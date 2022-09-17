/*
 * Model.java
 *
 * Created on 17/09/2012, 17:32:12
 */

package com.ic.projects.laudoecia.mdl;

import com.ic.projects.laudoecia.control.build.LaudoeCia;
import com.ic.projects.laudoecia.dao.auditable.DaoAtendimento;
import com.ic.projects.laudoecia.dao.laudo.DaoMdlDoProcedimento;
import com.ic.projects.laudoecia.dao.laudo.DaoModeloDeLaudo;
import com.ic.projects.laudoecia.model.auditable.Atendimento;
import com.ic.projects.laudoecia.model.auditable.ProcDoAtd;
import com.ic.projects.laudoecia.model.laudo.*;
import com.ic.projects.laudoecia.model.laudo.exceptions.ErrosDoCampoDoLaudo;
import com.lib.java.utils.SystemUtils;
import com.lib.swing.utils.SwingUtils;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
// <editor-fold defaultstate="collapsed" desc="Supress warnings">

@SuppressWarnings({"UseOfSystemOutOrSystemErr", "StaticNonFinalUsedInInitialization",
                   "PackageVisibleField", "ValueOfIncrementOrDecrementUsed",
                   "AssignmentToForLoopParameter"})

// </editor-fold>
class Model
{

    // <editor-fold defaultstate="collapsed" desc="Regex">

//    regex para validar (mais ou menos) os models e views dos laudos
//    espaços duplos: \.append\(".+  .+"\)
//    parentesis sem espaco: \.append\("[^"]+[^ ]{1}\([^"]+"\)
//    espaço antes da vírgula ou dois pontos: \.append\(".+ [\,\:].+"\)
//    vírgula ou dois pontos sem espaço após: \.append\(".+[\,\:][^( 0-9)]{1}.+"\)
//    append vazio: \.append\(""\)\
//    ponto e virgula sem dobrar no view: [^(;\()];[^;]

    // </editor-fold>

    static {
        LaudoeCia.configurarGenericDao();
        daoModeloDeLaudo = new DaoModeloDeLaudo();
        daoAtd = new DaoAtendimento();
    }

    // <editor-fold defaultstate="collapsed" desc="Debug utilities">

    final static Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    static LeitorDeCampoDoLaudo leitor = new LeitorDeCampoDoLaudo(false, scanner);
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static StringBuilder sb = new StringBuilder("");
    static DaoAtendimento daoAtd;
    static DaoModeloDeLaudo daoModeloDeLaudo;
    static DaoMdlDoProcedimento daoMdlDoProcedimento = new DaoMdlDoProcedimento();

    @SuppressWarnings("CallToThreadDumpStack")
    static void alterarModeloDeLaudo (int id) throws Exception
    {
        try
        {
            ModeloDeLaudo mdl = daoModeloDeLaudo.procurarPorId(id);
            mdl.setContexto(sb.toString());
            criarPlanilha();
            daoModeloDeLaudo.alterar(mdl);
            System.out.println("Alterado o modelo: " + id);
            sb.delete(0, sb.length());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    static Planilha criarPlanilha () throws Exception
    {
        return new CriadorDePlanilha(criarLaudo(sb.toString())).criarPlanilha();
    }

    static Laudo criarLaudo () throws ParseException
    {
        return criarLaudo("");
    }

    static Laudo criarLaudo (String contexto) throws ParseException
    {
        Laudo laudo = new Laudo();
        ProcDoAtd procDoAtd = new ProcDoAtd();
        procDoAtd.setLaudo(laudo);
        procDoAtd.setDataDaExecucao(sdf.parse("18/05/2012"));
        laudo.setProcDoAtd(procDoAtd);
        ModeloDeLaudo modeloDeLaudo= new ModeloDeLaudo();
        modeloDeLaudo.setContexto(contexto);
        laudo.setModeloDeLaudo(new ModeloDeLaudoDoProc(modeloDeLaudo));
        return laudo;
    }

    static void verLaudo (Planilha laudo) throws Exception
    {
        verLaudo(laudo, false);
    }

    static void verLaudo (Planilha laudo, boolean totalmenteNormal) throws Exception
    {
        if (totalmenteNormal)
        {
            laudo.totalmenteNormal();
        }
        final JTextPane editor = new JTextPane();
        editor.setContentType("text/html");
        editor.setText(laudo.gerarHtml(false));
        JFrame fr = getFrame();
        fr.add(new JScrollPane(editor), BorderLayout.CENTER);
        JButton jButton = new JButton("Print");
        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed (ActionEvent e)
            {
                try
                {
                    editor.print(null,
                                 null, false, null, null, true);
                }
                catch (PrinterException ex)
                {
                }
            }
        });
        fr.add(jButton, BorderLayout.SOUTH);
        fr.setVisible(true);
    }

    static void verLaudo (Laudo laudo) throws Exception
    {
        Atendimento atd = daoAtd.procurarPorId(1);
        atd.getProcedimentos().get(0).setLaudo(laudo);
        laudo.salvarAlteracoes();
        daoAtd.alterar(atd);

        atd = daoAtd.procurarPorId(1);
        verLaudo(atd.getProcedimentos().get(0).getLaudo().getPlanilha());
    }

    static JFrame getFrame ()
    {
        try
        {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException ex)
        {
        }
        JFrame fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
        return fr;
    }

    private static class LeitorDeCampoDoLaudo
    {
        boolean totalmenteNormal;
        Scanner scanner;
        String[] opcoes;
        boolean naoPerguntar = false;
        int contador = 0;
        Planilha planilha;

        void setPlanilha (Planilha planilha)
        {
            this.planilha = planilha;
        }

        LeitorDeCampoDoLaudo (boolean totalmenteNormal, Scanner scanner)
        {
            this.totalmenteNormal = totalmenteNormal;
            this.scanner = scanner;
        }

        LeitorDeCampoDoLaudo (Scanner scanner, String... opcoes)
        {
            this.scanner = scanner;
            this.opcoes = opcoes;
            this.naoPerguntar = true;
        }

        void lerCampoSemTextoNormal (CampoTexto campo, String texto) throws ErrosDoCampoDoLaudo
        {
            if (totalmenteNormal || !campo.isHabilitado())
            {
            }
            else if (naoPerguntar)
            {
                campo.setValor(opcoes[contador++]);
            }
            else
            {
                String resultado;
                do
                {
                    System.out.print(texto);
                    resultado = scanner.next();
                } while (resultado != null && resultado.equalsIgnoreCase("n"));
                campo.setValor(resultado);
            }
        }

        void lerCampoDoLaudo (CampoDoLaudo campo, String texto) throws ErrosDoCampoDoLaudo
        {
            if (totalmenteNormal || !campo.isHabilitado())
            {

            }
            else if (naoPerguntar)
            {
                campo.setValor(opcoes[contador++]);
            }
            else
            {
                System.out.print(texto);
                campo.setValor(scanner.next());
            }
        }

        void lerImpressaoDiagnostica (ImpressaoDiagnostica campo) throws ErrosDoCampoDoLaudo
        {
            if (totalmenteNormal || !campo.isHabilitado())
            {
            }
            else if (naoPerguntar)
            {
                campo.setValor(opcoes[contador++]);
            }
            else
            {
                System.out.print("Impressão diagnóstica: ");
                campo.setValor(scanner.next());
            }
        }

        void lerCampoDoLaudo (Enumeracao campo, String texto) throws ErrosDoCampoDoLaudo
        {
            if (totalmenteNormal || !campo.isHabilitado())
            {
            }
            else if (naoPerguntar)
            {
                campo.setValor(campo.getOpcoes()[Integer.valueOf(opcoes[contador++])]);
            }
            else
            {
                System.out.print(texto);
                campo.setValor(campo.getOpcoes()[scanner.nextInt()]);
            }
        }

        void lerCampoDoLaudo (int index, String texto) throws ErrosDoCampoDoLaudo
        {
            CampoDoLaudo cdl = planilha.getCampo(index);
            if (cdl instanceof Enumeracao)
            {
                lerCampoDoLaudo((Enumeracao)cdl, texto);
            }
            else
            {
                lerCampoDoLaudo(cdl, texto);
            }
        }

        void lerCampoDoLaudo (int index) throws ErrosDoCampoDoLaudo
        {
            CampoDoLaudo cdl = planilha.getCampo(index);
            lerCampoDoLaudo(cdl, "Impressão diagnóstica: ");
        }

    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Formatar string mdl">

    private static Map<Integer, Integer> mapa = new HashMap<>();
    private static StringBuilder novaString = new StringBuilder();

    /**
     * Ao criar a string, colocar um sb.append(\"\n##\n\"); antes dos metodos
     * @throws Exception
     */
    static void formatarStrMdl () throws Exception
    {
        String mdl = SystemUtils.getClipboardText();
        String[] linhas = mdl.split("\n");
        atualizarPlanilha(linhas);
        atualizarMetodos(linhas);
        atualizarVisao(linhas);
        SystemUtils.setClipboardContents(novaString.toString());
        SwingUtils.mostrarMsgDeSucesso(null, "Done!");
        System.exit(0);
    }

    private static void atualizarMetodos (String[] linhas) throws Exception
    {
        boolean blocoDeMetodos = false;
        for (int i = 0; i < linhas.length; i++)
        {
            String linha = linhas[i];
            if (blocoDeMetodos)
            {
                String[] dados = linha.split(";;");
                if (!(dados.length < 2 || dados[0].trim().startsWith("//")))
                {
                    linha = atualizarCdlDoMetodo(Integer.valueOf(index(dados[0])), linha);
                    linha = atualizarParametroCdl(linha);
                }
                novaString.append(linha).append("\n");
            }
            if (linha.contains("sb.append(\"\\n##\\n\");"))
            {
                if (blocoDeMetodos)
                {
                    break;
                }
                else
                {
                    blocoDeMetodos = true;
                }
            }
        }
    }

    private static String atualizarParametroCdl (String linha)
    {
        StringBuilder novaLinha = new StringBuilder();
        for (int i = 0; i < linha.length(); i++)
        {
            char charAtI = linha.charAt(i);
            if ('$' == charAtI && Character.isDigit(linha.charAt(i + 1)))
            {
                int charCount = 0;
                do
                {
                    charCount++;
                }
                while (Character.isDigit(linha.charAt(i + charCount + 1)));
                Integer indexCdl = Integer.valueOf(linha.substring(i + 1, i + 1 + charCount));
                if (mapa.containsKey(indexCdl))
                {
                    novaLinha.append('$').append(mapa.get(indexCdl));
                }
                else
                {
                    novaLinha.append('$').append(indexCdl);
                }
                i += charCount;
            }
            else
            {
                novaLinha.append(charAtI);
            }
        }
        return novaLinha.toString();
    }

    private static void atualizarVisao (String[] linhas) throws Exception
    {
        boolean blocoDeVisao = false;
        boolean linhaDoTopico = false;
        int contadorParaInicioDoBlocoDeVisao = 0;
        for (int i = 0; i < linhas.length; i++)
        {
            String linha = linhas[i];
            if (blocoDeVisao)
            {
                if (linha.contains("sb.append(") && !linha.trim().startsWith("//"))
                {
                    if (linhaDoTopico)
                    {
                        linha = tratarViewTopico (linha);
                        linhaDoTopico = false;
                    }
                    else
                    {
                        linha = tratarCdlView (linha);
                    }
                }
                novaString.append(linha).append("\n");
            }
            if (linha.contains("sb.append(\"\\n##\\n\");"))
            {
                contadorParaInicioDoBlocoDeVisao++;
                if (contadorParaInicioDoBlocoDeVisao == 2)
                {
                    blocoDeVisao = true;
                }
                linhaDoTopico = true;
            }
        }
    }

    private static String tratarViewTopico (String linha)
    {
        StringBuilder novaLinha = new StringBuilder();
        int intCount = 0;
        for (int i = 0; i < linha.length(); i++)
        {
            if (Character.isDigit(linha.charAt(i)) &&
                (';' == linha.charAt(i - 1) || intCount == 0))
            {
                switch (intCount)
                {
                    case 0:
                    case 2:
                        int charCount = 0;
                        do
                        {
                            charCount++;
                        }
                        while (Character.isDigit(linha.charAt(i + charCount)));
                        Integer indexCdl = Integer.valueOf(linha.substring(i, i + charCount));
                        if (mapa.containsKey(indexCdl))
                        {
                            novaLinha.append(mapa.get(indexCdl));
                        }
                        else
                        {
                            novaLinha.append(indexCdl);
                        }
                        i += charCount - 1;
                        break;
                    default:
                        while (Character.isDigit(linha.charAt(i)))
                        {
                            novaLinha.append(linha.charAt(i));
                            i++;
                        }
                        novaLinha.append(linha.charAt(i));
                }
                intCount++;
            }
            else
            {
                novaLinha.append(linha.charAt(i));
            }
        }
        return novaLinha.toString();
    }

    private static String tratarCdlView (String linha)
    {
        StringBuilder novaLinha = new StringBuilder();
        for (int i = 0; i < linha.length(); i++)
        {
            if (novaLinha.toString().endsWith("cdl@") ||
                novaLinha.toString().endsWith("cdl||"))
            {
                int charCount = 0;
                do
                {
                    charCount++;
                }
                while (Character.isDigit(linha.charAt(i + charCount)));
                Integer indexCdl = Integer.valueOf(linha.substring(i, i + charCount));
                if (mapa.containsKey(indexCdl))
                {
                    novaLinha.append(mapa.get(indexCdl));
                }
                else
                {
                    novaLinha.append(indexCdl);
                }
                i += charCount - 1;
            }
            else
            {
                novaLinha.append(linha.charAt(i));
            }
        }
        return novaLinha.toString();
    }

    private static String atualizarCdlDoMetodo (Integer index, String linha) throws Exception
    {
        if (mapa.containsKey(Integer.valueOf(index)))
        {
            if (linha.contains("sb.append(\"\\n" + index + ";;"))
            {
                return linha.replace("sb.append(\"\\n" + index + ";;",
                                      "sb.append(\"\\n" + mapa.get(index) + ";;");
            }
            else if (linha.contains("sb.append(\"" + index + ";;"))
            {
                return linha.replace("sb.append(\"" + index + ";;",
                                      "sb.append(\"" + mapa.get(index) + ";;");
            }
        }
        return linha;
    }

    private static void atualizarPlanilha (String[] linhas) throws Exception
    {
        int contadorDeCampos = 0;
        for (int i = 0; i < linhas.length; i++)
        {
            String linha = linhas[i];
            String[] dados = linha.split(";;");
            if (dados.length > 1 && ehCdl(dados[1]) && !dados[0].trim().startsWith("//"))
            {
                String index = index(dados[0]);
                if (!Integer.valueOf(index).equals(contadorDeCampos))
                {
                    mapa.put(Integer.valueOf(index), contadorDeCampos);
                    if (linha.contains("sb.append(\"\\n" + index + ";;"))
                    {
                        linha = linha.replace("sb.append(\"\\n" + index + ";;",
                                              "sb.append(\"\\n" + contadorDeCampos + ";;");
                    }
                    else if (linha.contains("sb.append(\"" + index + ";;"))
                    {
                        linha = linha.replace("sb.append(\"" + index + ";;",
                                              "sb.append(\"" + contadorDeCampos + ";;");
                    }
                    else
                    {
                        throw new Exception("Linha inesperada!");
                    }
                }
                linha = atualizarParametroCdl(linha);
                contadorDeCampos++;
            }
            novaString.append(linha).append("\n");
            if (linha.contains("sb.append(\"\\n##\\n\");"))
            {
                break;
            }
        }
    }

    private static boolean ehCdl (String desc)
    {
        try
        {
            String cdl = desc;
            for (int i = 0; i < desc.length(); i++)
            {
                if (String.valueOf(desc.charAt(i)).matches("[aA-zZ]{1}"))
                {
                }
                else
                {
                    cdl = desc.substring(0, i);
                    break;
                }
            }
            CriadorDePlanilha.tipoPeloNome(cdl);
            return true;
        }
        catch (ClassNotFoundException ex)
        {
            return false;
        }
    }

    private static String index (String linhaDoMdl) throws Exception
    {
        for (int i = 0; i < linhaDoMdl.length(); i++)
        {
            if (Character.isDigit(linhaDoMdl.charAt(i)))
            {
                return linhaDoMdl.substring(i);
            }
        }
        throw new Exception("Linha do modelo inesperada: " + linhaDoMdl);
    }

    // </editor-fold>

}
