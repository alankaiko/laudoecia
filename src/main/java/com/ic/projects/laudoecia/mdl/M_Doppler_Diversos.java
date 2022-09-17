/*
 * M_Doppler_Diversos.java
 *
 * Created on 07/05/2012, 16:45:34
 */
package com.ic.projects.laudoecia.mdl;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.laudo.*;

import static com.ic.projects.laudoecia.model.laudo.CampoSimples.identificador;
import static com.ic.projects.laudoecia.model.laudo.Composite.HTML_CAMPOS_FILHOS;
import static com.ic.projects.laudoecia.model.laudo.Topico.ID_DESCRICAO_TOPICO;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class M_Doppler_Diversos extends Model
{

    public static void main (String[] args) throws Exception
    {
        ecodopplerCardiograma();
        diversos();
        dopplerFluxoMetria();
        textoLivre();
        histeroscopia();
        endovaginalPelvica_AbdomenInferiorFeminino();
//        formatarStrMdl();
    }

    static void ecodopplerCardiograma () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Dados do paciente">

        sb.append("\n0;;Topico;;Dados do paciente$$\n");

        // altura
        sb.append("\n1;;Linha$$\n");
        sb.append("2;;CampoInteiro;;Altura: " + identificador + " cm;;3$$\n");

        // peso
        sb.append("3;;CampoDouble;;, peso: " + identificador + " kg;;2$$\n");

        // frequência cardiaca
        sb.append("\n4;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL + ";;3$$\n");

        // superficie corporal
        sb.append("5;;CampoRpn;;.007184 C1 .725 ^ * C2 .425 ^ *;;");
        sb.append(" e superfície corporal: " + identificador + " m².;;");
        sb.append("3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Parâmetros estruturais">

        // parametros estruturais
        sb.append("\n6;;Topico;;Parâmetros estruturais;;\n");
        sb.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t").append(ID_DESCRICAO_TOPICO).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td align=\"center\" colspan=\"1\">\n");
        sb.append("\t\t\t<b>Referências</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(HTML_CAMPOS_FILHOS).append("\n");
        sb.append("</table>$$\n");

        // aorta (diametro da raiz)
        sb.append("\n7;;Linha$$\n");
        sb.append("8;;CampoInteiro;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"80%\">\n");
        sb.append("\t\t\tAorta (diâmetro da raiz): " + identificador + " mm.\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"20%\" align=\"center\" >\n");
        sb.append("\t\t\t20 a 37 mm\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;3$$\n");

        // atrio esquerdo
        sb.append("\n9;;Linha$$\n");
        sb.append("10;;CampoInteiro;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"80%\">\n");
        sb.append("\t\t\tÁtrio esquerdo: " + identificador + " mm.\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"20%\" align=\"center\">\n");
        sb.append("\t\t\t20 a 40 mm\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;3$$\n");

        // diametro ventricular direito
        sb.append("\n11;;Linha$$\n");
        sb.append("12;;CampoInteiro;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"80%\">\n");
        sb.append("\t\t\tDiâmetro ventricular direito: " + identificador + " mm.\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"20%\" align=\"center\">\n");
        sb.append("\t\t\t07 a 26 mm\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;3$$\n");

        // Diâmetro diastólico final do VE
        sb.append("\n13;;Linha$$\n");
        sb.append("14;;CampoInteiro;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"80%\">\n");
        sb.append("\t\t\tDiâmetro diastólico final do VE: " + identificador + " mm.\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"20%\" align=\"center\">\n");
        sb.append("\t\t\t35 a 58 mm\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;3$$\n");

        // Diâmetro sistólico final do VE
        sb.append("\n15;;Linha$$\n");
        sb.append("16;;CampoInteiro;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"80%\">\n");
        sb.append("\t\t\tDiâmetro sistólico final do VE: " + identificador + " mm.\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"20%\" align=\"center\">\n");
        sb.append("\t\t\t25 a 40 mm\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;3$$\n");
        // Espessura diastólica do septo
        sb.append("\n17;;Linha$$\n");
        sb.append("18;;CampoInteiro;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"80%\">\n");
        sb.append("\t\t\tEspessura diastólica do septo: " + identificador + " mm.\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"20%\" align=\"center\">\n");
        sb.append("\t\t\t07 a 11 mm\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;3$$\n");

        // Espessura diastólica da PPVE
        sb.append("\n19;;Linha$$\n");
        sb.append("20;;CampoInteiro;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"80%\">\n");
        sb.append("\t\t\tEspessura diastólica da PPVE: " + identificador + " mm.\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"20%\" align=\"center\">\n");
        sb.append("\t\t\t07 a 11 mm\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;3$$\n");

        // Volume
        sb.append("\n21;;Linha$$\n");
        sb.append("22;;CampoDouble;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"80%\">\n");
        sb.append("\t\t\tVolume: " + identificador + " cm³.\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"20%\" align=\"center\">\n");
        sb.append("\t\t\t-\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;2$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Relações">

        sb.append("\n23;;Topico;;Relações e funções ventriculares;;\n");
        sb.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t").append(ID_DESCRICAO_TOPICO).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td align=\"center\" colspan=\"1\">\n");
        sb.append("\t\t\t<b>Referências</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(HTML_CAMPOS_FILHOS).append("\n");
        sb.append("</table>$$\n");

        // volume diastolico final
        sb.append("\n24;;Linha$$\n");
        sb.append("25;;CampoRpn;;C1 10 / 3 ^ 7 * 2.4 C1 10 / + /;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"80%\">\n");
        sb.append("\t\t\tVolume diastólico final: ").append(identificador).append(" mL.\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"20%\" align=\"center\">\n");
        sb.append("\t\t\t73 a 158 mL\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;0$$\n");

        // volume sistolico final
        sb.append("\n26;;Linha$$\n");
        sb.append("27;;CampoRpn;;C1 10 / 3 ^ 7 * 2.4 C1 10 / + /;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"80%\">\n");
        sb.append("\t\t\tVolume sistólico final: ").append(identificador).append(" mL.\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"20%\" align=\"center\">\n");
        sb.append("\t\t\t18 a 57 mL\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;0$$\n");

        // relacao atrio esquerdo aorta
        sb.append("\n28;;Linha$$\n");
        sb.append("29;;CampoRpn;;C1 C2 /;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"80%\">\n");
        sb.append("\t\t\tRelação átrio esquerdo / Aorta: ").append(identificador).append(".\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"20%\" align=\"center\">\n");
        sb.append("\t\t\t1,00 ± 0,50\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;2$$\n");

        // fracao de Teicholz
        sb.append("\n30;;Linha$$\n");
        sb.append("31;;CampoRpn;;C1 C2 - C1 / 100 *;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"80%\">\n");
        sb.append("\t\t\tFração de ejeção (Teicholz): ").append(identificador).append(" %.\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"20%\" align=\"center\">\n");
        sb.append("\t\t\t> 58%\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;0$$\n");

        // formula de massa
        sb.append("\n32;;Linha$$\n");
        sb.append("33;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");

        // Massa ventricular esquerda
        sb.append("\n34;;Linha$$\n");
        sb.append("35;;CampoRpn;;$33;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"80%\">\n");
        sb.append("\t\t\tMassa ventricular esquerda: ").append(identificador).append(" g.\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"20%\" align=\"center\">\n");
        sb.append("\t\t\t94 a 276g\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;0$$\n");

        // Índice de massa
        sb.append("\n36;;Linha$$\n");
        sb.append("37;;CampoRpn;;C1 C2 /;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"80%\">\n");
        sb.append("\t\t\tÍndice de massa: ").append(identificador).append(" g/m².\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"20%\" align=\"center\">\n");
        sb.append("\t\t\t-\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;2$$\n");

        // Percentual de encurtamento da cavidade
        sb.append("\n38;;Linha$$\n");
        sb.append("39;;CampoRpn;;C1 C2 - C1 / 100 *;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"80%\">\n");
        sb.append("\t\t\tPercentual de encurtamento da cavidade: ").append(identificador).append(" %.\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"20%\" align=\"center\">\n");
        sb.append("\t\t\t> 20%\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;0$$\n");

        // Relação septo / PPVE
        sb.append("\n40;;Linha$$\n");
        sb.append("41;;CampoRpn;;C1 C2 /;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"80%\">\n");
        sb.append("\t\t\tRelação septo / PPVE: ").append(identificador).append(".\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"20%\" align=\"center\">\n");
        sb.append("\t\t\t&lt; 1,30\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;2$$\n");

        // Volume sistólico
        sb.append("\n42;;Linha$$\n");
        sb.append("43;;CampoRpn;;C1 C2 -;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"80%\">\n");
        sb.append("\t\t\tVolume sistólico: ").append(identificador).append(" mL.\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"20%\" align=\"center\">\n");
        sb.append("\t\t\t54 a 99 mL\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;0$$\n");

        // Relação volume massa
        sb.append("\n44;;Linha$$\n");
        sb.append("45;;CampoRpn;;C1 C2 /;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"80%\">\n");
        sb.append("\t\t\tRelação volume massa: ").append(identificador).append(" mL/g.\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"20%\" align=\"center\">\n");
        sb.append("\t\t\t> 0,42 mL/g\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;2$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Comentários ecocardiográficos">

        sb.append("\n46;;Topico;;Comentários ecocardiográficos$$\n");

        sb.append("\n47;;Linha$$\n");
        sb.append("48;;CampoTexto;;\n");
        sb.append("Exame de satisfatória qualidade técnica.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Ritmo cardíaco regular.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Função sistólica do VE corrigida pela fórmula de Teicholz encontra-se normal.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Contratilidade segmentar preservada em repouso.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Septo interventricular: normal.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Parede posterior do VE: normal.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Ventrículo direito: normal.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Ventrículo esquerdo: normal.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Átrio direito: normal.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Aorta: normal.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Valva mitral: normal.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Valva tricúspide: normal.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Valva aórtica: normal.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Valva pulmonar: normal.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Pericárdio: normal.</p>$$\n");
        sb.append("\n49;;Linha$$\n");
        sb.append("50;;Enumeracao;;$48CampoTexto$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressão diagnóstica">

        sb.append("\n51;;Topico;;Impressão diagnóstica$$\n");

        sb.append("\n52;;Linha$$\n");
        sb.append("53;;ImpressaoDiagnostica;;<p style=\"margin-top: 0\">"
                + "Ecocardiograma dentro dos padrões de normalidade.</p>$$\n");
        sb.append("\n54;;Linha$$\n");
        sb.append("55;;Enumeracao;;$53CampoTexto$$\n");

        //btn avança para o próximo tópico
        sb.append("56;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL + ";;3$$\n");
        // </editor-fold>

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Metodos">

        sb.append("\n56;;setObrigatorio;;false$$\n");

        sb.append("\n5;;cadastrarParametroFormula;;$2CampoNumero$$\n");
        sb.append("5;;cadastrarParametroFormula;;$3CampoNumero$$\n");

        sb.append("\n25;;cadastrarParametroFormula;;$14CampoNumero$$\n");

        sb.append("\n27;;cadastrarParametroFormula;;$16CampoNumero$$\n");

        sb.append("\n29;;cadastrarParametroFormula;;$10CampoNumero$$\n");
        sb.append("29;;cadastrarParametroFormula;;$8CampoNumero$$\n");

        sb.append("\n31;;cadastrarParametroFormula;;$25CampoNumero$$\n");
        sb.append("31;;cadastrarParametroFormula;;$27CampoNumero$$\n");

        sb.append("\n33;;adicionarOpcao;;Fórmula TROY;;1.05 C1 C2 C3 + + 3 ^ C1 3 ^ - * 1000 /$$\n");
        sb.append("33;;adicionarOpcao;;Fórmula PENN;;1.04 C1 C2 C3 + + 3 ^ C1 3 ^ - * 13.6 - 1000 /$$\n");
        sb.append("33;;adicionarOpcao;;Fórmula ASE;;.8 1.04 C1 C2 C3 + + 3 ^ C1 3 ^ - * * .6 + 1000 /$$\n");

        sb.append("\n35;;cadastrarParametroFormula;;$14CampoNumero$$\n");
        sb.append("35;;cadastrarParametroFormula;;$20CampoNumero$$\n");
        sb.append("35;;cadastrarParametroFormula;;$18CampoNumero$$\n");

        sb.append("\n37;;cadastrarParametroFormula;;$35CampoNumero$$\n");
        sb.append("37;;cadastrarParametroFormula;;$5CampoNumero$$\n");

        sb.append("\n39;;cadastrarParametroFormula;;$14CampoNumero$$\n");
        sb.append("39;;cadastrarParametroFormula;;$16CampoNumero$$\n");

        sb.append("\n41;;cadastrarParametroFormula;;$18CampoNumero$$\n");
        sb.append("41;;cadastrarParametroFormula;;$20CampoNumero$$\n");

        sb.append("\n43;;cadastrarParametroFormula;;$25CampoNumero$$\n");
        sb.append("43;;cadastrarParametroFormula;;$27CampoNumero$$\n");

        sb.append("\n45;;cadastrarParametroFormula;;$25CampoNumero$$\n");
        sb.append("45;;cadastrarParametroFormula;;$35CampoNumero$$\n");

        // </editor-fold>

        alterarModeloDeLaudo(11);

    }

    static void diversos () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Descrição">

        sb.append("\n0;;Topico;;Descrição$$\n");
        sb.append("1;;Linha$$\n");
        sb.append("2;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("\n3;;Topico;;Observações gerais$$\n");
        sb.append("4;;Linha$$\n");
        sb.append("5;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("\n6;;Topico;;Impressão diagnóstica$$\n");
        sb.append("7;;Linha$$\n");
        sb.append("8;;ImpressaoDiagnostica;;$$\n");

        // </editor-fold>

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Métodos">

        sb.append("5;;setObrigatorio;;false$$\n");
        sb.append("8;;setObrigatorio;;false$$\n");

        // </editor-fold>

        alterarModeloDeLaudo(5);

    }

    static void dopplerFluxoMetria() throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento">

        sb.append("\n0;;Topico;;Equipamento$$\n");
        sb.append("\n1;;Linha$$\n");
        sb.append("2;;Enumeracao;;").append("Paciente submetido a estudo das"
                                            + " ondas de velocidade de fluxo (Doppler), com equipamento ").
                      append(identificador).append(" multifrequencial.;;true$$\n");

        sb.append("3;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados da gestação">

        sb.append("\n4;;Topico;;Dados da gestação$$\n");

        sb.append("\n5;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("6;;Label;;Gestação gemelar$$\n");
        sb.append("7;;Label;;Gestação múltipla com $$\n");
        sb.append("8;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL + ";;1$$\n");
        sb.append("9;;CampoRpn;;C1;;" + identificador + ";;0$$\n");
        sb.append("10;;Label;; embriões / fetos$$\n");
        sb.append("11;;Enumeracao;;, " + identificador + ";;true$$\n");
        sb.append("12;;Enumeracao;;, " + identificador + ";;true$$\n");

        //label data do exame
        sb.append("13;;Label;;").append(Label.DATA_DO_EXAME).append(";;false").append("$$\n");
        //dum
        sb.append("14;;Linha$$\n");
        sb.append("15;;CampoDate;;Data da última menstruação: ").append(CampoSimples.identificador).append(".$$\n");
        //dppPelaDum
        sb.append("16;;CampoRpnData;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;C1 280 "
                + "").append(CampoRpnData.UM_DIA_EM_MS).append(" * +$$\n");
        //semanas dum
        sb.append("17;;CampoRpnData;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;C1 C2 - "
                 + "").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 /$$\n");
         //diasIghUltEx
        sb.append("18;;CampoRpnData;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;C1 C2 - "
                + "").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 %$$\n");
        //dataUltEx
        sb.append("19;;CampoDate;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        //semUltEx
        sb.append("20;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;2$$\n");
        //diasUltEx
        sb.append("21;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;1$$\n");

        //dumPeloUltEx
         sb.append("22;;CampoRpnData;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;C1 C2 "
                + "").append(CampoRpnData.UM_DIA_EM_MS).append(" 7 * * - C3 "
                + "").append(CampoRpnData.UM_DIA_EM_MS).append(" * -$$\n");

        //dppPeloUltEx
        sb.append("23;;CampoRpnData;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;C1 280 "
                + "").append(CampoRpnData.UM_DIA_EM_MS).append(" * +$$\n");

        //semanasIghUltEx
        sb.append("24;;CampoRpnData;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;C1 C2 - "
                + "").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 /$$\n");

         //diasIghUltEx
        sb.append("25;;CampoRpnData;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;C1 C2 - "
                + "").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 %$$\n");
          //idade gestacional definida pelo usuário
        sb.append("26;;Linha$$\n");
        sb.append("27;;CampoInteiro;;").append("Idade gestacional: ").append(CampoSimples.identificador).append(" semana(s);;2$$\n");
        sb.append("28;;CampoInteiro;;").append(" e ").append(CampoSimples.identificador).append(" dia(s).;;1$$\n");
         //dppPeloValorInformado
         sb.append("29;;CampoRpnData;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;C1 280 "
                + "").append(CampoRpnData.UM_DIA_EM_MS).append(" * + C2 7 ")
        .append(CampoRpnData.UM_DIA_EM_MS).append(" * * - C3 ").append(CampoRpnData.UM_DIA_EM_MS).append(" * -$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados quando a gestação é unica">

        // <editor-fold defaultstate="collapsed" desc="Artéria Uterina">
        sb.append("\n30;;Topico;;Artéria uterina;;\n");
        sb.append("<table width=\"100%\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t").append(ID_DESCRICAO_TOPICO).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Direita").append("</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t<b>Esquerda</b></td>\n");
        sb.append("\t</tr>\n");
        sb.append(HTML_CAMPOS_FILHOS).append("\n");
        sb.append("</table>$$\n");

        // Relação S/D direita e esquerda	:
        sb.append("\n31;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("32;;CampoDouble;;\n");
        sb.append("\t\t\tRelação S/D direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("33;;CampoDouble;;\n");
        sb.append("\t\t\tRelação S/D esquerda: " + identificador + ".\n");
        sb.append(";;2$$\n");

         // IR direita e esquerda	:
        sb.append("\n34;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("35;;CampoDouble;;\n");
        sb.append("\t\t\tIR direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("36;;CampoDouble;;\n");
        sb.append("\t\t\tIR esquerda: " + identificador + ".\n");
        sb.append(";;2$$\n");

        // IP direita e esquerda	:
         sb.append("\n37;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("38;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("39;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Incisura direita e esquerda	:
        sb.append("\n40;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("41;;Enumeracao;;\n");
        sb.append("Incisura direita: " + identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("42;;Enumeracao;;\n");
        sb.append("Incisura esquerda: " + identificador + ".</td>\n");
        sb.append(";;true$$\n");
        // Relação A/C direita e esquerda	:
        sb.append("\n43;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("44;;CampoDouble;;\n");
        sb.append("Relação A/C direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("45;;CampoDouble;;\n");
        sb.append("Relação A/C esquerda: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Apenas Texto Média das relações das artérias uterinas	:
        sb.append("\n46;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n\t\t<td colspan=\"2\" width=\"50%\" "
                  + " >\n\t\t\t<b>Média das relações das artérias"
                  + " uterinas</b>\n\t\t</td>\n\t</tr>;;false$$\n");

          //Média das relações S/D	:
        sb.append("\n47;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("$$\n");
        sb.append("48;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média das relações S/D: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Média dos valores de IR:
         sb.append("\n49;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("50;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média dos valores de IR: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Média dos valores de IP:	:
         sb.append("\n51;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("52;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média dos valores de IP: " + identificador + " (Normal: IP Médio <= 2,31).\n");
        sb.append(";;2$$\n");
        // Média das relações A/C:
        sb.append("\n53;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("54;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média das relações A/C: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Incisura bilateral:
        sb.append("\n55;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("56;;CampoLogicoTexto;;Incisura bilateral: " + identificador + ".\n;;{$41CampoDoLaudo|$42CampoDoLaudo}\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Artéria Umbilical e cerebral">
        sb.append("\n57;;Topico;; ;;\n");
        sb.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Artérias umbilical e cerebral").append("</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Umbilical").append("<b/>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t<b>Cerebral</b></td>\n");
        sb.append("\t</tr>\n");
        sb.append(HTML_CAMPOS_FILHOS).append("\n");
        sb.append("</table>$$\n");

        // Relação S/D umbilical e cerebral:
         sb.append("\n58;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("59;;CampoDouble;;\n");
        sb.append("Relação S/D: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("60;;CampoDouble;;\n");
        sb.append("Relação S/D: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // IR umbilical e cerebral:
         sb.append("\n61;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("62;;CampoDouble;;\n");
        sb.append("IR: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("63;;CampoDouble;;\n");
        sb.append("IR: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // IP umbilical e cerebral:
         sb.append("\n64;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("65;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("66;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Pico sistólico (ACM)	:
         sb.append("\n67;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("68;;CampoDouble;;\n");
        sb.append("Pico sistólico (ACM): " + identificador + " cm/s.\n");
        sb.append(";;2$$\n");

        // diástole umbilica e cerebral:
        sb.append("\n69;;Linha$$\n");
        sb.append("70;;Enumeracao;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\" >\n");
        sb.append("\t\t\tDiástole: " + identificador + ".\n");
        sb.append("\t\t</td>\n");
        sb.append(";;true$$\n");
        sb.append("71;;Enumeracao;;\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\tDiástole: " + identificador + ".</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;true$$\n");

        // Apenas Texto Média das relações das artérias umbilical e cerebral:
        sb.append("\n72;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n\t\t<td colspan=\"2\" width=\"50%\" "
                  + " >\n\t\t\t<b>Média das relações das artérias umbilical e cerebral"
                  + " uterinas</b>\n\t\t</td>\n\t</tr>;;false$$\n");

        // Média das relações S/D	:
        sb.append("\n73;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("74;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média das relações S/D: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");
        // Média dos valores de IR:
         sb.append("\n75;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("76;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média dos valores de IR: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");
        // Média dos valores de IP:	:
         sb.append("\n77;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("78;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média dos valores de IP: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ducto venoso">
        sb.append("\n79;;Topico;;Ducto venoso$$\n");
        // ducto venoso diastole
        sb.append("\n80;;Linha$$\n");
        sb.append("81;;Enumeracao;;\n");
        sb.append("Diástole: " + identificador + ".\n");
        sb.append(";;true$$\n");
        // ducto venoso ip
        sb.append("\n82;;Linha$$\n");
        sb.append("83;;CampoDouble;;\n");
        sb.append("IP: " + identificador + " (Normal: IP < 2.3 (Fluxo anterogrado em fase de contração atrial)).\n");
        sb.append(";;2$$\n");
        // </editor-fold>

        //veia umbilical
        sb.append("\n84;;Topico;;Veia umbilical$$\n");
        // ducto venoso veia umbilical
        sb.append("\n85;;Linha$$\n");
        sb.append("86;;Enumeracao;;\n");
        sb.append(identificador + " (normal: fluxo contínuo).\n");
        sb.append(";;true$$\n");

        // <editor-fold defaultstate="collapsed" desc="Observações gestação unica">

         //campo descrito  Observações gerais
        sb.append("\n87;;Topico;;Observações gerais$$\n");
        sb.append("\n88;;Linha$$\n");
        sb.append("89;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados feto 1">

        // <editor-fold defaultstate="collapsed" desc="Artéria Uterina">
        sb.append("\n90;;Topico;;Descrição para o feto 1;;\n");
        sb.append("<table width=\"100%\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t").append(ID_DESCRICAO_TOPICO).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Artéria uterina").append("</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Direita").append("</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t<b>Esquerda</b></td>\n");
        sb.append("\t</tr>\n");
        sb.append(HTML_CAMPOS_FILHOS).append("\n");
        sb.append("</table>$$\n");

        // Relação S/D direita e esquerda	:
        sb.append("\n91;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("92;;CampoDouble;;\n");
        sb.append("\t\t\tRelação S/D direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("93;;CampoDouble;;\n");
        sb.append("\t\t\tRelação S/D esquerda: " + identificador + ".\n");
        sb.append(";;2$$\n");

         // IR direita e esquerda	:
        sb.append("\n94;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("95;;CampoDouble;;\n");
        sb.append("\t\t\tIR direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("96;;CampoDouble;;\n");
        sb.append("\t\t\tIR esquerda: " + identificador + ".\n");
        sb.append(";;2$$\n");

        // IP direita e esquerda	:
         sb.append("\n97;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("98;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("99;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Incisura direita e esquerda	:
        sb.append("\n100;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("101;;Enumeracao;;\n");
        sb.append("Incisura direita: " + identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("102;;Enumeracao;;\n");
        sb.append("Incisura esquerda: " + identificador + ".</td>\n");
        sb.append(";;true$$\n");
        // Relação A/C direita e esquerda	:
        sb.append("\n103;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("104;;CampoDouble;;\n");
        sb.append("Relação A/C direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("105;;CampoDouble;;\n");
        sb.append("Relação A/C esquerda: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Apenas Texto Média das relações das artérias uterinas	:
        sb.append("\n106;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n\t\t<td colspan=\"2\" width=\"50%\" "
                  + " >\n\t\t\t<b>Média das relações das artérias"
                  + " uterinas</b>\n\t\t</td>\n\t</tr>;;false$$\n");

          //Média das relações S/D	:
        sb.append("\n107;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("$$\n");
        sb.append("108;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média das relações S/D: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Média dos valores de IR:
         sb.append("\n109;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("110;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média dos valores de IR: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Média dos valores de IP:	:
         sb.append("\n111;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("112;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média dos valores de IP: " + identificador + " (Normal: IP Médio <= 2,31).\n");
        sb.append(";;2$$\n");
        // Média das relações A/C:
        sb.append("\n113;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("114;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média das relações A/C: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Incisura bilateral:
        sb.append("\n115;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("116;;CampoLogicoTexto;;Incisura bilateral: " + identificador + ".\n;;{$101CampoDoLaudo|$102CampoDoLaudo}\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Artéria Umbilical e cerebral">
         sb.append("\n117;;Topico;; ;;\n");
        sb.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Artérias umbilical e cerebral").append("</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Umbilical").append("<b/>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t<b>Cerebral</b></td>\n");
        sb.append("\t</tr>\n");
        sb.append(HTML_CAMPOS_FILHOS).append("\n");
        sb.append("</table>$$\n");

        // Relação S/D umbilical e cerebral:
         sb.append("\n118;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("119;;CampoDouble;;\n");
        sb.append("Relação S/D: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("120;;CampoDouble;;\n");
        sb.append("Relação S/D: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // IR umbilical e cerebral:
        sb.append("\n121;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("122;;CampoDouble;;\n");
        sb.append("IR: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("123;;CampoDouble;;\n");
        sb.append("IR: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // IP umbilical e cerebral:
         sb.append("\n124;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("125;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("126;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Pico sistólico (ACM)	:
         sb.append("\n127;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("128;;CampoDouble;;\n");
        sb.append("Pico sistólico (ACM): " + identificador + " cm/s.\n");
        sb.append(";;2$$\n");

        // diástole umbilical e cerebral:
        sb.append("\n129;;Linha$$\n");
        sb.append("130;;Enumeracao;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\" >\n");
        sb.append("\t\t\tDiástole: " + identificador + ".\n");
        sb.append("\t\t</td>\n");
        sb.append(";;true$$\n");
        sb.append("131;;Enumeracao;;\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\tDiástole: " + identificador + ".</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;true$$\n");

        // Apenas Texto Média das relações das artérias umbilical e cerebral:
        sb.append("\n132;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n\t\t<td colspan=\"2\" width=\"50%\" "
                  + " >\n\t\t\t<b>Média das relações das artérias umbilical e cerebral"
                  + " uterinas</b>\n\t\t</td>\n\t</tr>;;false$$\n");

        // Média das relações S/D	:
        sb.append("\n133;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("134;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média das relações S/D: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");
        // Média dos valores de IR:
         sb.append("\n135;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("136;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média dos valores de IR: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");
        // Média dos valores de IP:	:
         sb.append("\n137;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("138;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média dos valores de IP: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ducto venoso">
        sb.append("\n139;;Topico;;Ducto venoso$$\n");
        //sb.append("\n138;;Linha;;<b><u>Ducto Venoso</u></b>TEXTO_CAMPOS_FILHOS$$\n");
        // ducto venoso diastole
        sb.append("\n140;;Linha$$\n");
        sb.append("141;;Enumeracao;;\n");
        sb.append("Diástole: " + identificador + ".\n");
        sb.append(";;true$$\n");
        // ducto venoso ip
        sb.append("\n142;;Linha$$\n");
        sb.append("143;;CampoDouble;;\n");
        sb.append("IP: " + identificador + " (Normal: IP < 2.3 (Fluxo anterogrado em fase de contração atrial)).\n");
        sb.append(";;2$$\n");
        // </editor-fold>

        //veia umbilical
        sb.append("\n144;;Topico;;Veia umbilical$$\n");
        //sb.append("\n143;;Linha;;<b><u>Veia umbilical</u></b>TEXTO_CAMPOS_FILHOS$$\n");
        // ducto venoso veia umbilical
        sb.append("\n145;;Linha$$\n");
        sb.append("146;;Enumeracao;;\n");
        sb.append(identificador + " (normal: fluxo contínuo).\n");
        sb.append(";;true$$\n");

        // <editor-fold defaultstate="collapsed" desc="Observações feto 1">

         //campo descrito  Observações gerais
        sb.append("\n147;;Topico;;Observações gerais$$\n");
        //sb.append("\n146;;Linha;;<b><u>Observações Gerais</u></b>TEXTO_CAMPOS_FILHOS$$\n");
        sb.append("\n148;;Linha$$\n");
        sb.append("149;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados Feto2">

        // <editor-fold defaultstate="collapsed" desc="Artéria Uterina">
        sb.append("\n150;;Topico;;Descrição para o feto 2;;\n");
        sb.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t").append(ID_DESCRICAO_TOPICO).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Artéria uterina").append("</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Direita").append("</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t<b>Esquerda</b></td>\n");
        sb.append("\t</tr>\n");
        sb.append(HTML_CAMPOS_FILHOS).append("\n");
        sb.append("</table>$$\n");

        // Relação S/D direita e esquerda	:
        sb.append("\n151;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("152;;CampoDouble;;\n");
        sb.append("\t\t\tRelação S/D direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("153;;CampoDouble;;\n");
        sb.append("\t\t\tRelação S/D esquerda: " + identificador + ".\n");
        sb.append(";;2$$\n");

         // IR direita e esquerda	:
        sb.append("\n154;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("155;;CampoDouble;;\n");
        sb.append("\t\t\tIR direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("156;;CampoDouble;;\n");
        sb.append("\t\t\tIR esquerda: " + identificador + ".\n");
        sb.append(";;2$$\n");

        // IP direita e esquerda	:
        sb.append("\n157;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("158;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("159;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Incisura direita e esquerda	:
        sb.append("\n160;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("161;;Enumeracao;;\n");
        sb.append("Incisura direita: " + identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("162;;Enumeracao;;\n");
        sb.append("Incisura esquerda: " + identificador + ".</td>\n");
        sb.append(";;true$$\n");
        // Relação A/C direita e esquerda	:
        sb.append("\n163;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("164;;CampoDouble;;\n");
        sb.append("Relação A/C direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("165;;CampoDouble;;\n");
        sb.append("Relação A/C esquerda: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Apenas Texto Média das relações das artérias uterinas	:
        sb.append("\n166;;LinhaDaTbl;;\n");
         sb.append("\t<tr>\n\t\t<td colspan=\"2\" width=\"50%\" "
                  + " >\n\t\t\t<b>Média das relações das artérias"
                  + " uterinas</b>\n\t\t</td>\n\t</tr>;;false$$\n");

         // Média das relações S/D	:
         sb.append("\n167;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("$$\n");
        sb.append("168;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média das relações S/D: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Média dos valores de IR:
         sb.append("\n169;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("170;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média dos valores de IR: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Média dos valores de IP:	:
         sb.append("\n171;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("172;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média dos valores de IP: " + identificador + " (Normal: IP Médio <= 2,31).\n");
        sb.append(";;2$$\n");
        // Média das relações A/C:
        sb.append("\n173;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("174;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média das relações A/C: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Incisura bilateral:
        sb.append("\n175;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("176;;CampoLogicoTexto;;Incisura bilateral: " + identificador + ".\n;;{$161CampoDoLaudo|$162CampoDoLaudo}\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Artéria Umbilical e cerebral">
         sb.append("\n177;;Topico;; ;;\n");
        sb.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Artérias umbilical e cerebral").append("<b/>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Umbilical").append("<b/>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t<b>Cerebral</b></td>\n");
        sb.append("\t</tr>\n");
        sb.append(HTML_CAMPOS_FILHOS).append("\n");
        sb.append("</table>$$\n");

        // Relação S/D umbilical e cerebral:
         sb.append("\n178;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("179;;CampoDouble;;\n");
        sb.append("Relação S/D: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("180;;CampoDouble;;\n");
        sb.append("Relação S/D: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // IR umbilical e cerebral:
         sb.append("\n181;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("182;;CampoDouble;;\n");
        sb.append("IR: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("183;;CampoDouble;;\n");
        sb.append("IR: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // IP umbilical e cerebral:
         sb.append("\n184;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("185;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("186;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Pico sistólico (ACM)	:
         sb.append("\n187;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("188;;CampoDouble;;\n");
        sb.append("Pico sistólico (ACM): " + identificador + " cm/s.\n");
        sb.append(";;2$$\n");

        // diástole umbilica e cerebral:
        sb.append("\n189;;Linha$$\n");
        sb.append("190;;Enumeracao;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\" >\n");
        sb.append("\t\t\tDiástole: " + identificador + ".\n");
        sb.append("\t\t</td>\n");
        sb.append(";;true$$\n");
        sb.append("191;;Enumeracao;;\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\tDiástole: " + identificador + ".</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;true$$\n");

        // Apenas Texto Média das relações das artérias umbilical e cerebral:
        sb.append("\n192;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n\t\t<td colspan=\"2\" width=\"50%\" "
                  + " >\n\t\t\t<b>Média das relações das artérias umbilical e cerebral"
                  + " uterinas</b>\n\t\t</td>\n\t</tr>;;false$$\n");

        // Média das relações S/D	:
        sb.append("\n193;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("194;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média das relações S/D: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");
        // Média dos valores de IR:
         sb.append("\n195;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("196;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média dos valores de IR: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");
        // Média dos valores de IP:	:
         sb.append("\n197;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("198;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média dos valores de IP: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ducto venoso">
        sb.append("\n199;;Topico;;Ducto venoso$$\n");
        // ducto venoso diastole
        sb.append("\n200;;Linha$$\n");
        sb.append("201;;Enumeracao;;\n");
        sb.append("Diástole: " + identificador + ".\n");
        sb.append(";;true$$\n");
        // ducto venoso ip
        sb.append("\n202;;Linha$$\n");
        sb.append("203;;CampoDouble;;\n");
        sb.append("IP: " + identificador + " (Normal: IP < 2.3 (Fluxo anterourado em fase de contração atrial)).\n");
        sb.append(";;2$$\n");
        // </editor-fold>

        //veia umbilical
        sb.append("\n204;;Topico;;Veia umbilical$$\n");
        // ducto venoso veia umbilical
        sb.append("\n205;;Linha$$\n");
        sb.append("206;;Enumeracao;;\n");
        sb.append(identificador + " (normal: fluxo contínuo).\n");
        sb.append(";;true$$\n");

        // <editor-fold defaultstate="collapsed" desc="Observações feto 2">

         //campo descrito  Observações gerais
        sb.append("\n207;;Topico;;Observações gerais$$\n");
        sb.append("\n208;;Linha$$\n");
        sb.append("209;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados Feto3">

        // <editor-fold defaultstate="collapsed" desc="Artéria Uterina">
        sb.append("\n210;;Topico;;Descrição para o feto 3;;\n");
        sb.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t").append(ID_DESCRICAO_TOPICO).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Artéria uterina").append("</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Direita").append("</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t<b>Esquerda</b></td>\n");
        sb.append("\t</tr>\n");
        sb.append(HTML_CAMPOS_FILHOS).append("\n");
        sb.append("</table>$$\n");

        // Relação S/D direita e esquerda	:
        sb.append("\n211;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("212;;CampoDouble;;\n");
        sb.append("\t\t\tRelação S/D direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("213;;CampoDouble;;\n");
        sb.append("\t\t\tRelação S/D esquerda: " + identificador + ".\n");
        sb.append(";;2$$\n");

         // IR direita e esquerda	:
        sb.append("\n214;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("215;;CampoDouble;;\n");
        sb.append("\t\t\tIR direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("216;;CampoDouble;;\n");
        sb.append("\t\t\tIR esquerda: " + identificador + ".\n");
        sb.append(";;2$$\n");

        // IP direita e esquerda	:
         sb.append("\n217;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("218;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("219;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Incisura direita e esquerda	:
        sb.append("\n220;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("221;;Enumeracao;;\n");
        sb.append("Incisura direita: " + identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("222;;Enumeracao;;\n");
        sb.append("Incisura esquerda: " + identificador + ".</td>\n");
        sb.append(";;true$$\n");
        // Relação A/C direita e esquerda	:
        sb.append("\n223;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("224;;CampoDouble;;\n");
        sb.append("Relação A/C direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("225;;CampoDouble;;\n");
        sb.append("Relação A/C esquerda: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Apenas Texto Média das relações das artérias uterinas	:
        sb.append("\n226;;LinhaDaTbl;;\n");
         sb.append("\t<tr>\n\t\t<td colspan=\"2\" width=\"50%\" "
                  + " >\n\t\t\t<b>Média das relações das artérias"
                  + " uterinas</b>\n\t\t</td>\n\t</tr>;;false$$\n");

         // Média das relações S/D	:
         sb.append("\n227;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("$$\n");
        sb.append("228;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média das relações S/D: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Média dos valores de IR:
         sb.append("\n229;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("230;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média dos valores de IR: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Média dos valores de IP:	:
         sb.append("\n231;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("232;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média dos valores de IP: " + identificador + " (Normal: IP Médio <= 2,31).\n");
        sb.append(";;2$$\n");
        // Média das relações A/C:
        sb.append("\n233;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("234;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média das relações A/C: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Incisura bilateral:
        sb.append("\n235;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("236;;CampoLogicoTexto;;Incisura bilateral: " + identificador + ".\n;;{$221CampoDoLaudo|$222CampoDoLaudo}\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Artéria Umbilical e cerebral">
        sb.append("\n237;;Topico;; ;;\n");
        sb.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Artérias umbilical e cerebral").append("<b/>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Umbilical").append("<b/>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t<b>Cerebral</b></td>\n");
        sb.append("\t</tr>\n");
        sb.append(HTML_CAMPOS_FILHOS).append("\n");
        sb.append("</table>$$\n");

        // Relação S/D umbilical e cerebral:
         sb.append("\n238;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("239;;CampoDouble;;\n");
        sb.append("Relação S/D: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("240;;CampoDouble;;\n");
        sb.append("Relação S/D: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // IR umbilical e cerebral:
         sb.append("\n241;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("242;;CampoDouble;;\n");
        sb.append("IR: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("243;;CampoDouble;;\n");
        sb.append("IR: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // IP umbilical e cerebral:
         sb.append("\n244;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("245;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("246;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Pico sistólico (ACM)	:
         sb.append("\n247;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("248;;CampoDouble;;\n");
        sb.append("Pico sistólico (ACM): " + identificador + " cm/s.\n");
        sb.append(";;2$$\n");

        // diástole umbilica e cerebral:
        sb.append("\n249;;Linha$$\n");
        sb.append("250;;Enumeracao;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\" >\n");
        sb.append("\t\t\tDiástole: " + identificador + ".\n");
        sb.append("\t\t</td>\n");
        sb.append(";;true$$\n");
        sb.append("251;;Enumeracao;;\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\tDiástole: " + identificador + ".</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;true$$\n");

        // Apenas Texto Média das relações das artérias umbilical e cerebral:
        sb.append("\n252;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n\t\t<td colspan=\"2\" width=\"50%\" "
                  + " >\n\t\t\t<b>Média das relações das artérias umbilical e cerebral"
                  + " uterinas</b>\n\t\t</td>\n\t</tr>;;false$$\n");

        // Média das relações S/D	:
        sb.append("\n253;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("254;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média das relações S/D: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");
        // Média dos valores de IR:
         sb.append("\n255;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("256;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média dos valores de IR: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");
        // Média dos valores de IP:	:
         sb.append("\n257;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("258;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média dos valores de IP: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ducto venoso">
        sb.append("\n259;;Topico;;Ducto venoso$$\n");
        // ducto venoso diastole
        sb.append("\n260;;Linha$$\n");
        sb.append("261;;Enumeracao;;\n");
        sb.append("Diástole: " + identificador + ".\n");
        sb.append(";;true$$\n");
        // ducto venoso ip
        sb.append("\n262;;Linha$$\n");
        sb.append("263;;CampoDouble;;\n");
        sb.append("IP: " + identificador + " (Normal: IP < 2.3 (Fluxo anterogrado em fase de contração atrial)).\n");
        sb.append(";;2$$\n");
        // </editor-fold>
//
        //veia umbilical
        sb.append("\n264;;Topico;;Veia umbilical$$\n");
        // ducto venoso veia umbilical
        sb.append("\n265;;Linha$$\n");
        sb.append("266;;Enumeracao;;\n");
        sb.append(identificador + " (normal: fluxo contínuo).\n");
        sb.append(";;true$$\n");

        // <editor-fold defaultstate="collapsed" desc="Observações feto 3">

         //campo descrito  Observações gerais
        sb.append("\n267;;Topico;;Observações gerais$$\n");
        sb.append("\n268;;Linha$$\n");
        sb.append("269;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados Feto4">

        // <editor-fold defaultstate="collapsed" desc="Artéria Uterina">
        sb.append("\n270;;Topico;;Descrição para o feto 4;;\n");
        sb.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t").append(ID_DESCRICAO_TOPICO).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Artéria uterina").append("</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Direita").append("</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t<b>Esquerda</b></td>\n");
        sb.append("\t</tr>\n");
        sb.append(HTML_CAMPOS_FILHOS).append("\n");
        sb.append("</table>$$\n");

        // Relação S/D direita e esquerda	:
        sb.append("\n271;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("272;;CampoDouble;;\n");
        sb.append("\t\t\tRelação S/D direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("273;;CampoDouble;;\n");
        sb.append("\t\t\tRelação S/D esquerda: " + identificador + ".\n");
        sb.append(";;2$$\n");

         // IR direita e esquerda	:
        sb.append("\n274;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("275;;CampoDouble;;\n");
        sb.append("\t\t\tIR direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("276;;CampoDouble;;\n");
        sb.append("\t\t\tIR esquerda: " + identificador + ".\n");
        sb.append(";;2$$\n");

        // IP direita e esquerda	:
         sb.append("\n277;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("278;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("279;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Incisura direita e esquerda	:
        sb.append("\n280;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("281;;Enumeracao;;\n");
        sb.append("Incisura direita: " + identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("282;;Enumeracao;;\n");
        sb.append("Incisura esquerda: " + identificador + ".</td>\n");
        sb.append(";;true$$\n");
        // Relação A/C direita e esquerda	:
        sb.append("\n283;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("284;;CampoDouble;;\n");
        sb.append("Relação A/C direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("285;;CampoDouble;;\n");
        sb.append("Relação A/C esquerda: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Apenas Texto Média das relações das artérias uterinas	:
        sb.append("\n286;;LinhaDaTbl;;\n");
         sb.append("\t<tr>\n\t\t<td colspan=\"2\" width=\"50%\" "
                  + " >\n\t\t\t<b>Média das relações das artérias"
                  + " uterinas</b>\n\t\t</td>\n\t</tr>;;false$$\n");

         // Média das relações S/D	:
         sb.append("\n287;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("$$\n");
        sb.append("288;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média das relações S/D: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Média dos valores de IR:
         sb.append("\n289;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("290;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média dos valores de IR: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Média dos valores de IP:	:
         sb.append("\n291;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("292;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média dos valores de IP: " + identificador + " (Normal: IP Médio <= 2,31).\n");
        sb.append(";;2$$\n");
        // Média das relações A/C:
        sb.append("\n293;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("294;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média das relações A/C: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Incisura bilateral:
        sb.append("\n295;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("296;;CampoLogicoTexto;;Incisura bilateral: " + identificador + ".\n;;{$281CampoDoLaudo|$282CampoDoLaudo}\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Artéria Umbilical e cerebral">
        sb.append("\n297;;Topico;; ;;\n");
        sb.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Artérias umbilical e cerebral").append("<b/>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Umbilical").append("<b/>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t<b>Cerebral</b></td>\n");
        sb.append("\t</tr>\n");
        sb.append(HTML_CAMPOS_FILHOS).append("\n");
        sb.append("</table>$$\n");

        // Relação S/D umbilical e cerebral:
         sb.append("\n298;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("299;;CampoDouble;;\n");
        sb.append("Relação S/D: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("300;;CampoDouble;;\n");
        sb.append("Relação S/D: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // IR umbilical e cerebral:
         sb.append("\n301;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("302;;CampoDouble;;\n");
        sb.append("IR: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("303;;CampoDouble;;\n");
        sb.append("IR: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // IP umbilical e cerebral:
         sb.append("\n304;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("305;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("306;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Pico sistólico (ACM)	:
         sb.append("\n307;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("308;;CampoDouble;;\n");
        sb.append("Pico sistólico (ACM): " + identificador + " cm/s.\n");
        sb.append(";;2$$\n");

        // diástole umbilica e cerebral:
        sb.append("\n309;;Linha$$\n");
        sb.append("310;;Enumeracao;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\" >\n");
        sb.append("\t\t\tDiástole: " + identificador + ".\n");
        sb.append("\t\t</td>\n");
        sb.append(";;true$$\n");
        sb.append("311;;Enumeracao;;\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\tDiástole: " + identificador + ".</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;true$$\n");

        // Apenas Texto Média das relações das artérias umbilical e cerebral:
        sb.append("\n312;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n\t\t<td colspan=\"2\" width=\"50%\" "
                  + " >\n\t\t\t<b>Média das relações das artérias umbilical e cerebral"
                  + " uterinas</b>\n\t\t</td>\n\t</tr>;;false$$\n");

        // Média das relações S/D	:
        sb.append("\n313;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("314;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média das relações S/D: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");
        // Média dos valores de IR:
         sb.append("\n315;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("316;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média dos valores de IR: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");
        // Média dos valores de IP:	:
         sb.append("\n317;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("318;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média dos valores de IP: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ducto venoso">
        sb.append("\n319;;Topico;;Ducto venoso$$\n");
        // ducto venoso diastole
        sb.append("\n320;;Linha$$\n");
        sb.append("321;;Enumeracao;;\n");
        sb.append("Diástole: " + identificador + ".\n");
        sb.append(";;true$$\n");
        // ducto venoso ip
        sb.append("\n322;;Linha$$\n");
        sb.append("323;;CampoDouble;;\n");
        sb.append("IP: " + identificador + " (Normal: IP < 2.3 (Fluxo anterogrado em fase de contração atrial)).\n");
        sb.append(";;2$$\n");
        // </editor-fold>
//
        //veia umbilical
        sb.append("\n324;;Topico;;Veia umbilical$$\n");
        // ducto venoso veia umbilical
        sb.append("\n325;;Linha$$\n");
        sb.append("326;;Enumeracao;;\n");
        sb.append(identificador + " (normal: fluxo contínuo).\n");
        sb.append(";;true$$\n");

        // <editor-fold defaultstate="collapsed" desc="Observações feto 4">

         //campo descrito  Observações gerais
        sb.append("\n327;;Topico;;Observações gerais$$\n");
        sb.append("\n328;;Linha$$\n");
        sb.append("329;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados Feto5">

        // <editor-fold defaultstate="collapsed" desc="Artéria Uterina">
        sb.append("\n330;;Topico;;Descrição para o feto 5;;\n");
        sb.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Artéria uterina").append("</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Direita").append("</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t<b>Esquerda</b></td>\n");
        sb.append("\t</tr>\n");
        sb.append(HTML_CAMPOS_FILHOS).append("\n");
        sb.append("</table>$$\n");

        // Relação S/D direita e esquerda	:
        sb.append("\n331;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("332;;CampoDouble;;\n");
        sb.append("\t\t\tRelação S/D direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("333;;CampoDouble;;\n");
        sb.append("\t\t\tRelação S/D esquerda: " + identificador + ".\n");
        sb.append(";;2$$\n");

         // IR direita e esquerda	:
        sb.append("\n334;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("335;;CampoDouble;;\n");
        sb.append("\t\t\tIR direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("336;;CampoDouble;;\n");
        sb.append("\t\t\tIR esquerda: " + identificador + ".\n");
        sb.append(";;2$$\n");

        // IP direita e esquerda	:
         sb.append("\n337;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("338;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("339;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Incisura direita e esquerda	:
        sb.append("\n340;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("341;;Enumeracao;;\n");
        sb.append("Incisura direita: " + identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("342;;Enumeracao;;\n");
        sb.append("Incisura esquerda: " + identificador + ".</td>\n");
        sb.append(";;true$$\n");
        // Relação A/C direita e esquerda	:
        sb.append("\n343;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("344;;CampoDouble;;\n");
        sb.append("Relação A/C direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("345;;CampoDouble;;\n");
        sb.append("Relação A/C esquerda: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Apenas Texto Média das relações das artérias uterinas	:
        sb.append("\n346;;LinhaDaTbl;;\n");
         sb.append("\t<tr>\n\t\t<td colspan=\"2\" width=\"50%\" "
                  + " >\n\t\t\t<b>Média das relações das artérias"
                  + " uterinas</b>\n\t\t</td>\n\t</tr>;;false$$\n");

         // Média das relações S/D	:
         sb.append("\n347;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("$$\n");
        sb.append("348;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média das relações S/D: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Média dos valores de IR:
         sb.append("\n349;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("350;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média dos valores de IR: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Média dos valores de IP:	:
         sb.append("\n351;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("352;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média dos valores de IP: " + identificador + " (Normal: IP Médio <= 2,31).\n");
        sb.append(";;2$$\n");
        // Média das relações A/C:
        sb.append("\n353;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("354;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média das relações A/C: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Incisura bilateral:
        sb.append("\n355;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("356;;CampoLogicoTexto;;Incisura bilateral: " + identificador + ".\n;;{$341CampoDoLaudo|$342CampoDoLaudo}\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Artéria Umbilical e cerebral">
        sb.append("\n357;;Topico;; ;;\n");
        sb.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t").append(ID_DESCRICAO_TOPICO).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Artérias umbilical e cerebral").append("<b/>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Umbilical").append("<b/>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t<b>Cerebral</b></td>\n");
        sb.append("\t</tr>\n");
        sb.append(HTML_CAMPOS_FILHOS).append("\n");
        sb.append("</table>$$\n");

        // Relação S/D umbilical e cerebral:
         sb.append("\n358;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("359;;CampoDouble;;\n");
        sb.append("Relação S/D: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("360;;CampoDouble;;\n");
        sb.append("Relação S/D: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // IR umbilical e cerebral:
         sb.append("\n361;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("362;;CampoDouble;;\n");
        sb.append("IR: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("363;;CampoDouble;;\n");
        sb.append("IR: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // IP umbilical e cerebral:
         sb.append("\n364;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("365;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("366;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Pico sistólico (ACM)	:
         sb.append("\n367;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("368;;CampoDouble;;\n");
        sb.append("Pico sistólico (ACM): " + identificador + " cm/s.\n");
        sb.append(";;2$$\n");

        // diástole umbilica e cerebral:
        sb.append("\n369;;Linha$$\n");
        sb.append("370;;Enumeracao;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\" >\n");
        sb.append("\t\t\tDiástole: " + identificador + ".\n");
        sb.append("\t\t</td>\n");
        sb.append(";;true$$\n");
        sb.append("371;;Enumeracao;;\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\tDiástole: " + identificador + ".</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;true$$\n");

        // Apenas Texto Média das relações das artérias umbilical e cerebral:
        sb.append("\n372;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n\t\t<td colspan=\"2\" width=\"50%\" "
                  + " >\n\t\t\t<b>Média das relações das artérias umbilical e cerebral"
                  + " uterinas</b>\n\t\t</td>\n\t</tr>;;false$$\n");

        // Média das relações S/D	:
        sb.append("\n373;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("374;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média das relações S/D: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");
        // Média dos valores de IR:
         sb.append("\n375;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("376;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média dos valores de IR: " + identificador + " (Normal: &lt 1.0.)\n");
        sb.append(";;2$$\n");
        // Média dos valores de IP:	:
         sb.append("\n377;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("378;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média dos valores de IP: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ducto venoso">
        sb.append("\n379;;Topico;;Ducto venoso$$\n");
        // ducto venoso diastole
        sb.append("\n380;;Linha$$\n");
        sb.append("381;;Enumeracao;;\n");
        sb.append("Diástole: " + identificador + ".\n");
        sb.append(";;true$$\n");
        // ducto venoso ip
        sb.append("\n382;;Linha$$\n");
        sb.append("383;;CampoDouble;;\n");
        sb.append("IP: " + identificador + " (Normal: IP < 2.3 (Fluxo anterogrado em fase de contração atrial)).\n");
        sb.append(";;2$$\n");
        // </editor-fold>
//
        //veia umbilical
        sb.append("\n384;;Topico;;Veia umbilical$$\n");
        // ducto venoso veia umbilical
        sb.append("\n385;;Linha$$\n");
        sb.append("386;;Enumeracao;;\n");
        sb.append(identificador + " (normal: fluxo contínuo).\n");
        sb.append(";;true$$\n");

        // <editor-fold defaultstate="collapsed" desc="Observações feto 5">

         //campo descrito  Observações gerais
        sb.append("\n387;;Topico;;Observações gerais$$\n");
        sb.append("\n388;;Linha$$\n");
        sb.append("389;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados Feto6">

        // <editor-fold defaultstate="collapsed" desc="Artéria Uterina">
        sb.append("\n390;;Topico;;Descrição para o feto 6;;\n");
        sb.append("<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t").append(ID_DESCRICAO_TOPICO).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Artéria uterina").append("</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Direita").append("</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t<b>Esquerda</b></td>\n");
        sb.append("\t</tr>\n");
        sb.append(HTML_CAMPOS_FILHOS).append("\n");
        sb.append("</table>$$\n");

        // Relação S/D direita e esquerda	:
        sb.append("\n391;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("392;;CampoDouble;;\n");
        sb.append("\t\t\tRelação S/D direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("393;;CampoDouble;;\n");
        sb.append("\t\t\tRelação S/D esquerda: " + identificador + ".\n");
        sb.append(";;2$$\n");

         // IR direita e esquerda	:
        sb.append("\n394;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("395;;CampoDouble;;\n");
        sb.append("\t\t\tIR direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("396;;CampoDouble;;\n");
        sb.append("\t\t\tIR esquerda: " + identificador + ".\n");
        sb.append(";;2$$\n");

        // IP direita e esquerda	:
         sb.append("\n397;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("398;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("399;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Incisura direita e esquerda	:
        sb.append("\n400;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("401;;Enumeracao;;\n");
        sb.append("Incisura direita: " + identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("402;;Enumeracao;;\n");
        sb.append("Incisura esquerda: " + identificador + ".</td>\n");
        sb.append(";;true$$\n");
        // Relação A/C direita e esquerda	:
        sb.append("\n403;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("404;;CampoDouble;;\n");
        sb.append("Relação A/C direita: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("405;;CampoDouble;;\n");
        sb.append("Relação A/C esquerda: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Apenas Texto Média das relações das artérias uterinas	:
        sb.append("\n406;;LinhaDaTbl;;\n");
         sb.append("\t<tr>\n\t\t<td colspan=\"2\" width=\"50%\" "
                  + " >\n\t\t\t<b>Média das relações das artérias"
                  + " uterinas</b>\n\t\t</td>\n\t</tr>;;false$$\n");

         // Média das relações S/D	:
         sb.append("\n407;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("$$\n");
        sb.append("408;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média das relações S/D: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Média dos valores de IR:
         sb.append("\n409;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("410;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média dos valores de IR:" + identificador + ". \n");
        sb.append(";;2$$\n");
        // Média dos valores de IP:	:
         sb.append("\n411;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("412;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média dos valores de IP: " + identificador + " (Normal: IP Médio <= 2,31).\n");
        sb.append(";;2$$\n");
        // Média das relações A/C:
        sb.append("\n413;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("414;;CampoRpn;;C1 C2 + 2 /;;\n");
        sb.append("Média das relações A/C: " + identificador + ". \n");
        sb.append(";;2$$\n");
        // Incisura bilateral:
        sb.append("\n415;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("416;;CampoLogicoTexto;;Incisura bilateral::" + identificador + ".\n;;{$401CampoDoLaudo|$402CampoDoLaudo}\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Artéria Umbilical e cerebral">
        sb.append("\n417;;Topico;; ;;\n");
        sb.append("<table width=\"100%\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Artérias umbilical e cerebral").append("<b/>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Umbilical").append("<b/>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td  colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t<b>Cerebral</b></td>\n");
        sb.append("\t</tr>\n");
        sb.append(HTML_CAMPOS_FILHOS).append("\n");
        sb.append("</table>$$\n");

        // Relação S/D umbilical e cerebral:
         sb.append("\n418;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("419;;CampoDouble;;\n");
        sb.append("Relação S/D: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("420;;CampoDouble;;\n");
        sb.append("Relação S/D: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // IR umbilical e cerebral:
         sb.append("\n421;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("422;;CampoDouble;;\n");
        sb.append("IR: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("423;;CampoDouble;;\n");
        sb.append("IR: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // IP umbilical e cerebral:
         sb.append("\n424;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("425;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".\n");
        sb.append(";;2$$\n");
        sb.append("426;;CampoDouble;;\n");
        sb.append("IP: " + identificador + ".</td>\n");
        sb.append(";;2$$\n");
        // Pico sistólico (ACM)	:
         sb.append("\n427;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("428;;CampoDouble;;\n");
        sb.append("Pico sistólico (ACM): " + identificador + " cm/s.\n");
        sb.append(";;2$$\n");

        // diástole umbilica e cerebral:
        sb.append("\n429;;Linha$$\n");
        sb.append("430;;Enumeracao;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\" >\n");
        sb.append("\t\t\tDiástole: " + identificador + ".\n");
        sb.append("\t\t</td>\n");
        sb.append(";;true$$\n");
        sb.append("431;;Enumeracao;;\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\tDiástole: " + identificador + ".</td>\n");
        sb.append("\t</tr>\n");
        sb.append(";;true$$\n");

        // Apenas Texto Média das relações das artérias umbilical e cerebral:
        sb.append("\n432;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n\t\t<td colspan=\"2\" width=\"50%\" "
                  + " >\n\t\t\t<b>Média das relações das artérias umbilical e cerebral"
                  + " uterinas</b>\n\t\t</td>\n\t</tr>;;false$$\n");

        // Média das relações S/D	:
        sb.append("\n433;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("434;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média das relações S/D: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");
        // Média dos valores de IR:
         sb.append("\n435;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("436;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média dos valores de IR: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");
        // Média dos valores de IP:	:
         sb.append("\n437;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\"  >\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("438;;CampoRpn;;C1 C2 /;;\n");
        sb.append("Média dos valores de IP: " + identificador + " (Normal: &lt 1.0).\n");
        sb.append(";;2$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ducto venoso">
        sb.append("\n439;;Topico;;Ducto venoso$$\n");
        // ducto venoso diastole
        sb.append("\n440;;Linha$$\n");
        sb.append("441;;Enumeracao;;\n");
        sb.append("Diástole: " + identificador + ".\n");
        sb.append(";;true$$\n");
        // ducto venoso ip
        sb.append("\n442;;Linha$$\n");
        sb.append("443;;CampoDouble;;\n");
        sb.append("IP: " + identificador + " (Normal: IP < 2.3 (Fluxo anterogrado em fase de contração atrial)).\n");
        sb.append(";;2$$\n");
        // </editor-fold>
//
        //veia umbilical
        sb.append("\n444;;Topico;;Veia umbilical$$\n");
        // ducto venoso veia umbilical
        sb.append("\n445;;Linha$$\n");
        sb.append("446;;Enumeracao;;\n");
        sb.append(identificador + " (normal: fluxo contínuo).\n");
        sb.append(";;true$$\n");

        // <editor-fold defaultstate="collapsed" desc="Observações feto 6">

         //campo descrito  Observações gerais
        sb.append("\n447;;Topico;;Observações gerais$$\n");
        sb.append("\n448;;Linha$$\n");
        sb.append("449;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">
        sb.append("\n450;;Topico;;Impressão diagnóstica$$\n");
        //semanas informada
        sb.append("\n451;;Linha$$\n");
        sb.append("452;;ImpressaoDiagnostica;;\n");
        sb.append("<p style=\"margin-top: 0\">Dados hemodinâmicos:</p>\n");
        sb.append("<p style=\"margin-top: 0\">Fluxo útero placentário normal.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Fluxo feto placentário normal.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Função hemodinâmica normal.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Função miocárdica normal.</p>\n");
        sb.append("$$\n");
        sb.append("\n453;;Linha$$\n");
        sb.append("454;;Enumeracao;;$452CampoTexto$$\n");
        // </editor-fold>

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Metodos">

        // <editor-fold defaultstate="collapsed" desc="metodos feto gestação unica">

        sb.append("\n56;;cadastrarLogica;;Indeterminado$$\n");
        sb.append("\n56;;cadastrarLogica;;Não imprimir;;Indeterminado$$\n");
        sb.append("\n56;;cadastrarLogica;;Não;;Ausente$$\n");
        sb.append("\n56;;cadastrarLogica;;Sim;;Presente$$\n");

        sb.append("\n74;;adicionarExcecao;;0.0;; Índice Umbilico/Cerebral (S/D)...: 0 (Normal: &lt 1.0)$$\n");
        sb.append("\n76;;adicionarExcecao;;0.0;;Índice Umbilico/Cerebral (I/R)...: 0 (Normal: &lt 1.0)$$\n");
        sb.append("\n78;;adicionarExcecao;;0.0;;Índice Umbilico/Cerebral (I/P)...: 0 (Normal: &lt 1.0)$$\n");

        sb.append("\n48;;adicionarExcecao;;0.0;;Média das Relações S/D...: ----$$\n");
        sb.append("\n50;;adicionarExcecao;;0.0;;Média dos Valores de IR...: ----$$\n");
        sb.append("\n52;;adicionarExcecao;;0.0;;Média dos Valores de IP...: ----$$\n");
        //ducto venoso
        sb.append("\n81;;adicionarOpcao;;presente$$\n");
        sb.append("81;;adicionarOpcao;;zero$$\n");
        sb.append("81;;adicionarOpcao;;reversa$$\n");

        //veia umbilical
        sb.append("\n86;;adicionarOpcao;;Fluxo contínuo$$\n");
        sb.append("86;;adicionarOpcao;;Fluxo pulsátil$$\n");
        //relação sd umbilical / cerebral
        sb.append("\n74;;cadastrarParametroFormula;;$59CampoNumero$$\n");
        sb.append("74;;cadastrarParametroFormula;;$60CampoNumero$$\n");
         //relacao ir umbilicar / ir cerebral
        sb.append("\n76;;cadastrarParametroFormula;;$62CampoNumero$$\n");
        sb.append("76;;cadastrarParametroFormula;;$63CampoNumero$$\n");
         //relacao ip umbilicar / ip cerebral
        sb.append("\n78;;cadastrarParametroFormula;;$65CampoNumero$$\n");
        sb.append("78;;cadastrarParametroFormula;;$66CampoNumero$$\n");

        //diástole umbilicar e cerebral
        sb.append("\n70;;adicionarOpcao;;presente$$\n");
        sb.append("70;;adicionarOpcao;;zero$$\n");
        sb.append("70;;adicionarOpcao;;reversa$$\n");

        sb.append("\n71;;adicionarOpcao;;presente$$\n");
        sb.append("71;;adicionarOpcao;;zero$$\n");
        sb.append("71;;adicionarOpcao;;reversa$$\n");

        //vincular relacao s/d e ir umbilicar e cerebral
        sb.append("59;;vincularHabAoValorDoCampo;;$70CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("60;;vincularHabAoValorDoCampo;;$71CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("62;;vincularHabAoValorDoCampo;;$70CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("63;;vincularHabAoValorDoCampo;;$71CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
//
        //incisuras direita e esquerda
        sb.append("\n41;;adicionarOpcao;;Não$$\n");
        sb.append("41;;adicionarOpcao;;Sim$$\n");
        sb.append("42;;adicionarOpcao;;Não$$\n");
        sb.append("42;;adicionarOpcao;;Sim$$\n");
//
        sb.append("44;;vincularHabAoValorDoCampo;;$41CampoDoLaudo;;false;;{Sim|Não}$$\n");
        sb.append("45;;vincularHabAoValorDoCampo;;$42CampoDoLaudo;;false;;{Sim|Não}$$\n");
//
//        //media a/c
        sb.append("\n54;;cadastrarParametroFormula;;$44CampoNumero$$\n");
        sb.append("\n54;;cadastrarParametroFormula;;$45CampoNumero$$\n");
//
//        //media i/p
        sb.append("\n52;;cadastrarParametroFormula;;$38CampoNumero$$\n");
        sb.append("52;;cadastrarParametroFormula;;$39CampoNumero$$\n");
//
//        //media i/r
        sb.append("\n50;;cadastrarParametroFormula;;$35CampoNumero$$\n");
        sb.append("50;;cadastrarParametroFormula;;$36CampoNumero$$\n");
//
//        //media s/d
        sb.append("\n48;;cadastrarParametroFormula;;$32CampoNumero$$\n");
        sb.append("48;;cadastrarParametroFormula;;$33CampoNumero$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="metodos feto 1">
        sb.append("\n116;;cadastrarLogica;;Indeterminado$$\n");
        sb.append("\n116;;cadastrarLogica;;Não imprimir;;Indeterminado$$\n");
        sb.append("\n116;;cadastrarLogica;;Não;;Ausente$$\n");
        sb.append("\n116;;cadastrarLogica;;Sim;;Presente$$\n");

        sb.append("\n134;;adicionarExcecao;;0.0;; Índice Umbilico/Cerebral (S/D)...: 0 (Normal: &lt 1.0)$$\n");
        sb.append("\n136;;adicionarExcecao;;0.0;;Índice Umbilico/Cerebral (I/R)...: 0 (Normal: &lt 1.0)$$\n");
        sb.append("\n138;;adicionarExcecao;;0.0;;Índice Umbilico/Cerebral (I/P)...: 0 (Normal: &lt 1.0)$$\n");

        sb.append("\n108;;adicionarExcecao;;0.0;;Média das Relações S/D...: ----$$\n");
        sb.append("\n110;;adicionarExcecao;;0.0;;Média dos Valores de IR...: ----$$\n");
        sb.append("\n112;;adicionarExcecao;;0.0;;Média dos Valores de IP...: ----$$\n");
        //ducto venoso
        sb.append("\n141;;adicionarOpcao;;presente$$\n");
        sb.append("141;;adicionarOpcao;;zero$$\n");
        sb.append("141;;adicionarOpcao;;reversa$$\n");

        //veia umbilical
        sb.append("\n146;;adicionarOpcao;;Fluxo contínuo$$\n");
        sb.append("146;;adicionarOpcao;;Fluxo pulsátil$$\n");
        //relação sd umbilical / cerebral
        sb.append("\n134;;cadastrarParametroFormula;;$119CampoNumero$$\n");
        sb.append("134;;cadastrarParametroFormula;;$120CampoNumero$$\n");
         //relacao ir umbilicar / ir cerebral
        sb.append("\n136;;cadastrarParametroFormula;;$122CampoNumero$$\n");
        sb.append("136;;cadastrarParametroFormula;;$123CampoNumero$$\n");
         //relacao ip umbilicar / ip cerebral
        sb.append("\n138;;cadastrarParametroFormula;;$125CampoNumero$$\n");
        sb.append("138;;cadastrarParametroFormula;;$126CampoNumero$$\n");

        //diástole umbilicar e cerebral
        sb.append("\n130;;adicionarOpcao;;presente$$\n");
        sb.append("130;;adicionarOpcao;;zero$$\n");
        sb.append("130;;adicionarOpcao;;reversa$$\n");

        sb.append("\n131;;adicionarOpcao;;presente$$\n");
        sb.append("131;;adicionarOpcao;;zero$$\n");
        sb.append("131;;adicionarOpcao;;reversa$$\n");

        //vincular relacao s/d e ir umbilicar e cerebral
        sb.append("119;;vincularHabAoValorDoCampo;;$130CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("120;;vincularHabAoValorDoCampo;;$131CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("122;;vincularHabAoValorDoCampo;;$130CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("123;;vincularHabAoValorDoCampo;;$131CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
//
        //incisuras direita e esquerda
        sb.append("\n101;;adicionarOpcao;;Não$$\n");
        sb.append("101;;adicionarOpcao;;Sim$$\n");
        sb.append("102;;adicionarOpcao;;Não$$\n");
        sb.append("102;;adicionarOpcao;;Sim$$\n");
//
        sb.append("104;;vincularHabAoValorDoCampo;;$101CampoDoLaudo;;false;;{Sim|Não}$$\n");
        sb.append("105;;vincularHabAoValorDoCampo;;$102CampoDoLaudo;;false;;{Sim|Não}$$\n");
//
//        //media a/c
        sb.append("\n114;;cadastrarParametroFormula;;$104CampoNumero$$\n");
        sb.append("\n114;;cadastrarParametroFormula;;$105CampoNumero$$\n");
//
//        //media i/p
        sb.append("\n112;;cadastrarParametroFormula;;$98CampoNumero$$\n");
        sb.append("112;;cadastrarParametroFormula;;$99CampoNumero$$\n");
//
//        //media i/r
        sb.append("\n110;;cadastrarParametroFormula;;$95CampoNumero$$\n");
        sb.append("110;;cadastrarParametroFormula;;$96CampoNumero$$\n");
//
//        //media s/d
        sb.append("\n108;;cadastrarParametroFormula;;$92CampoNumero$$\n");
        sb.append("108;;cadastrarParametroFormula;;$93CampoNumero$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="metodos feto 2">
        sb.append("\n176;;cadastrarLogica;;Indeterminado$$\n");
        sb.append("\n176;;cadastrarLogica;;Não imprimir;;Indeterminado$$\n");
        sb.append("\n176;;cadastrarLogica;;Não;;Ausente$$\n");
        sb.append("\n176;;cadastrarLogica;;Sim;;Presente$$\n");

        sb.append("\n194;;adicionarExcecao;;0.0;; Índice Umbilico/Cerebral (S/D)...: 0 (Normal: &lt 1.0)$$\n");
        sb.append("\n196;;adicionarExcecao;;0.0;;Índice Umbilico/Cerebral (I/R)...: 0 (Normal: &lt 1.0)$$\n");
        sb.append("\n198;;adicionarExcecao;;0.0;;Índice Umbilico/Cerebral (I/P)...: 0 (Normal: &lt 1.0)$$\n");

        sb.append("\n168;;adicionarExcecao;;0.0;;Média das Relações S/D...: ----$$\n");
        sb.append("\n170;;adicionarExcecao;;0.0;;Média dos Valores de IR...: ----$$\n");
        sb.append("\n172;;adicionarExcecao;;0.0;;Média dos Valores de IP...: ----$$\n");
        //ducto venoso
        sb.append("\n201;;adicionarOpcao;;presente$$\n");
        sb.append("201;;adicionarOpcao;;zero$$\n");
        sb.append("201;;adicionarOpcao;;reversa$$\n");

        //veia umbilical
        sb.append("\n206;;adicionarOpcao;;Fluxo contínuo$$\n");
        sb.append("206;;adicionarOpcao;;Fluxo pulsátil$$\n");
        //relação sd umbilical / cerebral
        sb.append("\n194;;cadastrarParametroFormula;;$179CampoNumero$$\n");
        sb.append("194;;cadastrarParametroFormula;;$180CampoNumero$$\n");
         //relacao ir umbilicar / ir cerebral
        sb.append("\n196;;cadastrarParametroFormula;;$182CampoNumero$$\n");
        sb.append("196;;cadastrarParametroFormula;;$183CampoNumero$$\n");
         //relacao ip umbilicar / ip cerebral
        sb.append("\n198;;cadastrarParametroFormula;;$185CampoNumero$$\n");
        sb.append("198;;cadastrarParametroFormula;;$186CampoNumero$$\n");

        //diástole umbilicar e cerebral
        sb.append("\n190;;adicionarOpcao;;presente$$\n");
        sb.append("190;;adicionarOpcao;;zero$$\n");
        sb.append("190;;adicionarOpcao;;reversa$$\n");

        sb.append("\n191;;adicionarOpcao;;presente$$\n");
        sb.append("191;;adicionarOpcao;;zero$$\n");
        sb.append("191;;adicionarOpcao;;reversa$$\n");

        //vincular relacao s/d e ir umbilicar e cerebral
        sb.append("179;;vincularHabAoValorDoCampo;;$190CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("180;;vincularHabAoValorDoCampo;;$191CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("182;;vincularHabAoValorDoCampo;;$190CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("183;;vincularHabAoValorDoCampo;;$191CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
//
        //incisuras direita e esquerda
        sb.append("\n161;;adicionarOpcao;;Não$$\n");
        sb.append("161;;adicionarOpcao;;Sim$$\n");
        sb.append("162;;adicionarOpcao;;Não$$\n");
        sb.append("162;;adicionarOpcao;;Sim$$\n");
//
        sb.append("164;;vincularHabAoValorDoCampo;;$161CampoDoLaudo;;false;;{Sim|Não}$$\n");
        sb.append("165;;vincularHabAoValorDoCampo;;$162CampoDoLaudo;;false;;{Sim|Não}$$\n");
//
//        //media a/c
        sb.append("\n174;;cadastrarParametroFormula;;$164CampoNumero$$\n");
        sb.append("\n174;;cadastrarParametroFormula;;$165CampoNumero$$\n");
//
//        //media i/p
        sb.append("\n172;;cadastrarParametroFormula;;$158CampoNumero$$\n");
        sb.append("172;;cadastrarParametroFormula;;$159CampoNumero$$\n");
//
//        //media i/r
        sb.append("\n170;;cadastrarParametroFormula;;$155CampoNumero$$\n");
        sb.append("170;;cadastrarParametroFormula;;$156CampoNumero$$\n");
//
//        //media s/d
        sb.append("\n168;;cadastrarParametroFormula;;$152CampoNumero$$\n");
        sb.append("168;;cadastrarParametroFormula;;$153CampoNumero$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="metodos feto 3">
         sb.append("\n236;;cadastrarLogica;;Indeterminado$$\n");
        sb.append("\n236;;cadastrarLogica;;Não imprimir;;Indeterminado$$\n");
        sb.append("\n236;;cadastrarLogica;;Não;;Ausente$$\n");
        sb.append("\n236;;cadastrarLogica;;Sim;;Presente$$\n");

        sb.append("\n254;;adicionarExcecao;;0.0;; Índice Umbilico/Cerebral (S/D)...: 0 (Normal: &lt 1.0)$$\n");
        sb.append("\n256;;adicionarExcecao;;0.0;;Índice Umbilico/Cerebral (I/R)...: 0 (Normal: &lt 1.0)$$\n");
        sb.append("\n258;;adicionarExcecao;;0.0;;Índice Umbilico/Cerebral (I/P)...: 0 (Normal: &lt 1.0)$$\n");

        sb.append("\n228;;adicionarExcecao;;0.0;;Média das Relações S/D...: ----$$\n");
        sb.append("\n230;;adicionarExcecao;;0.0;;Média dos Valores de IR...: ----$$\n");
        sb.append("\n232;;adicionarExcecao;;0.0;;Média dos Valores de IP...: ----$$\n");
        //ducto venoso
        sb.append("\n261;;adicionarOpcao;;presente$$\n");
        sb.append("261;;adicionarOpcao;;zero$$\n");
        sb.append("261;;adicionarOpcao;;reversa$$\n");

        //veia umbilical
        sb.append("\n266;;adicionarOpcao;;Fluxo contínuo$$\n");
        sb.append("266;;adicionarOpcao;;Fluxo pulsátil$$\n");
        //relação sd umbilical / cerebral
        sb.append("\n254;;cadastrarParametroFormula;;$239CampoNumero$$\n");
        sb.append("254;;cadastrarParametroFormula;;$240CampoNumero$$\n");
         //relacao ir umbilicar / ir cerebral
        sb.append("\n256;;cadastrarParametroFormula;;$242CampoNumero$$\n");
        sb.append("256;;cadastrarParametroFormula;;$243CampoNumero$$\n");
         //relacao ip umbilicar / ip cerebral
        sb.append("\n258;;cadastrarParametroFormula;;$245CampoNumero$$\n");
        sb.append("258;;cadastrarParametroFormula;;$246CampoNumero$$\n");

        //diástole umbilicar e cerebral
        sb.append("\n250;;adicionarOpcao;;presente$$\n");
        sb.append("250;;adicionarOpcao;;zero$$\n");
        sb.append("250;;adicionarOpcao;;reversa$$\n");

        sb.append("\n251;;adicionarOpcao;;presente$$\n");
        sb.append("251;;adicionarOpcao;;zero$$\n");
        sb.append("251;;adicionarOpcao;;reversa$$\n");

        //vincular relacao s/d e ir umbilicar e cerebral
        sb.append("239;;vincularHabAoValorDoCampo;;$250CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("240;;vincularHabAoValorDoCampo;;$251CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("242;;vincularHabAoValorDoCampo;;$250CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("243;;vincularHabAoValorDoCampo;;$251CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");

        //incisuras direita e esquerda
        sb.append("\n221;;adicionarOpcao;;Não$$\n");
        sb.append("221;;adicionarOpcao;;Sim$$\n");
        sb.append("222;;adicionarOpcao;;Não$$\n");
        sb.append("222;;adicionarOpcao;;Sim$$\n");
//       vincular ac com relação a incisura
        sb.append("224;;vincularHabAoValorDoCampo;;$221CampoDoLaudo;;false;;{Sim|Não}$$\n");
        sb.append("225;;vincularHabAoValorDoCampo;;$222CampoDoLaudo;;false;;{Sim|Não}$$\n");
//
//        //media a/c
        sb.append("\n234;;cadastrarParametroFormula;;$224CampoNumero$$\n");
        sb.append("\n234;;cadastrarParametroFormula;;$225CampoNumero$$\n");
//
//        //media i/p
        sb.append("\n232;;cadastrarParametroFormula;;$218CampoNumero$$\n");
        sb.append("232;;cadastrarParametroFormula;;$219CampoNumero$$\n");
//
//        //media i/r
        sb.append("\n230;;cadastrarParametroFormula;;$215CampoNumero$$\n");
        sb.append("230;;cadastrarParametroFormula;;$216CampoNumero$$\n");
//
//        //media s/d
        sb.append("\n228;;cadastrarParametroFormula;;$212CampoNumero$$\n");
        sb.append("228;;cadastrarParametroFormula;;$213CampoNumero$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="metodos feto 4">
         sb.append("\n296;;cadastrarLogica;;Indeterminado$$\n");
        sb.append("\n296;;cadastrarLogica;;Não imprimir;;Indeterminado$$\n");
        sb.append("\n296;;cadastrarLogica;;Não;;Ausente$$\n");
        sb.append("\n296;;cadastrarLogica;;Sim;;Presente$$\n");

        sb.append("\n314;;adicionarExcecao;;0.0;; Índice Umbilico/Cerebral (S/D)...: 0 (Normal: &lt 1.0)$$\n");
        sb.append("\n316;;adicionarExcecao;;0.0;;Índice Umbilico/Cerebral (I/R)...: 0 (Normal: &lt 1.0)$$\n");
        sb.append("\n318;;adicionarExcecao;;0.0;;Índice Umbilico/Cerebral (I/P)...: 0 (Normal: &lt 1.0)$$\n");

        sb.append("\n288;;adicionarExcecao;;0.0;;Média das Relações S/D...: ----$$\n");
        sb.append("\n290;;adicionarExcecao;;0.0;;Média dos Valores de IR...: ----$$\n");
        sb.append("\n292;;adicionarExcecao;;0.0;;Média dos Valores de IP...: ----$$\n");
        //ducto venoso
        sb.append("\n321;;adicionarOpcao;;presente$$\n");
        sb.append("321;;adicionarOpcao;;zero$$\n");
        sb.append("321;;adicionarOpcao;;reversa$$\n");

        //veia umbilical
        sb.append("\n326;;adicionarOpcao;;Fluxo contínuo$$\n");
        sb.append("326;;adicionarOpcao;;Fluxo pulsátil$$\n");
        //relação sd umbilical / cerebral
        sb.append("\n314;;cadastrarParametroFormula;;$299CampoNumero$$\n");
        sb.append("314;;cadastrarParametroFormula;;$300CampoNumero$$\n");
         //relacao ir umbilicar / ir cerebral
        sb.append("\n316;;cadastrarParametroFormula;;$302CampoNumero$$\n");
        sb.append("316;;cadastrarParametroFormula;;$303CampoNumero$$\n");
         //relacao ip umbilicar / ip cerebral
        sb.append("\n318;;cadastrarParametroFormula;;$305CampoNumero$$\n");
        sb.append("318;;cadastrarParametroFormula;;$306CampoNumero$$\n");

        //diástole umbilicar e cerebral
        sb.append("\n310;;adicionarOpcao;;presente$$\n");
        sb.append("310;;adicionarOpcao;;zero$$\n");
        sb.append("310;;adicionarOpcao;;reversa$$\n");

        sb.append("\n311;;adicionarOpcao;;presente$$\n");
        sb.append("311;;adicionarOpcao;;zero$$\n");
        sb.append("311;;adicionarOpcao;;reversa$$\n");

        //vincular relacao s/d e ir umbilicar e cerebral
        sb.append("299;;vincularHabAoValorDoCampo;;$310CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("300;;vincularHabAoValorDoCampo;;$311CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("302;;vincularHabAoValorDoCampo;;$310CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("303;;vincularHabAoValorDoCampo;;$311CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");

        //incisuras direita e esquerda
        sb.append("\n281;;adicionarOpcao;;Não$$\n");
        sb.append("281;;adicionarOpcao;;Sim$$\n");
        sb.append("282;;adicionarOpcao;;Não$$\n");
        sb.append("282;;adicionarOpcao;;Sim$$\n");
//       vincular ac com relação a incisura
        sb.append("284;;vincularHabAoValorDoCampo;;$281CampoDoLaudo;;false;;{Sim|Não}$$\n");
        sb.append("285;;vincularHabAoValorDoCampo;;$282CampoDoLaudo;;false;;{Sim|Não}$$\n");
//
//        //media a/c
        sb.append("\n294;;cadastrarParametroFormula;;$284CampoNumero$$\n");
        sb.append("\n294;;cadastrarParametroFormula;;$285CampoNumero$$\n");
//
//        //media i/p
        sb.append("\n292;;cadastrarParametroFormula;;$278CampoNumero$$\n");
        sb.append("292;;cadastrarParametroFormula;;$279CampoNumero$$\n");
//
//        //media i/r
        sb.append("\n290;;cadastrarParametroFormula;;$275CampoNumero$$\n");
        sb.append("290;;cadastrarParametroFormula;;$276CampoNumero$$\n");
//
//        //media s/d
        sb.append("\n288;;cadastrarParametroFormula;;$272CampoNumero$$\n");
        sb.append("288;;cadastrarParametroFormula;;$273CampoNumero$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="metodos feto 5">
         sb.append("\n356;;cadastrarLogica;;Indeterminado$$\n");
        sb.append("\n356;;cadastrarLogica;;Não imprimir;;Indeterminado$$\n");
        sb.append("\n356;;cadastrarLogica;;Não;;Ausente$$\n");
        sb.append("\n356;;cadastrarLogica;;Sim;;Presente$$\n");

        sb.append("\n374;;adicionarExcecao;;0.0;; Índice Umbilico/Cerebral (S/D)...: 0 (Normal: &lt 1.0)$$\n");
        sb.append("\n376;;adicionarExcecao;;0.0;;Índice Umbilico/Cerebral (I/R)...: 0 (Normal: &lt 1.0)$$\n");
        sb.append("\n378;;adicionarExcecao;;0.0;;Índice Umbilico/Cerebral (I/P)...: 0 (Normal: &lt 1.0)$$\n");

        sb.append("\n348;;adicionarExcecao;;0.0;;Média das Relações S/D...: ----$$\n");
        sb.append("\n350;;adicionarExcecao;;0.0;;Média dos Valores de IR...: ----$$\n");
        sb.append("\n352;;adicionarExcecao;;0.0;;Média dos Valores de IP...: ----$$\n");
        //ducto venoso
        sb.append("\n381;;adicionarOpcao;;presente$$\n");
        sb.append("381;;adicionarOpcao;;zero$$\n");
        sb.append("381;;adicionarOpcao;;reversa$$\n");

        //veia umbilical
        sb.append("\n386;;adicionarOpcao;;Fluxo contínuo$$\n");
        sb.append("386;;adicionarOpcao;;Fluxo pulsátil$$\n");
        //relação sd umbilical / cerebral
        sb.append("\n374;;cadastrarParametroFormula;;$359CampoNumero$$\n");
        sb.append("374;;cadastrarParametroFormula;;$360CampoNumero$$\n");
         //relacao ir umbilicar / ir cerebral
        sb.append("\n376;;cadastrarParametroFormula;;$362CampoNumero$$\n");
        sb.append("376;;cadastrarParametroFormula;;$363CampoNumero$$\n");
         //relacao ip umbilicar / ip cerebral
        sb.append("\n378;;cadastrarParametroFormula;;$365CampoNumero$$\n");
        sb.append("378;;cadastrarParametroFormula;;$366CampoNumero$$\n");

        //diástole umbilicar e cerebral
        sb.append("\n370;;adicionarOpcao;;presente$$\n");
        sb.append("370;;adicionarOpcao;;zero$$\n");
        sb.append("370;;adicionarOpcao;;reversa$$\n");

        sb.append("\n371;;adicionarOpcao;;presente$$\n");
        sb.append("371;;adicionarOpcao;;zero$$\n");
        sb.append("371;;adicionarOpcao;;reversa$$\n");

        //vincular relacao s/d e ir umbilicar e cerebral
        sb.append("359;;vincularHabAoValorDoCampo;;$370CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("360;;vincularHabAoValorDoCampo;;$371CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("362;;vincularHabAoValorDoCampo;;$370CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("363;;vincularHabAoValorDoCampo;;$371CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");

        //incisuras direita e esquerda
        sb.append("\n341;;adicionarOpcao;;Não$$\n");
        sb.append("341;;adicionarOpcao;;Sim$$\n");
        sb.append("342;;adicionarOpcao;;Não$$\n");
        sb.append("342;;adicionarOpcao;;Sim$$\n");
//       vincular ac com relação a incisura
        sb.append("344;;vincularHabAoValorDoCampo;;$341CampoDoLaudo;;false;;{Sim|Não}$$\n");
        sb.append("345;;vincularHabAoValorDoCampo;;$342CampoDoLaudo;;false;;{Sim|Não}$$\n");
//
//        //media a/c
        sb.append("\n354;;cadastrarParametroFormula;;$344CampoNumero$$\n");
        sb.append("\n354;;cadastrarParametroFormula;;$345CampoNumero$$\n");
//
//        //media i/p
        sb.append("\n352;;cadastrarParametroFormula;;$338CampoNumero$$\n");
        sb.append("352;;cadastrarParametroFormula;;$339CampoNumero$$\n");
//
//        //media i/r
        sb.append("\n350;;cadastrarParametroFormula;;$335CampoNumero$$\n");
        sb.append("350;;cadastrarParametroFormula;;$336CampoNumero$$\n");
//
//        //media s/d
        sb.append("\n348;;cadastrarParametroFormula;;$332CampoNumero$$\n");
        sb.append("348;;cadastrarParametroFormula;;$333CampoNumero$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="metodos feto 6">
         sb.append("\n416;;cadastrarLogica;;Indeterminado$$\n");
        sb.append("\n416;;cadastrarLogica;;Não imprimir;;Indeterminado$$\n");
        sb.append("\n416;;cadastrarLogica;;Não;;Ausente$$\n");
        sb.append("\n416;;cadastrarLogica;;Sim;;Presente$$\n");

        sb.append("\n434;;adicionarExcecao;;0.0;; Índice Umbilico/Cerebral (S/D)...: 0 (Normal: &lt 1.0)$$\n");
        sb.append("\n436;;adicionarExcecao;;0.0;;Índice Umbilico/Cerebral (I/R)...: 0 (Normal: &lt 1.0)$$\n");
        sb.append("\n438;;adicionarExcecao;;0.0;;Índice Umbilico/Cerebral (I/P)...: 0 (Normal: &lt 1.0)$$\n");

        sb.append("\n408;;adicionarExcecao;;0.0;;Média das Relações S/D...: ----$$\n");
        sb.append("\n410;;adicionarExcecao;;0.0;;Média dos Valores de IR...: ----$$\n");
        sb.append("\n412;;adicionarExcecao;;0.0;;Média dos Valores de IP...: ----$$\n");
        //ducto venoso
        sb.append("\n441;;adicionarOpcao;;presente$$\n");
        sb.append("441;;adicionarOpcao;;zero$$\n");
        sb.append("441;;adicionarOpcao;;reversa$$\n");

        //veia umbilical
        sb.append("\n446;;adicionarOpcao;;Fluxo contínuo$$\n");
        sb.append("446;;adicionarOpcao;;Fluxo pulsátil$$\n");
        //relação sd umbilical / cerebral
        sb.append("\n434;;cadastrarParametroFormula;;$419CampoNumero$$\n");
        sb.append("434;;cadastrarParametroFormula;;$420CampoNumero$$\n");
         //relacao ir umbilicar / ir cerebral
        sb.append("\n436;;cadastrarParametroFormula;;$422CampoNumero$$\n");
        sb.append("436;;cadastrarParametroFormula;;$423CampoNumero$$\n");
         //relacao ip umbilicar / ip cerebral
        sb.append("\n438;;cadastrarParametroFormula;;$425CampoNumero$$\n");
        sb.append("438;;cadastrarParametroFormula;;$426CampoNumero$$\n");

        //diástole umbilicar e cerebral
        sb.append("\n430;;adicionarOpcao;;presente$$\n");
        sb.append("430;;adicionarOpcao;;zero$$\n");
        sb.append("430;;adicionarOpcao;;reversa$$\n");

        sb.append("\n431;;adicionarOpcao;;presente$$\n");
        sb.append("431;;adicionarOpcao;;zero$$\n");
        sb.append("431;;adicionarOpcao;;reversa$$\n");

        //vincular relacao s/d e ir umbilicar e cerebral
        sb.append("419;;vincularHabAoValorDoCampo;;$430CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("420;;vincularHabAoValorDoCampo;;$431CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("422;;vincularHabAoValorDoCampo;;$430CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("423;;vincularHabAoValorDoCampo;;$431CampoDoLaudo;;false;;{presente|" + Enumeracao.NAO_IMPRIMIR + "}$$\n");

        //incisuras direita e esquerda
        sb.append("\n401;;adicionarOpcao;;Não$$\n");
        sb.append("401;;adicionarOpcao;;Sim$$\n");
        sb.append("402;;adicionarOpcao;;Não$$\n");
        sb.append("402;;adicionarOpcao;;Sim$$\n");
//       vincular ac com relação a incisura
        sb.append("404;;vincularHabAoValorDoCampo;;$401CampoDoLaudo;;false;;{Sim|Não}$$\n");
        sb.append("405;;vincularHabAoValorDoCampo;;$402CampoDoLaudo;;false;;{Sim|Não}$$\n");
//
//        //media a/c
        sb.append("\n414;;cadastrarParametroFormula;;$404CampoNumero$$\n");
        sb.append("\n414;;cadastrarParametroFormula;;$405CampoNumero$$\n");
//
//        //media i/p
        sb.append("\n412;;cadastrarParametroFormula;;$398CampoNumero$$\n");
        sb.append("412;;cadastrarParametroFormula;;$399CampoNumero$$\n");
//
//        //media i/r
        sb.append("\n410;;cadastrarParametroFormula;;$395CampoNumero$$\n");
        sb.append("410;;cadastrarParametroFormula;;$396CampoNumero$$\n");
//
//        //media s/d
        sb.append("\n408;;cadastrarParametroFormula;;$392CampoNumero$$\n");
        sb.append("408;;cadastrarParametroFormula;;$393CampoNumero$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="metodos restantes">

        sb.append("89;;setObrigatorio;;false$$\n");
        sb.append("149;;setObrigatorio;;false$$\n");
        sb.append("209;;setObrigatorio;;false$$\n");
        sb.append("269;;setObrigatorio;;false$$\n");
        sb.append("329;;setObrigatorio;;false$$\n");
        sb.append("389;;setObrigatorio;;false$$\n");
        sb.append("449;;setObrigatorio;;false$$\n");
        sb.append("54;;setObrigatorio;;false$$\n");
        sb.append("114;;setObrigatorio;;false$$\n");
        sb.append("174;;setObrigatorio;;false$$\n");
        sb.append("234;;setObrigatorio;;false$$\n");
        sb.append("294;;setObrigatorio;;false$$\n");
        sb.append("354;;setObrigatorio;;false$$\n");
        sb.append("414;;setObrigatorio;;false$$\n");
        sb.append("15;;setObrigatorio;;false$$\n");
        sb.append("17;;setObrigatorio;;false$$\n");
        sb.append("18;;setObrigatorio;;false$$\n");
        sb.append("16;;setObrigatorio;;false$$\n");
        sb.append("19;;setObrigatorio;;false$$\n");
        sb.append("20;;setObrigatorio;;false$$\n");
        sb.append("21;;setObrigatorio;;false$$\n");
        sb.append("22;;setObrigatorio;;false$$\n");
        sb.append("23;;setObrigatorio;;false$$\n");
        sb.append("24;;setObrigatorio;;false$$\n");
        sb.append("25;;setObrigatorio;;false$$\n");

         //dppPeloValorInformado
        sb.append("29;;cadastrarParamFormula;;$13CampoDoLaudo$$\n");
        sb.append("29;;cadastrarParamFormula;;$27CampoDoLaudo$$\n");
        sb.append("29;;cadastrarParamFormula;;$28CampoDoLaudo$$\n");
         //diasIghDum
        sb.append("\n18;;cadastrarParamFormula;;$13CampoDoLaudo$$\n");
        sb.append("18;;cadastrarParamFormula;;$15CampoDoLaudo$$\n");
         //semanaIghDum
        sb.append("\n17;;cadastrarParamFormula;;$13CampoDoLaudo$$\n");
        sb.append("17;;cadastrarParamFormula;;$15CampoDoLaudo$$\n");
         //diasIghUltEx
        sb.append("\n25;;cadastrarParamFormula;;$13CampoDoLaudo$$\n");
        sb.append("25;;cadastrarParamFormula;;$22CampoDoLaudo$$\n");
        //dppPeloUltEx
        sb.append("\n23;;cadastrarParamFormula;;$22CampoDoLaudo$$\n");
        //dppPelaDum
        sb.append("\n16;;cadastrarParamFormula;;$15CampoDoLaudo$$\n");
        //dumPeloUltEx
        sb.append("\n22;;cadastrarParamFormula;;$19CampoDoLaudo$$\n");
        sb.append("22;;cadastrarParamFormula;;$20CampoDoLaudo$$\n");
        sb.append("22;;cadastrarParamFormula;;$21CampoDoLaudo$$\n");
        //semanasIghUltEx
        sb.append("\n24;;cadastrarParamFormula;;$13CampoDoLaudo$$\n");
        sb.append("24;;cadastrarParamFormula;;$22CampoDoLaudo$$\n");

        //topicos
        sb.append("30;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("57;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("79;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("84;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("87;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");

        sb.append("90;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("117;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("139;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("144;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("147;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");

        sb.append("150;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("177;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("199;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("204;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("207;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");

        sb.append("210;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("237;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("259;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("264;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("267;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");

        sb.append("270;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("297;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("319;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("324;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("327;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)4|(/s)5|(/s)6}$$\n");

        sb.append("330;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)5|(/s)6}$$\n");
        sb.append("357;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)5|(/s)6}$$\n");
        sb.append("379;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)5|(/s)6}$$\n");
        sb.append("384;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)5|(/s)6}$$\n");
        sb.append("387;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)5|(/s)6}$$\n");

        sb.append("390;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)6}$$\n");
        sb.append("417;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)6}$$\n");
        sb.append("439;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)6}$$\n");
        sb.append("444;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)6}$$\n");
        sb.append("447;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)6}$$\n");

         //dados equipamento
        sb.append("\n2;;adicionarOpcao;;convexo$$\n");
        sb.append("2;;adicionarOpcao;;linear$$\n");
        sb.append("2;;adicionarOpcao;;endocavitário$$\n");
        sb.append("2;;adicionarOpcao;;descrever$$\n");
        sb.append("2;;adicionarExcecao;;descrever;;$$\n");
        sb.append("3;;vincularHabAoValorDoCampo;;$2CampoDoLaudo;;false;;{descrever}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados da gestação">

        //corionicidade
        sb.append("\n11;;adicionarOpcao;;monocoriônica$$\n");
        sb.append("11;;adicionarOpcao;;dicoriônica$$\n");
        sb.append("11;;adicionarOpcao;;tricoriônica$$\n");
        sb.append("11;;adicionarOpcao;;tetracoriônica$$\n");
        sb.append("11;;adicionarOpcao;;pentacoriônica$$\n");
        sb.append("11;;adicionarOpcao;;hexacoriônica$$\n");
        sb.append("11;;adicionarOpcao;;heptacoriônica$$\n");
        sb.append("11;;adicionarOpcao;;octacoriônica$$\n");

         //amniocidade
        sb.append("\n12;;adicionarOpcao;;monoamniótica$$\n");
        sb.append("12;;adicionarOpcao;;diamniótica$$\n");
        sb.append("12;;adicionarOpcao;;triamniótica$$\n");
        sb.append("12;;adicionarOpcao;;tetraamniótica$$\n");
        sb.append("12;;adicionarOpcao;;pentaamniótica$$\n");
        sb.append("12;;adicionarOpcao;;hexaamniótica$$\n");
        sb.append("12;;adicionarOpcao;;heptaamniótica$$\n");
        sb.append("12;;adicionarOpcao;;octaamniótica$$\n");

        // Descrição da gestacao
        sb.append("8;;setValor;;(/s)1$$\n");
        sb.append("6;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2}$$\n");
        sb.append("7;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("9;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("9;;cadastrarParametroFormula;;$8CampoNumero$$\n");
        sb.append("10;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("11;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("12;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");

        // </editor-fold>

        // </editor-fold>

        alterarModeloDeLaudo(8);

    }

    static void textoLivre () throws Exception
    {

        sb.append("\n0;;Topico;;;;").append(Topico.HTML_CAMPOS_FILHOS).append("$$\n");
        sb.append("1;;Linha$$\n");
        sb.append("2;;ImpressaoDiagnostica;;$$\n");

        sb.append("\n##\n");

        alterarModeloDeLaudo(27);

    }

    static void histeroscopia () throws Exception
    {

        sb.append("\n0;;Topico;;Dados técnicos$$\n");
        sb.append("\n1;;Linha$$\n");
        sb.append("2;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Paciente submetida à "
                + "Vídeo-Histeroscopia Diagnóstica com Histeroscópio tipo Hamou "
                + "II e distensão da cavidade endometrial com gás carbônico.</p>$$\n");
        sb.append("\n3;;Linha$$\n");
        sb.append("4;;Enumeracao;;$2$$\n");

        sb.append("\n5;;Topico;;Canal endocervical$$\n");
        sb.append("\n6;;Linha$$\n");
        sb.append("7;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">De dimensões, forma e superfície normais.</p>$$\n");
        sb.append("\n8;;Linha$$\n");
        sb.append("9;;Enumeracao;;$7$$\n");

        sb.append("\n10;;Topico;;Orifício interno do colo uterino$$\n");
        sb.append("\n11;;Linha$$\n");
        sb.append("12;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Normal.</p>$$\n");
        sb.append("\n13;;Linha$$\n");
        sb.append("14;;Enumeracao;;$12$$\n");

        sb.append("\n15;;Topico;;Cavidade endometrial$$\n");
        sb.append("\n16;;Linha$$\n");
        sb.append("17;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">De volume e forma normais. "
                + "Superfície endometrial de aspecto normal e condizente com o "
                + "período do ciclo menstrual.</p>$$\n");
        sb.append("\n18;;Linha$$\n");
        sb.append("19;;Enumeracao;;$17$$\n");

        sb.append("\n20;;Topico;;Óstios tubários$$\n");
        sb.append("\n21;;Linha$$\n");
        sb.append("22;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Visualizados e de características normais.</p>$$\n");
        sb.append("\n23;;Linha$$\n");
        sb.append("24;;Enumeracao;;$22$$\n");

        sb.append("\n25;;Topico;;Biópsia$$\n");
        sb.append("\n26;;Linha$$\n");
        sb.append("27;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Realizada biópsia para estudos clínicos.</p>$$\n");
        sb.append("\n28;;Linha$$\n");
        sb.append("29;;Enumeracao;;$27$$\n");

        sb.append("\n30;;Topico;;Procedimento realizado$$\n");
        sb.append("\n31;;Linha$$\n");
        sb.append("32;;CampoTexto;;$$\n");

        sb.append("\n33;;Topico;;Observações$$\n");
        sb.append("\n34;;Linha$$\n");
        sb.append("35;;CampoTexto;;$$\n");

        sb.append("\n36;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n37;;Linha$$\n");
        sb.append("38;;ImpressaoDiagnostica;;\n");
        sb.append("<p style=\"margin-top: 0\">Canal cervical e cavidade endometrial normais.</p>$$\n");
        sb.append("39;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("40;;Enumeracao;;$38CampoTexto$$\n");

        sb.append("\n##\n");

        sb.append("32;;setObrigatorio;;false$$\n");
        sb.append("35;;setObrigatorio;;false$$\n");

        sb.append("\n29;;adicionarOpcao;;Não realizada;;Não realizada.$$\n");

        alterarModeloDeLaudo(28);

    }

    static void endovaginalPelvica_AbdomenInferiorFeminino () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento">

        sb.append("\n0;;Topico;;Equipamento$$\n");
        //Equipamento
        sb.append("\n1;;Linha$$\n");
        sb.append("2;;Enumeracao;;").append("Exame realizado em modo bidimensional "
                                            + "com equipamento dinâmico ").
                append(identificador).append(" multifrequencial.;;true$$\n");

        // frequencia
        sb.append("3;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Bexiga">

        sb.append("\n4;;Topico;;Bexiga$$\n");
        sb.append("\n5;;Linha$$\n");
        //dados bexiga
        sb.append("6;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        //descrição geral bexiga
        sb.append("\n7;;Linha$$\n");
        sb.append("8;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vagina">

        sb.append("\n9;;Topico;;Vagina$$\n");
        sb.append("\n10;;Linha$$\n");
        //dados vagina
        sb.append("11;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        //descrição geral vagina
        sb.append("\n12;;Linha$$\n");
        sb.append("13;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Útero">

        sb.append("\n14;;Topico;;Útero$$\n");
        sb.append("\n15;;Linha$$\n");
        //situação
        sb.append("16;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        //posição
        sb.append("17;;Enumeracao;;").append(", ").append(CampoSimples.identificador).append("$$\n");
        //contornos
        sb.append("18;;Enumeracao;;").append(", de contornos ").append(CampoSimples.identificador).append("$$\n");
        //limites
        sb.append("19;;Enumeracao;;").append(" e limites ").append(CampoSimples.identificador).append(".$$\n");

        // long
        sb.append("\n20;;Linha$$\n");
        sb.append("21;;CampoDouble;;Medindo: " + identificador + ";;2$$\n");
        // anterior pos
        sb.append("22;;CampoDouble;; x " + identificador + ";;2$$\n");
        // transversal
        sb.append("23;;CampoDouble;; x " + identificador + " cm;;2$$\n");
        // massa
        sb.append("24;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        //volume
        sb.append("25;;CampoRpn;;C1 C2 C3 @").append(StaticInfo.FATOR_VOL_DIVERSOS).append("@ * * *;;");
        sb.append(", com volume de: " + identificador + " cm³.;;3$$\n");
        sb.append("26;;CampoLogicoTexto;; (Referência: " + CampoSimples.identificador + " cm³)$$\n");

        // textura miometrio
        sb.append("\n27;;Linha$$\n");
        sb.append("28;;Enumeracao;;").append("Miométrio de textura acústica ").append(CampoSimples.identificador).append(".$$\n");
        // Canal endocervical
        sb.append("\n29;;Linha$$\n");
        sb.append("30;;Enumeracao;;").append("Canal endocervical ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Descrição
        sb.append("\n31;;Linha$$\n");
        sb.append("32;;CampoTexto;;$$\n");

        // Endométrio
        sb.append("\n33;;Linha$$\n");
        //presença
        sb.append("34;;Enumeracao;;").append("Eco endometrial ").append(CampoSimples.identificador).append(";;true$$\n");
        //limites
        sb.append("35;;Enumeracao;;").append(", ").append(CampoSimples.identificador).append("$$\n");
        //contornos
        sb.append("36;;Enumeracao;;").append(", ").append(CampoSimples.identificador).append("$$\n");
        //aspecto
        sb.append("37;;Enumeracao;;").append(", ").append(CampoSimples.identificador).append(".$$\n");
        //espessura
        sb.append("\n38;;Linha$$\n");
        sb.append("39;;CampoDouble;;").append("Espessura do eco endometrial: ").append(CampoSimples.identificador).append(" mm.;;2$$\n");

        // Descrição
        sb.append("\n40;;Linha$$\n");
        sb.append("41;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovários">

        sb.append("\n42;;Topico;;Anexos$$\n");
        sb.append("\n43;;Linha$$\n");
        //posição ovário direito
        sb.append("44;;Enumeracao;;").append("Ovário direito ").append(CampoSimples.identificador).append(";;true$$\n");
        //contorno ovário direito
        sb.append("45;;Enumeracao;;").append(", de contornos ").append(CampoSimples.identificador).append("$$\n");
        //limites ovário direito
        sb.append("46;;Enumeracao;;").append(" e limites ").append(CampoSimples.identificador).append(".$$\n");

        sb.append("\n47;;Linha$$\n");
        // parênquima de textura  ovário direito
        sb.append("48;;Enumeracao;;").append("Exibindo parênquima de textura ").append(CampoSimples.identificador).append("$$\n");
        //superfície de textura  ovário direito
        sb.append("49;;Enumeracao;;").append(" e ").append(CampoSimples.identificador).append(".;;true$$\n");

        //long
        sb.append("\n50;;Linha$$\n");
        sb.append("51;;CampoDouble;;Medindo: " + identificador + ";;2$$\n");
        //anterior pos
        sb.append("52;;CampoDouble;; x " + identificador + ";;2$$\n");
        //transversal
        sb.append("53;;CampoDouble;; x " + identificador + " cm;;2$$\n");
        //massa
        sb.append("54;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        //volume
        sb.append("55;;CampoRpn;;C1 C2 C3 @").append(StaticInfo.FATOR_VOL_DIVERSOS).append("@ * * *;;");
        sb.append(", com volume de: " + identificador + " cm³.;;");
        sb.append("3$$\n");
        sb.append("56;;CampoLogicoTexto;; (Referência: " + CampoSimples.identificador + " cm³)$$\n");

        // Desscrição ovario direito
        sb.append("\n57;;Linha$$\n");
        sb.append("58;;CampoTexto;;\n");
        sb.append("$$\n");

        sb.append("\n59;;Linha$$\n");
        //posição ovário esquerdo
        sb.append("60;;Enumeracao;;").append("Ovário esquerdo ").append(CampoSimples.identificador).append(";;true$$\n");
        //contorno ovário esquerdo
        sb.append("61;;Enumeracao;;").append(", de contornos ").append(CampoSimples.identificador).append("$$\n");
        //limites ovário esquerdo
        sb.append("62;;Enumeracao;;").append(" e limites ").append(CampoSimples.identificador).append(".$$\n");

        sb.append("\n63;;Linha$$\n");
        // parênquima de textura  ovário esquerdo
        sb.append("64;;Enumeracao;;").append("Exibindo parênquima de textura ").append(CampoSimples.identificador).append("$$\n");
        //superfície de textura  ovário esquerdo
        sb.append("65;;Enumeracao;;").append(" e ").append(CampoSimples.identificador).append(".;;true$$\n");

        //long
        sb.append("\n66;;Linha$$\n");
        sb.append("67;;CampoDouble;;Medindo: " + identificador + ";;2$$\n");
        //anterior pos
        sb.append("68;;CampoDouble;; x " + identificador + ";;2$$\n");
        //transversal
        sb.append("69;;CampoDouble;; x " + identificador + " cm;;2$$\n");
        //massa
        sb.append("70;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        //volume
        sb.append("71;;CampoRpn;;C1 C2 C3 @").append(StaticInfo.FATOR_VOL_DIVERSOS).append("@ * * *;;");
        sb.append(", com volume de: " + identificador + " cm³.;;");
        sb.append("3$$\n");
        sb.append("72;;CampoLogicoTexto;; (Referência: " + CampoSimples.identificador + " cm³)$$\n");

        // Descrição ovário esquerdo
        sb.append("\n73;;Linha$$\n");
        sb.append("74;;CampoTexto;;\n");
        sb.append("$$\n");

        // Observações gerais dos ovários
        sb.append("\n75;;Linha$$\n");
        sb.append("76;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fundo de saco Douglas">

        sb.append("\n77;;Topico;;F.S.D$$\n");
        sb.append("\n78;;Linha$$\n");
        sb.append("79;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");

        //campo descrito  F.S.D
        sb.append("\n80;;Linha$$\n");
        sb.append("81;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        //faixa etária
        sb.append("\n82;;Enumeracao;;Faixa etária: ").append(CampoSimples.identificador).append(";;true$$\n");

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        //campo descrito  Observações gerais
        sb.append("\n83;;Topico;;Observações gerais$$\n");
        sb.append("\n84;;Linha$$\n");
        sb.append("85;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("\n86;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n87;;Linha$$\n");
        sb.append("88;;ImpressaoDiagnostica;;\n");
        sb.append("<p style=\"margin-top: 0\">Aspecto ecográfico pélvico normal.</p>\n");
        sb.append("$$\n");
        sb.append("\n89;;Linha$$\n");
        sb.append("90;;Enumeracao;;$88CampoTexto$$\n");

        // </editor-fold>

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Métodos">

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento">

        sb.append("\n2;;adicionarOpcao;;convexo$$\n");
        sb.append("2;;adicionarOpcao;;linear$$\n");
        sb.append("2;;adicionarOpcao;;endocavitário$$\n");
        sb.append("2;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("2;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("3;;vincularHabAoValorDoCampo;;$2CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Útero">

        // Situação
        sb.append("\n16;;adicionarOpcao;;anteversão;;Em anteversão$$\n");
        sb.append("16;;adicionarOpcao;;medioversão;;Em medioversão$$\n");
        sb.append("16;;adicionarOpcao;;RTV leve;;Em RTV leve$$\n");
        sb.append("16;;adicionarOpcao;;RTV moderada;;Em RTV moderada$$\n");
        sb.append("16;;adicionarOpcao;;RTV acentuada;;Em RTV acentuada$$\n");
        sb.append("16;;adicionarOpcao;;histerectomia;;Paciente totalmente histerectomizada.$$\n");
        sb.append("16;;adicionarOpcao;;histerectomia subtotal;;Paciente submetida à histerectomia subtotal.$$\n");
        sb.append("16;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("16;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        // Posição
        sb.append("\n17;;adicionarOpcao;;centrado$$\n");
        sb.append("17;;adicionarOpcao;;desviado para direita$$\n");
        sb.append("17;;adicionarOpcao;;desviado para esquerda$$\n");
        sb.append("17;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");

        // Contornos
        sb.append("\n18;;adicionarOpcao;;regulares$$\n");
        sb.append("18;;adicionarOpcao;;irregulares$$\n");
        sb.append("18;;adicionarOpcao;;lobulados$$\n");
        sb.append("18;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");

        // Limites
        sb.append("\n19;;adicionarOpcao;;precisos$$\n");
        sb.append("19;;adicionarOpcao;;imprecisos$$\n");
        sb.append("19;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");

        // Medidas
        sb.append("\n21;;setObrigatorio;;false$$\n");
        sb.append("\n22;;setObrigatorio;;false$$\n");
        sb.append("\n23;;setObrigatorio;;false$$\n");

        sb.append("\n21;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$22CampoDoLaudo|$23CampoDoLaudo}$$\n");
        sb.append("\n21;;setMsgErroValidCampoObrig;;Termine de informar as medidas do útero.$$\n");
        sb.append("\n22;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$21CampoDoLaudo|$23CampoDoLaudo}$$\n");
        sb.append("\n22;;setMsgErroValidCampoObrig;;Termine de informar as medidas do útero.$$\n");
        sb.append("\n23;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$21CampoDoLaudo|$22CampoDoLaudo}$$\n");
        sb.append("\n23;;setMsgErroValidCampoObrig;;Termine de informar as medidas do útero.$$\n");

        sb.append("21;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");
        sb.append("22;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");
        sb.append("23;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");

        sb.append("25;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");

        sb.append("32;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada|histerectomia|histerectomia subtotal|").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("32;;vincularObrigatorio;;$16CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Endométrio">

        // Presença
        sb.append("33;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{").
                append("anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada|"
                + CampoSimples.DIGITAR + "}$$\n");

        sb.append("\n34;;adicionarOpcao;;presente$$\n");
        sb.append("34;;adicionarOpcao;;ausente;;ausente.$$\n");
        sb.append("34;;adicionarOpcao;;não visualizado;;não visualizado.$$\n");
        sb.append("34;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("34;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        // Limites
        sb.append("\n35;;adicionarOpcao;;bem delimitado$$\n");
        sb.append("35;;adicionarOpcao;;mal delimitado$$\n");
        sb.append("35;;vincularHabAoValorDoCampo;;$34CampoDoLaudo;;false;;{presente}$$\n");

        // Contornos
        sb.append("\n36;;adicionarOpcao;;regular$$\n");
        sb.append("36;;adicionarOpcao;;irregular$$\n");
        sb.append("36;;adicionarOpcao;;mal visualizado$$\n");
        sb.append("36;;vincularHabAoValorDoCampo;;$34CampoDoLaudo;;false;;{presente}$$\n");

        // Aspecto
        sb.append("\n37;;adicionarOpcao;;linear e fino$$\n");
        sb.append("37;;adicionarOpcao;;trilaminar$$\n");
        sb.append("37;;adicionarOpcao;;ecogênico$$\n");
        sb.append("37;;adicionarOpcao;;isoecogênico$$\n");
        sb.append("37;;vincularHabAoValorDoCampo;;$34CampoDoLaudo;;false;;{presente}$$\n");

        // Espessura
        sb.append("39;;vincularHabAoValorDoCampo;;$34CampoDoLaudo;;false;;{presente}$$\n");

        // Descrição
        sb.append("41;;vincularHabAoValorDoCampo;;$34CampoDoLaudo;;false;;{presente|ausente|não visualizado|").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("41;;vincularObrigatorio;;$34CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovário direito">

        // Posição
        sb.append("\n44;;adicionarOpcao;;para-uterino$$\n");
        sb.append("44;;adicionarOpcao;;posterior$$\n");
        sb.append("44;;adicionarOpcao;;inferior$$\n");
        sb.append("44;;adicionarOpcao;;anterior$$\n");
        sb.append("44;;adicionarOpcao;;pélvico$$\n");
        sb.append("44;;adicionarOpcao;;não visualizado;;não visualizado.$$\n");
        sb.append("44;;adicionarOpcao;;justa-uterino$$\n");
        sb.append("44;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("44;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        // Contornos
        sb.append("\n45;;adicionarOpcao;;regulares$$\n");
        sb.append("45;;adicionarOpcao;;irregulares$$\n");
        sb.append("45;;vincularHabAoValorDoCampo;;$44CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Limites
        sb.append("\n46;;adicionarOpcao;;precisos$$\n");
        sb.append("46;;adicionarOpcao;;imprecisos$$\n");
        sb.append("46;;vincularHabAoValorDoCampo;;$44CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Parenquima
        sb.append("\n48;;adicionarOpcao;;mista$$\n");
        sb.append("48;;adicionarOpcao;;sólida$$\n");
        sb.append("48;;adicionarOpcao;;cística$$\n");
        sb.append("48;;adicionarOpcao;;sólido cística$$\n");
        sb.append("48;;adicionarOpcao;;múltiplos folículos subcorticais $$\n");
        sb.append("48;;vincularHabAoValorDoCampo;;$44CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Superficie
        sb.append("\n49;;adicionarOpcao;;ecogenicidade normal$$\n");
        sb.append("49;;adicionarOpcao;;ecogenicidade aumentada$$\n");
        sb.append("49;;vincularHabAoValorDoCampo;;$44CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Medidas
        sb.append("\n51;;setObrigatorio;;false$$\n");
        sb.append("\n52;;setObrigatorio;;false$$\n");
        sb.append("\n53;;setObrigatorio;;false$$\n");

        sb.append("\n51;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$52CampoDoLaudo|$53CampoDoLaudo}$$\n");
        sb.append("\n51;;setMsgErroValidCampoObrig;;Termine de informar as medidas do ovário direito.$$\n");
        sb.append("\n52;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$51CampoDoLaudo|$53CampoDoLaudo}$$\n");
        sb.append("\n52;;setMsgErroValidCampoObrig;;Termine de informar as medidas do ovário direito.$$\n");
        sb.append("\n53;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$51CampoDoLaudo|$52CampoDoLaudo}$$\n");
        sb.append("\n53;;setMsgErroValidCampoObrig;;Termine de informar as medidas do ovário direito.$$\n");

        //

        sb.append("55;;cadastrarParametroFormula;;$51CampoNumero$$\n");
        sb.append("55;;cadastrarParametroFormula;;$52CampoNumero$$\n");
        sb.append("55;;cadastrarParametroFormula;;$53CampoNumero$$\n");
        sb.append("51;;vincularHabAoValorDoCampo;;$44CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");
        sb.append("52;;vincularHabAoValorDoCampo;;$44CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");
        sb.append("53;;vincularHabAoValorDoCampo;;$44CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");
        sb.append("55;;vincularHabAoValorDoCampo;;$44CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Descrição
        sb.append("58;;vincularHabAoValorDoCampo;;$44CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino|").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("58;;vincularObrigatorio;;$44CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovário esquerdo">

        // Posição
        sb.append("\n60;;adicionarOpcao;;para-uterino$$\n");
        sb.append("60;;adicionarOpcao;;posterior$$\n");
        sb.append("60;;adicionarOpcao;;inferior$$\n");
        sb.append("60;;adicionarOpcao;;anterior$$\n");
        sb.append("60;;adicionarOpcao;;pélvico$$\n");
        sb.append("60;;adicionarOpcao;;não visualizado;;não visualizado.$$\n");
        sb.append("60;;adicionarOpcao;;justa-uterino$$\n");
        sb.append("60;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("60;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        // Contornos
        sb.append("\n61;;adicionarOpcao;;regulares$$\n");
        sb.append("61;;adicionarOpcao;;irregulares$$\n");
        sb.append("61;;vincularHabAoValorDoCampo;;$60CampoDoLaudo;;false;;{").append("para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Limites
        sb.append("\n62;;adicionarOpcao;;precisos$$\n");
        sb.append("62;;adicionarOpcao;;imprecisos$$\n");
        sb.append("62;;vincularHabAoValorDoCampo;;$60CampoDoLaudo;;false;;{").append("para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Parenquima
        sb.append("\n64;;adicionarOpcao;;mista$$\n");
        sb.append("64;;adicionarOpcao;;sólida$$\n");
        sb.append("64;;adicionarOpcao;;cística$$\n");
        sb.append("64;;adicionarOpcao;;sólido cística$$\n");
        sb.append("64;;adicionarOpcao;;múltiplos folículos subcorticais $$\n");
        sb.append("64;;vincularHabAoValorDoCampo;;$60CampoDoLaudo;;false;;{").append("para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Superficie
        sb.append("\n65;;adicionarOpcao;;ecogenicidade normal$$\n");
        sb.append("65;;adicionarOpcao;;ecogenicidade aumentada$$\n");
        sb.append("65;;vincularHabAoValorDoCampo;;$60CampoDoLaudo;;false;;{").append("para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Medidas
        sb.append("\n67;;setObrigatorio;;false$$\n");
        sb.append("\n68;;setObrigatorio;;false$$\n");
        sb.append("\n69;;setObrigatorio;;false$$\n");

        sb.append("\n67;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$68CampoDoLaudo|$69CampoDoLaudo}$$\n");
        sb.append("\n67;;setMsgErroValidCampoObrig;;Termine de informar as medidas do ovário esquerdo.$$\n");
        sb.append("\n68;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$67CampoDoLaudo|$69CampoDoLaudo}$$\n");
        sb.append("\n68;;setMsgErroValidCampoObrig;;Termine de informar as medidas do ovário esquerdo.$$\n");
        sb.append("\n69;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$67CampoDoLaudo|$68CampoDoLaudo}$$\n");
        sb.append("\n69;;setMsgErroValidCampoObrig;;Termine de informar as medidas do ovário esquerdo.$$\n");

        //

        sb.append("\n71;;cadastrarParametroFormula;;$67CampoNumero$$\n");
        sb.append("71;;cadastrarParametroFormula;;$68CampoNumero$$\n");
        sb.append("71;;cadastrarParametroFormula;;$69CampoNumero$$\n");
        sb.append("67;;vincularHabAoValorDoCampo;;$60CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");
        sb.append("68;;vincularHabAoValorDoCampo;;$60CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");
        sb.append("69;;vincularHabAoValorDoCampo;;$60CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");
        sb.append("71;;vincularHabAoValorDoCampo;;$60CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Descrição
        sb.append("74;;vincularHabAoValorDoCampo;;$60CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino|").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("74;;vincularObrigatorio;;$60CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fundo de saco Douglas">

        sb.append("\n79;;adicionarOpcao;;Livre$$\n");
        sb.append("79;;adicionarOpcao;;Com líquido livre$$\n");
        sb.append("79;;adicionarOpcao;;Livre com ecogenicidade aumentada$$\n");
        sb.append("79;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("79;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        // Descrição
        sb.append("81;;vincularHabAoValorDoCampo;;$79CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        sb.append("\n24;;setObrigatorio;;false$$\n");
        sb.append("\n54;;setObrigatorio;;false$$\n");
        sb.append("\n70;;setObrigatorio;;false$$\n");
        sb.append("\n76;;setObrigatorio;;false$$\n");
//        sb.append("\n79;;setObrigatorio;;false$$\n");
        sb.append("\n85;;setObrigatorio;;false$$\n");

        //faixa etária
        sb.append("\n82;;adicionarOpcao;;adulta (paridade 0)$$\n");
        sb.append("82;;adicionarOpcao;;adulta (paridade 1-2)$$\n");
        sb.append("82;;adicionarOpcao;;adulta (paridade 3)$$\n");
        sb.append("82;;adicionarOpcao;;adulta (paridade >4)$$\n");
        sb.append("82;;adicionarOpcao;;menopausa$$\n");
        sb.append("82;;adicionarOpcao;;adolescente$$\n");
        sb.append("82;;adicionarOpcao;;criança$$\n");
        sb.append("82;;adicionarOpcao;;indefinida$$\n");

        //textura Miometrio
        sb.append("\n28;;adicionarOpcao;;homogênea$$\n");
        sb.append("28;;adicionarOpcao;;heterogênea$$\n");
        sb.append("28;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{").append("anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");

        //canal Endocervical
        sb.append("\n30;;adicionarOpcao;;fechado$$\n");
        sb.append("30;;adicionarOpcao;;pérveo$$\n");
        sb.append("30;;adicionarOpcao;;com presença de múcuo$$\n");
        sb.append("30;;adicionarOpcao;;não se visualiza múcuo$$\n");
        sb.append("30;;adicionarOpcao;;dilatado com múcuo de 1 mm$$\n");
        sb.append("30;;adicionarOpcao;;dilatado com múcuo de 2 mm$$\n");
        sb.append("30;;adicionarOpcao;;dilatado com múcuo de 3 mm$$\n");
        sb.append("30;;adicionarOpcao;;dilatado com múcuo de 4 mm$$\n");
        sb.append("30;;adicionarOpcao;;dilatado com múcuo superior a 4 mm$$\n");
        sb.append("30;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{").append("anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");

        sb.append("25;;cadastrarParametroFormula;;$21CampoNumero$$\n");
        sb.append("25;;cadastrarParametroFormula;;$22CampoNumero$$\n");
        sb.append("25;;cadastrarParametroFormula;;$23CampoNumero$$\n");

        //dados bexiga
        sb.append("\n6;;adicionarOpcao;;normal;;Conteúdo anecoico, paredes lisas e bem delimitadas.$$\n");
        sb.append("6;;adicionarOpcao;;não visualizada;;Não visualizada.$$\n");
        sb.append("6;;adicionarOpcao;;reverberação;;Reverberação.$$\n");
        sb.append("6;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("8;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");

        //dados vagina
        sb.append("\n11;;adicionarOpcao;;normal;;Acusticamente normal.$$\n");
        sb.append("11;;adicionarOpcao;;Aumento da ecogenicidade luminar;;Aumento da ecogenicidade luminar.$$\n");
        sb.append("11;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("13;;vincularHabAoValorDoCampo;;$11CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");

        sb.append("26;;setCampos;;{$82CampoDoLaudo}$$\n");
        sb.append("56;;setCampos;;{$82CampoDoLaudo}$$\n");
        sb.append("72;;setCampos;;{$82CampoDoLaudo}$$\n");

        sb.append("26;;cadastrarLogica;;adulta (paridade 0);;25 a 90$$\n");
        sb.append("26;;cadastrarLogica;;adulta (paridade 1-2);;25 a 140$$\n");
        sb.append("26;;cadastrarLogica;;adulta (paridade 3);;25 a 160$$\n");
        sb.append("26;;cadastrarLogica;;adulta (paridade >4);;25 a 180$$\n");
        sb.append("26;;cadastrarLogica;;menopausa;;até 70$$\n");
        sb.append("26;;cadastrarLogica;;adolescente;;10 a 40$$\n");
        sb.append("26;;cadastrarLogica;;criança;;1 a 10$$\n");

        sb.append("56;;cadastrarLogica;;adulta (paridade 0);;3 a 12$$\n");
        sb.append("56;;cadastrarLogica;;adulta (paridade 1-2);;3 a 12$$\n");
        sb.append("56;;cadastrarLogica;;adulta (paridade 3);;3 a 12$$\n");
        sb.append("56;;cadastrarLogica;;adulta (paridade >4);;3 a 12$$\n");
        sb.append("56;;cadastrarLogica;;menopausa;;1 a 5$$\n");
        sb.append("56;;cadastrarLogica;;adolescente;;2 a 5$$\n");
        sb.append("56;;cadastrarLogica;;criança;;0,5 a 2$$\n");

        sb.append("72;;cadastrarLogica;;adulta (paridade 0);;3 a 12$$\n");
        sb.append("72;;cadastrarLogica;;adulta (paridade 1-2);;3 a 12$$\n");
        sb.append("72;;cadastrarLogica;;adulta (paridade 3);;3 a 12$$\n");
        sb.append("72;;cadastrarLogica;;adulta (paridade >4);;3 a 12$$\n");
        sb.append("72;;cadastrarLogica;;menopausa;;1 a 5$$\n");
        sb.append("72;;cadastrarLogica;;adolescente;;2 a 5$$\n");
        sb.append("72;;cadastrarLogica;;criança;;0,5 a 2$$\n");

        // </editor-fold>

        alterarModeloDeLaudo(32);
    }

}
