/*
 * ImgFolderManager.java
 *
 * Created on 27/04/2012, 10:37:11
 */

package com.ic.projects.laudoecia.control.backup;

import com.ic.projects.laudoecia.dao.cadastro.DaoImagem;
import com.ic.projects.laudoecia.model.cadastro.Imagem;
import com.ic.projects.laudoecia.model.cadastro.ImagemRestore;
import com.lib.model.cnv.ConversorByteArrayImage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class ImgFolderManager
{
    private Path pastaDeImagens;

    public ImgFolderManager (Path backupDir)
    {
        if (backupDir == null)
        {
            throw new IllegalArgumentException("Backup dir invalido");
        }
        this.pastaDeImagens = Paths.get(backupDir.toString(), "imagens");
    }

    Path pastaDeImagens ()
    {
        return pastaDeImagens;
    }

    void restaurarImagens (final DaoImagem daoImagem) throws Exception
    {
        final ConversorByteArrayImage c = new ConversorByteArrayImage();
        final List<ImagemRestore> imagens = new ArrayList<>();
        Files.walkFileTree(pastaDeImagens, new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory (Path dir, BasicFileAttributes attrs) throws IOException
            {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile (Path file, BasicFileAttributes attrs) throws IOException
            {
                String fileName = file.getFileName().toString();
                if (fileName.matches("[0-9]+-[0-9]+\\.png"))
                {
                    ImagemRestore imagem = new ImagemRestore();
                    imagem.setCodigo(getCodigoImagem(fileName));
                    imagem.setIndice(getIndiceImagem(fileName));
                    imagem.setImagem(c.convertReverse(file.toFile()));
                    imagens.add(imagem);
                    if (imagens.size() > 100)
                    {
                        try
                        {
                            daoImagem.persistir100Imagens(imagens);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                            throw new IOException();
                        }
                        imagens.clear();
                    }
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
                return FileVisitResult.CONTINUE;
            }
        });
        if (imagens.size() > 0)
        {
            daoImagem.persistir100Imagens(imagens);
        }
    }

    public boolean exportarImagem (Imagem imagem) throws IOException
    {
        int codigo = imagem.getCodigo();
        Path subpasta = Paths.get(pastaDeImagens.toString(), getSubPasta(codigo));
        Files.createDirectories(subpasta);
        Path imagePath = Paths.get(subpasta.toString(), codigo + "-" + imagem.getIndice() + ".png");
        if (Files.exists(imagePath))
        {
            return false;
        }
        try (FileOutputStream fos = new FileOutputStream(imagePath.toFile()))
        {
            fos.write(imagem.getImagem());
        }
        return true;
    }

    private String getSubPasta (int codigo)
    {
        String codigoString = String.valueOf(codigo);
        if (codigoString.length() < 3)
        {
            return "1-100";
        }
        else if (codigoString.endsWith("00"))
        {
            return String.valueOf(codigo - 99) + "-" + codigoString;
        }
        else
        {
            codigoString = codigoString.substring(0, codigoString.length() - 2);
            int codigoInicial = Integer.valueOf(codigoString + "00") + 1;
            return String.valueOf(codigoInicial) + "-" + String.valueOf(codigoInicial + 99);
        }
    }

    private int getCodigoImagem (String fileName)
    {
        return Integer.valueOf(fileName.substring(0, fileName.lastIndexOf("-")));
    }

    private int getIndiceImagem (String fileName)
    {
        return Integer.valueOf(fileName.substring(fileName.lastIndexOf("-") + 1, fileName.lastIndexOf('.')));
    }
}
