package com.ic.projects.laudoecia.control.laudoecia;

import com.ic.projects.laudoecia.dao.auditable.DaoProcDoAtd;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.cadastro.Imagem;
import com.lib.model.cnv.ConversorByteArrayImage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author Lima Filho, A. L. - amsterdam@luvva.com.br
 */
public class ImgBackupManager
{
    private static final Path backupFolder;
    private static final ConversorByteArrayImage cnv = new ConversorByteArrayImage();

    static
    {
        backupFolder = Paths.get(System.getenv("APPDATA"), "laudoecia", "backupImagens");
    }

    static void backupImage (int procDoAtd, Imagem imagem)
    {
        Path path = Paths.get(backupFolder.toString(), String.valueOf(procDoAtd));
        path.toFile().mkdirs();
        int length = path.toFile().listFiles().length;
        File imgFile = new File(path.toString() + "\\" + length + "-" + imagem.getIndice() + ".png");
        try
        {
            try (FileOutputStream fos = new FileOutputStream(imgFile))
            {
                fos.write(imagem.getImagem());
            }
        }
        catch (IOException e)
        {
        }
    }

    static void clear (int procDoAtd)
    {
        Path path = Paths.get(backupFolder.toString(), String.valueOf(procDoAtd));
        try
        {
            Files.walkFileTree(path, new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory (Path dir, BasicFileAttributes attrs) throws IOException
                {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile (Path file, BasicFileAttributes attrs) throws IOException
                {
                    file.toFile().delete();
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed (Path file, IOException exc) throws IOException
                {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory (Path dir, IOException exc) throws IOException
                {
                    dir.toFile().delete();
                    return FileVisitResult.CONTINUE;
                }
            });
            path.toFile().delete();
        }
        catch (IOException e)
        {
        }
    }

    public static void restore ()
    {
        final DaoProcDoAtd daoProcDoAtd = new DaoProcDoAtd();
        try
        {
            Files.walkFileTree(backupFolder, new FileVisitor<Path>() {

                private ProcDoAtd procDoAtd;

                @Override
                public FileVisitResult preVisitDirectory (Path dir, BasicFileAttributes attrs) throws IOException
                {
                    String dirName = dir.getFileName().toString();
                    if (dirName.matches("[0-9]+"))
                    {
                        procDoAtd = daoProcDoAtd.procurarPorId(Integer.valueOf(dirName));
                        procDoAtd.getImagens().size();
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile (Path file, BasicFileAttributes attrs) throws IOException
                {
                    String imgFileName = file.getFileName().toString();
                    if (imgFileName.matches("[0-9]+-[0-9]+\\.png"))
                    {
                        Imagem imagem = new Imagem();
                        imagem.setIndice(Integer.valueOf(imgFileName.substring(imgFileName.indexOf("-") + 1
                                , imgFileName.indexOf("."))));
                        imagem.setImagem(cnv.convertReverse(file.toFile()));
                        procDoAtd.addImagem(imagem);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed (Path file, IOException exc) throws IOException
                {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory (Path dir, IOException exc) throws IOException
                {
                    String dirName = dir.getFileName().toString();
                    if (dirName.matches("[0-9]+"))
                    {
                        try
                        {
                            daoProcDoAtd.alterar(procDoAtd);
                            final Path backup = backupFolder.getParent().resolve("imagensRestauradas").resolve(
                                    dir.getFileName().toString());
                            Files.createDirectories(backup);
                            Files.walkFileTree(dir, new FileVisitor<Path>() {
                                @Override
                                public FileVisitResult preVisitDirectory (Path dir, BasicFileAttributes attrs) throws
                                        IOException
                                {
                                    return FileVisitResult.CONTINUE;
                                }

                                @Override
                                public FileVisitResult visitFile (Path file, BasicFileAttributes attrs) throws
                                        IOException
                                {
                                    Files.copy(file, backup.resolve(file.getFileName().toString()));
                                    file.toFile().delete();
                                    return FileVisitResult.CONTINUE;
                                }

                                @Override
                                public FileVisitResult visitFileFailed (Path file, IOException exc) throws IOException
                                {
                                    return FileVisitResult.CONTINUE;
                                }

                                @Override
                                public FileVisitResult postVisitDirectory (Path dir, IOException exc) throws IOException
                                {
                                    dir.toFile().delete();
                                    return FileVisitResult.CONTINUE;
                                }
                            });
                            dir.toFile().delete();
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
