/*
 * M_Morfologico.java
 *
 * Created on 26/10/2012, 10:40:05
 */

package com.ic.projects.laudoecia.mdl;

import com.ic.projects.laudoecia.model.laudo.CampoLogico;
import com.ic.projects.laudoecia.model.laudo.CampoRpnData;
import com.ic.projects.laudoecia.model.laudo.CampoSimples;
import static com.ic.projects.laudoecia.model.laudo.CampoSimples.identificador;
import com.ic.projects.laudoecia.model.laudo.Enumeracao;
import com.ic.projects.laudoecia.model.laudo.Label;
import com.ic.projects.laudoecia.model.laudo.Linha;
import com.ic.projects.laudoecia.model.laudo.LinhaDaTbl;
import com.ic.projects.laudoecia.model.laudo.Topico;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class M_Morfologico extends Model
{

    public static void main (String[] args) throws Exception
    {
        morfologicoFetal();
        obs14semanasComRef();
//        formatarStrMdl();
    }

    static void morfologicoFetal () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Contrutores">

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento">

        sb.append("\n0;;Topico;;Equipamento$$\n");
        sb.append("1;;Linha$$\n");
        sb.append("2;;Enumeracao;;").append("Exame realizado em modo bidimensional "
                                            + "com equipamento dinâmico ").
                append(identificador).append(" multifrequencial.;;true$$\n");

        sb.append("3;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Idade gestacional">

        //label data do exame
        sb.append("4;;Label;;").append(Label.DATA_DO_EXAME).append(";;false$$\n");
        //dum
        sb.append("5;;CampoDate;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        //dppPelaDum
        sb.append("6;;CampoRpnData;;").append(CampoSimples.NAO_IMPRIMIVEL).append(
                ";;C1 280 ").append(CampoRpnData.UM_DIA_EM_MS).append(" * +$$\n");
        //dataUltEx
        sb.append("7;;CampoDate;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        //semUltEx
        sb.append("8;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;2$$\n");
        //diasUltEx
        sb.append("9;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;1$$\n");

        //dumPeloUltEx
        sb.append("10;;CampoRpnData;;").append(CampoSimples.NAO_IMPRIMIVEL).append(
                ";;C1 C2 ").append(CampoRpnData.UM_DIA_EM_MS).append(" 7 * * - C3 ")
                .append(CampoRpnData.UM_DIA_EM_MS).append(" * -$$\n");

        //dppPeloUltEx
        sb.append("11;;CampoRpnData;;").append(CampoSimples.NAO_IMPRIMIVEL).append(
                ";;C1 280 ").append(CampoRpnData.UM_DIA_EM_MS).append(" * +$$\n");

        //semanasIghUltEx
        sb.append("12;;CampoRpnData;;").append(CampoSimples.NAO_IMPRIMIVEL).append(
                ";;C1 C2 - ").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 /$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Estática Fetal">

        sb.append("\n13;;Topico;;Estática fetal$$\n");
        //situação
        sb.append("\n14;;Linha$$\n");
        sb.append("15;;Enumeracao;;Feto em situação ").append(CampoSimples.identificador).append(";;true$$\n");
        //apresentação
        sb.append("16;;Enumeracao;;, apresentação ").append(CampoSimples.identificador).append("$$\n");
        //dorso
        sb.append("17;;Enumeracao;;, dorso ").append(CampoSimples.identificador).append(".$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Crânio Fetal e S.N.C">

        sb.append("\n18;;Topico;;Crânio fetal e S.N.C.$$\n");
        sb.append("19;;Linha$$\n");
        sb.append("20;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Polo cefálico identificado, apresentando calota craniana de contorno normal.\n");
        sb.append("</p><p style=\"margin-top: 0\">Foice cerebral presente e simétrica.\n");
        sb.append("</p><p style=\"margin-top: 0\">Relação ventrículo / hemisfério cerebral normal para a idade gestacional.\n");
        sb.append("</p><p style=\"margin-top: 0\">Plexos coroides visualizados, sendo de aspectos homogêneos e ecogênicos, \n"
                  + "moldando as paredes ventriculares, sem imagens de cistos em seu interior.\n");
        sb.append("</p><p style=\"margin-top: 0\">Tálamos e cavum do septo pelúcido identificados e normais.\n");
        sb.append("</p><p style=\"margin-top: 0\">Fossa posterior ocupada pelo cerebelo, onde se visualiza adequadamente seus \n"
                  + "hemisférios e vermix cerebelar, fissura inter-hemisférica visível.\n");
        sb.append("</p><p style=\"margin-top: 0\">Cisterna magna visível e normal.</p>$$\n");
        sb.append("\n21;;Linha$$\n");
        sb.append("22;;Enumeracao;;$20$$\n");

        //diametro Ventricular
        sb.append("\n23;;Linha$$\n");
        sb.append("24;;CampoInteiro;;Diâmetro ventricular: " + CampoSimples.identificador + " mm (Referência: menor que 10 mm).;;2$$\n");
        //D.B.P (mm)
        sb.append("\n25;;Linha$$\n");
        sb.append("26;;CampoInteiro;;Diâmetro biparietal: " + CampoSimples.identificador + " mm.;;3$$\n");
        //D.O.F (mm):
        sb.append("\n27;;Linha$$\n");
        sb.append("28;;CampoInteiro;;Diâmetro occiptofrontal: " + CampoSimples.identificador + " mm.;;3$$\n");
        //diametro cisterna Magma
        sb.append("\n29;;Linha$$\n");
        sb.append("30;;CampoInteiro;;Cisterna magna: " + CampoSimples.identificador + " mm.;;2$$\n");
        //diametro Transversal Cerebelo
        sb.append("\n31;;Linha$$\n");
        sb.append("32;;CampoInteiro;;Diâmetro transversal cerebelar: " + CampoSimples.identificador + " mm.;;2$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Face Fetal">

        sb.append("\n33;;Topico;;Face fetal$$\n");
        sb.append("\n34;;Linha$$\n");
        sb.append("35;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Presença de 02 (duas) órbitas de aspectos normais, com distância interorbitária normal.\n");
        sb.append("</p><p style=\"margin-top: 0\">Não observamos solução de descontinuidade em região labial.\n");
        sb.append("</p><p style=\"margin-top: 0\">Perfil fetal identificado, de aspecto normal.\n");
        sb.append("</p><p style=\"margin-top: 0\">Ossos faciais (osso nasal, palato e mandíbula) identificados.</p>\n");
        sb.append("$$\n");
        sb.append("\n36;;Linha$$\n");
        sb.append("37;;Enumeracao;;$35$$\n");

        //diametro distancia Orbitaria
        sb.append("\n38;;Linha$$\n");
        sb.append("39;;CampoInteiro;;Distância interorbitária: " + CampoSimples.identificador + " mm.;;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pescoço Fetal">

        sb.append("\n40;;Topico;;Pescoço fetal$$\n");
        sb.append("\n41;;Linha$$\n");
        sb.append("42;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Ausência de edema ou massas císticas.</p>$$\n");
        sb.append("\n43;;Linha$$\n");
        sb.append("44;;Enumeracao;;$42$$\n");

        //diametro Prega nucal
        sb.append("\n45;;Linha$$\n");
        sb.append("46;;CampoInteiro;;Prega nucal: " + CampoSimples.identificador + " mm (Referência: menor que 6 mm).;;2$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Coluna Fetal">

        sb.append("\n47;;Topico;;Coluna fetal$$\n");
        sb.append("\n48;;Linha$$\n");
        sb.append("49;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Observada a coluna em toda a sua extensão, desde a região cervical à \n"
                  + "região sacral, em cortes transversais e longitudinais, com canal medular \n"
                  + "íntegro e fechado em toda a sua extensão.</p>$$\n");
        sb.append("\n50;;Linha$$\n");
        sb.append("51;;Enumeracao;;$49$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tórax">

        sb.append("\n52;;Topico;;Tórax$$\n");
        sb.append("\n53;;Linha$$\n");
        sb.append("54;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Parede anterior do tórax fechada e normal.\n");
        sb.append("</p><p style=\"margin-top: 0\">Áreas pulmonares de aspecto homogêneo e habitual.\n");
        sb.append("</p><p style=\"margin-top: 0\">Músculo do diafragma identificado.</p>$$\n");
        sb.append("\n55;;Linha$$\n");
        sb.append("56;;Enumeracao;;$54$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Coração">

        sb.append("\n57;;Topico;;Coração$$\n");
        sb.append("\n58;;Linha$$\n");
        sb.append("59;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Plano de 4 câmaras (átrios direito e esquerdo, ventrículos direito e esquerdo).\n");
        sb.append("</p><p style=\"margin-top: 0\">Conexões átrio ventriculares adequadas.\n");
        sb.append("</p><p style=\"margin-top: 0\">Septo inter ventricular e inter atrial visualizados.\n");
        sb.append("</p><p style=\"margin-top: 0\">Forame oval e flap identificados ao nível do átrio esquerdo.\n");
        sb.append("</p><p style=\"margin-top: 0\">Saída da aorta (arco aórtico) e saída da pulmonar (arco pulmonar).</p>$$\n");
        sb.append("\n60;;Linha$$\n");
        sb.append("61;;Enumeracao;;$59$$\n");

        //ritmia
        sb.append("\n62;;Linha;;Batimentos cardíacos fetais").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("63;;Enumeracao;; ").append(CampoSimples.identificador).append(";;true$$\n");
        //diametro batimentos Cardiacos
        sb.append("64;;CampoInteiro;; de " + CampoSimples.identificador + " batimentos/minuto;;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Abdome Fetal">

        sb.append("\n65;;Topico;;Abdome fetal$$\n");
        sb.append("66;;Linha$$\n");
        sb.append("67;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Andar superior do abdome fetal identificados: estômago e veia umbilical.\n");
        sb.append("</p><p style=\"margin-top: 0\">Inserção do cordão umbilical identificado ao nível da parede abdominal anterior.\n");
        sb.append("</p><p style=\"margin-top: 0\">Alças intestinais de aspecto normal para a idade.</p>$$\n");
        sb.append("\n68;;Linha$$\n");
        sb.append("69;;Enumeracao;;$67$$\n");

        //C.A (mm):
        sb.append("\n70;;Linha$$\n");
        sb.append("71;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        sb.append("72;;CampoRpn;;1.57 C1 C2 + *;;Circunferência abdominal de " + CampoSimples.identificador + " mm.;;0$$\n");
        sb.append("73;;CampoInteiro;;Circunferência abdominal de " + CampoSimples.identificador + " mm.;;3$$\n");

        //D.A.P (mm):
        sb.append("74;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");
        //D.L.L (mm);
        sb.append("75;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vias Urinárias">

        sb.append("\n76;;Topico;;Vias urinárias$$\n");
        sb.append("\n77;;Linha$$\n");
        sb.append("78;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Lojas renais visualizadas,"
                + " sem sinais de hidronefrose.</p>$$\n");
        sb.append("\n79;;Linha$$\n");
        sb.append("80;;Enumeracao;;$78$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Cálculos diversos">

        //ic:
        sb.append("81;;CampoRpn;;C1 100 * C2 /;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //cc:
        sb.append("82;;CampoRpn;;C1 C2 + 2 / pi * 1.013 *;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //ccDivca:
        sb.append("83;;CampoRpn;;C1 C2 /;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //cfDivca:
        sb.append("84;;CampoRpn;;C1 100 * C2 /;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");

        sb.append("85;;CampoDate;;" + CampoSimples.NAO_IMPRIMIVEL + "$$\n");
        sb.append("86;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        sb.append("87;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL + ";;1$$\n");

        //dpp informada
        sb.append("88;;CampoRpnData;;" + CampoSimples.NAO_IMPRIMIVEL + ";;C1 280 "
                  + CampoRpnData.UM_DIA_EM_MS + " * +$$\n");

        //ddpPeloUltEx
        sb.append("89;;CampoRpnData;;" + CampoSimples.NAO_IMPRIMIVEL + ";;C1 C2 "
                  + CampoRpnData.UM_DIA_EM_MS + " 7 * * - C3 "
                  + CampoRpnData.UM_DIA_EM_MS + " * -$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Membros Fetais">

        sb.append("\n90;;Topico;;Membros fetais$$\n");
        sb.append("\n91;;Linha$$\n");
        sb.append("92;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Membros superiores identificados, visualizando: úmero, ulna, rádios direito e esquerdo.");
        sb.append("</p><p style=\"margin-top: 0\">Mãos de aspecto normal.");
        sb.append("</p><p style=\"margin-top: 0\">Membros inferiores identificados, visualizando: fêmur, fíbula, tíbias direita e esquerda.");
        sb.append("</p><p style=\"margin-top: 0\">Pés de aspecto normal.</p>\n$$\n");
        sb.append("\n93;;Linha$$\n");
        sb.append("94;;Enumeracao;;$92$$\n");

        //umero (mm):
        sb.append("\n95;;Linha$$\n");
        sb.append("96;;CampoInteiro;;Comprimento do úmero: " + CampoSimples.identificador + " mm.;;3$$\n");
        //ulna (mm):
        sb.append("\n97;;Linha$$\n");
        sb.append("98;;CampoInteiro;;Comprimento da ulna: " + CampoSimples.identificador + " mm.;;3$$\n");
        //tibia (mm):
        sb.append("\n99;;Linha$$\n");
        sb.append("100;;CampoInteiro;;Comprimento da tíbia: " + CampoSimples.identificador + " mm.;;3$$\n");
        //fibula (mm):
        sb.append("\n101;;Linha$$\n");
        sb.append("102;;CampoInteiro;;Comprimento da fíbula: " + CampoSimples.identificador + " mm.;;3$$\n");
        //radio (mm):
        sb.append("\n103;;Linha$$\n");
        sb.append("104;;CampoInteiro;;Comprimento do rádio: " + CampoSimples.identificador + " mm.;;3$$\n");
        //C.F (mm)
        sb.append("\n105;;Linha$$\n");
        sb.append("106;;CampoInteiro;;Comprimento do fêmur: " + CampoSimples.identificador + " mm.;;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        sb.append("\n107;;Topico;;Placenta$$\n");
        //inserção 1
        sb.append("\n108;;Linha$$\n");
        sb.append("109;;Enumeracao;;").append("De inserção ").append(CampoSimples.identificador).append(";;true$$\n");
        //insercao 2
        sb.append("110;;Enumeracao;;").append(" ").append(CampoSimples.identificador).append(".$$\n");
        //espessura
        sb.append("\n111;;Linha$$\n");
        sb.append("112;;CampoInteiro;;Espessura: " + CampoSimples.identificador + " mm.;;3$$\n");
        //maturidade
        sb.append("\n113;;Linha$$\n");
        sb.append("114;;Enumeracao;;").append("Apresentando ").append(CampoSimples.identificador).append(" (GRANNUM 0, 1, 2, 3).$$\n");

        // Descrição
        sb.append("\n115;;Linha$$\n");
        sb.append("116;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        sb.append("\n117;;Topico;;Outras informações$$\n");

        // Sexo provavel
        sb.append("\n118;;Linha$$\n");
        sb.append("119;;Enumeracao;;").append("Sexo fetal provável: ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Estatura
        sb.append("\n120;;Linha$$\n");
        sb.append("121;;CampoRpn;;C1 0.55 *;;Estatura fetal: " + CampoSimples.identificador + " cm.;;2$$\n");

        // Peso
        sb.append("\n122;;Linha$$\n");
        sb.append("123;;CampoRpn;;10 -1.7492 .0166 C1 * + .0046 C2 * + 2.646 C1 C2 * 100000 / * - ^ 1000 *"
                  + ";;Peso fetal estimado: " + CampoSimples.identificador + " g (±10%).;;0$$\n");

        // Cordão umbilical
        sb.append("\n124;;Linha$$\n");
        sb.append("125;;Enumeracao;;Cordão umbilical: ").append(CampoSimples.identificador).append(";;true$$\n");

        // Liquido amniótico
        sb.append("\n126;;Linha$$\n");
        sb.append("127;;Enumeracao;;Líquido amniótico: ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Canal endocervical
        sb.append("\n128;;Linha$$\n");
        sb.append("129;;Enumeracao;;Canal endocervical: ").append(CampoSimples.identificador).append(".;;true$$\n");

        // ILA

        //quadrante 1
        sb.append("130;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");

        //quadrante 2
        sb.append("131;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");

        //quadrante 3
        sb.append("132;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");

        //quadrante 4
        sb.append("133;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");

        // Soma
        sb.append("\n134;;Linha$$\n");
        sb.append("135;;CampoRpn;;C1 C2 C3 C4 + + +;;Índice do líquido amniótico: " + CampoSimples.identificador + " cm ;;2$$\n");
        sb.append("136;;CampoLogico;;$135CampoNumero;;" + CampoSimples.identificador + "$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("\n137;;Topico;;Observações gerais$$\n");
        sb.append("\n138;;Linha$$\n");
        sb.append("139;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Desvio padrao">

        sb.append("\n140;;Linha$$\n");
        sb.append("141;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("\n142;;Topico;;Impressão diagnóstica$$\n");

        // Descrição
        sb.append("\n143;;Linha;;Gravidez tópica de feto único").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        // Semanas IGH
        sb.append("144;;CampoInteiro;; de ").append(CampoSimples.identificador).append(" semana(s);;2$$\n");
        // Dias IGH
        sb.append("145;;CampoInteiro;;").append(" e ").append(CampoSimples.identificador).append(" dia(s);;1$$\n");

        sb.append("146;;CampoLogico;; (± " + identificador + " semana(s))$$\n");
        sb.append("147;;CampoDouble;; (± " + CampoSimples.identificador + " semana(s));;1$$\n");

        sb.append("\n148;;Linha$$\n");
        sb.append("149;;ImpressaoDiagnostica;;\n");
        sb.append("<p style=\"margin-top: 0\">Estudo morfológico fetal normal,"
                  + " biometria e relações biométricas fetais normais,"
                  + " ausência de marcadores ecográficos de cromossomopatias.</p>$$\n");
        sb.append("\n150;;Linha$$\n");
        sb.append("151;;Enumeracao;;$149CampoTexto$$\n");
        sb.append("\n152;;Linha$$\n");
        //semanas dum
        sb.append("153;;CampoRpnData;;Tempo de amenorreia: ").append(CampoSimples.identificador).append(";;C1 C2 - "
                                                                                                                   + "").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 /$$\n");
        //diasIghDum
        sb.append("154;;CampoRpnData;; semana(s) e ").append(CampoSimples.identificador).append(" dia(s).;;C1 C2 - "
                                                                                                         + "").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 %$$\n");
        //dppPeloValorInformado
        sb.append("155;;CampoRpnData;;").append(" Data aproximada do parto: " + CampoSimples.identificador + " (± 1,0 sem).").append(";;C1 280 "
                                                                                    + "").append(CampoRpnData.UM_DIA_EM_MS).append(" * + C2 7 ").append(CampoRpnData.UM_DIA_EM_MS).append(" * * - C3 ").append(CampoRpnData.UM_DIA_EM_MS).append(" * -$$\n");
        //diasIghUltEx
        sb.append("156;;CampoRpnData;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;C1 C2 - "
                                                                                    + "").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 %$$\n");
        // dias totais da igh informado pelo usuario
        sb.append("157;;CampoRpn;;C1 7 * C2 +;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;0$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="IGH pela biometria">

        // Fêmur
        sb.append("158;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$106CampoDoLaudo}$$\n");
        // Úmero
        sb.append("159;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$96CampoDoLaudo}$$\n");
        // Ulna
        sb.append("160;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$98CampoDoLaudo}$$\n");
        // Tíbia
        sb.append("161;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$100CampoDoLaudo}$$\n");
        // Fíbula
        sb.append("162;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$102CampoDoLaudo}$$\n");
        // Rádio
        sb.append("163;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$104CampoDoLaudo}$$\n");

        // D.B.P.
        sb.append("164;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$26CampoDoLaudo}$$\n");

        // C.A.
        sb.append("165;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$72CampoDoLaudo|$73CampoDoLaudo}$$\n");

        // C.C.
        sb.append("166;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$82CampoDoLaudo}$$\n");

        // </editor-fold>

        // </editor-fold>

        sb.append("167;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Metodos">

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento">

        sb.append("\n2;;adicionarOpcao;;convexo$$\n");
        sb.append("2;;adicionarOpcao;;linear$$\n");
        sb.append("2;;adicionarOpcao;;endocavitário$$\n");
        sb.append("2;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("2;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("3;;vincularHabAoValorDoCampo;;$2CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        // Insercao
        sb.append("\n109;;adicionarOpcao;;tópica$$\n");
        sb.append("109;;adicionarOpcao;;heterotópica$$\n");
        sb.append("109;;adicionarOpcao;;prévia marginal$$\n");
        sb.append("109;;adicionarOpcao;;prévia centro parcial$$\n");
        sb.append("109;;adicionarOpcao;;prévia centro total$$\n");
        sb.append("109;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("109;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        // Insercao 2
        sb.append("\n110;;adicionarOpcao;;anterior$$\n");
        sb.append("110;;adicionarOpcao;;posterior$$\n");
        sb.append("110;;adicionarOpcao;;fúndica$$\n");
        sb.append("110;;adicionarOpcao;;fúndica anterior$$\n");
        sb.append("110;;adicionarOpcao;;fúndica posterior$$\n");
        sb.append("110;;adicionarOpcao;;anterior lateral direita$$\n");
        sb.append("110;;adicionarOpcao;;anterior lateral esquerda$$\n");
        sb.append("110;;adicionarOpcao;;posterior lateral direita$$\n");
        sb.append("110;;adicionarOpcao;;posterior lateral esquerda$$\n");
        sb.append("110;;vincularHabAoValorDoCampo;;$109CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro total|prévia centro parcial}$$\n");

        // Espessura
        sb.append("112;;vincularHabAoValorDoCampo;;$109CampoDoLaudo;;false;;{tópica|heterotópica|prévia centro parcial|prévia centro total|prévia marginal}$$\n");

        // Maturidade
        sb.append("\n114;;adicionarOpcao;;grau 0;;textura homogênea e maturidade grau 0$$\n");
        sb.append("114;;adicionarOpcao;;grau 1;;textura homogênea e maturidade grau 1$$\n");
        sb.append("114;;adicionarOpcao;;grau 2;;textura homogênea e maturidade grau 2$$\n");
        sb.append("114;;adicionarOpcao;;grau 3;;maturidade grau 3$$\n");
        sb.append("114;;vincularHabAoValorDoCampo;;$109CampoDoLaudo;;false;;{tópica|heterotópica|prévia centro parcial|prévia centro total|prévia marginal}$$\n");
        sb.append("114;;setComecarDoZero;;").append(Enumeracao.COMECAR_DO_ZERO_SIM).append("$$\n");

        // Descrição
        sb.append("116;;vincularObrigatorio;;$109CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("116;;vincularHabAoValorDoCampo;;$109CampoDoLaudo;;false;;{tópica|heterotópica|prévia centro parcial|prévia centro total|prévia marginal|").append(CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Abdome fetal">

        sb.append("\n71;;adicionarOpcao;;informar$$\n");
        sb.append("71;;adicionarOpcao;;calcular$$\n");
        sb.append("71;;setValor;;informar$$\n");

        // c.a. calculado
        sb.append("\n72;;cadastrarParametroFormula;;$74CampoNumero$$\n");
        sb.append("72;;cadastrarParametroFormula;;$75CampoNumero$$\n");
        sb.append("72;;vincularHabAoValorDoCampo;;$71CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("73;;vincularHabAoValorDoCampo;;$71CampoDoLaudo;;false;;{informar}$$\n");

        sb.append("74;;vincularHabAoValorDoCampo;;$71CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("75;;vincularHabAoValorDoCampo;;$71CampoDoLaudo;;false;;{calcular}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="IGH pela biometria">

        // <editor-fold defaultstate="collapsed" desc="Fêmur">

        sb.append("158;;cadastrarLogica;;0,0->7,1;;<12,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;7,1->8,1;;12,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;8,1->9,1;;12,33 semanas$$\n");
        sb.append("158;;cadastrarLogica;;9,1->10,1;;12,67 semanas$$\n");
        sb.append("158;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("158;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("158;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("158;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("158;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("158;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("158;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;20,1->21,1;;16,33 semanas$$\n");
        sb.append("158;;cadastrarLogica;;21,1->22,1;;16,67 semanas$$\n");
        sb.append("158;;cadastrarLogica;;22,1->23,1;;17,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;23,1->24,1;;17,50 semanas$$\n");
        sb.append("158;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("158;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("158;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;28,1->29,1;;19,33 semanas$$\n");
        sb.append("158;;cadastrarLogica;;29,1->30,1;;19,67 semanas$$\n");
        sb.append("158;;cadastrarLogica;;30,1->31,1;;20,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;31,1->32,1;;20,33 semanas$$\n");
        sb.append("158;;cadastrarLogica;;32,1->33,1;;20,67 semanas$$\n");
        sb.append("158;;cadastrarLogica;;33,1->34,1;;21,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;34,1->35,1;;21,50 semanas$$\n");
        sb.append("158;;cadastrarLogica;;35,1->36,1;;22,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;36,1->37,1;;22,33 semanas$$\n");
        sb.append("158;;cadastrarLogica;;37,1->38,1;;22,67 semanas$$\n");
        sb.append("158;;cadastrarLogica;;38,1->39,1;;23,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;39,1->40,1;;23,33 semanas$$\n");
        sb.append("158;;cadastrarLogica;;40,1->41,1;;23,67 semanas$$\n");
        sb.append("158;;cadastrarLogica;;41,1->42,1;;24,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;42,1->43,1;;24,50 semanas$$\n");
        sb.append("158;;cadastrarLogica;;43,1->44,1;;25,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;44,1->45,1;;25,33 semanas$$\n");
        sb.append("158;;cadastrarLogica;;45,1->46,1;;25,67 semanas$$\n");
        sb.append("158;;cadastrarLogica;;46,1->47,1;;26,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;47,1->48,1;;26,50 semanas$$\n");
        sb.append("158;;cadastrarLogica;;48,1->49,1;;27,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;49,1->50,1;;27,33 semanas$$\n");
        sb.append("158;;cadastrarLogica;;50,1->51,1;;27,67 semanas$$\n");
        sb.append("158;;cadastrarLogica;;51,1->52,1;;28,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;52,1->53,1;;28,50 semanas$$\n");
        sb.append("158;;cadastrarLogica;;53,1->54,1;;29,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;54,1->55,1;;29,50 semanas$$\n");
        sb.append("158;;cadastrarLogica;;55,1->56,1;;30,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;56,1->57,1;;30,33 semanas$$\n");
        sb.append("158;;cadastrarLogica;;57,1->58,1;;30,67 semanas$$\n");
        sb.append("158;;cadastrarLogica;;58,1->59,1;;31,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;59,1->60,1;;31,50 semanas$$\n");
        sb.append("158;;cadastrarLogica;;60,1->61,1;;32,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;61,1->62,1;;32,50 semanas$$\n");
        sb.append("158;;cadastrarLogica;;62,1->63,1;;33,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;63,1->64,1;;33,50 semanas$$\n");
        sb.append("158;;cadastrarLogica;;64,1->65,1;;34,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;65,1->66,1;;34,50 semanas$$\n");
        sb.append("158;;cadastrarLogica;;66,1->67,1;;35,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;67,1->68,1;;36,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;68,1->69,1;;36,50 semanas$$\n");
        sb.append("158;;cadastrarLogica;;69,1->70,1;;37,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;70,1->71,1;;38,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;71,1->72,1;;38,50 semanas$$\n");
        sb.append("158;;cadastrarLogica;;72,1->73,1;;39,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;73,1->74,1;;40,00 semanas$$\n");
        sb.append("158;;cadastrarLogica;;74,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Úmero">

        sb.append("159;;cadastrarLogica;;0,0->8,1;;<12,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;8,1->9,1;;12,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;9,1->10,1;;12,50 semanas$$\n");
        sb.append("159;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("159;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("159;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("159;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("159;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("159;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("159;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;20,1->21,1;;16,50 semanas$$\n");
        sb.append("159;;cadastrarLogica;;21,1->22,1;;17,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;22,1->23,1;;17,33 semanas$$\n");
        sb.append("159;;cadastrarLogica;;23,1->24,1;;17,67 semanas$$\n");
        sb.append("159;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("159;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("159;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;28,1->29,1;;19,50 semanas$$\n");
        sb.append("159;;cadastrarLogica;;29,1->30,1;;20,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;30,1->31,1;;20,33 semanas$$\n");
        sb.append("159;;cadastrarLogica;;31,1->32,1;;20,67 semanas$$\n");
        sb.append("159;;cadastrarLogica;;32,1->33,1;;21,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;33,1->34,1;;21,50 semanas$$\n");
        sb.append("159;;cadastrarLogica;;34,1->35,1;;22,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;35,1->36,1;;22,33 semanas$$\n");
        sb.append("159;;cadastrarLogica;;36,1->37,1;;22,67 semanas$$\n");
        sb.append("159;;cadastrarLogica;;37,1->38,1;;23,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;38,1->39,1;;23,50 semanas$$\n");
        sb.append("159;;cadastrarLogica;;39,1->40,1;;24,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;40,1->41,1;;24,50 semanas$$\n");
        sb.append("159;;cadastrarLogica;;41,1->42,1;;25,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;42,1->43,1;;25,50 semanas$$\n");
        sb.append("159;;cadastrarLogica;;43,1->44,1;;26,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;44,1->45,1;;26,50 semanas$$\n");
        sb.append("159;;cadastrarLogica;;45,1->46,1;;27,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;46,1->47,1;;27,50 semanas$$\n");
        sb.append("159;;cadastrarLogica;;47,1->48,1;;28,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;48,1->49,1;;28,50 semanas$$\n");
        sb.append("159;;cadastrarLogica;;49,1->50,1;;29,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;50,1->51,1;;30,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;51,1->52,1;;30,50 semanas$$\n");
        sb.append("159;;cadastrarLogica;;52,1->53,1;;31,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;53,1->54,1;;31,50 semanas$$\n");
        sb.append("159;;cadastrarLogica;;54,1->55,1;;32,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;55,1->56,1;;33,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;56,1->57,1;;33,50 semanas$$\n");
        sb.append("159;;cadastrarLogica;;57,1->58,1;;34,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;58,1->59,1;;35,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;59,1->60,1;;35,50 semanas$$\n");
        sb.append("159;;cadastrarLogica;;60,1->61,1;;36,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;61,1->62,1;;37,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;63,1->64,1;;38,50 semanas$$\n");
        sb.append("159;;cadastrarLogica;;64,1->65,1;;39,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("159;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ulna">

        sb.append("160;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("160;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("160;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;10,1->11,1;;13,33 semanas$$\n");
        sb.append("160;;cadastrarLogica;;11,1->12,1;;13,67 semanas$$\n");
        sb.append("160;;cadastrarLogica;;12,1->13,1;;14,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;13,1->14,1;;14,50 semanas$$\n");
        sb.append("160;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;15,1->16,1;;15,33 semanas$$\n");
        sb.append("160;;cadastrarLogica;;16,1->17,1;;15,67 semanas$$\n");
        sb.append("160;;cadastrarLogica;;17,1->18,1;;16,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;18,1->19,1;;16,33 semanas$$\n");
        sb.append("160;;cadastrarLogica;;19,1->20,1;;16,67 semanas$$\n");
        sb.append("160;;cadastrarLogica;;20,1->21,1;;17,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;21,1->22,1;;17,50 semanas$$\n");
        sb.append("160;;cadastrarLogica;;22,1->23,1;;18,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;23,1->24,1;;18,33 semanas$$\n");
        sb.append("160;;cadastrarLogica;;24,1->25,1;;18,67 semanas$$\n");
        sb.append("160;;cadastrarLogica;;25,1->26,1;;19,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;26,1->27,1;;19,50 semanas$$\n");
        sb.append("160;;cadastrarLogica;;27,1->28,1;;20,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;28,1->29,1;;20,33 semanas$$\n");
        sb.append("160;;cadastrarLogica;;29,1->30,1;;20,67 semanas$$\n");
        sb.append("160;;cadastrarLogica;;30,1->31,1;;21,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;31,1->32,1;;21,50 semanas$$\n");
        sb.append("160;;cadastrarLogica;;32,1->33,1;;22,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;33,1->34,1;;22,50 semanas$$\n");
        sb.append("160;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("160;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;37,1->38,1;;24,50 semanas$$\n");
        sb.append("160;;cadastrarLogica;;38,1->39,1;;25,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;39,1->40,1;;25,50 semanas$$\n");
        sb.append("160;;cadastrarLogica;;40,1->41,1;;26,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;41,1->42,1;;26,50 semanas$$\n");
        sb.append("160;;cadastrarLogica;;42,1->43,1;;27,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;43,1->44,1;;27,50 semanas$$\n");
        sb.append("160;;cadastrarLogica;;44,1->45,1;;28,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;45,1->46,1;;28,50 semanas$$\n");
        sb.append("160;;cadastrarLogica;;46,1->47,1;;29,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;47,1->48,1;;30,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;48,1->49,1;;30,50 semanas$$\n");
        sb.append("160;;cadastrarLogica;;49,1->50,1;;31,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;50,1->51,1;;31,50 semanas$$\n");
        sb.append("160;;cadastrarLogica;;51,1->52,1;;32,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;52,1->53,1;;33,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;53,1->54,1;;33,50 semanas$$\n");
        sb.append("160;;cadastrarLogica;;54,1->55,1;;34,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;55,1->56,1;;35,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;56,1->57,1;;36,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;57,1->58,1;;37,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;58,1->59,1;;38,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;59,1->60,1;;39,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;60,1->61,1;;40,00 semanas$$\n");
        sb.append("160;;cadastrarLogica;;61,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tíbia">

        sb.append("161;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("161;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("161;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;10,1->11,1;;13,50 semanas$$\n");
        sb.append("161;;cadastrarLogica;;11,1->12,1;;14,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;12,1->13,1;;14,33 semanas$$\n");
        sb.append("161;;cadastrarLogica;;13,1->14,1;;14,67 semanas$$\n");
        sb.append("161;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;15,1->16,1;;15,50 semanas$$\n");
        sb.append("161;;cadastrarLogica;;16,1->17,1;;16,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;17,1->18,1;;16,33 semanas$$\n");
        sb.append("161;;cadastrarLogica;;18,1->19,1;;16,67 semanas$$\n");
        sb.append("161;;cadastrarLogica;;19,1->20,1;;17,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;20,1->21,1;;17,50 semanas$$\n");
        sb.append("161;;cadastrarLogica;;21,1->22,1;;18,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;22,1->23,1;;18,33 semanas$$\n");
        sb.append("161;;cadastrarLogica;;23,1->24,1;;18,67 semanas$$\n");
        sb.append("161;;cadastrarLogica;;24,1->25,1;;19,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;25,1->26,1;;19,50 semanas$$\n");
        sb.append("161;;cadastrarLogica;;26,1->27,1;;20,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;27,1->28,1;;20,33 semanas$$\n");
        sb.append("161;;cadastrarLogica;;28,1->29,1;;20,67 semanas$$\n");
        sb.append("161;;cadastrarLogica;;29,1->30,1;;21,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;30,1->31,1;;21,50 semanas$$\n");
        sb.append("161;;cadastrarLogica;;31,1->32,1;;22,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;32,1->33,1;;22,33 semanas$$\n");
        sb.append("161;;cadastrarLogica;;33,1->34,1;;22,67 semanas$$\n");
        sb.append("161;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("161;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;37,1->38,1;;24,33 semanas$$\n");
        sb.append("161;;cadastrarLogica;;38,1->39,1;;24,67 semanas$$\n");
        sb.append("161;;cadastrarLogica;;39,1->40,1;;25,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;40,1->41,1;;25,50 semanas$$\n");
        sb.append("161;;cadastrarLogica;;41,1->42,1;;26,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;42,1->43,1;;26,50 semanas$$\n");
        sb.append("161;;cadastrarLogica;;43,1->44,1;;27,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;44,1->45,1;;27,50 semanas$$\n");
        sb.append("161;;cadastrarLogica;;45,1->46,1;;28,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;46,1->47,1;;28,50 semanas$$\n");
        sb.append("161;;cadastrarLogica;;47,1->48,1;;29,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;48,1->49,1;;29,50 semanas$$\n");
        sb.append("161;;cadastrarLogica;;49,1->50,1;;30,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;50,1->51,1;;30,50 semanas$$\n");
        sb.append("161;;cadastrarLogica;;51,1->52,1;;31,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;52,1->53,1;;31,50 semanas$$\n");
        sb.append("161;;cadastrarLogica;;53,1->54,1;;32,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;54,1->55,1;;33,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;55,1->56,1;;33,50 semanas$$\n");
        sb.append("161;;cadastrarLogica;;56,1->57,1;;34,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;57,1->58,1;;35,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;58,1->59,1;;35,50 semanas$$\n");
        sb.append("161;;cadastrarLogica;;59,1->60,1;;36,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;60,1->61,1;;37,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;61,1->62,1;;37,50 semanas$$\n");
        sb.append("161;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;63,1->64,1;;39,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;64,1->65,1;;39,50 semanas$$\n");
        sb.append("161;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("161;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fíbula">

        sb.append("162;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;7,1->8,1;;13,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;8,1->9,1;;13,33 semanas$$\n");
        sb.append("162;;cadastrarLogica;;9,1->10,1;;13,67 semanas$$\n");
        sb.append("162;;cadastrarLogica;;10,1->11,1;;14,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;11,1->12,1;;14,33 semanas$$\n");
        sb.append("162;;cadastrarLogica;;12,1->13,1;;14,67 semanas$$\n");
        sb.append("162;;cadastrarLogica;;13,1->14,1;;15,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;14,1->15,1;;15,50 semanas$$\n");
        sb.append("162;;cadastrarLogica;;15,1->16,1;;16,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;16,1->17,1;;16,33 semanas$$\n");
        sb.append("162;;cadastrarLogica;;17,1->18,1;;16,67 semanas$$\n");
        sb.append("162;;cadastrarLogica;;18,1->19,1;;17,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;19,1->20,1;;17,33 semanas$$\n");
        sb.append("162;;cadastrarLogica;;20,1->21,1;;17,67 semanas$$\n");
        sb.append("162;;cadastrarLogica;;21,1->22,1;;18,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;22,1->23,1;;18,33 semanas$$\n");
        sb.append("162;;cadastrarLogica;;23,1->24,1;;18,67 semanas$$\n");
        sb.append("162;;cadastrarLogica;;24,1->25,1;;19,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;25,1->26,1;;19,33 semanas$$\n");
        sb.append("162;;cadastrarLogica;;26,1->27,1;;19,67 semanas$$\n");
        sb.append("162;;cadastrarLogica;;27,1->28,1;;20,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;28,1->29,1;;20,33 semanas$$\n");
        sb.append("162;;cadastrarLogica;;29,1->30,1;;20,67 semanas$$\n");
        sb.append("162;;cadastrarLogica;;30,1->31,1;;21,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;31,1->32,1;;21,50 semanas$$\n");
        sb.append("162;;cadastrarLogica;;32,1->33,1;;22,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;33,1->34,1;;22,33 semanas$$\n");
        sb.append("162;;cadastrarLogica;;34,1->35,1;;22,67 semanas$$\n");
        sb.append("162;;cadastrarLogica;;35,1->36,1;;23,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;36,1->37,1;;23,50 semanas$$\n");
        sb.append("162;;cadastrarLogica;;37,1->38,1;;24,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;38,1->39,1;;24,50 semanas$$\n");
        sb.append("162;;cadastrarLogica;;39,1->40,1;;25,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;40,1->41,1;;25,50 semanas$$\n");
        sb.append("162;;cadastrarLogica;;41,1->42,1;;26,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;42,1->43,1;;26,50 semanas$$\n");
        sb.append("162;;cadastrarLogica;;43,1->44,1;;27,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;44,1->45,1;;27,50 semanas$$\n");
        sb.append("162;;cadastrarLogica;;45,1->46,1;;28,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;46,1->47,1;;28,50 semanas$$\n");
        sb.append("162;;cadastrarLogica;;47,1->48,1;;29,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;48,1->49,1;;29,50 semanas$$\n");
        sb.append("162;;cadastrarLogica;;49,1->50,1;;30,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;50,1->51,1;;31,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;51,1->52,1;;31,50 semanas$$\n");
        sb.append("162;;cadastrarLogica;;52,1->53,1;;32,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;53,1->54,1;;32,50 semanas$$\n");
        sb.append("162;;cadastrarLogica;;54,1->55,1;;33,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;55,1->56,1;;34,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;56,1->57,1;;35,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;57,1->58,1;;35,50 semanas$$\n");
        sb.append("162;;cadastrarLogica;;58,1->59,1;;36,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;59,1->60,1;;37,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;60,1->61,1;;38,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;61,1->62,1;;39,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;62,1->63,1;;39,50 semanas$$\n");
        sb.append("162;;cadastrarLogica;;63,1->64,1;;40,00 semanas$$\n");
        sb.append("162;;cadastrarLogica;;64,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Rádio">

        sb.append("163;;cadastrarLogica;;0,0->5,1;;<12,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;5,1->6,1;;12,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;6,1->7,1;;12,50 semanas$$\n");
        sb.append("163;;cadastrarLogica;;7,1->8,1;;13,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;8,1->9,1;;13,33 semanas$$\n");
        sb.append("163;;cadastrarLogica;;9,1->10,1;;13,67 semanas$$\n");
        sb.append("163;;cadastrarLogica;;10,1->11,1;;14,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;11,1->12,1;;14,33 semanas$$\n");
        sb.append("163;;cadastrarLogica;;12,1->13,1;;14,67 semanas$$\n");
        sb.append("163;;cadastrarLogica;;13,1->14,1;;15,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;14,1->15,1;;15,33 semanas$$\n");
        sb.append("163;;cadastrarLogica;;15,1->16,1;;15,67 semanas$$\n");
        sb.append("163;;cadastrarLogica;;16,1->17,1;;16,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;17,1->18,1;;16,50 semanas$$\n");
        sb.append("163;;cadastrarLogica;;18,1->19,1;;17,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;19,1->20,1;;17,33 semanas$$\n");
        sb.append("163;;cadastrarLogica;;20,1->21,1;;17,67 semanas$$\n");
        sb.append("163;;cadastrarLogica;;21,1->22,1;;18,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;22,1->23,1;;18,50 semanas$$\n");
        sb.append("163;;cadastrarLogica;;23,1->24,1;;19,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;24,1->25,1;;19,33 semanas$$\n");
        sb.append("163;;cadastrarLogica;;25,1->26,1;;19,67 semanas$$\n");
        sb.append("163;;cadastrarLogica;;26,1->27,1;;20,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;27,1->28,1;;20,50 semanas$$\n");
        sb.append("163;;cadastrarLogica;;28,1->29,1;;21,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;29,1->30,1;;21,50 semanas$$\n");
        sb.append("163;;cadastrarLogica;;30,1->31,1;;22,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;31,1->32,1;;22,50 semanas$$\n");
        sb.append("163;;cadastrarLogica;;32,1->33,1;;23,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;33,1->34,1;;23,50 semanas$$\n");
        sb.append("163;;cadastrarLogica;;34,1->35,1;;24,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;35,1->36,1;;25,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;36,1->37,1;;25,50 semanas$$\n");
        sb.append("163;;cadastrarLogica;;37,1->38,1;;26,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;38,1->39,1;;26,50 semanas$$\n");
        sb.append("163;;cadastrarLogica;;39,1->40,1;;27,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;40,1->41,1;;28,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;41,1->42,1;;28,50 semanas$$\n");
        sb.append("163;;cadastrarLogica;;42,1->43,1;;29,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;43,1->44,1;;30,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;44,1->45,1;;31,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;45,1->46,1;;32,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;46,1->47,1;;33,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;47,1->48,1;;33,50 semanas$$\n");
        sb.append("163;;cadastrarLogica;;48,1->49,1;;34,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;49,1->50,1;;35,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;50,1->51,1;;36,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;51,1->52,1;;37,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;51,1->52,1;;38,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;52,1->53,1;;39,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;53,1->54,1;;40,00 semanas$$\n");
        sb.append("163;;cadastrarLogica;;54,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.A.">

        sb.append("165;;cadastrarLogica;;0,0->39,3;;<11,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;39,3->40,6;;11,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;40,6->41,9;;11,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;41,9->43,2;;11,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;43,2->44,5;;11,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;44,5->45,8;;11,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;45,8->47,0;;11,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;47,0->48,3;;11,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;48,3->49,6;;11,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;49,6->50,9;;11,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;50,9->52,2;;11,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;52,2->53,5;;12,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;53,5->54,8;;12,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;54,8->56,0;;12,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;56,0->57,3;;12,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;57,3->58,6;;12,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;58,6->59,9;;12,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;59,9->61,2;;12,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;61,2->62,4;;12,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;62,4->63,7;;12,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;63,7->65,0;;12,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;65,0->66,3;;13,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;66,3->67,5;;13,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;67,5->68,8;;13,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;68,8->70,1;;13,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;70,1->71,4;;13,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;71,4->72,6;;13,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;72,6->73,9;;13,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;73,9->75,2;;13,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;75,2->76,4;;13,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;76,4->77,7;;13,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;77,7->79,0;;14,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;79,0->80,2;;14,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;80,2->81,4;;14,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;81,4->82,7;;14,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;82,7->84,0;;14,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;84,0->85,2;;14,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;85,2->86,4;;14,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;86,4->87,7;;14,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;87,7->89,0;;14,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;89,0->90,2;;14,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;90,2->91,4;;15,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;91,4->92,7;;15,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;92,7->94,0;;15,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;94,0->95,2;;15,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;95,2->96,4;;15,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;96,4->97,7;;15,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;97,7->99,0;;15,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;99,0->100,2;;15,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;100,2->101,4;;15,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;101,4->102,7;;15,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;102,7->103,9;;16,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;103,9->105,2;;16,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;105,2->106,4;;16,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;106,4->107,6;;16,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;107,6->108,8;;16,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;108,8->110,1;;16,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;110,1->111,3;;16,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;111,3->112,5;;16,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;112,5->113,8;;16,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;113,8->115,0;;16,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;115,0->116,2;;17,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;116,2->117,4;;17,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;117,4->118,7;;17,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;118,7->119,9;;17,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;119,9->121,1;;17,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;121,1->122,3;;17,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;122,3->123,5;;17,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;123,5->124,8;;17,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;124,8->126,0;;17,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;126,0->127,2;;17,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;127,2->128,4;;18,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;128,4->129,6;;18,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;129,6->130,8;;18,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;130,8->132,0;;18,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;132,0->133,2;;18,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;133,2->134,4;;18,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;134,4->135,6;;18,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;135,6->136,8;;18,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;136,8->138,0;;18,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;138,0->139,2;;18,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;139,2->140,4;;19,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;140,4->141,6;;19,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;141,6->142,8;;19,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;142,8->144,0;;19,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;144,0->145,1;;19,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;145,1->146,3;;19,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;146,3->147,5;;19,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;147,5->148,7;;19,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;148,7->149,9;;19,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;149,9->151,1;;19,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;151,1->152,3;;20,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;152,3->153,4;;20,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;153,4->154,6;;20,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;154,6->155,8;;20,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;155,8->157,0;;20,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;157,0->158,1;;20,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;158,1->159,3;;20,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;159,3->160,5;;20,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;160,5->161,6;;20,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;161,6->162,8;;20,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;162,8->164,0;;21,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;164,0->165,1;;21,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;165,1->166,3;;21,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;166,3->167,4;;21,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;167,4->168,6;;21,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;168,6->169,8;;21,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;169,8->170,9;;21,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;170,9->172,1;;21,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;172,1->173,2;;21,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;173,2->174,4;;21,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;174,4->175,5;;22,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;175,5->176,7;;22,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;176,7->177,8;;22,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;177,8->179,0;;22,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;179,0->180,1;;22,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;180,1->181,2;;22,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;181,2->182,4;;22,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;182,4->183,5;;22,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;183,5->184,7;;22,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;184,7->185,8;;22,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;185,8->186,9;;23,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;186,9->188,0;;23,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;188,0->189,2;;23,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;189,2->190,3;;23,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;190,3->191,4;;23,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;191,4->192,5;;23,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;192,5->193,6;;23,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;193,6->194,8;;23,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;194,8->195,9;;23,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;195,9->197,0;;23,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;197,0->198,1;;24,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;198,1->199,2;;24,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;199,2->200,3;;24,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;200,3->201,4;;24,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;201,4->202,5;;24,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;202,5->203,6;;24,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;203,6->204,7;;24,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;204,7->205,8;;24,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;205,8->206,9;;24,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;206,9->208,0;;24,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;208,0->209,1;;25,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;209,1->210,2;;25,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;210,2->211,2;;25,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;211,2->212,3;;25,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;212,3->213,4;;25,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;213,4->214,5;;25,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;214,5->215,6;;25,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;215,6->216,6;;25,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;216,6->217,7;;25,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;217,7->218,8;;25,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;218,8->219,9;;26,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;219,9->220,9;;26,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;220,9->222,0;;26,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;222,0->223,0;;26,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;223,0->224,1;;26,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;224,1->225,2;;26,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;225,2->226,2;;26,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;226,2->227,3;;26,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;227,3->228,3;;26,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;228,3->229,4;;26,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;229,4->230,4;;27,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;230,4->231,5;;27,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;231,5->232,5;;27,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;232,5->233,6;;27,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;233,6->234,6;;27,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;234,6->235,6;;27,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;235,6->236,7;;27,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;236,7->237,7;;27,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;237,7->238,8;;27,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;238,8->239,8;;27,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;239,8->240,8;;28,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;240,8->241,8;;28,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;241,8->242,8;;28,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;242,8->243,8;;28,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;243,8->244,9;;28,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;244,9->245,9;;28,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;245,9->246,9;;28,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;246,9->247,9;;28,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;247,9->248,9;;28,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;248,9->249,9;;28,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;249,9->250,9;;29,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;250,9->251,9;;29,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;251,9->252,9;;29,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;252,9->253,9;;29,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;253,9->254,9;;29,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;254,9->255,8;;29,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;255,8->256,8;;29,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;256,8->257,8;;29,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;257,8->258,8;;29,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;258,8->259,8;;29,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;259,8->260,8;;30,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;260,8->261,7;;30,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;261,7->262,7;;30,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;262,7->263,7;;30,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;263,7->264,6;;30,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;264,6->265,6;;30,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;265,6->266,6;;30,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;266,6->267,6;;30,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;267,6->268,5;;30,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;268,5->269,5;;30,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;269,5->270,4;;31,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;270,4->271,4;;31,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;271,4->272,4;;31,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;272,4->273,3;;31,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;273,3->274,2;;31,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;274,2->275,2;;31,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;275,2->276,2;;31,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;276,2->277,1;;31,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;277,1->278,0;;31,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;278,0->279,0;;31,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;279,0->279,9;;32,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;279,9->280,8;;32,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;280,8->281,7;;32,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;281,7->282,6;;32,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;282,6->283,6;;32,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;283,6->284,5;;32,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;284,5->285,4;;32,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;285,4->286,3;;32,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;286,3->287,2;;32,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;287,2->288,1;;32,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;288,1->289,0;;33,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;289,0->289,9;;33,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;289,9->290,8;;33,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;290,8->291,7;;33,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;291,7->292,6;;33,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;292,6->293,5;;33,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;293,5->294,4;;33,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;294,4->295,3;;33,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;295,3->296,2;;33,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;296,2->297,1;;33,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;297,1->298,0;;34,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;298,0->298,8;;34,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;298,8->299,7;;34,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;299,7->300,5;;34,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;300,5->301,4;;34,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;301,4->302,3;;34,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;302,3->303,1;;34,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;303,1->304,0;;34,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;304,0->304,8;;34,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;304,8->305,7;;34,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;305,7->306,5;;35,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;306,5->307,4;;35,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;307,4->308,2;;35,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;308,2->309,1;;35,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;309,1->309,9;;35,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;309,9->310,7;;35,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;310,7->311,6;;35,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;311,6->312,4;;35,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;312,4->313,3;;35,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;313,3->314,1;;35,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;314,1->314,9;;36,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;314,9->315,7;;36,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;315,7->316,5;;36,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;316,5->317,3;;36,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;317,3->318,1;;36,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;318,1->318,9;;36,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;318,9->319,7;;36,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;319,7->320,5;;36,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;320,5->321,3;;36,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;321,3->322,1;;36,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;322,1->322,9;;37,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;322,9->323,7;;37,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;323,7->324,4;;37,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;324,4->325,2;;37,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;325,2->326,0;;37,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;326,0->326,8;;37,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;326,8->327,6;;37,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;327,6->328,3;;37,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;328,3->329,1;;37,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;329,1->329,9;;37,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;329,9->330,6;;38,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;330,6->331,4;;38,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;331,4->332,2;;38,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;332,2->332,9;;38,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;332,9->333,6;;38,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;333,6->334,4;;38,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;334,4->335,2;;38,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;335,2->335,9;;38,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;335,9->336,6;;38,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;336,6->337,4;;38,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;337,4->338,1;;39,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;338,1->338,8;;39,10 semanas$$\n");
        sb.append("165;;cadastrarLogica;;338,8->339,5;;39,20 semanas$$\n");
        sb.append("165;;cadastrarLogica;;339,5->340,2;;39,30 semanas$$\n");
        sb.append("165;;cadastrarLogica;;340,2->341,0;;39,40 semanas$$\n");
        sb.append("165;;cadastrarLogica;;341,0->341,7;;39,50 semanas$$\n");
        sb.append("165;;cadastrarLogica;;341,7->342,4;;39,60 semanas$$\n");
        sb.append("165;;cadastrarLogica;;342,4->343,1;;39,70 semanas$$\n");
        sb.append("165;;cadastrarLogica;;343,1->343,8;;39,80 semanas$$\n");
        sb.append("165;;cadastrarLogica;;343,8->344,5;;39,90 semanas$$\n");
        sb.append("165;;cadastrarLogica;;344,5->346,1;;40,00 semanas$$\n");
        sb.append("165;;cadastrarLogica;;346,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.C.">

        sb.append("166;;cadastrarLogica;;0,0->53,2;;<11,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;53,2->54,6;;11,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;54,6->56,1;;11,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;56,1->57,5;;11,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;57,5->58,9;;11,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;58,9->60,4;;11,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;60,4->61,8;;11,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;61,8->63,2;;11,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;63,2->64,6;;11,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;64,6->66,1;;11,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;66,1->67,5;;11,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;67,5->68,9;;12,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;68,9->70,4;;12,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;70,4->71,8;;12,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;71,8->73,2;;12,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;73,2->74,6;;12,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;74,6->76,1;;12,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;76,1->77,5;;12,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;77,5->78,9;;12,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;78,9->80,4;;12,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;80,4->81,8;;12,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;81,8->83,2;;13,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;83,2->84,5;;13,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;84,5->85,9;;13,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;85,9->87,3;;13,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;87,3->88,6;;13,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;88,6->90,0;;13,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;90,0->91,4;;13,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;91,4->92,8;;13,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;92,8->94,1;;13,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;94,1->95,5;;13,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;95,5->96,9;;14,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;96,9->98,2;;14,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;98,2->99,6;;14,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;99,6->101,0;;14,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;101,0->102,4;;14,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;102,4->103,7;;14,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;103,7->105,1;;14,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;105,1->106,5;;14,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;106,5->107,8;;14,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;107,8->109,2;;14,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;109,2->110,6;;15,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;110,6->111,9;;15,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;111,9->113,2;;15,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;113,2->114,6;;15,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;114,6->116,0;;15,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;116,0->117,3;;15,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;117,3->118,6;;15,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;118,6->120,0;;15,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;120,0->121,4;;15,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;121,4->122,7;;15,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;122,7->124,0;;16,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;124,0->125,3;;16,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;125,3->126,6;;16,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;126,6->127,9;;16,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;127,9->129,2;;16,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;129,2->130,6;;16,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;130,6->131,9;;16,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;131,9->133,2;;16,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;133,2->134,5;;16,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;134,5->135,8;;16,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;135,8->137,1;;17,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;137,1->138,4;;17,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;138,4->139,7;;17,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;139,7->141,0;;17,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;141,0->142,2;;17,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;142,2->143,5;;17,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;143,5->144,8;;17,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;144,8->146,1;;17,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;146,1->147,4;;17,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;147,4->148,7;;17,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;148,7->150,0;;18,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;150,0->151,2;;18,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;151,2->152,5;;18,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;152,5->153,7;;18,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;153,7->155,0;;18,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;155,0->156,3;;18,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;156,3->157,5;;18,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;157,5->158,8;;18,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;158,8->160,0;;18,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;160,0->161,3;;18,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;161,3->162,5;;19,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;162,5->163,7;;19,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;163,7->165,0;;19,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;165,0->166,2;;19,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;166,2->167,4;;19,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;167,4->168,6;;19,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;168,6->169,8;;19,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;169,8->171,1;;19,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;171,1->172,3;;19,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;172,3->173,5;;19,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;173,5->174,7;;20,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;174,7->175,9;;20,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;175,9->177,1;;20,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;177,1->178,3;;20,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;178,3->179,5;;20,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;179,5->180,7;;20,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;180,7->181,9;;20,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;181,9->183,1;;20,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;183,1->184,3;;20,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;184,3->185,5;;20,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;185,5->186,6;;21,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;186,6->187,8;;21,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;187,8->189,0;;21,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;189,0->190,1;;21,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;190,1->191,2;;21,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;191,2->192,4;;21,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;192,4->193,6;;21,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;193,6->194,7;;21,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;194,7->195,8;;21,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;195,8->197,0;;21,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;197,0->198,1;;22,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;198,1->199,3;;22,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;199,3->200,4;;22,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;200,4->201,5;;22,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;201,5->202,6;;22,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;202,6->203,8;;22,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;203,8->204,9;;22,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;204,9->206,0;;22,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;206,0->207,2;;22,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;207,2->208,3;;22,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;208,3->209,4;;23,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;209,4->210,5;;23,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;210,5->211,5;;23,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;211,5->212,6;;23,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;212,6->213,7;;23,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;213,7->214,8;;23,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;214,8->215,9;;23,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;215,9->216,9;;23,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;216,9->218,0;;23,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;218,0->219,1;;23,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;219,1->220,1;;24,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;220,1->221,2;;24,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;221,2->222,2;;24,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;222,2->223,3;;24,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;223,3->224,3;;24,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;224,3->225,3;;24,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;225,3->226,4;;24,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;226,4->227,4;;24,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;227,4->228,5;;24,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;228,5->229,5;;24,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;229,5->230,5;;25,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;230,5->231,5;;25,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;231,5->232,5;;25,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;232,5->233,5;;25,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;233,5->234,5;;25,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;234,5->235,5;;25,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;235,5->236,5;;25,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;236,5->237,5;;25,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;237,5->238,5;;25,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;238,5->239,5;;25,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;239,5->240,5;;26,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;240,5->241,4;;26,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;241,4->242,4;;26,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;242,4->243,3;;26,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;243,3->244,3;;26,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;244,3->245,3;;26,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;245,3->246,2;;26,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;246,2->247,2;;26,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;247,2->248,1;;26,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;248,1->249,1;;26,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;249,1->250,0;;27,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;250,0->250,9;;27,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;250,9->251,9;;27,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;251,9->252,8;;27,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;252,8->253,7;;27,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;253,7->254,6;;27,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;254,6->255,5;;27,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;255,5->256,5;;27,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;256,5->257,4;;27,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;257,4->258,3;;27,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;258,3->259,2;;28,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;259,2->260,0;;28,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;260,0->260,9;;28,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;260,9->261,7;;28,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;261,7->262,6;;28,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;262,6->263,5;;28,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;263,5->264,3;;28,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;264,3->265,2;;28,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;265,2->266,0;;28,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;266,0->266,9;;28,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;266,9->267,7;;29,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;267,7->268,5;;29,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;268,5->269,4;;29,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;269,4->270,2;;29,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;270,2->271,0;;29,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;271,0->271,8;;29,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;271,8->272,6;;29,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;272,6->273,5;;29,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;273,5->274,3;;29,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;274,3->275,1;;29,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;275,1->275,9;;30,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;275,9->276,6;;30,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;276,6->277,4;;30,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;277,4->278,2;;30,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;278,2->279,0;;30,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;279,0->279,7;;30,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;279,7->280,5;;30,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;280,5->281,3;;30,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;281,3->282,0;;30,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;282,0->282,8;;30,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;282,8->283,5;;31,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;283,5->284,2;;31,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;284,2->284,9;;31,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;284,9->285,6;;31,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;285,6->286,4;;31,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;286,4->287,1;;31,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;287,1->287,8;;31,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;287,8->288,5;;31,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;288,5->289,2;;31,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;289,2->289,9;;31,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;289,9->290,6;;32,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;290,6->291,2;;32,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;291,2->291,9;;32,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;291,9->292,6;;32,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;292,6->293,2;;32,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;293,2->293,9;;32,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;293,9->294,6;;32,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;294,6->295,3;;32,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;295,3->295,9;;32,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;295,9->296,6;;32,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;296,6->297,2;;33,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;297,2->297,8;;33,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;297,8->298,4;;33,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;298,4->299,0;;33,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;299,0->299,6;;33,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;299,6->300,3;;33,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;300,3->300,9;;33,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;300,9->301,5;;33,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;301,5->302,1;;33,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;302,1->302,7;;33,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;302,7->303,2;;34,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;303,2->303,8;;34,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;303,8->304,3;;34,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;304,3->304,9;;34,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;304,9->305,4;;34,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;305,4->306,0;;34,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;306,0->306,6;;34,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;306,6->307,1;;34,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;307,1->307,6;;34,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;307,6->308,2;;34,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;308,2->308,7;;35,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;308,7->309,2;;35,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;309,2->309,7;;35,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;309,7->310,2;;35,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;310,2->310,6;;35,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;310,6->311,1;;35,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;311,1->311,6;;35,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;311,6->312,1;;35,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;312,1->312,6;;35,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;312,6->313,1;;35,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;313,1->313,5;;36,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;313,5->314,0;;36,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;314,0->314,4;;36,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;314,4->314,9;;36,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;314,9->315,3;;36,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;315,3->315,7;;36,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;315,7->316,2;;36,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;316,2->316,6;;36,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;316,6->317,1;;36,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;317,1->317,5;;36,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;317,5->317,9;;37,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;317,9->318,2;;37,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;318,2->318,6;;37,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;318,6->319,0;;37,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;319,0->319,4;;37,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;319,4->319,7;;37,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;319,7->320,1;;37,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;320,1->320,5;;37,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;320,5->320,8;;37,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;320,8->321,2;;37,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;321,2->321,5;;38,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;321,5->321,8;;38,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;321,8->322,1;;38,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;322,1->322,4;;38,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;322,4->322,8;;38,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;322,8->323,1;;38,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;323,1->323,4;;38,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;323,4->323,7;;38,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;323,7->324,0;;38,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;324,0->324,3;;38,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;324,3->324,5;;39,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;324,5->324,8;;39,10 semanas$$\n");
        sb.append("166;;cadastrarLogica;;324,8->325,0;;39,20 semanas$$\n");
        sb.append("166;;cadastrarLogica;;325,0->325,3;;39,30 semanas$$\n");
        sb.append("166;;cadastrarLogica;;325,3->325,5;;39,40 semanas$$\n");
        sb.append("166;;cadastrarLogica;;325,5->325,7;;39,50 semanas$$\n");
        sb.append("166;;cadastrarLogica;;325,7->326,0;;39,60 semanas$$\n");
        sb.append("166;;cadastrarLogica;;326,0->326,2;;39,70 semanas$$\n");
        sb.append("166;;cadastrarLogica;;326,2->326,5;;39,80 semanas$$\n");
        sb.append("166;;cadastrarLogica;;326,5->326,7;;39,90 semanas$$\n");
        sb.append("166;;cadastrarLogica;;326,7->328,1;;40,00 semanas$$\n");
        sb.append("166;;cadastrarLogica;;328,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("164;;cadastrarLogica;;0,0->15,7;;<11,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;15,7->16,0;;11,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;16,0->16,4;;11,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;16,4->16,7;;11,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;16,7->17,1;;11,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;17,1->17,4;;11,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;17,4->17,7;;11,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;17,7->18,1;;11,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;18,1->18,4;;11,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;18,4->18,8;;11,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;18,8->19,1;;11,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;19,1->19,4;;12,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;19,4->19,7;;12,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;19,7->20,1;;12,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;20,1->20,4;;12,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;20,4->20,7;;12,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;20,7->21,0;;12,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;21,0->21,3;;12,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;21,3->21,7;;12,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;21,7->22,0;;12,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;22,0->22,3;;12,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;22,3->22,8;;13,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;22,8->23,2;;13,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;23,2->23,7;;13,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;23,7->24,2;;13,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;24,2->24,6;;13,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;24,6->25,1;;13,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;25,1->25,6;;13,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;25,6->26,1;;13,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;26,1->26,5;;13,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;26,5->27,0;;13,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;27,0->27,4;;14,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;27,4->27,7;;14,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;27,7->28,1;;14,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;28,1->28,5;;14,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;28,5->28,8;;14,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;28,8->29,2;;14,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;29,2->29,6;;14,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;29,6->30,0;;14,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;30,0->30,3;;14,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;30,3->30,7;;14,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;30,7->31,1;;15,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;31,1->31,4;;15,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;31,4->31,8;;15,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;31,8->32,1;;15,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;32,1->32,5;;15,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;32,5->32,9;;15,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;32,9->33,2;;15,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;33,2->33,6;;15,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;33,6->33,9;;15,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;33,9->34,3;;15,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;34,3->34,7;;16,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;34,7->35,0;;16,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;35,0->35,4;;16,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;35,4->35,7;;16,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;35,7->36,1;;16,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;36,1->36,5;;16,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;36,5->36,8;;16,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;36,8->37,2;;16,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;37,2->37,5;;16,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;37,5->37,9;;16,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;37,9->38,2;;17,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;38,2->38,6;;17,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;38,6->38,9;;17,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;38,9->39,3;;17,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;39,3->39,6;;17,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;39,6->39,9;;17,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;39,9->40,3;;17,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;40,3->40,6;;17,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;40,6->41,0;;17,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;41,0->41,3;;17,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;41,3->41,6;;18,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;41,6->42,0;;18,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;42,0->42,3;;18,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;42,3->42,7;;18,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;42,7->43,0;;18,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;43,0->43,3;;18,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;43,3->43,7;;18,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;43,7->44,0;;18,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;44,0->44,4;;18,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;44,4->44,7;;18,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;44,7->45,0;;19,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;45,0->45,4;;19,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;45,4->45,7;;19,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;45,7->46,1;;19,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;46,1->46,4;;19,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;46,4->46,7;;19,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;46,7->47,1;;19,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;47,1->47,4;;19,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;47,4->47,8;;19,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;47,8->48,1;;19,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;48,1->48,4;;20,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;48,4->48,7;;20,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;48,7->49,1;;20,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;49,1->49,4;;20,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;49,4->49,7;;20,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;49,7->50,0;;20,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;50,0->50,3;;20,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;50,3->50,7;;20,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;50,7->51,0;;20,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;51,0->51,3;;20,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;51,3->51,6;;21,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;51,6->51,9;;21,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;51,9->52,3;;21,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;52,3->52,6;;21,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;52,6->52,9;;21,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;52,9->53,2;;21,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;53,2->53,5;;21,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;53,5->53,9;;21,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;53,9->54,2;;21,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;54,2->54,5;;21,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;54,5->54,8;;22,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;54,8->55,1;;22,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;55,1->55,4;;22,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;55,4->55,7;;22,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;55,7->56,0;;22,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;56,0->56,3;;22,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;56,3->56,6;;22,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;56,6->56,9;;22,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;56,9->57,2;;22,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;57,2->57,5;;22,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;57,5->57,8;;23,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;57,8->58,1;;23,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;58,1->58,4;;23,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;58,4->58,7;;23,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;58,7->59,0;;23,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;59,0->59,3;;23,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;59,3->59,6;;23,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;59,6->59,9;;23,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;59,9->60,2;;23,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;60,2->60,5;;23,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;60,5->60,8;;24,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;60,8->61,1;;24,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;61,1->61,4;;24,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;61,4->61,7;;24,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;61,7->62,0;;24,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;62,0->62,2;;24,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;62,2->62,5;;24,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;62,5->62,8;;24,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;62,8->63,1;;24,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;63,1->63,4;;24,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;63,4->63,7;;25,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;63,7->64,0;;25,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;64,0->64,2;;25,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;64,2->64,5;;25,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;64,5->64,8;;25,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;64,8->65,1;;25,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;65,1->65,4;;25,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;65,4->65,6;;25,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;65,6->65,9;;25,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;65,9->66,2;;25,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;66,2->66,5;;26,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;66,5->66,7;;26,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;66,7->67,0;;26,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;67,0->67,3;;26,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;67,3->67,6;;26,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;67,6->67,8;;26,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;67,8->68,1;;26,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;68,1->68,4;;26,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;68,4->68,6;;26,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;68,6->68,9;;26,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;68,9->69,2;;27,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;69,2->69,4;;27,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;69,4->69,6;;27,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;69,6->69,9;;27,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;69,9->70,2;;27,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;70,2->70,4;;27,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;70,4->70,6;;27,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;70,6->70,9;;27,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;70,9->71,2;;27,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;71,2->71,4;;27,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;71,4->71,6;;28,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;71,6->71,9;;28,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;71,9->72,2;;28,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;72,2->72,4;;28,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;72,4->72,6;;28,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;72,6->72,9;;28,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;72,9->73,2;;28,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;73,2->73,4;;28,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;73,4->73,6;;28,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;73,6->73,9;;28,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;73,9->74,1;;29,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;74,1->74,4;;29,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;74,4->74,6;;29,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;74,6->74,8;;29,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;74,8->75,1;;29,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;75,1->75,3;;29,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;75,3->75,5;;29,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;75,5->75,7;;29,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;75,7->76,0;;29,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;76,0->76,2;;29,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;76,2->76,4;;30,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;76,4->76,7;;30,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;76,7->76,9;;30,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;76,9->77,1;;30,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;77,1->77,4;;30,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;77,4->77,6;;30,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;77,6->77,8;;30,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;77,8->78,0;;30,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;78,0->78,3;;30,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;78,3->78,5;;30,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;78,5->78,7;;31,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;78,7->78,9;;31,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;78,9->79,1;;31,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;79,1->79,3;;31,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;79,3->79,6;;31,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;79,6->79,8;;31,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;79,8->80,0;;31,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;80,0->80,2;;31,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;80,2->80,4;;31,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;80,4->80,6;;31,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;80,6->80,8;;32,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;80,8->81,0;;32,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;81,0->81,2;;32,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;81,2->81,4;;32,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;81,4->81,6;;32,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;81,6->81,7;;32,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;81,7->81,9;;32,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;81,9->82,1;;32,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;82,1->82,3;;32,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;82,3->82,5;;32,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;82,5->82,7;;33,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;82,7->82,9;;33,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;82,9->83,1;;33,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;83,1->83,3;;33,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;83,3->83,4;;33,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;83,4->83,6;;33,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;83,6->83,8;;33,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;83,8->84,0;;33,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;84,0->84,2;;33,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;84,2->84,4;;33,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;84,4->84,6;;34,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;84,6->84,7;;34,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;84,7->84,9;;34,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;84,9->85,1;;34,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;85,1->85,2;;34,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;85,2->85,4;;34,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;85,4->85,6;;34,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;85,6->85,8;;34,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;85,8->85,9;;34,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;85,9->86,1;;34,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;86,1->86,2;;35,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;86,2->86,4;;35,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;86,4->86,6;;35,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;86,6->86,7;;35,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;86,7->86,8;;35,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;86,8->87,0;;35,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;87,0->87,1;;35,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;87,1->87,3;;35,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;87,3->87,4;;35,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;87,4->87,6;;35,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;87,6->87,8;;36,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;87,8->87,9;;36,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;87,9->88,0;;36,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;88,0->88,2;;36,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;88,2->88,4;;36,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;88,4->88,5;;36,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;88,5->88,6;;36,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;88,6->88,8;;36,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;88,8->88,9;;36,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;88,9->89,1;;36,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;89,1->89,2;;37,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;89,2->89,3;;37,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;89,3->89,5;;37,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;89,5->89,6;;37,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;89,6->89,7;;37,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;89,7->89,8;;37,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;89,8->89,9;;37,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;89,9->90,1;;37,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;90,1->90,2;;37,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;90,2->90,3;;37,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;90,3->90,4;;38,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;90,4->90,5;;38,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;90,5->90,6;;38,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;90,6->90,7;;38,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;90,7->90,8;;38,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;90,8->91,0;;38,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;91,0->91,1;;38,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;91,1->91,2;;38,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;91,2->91,3;;38,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;91,3->91,4;;38,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;91,4->91,5;;39,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;91,5->91,6;;39,10 semanas$$\n");
        sb.append("164;;cadastrarLogica;;91,6->91,7;;39,20 semanas$$\n");
        sb.append("164;;cadastrarLogica;;91,7->91,8;;39,30 semanas$$\n");
        sb.append("164;;cadastrarLogica;;91,8->91,9;;39,40 semanas$$\n");
        sb.append("164;;cadastrarLogica;;91,9->92,0;;39,50 semanas$$\n");
        sb.append("164;;cadastrarLogica;;92,0->92,1;;39,60 semanas$$\n");
        sb.append("164;;cadastrarLogica;;92,1->92,2;;39,70 semanas$$\n");
        sb.append("164;;cadastrarLogica;;92,2->92,3;;39,80 semanas$$\n");
        sb.append("164;;cadastrarLogica;;92,3->92,4;;39,90 semanas$$\n");
        sb.append("164;;cadastrarLogica;;92,4->93,1;;40,00 semanas$$\n");
        sb.append("164;;cadastrarLogica;;93,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Mess">

        sb.append("5;;setObrigatorio;;false$$\n");
        sb.append("7;;setObrigatorio;;false$$\n");
        sb.append("8;;setObrigatorio;;false$$\n");
        sb.append("9;;setObrigatorio;;false$$\n");
        sb.append("85;;setObrigatorio;;false$$\n");
        sb.append("86;;setObrigatorio;;false$$\n");
        sb.append("87;;setObrigatorio;;false$$\n");
        sb.append("88;;setObrigatorio;;false$$\n");
        sb.append("89;;setObrigatorio;;false$$\n");
        sb.append("139;;setObrigatorio;;false$$\n");
        sb.append("146;;setObrigatorio;;false$$\n");
        sb.append("153;;setObrigatorio;;false$$\n");
        sb.append("154;;setObrigatorio;;false$$\n");
        sb.append("155;;setObrigatorio;;false$$\n");
        sb.append("156;;setObrigatorio;;false$$\n");

        sb.append("\n146;;cadastrarLogica;;(/s);;").append(CampoLogico.INTERVALO).append(";;{0.00|0.1}$$\n");
        sb.append("146;;cadastrarLogica;;(/s);;").append(CampoLogico.INTERVALO).append(";;{0.00|0.1}$$\n");
        sb.append("146;;cadastrarLogica;;(/s)0,5;;").append(CampoLogico.INTERVALO).append(";;{0.00|105.00}$$\n");
        sb.append("146;;cadastrarLogica;;(/s)1,0;;").append(CampoLogico.INTERVALO).append(";;{105.00|161.00}$$\n");
        sb.append("146;;cadastrarLogica;;(/s)1,5;;").append(CampoLogico.INTERVALO).append(";;{161.00|203.00}$$\n");
        sb.append("146;;cadastrarLogica;;(/s)2,0;;").append(CampoLogico.INTERVALO).append(";;{203.00|245.00}$$\n");
        sb.append("146;;cadastrarLogica;;(/s)2,5;;").append(CampoLogico.INTERVALO).append(";;{245.00|266.00}$$\n");
        sb.append("146;;cadastrarLogica;;(/s)3,0;;").append(CampoLogico.INTERVALO).append(";;{266.00|999.00}$$\n");
        sb.append("146;;setDependencia;;$157CampoNumero$$\n");

        sb.append("\n157;;cadastrarParametroFormula;;$144CampoNumero$$\n");
        sb.append("\n157;;cadastrarParametroFormula;;$145CampoNumero$$\n");

        //desvio padrão
        sb.append("\n141;;adicionarOpcao;;padrão clássico$$\n");
        sb.append("141;;adicionarOpcao;;definido;;$$\n");
        sb.append("147;;vincularHabAoValorDoCampo;;$141CampoDoLaudo;;false;;{definido}$$\n");
        sb.append("146;;vincularHabAoValorDoCampo;;$141CampoDoLaudo;;false;;{padrão clássico}$$\n");
        //dppPelaDum
        sb.append("\n6;;cadastrarParamFormula;;$5CampoDoLaudo$$\n");
        //dppPeloValorInformado
        sb.append("\n155;;cadastrarParamFormula;;$4CampoDoLaudo$$\n");
        sb.append("155;;cadastrarParamFormula;;$144CampoDoLaudo$$\n");
        sb.append("155;;cadastrarParamFormula;;$145CampoDoLaudo$$\n");

        //diasIghDum
        sb.append("\n153;;cadastrarParamFormula;;$4CampoDoLaudo$$\n");
        sb.append("153;;cadastrarParamFormula;;$5CampoDoLaudo$$\n");
        //semanaIghDum
        sb.append("\n154;;cadastrarParamFormula;;$4CampoDoLaudo$$\n");
        sb.append("154;;cadastrarParamFormula;;$5CampoDoLaudo$$\n");

        //diasTghUltEx
        sb.append("\n156;;cadastrarParamFormula;;$4CampoDoLaudo$$\n");
        sb.append("156;;cadastrarParamFormula;;$10CampoDoLaudo$$\n");
        //dppPeloUltEx
        sb.append("\n11;;cadastrarParamFormula;;$10CampoDoLaudo$$\n");
        //dumPeloUltEx
        sb.append("\n10;;cadastrarParamFormula;;$7CampoDoLaudo$$\n");
        sb.append("10;;cadastrarParamFormula;;$8CampoDoLaudo$$\n");
        sb.append("10;;cadastrarParamFormula;;$9CampoDoLaudo$$\n");
        //semanasIghUltEx
        sb.append("\n12;;cadastrarParamFormula;;$4CampoDoLaudo$$\n");
        sb.append("12;;cadastrarParamFormula;;$10CampoDoLaudo$$\n");

        sb.append("\n136;;cadastrarLogica;;;;").append(CampoLogico.INTERVALO).append(";;{0.00|0.01}$$\n");
        sb.append("136;;cadastrarLogica;; (Oligoâmnio - ILA está entre 0,00 e 5,00).;;").append(CampoLogico.INTERVALO).append(";;{0.01|5.0}$$\n");
        sb.append("136;;cadastrarLogica;; (Reduzido - ILA está entre 5,00 e 8,00).;;").append(CampoLogico.INTERVALO).append(";;{5.0|8.0}$$\n");
        sb.append("136;;cadastrarLogica;; (Normal - ILA está entre 8,00 e 22,00).;;").append(CampoLogico.INTERVALO).append(";;{8.0|22.0}$$\n");
        sb.append("136;;cadastrarLogica;; (Aumentado - ILA está entre 22,00 e 25,00).;;").append(CampoLogico.INTERVALO).append(";;{22.0|25.0}$$\n");
        sb.append("136;;cadastrarLogica;; (Poliidrâmnio - ILA é maior ou igual a 25,00).;;").append(CampoLogico.INTERVALO).append(";;{25.0|999.00}$$\n");

        //campo soma biometria
        sb.append("\n135;;cadastrarParametroFormula;;$130CampoNumero$$\n");
        sb.append("135;;cadastrarParametroFormula;;$131CampoNumero$$\n");
        sb.append("135;;cadastrarParametroFormula;;$132CampoNumero$$\n");
        sb.append("135;;cadastrarParametroFormula;;$133CampoNumero$$\n");

        //cordão umbilical
        sb.append("\n125;;adicionarOpcao;;normal;;com duas artérias e uma veia normoinserida.$$\n");
        sb.append("125;;adicionarOpcao;;não visualizado$$\n");
        sb.append("125;;adicionarOpcao;;artéria única$$\n");

        //liquido Amniotico
        sb.append("\n127;;adicionarOpcao;;normal$$\n");
        sb.append("127;;adicionarOpcao;;aumento leve$$\n");
        sb.append("127;;adicionarOpcao;;aumento moderado$$\n");
        sb.append("127;;adicionarOpcao;;aumento acentuado$$\n");
        sb.append("127;;adicionarOpcao;;diminuição leve$$\n");
        sb.append("127;;adicionarOpcao;;diminuição moderada$$\n");
        sb.append("127;;adicionarOpcao;;diminuição acentuada$$\n");

        //canal Endocervical
        sb.append("\n129;;adicionarOpcao;;fechado$$\n");
        sb.append("129;;adicionarOpcao;;não visualizado$$\n");
        sb.append("129;;adicionarOpcao;;pérveo$$\n");

        //ic
        sb.append("\n81;;cadastrarParametroFormula;;$26CampoNumero$$\n");
        sb.append("81;;cadastrarParametroFormula;;$28CampoNumero$$\n");
        //cc
        sb.append("\n82;;cadastrarParametroFormula;;$26CampoNumero$$\n");
        sb.append("82;;cadastrarParametroFormula;;$28CampoNumero$$\n");

        //ccDivca
        sb.append("\n83;;cadastrarParametroFormula;;$82CampoNumero$$\n");
        sb.append("83;;cadastrarParametroFormula;;$72CampoNumero$$\n");
        sb.append("83;;cadastrarParametroFormula;;$73CampoNumero;;2$$\n");
        //cfDivca
        sb.append("\n84;;cadastrarParametroFormula;;$106CampoNumero$$\n");
        sb.append("84;;cadastrarParametroFormula;;$72CampoNumero$$\n");
        sb.append("84;;cadastrarParametroFormula;;$73CampoNumero;;2$$\n");
        //ritmia
        sb.append("\n63;;adicionarOpcao;;rítmicos$$\n");
        sb.append("63;;adicionarOpcao;;arrítmicos$$\n");

        // Peso fetal
        sb.append("\n123;;cadastrarParametroFormula;;$26CampoNumero$$\n");
        sb.append("123;;cadastrarParametroFormula;;$72CampoNumero$$\n");
        sb.append("123;;cadastrarParametroFormula;;$73CampoNumero;;2$$\n");

        //estatuta fetal
        sb.append("\n121;;cadastrarParametroFormula;;$26CampoNumero$$\n");

        //sexo provavel feto
        sb.append("\n119;;adicionarOpcao;;masculino$$\n");
        sb.append("119;;adicionarOpcao;;feminino$$\n");
        sb.append("119;;adicionarOpcao;;não visualizado$$\n");
        sb.append("119;;adicionarOpcao;;não impresso a pedido (masculino)$$\n");
        sb.append("119;;adicionarOpcao;;não impresso a pedido (feminino)$$\n");
        sb.append("119;;adicionarExcecao;;não impresso a pedido (masculino);;$$\n");
        sb.append("119;;adicionarExcecao;;não impresso a pedido (feminino);;$$\n");

        //situação estatica fetal
        sb.append("\n15;;adicionarOpcao;;longitudinal$$\n");
        sb.append("15;;adicionarOpcao;;transversal com polo cefálico a direita$$\n");
        sb.append("\n15;;adicionarOpcao;;transversal com polo cefálico a esquerda$$\n");
        sb.append("15;;adicionarOpcao;;oblíqua$$\n");
        sb.append("15;;adicionarOpcao;;indiferente$$\n");

        sb.append("\n16;;adicionarOpcao;;cefálica$$\n");
        sb.append("16;;adicionarOpcao;;pélvica$$\n");
        sb.append("\n16;;adicionarOpcao;;córmica$$\n");
        sb.append("16;;adicionarOpcao;;indiferente$$\n");
        sb.append("16;;vincularHabAoValorDoCampo;;$15CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico a direita|transversal com polo cefálico a esquerda|oblíqua|indiferente}$$\n");

        sb.append("\n17;;adicionarOpcao;;à esquerda$$\n");
        sb.append("17;;adicionarOpcao;;à direita$$\n");
        sb.append("17;;adicionarOpcao;;anterior$$\n");
        sb.append("17;;adicionarOpcao;;posterior$$\n");
        sb.append("17;;adicionarOpcao;;superior$$\n");
        sb.append("17;;adicionarOpcao;;inferior$$\n");
        sb.append("17;;adicionarOpcao;;indiferente$$\n");
        sb.append("17;;vincularHabAoValorDoCampo;;$15CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico a direita|transversal com polo cefálico a esquerda|oblíqua|indiferente}$$\n");

        // </editor-fold>

        // </editor-fold>

        sb.append("167;;adicionarOpcao;;sim$$\n");
        sb.append("167;;adicionarOpcao;;não$$\n");
        sb.append("155;;vincularHabAoValorDoCampo;;$167CampoDoLaudo;;false;;{sim}$$\n");

        alterarModeloDeLaudo(25);

    }

    static void obs14semanasComRef() throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Construtores">

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento">

        sb.append("\n0;;Topico;;Equipamento$$\n");
        sb.append("\n1;;Linha$$\n");
        sb.append("2;;Enumeracao;;Exame realizado em modo bidimensional com equipamento dinâmico ").append(identificador).append(" multifrequencial.;;true$$\n");

        sb.append("3;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados da gestação">

        sb.append("\n4;;Topico;;Dados da gestação$$\n");

        sb.append("\n5;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("6;;Label;;").append("Gestação gemelar$$\n");
        sb.append("7;;Label;;").append("Gestação múltipla com $$\n");
        // número de fetos
        sb.append("8;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL + ";;1$$\n");
        sb.append("9;;CampoRpn;;C1;;" + identificador + ";;0$$\n");
        sb.append("10;;Label;;").append(" fetos$$\n");
        sb.append("11;;Enumeracao;;, " + identificador + ";;true$$\n");
        sb.append("12;;Enumeracao;;, " + identificador + ";;true$$\n");

        //label data do exame
        sb.append("13;;Label;;").append(Label.DATA_DO_EXAME).append(";;false").append("$$\n");
        //dum
        sb.append("14;;Linha$$\n");
        sb.append("15;;CampoDate;;Data da última menstruação: ").append(CampoSimples.identificador).append(".$$\n");
        //dppPelaDum
        sb.append("16;;CampoRpnData;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;C1 280 ").append(CampoRpnData.UM_DIA_EM_MS).append(" * +$$\n");
        //semanas dum
        sb.append("17;;CampoRpnData;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;C1 C2 - ").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 /$$\n");
        //diasIghUltEx
        sb.append("18;;CampoRpnData;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;C1 C2 - ").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 %$$\n");
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

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto único">

        sb.append("\n26;;Topico;;Feto$$\n");

        // <editor-fold defaultstate="collapsed" desc="Feto único">

        // Situação
        sb.append("\n27;;Linha$$\n");
        sb.append("28;;Enumeracao;;").append("Feto em situação ").append(CampoSimples.identificador).append(";;true$$\n");
        // Apresentacao
        sb.append("29;;Enumeracao;;").append(", apresentação ").append(CampoSimples.identificador).append(".$$\n");

        sb.append("\n30;;Linha$$\n");
        // Dorso
        sb.append("31;;Enumeracao;;").append("Dorso ").append(CampoSimples.identificador).append("$$\n");
        // Movimentos fetais
        sb.append("32;;Enumeracao;;").append(", movimentos fetais ").append(CampoSimples.identificador).append(".$$\n");

        // Movimentos respiratórios
        sb.append("\n33;;Linha$$\n");
        sb.append("34;;Enumeracao;;").append("Movimentos respiratórios ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Batimentos cardíacos fetais
        sb.append("\n35;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("36;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Ritmia
        sb.append("37;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        // BPM
        sb.append("38;;CampoInteiro;; de " + CampoSimples.identificador + " bpm;;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos internos">

        sb.append("\n39;;Linha;;<b>Órgãos internos:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("40;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");

        // Descrição
        sb.append("41;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria">

        sb.append("42;;Linha;;</div><table class=\"topico\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td width=\"75%\"><b>Biometria:</b></td><td align=\"center\" width=\"25%\">" + Linha.TEXTO_CAMPOS_FILHOS + "</td></tr>$$\n");
        sb.append("43;;CampoRpn;;C1;;<b>Ref. p/ " + CampoSimples.identificador + " sem.</b>;;2$$\n");

        //D.B.P (mm)
        sb.append("44;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("45;;CampoInteiro;;Diâmetro biparietal de " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("46;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // IC
        sb.append("47;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("48;;CampoRpn;;C1 100 * C2 /;;Índice cefálico: " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("49;;Label;;74 a 86$$\n");
        // C.A (mm)
        sb.append("50;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_2 + LinhaDaTbl.HTML_FILHO_3 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_4 + "</td></tr>$$");
        sb.append("51;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        sb.append("52;;CampoRpn;;1.57 C1 C2 + *;;Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.;;0$$\n");
        sb.append("53;;CampoInteiro;;Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("54;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CC
        sb.append("55;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("56;;CampoRpn;;C1 C2 + 2 / pi * 1.013 *;;Circunferência craniana fetal: " + CampoSimples.identificador + " mm.;;2$$\n");
        sb.append("57;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CC Div CA
        sb.append("58;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("59;;CampoRpn;;C1 C2 /;;Circunferência craniana / circunferência abdominal: " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("60;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        //C.F (mm)
        sb.append("61;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("62;;CampoInteiro;;Comprimento do fêmur: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("63;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CF / CA
        sb.append("64;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("65;;CampoRpn;;C1 100 * C2 /;;C.F. / C.A. (Hadlock): " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("66;;Label;;20 a 24$$\n");
        // Umero (mm)
        sb.append("67;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("68;;CampoInteiro;;Comprimento do úmero: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("69;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Ulna (mm)
        sb.append("70;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("71;;CampoInteiro;;Comprimento da ulna: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("72;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Tibia (mm)
        sb.append("73;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("74;;CampoInteiro;;Comprimento da tíbia: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("75;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Peso
        sb.append("76;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr></table><div class=\"topico\">$$");
        sb.append("77;;CampoRpn;;10 -1.7492 .0166 C1 * + .0046 C2 * + 2.646 C1 C2 * 100000 / * - ^ 1000 *;;Peso fetal provável: " + CampoSimples.identificador + " g (±10%).;;2$$\n");
        sb.append("78;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");

        sb.append("79;;Linha$$\n");
        // Estatura
        sb.append("80;;CampoRpn;;C1 0.55 *;;<p style=\"margin-top: 0\">Estatura fetal provável: " + CampoSimples.identificador + " cm.</p>;;2$$\n");
        // Sexo
        sb.append("81;;Enumeracao;;<p style=\"margin-top: 0\">Sexo fetal provável: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // Gordura
        sb.append("82;;Enumeracao;;<p style=\"margin-top: 0\">Gordura pré-peritoneal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // Estadiamento intestinal
        sb.append("83;;Enumeracao;;<p style=\"margin-top: 0\">Estadiamento intestinal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // D.O.F (mm)
        sb.append("84;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL +";;3$$\n");
        // D.A.P (mm)
        sb.append("85;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");
        // D.L.L (mm)
        sb.append("86;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        sb.append("\n87;;Linha;;\n");
        sb.append("<b>Placenta:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //inserção 1
        sb.append("88;;Enumeracao;;<p style=\"margin-top: 0\">De inserção ").append(CampoSimples.identificador).append(";;true$$\n");
        //insercao 2
        sb.append("89;;Enumeracao;; ").append(CampoSimples.identificador).append(".</p>$$\n");
        //espessura
        sb.append("90;;CampoInteiro;;<p style=\"margin-top: 0\">Espessura: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        //maturidade
        sb.append("91;;Enumeracao;;<p style=\"margin-top: 0\">Apresentando ").append(CampoSimples.identificador).append(" (GRANNUM 0, 1, 2, 3).</p>$$\n");

        // Descrição
        sb.append("92;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados placenta">

        //cordão umbilical
        sb.append("\n93;;Linha;;<b>Cordão umbilical:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("94;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");

        //liquido amniótico
        sb.append("\n95;;Linha;;<b>Líquido amniótico:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("96;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append(";;true$$\n");
        //quadrante 1
        sb.append("97;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 2
        sb.append("98;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 3
        sb.append("99;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 4
        sb.append("100;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        // ILA
        sb.append("\n101;;Linha;;<b>Índice do líquido amniótico:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("102;;CampoRpn;;C1 C2 C3 C4 + + +;;<p style=\"margin-top: 0\">" + CampoSimples.identificador + " cm ;;2$$\n");
        sb.append("103;;CampoLogico;;$102CampoNumero;;"+CampoSimples.identificador + "$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 1">

        sb.append("\n104;;Topico;;Feto 1$$\n");

        // <editor-fold defaultstate="collapsed" desc="Feto 1">

        //situação
        sb.append("\n105;;Linha$$\n");
        sb.append("106;;Enumeracao;;").append("Feto em situação ").append(CampoSimples.identificador).append(";;true$$\n");
        //apresentacao
        sb.append("107;;Enumeracao;;").append(", apresentação ").append(CampoSimples.identificador).append(".$$\n");
        sb.append("\n108;;Linha$$\n");
        //dorso
        sb.append("109;;Enumeracao;;").append("Dorso ").append(CampoSimples.identificador).append("$$\n");
        //movimentos fetais
        sb.append("110;;Enumeracao;;").append(", movimentos fetais ").append(CampoSimples.identificador).append(".$$\n");
        //Movimentos respiratórios
        sb.append("\n111;;Linha$$\n");
        sb.append("112;;Enumeracao;;").append("Movimentos respiratórios ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Batimentos cardíacos fetais
        sb.append("\n113;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("114;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Ritmia
        sb.append("115;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        // BPM
        sb.append("116;;CampoInteiro;; de " + CampoSimples.identificador + " bpm;;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos internos">

        sb.append("\n117;;Linha;;<b>Órgãos internos:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("118;;Enumeracao;;<p style=\"margin-top: 0\">").
                append(CampoSimples.identificador).append("</p>;;true$$\n");

        // Descrição
        sb.append("119;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria">

        sb.append("120;;Linha;;</div><table class=\"topico\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td width=\"75%\"><b>Biometria:</b></td><td align=\"center\" width=\"25%\">" + Linha.TEXTO_CAMPOS_FILHOS + "</td></tr>$$\n");
        sb.append("121;;CampoRpn;;C1;;<b>Ref. p/ " + CampoSimples.identificador + " sem.</b>;;2$$\n");

        //D.B.P (mm)
        sb.append("\n122;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("123;;CampoInteiro;;Diâmetro biparietal de " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("124;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // IC
        sb.append("125;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("126;;CampoRpn;;C1 100 * C2 /;;Índice cefálico: " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("127;;Label;;74 a 86$$\n");
        // C.A (mm)
        sb.append("128;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_2 + LinhaDaTbl.HTML_FILHO_3 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_4 + "</td></tr>$$");
        sb.append("129;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        sb.append("130;;CampoRpn;;1.57 C1 C2 + *;;Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.;;0$$\n");
        sb.append("131;;CampoInteiro;;Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("132;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CC
        sb.append("133;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("134;;CampoRpn;;C1 C2 + 2 / pi * 1.013 *;;Circunferência craniana fetal: " + CampoSimples.identificador + " mm.;;2$$\n");
        sb.append("135;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CC Div CA
        sb.append("136;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("137;;CampoRpn;;C1 C2 /;;Circunferência craniana / circunferência abdominal: " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("138;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        //C.F (mm)
        sb.append("139;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("140;;CampoInteiro;;Comprimento do fêmur: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("141;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CF / CA
        sb.append("142;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("143;;CampoRpn;;C1 100 * C2 /;;C.F. / C.A. (Hadlock): " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("144;;Label;;20 a 24$$\n");
        // Umero (mm)
        sb.append("145;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("146;;CampoInteiro;;Comprimento do úmero: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("147;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Ulna (mm)
        sb.append("148;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("149;;CampoInteiro;;Comprimento da ulna: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("150;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Tibia (mm)
        sb.append("151;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("152;;CampoInteiro;;Comprimento da tíbia: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("153;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Peso
        sb.append("154;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr></table><div class=\"topico\">$$");
        sb.append("155;;CampoRpn;;10 -1.7492 .0166 C1 * + .0046 C2 * + 2.646 C1 C2 * 100000 / * - ^ 1000 *;;Peso fetal provável: " + CampoSimples.identificador + " g (±10%).;;2$$\n");
        sb.append("156;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");

        sb.append("157;;Linha$$\n");
        // Estatura
        sb.append("158;;CampoRpn;;C1 0.55 *;;<p style=\"margin-top: 0\">Estatura fetal provável: " + CampoSimples.identificador + " cm.</p>;;2$$\n");
        //sexo
        sb.append("159;;Enumeracao;;<p style=\"margin-top: 0\">Sexo fetal provável: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        //gordura
        sb.append("160;;Enumeracao;;<p style=\"margin-top: 0\">Gordura pré-peritoneal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // Estadiamento intestinal
        sb.append("161;;Enumeracao;;<p style=\"margin-top: 0\">Estadiamento intestinal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // D.O.F (mm)
        sb.append("162;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL +";;3$$\n");
        // D.A.P (mm)
        sb.append("163;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");
        // D.L.L (mm)
        sb.append("164;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        sb.append("\n165;;Linha;;<b>Placenta:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        //inserção 1
        sb.append("166;;Enumeracao;;<p style=\"margin-top: 0\">De inserção ").append(CampoSimples.identificador).append(";;true$$\n");
        //insercao 2
        sb.append("167;;Enumeracao;; ").append(CampoSimples.identificador).append(".</p>$$\n");
        //espessura
        sb.append("168;;CampoInteiro;;<p style=\"margin-top: 0\">Espessura: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        //maturidade
        sb.append("169;;Enumeracao;;<p style=\"margin-top: 0\">Apresentando ").append(CampoSimples.identificador).append(" (GRANNUM 0, 1, 2, 3).</p>$$\n");

        // Descrição
        sb.append("170;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras inf">

        //cordão umbilical
        sb.append("\n171;;Linha;;<b>Cordão umbilical:</b></p>").append(
                Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("172;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");

        //liquido amniótico
        sb.append("\n173;;Linha;;<b>Líquido amniótico:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("174;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        //quadrante 1
        sb.append("175;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 2
        sb.append("176;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 3
        sb.append("177;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 4
        sb.append("178;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        // ILA
        sb.append("\n179;;Linha;;<p style=\"margin-top: 0\"><b>Índice do líquido amniótico:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("180;;CampoRpn;;C1 C2 C3 C4 + + +;;<p style=\"margin-top: 0\">" + CampoSimples.identificador + " cm ;;2$$\n");
        sb.append("181;;CampoLogico;;$180CampoNumero;;"+CampoSimples.identificador + "</p>$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 2">

        sb.append("\n182;;Topico;;Feto 2$$\n");

        // <editor-fold defaultstate="collapsed" desc="Feto 2">

        //situação
        sb.append("\n183;;Linha$$\n");
        sb.append("184;;Enumeracao;;").append("Feto em situação ").append(CampoSimples.identificador).append(";;true$$\n");
        //apresentacao
        sb.append("185;;Enumeracao;;").append(", apresentação ").append(CampoSimples.identificador).append(".$$\n");
        sb.append("\n186;;Linha$$\n");
        //dorso
        sb.append("187;;Enumeracao;;").append("Dorso ").append(CampoSimples.identificador).append("$$\n");
        //movimentos fetais
        sb.append("188;;Enumeracao;;").append(", movimentos fetais ").append(CampoSimples.identificador).append(".$$\n");
        //Movimentos respiratórios
        sb.append("\n189;;Linha$$\n");
        sb.append("190;;Enumeracao;;").append("Movimentos respiratórios ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Batimentos cardíacos fetais
        sb.append("\n191;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("192;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Ritmia
        sb.append("193;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        // BPM
        sb.append("194;;CampoInteiro;; de " + CampoSimples.identificador + " bpm;;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="órgãos internos Feto2">

        sb.append("\n195;;Linha;;<b>Órgãos internos:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("196;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");

        // Descrição
        sb.append("197;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria Feto2">

        sb.append("198;;Linha;;</div><table class=\"topico\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td width=\"75%\"><b>Biometria:</b></td><td align=\"center\" width=\"25%\">" + Linha.TEXTO_CAMPOS_FILHOS + "</td></tr>$$\n");
        sb.append("199;;CampoRpn;;C1;;<b>Ref. p/ " + CampoSimples.identificador + " sem.</b>;;2$$\n");

        // D.B.P (mm)
        sb.append("\n200;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("201;;CampoInteiro;;Diâmetro biparietal de " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("202;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // IC
        sb.append("203;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("204;;CampoRpn;;C1 100 * C2 /;;Índice cefálico: " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("205;;Label;;74 a 86$$\n");
        // C.A (mm)
        sb.append("206;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_2 + LinhaDaTbl.HTML_FILHO_3 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_4 + "</td></tr>$$");
        sb.append("207;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        sb.append("208;;CampoRpn;;1.57 C1 C2 + *;;Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.;;0$$\n");
        sb.append("209;;CampoInteiro;;Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("210;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CC
        sb.append("211;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("212;;CampoRpn;;C1 C2 + 2 / pi * 1.013 *;;Circunferência craniana fetal: " + CampoSimples.identificador + " mm.;;2$$\n");
        sb.append("213;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CC Div CA
        sb.append("214;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("215;;CampoRpn;;C1 C2 /;;Circunferência craniana / circunferência abdominal: " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("216;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        //C.F (mm)
        sb.append("217;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("218;;CampoInteiro;;Comprimento do fêmur: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("219;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CF / CA
        sb.append("220;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("221;;CampoRpn;;C1 100 * C2 /;;C.F. / C.A. (Hadlock): " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("222;;Label;;20 a 24$$\n");
        // Umero (mm)
        sb.append("223;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("224;;CampoInteiro;;Comprimento do úmero: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("225;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Ulna (mm)
        sb.append("226;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("227;;CampoInteiro;;Comprimento da ulna: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("228;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Tibia (mm)
        sb.append("229;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("230;;CampoInteiro;;Comprimento da tíbia: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("231;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Peso
        sb.append("232;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr></table><div class=\"topico\">$$");
        sb.append("233;;CampoRpn;;10 -1.7492 .0166 C1 * + .0046 C2 * + 2.646 C1 C2 * 100000 / * - ^ 1000 *;;Peso fetal provável: " + CampoSimples.identificador + " g (±10%).;;2$$\n");
        sb.append("234;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");

        sb.append("235;;Linha$$\n");
        // Estatura
        sb.append("236;;CampoRpn;;C1 0.55 *;;<p style=\"margin-top: 0\">Estatura fetal provável: " + CampoSimples.identificador + " cm.</p>;;2$$\n");
        //sexo
        sb.append("237;;Enumeracao;;<p style=\"margin-top: 0\">Sexo fetal provável: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        //gordura
        sb.append("238;;Enumeracao;;<p style=\"margin-top: 0\">Gordura pré-peritoneal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // Estadiamento intestinal
        sb.append("239;;Enumeracao;;<p style=\"margin-top: 0\">Estadiamento intestinal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // D.O.F (mm)
        sb.append("240;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL +";;3$$\n");
        // D.A.P (mm)
        sb.append("241;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");
        // D.L.L (mm)
        sb.append("242;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta Feto2">
        sb.append("\n243;;Linha;;\n");
        sb.append("<b>Placenta:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //inserção 1
        sb.append("244;;Enumeracao;;<p style=\"margin-top: 0\">De inserção ").append(CampoSimples.identificador).append(";;true$$\n");
        //insercao 2
        sb.append("245;;Enumeracao;; ").append(CampoSimples.identificador).append(".</p>$$\n");
        //espessura
        sb.append("246;;CampoInteiro;;<p style=\"margin-top: 0\">Espessura: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        //maturidade
        sb.append("247;;Enumeracao;;<p style=\"margin-top: 0\">Apresentando ").append(CampoSimples.identificador).append(" (GRANNUM 0, 1, 2, 3).</p>$$\n");

        // Descrição
        sb.append("248;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="dados placenta Feto2">
        sb.append("\n249;;Linha;;\n");
        sb.append("<b>Cordão umbilical:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //cordão umbilical
        sb.append("250;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");
        sb.append("\n251;;Linha;;\n");
        sb.append("<b>Líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //liquido amniótico
        sb.append("252;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append(".</p>;;true$$\n");

        //quadrante 1
        sb.append("253;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 2
        sb.append("254;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 3
        sb.append("255;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 4
        sb.append("256;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //soma
        sb.append("\n257;;Linha;;\n");
        sb.append("<b>Índice do líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        sb.append("258;;CampoRpn;;C1 C2 C3 C4 + + +;;<p style=\"margin-top: 0\">" + CampoSimples.identificador + " cm ;;2$$\n");
        sb.append("259;;CampoLogico;;$258CampoNumero;;"+CampoSimples.identificador + "</p>$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 3">

        sb.append("\n260;;Topico;;Feto 3$$\n");

        // <editor-fold defaultstate="collapsed" desc="Feto 3">

        //situação
        sb.append("\n261;;Linha$$\n");
        sb.append("262;;Enumeracao;;").append("Feto em situação ").append(CampoSimples.identificador).append(";;true$$\n");
        //apresentacao
        sb.append("263;;Enumeracao;;").append(", apresentação ").append(CampoSimples.identificador).append(".$$\n");
        sb.append("\n264;;Linha$$\n");
        //dorso
        sb.append("265;;Enumeracao;;").append("Dorso ").append(CampoSimples.identificador).append("$$\n");
        //movimentos fetais
        sb.append("266;;Enumeracao;;").append(", movimentos fetais ").append(CampoSimples.identificador).append(".$$\n");
        //Movimentos respiratórios
        sb.append("\n267;;Linha$$\n");
        sb.append("268;;Enumeracao;;").append("Movimentos respiratórios ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Batimentos cardíacos fetais
        sb.append("\n269;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("270;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Ritmia
        sb.append("271;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        // BPM
        sb.append("272;;CampoInteiro;; de " + CampoSimples.identificador + " bpm;;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="órgãos internos Feto3">

        sb.append("\n273;;Linha;;<b>Órgãos internos:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("274;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");

        // Descrição
        sb.append("275;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria Feto3">

        sb.append("276;;Linha;;</div><table class=\"topico\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td width=\"75%\"><b>Biometria:</b></td><td align=\"center\" width=\"25%\">" + Linha.TEXTO_CAMPOS_FILHOS + "</td></tr>$$\n");
        sb.append("277;;CampoRpn;;C1;;<b>Ref. p/ " + CampoSimples.identificador + " sem.</b>;;2$$\n");

        //D.B.P (mm)
        sb.append("\n278;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("279;;CampoInteiro;;Diâmetro biparietal de " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("280;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // IC
        sb.append("281;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("282;;CampoRpn;;C1 100 * C2 /;;Índice cefálico: " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("283;;Label;;74 a 86$$\n");
        // C.A (mm)
        sb.append("284;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_2 + LinhaDaTbl.HTML_FILHO_3 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_4 + "</td></tr>$$");
        sb.append("285;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        sb.append("286;;CampoRpn;;1.57 C1 C2 + *;;Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.;;0$$\n");
        sb.append("287;;CampoInteiro;;Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("288;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CC
        sb.append("289;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("290;;CampoRpn;;C1 C2 + 2 / pi * 1.013 *;;Circunferência craniana fetal: " + CampoSimples.identificador + " mm.;;2$$\n");
        sb.append("291;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CC Div CA
        sb.append("292;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("293;;CampoRpn;;C1 C2 /;;Circunferência craniana / circunferência abdominal: " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("294;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        //C.F (mm)
        sb.append("295;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("296;;CampoInteiro;;Comprimento do fêmur: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("297;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CF / CA
        sb.append("298;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("299;;CampoRpn;;C1 100 * C2 /;;C.F. / C.A. (Hadlock): " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("300;;Label;;20 a 24$$\n");
        // Umero (mm)
        sb.append("301;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("302;;CampoInteiro;;Comprimento do úmero: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("303;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Ulna (mm)
        sb.append("304;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("305;;CampoInteiro;;Comprimento da ulna: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("306;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Tibia (mm)
        sb.append("307;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("308;;CampoInteiro;;Comprimento da tíbia: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("309;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Peso
        sb.append("310;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr></table><div class=\"topico\">$$");
        sb.append("311;;CampoRpn;;10 -1.7492 .0166 C1 * + .0046 C2 * + 2.646 C1 C2 * 100000 / * - ^ 1000 *;;Peso fetal provável: " + CampoSimples.identificador + " g (±10%).;;2$$\n");
        sb.append("312;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");

        sb.append("313;;Linha$$\n");
        // Estatura
        sb.append("314;;CampoRpn;;C1 0.55 *;;<p style=\"margin-top: 0\">Estatura fetal provável: " + CampoSimples.identificador + " cm.</p>;;2$$\n");
        //sexo
        sb.append("315;;Enumeracao;;<p style=\"margin-top: 0\">Sexo fetal provável: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        //gordura
        sb.append("316;;Enumeracao;;<p style=\"margin-top: 0\">Gordura pré-peritoneal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // Estadiamento intestinal
        sb.append("317;;Enumeracao;;<p style=\"margin-top: 0\">Estadiamento intestinal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // D.O.F (mm)
        sb.append("318;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL +";;3$$\n");
        // D.A.P (mm)
        sb.append("319;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");
        // D.L.L (mm)
        sb.append("320;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta Feto3">
        sb.append("\n321;;Linha;;\n");
        sb.append("<b>Placenta:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //inserção 1
        sb.append("322;;Enumeracao;;<p style=\"margin-top: 0\">De inserção ").append(CampoSimples.identificador).append(";;true$$\n");
        //insercao 2
        sb.append("323;;Enumeracao;; ").append(CampoSimples.identificador).append(".</p>$$\n");
        //espessura
        sb.append("324;;CampoInteiro;;<p style=\"margin-top: 0\">Espessura: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        //maturidade
        sb.append("325;;Enumeracao;;<p style=\"margin-top: 0\">Apresentando ").append(CampoSimples.identificador).append(" (GRANNUM 0, 1, 2, 3).</p>$$\n");

        // Descrição
        sb.append("326;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="dados placenta Feto3">
        sb.append("\n327;;Linha;;\n");
        sb.append("<b>Cordão umbilical:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //cordão umbilical
        sb.append("328;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");
        sb.append("\n329;;Linha;;\n");
        sb.append("<b>Líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //liquido amniótico
        sb.append("330;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append(".</p>;;true$$\n");

        //quadrante 1
        sb.append("331;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 2
        sb.append("332;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 3
        sb.append("333;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 4
        sb.append("334;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //soma
        sb.append("\n335;;Linha;;\n");
        sb.append("<b>Índice do líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        sb.append("336;;CampoRpn;;C1 C2 C3 C4 + + +;;<p style=\"margin-top: 0\">" + CampoSimples.identificador + " cm ;;2$$\n");
        sb.append("337;;CampoLogico;;$336CampoNumero;;"+CampoSimples.identificador + "</p>$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 4">

        sb.append("\n338;;Topico;;Feto 4$$\n");

        // <editor-fold defaultstate="collapsed" desc="Feto 4">

        //situação
        sb.append("\n339;;Linha$$\n");
        sb.append("340;;Enumeracao;;").append("Feto em situação ").append(CampoSimples.identificador).append(";;true$$\n");
        //apresentacao
        sb.append("341;;Enumeracao;;").append(", apresentação ").append(CampoSimples.identificador).append(".$$\n");
        sb.append("\n342;;Linha$$\n");
        //dorso
        sb.append("343;;Enumeracao;;").append("Dorso ").append(CampoSimples.identificador).append("$$\n");
        //movimentos fetais
        sb.append("344;;Enumeracao;;").append(", movimentos fetais ").append(CampoSimples.identificador).append(".$$\n");
        //Movimentos respiratórios
        sb.append("\n345;;Linha$$\n");
        sb.append("346;;Enumeracao;;").append("Movimentos respiratórios ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Batimentos cardíacos fetais
        sb.append("\n347;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("348;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Ritmia
        sb.append("349;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        // BPM
        sb.append("350;;CampoInteiro;; de " + CampoSimples.identificador + " bpm;;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="órgãos internos Feto4">
        sb.append("\n351;;Linha;;<b>Órgãos internos:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("352;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");

        // Descrição
        sb.append("353;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria Feto4">

        sb.append("354;;Linha;;</div><table class=\"topico\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td width=\"75%\"><b>Biometria:</b></td><td align=\"center\" width=\"25%\">" + Linha.TEXTO_CAMPOS_FILHOS + "</td></tr>$$\n");
        sb.append("355;;CampoRpn;;C1;;<b>Ref. p/ " + CampoSimples.identificador + " sem.</b>;;2$$\n");

        //D.B.P (mm)
        sb.append("\n356;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("357;;CampoInteiro;;Diâmetro biparietal de " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("358;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // IC
        sb.append("359;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("360;;CampoRpn;;C1 100 * C2 /;;Índice cefálico: " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("361;;Label;;74 a 86$$\n");
        // C.A (mm)
        sb.append("362;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_2 + LinhaDaTbl.HTML_FILHO_3 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_4 + "</td></tr>$$");
        sb.append("363;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        sb.append("364;;CampoRpn;;1.57 C1 C2 + *;;Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.;;0$$\n");
        sb.append("365;;CampoInteiro;;Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("366;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CC
        sb.append("367;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("368;;CampoRpn;;C1 C2 + 2 / pi * 1.013 *;;Circunferência craniana fetal: " + CampoSimples.identificador + " mm.;;2$$\n");
        sb.append("369;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CC Div CA
        sb.append("370;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("371;;CampoRpn;;C1 C2 /;;Circunferência craniana / circunferência abdominal: " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("372;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        //C.F (mm)
        sb.append("373;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("374;;CampoInteiro;;Comprimento do fêmur: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("375;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CF / CA
        sb.append("376;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("377;;CampoRpn;;C1 100 * C2 /;;C.F. / C.A. (Hadlock): " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("378;;Label;;20 a 24$$\n");
        // Umero (mm)
        sb.append("379;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("380;;CampoInteiro;;Comprimento do úmero: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("381;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Ulna (mm)
        sb.append("382;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("383;;CampoInteiro;;Comprimento da ulna: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("384;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Tibia (mm)
        sb.append("385;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("386;;CampoInteiro;;Comprimento da tíbia: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("387;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Peso
        sb.append("388;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr></table><div class=\"topico\">$$");
        sb.append("389;;CampoRpn;;10 -1.7492 .0166 C1 * + .0046 C2 * + 2.646 C1 C2 * 100000 / * - ^ 1000 *;;Peso fetal provável: " + CampoSimples.identificador + " g (±10%).;;2$$\n");
        sb.append("390;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");

        sb.append("391;;Linha$$\n");
        // Estatura
        sb.append("392;;CampoRpn;;C1 0.55 *;;<p style=\"margin-top: 0\">Estatura fetal provável: " + CampoSimples.identificador + " cm.</p>;;2$$\n");
        //sexo
        sb.append("393;;Enumeracao;;<p style=\"margin-top: 0\">Sexo fetal provável: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        //gordura
        sb.append("394;;Enumeracao;;<p style=\"margin-top: 0\">Gordura pré-peritoneal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // Estadiamento intestinal
        sb.append("395;;Enumeracao;;<p style=\"margin-top: 0\">Estadiamento intestinal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // D.O.F (mm)
        sb.append("396;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL +";;3$$\n");
        // D.A.P (mm)
        sb.append("397;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");
        // D.L.L (mm)
        sb.append("398;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta Feto4">
        sb.append("\n399;;Linha;;\n");
        sb.append("<b>Placenta:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //inserção 1
        sb.append("400;;Enumeracao;;<p style=\"margin-top: 0\">De inserção ").append(CampoSimples.identificador).append(";;true$$\n");
        //insercao 2
        sb.append("401;;Enumeracao;; ").append(CampoSimples.identificador).append(".</p>$$\n");
        //espessura
        sb.append("402;;CampoInteiro;;<p style=\"margin-top: 0\">Espessura: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        //maturidade
        sb.append("403;;Enumeracao;;<p style=\"margin-top: 0\">Apresentando ").append(CampoSimples.identificador).append(" (GRANNUM 0, 1, 2, 3).</p>$$\n");

        // Descrição
        sb.append("404;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="dados placenta Feto4">
        sb.append("\n405;;Linha;;\n");
        sb.append("<b>Cordão umbilical:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //cordão umbilical
        sb.append("406;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");
        sb.append("\n407;;Linha;;\n");
        sb.append("<b>Líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //liquido amniótico
        sb.append("408;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append(".</p>;;true$$\n");

        //quadrante 1
        sb.append("409;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 2
        sb.append("410;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 3
        sb.append("411;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 4
        sb.append("412;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //soma
        sb.append("\n413;;Linha;;\n");
        sb.append("<b>Índice do líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        sb.append("414;;CampoRpn;;C1 C2 C3 C4 + + +;;<p style=\"margin-top: 0\">" + CampoSimples.identificador + " cm ;;2$$\n");
        sb.append("415;;CampoLogico;;$414CampoNumero;;"+CampoSimples.identificador + "</p>$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 5">

        sb.append("\n416;;Topico;;Feto 5$$\n");

        // <editor-fold defaultstate="collapsed" desc="Feto 5">

        //situação
        sb.append("\n417;;Linha$$\n");
        sb.append("418;;Enumeracao;;").append("Feto em situação ").append(CampoSimples.identificador).append(";;true$$\n");
        //apresentacao
        sb.append("419;;Enumeracao;;").append(", apresentação ").append(CampoSimples.identificador).append(".$$\n");
        sb.append("\n420;;Linha$$\n");
        //dorso
        sb.append("421;;Enumeracao;;").append("Dorso ").append(CampoSimples.identificador).append("$$\n");
        //movimentos fetais
        sb.append("422;;Enumeracao;;").append(", movimentos fetais ").append(CampoSimples.identificador).append(".$$\n");
        //Movimentos respiratórios
        sb.append("\n423;;Linha$$\n");
        sb.append("424;;Enumeracao;;").append("Movimentos respiratórios ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Batimentos cardíacos fetais
        sb.append("\n425;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("426;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Ritmia
        sb.append("427;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        // BPM
        sb.append("428;;CampoInteiro;; de " + CampoSimples.identificador + " bpm;;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="órgãos internos Feto5">
        sb.append("\n429;;Linha;;<b>Órgãos internos:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("430;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");

        // Descrição
        sb.append("431;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria Feto5">

        sb.append("432;;Linha;;</div><table class=\"topico\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td width=\"75%\"><b>Biometria:</b></td><td align=\"center\" width=\"25%\">" + Linha.TEXTO_CAMPOS_FILHOS + "</td></tr>$$\n");
        sb.append("433;;CampoRpn;;C1;;<b>Ref. p/ " + CampoSimples.identificador + " sem.</b>;;2$$\n");

        //D.B.P (mm)
        sb.append("\n434;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("435;;CampoInteiro;;Diâmetro biparietal de " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("436;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // IC
        sb.append("437;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("438;;CampoRpn;;C1 100 * C2 /;;Índice cefálico: " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("439;;Label;;74 a 86$$\n");
        // C.A (mm)
        sb.append("440;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_2 + LinhaDaTbl.HTML_FILHO_3 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_4 + "</td></tr>$$");
        sb.append("441;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        sb.append("442;;CampoRpn;;1.57 C1 C2 + *;;Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.;;0$$\n");
        sb.append("443;;CampoInteiro;;Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("444;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CC
        sb.append("445;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("446;;CampoRpn;;C1 C2 + 2 / pi * 1.013 *;;Circunferência craniana fetal: " + CampoSimples.identificador + " mm.;;2$$\n");
        sb.append("447;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CC Div CA
        sb.append("448;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("449;;CampoRpn;;C1 C2 /;;Circunferência craniana / circunferência abdominal: " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("450;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        //C.F (mm)
        sb.append("451;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("452;;CampoInteiro;;Comprimento do fêmur: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("453;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CF / CA
        sb.append("454;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("455;;CampoRpn;;C1 100 * C2 /;;C.F. / C.A. (Hadlock): " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("456;;Label;;20 a 24$$\n");
        // Umero (mm)
        sb.append("457;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("458;;CampoInteiro;;Comprimento do úmero: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("459;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Ulna (mm)
        sb.append("460;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("461;;CampoInteiro;;Comprimento da ulna: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("462;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Tibia (mm)
        sb.append("463;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("464;;CampoInteiro;;Comprimento da tíbia: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("465;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Peso
        sb.append("466;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr></table><div class=\"topico\">$$");
        sb.append("467;;CampoRpn;;10 -1.7492 .0166 C1 * + .0046 C2 * + 2.646 C1 C2 * 100000 / * - ^ 1000 *;;Peso fetal provável: " + CampoSimples.identificador + " g (±10%).;;2$$\n");
        sb.append("468;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");

        sb.append("469;;Linha$$\n");
        // Estatura
        sb.append("470;;CampoRpn;;C1 0.55 *;;<p style=\"margin-top: 0\">Estatura fetal provável: " + CampoSimples.identificador + " cm.</p>;;2$$\n");
        //sexo
        sb.append("471;;Enumeracao;;<p style=\"margin-top: 0\">Sexo fetal provável: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        //gordura
        sb.append("472;;Enumeracao;;<p style=\"margin-top: 0\">Gordura pré-peritoneal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // Estadiamento intestinal
        sb.append("473;;Enumeracao;;<p style=\"margin-top: 0\">Estadiamento intestinal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // D.O.F (mm)
        sb.append("474;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL +";;3$$\n");
        // D.A.P (mm)
        sb.append("475;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");
        // D.L.L (mm)
        sb.append("476;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta Feto5">
        sb.append("\n477;;Linha;;\n");
        sb.append("<b>Placenta:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //inserção 1
        sb.append("478;;Enumeracao;;<p style=\"margin-top: 0\">De inserção ").append(CampoSimples.identificador).append(";;true$$\n");
        //insercao 2
        sb.append("479;;Enumeracao;; ").append(CampoSimples.identificador).append(".</p>$$\n");
        //espessura
        sb.append("480;;CampoInteiro;;<p style=\"margin-top: 0\">Espessura: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        //maturidade
        sb.append("481;;Enumeracao;;<p style=\"margin-top: 0\">Apresentando ").append(CampoSimples.identificador).append(" (GRANNUM 0, 1, 2, 3).</p>$$\n");

        // Descrição
        sb.append("482;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="dados placenta Feto5">
        sb.append("\n483;;Linha;;\n");
        sb.append("<b>Cordão umbilical:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //cordão umbilical
        sb.append("484;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");
        sb.append("\n485;;Linha;;\n");
        sb.append("<b>Líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //liquido amniótico
        sb.append("486;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append(".</p>;;true$$\n");

        //quadrante 1
        sb.append("487;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 2
        sb.append("488;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 3
        sb.append("489;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 4
        sb.append("490;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //soma
        sb.append("\n491;;Linha;;\n");
        sb.append("<b>Índice do líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        sb.append("492;;CampoRpn;;C1 C2 C3 C4 + + +;;<p style=\"margin-top: 0\">" + CampoSimples.identificador + " cm ;;2$$\n");
        sb.append("493;;CampoLogico;;$492CampoNumero;;"+CampoSimples.identificador + "</p>$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 6">

        sb.append("\n494;;Topico;;Feto 6$$\n");

        // <editor-fold defaultstate="collapsed" desc="Feto 6">

        //situação
        sb.append("\n495;;Linha$$\n");
        sb.append("496;;Enumeracao;;").append("Feto em situação ").append(CampoSimples.identificador).append(";;true$$\n");
        //apresentacao
        sb.append("497;;Enumeracao;;").append(", apresentação ").append(CampoSimples.identificador).append(".$$\n");
        sb.append("\n498;;Linha$$\n");
        //dorso
        sb.append("499;;Enumeracao;;").append("Dorso ").append(CampoSimples.identificador).append("$$\n");
        //movimentos fetais
        sb.append("500;;Enumeracao;;").append(", movimentos fetais ").append(CampoSimples.identificador).append(".$$\n");
        //Movimentos respiratórios
        sb.append("\n501;;Linha$$\n");
        sb.append("502;;Enumeracao;;").append("Movimentos respiratórios ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Batimentos cardíacos fetais
        sb.append("\n503;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("504;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Ritmia
        sb.append("505;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        // BPM
        sb.append("506;;CampoInteiro;; de " + CampoSimples.identificador + " bpm;;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="órgãos internos Feto6">
        sb.append("\n507;;Linha;;<b>Órgãos internos:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("508;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");

        // Descrição
        sb.append("509;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria Feto6">

        sb.append("510;;Linha;;</div><table class=\"topico\" width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td width=\"75%\"><b>Biometria:</b></td><td align=\"center\" width=\"25%\">" + Linha.TEXTO_CAMPOS_FILHOS + "</td></tr>$$\n");
        sb.append("511;;CampoRpn;;C1;;<b>Ref. p/ " + CampoSimples.identificador + " sem.</b>;;2$$\n");

        //D.B.P (mm)
        sb.append("\n512;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("513;;CampoInteiro;;Diâmetro biparietal de " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("514;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // IC
        sb.append("515;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("516;;CampoRpn;;C1 100 * C2 /;;Índice cefálico: " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("517;;Label;;74 a 86$$\n");
        // C.A (mm)
        sb.append("518;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_2 + LinhaDaTbl.HTML_FILHO_3 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_4 + "</td></tr>$$");
        sb.append("519;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        sb.append("520;;CampoRpn;;1.57 C1 C2 + *;;Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.;;0$$\n");
        sb.append("521;;CampoInteiro;;Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("522;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CC
        sb.append("523;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("524;;CampoRpn;;C1 C2 + 2 / pi * 1.013 *;;Circunferência craniana fetal: " + CampoSimples.identificador + " mm.;;2$$\n");
        sb.append("525;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CC Div CA
        sb.append("526;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("527;;CampoRpn;;C1 C2 /;;Circunferência craniana / circunferência abdominal: " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("528;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        //C.F (mm)
        sb.append("529;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("530;;CampoInteiro;;Comprimento do fêmur: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("531;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // CF / CA
        sb.append("532;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("533;;CampoRpn;;C1 100 * C2 /;;C.F. / C.A. (Hadlock): " + CampoSimples.identificador + ".;;2$$\n");
        sb.append("534;;Label;;20 a 24$$\n");
        // Umero (mm)
        sb.append("535;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("536;;CampoInteiro;;Comprimento do úmero: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("537;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Ulna (mm)
        sb.append("538;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("539;;CampoInteiro;;Comprimento da ulna: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("540;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Tibia (mm)
        sb.append("541;;LinhaDaTbl;;true;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr>$$");
        sb.append("542;;CampoInteiro;;Comprimento da tíbia: " + CampoSimples.identificador + " mm.;;3$$\n");
        sb.append("543;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");
        // Peso
        sb.append("544;;LinhaDaTbl;;<tr><td>" + LinhaDaTbl.HTML_FILHO_1 + "</td><td align=\"center\">" + LinhaDaTbl.HTML_FILHO_2 + "</td></tr></table><div class=\"topico\">$$");
        sb.append("545;;CampoRpn;;10 -1.7492 .0166 C1 * + .0046 C2 * + 2.646 C1 C2 * 100000 / * - ^ 1000 *;;Peso fetal provável: " + CampoSimples.identificador + " g (±10%).;;2$$\n");
        sb.append("546;;CampoLogicoTexto;;" + CampoSimples.identificador + "$$\n");

        sb.append("547;;Linha$$\n");
        // Estatura
        sb.append("548;;CampoRpn;;C1 0.55 *;;<p style=\"margin-top: 0\">Estatura fetal provável: " + CampoSimples.identificador + " cm.</p>;;2$$\n");
        //sexo
        sb.append("549;;Enumeracao;;<p style=\"margin-top: 0\">Sexo fetal provável: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        //gordura
        sb.append("550;;Enumeracao;;<p style=\"margin-top: 0\">Gordura pré-peritoneal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // Estadiamento intestinal
        sb.append("551;;Enumeracao;;<p style=\"margin-top: 0\">Estadiamento intestinal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // D.O.F (mm)
        sb.append("552;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL +";;3$$\n");
        // D.A.P (mm)
        sb.append("553;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");
        // D.L.L (mm)
        sb.append("554;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta Feto6">
        sb.append("\n555;;Linha;;\n");
        sb.append("<b>Placenta:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //inserção 1
        sb.append("556;;Enumeracao;;<p style=\"margin-top: 0\">De inserção ").append(CampoSimples.identificador).append(";;true$$\n");
        //insercao 2
        sb.append("557;;Enumeracao;; ").append(CampoSimples.identificador).append(".</p>$$\n");
        //espessura
        sb.append("558;;CampoInteiro;;<p style=\"margin-top: 0\">Espessura: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        //maturidade
        sb.append("559;;Enumeracao;;<p style=\"margin-top: 0\">Apresentando ").append(CampoSimples.identificador).append(" (GRANNUM 0, 1, 2, 3).</p>$$\n");

        // Descrição
        sb.append("560;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="dados placenta Feto6">
        sb.append("\n561;;Linha;;\n");
        sb.append("<b>Cordão umbilical:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //cordão umbilical
        sb.append("562;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");
        sb.append("\n563;;Linha;;\n");
        sb.append("<b>Líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //liquido amniótico
        sb.append("564;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append(".</p>;;true$$\n");

        //quadrante 1
        sb.append("565;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 2
        sb.append("566;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 3
        sb.append("567;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 4
        sb.append("568;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //soma
        sb.append("\n569;;Linha;;\n");
        sb.append("<b>Índice do líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        sb.append("570;;CampoRpn;;C1 C2 C3 C4 + + +;;<p style=\"margin-top: 0\">" + CampoSimples.identificador + " cm ;;2$$\n");
        sb.append("571;;CampoLogico;;$570CampoNumero;;"+CampoSimples.identificador + "</p>$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("\n572;;Topico;;Observações gerais$$\n");
        sb.append("\n573;;Linha$$\n");
        sb.append("574;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Desvio padrao">

        sb.append("\n575;;Linha$$\n");
        // tipo
        sb.append("576;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        sb.append("\n577;;Linha$$\n");
        sb.append("\n578;;Linha$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("\n579;;Topico;;Impressão diagnóstica$$\n");

        sb.append("\n580;;Linha$$\n");
        sb.append("581;;Label;;").append("Gravidez tópica, com feto único, de $$\n");
        sb.append("582;;Label;;").append("Gravidez tópica, gemelar, de $$\n");
        sb.append("583;;Label;;").append("Gravidez tópica, múltipla com $$\n");
        sb.append("584;;CampoRpn;;C1;;").append(CampoSimples.identificador).append(" fetos, de ;;0$$\n");
        // Semanas IGH
        sb.append("585;;CampoInteiro;;").append(CampoSimples.identificador).append(";;2$$\n");
        sb.append("586;;Label;;").append(" semanas $$\n");
        sb.append("587;;Label;;$$\n");
        // Dias IGH
        sb.append("588;;CampoInteiro;; e ").append(CampoSimples.identificador).append(" dia(s);;1$$\n");
        sb.append("589;;Label;;$$\n");
        sb.append("590;;CampoLogico;; (± " + identificador + " semana(s)).$$\n");
        sb.append("591;;CampoDouble;; (± "+ CampoSimples.identificador + " semana(s)).;;1$$\n");

        sb.append("\n592;;Linha$$\n");
        sb.append("593;;ImpressaoDiagnostica;;$580CampoDoLaudo$$\n");

        sb.append("\n594;;Linha$$\n");
        sb.append("595;;Enumeracao;;$593CampoTexto$$\n");

        sb.append("\n596;;Linha$$\n");
        sb.append("597;;CampoRpnData;;").append("Tempo de amenorreia: ").
                append(CampoSimples.identificador).append(";;C1 C2 - ").
                append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 /$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outros">

        //diasIghDum
        sb.append("598;;CampoRpnData;;").append(" semanas e ").append(CampoSimples.identificador).append(" dia(s).;;C1 C2 - "
                  + "").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 %$$\n");

        //dppPeloValorInformado
        sb.append("599;;CampoRpnData;;").append(" Data aproximada do parto: " + CampoSimples.identificador + " (± 1,0 sem).").append(";;C1 280 "
                + "").append(CampoRpnData.UM_DIA_EM_MS).append(" * + C2 7 ")
        .append(CampoRpnData.UM_DIA_EM_MS).append(" * * - C3 ").append(CampoRpnData.UM_DIA_EM_MS).append(" * -$$\n");

         // dias totais da igh informado pelo usuario
        sb.append("600;;CampoRpn;;C1 7 * C2 +;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;0$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="IGH pela biometria">

        // <editor-fold defaultstate="collapsed" desc="Feto 1">

        // Fêmur
        sb.append("601;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$62CampoDoLaudo|$140CampoDoLaudo}$$\n");
        // Úmero
        sb.append("602;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$68CampoDoLaudo|$146CampoDoLaudo}$$\n");
        // Ulna
        sb.append("603;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$71CampoDoLaudo|$149CampoDoLaudo}$$\n");
        // Tíbia
        sb.append("604;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$74CampoDoLaudo|$152CampoDoLaudo}$$\n");

        // D.B.P.
        sb.append("605;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$45CampoDoLaudo|$123CampoDoLaudo}$$\n");

        // C.A.
        sb.append("606;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$52CampoDoLaudo|$53CampoDoLaudo|$130CampoDoLaudo|$131CampoDoLaudo}$$\n");

        // C.C.
        sb.append("607;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$56CampoDoLaudo|$134CampoDoLaudo}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 2">

        // Fêmur
        sb.append("608;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$218CampoDoLaudo}$$\n");
        // Úmero
        sb.append("609;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$224CampoDoLaudo}$$\n");
        // Ulna
        sb.append("610;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$227CampoDoLaudo}$$\n");
        // Tíbia
        sb.append("611;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$230CampoDoLaudo}$$\n");

        // D.B.P.
        sb.append("612;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$201CampoDoLaudo}$$\n");

        // C.A.
        sb.append("613;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$208CampoDoLaudo|$209CampoDoLaudo}$$\n");

        // C.C.
        sb.append("614;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$212CampoDoLaudo}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 3">

        // Fêmur
        sb.append("615;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$296CampoDoLaudo}$$\n");
        // Úmero
        sb.append("616;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$302CampoDoLaudo}$$\n");
        // Ulna
        sb.append("617;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$305CampoDoLaudo}$$\n");
        // Tíbia
        sb.append("618;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$308CampoDoLaudo}$$\n");

        // D.B.P.
        sb.append("619;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$279CampoDoLaudo}$$\n");

        // C.A.
        sb.append("620;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$286CampoDoLaudo|$287CampoDoLaudo}$$\n");

        // C.C.
        sb.append("621;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$290CampoDoLaudo}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 4">

        // Fêmur
        sb.append("622;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$374CampoDoLaudo}$$\n");
        // Úmero
        sb.append("623;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$380CampoDoLaudo}$$\n");
        // Ulna
        sb.append("624;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$383CampoDoLaudo}$$\n");
        // Tíbia
        sb.append("625;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$386CampoDoLaudo}$$\n");

        // D.B.P.
        sb.append("626;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$357CampoDoLaudo}$$\n");

        // C.A.
        sb.append("627;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$364CampoDoLaudo|$365CampoDoLaudo}$$\n");

        // C.C.
        sb.append("628;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$368CampoDoLaudo}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 5">

        // Fêmur
        sb.append("629;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$452CampoDoLaudo}$$\n");
        // Úmero
        sb.append("630;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$458CampoDoLaudo}$$\n");
        // Ulna
        sb.append("631;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$461CampoDoLaudo}$$\n");
        // Tíbia
        sb.append("632;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$464CampoDoLaudo}$$\n");

        // D.B.P.
        sb.append("633;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$435CampoDoLaudo}$$\n");

        // C.A.
        sb.append("634;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$442CampoDoLaudo|$443CampoDoLaudo}$$\n");

        // C.C.
        sb.append("635;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$446CampoDoLaudo}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 6">

        // Fêmur
        sb.append("636;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$530CampoDoLaudo}$$\n");
        // Úmero
        sb.append("637;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$536CampoDoLaudo}$$\n");
        // Ulna
        sb.append("638;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$539CampoDoLaudo}$$\n");
        // Tíbia
        sb.append("639;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$542CampoDoLaudo}$$\n");

        // D.B.P.
        sb.append("640;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$513CampoDoLaudo}$$\n");

        // C.A.
        sb.append("641;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$520CampoDoLaudo|$521CampoDoLaudo}$$\n");

        // C.C.
        sb.append("642;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$524CampoDoLaudo}$$\n");

        // </editor-fold>

        // </editor-fold>

        sb.append("643;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");

        // </editor-fold>

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Metodos">

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento">

        sb.append("\n2;;adicionarOpcao;;convexo$$\n");
        sb.append("2;;adicionarOpcao;;linear$$\n");
        sb.append("2;;adicionarOpcao;;endocavitário$$\n");
        sb.append("2;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("2;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("3;;vincularHabAoValorDoCampo;;$2CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Desvio padrão">

        sb.append("\n580;;setImprimivel;;false$$\n");

        sb.append("\n576;;adicionarOpcao;;padrão clássico$$\n");
        sb.append("576;;adicionarOpcao;;definido$$\n");

        sb.append("\n581;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("582;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2}$$\n");
        sb.append("583;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("584;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("584;;cadastrarParametroFormula;;$8CampoNumero$$\n");

        sb.append("\n590;;vincularHabAoValorDoCampo;;$576CampoDoLaudo;;false;;{padrão clássico}$$\n");
        sb.append("590;;cadastrarLogica;;(/s).;;").append(CampoLogico.INTERVALO).append(";;{0.00|0.1}$$\n");
        sb.append("590;;cadastrarLogica;;(/s)0,5;;").append(CampoLogico.INTERVALO).append(";;{0.00|105.00}$$\n");
        sb.append("590;;cadastrarLogica;;(/s)1,0;;").append(CampoLogico.INTERVALO).append(";;{105.00|161.00}$$\n");
        sb.append("590;;cadastrarLogica;;(/s)1,5;;").append(CampoLogico.INTERVALO).append(";;{161.00|203.00}$$\n");
        sb.append("590;;cadastrarLogica;;(/s)2,0;;").append(CampoLogico.INTERVALO).append(";;{203.00|245.00}$$\n");
        sb.append("590;;cadastrarLogica;;(/s)2,5;;").append(CampoLogico.INTERVALO).append(";;{245.00|266.00}$$\n");
        sb.append("590;;cadastrarLogica;;(/s)3,0;;").append(CampoLogico.INTERVALO).append(";;{266.00|999.00}$$\n");
        sb.append("590;;setDependencia;;$600CampoNumero$$\n");

        sb.append("\n591;;vincularHabAoValorDoCampo;;$576CampoDoLaudo;;false;;{definido}$$\n");

        sb.append("\n600;;cadastrarParametroFormula;;$585CampoNumero$$\n");
        sb.append("600;;cadastrarParametroFormula;;$588CampoNumero$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Metodos diversos">

        sb.append("15;;setObrigatorio;;false$$\n");
        sb.append("19;;setObrigatorio;;false$$\n");
        sb.append("20;;setObrigatorio;;false$$\n");
        sb.append("21;;setObrigatorio;;false$$\n");
        sb.append("574;;setObrigatorio;;false$$\n");

        //dppPeloValorInformado
        sb.append("\n599;;cadastrarParamFormula;;$13CampoDoLaudo$$\n");
        sb.append("599;;cadastrarParamFormula;;$585CampoDoLaudo$$\n");
        sb.append("599;;cadastrarParamFormula;;$588CampoDoLaudo$$\n");

        //diasIghDum
        sb.append("\n597;;cadastrarParamFormula;;$13CampoDoLaudo$$\n");
        sb.append("597;;cadastrarParamFormula;;$15CampoDoLaudo$$\n");
        //semanaIghDum
        sb.append("\n598;;cadastrarParamFormula;;$13CampoDoLaudo$$\n");
        sb.append("598;;cadastrarParamFormula;;$15CampoDoLaudo$$\n");

        // Descrição da gestacao
        sb.append("8;;setValor;;(/s)1$$\n");
        sb.append("8;;setMsgErroValidCampoObrig;;Digite um valor entre 1 e 6!!$$\n");
        sb.append("6;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2}$$\n");
        sb.append("7;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("9;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("9;;cadastrarParametroFormula;;$8CampoNumero$$\n");
        sb.append("10;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("11;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("12;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");

        // Corionicidade
        sb.append("\n11;;adicionarOpcao;;monocoriônica$$\n");
        sb.append("11;;adicionarOpcao;;dicoriônica$$\n");
        sb.append("11;;adicionarOpcao;;tricoriônica$$\n");
        sb.append("11;;adicionarOpcao;;tetracoriônica$$\n");
        sb.append("11;;adicionarOpcao;;pentacoriônica$$\n");
        sb.append("11;;adicionarOpcao;;hexacoriônica$$\n");
        sb.append("11;;adicionarOpcao;;heptacoriônica$$\n");
        sb.append("11;;adicionarOpcao;;octacoriônica$$\n");

        // Amniocidade
        sb.append("\n12;;adicionarOpcao;;monoamniótica$$\n");
        sb.append("12;;adicionarOpcao;;diamniótica$$\n");
        sb.append("12;;adicionarOpcao;;triamniótica$$\n");
        sb.append("12;;adicionarOpcao;;tetraamniótica$$\n");
        sb.append("12;;adicionarOpcao;;pentaamniótica$$\n");
        sb.append("12;;adicionarOpcao;;hexaamniótica$$\n");
        sb.append("12;;adicionarOpcao;;heptaamniótica$$\n");
        sb.append("12;;adicionarOpcao;;octaamniótica$$\n");

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
        //semanasIghDum
        sb.append("\n17;;cadastrarParamFormula;;$13CampoDoLaudo$$\n");
        sb.append("17;;cadastrarParamFormula;;$15CampoDoLaudo$$\n");
        //diasIghDum
        sb.append("\n18;;cadastrarParamFormula;;$13CampoDoLaudo$$\n");
        sb.append("18;;cadastrarParamFormula;;$15CampoDoLaudo$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto único">

        sb.append("26;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");

        // <editor-fold defaultstate="collapsed" desc="Dados do feto">

        // situação
        sb.append("\n28;;adicionarOpcao;;longitudinal$$\n");
        sb.append("28;;adicionarOpcao;;transversal com polo cefálico à direita$$\n");
        sb.append("28;;adicionarOpcao;;transversal com polo cefálico à esquerda$$\n");
        sb.append("28;;adicionarOpcao;;oblíqua$$\n");
        sb.append("28;;adicionarOpcao;;indiferente$$\n");

        // apresentacao
        sb.append("\n29;;adicionarOpcao;;cefálica$$\n");
        sb.append("29;;adicionarOpcao;;pélvica$$\n");
        sb.append("29;;adicionarOpcao;;córmica$$\n");
        sb.append("29;;adicionarOpcao;;indiferente$$\n");
        sb.append("29;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // dorso
        sb.append("\n31;;adicionarOpcao;;à esquerda$$\n");
        sb.append("31;;adicionarOpcao;;à direita$$\n");
        sb.append("31;;adicionarOpcao;;anterior$$\n");
        sb.append("31;;adicionarOpcao;;posterior$$\n");
        sb.append("31;;adicionarOpcao;;superior$$\n");
        sb.append("31;;adicionarOpcao;;inferior$$\n");
        sb.append("31;;adicionarOpcao;;indiferente$$\n");
        sb.append("31;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // movimentos fetais
        sb.append("\n32;;adicionarOpcao;;presentes$$\n");
        sb.append("32;;adicionarOpcao;;ausentes$$\n");
        sb.append("32;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //movimentos respiratorios
        sb.append("\n34;;adicionarOpcao;;presentes$$\n");
        sb.append("34;;adicionarOpcao;;ausentes$$\n");
        sb.append("34;;adicionarOpcao;;não visualizados$$\n");
        sb.append("34;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // batimentos cardiacos
        sb.append("\n36;;adicionarOpcao;;presentes;;$$\n");
        sb.append("36;;adicionarOpcao;;ausentes$$\n");
        sb.append("36;;adicionarOpcao;;não visualizados$$\n");
        sb.append("36;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //ritmia
        sb.append("\n37;;adicionarOpcao;;rítmicos$$\n");
        sb.append("37;;adicionarOpcao;;arrítmicos$$\n");
        sb.append("37;;vincularHabAoValorDoCampo;;$36CampoDoLaudo;;false;;{presentes}$$\n");

        //numero batimentos / min
        sb.append("38;;vincularHabAoValorDoCampo;;$36CampoDoLaudo;;false;;{presentes}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos internos">

        // sexo
        sb.append("\n81;;adicionarOpcao;;masculino$$\n");
        sb.append("81;;adicionarOpcao;;feminino$$\n");
        sb.append("81;;adicionarOpcao;;não visualizado$$\n");
        sb.append("81;;adicionarOpcao;;não impresso a pedido (masculino)$$\n");
        sb.append("81;;adicionarOpcao;;não impresso a pedido (feminino)$$\n");
        sb.append("81;;adicionarExcecao;;não impresso a pedido (masculino);;$$\n");
        sb.append("81;;adicionarExcecao;;não impresso a pedido (feminino);;$$\n");

        // gordura Peritonial
        sb.append("\n82;;adicionarOpcao;;presente$$\n");
        sb.append("82;;adicionarOpcao;;ausente$$\n");

        // estadiamento Intestinal
        sb.append("\n83;;adicionarOpcao;;grau I$$\n");
        sb.append("83;;adicionarOpcao;;grau II$$\n");
        sb.append("83;;adicionarOpcao;;grau III$$\n");
        sb.append("83;;adicionarOpcao;;grau IV$$\n");

        // Órgãos internos
        sb.append("40;;adicionarOpcao;;normal;;Sem alterações visíveis.$$\n");
        sb.append("40;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("40;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("41;;vincularHabAoValorDoCampo;;$40CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        // ILA
        sb.append("\n103;;cadastrarLogica;;;;").append(CampoLogico.INTERVALO).append(";;{0.00|0.01}$$\n");
        sb.append("103;;cadastrarLogica;;(Oligoâmnio - ILA está entre 0,00 e 5,00).;;").append(CampoLogico.INTERVALO).append(";;{0.0|5.0}$$\n");
        sb.append("103;;cadastrarLogica;;(Reduzido - ILA está entre 5,00 e 8,00).;;").append(CampoLogico.INTERVALO).append(";;{5.0|8.0}$$\n");
        sb.append("103;;cadastrarLogica;;(Normal - ILA está entre 8,00 e 22,00).;;").append(CampoLogico.INTERVALO).append(";;{8.0|22.0}$$\n");
        sb.append("103;;cadastrarLogica;;(Aumentado - ILA está entre 22,00 e 25,00).;;").append(CampoLogico.INTERVALO).append(";;{22.0|25.0}$$\n");
        sb.append("103;;cadastrarLogica;;(Poliidrâmnio - ILA é maior ou igual a 25,00).;;").append(CampoLogico.INTERVALO).append(";;{25.0|999.00}$$\n");

        //cordão umbilical
        sb.append("\n94;;adicionarOpcao;;normal;;Com duas artérias e uma veia normoinserida.$$\n");
        sb.append("94;;adicionarOpcao;;artéria única;;Artéria única.$$\n");
        sb.append("94;;adicionarOpcao;;não visualizado;;Não visualizado.$$\n");

        //liquido Amniotico
        sb.append("\n96;;adicionarOpcao;;Normal$$\n");
        sb.append("96;;adicionarOpcao;;Aumento leve$$\n");
        sb.append("96;;adicionarOpcao;;Aumento moderado$$\n");
        sb.append("96;;adicionarOpcao;;Aumento acentuado$$\n");
        sb.append("96;;adicionarOpcao;;Diminuição leve$$\n");
        sb.append("96;;adicionarOpcao;;Diminuição moderada$$\n");
        sb.append("96;;adicionarOpcao;;Diminuição acentuada$$\n");
        sb.append("96;;vincularHabAoValorDoCampo;;$88CampoDoLaudo;;{").append(Enumeracao.NAO_IMPRIMIR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        //insercao
        sb.append("\n88;;adicionarOpcao;;tópica$$\n");
        sb.append("88;;adicionarOpcao;;heterotópica$$\n");
        sb.append("88;;adicionarOpcao;;prévia marginal$$\n");
        sb.append("88;;adicionarOpcao;;prévia centro parcial$$\n");
        sb.append("88;;adicionarOpcao;;prévia centro total$$\n");
        sb.append("88;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("88;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        //insercao 2
        sb.append("\n89;;adicionarOpcao;;anterior$$\n");
        sb.append("89;;adicionarOpcao;;posterior$$\n");
        sb.append("89;;adicionarOpcao;;fúndica$$\n");
        sb.append("89;;adicionarOpcao;;fúndica anterior$$\n");
        sb.append("89;;adicionarOpcao;;fúndica posterior$$\n");
        sb.append("89;;adicionarOpcao;;anterior lateral direita$$\n");
        sb.append("89;;adicionarOpcao;;anterior lateral esquerda$$\n");
        sb.append("89;;adicionarOpcao;;posterior lateral direita$$\n");
        sb.append("89;;adicionarOpcao;;posterior lateral esquerda$$\n");
        sb.append("89;;vincularHabAoValorDoCampo;;$88CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //espessura
        sb.append("90;;vincularHabAoValorDoCampo;;$88CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //maturidade
        sb.append("\n91;;adicionarOpcao;;grau 0;;textura homogênea e maturidade grau 0$$\n");
        sb.append("91;;adicionarOpcao;;grau 1;;textura heterogênea e maturidade grau 1$$\n");
        sb.append("91;;adicionarOpcao;;grau 2;;textura heterogênea e maturidade grau 2$$\n");
        sb.append("91;;adicionarOpcao;;grau 3;;maturidade grau 3$$\n");
        sb.append("91;;vincularHabAoValorDoCampo;;$88CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");
        sb.append("91;;setComecarDoZero;;").append(Enumeracao.COMECAR_DO_ZERO_SIM).append("$$\n");

        // Descrição
        sb.append("92;;vincularObrigatorio;;$88CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("92;;vincularHabAoValorDoCampo;;$88CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total|" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria">

        //campo soma biometria
        sb.append("\n102;;cadastrarParametroFormula;;$97CampoNumero$$\n");
        sb.append("102;;cadastrarParametroFormula;;$98CampoNumero$$\n");
        sb.append("102;;cadastrarParametroFormula;;$99CampoNumero$$\n");
        sb.append("102;;cadastrarParametroFormula;;$100CampoNumero$$\n");

        //ic
        sb.append("\n48;;cadastrarParametroFormula;;$45CampoNumero$$\n");
        sb.append("48;;cadastrarParametroFormula;;$84CampoNumero$$\n");
        //cc
        sb.append("\n56;;cadastrarParametroFormula;;$45CampoNumero$$\n");
        sb.append("56;;cadastrarParametroFormula;;$84CampoNumero$$\n");

        //ca
        sb.append("\n51;;adicionarOpcao;;informar$$\n");
        sb.append("51;;adicionarOpcao;;calcular$$\n");
        sb.append("51;;setValor;;informar$$\n");

        sb.append("\n52;;cadastrarParametroFormula;;$85CampoNumero$$\n");
        sb.append("52;;cadastrarParametroFormula;;$86CampoNumero$$\n");
        sb.append("52;;vincularHabAoValorDoCampo;;$51CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("53;;vincularHabAoValorDoCampo;;$51CampoDoLaudo;;false;;{informar}$$\n");

        sb.append("85;;vincularHabAoValorDoCampo;;$51CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("86;;vincularHabAoValorDoCampo;;$51CampoDoLaudo;;false;;{calcular}$$\n");

        //ccDivca
        sb.append("\n59;;cadastrarParametroFormula;;$56CampoNumero$$\n");
        sb.append("59;;cadastrarParametroFormula;;$52CampoNumero$$\n");
        sb.append("59;;cadastrarParametroFormula;;$53CampoNumero;;2$$\n");
        //cfDivca
        sb.append("\n65;;cadastrarParametroFormula;;$62CampoNumero$$\n");
        sb.append("65;;cadastrarParametroFormula;;$52CampoNumero$$\n");
        sb.append("65;;cadastrarParametroFormula;;$53CampoNumero;;2$$\n");
        //peso fetal
        sb.append("\n77;;cadastrarParametroFormula;;$45CampoNumero$$\n");
        sb.append("77;;cadastrarParametroFormula;;$52CampoNumero$$\n");
        sb.append("77;;cadastrarParametroFormula;;$53CampoNumero;;2$$\n");
        //estatuta fetal
        sb.append("\n80;;cadastrarParametroFormula;;$45CampoNumero$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 1">

        sb.append("104;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");

        // <editor-fold defaultstate="collapsed" desc="Dados do feto">

        // situação
        sb.append("\n106;;adicionarOpcao;;longitudinal$$\n");
        sb.append("106;;adicionarOpcao;;transversal com polo cefálico à direita$$\n");
        sb.append("106;;adicionarOpcao;;transversal com polo cefálico à esquerda$$\n");
        sb.append("106;;adicionarOpcao;;oblíqua$$\n");
        sb.append("106;;adicionarOpcao;;indiferente$$\n");

        // apresentacao
        sb.append("\n107;;adicionarOpcao;;cefálica$$\n");
        sb.append("107;;adicionarOpcao;;pélvica$$\n");
        sb.append("107;;adicionarOpcao;;córmica$$\n");
        sb.append("107;;adicionarOpcao;;indiferente$$\n");
        sb.append("107;;vincularHabAoValorDoCampo;;$106CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // dorso
        sb.append("\n109;;adicionarOpcao;;à esquerda$$\n");
        sb.append("109;;adicionarOpcao;;à direita$$\n");
        sb.append("109;;adicionarOpcao;;anterior$$\n");
        sb.append("109;;adicionarOpcao;;posterior$$\n");
        sb.append("109;;adicionarOpcao;;superior$$\n");
        sb.append("109;;adicionarOpcao;;inferior$$\n");
        sb.append("109;;adicionarOpcao;;indiferente$$\n");
        sb.append("109;;vincularHabAoValorDoCampo;;$106CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // movimentos fetais
        sb.append("\n110;;adicionarOpcao;;presentes$$\n");
        sb.append("110;;adicionarOpcao;;ausentes$$\n");
        sb.append("110;;vincularHabAoValorDoCampo;;$106CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //movimentos respiratorios
        sb.append("\n112;;adicionarOpcao;;presentes$$\n");
        sb.append("112;;adicionarOpcao;;ausentes$$\n");
        sb.append("112;;adicionarOpcao;;não visualizados$$\n");
        sb.append("112;;vincularHabAoValorDoCampo;;$106CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // batimentos cardiacos
        sb.append("\n114;;adicionarOpcao;;presentes;;$$\n");
        sb.append("114;;adicionarOpcao;;ausentes$$\n");
        sb.append("114;;adicionarOpcao;;não visualizados$$\n");
        sb.append("114;;vincularHabAoValorDoCampo;;$106CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //ritmia
        sb.append("\n115;;adicionarOpcao;;rítmicos$$\n");
        sb.append("115;;adicionarOpcao;;arrítmicos$$\n");
        sb.append("115;;vincularHabAoValorDoCampo;;$114CampoDoLaudo;;false;;{presentes}$$\n");

        //numero batimentos / min
        sb.append("116;;vincularHabAoValorDoCampo;;$114CampoDoLaudo;;false;;{presentes}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos internos">

        // sexo
        sb.append("\n159;;adicionarOpcao;;masculino$$\n");
        sb.append("159;;adicionarOpcao;;feminino$$\n");
        sb.append("159;;adicionarOpcao;;não visualizado$$\n");
        sb.append("159;;adicionarOpcao;;não impresso a pedido (masculino)$$\n");
        sb.append("159;;adicionarOpcao;;não impresso a pedido (feminino)$$\n");
        sb.append("159;;adicionarExcecao;;não impresso a pedido (masculino);;$$\n");
        sb.append("159;;adicionarExcecao;;não impresso a pedido (feminino);;$$\n");

        //gordura Peritonial
        sb.append("\n160;;adicionarOpcao;;presente$$\n");
        sb.append("160;;adicionarOpcao;;ausente$$\n");

        //estadiamento Instestinal
        sb.append("\n161;;adicionarOpcao;;grau I$$\n");
        sb.append("161;;adicionarOpcao;;grau II$$\n");
        sb.append("161;;adicionarOpcao;;grau III$$\n");
        sb.append("161;;adicionarOpcao;;grau IV$$\n");

        // Órgãos internos
        sb.append("118;;adicionarOpcao;;normal;;Sem alterações visíveis.$$\n");
        sb.append("118;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("118;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("119;;vincularHabAoValorDoCampo;;$118CampoDoLaudo;;false;;{").append(""+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        // ILA
        sb.append("\n181;;cadastrarLogica;;;;").append(CampoLogico.INTERVALO).append(";;{0.00|0.01}$$\n");
        sb.append("181;;cadastrarLogica;;(Oligoâmnio - ILA está entre 0,00 e 5,00).;;").append(CampoLogico.INTERVALO).append(";;{0.0|5.0}$$\n");
        sb.append("181;;cadastrarLogica;;(Reduzido - ILA está entre 5,00 e 8,00).;;").append(CampoLogico.INTERVALO).append(";;{5.0|8.0}$$\n");
        sb.append("181;;cadastrarLogica;;(Normal - ILA está entre 8,00 e 22,00).;;").append(CampoLogico.INTERVALO).append(";;{8.0|22.0}$$\n");
        sb.append("181;;cadastrarLogica;;(Aumentado - ILA está entre 22,00 e 25,00).;;").append(CampoLogico.INTERVALO).append(";;{22.0|25.0}$$\n");
        sb.append("181;;cadastrarLogica;;(Poliidrâmnio - ILA é maior ou igual a 25,00).;;").append(CampoLogico.INTERVALO).append(";;{25.0|999.00}$$\n");

        //cordão umbilical
        sb.append("\n172;;adicionarOpcao;;normal;;Com duas artérias e uma veia normoinserida.$$\n");
        sb.append("172;;adicionarOpcao;;artéria única;;Artéria única.$$\n");
        sb.append("172;;adicionarOpcao;;não visualizado;;Não visualizado.$$\n");

        //liquido Amniotico
        sb.append("\n174;;adicionarOpcao;;Normal$$\n");
        sb.append("174;;adicionarOpcao;;Aumento leve$$\n");
        sb.append("174;;adicionarOpcao;;Aumento moderado$$\n");
        sb.append("174;;adicionarOpcao;;Aumento acentuado$$\n");
        sb.append("174;;adicionarOpcao;;Diminuição leve$$\n");
        sb.append("174;;adicionarOpcao;;Diminuição moderada$$\n");
        sb.append("174;;adicionarOpcao;;Diminuição acentuada$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria">

        //campo soma biometria
        sb.append("\n180;;cadastrarParametroFormula;;$175CampoNumero$$\n");
        sb.append("180;;cadastrarParametroFormula;;$176CampoNumero$$\n");
        sb.append("180;;cadastrarParametroFormula;;$177CampoNumero$$\n");
        sb.append("180;;cadastrarParametroFormula;;$178CampoNumero$$\n");

        //ic
        sb.append("\n126;;cadastrarParametroFormula;;$123CampoNumero$$\n");
        sb.append("126;;cadastrarParametroFormula;;$162CampoNumero$$\n");
        //cc
        sb.append("\n134;;cadastrarParametroFormula;;$123CampoNumero$$\n");
        sb.append("134;;cadastrarParametroFormula;;$162CampoNumero$$\n");

        //ca

        sb.append("\n129;;adicionarOpcao;;informar$$\n");
        sb.append("129;;adicionarOpcao;;calcular$$\n");
        sb.append("129;;setValor;;informar$$\n");

        sb.append("\n130;;cadastrarParametroFormula;;$163CampoNumero$$\n");
        sb.append("130;;cadastrarParametroFormula;;$164CampoNumero$$\n");
        sb.append("130;;vincularHabAoValorDoCampo;;$129CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("131;;vincularHabAoValorDoCampo;;$129CampoDoLaudo;;false;;{informar}$$\n");

        sb.append("163;;vincularHabAoValorDoCampo;;$129CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("164;;vincularHabAoValorDoCampo;;$129CampoDoLaudo;;false;;{calcular}$$\n");

        //ccDivca
        sb.append("\n137;;cadastrarParametroFormula;;$134CampoNumero$$\n");
        sb.append("137;;cadastrarParametroFormula;;$130CampoNumero$$\n");
        sb.append("137;;cadastrarParametroFormula;;$131CampoNumero;;2$$\n");
        //cfDivca
        sb.append("\n143;;cadastrarParametroFormula;;$140CampoNumero$$\n");
        sb.append("143;;cadastrarParametroFormula;;$130CampoNumero$$\n");
        sb.append("143;;cadastrarParametroFormula;;$131CampoNumero;;2$$\n");
        //peso fetal
        sb.append("\n155;;cadastrarParametroFormula;;$123CampoNumero$$\n");
        sb.append("155;;cadastrarParametroFormula;;$130CampoNumero$$\n");
        sb.append("155;;cadastrarParametroFormula;;$131CampoNumero;;2$$\n");
        //estatuta fetal
        sb.append("\n158;;cadastrarParametroFormula;;$123CampoNumero$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        //insercao
        sb.append("\n166;;adicionarOpcao;;tópica$$\n");
        sb.append("166;;adicionarOpcao;;heterotópica$$\n");
        sb.append("166;;adicionarOpcao;;prévia marginal$$\n");
        sb.append("166;;adicionarOpcao;;prévia centro parcial$$\n");
        sb.append("166;;adicionarOpcao;;prévia centro total$$\n");
        sb.append("166;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("166;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        //insercao 2
        sb.append("\n167;;adicionarOpcao;;anterior$$\n");
        sb.append("167;;adicionarOpcao;;posterior$$\n");
        sb.append("167;;adicionarOpcao;;fúndica$$\n");
        sb.append("167;;adicionarOpcao;;fúndica anterior$$\n");
        sb.append("167;;adicionarOpcao;;fúndica posterior$$\n");
        sb.append("167;;adicionarOpcao;;anterior lateral direita$$\n");
        sb.append("167;;adicionarOpcao;;anterior lateral esquerda$$\n");
        sb.append("167;;adicionarOpcao;;posterior lateral direita$$\n");
        sb.append("167;;adicionarOpcao;;posterior lateral esquerda$$\n");
        sb.append("167;;vincularHabAoValorDoCampo;;$166CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //espesssura
        sb.append("168;;vincularHabAoValorDoCampo;;$166CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //maturidade
        sb.append("\n169;;adicionarOpcao;;grau 0;;textura homogênea e maturidade grau 0$$\n");
        sb.append("169;;adicionarOpcao;;grau 1;;textura heterogênea e maturidade grau 1$$\n");
        sb.append("169;;adicionarOpcao;;grau 2;;textura heterogênea e maturidade grau 2$$\n");
        sb.append("169;;adicionarOpcao;;grau 3;;maturidade grau 3$$\n");
        sb.append("169;;vincularHabAoValorDoCampo;;$166CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");
        sb.append("169;;setComecarDoZero;;").append(Enumeracao.COMECAR_DO_ZERO_SIM).append("$$\n");

        // Descrição
        sb.append("170;;vincularObrigatorio;;$166CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("170;;vincularHabAoValorDoCampo;;$166CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total|" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 2">

        sb.append("182;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");

        // <editor-fold defaultstate="collapsed" desc="Dados do feto">

        // situação
        sb.append("\n184;;adicionarOpcao;;longitudinal$$\n");
        sb.append("184;;adicionarOpcao;;transversal com polo cefálico à direita$$\n");
        sb.append("184;;adicionarOpcao;;transversal com polo cefálico à esquerda$$\n");
        sb.append("184;;adicionarOpcao;;oblíqua$$\n");
        sb.append("184;;adicionarOpcao;;indiferente$$\n");

        // apresentacao
        sb.append("\n185;;adicionarOpcao;;cefálica$$\n");
        sb.append("185;;adicionarOpcao;;pélvica$$\n");
        sb.append("185;;adicionarOpcao;;córmica$$\n");
        sb.append("185;;adicionarOpcao;;indiferente$$\n");
        sb.append("185;;vincularHabAoValorDoCampo;;$184CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // dorso
        sb.append("\n187;;adicionarOpcao;;à esquerda$$\n");
        sb.append("187;;adicionarOpcao;;à direita$$\n");
        sb.append("187;;adicionarOpcao;;anterior$$\n");
        sb.append("187;;adicionarOpcao;;posterior$$\n");
        sb.append("187;;adicionarOpcao;;superior$$\n");
        sb.append("187;;adicionarOpcao;;inferior$$\n");
        sb.append("187;;adicionarOpcao;;indiferente$$\n");
        sb.append("187;;vincularHabAoValorDoCampo;;$184CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // movimentos fetais
        sb.append("\n188;;adicionarOpcao;;presentes$$\n");
        sb.append("188;;adicionarOpcao;;ausentes$$\n");
        sb.append("188;;vincularHabAoValorDoCampo;;$184CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //movimentos respiratorios
        sb.append("\n190;;adicionarOpcao;;presentes$$\n");
        sb.append("190;;adicionarOpcao;;ausentes$$\n");
        sb.append("190;;adicionarOpcao;;não visualizados$$\n");
        sb.append("190;;vincularHabAoValorDoCampo;;$184CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // batimentos cardiacos
        sb.append("\n192;;adicionarOpcao;;presentes;;$$\n");
        sb.append("192;;adicionarOpcao;;ausentes$$\n");
        sb.append("192;;adicionarOpcao;;não visualizados$$\n");
        sb.append("192;;vincularHabAoValorDoCampo;;$184CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //ritmia
        sb.append("\n193;;adicionarOpcao;;rítmicos$$\n");
        sb.append("193;;adicionarOpcao;;arrítmicos$$\n");
        sb.append("193;;vincularHabAoValorDoCampo;;$192CampoDoLaudo;;false;;{presentes}$$\n");

        //numero batimentos / min
        sb.append("194;;vincularHabAoValorDoCampo;;$192CampoDoLaudo;;false;;{presentes}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos internos">

        // sexo
        sb.append("\n237;;adicionarOpcao;;masculino$$\n");
        sb.append("237;;adicionarOpcao;;feminino$$\n");
        sb.append("237;;adicionarOpcao;;não visualizado$$\n");
        sb.append("237;;adicionarOpcao;;não impresso a pedido (masculino)$$\n");
        sb.append("237;;adicionarOpcao;;não impresso a pedido (feminino)$$\n");
        sb.append("237;;adicionarExcecao;;não impresso a pedido (masculino);;$$\n");
        sb.append("237;;adicionarExcecao;;não impresso a pedido (feminino);;$$\n");

        //gordura Peritonial
        sb.append("\n238;;adicionarOpcao;;presente$$\n");
        sb.append("238;;adicionarOpcao;;ausente$$\n");

        //estadiamento Instestinal
        sb.append("\n239;;adicionarOpcao;;grau I$$\n");
        sb.append("239;;adicionarOpcao;;grau II$$\n");
        sb.append("239;;adicionarOpcao;;grau III$$\n");
        sb.append("239;;adicionarOpcao;;grau IV$$\n");

        // Órgãos internos
        sb.append("196;;adicionarOpcao;;normal;;Sem alterações visíveis.$$\n");
        sb.append("196;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("196;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("197;;vincularHabAoValorDoCampo;;$196CampoDoLaudo;;false;;{").append(""+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        // ILA
        sb.append("\n259;;cadastrarLogica;;;;").append(CampoLogico.INTERVALO).append(";;{0.00|0.01}$$\n");
        sb.append("259;;cadastrarLogica;;(Oligoâmnio - ILA está entre 0,00 e 5,00).;;").append(CampoLogico.INTERVALO).append(";;{0.0|5.0}$$\n");
        sb.append("259;;cadastrarLogica;;(Reduzido - ILA está entre 5,00 e 8,00).;;").append(CampoLogico.INTERVALO).append(";;{5.0|8.0}$$\n");
        sb.append("259;;cadastrarLogica;;(Normal - ILA está entre 8,00 e 22,00).;;").append(CampoLogico.INTERVALO).append(";;{8.0|22.0}$$\n");
        sb.append("259;;cadastrarLogica;;(Aumentado - ILA está entre 22,00 e 25,00).;;").append(CampoLogico.INTERVALO).append(";;{22.0|25.0}$$\n");
        sb.append("259;;cadastrarLogica;;(Poliidrâmnio - ILA é maior ou igual a 25,00).;;").append(CampoLogico.INTERVALO).append(";;{25.0|999.00}$$\n");

        //cordão umbilical
        sb.append("\n250;;adicionarOpcao;;normal;;Com duas artérias e uma veia normoinserida.$$\n");
        sb.append("250;;adicionarOpcao;;artéria única;;Artéria única.$$\n");
        sb.append("250;;adicionarOpcao;;não visualizado;;Não visualizado.$$\n");

        //liquido Amniotico
        sb.append("\n252;;adicionarOpcao;;Normal$$\n");
        sb.append("252;;adicionarOpcao;;Aumento leve$$\n");
        sb.append("252;;adicionarOpcao;;Aumento moderado$$\n");
        sb.append("252;;adicionarOpcao;;Aumento acentuado$$\n");
        sb.append("252;;adicionarOpcao;;Diminuição leve$$\n");
        sb.append("252;;adicionarOpcao;;Diminuição moderada$$\n");
        sb.append("252;;adicionarOpcao;;Diminuição acentuada$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        //insercao
        sb.append("\n244;;adicionarOpcao;;tópica$$\n");
        sb.append("244;;adicionarOpcao;;heterotópica$$\n");
        sb.append("244;;adicionarOpcao;;prévia marginal$$\n");
        sb.append("244;;adicionarOpcao;;prévia centro parcial$$\n");
        sb.append("244;;adicionarOpcao;;prévia centro total$$\n");
        sb.append("244;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("244;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        //insercao 2
        sb.append("\n245;;adicionarOpcao;;anterior$$\n");
        sb.append("245;;adicionarOpcao;;posterior$$\n");
        sb.append("245;;adicionarOpcao;;fúndica$$\n");
        sb.append("245;;adicionarOpcao;;fúndica anterior$$\n");
        sb.append("245;;adicionarOpcao;;fúndica posterior$$\n");
        sb.append("245;;adicionarOpcao;;anterior lateral direita$$\n");
        sb.append("245;;adicionarOpcao;;anterior lateral esquerda$$\n");
        sb.append("245;;adicionarOpcao;;posterior lateral direita$$\n");
        sb.append("245;;adicionarOpcao;;posterior lateral esquerda$$\n");
        sb.append("245;;vincularHabAoValorDoCampo;;$244CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //espesssura
        sb.append("246;;vincularHabAoValorDoCampo;;$244CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //maturidade
        sb.append("\n247;;adicionarOpcao;;grau 0;;textura homogênea e maturidade grau 0$$\n");
        sb.append("247;;adicionarOpcao;;grau 1;;textura heterogênea e maturidade grau 1$$\n");
        sb.append("247;;adicionarOpcao;;grau 2;;textura heterogênea e maturidade grau 2$$\n");
        sb.append("247;;adicionarOpcao;;grau 3;;maturidade grau 3$$\n");
        sb.append("247;;vincularHabAoValorDoCampo;;$244CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");
        sb.append("247;;setComecarDoZero;;").append(Enumeracao.COMECAR_DO_ZERO_SIM).append("$$\n");

        // Descrição
        sb.append("248;;vincularObrigatorio;;$244CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("248;;vincularHabAoValorDoCampo;;$244CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total|" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria">

        //campo soma biometria
        sb.append("\n258;;cadastrarParametroFormula;;$253CampoNumero$$\n");
        sb.append("258;;cadastrarParametroFormula;;$254CampoNumero$$\n");
        sb.append("258;;cadastrarParametroFormula;;$255CampoNumero$$\n");
        sb.append("258;;cadastrarParametroFormula;;$256CampoNumero$$\n");

        //ic
        sb.append("\n204;;cadastrarParametroFormula;;$201CampoNumero$$\n");
        sb.append("204;;cadastrarParametroFormula;;$240CampoNumero$$\n");
        //cc
        sb.append("\n212;;cadastrarParametroFormula;;$201CampoNumero$$\n");
        sb.append("212;;cadastrarParametroFormula;;$240CampoNumero$$\n");

        //ca

        sb.append("\n207;;adicionarOpcao;;informar$$\n");
        sb.append("207;;adicionarOpcao;;calcular$$\n");
        sb.append("207;;setValor;;informar$$\n");

        sb.append("\n208;;cadastrarParametroFormula;;$241CampoNumero$$\n");
        sb.append("208;;cadastrarParametroFormula;;$242CampoNumero$$\n");
        sb.append("208;;vincularHabAoValorDoCampo;;$207CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("209;;vincularHabAoValorDoCampo;;$207CampoDoLaudo;;false;;{informar}$$\n");

        sb.append("241;;vincularHabAoValorDoCampo;;$207CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("242;;vincularHabAoValorDoCampo;;$207CampoDoLaudo;;false;;{calcular}$$\n");

        //ccDivca
        sb.append("\n215;;cadastrarParametroFormula;;$212CampoNumero$$\n");
        sb.append("215;;cadastrarParametroFormula;;$208CampoNumero$$\n");
        sb.append("215;;cadastrarParametroFormula;;$209CampoNumero;;2$$\n");
        //cfDivca
        sb.append("\n221;;cadastrarParametroFormula;;$218CampoNumero$$\n");
        sb.append("221;;cadastrarParametroFormula;;$208CampoNumero$$\n");
        sb.append("221;;cadastrarParametroFormula;;$209CampoNumero;;2$$\n");
        //peso fetal
        sb.append("\n233;;cadastrarParametroFormula;;$201CampoNumero$$\n");
        sb.append("233;;cadastrarParametroFormula;;$208CampoNumero$$\n");
        sb.append("233;;cadastrarParametroFormula;;$209CampoNumero;;2$$\n");
        //estatuta fetal
        sb.append("\n236;;cadastrarParametroFormula;;$201CampoNumero$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 3">

        sb.append("260;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");

        // <editor-fold defaultstate="collapsed" desc="Dados do feto">

        // situação
        sb.append("\n262;;adicionarOpcao;;longitudinal$$\n");
        sb.append("262;;adicionarOpcao;;transversal com polo cefálico à direita$$\n");
        sb.append("262;;adicionarOpcao;;transversal com polo cefálico à esquerda$$\n");
        sb.append("262;;adicionarOpcao;;oblíqua$$\n");
        sb.append("262;;adicionarOpcao;;indiferente$$\n");

        // apresentacao
        sb.append("\n263;;adicionarOpcao;;cefálica$$\n");
        sb.append("263;;adicionarOpcao;;pélvica$$\n");
        sb.append("263;;adicionarOpcao;;córmica$$\n");
        sb.append("263;;adicionarOpcao;;indiferente$$\n");
        sb.append("263;;vincularHabAoValorDoCampo;;$262CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // dorso
        sb.append("\n265;;adicionarOpcao;;à esquerda$$\n");
        sb.append("265;;adicionarOpcao;;à direita$$\n");
        sb.append("265;;adicionarOpcao;;anterior$$\n");
        sb.append("265;;adicionarOpcao;;posterior$$\n");
        sb.append("265;;adicionarOpcao;;superior$$\n");
        sb.append("265;;adicionarOpcao;;inferior$$\n");
        sb.append("265;;adicionarOpcao;;indiferente$$\n");
        sb.append("265;;vincularHabAoValorDoCampo;;$262CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // movimentos fetais
        sb.append("\n266;;adicionarOpcao;;presentes$$\n");
        sb.append("266;;adicionarOpcao;;ausentes$$\n");
        sb.append("266;;vincularHabAoValorDoCampo;;$262CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //movimentos respiratorios
        sb.append("\n268;;adicionarOpcao;;presentes$$\n");
        sb.append("268;;adicionarOpcao;;ausentes$$\n");
        sb.append("268;;adicionarOpcao;;não visualizados$$\n");
        sb.append("268;;vincularHabAoValorDoCampo;;$262CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // batimentos cardiacos
        sb.append("\n270;;adicionarOpcao;;presentes;;$$\n");
        sb.append("270;;adicionarOpcao;;ausentes$$\n");
        sb.append("270;;adicionarOpcao;;não visualizados$$\n");
        sb.append("270;;vincularHabAoValorDoCampo;;$262CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //ritmia
        sb.append("\n271;;adicionarOpcao;;rítmicos$$\n");
        sb.append("271;;adicionarOpcao;;arrítmicos$$\n");
        sb.append("271;;vincularHabAoValorDoCampo;;$270CampoDoLaudo;;false;;{presentes}$$\n");

        //numero batimentos / min
        sb.append("272;;vincularHabAoValorDoCampo;;$270CampoDoLaudo;;false;;{presentes}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos internos">

        // sexo
        sb.append("\n315;;adicionarOpcao;;masculino$$\n");
        sb.append("315;;adicionarOpcao;;feminino$$\n");
        sb.append("315;;adicionarOpcao;;não visualizado$$\n");
        sb.append("315;;adicionarOpcao;;não impresso a pedido (masculino)$$\n");
        sb.append("315;;adicionarOpcao;;não impresso a pedido (feminino)$$\n");
        sb.append("315;;adicionarExcecao;;não impresso a pedido (masculino);;$$\n");
        sb.append("315;;adicionarExcecao;;não impresso a pedido (feminino);;$$\n");

        //gordura Peritonial
        sb.append("\n316;;adicionarOpcao;;presente$$\n");
        sb.append("316;;adicionarOpcao;;ausente$$\n");

        //estadiamento Instestinal
        sb.append("\n317;;adicionarOpcao;;grau I$$\n");
        sb.append("317;;adicionarOpcao;;grau II$$\n");
        sb.append("317;;adicionarOpcao;;grau III$$\n");
        sb.append("317;;adicionarOpcao;;grau IV$$\n");

        // Órgãos internos
        sb.append("274;;adicionarOpcao;;normal;;Sem alterações visíveis.$$\n");
        sb.append("274;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("274;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("275;;vincularHabAoValorDoCampo;;$274CampoDoLaudo;;false;;{").append(""+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        //insercao
        sb.append("\n322;;adicionarOpcao;;tópica$$\n");
        sb.append("322;;adicionarOpcao;;heterotópica$$\n");
        sb.append("322;;adicionarOpcao;;prévia marginal$$\n");
        sb.append("322;;adicionarOpcao;;prévia centro parcial$$\n");
        sb.append("322;;adicionarOpcao;;prévia centro total$$\n");
        sb.append("322;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("322;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        //insercao 2
        sb.append("\n323;;adicionarOpcao;;anterior$$\n");
        sb.append("323;;adicionarOpcao;;posterior$$\n");
        sb.append("323;;adicionarOpcao;;fúndica$$\n");
        sb.append("323;;adicionarOpcao;;fúndica anterior$$\n");
        sb.append("323;;adicionarOpcao;;fúndica posterior$$\n");
        sb.append("323;;adicionarOpcao;;anterior lateral direita$$\n");
        sb.append("323;;adicionarOpcao;;anterior lateral esquerda$$\n");
        sb.append("323;;adicionarOpcao;;posterior lateral direita$$\n");
        sb.append("323;;adicionarOpcao;;posterior lateral esquerda$$\n");
        sb.append("323;;vincularHabAoValorDoCampo;;$322CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //espesssura
        sb.append("324;;vincularHabAoValorDoCampo;;$322CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //maturidade
        sb.append("\n325;;adicionarOpcao;;grau 0;;textura homogênea e maturidade grau 0$$\n");
        sb.append("325;;adicionarOpcao;;grau 1;;textura heterogênea e maturidade grau 1$$\n");
        sb.append("325;;adicionarOpcao;;grau 2;;textura heterogênea e maturidade grau 2$$\n");
        sb.append("325;;adicionarOpcao;;grau 3;;maturidade grau 3$$\n");
        sb.append("325;;vincularHabAoValorDoCampo;;$322CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");
        sb.append("325;;setComecarDoZero;;").append(Enumeracao.COMECAR_DO_ZERO_SIM).append("$$\n");

        // Descrição
        sb.append("326;;vincularObrigatorio;;$322CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("326;;vincularHabAoValorDoCampo;;$322CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total|" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        // ILA
        sb.append("\n337;;cadastrarLogica;;;;").append(CampoLogico.INTERVALO).append(";;{0.00|0.01}$$\n");
        sb.append("337;;cadastrarLogica;;(Oligoâmnio - ILA está entre 0,00 e 5,00).;;").append(CampoLogico.INTERVALO).append(";;{0.0|5.0}$$\n");
        sb.append("337;;cadastrarLogica;;(Reduzido - ILA está entre 5,00 e 8,00).;;").append(CampoLogico.INTERVALO).append(";;{5.0|8.0}$$\n");
        sb.append("337;;cadastrarLogica;;(Normal - ILA está entre 8,00 e 22,00).;;").append(CampoLogico.INTERVALO).append(";;{8.0|22.0}$$\n");
        sb.append("337;;cadastrarLogica;;(Aumentado - ILA está entre 22,00 e 25,00).;;").append(CampoLogico.INTERVALO).append(";;{22.0|25.0}$$\n");
        sb.append("337;;cadastrarLogica;;(Poliidrâmnio - ILA é maior ou igual a 25,00).;;").append(CampoLogico.INTERVALO).append(";;{25.0|999.00}$$\n");

        //cordão umbilical
        sb.append("\n328;;adicionarOpcao;;normal;;Com duas artérias e uma veia normoinserida.$$\n");
        sb.append("328;;adicionarOpcao;;artéria única;;Artéria única.$$\n");
        sb.append("328;;adicionarOpcao;;não visualizado;;Não visualizado.$$\n");

        //liquido Amniotico
        sb.append("\n330;;adicionarOpcao;;Normal$$\n");
        sb.append("330;;adicionarOpcao;;Aumento leve$$\n");
        sb.append("330;;adicionarOpcao;;Aumento moderado$$\n");
        sb.append("330;;adicionarOpcao;;Aumento acentuado$$\n");
        sb.append("330;;adicionarOpcao;;Diminuição leve$$\n");
        sb.append("330;;adicionarOpcao;;Diminuição moderada$$\n");
        sb.append("330;;adicionarOpcao;;Diminuição acentuada$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria">

        //campo soma biometria
        sb.append("\n336;;cadastrarParametroFormula;;$331CampoNumero$$\n");
        sb.append("336;;cadastrarParametroFormula;;$332CampoNumero$$\n");
        sb.append("336;;cadastrarParametroFormula;;$333CampoNumero$$\n");
        sb.append("336;;cadastrarParametroFormula;;$334CampoNumero$$\n");

        //ic
        sb.append("\n282;;cadastrarParametroFormula;;$279CampoNumero$$\n");
        sb.append("282;;cadastrarParametroFormula;;$318CampoNumero$$\n");
        //cc
        sb.append("\n290;;cadastrarParametroFormula;;$279CampoNumero$$\n");
        sb.append("290;;cadastrarParametroFormula;;$318CampoNumero$$\n");

        //ca
        sb.append("\n285;;adicionarOpcao;;informar$$\n");
        sb.append("285;;adicionarOpcao;;calcular$$\n");
        sb.append("285;;setValor;;informar$$\n");

        sb.append("\n286;;cadastrarParametroFormula;;$319CampoNumero$$\n");
        sb.append("286;;cadastrarParametroFormula;;$320CampoNumero$$\n");
        sb.append("286;;vincularHabAoValorDoCampo;;$285CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("287;;vincularHabAoValorDoCampo;;$285CampoDoLaudo;;false;;{informar}$$\n");

        sb.append("319;;vincularHabAoValorDoCampo;;$285CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("320;;vincularHabAoValorDoCampo;;$285CampoDoLaudo;;false;;{calcular}$$\n");

        //ccDivca
        sb.append("\n293;;cadastrarParametroFormula;;$290CampoNumero$$\n");
        sb.append("293;;cadastrarParametroFormula;;$286CampoNumero$$\n");
        sb.append("293;;cadastrarParametroFormula;;$287CampoNumero;;2$$\n");
        //cfDivca
        sb.append("\n299;;cadastrarParametroFormula;;$296CampoNumero$$\n");
        sb.append("299;;cadastrarParametroFormula;;$286CampoNumero$$\n");
        sb.append("299;;cadastrarParametroFormula;;$287CampoNumero;;2$$\n");
        //peso fetal
        sb.append("\n311;;cadastrarParametroFormula;;$279CampoNumero$$\n");
        sb.append("311;;cadastrarParametroFormula;;$286CampoNumero$$\n");
        sb.append("311;;cadastrarParametroFormula;;$287CampoNumero;;2$$\n");
        //estatuta fetal
        sb.append("\n314;;cadastrarParametroFormula;;$279CampoNumero$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 4">

        sb.append("338;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)4|(/s)5|(/s)6}$$\n");

        // <editor-fold defaultstate="collapsed" desc="Dados do feto">

        // situação
        sb.append("\n340;;adicionarOpcao;;longitudinal$$\n");
        sb.append("340;;adicionarOpcao;;transversal com polo cefálico à direita$$\n");
        sb.append("340;;adicionarOpcao;;transversal com polo cefálico à esquerda$$\n");
        sb.append("340;;adicionarOpcao;;oblíqua$$\n");
        sb.append("340;;adicionarOpcao;;indiferente$$\n");

        // apresentacao
        sb.append("\n341;;adicionarOpcao;;cefálica$$\n");
        sb.append("341;;adicionarOpcao;;pélvica$$\n");
        sb.append("341;;adicionarOpcao;;córmica$$\n");
        sb.append("341;;adicionarOpcao;;indiferente$$\n");
        sb.append("341;;vincularHabAoValorDoCampo;;$340CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // dorso
        sb.append("\n343;;adicionarOpcao;;à esquerda$$\n");
        sb.append("343;;adicionarOpcao;;à direita$$\n");
        sb.append("343;;adicionarOpcao;;anterior$$\n");
        sb.append("343;;adicionarOpcao;;posterior$$\n");
        sb.append("343;;adicionarOpcao;;superior$$\n");
        sb.append("343;;adicionarOpcao;;inferior$$\n");
        sb.append("343;;adicionarOpcao;;indiferente$$\n");
        sb.append("343;;vincularHabAoValorDoCampo;;$340CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // movimentos fetais
        sb.append("\n344;;adicionarOpcao;;presentes$$\n");
        sb.append("344;;adicionarOpcao;;ausentes$$\n");
        sb.append("344;;vincularHabAoValorDoCampo;;$340CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //movimentos respiratorios
        sb.append("\n346;;adicionarOpcao;;presentes$$\n");
        sb.append("346;;adicionarOpcao;;ausentes$$\n");
        sb.append("346;;adicionarOpcao;;não visualizados$$\n");
        sb.append("346;;vincularHabAoValorDoCampo;;$340CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // batimentos cardiacos
        sb.append("\n348;;adicionarOpcao;;presentes;;$$\n");
        sb.append("348;;adicionarOpcao;;ausentes$$\n");
        sb.append("348;;adicionarOpcao;;não visualizados$$\n");
        sb.append("348;;vincularHabAoValorDoCampo;;$340CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //ritmia
        sb.append("\n349;;adicionarOpcao;;rítmicos$$\n");
        sb.append("349;;adicionarOpcao;;arrítmicos$$\n");
        sb.append("349;;vincularHabAoValorDoCampo;;$348CampoDoLaudo;;false;;{presentes}$$\n");

        //numero batimentos / min
        sb.append("350;;vincularHabAoValorDoCampo;;$348CampoDoLaudo;;false;;{presentes}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos internos">

        // sexo
        sb.append("\n393;;adicionarOpcao;;masculino$$\n");
        sb.append("393;;adicionarOpcao;;feminino$$\n");
        sb.append("393;;adicionarOpcao;;não visualizado$$\n");
        sb.append("393;;adicionarOpcao;;não impresso a pedido (masculino)$$\n");
        sb.append("393;;adicionarOpcao;;não impresso a pedido (feminino)$$\n");
        sb.append("393;;adicionarExcecao;;não impresso a pedido (masculino);;$$\n");
        sb.append("393;;adicionarExcecao;;não impresso a pedido (feminino);;$$\n");

        //gordura Peritonial
        sb.append("\n394;;adicionarOpcao;;presente$$\n");
        sb.append("82;;adicionarOpcao;;ausente$$\n");

        //estadiamento Instestinal
        sb.append("\n395;;adicionarOpcao;;grau I$$\n");
        sb.append("395;;adicionarOpcao;;grau II$$\n");
        sb.append("395;;adicionarOpcao;;grau III$$\n");
        sb.append("395;;adicionarOpcao;;grau IV$$\n");

        // Órgãos internos
        sb.append("352;;adicionarOpcao;;normal;;Sem alterações visíveis.$$\n");
        sb.append("352;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("352;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("353;;vincularHabAoValorDoCampo;;$352CampoDoLaudo;;false;;{").append(""+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        // ILA
        sb.append("\n415;;cadastrarLogica;;;;").append(CampoLogico.INTERVALO).append(";;{0.00|0.01}$$\n");
        sb.append("415;;cadastrarLogica;;(Oligoâmnio - ILA está entre 0,00 e 5,00).;;").append(CampoLogico.INTERVALO).append(";;{0.0|5.0}$$\n");
        sb.append("415;;cadastrarLogica;;(Reduzido - ILA está entre 5,00 e 8,00).;;").append(CampoLogico.INTERVALO).append(";;{5.0|8.0}$$\n");
        sb.append("415;;cadastrarLogica;;(Normal - ILA está entre 8,00 e 22,00).;;").append(CampoLogico.INTERVALO).append(";;{8.0|22.0}$$\n");
        sb.append("415;;cadastrarLogica;;(Aumentado - ILA está entre 22,00 e 25,00).;;").append(CampoLogico.INTERVALO).append(";;{22.0|25.0}$$\n");
        sb.append("415;;cadastrarLogica;;(Poliidrâmnio - ILA é maior ou igual a 25,00).;;").append(CampoLogico.INTERVALO).append(";;{25.0|999.00}$$\n");

        //cordão umbilical
        sb.append("\n406;;adicionarOpcao;;normal;;Com duas artérias e uma veia normoinserida.$$\n");
        sb.append("406;;adicionarOpcao;;artéria única;;Artéria única.$$\n");
        sb.append("406;;adicionarOpcao;;não visualizado;;Não visualizado.$$\n");

        //liquido Amniotico
        sb.append("\n408;;adicionarOpcao;;Normal$$\n");
        sb.append("408;;adicionarOpcao;;Aumento leve$$\n");
        sb.append("408;;adicionarOpcao;;Aumento moderado$$\n");
        sb.append("408;;adicionarOpcao;;Aumento acentuado$$\n");
        sb.append("408;;adicionarOpcao;;Diminuição leve$$\n");
        sb.append("408;;adicionarOpcao;;Diminuição moderada$$\n");
        sb.append("408;;adicionarOpcao;;Diminuição acentuada$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        //insercao
        sb.append("\n400;;adicionarOpcao;;tópica$$\n");
        sb.append("400;;adicionarOpcao;;heterotópica$$\n");
        sb.append("400;;adicionarOpcao;;prévia marginal$$\n");
        sb.append("400;;adicionarOpcao;;prévia centro parcial$$\n");
        sb.append("400;;adicionarOpcao;;prévia centro total$$\n");
        sb.append("400;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("400;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        //insercao 2
        sb.append("\n401;;adicionarOpcao;;anterior$$\n");
        sb.append("401;;adicionarOpcao;;posterior$$\n");
        sb.append("401;;adicionarOpcao;;fúndica$$\n");
        sb.append("401;;adicionarOpcao;;fúndica anterior$$\n");
        sb.append("401;;adicionarOpcao;;fúndica posterior$$\n");
        sb.append("401;;adicionarOpcao;;anterior lateral direita$$\n");
        sb.append("401;;adicionarOpcao;;anterior lateral esquerda$$\n");
        sb.append("401;;adicionarOpcao;;posterior lateral direita$$\n");
        sb.append("401;;adicionarOpcao;;posterior lateral esquerda$$\n");
        sb.append("401;;vincularHabAoValorDoCampo;;$400CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //espesssura
        sb.append("402;;vincularHabAoValorDoCampo;;$400CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //maturidade
        sb.append("\n403;;adicionarOpcao;;grau 0;;textura homogênea e maturidade grau 0$$\n");
        sb.append("403;;adicionarOpcao;;grau 1;;textura heterogênea e maturidade grau 1$$\n");
        sb.append("403;;adicionarOpcao;;grau 2;;textura heterogênea e maturidade grau 2$$\n");
        sb.append("403;;adicionarOpcao;;grau 3;;maturidade grau 3$$\n");
        sb.append("403;;vincularHabAoValorDoCampo;;$400CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");
        sb.append("403;;setComecarDoZero;;").append(Enumeracao.COMECAR_DO_ZERO_SIM).append("$$\n");

        // Descrição
        sb.append("404;;vincularObrigatorio;;$400CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("404;;vincularHabAoValorDoCampo;;$400CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total|" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria">

        //campo soma biometria
        sb.append("\n414;;cadastrarParametroFormula;;$409CampoNumero$$\n");
        sb.append("414;;cadastrarParametroFormula;;$410CampoNumero$$\n");
        sb.append("414;;cadastrarParametroFormula;;$411CampoNumero$$\n");
        sb.append("414;;cadastrarParametroFormula;;$412CampoNumero$$\n");

        //ic
        sb.append("\n360;;cadastrarParametroFormula;;$279CampoNumero$$\n");
        sb.append("360;;cadastrarParametroFormula;;$396CampoNumero$$\n");
        //cc
        sb.append("\n368;;cadastrarParametroFormula;;$279CampoNumero$$\n");
        sb.append("368;;cadastrarParametroFormula;;$396CampoNumero$$\n");

        //ca

        sb.append("\n363;;adicionarOpcao;;informar$$\n");
        sb.append("363;;adicionarOpcao;;calcular$$\n");
        sb.append("363;;setValor;;informar$$\n");

        sb.append("\n364;;cadastrarParametroFormula;;$397CampoNumero$$\n");
        sb.append("364;;cadastrarParametroFormula;;$398CampoNumero$$\n");
        sb.append("364;;vincularHabAoValorDoCampo;;$363CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("365;;vincularHabAoValorDoCampo;;$363CampoDoLaudo;;false;;{informar}$$\n");

        sb.append("397;;vincularHabAoValorDoCampo;;$363CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("398;;vincularHabAoValorDoCampo;;$363CampoDoLaudo;;false;;{calcular}$$\n");

        //ccDivca
        sb.append("\n371;;cadastrarParametroFormula;;$368CampoNumero$$\n");
        sb.append("371;;cadastrarParametroFormula;;$364CampoNumero$$\n");
        sb.append("371;;cadastrarParametroFormula;;$365CampoNumero;;2$$\n");
        //cfDivca
        sb.append("\n377;;cadastrarParametroFormula;;$374CampoNumero$$\n");
        sb.append("377;;cadastrarParametroFormula;;$364CampoNumero$$\n");
        sb.append("377;;cadastrarParametroFormula;;$365CampoNumero;;2$$\n");
        //peso fetal
        sb.append("\n389;;cadastrarParametroFormula;;$357CampoNumero$$\n");
        sb.append("389;;cadastrarParametroFormula;;$364CampoNumero$$\n");
        sb.append("389;;cadastrarParametroFormula;;$365CampoNumero;;2$$\n");
        //estatuta fetal
        sb.append("\n392;;cadastrarParametroFormula;;$357CampoNumero$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 5">

        sb.append("416;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)5|(/s)6}$$\n");

        // <editor-fold defaultstate="collapsed" desc="Dados do feto">

        // situação
        sb.append("\n418;;adicionarOpcao;;longitudinal$$\n");
        sb.append("418;;adicionarOpcao;;transversal com polo cefálico à direita$$\n");
        sb.append("418;;adicionarOpcao;;transversal com polo cefálico à esquerda$$\n");
        sb.append("418;;adicionarOpcao;;oblíqua$$\n");
        sb.append("418;;adicionarOpcao;;indiferente$$\n");

        // apresentacao
        sb.append("\n419;;adicionarOpcao;;cefálica$$\n");
        sb.append("419;;adicionarOpcao;;pélvica$$\n");
        sb.append("419;;adicionarOpcao;;córmica$$\n");
        sb.append("419;;adicionarOpcao;;indiferente$$\n");
        sb.append("419;;vincularHabAoValorDoCampo;;$418CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // dorso
        sb.append("\n421;;adicionarOpcao;;à esquerda$$\n");
        sb.append("421;;adicionarOpcao;;à direita$$\n");
        sb.append("421;;adicionarOpcao;;anterior$$\n");
        sb.append("421;;adicionarOpcao;;posterior$$\n");
        sb.append("421;;adicionarOpcao;;superior$$\n");
        sb.append("421;;adicionarOpcao;;inferior$$\n");
        sb.append("421;;adicionarOpcao;;indiferente$$\n");
        sb.append("421;;vincularHabAoValorDoCampo;;$418CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // movimentos fetais
        sb.append("\n422;;adicionarOpcao;;presentes$$\n");
        sb.append("422;;adicionarOpcao;;ausentes$$\n");
        sb.append("422;;vincularHabAoValorDoCampo;;$418CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //movimentos respiratorios
        sb.append("\n424;;adicionarOpcao;;presentes$$\n");
        sb.append("424;;adicionarOpcao;;ausentes$$\n");
        sb.append("424;;adicionarOpcao;;não visualizados$$\n");
        sb.append("424;;vincularHabAoValorDoCampo;;$418CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // batimentos cardiacos
        sb.append("\n426;;adicionarOpcao;;presentes;;$$\n");
        sb.append("426;;adicionarOpcao;;ausentes$$\n");
        sb.append("426;;adicionarOpcao;;não visualizados$$\n");
        sb.append("426;;vincularHabAoValorDoCampo;;$418CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //ritmia
        sb.append("\n427;;adicionarOpcao;;rítmicos$$\n");
        sb.append("427;;adicionarOpcao;;arrítmicos$$\n");
        sb.append("427;;vincularHabAoValorDoCampo;;$426CampoDoLaudo;;false;;{presentes}$$\n");

        //numero batimentos / min
        sb.append("428;;vincularHabAoValorDoCampo;;$426CampoDoLaudo;;false;;{presentes}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos internos">

        //sexo Fetal
        sb.append("\n471;;adicionarOpcao;;masculino$$\n");
        sb.append("471;;adicionarOpcao;;feminino$$\n");
        sb.append("471;;adicionarOpcao;;não visualizado$$\n");
        sb.append("471;;adicionarOpcao;;não impresso a pedido (masculino)$$\n");
        sb.append("471;;adicionarOpcao;;não impresso a pedido (feminino)$$\n");
        sb.append("471;;adicionarExcecao;;não impresso a pedido (masculino);;$$\n");
        sb.append("471;;adicionarExcecao;;não impresso a pedido (feminino);;$$\n");

        //gordura Peritonial
        sb.append("\n472;;adicionarOpcao;;presente$$\n");
        sb.append("472;;adicionarOpcao;;ausente$$\n");

        //estadiamento Instestinal
        sb.append("\n473;;adicionarOpcao;;grau I$$\n");
        sb.append("473;;adicionarOpcao;;grau II$$\n");
        sb.append("473;;adicionarOpcao;;grau III$$\n");
        sb.append("473;;adicionarOpcao;;grau IV$$\n");

        // Órgãos internos
        sb.append("430;;adicionarOpcao;;normal;;Sem alterações visíveis.$$\n");
        sb.append("430;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("430;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("431;;vincularHabAoValorDoCampo;;$430CampoDoLaudo;;false;;{").append(""+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        // ILA
        sb.append("\n493;;cadastrarLogica;;;;").append(CampoLogico.INTERVALO).append(";;{0.00|0.01}$$\n");
        sb.append("493;;cadastrarLogica;;(Oligoâmnio - ILA está entre 0,00 e 5,00).;;").append(CampoLogico.INTERVALO).append(";;{0.0|5.0}$$\n");
        sb.append("493;;cadastrarLogica;;(Reduzido - ILA está entre 5,00 e 8,00).;;").append(CampoLogico.INTERVALO).append(";;{5.0|8.0}$$\n");
        sb.append("493;;cadastrarLogica;;(Normal - ILA está entre 8,00 e 22,00).;;").append(CampoLogico.INTERVALO).append(";;{8.0|22.0}$$\n");
        sb.append("493;;cadastrarLogica;;(Aumentado - ILA está entre 22,00 e 25,00).;;").append(CampoLogico.INTERVALO).append(";;{22.0|25.0}$$\n");
        sb.append("493;;cadastrarLogica;;(Poliidrâmnio - ILA é maior ou igual a 25,00).;;").append(CampoLogico.INTERVALO).append(";;{25.0|999.00}$$\n");

        //cordão umbilical
        sb.append("\n484;;adicionarOpcao;;normal;;Com duas artérias e uma veia normoinserida.$$\n");
        sb.append("484;;adicionarOpcao;;artéria única;;Artéria única.$$\n");
        sb.append("484;;adicionarOpcao;;não visualizado;;Não visualizado.$$\n");

        //liquido Amniotico
        sb.append("\n486;;adicionarOpcao;;Normal$$\n");
        sb.append("486;;adicionarOpcao;;Aumento leve$$\n");
        sb.append("486;;adicionarOpcao;;Aumento moderado$$\n");
        sb.append("486;;adicionarOpcao;;Aumento acentuado$$\n");
        sb.append("486;;adicionarOpcao;;Diminuição leve$$\n");
        sb.append("486;;adicionarOpcao;;Diminuição moderada$$\n");
        sb.append("486;;adicionarOpcao;;Diminuição acentuada$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        //insercao
        sb.append("\n478;;adicionarOpcao;;tópica$$\n");
        sb.append("478;;adicionarOpcao;;heterotópica$$\n");
        sb.append("478;;adicionarOpcao;;prévia marginal$$\n");
        sb.append("478;;adicionarOpcao;;prévia centro parcial$$\n");
        sb.append("478;;adicionarOpcao;;prévia centro total$$\n");
        sb.append("478;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("478;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        //insercao 2
        sb.append("\n479;;adicionarOpcao;;anterior$$\n");
        sb.append("479;;adicionarOpcao;;posterior$$\n");
        sb.append("479;;adicionarOpcao;;fúndica$$\n");
        sb.append("479;;adicionarOpcao;;fúndica anterior$$\n");
        sb.append("479;;adicionarOpcao;;fúndica posterior$$\n");
        sb.append("479;;adicionarOpcao;;anterior lateral direita$$\n");
        sb.append("479;;adicionarOpcao;;anterior lateral esquerda$$\n");
        sb.append("479;;adicionarOpcao;;posterior lateral direita$$\n");
        sb.append("479;;adicionarOpcao;;posterior lateral esquerda$$\n");
        sb.append("479;;vincularHabAoValorDoCampo;;$478CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //maturidade
        sb.append("\n481;;adicionarOpcao;;grau 0;;textura homogênea e maturidade grau 0$$\n");
        sb.append("481;;adicionarOpcao;;grau 1;;textura heterogênea e maturidade grau 1$$\n");
        sb.append("481;;adicionarOpcao;;grau 2;;textura heterogênea e maturidade grau 2$$\n");
        sb.append("481;;adicionarOpcao;;grau 3;;maturidade grau 3$$\n");
        sb.append("481;;vincularHabAoValorDoCampo;;$478CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");
        sb.append("481;;setComecarDoZero;;").append(Enumeracao.COMECAR_DO_ZERO_SIM).append("$$\n");

        //espesssura
        sb.append("480;;vincularHabAoValorDoCampo;;$478CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        // Descrição
        sb.append("482;;vincularObrigatorio;;$478CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("482;;vincularHabAoValorDoCampo;;$478CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total|" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria">

        //campo soma biometria
        sb.append("\n492;;cadastrarParametroFormula;;$487CampoNumero$$\n");
        sb.append("492;;cadastrarParametroFormula;;$488CampoNumero$$\n");
        sb.append("492;;cadastrarParametroFormula;;$489CampoNumero$$\n");
        sb.append("492;;cadastrarParametroFormula;;$490CampoNumero$$\n");

        //ic
        sb.append("\n438;;cadastrarParametroFormula;;$435CampoNumero$$\n");
        sb.append("438;;cadastrarParametroFormula;;$474CampoNumero$$\n");
        //cc
        sb.append("\n446;;cadastrarParametroFormula;;$435CampoNumero$$\n");
        sb.append("446;;cadastrarParametroFormula;;$474CampoNumero$$\n");

        //ca

        sb.append("\n441;;adicionarOpcao;;informar$$\n");
        sb.append("441;;adicionarOpcao;;calcular$$\n");
        sb.append("441;;setValor;;informar$$\n");

        sb.append("\n442;;cadastrarParametroFormula;;$475CampoNumero$$\n");
        sb.append("442;;cadastrarParametroFormula;;$476CampoNumero$$\n");
        sb.append("442;;vincularHabAoValorDoCampo;;$441CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("443;;vincularHabAoValorDoCampo;;$441CampoDoLaudo;;false;;{informar}$$\n");

        sb.append("475;;vincularHabAoValorDoCampo;;$441CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("476;;vincularHabAoValorDoCampo;;$441CampoDoLaudo;;false;;{calcular}$$\n");

        //ccDivca
        sb.append("\n449;;cadastrarParametroFormula;;$446CampoNumero$$\n");
        sb.append("449;;cadastrarParametroFormula;;$442CampoNumero$$\n");
        sb.append("449;;cadastrarParametroFormula;;$443CampoNumero;;2$$\n");
        //cfDivca
        sb.append("\n455;;cadastrarParametroFormula;;$452CampoNumero$$\n");
        sb.append("455;;cadastrarParametroFormula;;$442CampoNumero$$\n");
        sb.append("455;;cadastrarParametroFormula;;$443CampoNumero;;2$$\n");
        //peso fetal
        sb.append("\n467;;cadastrarParametroFormula;;$435CampoNumero$$\n");
        sb.append("467;;cadastrarParametroFormula;;$442CampoNumero$$\n");
        sb.append("467;;cadastrarParametroFormula;;$443CampoNumero;;2$$\n");
        //estatuta fetal
        sb.append("\n470;;cadastrarParametroFormula;;$435CampoNumero$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 6">

        sb.append("494;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)6}$$\n");

        // <editor-fold defaultstate="collapsed" desc="Dados do feto">

        // situação
        sb.append("\n496;;adicionarOpcao;;longitudinal$$\n");
        sb.append("496;;adicionarOpcao;;transversal com polo cefálico à direita$$\n");
        sb.append("496;;adicionarOpcao;;transversal com polo cefálico à esquerda$$\n");
        sb.append("496;;adicionarOpcao;;oblíqua$$\n");
        sb.append("496;;adicionarOpcao;;indiferente$$\n");

        // apresentacao
        sb.append("\n497;;adicionarOpcao;;cefálica$$\n");
        sb.append("497;;adicionarOpcao;;pélvica$$\n");
        sb.append("497;;adicionarOpcao;;córmica$$\n");
        sb.append("497;;adicionarOpcao;;indiferente$$\n");
        sb.append("497;;vincularHabAoValorDoCampo;;$496CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // dorso
        sb.append("\n499;;adicionarOpcao;;à esquerda$$\n");
        sb.append("499;;adicionarOpcao;;à direita$$\n");
        sb.append("499;;adicionarOpcao;;anterior$$\n");
        sb.append("499;;adicionarOpcao;;posterior$$\n");
        sb.append("499;;adicionarOpcao;;superior$$\n");
        sb.append("499;;adicionarOpcao;;inferior$$\n");
        sb.append("499;;adicionarOpcao;;indiferente$$\n");
        sb.append("499;;vincularHabAoValorDoCampo;;$496CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // movimentos fetais
        sb.append("\n500;;adicionarOpcao;;presentes$$\n");
        sb.append("500;;adicionarOpcao;;ausentes$$\n");
        sb.append("500;;vincularHabAoValorDoCampo;;$496CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //movimentos respiratorios
        sb.append("\n502;;adicionarOpcao;;presentes$$\n");
        sb.append("502;;adicionarOpcao;;ausentes$$\n");
        sb.append("502;;adicionarOpcao;;não visualizados$$\n");
        sb.append("502;;vincularHabAoValorDoCampo;;$496CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // batimentos cardiacos
        sb.append("\n504;;adicionarOpcao;;presentes;;$$\n");
        sb.append("504;;adicionarOpcao;;ausentes$$\n");
        sb.append("504;;adicionarOpcao;;não visualizados$$\n");
        sb.append("504;;vincularHabAoValorDoCampo;;$496CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //ritmia
        sb.append("\n505;;adicionarOpcao;;rítmicos$$\n");
        sb.append("505;;adicionarOpcao;;arrítmicos$$\n");
        sb.append("505;;vincularHabAoValorDoCampo;;$504CampoDoLaudo;;false;;{presentes}$$\n");

        //numero batimentos / min
        sb.append("506;;vincularHabAoValorDoCampo;;$504CampoDoLaudo;;false;;{presentes}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos internos">

        // sexo
        sb.append("\n549;;adicionarOpcao;;masculino$$\n");
        sb.append("549;;adicionarOpcao;;feminino$$\n");
        sb.append("549;;adicionarOpcao;;não visualizado$$\n");
        sb.append("549;;adicionarOpcao;;não impresso a pedido (masculino)$$\n");
        sb.append("549;;adicionarOpcao;;não impresso a pedido (feminino)$$\n");
        sb.append("549;;adicionarExcecao;;não impresso a pedido (masculino);;$$\n");
        sb.append("549;;adicionarExcecao;;não impresso a pedido (feminino);;$$\n");

        //gordura Peritonial
        sb.append("\n550;;adicionarOpcao;;presente$$\n");
        sb.append("550;;adicionarOpcao;;ausente$$\n");

        //estadiamento Instestinal
        sb.append("\n551;;adicionarOpcao;;grau I$$\n");
        sb.append("551;;adicionarOpcao;;grau II$$\n");
        sb.append("551;;adicionarOpcao;;grau III$$\n");
        sb.append("551;;adicionarOpcao;;grau IV$$\n");

        // Órgãos internos
        sb.append("508;;adicionarOpcao;;normal;;Sem alterações visíveis.$$\n");
        sb.append("508;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("508;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("509;;vincularHabAoValorDoCampo;;$508CampoDoLaudo;;false;;{").append(""+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        // ILA
        sb.append("\n571;;cadastrarLogica;;;;").append(CampoLogico.INTERVALO).append(";;{0.00|0.01}$$\n");
        sb.append("571;;cadastrarLogica;;(Oligoâmnio - ILA está entre 0,00 e 5,00).;;").append(CampoLogico.INTERVALO).append(";;{0.0|5.0}$$\n");
        sb.append("571;;cadastrarLogica;;(Reduzido - ILA está entre 5,00 e 8,00).;;").append(CampoLogico.INTERVALO).append(";;{5.0|8.0}$$\n");
        sb.append("571;;cadastrarLogica;;(Normal - ILA está entre 8,00 e 22,00).;;").append(CampoLogico.INTERVALO).append(";;{8.0|22.0}$$\n");
        sb.append("571;;cadastrarLogica;;(Aumentado - ILA está entre 22,00 e 25,00).;;").append(CampoLogico.INTERVALO).append(";;{22.0|25.0}$$\n");
        sb.append("571;;cadastrarLogica;;(Poliidrâmnio - ILA é maior ou igual a 25,00).;;").append(CampoLogico.INTERVALO).append(";;{25.0|999.00}$$\n");

        //cordão umbilical
        sb.append("\n562;;adicionarOpcao;;normal;;Com duas artérias e uma veia normoinserida.$$\n");
        sb.append("562;;adicionarOpcao;;artéria única;;Artéria única.$$\n");
        sb.append("562;;adicionarOpcao;;não visualizado$$\n");

        //liquido Amniotico
        sb.append("\n564;;adicionarOpcao;;Normal$$\n");
        sb.append("564;;adicionarOpcao;;Aumento leve$$\n");
        sb.append("564;;adicionarOpcao;;Aumento moderado$$\n");
        sb.append("564;;adicionarOpcao;;Aumento acentuado$$\n");
        sb.append("564;;adicionarOpcao;;Diminuição leve$$\n");
        sb.append("564;;adicionarOpcao;;Diminuição moderada$$\n");
        sb.append("564;;adicionarOpcao;;Diminuição acentuada$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria">

        //campo soma biometria
        sb.append("\n570;;cadastrarParametroFormula;;$565CampoNumero$$\n");
        sb.append("570;;cadastrarParametroFormula;;$566CampoNumero$$\n");
        sb.append("570;;cadastrarParametroFormula;;$567CampoNumero$$\n");
        sb.append("570;;cadastrarParametroFormula;;$568CampoNumero$$\n");

        //ic
        sb.append("\n516;;cadastrarParametroFormula;;$513CampoNumero$$\n");
        sb.append("516;;cadastrarParametroFormula;;$552CampoNumero$$\n");
        //cc
        sb.append("\n524;;cadastrarParametroFormula;;$513CampoNumero$$\n");
        sb.append("524;;cadastrarParametroFormula;;$552CampoNumero$$\n");

        //ca

        sb.append("\n519;;adicionarOpcao;;informar$$\n");
        sb.append("519;;adicionarOpcao;;calcular$$\n");
        sb.append("519;;setValor;;informar$$\n");

        sb.append("\n520;;cadastrarParametroFormula;;$553CampoNumero$$\n");
        sb.append("520;;cadastrarParametroFormula;;$554CampoNumero$$\n");
        sb.append("520;;vincularHabAoValorDoCampo;;$519CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("521;;vincularHabAoValorDoCampo;;$519CampoDoLaudo;;false;;{informar}$$\n");

        sb.append("553;;vincularHabAoValorDoCampo;;$519CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("554;;vincularHabAoValorDoCampo;;$519CampoDoLaudo;;false;;{calcular}$$\n");

        //ccDivca
        sb.append("\n527;;cadastrarParametroFormula;;$524CampoNumero$$\n");
        sb.append("527;;cadastrarParametroFormula;;$520CampoNumero$$\n");
        sb.append("527;;cadastrarParametroFormula;;$521CampoNumero;;2$$\n");
        //cfDivca
        sb.append("\n533;;cadastrarParametroFormula;;$530CampoNumero$$\n");
        sb.append("533;;cadastrarParametroFormula;;$520CampoNumero$$\n");
        sb.append("533;;cadastrarParametroFormula;;$521CampoNumero;;2$$\n");
        //peso fetal
        sb.append("\n545;;cadastrarParametroFormula;;$513CampoNumero$$\n");
        sb.append("545;;cadastrarParametroFormula;;$520CampoNumero$$\n");
        sb.append("545;;cadastrarParametroFormula;;$521CampoNumero;;2$$\n");
        //estatuta fetal
        sb.append("\n548;;cadastrarParametroFormula;;$513CampoNumero$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        //insercao
        sb.append("\n556;;adicionarOpcao;;tópica$$\n");
        sb.append("556;;adicionarOpcao;;heterotópica$$\n");
        sb.append("556;;adicionarOpcao;;prévia marginal$$\n");
        sb.append("556;;adicionarOpcao;;prévia centro parcial$$\n");
        sb.append("556;;adicionarOpcao;;prévia centro total$$\n");
        sb.append("556;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("556;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        //insercao 2
        sb.append("\n557;;adicionarOpcao;;anterior$$\n");
        sb.append("557;;adicionarOpcao;;posterior$$\n");
        sb.append("557;;adicionarOpcao;;fúndica$$\n");
        sb.append("557;;adicionarOpcao;;fúndica anterior$$\n");
        sb.append("557;;adicionarOpcao;;fúndica posterior$$\n");
        sb.append("557;;adicionarOpcao;;anterior lateral direita$$\n");
        sb.append("557;;adicionarOpcao;;anterior lateral esquerda$$\n");
        sb.append("557;;adicionarOpcao;;posterior lateral direita$$\n");
        sb.append("557;;adicionarOpcao;;posterior lateral esquerda$$\n");
        sb.append("557;;vincularHabAoValorDoCampo;;$556CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //espesssura
        sb.append("558;;vincularHabAoValorDoCampo;;$556CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        // maturidade
        sb.append("\n559;;adicionarOpcao;;grau 0;;textura homogênea e maturidade grau 0$$\n");
        sb.append("559;;adicionarOpcao;;grau 1;;textura heterogênea e maturidade grau 1$$\n");
        sb.append("559;;adicionarOpcao;;grau 2;;textura heterogênea e maturidade grau 2$$\n");
        sb.append("559;;adicionarOpcao;;grau 3;;maturidade grau 3$$\n");
        sb.append("559;;vincularHabAoValorDoCampo;;$556CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");
        sb.append("559;;setComecarDoZero;;").append(Enumeracao.COMECAR_DO_ZERO_SIM).append("$$\n");

        // Descrição
        sb.append("560;;vincularObrigatorio;;$556CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("560;;vincularHabAoValorDoCampo;;$556CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total|" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="IGH pela biometria">

        sb.append("45;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("52;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("53;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("56;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("62;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("68;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("71;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("74;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("85;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("86;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");

        sb.append("123;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("130;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("131;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("134;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("140;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("146;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("149;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("152;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("163;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("164;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");

        preencherIghFeto1();
        preencherIghFeto2();
        preencherIghFeto3();
        preencherIghFeto4();
        preencherIghFeto5();
        preencherIghFeto6();

        // </editor-fold>

        sb.append("\n43;;cadastrarParametroFormula;;$585CampoNumero$$\n");
        sb.append("\n121;;cadastrarParametroFormula;;$585CampoNumero$$\n");
        sb.append("\n199;;cadastrarParametroFormula;;$585CampoNumero$$\n");
        sb.append("\n277;;cadastrarParametroFormula;;$585CampoNumero$$\n");
        sb.append("\n355;;cadastrarParametroFormula;;$585CampoNumero$$\n");
        sb.append("\n433;;cadastrarParametroFormula;;$585CampoNumero$$\n");
        sb.append("\n511;;cadastrarParametroFormula;;$585CampoNumero$$\n");

        sb.append("50;;setarHtmlCampoDes;;$52CampoDoLaudo;;$$\n");
        sb.append("50;;setarHtmlCampoDes;;$53CampoDoLaudo;;$$\n");

        sb.append("128;;setarHtmlCampoDes;;$130CampoDoLaudo;;$$\n");
        sb.append("128;;setarHtmlCampoDes;;$131CampoDoLaudo;;$$\n");

        sb.append("206;;setarHtmlCampoDes;;$208CampoDoLaudo;;$$\n");
        sb.append("206;;setarHtmlCampoDes;;$209CampoDoLaudo;;$$\n");

        sb.append("284;;setarHtmlCampoDes;;$286CampoDoLaudo;;$$\n");
        sb.append("284;;setarHtmlCampoDes;;$287CampoDoLaudo;;$$\n");

        sb.append("362;;setarHtmlCampoDes;;$364CampoDoLaudo;;$$\n");
        sb.append("362;;setarHtmlCampoDes;;$365CampoDoLaudo;;$$\n");

        sb.append("440;;setarHtmlCampoDes;;$442CampoDoLaudo;;$$\n");
        sb.append("440;;setarHtmlCampoDes;;$443CampoDoLaudo;;$$\n");

        sb.append("518;;setarHtmlCampoDes;;$520CampoDoLaudo;;$$\n");
        sb.append("518;;setarHtmlCampoDes;;$521CampoDoLaudo;;$$\n");

        preencherRef();
        preencherRef1();
        preencherRef2();
        preencherRef3();
        preencherRef4();
        preencherRef5();
        preencherRef6();

        sb.append("643;;adicionarOpcao;;sim$$\n");
        sb.append("643;;adicionarOpcao;;não$$\n");
        sb.append("599;;vincularHabAoValorDoCampo;;$643CampoDoLaudo;;false;;{sim}$$\n");

        // </editor-fold>

        alterarModeloDeLaudo(31);

    }

    private static void preencherRef ()
    {
        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("46;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("44;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("46;;cadastrarLogica;;0->78;;$$\n");
        sb.append("46;;cadastrarLogica;;78->85;;13 a 22$$\n");
        sb.append("46;;cadastrarLogica;;85->92;;16 a 25$$\n");
        sb.append("46;;cadastrarLogica;;92->99;;20 a 29$$\n");
        sb.append("46;;cadastrarLogica;;99->106;;23 a 32$$\n");
        sb.append("46;;cadastrarLogica;;106->113;;27 a 36$$\n");
        sb.append("46;;cadastrarLogica;;113->120;;30 a 39$$\n");
        sb.append("46;;cadastrarLogica;;120->127;;34 a 43$$\n");
        sb.append("46;;cadastrarLogica;;127->134;;37 a 46$$\n");
        sb.append("46;;cadastrarLogica;;134->141;;40 a 49$$\n");
        sb.append("46;;cadastrarLogica;;141->148;;44 a 53$$\n");
        sb.append("46;;cadastrarLogica;;148->155;;47 a 56$$\n");
        sb.append("46;;cadastrarLogica;;155->162;;50 a 59$$\n");
        sb.append("46;;cadastrarLogica;;162->169;;53 a 62$$\n");
        sb.append("46;;cadastrarLogica;;169->176;;56 a 65$$\n");
        sb.append("46;;cadastrarLogica;;176->183;;59 a 68$$\n");
        sb.append("46;;cadastrarLogica;;183->190;;62 a 71$$\n");
        sb.append("46;;cadastrarLogica;;190->197;;65 a 74$$\n");
        sb.append("46;;cadastrarLogica;;197->204;;68 a 77$$\n");
        sb.append("46;;cadastrarLogica;;204->211;;70 a 79$$\n");
        sb.append("46;;cadastrarLogica;;211->218;;73 a 82$$\n");
        sb.append("46;;cadastrarLogica;;218->225;;75 a 84$$\n");
        sb.append("46;;cadastrarLogica;;225->232;;77 a 86$$\n");
        sb.append("46;;cadastrarLogica;;232->239;;79 a 88$$\n");
        sb.append("46;;cadastrarLogica;;239->246;;81 a 90$$\n");
        sb.append("46;;cadastrarLogica;;246->253;;83 a 92$$\n");
        sb.append("46;;cadastrarLogica;;253->260;;84 a 93$$\n");
        sb.append("46;;cadastrarLogica;;260->267;;86 a 95$$\n");
        sb.append("46;;cadastrarLogica;;267->274;;87 a 96$$\n");
        sb.append("46;;cadastrarLogica;;274->281;;88 a 97$$\n");
        sb.append("46;;cadastrarLogica;;281->288;;89 a 98$$\n");
        sb.append("46;;cadastrarLogica;;288->295;;89 a 98$$\n");
        sb.append("46;;cadastrarLogica;;295->600;;90 a 99$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="IC">

//        sb.append("47;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CA">

        sb.append("54;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("52;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("54;;cadastrarLogica;;0->78;;$$\n");
        sb.append("54;;cadastrarLogica;;78->85;;$$\n");
        sb.append("54;;cadastrarLogica;;85->92;;$$\n");
        sb.append("54;;cadastrarLogica;;92->99;;$$\n");
        sb.append("54;;cadastrarLogica;;99->106;;67 a 79$$\n");
        sb.append("54;;cadastrarLogica;;106->113;;79 a 93$$\n");
        sb.append("54;;cadastrarLogica;;113->120;;91 a 107$$\n");
        sb.append("54;;cadastrarLogica;;120->127;;103 a 121$$\n");
        sb.append("54;;cadastrarLogica;;127->134;;115 a 135$$\n");
        sb.append("54;;cadastrarLogica;;134->141;;126 a 148$$\n");
        sb.append("54;;cadastrarLogica;;141->148;;138 a 163$$\n");
        sb.append("54;;cadastrarLogica;;148->155;;149 a 176$$\n");
        sb.append("54;;cadastrarLogica;;155->162;;160 a 188$$\n");
        sb.append("54;;cadastrarLogica;;162->169;;170 a 200$$\n");
        sb.append("54;;cadastrarLogica;;169->176;;181 a 213$$\n");
        sb.append("54;;cadastrarLogica;;176->183;;191 a 225$$\n");
        sb.append("54;;cadastrarLogica;;183->190;;201 a 237$$\n");
        sb.append("54;;cadastrarLogica;;190->197;;211 a 249$$\n");
        sb.append("54;;cadastrarLogica;;197->204;;220 a 260$$\n");
        sb.append("54;;cadastrarLogica;;204->211;;230 a 272$$\n");
        sb.append("54;;cadastrarLogica;;211->218;;239 a 283$$\n");
        sb.append("54;;cadastrarLogica;;218->225;;249 a 294$$\n");
        sb.append("54;;cadastrarLogica;;225->232;;258 a 304$$\n");
        sb.append("54;;cadastrarLogica;;232->239;;267 a 315$$\n");
        sb.append("54;;cadastrarLogica;;239->246;;275 a 325$$\n");
        sb.append("54;;cadastrarLogica;;246->253;;283 a 335$$\n");
        sb.append("54;;cadastrarLogica;;253->260;;292 a 344$$\n");
        sb.append("54;;cadastrarLogica;;260->267;;300 a 354$$\n");
        sb.append("54;;cadastrarLogica;;267->274;;308 a 364$$\n");
        sb.append("54;;cadastrarLogica;;274->281;;316 a 373$$\n");
        sb.append("54;;cadastrarLogica;;281->288;;324 a 382$$\n");
        sb.append("54;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CC">

        sb.append("57;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("55;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("57;;cadastrarLogica;;0->78;;$$\n");
        sb.append("57;;cadastrarLogica;;78->85;;$$\n");
        sb.append("57;;cadastrarLogica;;85->92;;51 a 89$$\n");
        sb.append("57;;cadastrarLogica;;92->99;;65 a 103$$\n");
        sb.append("57;;cadastrarLogica;;99->106;;79 a 117$$\n");
        sb.append("57;;cadastrarLogica;;106->113;;92 a 130$$\n");
        sb.append("57;;cadastrarLogica;;113->120;;105 a 43$$\n");
        sb.append("57;;cadastrarLogica;;120->127;;118 a 156$$\n");
        sb.append("57;;cadastrarLogica;;127->134;;131 a 169$$\n");
        sb.append("57;;cadastrarLogica;;134->141;;144 a 182$$\n");
        sb.append("57;;cadastrarLogica;;141->148;;156 a 194$$\n");
        sb.append("57;;cadastrarLogica;;148->155;;168 a 206$$\n");
        sb.append("57;;cadastrarLogica;;155->162;;180 a 218$$\n");
        sb.append("57;;cadastrarLogica;;162->169;;191 a 229$$\n");
        sb.append("57;;cadastrarLogica;;169->176;;202 a 240$$\n");
        sb.append("57;;cadastrarLogica;;176->183;;213 a 251$$\n");
        sb.append("57;;cadastrarLogica;;183->190;;223 a 261$$\n");
        sb.append("57;;cadastrarLogica;;190->197;;233 a 271$$\n");
        sb.append("57;;cadastrarLogica;;197->204;;243 a 281$$\n");
        sb.append("57;;cadastrarLogica;;204->211;;252 a 290$$\n");
        sb.append("57;;cadastrarLogica;;211->218;;261 a 299$$\n");
        sb.append("57;;cadastrarLogica;;218->225;;270 a 308$$\n");
        sb.append("57;;cadastrarLogica;;225->232;;278 a 316$$\n");
        sb.append("57;;cadastrarLogica;;232->239;;285 a 323$$\n");
        sb.append("57;;cadastrarLogica;;239->246;;293 a 331$$\n");
        sb.append("57;;cadastrarLogica;;246->253;;299 a 337$$\n");
        sb.append("57;;cadastrarLogica;;253->260;;306 a 344$$\n");
        sb.append("57;;cadastrarLogica;;260->267;;311 a 349$$\n");
        sb.append("57;;cadastrarLogica;;267->274;;319 a 355$$\n");
        sb.append("57;;cadastrarLogica;;274->281;;322 a 360$$\n");
        sb.append("57;;cadastrarLogica;;281->288;;326 a 364$$\n");
        sb.append("57;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CC / CA">

        sb.append("60;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("58;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("60;;cadastrarLogica;;0->78;;$$\n");
        sb.append("60;;cadastrarLogica;;78->85;;$$\n");
        sb.append("60;;cadastrarLogica;;85->92;;1,12 a 1,31$$\n");
        sb.append("60;;cadastrarLogica;;92->99;;1,11 a 1,30$$\n");
        sb.append("60;;cadastrarLogica;;99->106;;1,10 a 1,29$$\n");
        sb.append("60;;cadastrarLogica;;106->113;;1,09 a 1,28$$\n");
        sb.append("60;;cadastrarLogica;;113->120;;1,08 a 1,27$$\n");
        sb.append("60;;cadastrarLogica;;120->127;;1,07 a 1,26$$\n");
        sb.append("60;;cadastrarLogica;;127->134;;1,06 a 1,25$$\n");
        sb.append("60;;cadastrarLogica;;134->141;;1,06 a 1,24$$\n");
        sb.append("60;;cadastrarLogica;;141->148;;1,05 a 1,24$$\n");
        sb.append("60;;cadastrarLogica;;148->155;;1,04 a 1,23$$\n");
        sb.append("60;;cadastrarLogica;;155->162;;1,03 a 1,22$$\n");
        sb.append("60;;cadastrarLogica;;162->169;;1,02 a 1,21$$\n");
        sb.append("60;;cadastrarLogica;;169->176;;1,01 a 1,20$$\n");
        sb.append("60;;cadastrarLogica;;176->183;;1,00 a 1,19$$\n");
        sb.append("60;;cadastrarLogica;;183->190;;1,00 a 1,18$$\n");
        sb.append("60;;cadastrarLogica;;190->197;;0,99 a 1,18$$\n");
        sb.append("60;;cadastrarLogica;;197->204;;0,98 a 1,17$$\n");
        sb.append("60;;cadastrarLogica;;204->211;;0,97 a 1,16$$\n");
        sb.append("60;;cadastrarLogica;;211->218;;0,96 a 1,15$$\n");
        sb.append("60;;cadastrarLogica;;218->225;;0,95 a 1,14$$\n");
        sb.append("60;;cadastrarLogica;;225->232;;0,95 a 1,13$$\n");
        sb.append("60;;cadastrarLogica;;232->239;;0,94 a 1,13$$\n");
        sb.append("60;;cadastrarLogica;;239->246;;0,93 a 1,12$$\n");
        sb.append("60;;cadastrarLogica;;246->253;;0,93 a 1,12$$\n");
        sb.append("60;;cadastrarLogica;;253->260;;0,92 a 1,11$$\n");
        sb.append("60;;cadastrarLogica;;260->267;;0,91 a 1,10$$\n");
        sb.append("60;;cadastrarLogica;;267->274;;0,89 a 1,09$$\n");
        sb.append("60;;cadastrarLogica;;274->281;;0,89 a 1,09$$\n");
        sb.append("60;;cadastrarLogica;;281->288;;0,89 a 1,08$$\n");
        sb.append("60;;cadastrarLogica;;288->295;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CF">

        sb.append("63;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("61;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("63;;cadastrarLogica;;0->78;;$$\n");
        sb.append("63;;cadastrarLogica;;78->85;;$$\n");
        sb.append("63;;cadastrarLogica;;85->92;;2 a 14$$\n");
        sb.append("63;;cadastrarLogica;;92->99;;5 a 17$$\n");
        sb.append("63;;cadastrarLogica;;99->106;;9 a 21$$\n");
        sb.append("63;;cadastrarLogica;;106->113;;12 a 24$$\n");
        sb.append("63;;cadastrarLogica;;113->120;;15 a 27$$\n");
        sb.append("63;;cadastrarLogica;;120->127;;18 a 30$$\n");
        sb.append("63;;cadastrarLogica;;127->134;;21 a 33$$\n");
        sb.append("63;;cadastrarLogica;;134->141;;23 a 36$$\n");
        sb.append("63;;cadastrarLogica;;141->148;;27 a 39$$\n");
        sb.append("63;;cadastrarLogica;;148->155;;30 a 42$$\n");
        sb.append("63;;cadastrarLogica;;155->162;;33 a 45$$\n");
        sb.append("63;;cadastrarLogica;;162->169;;36 a 48$$\n");
        sb.append("63;;cadastrarLogica;;169->176;;38 a 50$$\n");
        sb.append("63;;cadastrarLogica;;176->183;;41 a 53$$\n");
        sb.append("63;;cadastrarLogica;;183->190;;43 a 55$$\n");
        sb.append("63;;cadastrarLogica;;190->197;;46 a 58$$\n");
        sb.append("63;;cadastrarLogica;;197->204;;48 a 60$$\n");
        sb.append("63;;cadastrarLogica;;204->211;;50 a 62$$\n");
        sb.append("63;;cadastrarLogica;;211->218;;52 a 64$$\n");
        sb.append("63;;cadastrarLogica;;218->225;;55 a 67$$\n");
        sb.append("63;;cadastrarLogica;;225->232;;57 a 69$$\n");
        sb.append("63;;cadastrarLogica;;232->239;;59 a 71$$\n");
        sb.append("63;;cadastrarLogica;;239->246;;60 a 72$$\n");
        sb.append("63;;cadastrarLogica;;246->253;;62 a 74$$\n");
        sb.append("63;;cadastrarLogica;;253->260;;64 a 76$$\n");
        sb.append("63;;cadastrarLogica;;260->267;;66 a 78$$\n");
        sb.append("63;;cadastrarLogica;;267->274;;67 a 79$$\n");
        sb.append("63;;cadastrarLogica;;274->281;;69 a 81$$\n");
        sb.append("63;;cadastrarLogica;;281->288;;70 a 82$$\n");
        sb.append("63;;cadastrarLogica;;288->295;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CF / CA">

//        sb.append("64;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C Umero">

        sb.append("69;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("67;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("69;;cadastrarLogica;;0->78;;$$\n");
        sb.append("69;;cadastrarLogica;;78->85;;$$\n");
        sb.append("69;;cadastrarLogica;;85->92;;4 a 13$$\n");
        sb.append("69;;cadastrarLogica;;92->99;;7 a 15$$\n");
        sb.append("69;;cadastrarLogica;;99->106;;10 a 18$$\n");
        sb.append("69;;cadastrarLogica;;106->113;;13 a 21$$\n");
        sb.append("69;;cadastrarLogica;;113->120;;16 a 24$$\n");
        sb.append("69;;cadastrarLogica;;120->127;;18 a 27$$\n");
        sb.append("69;;cadastrarLogica;;127->134;;21 a 29$$\n");
        sb.append("69;;cadastrarLogica;;134->141;;24 a 32$$\n");
        sb.append("69;;cadastrarLogica;;141->148;;26 a 34$$\n");
        sb.append("69;;cadastrarLogica;;148->155;;29 a 37$$\n");
        sb.append("69;;cadastrarLogica;;155->162;;31 a 39$$\n");
        sb.append("69;;cadastrarLogica;;162->169;;33 a 42$$\n");
        sb.append("69;;cadastrarLogica;;169->176;;36 a 44$$\n");
        sb.append("69;;cadastrarLogica;;176->183;;38 a 46$$\n");
        sb.append("69;;cadastrarLogica;;183->190;;40 a 48$$\n");
        sb.append("69;;cadastrarLogica;;190->197;;42 a 50$$\n");
        sb.append("69;;cadastrarLogica;;197->204;;44 a 52$$\n");
        sb.append("69;;cadastrarLogica;;204->211;;46 a 54$$\n");
        sb.append("69;;cadastrarLogica;;211->218;;47 a 56$$\n");
        sb.append("69;;cadastrarLogica;;218->225;;49 a 57$$\n");
        sb.append("69;;cadastrarLogica;;225->232;;51 a 59$$\n");
        sb.append("69;;cadastrarLogica;;232->239;;52 a 60$$\n");
        sb.append("69;;cadastrarLogica;;239->246;;54 a 62$$\n");
        sb.append("69;;cadastrarLogica;;246->253;;55 a 63$$\n");
        sb.append("69;;cadastrarLogica;;253->260;;56 a 65$$\n");
        sb.append("69;;cadastrarLogica;;260->267;;58 a 66$$\n");
        sb.append("69;;cadastrarLogica;;267->274;;59 a 67$$\n");
        sb.append("69;;cadastrarLogica;;274->281;;61 a 69$$\n");
        sb.append("69;;cadastrarLogica;;281->288;;62 a 70$$\n");
        sb.append("69;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C Ulna">

        sb.append("72;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("70;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("72;;cadastrarLogica;;0->78;;$$\n");
        sb.append("72;;cadastrarLogica;;78->85;;$$\n");
        sb.append("72;;cadastrarLogica;;85->92;;3 a 11$$\n");
        sb.append("72;;cadastrarLogica;;92->99;;5 a 14$$\n");
        sb.append("72;;cadastrarLogica;;99->106;;8 a 17$$\n");
        sb.append("72;;cadastrarLogica;;106->113;;11 a 20$$\n");
        sb.append("72;;cadastrarLogica;;113->120;;14 a 22$$\n");
        sb.append("72;;cadastrarLogica;;120->127;;16 a 25$$\n");
        sb.append("72;;cadastrarLogica;;127->134;;19 a 28$$\n");
        sb.append("72;;cadastrarLogica;;134->141;;22 a 30$$\n");
        sb.append("72;;cadastrarLogica;;141->148;;24 a 33$$\n");
        sb.append("72;;cadastrarLogica;;148->155;;26 a 35$$\n");
        sb.append("72;;cadastrarLogica;;155->162;;29 a 37$$\n");
        sb.append("72;;cadastrarLogica;;162->169;;31 a 39$$\n");
        sb.append("72;;cadastrarLogica;;169->176;;33 a 42$$\n");
        sb.append("72;;cadastrarLogica;;176->183;;35 a 44$$\n");
        sb.append("72;;cadastrarLogica;;183->190;;37 a 46$$\n");
        sb.append("72;;cadastrarLogica;;190->197;;39 a 47$$\n");
        sb.append("72;;cadastrarLogica;;197->204;;41 a 49$$\n");
        sb.append("72;;cadastrarLogica;;204->211;;43 a 51$$\n");
        sb.append("72;;cadastrarLogica;;211->218;;44 a 53$$\n");
        sb.append("72;;cadastrarLogica;;218->225;;46 a 54$$\n");
        sb.append("72;;cadastrarLogica;;225->232;;47 a 56$$\n");
        sb.append("72;;cadastrarLogica;;232->239;;49 a 57$$\n");
        sb.append("72;;cadastrarLogica;;239->246;;50 a 59$$\n");
        sb.append("72;;cadastrarLogica;;246->253;;52 a 60$$\n");
        sb.append("72;;cadastrarLogica;;253->260;;53 a 61$$\n");
        sb.append("72;;cadastrarLogica;;260->267;;54 a 63$$\n");
        sb.append("72;;cadastrarLogica;;267->274;;55 a 64$$\n");
        sb.append("72;;cadastrarLogica;;274->281;;56 a 65$$\n");
        sb.append("72;;cadastrarLogica;;281->288;;57 a 66$$\n");
        sb.append("72;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C tibia">

        sb.append("75;;setCampos;;{$600CampoDoLaudo}$$\n");
////        sb.append("73;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("75;;cadastrarLogica;;0->78;;$$\n");
        sb.append("75;;cadastrarLogica;;78->85;;$$\n");
        sb.append("75;;cadastrarLogica;;85->92;;3 a 12$$\n");
        sb.append("75;;cadastrarLogica;;92->99;;5 a 14$$\n");
        sb.append("75;;cadastrarLogica;;99->106;;8 a 16$$\n");
        sb.append("75;;cadastrarLogica;;106->113;;10 a 19$$\n");
        sb.append("75;;cadastrarLogica;;113->120;;13 a 21$$\n");
        sb.append("75;;cadastrarLogica;;120->127;;15 a 24$$\n");
        sb.append("75;;cadastrarLogica;;127->134;;18 a 27$$\n");
        sb.append("75;;cadastrarLogica;;134->141;;21 a 29$$\n");
        sb.append("75;;cadastrarLogica;;141->148;;23 a 32$$\n");
        sb.append("75;;cadastrarLogica;;148->155;;26 a 34$$\n");
        sb.append("75;;cadastrarLogica;;155->162;;28 a 37$$\n");
        sb.append("75;;cadastrarLogica;;162->169;;31 a 39$$\n");
        sb.append("75;;cadastrarLogica;;169->176;;33 a 42$$\n");
        sb.append("75;;cadastrarLogica;;176->183;;35 a 44$$\n");
        sb.append("75;;cadastrarLogica;;183->190;;37 a 46$$\n");
        sb.append("75;;cadastrarLogica;;190->197;;40 a 48$$\n");
        sb.append("75;;cadastrarLogica;;197->204;;42 a 50$$\n");
        sb.append("75;;cadastrarLogica;;204->211;;44 a 52$$\n");
        sb.append("75;;cadastrarLogica;;211->218;;46 a 54$$\n");
        sb.append("75;;cadastrarLogica;;218->225;;47 a 56$$\n");
        sb.append("75;;cadastrarLogica;;225->232;;49 a 58$$\n");
        sb.append("75;;cadastrarLogica;;232->239;;51 a 60$$\n");
        sb.append("75;;cadastrarLogica;;239->246;;53 a 61$$\n");
        sb.append("75;;cadastrarLogica;;246->253;;54 a 63$$\n");
        sb.append("75;;cadastrarLogica;;253->260;;56 a 64$$\n");
        sb.append("75;;cadastrarLogica;;260->267;;57 a 66$$\n");
        sb.append("75;;cadastrarLogica;;267->274;;59 a 67$$\n");
        sb.append("75;;cadastrarLogica;;274->281;;60 a 69$$\n");
        sb.append("75;;cadastrarLogica;;281->288;;61 a 70$$\n");
        sb.append("75;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="PFP">

        sb.append("78;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("76;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("78;;cadastrarLogica;;0->78;;$$\n");
        sb.append("78;;cadastrarLogica;;78->85;;$$\n");
        sb.append("78;;cadastrarLogica;;85->92;;$$\n");
        sb.append("78;;cadastrarLogica;;92->99;;$$\n");
        sb.append("78;;cadastrarLogica;;99->106;;$$\n");
        sb.append("78;;cadastrarLogica;;106->113;;$$\n");
        sb.append("78;;cadastrarLogica;;113->120;;$$\n");
        sb.append("78;;cadastrarLogica;;120->127;;$$\n");
        sb.append("78;;cadastrarLogica;;127->134;;$$\n");
        sb.append("78;;cadastrarLogica;;134->141;;$$\n");
        sb.append("78;;cadastrarLogica;;141->148;;$$\n");
        sb.append("78;;cadastrarLogica;;148->155;;$$\n");
        sb.append("78;;cadastrarLogica;;155->162;;$$\n");
        sb.append("78;;cadastrarLogica;;162->169;;$$\n");
        sb.append("78;;cadastrarLogica;;169->176;;530 a 1260$$\n");
        sb.append("78;;cadastrarLogica;;176->183;;605 a 1305$$\n");
        sb.append("78;;cadastrarLogica;;183->190;;685 a 1360$$\n");
        sb.append("78;;cadastrarLogica;;190->197;;770 a 1435$$\n");
        sb.append("78;;cadastrarLogica;;197->204;;860 a 1550$$\n");
        sb.append("78;;cadastrarLogica;;204->211;;960 a 1690$$\n");
        sb.append("78;;cadastrarLogica;;211->218;;1060 a 1840$$\n");
        sb.append("78;;cadastrarLogica;;218->225;;1170 a 2030$$\n");
        sb.append("78;;cadastrarLogica;;225->232;;1290 a 2280$$\n");
        sb.append("78;;cadastrarLogica;;232->239;;1440 a 2600$$\n");
        sb.append("78;;cadastrarLogica;;239->246;;1600 a 2940$$\n");
        sb.append("78;;cadastrarLogica;;246->253;;1800 a 3200$$\n");
        sb.append("78;;cadastrarLogica;;253->260;;2050 a 3390$$\n");
        sb.append("78;;cadastrarLogica;;260->267;;2260 a 3520$$\n");
        sb.append("78;;cadastrarLogica;;267->274;;2430 a 3640$$\n");
        sb.append("78;;cadastrarLogica;;274->281;;2550 a 3735$$\n");
        sb.append("78;;cadastrarLogica;;281->288;;2690 a 3870$$\n");
        sb.append("78;;cadastrarLogica;;288->295;;2720 a 3890$$\n");
        sb.append("78;;cadastrarLogica;;295->600;;$$\n");

        // </editor-fold>
    }

    private static void preencherRef1 ()
    {
        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("124;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("120;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("124;;cadastrarLogica;;0->78;;$$\n");
        sb.append("124;;cadastrarLogica;;78->85;;13 a 22$$\n");
        sb.append("124;;cadastrarLogica;;85->92;;16 a 25$$\n");
        sb.append("124;;cadastrarLogica;;92->99;;20 a 29$$\n");
        sb.append("124;;cadastrarLogica;;99->106;;23 a 32$$\n");
        sb.append("124;;cadastrarLogica;;106->113;;27 a 36$$\n");
        sb.append("124;;cadastrarLogica;;113->120;;30 a 39$$\n");
        sb.append("124;;cadastrarLogica;;120->127;;34 a 43$$\n");
        sb.append("124;;cadastrarLogica;;127->134;;37 a 46$$\n");
        sb.append("124;;cadastrarLogica;;134->141;;40 a 49$$\n");
        sb.append("124;;cadastrarLogica;;141->148;;44 a 53$$\n");
        sb.append("124;;cadastrarLogica;;148->155;;47 a 56$$\n");
        sb.append("124;;cadastrarLogica;;155->162;;50 a 59$$\n");
        sb.append("124;;cadastrarLogica;;162->169;;53 a 62$$\n");
        sb.append("124;;cadastrarLogica;;169->176;;56 a 65$$\n");
        sb.append("124;;cadastrarLogica;;176->183;;59 a 68$$\n");
        sb.append("124;;cadastrarLogica;;183->190;;62 a 71$$\n");
        sb.append("124;;cadastrarLogica;;190->197;;65 a 74$$\n");
        sb.append("124;;cadastrarLogica;;197->204;;68 a 77$$\n");
        sb.append("124;;cadastrarLogica;;204->211;;70 a 79$$\n");
        sb.append("124;;cadastrarLogica;;211->218;;73 a 82$$\n");
        sb.append("124;;cadastrarLogica;;218->225;;75 a 84$$\n");
        sb.append("124;;cadastrarLogica;;225->232;;77 a 86$$\n");
        sb.append("124;;cadastrarLogica;;232->239;;79 a 88$$\n");
        sb.append("124;;cadastrarLogica;;239->246;;81 a 90$$\n");
        sb.append("124;;cadastrarLogica;;246->253;;83 a 92$$\n");
        sb.append("124;;cadastrarLogica;;253->260;;84 a 93$$\n");
        sb.append("124;;cadastrarLogica;;260->267;;86 a 95$$\n");
        sb.append("124;;cadastrarLogica;;267->274;;87 a 96$$\n");
        sb.append("124;;cadastrarLogica;;274->281;;88 a 97$$\n");
        sb.append("124;;cadastrarLogica;;281->288;;89 a 98$$\n");
        sb.append("124;;cadastrarLogica;;288->295;;89 a 98$$\n");
        sb.append("124;;cadastrarLogica;;295->600;;90 a 99$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="IC">

//        sb.append("123;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CA">

        sb.append("132;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("128;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("132;;cadastrarLogica;;0->78;;$$\n");
        sb.append("132;;cadastrarLogica;;78->85;;$$\n");
        sb.append("132;;cadastrarLogica;;85->92;;$$\n");
        sb.append("132;;cadastrarLogica;;92->99;;$$\n");
        sb.append("132;;cadastrarLogica;;99->106;;67 a 79$$\n");
        sb.append("132;;cadastrarLogica;;106->113;;79 a 93$$\n");
        sb.append("132;;cadastrarLogica;;113->120;;91 a 107$$\n");
        sb.append("132;;cadastrarLogica;;120->127;;103 a 121$$\n");
        sb.append("132;;cadastrarLogica;;127->134;;115 a 135$$\n");
        sb.append("132;;cadastrarLogica;;134->141;;126 a 148$$\n");
        sb.append("132;;cadastrarLogica;;141->148;;138 a 163$$\n");
        sb.append("132;;cadastrarLogica;;148->155;;149 a 176$$\n");
        sb.append("132;;cadastrarLogica;;155->162;;160 a 188$$\n");
        sb.append("132;;cadastrarLogica;;162->169;;170 a 200$$\n");
        sb.append("132;;cadastrarLogica;;169->176;;181 a 213$$\n");
        sb.append("132;;cadastrarLogica;;176->183;;191 a 225$$\n");
        sb.append("132;;cadastrarLogica;;183->190;;201 a 237$$\n");
        sb.append("132;;cadastrarLogica;;190->197;;211 a 249$$\n");
        sb.append("132;;cadastrarLogica;;197->204;;220 a 260$$\n");
        sb.append("132;;cadastrarLogica;;204->211;;230 a 272$$\n");
        sb.append("132;;cadastrarLogica;;211->218;;239 a 283$$\n");
        sb.append("132;;cadastrarLogica;;218->225;;249 a 294$$\n");
        sb.append("132;;cadastrarLogica;;225->232;;258 a 304$$\n");
        sb.append("132;;cadastrarLogica;;232->239;;267 a 315$$\n");
        sb.append("132;;cadastrarLogica;;239->246;;275 a 325$$\n");
        sb.append("132;;cadastrarLogica;;246->253;;283 a 335$$\n");
        sb.append("132;;cadastrarLogica;;253->260;;292 a 344$$\n");
        sb.append("132;;cadastrarLogica;;260->267;;300 a 354$$\n");
        sb.append("132;;cadastrarLogica;;267->274;;308 a 364$$\n");
        sb.append("132;;cadastrarLogica;;274->281;;316 a 373$$\n");
        sb.append("132;;cadastrarLogica;;281->288;;324 a 382$$\n");
        sb.append("132;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CC">

        sb.append("135;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("131;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("135;;cadastrarLogica;;0->78;;$$\n");
        sb.append("135;;cadastrarLogica;;78->85;;$$\n");
        sb.append("135;;cadastrarLogica;;85->92;;51 a 89$$\n");
        sb.append("135;;cadastrarLogica;;92->99;;65 a 103$$\n");
        sb.append("135;;cadastrarLogica;;99->106;;79 a 117$$\n");
        sb.append("135;;cadastrarLogica;;106->113;;92 a 130$$\n");
        sb.append("135;;cadastrarLogica;;113->120;;105 a 43$$\n");
        sb.append("135;;cadastrarLogica;;120->127;;118 a 156$$\n");
        sb.append("135;;cadastrarLogica;;127->134;;131 a 169$$\n");
        sb.append("135;;cadastrarLogica;;134->141;;144 a 182$$\n");
        sb.append("135;;cadastrarLogica;;141->148;;156 a 194$$\n");
        sb.append("135;;cadastrarLogica;;148->155;;168 a 206$$\n");
        sb.append("135;;cadastrarLogica;;155->162;;180 a 218$$\n");
        sb.append("135;;cadastrarLogica;;162->169;;191 a 229$$\n");
        sb.append("135;;cadastrarLogica;;169->176;;202 a 240$$\n");
        sb.append("135;;cadastrarLogica;;176->183;;213 a 251$$\n");
        sb.append("135;;cadastrarLogica;;183->190;;223 a 261$$\n");
        sb.append("135;;cadastrarLogica;;190->197;;233 a 271$$\n");
        sb.append("135;;cadastrarLogica;;197->204;;243 a 281$$\n");
        sb.append("135;;cadastrarLogica;;204->211;;252 a 290$$\n");
        sb.append("135;;cadastrarLogica;;211->218;;261 a 299$$\n");
        sb.append("135;;cadastrarLogica;;218->225;;270 a 308$$\n");
        sb.append("135;;cadastrarLogica;;225->232;;278 a 316$$\n");
        sb.append("135;;cadastrarLogica;;232->239;;285 a 323$$\n");
        sb.append("135;;cadastrarLogica;;239->246;;293 a 331$$\n");
        sb.append("135;;cadastrarLogica;;246->253;;299 a 337$$\n");
        sb.append("135;;cadastrarLogica;;253->260;;306 a 344$$\n");
        sb.append("135;;cadastrarLogica;;260->267;;311 a 349$$\n");
        sb.append("135;;cadastrarLogica;;267->274;;319 a 355$$\n");
        sb.append("135;;cadastrarLogica;;274->281;;322 a 360$$\n");
        sb.append("135;;cadastrarLogica;;281->288;;326 a 364$$\n");
        sb.append("135;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CC / CA">

        sb.append("138;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("134;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
                sb.append("216;;cadastrarLogica;;0->78;;$$\n");
        sb.append("138;;cadastrarLogica;;78->85;;$$\n");
        sb.append("138;;cadastrarLogica;;85->92;;1,12 a 1,31$$\n");
        sb.append("138;;cadastrarLogica;;92->99;;1,11 a 1,30$$\n");
        sb.append("138;;cadastrarLogica;;99->106;;1,11 a 1,30$$\n");
        sb.append("138;;cadastrarLogica;;106->113;;1,10 a 1,29$$\n");
        sb.append("138;;cadastrarLogica;;113->120;;1,09 a 1,28$$\n");
        sb.append("138;;cadastrarLogica;;120->127;;1,08 a 1,27$$\n");
        sb.append("138;;cadastrarLogica;;127->134;;1,07 a 1,26$$\n");
        sb.append("138;;cadastrarLogica;;134->141;;1,06 a 1,25$$\n");
        sb.append("138;;cadastrarLogica;;141->148;;1,06 a 1,24$$\n");
        sb.append("138;;cadastrarLogica;;148->155;;1,05 a 1,24$$\n");
        sb.append("138;;cadastrarLogica;;155->162;;1,04 a 1,23$$\n");
        sb.append("138;;cadastrarLogica;;162->169;;1,03 a 1,22$$\n");
        sb.append("138;;cadastrarLogica;;169->176;;1,02 a 1,21$$\n");
        sb.append("138;;cadastrarLogica;;176->183;;1,01 a 1,20$$\n");
        sb.append("138;;cadastrarLogica;;183->190;;1,00 a 1,19$$\n");
        sb.append("138;;cadastrarLogica;;190->197;;1,00 a 1,18$$\n");
        sb.append("138;;cadastrarLogica;;197->204;;0,99 a 1,18$$\n");
        sb.append("138;;cadastrarLogica;;204->211;;0,98 a 1,17$$\n");
        sb.append("138;;cadastrarLogica;;211->218;;0,97 a 1,16$$\n");
        sb.append("138;;cadastrarLogica;;218->225;;0,96 a 1,15$$\n");
        sb.append("138;;cadastrarLogica;;225->232;;0,95 a 1,14$$\n");
        sb.append("138;;cadastrarLogica;;232->239;;0,95 a 1,13$$\n");
        sb.append("138;;cadastrarLogica;;239->246;;0,94 a 1,13$$\n");
        sb.append("138;;cadastrarLogica;;246->253;;0,93 a 1,12$$\n");
        sb.append("138;;cadastrarLogica;;253->260;;0,92 a 1,11$$\n");
        sb.append("138;;cadastrarLogica;;260->267;;0,91 a 1,10$$\n");
        sb.append("138;;cadastrarLogica;;267->274;;0,89 a 1,09$$\n");
        sb.append("138;;cadastrarLogica;;274->281;;0,89 a 1,09$$\n");
        sb.append("138;;cadastrarLogica;;281->288;;0,89 a 1,08$$\n");
        sb.append("138;;cadastrarLogica;;288->295;;$$\n");
        sb.append("138;;cadastrarLogica;;295->302;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CF">

        sb.append("141;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("137;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("141;;cadastrarLogica;;0->78;;$$\n");
        sb.append("141;;cadastrarLogica;;78->85;;$$\n");
        sb.append("141;;cadastrarLogica;;85->92;;2 a 14$$\n");
        sb.append("141;;cadastrarLogica;;92->99;;5 a 17$$\n");
        sb.append("141;;cadastrarLogica;;99->106;;9 a 21$$\n");
        sb.append("141;;cadastrarLogica;;106->113;;12 a 24$$\n");
        sb.append("141;;cadastrarLogica;;113->120;;15 a 27$$\n");
        sb.append("141;;cadastrarLogica;;120->127;;18 a 30$$\n");
        sb.append("141;;cadastrarLogica;;127->134;;21 a 33$$\n");
        sb.append("141;;cadastrarLogica;;134->141;;23 a 36$$\n");
        sb.append("141;;cadastrarLogica;;141->148;;27 a 39$$\n");
        sb.append("141;;cadastrarLogica;;148->155;;30 a 42$$\n");
        sb.append("141;;cadastrarLogica;;155->162;;33 a 45$$\n");
        sb.append("141;;cadastrarLogica;;162->169;;36 a 48$$\n");
        sb.append("141;;cadastrarLogica;;169->176;;38 a 50$$\n");
        sb.append("141;;cadastrarLogica;;176->183;;41 a 53$$\n");
        sb.append("141;;cadastrarLogica;;183->190;;43 a 55$$\n");
        sb.append("141;;cadastrarLogica;;190->197;;46 a 58$$\n");
        sb.append("141;;cadastrarLogica;;197->204;;48 a 60$$\n");
        sb.append("141;;cadastrarLogica;;204->211;;50 a 62$$\n");
        sb.append("141;;cadastrarLogica;;211->218;;52 a 64$$\n");
        sb.append("141;;cadastrarLogica;;218->225;;55 a 67$$\n");
        sb.append("141;;cadastrarLogica;;225->232;;57 a 69$$\n");
        sb.append("141;;cadastrarLogica;;232->239;;59 a 71$$\n");
        sb.append("141;;cadastrarLogica;;239->246;;60 a 72$$\n");
        sb.append("141;;cadastrarLogica;;246->253;;62 a 74$$\n");
        sb.append("141;;cadastrarLogica;;253->260;;64 a 76$$\n");
        sb.append("141;;cadastrarLogica;;260->267;;66 a 78$$\n");
        sb.append("141;;cadastrarLogica;;267->274;;67 a 79$$\n");
        sb.append("141;;cadastrarLogica;;274->281;;69 a 81$$\n");
        sb.append("141;;cadastrarLogica;;281->288;;70 a 82$$\n");
        sb.append("141;;cadastrarLogica;;288->295;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CF / CA">

//        sb.append("140;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C Umero">

        sb.append("147;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("143;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("147;;cadastrarLogica;;0->78;;$$\n");
        sb.append("147;;cadastrarLogica;;78->85;;$$\n");
        sb.append("147;;cadastrarLogica;;85->92;;4 a 13$$\n");
        sb.append("147;;cadastrarLogica;;92->99;;7 a 15$$\n");
        sb.append("147;;cadastrarLogica;;99->106;;10 a 18$$\n");
        sb.append("147;;cadastrarLogica;;106->113;;13 a 21$$\n");
        sb.append("147;;cadastrarLogica;;113->120;;16 a 24$$\n");
        sb.append("147;;cadastrarLogica;;120->127;;18 a 27$$\n");
        sb.append("147;;cadastrarLogica;;127->134;;21 a 29$$\n");
        sb.append("147;;cadastrarLogica;;134->141;;24 a 32$$\n");
        sb.append("147;;cadastrarLogica;;141->148;;26 a 34$$\n");
        sb.append("147;;cadastrarLogica;;148->155;;29 a 37$$\n");
        sb.append("147;;cadastrarLogica;;155->162;;31 a 39$$\n");
        sb.append("147;;cadastrarLogica;;162->169;;33 a 42$$\n");
        sb.append("147;;cadastrarLogica;;169->176;;36 a 44$$\n");
        sb.append("147;;cadastrarLogica;;176->183;;38 a 46$$\n");
        sb.append("147;;cadastrarLogica;;183->190;;40 a 48$$\n");
        sb.append("147;;cadastrarLogica;;190->197;;42 a 50$$\n");
        sb.append("147;;cadastrarLogica;;197->204;;44 a 52$$\n");
        sb.append("147;;cadastrarLogica;;204->211;;46 a 54$$\n");
        sb.append("147;;cadastrarLogica;;211->218;;47 a 56$$\n");
        sb.append("147;;cadastrarLogica;;218->225;;49 a 57$$\n");
        sb.append("147;;cadastrarLogica;;225->232;;51 a 59$$\n");
        sb.append("147;;cadastrarLogica;;232->239;;52 a 60$$\n");
        sb.append("147;;cadastrarLogica;;239->246;;54 a 62$$\n");
        sb.append("147;;cadastrarLogica;;246->253;;55 a 63$$\n");
        sb.append("147;;cadastrarLogica;;253->260;;56 a 65$$\n");
        sb.append("147;;cadastrarLogica;;260->267;;58 a 66$$\n");
        sb.append("147;;cadastrarLogica;;267->274;;59 a 67$$\n");
        sb.append("147;;cadastrarLogica;;274->281;;61 a 69$$\n");
        sb.append("147;;cadastrarLogica;;281->288;;62 a 70$$\n");
        sb.append("147;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C Ulna">

        sb.append("150;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("146;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("150;;cadastrarLogica;;0->78;;$$\n");
        sb.append("150;;cadastrarLogica;;78->85;;$$\n");
        sb.append("150;;cadastrarLogica;;85->92;;3 a 11$$\n");
        sb.append("150;;cadastrarLogica;;92->99;;5 a 14$$\n");
        sb.append("150;;cadastrarLogica;;99->106;;8 a 17$$\n");
        sb.append("150;;cadastrarLogica;;106->113;;11 a 20$$\n");
        sb.append("150;;cadastrarLogica;;113->120;;14 a 22$$\n");
        sb.append("150;;cadastrarLogica;;120->127;;16 a 25$$\n");
        sb.append("150;;cadastrarLogica;;127->134;;19 a 28$$\n");
        sb.append("150;;cadastrarLogica;;134->141;;22 a 30$$\n");
        sb.append("150;;cadastrarLogica;;141->148;;24 a 33$$\n");
        sb.append("150;;cadastrarLogica;;148->155;;26 a 35$$\n");
        sb.append("150;;cadastrarLogica;;155->162;;29 a 37$$\n");
        sb.append("150;;cadastrarLogica;;162->169;;31 a 39$$\n");
        sb.append("150;;cadastrarLogica;;169->176;;33 a 42$$\n");
        sb.append("150;;cadastrarLogica;;176->183;;35 a 44$$\n");
        sb.append("150;;cadastrarLogica;;183->190;;37 a 46$$\n");
        sb.append("150;;cadastrarLogica;;190->197;;39 a 47$$\n");
        sb.append("150;;cadastrarLogica;;197->204;;41 a 49$$\n");
        sb.append("150;;cadastrarLogica;;204->211;;43 a 51$$\n");
        sb.append("150;;cadastrarLogica;;211->218;;44 a 53$$\n");
        sb.append("150;;cadastrarLogica;;218->225;;46 a 54$$\n");
        sb.append("150;;cadastrarLogica;;225->232;;47 a 56$$\n");
        sb.append("150;;cadastrarLogica;;232->239;;49 a 57$$\n");
        sb.append("150;;cadastrarLogica;;239->246;;50 a 59$$\n");
        sb.append("150;;cadastrarLogica;;246->253;;52 a 60$$\n");
        sb.append("150;;cadastrarLogica;;253->260;;53 a 61$$\n");
        sb.append("150;;cadastrarLogica;;260->267;;54 a 63$$\n");
        sb.append("150;;cadastrarLogica;;267->274;;55 a 64$$\n");
        sb.append("150;;cadastrarLogica;;274->281;;56 a 65$$\n");
        sb.append("150;;cadastrarLogica;;281->288;;57 a 66$$\n");
        sb.append("150;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C tibia">

        sb.append("153;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("149;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("153;;cadastrarLogica;;0->78;;$$\n");
        sb.append("153;;cadastrarLogica;;78->85;;$$\n");
        sb.append("153;;cadastrarLogica;;85->92;;3 a 12$$\n");
        sb.append("153;;cadastrarLogica;;92->99;;5 a 14$$\n");
        sb.append("153;;cadastrarLogica;;99->106;;8 a 16$$\n");
        sb.append("153;;cadastrarLogica;;106->113;;10 a 19$$\n");
        sb.append("153;;cadastrarLogica;;113->120;;13 a 21$$\n");
        sb.append("153;;cadastrarLogica;;120->127;;15 a 24$$\n");
        sb.append("153;;cadastrarLogica;;127->134;;18 a 27$$\n");
        sb.append("153;;cadastrarLogica;;134->141;;21 a 29$$\n");
        sb.append("153;;cadastrarLogica;;141->148;;23 a 32$$\n");
        sb.append("153;;cadastrarLogica;;148->155;;26 a 34$$\n");
        sb.append("153;;cadastrarLogica;;155->162;;28 a 37$$\n");
        sb.append("153;;cadastrarLogica;;162->169;;31 a 39$$\n");
        sb.append("153;;cadastrarLogica;;169->176;;33 a 42$$\n");
        sb.append("153;;cadastrarLogica;;176->183;;35 a 44$$\n");
        sb.append("153;;cadastrarLogica;;183->190;;37 a 46$$\n");
        sb.append("153;;cadastrarLogica;;190->197;;40 a 48$$\n");
        sb.append("153;;cadastrarLogica;;197->204;;42 a 50$$\n");
        sb.append("153;;cadastrarLogica;;204->211;;44 a 52$$\n");
        sb.append("153;;cadastrarLogica;;211->218;;46 a 54$$\n");
        sb.append("153;;cadastrarLogica;;218->225;;47 a 56$$\n");
        sb.append("153;;cadastrarLogica;;225->232;;49 a 58$$\n");
        sb.append("153;;cadastrarLogica;;232->239;;51 a 60$$\n");
        sb.append("153;;cadastrarLogica;;239->246;;53 a 61$$\n");
        sb.append("153;;cadastrarLogica;;246->253;;54 a 63$$\n");
        sb.append("153;;cadastrarLogica;;253->260;;56 a 64$$\n");
        sb.append("153;;cadastrarLogica;;260->267;;57 a 66$$\n");
        sb.append("153;;cadastrarLogica;;267->274;;59 a 67$$\n");
        sb.append("153;;cadastrarLogica;;274->281;;60 a 69$$\n");
        sb.append("153;;cadastrarLogica;;281->288;;61 a 70$$\n");
        sb.append("153;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="PFP">

        sb.append("156;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("152;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("156;;cadastrarLogica;;0->78;;$$\n");
        sb.append("156;;cadastrarLogica;;78->85;;$$\n");
        sb.append("156;;cadastrarLogica;;85->92;;$$\n");
        sb.append("156;;cadastrarLogica;;92->99;;$$\n");
        sb.append("156;;cadastrarLogica;;99->106;;$$\n");
        sb.append("156;;cadastrarLogica;;106->113;;$$\n");
        sb.append("156;;cadastrarLogica;;113->120;;$$\n");
        sb.append("156;;cadastrarLogica;;120->127;;$$\n");
        sb.append("156;;cadastrarLogica;;127->134;;$$\n");
        sb.append("156;;cadastrarLogica;;134->141;;$$\n");
        sb.append("156;;cadastrarLogica;;141->148;;$$\n");
        sb.append("156;;cadastrarLogica;;148->155;;$$\n");
        sb.append("156;;cadastrarLogica;;155->162;;$$\n");
        sb.append("156;;cadastrarLogica;;162->169;;$$\n");
        sb.append("156;;cadastrarLogica;;169->176;;530 a 1260$$\n");
        sb.append("156;;cadastrarLogica;;176->183;;605 a 1305$$\n");
        sb.append("156;;cadastrarLogica;;183->190;;685 a 1360$$\n");
        sb.append("156;;cadastrarLogica;;190->197;;770 a 1435$$\n");
        sb.append("156;;cadastrarLogica;;197->204;;860 a 1550$$\n");
        sb.append("156;;cadastrarLogica;;204->211;;960 a 1690$$\n");
        sb.append("156;;cadastrarLogica;;211->218;;1060 a 1840$$\n");
        sb.append("156;;cadastrarLogica;;218->225;;1170 a 2030$$\n");
        sb.append("156;;cadastrarLogica;;225->232;;1290 a 2280$$\n");
        sb.append("156;;cadastrarLogica;;232->239;;1440 a 2600$$\n");
        sb.append("156;;cadastrarLogica;;239->246;;1600 a 2940$$\n");
        sb.append("156;;cadastrarLogica;;246->253;;1800 a 3200$$\n");
        sb.append("156;;cadastrarLogica;;253->260;;2050 a 3390$$\n");
        sb.append("156;;cadastrarLogica;;260->267;;2260 a 3520$$\n");
        sb.append("156;;cadastrarLogica;;267->274;;2430 a 3640$$\n");
        sb.append("156;;cadastrarLogica;;274->281;;2550 a 3735$$\n");
        sb.append("156;;cadastrarLogica;;281->288;;2690 a 3870$$\n");
        sb.append("156;;cadastrarLogica;;288->295;;2720 a 3890$$\n");
        sb.append("156;;cadastrarLogica;;295->600;;$$\n");

        // </editor-fold>
    }

    private static void preencherRef2 ()
    {
        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("202;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("196;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("202;;cadastrarLogica;;0->78;;$$\n");
        sb.append("202;;cadastrarLogica;;78->85;;13 a 22$$\n");
        sb.append("202;;cadastrarLogica;;85->92;;16 a 25$$\n");
        sb.append("202;;cadastrarLogica;;92->99;;20 a 29$$\n");
        sb.append("202;;cadastrarLogica;;99->106;;23 a 32$$\n");
        sb.append("202;;cadastrarLogica;;106->113;;27 a 36$$\n");
        sb.append("202;;cadastrarLogica;;113->120;;30 a 39$$\n");
        sb.append("202;;cadastrarLogica;;120->127;;34 a 43$$\n");
        sb.append("202;;cadastrarLogica;;127->134;;37 a 46$$\n");
        sb.append("202;;cadastrarLogica;;134->141;;40 a 49$$\n");
        sb.append("202;;cadastrarLogica;;141->148;;44 a 53$$\n");
        sb.append("202;;cadastrarLogica;;148->155;;47 a 56$$\n");
        sb.append("202;;cadastrarLogica;;155->162;;50 a 59$$\n");
        sb.append("202;;cadastrarLogica;;162->169;;53 a 62$$\n");
        sb.append("202;;cadastrarLogica;;169->176;;56 a 65$$\n");
        sb.append("202;;cadastrarLogica;;176->183;;59 a 68$$\n");
        sb.append("202;;cadastrarLogica;;183->190;;62 a 71$$\n");
        sb.append("202;;cadastrarLogica;;190->197;;65 a 74$$\n");
        sb.append("202;;cadastrarLogica;;197->204;;68 a 77$$\n");
        sb.append("202;;cadastrarLogica;;204->211;;70 a 79$$\n");
        sb.append("202;;cadastrarLogica;;211->218;;73 a 82$$\n");
        sb.append("202;;cadastrarLogica;;218->225;;75 a 84$$\n");
        sb.append("202;;cadastrarLogica;;225->232;;77 a 86$$\n");
        sb.append("202;;cadastrarLogica;;232->239;;79 a 88$$\n");
        sb.append("202;;cadastrarLogica;;239->246;;81 a 90$$\n");
        sb.append("202;;cadastrarLogica;;246->253;;83 a 92$$\n");
        sb.append("202;;cadastrarLogica;;253->260;;84 a 93$$\n");
        sb.append("202;;cadastrarLogica;;260->267;;86 a 95$$\n");
        sb.append("202;;cadastrarLogica;;267->274;;87 a 96$$\n");
        sb.append("202;;cadastrarLogica;;274->281;;88 a 97$$\n");
        sb.append("202;;cadastrarLogica;;281->288;;89 a 98$$\n");
        sb.append("202;;cadastrarLogica;;288->295;;89 a 98$$\n");
        sb.append("202;;cadastrarLogica;;295->600;;90 a 99$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="IC">

//        sb.append("199;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CA">

        sb.append("210;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("204;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("210;;cadastrarLogica;;0->78;;$$\n");
        sb.append("210;;cadastrarLogica;;78->85;;$$\n");
        sb.append("210;;cadastrarLogica;;85->92;;$$\n");
        sb.append("210;;cadastrarLogica;;92->99;;$$\n");
        sb.append("210;;cadastrarLogica;;99->106;;67 a 79$$\n");
        sb.append("210;;cadastrarLogica;;106->113;;79 a 93$$\n");
        sb.append("210;;cadastrarLogica;;113->120;;91 a 107$$\n");
        sb.append("210;;cadastrarLogica;;120->127;;103 a 121$$\n");
        sb.append("210;;cadastrarLogica;;127->134;;115 a 135$$\n");
        sb.append("210;;cadastrarLogica;;134->141;;126 a 148$$\n");
        sb.append("210;;cadastrarLogica;;141->148;;138 a 163$$\n");
        sb.append("210;;cadastrarLogica;;148->155;;149 a 176$$\n");
        sb.append("210;;cadastrarLogica;;155->162;;160 a 188$$\n");
        sb.append("210;;cadastrarLogica;;162->169;;170 a 200$$\n");
        sb.append("210;;cadastrarLogica;;169->176;;181 a 213$$\n");
        sb.append("210;;cadastrarLogica;;176->183;;191 a 225$$\n");
        sb.append("210;;cadastrarLogica;;183->190;;201 a 237$$\n");
        sb.append("210;;cadastrarLogica;;190->197;;211 a 249$$\n");
        sb.append("210;;cadastrarLogica;;197->204;;220 a 260$$\n");
        sb.append("210;;cadastrarLogica;;204->211;;230 a 272$$\n");
        sb.append("210;;cadastrarLogica;;211->218;;239 a 283$$\n");
        sb.append("210;;cadastrarLogica;;218->225;;249 a 294$$\n");
        sb.append("210;;cadastrarLogica;;225->232;;258 a 304$$\n");
        sb.append("210;;cadastrarLogica;;232->239;;267 a 315$$\n");
        sb.append("210;;cadastrarLogica;;239->246;;275 a 325$$\n");
        sb.append("210;;cadastrarLogica;;246->253;;283 a 335$$\n");
        sb.append("210;;cadastrarLogica;;253->260;;292 a 344$$\n");
        sb.append("210;;cadastrarLogica;;260->267;;300 a 354$$\n");
        sb.append("210;;cadastrarLogica;;267->274;;308 a 364$$\n");
        sb.append("210;;cadastrarLogica;;274->281;;316 a 373$$\n");
        sb.append("210;;cadastrarLogica;;281->288;;324 a 382$$\n");
        sb.append("210;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CC">

        sb.append("213;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("207;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("213;;cadastrarLogica;;0->78;;$$\n");
        sb.append("213;;cadastrarLogica;;78->85;;$$\n");
        sb.append("213;;cadastrarLogica;;85->92;;51 a 89$$\n");
        sb.append("213;;cadastrarLogica;;92->99;;65 a 103$$\n");
        sb.append("213;;cadastrarLogica;;99->106;;79 a 117$$\n");
        sb.append("213;;cadastrarLogica;;106->113;;92 a 130$$\n");
        sb.append("213;;cadastrarLogica;;113->120;;105 a 43$$\n");
        sb.append("213;;cadastrarLogica;;120->127;;118 a 156$$\n");
        sb.append("213;;cadastrarLogica;;127->134;;131 a 169$$\n");
        sb.append("213;;cadastrarLogica;;134->141;;144 a 182$$\n");
        sb.append("213;;cadastrarLogica;;141->148;;156 a 194$$\n");
        sb.append("213;;cadastrarLogica;;148->155;;168 a 206$$\n");
        sb.append("213;;cadastrarLogica;;155->162;;180 a 218$$\n");
        sb.append("213;;cadastrarLogica;;162->169;;191 a 229$$\n");
        sb.append("213;;cadastrarLogica;;169->176;;202 a 240$$\n");
        sb.append("213;;cadastrarLogica;;176->183;;213 a 251$$\n");
        sb.append("213;;cadastrarLogica;;183->190;;223 a 261$$\n");
        sb.append("213;;cadastrarLogica;;190->197;;233 a 271$$\n");
        sb.append("213;;cadastrarLogica;;197->204;;243 a 281$$\n");
        sb.append("213;;cadastrarLogica;;204->211;;252 a 290$$\n");
        sb.append("213;;cadastrarLogica;;211->218;;261 a 299$$\n");
        sb.append("213;;cadastrarLogica;;218->225;;270 a 308$$\n");
        sb.append("213;;cadastrarLogica;;225->232;;278 a 316$$\n");
        sb.append("213;;cadastrarLogica;;232->239;;285 a 323$$\n");
        sb.append("213;;cadastrarLogica;;239->246;;293 a 331$$\n");
        sb.append("213;;cadastrarLogica;;246->253;;299 a 337$$\n");
        sb.append("213;;cadastrarLogica;;253->260;;306 a 344$$\n");
        sb.append("213;;cadastrarLogica;;260->267;;311 a 349$$\n");
        sb.append("213;;cadastrarLogica;;267->274;;319 a 355$$\n");
        sb.append("213;;cadastrarLogica;;274->281;;322 a 360$$\n");
        sb.append("213;;cadastrarLogica;;281->288;;326 a 364$$\n");
        sb.append("213;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CC / CA">

        sb.append("216;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("210;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("216;;cadastrarLogica;;0->78;;$$\n");
        sb.append("216;;cadastrarLogica;;78->85;;$$\n");
        sb.append("216;;cadastrarLogica;;85->92;;1,12 a 1,31$$\n");
        sb.append("216;;cadastrarLogica;;92->99;;1,11 a 1,30$$\n");
        sb.append("216;;cadastrarLogica;;99->106;;1,11 a 1,30$$\n");
        sb.append("216;;cadastrarLogica;;106->113;;1,10 a 1,29$$\n");
        sb.append("216;;cadastrarLogica;;113->120;;1,09 a 1,28$$\n");
        sb.append("216;;cadastrarLogica;;120->127;;1,08 a 1,27$$\n");
        sb.append("216;;cadastrarLogica;;127->134;;1,07 a 1,26$$\n");
        sb.append("216;;cadastrarLogica;;134->141;;1,06 a 1,25$$\n");
        sb.append("216;;cadastrarLogica;;141->148;;1,06 a 1,24$$\n");
        sb.append("216;;cadastrarLogica;;148->155;;1,05 a 1,24$$\n");
        sb.append("216;;cadastrarLogica;;155->162;;1,04 a 1,23$$\n");
        sb.append("216;;cadastrarLogica;;162->169;;1,03 a 1,22$$\n");
        sb.append("216;;cadastrarLogica;;169->176;;1,02 a 1,21$$\n");
        sb.append("216;;cadastrarLogica;;176->183;;1,01 a 1,20$$\n");
        sb.append("216;;cadastrarLogica;;183->190;;1,00 a 1,19$$\n");
        sb.append("216;;cadastrarLogica;;190->197;;1,00 a 1,18$$\n");
        sb.append("216;;cadastrarLogica;;197->204;;0,99 a 1,18$$\n");
        sb.append("216;;cadastrarLogica;;204->211;;0,98 a 1,17$$\n");
        sb.append("216;;cadastrarLogica;;211->218;;0,97 a 1,16$$\n");
        sb.append("216;;cadastrarLogica;;218->225;;0,96 a 1,15$$\n");
        sb.append("216;;cadastrarLogica;;225->232;;0,95 a 1,14$$\n");
        sb.append("216;;cadastrarLogica;;232->239;;0,95 a 1,13$$\n");
        sb.append("216;;cadastrarLogica;;239->246;;0,94 a 1,13$$\n");
        sb.append("216;;cadastrarLogica;;246->253;;0,93 a 1,12$$\n");
        sb.append("216;;cadastrarLogica;;253->260;;0,92 a 1,11$$\n");
        sb.append("216;;cadastrarLogica;;260->267;;0,91 a 1,10$$\n");
        sb.append("216;;cadastrarLogica;;267->274;;0,89 a 1,09$$\n");
        sb.append("216;;cadastrarLogica;;274->281;;0,89 a 1,09$$\n");
        sb.append("216;;cadastrarLogica;;281->288;;0,89 a 1,08$$\n");
        sb.append("216;;cadastrarLogica;;288->295;;$$\n");
        sb.append("216;;cadastrarLogica;;295->302;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CF">

        sb.append("219;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("213;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("219;;cadastrarLogica;;0->78;;$$\n");
        sb.append("219;;cadastrarLogica;;78->85;;$$\n");
        sb.append("219;;cadastrarLogica;;85->92;;2 a 14$$\n");
        sb.append("219;;cadastrarLogica;;92->99;;5 a 17$$\n");
        sb.append("219;;cadastrarLogica;;99->106;;9 a 21$$\n");
        sb.append("219;;cadastrarLogica;;106->113;;12 a 24$$\n");
        sb.append("219;;cadastrarLogica;;113->120;;15 a 27$$\n");
        sb.append("219;;cadastrarLogica;;120->127;;18 a 30$$\n");
        sb.append("219;;cadastrarLogica;;127->134;;21 a 33$$\n");
        sb.append("219;;cadastrarLogica;;134->141;;23 a 36$$\n");
        sb.append("219;;cadastrarLogica;;141->148;;27 a 39$$\n");
        sb.append("219;;cadastrarLogica;;148->155;;30 a 42$$\n");
        sb.append("219;;cadastrarLogica;;155->162;;33 a 45$$\n");
        sb.append("219;;cadastrarLogica;;162->169;;36 a 48$$\n");
        sb.append("219;;cadastrarLogica;;169->176;;38 a 50$$\n");
        sb.append("219;;cadastrarLogica;;176->183;;41 a 53$$\n");
        sb.append("219;;cadastrarLogica;;183->190;;43 a 55$$\n");
        sb.append("219;;cadastrarLogica;;190->197;;46 a 58$$\n");
        sb.append("219;;cadastrarLogica;;197->204;;48 a 60$$\n");
        sb.append("219;;cadastrarLogica;;204->211;;50 a 62$$\n");
        sb.append("219;;cadastrarLogica;;211->218;;52 a 64$$\n");
        sb.append("219;;cadastrarLogica;;218->225;;55 a 67$$\n");
        sb.append("219;;cadastrarLogica;;225->232;;57 a 69$$\n");
        sb.append("219;;cadastrarLogica;;232->239;;59 a 71$$\n");
        sb.append("219;;cadastrarLogica;;239->246;;60 a 72$$\n");
        sb.append("219;;cadastrarLogica;;246->253;;62 a 74$$\n");
        sb.append("219;;cadastrarLogica;;253->260;;64 a 76$$\n");
        sb.append("219;;cadastrarLogica;;260->267;;66 a 78$$\n");
        sb.append("219;;cadastrarLogica;;267->274;;67 a 79$$\n");
        sb.append("219;;cadastrarLogica;;274->281;;69 a 81$$\n");
        sb.append("219;;cadastrarLogica;;281->288;;70 a 82$$\n");
        sb.append("219;;cadastrarLogica;;288->295;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CF / CA">

//        sb.append("216;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C Umero">

        sb.append("225;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("219;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("225;;cadastrarLogica;;0->78;;$$\n");
        sb.append("225;;cadastrarLogica;;78->85;;$$\n");
        sb.append("225;;cadastrarLogica;;85->92;;4 a 13$$\n");
        sb.append("225;;cadastrarLogica;;92->99;;7 a 15$$\n");
        sb.append("225;;cadastrarLogica;;99->106;;10 a 18$$\n");
        sb.append("225;;cadastrarLogica;;106->113;;13 a 21$$\n");
        sb.append("225;;cadastrarLogica;;113->120;;16 a 24$$\n");
        sb.append("225;;cadastrarLogica;;120->127;;18 a 27$$\n");
        sb.append("225;;cadastrarLogica;;127->134;;21 a 29$$\n");
        sb.append("225;;cadastrarLogica;;134->141;;24 a 32$$\n");
        sb.append("225;;cadastrarLogica;;141->148;;26 a 34$$\n");
        sb.append("225;;cadastrarLogica;;148->155;;29 a 37$$\n");
        sb.append("225;;cadastrarLogica;;155->162;;31 a 39$$\n");
        sb.append("225;;cadastrarLogica;;162->169;;33 a 42$$\n");
        sb.append("225;;cadastrarLogica;;169->176;;36 a 44$$\n");
        sb.append("225;;cadastrarLogica;;176->183;;38 a 46$$\n");
        sb.append("225;;cadastrarLogica;;183->190;;40 a 48$$\n");
        sb.append("225;;cadastrarLogica;;190->197;;42 a 50$$\n");
        sb.append("225;;cadastrarLogica;;197->204;;44 a 52$$\n");
        sb.append("225;;cadastrarLogica;;204->211;;46 a 54$$\n");
        sb.append("225;;cadastrarLogica;;211->218;;47 a 56$$\n");
        sb.append("225;;cadastrarLogica;;218->225;;49 a 57$$\n");
        sb.append("225;;cadastrarLogica;;225->232;;51 a 59$$\n");
        sb.append("225;;cadastrarLogica;;232->239;;52 a 60$$\n");
        sb.append("225;;cadastrarLogica;;239->246;;54 a 62$$\n");
        sb.append("225;;cadastrarLogica;;246->253;;55 a 63$$\n");
        sb.append("225;;cadastrarLogica;;253->260;;56 a 65$$\n");
        sb.append("225;;cadastrarLogica;;260->267;;58 a 66$$\n");
        sb.append("225;;cadastrarLogica;;267->274;;59 a 67$$\n");
        sb.append("225;;cadastrarLogica;;274->281;;61 a 69$$\n");
        sb.append("225;;cadastrarLogica;;281->288;;62 a 70$$\n");
        sb.append("225;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C Ulna">

        sb.append("228;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("222;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("228;;cadastrarLogica;;0->78;;$$\n");
        sb.append("228;;cadastrarLogica;;78->85;;$$\n");
        sb.append("228;;cadastrarLogica;;85->92;;3 a 11$$\n");
        sb.append("228;;cadastrarLogica;;92->99;;5 a 14$$\n");
        sb.append("228;;cadastrarLogica;;99->106;;8 a 17$$\n");
        sb.append("228;;cadastrarLogica;;106->113;;11 a 20$$\n");
        sb.append("228;;cadastrarLogica;;113->120;;14 a 22$$\n");
        sb.append("228;;cadastrarLogica;;120->127;;16 a 25$$\n");
        sb.append("228;;cadastrarLogica;;127->134;;19 a 28$$\n");
        sb.append("228;;cadastrarLogica;;134->141;;22 a 30$$\n");
        sb.append("228;;cadastrarLogica;;141->148;;24 a 33$$\n");
        sb.append("228;;cadastrarLogica;;148->155;;26 a 35$$\n");
        sb.append("228;;cadastrarLogica;;155->162;;29 a 37$$\n");
        sb.append("228;;cadastrarLogica;;162->169;;31 a 39$$\n");
        sb.append("228;;cadastrarLogica;;169->176;;33 a 42$$\n");
        sb.append("228;;cadastrarLogica;;176->183;;35 a 44$$\n");
        sb.append("228;;cadastrarLogica;;183->190;;37 a 46$$\n");
        sb.append("228;;cadastrarLogica;;190->197;;39 a 47$$\n");
        sb.append("228;;cadastrarLogica;;197->204;;41 a 49$$\n");
        sb.append("228;;cadastrarLogica;;204->211;;43 a 51$$\n");
        sb.append("228;;cadastrarLogica;;211->218;;44 a 53$$\n");
        sb.append("228;;cadastrarLogica;;218->225;;46 a 54$$\n");
        sb.append("228;;cadastrarLogica;;225->232;;47 a 56$$\n");
        sb.append("228;;cadastrarLogica;;232->239;;49 a 57$$\n");
        sb.append("228;;cadastrarLogica;;239->246;;50 a 59$$\n");
        sb.append("228;;cadastrarLogica;;246->253;;52 a 60$$\n");
        sb.append("228;;cadastrarLogica;;253->260;;53 a 61$$\n");
        sb.append("228;;cadastrarLogica;;260->267;;54 a 63$$\n");
        sb.append("228;;cadastrarLogica;;267->274;;55 a 64$$\n");
        sb.append("228;;cadastrarLogica;;274->281;;56 a 65$$\n");
        sb.append("228;;cadastrarLogica;;281->288;;57 a 66$$\n");
        sb.append("228;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C tibia">

        sb.append("231;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("225;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("231;;cadastrarLogica;;0->78;;$$\n");
        sb.append("231;;cadastrarLogica;;78->85;;$$\n");
        sb.append("231;;cadastrarLogica;;85->92;;3 a 12$$\n");
        sb.append("231;;cadastrarLogica;;92->99;;5 a 14$$\n");
        sb.append("231;;cadastrarLogica;;99->106;;8 a 16$$\n");
        sb.append("231;;cadastrarLogica;;106->113;;10 a 19$$\n");
        sb.append("231;;cadastrarLogica;;113->120;;13 a 21$$\n");
        sb.append("231;;cadastrarLogica;;120->127;;15 a 24$$\n");
        sb.append("231;;cadastrarLogica;;127->134;;18 a 27$$\n");
        sb.append("231;;cadastrarLogica;;134->141;;21 a 29$$\n");
        sb.append("231;;cadastrarLogica;;141->148;;23 a 32$$\n");
        sb.append("231;;cadastrarLogica;;148->155;;26 a 34$$\n");
        sb.append("231;;cadastrarLogica;;155->162;;28 a 37$$\n");
        sb.append("231;;cadastrarLogica;;162->169;;31 a 39$$\n");
        sb.append("231;;cadastrarLogica;;169->176;;33 a 42$$\n");
        sb.append("231;;cadastrarLogica;;176->183;;35 a 44$$\n");
        sb.append("231;;cadastrarLogica;;183->190;;37 a 46$$\n");
        sb.append("231;;cadastrarLogica;;190->197;;40 a 48$$\n");
        sb.append("231;;cadastrarLogica;;197->204;;42 a 50$$\n");
        sb.append("231;;cadastrarLogica;;204->211;;44 a 52$$\n");
        sb.append("231;;cadastrarLogica;;211->218;;46 a 54$$\n");
        sb.append("231;;cadastrarLogica;;218->225;;47 a 56$$\n");
        sb.append("231;;cadastrarLogica;;225->232;;49 a 58$$\n");
        sb.append("231;;cadastrarLogica;;232->239;;51 a 60$$\n");
        sb.append("231;;cadastrarLogica;;239->246;;53 a 61$$\n");
        sb.append("231;;cadastrarLogica;;246->253;;54 a 63$$\n");
        sb.append("231;;cadastrarLogica;;253->260;;56 a 64$$\n");
        sb.append("231;;cadastrarLogica;;260->267;;57 a 66$$\n");
        sb.append("231;;cadastrarLogica;;267->274;;59 a 67$$\n");
        sb.append("231;;cadastrarLogica;;274->281;;60 a 69$$\n");
        sb.append("231;;cadastrarLogica;;281->288;;61 a 70$$\n");
        sb.append("231;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="PFP">

        sb.append("234;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("228;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("234;;cadastrarLogica;;0->78;;$$\n");
        sb.append("234;;cadastrarLogica;;78->85;;$$\n");
        sb.append("234;;cadastrarLogica;;85->92;;$$\n");
        sb.append("234;;cadastrarLogica;;92->99;;$$\n");
        sb.append("234;;cadastrarLogica;;99->106;;$$\n");
        sb.append("234;;cadastrarLogica;;106->113;;$$\n");
        sb.append("234;;cadastrarLogica;;113->120;;$$\n");
        sb.append("234;;cadastrarLogica;;120->127;;$$\n");
        sb.append("234;;cadastrarLogica;;127->134;;$$\n");
        sb.append("234;;cadastrarLogica;;134->141;;$$\n");
        sb.append("234;;cadastrarLogica;;141->148;;$$\n");
        sb.append("234;;cadastrarLogica;;148->155;;$$\n");
        sb.append("234;;cadastrarLogica;;155->162;;$$\n");
        sb.append("234;;cadastrarLogica;;162->169;;$$\n");
        sb.append("234;;cadastrarLogica;;169->176;;530 a 1260$$\n");
        sb.append("234;;cadastrarLogica;;176->183;;605 a 1305$$\n");
        sb.append("234;;cadastrarLogica;;183->190;;685 a 1360$$\n");
        sb.append("234;;cadastrarLogica;;190->197;;770 a 1435$$\n");
        sb.append("234;;cadastrarLogica;;197->204;;860 a 1550$$\n");
        sb.append("234;;cadastrarLogica;;204->211;;960 a 1690$$\n");
        sb.append("234;;cadastrarLogica;;211->218;;1060 a 1840$$\n");
        sb.append("234;;cadastrarLogica;;218->225;;1170 a 2030$$\n");
        sb.append("234;;cadastrarLogica;;225->232;;1290 a 2280$$\n");
        sb.append("234;;cadastrarLogica;;232->239;;1440 a 2600$$\n");
        sb.append("234;;cadastrarLogica;;239->246;;1600 a 2940$$\n");
        sb.append("234;;cadastrarLogica;;246->253;;1800 a 3200$$\n");
        sb.append("234;;cadastrarLogica;;253->260;;2050 a 3390$$\n");
        sb.append("234;;cadastrarLogica;;260->267;;2260 a 3520$$\n");
        sb.append("234;;cadastrarLogica;;267->274;;2430 a 3640$$\n");
        sb.append("234;;cadastrarLogica;;274->281;;2550 a 3735$$\n");
        sb.append("234;;cadastrarLogica;;281->288;;2690 a 3870$$\n");
        sb.append("234;;cadastrarLogica;;288->295;;2720 a 3890$$\n");
        sb.append("234;;cadastrarLogica;;295->600;;$$\n");

        // </editor-fold>
    }

    private static void preencherRef3 ()
    {
        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("280;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("272;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("280;;cadastrarLogica;;0->78;;$$\n");
        sb.append("280;;cadastrarLogica;;78->85;;13 a 22$$\n");
        sb.append("280;;cadastrarLogica;;85->92;;16 a 25$$\n");
        sb.append("280;;cadastrarLogica;;92->99;;20 a 29$$\n");
        sb.append("280;;cadastrarLogica;;99->106;;23 a 32$$\n");
        sb.append("280;;cadastrarLogica;;106->113;;27 a 36$$\n");
        sb.append("280;;cadastrarLogica;;113->120;;30 a 39$$\n");
        sb.append("280;;cadastrarLogica;;120->127;;34 a 43$$\n");
        sb.append("280;;cadastrarLogica;;127->134;;37 a 46$$\n");
        sb.append("280;;cadastrarLogica;;134->141;;40 a 49$$\n");
        sb.append("280;;cadastrarLogica;;141->148;;44 a 53$$\n");
        sb.append("280;;cadastrarLogica;;148->155;;47 a 56$$\n");
        sb.append("280;;cadastrarLogica;;155->162;;50 a 59$$\n");
        sb.append("280;;cadastrarLogica;;162->169;;53 a 62$$\n");
        sb.append("280;;cadastrarLogica;;169->176;;56 a 65$$\n");
        sb.append("280;;cadastrarLogica;;176->183;;59 a 68$$\n");
        sb.append("280;;cadastrarLogica;;183->190;;62 a 71$$\n");
        sb.append("280;;cadastrarLogica;;190->197;;65 a 74$$\n");
        sb.append("280;;cadastrarLogica;;197->204;;68 a 77$$\n");
        sb.append("280;;cadastrarLogica;;204->211;;70 a 79$$\n");
        sb.append("280;;cadastrarLogica;;211->218;;73 a 82$$\n");
        sb.append("280;;cadastrarLogica;;218->225;;75 a 84$$\n");
        sb.append("280;;cadastrarLogica;;225->232;;77 a 86$$\n");
        sb.append("280;;cadastrarLogica;;232->239;;79 a 88$$\n");
        sb.append("280;;cadastrarLogica;;239->246;;81 a 90$$\n");
        sb.append("280;;cadastrarLogica;;246->253;;83 a 92$$\n");
        sb.append("280;;cadastrarLogica;;253->260;;84 a 93$$\n");
        sb.append("280;;cadastrarLogica;;260->267;;86 a 95$$\n");
        sb.append("280;;cadastrarLogica;;267->274;;87 a 96$$\n");
        sb.append("280;;cadastrarLogica;;274->281;;88 a 97$$\n");
        sb.append("280;;cadastrarLogica;;281->288;;89 a 98$$\n");
        sb.append("280;;cadastrarLogica;;288->295;;89 a 98$$\n");
        sb.append("280;;cadastrarLogica;;295->600;;90 a 99$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="IC">

//        sb.append("275;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CA">

        sb.append("288;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("280;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("288;;cadastrarLogica;;0->78;;$$\n");
        sb.append("288;;cadastrarLogica;;78->85;;$$\n");
        sb.append("288;;cadastrarLogica;;85->92;;$$\n");
        sb.append("288;;cadastrarLogica;;92->99;;$$\n");
        sb.append("288;;cadastrarLogica;;99->106;;67 a 79$$\n");
        sb.append("288;;cadastrarLogica;;106->113;;79 a 93$$\n");
        sb.append("288;;cadastrarLogica;;113->120;;91 a 107$$\n");
        sb.append("288;;cadastrarLogica;;120->127;;103 a 121$$\n");
        sb.append("288;;cadastrarLogica;;127->134;;115 a 135$$\n");
        sb.append("288;;cadastrarLogica;;134->141;;126 a 148$$\n");
        sb.append("288;;cadastrarLogica;;141->148;;138 a 163$$\n");
        sb.append("288;;cadastrarLogica;;148->155;;149 a 176$$\n");
        sb.append("288;;cadastrarLogica;;155->162;;160 a 188$$\n");
        sb.append("288;;cadastrarLogica;;162->169;;170 a 200$$\n");
        sb.append("288;;cadastrarLogica;;169->176;;181 a 213$$\n");
        sb.append("288;;cadastrarLogica;;176->183;;191 a 225$$\n");
        sb.append("288;;cadastrarLogica;;183->190;;201 a 237$$\n");
        sb.append("288;;cadastrarLogica;;190->197;;211 a 249$$\n");
        sb.append("288;;cadastrarLogica;;197->204;;220 a 260$$\n");
        sb.append("288;;cadastrarLogica;;204->211;;230 a 272$$\n");
        sb.append("288;;cadastrarLogica;;211->218;;239 a 283$$\n");
        sb.append("288;;cadastrarLogica;;218->225;;249 a 294$$\n");
        sb.append("288;;cadastrarLogica;;225->232;;258 a 304$$\n");
        sb.append("288;;cadastrarLogica;;232->239;;267 a 315$$\n");
        sb.append("288;;cadastrarLogica;;239->246;;275 a 325$$\n");
        sb.append("288;;cadastrarLogica;;246->253;;283 a 335$$\n");
        sb.append("288;;cadastrarLogica;;253->260;;292 a 344$$\n");
        sb.append("288;;cadastrarLogica;;260->267;;300 a 354$$\n");
        sb.append("288;;cadastrarLogica;;267->274;;308 a 364$$\n");
        sb.append("288;;cadastrarLogica;;274->281;;316 a 373$$\n");
        sb.append("288;;cadastrarLogica;;281->288;;324 a 382$$\n");
        sb.append("288;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CC">

        sb.append("291;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("283;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("291;;cadastrarLogica;;0->78;;$$\n");
        sb.append("291;;cadastrarLogica;;78->85;;$$\n");
        sb.append("291;;cadastrarLogica;;85->92;;51 a 89$$\n");
        sb.append("291;;cadastrarLogica;;92->99;;65 a 103$$\n");
        sb.append("291;;cadastrarLogica;;99->106;;79 a 117$$\n");
        sb.append("291;;cadastrarLogica;;106->113;;92 a 130$$\n");
        sb.append("291;;cadastrarLogica;;113->120;;105 a 43$$\n");
        sb.append("291;;cadastrarLogica;;120->127;;118 a 156$$\n");
        sb.append("291;;cadastrarLogica;;127->134;;131 a 169$$\n");
        sb.append("291;;cadastrarLogica;;134->141;;144 a 182$$\n");
        sb.append("291;;cadastrarLogica;;141->148;;156 a 194$$\n");
        sb.append("291;;cadastrarLogica;;148->155;;168 a 206$$\n");
        sb.append("291;;cadastrarLogica;;155->162;;180 a 218$$\n");
        sb.append("291;;cadastrarLogica;;162->169;;191 a 229$$\n");
        sb.append("291;;cadastrarLogica;;169->176;;202 a 240$$\n");
        sb.append("291;;cadastrarLogica;;176->183;;213 a 251$$\n");
        sb.append("291;;cadastrarLogica;;183->190;;223 a 261$$\n");
        sb.append("291;;cadastrarLogica;;190->197;;233 a 271$$\n");
        sb.append("291;;cadastrarLogica;;197->204;;243 a 281$$\n");
        sb.append("291;;cadastrarLogica;;204->211;;252 a 290$$\n");
        sb.append("291;;cadastrarLogica;;211->218;;261 a 299$$\n");
        sb.append("291;;cadastrarLogica;;218->225;;270 a 308$$\n");
        sb.append("291;;cadastrarLogica;;225->232;;278 a 316$$\n");
        sb.append("291;;cadastrarLogica;;232->239;;285 a 323$$\n");
        sb.append("291;;cadastrarLogica;;239->246;;293 a 331$$\n");
        sb.append("291;;cadastrarLogica;;246->253;;299 a 337$$\n");
        sb.append("291;;cadastrarLogica;;253->260;;306 a 344$$\n");
        sb.append("291;;cadastrarLogica;;260->267;;311 a 349$$\n");
        sb.append("291;;cadastrarLogica;;267->274;;319 a 355$$\n");
        sb.append("291;;cadastrarLogica;;274->281;;322 a 360$$\n");
        sb.append("291;;cadastrarLogica;;281->288;;326 a 364$$\n");
        sb.append("291;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CC / CA">

        sb.append("294;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("286;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("294;;cadastrarLogica;;0->78;;$$\n");
        sb.append("294;;cadastrarLogica;;78->85;;$$\n");
        sb.append("294;;cadastrarLogica;;85->92;;1,12 a 1,31$$\n");
        sb.append("294;;cadastrarLogica;;92->99;;1,11 a 1,30$$\n");
        sb.append("294;;cadastrarLogica;;99->106;;1,11 a 1,30$$\n");
        sb.append("294;;cadastrarLogica;;106->113;;1,10 a 1,29$$\n");
        sb.append("294;;cadastrarLogica;;113->120;;1,09 a 1,28$$\n");
        sb.append("294;;cadastrarLogica;;120->127;;1,08 a 1,27$$\n");
        sb.append("294;;cadastrarLogica;;127->134;;1,07 a 1,26$$\n");
        sb.append("294;;cadastrarLogica;;134->141;;1,06 a 1,25$$\n");
        sb.append("294;;cadastrarLogica;;141->148;;1,06 a 1,24$$\n");
        sb.append("294;;cadastrarLogica;;148->155;;1,05 a 1,24$$\n");
        sb.append("294;;cadastrarLogica;;155->162;;1,04 a 1,23$$\n");
        sb.append("294;;cadastrarLogica;;162->169;;1,03 a 1,22$$\n");
        sb.append("294;;cadastrarLogica;;169->176;;1,02 a 1,21$$\n");
        sb.append("294;;cadastrarLogica;;176->183;;1,01 a 1,20$$\n");
        sb.append("294;;cadastrarLogica;;183->190;;1,00 a 1,19$$\n");
        sb.append("294;;cadastrarLogica;;190->197;;1,00 a 1,18$$\n");
        sb.append("294;;cadastrarLogica;;197->204;;0,99 a 1,18$$\n");
        sb.append("294;;cadastrarLogica;;204->211;;0,98 a 1,17$$\n");
        sb.append("294;;cadastrarLogica;;211->218;;0,97 a 1,16$$\n");
        sb.append("294;;cadastrarLogica;;218->225;;0,96 a 1,15$$\n");
        sb.append("294;;cadastrarLogica;;225->232;;0,95 a 1,14$$\n");
        sb.append("294;;cadastrarLogica;;232->239;;0,95 a 1,13$$\n");
        sb.append("294;;cadastrarLogica;;239->246;;0,94 a 1,13$$\n");
        sb.append("294;;cadastrarLogica;;246->253;;0,93 a 1,12$$\n");
        sb.append("294;;cadastrarLogica;;253->260;;0,92 a 1,11$$\n");
        sb.append("294;;cadastrarLogica;;260->267;;0,91 a 1,10$$\n");
        sb.append("294;;cadastrarLogica;;267->274;;0,89 a 1,09$$\n");
        sb.append("294;;cadastrarLogica;;274->281;;0,89 a 1,09$$\n");
        sb.append("294;;cadastrarLogica;;281->288;;0,89 a 1,08$$\n");
        sb.append("294;;cadastrarLogica;;288->295;;$$\n");
        sb.append("294;;cadastrarLogica;;295->302;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CF">

        sb.append("297;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("289;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("297;;cadastrarLogica;;0->78;;$$\n");
        sb.append("297;;cadastrarLogica;;78->85;;$$\n");
        sb.append("297;;cadastrarLogica;;85->92;;2 a 14$$\n");
        sb.append("297;;cadastrarLogica;;92->99;;5 a 17$$\n");
        sb.append("297;;cadastrarLogica;;99->106;;9 a 21$$\n");
        sb.append("297;;cadastrarLogica;;106->113;;12 a 24$$\n");
        sb.append("297;;cadastrarLogica;;113->120;;15 a 27$$\n");
        sb.append("297;;cadastrarLogica;;120->127;;18 a 30$$\n");
        sb.append("297;;cadastrarLogica;;127->134;;21 a 33$$\n");
        sb.append("297;;cadastrarLogica;;134->141;;23 a 36$$\n");
        sb.append("297;;cadastrarLogica;;141->148;;27 a 39$$\n");
        sb.append("297;;cadastrarLogica;;148->155;;30 a 42$$\n");
        sb.append("297;;cadastrarLogica;;155->162;;33 a 45$$\n");
        sb.append("297;;cadastrarLogica;;162->169;;36 a 48$$\n");
        sb.append("297;;cadastrarLogica;;169->176;;38 a 50$$\n");
        sb.append("297;;cadastrarLogica;;176->183;;41 a 53$$\n");
        sb.append("297;;cadastrarLogica;;183->190;;43 a 55$$\n");
        sb.append("297;;cadastrarLogica;;190->197;;46 a 58$$\n");
        sb.append("297;;cadastrarLogica;;197->204;;48 a 60$$\n");
        sb.append("297;;cadastrarLogica;;204->211;;50 a 62$$\n");
        sb.append("297;;cadastrarLogica;;211->218;;52 a 64$$\n");
        sb.append("297;;cadastrarLogica;;218->225;;55 a 67$$\n");
        sb.append("297;;cadastrarLogica;;225->232;;57 a 69$$\n");
        sb.append("297;;cadastrarLogica;;232->239;;59 a 71$$\n");
        sb.append("297;;cadastrarLogica;;239->246;;60 a 72$$\n");
        sb.append("297;;cadastrarLogica;;246->253;;62 a 74$$\n");
        sb.append("297;;cadastrarLogica;;253->260;;64 a 76$$\n");
        sb.append("297;;cadastrarLogica;;260->267;;66 a 78$$\n");
        sb.append("297;;cadastrarLogica;;267->274;;67 a 79$$\n");
        sb.append("297;;cadastrarLogica;;274->281;;69 a 81$$\n");
        sb.append("297;;cadastrarLogica;;281->288;;70 a 82$$\n");
        sb.append("297;;cadastrarLogica;;288->295;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CF / CA">

//        sb.append("292;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C Umero">

        sb.append("303;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("295;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("303;;cadastrarLogica;;0->78;;$$\n");
        sb.append("303;;cadastrarLogica;;78->85;;$$\n");
        sb.append("303;;cadastrarLogica;;85->92;;4 a 13$$\n");
        sb.append("303;;cadastrarLogica;;92->99;;7 a 15$$\n");
        sb.append("303;;cadastrarLogica;;99->106;;10 a 18$$\n");
        sb.append("303;;cadastrarLogica;;106->113;;13 a 21$$\n");
        sb.append("303;;cadastrarLogica;;113->120;;16 a 24$$\n");
        sb.append("303;;cadastrarLogica;;120->127;;18 a 27$$\n");
        sb.append("303;;cadastrarLogica;;127->134;;21 a 29$$\n");
        sb.append("303;;cadastrarLogica;;134->141;;24 a 32$$\n");
        sb.append("303;;cadastrarLogica;;141->148;;26 a 34$$\n");
        sb.append("303;;cadastrarLogica;;148->155;;29 a 37$$\n");
        sb.append("303;;cadastrarLogica;;155->162;;31 a 39$$\n");
        sb.append("303;;cadastrarLogica;;162->169;;33 a 42$$\n");
        sb.append("303;;cadastrarLogica;;169->176;;36 a 44$$\n");
        sb.append("303;;cadastrarLogica;;176->183;;38 a 46$$\n");
        sb.append("303;;cadastrarLogica;;183->190;;40 a 48$$\n");
        sb.append("303;;cadastrarLogica;;190->197;;42 a 50$$\n");
        sb.append("303;;cadastrarLogica;;197->204;;44 a 52$$\n");
        sb.append("303;;cadastrarLogica;;204->211;;46 a 54$$\n");
        sb.append("303;;cadastrarLogica;;211->218;;47 a 56$$\n");
        sb.append("303;;cadastrarLogica;;218->225;;49 a 57$$\n");
        sb.append("303;;cadastrarLogica;;225->232;;51 a 59$$\n");
        sb.append("303;;cadastrarLogica;;232->239;;52 a 60$$\n");
        sb.append("303;;cadastrarLogica;;239->246;;54 a 62$$\n");
        sb.append("303;;cadastrarLogica;;246->253;;55 a 63$$\n");
        sb.append("303;;cadastrarLogica;;253->260;;56 a 65$$\n");
        sb.append("303;;cadastrarLogica;;260->267;;58 a 66$$\n");
        sb.append("303;;cadastrarLogica;;267->274;;59 a 67$$\n");
        sb.append("303;;cadastrarLogica;;274->281;;61 a 69$$\n");
        sb.append("303;;cadastrarLogica;;281->288;;62 a 70$$\n");
        sb.append("303;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C Ulna">

        sb.append("306;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("298;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("306;;cadastrarLogica;;0->78;;$$\n");
        sb.append("306;;cadastrarLogica;;78->85;;$$\n");
        sb.append("306;;cadastrarLogica;;85->92;;3 a 11$$\n");
        sb.append("306;;cadastrarLogica;;92->99;;5 a 14$$\n");
        sb.append("306;;cadastrarLogica;;99->106;;8 a 17$$\n");
        sb.append("306;;cadastrarLogica;;106->113;;11 a 20$$\n");
        sb.append("306;;cadastrarLogica;;113->120;;14 a 22$$\n");
        sb.append("306;;cadastrarLogica;;120->127;;16 a 25$$\n");
        sb.append("306;;cadastrarLogica;;127->134;;19 a 28$$\n");
        sb.append("306;;cadastrarLogica;;134->141;;22 a 30$$\n");
        sb.append("306;;cadastrarLogica;;141->148;;24 a 33$$\n");
        sb.append("306;;cadastrarLogica;;148->155;;26 a 35$$\n");
        sb.append("306;;cadastrarLogica;;155->162;;29 a 37$$\n");
        sb.append("306;;cadastrarLogica;;162->169;;31 a 39$$\n");
        sb.append("306;;cadastrarLogica;;169->176;;33 a 42$$\n");
        sb.append("306;;cadastrarLogica;;176->183;;35 a 44$$\n");
        sb.append("306;;cadastrarLogica;;183->190;;37 a 46$$\n");
        sb.append("306;;cadastrarLogica;;190->197;;39 a 47$$\n");
        sb.append("306;;cadastrarLogica;;197->204;;41 a 49$$\n");
        sb.append("306;;cadastrarLogica;;204->211;;43 a 51$$\n");
        sb.append("306;;cadastrarLogica;;211->218;;44 a 53$$\n");
        sb.append("306;;cadastrarLogica;;218->225;;46 a 54$$\n");
        sb.append("306;;cadastrarLogica;;225->232;;47 a 56$$\n");
        sb.append("306;;cadastrarLogica;;232->239;;49 a 57$$\n");
        sb.append("306;;cadastrarLogica;;239->246;;50 a 59$$\n");
        sb.append("306;;cadastrarLogica;;246->253;;52 a 60$$\n");
        sb.append("306;;cadastrarLogica;;253->260;;53 a 61$$\n");
        sb.append("306;;cadastrarLogica;;260->267;;54 a 63$$\n");
        sb.append("306;;cadastrarLogica;;267->274;;55 a 64$$\n");
        sb.append("306;;cadastrarLogica;;274->281;;56 a 65$$\n");
        sb.append("306;;cadastrarLogica;;281->288;;57 a 66$$\n");
        sb.append("306;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C tibia">

        sb.append("309;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("301;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("309;;cadastrarLogica;;0->78;;$$\n");
        sb.append("309;;cadastrarLogica;;78->85;;$$\n");
        sb.append("309;;cadastrarLogica;;85->92;;3 a 12$$\n");
        sb.append("309;;cadastrarLogica;;92->99;;5 a 14$$\n");
        sb.append("309;;cadastrarLogica;;99->106;;8 a 16$$\n");
        sb.append("309;;cadastrarLogica;;106->113;;10 a 19$$\n");
        sb.append("309;;cadastrarLogica;;113->120;;13 a 21$$\n");
        sb.append("309;;cadastrarLogica;;120->127;;15 a 24$$\n");
        sb.append("309;;cadastrarLogica;;127->134;;18 a 27$$\n");
        sb.append("309;;cadastrarLogica;;134->141;;21 a 29$$\n");
        sb.append("309;;cadastrarLogica;;141->148;;23 a 32$$\n");
        sb.append("309;;cadastrarLogica;;148->155;;26 a 34$$\n");
        sb.append("309;;cadastrarLogica;;155->162;;28 a 37$$\n");
        sb.append("309;;cadastrarLogica;;162->169;;31 a 39$$\n");
        sb.append("309;;cadastrarLogica;;169->176;;33 a 42$$\n");
        sb.append("309;;cadastrarLogica;;176->183;;35 a 44$$\n");
        sb.append("309;;cadastrarLogica;;183->190;;37 a 46$$\n");
        sb.append("309;;cadastrarLogica;;190->197;;40 a 48$$\n");
        sb.append("309;;cadastrarLogica;;197->204;;42 a 50$$\n");
        sb.append("309;;cadastrarLogica;;204->211;;44 a 52$$\n");
        sb.append("309;;cadastrarLogica;;211->218;;46 a 54$$\n");
        sb.append("309;;cadastrarLogica;;218->225;;47 a 56$$\n");
        sb.append("309;;cadastrarLogica;;225->232;;49 a 58$$\n");
        sb.append("309;;cadastrarLogica;;232->239;;51 a 60$$\n");
        sb.append("309;;cadastrarLogica;;239->246;;53 a 61$$\n");
        sb.append("309;;cadastrarLogica;;246->253;;54 a 63$$\n");
        sb.append("309;;cadastrarLogica;;253->260;;56 a 64$$\n");
        sb.append("309;;cadastrarLogica;;260->267;;57 a 66$$\n");
        sb.append("309;;cadastrarLogica;;267->274;;59 a 67$$\n");
        sb.append("309;;cadastrarLogica;;274->281;;60 a 69$$\n");
        sb.append("309;;cadastrarLogica;;281->288;;61 a 70$$\n");
        sb.append("309;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="PFP">

        sb.append("312;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("304;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("312;;cadastrarLogica;;0->78;;$$\n");
        sb.append("312;;cadastrarLogica;;78->85;;$$\n");
        sb.append("312;;cadastrarLogica;;85->92;;$$\n");
        sb.append("312;;cadastrarLogica;;92->99;;$$\n");
        sb.append("312;;cadastrarLogica;;99->106;;$$\n");
        sb.append("312;;cadastrarLogica;;106->113;;$$\n");
        sb.append("312;;cadastrarLogica;;113->120;;$$\n");
        sb.append("312;;cadastrarLogica;;120->127;;$$\n");
        sb.append("312;;cadastrarLogica;;127->134;;$$\n");
        sb.append("312;;cadastrarLogica;;134->141;;$$\n");
        sb.append("312;;cadastrarLogica;;141->148;;$$\n");
        sb.append("312;;cadastrarLogica;;148->155;;$$\n");
        sb.append("312;;cadastrarLogica;;155->162;;$$\n");
        sb.append("312;;cadastrarLogica;;162->169;;$$\n");
        sb.append("312;;cadastrarLogica;;169->176;;530 a 1260$$\n");
        sb.append("312;;cadastrarLogica;;176->183;;605 a 1305$$\n");
        sb.append("312;;cadastrarLogica;;183->190;;685 a 1360$$\n");
        sb.append("312;;cadastrarLogica;;190->197;;770 a 1435$$\n");
        sb.append("312;;cadastrarLogica;;197->204;;860 a 1550$$\n");
        sb.append("312;;cadastrarLogica;;204->211;;960 a 1690$$\n");
        sb.append("312;;cadastrarLogica;;211->218;;1060 a 1840$$\n");
        sb.append("312;;cadastrarLogica;;218->225;;1170 a 2030$$\n");
        sb.append("312;;cadastrarLogica;;225->232;;1290 a 2280$$\n");
        sb.append("312;;cadastrarLogica;;232->239;;1440 a 2600$$\n");
        sb.append("312;;cadastrarLogica;;239->246;;1600 a 2940$$\n");
        sb.append("312;;cadastrarLogica;;246->253;;1800 a 3200$$\n");
        sb.append("312;;cadastrarLogica;;253->260;;2050 a 3390$$\n");
        sb.append("312;;cadastrarLogica;;260->267;;2260 a 3520$$\n");
        sb.append("312;;cadastrarLogica;;267->274;;2430 a 3640$$\n");
        sb.append("312;;cadastrarLogica;;274->281;;2550 a 3735$$\n");
        sb.append("312;;cadastrarLogica;;281->288;;2690 a 3870$$\n");
        sb.append("312;;cadastrarLogica;;288->295;;2720 a 3890$$\n");
        sb.append("312;;cadastrarLogica;;295->600;;$$\n");

        // </editor-fold>
    }

    private static void preencherRef4 ()
    {
        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("358;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("348;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("358;;cadastrarLogica;;0->78;;$$\n");
        sb.append("358;;cadastrarLogica;;78->85;;13 a 22$$\n");
        sb.append("358;;cadastrarLogica;;85->92;;16 a 25$$\n");
        sb.append("358;;cadastrarLogica;;92->99;;20 a 29$$\n");
        sb.append("358;;cadastrarLogica;;99->106;;23 a 32$$\n");
        sb.append("358;;cadastrarLogica;;106->113;;27 a 36$$\n");
        sb.append("358;;cadastrarLogica;;113->120;;30 a 39$$\n");
        sb.append("358;;cadastrarLogica;;120->127;;34 a 43$$\n");
        sb.append("358;;cadastrarLogica;;127->134;;37 a 46$$\n");
        sb.append("358;;cadastrarLogica;;134->141;;40 a 49$$\n");
        sb.append("358;;cadastrarLogica;;141->148;;44 a 53$$\n");
        sb.append("358;;cadastrarLogica;;148->155;;47 a 56$$\n");
        sb.append("358;;cadastrarLogica;;155->162;;50 a 59$$\n");
        sb.append("358;;cadastrarLogica;;162->169;;53 a 62$$\n");
        sb.append("358;;cadastrarLogica;;169->176;;56 a 65$$\n");
        sb.append("358;;cadastrarLogica;;176->183;;59 a 68$$\n");
        sb.append("358;;cadastrarLogica;;183->190;;62 a 71$$\n");
        sb.append("358;;cadastrarLogica;;190->197;;65 a 74$$\n");
        sb.append("358;;cadastrarLogica;;197->204;;68 a 77$$\n");
        sb.append("358;;cadastrarLogica;;204->211;;70 a 79$$\n");
        sb.append("358;;cadastrarLogica;;211->218;;73 a 82$$\n");
        sb.append("358;;cadastrarLogica;;218->225;;75 a 84$$\n");
        sb.append("358;;cadastrarLogica;;225->232;;77 a 86$$\n");
        sb.append("358;;cadastrarLogica;;232->239;;79 a 88$$\n");
        sb.append("358;;cadastrarLogica;;239->246;;81 a 90$$\n");
        sb.append("358;;cadastrarLogica;;246->253;;83 a 92$$\n");
        sb.append("358;;cadastrarLogica;;253->260;;84 a 93$$\n");
        sb.append("358;;cadastrarLogica;;260->267;;86 a 95$$\n");
        sb.append("358;;cadastrarLogica;;267->274;;87 a 96$$\n");
        sb.append("358;;cadastrarLogica;;274->281;;88 a 97$$\n");
        sb.append("358;;cadastrarLogica;;281->288;;89 a 98$$\n");
        sb.append("358;;cadastrarLogica;;288->295;;89 a 98$$\n");
        sb.append("358;;cadastrarLogica;;295->600;;90 a 99$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="IC">

//        sb.append("351;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CA">

        sb.append("366;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("356;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("366;;cadastrarLogica;;0->78;;$$\n");
        sb.append("366;;cadastrarLogica;;78->85;;$$\n");
        sb.append("366;;cadastrarLogica;;85->92;;$$\n");
        sb.append("366;;cadastrarLogica;;92->99;;$$\n");
        sb.append("366;;cadastrarLogica;;99->106;;67 a 79$$\n");
        sb.append("366;;cadastrarLogica;;106->113;;79 a 93$$\n");
        sb.append("366;;cadastrarLogica;;113->120;;91 a 107$$\n");
        sb.append("366;;cadastrarLogica;;120->127;;103 a 121$$\n");
        sb.append("366;;cadastrarLogica;;127->134;;115 a 135$$\n");
        sb.append("366;;cadastrarLogica;;134->141;;126 a 148$$\n");
        sb.append("366;;cadastrarLogica;;141->148;;138 a 163$$\n");
        sb.append("366;;cadastrarLogica;;148->155;;149 a 176$$\n");
        sb.append("366;;cadastrarLogica;;155->162;;160 a 188$$\n");
        sb.append("366;;cadastrarLogica;;162->169;;170 a 200$$\n");
        sb.append("366;;cadastrarLogica;;169->176;;181 a 213$$\n");
        sb.append("366;;cadastrarLogica;;176->183;;191 a 225$$\n");
        sb.append("366;;cadastrarLogica;;183->190;;201 a 237$$\n");
        sb.append("366;;cadastrarLogica;;190->197;;211 a 249$$\n");
        sb.append("366;;cadastrarLogica;;197->204;;220 a 260$$\n");
        sb.append("366;;cadastrarLogica;;204->211;;230 a 272$$\n");
        sb.append("366;;cadastrarLogica;;211->218;;239 a 283$$\n");
        sb.append("366;;cadastrarLogica;;218->225;;249 a 294$$\n");
        sb.append("366;;cadastrarLogica;;225->232;;258 a 304$$\n");
        sb.append("366;;cadastrarLogica;;232->239;;267 a 315$$\n");
        sb.append("366;;cadastrarLogica;;239->246;;275 a 325$$\n");
        sb.append("366;;cadastrarLogica;;246->253;;283 a 335$$\n");
        sb.append("366;;cadastrarLogica;;253->260;;292 a 344$$\n");
        sb.append("366;;cadastrarLogica;;260->267;;300 a 354$$\n");
        sb.append("366;;cadastrarLogica;;267->274;;308 a 364$$\n");
        sb.append("366;;cadastrarLogica;;274->281;;316 a 373$$\n");
        sb.append("366;;cadastrarLogica;;281->288;;324 a 382$$\n");
        sb.append("366;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CC">

        sb.append("369;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("359;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("369;;cadastrarLogica;;0->78;;$$\n");
        sb.append("369;;cadastrarLogica;;78->85;;$$\n");
        sb.append("369;;cadastrarLogica;;85->92;;51 a 89$$\n");
        sb.append("369;;cadastrarLogica;;92->99;;65 a 103$$\n");
        sb.append("369;;cadastrarLogica;;99->106;;79 a 117$$\n");
        sb.append("369;;cadastrarLogica;;106->113;;92 a 130$$\n");
        sb.append("369;;cadastrarLogica;;113->120;;105 a 43$$\n");
        sb.append("369;;cadastrarLogica;;120->127;;118 a 156$$\n");
        sb.append("369;;cadastrarLogica;;127->134;;131 a 169$$\n");
        sb.append("369;;cadastrarLogica;;134->141;;144 a 182$$\n");
        sb.append("369;;cadastrarLogica;;141->148;;156 a 194$$\n");
        sb.append("369;;cadastrarLogica;;148->155;;168 a 206$$\n");
        sb.append("369;;cadastrarLogica;;155->162;;180 a 218$$\n");
        sb.append("369;;cadastrarLogica;;162->169;;191 a 229$$\n");
        sb.append("369;;cadastrarLogica;;169->176;;202 a 240$$\n");
        sb.append("369;;cadastrarLogica;;176->183;;213 a 251$$\n");
        sb.append("369;;cadastrarLogica;;183->190;;223 a 261$$\n");
        sb.append("369;;cadastrarLogica;;190->197;;233 a 271$$\n");
        sb.append("369;;cadastrarLogica;;197->204;;243 a 281$$\n");
        sb.append("369;;cadastrarLogica;;204->211;;252 a 290$$\n");
        sb.append("369;;cadastrarLogica;;211->218;;261 a 299$$\n");
        sb.append("369;;cadastrarLogica;;218->225;;270 a 308$$\n");
        sb.append("369;;cadastrarLogica;;225->232;;278 a 316$$\n");
        sb.append("369;;cadastrarLogica;;232->239;;285 a 323$$\n");
        sb.append("369;;cadastrarLogica;;239->246;;293 a 331$$\n");
        sb.append("369;;cadastrarLogica;;246->253;;299 a 337$$\n");
        sb.append("369;;cadastrarLogica;;253->260;;306 a 344$$\n");
        sb.append("369;;cadastrarLogica;;260->267;;311 a 349$$\n");
        sb.append("369;;cadastrarLogica;;267->274;;319 a 355$$\n");
        sb.append("369;;cadastrarLogica;;274->281;;322 a 360$$\n");
        sb.append("369;;cadastrarLogica;;281->288;;326 a 364$$\n");
        sb.append("369;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CC / CA">

        sb.append("372;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("362;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("372;;cadastrarLogica;;0->78;;$$\n");
        sb.append("372;;cadastrarLogica;;78->85;;$$\n");
        sb.append("372;;cadastrarLogica;;85->92;;1,12 a 1,31$$\n");
        sb.append("372;;cadastrarLogica;;92->99;;1,11 a 1,30$$\n");
        sb.append("372;;cadastrarLogica;;99->106;;1,11 a 1,30$$\n");
        sb.append("372;;cadastrarLogica;;106->113;;1,10 a 1,29$$\n");
        sb.append("372;;cadastrarLogica;;113->120;;1,09 a 1,28$$\n");
        sb.append("372;;cadastrarLogica;;120->127;;1,08 a 1,27$$\n");
        sb.append("372;;cadastrarLogica;;127->134;;1,07 a 1,26$$\n");
        sb.append("372;;cadastrarLogica;;134->141;;1,06 a 1,25$$\n");
        sb.append("372;;cadastrarLogica;;141->148;;1,06 a 1,24$$\n");
        sb.append("372;;cadastrarLogica;;148->155;;1,05 a 1,24$$\n");
        sb.append("372;;cadastrarLogica;;155->162;;1,04 a 1,23$$\n");
        sb.append("372;;cadastrarLogica;;162->169;;1,03 a 1,22$$\n");
        sb.append("372;;cadastrarLogica;;169->176;;1,02 a 1,21$$\n");
        sb.append("372;;cadastrarLogica;;176->183;;1,01 a 1,20$$\n");
        sb.append("372;;cadastrarLogica;;183->190;;1,00 a 1,19$$\n");
        sb.append("372;;cadastrarLogica;;190->197;;1,00 a 1,18$$\n");
        sb.append("372;;cadastrarLogica;;197->204;;0,99 a 1,18$$\n");
        sb.append("372;;cadastrarLogica;;204->211;;0,98 a 1,17$$\n");
        sb.append("372;;cadastrarLogica;;211->218;;0,97 a 1,16$$\n");
        sb.append("372;;cadastrarLogica;;218->225;;0,96 a 1,15$$\n");
        sb.append("372;;cadastrarLogica;;225->232;;0,95 a 1,14$$\n");
        sb.append("372;;cadastrarLogica;;232->239;;0,95 a 1,13$$\n");
        sb.append("372;;cadastrarLogica;;239->246;;0,94 a 1,13$$\n");
        sb.append("372;;cadastrarLogica;;246->253;;0,93 a 1,12$$\n");
        sb.append("372;;cadastrarLogica;;253->260;;0,92 a 1,11$$\n");
        sb.append("372;;cadastrarLogica;;260->267;;0,91 a 1,10$$\n");
        sb.append("372;;cadastrarLogica;;267->274;;0,89 a 1,09$$\n");
        sb.append("372;;cadastrarLogica;;274->281;;0,89 a 1,09$$\n");
        sb.append("372;;cadastrarLogica;;281->288;;0,89 a 1,08$$\n");
        sb.append("372;;cadastrarLogica;;288->295;;$$\n");
        sb.append("372;;cadastrarLogica;;295->302;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CF">

        sb.append("375;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("365;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("375;;cadastrarLogica;;0->78;;$$\n");
        sb.append("375;;cadastrarLogica;;78->85;;$$\n");
        sb.append("375;;cadastrarLogica;;85->92;;2 a 14$$\n");
        sb.append("375;;cadastrarLogica;;92->99;;5 a 17$$\n");
        sb.append("375;;cadastrarLogica;;99->106;;9 a 21$$\n");
        sb.append("375;;cadastrarLogica;;106->113;;12 a 24$$\n");
        sb.append("375;;cadastrarLogica;;113->120;;15 a 27$$\n");
        sb.append("375;;cadastrarLogica;;120->127;;18 a 30$$\n");
        sb.append("375;;cadastrarLogica;;127->134;;21 a 33$$\n");
        sb.append("375;;cadastrarLogica;;134->141;;23 a 36$$\n");
        sb.append("375;;cadastrarLogica;;141->148;;27 a 39$$\n");
        sb.append("375;;cadastrarLogica;;148->155;;30 a 42$$\n");
        sb.append("375;;cadastrarLogica;;155->162;;33 a 45$$\n");
        sb.append("375;;cadastrarLogica;;162->169;;36 a 48$$\n");
        sb.append("375;;cadastrarLogica;;169->176;;38 a 50$$\n");
        sb.append("375;;cadastrarLogica;;176->183;;41 a 53$$\n");
        sb.append("375;;cadastrarLogica;;183->190;;43 a 55$$\n");
        sb.append("375;;cadastrarLogica;;190->197;;46 a 58$$\n");
        sb.append("375;;cadastrarLogica;;197->204;;48 a 60$$\n");
        sb.append("375;;cadastrarLogica;;204->211;;50 a 62$$\n");
        sb.append("375;;cadastrarLogica;;211->218;;52 a 64$$\n");
        sb.append("375;;cadastrarLogica;;218->225;;55 a 67$$\n");
        sb.append("375;;cadastrarLogica;;225->232;;57 a 69$$\n");
        sb.append("375;;cadastrarLogica;;232->239;;59 a 71$$\n");
        sb.append("375;;cadastrarLogica;;239->246;;60 a 72$$\n");
        sb.append("375;;cadastrarLogica;;246->253;;62 a 74$$\n");
        sb.append("375;;cadastrarLogica;;253->260;;64 a 76$$\n");
        sb.append("375;;cadastrarLogica;;260->267;;66 a 78$$\n");
        sb.append("375;;cadastrarLogica;;267->274;;67 a 79$$\n");
        sb.append("375;;cadastrarLogica;;274->281;;69 a 81$$\n");
        sb.append("375;;cadastrarLogica;;281->288;;70 a 82$$\n");
        sb.append("375;;cadastrarLogica;;288->295;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CF / CA">

//        sb.append("368;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C Umero">

        sb.append("381;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("371;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("381;;cadastrarLogica;;0->78;;$$\n");
        sb.append("381;;cadastrarLogica;;78->85;;$$\n");
        sb.append("381;;cadastrarLogica;;85->92;;4 a 13$$\n");
        sb.append("381;;cadastrarLogica;;92->99;;7 a 15$$\n");
        sb.append("381;;cadastrarLogica;;99->106;;10 a 18$$\n");
        sb.append("381;;cadastrarLogica;;106->113;;13 a 21$$\n");
        sb.append("381;;cadastrarLogica;;113->120;;16 a 24$$\n");
        sb.append("381;;cadastrarLogica;;120->127;;18 a 27$$\n");
        sb.append("381;;cadastrarLogica;;127->134;;21 a 29$$\n");
        sb.append("381;;cadastrarLogica;;134->141;;24 a 32$$\n");
        sb.append("381;;cadastrarLogica;;141->148;;26 a 34$$\n");
        sb.append("381;;cadastrarLogica;;148->155;;29 a 37$$\n");
        sb.append("381;;cadastrarLogica;;155->162;;31 a 39$$\n");
        sb.append("381;;cadastrarLogica;;162->169;;33 a 42$$\n");
        sb.append("381;;cadastrarLogica;;169->176;;36 a 44$$\n");
        sb.append("381;;cadastrarLogica;;176->183;;38 a 46$$\n");
        sb.append("381;;cadastrarLogica;;183->190;;40 a 48$$\n");
        sb.append("381;;cadastrarLogica;;190->197;;42 a 50$$\n");
        sb.append("381;;cadastrarLogica;;197->204;;44 a 52$$\n");
        sb.append("381;;cadastrarLogica;;204->211;;46 a 54$$\n");
        sb.append("381;;cadastrarLogica;;211->218;;47 a 56$$\n");
        sb.append("381;;cadastrarLogica;;218->225;;49 a 57$$\n");
        sb.append("381;;cadastrarLogica;;225->232;;51 a 59$$\n");
        sb.append("381;;cadastrarLogica;;232->239;;52 a 60$$\n");
        sb.append("381;;cadastrarLogica;;239->246;;54 a 62$$\n");
        sb.append("381;;cadastrarLogica;;246->253;;55 a 63$$\n");
        sb.append("381;;cadastrarLogica;;253->260;;56 a 65$$\n");
        sb.append("381;;cadastrarLogica;;260->267;;58 a 66$$\n");
        sb.append("381;;cadastrarLogica;;267->274;;59 a 67$$\n");
        sb.append("381;;cadastrarLogica;;274->281;;61 a 69$$\n");
        sb.append("381;;cadastrarLogica;;281->288;;62 a 70$$\n");
        sb.append("381;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C Ulna">

        sb.append("384;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("374;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("384;;cadastrarLogica;;0->78;;$$\n");
        sb.append("384;;cadastrarLogica;;78->85;;$$\n");
        sb.append("384;;cadastrarLogica;;85->92;;3 a 11$$\n");
        sb.append("384;;cadastrarLogica;;92->99;;5 a 14$$\n");
        sb.append("384;;cadastrarLogica;;99->106;;8 a 17$$\n");
        sb.append("384;;cadastrarLogica;;106->113;;11 a 20$$\n");
        sb.append("384;;cadastrarLogica;;113->120;;14 a 22$$\n");
        sb.append("384;;cadastrarLogica;;120->127;;16 a 25$$\n");
        sb.append("384;;cadastrarLogica;;127->134;;19 a 28$$\n");
        sb.append("384;;cadastrarLogica;;134->141;;22 a 30$$\n");
        sb.append("384;;cadastrarLogica;;141->148;;24 a 33$$\n");
        sb.append("384;;cadastrarLogica;;148->155;;26 a 35$$\n");
        sb.append("384;;cadastrarLogica;;155->162;;29 a 37$$\n");
        sb.append("384;;cadastrarLogica;;162->169;;31 a 39$$\n");
        sb.append("384;;cadastrarLogica;;169->176;;33 a 42$$\n");
        sb.append("384;;cadastrarLogica;;176->183;;35 a 44$$\n");
        sb.append("384;;cadastrarLogica;;183->190;;37 a 46$$\n");
        sb.append("384;;cadastrarLogica;;190->197;;39 a 47$$\n");
        sb.append("384;;cadastrarLogica;;197->204;;41 a 49$$\n");
        sb.append("384;;cadastrarLogica;;204->211;;43 a 51$$\n");
        sb.append("384;;cadastrarLogica;;211->218;;44 a 53$$\n");
        sb.append("384;;cadastrarLogica;;218->225;;46 a 54$$\n");
        sb.append("384;;cadastrarLogica;;225->232;;47 a 56$$\n");
        sb.append("384;;cadastrarLogica;;232->239;;49 a 57$$\n");
        sb.append("384;;cadastrarLogica;;239->246;;50 a 59$$\n");
        sb.append("384;;cadastrarLogica;;246->253;;52 a 60$$\n");
        sb.append("384;;cadastrarLogica;;253->260;;53 a 61$$\n");
        sb.append("384;;cadastrarLogica;;260->267;;54 a 63$$\n");
        sb.append("384;;cadastrarLogica;;267->274;;55 a 64$$\n");
        sb.append("384;;cadastrarLogica;;274->281;;56 a 65$$\n");
        sb.append("384;;cadastrarLogica;;281->288;;57 a 66$$\n");
        sb.append("384;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C tibia">

        sb.append("387;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("377;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("387;;cadastrarLogica;;0->78;;$$\n");
        sb.append("387;;cadastrarLogica;;78->85;;$$\n");
        sb.append("387;;cadastrarLogica;;85->92;;3 a 12$$\n");
        sb.append("387;;cadastrarLogica;;92->99;;5 a 14$$\n");
        sb.append("387;;cadastrarLogica;;99->106;;8 a 16$$\n");
        sb.append("387;;cadastrarLogica;;106->113;;10 a 19$$\n");
        sb.append("387;;cadastrarLogica;;113->120;;13 a 21$$\n");
        sb.append("387;;cadastrarLogica;;120->127;;15 a 24$$\n");
        sb.append("387;;cadastrarLogica;;127->134;;18 a 27$$\n");
        sb.append("387;;cadastrarLogica;;134->141;;21 a 29$$\n");
        sb.append("387;;cadastrarLogica;;141->148;;23 a 32$$\n");
        sb.append("387;;cadastrarLogica;;148->155;;26 a 34$$\n");
        sb.append("387;;cadastrarLogica;;155->162;;28 a 37$$\n");
        sb.append("387;;cadastrarLogica;;162->169;;31 a 39$$\n");
        sb.append("387;;cadastrarLogica;;169->176;;33 a 42$$\n");
        sb.append("387;;cadastrarLogica;;176->183;;35 a 44$$\n");
        sb.append("387;;cadastrarLogica;;183->190;;37 a 46$$\n");
        sb.append("387;;cadastrarLogica;;190->197;;40 a 48$$\n");
        sb.append("387;;cadastrarLogica;;197->204;;42 a 50$$\n");
        sb.append("387;;cadastrarLogica;;204->211;;44 a 52$$\n");
        sb.append("387;;cadastrarLogica;;211->218;;46 a 54$$\n");
        sb.append("387;;cadastrarLogica;;218->225;;47 a 56$$\n");
        sb.append("387;;cadastrarLogica;;225->232;;49 a 58$$\n");
        sb.append("387;;cadastrarLogica;;232->239;;51 a 60$$\n");
        sb.append("387;;cadastrarLogica;;239->246;;53 a 61$$\n");
        sb.append("387;;cadastrarLogica;;246->253;;54 a 63$$\n");
        sb.append("387;;cadastrarLogica;;253->260;;56 a 64$$\n");
        sb.append("387;;cadastrarLogica;;260->267;;57 a 66$$\n");
        sb.append("387;;cadastrarLogica;;267->274;;59 a 67$$\n");
        sb.append("387;;cadastrarLogica;;274->281;;60 a 69$$\n");
        sb.append("387;;cadastrarLogica;;281->288;;61 a 70$$\n");
        sb.append("387;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="PFP">

        sb.append("390;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("380;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("390;;cadastrarLogica;;0->78;;$$\n");
        sb.append("390;;cadastrarLogica;;78->85;;$$\n");
        sb.append("390;;cadastrarLogica;;85->92;;$$\n");
        sb.append("390;;cadastrarLogica;;92->99;;$$\n");
        sb.append("390;;cadastrarLogica;;99->106;;$$\n");
        sb.append("390;;cadastrarLogica;;106->113;;$$\n");
        sb.append("390;;cadastrarLogica;;113->120;;$$\n");
        sb.append("390;;cadastrarLogica;;120->127;;$$\n");
        sb.append("390;;cadastrarLogica;;127->134;;$$\n");
        sb.append("390;;cadastrarLogica;;134->141;;$$\n");
        sb.append("390;;cadastrarLogica;;141->148;;$$\n");
        sb.append("390;;cadastrarLogica;;148->155;;$$\n");
        sb.append("390;;cadastrarLogica;;155->162;;$$\n");
        sb.append("390;;cadastrarLogica;;162->169;;$$\n");
        sb.append("390;;cadastrarLogica;;169->176;;530 a 1260$$\n");
        sb.append("390;;cadastrarLogica;;176->183;;605 a 1305$$\n");
        sb.append("390;;cadastrarLogica;;183->190;;685 a 1360$$\n");
        sb.append("390;;cadastrarLogica;;190->197;;770 a 1435$$\n");
        sb.append("390;;cadastrarLogica;;197->204;;860 a 1550$$\n");
        sb.append("390;;cadastrarLogica;;204->211;;960 a 1690$$\n");
        sb.append("390;;cadastrarLogica;;211->218;;1060 a 1840$$\n");
        sb.append("390;;cadastrarLogica;;218->225;;1170 a 2030$$\n");
        sb.append("390;;cadastrarLogica;;225->232;;1290 a 2280$$\n");
        sb.append("390;;cadastrarLogica;;232->239;;1440 a 2600$$\n");
        sb.append("390;;cadastrarLogica;;239->246;;1600 a 2940$$\n");
        sb.append("390;;cadastrarLogica;;246->253;;1800 a 3200$$\n");
        sb.append("390;;cadastrarLogica;;253->260;;2050 a 3390$$\n");
        sb.append("390;;cadastrarLogica;;260->267;;2260 a 3520$$\n");
        sb.append("390;;cadastrarLogica;;267->274;;2430 a 3640$$\n");
        sb.append("390;;cadastrarLogica;;274->281;;2550 a 3735$$\n");
        sb.append("390;;cadastrarLogica;;281->288;;2690 a 3870$$\n");
        sb.append("390;;cadastrarLogica;;288->295;;2720 a 3890$$\n");
        sb.append("390;;cadastrarLogica;;295->600;;$$\n");

        // </editor-fold>
    }

    private static void preencherRef5 ()
    {
        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("436;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("424;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("436;;cadastrarLogica;;0->78;;$$\n");
        sb.append("436;;cadastrarLogica;;78->85;;13 a 22$$\n");
        sb.append("436;;cadastrarLogica;;85->92;;16 a 25$$\n");
        sb.append("436;;cadastrarLogica;;92->99;;20 a 29$$\n");
        sb.append("436;;cadastrarLogica;;99->106;;23 a 32$$\n");
        sb.append("436;;cadastrarLogica;;106->113;;27 a 36$$\n");
        sb.append("436;;cadastrarLogica;;113->120;;30 a 39$$\n");
        sb.append("436;;cadastrarLogica;;120->127;;34 a 43$$\n");
        sb.append("436;;cadastrarLogica;;127->134;;37 a 46$$\n");
        sb.append("436;;cadastrarLogica;;134->141;;40 a 49$$\n");
        sb.append("436;;cadastrarLogica;;141->148;;44 a 53$$\n");
        sb.append("436;;cadastrarLogica;;148->155;;47 a 56$$\n");
        sb.append("436;;cadastrarLogica;;155->162;;50 a 59$$\n");
        sb.append("436;;cadastrarLogica;;162->169;;53 a 62$$\n");
        sb.append("436;;cadastrarLogica;;169->176;;56 a 65$$\n");
        sb.append("436;;cadastrarLogica;;176->183;;59 a 68$$\n");
        sb.append("436;;cadastrarLogica;;183->190;;62 a 71$$\n");
        sb.append("436;;cadastrarLogica;;190->197;;65 a 74$$\n");
        sb.append("436;;cadastrarLogica;;197->204;;68 a 77$$\n");
        sb.append("436;;cadastrarLogica;;204->211;;70 a 79$$\n");
        sb.append("436;;cadastrarLogica;;211->218;;73 a 82$$\n");
        sb.append("436;;cadastrarLogica;;218->225;;75 a 84$$\n");
        sb.append("436;;cadastrarLogica;;225->232;;77 a 86$$\n");
        sb.append("436;;cadastrarLogica;;232->239;;79 a 88$$\n");
        sb.append("436;;cadastrarLogica;;239->246;;81 a 90$$\n");
        sb.append("436;;cadastrarLogica;;246->253;;83 a 92$$\n");
        sb.append("436;;cadastrarLogica;;253->260;;84 a 93$$\n");
        sb.append("436;;cadastrarLogica;;260->267;;86 a 95$$\n");
        sb.append("436;;cadastrarLogica;;267->274;;87 a 96$$\n");
        sb.append("436;;cadastrarLogica;;274->281;;88 a 97$$\n");
        sb.append("436;;cadastrarLogica;;281->288;;89 a 98$$\n");
        sb.append("436;;cadastrarLogica;;288->295;;89 a 98$$\n");
        sb.append("436;;cadastrarLogica;;295->600;;90 a 99$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="IC">

//        sb.append("427;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CA">

        sb.append("444;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("432;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("444;;cadastrarLogica;;0->78;;$$\n");
        sb.append("444;;cadastrarLogica;;78->85;;$$\n");
        sb.append("444;;cadastrarLogica;;85->92;;$$\n");
        sb.append("444;;cadastrarLogica;;92->99;;$$\n");
        sb.append("444;;cadastrarLogica;;99->106;;67 a 79$$\n");
        sb.append("444;;cadastrarLogica;;106->113;;79 a 93$$\n");
        sb.append("444;;cadastrarLogica;;113->120;;91 a 107$$\n");
        sb.append("444;;cadastrarLogica;;120->127;;103 a 121$$\n");
        sb.append("444;;cadastrarLogica;;127->134;;115 a 135$$\n");
        sb.append("444;;cadastrarLogica;;134->141;;126 a 148$$\n");
        sb.append("444;;cadastrarLogica;;141->148;;138 a 163$$\n");
        sb.append("444;;cadastrarLogica;;148->155;;149 a 176$$\n");
        sb.append("444;;cadastrarLogica;;155->162;;160 a 188$$\n");
        sb.append("444;;cadastrarLogica;;162->169;;170 a 200$$\n");
        sb.append("444;;cadastrarLogica;;169->176;;181 a 213$$\n");
        sb.append("444;;cadastrarLogica;;176->183;;191 a 225$$\n");
        sb.append("444;;cadastrarLogica;;183->190;;201 a 237$$\n");
        sb.append("444;;cadastrarLogica;;190->197;;211 a 249$$\n");
        sb.append("444;;cadastrarLogica;;197->204;;220 a 260$$\n");
        sb.append("444;;cadastrarLogica;;204->211;;230 a 272$$\n");
        sb.append("444;;cadastrarLogica;;211->218;;239 a 283$$\n");
        sb.append("444;;cadastrarLogica;;218->225;;249 a 294$$\n");
        sb.append("444;;cadastrarLogica;;225->232;;258 a 304$$\n");
        sb.append("444;;cadastrarLogica;;232->239;;267 a 315$$\n");
        sb.append("444;;cadastrarLogica;;239->246;;275 a 325$$\n");
        sb.append("444;;cadastrarLogica;;246->253;;283 a 335$$\n");
        sb.append("444;;cadastrarLogica;;253->260;;292 a 344$$\n");
        sb.append("444;;cadastrarLogica;;260->267;;300 a 354$$\n");
        sb.append("444;;cadastrarLogica;;267->274;;308 a 364$$\n");
        sb.append("444;;cadastrarLogica;;274->281;;316 a 373$$\n");
        sb.append("444;;cadastrarLogica;;281->288;;324 a 382$$\n");
        sb.append("444;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CC">

        sb.append("447;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("435;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("447;;cadastrarLogica;;0->78;;$$\n");
        sb.append("447;;cadastrarLogica;;78->85;;$$\n");
        sb.append("447;;cadastrarLogica;;85->92;;51 a 89$$\n");
        sb.append("447;;cadastrarLogica;;92->99;;65 a 103$$\n");
        sb.append("447;;cadastrarLogica;;99->106;;79 a 117$$\n");
        sb.append("447;;cadastrarLogica;;106->113;;92 a 130$$\n");
        sb.append("447;;cadastrarLogica;;113->120;;105 a 43$$\n");
        sb.append("447;;cadastrarLogica;;120->127;;118 a 156$$\n");
        sb.append("447;;cadastrarLogica;;127->134;;131 a 169$$\n");
        sb.append("447;;cadastrarLogica;;134->141;;144 a 182$$\n");
        sb.append("447;;cadastrarLogica;;141->148;;156 a 194$$\n");
        sb.append("447;;cadastrarLogica;;148->155;;168 a 206$$\n");
        sb.append("447;;cadastrarLogica;;155->162;;180 a 218$$\n");
        sb.append("447;;cadastrarLogica;;162->169;;191 a 229$$\n");
        sb.append("447;;cadastrarLogica;;169->176;;202 a 240$$\n");
        sb.append("447;;cadastrarLogica;;176->183;;213 a 251$$\n");
        sb.append("447;;cadastrarLogica;;183->190;;223 a 261$$\n");
        sb.append("447;;cadastrarLogica;;190->197;;233 a 271$$\n");
        sb.append("447;;cadastrarLogica;;197->204;;243 a 281$$\n");
        sb.append("447;;cadastrarLogica;;204->211;;252 a 290$$\n");
        sb.append("447;;cadastrarLogica;;211->218;;261 a 299$$\n");
        sb.append("447;;cadastrarLogica;;218->225;;270 a 308$$\n");
        sb.append("447;;cadastrarLogica;;225->232;;278 a 316$$\n");
        sb.append("447;;cadastrarLogica;;232->239;;285 a 323$$\n");
        sb.append("447;;cadastrarLogica;;239->246;;293 a 331$$\n");
        sb.append("447;;cadastrarLogica;;246->253;;299 a 337$$\n");
        sb.append("447;;cadastrarLogica;;253->260;;306 a 344$$\n");
        sb.append("447;;cadastrarLogica;;260->267;;311 a 349$$\n");
        sb.append("447;;cadastrarLogica;;267->274;;319 a 355$$\n");
        sb.append("447;;cadastrarLogica;;274->281;;322 a 360$$\n");
        sb.append("447;;cadastrarLogica;;281->288;;326 a 364$$\n");
        sb.append("447;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CC / CA">

        sb.append("450;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("438;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("450;;cadastrarLogica;;0->78;;$$\n");
        sb.append("450;;cadastrarLogica;;78->85;;$$\n");
        sb.append("450;;cadastrarLogica;;85->92;;1,12 a 1,31$$\n");
        sb.append("450;;cadastrarLogica;;92->99;;1,11 a 1,30$$\n");
        sb.append("450;;cadastrarLogica;;99->106;;1,11 a 1,30$$\n");
        sb.append("450;;cadastrarLogica;;106->113;;1,10 a 1,29$$\n");
        sb.append("450;;cadastrarLogica;;113->120;;1,09 a 1,28$$\n");
        sb.append("450;;cadastrarLogica;;120->127;;1,08 a 1,27$$\n");
        sb.append("450;;cadastrarLogica;;127->134;;1,07 a 1,26$$\n");
        sb.append("450;;cadastrarLogica;;134->141;;1,06 a 1,25$$\n");
        sb.append("450;;cadastrarLogica;;141->148;;1,06 a 1,24$$\n");
        sb.append("450;;cadastrarLogica;;148->155;;1,05 a 1,24$$\n");
        sb.append("450;;cadastrarLogica;;155->162;;1,04 a 1,23$$\n");
        sb.append("450;;cadastrarLogica;;162->169;;1,03 a 1,22$$\n");
        sb.append("450;;cadastrarLogica;;169->176;;1,02 a 1,21$$\n");
        sb.append("450;;cadastrarLogica;;176->183;;1,01 a 1,20$$\n");
        sb.append("450;;cadastrarLogica;;183->190;;1,00 a 1,19$$\n");
        sb.append("450;;cadastrarLogica;;190->197;;1,00 a 1,18$$\n");
        sb.append("450;;cadastrarLogica;;197->204;;0,99 a 1,18$$\n");
        sb.append("450;;cadastrarLogica;;204->211;;0,98 a 1,17$$\n");
        sb.append("450;;cadastrarLogica;;211->218;;0,97 a 1,16$$\n");
        sb.append("450;;cadastrarLogica;;218->225;;0,96 a 1,15$$\n");
        sb.append("450;;cadastrarLogica;;225->232;;0,95 a 1,14$$\n");
        sb.append("450;;cadastrarLogica;;232->239;;0,95 a 1,13$$\n");
        sb.append("450;;cadastrarLogica;;239->246;;0,94 a 1,13$$\n");
        sb.append("450;;cadastrarLogica;;246->253;;0,93 a 1,12$$\n");
        sb.append("450;;cadastrarLogica;;253->260;;0,92 a 1,11$$\n");
        sb.append("450;;cadastrarLogica;;260->267;;0,91 a 1,10$$\n");
        sb.append("450;;cadastrarLogica;;267->274;;0,89 a 1,09$$\n");
        sb.append("450;;cadastrarLogica;;274->281;;0,89 a 1,09$$\n");
        sb.append("450;;cadastrarLogica;;281->288;;0,89 a 1,08$$\n");
        sb.append("450;;cadastrarLogica;;288->295;;$$\n");
        sb.append("450;;cadastrarLogica;;295->302;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CF">

        sb.append("453;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("441;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("453;;cadastrarLogica;;0->78;;$$\n");
        sb.append("453;;cadastrarLogica;;78->85;;$$\n");
        sb.append("453;;cadastrarLogica;;85->92;;2 a 14$$\n");
        sb.append("453;;cadastrarLogica;;92->99;;5 a 17$$\n");
        sb.append("453;;cadastrarLogica;;99->106;;9 a 21$$\n");
        sb.append("453;;cadastrarLogica;;106->113;;12 a 24$$\n");
        sb.append("453;;cadastrarLogica;;113->120;;15 a 27$$\n");
        sb.append("453;;cadastrarLogica;;120->127;;18 a 30$$\n");
        sb.append("453;;cadastrarLogica;;127->134;;21 a 33$$\n");
        sb.append("453;;cadastrarLogica;;134->141;;23 a 36$$\n");
        sb.append("453;;cadastrarLogica;;141->148;;27 a 39$$\n");
        sb.append("453;;cadastrarLogica;;148->155;;30 a 42$$\n");
        sb.append("453;;cadastrarLogica;;155->162;;33 a 45$$\n");
        sb.append("453;;cadastrarLogica;;162->169;;36 a 48$$\n");
        sb.append("453;;cadastrarLogica;;169->176;;38 a 50$$\n");
        sb.append("453;;cadastrarLogica;;176->183;;41 a 53$$\n");
        sb.append("453;;cadastrarLogica;;183->190;;43 a 55$$\n");
        sb.append("453;;cadastrarLogica;;190->197;;46 a 58$$\n");
        sb.append("453;;cadastrarLogica;;197->204;;48 a 60$$\n");
        sb.append("453;;cadastrarLogica;;204->211;;50 a 62$$\n");
        sb.append("453;;cadastrarLogica;;211->218;;52 a 64$$\n");
        sb.append("453;;cadastrarLogica;;218->225;;55 a 67$$\n");
        sb.append("453;;cadastrarLogica;;225->232;;57 a 69$$\n");
        sb.append("453;;cadastrarLogica;;232->239;;59 a 71$$\n");
        sb.append("453;;cadastrarLogica;;239->246;;60 a 72$$\n");
        sb.append("453;;cadastrarLogica;;246->253;;62 a 74$$\n");
        sb.append("453;;cadastrarLogica;;253->260;;64 a 76$$\n");
        sb.append("453;;cadastrarLogica;;260->267;;66 a 78$$\n");
        sb.append("453;;cadastrarLogica;;267->274;;67 a 79$$\n");
        sb.append("453;;cadastrarLogica;;274->281;;69 a 81$$\n");
        sb.append("453;;cadastrarLogica;;281->288;;70 a 82$$\n");
        sb.append("453;;cadastrarLogica;;288->295;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CF / CA">

//        sb.append("444;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C Umero">

        sb.append("459;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("447;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("459;;cadastrarLogica;;0->78;;$$\n");
        sb.append("459;;cadastrarLogica;;78->85;;$$\n");
        sb.append("459;;cadastrarLogica;;85->92;;4 a 13$$\n");
        sb.append("459;;cadastrarLogica;;92->99;;7 a 15$$\n");
        sb.append("459;;cadastrarLogica;;99->106;;10 a 18$$\n");
        sb.append("459;;cadastrarLogica;;106->113;;13 a 21$$\n");
        sb.append("459;;cadastrarLogica;;113->120;;16 a 24$$\n");
        sb.append("459;;cadastrarLogica;;120->127;;18 a 27$$\n");
        sb.append("459;;cadastrarLogica;;127->134;;21 a 29$$\n");
        sb.append("459;;cadastrarLogica;;134->141;;24 a 32$$\n");
        sb.append("459;;cadastrarLogica;;141->148;;26 a 34$$\n");
        sb.append("459;;cadastrarLogica;;148->155;;29 a 37$$\n");
        sb.append("459;;cadastrarLogica;;155->162;;31 a 39$$\n");
        sb.append("459;;cadastrarLogica;;162->169;;33 a 42$$\n");
        sb.append("459;;cadastrarLogica;;169->176;;36 a 44$$\n");
        sb.append("459;;cadastrarLogica;;176->183;;38 a 46$$\n");
        sb.append("459;;cadastrarLogica;;183->190;;40 a 48$$\n");
        sb.append("459;;cadastrarLogica;;190->197;;42 a 50$$\n");
        sb.append("459;;cadastrarLogica;;197->204;;44 a 52$$\n");
        sb.append("459;;cadastrarLogica;;204->211;;46 a 54$$\n");
        sb.append("459;;cadastrarLogica;;211->218;;47 a 56$$\n");
        sb.append("459;;cadastrarLogica;;218->225;;49 a 57$$\n");
        sb.append("459;;cadastrarLogica;;225->232;;51 a 59$$\n");
        sb.append("459;;cadastrarLogica;;232->239;;52 a 60$$\n");
        sb.append("459;;cadastrarLogica;;239->246;;54 a 62$$\n");
        sb.append("459;;cadastrarLogica;;246->253;;55 a 63$$\n");
        sb.append("459;;cadastrarLogica;;253->260;;56 a 65$$\n");
        sb.append("459;;cadastrarLogica;;260->267;;58 a 66$$\n");
        sb.append("459;;cadastrarLogica;;267->274;;59 a 67$$\n");
        sb.append("459;;cadastrarLogica;;274->281;;61 a 69$$\n");
        sb.append("459;;cadastrarLogica;;281->288;;62 a 70$$\n");
        sb.append("459;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C Ulna">

        sb.append("462;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("450;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("462;;cadastrarLogica;;0->78;;$$\n");
        sb.append("462;;cadastrarLogica;;78->85;;$$\n");
        sb.append("462;;cadastrarLogica;;85->92;;3 a 11$$\n");
        sb.append("462;;cadastrarLogica;;92->99;;5 a 14$$\n");
        sb.append("462;;cadastrarLogica;;99->106;;8 a 17$$\n");
        sb.append("462;;cadastrarLogica;;106->113;;11 a 20$$\n");
        sb.append("462;;cadastrarLogica;;113->120;;14 a 22$$\n");
        sb.append("462;;cadastrarLogica;;120->127;;16 a 25$$\n");
        sb.append("462;;cadastrarLogica;;127->134;;19 a 28$$\n");
        sb.append("462;;cadastrarLogica;;134->141;;22 a 30$$\n");
        sb.append("462;;cadastrarLogica;;141->148;;24 a 33$$\n");
        sb.append("462;;cadastrarLogica;;148->155;;26 a 35$$\n");
        sb.append("462;;cadastrarLogica;;155->162;;29 a 37$$\n");
        sb.append("462;;cadastrarLogica;;162->169;;31 a 39$$\n");
        sb.append("462;;cadastrarLogica;;169->176;;33 a 42$$\n");
        sb.append("462;;cadastrarLogica;;176->183;;35 a 44$$\n");
        sb.append("462;;cadastrarLogica;;183->190;;37 a 46$$\n");
        sb.append("462;;cadastrarLogica;;190->197;;39 a 47$$\n");
        sb.append("462;;cadastrarLogica;;197->204;;41 a 49$$\n");
        sb.append("462;;cadastrarLogica;;204->211;;43 a 51$$\n");
        sb.append("462;;cadastrarLogica;;211->218;;44 a 53$$\n");
        sb.append("462;;cadastrarLogica;;218->225;;46 a 54$$\n");
        sb.append("462;;cadastrarLogica;;225->232;;47 a 56$$\n");
        sb.append("462;;cadastrarLogica;;232->239;;49 a 57$$\n");
        sb.append("462;;cadastrarLogica;;239->246;;50 a 59$$\n");
        sb.append("462;;cadastrarLogica;;246->253;;52 a 60$$\n");
        sb.append("462;;cadastrarLogica;;253->260;;53 a 61$$\n");
        sb.append("462;;cadastrarLogica;;260->267;;54 a 63$$\n");
        sb.append("462;;cadastrarLogica;;267->274;;55 a 64$$\n");
        sb.append("462;;cadastrarLogica;;274->281;;56 a 65$$\n");
        sb.append("462;;cadastrarLogica;;281->288;;57 a 66$$\n");
        sb.append("462;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C tibia">

        sb.append("465;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("453;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("465;;cadastrarLogica;;0->78;;$$\n");
        sb.append("465;;cadastrarLogica;;78->85;;$$\n");
        sb.append("465;;cadastrarLogica;;85->92;;3 a 12$$\n");
        sb.append("465;;cadastrarLogica;;92->99;;5 a 14$$\n");
        sb.append("465;;cadastrarLogica;;99->106;;8 a 16$$\n");
        sb.append("465;;cadastrarLogica;;106->113;;10 a 19$$\n");
        sb.append("465;;cadastrarLogica;;113->120;;13 a 21$$\n");
        sb.append("465;;cadastrarLogica;;120->127;;15 a 24$$\n");
        sb.append("465;;cadastrarLogica;;127->134;;18 a 27$$\n");
        sb.append("465;;cadastrarLogica;;134->141;;21 a 29$$\n");
        sb.append("465;;cadastrarLogica;;141->148;;23 a 32$$\n");
        sb.append("465;;cadastrarLogica;;148->155;;26 a 34$$\n");
        sb.append("465;;cadastrarLogica;;155->162;;28 a 37$$\n");
        sb.append("465;;cadastrarLogica;;162->169;;31 a 39$$\n");
        sb.append("465;;cadastrarLogica;;169->176;;33 a 42$$\n");
        sb.append("465;;cadastrarLogica;;176->183;;35 a 44$$\n");
        sb.append("465;;cadastrarLogica;;183->190;;37 a 46$$\n");
        sb.append("465;;cadastrarLogica;;190->197;;40 a 48$$\n");
        sb.append("465;;cadastrarLogica;;197->204;;42 a 50$$\n");
        sb.append("465;;cadastrarLogica;;204->211;;44 a 52$$\n");
        sb.append("465;;cadastrarLogica;;211->218;;46 a 54$$\n");
        sb.append("465;;cadastrarLogica;;218->225;;47 a 56$$\n");
        sb.append("465;;cadastrarLogica;;225->232;;49 a 58$$\n");
        sb.append("465;;cadastrarLogica;;232->239;;51 a 60$$\n");
        sb.append("465;;cadastrarLogica;;239->246;;53 a 61$$\n");
        sb.append("465;;cadastrarLogica;;246->253;;54 a 63$$\n");
        sb.append("465;;cadastrarLogica;;253->260;;56 a 64$$\n");
        sb.append("465;;cadastrarLogica;;260->267;;57 a 66$$\n");
        sb.append("465;;cadastrarLogica;;267->274;;59 a 67$$\n");
        sb.append("465;;cadastrarLogica;;274->281;;60 a 69$$\n");
        sb.append("465;;cadastrarLogica;;281->288;;61 a 70$$\n");
        sb.append("465;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="PFP">

        sb.append("468;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("456;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("468;;cadastrarLogica;;0->78;;$$\n");
        sb.append("468;;cadastrarLogica;;78->85;;$$\n");
        sb.append("468;;cadastrarLogica;;85->92;;$$\n");
        sb.append("468;;cadastrarLogica;;92->99;;$$\n");
        sb.append("468;;cadastrarLogica;;99->106;;$$\n");
        sb.append("468;;cadastrarLogica;;106->113;;$$\n");
        sb.append("468;;cadastrarLogica;;113->120;;$$\n");
        sb.append("468;;cadastrarLogica;;120->127;;$$\n");
        sb.append("468;;cadastrarLogica;;127->134;;$$\n");
        sb.append("468;;cadastrarLogica;;134->141;;$$\n");
        sb.append("468;;cadastrarLogica;;141->148;;$$\n");
        sb.append("468;;cadastrarLogica;;148->155;;$$\n");
        sb.append("468;;cadastrarLogica;;155->162;;$$\n");
        sb.append("468;;cadastrarLogica;;162->169;;$$\n");
        sb.append("468;;cadastrarLogica;;169->176;;530 a 1260$$\n");
        sb.append("468;;cadastrarLogica;;176->183;;605 a 1305$$\n");
        sb.append("468;;cadastrarLogica;;183->190;;685 a 1360$$\n");
        sb.append("468;;cadastrarLogica;;190->197;;770 a 1435$$\n");
        sb.append("468;;cadastrarLogica;;197->204;;860 a 1550$$\n");
        sb.append("468;;cadastrarLogica;;204->211;;960 a 1690$$\n");
        sb.append("468;;cadastrarLogica;;211->218;;1060 a 1840$$\n");
        sb.append("468;;cadastrarLogica;;218->225;;1170 a 2030$$\n");
        sb.append("468;;cadastrarLogica;;225->232;;1290 a 2280$$\n");
        sb.append("468;;cadastrarLogica;;232->239;;1440 a 2600$$\n");
        sb.append("468;;cadastrarLogica;;239->246;;1600 a 2940$$\n");
        sb.append("468;;cadastrarLogica;;246->253;;1800 a 3200$$\n");
        sb.append("468;;cadastrarLogica;;253->260;;2050 a 3390$$\n");
        sb.append("468;;cadastrarLogica;;260->267;;2260 a 3520$$\n");
        sb.append("468;;cadastrarLogica;;267->274;;2430 a 3640$$\n");
        sb.append("468;;cadastrarLogica;;274->281;;2550 a 3735$$\n");
        sb.append("468;;cadastrarLogica;;281->288;;2690 a 3870$$\n");
        sb.append("468;;cadastrarLogica;;288->295;;2720 a 3890$$\n");
        sb.append("468;;cadastrarLogica;;295->600;;$$\n");

        // </editor-fold>
    }

    private static void preencherRef6 ()
    {
        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("514;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("500;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("514;;cadastrarLogica;;0->78;;$$\n");
        sb.append("514;;cadastrarLogica;;78->85;;13 a 22$$\n");
        sb.append("514;;cadastrarLogica;;85->92;;16 a 25$$\n");
        sb.append("514;;cadastrarLogica;;92->99;;20 a 29$$\n");
        sb.append("514;;cadastrarLogica;;99->106;;23 a 32$$\n");
        sb.append("514;;cadastrarLogica;;106->113;;27 a 36$$\n");
        sb.append("514;;cadastrarLogica;;113->120;;30 a 39$$\n");
        sb.append("514;;cadastrarLogica;;120->127;;34 a 43$$\n");
        sb.append("514;;cadastrarLogica;;127->134;;37 a 46$$\n");
        sb.append("514;;cadastrarLogica;;134->141;;40 a 49$$\n");
        sb.append("514;;cadastrarLogica;;141->148;;44 a 53$$\n");
        sb.append("514;;cadastrarLogica;;148->155;;47 a 56$$\n");
        sb.append("514;;cadastrarLogica;;155->162;;50 a 59$$\n");
        sb.append("514;;cadastrarLogica;;162->169;;53 a 62$$\n");
        sb.append("514;;cadastrarLogica;;169->176;;56 a 65$$\n");
        sb.append("514;;cadastrarLogica;;176->183;;59 a 68$$\n");
        sb.append("514;;cadastrarLogica;;183->190;;62 a 71$$\n");
        sb.append("514;;cadastrarLogica;;190->197;;65 a 74$$\n");
        sb.append("514;;cadastrarLogica;;197->204;;68 a 77$$\n");
        sb.append("514;;cadastrarLogica;;204->211;;70 a 79$$\n");
        sb.append("514;;cadastrarLogica;;211->218;;73 a 82$$\n");
        sb.append("514;;cadastrarLogica;;218->225;;75 a 84$$\n");
        sb.append("514;;cadastrarLogica;;225->232;;77 a 86$$\n");
        sb.append("514;;cadastrarLogica;;232->239;;79 a 88$$\n");
        sb.append("514;;cadastrarLogica;;239->246;;81 a 90$$\n");
        sb.append("514;;cadastrarLogica;;246->253;;83 a 92$$\n");
        sb.append("514;;cadastrarLogica;;253->260;;84 a 93$$\n");
        sb.append("514;;cadastrarLogica;;260->267;;86 a 95$$\n");
        sb.append("514;;cadastrarLogica;;267->274;;87 a 96$$\n");
        sb.append("514;;cadastrarLogica;;274->281;;88 a 97$$\n");
        sb.append("514;;cadastrarLogica;;281->288;;89 a 98$$\n");
        sb.append("514;;cadastrarLogica;;288->295;;89 a 98$$\n");
        sb.append("514;;cadastrarLogica;;295->600;;90 a 99$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="IC">

//        sb.append("503;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CA">

        sb.append("522;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("508;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("522;;cadastrarLogica;;0->78;;$$\n");
        sb.append("522;;cadastrarLogica;;78->85;;$$\n");
        sb.append("522;;cadastrarLogica;;85->92;;$$\n");
        sb.append("522;;cadastrarLogica;;92->99;;$$\n");
        sb.append("522;;cadastrarLogica;;99->106;;67 a 79$$\n");
        sb.append("522;;cadastrarLogica;;106->113;;79 a 93$$\n");
        sb.append("522;;cadastrarLogica;;113->120;;91 a 107$$\n");
        sb.append("522;;cadastrarLogica;;120->127;;103 a 121$$\n");
        sb.append("522;;cadastrarLogica;;127->134;;115 a 135$$\n");
        sb.append("522;;cadastrarLogica;;134->141;;126 a 148$$\n");
        sb.append("522;;cadastrarLogica;;141->148;;138 a 163$$\n");
        sb.append("522;;cadastrarLogica;;148->155;;149 a 176$$\n");
        sb.append("522;;cadastrarLogica;;155->162;;160 a 188$$\n");
        sb.append("522;;cadastrarLogica;;162->169;;170 a 200$$\n");
        sb.append("522;;cadastrarLogica;;169->176;;181 a 213$$\n");
        sb.append("522;;cadastrarLogica;;176->183;;191 a 225$$\n");
        sb.append("522;;cadastrarLogica;;183->190;;201 a 237$$\n");
        sb.append("522;;cadastrarLogica;;190->197;;211 a 249$$\n");
        sb.append("522;;cadastrarLogica;;197->204;;220 a 260$$\n");
        sb.append("522;;cadastrarLogica;;204->211;;230 a 272$$\n");
        sb.append("522;;cadastrarLogica;;211->218;;239 a 283$$\n");
        sb.append("522;;cadastrarLogica;;218->225;;249 a 294$$\n");
        sb.append("522;;cadastrarLogica;;225->232;;258 a 304$$\n");
        sb.append("522;;cadastrarLogica;;232->239;;267 a 315$$\n");
        sb.append("522;;cadastrarLogica;;239->246;;275 a 325$$\n");
        sb.append("522;;cadastrarLogica;;246->253;;283 a 335$$\n");
        sb.append("522;;cadastrarLogica;;253->260;;292 a 344$$\n");
        sb.append("522;;cadastrarLogica;;260->267;;300 a 354$$\n");
        sb.append("522;;cadastrarLogica;;267->274;;308 a 364$$\n");
        sb.append("522;;cadastrarLogica;;274->281;;316 a 373$$\n");
        sb.append("522;;cadastrarLogica;;281->288;;324 a 382$$\n");
        sb.append("522;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CC">

        sb.append("525;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("511;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("525;;cadastrarLogica;;0->78;;$$\n");
        sb.append("525;;cadastrarLogica;;78->85;;$$\n");
        sb.append("525;;cadastrarLogica;;85->92;;51 a 89$$\n");
        sb.append("525;;cadastrarLogica;;92->99;;65 a 103$$\n");
        sb.append("525;;cadastrarLogica;;99->106;;79 a 117$$\n");
        sb.append("525;;cadastrarLogica;;106->113;;92 a 130$$\n");
        sb.append("525;;cadastrarLogica;;113->120;;105 a 43$$\n");
        sb.append("525;;cadastrarLogica;;120->127;;118 a 156$$\n");
        sb.append("525;;cadastrarLogica;;127->134;;131 a 169$$\n");
        sb.append("525;;cadastrarLogica;;134->141;;144 a 182$$\n");
        sb.append("525;;cadastrarLogica;;141->148;;156 a 194$$\n");
        sb.append("525;;cadastrarLogica;;148->155;;168 a 206$$\n");
        sb.append("525;;cadastrarLogica;;155->162;;180 a 218$$\n");
        sb.append("525;;cadastrarLogica;;162->169;;191 a 229$$\n");
        sb.append("525;;cadastrarLogica;;169->176;;202 a 240$$\n");
        sb.append("525;;cadastrarLogica;;176->183;;213 a 251$$\n");
        sb.append("525;;cadastrarLogica;;183->190;;223 a 261$$\n");
        sb.append("525;;cadastrarLogica;;190->197;;233 a 271$$\n");
        sb.append("525;;cadastrarLogica;;197->204;;243 a 281$$\n");
        sb.append("525;;cadastrarLogica;;204->211;;252 a 290$$\n");
        sb.append("525;;cadastrarLogica;;211->218;;261 a 299$$\n");
        sb.append("525;;cadastrarLogica;;218->225;;270 a 308$$\n");
        sb.append("525;;cadastrarLogica;;225->232;;278 a 316$$\n");
        sb.append("525;;cadastrarLogica;;232->239;;285 a 323$$\n");
        sb.append("525;;cadastrarLogica;;239->246;;293 a 331$$\n");
        sb.append("525;;cadastrarLogica;;246->253;;299 a 337$$\n");
        sb.append("525;;cadastrarLogica;;253->260;;306 a 344$$\n");
        sb.append("525;;cadastrarLogica;;260->267;;311 a 349$$\n");
        sb.append("525;;cadastrarLogica;;267->274;;319 a 355$$\n");
        sb.append("525;;cadastrarLogica;;274->281;;322 a 360$$\n");
        sb.append("525;;cadastrarLogica;;281->288;;326 a 364$$\n");
        sb.append("525;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CC / CA">

        sb.append("528;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("514;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("528;;cadastrarLogica;;0->78;;$$\n");
        sb.append("528;;cadastrarLogica;;78->85;;$$\n");
        sb.append("528;;cadastrarLogica;;85->92;;1,12 a 1,31$$\n");
        sb.append("528;;cadastrarLogica;;92->99;;1,11 a 1,30$$\n");
        sb.append("528;;cadastrarLogica;;99->106;;1,11 a 1,30$$\n");
        sb.append("528;;cadastrarLogica;;106->113;;1,10 a 1,29$$\n");
        sb.append("528;;cadastrarLogica;;113->120;;1,09 a 1,28$$\n");
        sb.append("528;;cadastrarLogica;;120->127;;1,08 a 1,27$$\n");
        sb.append("528;;cadastrarLogica;;127->134;;1,07 a 1,26$$\n");
        sb.append("528;;cadastrarLogica;;134->141;;1,06 a 1,25$$\n");
        sb.append("528;;cadastrarLogica;;141->148;;1,06 a 1,24$$\n");
        sb.append("528;;cadastrarLogica;;148->155;;1,05 a 1,24$$\n");
        sb.append("528;;cadastrarLogica;;155->162;;1,04 a 1,23$$\n");
        sb.append("528;;cadastrarLogica;;162->169;;1,03 a 1,22$$\n");
        sb.append("528;;cadastrarLogica;;169->176;;1,02 a 1,21$$\n");
        sb.append("528;;cadastrarLogica;;176->183;;1,01 a 1,20$$\n");
        sb.append("528;;cadastrarLogica;;183->190;;1,00 a 1,19$$\n");
        sb.append("528;;cadastrarLogica;;190->197;;1,00 a 1,18$$\n");
        sb.append("528;;cadastrarLogica;;197->204;;0,99 a 1,18$$\n");
        sb.append("528;;cadastrarLogica;;204->211;;0,98 a 1,17$$\n");
        sb.append("528;;cadastrarLogica;;211->218;;0,97 a 1,16$$\n");
        sb.append("528;;cadastrarLogica;;218->225;;0,96 a 1,15$$\n");
        sb.append("528;;cadastrarLogica;;225->232;;0,95 a 1,14$$\n");
        sb.append("528;;cadastrarLogica;;232->239;;0,95 a 1,13$$\n");
        sb.append("528;;cadastrarLogica;;239->246;;0,94 a 1,13$$\n");
        sb.append("528;;cadastrarLogica;;246->253;;0,93 a 1,12$$\n");
        sb.append("528;;cadastrarLogica;;253->260;;0,92 a 1,11$$\n");
        sb.append("528;;cadastrarLogica;;260->267;;0,91 a 1,10$$\n");
        sb.append("528;;cadastrarLogica;;267->274;;0,89 a 1,09$$\n");
        sb.append("528;;cadastrarLogica;;274->281;;0,89 a 1,09$$\n");
        sb.append("528;;cadastrarLogica;;281->288;;0,89 a 1,08$$\n");
        sb.append("528;;cadastrarLogica;;288->295;;$$\n");
        sb.append("528;;cadastrarLogica;;295->302;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CF">

        sb.append("531;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("517;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("531;;cadastrarLogica;;0->78;;$$\n");
        sb.append("531;;cadastrarLogica;;78->85;;$$\n");
        sb.append("531;;cadastrarLogica;;85->92;;2 a 14$$\n");
        sb.append("531;;cadastrarLogica;;92->99;;5 a 17$$\n");
        sb.append("531;;cadastrarLogica;;99->106;;9 a 21$$\n");
        sb.append("531;;cadastrarLogica;;106->113;;12 a 24$$\n");
        sb.append("531;;cadastrarLogica;;113->120;;15 a 27$$\n");
        sb.append("531;;cadastrarLogica;;120->127;;18 a 30$$\n");
        sb.append("531;;cadastrarLogica;;127->134;;21 a 33$$\n");
        sb.append("531;;cadastrarLogica;;134->141;;23 a 36$$\n");
        sb.append("531;;cadastrarLogica;;141->148;;27 a 39$$\n");
        sb.append("531;;cadastrarLogica;;148->155;;30 a 42$$\n");
        sb.append("531;;cadastrarLogica;;155->162;;33 a 45$$\n");
        sb.append("531;;cadastrarLogica;;162->169;;36 a 48$$\n");
        sb.append("531;;cadastrarLogica;;169->176;;38 a 50$$\n");
        sb.append("531;;cadastrarLogica;;176->183;;41 a 53$$\n");
        sb.append("531;;cadastrarLogica;;183->190;;43 a 55$$\n");
        sb.append("531;;cadastrarLogica;;190->197;;46 a 58$$\n");
        sb.append("531;;cadastrarLogica;;197->204;;48 a 60$$\n");
        sb.append("531;;cadastrarLogica;;204->211;;50 a 62$$\n");
        sb.append("531;;cadastrarLogica;;211->218;;52 a 64$$\n");
        sb.append("531;;cadastrarLogica;;218->225;;55 a 67$$\n");
        sb.append("531;;cadastrarLogica;;225->232;;57 a 69$$\n");
        sb.append("531;;cadastrarLogica;;232->239;;59 a 71$$\n");
        sb.append("531;;cadastrarLogica;;239->246;;60 a 72$$\n");
        sb.append("531;;cadastrarLogica;;246->253;;62 a 74$$\n");
        sb.append("531;;cadastrarLogica;;253->260;;64 a 76$$\n");
        sb.append("531;;cadastrarLogica;;260->267;;66 a 78$$\n");
        sb.append("531;;cadastrarLogica;;267->274;;67 a 79$$\n");
        sb.append("531;;cadastrarLogica;;274->281;;69 a 81$$\n");
        sb.append("531;;cadastrarLogica;;281->288;;70 a 82$$\n");
        sb.append("531;;cadastrarLogica;;288->295;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="CF / CA">

//        sb.append("520;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C Umero">

        sb.append("537;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("523;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("537;;cadastrarLogica;;0->78;;$$\n");
        sb.append("537;;cadastrarLogica;;78->85;;$$\n");
        sb.append("537;;cadastrarLogica;;85->92;;4 a 13$$\n");
        sb.append("537;;cadastrarLogica;;92->99;;7 a 15$$\n");
        sb.append("537;;cadastrarLogica;;99->106;;10 a 18$$\n");
        sb.append("537;;cadastrarLogica;;106->113;;13 a 21$$\n");
        sb.append("537;;cadastrarLogica;;113->120;;16 a 24$$\n");
        sb.append("537;;cadastrarLogica;;120->127;;18 a 27$$\n");
        sb.append("537;;cadastrarLogica;;127->134;;21 a 29$$\n");
        sb.append("537;;cadastrarLogica;;134->141;;24 a 32$$\n");
        sb.append("537;;cadastrarLogica;;141->148;;26 a 34$$\n");
        sb.append("537;;cadastrarLogica;;148->155;;29 a 37$$\n");
        sb.append("537;;cadastrarLogica;;155->162;;31 a 39$$\n");
        sb.append("537;;cadastrarLogica;;162->169;;33 a 42$$\n");
        sb.append("537;;cadastrarLogica;;169->176;;36 a 44$$\n");
        sb.append("537;;cadastrarLogica;;176->183;;38 a 46$$\n");
        sb.append("537;;cadastrarLogica;;183->190;;40 a 48$$\n");
        sb.append("537;;cadastrarLogica;;190->197;;42 a 50$$\n");
        sb.append("537;;cadastrarLogica;;197->204;;44 a 52$$\n");
        sb.append("537;;cadastrarLogica;;204->211;;46 a 54$$\n");
        sb.append("537;;cadastrarLogica;;211->218;;47 a 56$$\n");
        sb.append("537;;cadastrarLogica;;218->225;;49 a 57$$\n");
        sb.append("537;;cadastrarLogica;;225->232;;51 a 59$$\n");
        sb.append("537;;cadastrarLogica;;232->239;;52 a 60$$\n");
        sb.append("537;;cadastrarLogica;;239->246;;54 a 62$$\n");
        sb.append("537;;cadastrarLogica;;246->253;;55 a 63$$\n");
        sb.append("537;;cadastrarLogica;;253->260;;56 a 65$$\n");
        sb.append("537;;cadastrarLogica;;260->267;;58 a 66$$\n");
        sb.append("537;;cadastrarLogica;;267->274;;59 a 67$$\n");
        sb.append("537;;cadastrarLogica;;274->281;;61 a 69$$\n");
        sb.append("537;;cadastrarLogica;;281->288;;62 a 70$$\n");
        sb.append("537;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C Ulna">

        sb.append("540;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("526;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("540;;cadastrarLogica;;0->78;;$$\n");
        sb.append("540;;cadastrarLogica;;78->85;;$$\n");
        sb.append("540;;cadastrarLogica;;85->92;;3 a 11$$\n");
        sb.append("540;;cadastrarLogica;;92->99;;5 a 14$$\n");
        sb.append("540;;cadastrarLogica;;99->106;;8 a 17$$\n");
        sb.append("540;;cadastrarLogica;;106->113;;11 a 20$$\n");
        sb.append("540;;cadastrarLogica;;113->120;;14 a 22$$\n");
        sb.append("540;;cadastrarLogica;;120->127;;16 a 25$$\n");
        sb.append("540;;cadastrarLogica;;127->134;;19 a 28$$\n");
        sb.append("540;;cadastrarLogica;;134->141;;22 a 30$$\n");
        sb.append("540;;cadastrarLogica;;141->148;;24 a 33$$\n");
        sb.append("540;;cadastrarLogica;;148->155;;26 a 35$$\n");
        sb.append("540;;cadastrarLogica;;155->162;;29 a 37$$\n");
        sb.append("540;;cadastrarLogica;;162->169;;31 a 39$$\n");
        sb.append("540;;cadastrarLogica;;169->176;;33 a 42$$\n");
        sb.append("540;;cadastrarLogica;;176->183;;35 a 44$$\n");
        sb.append("540;;cadastrarLogica;;183->190;;37 a 46$$\n");
        sb.append("540;;cadastrarLogica;;190->197;;39 a 47$$\n");
        sb.append("540;;cadastrarLogica;;197->204;;41 a 49$$\n");
        sb.append("540;;cadastrarLogica;;204->211;;43 a 51$$\n");
        sb.append("540;;cadastrarLogica;;211->218;;44 a 53$$\n");
        sb.append("540;;cadastrarLogica;;218->225;;46 a 54$$\n");
        sb.append("540;;cadastrarLogica;;225->232;;47 a 56$$\n");
        sb.append("540;;cadastrarLogica;;232->239;;49 a 57$$\n");
        sb.append("540;;cadastrarLogica;;239->246;;50 a 59$$\n");
        sb.append("540;;cadastrarLogica;;246->253;;52 a 60$$\n");
        sb.append("540;;cadastrarLogica;;253->260;;53 a 61$$\n");
        sb.append("540;;cadastrarLogica;;260->267;;54 a 63$$\n");
        sb.append("540;;cadastrarLogica;;267->274;;55 a 64$$\n");
        sb.append("540;;cadastrarLogica;;274->281;;56 a 65$$\n");
        sb.append("540;;cadastrarLogica;;281->288;;57 a 66$$\n");
        sb.append("540;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C tibia">

        sb.append("543;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("529;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("543;;cadastrarLogica;;0->78;;$$\n");
        sb.append("543;;cadastrarLogica;;78->85;;$$\n");
        sb.append("543;;cadastrarLogica;;85->92;;3 a 12$$\n");
        sb.append("543;;cadastrarLogica;;92->99;;5 a 14$$\n");
        sb.append("543;;cadastrarLogica;;99->106;;8 a 16$$\n");
        sb.append("543;;cadastrarLogica;;106->113;;10 a 19$$\n");
        sb.append("543;;cadastrarLogica;;113->120;;13 a 21$$\n");
        sb.append("543;;cadastrarLogica;;120->127;;15 a 24$$\n");
        sb.append("543;;cadastrarLogica;;127->134;;18 a 27$$\n");
        sb.append("543;;cadastrarLogica;;134->141;;21 a 29$$\n");
        sb.append("543;;cadastrarLogica;;141->148;;23 a 32$$\n");
        sb.append("543;;cadastrarLogica;;148->155;;26 a 34$$\n");
        sb.append("543;;cadastrarLogica;;155->162;;28 a 37$$\n");
        sb.append("543;;cadastrarLogica;;162->169;;31 a 39$$\n");
        sb.append("543;;cadastrarLogica;;169->176;;33 a 42$$\n");
        sb.append("543;;cadastrarLogica;;176->183;;35 a 44$$\n");
        sb.append("543;;cadastrarLogica;;183->190;;37 a 46$$\n");
        sb.append("543;;cadastrarLogica;;190->197;;40 a 48$$\n");
        sb.append("543;;cadastrarLogica;;197->204;;42 a 50$$\n");
        sb.append("543;;cadastrarLogica;;204->211;;44 a 52$$\n");
        sb.append("543;;cadastrarLogica;;211->218;;46 a 54$$\n");
        sb.append("543;;cadastrarLogica;;218->225;;47 a 56$$\n");
        sb.append("543;;cadastrarLogica;;225->232;;49 a 58$$\n");
        sb.append("543;;cadastrarLogica;;232->239;;51 a 60$$\n");
        sb.append("543;;cadastrarLogica;;239->246;;53 a 61$$\n");
        sb.append("543;;cadastrarLogica;;246->253;;54 a 63$$\n");
        sb.append("543;;cadastrarLogica;;253->260;;56 a 64$$\n");
        sb.append("543;;cadastrarLogica;;260->267;;57 a 66$$\n");
        sb.append("543;;cadastrarLogica;;267->274;;59 a 67$$\n");
        sb.append("543;;cadastrarLogica;;274->281;;60 a 69$$\n");
        sb.append("543;;cadastrarLogica;;281->288;;61 a 70$$\n");
        sb.append("543;;cadastrarLogica;;288->600;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="PFP">

        sb.append("546;;setCampos;;{$600CampoDoLaudo}$$\n");
//        sb.append("532;;vincularHabAoValorDoCampo;;$629CampoDoLaudo;;false;;{sim}$$\n");
        sb.append("546;;cadastrarLogica;;0->78;;$$\n");
        sb.append("546;;cadastrarLogica;;78->85;;$$\n");
        sb.append("546;;cadastrarLogica;;85->92;;$$\n");
        sb.append("546;;cadastrarLogica;;92->99;;$$\n");
        sb.append("546;;cadastrarLogica;;99->106;;$$\n");
        sb.append("546;;cadastrarLogica;;106->113;;$$\n");
        sb.append("546;;cadastrarLogica;;113->120;;$$\n");
        sb.append("546;;cadastrarLogica;;120->127;;$$\n");
        sb.append("546;;cadastrarLogica;;127->134;;$$\n");
        sb.append("546;;cadastrarLogica;;134->141;;$$\n");
        sb.append("546;;cadastrarLogica;;141->148;;$$\n");
        sb.append("546;;cadastrarLogica;;148->155;;$$\n");
        sb.append("546;;cadastrarLogica;;155->162;;$$\n");
        sb.append("546;;cadastrarLogica;;162->169;;$$\n");
        sb.append("546;;cadastrarLogica;;169->176;;530 a 1260$$\n");
        sb.append("546;;cadastrarLogica;;176->183;;605 a 1305$$\n");
        sb.append("546;;cadastrarLogica;;183->190;;685 a 1360$$\n");
        sb.append("546;;cadastrarLogica;;190->197;;770 a 1435$$\n");
        sb.append("546;;cadastrarLogica;;197->204;;860 a 1550$$\n");
        sb.append("546;;cadastrarLogica;;204->211;;960 a 1690$$\n");
        sb.append("546;;cadastrarLogica;;211->218;;1060 a 1840$$\n");
        sb.append("546;;cadastrarLogica;;218->225;;1170 a 2030$$\n");
        sb.append("546;;cadastrarLogica;;225->232;;1290 a 2280$$\n");
        sb.append("546;;cadastrarLogica;;232->239;;1440 a 2600$$\n");
        sb.append("546;;cadastrarLogica;;239->246;;1600 a 2940$$\n");
        sb.append("546;;cadastrarLogica;;246->253;;1800 a 3200$$\n");
        sb.append("546;;cadastrarLogica;;253->260;;2050 a 3390$$\n");
        sb.append("546;;cadastrarLogica;;260->267;;2260 a 3520$$\n");
        sb.append("546;;cadastrarLogica;;267->274;;2430 a 3640$$\n");
        sb.append("546;;cadastrarLogica;;274->281;;2550 a 3735$$\n");
        sb.append("546;;cadastrarLogica;;281->288;;2690 a 3870$$\n");
        sb.append("546;;cadastrarLogica;;288->295;;2720 a 3890$$\n");
        sb.append("546;;cadastrarLogica;;295->600;;$$\n");

        // </editor-fold>
    }

    private static void preencherIghFeto1 ()
    {

        // <editor-fold defaultstate="collapsed" desc="Fêmur">

        sb.append("601;;cadastrarLogica;;0,0->7,1;;<12,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;7,1->8,1;;12,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;8,1->9,1;;12,33 semanas$$\n");
        sb.append("601;;cadastrarLogica;;9,1->10,1;;12,67 semanas$$\n");
        sb.append("601;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("601;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("601;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("601;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("601;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("601;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("601;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;20,1->21,1;;16,33 semanas$$\n");
        sb.append("601;;cadastrarLogica;;21,1->22,1;;16,67 semanas$$\n");
        sb.append("601;;cadastrarLogica;;22,1->23,1;;17,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;23,1->24,1;;17,50 semanas$$\n");
        sb.append("601;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("601;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("601;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;28,1->29,1;;19,33 semanas$$\n");
        sb.append("601;;cadastrarLogica;;29,1->30,1;;19,67 semanas$$\n");
        sb.append("601;;cadastrarLogica;;30,1->31,1;;20,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;31,1->32,1;;20,33 semanas$$\n");
        sb.append("601;;cadastrarLogica;;32,1->33,1;;20,67 semanas$$\n");
        sb.append("601;;cadastrarLogica;;33,1->34,1;;21,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;34,1->35,1;;21,50 semanas$$\n");
        sb.append("601;;cadastrarLogica;;35,1->36,1;;22,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;36,1->37,1;;22,33 semanas$$\n");
        sb.append("601;;cadastrarLogica;;37,1->38,1;;22,67 semanas$$\n");
        sb.append("601;;cadastrarLogica;;38,1->39,1;;23,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;39,1->40,1;;23,33 semanas$$\n");
        sb.append("601;;cadastrarLogica;;40,1->41,1;;23,67 semanas$$\n");
        sb.append("601;;cadastrarLogica;;41,1->42,1;;24,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;42,1->43,1;;24,50 semanas$$\n");
        sb.append("601;;cadastrarLogica;;43,1->44,1;;25,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;44,1->45,1;;25,33 semanas$$\n");
        sb.append("601;;cadastrarLogica;;45,1->46,1;;25,67 semanas$$\n");
        sb.append("601;;cadastrarLogica;;46,1->47,1;;26,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;47,1->48,1;;26,50 semanas$$\n");
        sb.append("601;;cadastrarLogica;;48,1->49,1;;27,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;49,1->50,1;;27,33 semanas$$\n");
        sb.append("601;;cadastrarLogica;;50,1->51,1;;27,67 semanas$$\n");
        sb.append("601;;cadastrarLogica;;51,1->52,1;;28,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;52,1->53,1;;28,50 semanas$$\n");
        sb.append("601;;cadastrarLogica;;53,1->54,1;;29,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;54,1->55,1;;29,50 semanas$$\n");
        sb.append("601;;cadastrarLogica;;55,1->56,1;;30,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;56,1->57,1;;30,33 semanas$$\n");
        sb.append("601;;cadastrarLogica;;57,1->58,1;;30,67 semanas$$\n");
        sb.append("601;;cadastrarLogica;;58,1->59,1;;31,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;59,1->60,1;;31,50 semanas$$\n");
        sb.append("601;;cadastrarLogica;;60,1->61,1;;32,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;61,1->62,1;;32,50 semanas$$\n");
        sb.append("601;;cadastrarLogica;;62,1->63,1;;33,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;63,1->64,1;;33,50 semanas$$\n");
        sb.append("601;;cadastrarLogica;;64,1->65,1;;34,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;65,1->66,1;;34,50 semanas$$\n");
        sb.append("601;;cadastrarLogica;;66,1->67,1;;35,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;67,1->68,1;;36,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;68,1->69,1;;36,50 semanas$$\n");
        sb.append("601;;cadastrarLogica;;69,1->70,1;;37,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;70,1->71,1;;38,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;71,1->72,1;;38,50 semanas$$\n");
        sb.append("601;;cadastrarLogica;;72,1->73,1;;39,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;73,1->74,1;;40,00 semanas$$\n");
        sb.append("601;;cadastrarLogica;;74,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Úmero">

        sb.append("602;;cadastrarLogica;;0,0->8,1;;<12,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;8,1->9,1;;12,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;9,1->10,1;;12,50 semanas$$\n");
        sb.append("602;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("602;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("602;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("602;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("602;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("602;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("602;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;20,1->21,1;;16,50 semanas$$\n");
        sb.append("602;;cadastrarLogica;;21,1->22,1;;17,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;22,1->23,1;;17,33 semanas$$\n");
        sb.append("602;;cadastrarLogica;;23,1->24,1;;17,67 semanas$$\n");
        sb.append("602;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("602;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("602;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;28,1->29,1;;19,50 semanas$$\n");
        sb.append("602;;cadastrarLogica;;29,1->30,1;;20,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;30,1->31,1;;20,33 semanas$$\n");
        sb.append("602;;cadastrarLogica;;31,1->32,1;;20,67 semanas$$\n");
        sb.append("602;;cadastrarLogica;;32,1->33,1;;21,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;33,1->34,1;;21,50 semanas$$\n");
        sb.append("602;;cadastrarLogica;;34,1->35,1;;22,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;35,1->36,1;;22,33 semanas$$\n");
        sb.append("602;;cadastrarLogica;;36,1->37,1;;22,67 semanas$$\n");
        sb.append("602;;cadastrarLogica;;37,1->38,1;;23,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;38,1->39,1;;23,50 semanas$$\n");
        sb.append("602;;cadastrarLogica;;39,1->40,1;;24,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;40,1->41,1;;24,50 semanas$$\n");
        sb.append("602;;cadastrarLogica;;41,1->42,1;;25,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;42,1->43,1;;25,50 semanas$$\n");
        sb.append("602;;cadastrarLogica;;43,1->44,1;;26,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;44,1->45,1;;26,50 semanas$$\n");
        sb.append("602;;cadastrarLogica;;45,1->46,1;;27,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;46,1->47,1;;27,50 semanas$$\n");
        sb.append("602;;cadastrarLogica;;47,1->48,1;;28,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;48,1->49,1;;28,50 semanas$$\n");
        sb.append("602;;cadastrarLogica;;49,1->50,1;;29,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;50,1->51,1;;30,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;51,1->52,1;;30,50 semanas$$\n");
        sb.append("602;;cadastrarLogica;;52,1->53,1;;31,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;53,1->54,1;;31,50 semanas$$\n");
        sb.append("602;;cadastrarLogica;;54,1->55,1;;32,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;55,1->56,1;;33,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;56,1->57,1;;33,50 semanas$$\n");
        sb.append("602;;cadastrarLogica;;57,1->58,1;;34,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;58,1->59,1;;35,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;59,1->60,1;;35,50 semanas$$\n");
        sb.append("602;;cadastrarLogica;;60,1->61,1;;36,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;61,1->62,1;;37,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;63,1->64,1;;38,50 semanas$$\n");
        sb.append("602;;cadastrarLogica;;64,1->65,1;;39,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("602;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ulna">

        sb.append("603;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("603;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("603;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;10,1->11,1;;13,33 semanas$$\n");
        sb.append("603;;cadastrarLogica;;11,1->12,1;;13,67 semanas$$\n");
        sb.append("603;;cadastrarLogica;;12,1->13,1;;14,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;13,1->14,1;;14,50 semanas$$\n");
        sb.append("603;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;15,1->16,1;;15,33 semanas$$\n");
        sb.append("603;;cadastrarLogica;;16,1->17,1;;15,67 semanas$$\n");
        sb.append("603;;cadastrarLogica;;17,1->18,1;;16,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;18,1->19,1;;16,33 semanas$$\n");
        sb.append("603;;cadastrarLogica;;19,1->20,1;;16,67 semanas$$\n");
        sb.append("603;;cadastrarLogica;;20,1->21,1;;17,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;21,1->22,1;;17,50 semanas$$\n");
        sb.append("603;;cadastrarLogica;;22,1->23,1;;18,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;23,1->24,1;;18,33 semanas$$\n");
        sb.append("603;;cadastrarLogica;;24,1->25,1;;18,67 semanas$$\n");
        sb.append("603;;cadastrarLogica;;25,1->26,1;;19,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;26,1->27,1;;19,50 semanas$$\n");
        sb.append("603;;cadastrarLogica;;27,1->28,1;;20,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;28,1->29,1;;20,33 semanas$$\n");
        sb.append("603;;cadastrarLogica;;29,1->30,1;;20,67 semanas$$\n");
        sb.append("603;;cadastrarLogica;;30,1->31,1;;21,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;31,1->32,1;;21,50 semanas$$\n");
        sb.append("603;;cadastrarLogica;;32,1->33,1;;22,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;33,1->34,1;;22,50 semanas$$\n");
        sb.append("603;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("603;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;37,1->38,1;;24,50 semanas$$\n");
        sb.append("603;;cadastrarLogica;;38,1->39,1;;25,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;39,1->40,1;;25,50 semanas$$\n");
        sb.append("603;;cadastrarLogica;;40,1->41,1;;26,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;41,1->42,1;;26,50 semanas$$\n");
        sb.append("603;;cadastrarLogica;;42,1->43,1;;27,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;43,1->44,1;;27,50 semanas$$\n");
        sb.append("603;;cadastrarLogica;;44,1->45,1;;28,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;45,1->46,1;;28,50 semanas$$\n");
        sb.append("603;;cadastrarLogica;;46,1->47,1;;29,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;47,1->48,1;;30,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;48,1->49,1;;30,50 semanas$$\n");
        sb.append("603;;cadastrarLogica;;49,1->50,1;;31,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;50,1->51,1;;31,50 semanas$$\n");
        sb.append("603;;cadastrarLogica;;51,1->52,1;;32,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;52,1->53,1;;33,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;53,1->54,1;;33,50 semanas$$\n");
        sb.append("603;;cadastrarLogica;;54,1->55,1;;34,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;55,1->56,1;;35,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;56,1->57,1;;36,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;57,1->58,1;;37,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;58,1->59,1;;38,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;59,1->60,1;;39,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;60,1->61,1;;40,00 semanas$$\n");
        sb.append("603;;cadastrarLogica;;61,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tíbia">

        sb.append("604;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("604;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("604;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;10,1->11,1;;13,50 semanas$$\n");
        sb.append("604;;cadastrarLogica;;11,1->12,1;;14,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;12,1->13,1;;14,33 semanas$$\n");
        sb.append("604;;cadastrarLogica;;13,1->14,1;;14,67 semanas$$\n");
        sb.append("604;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;15,1->16,1;;15,50 semanas$$\n");
        sb.append("604;;cadastrarLogica;;16,1->17,1;;16,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;17,1->18,1;;16,33 semanas$$\n");
        sb.append("604;;cadastrarLogica;;18,1->19,1;;16,67 semanas$$\n");
        sb.append("604;;cadastrarLogica;;19,1->20,1;;17,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;20,1->21,1;;17,50 semanas$$\n");
        sb.append("604;;cadastrarLogica;;21,1->22,1;;18,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;22,1->23,1;;18,33 semanas$$\n");
        sb.append("604;;cadastrarLogica;;23,1->24,1;;18,67 semanas$$\n");
        sb.append("604;;cadastrarLogica;;24,1->25,1;;19,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;25,1->26,1;;19,50 semanas$$\n");
        sb.append("604;;cadastrarLogica;;26,1->27,1;;20,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;27,1->28,1;;20,33 semanas$$\n");
        sb.append("604;;cadastrarLogica;;28,1->29,1;;20,67 semanas$$\n");
        sb.append("604;;cadastrarLogica;;29,1->30,1;;21,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;30,1->31,1;;21,50 semanas$$\n");
        sb.append("604;;cadastrarLogica;;31,1->32,1;;22,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;32,1->33,1;;22,33 semanas$$\n");
        sb.append("604;;cadastrarLogica;;33,1->34,1;;22,67 semanas$$\n");
        sb.append("604;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("604;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;37,1->38,1;;24,33 semanas$$\n");
        sb.append("604;;cadastrarLogica;;38,1->39,1;;24,67 semanas$$\n");
        sb.append("604;;cadastrarLogica;;39,1->40,1;;25,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;40,1->41,1;;25,50 semanas$$\n");
        sb.append("604;;cadastrarLogica;;41,1->42,1;;26,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;42,1->43,1;;26,50 semanas$$\n");
        sb.append("604;;cadastrarLogica;;43,1->44,1;;27,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;44,1->45,1;;27,50 semanas$$\n");
        sb.append("604;;cadastrarLogica;;45,1->46,1;;28,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;46,1->47,1;;28,50 semanas$$\n");
        sb.append("604;;cadastrarLogica;;47,1->48,1;;29,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;48,1->49,1;;29,50 semanas$$\n");
        sb.append("604;;cadastrarLogica;;49,1->50,1;;30,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;50,1->51,1;;30,50 semanas$$\n");
        sb.append("604;;cadastrarLogica;;51,1->52,1;;31,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;52,1->53,1;;31,50 semanas$$\n");
        sb.append("604;;cadastrarLogica;;53,1->54,1;;32,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;54,1->55,1;;33,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;55,1->56,1;;33,50 semanas$$\n");
        sb.append("604;;cadastrarLogica;;56,1->57,1;;34,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;57,1->58,1;;35,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;58,1->59,1;;35,50 semanas$$\n");
        sb.append("604;;cadastrarLogica;;59,1->60,1;;36,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;60,1->61,1;;37,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;61,1->62,1;;37,50 semanas$$\n");
        sb.append("604;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;63,1->64,1;;39,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;64,1->65,1;;39,50 semanas$$\n");
        sb.append("604;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("604;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.A.">

        sb.append("606;;cadastrarLogica;;0,0->39,3;;<11,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;39,3->40,6;;11,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;40,6->41,9;;11,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;41,9->43,2;;11,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;43,2->44,5;;11,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;44,5->45,8;;11,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;45,8->47,0;;11,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;47,0->48,3;;11,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;48,3->49,6;;11,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;49,6->50,9;;11,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;50,9->52,2;;11,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;52,2->53,5;;12,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;53,5->54,8;;12,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;54,8->56,0;;12,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;56,0->57,3;;12,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;57,3->58,6;;12,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;58,6->59,9;;12,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;59,9->61,2;;12,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;61,2->62,4;;12,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;62,4->63,7;;12,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;63,7->65,0;;12,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;65,0->66,3;;13,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;66,3->67,5;;13,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;67,5->68,8;;13,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;68,8->70,1;;13,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;70,1->71,4;;13,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;71,4->72,6;;13,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;72,6->73,9;;13,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;73,9->75,2;;13,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;75,2->76,4;;13,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;76,4->77,7;;13,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;77,7->79,0;;14,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;79,0->80,2;;14,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;80,2->81,4;;14,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;81,4->82,7;;14,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;82,7->84,0;;14,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;84,0->85,2;;14,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;85,2->86,4;;14,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;86,4->87,7;;14,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;87,7->89,0;;14,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;89,0->90,2;;14,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;90,2->91,4;;15,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;91,4->92,7;;15,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;92,7->94,0;;15,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;94,0->95,2;;15,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;95,2->96,4;;15,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;96,4->97,7;;15,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;97,7->99,0;;15,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;99,0->100,2;;15,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;100,2->101,4;;15,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;101,4->102,7;;15,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;102,7->103,9;;16,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;103,9->105,2;;16,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;105,2->106,4;;16,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;106,4->107,6;;16,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;107,6->108,8;;16,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;108,8->110,1;;16,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;110,1->111,3;;16,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;111,3->112,5;;16,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;112,5->113,8;;16,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;113,8->115,0;;16,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;115,0->116,2;;17,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;116,2->117,4;;17,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;117,4->118,7;;17,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;118,7->119,9;;17,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;119,9->121,1;;17,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;121,1->122,3;;17,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;122,3->123,5;;17,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;123,5->124,8;;17,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;124,8->126,0;;17,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;126,0->127,2;;17,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;127,2->128,4;;18,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;128,4->129,6;;18,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;129,6->130,8;;18,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;130,8->132,0;;18,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;132,0->133,2;;18,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;133,2->134,4;;18,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;134,4->135,6;;18,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;135,6->136,8;;18,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;136,8->138,0;;18,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;138,0->139,2;;18,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;139,2->140,4;;19,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;140,4->141,6;;19,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;141,6->142,8;;19,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;142,8->144,0;;19,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;144,0->145,1;;19,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;145,1->146,3;;19,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;146,3->147,5;;19,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;147,5->148,7;;19,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;148,7->149,9;;19,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;149,9->151,1;;19,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;151,1->152,3;;20,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;152,3->153,4;;20,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;153,4->154,6;;20,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;154,6->155,8;;20,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;155,8->157,0;;20,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;157,0->158,1;;20,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;158,1->159,3;;20,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;159,3->160,5;;20,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;160,5->161,6;;20,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;161,6->162,8;;20,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;162,8->164,0;;21,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;164,0->165,1;;21,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;165,1->166,3;;21,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;166,3->167,4;;21,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;167,4->168,6;;21,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;168,6->169,8;;21,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;169,8->170,9;;21,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;170,9->172,1;;21,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;172,1->173,2;;21,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;173,2->174,4;;21,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;174,4->175,5;;22,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;175,5->176,7;;22,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;176,7->177,8;;22,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;177,8->179,0;;22,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;179,0->180,1;;22,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;180,1->181,2;;22,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;181,2->182,4;;22,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;182,4->183,5;;22,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;183,5->184,7;;22,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;184,7->185,8;;22,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;185,8->186,9;;23,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;186,9->188,0;;23,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;188,0->189,2;;23,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;189,2->190,3;;23,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;190,3->191,4;;23,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;191,4->192,5;;23,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;192,5->193,6;;23,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;193,6->194,8;;23,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;194,8->195,9;;23,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;195,9->197,0;;23,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;197,0->198,1;;24,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;198,1->199,2;;24,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;199,2->200,3;;24,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;200,3->201,4;;24,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;201,4->202,5;;24,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;202,5->203,6;;24,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;203,6->204,7;;24,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;204,7->205,8;;24,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;205,8->206,9;;24,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;206,9->208,0;;24,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;208,0->209,1;;25,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;209,1->210,2;;25,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;210,2->211,2;;25,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;211,2->212,3;;25,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;212,3->213,4;;25,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;213,4->214,5;;25,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;214,5->215,6;;25,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;215,6->216,6;;25,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;216,6->217,7;;25,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;217,7->218,8;;25,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;218,8->219,9;;26,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;219,9->220,9;;26,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;220,9->222,0;;26,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;222,0->223,0;;26,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;223,0->224,1;;26,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;224,1->225,2;;26,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;225,2->226,2;;26,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;226,2->227,3;;26,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;227,3->228,3;;26,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;228,3->229,4;;26,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;229,4->230,4;;27,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;230,4->231,5;;27,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;231,5->232,5;;27,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;232,5->233,6;;27,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;233,6->234,6;;27,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;234,6->235,6;;27,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;235,6->236,7;;27,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;236,7->237,7;;27,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;237,7->238,8;;27,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;238,8->239,8;;27,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;239,8->240,8;;28,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;240,8->241,8;;28,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;241,8->242,8;;28,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;242,8->243,8;;28,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;243,8->244,9;;28,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;244,9->245,9;;28,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;245,9->246,9;;28,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;246,9->247,9;;28,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;247,9->248,9;;28,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;248,9->249,9;;28,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;249,9->250,9;;29,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;250,9->251,9;;29,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;251,9->252,9;;29,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;252,9->253,9;;29,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;253,9->254,9;;29,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;254,9->255,8;;29,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;255,8->256,8;;29,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;256,8->257,8;;29,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;257,8->258,8;;29,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;258,8->259,8;;29,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;259,8->260,8;;30,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;260,8->261,7;;30,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;261,7->262,7;;30,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;262,7->263,7;;30,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;263,7->264,6;;30,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;264,6->265,6;;30,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;265,6->266,6;;30,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;266,6->267,6;;30,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;267,6->268,5;;30,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;268,5->269,5;;30,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;269,5->270,4;;31,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;270,4->271,4;;31,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;271,4->272,4;;31,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;272,4->273,3;;31,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;273,3->274,2;;31,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;274,2->275,2;;31,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;275,2->276,2;;31,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;276,2->277,1;;31,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;277,1->278,0;;31,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;278,0->279,0;;31,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;279,0->279,9;;32,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;279,9->280,8;;32,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;280,8->281,7;;32,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;281,7->282,6;;32,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;282,6->283,6;;32,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;283,6->284,5;;32,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;284,5->285,4;;32,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;285,4->286,3;;32,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;286,3->287,2;;32,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;287,2->288,1;;32,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;288,1->289,0;;33,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;289,0->289,9;;33,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;289,9->290,8;;33,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;290,8->291,7;;33,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;291,7->292,6;;33,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;292,6->293,5;;33,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;293,5->294,4;;33,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;294,4->295,3;;33,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;295,3->296,2;;33,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;296,2->297,1;;33,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;297,1->298,0;;34,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;298,0->298,8;;34,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;298,8->299,7;;34,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;299,7->300,5;;34,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;300,5->301,4;;34,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;301,4->302,3;;34,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;302,3->303,1;;34,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;303,1->304,0;;34,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;304,0->304,8;;34,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;304,8->305,7;;34,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;305,7->306,5;;35,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;306,5->307,4;;35,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;307,4->308,2;;35,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;308,2->309,1;;35,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;309,1->309,9;;35,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;309,9->310,7;;35,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;310,7->311,6;;35,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;311,6->312,4;;35,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;312,4->313,3;;35,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;313,3->314,1;;35,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;314,1->314,9;;36,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;314,9->315,7;;36,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;315,7->316,5;;36,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;316,5->317,3;;36,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;317,3->318,1;;36,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;318,1->318,9;;36,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;318,9->319,7;;36,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;319,7->320,5;;36,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;320,5->321,3;;36,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;321,3->322,1;;36,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;322,1->322,9;;37,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;322,9->323,7;;37,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;323,7->324,4;;37,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;324,4->325,2;;37,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;325,2->326,0;;37,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;326,0->326,8;;37,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;326,8->327,6;;37,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;327,6->328,3;;37,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;328,3->329,1;;37,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;329,1->329,9;;37,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;329,9->330,6;;38,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;330,6->331,4;;38,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;331,4->332,2;;38,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;332,2->332,9;;38,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;332,9->333,6;;38,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;333,6->334,4;;38,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;334,4->335,2;;38,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;335,2->335,9;;38,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;335,9->336,6;;38,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;336,6->337,4;;38,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;337,4->338,1;;39,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;338,1->338,8;;39,10 semanas$$\n");
        sb.append("606;;cadastrarLogica;;338,8->339,5;;39,20 semanas$$\n");
        sb.append("606;;cadastrarLogica;;339,5->340,2;;39,30 semanas$$\n");
        sb.append("606;;cadastrarLogica;;340,2->341,0;;39,40 semanas$$\n");
        sb.append("606;;cadastrarLogica;;341,0->341,7;;39,50 semanas$$\n");
        sb.append("606;;cadastrarLogica;;341,7->342,4;;39,60 semanas$$\n");
        sb.append("606;;cadastrarLogica;;342,4->343,1;;39,70 semanas$$\n");
        sb.append("606;;cadastrarLogica;;343,1->343,8;;39,80 semanas$$\n");
        sb.append("606;;cadastrarLogica;;343,8->344,5;;39,90 semanas$$\n");
        sb.append("606;;cadastrarLogica;;344,5->346,1;;40,00 semanas$$\n");
        sb.append("606;;cadastrarLogica;;346,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.C.">

        sb.append("607;;cadastrarLogica;;0,0->53,2;;<11,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;53,2->54,6;;11,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;54,6->56,1;;11,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;56,1->57,5;;11,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;57,5->58,9;;11,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;58,9->60,4;;11,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;60,4->61,8;;11,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;61,8->63,2;;11,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;63,2->64,6;;11,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;64,6->66,1;;11,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;66,1->67,5;;11,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;67,5->68,9;;12,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;68,9->70,4;;12,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;70,4->71,8;;12,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;71,8->73,2;;12,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;73,2->74,6;;12,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;74,6->76,1;;12,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;76,1->77,5;;12,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;77,5->78,9;;12,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;78,9->80,4;;12,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;80,4->81,8;;12,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;81,8->83,2;;13,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;83,2->84,5;;13,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;84,5->85,9;;13,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;85,9->87,3;;13,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;87,3->88,6;;13,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;88,6->90,0;;13,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;90,0->91,4;;13,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;91,4->92,8;;13,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;92,8->94,1;;13,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;94,1->95,5;;13,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;95,5->96,9;;14,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;96,9->98,2;;14,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;98,2->99,6;;14,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;99,6->101,0;;14,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;101,0->102,4;;14,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;102,4->103,7;;14,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;103,7->105,1;;14,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;105,1->106,5;;14,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;106,5->107,8;;14,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;107,8->109,2;;14,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;109,2->110,6;;15,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;110,6->111,9;;15,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;111,9->113,2;;15,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;113,2->114,6;;15,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;114,6->116,0;;15,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;116,0->117,3;;15,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;117,3->118,6;;15,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;118,6->120,0;;15,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;120,0->121,4;;15,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;121,4->122,7;;15,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;122,7->124,0;;16,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;124,0->125,3;;16,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;125,3->126,6;;16,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;126,6->127,9;;16,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;127,9->129,2;;16,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;129,2->130,6;;16,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;130,6->131,9;;16,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;131,9->133,2;;16,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;133,2->134,5;;16,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;134,5->135,8;;16,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;135,8->137,1;;17,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;137,1->138,4;;17,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;138,4->139,7;;17,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;139,7->141,0;;17,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;141,0->142,2;;17,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;142,2->143,5;;17,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;143,5->144,8;;17,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;144,8->146,1;;17,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;146,1->147,4;;17,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;147,4->148,7;;17,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;148,7->150,0;;18,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;150,0->151,2;;18,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;151,2->152,5;;18,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;152,5->153,7;;18,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;153,7->155,0;;18,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;155,0->156,3;;18,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;156,3->157,5;;18,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;157,5->158,8;;18,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;158,8->160,0;;18,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;160,0->161,3;;18,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;161,3->162,5;;19,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;162,5->163,7;;19,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;163,7->165,0;;19,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;165,0->166,2;;19,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;166,2->167,4;;19,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;167,4->168,6;;19,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;168,6->169,8;;19,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;169,8->171,1;;19,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;171,1->172,3;;19,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;172,3->173,5;;19,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;173,5->174,7;;20,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;174,7->175,9;;20,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;175,9->177,1;;20,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;177,1->178,3;;20,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;178,3->179,5;;20,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;179,5->180,7;;20,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;180,7->181,9;;20,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;181,9->183,1;;20,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;183,1->184,3;;20,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;184,3->185,5;;20,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;185,5->186,6;;21,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;186,6->187,8;;21,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;187,8->189,0;;21,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;189,0->190,1;;21,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;190,1->191,2;;21,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;191,2->192,4;;21,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;192,4->193,6;;21,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;193,6->194,7;;21,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;194,7->195,8;;21,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;195,8->197,0;;21,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;197,0->198,1;;22,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;198,1->199,3;;22,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;199,3->200,4;;22,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;200,4->201,5;;22,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;201,5->202,6;;22,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;202,6->203,8;;22,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;203,8->204,9;;22,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;204,9->206,0;;22,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;206,0->207,2;;22,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;207,2->208,3;;22,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;208,3->209,4;;23,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;209,4->210,5;;23,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;210,5->211,5;;23,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;211,5->212,6;;23,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;212,6->213,7;;23,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;213,7->214,8;;23,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;214,8->215,9;;23,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;215,9->216,9;;23,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;216,9->218,0;;23,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;218,0->219,1;;23,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;219,1->220,1;;24,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;220,1->221,2;;24,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;221,2->222,2;;24,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;222,2->223,3;;24,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;223,3->224,3;;24,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;224,3->225,3;;24,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;225,3->226,4;;24,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;226,4->227,4;;24,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;227,4->228,5;;24,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;228,5->229,5;;24,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;229,5->230,5;;25,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;230,5->231,5;;25,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;231,5->232,5;;25,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;232,5->233,5;;25,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;233,5->234,5;;25,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;234,5->235,5;;25,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;235,5->236,5;;25,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;236,5->237,5;;25,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;237,5->238,5;;25,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;238,5->239,5;;25,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;239,5->240,5;;26,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;240,5->241,4;;26,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;241,4->242,4;;26,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;242,4->243,3;;26,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;243,3->244,3;;26,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;244,3->245,3;;26,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;245,3->246,2;;26,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;246,2->247,2;;26,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;247,2->248,1;;26,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;248,1->249,1;;26,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;249,1->250,0;;27,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;250,0->250,9;;27,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;250,9->251,9;;27,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;251,9->252,8;;27,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;252,8->253,7;;27,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;253,7->254,6;;27,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;254,6->255,5;;27,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;255,5->256,5;;27,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;256,5->257,4;;27,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;257,4->258,3;;27,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;258,3->259,2;;28,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;259,2->260,0;;28,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;260,0->260,9;;28,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;260,9->261,7;;28,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;261,7->262,6;;28,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;262,6->263,5;;28,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;263,5->264,3;;28,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;264,3->265,2;;28,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;265,2->266,0;;28,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;266,0->266,9;;28,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;266,9->267,7;;29,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;267,7->268,5;;29,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;268,5->269,4;;29,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;269,4->270,2;;29,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;270,2->271,0;;29,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;271,0->271,8;;29,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;271,8->272,6;;29,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;272,6->273,5;;29,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;273,5->274,3;;29,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;274,3->275,1;;29,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;275,1->275,9;;30,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;275,9->276,6;;30,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;276,6->277,4;;30,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;277,4->278,2;;30,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;278,2->279,0;;30,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;279,0->279,7;;30,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;279,7->280,5;;30,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;280,5->281,3;;30,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;281,3->282,0;;30,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;282,0->282,8;;30,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;282,8->283,5;;31,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;283,5->284,2;;31,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;284,2->284,9;;31,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;284,9->285,6;;31,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;285,6->286,4;;31,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;286,4->287,1;;31,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;287,1->287,8;;31,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;287,8->288,5;;31,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;288,5->289,2;;31,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;289,2->289,9;;31,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;289,9->290,6;;32,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;290,6->291,2;;32,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;291,2->291,9;;32,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;291,9->292,6;;32,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;292,6->293,2;;32,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;293,2->293,9;;32,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;293,9->294,6;;32,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;294,6->295,3;;32,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;295,3->295,9;;32,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;295,9->296,6;;32,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;296,6->297,2;;33,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;297,2->297,8;;33,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;297,8->298,4;;33,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;298,4->299,0;;33,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;299,0->299,6;;33,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;299,6->300,3;;33,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;300,3->300,9;;33,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;300,9->301,5;;33,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;301,5->302,1;;33,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;302,1->302,7;;33,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;302,7->303,2;;34,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;303,2->303,8;;34,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;303,8->304,3;;34,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;304,3->304,9;;34,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;304,9->305,4;;34,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;305,4->306,0;;34,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;306,0->306,6;;34,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;306,6->307,1;;34,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;307,1->307,6;;34,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;307,6->308,2;;34,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;308,2->308,7;;35,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;308,7->309,2;;35,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;309,2->309,7;;35,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;309,7->310,2;;35,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;310,2->310,6;;35,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;310,6->311,1;;35,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;311,1->311,6;;35,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;311,6->312,1;;35,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;312,1->312,6;;35,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;312,6->313,1;;35,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;313,1->313,5;;36,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;313,5->314,0;;36,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;314,0->314,4;;36,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;314,4->314,9;;36,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;314,9->315,3;;36,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;315,3->315,7;;36,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;315,7->316,2;;36,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;316,2->316,6;;36,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;316,6->317,1;;36,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;317,1->317,5;;36,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;317,5->317,9;;37,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;317,9->318,2;;37,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;318,2->318,6;;37,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;318,6->319,0;;37,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;319,0->319,4;;37,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;319,4->319,7;;37,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;319,7->320,1;;37,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;320,1->320,5;;37,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;320,5->320,8;;37,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;320,8->321,2;;37,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;321,2->321,5;;38,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;321,5->321,8;;38,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;321,8->322,1;;38,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;322,1->322,4;;38,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;322,4->322,8;;38,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;322,8->323,1;;38,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;323,1->323,4;;38,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;323,4->323,7;;38,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;323,7->324,0;;38,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;324,0->324,3;;38,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;324,3->324,5;;39,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;324,5->324,8;;39,10 semanas$$\n");
        sb.append("607;;cadastrarLogica;;324,8->325,0;;39,20 semanas$$\n");
        sb.append("607;;cadastrarLogica;;325,0->325,3;;39,30 semanas$$\n");
        sb.append("607;;cadastrarLogica;;325,3->325,5;;39,40 semanas$$\n");
        sb.append("607;;cadastrarLogica;;325,5->325,7;;39,50 semanas$$\n");
        sb.append("607;;cadastrarLogica;;325,7->326,0;;39,60 semanas$$\n");
        sb.append("607;;cadastrarLogica;;326,0->326,2;;39,70 semanas$$\n");
        sb.append("607;;cadastrarLogica;;326,2->326,5;;39,80 semanas$$\n");
        sb.append("607;;cadastrarLogica;;326,5->326,7;;39,90 semanas$$\n");
        sb.append("607;;cadastrarLogica;;326,7->328,1;;40,00 semanas$$\n");
        sb.append("607;;cadastrarLogica;;328,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("605;;cadastrarLogica;;0,0->15,7;;<11,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;15,7->16,0;;11,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;16,0->16,4;;11,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;16,4->16,7;;11,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;16,7->17,1;;11,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;17,1->17,4;;11,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;17,4->17,7;;11,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;17,7->18,1;;11,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;18,1->18,4;;11,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;18,4->18,8;;11,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;18,8->19,1;;11,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;19,1->19,4;;12,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;19,4->19,7;;12,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;19,7->20,1;;12,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;20,1->20,4;;12,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;20,4->20,7;;12,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;20,7->21,0;;12,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;21,0->21,3;;12,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;21,3->21,7;;12,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;21,7->22,0;;12,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;22,0->22,3;;12,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;22,3->22,8;;13,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;22,8->23,2;;13,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;23,2->23,7;;13,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;23,7->24,2;;13,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;24,2->24,6;;13,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;24,6->25,1;;13,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;25,1->25,6;;13,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;25,6->26,1;;13,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;26,1->26,5;;13,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;26,5->27,0;;13,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;27,0->27,4;;14,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;27,4->27,7;;14,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;27,7->28,1;;14,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;28,1->28,5;;14,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;28,5->28,8;;14,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;28,8->29,2;;14,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;29,2->29,6;;14,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;29,6->30,0;;14,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;30,0->30,3;;14,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;30,3->30,7;;14,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;30,7->31,1;;15,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;31,1->31,4;;15,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;31,4->31,8;;15,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;31,8->32,1;;15,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;32,1->32,5;;15,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;32,5->32,9;;15,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;32,9->33,2;;15,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;33,2->33,6;;15,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;33,6->33,9;;15,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;33,9->34,3;;15,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;34,3->34,7;;16,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;34,7->35,0;;16,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;35,0->35,4;;16,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;35,4->35,7;;16,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;35,7->36,1;;16,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;36,1->36,5;;16,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;36,5->36,8;;16,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;36,8->37,2;;16,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;37,2->37,5;;16,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;37,5->37,9;;16,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;37,9->38,2;;17,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;38,2->38,6;;17,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;38,6->38,9;;17,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;38,9->39,3;;17,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;39,3->39,6;;17,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;39,6->39,9;;17,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;39,9->40,3;;17,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;40,3->40,6;;17,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;40,6->41,0;;17,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;41,0->41,3;;17,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;41,3->41,6;;18,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;41,6->42,0;;18,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;42,0->42,3;;18,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;42,3->42,7;;18,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;42,7->43,0;;18,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;43,0->43,3;;18,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;43,3->43,7;;18,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;43,7->44,0;;18,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;44,0->44,4;;18,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;44,4->44,7;;18,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;44,7->45,0;;19,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;45,0->45,4;;19,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;45,4->45,7;;19,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;45,7->46,1;;19,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;46,1->46,4;;19,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;46,4->46,7;;19,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;46,7->47,1;;19,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;47,1->47,4;;19,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;47,4->47,8;;19,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;47,8->48,1;;19,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;48,1->48,4;;20,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;48,4->48,7;;20,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;48,7->49,1;;20,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;49,1->49,4;;20,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;49,4->49,7;;20,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;49,7->50,0;;20,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;50,0->50,3;;20,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;50,3->50,7;;20,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;50,7->51,0;;20,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;51,0->51,3;;20,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;51,3->51,6;;21,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;51,6->51,9;;21,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;51,9->52,3;;21,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;52,3->52,6;;21,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;52,6->52,9;;21,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;52,9->53,2;;21,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;53,2->53,5;;21,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;53,5->53,9;;21,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;53,9->54,2;;21,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;54,2->54,5;;21,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;54,5->54,8;;22,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;54,8->55,1;;22,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;55,1->55,4;;22,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;55,4->55,7;;22,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;55,7->56,0;;22,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;56,0->56,3;;22,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;56,3->56,6;;22,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;56,6->56,9;;22,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;56,9->57,2;;22,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;57,2->57,5;;22,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;57,5->57,8;;23,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;57,8->58,1;;23,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;58,1->58,4;;23,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;58,4->58,7;;23,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;58,7->59,0;;23,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;59,0->59,3;;23,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;59,3->59,6;;23,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;59,6->59,9;;23,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;59,9->60,2;;23,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;60,2->60,5;;23,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;60,5->60,8;;24,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;60,8->61,1;;24,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;61,1->61,4;;24,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;61,4->61,7;;24,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;61,7->62,0;;24,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;62,0->62,2;;24,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;62,2->62,5;;24,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;62,5->62,8;;24,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;62,8->63,1;;24,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;63,1->63,4;;24,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;63,4->63,7;;25,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;63,7->64,0;;25,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;64,0->64,2;;25,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;64,2->64,5;;25,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;64,5->64,8;;25,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;64,8->65,1;;25,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;65,1->65,4;;25,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;65,4->65,6;;25,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;65,6->65,9;;25,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;65,9->66,2;;25,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;66,2->66,5;;26,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;66,5->66,7;;26,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;66,7->67,0;;26,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;67,0->67,3;;26,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;67,3->67,6;;26,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;67,6->67,8;;26,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;67,8->68,1;;26,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;68,1->68,4;;26,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;68,4->68,6;;26,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;68,6->68,9;;26,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;68,9->69,2;;27,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;69,2->69,4;;27,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;69,4->69,6;;27,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;69,6->69,9;;27,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;69,9->70,2;;27,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;70,2->70,4;;27,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;70,4->70,6;;27,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;70,6->70,9;;27,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;70,9->71,2;;27,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;71,2->71,4;;27,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;71,4->71,6;;28,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;71,6->71,9;;28,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;71,9->72,2;;28,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;72,2->72,4;;28,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;72,4->72,6;;28,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;72,6->72,9;;28,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;72,9->73,2;;28,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;73,2->73,4;;28,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;73,4->73,6;;28,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;73,6->73,9;;28,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;73,9->74,1;;29,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;74,1->74,4;;29,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;74,4->74,6;;29,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;74,6->74,8;;29,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;74,8->75,1;;29,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;75,1->75,3;;29,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;75,3->75,5;;29,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;75,5->75,7;;29,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;75,7->76,0;;29,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;76,0->76,2;;29,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;76,2->76,4;;30,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;76,4->76,7;;30,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;76,7->76,9;;30,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;76,9->77,1;;30,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;77,1->77,4;;30,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;77,4->77,6;;30,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;77,6->77,8;;30,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;77,8->78,0;;30,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;78,0->78,3;;30,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;78,3->78,5;;30,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;78,5->78,7;;31,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;78,7->78,9;;31,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;78,9->79,1;;31,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;79,1->79,3;;31,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;79,3->79,6;;31,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;79,6->79,8;;31,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;79,8->80,0;;31,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;80,0->80,2;;31,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;80,2->80,4;;31,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;80,4->80,6;;31,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;80,6->80,8;;32,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;80,8->81,0;;32,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;81,0->81,2;;32,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;81,2->81,4;;32,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;81,4->81,6;;32,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;81,6->81,7;;32,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;81,7->81,9;;32,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;81,9->82,1;;32,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;82,1->82,3;;32,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;82,3->82,5;;32,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;82,5->82,7;;33,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;82,7->82,9;;33,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;82,9->83,1;;33,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;83,1->83,3;;33,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;83,3->83,4;;33,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;83,4->83,6;;33,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;83,6->83,8;;33,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;83,8->84,0;;33,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;84,0->84,2;;33,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;84,2->84,4;;33,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;84,4->84,6;;34,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;84,6->84,7;;34,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;84,7->84,9;;34,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;84,9->85,1;;34,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;85,1->85,2;;34,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;85,2->85,4;;34,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;85,4->85,6;;34,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;85,6->85,8;;34,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;85,8->85,9;;34,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;85,9->86,1;;34,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;86,1->86,2;;35,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;86,2->86,4;;35,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;86,4->86,6;;35,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;86,6->86,7;;35,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;86,7->86,8;;35,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;86,8->87,0;;35,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;87,0->87,1;;35,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;87,1->87,3;;35,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;87,3->87,4;;35,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;87,4->87,6;;35,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;87,6->87,8;;36,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;87,8->87,9;;36,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;87,9->88,0;;36,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;88,0->88,2;;36,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;88,2->88,4;;36,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;88,4->88,5;;36,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;88,5->88,6;;36,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;88,6->88,8;;36,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;88,8->88,9;;36,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;88,9->89,1;;36,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;89,1->89,2;;37,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;89,2->89,3;;37,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;89,3->89,5;;37,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;89,5->89,6;;37,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;89,6->89,7;;37,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;89,7->89,8;;37,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;89,8->89,9;;37,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;89,9->90,1;;37,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;90,1->90,2;;37,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;90,2->90,3;;37,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;90,3->90,4;;38,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;90,4->90,5;;38,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;90,5->90,6;;38,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;90,6->90,7;;38,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;90,7->90,8;;38,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;90,8->91,0;;38,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;91,0->91,1;;38,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;91,1->91,2;;38,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;91,2->91,3;;38,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;91,3->91,4;;38,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;91,4->91,5;;39,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;91,5->91,6;;39,10 semanas$$\n");
        sb.append("605;;cadastrarLogica;;91,6->91,7;;39,20 semanas$$\n");
        sb.append("605;;cadastrarLogica;;91,7->91,8;;39,30 semanas$$\n");
        sb.append("605;;cadastrarLogica;;91,8->91,9;;39,40 semanas$$\n");
        sb.append("605;;cadastrarLogica;;91,9->92,0;;39,50 semanas$$\n");
        sb.append("605;;cadastrarLogica;;92,0->92,1;;39,60 semanas$$\n");
        sb.append("605;;cadastrarLogica;;92,1->92,2;;39,70 semanas$$\n");
        sb.append("605;;cadastrarLogica;;92,2->92,3;;39,80 semanas$$\n");
        sb.append("605;;cadastrarLogica;;92,3->92,4;;39,90 semanas$$\n");
        sb.append("605;;cadastrarLogica;;92,4->93,1;;40,00 semanas$$\n");
        sb.append("605;;cadastrarLogica;;93,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

    }

    private static void preencherIghFeto2 ()
    {

        // <editor-fold defaultstate="collapsed" desc="Fêmur">

        sb.append("608;;cadastrarLogica;;0,0->7,1;;<12,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;7,1->8,1;;12,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;8,1->9,1;;12,33 semanas$$\n");
        sb.append("608;;cadastrarLogica;;9,1->10,1;;12,67 semanas$$\n");
        sb.append("608;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("608;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("608;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("608;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("608;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("608;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("608;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;20,1->21,1;;16,33 semanas$$\n");
        sb.append("608;;cadastrarLogica;;21,1->22,1;;16,67 semanas$$\n");
        sb.append("608;;cadastrarLogica;;22,1->23,1;;17,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;23,1->24,1;;17,50 semanas$$\n");
        sb.append("608;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("608;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("608;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;28,1->29,1;;19,33 semanas$$\n");
        sb.append("608;;cadastrarLogica;;29,1->30,1;;19,67 semanas$$\n");
        sb.append("608;;cadastrarLogica;;30,1->31,1;;20,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;31,1->32,1;;20,33 semanas$$\n");
        sb.append("608;;cadastrarLogica;;32,1->33,1;;20,67 semanas$$\n");
        sb.append("608;;cadastrarLogica;;33,1->34,1;;21,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;34,1->35,1;;21,50 semanas$$\n");
        sb.append("608;;cadastrarLogica;;35,1->36,1;;22,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;36,1->37,1;;22,33 semanas$$\n");
        sb.append("608;;cadastrarLogica;;37,1->38,1;;22,67 semanas$$\n");
        sb.append("608;;cadastrarLogica;;38,1->39,1;;23,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;39,1->40,1;;23,33 semanas$$\n");
        sb.append("608;;cadastrarLogica;;40,1->41,1;;23,67 semanas$$\n");
        sb.append("608;;cadastrarLogica;;41,1->42,1;;24,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;42,1->43,1;;24,50 semanas$$\n");
        sb.append("608;;cadastrarLogica;;43,1->44,1;;25,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;44,1->45,1;;25,33 semanas$$\n");
        sb.append("608;;cadastrarLogica;;45,1->46,1;;25,67 semanas$$\n");
        sb.append("608;;cadastrarLogica;;46,1->47,1;;26,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;47,1->48,1;;26,50 semanas$$\n");
        sb.append("608;;cadastrarLogica;;48,1->49,1;;27,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;49,1->50,1;;27,33 semanas$$\n");
        sb.append("608;;cadastrarLogica;;50,1->51,1;;27,67 semanas$$\n");
        sb.append("608;;cadastrarLogica;;51,1->52,1;;28,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;52,1->53,1;;28,50 semanas$$\n");
        sb.append("608;;cadastrarLogica;;53,1->54,1;;29,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;54,1->55,1;;29,50 semanas$$\n");
        sb.append("608;;cadastrarLogica;;55,1->56,1;;30,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;56,1->57,1;;30,33 semanas$$\n");
        sb.append("608;;cadastrarLogica;;57,1->58,1;;30,67 semanas$$\n");
        sb.append("608;;cadastrarLogica;;58,1->59,1;;31,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;59,1->60,1;;31,50 semanas$$\n");
        sb.append("608;;cadastrarLogica;;60,1->61,1;;32,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;61,1->62,1;;32,50 semanas$$\n");
        sb.append("608;;cadastrarLogica;;62,1->63,1;;33,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;63,1->64,1;;33,50 semanas$$\n");
        sb.append("608;;cadastrarLogica;;64,1->65,1;;34,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;65,1->66,1;;34,50 semanas$$\n");
        sb.append("608;;cadastrarLogica;;66,1->67,1;;35,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;67,1->68,1;;36,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;68,1->69,1;;36,50 semanas$$\n");
        sb.append("608;;cadastrarLogica;;69,1->70,1;;37,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;70,1->71,1;;38,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;71,1->72,1;;38,50 semanas$$\n");
        sb.append("608;;cadastrarLogica;;72,1->73,1;;39,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;73,1->74,1;;40,00 semanas$$\n");
        sb.append("608;;cadastrarLogica;;74,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Úmero">

        sb.append("609;;cadastrarLogica;;0,0->8,1;;<12,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;8,1->9,1;;12,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;9,1->10,1;;12,50 semanas$$\n");
        sb.append("609;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("609;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("609;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("609;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("609;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("609;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("609;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;20,1->21,1;;16,50 semanas$$\n");
        sb.append("609;;cadastrarLogica;;21,1->22,1;;17,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;22,1->23,1;;17,33 semanas$$\n");
        sb.append("609;;cadastrarLogica;;23,1->24,1;;17,67 semanas$$\n");
        sb.append("609;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("609;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("609;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;28,1->29,1;;19,50 semanas$$\n");
        sb.append("609;;cadastrarLogica;;29,1->30,1;;20,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;30,1->31,1;;20,33 semanas$$\n");
        sb.append("609;;cadastrarLogica;;31,1->32,1;;20,67 semanas$$\n");
        sb.append("609;;cadastrarLogica;;32,1->33,1;;21,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;33,1->34,1;;21,50 semanas$$\n");
        sb.append("609;;cadastrarLogica;;34,1->35,1;;22,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;35,1->36,1;;22,33 semanas$$\n");
        sb.append("609;;cadastrarLogica;;36,1->37,1;;22,67 semanas$$\n");
        sb.append("609;;cadastrarLogica;;37,1->38,1;;23,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;38,1->39,1;;23,50 semanas$$\n");
        sb.append("609;;cadastrarLogica;;39,1->40,1;;24,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;40,1->41,1;;24,50 semanas$$\n");
        sb.append("609;;cadastrarLogica;;41,1->42,1;;25,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;42,1->43,1;;25,50 semanas$$\n");
        sb.append("609;;cadastrarLogica;;43,1->44,1;;26,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;44,1->45,1;;26,50 semanas$$\n");
        sb.append("609;;cadastrarLogica;;45,1->46,1;;27,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;46,1->47,1;;27,50 semanas$$\n");
        sb.append("609;;cadastrarLogica;;47,1->48,1;;28,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;48,1->49,1;;28,50 semanas$$\n");
        sb.append("609;;cadastrarLogica;;49,1->50,1;;29,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;50,1->51,1;;30,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;51,1->52,1;;30,50 semanas$$\n");
        sb.append("609;;cadastrarLogica;;52,1->53,1;;31,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;53,1->54,1;;31,50 semanas$$\n");
        sb.append("609;;cadastrarLogica;;54,1->55,1;;32,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;55,1->56,1;;33,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;56,1->57,1;;33,50 semanas$$\n");
        sb.append("609;;cadastrarLogica;;57,1->58,1;;34,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;58,1->59,1;;35,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;59,1->60,1;;35,50 semanas$$\n");
        sb.append("609;;cadastrarLogica;;60,1->61,1;;36,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;61,1->62,1;;37,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;63,1->64,1;;38,50 semanas$$\n");
        sb.append("609;;cadastrarLogica;;64,1->65,1;;39,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("609;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ulna">

        sb.append("610;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("610;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("610;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;10,1->11,1;;13,33 semanas$$\n");
        sb.append("610;;cadastrarLogica;;11,1->12,1;;13,67 semanas$$\n");
        sb.append("610;;cadastrarLogica;;12,1->13,1;;14,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;13,1->14,1;;14,50 semanas$$\n");
        sb.append("610;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;15,1->16,1;;15,33 semanas$$\n");
        sb.append("610;;cadastrarLogica;;16,1->17,1;;15,67 semanas$$\n");
        sb.append("610;;cadastrarLogica;;17,1->18,1;;16,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;18,1->19,1;;16,33 semanas$$\n");
        sb.append("610;;cadastrarLogica;;19,1->20,1;;16,67 semanas$$\n");
        sb.append("610;;cadastrarLogica;;20,1->21,1;;17,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;21,1->22,1;;17,50 semanas$$\n");
        sb.append("610;;cadastrarLogica;;22,1->23,1;;18,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;23,1->24,1;;18,33 semanas$$\n");
        sb.append("610;;cadastrarLogica;;24,1->25,1;;18,67 semanas$$\n");
        sb.append("610;;cadastrarLogica;;25,1->26,1;;19,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;26,1->27,1;;19,50 semanas$$\n");
        sb.append("610;;cadastrarLogica;;27,1->28,1;;20,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;28,1->29,1;;20,33 semanas$$\n");
        sb.append("610;;cadastrarLogica;;29,1->30,1;;20,67 semanas$$\n");
        sb.append("610;;cadastrarLogica;;30,1->31,1;;21,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;31,1->32,1;;21,50 semanas$$\n");
        sb.append("610;;cadastrarLogica;;32,1->33,1;;22,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;33,1->34,1;;22,50 semanas$$\n");
        sb.append("610;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("610;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;37,1->38,1;;24,50 semanas$$\n");
        sb.append("610;;cadastrarLogica;;38,1->39,1;;25,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;39,1->40,1;;25,50 semanas$$\n");
        sb.append("610;;cadastrarLogica;;40,1->41,1;;26,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;41,1->42,1;;26,50 semanas$$\n");
        sb.append("610;;cadastrarLogica;;42,1->43,1;;27,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;43,1->44,1;;27,50 semanas$$\n");
        sb.append("610;;cadastrarLogica;;44,1->45,1;;28,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;45,1->46,1;;28,50 semanas$$\n");
        sb.append("610;;cadastrarLogica;;46,1->47,1;;29,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;47,1->48,1;;30,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;48,1->49,1;;30,50 semanas$$\n");
        sb.append("610;;cadastrarLogica;;49,1->50,1;;31,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;50,1->51,1;;31,50 semanas$$\n");
        sb.append("610;;cadastrarLogica;;51,1->52,1;;32,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;52,1->53,1;;33,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;53,1->54,1;;33,50 semanas$$\n");
        sb.append("610;;cadastrarLogica;;54,1->55,1;;34,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;55,1->56,1;;35,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;56,1->57,1;;36,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;57,1->58,1;;37,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;58,1->59,1;;38,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;59,1->60,1;;39,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;60,1->61,1;;40,00 semanas$$\n");
        sb.append("610;;cadastrarLogica;;61,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tíbia">

        sb.append("611;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("611;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("611;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;10,1->11,1;;13,50 semanas$$\n");
        sb.append("611;;cadastrarLogica;;11,1->12,1;;14,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;12,1->13,1;;14,33 semanas$$\n");
        sb.append("611;;cadastrarLogica;;13,1->14,1;;14,67 semanas$$\n");
        sb.append("611;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;15,1->16,1;;15,50 semanas$$\n");
        sb.append("611;;cadastrarLogica;;16,1->17,1;;16,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;17,1->18,1;;16,33 semanas$$\n");
        sb.append("611;;cadastrarLogica;;18,1->19,1;;16,67 semanas$$\n");
        sb.append("611;;cadastrarLogica;;19,1->20,1;;17,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;20,1->21,1;;17,50 semanas$$\n");
        sb.append("611;;cadastrarLogica;;21,1->22,1;;18,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;22,1->23,1;;18,33 semanas$$\n");
        sb.append("611;;cadastrarLogica;;23,1->24,1;;18,67 semanas$$\n");
        sb.append("611;;cadastrarLogica;;24,1->25,1;;19,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;25,1->26,1;;19,50 semanas$$\n");
        sb.append("611;;cadastrarLogica;;26,1->27,1;;20,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;27,1->28,1;;20,33 semanas$$\n");
        sb.append("611;;cadastrarLogica;;28,1->29,1;;20,67 semanas$$\n");
        sb.append("611;;cadastrarLogica;;29,1->30,1;;21,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;30,1->31,1;;21,50 semanas$$\n");
        sb.append("611;;cadastrarLogica;;31,1->32,1;;22,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;32,1->33,1;;22,33 semanas$$\n");
        sb.append("611;;cadastrarLogica;;33,1->34,1;;22,67 semanas$$\n");
        sb.append("611;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("611;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;37,1->38,1;;24,33 semanas$$\n");
        sb.append("611;;cadastrarLogica;;38,1->39,1;;24,67 semanas$$\n");
        sb.append("611;;cadastrarLogica;;39,1->40,1;;25,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;40,1->41,1;;25,50 semanas$$\n");
        sb.append("611;;cadastrarLogica;;41,1->42,1;;26,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;42,1->43,1;;26,50 semanas$$\n");
        sb.append("611;;cadastrarLogica;;43,1->44,1;;27,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;44,1->45,1;;27,50 semanas$$\n");
        sb.append("611;;cadastrarLogica;;45,1->46,1;;28,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;46,1->47,1;;28,50 semanas$$\n");
        sb.append("611;;cadastrarLogica;;47,1->48,1;;29,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;48,1->49,1;;29,50 semanas$$\n");
        sb.append("611;;cadastrarLogica;;49,1->50,1;;30,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;50,1->51,1;;30,50 semanas$$\n");
        sb.append("611;;cadastrarLogica;;51,1->52,1;;31,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;52,1->53,1;;31,50 semanas$$\n");
        sb.append("611;;cadastrarLogica;;53,1->54,1;;32,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;54,1->55,1;;33,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;55,1->56,1;;33,50 semanas$$\n");
        sb.append("611;;cadastrarLogica;;56,1->57,1;;34,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;57,1->58,1;;35,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;58,1->59,1;;35,50 semanas$$\n");
        sb.append("611;;cadastrarLogica;;59,1->60,1;;36,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;60,1->61,1;;37,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;61,1->62,1;;37,50 semanas$$\n");
        sb.append("611;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;63,1->64,1;;39,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;64,1->65,1;;39,50 semanas$$\n");
        sb.append("611;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("611;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.A.">

        sb.append("613;;cadastrarLogica;;0,0->39,3;;<11,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;39,3->40,6;;11,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;40,6->41,9;;11,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;41,9->43,2;;11,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;43,2->44,5;;11,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;44,5->45,8;;11,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;45,8->47,0;;11,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;47,0->48,3;;11,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;48,3->49,6;;11,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;49,6->50,9;;11,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;50,9->52,2;;11,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;52,2->53,5;;12,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;53,5->54,8;;12,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;54,8->56,0;;12,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;56,0->57,3;;12,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;57,3->58,6;;12,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;58,6->59,9;;12,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;59,9->61,2;;12,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;61,2->62,4;;12,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;62,4->63,7;;12,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;63,7->65,0;;12,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;65,0->66,3;;13,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;66,3->67,5;;13,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;67,5->68,8;;13,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;68,8->70,1;;13,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;70,1->71,4;;13,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;71,4->72,6;;13,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;72,6->73,9;;13,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;73,9->75,2;;13,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;75,2->76,4;;13,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;76,4->77,7;;13,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;77,7->79,0;;14,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;79,0->80,2;;14,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;80,2->81,4;;14,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;81,4->82,7;;14,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;82,7->84,0;;14,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;84,0->85,2;;14,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;85,2->86,4;;14,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;86,4->87,7;;14,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;87,7->89,0;;14,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;89,0->90,2;;14,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;90,2->91,4;;15,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;91,4->92,7;;15,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;92,7->94,0;;15,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;94,0->95,2;;15,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;95,2->96,4;;15,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;96,4->97,7;;15,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;97,7->99,0;;15,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;99,0->100,2;;15,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;100,2->101,4;;15,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;101,4->102,7;;15,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;102,7->103,9;;16,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;103,9->105,2;;16,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;105,2->106,4;;16,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;106,4->107,6;;16,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;107,6->108,8;;16,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;108,8->110,1;;16,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;110,1->111,3;;16,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;111,3->112,5;;16,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;112,5->113,8;;16,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;113,8->115,0;;16,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;115,0->116,2;;17,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;116,2->117,4;;17,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;117,4->118,7;;17,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;118,7->119,9;;17,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;119,9->121,1;;17,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;121,1->122,3;;17,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;122,3->123,5;;17,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;123,5->124,8;;17,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;124,8->126,0;;17,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;126,0->127,2;;17,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;127,2->128,4;;18,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;128,4->129,6;;18,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;129,6->130,8;;18,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;130,8->132,0;;18,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;132,0->133,2;;18,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;133,2->134,4;;18,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;134,4->135,6;;18,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;135,6->136,8;;18,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;136,8->138,0;;18,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;138,0->139,2;;18,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;139,2->140,4;;19,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;140,4->141,6;;19,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;141,6->142,8;;19,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;142,8->144,0;;19,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;144,0->145,1;;19,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;145,1->146,3;;19,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;146,3->147,5;;19,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;147,5->148,7;;19,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;148,7->149,9;;19,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;149,9->151,1;;19,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;151,1->152,3;;20,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;152,3->153,4;;20,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;153,4->154,6;;20,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;154,6->155,8;;20,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;155,8->157,0;;20,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;157,0->158,1;;20,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;158,1->159,3;;20,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;159,3->160,5;;20,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;160,5->161,6;;20,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;161,6->162,8;;20,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;162,8->164,0;;21,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;164,0->165,1;;21,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;165,1->166,3;;21,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;166,3->167,4;;21,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;167,4->168,6;;21,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;168,6->169,8;;21,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;169,8->170,9;;21,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;170,9->172,1;;21,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;172,1->173,2;;21,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;173,2->174,4;;21,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;174,4->175,5;;22,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;175,5->176,7;;22,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;176,7->177,8;;22,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;177,8->179,0;;22,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;179,0->180,1;;22,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;180,1->181,2;;22,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;181,2->182,4;;22,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;182,4->183,5;;22,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;183,5->184,7;;22,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;184,7->185,8;;22,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;185,8->186,9;;23,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;186,9->188,0;;23,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;188,0->189,2;;23,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;189,2->190,3;;23,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;190,3->191,4;;23,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;191,4->192,5;;23,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;192,5->193,6;;23,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;193,6->194,8;;23,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;194,8->195,9;;23,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;195,9->197,0;;23,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;197,0->198,1;;24,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;198,1->199,2;;24,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;199,2->200,3;;24,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;200,3->201,4;;24,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;201,4->202,5;;24,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;202,5->203,6;;24,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;203,6->204,7;;24,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;204,7->205,8;;24,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;205,8->206,9;;24,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;206,9->208,0;;24,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;208,0->209,1;;25,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;209,1->210,2;;25,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;210,2->211,2;;25,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;211,2->212,3;;25,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;212,3->213,4;;25,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;213,4->214,5;;25,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;214,5->215,6;;25,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;215,6->216,6;;25,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;216,6->217,7;;25,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;217,7->218,8;;25,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;218,8->219,9;;26,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;219,9->220,9;;26,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;220,9->222,0;;26,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;222,0->223,0;;26,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;223,0->224,1;;26,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;224,1->225,2;;26,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;225,2->226,2;;26,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;226,2->227,3;;26,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;227,3->228,3;;26,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;228,3->229,4;;26,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;229,4->230,4;;27,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;230,4->231,5;;27,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;231,5->232,5;;27,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;232,5->233,6;;27,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;233,6->234,6;;27,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;234,6->235,6;;27,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;235,6->236,7;;27,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;236,7->237,7;;27,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;237,7->238,8;;27,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;238,8->239,8;;27,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;239,8->240,8;;28,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;240,8->241,8;;28,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;241,8->242,8;;28,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;242,8->243,8;;28,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;243,8->244,9;;28,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;244,9->245,9;;28,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;245,9->246,9;;28,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;246,9->247,9;;28,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;247,9->248,9;;28,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;248,9->249,9;;28,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;249,9->250,9;;29,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;250,9->251,9;;29,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;251,9->252,9;;29,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;252,9->253,9;;29,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;253,9->254,9;;29,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;254,9->255,8;;29,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;255,8->256,8;;29,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;256,8->257,8;;29,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;257,8->258,8;;29,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;258,8->259,8;;29,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;259,8->260,8;;30,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;260,8->261,7;;30,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;261,7->262,7;;30,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;262,7->263,7;;30,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;263,7->264,6;;30,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;264,6->265,6;;30,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;265,6->266,6;;30,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;266,6->267,6;;30,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;267,6->268,5;;30,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;268,5->269,5;;30,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;269,5->270,4;;31,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;270,4->271,4;;31,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;271,4->272,4;;31,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;272,4->273,3;;31,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;273,3->274,2;;31,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;274,2->275,2;;31,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;275,2->276,2;;31,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;276,2->277,1;;31,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;277,1->278,0;;31,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;278,0->279,0;;31,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;279,0->279,9;;32,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;279,9->280,8;;32,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;280,8->281,7;;32,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;281,7->282,6;;32,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;282,6->283,6;;32,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;283,6->284,5;;32,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;284,5->285,4;;32,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;285,4->286,3;;32,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;286,3->287,2;;32,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;287,2->288,1;;32,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;288,1->289,0;;33,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;289,0->289,9;;33,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;289,9->290,8;;33,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;290,8->291,7;;33,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;291,7->292,6;;33,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;292,6->293,5;;33,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;293,5->294,4;;33,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;294,4->295,3;;33,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;295,3->296,2;;33,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;296,2->297,1;;33,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;297,1->298,0;;34,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;298,0->298,8;;34,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;298,8->299,7;;34,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;299,7->300,5;;34,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;300,5->301,4;;34,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;301,4->302,3;;34,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;302,3->303,1;;34,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;303,1->304,0;;34,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;304,0->304,8;;34,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;304,8->305,7;;34,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;305,7->306,5;;35,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;306,5->307,4;;35,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;307,4->308,2;;35,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;308,2->309,1;;35,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;309,1->309,9;;35,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;309,9->310,7;;35,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;310,7->311,6;;35,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;311,6->312,4;;35,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;312,4->313,3;;35,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;313,3->314,1;;35,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;314,1->314,9;;36,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;314,9->315,7;;36,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;315,7->316,5;;36,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;316,5->317,3;;36,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;317,3->318,1;;36,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;318,1->318,9;;36,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;318,9->319,7;;36,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;319,7->320,5;;36,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;320,5->321,3;;36,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;321,3->322,1;;36,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;322,1->322,9;;37,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;322,9->323,7;;37,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;323,7->324,4;;37,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;324,4->325,2;;37,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;325,2->326,0;;37,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;326,0->326,8;;37,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;326,8->327,6;;37,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;327,6->328,3;;37,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;328,3->329,1;;37,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;329,1->329,9;;37,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;329,9->330,6;;38,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;330,6->331,4;;38,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;331,4->332,2;;38,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;332,2->332,9;;38,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;332,9->333,6;;38,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;333,6->334,4;;38,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;334,4->335,2;;38,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;335,2->335,9;;38,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;335,9->336,6;;38,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;336,6->337,4;;38,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;337,4->338,1;;39,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;338,1->338,8;;39,10 semanas$$\n");
        sb.append("613;;cadastrarLogica;;338,8->339,5;;39,20 semanas$$\n");
        sb.append("613;;cadastrarLogica;;339,5->340,2;;39,30 semanas$$\n");
        sb.append("613;;cadastrarLogica;;340,2->341,0;;39,40 semanas$$\n");
        sb.append("613;;cadastrarLogica;;341,0->341,7;;39,50 semanas$$\n");
        sb.append("613;;cadastrarLogica;;341,7->342,4;;39,60 semanas$$\n");
        sb.append("613;;cadastrarLogica;;342,4->343,1;;39,70 semanas$$\n");
        sb.append("613;;cadastrarLogica;;343,1->343,8;;39,80 semanas$$\n");
        sb.append("613;;cadastrarLogica;;343,8->344,5;;39,90 semanas$$\n");
        sb.append("613;;cadastrarLogica;;344,5->346,1;;40,00 semanas$$\n");
        sb.append("613;;cadastrarLogica;;346,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.C.">

        sb.append("614;;cadastrarLogica;;0,0->53,2;;<11,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;53,2->54,6;;11,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;54,6->56,1;;11,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;56,1->57,5;;11,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;57,5->58,9;;11,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;58,9->60,4;;11,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;60,4->61,8;;11,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;61,8->63,2;;11,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;63,2->64,6;;11,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;64,6->66,1;;11,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;66,1->67,5;;11,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;67,5->68,9;;12,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;68,9->70,4;;12,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;70,4->71,8;;12,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;71,8->73,2;;12,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;73,2->74,6;;12,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;74,6->76,1;;12,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;76,1->77,5;;12,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;77,5->78,9;;12,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;78,9->80,4;;12,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;80,4->81,8;;12,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;81,8->83,2;;13,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;83,2->84,5;;13,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;84,5->85,9;;13,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;85,9->87,3;;13,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;87,3->88,6;;13,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;88,6->90,0;;13,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;90,0->91,4;;13,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;91,4->92,8;;13,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;92,8->94,1;;13,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;94,1->95,5;;13,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;95,5->96,9;;14,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;96,9->98,2;;14,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;98,2->99,6;;14,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;99,6->101,0;;14,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;101,0->102,4;;14,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;102,4->103,7;;14,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;103,7->105,1;;14,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;105,1->106,5;;14,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;106,5->107,8;;14,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;107,8->109,2;;14,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;109,2->110,6;;15,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;110,6->111,9;;15,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;111,9->113,2;;15,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;113,2->114,6;;15,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;114,6->116,0;;15,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;116,0->117,3;;15,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;117,3->118,6;;15,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;118,6->120,0;;15,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;120,0->121,4;;15,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;121,4->122,7;;15,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;122,7->124,0;;16,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;124,0->125,3;;16,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;125,3->126,6;;16,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;126,6->127,9;;16,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;127,9->129,2;;16,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;129,2->130,6;;16,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;130,6->131,9;;16,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;131,9->133,2;;16,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;133,2->134,5;;16,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;134,5->135,8;;16,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;135,8->137,1;;17,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;137,1->138,4;;17,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;138,4->139,7;;17,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;139,7->141,0;;17,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;141,0->142,2;;17,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;142,2->143,5;;17,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;143,5->144,8;;17,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;144,8->146,1;;17,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;146,1->147,4;;17,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;147,4->148,7;;17,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;148,7->150,0;;18,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;150,0->151,2;;18,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;151,2->152,5;;18,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;152,5->153,7;;18,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;153,7->155,0;;18,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;155,0->156,3;;18,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;156,3->157,5;;18,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;157,5->158,8;;18,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;158,8->160,0;;18,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;160,0->161,3;;18,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;161,3->162,5;;19,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;162,5->163,7;;19,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;163,7->165,0;;19,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;165,0->166,2;;19,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;166,2->167,4;;19,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;167,4->168,6;;19,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;168,6->169,8;;19,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;169,8->171,1;;19,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;171,1->172,3;;19,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;172,3->173,5;;19,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;173,5->174,7;;20,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;174,7->175,9;;20,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;175,9->177,1;;20,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;177,1->178,3;;20,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;178,3->179,5;;20,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;179,5->180,7;;20,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;180,7->181,9;;20,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;181,9->183,1;;20,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;183,1->184,3;;20,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;184,3->185,5;;20,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;185,5->186,6;;21,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;186,6->187,8;;21,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;187,8->189,0;;21,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;189,0->190,1;;21,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;190,1->191,2;;21,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;191,2->192,4;;21,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;192,4->193,6;;21,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;193,6->194,7;;21,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;194,7->195,8;;21,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;195,8->197,0;;21,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;197,0->198,1;;22,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;198,1->199,3;;22,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;199,3->200,4;;22,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;200,4->201,5;;22,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;201,5->202,6;;22,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;202,6->203,8;;22,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;203,8->204,9;;22,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;204,9->206,0;;22,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;206,0->207,2;;22,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;207,2->208,3;;22,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;208,3->209,4;;23,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;209,4->210,5;;23,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;210,5->211,5;;23,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;211,5->212,6;;23,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;212,6->213,7;;23,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;213,7->214,8;;23,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;214,8->215,9;;23,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;215,9->216,9;;23,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;216,9->218,0;;23,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;218,0->219,1;;23,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;219,1->220,1;;24,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;220,1->221,2;;24,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;221,2->222,2;;24,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;222,2->223,3;;24,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;223,3->224,3;;24,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;224,3->225,3;;24,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;225,3->226,4;;24,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;226,4->227,4;;24,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;227,4->228,5;;24,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;228,5->229,5;;24,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;229,5->230,5;;25,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;230,5->231,5;;25,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;231,5->232,5;;25,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;232,5->233,5;;25,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;233,5->234,5;;25,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;234,5->235,5;;25,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;235,5->236,5;;25,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;236,5->237,5;;25,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;237,5->238,5;;25,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;238,5->239,5;;25,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;239,5->240,5;;26,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;240,5->241,4;;26,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;241,4->242,4;;26,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;242,4->243,3;;26,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;243,3->244,3;;26,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;244,3->245,3;;26,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;245,3->246,2;;26,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;246,2->247,2;;26,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;247,2->248,1;;26,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;248,1->249,1;;26,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;249,1->250,0;;27,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;250,0->250,9;;27,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;250,9->251,9;;27,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;251,9->252,8;;27,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;252,8->253,7;;27,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;253,7->254,6;;27,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;254,6->255,5;;27,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;255,5->256,5;;27,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;256,5->257,4;;27,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;257,4->258,3;;27,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;258,3->259,2;;28,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;259,2->260,0;;28,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;260,0->260,9;;28,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;260,9->261,7;;28,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;261,7->262,6;;28,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;262,6->263,5;;28,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;263,5->264,3;;28,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;264,3->265,2;;28,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;265,2->266,0;;28,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;266,0->266,9;;28,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;266,9->267,7;;29,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;267,7->268,5;;29,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;268,5->269,4;;29,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;269,4->270,2;;29,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;270,2->271,0;;29,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;271,0->271,8;;29,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;271,8->272,6;;29,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;272,6->273,5;;29,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;273,5->274,3;;29,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;274,3->275,1;;29,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;275,1->275,9;;30,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;275,9->276,6;;30,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;276,6->277,4;;30,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;277,4->278,2;;30,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;278,2->279,0;;30,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;279,0->279,7;;30,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;279,7->280,5;;30,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;280,5->281,3;;30,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;281,3->282,0;;30,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;282,0->282,8;;30,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;282,8->283,5;;31,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;283,5->284,2;;31,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;284,2->284,9;;31,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;284,9->285,6;;31,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;285,6->286,4;;31,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;286,4->287,1;;31,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;287,1->287,8;;31,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;287,8->288,5;;31,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;288,5->289,2;;31,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;289,2->289,9;;31,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;289,9->290,6;;32,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;290,6->291,2;;32,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;291,2->291,9;;32,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;291,9->292,6;;32,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;292,6->293,2;;32,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;293,2->293,9;;32,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;293,9->294,6;;32,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;294,6->295,3;;32,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;295,3->295,9;;32,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;295,9->296,6;;32,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;296,6->297,2;;33,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;297,2->297,8;;33,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;297,8->298,4;;33,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;298,4->299,0;;33,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;299,0->299,6;;33,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;299,6->300,3;;33,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;300,3->300,9;;33,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;300,9->301,5;;33,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;301,5->302,1;;33,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;302,1->302,7;;33,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;302,7->303,2;;34,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;303,2->303,8;;34,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;303,8->304,3;;34,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;304,3->304,9;;34,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;304,9->305,4;;34,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;305,4->306,0;;34,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;306,0->306,6;;34,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;306,6->307,1;;34,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;307,1->307,6;;34,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;307,6->308,2;;34,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;308,2->308,7;;35,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;308,7->309,2;;35,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;309,2->309,7;;35,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;309,7->310,2;;35,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;310,2->310,6;;35,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;310,6->311,1;;35,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;311,1->311,6;;35,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;311,6->312,1;;35,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;312,1->312,6;;35,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;312,6->313,1;;35,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;313,1->313,5;;36,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;313,5->314,0;;36,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;314,0->314,4;;36,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;314,4->314,9;;36,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;314,9->315,3;;36,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;315,3->315,7;;36,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;315,7->316,2;;36,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;316,2->316,6;;36,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;316,6->317,1;;36,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;317,1->317,5;;36,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;317,5->317,9;;37,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;317,9->318,2;;37,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;318,2->318,6;;37,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;318,6->319,0;;37,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;319,0->319,4;;37,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;319,4->319,7;;37,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;319,7->320,1;;37,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;320,1->320,5;;37,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;320,5->320,8;;37,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;320,8->321,2;;37,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;321,2->321,5;;38,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;321,5->321,8;;38,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;321,8->322,1;;38,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;322,1->322,4;;38,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;322,4->322,8;;38,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;322,8->323,1;;38,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;323,1->323,4;;38,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;323,4->323,7;;38,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;323,7->324,0;;38,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;324,0->324,3;;38,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;324,3->324,5;;39,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;324,5->324,8;;39,10 semanas$$\n");
        sb.append("614;;cadastrarLogica;;324,8->325,0;;39,20 semanas$$\n");
        sb.append("614;;cadastrarLogica;;325,0->325,3;;39,30 semanas$$\n");
        sb.append("614;;cadastrarLogica;;325,3->325,5;;39,40 semanas$$\n");
        sb.append("614;;cadastrarLogica;;325,5->325,7;;39,50 semanas$$\n");
        sb.append("614;;cadastrarLogica;;325,7->326,0;;39,60 semanas$$\n");
        sb.append("614;;cadastrarLogica;;326,0->326,2;;39,70 semanas$$\n");
        sb.append("614;;cadastrarLogica;;326,2->326,5;;39,80 semanas$$\n");
        sb.append("614;;cadastrarLogica;;326,5->326,7;;39,90 semanas$$\n");
        sb.append("614;;cadastrarLogica;;326,7->328,1;;40,00 semanas$$\n");
        sb.append("614;;cadastrarLogica;;328,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("612;;cadastrarLogica;;0,0->15,7;;<11,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;15,7->16,0;;11,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;16,0->16,4;;11,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;16,4->16,7;;11,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;16,7->17,1;;11,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;17,1->17,4;;11,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;17,4->17,7;;11,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;17,7->18,1;;11,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;18,1->18,4;;11,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;18,4->18,8;;11,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;18,8->19,1;;11,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;19,1->19,4;;12,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;19,4->19,7;;12,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;19,7->20,1;;12,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;20,1->20,4;;12,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;20,4->20,7;;12,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;20,7->21,0;;12,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;21,0->21,3;;12,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;21,3->21,7;;12,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;21,7->22,0;;12,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;22,0->22,3;;12,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;22,3->22,8;;13,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;22,8->23,2;;13,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;23,2->23,7;;13,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;23,7->24,2;;13,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;24,2->24,6;;13,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;24,6->25,1;;13,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;25,1->25,6;;13,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;25,6->26,1;;13,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;26,1->26,5;;13,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;26,5->27,0;;13,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;27,0->27,4;;14,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;27,4->27,7;;14,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;27,7->28,1;;14,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;28,1->28,5;;14,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;28,5->28,8;;14,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;28,8->29,2;;14,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;29,2->29,6;;14,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;29,6->30,0;;14,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;30,0->30,3;;14,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;30,3->30,7;;14,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;30,7->31,1;;15,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;31,1->31,4;;15,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;31,4->31,8;;15,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;31,8->32,1;;15,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;32,1->32,5;;15,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;32,5->32,9;;15,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;32,9->33,2;;15,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;33,2->33,6;;15,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;33,6->33,9;;15,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;33,9->34,3;;15,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;34,3->34,7;;16,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;34,7->35,0;;16,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;35,0->35,4;;16,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;35,4->35,7;;16,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;35,7->36,1;;16,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;36,1->36,5;;16,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;36,5->36,8;;16,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;36,8->37,2;;16,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;37,2->37,5;;16,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;37,5->37,9;;16,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;37,9->38,2;;17,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;38,2->38,6;;17,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;38,6->38,9;;17,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;38,9->39,3;;17,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;39,3->39,6;;17,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;39,6->39,9;;17,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;39,9->40,3;;17,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;40,3->40,6;;17,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;40,6->41,0;;17,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;41,0->41,3;;17,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;41,3->41,6;;18,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;41,6->42,0;;18,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;42,0->42,3;;18,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;42,3->42,7;;18,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;42,7->43,0;;18,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;43,0->43,3;;18,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;43,3->43,7;;18,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;43,7->44,0;;18,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;44,0->44,4;;18,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;44,4->44,7;;18,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;44,7->45,0;;19,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;45,0->45,4;;19,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;45,4->45,7;;19,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;45,7->46,1;;19,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;46,1->46,4;;19,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;46,4->46,7;;19,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;46,7->47,1;;19,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;47,1->47,4;;19,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;47,4->47,8;;19,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;47,8->48,1;;19,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;48,1->48,4;;20,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;48,4->48,7;;20,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;48,7->49,1;;20,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;49,1->49,4;;20,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;49,4->49,7;;20,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;49,7->50,0;;20,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;50,0->50,3;;20,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;50,3->50,7;;20,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;50,7->51,0;;20,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;51,0->51,3;;20,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;51,3->51,6;;21,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;51,6->51,9;;21,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;51,9->52,3;;21,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;52,3->52,6;;21,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;52,6->52,9;;21,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;52,9->53,2;;21,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;53,2->53,5;;21,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;53,5->53,9;;21,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;53,9->54,2;;21,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;54,2->54,5;;21,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;54,5->54,8;;22,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;54,8->55,1;;22,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;55,1->55,4;;22,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;55,4->55,7;;22,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;55,7->56,0;;22,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;56,0->56,3;;22,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;56,3->56,6;;22,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;56,6->56,9;;22,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;56,9->57,2;;22,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;57,2->57,5;;22,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;57,5->57,8;;23,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;57,8->58,1;;23,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;58,1->58,4;;23,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;58,4->58,7;;23,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;58,7->59,0;;23,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;59,0->59,3;;23,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;59,3->59,6;;23,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;59,6->59,9;;23,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;59,9->60,2;;23,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;60,2->60,5;;23,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;60,5->60,8;;24,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;60,8->61,1;;24,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;61,1->61,4;;24,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;61,4->61,7;;24,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;61,7->62,0;;24,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;62,0->62,2;;24,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;62,2->62,5;;24,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;62,5->62,8;;24,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;62,8->63,1;;24,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;63,1->63,4;;24,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;63,4->63,7;;25,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;63,7->64,0;;25,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;64,0->64,2;;25,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;64,2->64,5;;25,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;64,5->64,8;;25,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;64,8->65,1;;25,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;65,1->65,4;;25,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;65,4->65,6;;25,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;65,6->65,9;;25,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;65,9->66,2;;25,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;66,2->66,5;;26,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;66,5->66,7;;26,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;66,7->67,0;;26,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;67,0->67,3;;26,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;67,3->67,6;;26,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;67,6->67,8;;26,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;67,8->68,1;;26,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;68,1->68,4;;26,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;68,4->68,6;;26,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;68,6->68,9;;26,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;68,9->69,2;;27,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;69,2->69,4;;27,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;69,4->69,6;;27,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;69,6->69,9;;27,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;69,9->70,2;;27,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;70,2->70,4;;27,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;70,4->70,6;;27,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;70,6->70,9;;27,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;70,9->71,2;;27,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;71,2->71,4;;27,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;71,4->71,6;;28,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;71,6->71,9;;28,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;71,9->72,2;;28,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;72,2->72,4;;28,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;72,4->72,6;;28,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;72,6->72,9;;28,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;72,9->73,2;;28,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;73,2->73,4;;28,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;73,4->73,6;;28,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;73,6->73,9;;28,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;73,9->74,1;;29,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;74,1->74,4;;29,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;74,4->74,6;;29,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;74,6->74,8;;29,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;74,8->75,1;;29,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;75,1->75,3;;29,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;75,3->75,5;;29,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;75,5->75,7;;29,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;75,7->76,0;;29,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;76,0->76,2;;29,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;76,2->76,4;;30,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;76,4->76,7;;30,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;76,7->76,9;;30,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;76,9->77,1;;30,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;77,1->77,4;;30,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;77,4->77,6;;30,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;77,6->77,8;;30,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;77,8->78,0;;30,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;78,0->78,3;;30,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;78,3->78,5;;30,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;78,5->78,7;;31,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;78,7->78,9;;31,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;78,9->79,1;;31,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;79,1->79,3;;31,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;79,3->79,6;;31,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;79,6->79,8;;31,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;79,8->80,0;;31,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;80,0->80,2;;31,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;80,2->80,4;;31,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;80,4->80,6;;31,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;80,6->80,8;;32,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;80,8->81,0;;32,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;81,0->81,2;;32,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;81,2->81,4;;32,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;81,4->81,6;;32,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;81,6->81,7;;32,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;81,7->81,9;;32,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;81,9->82,1;;32,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;82,1->82,3;;32,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;82,3->82,5;;32,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;82,5->82,7;;33,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;82,7->82,9;;33,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;82,9->83,1;;33,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;83,1->83,3;;33,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;83,3->83,4;;33,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;83,4->83,6;;33,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;83,6->83,8;;33,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;83,8->84,0;;33,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;84,0->84,2;;33,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;84,2->84,4;;33,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;84,4->84,6;;34,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;84,6->84,7;;34,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;84,7->84,9;;34,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;84,9->85,1;;34,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;85,1->85,2;;34,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;85,2->85,4;;34,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;85,4->85,6;;34,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;85,6->85,8;;34,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;85,8->85,9;;34,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;85,9->86,1;;34,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;86,1->86,2;;35,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;86,2->86,4;;35,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;86,4->86,6;;35,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;86,6->86,7;;35,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;86,7->86,8;;35,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;86,8->87,0;;35,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;87,0->87,1;;35,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;87,1->87,3;;35,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;87,3->87,4;;35,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;87,4->87,6;;35,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;87,6->87,8;;36,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;87,8->87,9;;36,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;87,9->88,0;;36,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;88,0->88,2;;36,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;88,2->88,4;;36,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;88,4->88,5;;36,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;88,5->88,6;;36,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;88,6->88,8;;36,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;88,8->88,9;;36,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;88,9->89,1;;36,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;89,1->89,2;;37,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;89,2->89,3;;37,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;89,3->89,5;;37,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;89,5->89,6;;37,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;89,6->89,7;;37,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;89,7->89,8;;37,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;89,8->89,9;;37,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;89,9->90,1;;37,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;90,1->90,2;;37,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;90,2->90,3;;37,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;90,3->90,4;;38,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;90,4->90,5;;38,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;90,5->90,6;;38,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;90,6->90,7;;38,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;90,7->90,8;;38,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;90,8->91,0;;38,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;91,0->91,1;;38,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;91,1->91,2;;38,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;91,2->91,3;;38,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;91,3->91,4;;38,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;91,4->91,5;;39,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;91,5->91,6;;39,10 semanas$$\n");
        sb.append("612;;cadastrarLogica;;91,6->91,7;;39,20 semanas$$\n");
        sb.append("612;;cadastrarLogica;;91,7->91,8;;39,30 semanas$$\n");
        sb.append("612;;cadastrarLogica;;91,8->91,9;;39,40 semanas$$\n");
        sb.append("612;;cadastrarLogica;;91,9->92,0;;39,50 semanas$$\n");
        sb.append("612;;cadastrarLogica;;92,0->92,1;;39,60 semanas$$\n");
        sb.append("612;;cadastrarLogica;;92,1->92,2;;39,70 semanas$$\n");
        sb.append("612;;cadastrarLogica;;92,2->92,3;;39,80 semanas$$\n");
        sb.append("612;;cadastrarLogica;;92,3->92,4;;39,90 semanas$$\n");
        sb.append("612;;cadastrarLogica;;92,4->93,1;;40,00 semanas$$\n");
        sb.append("612;;cadastrarLogica;;93,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

    }

    private static void preencherIghFeto3 ()
    {

        // <editor-fold defaultstate="collapsed" desc="Fêmur">

        sb.append("615;;cadastrarLogica;;0,0->7,1;;<12,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;7,1->8,1;;12,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;8,1->9,1;;12,33 semanas$$\n");
        sb.append("615;;cadastrarLogica;;9,1->10,1;;12,67 semanas$$\n");
        sb.append("615;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("615;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("615;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("615;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("615;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("615;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("615;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;20,1->21,1;;16,33 semanas$$\n");
        sb.append("615;;cadastrarLogica;;21,1->22,1;;16,67 semanas$$\n");
        sb.append("615;;cadastrarLogica;;22,1->23,1;;17,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;23,1->24,1;;17,50 semanas$$\n");
        sb.append("615;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("615;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("615;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;28,1->29,1;;19,33 semanas$$\n");
        sb.append("615;;cadastrarLogica;;29,1->30,1;;19,67 semanas$$\n");
        sb.append("615;;cadastrarLogica;;30,1->31,1;;20,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;31,1->32,1;;20,33 semanas$$\n");
        sb.append("615;;cadastrarLogica;;32,1->33,1;;20,67 semanas$$\n");
        sb.append("615;;cadastrarLogica;;33,1->34,1;;21,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;34,1->35,1;;21,50 semanas$$\n");
        sb.append("615;;cadastrarLogica;;35,1->36,1;;22,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;36,1->37,1;;22,33 semanas$$\n");
        sb.append("615;;cadastrarLogica;;37,1->38,1;;22,67 semanas$$\n");
        sb.append("615;;cadastrarLogica;;38,1->39,1;;23,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;39,1->40,1;;23,33 semanas$$\n");
        sb.append("615;;cadastrarLogica;;40,1->41,1;;23,67 semanas$$\n");
        sb.append("615;;cadastrarLogica;;41,1->42,1;;24,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;42,1->43,1;;24,50 semanas$$\n");
        sb.append("615;;cadastrarLogica;;43,1->44,1;;25,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;44,1->45,1;;25,33 semanas$$\n");
        sb.append("615;;cadastrarLogica;;45,1->46,1;;25,67 semanas$$\n");
        sb.append("615;;cadastrarLogica;;46,1->47,1;;26,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;47,1->48,1;;26,50 semanas$$\n");
        sb.append("615;;cadastrarLogica;;48,1->49,1;;27,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;49,1->50,1;;27,33 semanas$$\n");
        sb.append("615;;cadastrarLogica;;50,1->51,1;;27,67 semanas$$\n");
        sb.append("615;;cadastrarLogica;;51,1->52,1;;28,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;52,1->53,1;;28,50 semanas$$\n");
        sb.append("615;;cadastrarLogica;;53,1->54,1;;29,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;54,1->55,1;;29,50 semanas$$\n");
        sb.append("615;;cadastrarLogica;;55,1->56,1;;30,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;56,1->57,1;;30,33 semanas$$\n");
        sb.append("615;;cadastrarLogica;;57,1->58,1;;30,67 semanas$$\n");
        sb.append("615;;cadastrarLogica;;58,1->59,1;;31,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;59,1->60,1;;31,50 semanas$$\n");
        sb.append("615;;cadastrarLogica;;60,1->61,1;;32,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;61,1->62,1;;32,50 semanas$$\n");
        sb.append("615;;cadastrarLogica;;62,1->63,1;;33,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;63,1->64,1;;33,50 semanas$$\n");
        sb.append("615;;cadastrarLogica;;64,1->65,1;;34,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;65,1->66,1;;34,50 semanas$$\n");
        sb.append("615;;cadastrarLogica;;66,1->67,1;;35,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;67,1->68,1;;36,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;68,1->69,1;;36,50 semanas$$\n");
        sb.append("615;;cadastrarLogica;;69,1->70,1;;37,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;70,1->71,1;;38,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;71,1->72,1;;38,50 semanas$$\n");
        sb.append("615;;cadastrarLogica;;72,1->73,1;;39,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;73,1->74,1;;40,00 semanas$$\n");
        sb.append("615;;cadastrarLogica;;74,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Úmero">

        sb.append("616;;cadastrarLogica;;0,0->8,1;;<12,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;8,1->9,1;;12,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;9,1->10,1;;12,50 semanas$$\n");
        sb.append("616;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("616;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("616;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("616;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("616;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("616;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("616;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;20,1->21,1;;16,50 semanas$$\n");
        sb.append("616;;cadastrarLogica;;21,1->22,1;;17,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;22,1->23,1;;17,33 semanas$$\n");
        sb.append("616;;cadastrarLogica;;23,1->24,1;;17,67 semanas$$\n");
        sb.append("616;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("616;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("616;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;28,1->29,1;;19,50 semanas$$\n");
        sb.append("616;;cadastrarLogica;;29,1->30,1;;20,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;30,1->31,1;;20,33 semanas$$\n");
        sb.append("616;;cadastrarLogica;;31,1->32,1;;20,67 semanas$$\n");
        sb.append("616;;cadastrarLogica;;32,1->33,1;;21,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;33,1->34,1;;21,50 semanas$$\n");
        sb.append("616;;cadastrarLogica;;34,1->35,1;;22,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;35,1->36,1;;22,33 semanas$$\n");
        sb.append("616;;cadastrarLogica;;36,1->37,1;;22,67 semanas$$\n");
        sb.append("616;;cadastrarLogica;;37,1->38,1;;23,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;38,1->39,1;;23,50 semanas$$\n");
        sb.append("616;;cadastrarLogica;;39,1->40,1;;24,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;40,1->41,1;;24,50 semanas$$\n");
        sb.append("616;;cadastrarLogica;;41,1->42,1;;25,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;42,1->43,1;;25,50 semanas$$\n");
        sb.append("616;;cadastrarLogica;;43,1->44,1;;26,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;44,1->45,1;;26,50 semanas$$\n");
        sb.append("616;;cadastrarLogica;;45,1->46,1;;27,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;46,1->47,1;;27,50 semanas$$\n");
        sb.append("616;;cadastrarLogica;;47,1->48,1;;28,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;48,1->49,1;;28,50 semanas$$\n");
        sb.append("616;;cadastrarLogica;;49,1->50,1;;29,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;50,1->51,1;;30,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;51,1->52,1;;30,50 semanas$$\n");
        sb.append("616;;cadastrarLogica;;52,1->53,1;;31,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;53,1->54,1;;31,50 semanas$$\n");
        sb.append("616;;cadastrarLogica;;54,1->55,1;;32,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;55,1->56,1;;33,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;56,1->57,1;;33,50 semanas$$\n");
        sb.append("616;;cadastrarLogica;;57,1->58,1;;34,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;58,1->59,1;;35,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;59,1->60,1;;35,50 semanas$$\n");
        sb.append("616;;cadastrarLogica;;60,1->61,1;;36,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;61,1->62,1;;37,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;63,1->64,1;;38,50 semanas$$\n");
        sb.append("616;;cadastrarLogica;;64,1->65,1;;39,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("616;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ulna">

        sb.append("617;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("617;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("617;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;10,1->11,1;;13,33 semanas$$\n");
        sb.append("617;;cadastrarLogica;;11,1->12,1;;13,67 semanas$$\n");
        sb.append("617;;cadastrarLogica;;12,1->13,1;;14,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;13,1->14,1;;14,50 semanas$$\n");
        sb.append("617;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;15,1->16,1;;15,33 semanas$$\n");
        sb.append("617;;cadastrarLogica;;16,1->17,1;;15,67 semanas$$\n");
        sb.append("617;;cadastrarLogica;;17,1->18,1;;16,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;18,1->19,1;;16,33 semanas$$\n");
        sb.append("617;;cadastrarLogica;;19,1->20,1;;16,67 semanas$$\n");
        sb.append("617;;cadastrarLogica;;20,1->21,1;;17,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;21,1->22,1;;17,50 semanas$$\n");
        sb.append("617;;cadastrarLogica;;22,1->23,1;;18,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;23,1->24,1;;18,33 semanas$$\n");
        sb.append("617;;cadastrarLogica;;24,1->25,1;;18,67 semanas$$\n");
        sb.append("617;;cadastrarLogica;;25,1->26,1;;19,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;26,1->27,1;;19,50 semanas$$\n");
        sb.append("617;;cadastrarLogica;;27,1->28,1;;20,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;28,1->29,1;;20,33 semanas$$\n");
        sb.append("617;;cadastrarLogica;;29,1->30,1;;20,67 semanas$$\n");
        sb.append("617;;cadastrarLogica;;30,1->31,1;;21,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;31,1->32,1;;21,50 semanas$$\n");
        sb.append("617;;cadastrarLogica;;32,1->33,1;;22,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;33,1->34,1;;22,50 semanas$$\n");
        sb.append("617;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("617;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;37,1->38,1;;24,50 semanas$$\n");
        sb.append("617;;cadastrarLogica;;38,1->39,1;;25,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;39,1->40,1;;25,50 semanas$$\n");
        sb.append("617;;cadastrarLogica;;40,1->41,1;;26,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;41,1->42,1;;26,50 semanas$$\n");
        sb.append("617;;cadastrarLogica;;42,1->43,1;;27,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;43,1->44,1;;27,50 semanas$$\n");
        sb.append("617;;cadastrarLogica;;44,1->45,1;;28,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;45,1->46,1;;28,50 semanas$$\n");
        sb.append("617;;cadastrarLogica;;46,1->47,1;;29,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;47,1->48,1;;30,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;48,1->49,1;;30,50 semanas$$\n");
        sb.append("617;;cadastrarLogica;;49,1->50,1;;31,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;50,1->51,1;;31,50 semanas$$\n");
        sb.append("617;;cadastrarLogica;;51,1->52,1;;32,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;52,1->53,1;;33,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;53,1->54,1;;33,50 semanas$$\n");
        sb.append("617;;cadastrarLogica;;54,1->55,1;;34,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;55,1->56,1;;35,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;56,1->57,1;;36,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;57,1->58,1;;37,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;58,1->59,1;;38,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;59,1->60,1;;39,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;60,1->61,1;;40,00 semanas$$\n");
        sb.append("617;;cadastrarLogica;;61,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tíbia">

        sb.append("618;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("618;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("618;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;10,1->11,1;;13,50 semanas$$\n");
        sb.append("618;;cadastrarLogica;;11,1->12,1;;14,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;12,1->13,1;;14,33 semanas$$\n");
        sb.append("618;;cadastrarLogica;;13,1->14,1;;14,67 semanas$$\n");
        sb.append("618;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;15,1->16,1;;15,50 semanas$$\n");
        sb.append("618;;cadastrarLogica;;16,1->17,1;;16,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;17,1->18,1;;16,33 semanas$$\n");
        sb.append("618;;cadastrarLogica;;18,1->19,1;;16,67 semanas$$\n");
        sb.append("618;;cadastrarLogica;;19,1->20,1;;17,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;20,1->21,1;;17,50 semanas$$\n");
        sb.append("618;;cadastrarLogica;;21,1->22,1;;18,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;22,1->23,1;;18,33 semanas$$\n");
        sb.append("618;;cadastrarLogica;;23,1->24,1;;18,67 semanas$$\n");
        sb.append("618;;cadastrarLogica;;24,1->25,1;;19,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;25,1->26,1;;19,50 semanas$$\n");
        sb.append("618;;cadastrarLogica;;26,1->27,1;;20,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;27,1->28,1;;20,33 semanas$$\n");
        sb.append("618;;cadastrarLogica;;28,1->29,1;;20,67 semanas$$\n");
        sb.append("618;;cadastrarLogica;;29,1->30,1;;21,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;30,1->31,1;;21,50 semanas$$\n");
        sb.append("618;;cadastrarLogica;;31,1->32,1;;22,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;32,1->33,1;;22,33 semanas$$\n");
        sb.append("618;;cadastrarLogica;;33,1->34,1;;22,67 semanas$$\n");
        sb.append("618;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("618;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;37,1->38,1;;24,33 semanas$$\n");
        sb.append("618;;cadastrarLogica;;38,1->39,1;;24,67 semanas$$\n");
        sb.append("618;;cadastrarLogica;;39,1->40,1;;25,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;40,1->41,1;;25,50 semanas$$\n");
        sb.append("618;;cadastrarLogica;;41,1->42,1;;26,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;42,1->43,1;;26,50 semanas$$\n");
        sb.append("618;;cadastrarLogica;;43,1->44,1;;27,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;44,1->45,1;;27,50 semanas$$\n");
        sb.append("618;;cadastrarLogica;;45,1->46,1;;28,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;46,1->47,1;;28,50 semanas$$\n");
        sb.append("618;;cadastrarLogica;;47,1->48,1;;29,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;48,1->49,1;;29,50 semanas$$\n");
        sb.append("618;;cadastrarLogica;;49,1->50,1;;30,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;50,1->51,1;;30,50 semanas$$\n");
        sb.append("618;;cadastrarLogica;;51,1->52,1;;31,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;52,1->53,1;;31,50 semanas$$\n");
        sb.append("618;;cadastrarLogica;;53,1->54,1;;32,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;54,1->55,1;;33,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;55,1->56,1;;33,50 semanas$$\n");
        sb.append("618;;cadastrarLogica;;56,1->57,1;;34,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;57,1->58,1;;35,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;58,1->59,1;;35,50 semanas$$\n");
        sb.append("618;;cadastrarLogica;;59,1->60,1;;36,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;60,1->61,1;;37,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;61,1->62,1;;37,50 semanas$$\n");
        sb.append("618;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;63,1->64,1;;39,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;64,1->65,1;;39,50 semanas$$\n");
        sb.append("618;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("618;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.A.">

        sb.append("620;;cadastrarLogica;;0,0->39,3;;<11,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;39,3->40,6;;11,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;40,6->41,9;;11,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;41,9->43,2;;11,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;43,2->44,5;;11,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;44,5->45,8;;11,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;45,8->47,0;;11,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;47,0->48,3;;11,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;48,3->49,6;;11,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;49,6->50,9;;11,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;50,9->52,2;;11,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;52,2->53,5;;12,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;53,5->54,8;;12,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;54,8->56,0;;12,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;56,0->57,3;;12,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;57,3->58,6;;12,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;58,6->59,9;;12,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;59,9->61,2;;12,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;61,2->62,4;;12,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;62,4->63,7;;12,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;63,7->65,0;;12,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;65,0->66,3;;13,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;66,3->67,5;;13,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;67,5->68,8;;13,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;68,8->70,1;;13,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;70,1->71,4;;13,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;71,4->72,6;;13,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;72,6->73,9;;13,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;73,9->75,2;;13,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;75,2->76,4;;13,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;76,4->77,7;;13,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;77,7->79,0;;14,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;79,0->80,2;;14,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;80,2->81,4;;14,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;81,4->82,7;;14,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;82,7->84,0;;14,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;84,0->85,2;;14,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;85,2->86,4;;14,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;86,4->87,7;;14,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;87,7->89,0;;14,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;89,0->90,2;;14,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;90,2->91,4;;15,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;91,4->92,7;;15,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;92,7->94,0;;15,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;94,0->95,2;;15,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;95,2->96,4;;15,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;96,4->97,7;;15,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;97,7->99,0;;15,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;99,0->100,2;;15,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;100,2->101,4;;15,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;101,4->102,7;;15,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;102,7->103,9;;16,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;103,9->105,2;;16,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;105,2->106,4;;16,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;106,4->107,6;;16,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;107,6->108,8;;16,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;108,8->110,1;;16,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;110,1->111,3;;16,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;111,3->112,5;;16,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;112,5->113,8;;16,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;113,8->115,0;;16,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;115,0->116,2;;17,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;116,2->117,4;;17,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;117,4->118,7;;17,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;118,7->119,9;;17,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;119,9->121,1;;17,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;121,1->122,3;;17,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;122,3->123,5;;17,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;123,5->124,8;;17,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;124,8->126,0;;17,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;126,0->127,2;;17,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;127,2->128,4;;18,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;128,4->129,6;;18,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;129,6->130,8;;18,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;130,8->132,0;;18,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;132,0->133,2;;18,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;133,2->134,4;;18,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;134,4->135,6;;18,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;135,6->136,8;;18,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;136,8->138,0;;18,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;138,0->139,2;;18,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;139,2->140,4;;19,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;140,4->141,6;;19,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;141,6->142,8;;19,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;142,8->144,0;;19,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;144,0->145,1;;19,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;145,1->146,3;;19,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;146,3->147,5;;19,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;147,5->148,7;;19,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;148,7->149,9;;19,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;149,9->151,1;;19,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;151,1->152,3;;20,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;152,3->153,4;;20,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;153,4->154,6;;20,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;154,6->155,8;;20,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;155,8->157,0;;20,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;157,0->158,1;;20,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;158,1->159,3;;20,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;159,3->160,5;;20,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;160,5->161,6;;20,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;161,6->162,8;;20,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;162,8->164,0;;21,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;164,0->165,1;;21,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;165,1->166,3;;21,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;166,3->167,4;;21,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;167,4->168,6;;21,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;168,6->169,8;;21,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;169,8->170,9;;21,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;170,9->172,1;;21,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;172,1->173,2;;21,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;173,2->174,4;;21,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;174,4->175,5;;22,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;175,5->176,7;;22,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;176,7->177,8;;22,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;177,8->179,0;;22,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;179,0->180,1;;22,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;180,1->181,2;;22,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;181,2->182,4;;22,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;182,4->183,5;;22,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;183,5->184,7;;22,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;184,7->185,8;;22,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;185,8->186,9;;23,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;186,9->188,0;;23,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;188,0->189,2;;23,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;189,2->190,3;;23,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;190,3->191,4;;23,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;191,4->192,5;;23,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;192,5->193,6;;23,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;193,6->194,8;;23,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;194,8->195,9;;23,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;195,9->197,0;;23,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;197,0->198,1;;24,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;198,1->199,2;;24,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;199,2->200,3;;24,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;200,3->201,4;;24,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;201,4->202,5;;24,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;202,5->203,6;;24,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;203,6->204,7;;24,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;204,7->205,8;;24,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;205,8->206,9;;24,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;206,9->208,0;;24,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;208,0->209,1;;25,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;209,1->210,2;;25,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;210,2->211,2;;25,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;211,2->212,3;;25,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;212,3->213,4;;25,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;213,4->214,5;;25,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;214,5->215,6;;25,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;215,6->216,6;;25,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;216,6->217,7;;25,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;217,7->218,8;;25,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;218,8->219,9;;26,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;219,9->220,9;;26,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;220,9->222,0;;26,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;222,0->223,0;;26,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;223,0->224,1;;26,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;224,1->225,2;;26,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;225,2->226,2;;26,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;226,2->227,3;;26,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;227,3->228,3;;26,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;228,3->229,4;;26,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;229,4->230,4;;27,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;230,4->231,5;;27,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;231,5->232,5;;27,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;232,5->233,6;;27,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;233,6->234,6;;27,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;234,6->235,6;;27,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;235,6->236,7;;27,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;236,7->237,7;;27,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;237,7->238,8;;27,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;238,8->239,8;;27,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;239,8->240,8;;28,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;240,8->241,8;;28,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;241,8->242,8;;28,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;242,8->243,8;;28,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;243,8->244,9;;28,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;244,9->245,9;;28,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;245,9->246,9;;28,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;246,9->247,9;;28,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;247,9->248,9;;28,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;248,9->249,9;;28,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;249,9->250,9;;29,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;250,9->251,9;;29,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;251,9->252,9;;29,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;252,9->253,9;;29,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;253,9->254,9;;29,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;254,9->255,8;;29,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;255,8->256,8;;29,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;256,8->257,8;;29,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;257,8->258,8;;29,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;258,8->259,8;;29,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;259,8->260,8;;30,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;260,8->261,7;;30,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;261,7->262,7;;30,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;262,7->263,7;;30,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;263,7->264,6;;30,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;264,6->265,6;;30,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;265,6->266,6;;30,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;266,6->267,6;;30,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;267,6->268,5;;30,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;268,5->269,5;;30,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;269,5->270,4;;31,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;270,4->271,4;;31,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;271,4->272,4;;31,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;272,4->273,3;;31,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;273,3->274,2;;31,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;274,2->275,2;;31,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;275,2->276,2;;31,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;276,2->277,1;;31,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;277,1->278,0;;31,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;278,0->279,0;;31,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;279,0->279,9;;32,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;279,9->280,8;;32,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;280,8->281,7;;32,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;281,7->282,6;;32,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;282,6->283,6;;32,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;283,6->284,5;;32,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;284,5->285,4;;32,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;285,4->286,3;;32,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;286,3->287,2;;32,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;287,2->288,1;;32,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;288,1->289,0;;33,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;289,0->289,9;;33,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;289,9->290,8;;33,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;290,8->291,7;;33,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;291,7->292,6;;33,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;292,6->293,5;;33,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;293,5->294,4;;33,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;294,4->295,3;;33,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;295,3->296,2;;33,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;296,2->297,1;;33,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;297,1->298,0;;34,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;298,0->298,8;;34,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;298,8->299,7;;34,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;299,7->300,5;;34,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;300,5->301,4;;34,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;301,4->302,3;;34,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;302,3->303,1;;34,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;303,1->304,0;;34,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;304,0->304,8;;34,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;304,8->305,7;;34,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;305,7->306,5;;35,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;306,5->307,4;;35,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;307,4->308,2;;35,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;308,2->309,1;;35,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;309,1->309,9;;35,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;309,9->310,7;;35,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;310,7->311,6;;35,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;311,6->312,4;;35,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;312,4->313,3;;35,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;313,3->314,1;;35,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;314,1->314,9;;36,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;314,9->315,7;;36,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;315,7->316,5;;36,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;316,5->317,3;;36,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;317,3->318,1;;36,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;318,1->318,9;;36,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;318,9->319,7;;36,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;319,7->320,5;;36,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;320,5->321,3;;36,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;321,3->322,1;;36,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;322,1->322,9;;37,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;322,9->323,7;;37,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;323,7->324,4;;37,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;324,4->325,2;;37,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;325,2->326,0;;37,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;326,0->326,8;;37,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;326,8->327,6;;37,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;327,6->328,3;;37,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;328,3->329,1;;37,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;329,1->329,9;;37,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;329,9->330,6;;38,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;330,6->331,4;;38,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;331,4->332,2;;38,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;332,2->332,9;;38,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;332,9->333,6;;38,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;333,6->334,4;;38,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;334,4->335,2;;38,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;335,2->335,9;;38,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;335,9->336,6;;38,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;336,6->337,4;;38,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;337,4->338,1;;39,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;338,1->338,8;;39,10 semanas$$\n");
        sb.append("620;;cadastrarLogica;;338,8->339,5;;39,20 semanas$$\n");
        sb.append("620;;cadastrarLogica;;339,5->340,2;;39,30 semanas$$\n");
        sb.append("620;;cadastrarLogica;;340,2->341,0;;39,40 semanas$$\n");
        sb.append("620;;cadastrarLogica;;341,0->341,7;;39,50 semanas$$\n");
        sb.append("620;;cadastrarLogica;;341,7->342,4;;39,60 semanas$$\n");
        sb.append("620;;cadastrarLogica;;342,4->343,1;;39,70 semanas$$\n");
        sb.append("620;;cadastrarLogica;;343,1->343,8;;39,80 semanas$$\n");
        sb.append("620;;cadastrarLogica;;343,8->344,5;;39,90 semanas$$\n");
        sb.append("620;;cadastrarLogica;;344,5->346,1;;40,00 semanas$$\n");
        sb.append("620;;cadastrarLogica;;346,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.C.">

        sb.append("621;;cadastrarLogica;;0,0->53,2;;<11,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;53,2->54,6;;11,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;54,6->56,1;;11,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;56,1->57,5;;11,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;57,5->58,9;;11,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;58,9->60,4;;11,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;60,4->61,8;;11,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;61,8->63,2;;11,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;63,2->64,6;;11,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;64,6->66,1;;11,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;66,1->67,5;;11,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;67,5->68,9;;12,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;68,9->70,4;;12,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;70,4->71,8;;12,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;71,8->73,2;;12,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;73,2->74,6;;12,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;74,6->76,1;;12,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;76,1->77,5;;12,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;77,5->78,9;;12,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;78,9->80,4;;12,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;80,4->81,8;;12,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;81,8->83,2;;13,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;83,2->84,5;;13,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;84,5->85,9;;13,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;85,9->87,3;;13,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;87,3->88,6;;13,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;88,6->90,0;;13,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;90,0->91,4;;13,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;91,4->92,8;;13,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;92,8->94,1;;13,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;94,1->95,5;;13,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;95,5->96,9;;14,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;96,9->98,2;;14,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;98,2->99,6;;14,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;99,6->101,0;;14,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;101,0->102,4;;14,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;102,4->103,7;;14,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;103,7->105,1;;14,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;105,1->106,5;;14,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;106,5->107,8;;14,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;107,8->109,2;;14,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;109,2->110,6;;15,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;110,6->111,9;;15,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;111,9->113,2;;15,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;113,2->114,6;;15,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;114,6->116,0;;15,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;116,0->117,3;;15,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;117,3->118,6;;15,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;118,6->120,0;;15,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;120,0->121,4;;15,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;121,4->122,7;;15,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;122,7->124,0;;16,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;124,0->125,3;;16,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;125,3->126,6;;16,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;126,6->127,9;;16,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;127,9->129,2;;16,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;129,2->130,6;;16,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;130,6->131,9;;16,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;131,9->133,2;;16,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;133,2->134,5;;16,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;134,5->135,8;;16,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;135,8->137,1;;17,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;137,1->138,4;;17,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;138,4->139,7;;17,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;139,7->141,0;;17,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;141,0->142,2;;17,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;142,2->143,5;;17,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;143,5->144,8;;17,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;144,8->146,1;;17,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;146,1->147,4;;17,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;147,4->148,7;;17,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;148,7->150,0;;18,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;150,0->151,2;;18,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;151,2->152,5;;18,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;152,5->153,7;;18,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;153,7->155,0;;18,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;155,0->156,3;;18,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;156,3->157,5;;18,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;157,5->158,8;;18,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;158,8->160,0;;18,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;160,0->161,3;;18,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;161,3->162,5;;19,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;162,5->163,7;;19,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;163,7->165,0;;19,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;165,0->166,2;;19,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;166,2->167,4;;19,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;167,4->168,6;;19,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;168,6->169,8;;19,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;169,8->171,1;;19,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;171,1->172,3;;19,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;172,3->173,5;;19,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;173,5->174,7;;20,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;174,7->175,9;;20,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;175,9->177,1;;20,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;177,1->178,3;;20,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;178,3->179,5;;20,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;179,5->180,7;;20,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;180,7->181,9;;20,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;181,9->183,1;;20,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;183,1->184,3;;20,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;184,3->185,5;;20,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;185,5->186,6;;21,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;186,6->187,8;;21,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;187,8->189,0;;21,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;189,0->190,1;;21,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;190,1->191,2;;21,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;191,2->192,4;;21,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;192,4->193,6;;21,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;193,6->194,7;;21,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;194,7->195,8;;21,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;195,8->197,0;;21,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;197,0->198,1;;22,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;198,1->199,3;;22,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;199,3->200,4;;22,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;200,4->201,5;;22,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;201,5->202,6;;22,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;202,6->203,8;;22,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;203,8->204,9;;22,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;204,9->206,0;;22,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;206,0->207,2;;22,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;207,2->208,3;;22,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;208,3->209,4;;23,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;209,4->210,5;;23,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;210,5->211,5;;23,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;211,5->212,6;;23,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;212,6->213,7;;23,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;213,7->214,8;;23,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;214,8->215,9;;23,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;215,9->216,9;;23,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;216,9->218,0;;23,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;218,0->219,1;;23,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;219,1->220,1;;24,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;220,1->221,2;;24,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;221,2->222,2;;24,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;222,2->223,3;;24,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;223,3->224,3;;24,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;224,3->225,3;;24,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;225,3->226,4;;24,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;226,4->227,4;;24,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;227,4->228,5;;24,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;228,5->229,5;;24,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;229,5->230,5;;25,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;230,5->231,5;;25,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;231,5->232,5;;25,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;232,5->233,5;;25,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;233,5->234,5;;25,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;234,5->235,5;;25,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;235,5->236,5;;25,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;236,5->237,5;;25,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;237,5->238,5;;25,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;238,5->239,5;;25,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;239,5->240,5;;26,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;240,5->241,4;;26,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;241,4->242,4;;26,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;242,4->243,3;;26,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;243,3->244,3;;26,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;244,3->245,3;;26,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;245,3->246,2;;26,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;246,2->247,2;;26,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;247,2->248,1;;26,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;248,1->249,1;;26,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;249,1->250,0;;27,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;250,0->250,9;;27,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;250,9->251,9;;27,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;251,9->252,8;;27,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;252,8->253,7;;27,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;253,7->254,6;;27,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;254,6->255,5;;27,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;255,5->256,5;;27,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;256,5->257,4;;27,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;257,4->258,3;;27,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;258,3->259,2;;28,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;259,2->260,0;;28,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;260,0->260,9;;28,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;260,9->261,7;;28,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;261,7->262,6;;28,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;262,6->263,5;;28,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;263,5->264,3;;28,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;264,3->265,2;;28,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;265,2->266,0;;28,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;266,0->266,9;;28,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;266,9->267,7;;29,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;267,7->268,5;;29,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;268,5->269,4;;29,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;269,4->270,2;;29,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;270,2->271,0;;29,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;271,0->271,8;;29,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;271,8->272,6;;29,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;272,6->273,5;;29,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;273,5->274,3;;29,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;274,3->275,1;;29,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;275,1->275,9;;30,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;275,9->276,6;;30,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;276,6->277,4;;30,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;277,4->278,2;;30,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;278,2->279,0;;30,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;279,0->279,7;;30,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;279,7->280,5;;30,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;280,5->281,3;;30,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;281,3->282,0;;30,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;282,0->282,8;;30,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;282,8->283,5;;31,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;283,5->284,2;;31,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;284,2->284,9;;31,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;284,9->285,6;;31,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;285,6->286,4;;31,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;286,4->287,1;;31,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;287,1->287,8;;31,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;287,8->288,5;;31,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;288,5->289,2;;31,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;289,2->289,9;;31,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;289,9->290,6;;32,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;290,6->291,2;;32,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;291,2->291,9;;32,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;291,9->292,6;;32,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;292,6->293,2;;32,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;293,2->293,9;;32,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;293,9->294,6;;32,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;294,6->295,3;;32,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;295,3->295,9;;32,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;295,9->296,6;;32,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;296,6->297,2;;33,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;297,2->297,8;;33,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;297,8->298,4;;33,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;298,4->299,0;;33,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;299,0->299,6;;33,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;299,6->300,3;;33,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;300,3->300,9;;33,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;300,9->301,5;;33,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;301,5->302,1;;33,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;302,1->302,7;;33,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;302,7->303,2;;34,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;303,2->303,8;;34,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;303,8->304,3;;34,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;304,3->304,9;;34,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;304,9->305,4;;34,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;305,4->306,0;;34,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;306,0->306,6;;34,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;306,6->307,1;;34,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;307,1->307,6;;34,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;307,6->308,2;;34,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;308,2->308,7;;35,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;308,7->309,2;;35,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;309,2->309,7;;35,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;309,7->310,2;;35,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;310,2->310,6;;35,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;310,6->311,1;;35,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;311,1->311,6;;35,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;311,6->312,1;;35,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;312,1->312,6;;35,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;312,6->313,1;;35,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;313,1->313,5;;36,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;313,5->314,0;;36,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;314,0->314,4;;36,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;314,4->314,9;;36,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;314,9->315,3;;36,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;315,3->315,7;;36,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;315,7->316,2;;36,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;316,2->316,6;;36,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;316,6->317,1;;36,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;317,1->317,5;;36,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;317,5->317,9;;37,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;317,9->318,2;;37,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;318,2->318,6;;37,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;318,6->319,0;;37,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;319,0->319,4;;37,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;319,4->319,7;;37,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;319,7->320,1;;37,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;320,1->320,5;;37,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;320,5->320,8;;37,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;320,8->321,2;;37,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;321,2->321,5;;38,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;321,5->321,8;;38,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;321,8->322,1;;38,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;322,1->322,4;;38,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;322,4->322,8;;38,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;322,8->323,1;;38,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;323,1->323,4;;38,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;323,4->323,7;;38,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;323,7->324,0;;38,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;324,0->324,3;;38,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;324,3->324,5;;39,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;324,5->324,8;;39,10 semanas$$\n");
        sb.append("621;;cadastrarLogica;;324,8->325,0;;39,20 semanas$$\n");
        sb.append("621;;cadastrarLogica;;325,0->325,3;;39,30 semanas$$\n");
        sb.append("621;;cadastrarLogica;;325,3->325,5;;39,40 semanas$$\n");
        sb.append("621;;cadastrarLogica;;325,5->325,7;;39,50 semanas$$\n");
        sb.append("621;;cadastrarLogica;;325,7->326,0;;39,60 semanas$$\n");
        sb.append("621;;cadastrarLogica;;326,0->326,2;;39,70 semanas$$\n");
        sb.append("621;;cadastrarLogica;;326,2->326,5;;39,80 semanas$$\n");
        sb.append("621;;cadastrarLogica;;326,5->326,7;;39,90 semanas$$\n");
        sb.append("621;;cadastrarLogica;;326,7->328,1;;40,00 semanas$$\n");
        sb.append("621;;cadastrarLogica;;328,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("619;;cadastrarLogica;;0,0->15,7;;<11,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;15,7->16,0;;11,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;16,0->16,4;;11,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;16,4->16,7;;11,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;16,7->17,1;;11,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;17,1->17,4;;11,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;17,4->17,7;;11,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;17,7->18,1;;11,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;18,1->18,4;;11,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;18,4->18,8;;11,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;18,8->19,1;;11,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;19,1->19,4;;12,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;19,4->19,7;;12,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;19,7->20,1;;12,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;20,1->20,4;;12,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;20,4->20,7;;12,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;20,7->21,0;;12,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;21,0->21,3;;12,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;21,3->21,7;;12,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;21,7->22,0;;12,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;22,0->22,3;;12,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;22,3->22,8;;13,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;22,8->23,2;;13,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;23,2->23,7;;13,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;23,7->24,2;;13,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;24,2->24,6;;13,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;24,6->25,1;;13,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;25,1->25,6;;13,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;25,6->26,1;;13,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;26,1->26,5;;13,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;26,5->27,0;;13,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;27,0->27,4;;14,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;27,4->27,7;;14,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;27,7->28,1;;14,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;28,1->28,5;;14,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;28,5->28,8;;14,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;28,8->29,2;;14,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;29,2->29,6;;14,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;29,6->30,0;;14,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;30,0->30,3;;14,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;30,3->30,7;;14,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;30,7->31,1;;15,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;31,1->31,4;;15,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;31,4->31,8;;15,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;31,8->32,1;;15,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;32,1->32,5;;15,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;32,5->32,9;;15,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;32,9->33,2;;15,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;33,2->33,6;;15,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;33,6->33,9;;15,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;33,9->34,3;;15,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;34,3->34,7;;16,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;34,7->35,0;;16,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;35,0->35,4;;16,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;35,4->35,7;;16,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;35,7->36,1;;16,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;36,1->36,5;;16,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;36,5->36,8;;16,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;36,8->37,2;;16,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;37,2->37,5;;16,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;37,5->37,9;;16,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;37,9->38,2;;17,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;38,2->38,6;;17,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;38,6->38,9;;17,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;38,9->39,3;;17,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;39,3->39,6;;17,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;39,6->39,9;;17,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;39,9->40,3;;17,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;40,3->40,6;;17,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;40,6->41,0;;17,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;41,0->41,3;;17,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;41,3->41,6;;18,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;41,6->42,0;;18,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;42,0->42,3;;18,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;42,3->42,7;;18,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;42,7->43,0;;18,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;43,0->43,3;;18,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;43,3->43,7;;18,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;43,7->44,0;;18,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;44,0->44,4;;18,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;44,4->44,7;;18,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;44,7->45,0;;19,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;45,0->45,4;;19,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;45,4->45,7;;19,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;45,7->46,1;;19,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;46,1->46,4;;19,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;46,4->46,7;;19,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;46,7->47,1;;19,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;47,1->47,4;;19,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;47,4->47,8;;19,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;47,8->48,1;;19,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;48,1->48,4;;20,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;48,4->48,7;;20,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;48,7->49,1;;20,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;49,1->49,4;;20,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;49,4->49,7;;20,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;49,7->50,0;;20,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;50,0->50,3;;20,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;50,3->50,7;;20,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;50,7->51,0;;20,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;51,0->51,3;;20,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;51,3->51,6;;21,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;51,6->51,9;;21,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;51,9->52,3;;21,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;52,3->52,6;;21,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;52,6->52,9;;21,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;52,9->53,2;;21,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;53,2->53,5;;21,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;53,5->53,9;;21,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;53,9->54,2;;21,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;54,2->54,5;;21,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;54,5->54,8;;22,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;54,8->55,1;;22,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;55,1->55,4;;22,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;55,4->55,7;;22,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;55,7->56,0;;22,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;56,0->56,3;;22,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;56,3->56,6;;22,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;56,6->56,9;;22,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;56,9->57,2;;22,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;57,2->57,5;;22,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;57,5->57,8;;23,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;57,8->58,1;;23,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;58,1->58,4;;23,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;58,4->58,7;;23,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;58,7->59,0;;23,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;59,0->59,3;;23,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;59,3->59,6;;23,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;59,6->59,9;;23,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;59,9->60,2;;23,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;60,2->60,5;;23,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;60,5->60,8;;24,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;60,8->61,1;;24,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;61,1->61,4;;24,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;61,4->61,7;;24,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;61,7->62,0;;24,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;62,0->62,2;;24,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;62,2->62,5;;24,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;62,5->62,8;;24,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;62,8->63,1;;24,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;63,1->63,4;;24,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;63,4->63,7;;25,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;63,7->64,0;;25,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;64,0->64,2;;25,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;64,2->64,5;;25,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;64,5->64,8;;25,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;64,8->65,1;;25,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;65,1->65,4;;25,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;65,4->65,6;;25,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;65,6->65,9;;25,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;65,9->66,2;;25,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;66,2->66,5;;26,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;66,5->66,7;;26,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;66,7->67,0;;26,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;67,0->67,3;;26,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;67,3->67,6;;26,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;67,6->67,8;;26,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;67,8->68,1;;26,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;68,1->68,4;;26,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;68,4->68,6;;26,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;68,6->68,9;;26,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;68,9->69,2;;27,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;69,2->69,4;;27,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;69,4->69,6;;27,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;69,6->69,9;;27,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;69,9->70,2;;27,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;70,2->70,4;;27,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;70,4->70,6;;27,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;70,6->70,9;;27,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;70,9->71,2;;27,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;71,2->71,4;;27,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;71,4->71,6;;28,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;71,6->71,9;;28,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;71,9->72,2;;28,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;72,2->72,4;;28,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;72,4->72,6;;28,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;72,6->72,9;;28,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;72,9->73,2;;28,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;73,2->73,4;;28,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;73,4->73,6;;28,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;73,6->73,9;;28,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;73,9->74,1;;29,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;74,1->74,4;;29,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;74,4->74,6;;29,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;74,6->74,8;;29,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;74,8->75,1;;29,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;75,1->75,3;;29,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;75,3->75,5;;29,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;75,5->75,7;;29,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;75,7->76,0;;29,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;76,0->76,2;;29,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;76,2->76,4;;30,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;76,4->76,7;;30,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;76,7->76,9;;30,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;76,9->77,1;;30,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;77,1->77,4;;30,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;77,4->77,6;;30,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;77,6->77,8;;30,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;77,8->78,0;;30,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;78,0->78,3;;30,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;78,3->78,5;;30,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;78,5->78,7;;31,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;78,7->78,9;;31,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;78,9->79,1;;31,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;79,1->79,3;;31,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;79,3->79,6;;31,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;79,6->79,8;;31,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;79,8->80,0;;31,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;80,0->80,2;;31,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;80,2->80,4;;31,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;80,4->80,6;;31,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;80,6->80,8;;32,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;80,8->81,0;;32,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;81,0->81,2;;32,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;81,2->81,4;;32,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;81,4->81,6;;32,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;81,6->81,7;;32,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;81,7->81,9;;32,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;81,9->82,1;;32,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;82,1->82,3;;32,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;82,3->82,5;;32,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;82,5->82,7;;33,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;82,7->82,9;;33,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;82,9->83,1;;33,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;83,1->83,3;;33,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;83,3->83,4;;33,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;83,4->83,6;;33,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;83,6->83,8;;33,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;83,8->84,0;;33,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;84,0->84,2;;33,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;84,2->84,4;;33,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;84,4->84,6;;34,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;84,6->84,7;;34,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;84,7->84,9;;34,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;84,9->85,1;;34,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;85,1->85,2;;34,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;85,2->85,4;;34,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;85,4->85,6;;34,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;85,6->85,8;;34,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;85,8->85,9;;34,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;85,9->86,1;;34,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;86,1->86,2;;35,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;86,2->86,4;;35,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;86,4->86,6;;35,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;86,6->86,7;;35,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;86,7->86,8;;35,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;86,8->87,0;;35,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;87,0->87,1;;35,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;87,1->87,3;;35,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;87,3->87,4;;35,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;87,4->87,6;;35,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;87,6->87,8;;36,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;87,8->87,9;;36,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;87,9->88,0;;36,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;88,0->88,2;;36,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;88,2->88,4;;36,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;88,4->88,5;;36,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;88,5->88,6;;36,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;88,6->88,8;;36,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;88,8->88,9;;36,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;88,9->89,1;;36,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;89,1->89,2;;37,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;89,2->89,3;;37,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;89,3->89,5;;37,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;89,5->89,6;;37,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;89,6->89,7;;37,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;89,7->89,8;;37,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;89,8->89,9;;37,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;89,9->90,1;;37,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;90,1->90,2;;37,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;90,2->90,3;;37,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;90,3->90,4;;38,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;90,4->90,5;;38,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;90,5->90,6;;38,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;90,6->90,7;;38,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;90,7->90,8;;38,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;90,8->91,0;;38,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;91,0->91,1;;38,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;91,1->91,2;;38,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;91,2->91,3;;38,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;91,3->91,4;;38,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;91,4->91,5;;39,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;91,5->91,6;;39,10 semanas$$\n");
        sb.append("619;;cadastrarLogica;;91,6->91,7;;39,20 semanas$$\n");
        sb.append("619;;cadastrarLogica;;91,7->91,8;;39,30 semanas$$\n");
        sb.append("619;;cadastrarLogica;;91,8->91,9;;39,40 semanas$$\n");
        sb.append("619;;cadastrarLogica;;91,9->92,0;;39,50 semanas$$\n");
        sb.append("619;;cadastrarLogica;;92,0->92,1;;39,60 semanas$$\n");
        sb.append("619;;cadastrarLogica;;92,1->92,2;;39,70 semanas$$\n");
        sb.append("619;;cadastrarLogica;;92,2->92,3;;39,80 semanas$$\n");
        sb.append("619;;cadastrarLogica;;92,3->92,4;;39,90 semanas$$\n");
        sb.append("619;;cadastrarLogica;;92,4->93,1;;40,00 semanas$$\n");
        sb.append("619;;cadastrarLogica;;93,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

    }

    private static void preencherIghFeto4 ()
    {

        // <editor-fold defaultstate="collapsed" desc="Fêmur">

        sb.append("622;;cadastrarLogica;;0,0->7,1;;<12,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;7,1->8,1;;12,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;8,1->9,1;;12,33 semanas$$\n");
        sb.append("622;;cadastrarLogica;;9,1->10,1;;12,67 semanas$$\n");
        sb.append("622;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("622;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("622;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("622;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("622;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("622;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("622;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;20,1->21,1;;16,33 semanas$$\n");
        sb.append("622;;cadastrarLogica;;21,1->22,1;;16,67 semanas$$\n");
        sb.append("622;;cadastrarLogica;;22,1->23,1;;17,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;23,1->24,1;;17,50 semanas$$\n");
        sb.append("622;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("622;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("622;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;28,1->29,1;;19,33 semanas$$\n");
        sb.append("622;;cadastrarLogica;;29,1->30,1;;19,67 semanas$$\n");
        sb.append("622;;cadastrarLogica;;30,1->31,1;;20,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;31,1->32,1;;20,33 semanas$$\n");
        sb.append("622;;cadastrarLogica;;32,1->33,1;;20,67 semanas$$\n");
        sb.append("622;;cadastrarLogica;;33,1->34,1;;21,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;34,1->35,1;;21,50 semanas$$\n");
        sb.append("622;;cadastrarLogica;;35,1->36,1;;22,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;36,1->37,1;;22,33 semanas$$\n");
        sb.append("622;;cadastrarLogica;;37,1->38,1;;22,67 semanas$$\n");
        sb.append("622;;cadastrarLogica;;38,1->39,1;;23,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;39,1->40,1;;23,33 semanas$$\n");
        sb.append("622;;cadastrarLogica;;40,1->41,1;;23,67 semanas$$\n");
        sb.append("622;;cadastrarLogica;;41,1->42,1;;24,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;42,1->43,1;;24,50 semanas$$\n");
        sb.append("622;;cadastrarLogica;;43,1->44,1;;25,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;44,1->45,1;;25,33 semanas$$\n");
        sb.append("622;;cadastrarLogica;;45,1->46,1;;25,67 semanas$$\n");
        sb.append("622;;cadastrarLogica;;46,1->47,1;;26,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;47,1->48,1;;26,50 semanas$$\n");
        sb.append("622;;cadastrarLogica;;48,1->49,1;;27,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;49,1->50,1;;27,33 semanas$$\n");
        sb.append("622;;cadastrarLogica;;50,1->51,1;;27,67 semanas$$\n");
        sb.append("622;;cadastrarLogica;;51,1->52,1;;28,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;52,1->53,1;;28,50 semanas$$\n");
        sb.append("622;;cadastrarLogica;;53,1->54,1;;29,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;54,1->55,1;;29,50 semanas$$\n");
        sb.append("622;;cadastrarLogica;;55,1->56,1;;30,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;56,1->57,1;;30,33 semanas$$\n");
        sb.append("622;;cadastrarLogica;;57,1->58,1;;30,67 semanas$$\n");
        sb.append("622;;cadastrarLogica;;58,1->59,1;;31,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;59,1->60,1;;31,50 semanas$$\n");
        sb.append("622;;cadastrarLogica;;60,1->61,1;;32,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;61,1->62,1;;32,50 semanas$$\n");
        sb.append("622;;cadastrarLogica;;62,1->63,1;;33,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;63,1->64,1;;33,50 semanas$$\n");
        sb.append("622;;cadastrarLogica;;64,1->65,1;;34,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;65,1->66,1;;34,50 semanas$$\n");
        sb.append("622;;cadastrarLogica;;66,1->67,1;;35,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;67,1->68,1;;36,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;68,1->69,1;;36,50 semanas$$\n");
        sb.append("622;;cadastrarLogica;;69,1->70,1;;37,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;70,1->71,1;;38,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;71,1->72,1;;38,50 semanas$$\n");
        sb.append("622;;cadastrarLogica;;72,1->73,1;;39,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;73,1->74,1;;40,00 semanas$$\n");
        sb.append("622;;cadastrarLogica;;74,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Úmero">

        sb.append("623;;cadastrarLogica;;0,0->8,1;;<12,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;8,1->9,1;;12,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;9,1->10,1;;12,50 semanas$$\n");
        sb.append("623;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("623;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("623;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("623;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("623;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("623;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("623;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;20,1->21,1;;16,50 semanas$$\n");
        sb.append("623;;cadastrarLogica;;21,1->22,1;;17,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;22,1->23,1;;17,33 semanas$$\n");
        sb.append("623;;cadastrarLogica;;23,1->24,1;;17,67 semanas$$\n");
        sb.append("623;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("623;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("623;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;28,1->29,1;;19,50 semanas$$\n");
        sb.append("623;;cadastrarLogica;;29,1->30,1;;20,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;30,1->31,1;;20,33 semanas$$\n");
        sb.append("623;;cadastrarLogica;;31,1->32,1;;20,67 semanas$$\n");
        sb.append("623;;cadastrarLogica;;32,1->33,1;;21,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;33,1->34,1;;21,50 semanas$$\n");
        sb.append("623;;cadastrarLogica;;34,1->35,1;;22,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;35,1->36,1;;22,33 semanas$$\n");
        sb.append("623;;cadastrarLogica;;36,1->37,1;;22,67 semanas$$\n");
        sb.append("623;;cadastrarLogica;;37,1->38,1;;23,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;38,1->39,1;;23,50 semanas$$\n");
        sb.append("623;;cadastrarLogica;;39,1->40,1;;24,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;40,1->41,1;;24,50 semanas$$\n");
        sb.append("623;;cadastrarLogica;;41,1->42,1;;25,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;42,1->43,1;;25,50 semanas$$\n");
        sb.append("623;;cadastrarLogica;;43,1->44,1;;26,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;44,1->45,1;;26,50 semanas$$\n");
        sb.append("623;;cadastrarLogica;;45,1->46,1;;27,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;46,1->47,1;;27,50 semanas$$\n");
        sb.append("623;;cadastrarLogica;;47,1->48,1;;28,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;48,1->49,1;;28,50 semanas$$\n");
        sb.append("623;;cadastrarLogica;;49,1->50,1;;29,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;50,1->51,1;;30,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;51,1->52,1;;30,50 semanas$$\n");
        sb.append("623;;cadastrarLogica;;52,1->53,1;;31,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;53,1->54,1;;31,50 semanas$$\n");
        sb.append("623;;cadastrarLogica;;54,1->55,1;;32,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;55,1->56,1;;33,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;56,1->57,1;;33,50 semanas$$\n");
        sb.append("623;;cadastrarLogica;;57,1->58,1;;34,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;58,1->59,1;;35,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;59,1->60,1;;35,50 semanas$$\n");
        sb.append("623;;cadastrarLogica;;60,1->61,1;;36,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;61,1->62,1;;37,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;63,1->64,1;;38,50 semanas$$\n");
        sb.append("623;;cadastrarLogica;;64,1->65,1;;39,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("623;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ulna">

        sb.append("624;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("624;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("624;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;10,1->11,1;;13,33 semanas$$\n");
        sb.append("624;;cadastrarLogica;;11,1->12,1;;13,67 semanas$$\n");
        sb.append("624;;cadastrarLogica;;12,1->13,1;;14,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;13,1->14,1;;14,50 semanas$$\n");
        sb.append("624;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;15,1->16,1;;15,33 semanas$$\n");
        sb.append("624;;cadastrarLogica;;16,1->17,1;;15,67 semanas$$\n");
        sb.append("624;;cadastrarLogica;;17,1->18,1;;16,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;18,1->19,1;;16,33 semanas$$\n");
        sb.append("624;;cadastrarLogica;;19,1->20,1;;16,67 semanas$$\n");
        sb.append("624;;cadastrarLogica;;20,1->21,1;;17,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;21,1->22,1;;17,50 semanas$$\n");
        sb.append("624;;cadastrarLogica;;22,1->23,1;;18,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;23,1->24,1;;18,33 semanas$$\n");
        sb.append("624;;cadastrarLogica;;24,1->25,1;;18,67 semanas$$\n");
        sb.append("624;;cadastrarLogica;;25,1->26,1;;19,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;26,1->27,1;;19,50 semanas$$\n");
        sb.append("624;;cadastrarLogica;;27,1->28,1;;20,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;28,1->29,1;;20,33 semanas$$\n");
        sb.append("624;;cadastrarLogica;;29,1->30,1;;20,67 semanas$$\n");
        sb.append("624;;cadastrarLogica;;30,1->31,1;;21,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;31,1->32,1;;21,50 semanas$$\n");
        sb.append("624;;cadastrarLogica;;32,1->33,1;;22,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;33,1->34,1;;22,50 semanas$$\n");
        sb.append("624;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("624;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;37,1->38,1;;24,50 semanas$$\n");
        sb.append("624;;cadastrarLogica;;38,1->39,1;;25,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;39,1->40,1;;25,50 semanas$$\n");
        sb.append("624;;cadastrarLogica;;40,1->41,1;;26,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;41,1->42,1;;26,50 semanas$$\n");
        sb.append("624;;cadastrarLogica;;42,1->43,1;;27,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;43,1->44,1;;27,50 semanas$$\n");
        sb.append("624;;cadastrarLogica;;44,1->45,1;;28,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;45,1->46,1;;28,50 semanas$$\n");
        sb.append("624;;cadastrarLogica;;46,1->47,1;;29,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;47,1->48,1;;30,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;48,1->49,1;;30,50 semanas$$\n");
        sb.append("624;;cadastrarLogica;;49,1->50,1;;31,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;50,1->51,1;;31,50 semanas$$\n");
        sb.append("624;;cadastrarLogica;;51,1->52,1;;32,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;52,1->53,1;;33,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;53,1->54,1;;33,50 semanas$$\n");
        sb.append("624;;cadastrarLogica;;54,1->55,1;;34,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;55,1->56,1;;35,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;56,1->57,1;;36,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;57,1->58,1;;37,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;58,1->59,1;;38,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;59,1->60,1;;39,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;60,1->61,1;;40,00 semanas$$\n");
        sb.append("624;;cadastrarLogica;;61,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tíbia">

        sb.append("625;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("625;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("625;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;10,1->11,1;;13,50 semanas$$\n");
        sb.append("625;;cadastrarLogica;;11,1->12,1;;14,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;12,1->13,1;;14,33 semanas$$\n");
        sb.append("625;;cadastrarLogica;;13,1->14,1;;14,67 semanas$$\n");
        sb.append("625;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;15,1->16,1;;15,50 semanas$$\n");
        sb.append("625;;cadastrarLogica;;16,1->17,1;;16,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;17,1->18,1;;16,33 semanas$$\n");
        sb.append("625;;cadastrarLogica;;18,1->19,1;;16,67 semanas$$\n");
        sb.append("625;;cadastrarLogica;;19,1->20,1;;17,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;20,1->21,1;;17,50 semanas$$\n");
        sb.append("625;;cadastrarLogica;;21,1->22,1;;18,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;22,1->23,1;;18,33 semanas$$\n");
        sb.append("625;;cadastrarLogica;;23,1->24,1;;18,67 semanas$$\n");
        sb.append("625;;cadastrarLogica;;24,1->25,1;;19,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;25,1->26,1;;19,50 semanas$$\n");
        sb.append("625;;cadastrarLogica;;26,1->27,1;;20,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;27,1->28,1;;20,33 semanas$$\n");
        sb.append("625;;cadastrarLogica;;28,1->29,1;;20,67 semanas$$\n");
        sb.append("625;;cadastrarLogica;;29,1->30,1;;21,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;30,1->31,1;;21,50 semanas$$\n");
        sb.append("625;;cadastrarLogica;;31,1->32,1;;22,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;32,1->33,1;;22,33 semanas$$\n");
        sb.append("625;;cadastrarLogica;;33,1->34,1;;22,67 semanas$$\n");
        sb.append("625;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("625;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;37,1->38,1;;24,33 semanas$$\n");
        sb.append("625;;cadastrarLogica;;38,1->39,1;;24,67 semanas$$\n");
        sb.append("625;;cadastrarLogica;;39,1->40,1;;25,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;40,1->41,1;;25,50 semanas$$\n");
        sb.append("625;;cadastrarLogica;;41,1->42,1;;26,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;42,1->43,1;;26,50 semanas$$\n");
        sb.append("625;;cadastrarLogica;;43,1->44,1;;27,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;44,1->45,1;;27,50 semanas$$\n");
        sb.append("625;;cadastrarLogica;;45,1->46,1;;28,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;46,1->47,1;;28,50 semanas$$\n");
        sb.append("625;;cadastrarLogica;;47,1->48,1;;29,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;48,1->49,1;;29,50 semanas$$\n");
        sb.append("625;;cadastrarLogica;;49,1->50,1;;30,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;50,1->51,1;;30,50 semanas$$\n");
        sb.append("625;;cadastrarLogica;;51,1->52,1;;31,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;52,1->53,1;;31,50 semanas$$\n");
        sb.append("625;;cadastrarLogica;;53,1->54,1;;32,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;54,1->55,1;;33,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;55,1->56,1;;33,50 semanas$$\n");
        sb.append("625;;cadastrarLogica;;56,1->57,1;;34,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;57,1->58,1;;35,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;58,1->59,1;;35,50 semanas$$\n");
        sb.append("625;;cadastrarLogica;;59,1->60,1;;36,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;60,1->61,1;;37,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;61,1->62,1;;37,50 semanas$$\n");
        sb.append("625;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;63,1->64,1;;39,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;64,1->65,1;;39,50 semanas$$\n");
        sb.append("625;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("625;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.A.">

        sb.append("627;;cadastrarLogica;;0,0->39,3;;<11,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;39,3->40,6;;11,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;40,6->41,9;;11,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;41,9->43,2;;11,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;43,2->44,5;;11,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;44,5->45,8;;11,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;45,8->47,0;;11,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;47,0->48,3;;11,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;48,3->49,6;;11,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;49,6->50,9;;11,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;50,9->52,2;;11,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;52,2->53,5;;12,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;53,5->54,8;;12,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;54,8->56,0;;12,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;56,0->57,3;;12,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;57,3->58,6;;12,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;58,6->59,9;;12,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;59,9->61,2;;12,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;61,2->62,4;;12,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;62,4->63,7;;12,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;63,7->65,0;;12,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;65,0->66,3;;13,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;66,3->67,5;;13,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;67,5->68,8;;13,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;68,8->70,1;;13,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;70,1->71,4;;13,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;71,4->72,6;;13,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;72,6->73,9;;13,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;73,9->75,2;;13,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;75,2->76,4;;13,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;76,4->77,7;;13,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;77,7->79,0;;14,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;79,0->80,2;;14,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;80,2->81,4;;14,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;81,4->82,7;;14,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;82,7->84,0;;14,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;84,0->85,2;;14,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;85,2->86,4;;14,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;86,4->87,7;;14,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;87,7->89,0;;14,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;89,0->90,2;;14,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;90,2->91,4;;15,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;91,4->92,7;;15,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;92,7->94,0;;15,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;94,0->95,2;;15,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;95,2->96,4;;15,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;96,4->97,7;;15,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;97,7->99,0;;15,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;99,0->100,2;;15,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;100,2->101,4;;15,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;101,4->102,7;;15,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;102,7->103,9;;16,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;103,9->105,2;;16,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;105,2->106,4;;16,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;106,4->107,6;;16,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;107,6->108,8;;16,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;108,8->110,1;;16,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;110,1->111,3;;16,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;111,3->112,5;;16,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;112,5->113,8;;16,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;113,8->115,0;;16,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;115,0->116,2;;17,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;116,2->117,4;;17,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;117,4->118,7;;17,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;118,7->119,9;;17,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;119,9->121,1;;17,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;121,1->122,3;;17,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;122,3->123,5;;17,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;123,5->124,8;;17,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;124,8->126,0;;17,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;126,0->127,2;;17,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;127,2->128,4;;18,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;128,4->129,6;;18,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;129,6->130,8;;18,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;130,8->132,0;;18,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;132,0->133,2;;18,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;133,2->134,4;;18,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;134,4->135,6;;18,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;135,6->136,8;;18,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;136,8->138,0;;18,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;138,0->139,2;;18,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;139,2->140,4;;19,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;140,4->141,6;;19,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;141,6->142,8;;19,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;142,8->144,0;;19,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;144,0->145,1;;19,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;145,1->146,3;;19,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;146,3->147,5;;19,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;147,5->148,7;;19,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;148,7->149,9;;19,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;149,9->151,1;;19,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;151,1->152,3;;20,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;152,3->153,4;;20,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;153,4->154,6;;20,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;154,6->155,8;;20,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;155,8->157,0;;20,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;157,0->158,1;;20,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;158,1->159,3;;20,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;159,3->160,5;;20,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;160,5->161,6;;20,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;161,6->162,8;;20,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;162,8->164,0;;21,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;164,0->165,1;;21,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;165,1->166,3;;21,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;166,3->167,4;;21,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;167,4->168,6;;21,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;168,6->169,8;;21,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;169,8->170,9;;21,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;170,9->172,1;;21,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;172,1->173,2;;21,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;173,2->174,4;;21,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;174,4->175,5;;22,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;175,5->176,7;;22,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;176,7->177,8;;22,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;177,8->179,0;;22,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;179,0->180,1;;22,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;180,1->181,2;;22,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;181,2->182,4;;22,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;182,4->183,5;;22,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;183,5->184,7;;22,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;184,7->185,8;;22,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;185,8->186,9;;23,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;186,9->188,0;;23,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;188,0->189,2;;23,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;189,2->190,3;;23,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;190,3->191,4;;23,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;191,4->192,5;;23,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;192,5->193,6;;23,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;193,6->194,8;;23,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;194,8->195,9;;23,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;195,9->197,0;;23,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;197,0->198,1;;24,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;198,1->199,2;;24,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;199,2->200,3;;24,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;200,3->201,4;;24,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;201,4->202,5;;24,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;202,5->203,6;;24,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;203,6->204,7;;24,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;204,7->205,8;;24,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;205,8->206,9;;24,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;206,9->208,0;;24,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;208,0->209,1;;25,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;209,1->210,2;;25,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;210,2->211,2;;25,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;211,2->212,3;;25,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;212,3->213,4;;25,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;213,4->214,5;;25,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;214,5->215,6;;25,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;215,6->216,6;;25,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;216,6->217,7;;25,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;217,7->218,8;;25,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;218,8->219,9;;26,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;219,9->220,9;;26,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;220,9->222,0;;26,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;222,0->223,0;;26,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;223,0->224,1;;26,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;224,1->225,2;;26,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;225,2->226,2;;26,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;226,2->227,3;;26,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;227,3->228,3;;26,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;228,3->229,4;;26,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;229,4->230,4;;27,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;230,4->231,5;;27,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;231,5->232,5;;27,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;232,5->233,6;;27,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;233,6->234,6;;27,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;234,6->235,6;;27,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;235,6->236,7;;27,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;236,7->237,7;;27,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;237,7->238,8;;27,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;238,8->239,8;;27,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;239,8->240,8;;28,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;240,8->241,8;;28,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;241,8->242,8;;28,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;242,8->243,8;;28,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;243,8->244,9;;28,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;244,9->245,9;;28,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;245,9->246,9;;28,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;246,9->247,9;;28,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;247,9->248,9;;28,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;248,9->249,9;;28,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;249,9->250,9;;29,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;250,9->251,9;;29,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;251,9->252,9;;29,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;252,9->253,9;;29,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;253,9->254,9;;29,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;254,9->255,8;;29,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;255,8->256,8;;29,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;256,8->257,8;;29,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;257,8->258,8;;29,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;258,8->259,8;;29,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;259,8->260,8;;30,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;260,8->261,7;;30,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;261,7->262,7;;30,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;262,7->263,7;;30,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;263,7->264,6;;30,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;264,6->265,6;;30,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;265,6->266,6;;30,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;266,6->267,6;;30,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;267,6->268,5;;30,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;268,5->269,5;;30,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;269,5->270,4;;31,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;270,4->271,4;;31,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;271,4->272,4;;31,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;272,4->273,3;;31,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;273,3->274,2;;31,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;274,2->275,2;;31,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;275,2->276,2;;31,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;276,2->277,1;;31,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;277,1->278,0;;31,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;278,0->279,0;;31,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;279,0->279,9;;32,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;279,9->280,8;;32,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;280,8->281,7;;32,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;281,7->282,6;;32,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;282,6->283,6;;32,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;283,6->284,5;;32,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;284,5->285,4;;32,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;285,4->286,3;;32,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;286,3->287,2;;32,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;287,2->288,1;;32,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;288,1->289,0;;33,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;289,0->289,9;;33,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;289,9->290,8;;33,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;290,8->291,7;;33,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;291,7->292,6;;33,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;292,6->293,5;;33,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;293,5->294,4;;33,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;294,4->295,3;;33,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;295,3->296,2;;33,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;296,2->297,1;;33,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;297,1->298,0;;34,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;298,0->298,8;;34,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;298,8->299,7;;34,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;299,7->300,5;;34,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;300,5->301,4;;34,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;301,4->302,3;;34,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;302,3->303,1;;34,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;303,1->304,0;;34,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;304,0->304,8;;34,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;304,8->305,7;;34,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;305,7->306,5;;35,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;306,5->307,4;;35,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;307,4->308,2;;35,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;308,2->309,1;;35,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;309,1->309,9;;35,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;309,9->310,7;;35,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;310,7->311,6;;35,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;311,6->312,4;;35,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;312,4->313,3;;35,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;313,3->314,1;;35,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;314,1->314,9;;36,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;314,9->315,7;;36,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;315,7->316,5;;36,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;316,5->317,3;;36,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;317,3->318,1;;36,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;318,1->318,9;;36,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;318,9->319,7;;36,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;319,7->320,5;;36,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;320,5->321,3;;36,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;321,3->322,1;;36,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;322,1->322,9;;37,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;322,9->323,7;;37,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;323,7->324,4;;37,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;324,4->325,2;;37,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;325,2->326,0;;37,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;326,0->326,8;;37,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;326,8->327,6;;37,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;327,6->328,3;;37,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;328,3->329,1;;37,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;329,1->329,9;;37,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;329,9->330,6;;38,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;330,6->331,4;;38,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;331,4->332,2;;38,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;332,2->332,9;;38,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;332,9->333,6;;38,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;333,6->334,4;;38,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;334,4->335,2;;38,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;335,2->335,9;;38,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;335,9->336,6;;38,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;336,6->337,4;;38,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;337,4->338,1;;39,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;338,1->338,8;;39,10 semanas$$\n");
        sb.append("627;;cadastrarLogica;;338,8->339,5;;39,20 semanas$$\n");
        sb.append("627;;cadastrarLogica;;339,5->340,2;;39,30 semanas$$\n");
        sb.append("627;;cadastrarLogica;;340,2->341,0;;39,40 semanas$$\n");
        sb.append("627;;cadastrarLogica;;341,0->341,7;;39,50 semanas$$\n");
        sb.append("627;;cadastrarLogica;;341,7->342,4;;39,60 semanas$$\n");
        sb.append("627;;cadastrarLogica;;342,4->343,1;;39,70 semanas$$\n");
        sb.append("627;;cadastrarLogica;;343,1->343,8;;39,80 semanas$$\n");
        sb.append("627;;cadastrarLogica;;343,8->344,5;;39,90 semanas$$\n");
        sb.append("627;;cadastrarLogica;;344,5->346,1;;40,00 semanas$$\n");
        sb.append("627;;cadastrarLogica;;346,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.C.">

        sb.append("628;;cadastrarLogica;;0,0->53,2;;<11,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;53,2->54,6;;11,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;54,6->56,1;;11,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;56,1->57,5;;11,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;57,5->58,9;;11,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;58,9->60,4;;11,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;60,4->61,8;;11,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;61,8->63,2;;11,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;63,2->64,6;;11,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;64,6->66,1;;11,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;66,1->67,5;;11,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;67,5->68,9;;12,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;68,9->70,4;;12,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;70,4->71,8;;12,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;71,8->73,2;;12,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;73,2->74,6;;12,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;74,6->76,1;;12,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;76,1->77,5;;12,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;77,5->78,9;;12,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;78,9->80,4;;12,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;80,4->81,8;;12,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;81,8->83,2;;13,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;83,2->84,5;;13,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;84,5->85,9;;13,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;85,9->87,3;;13,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;87,3->88,6;;13,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;88,6->90,0;;13,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;90,0->91,4;;13,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;91,4->92,8;;13,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;92,8->94,1;;13,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;94,1->95,5;;13,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;95,5->96,9;;14,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;96,9->98,2;;14,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;98,2->99,6;;14,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;99,6->101,0;;14,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;101,0->102,4;;14,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;102,4->103,7;;14,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;103,7->105,1;;14,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;105,1->106,5;;14,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;106,5->107,8;;14,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;107,8->109,2;;14,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;109,2->110,6;;15,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;110,6->111,9;;15,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;111,9->113,2;;15,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;113,2->114,6;;15,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;114,6->116,0;;15,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;116,0->117,3;;15,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;117,3->118,6;;15,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;118,6->120,0;;15,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;120,0->121,4;;15,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;121,4->122,7;;15,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;122,7->124,0;;16,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;124,0->125,3;;16,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;125,3->126,6;;16,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;126,6->127,9;;16,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;127,9->129,2;;16,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;129,2->130,6;;16,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;130,6->131,9;;16,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;131,9->133,2;;16,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;133,2->134,5;;16,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;134,5->135,8;;16,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;135,8->137,1;;17,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;137,1->138,4;;17,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;138,4->139,7;;17,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;139,7->141,0;;17,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;141,0->142,2;;17,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;142,2->143,5;;17,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;143,5->144,8;;17,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;144,8->146,1;;17,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;146,1->147,4;;17,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;147,4->148,7;;17,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;148,7->150,0;;18,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;150,0->151,2;;18,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;151,2->152,5;;18,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;152,5->153,7;;18,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;153,7->155,0;;18,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;155,0->156,3;;18,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;156,3->157,5;;18,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;157,5->158,8;;18,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;158,8->160,0;;18,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;160,0->161,3;;18,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;161,3->162,5;;19,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;162,5->163,7;;19,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;163,7->165,0;;19,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;165,0->166,2;;19,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;166,2->167,4;;19,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;167,4->168,6;;19,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;168,6->169,8;;19,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;169,8->171,1;;19,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;171,1->172,3;;19,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;172,3->173,5;;19,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;173,5->174,7;;20,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;174,7->175,9;;20,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;175,9->177,1;;20,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;177,1->178,3;;20,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;178,3->179,5;;20,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;179,5->180,7;;20,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;180,7->181,9;;20,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;181,9->183,1;;20,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;183,1->184,3;;20,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;184,3->185,5;;20,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;185,5->186,6;;21,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;186,6->187,8;;21,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;187,8->189,0;;21,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;189,0->190,1;;21,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;190,1->191,2;;21,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;191,2->192,4;;21,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;192,4->193,6;;21,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;193,6->194,7;;21,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;194,7->195,8;;21,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;195,8->197,0;;21,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;197,0->198,1;;22,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;198,1->199,3;;22,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;199,3->200,4;;22,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;200,4->201,5;;22,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;201,5->202,6;;22,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;202,6->203,8;;22,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;203,8->204,9;;22,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;204,9->206,0;;22,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;206,0->207,2;;22,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;207,2->208,3;;22,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;208,3->209,4;;23,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;209,4->210,5;;23,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;210,5->211,5;;23,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;211,5->212,6;;23,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;212,6->213,7;;23,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;213,7->214,8;;23,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;214,8->215,9;;23,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;215,9->216,9;;23,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;216,9->218,0;;23,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;218,0->219,1;;23,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;219,1->220,1;;24,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;220,1->221,2;;24,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;221,2->222,2;;24,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;222,2->223,3;;24,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;223,3->224,3;;24,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;224,3->225,3;;24,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;225,3->226,4;;24,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;226,4->227,4;;24,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;227,4->228,5;;24,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;228,5->229,5;;24,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;229,5->230,5;;25,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;230,5->231,5;;25,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;231,5->232,5;;25,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;232,5->233,5;;25,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;233,5->234,5;;25,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;234,5->235,5;;25,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;235,5->236,5;;25,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;236,5->237,5;;25,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;237,5->238,5;;25,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;238,5->239,5;;25,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;239,5->240,5;;26,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;240,5->241,4;;26,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;241,4->242,4;;26,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;242,4->243,3;;26,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;243,3->244,3;;26,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;244,3->245,3;;26,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;245,3->246,2;;26,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;246,2->247,2;;26,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;247,2->248,1;;26,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;248,1->249,1;;26,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;249,1->250,0;;27,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;250,0->250,9;;27,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;250,9->251,9;;27,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;251,9->252,8;;27,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;252,8->253,7;;27,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;253,7->254,6;;27,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;254,6->255,5;;27,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;255,5->256,5;;27,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;256,5->257,4;;27,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;257,4->258,3;;27,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;258,3->259,2;;28,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;259,2->260,0;;28,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;260,0->260,9;;28,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;260,9->261,7;;28,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;261,7->262,6;;28,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;262,6->263,5;;28,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;263,5->264,3;;28,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;264,3->265,2;;28,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;265,2->266,0;;28,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;266,0->266,9;;28,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;266,9->267,7;;29,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;267,7->268,5;;29,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;268,5->269,4;;29,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;269,4->270,2;;29,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;270,2->271,0;;29,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;271,0->271,8;;29,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;271,8->272,6;;29,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;272,6->273,5;;29,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;273,5->274,3;;29,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;274,3->275,1;;29,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;275,1->275,9;;30,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;275,9->276,6;;30,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;276,6->277,4;;30,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;277,4->278,2;;30,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;278,2->279,0;;30,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;279,0->279,7;;30,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;279,7->280,5;;30,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;280,5->281,3;;30,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;281,3->282,0;;30,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;282,0->282,8;;30,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;282,8->283,5;;31,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;283,5->284,2;;31,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;284,2->284,9;;31,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;284,9->285,6;;31,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;285,6->286,4;;31,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;286,4->287,1;;31,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;287,1->287,8;;31,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;287,8->288,5;;31,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;288,5->289,2;;31,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;289,2->289,9;;31,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;289,9->290,6;;32,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;290,6->291,2;;32,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;291,2->291,9;;32,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;291,9->292,6;;32,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;292,6->293,2;;32,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;293,2->293,9;;32,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;293,9->294,6;;32,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;294,6->295,3;;32,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;295,3->295,9;;32,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;295,9->296,6;;32,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;296,6->297,2;;33,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;297,2->297,8;;33,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;297,8->298,4;;33,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;298,4->299,0;;33,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;299,0->299,6;;33,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;299,6->300,3;;33,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;300,3->300,9;;33,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;300,9->301,5;;33,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;301,5->302,1;;33,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;302,1->302,7;;33,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;302,7->303,2;;34,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;303,2->303,8;;34,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;303,8->304,3;;34,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;304,3->304,9;;34,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;304,9->305,4;;34,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;305,4->306,0;;34,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;306,0->306,6;;34,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;306,6->307,1;;34,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;307,1->307,6;;34,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;307,6->308,2;;34,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;308,2->308,7;;35,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;308,7->309,2;;35,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;309,2->309,7;;35,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;309,7->310,2;;35,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;310,2->310,6;;35,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;310,6->311,1;;35,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;311,1->311,6;;35,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;311,6->312,1;;35,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;312,1->312,6;;35,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;312,6->313,1;;35,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;313,1->313,5;;36,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;313,5->314,0;;36,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;314,0->314,4;;36,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;314,4->314,9;;36,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;314,9->315,3;;36,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;315,3->315,7;;36,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;315,7->316,2;;36,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;316,2->316,6;;36,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;316,6->317,1;;36,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;317,1->317,5;;36,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;317,5->317,9;;37,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;317,9->318,2;;37,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;318,2->318,6;;37,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;318,6->319,0;;37,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;319,0->319,4;;37,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;319,4->319,7;;37,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;319,7->320,1;;37,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;320,1->320,5;;37,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;320,5->320,8;;37,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;320,8->321,2;;37,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;321,2->321,5;;38,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;321,5->321,8;;38,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;321,8->322,1;;38,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;322,1->322,4;;38,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;322,4->322,8;;38,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;322,8->323,1;;38,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;323,1->323,4;;38,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;323,4->323,7;;38,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;323,7->324,0;;38,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;324,0->324,3;;38,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;324,3->324,5;;39,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;324,5->324,8;;39,10 semanas$$\n");
        sb.append("628;;cadastrarLogica;;324,8->325,0;;39,20 semanas$$\n");
        sb.append("628;;cadastrarLogica;;325,0->325,3;;39,30 semanas$$\n");
        sb.append("628;;cadastrarLogica;;325,3->325,5;;39,40 semanas$$\n");
        sb.append("628;;cadastrarLogica;;325,5->325,7;;39,50 semanas$$\n");
        sb.append("628;;cadastrarLogica;;325,7->326,0;;39,60 semanas$$\n");
        sb.append("628;;cadastrarLogica;;326,0->326,2;;39,70 semanas$$\n");
        sb.append("628;;cadastrarLogica;;326,2->326,5;;39,80 semanas$$\n");
        sb.append("628;;cadastrarLogica;;326,5->326,7;;39,90 semanas$$\n");
        sb.append("628;;cadastrarLogica;;326,7->328,1;;40,00 semanas$$\n");
        sb.append("628;;cadastrarLogica;;328,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("626;;cadastrarLogica;;0,0->15,7;;<11,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;15,7->16,0;;11,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;16,0->16,4;;11,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;16,4->16,7;;11,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;16,7->17,1;;11,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;17,1->17,4;;11,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;17,4->17,7;;11,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;17,7->18,1;;11,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;18,1->18,4;;11,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;18,4->18,8;;11,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;18,8->19,1;;11,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;19,1->19,4;;12,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;19,4->19,7;;12,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;19,7->20,1;;12,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;20,1->20,4;;12,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;20,4->20,7;;12,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;20,7->21,0;;12,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;21,0->21,3;;12,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;21,3->21,7;;12,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;21,7->22,0;;12,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;22,0->22,3;;12,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;22,3->22,8;;13,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;22,8->23,2;;13,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;23,2->23,7;;13,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;23,7->24,2;;13,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;24,2->24,6;;13,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;24,6->25,1;;13,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;25,1->25,6;;13,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;25,6->26,1;;13,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;26,1->26,5;;13,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;26,5->27,0;;13,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;27,0->27,4;;14,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;27,4->27,7;;14,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;27,7->28,1;;14,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;28,1->28,5;;14,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;28,5->28,8;;14,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;28,8->29,2;;14,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;29,2->29,6;;14,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;29,6->30,0;;14,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;30,0->30,3;;14,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;30,3->30,7;;14,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;30,7->31,1;;15,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;31,1->31,4;;15,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;31,4->31,8;;15,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;31,8->32,1;;15,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;32,1->32,5;;15,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;32,5->32,9;;15,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;32,9->33,2;;15,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;33,2->33,6;;15,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;33,6->33,9;;15,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;33,9->34,3;;15,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;34,3->34,7;;16,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;34,7->35,0;;16,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;35,0->35,4;;16,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;35,4->35,7;;16,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;35,7->36,1;;16,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;36,1->36,5;;16,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;36,5->36,8;;16,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;36,8->37,2;;16,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;37,2->37,5;;16,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;37,5->37,9;;16,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;37,9->38,2;;17,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;38,2->38,6;;17,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;38,6->38,9;;17,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;38,9->39,3;;17,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;39,3->39,6;;17,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;39,6->39,9;;17,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;39,9->40,3;;17,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;40,3->40,6;;17,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;40,6->41,0;;17,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;41,0->41,3;;17,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;41,3->41,6;;18,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;41,6->42,0;;18,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;42,0->42,3;;18,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;42,3->42,7;;18,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;42,7->43,0;;18,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;43,0->43,3;;18,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;43,3->43,7;;18,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;43,7->44,0;;18,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;44,0->44,4;;18,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;44,4->44,7;;18,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;44,7->45,0;;19,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;45,0->45,4;;19,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;45,4->45,7;;19,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;45,7->46,1;;19,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;46,1->46,4;;19,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;46,4->46,7;;19,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;46,7->47,1;;19,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;47,1->47,4;;19,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;47,4->47,8;;19,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;47,8->48,1;;19,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;48,1->48,4;;20,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;48,4->48,7;;20,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;48,7->49,1;;20,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;49,1->49,4;;20,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;49,4->49,7;;20,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;49,7->50,0;;20,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;50,0->50,3;;20,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;50,3->50,7;;20,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;50,7->51,0;;20,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;51,0->51,3;;20,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;51,3->51,6;;21,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;51,6->51,9;;21,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;51,9->52,3;;21,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;52,3->52,6;;21,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;52,6->52,9;;21,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;52,9->53,2;;21,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;53,2->53,5;;21,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;53,5->53,9;;21,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;53,9->54,2;;21,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;54,2->54,5;;21,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;54,5->54,8;;22,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;54,8->55,1;;22,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;55,1->55,4;;22,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;55,4->55,7;;22,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;55,7->56,0;;22,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;56,0->56,3;;22,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;56,3->56,6;;22,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;56,6->56,9;;22,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;56,9->57,2;;22,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;57,2->57,5;;22,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;57,5->57,8;;23,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;57,8->58,1;;23,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;58,1->58,4;;23,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;58,4->58,7;;23,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;58,7->59,0;;23,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;59,0->59,3;;23,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;59,3->59,6;;23,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;59,6->59,9;;23,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;59,9->60,2;;23,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;60,2->60,5;;23,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;60,5->60,8;;24,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;60,8->61,1;;24,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;61,1->61,4;;24,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;61,4->61,7;;24,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;61,7->62,0;;24,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;62,0->62,2;;24,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;62,2->62,5;;24,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;62,5->62,8;;24,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;62,8->63,1;;24,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;63,1->63,4;;24,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;63,4->63,7;;25,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;63,7->64,0;;25,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;64,0->64,2;;25,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;64,2->64,5;;25,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;64,5->64,8;;25,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;64,8->65,1;;25,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;65,1->65,4;;25,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;65,4->65,6;;25,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;65,6->65,9;;25,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;65,9->66,2;;25,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;66,2->66,5;;26,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;66,5->66,7;;26,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;66,7->67,0;;26,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;67,0->67,3;;26,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;67,3->67,6;;26,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;67,6->67,8;;26,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;67,8->68,1;;26,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;68,1->68,4;;26,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;68,4->68,6;;26,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;68,6->68,9;;26,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;68,9->69,2;;27,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;69,2->69,4;;27,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;69,4->69,6;;27,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;69,6->69,9;;27,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;69,9->70,2;;27,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;70,2->70,4;;27,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;70,4->70,6;;27,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;70,6->70,9;;27,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;70,9->71,2;;27,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;71,2->71,4;;27,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;71,4->71,6;;28,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;71,6->71,9;;28,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;71,9->72,2;;28,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;72,2->72,4;;28,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;72,4->72,6;;28,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;72,6->72,9;;28,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;72,9->73,2;;28,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;73,2->73,4;;28,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;73,4->73,6;;28,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;73,6->73,9;;28,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;73,9->74,1;;29,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;74,1->74,4;;29,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;74,4->74,6;;29,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;74,6->74,8;;29,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;74,8->75,1;;29,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;75,1->75,3;;29,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;75,3->75,5;;29,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;75,5->75,7;;29,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;75,7->76,0;;29,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;76,0->76,2;;29,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;76,2->76,4;;30,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;76,4->76,7;;30,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;76,7->76,9;;30,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;76,9->77,1;;30,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;77,1->77,4;;30,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;77,4->77,6;;30,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;77,6->77,8;;30,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;77,8->78,0;;30,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;78,0->78,3;;30,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;78,3->78,5;;30,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;78,5->78,7;;31,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;78,7->78,9;;31,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;78,9->79,1;;31,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;79,1->79,3;;31,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;79,3->79,6;;31,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;79,6->79,8;;31,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;79,8->80,0;;31,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;80,0->80,2;;31,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;80,2->80,4;;31,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;80,4->80,6;;31,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;80,6->80,8;;32,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;80,8->81,0;;32,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;81,0->81,2;;32,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;81,2->81,4;;32,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;81,4->81,6;;32,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;81,6->81,7;;32,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;81,7->81,9;;32,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;81,9->82,1;;32,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;82,1->82,3;;32,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;82,3->82,5;;32,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;82,5->82,7;;33,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;82,7->82,9;;33,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;82,9->83,1;;33,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;83,1->83,3;;33,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;83,3->83,4;;33,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;83,4->83,6;;33,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;83,6->83,8;;33,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;83,8->84,0;;33,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;84,0->84,2;;33,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;84,2->84,4;;33,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;84,4->84,6;;34,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;84,6->84,7;;34,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;84,7->84,9;;34,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;84,9->85,1;;34,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;85,1->85,2;;34,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;85,2->85,4;;34,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;85,4->85,6;;34,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;85,6->85,8;;34,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;85,8->85,9;;34,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;85,9->86,1;;34,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;86,1->86,2;;35,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;86,2->86,4;;35,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;86,4->86,6;;35,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;86,6->86,7;;35,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;86,7->86,8;;35,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;86,8->87,0;;35,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;87,0->87,1;;35,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;87,1->87,3;;35,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;87,3->87,4;;35,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;87,4->87,6;;35,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;87,6->87,8;;36,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;87,8->87,9;;36,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;87,9->88,0;;36,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;88,0->88,2;;36,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;88,2->88,4;;36,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;88,4->88,5;;36,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;88,5->88,6;;36,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;88,6->88,8;;36,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;88,8->88,9;;36,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;88,9->89,1;;36,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;89,1->89,2;;37,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;89,2->89,3;;37,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;89,3->89,5;;37,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;89,5->89,6;;37,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;89,6->89,7;;37,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;89,7->89,8;;37,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;89,8->89,9;;37,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;89,9->90,1;;37,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;90,1->90,2;;37,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;90,2->90,3;;37,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;90,3->90,4;;38,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;90,4->90,5;;38,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;90,5->90,6;;38,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;90,6->90,7;;38,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;90,7->90,8;;38,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;90,8->91,0;;38,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;91,0->91,1;;38,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;91,1->91,2;;38,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;91,2->91,3;;38,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;91,3->91,4;;38,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;91,4->91,5;;39,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;91,5->91,6;;39,10 semanas$$\n");
        sb.append("626;;cadastrarLogica;;91,6->91,7;;39,20 semanas$$\n");
        sb.append("626;;cadastrarLogica;;91,7->91,8;;39,30 semanas$$\n");
        sb.append("626;;cadastrarLogica;;91,8->91,9;;39,40 semanas$$\n");
        sb.append("626;;cadastrarLogica;;91,9->92,0;;39,50 semanas$$\n");
        sb.append("626;;cadastrarLogica;;92,0->92,1;;39,60 semanas$$\n");
        sb.append("626;;cadastrarLogica;;92,1->92,2;;39,70 semanas$$\n");
        sb.append("626;;cadastrarLogica;;92,2->92,3;;39,80 semanas$$\n");
        sb.append("626;;cadastrarLogica;;92,3->92,4;;39,90 semanas$$\n");
        sb.append("626;;cadastrarLogica;;92,4->93,1;;40,00 semanas$$\n");
        sb.append("626;;cadastrarLogica;;93,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

    }

    private static void preencherIghFeto5 ()
    {

        // <editor-fold defaultstate="collapsed" desc="Fêmur">

        sb.append("629;;cadastrarLogica;;0,0->7,1;;<12,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;7,1->8,1;;12,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;8,1->9,1;;12,33 semanas$$\n");
        sb.append("629;;cadastrarLogica;;9,1->10,1;;12,67 semanas$$\n");
        sb.append("629;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("629;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("629;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("629;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("629;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("629;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("629;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;20,1->21,1;;16,33 semanas$$\n");
        sb.append("629;;cadastrarLogica;;21,1->22,1;;16,67 semanas$$\n");
        sb.append("629;;cadastrarLogica;;22,1->23,1;;17,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;23,1->24,1;;17,50 semanas$$\n");
        sb.append("629;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("629;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("629;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;28,1->29,1;;19,33 semanas$$\n");
        sb.append("629;;cadastrarLogica;;29,1->30,1;;19,67 semanas$$\n");
        sb.append("629;;cadastrarLogica;;30,1->31,1;;20,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;31,1->32,1;;20,33 semanas$$\n");
        sb.append("629;;cadastrarLogica;;32,1->33,1;;20,67 semanas$$\n");
        sb.append("629;;cadastrarLogica;;33,1->34,1;;21,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;34,1->35,1;;21,50 semanas$$\n");
        sb.append("629;;cadastrarLogica;;35,1->36,1;;22,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;36,1->37,1;;22,33 semanas$$\n");
        sb.append("629;;cadastrarLogica;;37,1->38,1;;22,67 semanas$$\n");
        sb.append("629;;cadastrarLogica;;38,1->39,1;;23,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;39,1->40,1;;23,33 semanas$$\n");
        sb.append("629;;cadastrarLogica;;40,1->41,1;;23,67 semanas$$\n");
        sb.append("629;;cadastrarLogica;;41,1->42,1;;24,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;42,1->43,1;;24,50 semanas$$\n");
        sb.append("629;;cadastrarLogica;;43,1->44,1;;25,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;44,1->45,1;;25,33 semanas$$\n");
        sb.append("629;;cadastrarLogica;;45,1->46,1;;25,67 semanas$$\n");
        sb.append("629;;cadastrarLogica;;46,1->47,1;;26,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;47,1->48,1;;26,50 semanas$$\n");
        sb.append("629;;cadastrarLogica;;48,1->49,1;;27,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;49,1->50,1;;27,33 semanas$$\n");
        sb.append("629;;cadastrarLogica;;50,1->51,1;;27,67 semanas$$\n");
        sb.append("629;;cadastrarLogica;;51,1->52,1;;28,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;52,1->53,1;;28,50 semanas$$\n");
        sb.append("629;;cadastrarLogica;;53,1->54,1;;29,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;54,1->55,1;;29,50 semanas$$\n");
        sb.append("629;;cadastrarLogica;;55,1->56,1;;30,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;56,1->57,1;;30,33 semanas$$\n");
        sb.append("629;;cadastrarLogica;;57,1->58,1;;30,67 semanas$$\n");
        sb.append("629;;cadastrarLogica;;58,1->59,1;;31,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;59,1->60,1;;31,50 semanas$$\n");
        sb.append("629;;cadastrarLogica;;60,1->61,1;;32,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;61,1->62,1;;32,50 semanas$$\n");
        sb.append("629;;cadastrarLogica;;62,1->63,1;;33,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;63,1->64,1;;33,50 semanas$$\n");
        sb.append("629;;cadastrarLogica;;64,1->65,1;;34,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;65,1->66,1;;34,50 semanas$$\n");
        sb.append("629;;cadastrarLogica;;66,1->67,1;;35,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;67,1->68,1;;36,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;68,1->69,1;;36,50 semanas$$\n");
        sb.append("629;;cadastrarLogica;;69,1->70,1;;37,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;70,1->71,1;;38,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;71,1->72,1;;38,50 semanas$$\n");
        sb.append("629;;cadastrarLogica;;72,1->73,1;;39,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;73,1->74,1;;40,00 semanas$$\n");
        sb.append("629;;cadastrarLogica;;74,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Úmero">

        sb.append("630;;cadastrarLogica;;0,0->8,1;;<12,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;8,1->9,1;;12,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;9,1->10,1;;12,50 semanas$$\n");
        sb.append("630;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("630;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("630;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("630;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("630;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("630;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("630;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;20,1->21,1;;16,50 semanas$$\n");
        sb.append("630;;cadastrarLogica;;21,1->22,1;;17,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;22,1->23,1;;17,33 semanas$$\n");
        sb.append("630;;cadastrarLogica;;23,1->24,1;;17,67 semanas$$\n");
        sb.append("630;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("630;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("630;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;28,1->29,1;;19,50 semanas$$\n");
        sb.append("630;;cadastrarLogica;;29,1->30,1;;20,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;30,1->31,1;;20,33 semanas$$\n");
        sb.append("630;;cadastrarLogica;;31,1->32,1;;20,67 semanas$$\n");
        sb.append("630;;cadastrarLogica;;32,1->33,1;;21,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;33,1->34,1;;21,50 semanas$$\n");
        sb.append("630;;cadastrarLogica;;34,1->35,1;;22,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;35,1->36,1;;22,33 semanas$$\n");
        sb.append("630;;cadastrarLogica;;36,1->37,1;;22,67 semanas$$\n");
        sb.append("630;;cadastrarLogica;;37,1->38,1;;23,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;38,1->39,1;;23,50 semanas$$\n");
        sb.append("630;;cadastrarLogica;;39,1->40,1;;24,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;40,1->41,1;;24,50 semanas$$\n");
        sb.append("630;;cadastrarLogica;;41,1->42,1;;25,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;42,1->43,1;;25,50 semanas$$\n");
        sb.append("630;;cadastrarLogica;;43,1->44,1;;26,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;44,1->45,1;;26,50 semanas$$\n");
        sb.append("630;;cadastrarLogica;;45,1->46,1;;27,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;46,1->47,1;;27,50 semanas$$\n");
        sb.append("630;;cadastrarLogica;;47,1->48,1;;28,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;48,1->49,1;;28,50 semanas$$\n");
        sb.append("630;;cadastrarLogica;;49,1->50,1;;29,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;50,1->51,1;;30,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;51,1->52,1;;30,50 semanas$$\n");
        sb.append("630;;cadastrarLogica;;52,1->53,1;;31,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;53,1->54,1;;31,50 semanas$$\n");
        sb.append("630;;cadastrarLogica;;54,1->55,1;;32,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;55,1->56,1;;33,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;56,1->57,1;;33,50 semanas$$\n");
        sb.append("630;;cadastrarLogica;;57,1->58,1;;34,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;58,1->59,1;;35,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;59,1->60,1;;35,50 semanas$$\n");
        sb.append("630;;cadastrarLogica;;60,1->61,1;;36,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;61,1->62,1;;37,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;63,1->64,1;;38,50 semanas$$\n");
        sb.append("630;;cadastrarLogica;;64,1->65,1;;39,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("630;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ulna">

        sb.append("631;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("631;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("631;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;10,1->11,1;;13,33 semanas$$\n");
        sb.append("631;;cadastrarLogica;;11,1->12,1;;13,67 semanas$$\n");
        sb.append("631;;cadastrarLogica;;12,1->13,1;;14,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;13,1->14,1;;14,50 semanas$$\n");
        sb.append("631;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;15,1->16,1;;15,33 semanas$$\n");
        sb.append("631;;cadastrarLogica;;16,1->17,1;;15,67 semanas$$\n");
        sb.append("631;;cadastrarLogica;;17,1->18,1;;16,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;18,1->19,1;;16,33 semanas$$\n");
        sb.append("631;;cadastrarLogica;;19,1->20,1;;16,67 semanas$$\n");
        sb.append("631;;cadastrarLogica;;20,1->21,1;;17,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;21,1->22,1;;17,50 semanas$$\n");
        sb.append("631;;cadastrarLogica;;22,1->23,1;;18,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;23,1->24,1;;18,33 semanas$$\n");
        sb.append("631;;cadastrarLogica;;24,1->25,1;;18,67 semanas$$\n");
        sb.append("631;;cadastrarLogica;;25,1->26,1;;19,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;26,1->27,1;;19,50 semanas$$\n");
        sb.append("631;;cadastrarLogica;;27,1->28,1;;20,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;28,1->29,1;;20,33 semanas$$\n");
        sb.append("631;;cadastrarLogica;;29,1->30,1;;20,67 semanas$$\n");
        sb.append("631;;cadastrarLogica;;30,1->31,1;;21,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;31,1->32,1;;21,50 semanas$$\n");
        sb.append("631;;cadastrarLogica;;32,1->33,1;;22,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;33,1->34,1;;22,50 semanas$$\n");
        sb.append("631;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("631;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;37,1->38,1;;24,50 semanas$$\n");
        sb.append("631;;cadastrarLogica;;38,1->39,1;;25,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;39,1->40,1;;25,50 semanas$$\n");
        sb.append("631;;cadastrarLogica;;40,1->41,1;;26,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;41,1->42,1;;26,50 semanas$$\n");
        sb.append("631;;cadastrarLogica;;42,1->43,1;;27,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;43,1->44,1;;27,50 semanas$$\n");
        sb.append("631;;cadastrarLogica;;44,1->45,1;;28,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;45,1->46,1;;28,50 semanas$$\n");
        sb.append("631;;cadastrarLogica;;46,1->47,1;;29,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;47,1->48,1;;30,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;48,1->49,1;;30,50 semanas$$\n");
        sb.append("631;;cadastrarLogica;;49,1->50,1;;31,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;50,1->51,1;;31,50 semanas$$\n");
        sb.append("631;;cadastrarLogica;;51,1->52,1;;32,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;52,1->53,1;;33,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;53,1->54,1;;33,50 semanas$$\n");
        sb.append("631;;cadastrarLogica;;54,1->55,1;;34,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;55,1->56,1;;35,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;56,1->57,1;;36,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;57,1->58,1;;37,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;58,1->59,1;;38,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;59,1->60,1;;39,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;60,1->61,1;;40,00 semanas$$\n");
        sb.append("631;;cadastrarLogica;;61,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tíbia">

        sb.append("632;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("632;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("632;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;10,1->11,1;;13,50 semanas$$\n");
        sb.append("632;;cadastrarLogica;;11,1->12,1;;14,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;12,1->13,1;;14,33 semanas$$\n");
        sb.append("632;;cadastrarLogica;;13,1->14,1;;14,67 semanas$$\n");
        sb.append("632;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;15,1->16,1;;15,50 semanas$$\n");
        sb.append("632;;cadastrarLogica;;16,1->17,1;;16,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;17,1->18,1;;16,33 semanas$$\n");
        sb.append("632;;cadastrarLogica;;18,1->19,1;;16,67 semanas$$\n");
        sb.append("632;;cadastrarLogica;;19,1->20,1;;17,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;20,1->21,1;;17,50 semanas$$\n");
        sb.append("632;;cadastrarLogica;;21,1->22,1;;18,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;22,1->23,1;;18,33 semanas$$\n");
        sb.append("632;;cadastrarLogica;;23,1->24,1;;18,67 semanas$$\n");
        sb.append("632;;cadastrarLogica;;24,1->25,1;;19,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;25,1->26,1;;19,50 semanas$$\n");
        sb.append("632;;cadastrarLogica;;26,1->27,1;;20,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;27,1->28,1;;20,33 semanas$$\n");
        sb.append("632;;cadastrarLogica;;28,1->29,1;;20,67 semanas$$\n");
        sb.append("632;;cadastrarLogica;;29,1->30,1;;21,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;30,1->31,1;;21,50 semanas$$\n");
        sb.append("632;;cadastrarLogica;;31,1->32,1;;22,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;32,1->33,1;;22,33 semanas$$\n");
        sb.append("632;;cadastrarLogica;;33,1->34,1;;22,67 semanas$$\n");
        sb.append("632;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("632;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;37,1->38,1;;24,33 semanas$$\n");
        sb.append("632;;cadastrarLogica;;38,1->39,1;;24,67 semanas$$\n");
        sb.append("632;;cadastrarLogica;;39,1->40,1;;25,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;40,1->41,1;;25,50 semanas$$\n");
        sb.append("632;;cadastrarLogica;;41,1->42,1;;26,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;42,1->43,1;;26,50 semanas$$\n");
        sb.append("632;;cadastrarLogica;;43,1->44,1;;27,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;44,1->45,1;;27,50 semanas$$\n");
        sb.append("632;;cadastrarLogica;;45,1->46,1;;28,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;46,1->47,1;;28,50 semanas$$\n");
        sb.append("632;;cadastrarLogica;;47,1->48,1;;29,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;48,1->49,1;;29,50 semanas$$\n");
        sb.append("632;;cadastrarLogica;;49,1->50,1;;30,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;50,1->51,1;;30,50 semanas$$\n");
        sb.append("632;;cadastrarLogica;;51,1->52,1;;31,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;52,1->53,1;;31,50 semanas$$\n");
        sb.append("632;;cadastrarLogica;;53,1->54,1;;32,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;54,1->55,1;;33,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;55,1->56,1;;33,50 semanas$$\n");
        sb.append("632;;cadastrarLogica;;56,1->57,1;;34,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;57,1->58,1;;35,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;58,1->59,1;;35,50 semanas$$\n");
        sb.append("632;;cadastrarLogica;;59,1->60,1;;36,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;60,1->61,1;;37,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;61,1->62,1;;37,50 semanas$$\n");
        sb.append("632;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;63,1->64,1;;39,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;64,1->65,1;;39,50 semanas$$\n");
        sb.append("632;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("632;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.A.">

        sb.append("634;;cadastrarLogica;;0,0->39,3;;<11,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;39,3->40,6;;11,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;40,6->41,9;;11,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;41,9->43,2;;11,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;43,2->44,5;;11,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;44,5->45,8;;11,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;45,8->47,0;;11,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;47,0->48,3;;11,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;48,3->49,6;;11,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;49,6->50,9;;11,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;50,9->52,2;;11,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;52,2->53,5;;12,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;53,5->54,8;;12,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;54,8->56,0;;12,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;56,0->57,3;;12,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;57,3->58,6;;12,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;58,6->59,9;;12,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;59,9->61,2;;12,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;61,2->62,4;;12,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;62,4->63,7;;12,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;63,7->65,0;;12,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;65,0->66,3;;13,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;66,3->67,5;;13,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;67,5->68,8;;13,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;68,8->70,1;;13,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;70,1->71,4;;13,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;71,4->72,6;;13,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;72,6->73,9;;13,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;73,9->75,2;;13,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;75,2->76,4;;13,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;76,4->77,7;;13,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;77,7->79,0;;14,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;79,0->80,2;;14,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;80,2->81,4;;14,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;81,4->82,7;;14,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;82,7->84,0;;14,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;84,0->85,2;;14,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;85,2->86,4;;14,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;86,4->87,7;;14,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;87,7->89,0;;14,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;89,0->90,2;;14,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;90,2->91,4;;15,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;91,4->92,7;;15,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;92,7->94,0;;15,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;94,0->95,2;;15,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;95,2->96,4;;15,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;96,4->97,7;;15,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;97,7->99,0;;15,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;99,0->100,2;;15,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;100,2->101,4;;15,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;101,4->102,7;;15,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;102,7->103,9;;16,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;103,9->105,2;;16,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;105,2->106,4;;16,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;106,4->107,6;;16,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;107,6->108,8;;16,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;108,8->110,1;;16,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;110,1->111,3;;16,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;111,3->112,5;;16,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;112,5->113,8;;16,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;113,8->115,0;;16,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;115,0->116,2;;17,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;116,2->117,4;;17,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;117,4->118,7;;17,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;118,7->119,9;;17,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;119,9->121,1;;17,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;121,1->122,3;;17,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;122,3->123,5;;17,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;123,5->124,8;;17,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;124,8->126,0;;17,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;126,0->127,2;;17,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;127,2->128,4;;18,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;128,4->129,6;;18,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;129,6->130,8;;18,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;130,8->132,0;;18,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;132,0->133,2;;18,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;133,2->134,4;;18,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;134,4->135,6;;18,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;135,6->136,8;;18,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;136,8->138,0;;18,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;138,0->139,2;;18,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;139,2->140,4;;19,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;140,4->141,6;;19,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;141,6->142,8;;19,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;142,8->144,0;;19,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;144,0->145,1;;19,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;145,1->146,3;;19,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;146,3->147,5;;19,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;147,5->148,7;;19,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;148,7->149,9;;19,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;149,9->151,1;;19,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;151,1->152,3;;20,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;152,3->153,4;;20,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;153,4->154,6;;20,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;154,6->155,8;;20,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;155,8->157,0;;20,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;157,0->158,1;;20,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;158,1->159,3;;20,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;159,3->160,5;;20,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;160,5->161,6;;20,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;161,6->162,8;;20,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;162,8->164,0;;21,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;164,0->165,1;;21,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;165,1->166,3;;21,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;166,3->167,4;;21,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;167,4->168,6;;21,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;168,6->169,8;;21,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;169,8->170,9;;21,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;170,9->172,1;;21,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;172,1->173,2;;21,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;173,2->174,4;;21,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;174,4->175,5;;22,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;175,5->176,7;;22,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;176,7->177,8;;22,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;177,8->179,0;;22,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;179,0->180,1;;22,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;180,1->181,2;;22,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;181,2->182,4;;22,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;182,4->183,5;;22,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;183,5->184,7;;22,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;184,7->185,8;;22,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;185,8->186,9;;23,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;186,9->188,0;;23,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;188,0->189,2;;23,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;189,2->190,3;;23,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;190,3->191,4;;23,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;191,4->192,5;;23,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;192,5->193,6;;23,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;193,6->194,8;;23,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;194,8->195,9;;23,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;195,9->197,0;;23,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;197,0->198,1;;24,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;198,1->199,2;;24,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;199,2->200,3;;24,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;200,3->201,4;;24,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;201,4->202,5;;24,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;202,5->203,6;;24,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;203,6->204,7;;24,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;204,7->205,8;;24,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;205,8->206,9;;24,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;206,9->208,0;;24,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;208,0->209,1;;25,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;209,1->210,2;;25,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;210,2->211,2;;25,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;211,2->212,3;;25,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;212,3->213,4;;25,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;213,4->214,5;;25,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;214,5->215,6;;25,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;215,6->216,6;;25,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;216,6->217,7;;25,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;217,7->218,8;;25,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;218,8->219,9;;26,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;219,9->220,9;;26,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;220,9->222,0;;26,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;222,0->223,0;;26,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;223,0->224,1;;26,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;224,1->225,2;;26,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;225,2->226,2;;26,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;226,2->227,3;;26,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;227,3->228,3;;26,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;228,3->229,4;;26,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;229,4->230,4;;27,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;230,4->231,5;;27,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;231,5->232,5;;27,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;232,5->233,6;;27,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;233,6->234,6;;27,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;234,6->235,6;;27,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;235,6->236,7;;27,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;236,7->237,7;;27,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;237,7->238,8;;27,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;238,8->239,8;;27,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;239,8->240,8;;28,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;240,8->241,8;;28,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;241,8->242,8;;28,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;242,8->243,8;;28,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;243,8->244,9;;28,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;244,9->245,9;;28,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;245,9->246,9;;28,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;246,9->247,9;;28,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;247,9->248,9;;28,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;248,9->249,9;;28,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;249,9->250,9;;29,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;250,9->251,9;;29,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;251,9->252,9;;29,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;252,9->253,9;;29,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;253,9->254,9;;29,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;254,9->255,8;;29,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;255,8->256,8;;29,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;256,8->257,8;;29,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;257,8->258,8;;29,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;258,8->259,8;;29,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;259,8->260,8;;30,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;260,8->261,7;;30,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;261,7->262,7;;30,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;262,7->263,7;;30,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;263,7->264,6;;30,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;264,6->265,6;;30,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;265,6->266,6;;30,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;266,6->267,6;;30,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;267,6->268,5;;30,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;268,5->269,5;;30,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;269,5->270,4;;31,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;270,4->271,4;;31,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;271,4->272,4;;31,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;272,4->273,3;;31,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;273,3->274,2;;31,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;274,2->275,2;;31,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;275,2->276,2;;31,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;276,2->277,1;;31,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;277,1->278,0;;31,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;278,0->279,0;;31,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;279,0->279,9;;32,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;279,9->280,8;;32,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;280,8->281,7;;32,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;281,7->282,6;;32,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;282,6->283,6;;32,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;283,6->284,5;;32,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;284,5->285,4;;32,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;285,4->286,3;;32,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;286,3->287,2;;32,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;287,2->288,1;;32,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;288,1->289,0;;33,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;289,0->289,9;;33,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;289,9->290,8;;33,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;290,8->291,7;;33,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;291,7->292,6;;33,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;292,6->293,5;;33,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;293,5->294,4;;33,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;294,4->295,3;;33,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;295,3->296,2;;33,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;296,2->297,1;;33,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;297,1->298,0;;34,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;298,0->298,8;;34,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;298,8->299,7;;34,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;299,7->300,5;;34,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;300,5->301,4;;34,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;301,4->302,3;;34,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;302,3->303,1;;34,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;303,1->304,0;;34,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;304,0->304,8;;34,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;304,8->305,7;;34,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;305,7->306,5;;35,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;306,5->307,4;;35,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;307,4->308,2;;35,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;308,2->309,1;;35,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;309,1->309,9;;35,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;309,9->310,7;;35,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;310,7->311,6;;35,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;311,6->312,4;;35,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;312,4->313,3;;35,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;313,3->314,1;;35,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;314,1->314,9;;36,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;314,9->315,7;;36,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;315,7->316,5;;36,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;316,5->317,3;;36,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;317,3->318,1;;36,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;318,1->318,9;;36,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;318,9->319,7;;36,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;319,7->320,5;;36,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;320,5->321,3;;36,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;321,3->322,1;;36,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;322,1->322,9;;37,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;322,9->323,7;;37,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;323,7->324,4;;37,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;324,4->325,2;;37,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;325,2->326,0;;37,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;326,0->326,8;;37,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;326,8->327,6;;37,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;327,6->328,3;;37,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;328,3->329,1;;37,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;329,1->329,9;;37,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;329,9->330,6;;38,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;330,6->331,4;;38,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;331,4->332,2;;38,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;332,2->332,9;;38,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;332,9->333,6;;38,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;333,6->334,4;;38,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;334,4->335,2;;38,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;335,2->335,9;;38,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;335,9->336,6;;38,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;336,6->337,4;;38,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;337,4->338,1;;39,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;338,1->338,8;;39,10 semanas$$\n");
        sb.append("634;;cadastrarLogica;;338,8->339,5;;39,20 semanas$$\n");
        sb.append("634;;cadastrarLogica;;339,5->340,2;;39,30 semanas$$\n");
        sb.append("634;;cadastrarLogica;;340,2->341,0;;39,40 semanas$$\n");
        sb.append("634;;cadastrarLogica;;341,0->341,7;;39,50 semanas$$\n");
        sb.append("634;;cadastrarLogica;;341,7->342,4;;39,60 semanas$$\n");
        sb.append("634;;cadastrarLogica;;342,4->343,1;;39,70 semanas$$\n");
        sb.append("634;;cadastrarLogica;;343,1->343,8;;39,80 semanas$$\n");
        sb.append("634;;cadastrarLogica;;343,8->344,5;;39,90 semanas$$\n");
        sb.append("634;;cadastrarLogica;;344,5->346,1;;40,00 semanas$$\n");
        sb.append("634;;cadastrarLogica;;346,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.C.">

        sb.append("635;;cadastrarLogica;;0,0->53,2;;<11,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;53,2->54,6;;11,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;54,6->56,1;;11,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;56,1->57,5;;11,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;57,5->58,9;;11,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;58,9->60,4;;11,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;60,4->61,8;;11,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;61,8->63,2;;11,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;63,2->64,6;;11,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;64,6->66,1;;11,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;66,1->67,5;;11,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;67,5->68,9;;12,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;68,9->70,4;;12,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;70,4->71,8;;12,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;71,8->73,2;;12,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;73,2->74,6;;12,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;74,6->76,1;;12,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;76,1->77,5;;12,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;77,5->78,9;;12,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;78,9->80,4;;12,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;80,4->81,8;;12,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;81,8->83,2;;13,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;83,2->84,5;;13,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;84,5->85,9;;13,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;85,9->87,3;;13,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;87,3->88,6;;13,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;88,6->90,0;;13,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;90,0->91,4;;13,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;91,4->92,8;;13,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;92,8->94,1;;13,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;94,1->95,5;;13,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;95,5->96,9;;14,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;96,9->98,2;;14,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;98,2->99,6;;14,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;99,6->101,0;;14,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;101,0->102,4;;14,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;102,4->103,7;;14,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;103,7->105,1;;14,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;105,1->106,5;;14,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;106,5->107,8;;14,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;107,8->109,2;;14,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;109,2->110,6;;15,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;110,6->111,9;;15,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;111,9->113,2;;15,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;113,2->114,6;;15,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;114,6->116,0;;15,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;116,0->117,3;;15,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;117,3->118,6;;15,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;118,6->120,0;;15,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;120,0->121,4;;15,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;121,4->122,7;;15,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;122,7->124,0;;16,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;124,0->125,3;;16,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;125,3->126,6;;16,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;126,6->127,9;;16,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;127,9->129,2;;16,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;129,2->130,6;;16,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;130,6->131,9;;16,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;131,9->133,2;;16,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;133,2->134,5;;16,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;134,5->135,8;;16,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;135,8->137,1;;17,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;137,1->138,4;;17,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;138,4->139,7;;17,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;139,7->141,0;;17,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;141,0->142,2;;17,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;142,2->143,5;;17,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;143,5->144,8;;17,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;144,8->146,1;;17,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;146,1->147,4;;17,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;147,4->148,7;;17,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;148,7->150,0;;18,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;150,0->151,2;;18,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;151,2->152,5;;18,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;152,5->153,7;;18,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;153,7->155,0;;18,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;155,0->156,3;;18,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;156,3->157,5;;18,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;157,5->158,8;;18,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;158,8->160,0;;18,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;160,0->161,3;;18,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;161,3->162,5;;19,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;162,5->163,7;;19,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;163,7->165,0;;19,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;165,0->166,2;;19,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;166,2->167,4;;19,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;167,4->168,6;;19,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;168,6->169,8;;19,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;169,8->171,1;;19,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;171,1->172,3;;19,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;172,3->173,5;;19,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;173,5->174,7;;20,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;174,7->175,9;;20,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;175,9->177,1;;20,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;177,1->178,3;;20,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;178,3->179,5;;20,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;179,5->180,7;;20,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;180,7->181,9;;20,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;181,9->183,1;;20,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;183,1->184,3;;20,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;184,3->185,5;;20,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;185,5->186,6;;21,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;186,6->187,8;;21,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;187,8->189,0;;21,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;189,0->190,1;;21,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;190,1->191,2;;21,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;191,2->192,4;;21,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;192,4->193,6;;21,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;193,6->194,7;;21,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;194,7->195,8;;21,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;195,8->197,0;;21,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;197,0->198,1;;22,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;198,1->199,3;;22,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;199,3->200,4;;22,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;200,4->201,5;;22,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;201,5->202,6;;22,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;202,6->203,8;;22,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;203,8->204,9;;22,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;204,9->206,0;;22,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;206,0->207,2;;22,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;207,2->208,3;;22,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;208,3->209,4;;23,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;209,4->210,5;;23,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;210,5->211,5;;23,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;211,5->212,6;;23,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;212,6->213,7;;23,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;213,7->214,8;;23,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;214,8->215,9;;23,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;215,9->216,9;;23,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;216,9->218,0;;23,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;218,0->219,1;;23,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;219,1->220,1;;24,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;220,1->221,2;;24,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;221,2->222,2;;24,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;222,2->223,3;;24,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;223,3->224,3;;24,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;224,3->225,3;;24,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;225,3->226,4;;24,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;226,4->227,4;;24,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;227,4->228,5;;24,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;228,5->229,5;;24,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;229,5->230,5;;25,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;230,5->231,5;;25,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;231,5->232,5;;25,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;232,5->233,5;;25,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;233,5->234,5;;25,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;234,5->235,5;;25,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;235,5->236,5;;25,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;236,5->237,5;;25,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;237,5->238,5;;25,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;238,5->239,5;;25,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;239,5->240,5;;26,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;240,5->241,4;;26,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;241,4->242,4;;26,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;242,4->243,3;;26,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;243,3->244,3;;26,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;244,3->245,3;;26,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;245,3->246,2;;26,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;246,2->247,2;;26,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;247,2->248,1;;26,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;248,1->249,1;;26,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;249,1->250,0;;27,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;250,0->250,9;;27,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;250,9->251,9;;27,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;251,9->252,8;;27,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;252,8->253,7;;27,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;253,7->254,6;;27,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;254,6->255,5;;27,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;255,5->256,5;;27,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;256,5->257,4;;27,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;257,4->258,3;;27,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;258,3->259,2;;28,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;259,2->260,0;;28,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;260,0->260,9;;28,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;260,9->261,7;;28,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;261,7->262,6;;28,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;262,6->263,5;;28,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;263,5->264,3;;28,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;264,3->265,2;;28,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;265,2->266,0;;28,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;266,0->266,9;;28,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;266,9->267,7;;29,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;267,7->268,5;;29,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;268,5->269,4;;29,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;269,4->270,2;;29,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;270,2->271,0;;29,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;271,0->271,8;;29,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;271,8->272,6;;29,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;272,6->273,5;;29,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;273,5->274,3;;29,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;274,3->275,1;;29,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;275,1->275,9;;30,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;275,9->276,6;;30,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;276,6->277,4;;30,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;277,4->278,2;;30,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;278,2->279,0;;30,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;279,0->279,7;;30,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;279,7->280,5;;30,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;280,5->281,3;;30,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;281,3->282,0;;30,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;282,0->282,8;;30,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;282,8->283,5;;31,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;283,5->284,2;;31,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;284,2->284,9;;31,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;284,9->285,6;;31,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;285,6->286,4;;31,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;286,4->287,1;;31,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;287,1->287,8;;31,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;287,8->288,5;;31,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;288,5->289,2;;31,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;289,2->289,9;;31,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;289,9->290,6;;32,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;290,6->291,2;;32,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;291,2->291,9;;32,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;291,9->292,6;;32,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;292,6->293,2;;32,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;293,2->293,9;;32,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;293,9->294,6;;32,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;294,6->295,3;;32,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;295,3->295,9;;32,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;295,9->296,6;;32,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;296,6->297,2;;33,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;297,2->297,8;;33,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;297,8->298,4;;33,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;298,4->299,0;;33,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;299,0->299,6;;33,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;299,6->300,3;;33,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;300,3->300,9;;33,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;300,9->301,5;;33,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;301,5->302,1;;33,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;302,1->302,7;;33,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;302,7->303,2;;34,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;303,2->303,8;;34,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;303,8->304,3;;34,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;304,3->304,9;;34,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;304,9->305,4;;34,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;305,4->306,0;;34,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;306,0->306,6;;34,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;306,6->307,1;;34,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;307,1->307,6;;34,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;307,6->308,2;;34,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;308,2->308,7;;35,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;308,7->309,2;;35,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;309,2->309,7;;35,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;309,7->310,2;;35,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;310,2->310,6;;35,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;310,6->311,1;;35,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;311,1->311,6;;35,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;311,6->312,1;;35,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;312,1->312,6;;35,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;312,6->313,1;;35,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;313,1->313,5;;36,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;313,5->314,0;;36,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;314,0->314,4;;36,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;314,4->314,9;;36,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;314,9->315,3;;36,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;315,3->315,7;;36,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;315,7->316,2;;36,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;316,2->316,6;;36,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;316,6->317,1;;36,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;317,1->317,5;;36,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;317,5->317,9;;37,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;317,9->318,2;;37,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;318,2->318,6;;37,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;318,6->319,0;;37,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;319,0->319,4;;37,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;319,4->319,7;;37,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;319,7->320,1;;37,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;320,1->320,5;;37,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;320,5->320,8;;37,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;320,8->321,2;;37,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;321,2->321,5;;38,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;321,5->321,8;;38,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;321,8->322,1;;38,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;322,1->322,4;;38,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;322,4->322,8;;38,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;322,8->323,1;;38,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;323,1->323,4;;38,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;323,4->323,7;;38,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;323,7->324,0;;38,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;324,0->324,3;;38,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;324,3->324,5;;39,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;324,5->324,8;;39,10 semanas$$\n");
        sb.append("635;;cadastrarLogica;;324,8->325,0;;39,20 semanas$$\n");
        sb.append("635;;cadastrarLogica;;325,0->325,3;;39,30 semanas$$\n");
        sb.append("635;;cadastrarLogica;;325,3->325,5;;39,40 semanas$$\n");
        sb.append("635;;cadastrarLogica;;325,5->325,7;;39,50 semanas$$\n");
        sb.append("635;;cadastrarLogica;;325,7->326,0;;39,60 semanas$$\n");
        sb.append("635;;cadastrarLogica;;326,0->326,2;;39,70 semanas$$\n");
        sb.append("635;;cadastrarLogica;;326,2->326,5;;39,80 semanas$$\n");
        sb.append("635;;cadastrarLogica;;326,5->326,7;;39,90 semanas$$\n");
        sb.append("635;;cadastrarLogica;;326,7->328,1;;40,00 semanas$$\n");
        sb.append("635;;cadastrarLogica;;328,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("633;;cadastrarLogica;;0,0->15,7;;<11,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;15,7->16,0;;11,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;16,0->16,4;;11,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;16,4->16,7;;11,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;16,7->17,1;;11,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;17,1->17,4;;11,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;17,4->17,7;;11,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;17,7->18,1;;11,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;18,1->18,4;;11,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;18,4->18,8;;11,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;18,8->19,1;;11,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;19,1->19,4;;12,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;19,4->19,7;;12,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;19,7->20,1;;12,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;20,1->20,4;;12,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;20,4->20,7;;12,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;20,7->21,0;;12,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;21,0->21,3;;12,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;21,3->21,7;;12,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;21,7->22,0;;12,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;22,0->22,3;;12,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;22,3->22,8;;13,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;22,8->23,2;;13,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;23,2->23,7;;13,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;23,7->24,2;;13,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;24,2->24,6;;13,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;24,6->25,1;;13,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;25,1->25,6;;13,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;25,6->26,1;;13,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;26,1->26,5;;13,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;26,5->27,0;;13,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;27,0->27,4;;14,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;27,4->27,7;;14,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;27,7->28,1;;14,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;28,1->28,5;;14,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;28,5->28,8;;14,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;28,8->29,2;;14,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;29,2->29,6;;14,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;29,6->30,0;;14,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;30,0->30,3;;14,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;30,3->30,7;;14,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;30,7->31,1;;15,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;31,1->31,4;;15,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;31,4->31,8;;15,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;31,8->32,1;;15,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;32,1->32,5;;15,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;32,5->32,9;;15,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;32,9->33,2;;15,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;33,2->33,6;;15,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;33,6->33,9;;15,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;33,9->34,3;;15,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;34,3->34,7;;16,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;34,7->35,0;;16,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;35,0->35,4;;16,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;35,4->35,7;;16,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;35,7->36,1;;16,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;36,1->36,5;;16,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;36,5->36,8;;16,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;36,8->37,2;;16,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;37,2->37,5;;16,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;37,5->37,9;;16,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;37,9->38,2;;17,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;38,2->38,6;;17,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;38,6->38,9;;17,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;38,9->39,3;;17,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;39,3->39,6;;17,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;39,6->39,9;;17,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;39,9->40,3;;17,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;40,3->40,6;;17,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;40,6->41,0;;17,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;41,0->41,3;;17,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;41,3->41,6;;18,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;41,6->42,0;;18,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;42,0->42,3;;18,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;42,3->42,7;;18,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;42,7->43,0;;18,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;43,0->43,3;;18,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;43,3->43,7;;18,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;43,7->44,0;;18,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;44,0->44,4;;18,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;44,4->44,7;;18,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;44,7->45,0;;19,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;45,0->45,4;;19,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;45,4->45,7;;19,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;45,7->46,1;;19,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;46,1->46,4;;19,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;46,4->46,7;;19,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;46,7->47,1;;19,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;47,1->47,4;;19,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;47,4->47,8;;19,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;47,8->48,1;;19,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;48,1->48,4;;20,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;48,4->48,7;;20,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;48,7->49,1;;20,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;49,1->49,4;;20,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;49,4->49,7;;20,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;49,7->50,0;;20,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;50,0->50,3;;20,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;50,3->50,7;;20,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;50,7->51,0;;20,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;51,0->51,3;;20,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;51,3->51,6;;21,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;51,6->51,9;;21,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;51,9->52,3;;21,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;52,3->52,6;;21,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;52,6->52,9;;21,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;52,9->53,2;;21,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;53,2->53,5;;21,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;53,5->53,9;;21,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;53,9->54,2;;21,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;54,2->54,5;;21,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;54,5->54,8;;22,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;54,8->55,1;;22,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;55,1->55,4;;22,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;55,4->55,7;;22,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;55,7->56,0;;22,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;56,0->56,3;;22,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;56,3->56,6;;22,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;56,6->56,9;;22,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;56,9->57,2;;22,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;57,2->57,5;;22,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;57,5->57,8;;23,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;57,8->58,1;;23,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;58,1->58,4;;23,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;58,4->58,7;;23,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;58,7->59,0;;23,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;59,0->59,3;;23,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;59,3->59,6;;23,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;59,6->59,9;;23,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;59,9->60,2;;23,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;60,2->60,5;;23,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;60,5->60,8;;24,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;60,8->61,1;;24,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;61,1->61,4;;24,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;61,4->61,7;;24,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;61,7->62,0;;24,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;62,0->62,2;;24,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;62,2->62,5;;24,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;62,5->62,8;;24,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;62,8->63,1;;24,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;63,1->63,4;;24,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;63,4->63,7;;25,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;63,7->64,0;;25,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;64,0->64,2;;25,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;64,2->64,5;;25,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;64,5->64,8;;25,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;64,8->65,1;;25,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;65,1->65,4;;25,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;65,4->65,6;;25,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;65,6->65,9;;25,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;65,9->66,2;;25,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;66,2->66,5;;26,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;66,5->66,7;;26,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;66,7->67,0;;26,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;67,0->67,3;;26,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;67,3->67,6;;26,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;67,6->67,8;;26,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;67,8->68,1;;26,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;68,1->68,4;;26,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;68,4->68,6;;26,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;68,6->68,9;;26,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;68,9->69,2;;27,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;69,2->69,4;;27,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;69,4->69,6;;27,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;69,6->69,9;;27,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;69,9->70,2;;27,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;70,2->70,4;;27,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;70,4->70,6;;27,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;70,6->70,9;;27,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;70,9->71,2;;27,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;71,2->71,4;;27,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;71,4->71,6;;28,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;71,6->71,9;;28,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;71,9->72,2;;28,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;72,2->72,4;;28,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;72,4->72,6;;28,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;72,6->72,9;;28,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;72,9->73,2;;28,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;73,2->73,4;;28,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;73,4->73,6;;28,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;73,6->73,9;;28,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;73,9->74,1;;29,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;74,1->74,4;;29,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;74,4->74,6;;29,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;74,6->74,8;;29,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;74,8->75,1;;29,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;75,1->75,3;;29,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;75,3->75,5;;29,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;75,5->75,7;;29,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;75,7->76,0;;29,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;76,0->76,2;;29,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;76,2->76,4;;30,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;76,4->76,7;;30,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;76,7->76,9;;30,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;76,9->77,1;;30,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;77,1->77,4;;30,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;77,4->77,6;;30,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;77,6->77,8;;30,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;77,8->78,0;;30,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;78,0->78,3;;30,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;78,3->78,5;;30,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;78,5->78,7;;31,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;78,7->78,9;;31,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;78,9->79,1;;31,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;79,1->79,3;;31,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;79,3->79,6;;31,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;79,6->79,8;;31,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;79,8->80,0;;31,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;80,0->80,2;;31,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;80,2->80,4;;31,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;80,4->80,6;;31,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;80,6->80,8;;32,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;80,8->81,0;;32,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;81,0->81,2;;32,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;81,2->81,4;;32,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;81,4->81,6;;32,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;81,6->81,7;;32,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;81,7->81,9;;32,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;81,9->82,1;;32,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;82,1->82,3;;32,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;82,3->82,5;;32,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;82,5->82,7;;33,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;82,7->82,9;;33,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;82,9->83,1;;33,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;83,1->83,3;;33,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;83,3->83,4;;33,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;83,4->83,6;;33,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;83,6->83,8;;33,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;83,8->84,0;;33,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;84,0->84,2;;33,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;84,2->84,4;;33,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;84,4->84,6;;34,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;84,6->84,7;;34,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;84,7->84,9;;34,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;84,9->85,1;;34,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;85,1->85,2;;34,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;85,2->85,4;;34,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;85,4->85,6;;34,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;85,6->85,8;;34,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;85,8->85,9;;34,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;85,9->86,1;;34,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;86,1->86,2;;35,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;86,2->86,4;;35,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;86,4->86,6;;35,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;86,6->86,7;;35,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;86,7->86,8;;35,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;86,8->87,0;;35,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;87,0->87,1;;35,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;87,1->87,3;;35,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;87,3->87,4;;35,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;87,4->87,6;;35,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;87,6->87,8;;36,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;87,8->87,9;;36,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;87,9->88,0;;36,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;88,0->88,2;;36,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;88,2->88,4;;36,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;88,4->88,5;;36,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;88,5->88,6;;36,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;88,6->88,8;;36,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;88,8->88,9;;36,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;88,9->89,1;;36,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;89,1->89,2;;37,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;89,2->89,3;;37,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;89,3->89,5;;37,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;89,5->89,6;;37,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;89,6->89,7;;37,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;89,7->89,8;;37,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;89,8->89,9;;37,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;89,9->90,1;;37,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;90,1->90,2;;37,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;90,2->90,3;;37,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;90,3->90,4;;38,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;90,4->90,5;;38,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;90,5->90,6;;38,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;90,6->90,7;;38,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;90,7->90,8;;38,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;90,8->91,0;;38,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;91,0->91,1;;38,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;91,1->91,2;;38,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;91,2->91,3;;38,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;91,3->91,4;;38,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;91,4->91,5;;39,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;91,5->91,6;;39,10 semanas$$\n");
        sb.append("633;;cadastrarLogica;;91,6->91,7;;39,20 semanas$$\n");
        sb.append("633;;cadastrarLogica;;91,7->91,8;;39,30 semanas$$\n");
        sb.append("633;;cadastrarLogica;;91,8->91,9;;39,40 semanas$$\n");
        sb.append("633;;cadastrarLogica;;91,9->92,0;;39,50 semanas$$\n");
        sb.append("633;;cadastrarLogica;;92,0->92,1;;39,60 semanas$$\n");
        sb.append("633;;cadastrarLogica;;92,1->92,2;;39,70 semanas$$\n");
        sb.append("633;;cadastrarLogica;;92,2->92,3;;39,80 semanas$$\n");
        sb.append("633;;cadastrarLogica;;92,3->92,4;;39,90 semanas$$\n");
        sb.append("633;;cadastrarLogica;;92,4->93,1;;40,00 semanas$$\n");
        sb.append("633;;cadastrarLogica;;93,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

    }

    private static void preencherIghFeto6 ()
    {

        // <editor-fold defaultstate="collapsed" desc="Fêmur">

        sb.append("636;;cadastrarLogica;;0,0->7,1;;<12,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;7,1->8,1;;12,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;8,1->9,1;;12,33 semanas$$\n");
        sb.append("636;;cadastrarLogica;;9,1->10,1;;12,67 semanas$$\n");
        sb.append("636;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("636;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("636;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("636;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("636;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("636;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("636;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;20,1->21,1;;16,33 semanas$$\n");
        sb.append("636;;cadastrarLogica;;21,1->22,1;;16,67 semanas$$\n");
        sb.append("636;;cadastrarLogica;;22,1->23,1;;17,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;23,1->24,1;;17,50 semanas$$\n");
        sb.append("636;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("636;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("636;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;28,1->29,1;;19,33 semanas$$\n");
        sb.append("636;;cadastrarLogica;;29,1->30,1;;19,67 semanas$$\n");
        sb.append("636;;cadastrarLogica;;30,1->31,1;;20,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;31,1->32,1;;20,33 semanas$$\n");
        sb.append("636;;cadastrarLogica;;32,1->33,1;;20,67 semanas$$\n");
        sb.append("636;;cadastrarLogica;;33,1->34,1;;21,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;34,1->35,1;;21,50 semanas$$\n");
        sb.append("636;;cadastrarLogica;;35,1->36,1;;22,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;36,1->37,1;;22,33 semanas$$\n");
        sb.append("636;;cadastrarLogica;;37,1->38,1;;22,67 semanas$$\n");
        sb.append("636;;cadastrarLogica;;38,1->39,1;;23,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;39,1->40,1;;23,33 semanas$$\n");
        sb.append("636;;cadastrarLogica;;40,1->41,1;;23,67 semanas$$\n");
        sb.append("636;;cadastrarLogica;;41,1->42,1;;24,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;42,1->43,1;;24,50 semanas$$\n");
        sb.append("636;;cadastrarLogica;;43,1->44,1;;25,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;44,1->45,1;;25,33 semanas$$\n");
        sb.append("636;;cadastrarLogica;;45,1->46,1;;25,67 semanas$$\n");
        sb.append("636;;cadastrarLogica;;46,1->47,1;;26,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;47,1->48,1;;26,50 semanas$$\n");
        sb.append("636;;cadastrarLogica;;48,1->49,1;;27,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;49,1->50,1;;27,33 semanas$$\n");
        sb.append("636;;cadastrarLogica;;50,1->51,1;;27,67 semanas$$\n");
        sb.append("636;;cadastrarLogica;;51,1->52,1;;28,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;52,1->53,1;;28,50 semanas$$\n");
        sb.append("636;;cadastrarLogica;;53,1->54,1;;29,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;54,1->55,1;;29,50 semanas$$\n");
        sb.append("636;;cadastrarLogica;;55,1->56,1;;30,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;56,1->57,1;;30,33 semanas$$\n");
        sb.append("636;;cadastrarLogica;;57,1->58,1;;30,67 semanas$$\n");
        sb.append("636;;cadastrarLogica;;58,1->59,1;;31,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;59,1->60,1;;31,50 semanas$$\n");
        sb.append("636;;cadastrarLogica;;60,1->61,1;;32,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;61,1->62,1;;32,50 semanas$$\n");
        sb.append("636;;cadastrarLogica;;62,1->63,1;;33,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;63,1->64,1;;33,50 semanas$$\n");
        sb.append("636;;cadastrarLogica;;64,1->65,1;;34,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;65,1->66,1;;34,50 semanas$$\n");
        sb.append("636;;cadastrarLogica;;66,1->67,1;;35,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;67,1->68,1;;36,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;68,1->69,1;;36,50 semanas$$\n");
        sb.append("636;;cadastrarLogica;;69,1->70,1;;37,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;70,1->71,1;;38,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;71,1->72,1;;38,50 semanas$$\n");
        sb.append("636;;cadastrarLogica;;72,1->73,1;;39,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;73,1->74,1;;40,00 semanas$$\n");
        sb.append("636;;cadastrarLogica;;74,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Úmero">

        sb.append("637;;cadastrarLogica;;0,0->8,1;;<12,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;8,1->9,1;;12,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;9,1->10,1;;12,50 semanas$$\n");
        sb.append("637;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("637;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("637;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("637;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("637;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("637;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("637;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;20,1->21,1;;16,50 semanas$$\n");
        sb.append("637;;cadastrarLogica;;21,1->22,1;;17,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;22,1->23,1;;17,33 semanas$$\n");
        sb.append("637;;cadastrarLogica;;23,1->24,1;;17,67 semanas$$\n");
        sb.append("637;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("637;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("637;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;28,1->29,1;;19,50 semanas$$\n");
        sb.append("637;;cadastrarLogica;;29,1->30,1;;20,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;30,1->31,1;;20,33 semanas$$\n");
        sb.append("637;;cadastrarLogica;;31,1->32,1;;20,67 semanas$$\n");
        sb.append("637;;cadastrarLogica;;32,1->33,1;;21,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;33,1->34,1;;21,50 semanas$$\n");
        sb.append("637;;cadastrarLogica;;34,1->35,1;;22,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;35,1->36,1;;22,33 semanas$$\n");
        sb.append("637;;cadastrarLogica;;36,1->37,1;;22,67 semanas$$\n");
        sb.append("637;;cadastrarLogica;;37,1->38,1;;23,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;38,1->39,1;;23,50 semanas$$\n");
        sb.append("637;;cadastrarLogica;;39,1->40,1;;24,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;40,1->41,1;;24,50 semanas$$\n");
        sb.append("637;;cadastrarLogica;;41,1->42,1;;25,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;42,1->43,1;;25,50 semanas$$\n");
        sb.append("637;;cadastrarLogica;;43,1->44,1;;26,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;44,1->45,1;;26,50 semanas$$\n");
        sb.append("637;;cadastrarLogica;;45,1->46,1;;27,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;46,1->47,1;;27,50 semanas$$\n");
        sb.append("637;;cadastrarLogica;;47,1->48,1;;28,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;48,1->49,1;;28,50 semanas$$\n");
        sb.append("637;;cadastrarLogica;;49,1->50,1;;29,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;50,1->51,1;;30,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;51,1->52,1;;30,50 semanas$$\n");
        sb.append("637;;cadastrarLogica;;52,1->53,1;;31,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;53,1->54,1;;31,50 semanas$$\n");
        sb.append("637;;cadastrarLogica;;54,1->55,1;;32,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;55,1->56,1;;33,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;56,1->57,1;;33,50 semanas$$\n");
        sb.append("637;;cadastrarLogica;;57,1->58,1;;34,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;58,1->59,1;;35,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;59,1->60,1;;35,50 semanas$$\n");
        sb.append("637;;cadastrarLogica;;60,1->61,1;;36,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;61,1->62,1;;37,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;63,1->64,1;;38,50 semanas$$\n");
        sb.append("637;;cadastrarLogica;;64,1->65,1;;39,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("637;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ulna">

        sb.append("638;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("638;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("638;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;10,1->11,1;;13,33 semanas$$\n");
        sb.append("638;;cadastrarLogica;;11,1->12,1;;13,67 semanas$$\n");
        sb.append("638;;cadastrarLogica;;12,1->13,1;;14,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;13,1->14,1;;14,50 semanas$$\n");
        sb.append("638;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;15,1->16,1;;15,33 semanas$$\n");
        sb.append("638;;cadastrarLogica;;16,1->17,1;;15,67 semanas$$\n");
        sb.append("638;;cadastrarLogica;;17,1->18,1;;16,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;18,1->19,1;;16,33 semanas$$\n");
        sb.append("638;;cadastrarLogica;;19,1->20,1;;16,67 semanas$$\n");
        sb.append("638;;cadastrarLogica;;20,1->21,1;;17,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;21,1->22,1;;17,50 semanas$$\n");
        sb.append("638;;cadastrarLogica;;22,1->23,1;;18,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;23,1->24,1;;18,33 semanas$$\n");
        sb.append("638;;cadastrarLogica;;24,1->25,1;;18,67 semanas$$\n");
        sb.append("638;;cadastrarLogica;;25,1->26,1;;19,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;26,1->27,1;;19,50 semanas$$\n");
        sb.append("638;;cadastrarLogica;;27,1->28,1;;20,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;28,1->29,1;;20,33 semanas$$\n");
        sb.append("638;;cadastrarLogica;;29,1->30,1;;20,67 semanas$$\n");
        sb.append("638;;cadastrarLogica;;30,1->31,1;;21,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;31,1->32,1;;21,50 semanas$$\n");
        sb.append("638;;cadastrarLogica;;32,1->33,1;;22,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;33,1->34,1;;22,50 semanas$$\n");
        sb.append("638;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("638;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;37,1->38,1;;24,50 semanas$$\n");
        sb.append("638;;cadastrarLogica;;38,1->39,1;;25,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;39,1->40,1;;25,50 semanas$$\n");
        sb.append("638;;cadastrarLogica;;40,1->41,1;;26,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;41,1->42,1;;26,50 semanas$$\n");
        sb.append("638;;cadastrarLogica;;42,1->43,1;;27,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;43,1->44,1;;27,50 semanas$$\n");
        sb.append("638;;cadastrarLogica;;44,1->45,1;;28,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;45,1->46,1;;28,50 semanas$$\n");
        sb.append("638;;cadastrarLogica;;46,1->47,1;;29,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;47,1->48,1;;30,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;48,1->49,1;;30,50 semanas$$\n");
        sb.append("638;;cadastrarLogica;;49,1->50,1;;31,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;50,1->51,1;;31,50 semanas$$\n");
        sb.append("638;;cadastrarLogica;;51,1->52,1;;32,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;52,1->53,1;;33,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;53,1->54,1;;33,50 semanas$$\n");
        sb.append("638;;cadastrarLogica;;54,1->55,1;;34,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;55,1->56,1;;35,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;56,1->57,1;;36,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;57,1->58,1;;37,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;58,1->59,1;;38,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;59,1->60,1;;39,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;60,1->61,1;;40,00 semanas$$\n");
        sb.append("638;;cadastrarLogica;;61,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tíbia">

        sb.append("639;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("639;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("639;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;10,1->11,1;;13,50 semanas$$\n");
        sb.append("639;;cadastrarLogica;;11,1->12,1;;14,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;12,1->13,1;;14,33 semanas$$\n");
        sb.append("639;;cadastrarLogica;;13,1->14,1;;14,67 semanas$$\n");
        sb.append("639;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;15,1->16,1;;15,50 semanas$$\n");
        sb.append("639;;cadastrarLogica;;16,1->17,1;;16,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;17,1->18,1;;16,33 semanas$$\n");
        sb.append("639;;cadastrarLogica;;18,1->19,1;;16,67 semanas$$\n");
        sb.append("639;;cadastrarLogica;;19,1->20,1;;17,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;20,1->21,1;;17,50 semanas$$\n");
        sb.append("639;;cadastrarLogica;;21,1->22,1;;18,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;22,1->23,1;;18,33 semanas$$\n");
        sb.append("639;;cadastrarLogica;;23,1->24,1;;18,67 semanas$$\n");
        sb.append("639;;cadastrarLogica;;24,1->25,1;;19,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;25,1->26,1;;19,50 semanas$$\n");
        sb.append("639;;cadastrarLogica;;26,1->27,1;;20,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;27,1->28,1;;20,33 semanas$$\n");
        sb.append("639;;cadastrarLogica;;28,1->29,1;;20,67 semanas$$\n");
        sb.append("639;;cadastrarLogica;;29,1->30,1;;21,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;30,1->31,1;;21,50 semanas$$\n");
        sb.append("639;;cadastrarLogica;;31,1->32,1;;22,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;32,1->33,1;;22,33 semanas$$\n");
        sb.append("639;;cadastrarLogica;;33,1->34,1;;22,67 semanas$$\n");
        sb.append("639;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("639;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;37,1->38,1;;24,33 semanas$$\n");
        sb.append("639;;cadastrarLogica;;38,1->39,1;;24,67 semanas$$\n");
        sb.append("639;;cadastrarLogica;;39,1->40,1;;25,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;40,1->41,1;;25,50 semanas$$\n");
        sb.append("639;;cadastrarLogica;;41,1->42,1;;26,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;42,1->43,1;;26,50 semanas$$\n");
        sb.append("639;;cadastrarLogica;;43,1->44,1;;27,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;44,1->45,1;;27,50 semanas$$\n");
        sb.append("639;;cadastrarLogica;;45,1->46,1;;28,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;46,1->47,1;;28,50 semanas$$\n");
        sb.append("639;;cadastrarLogica;;47,1->48,1;;29,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;48,1->49,1;;29,50 semanas$$\n");
        sb.append("639;;cadastrarLogica;;49,1->50,1;;30,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;50,1->51,1;;30,50 semanas$$\n");
        sb.append("639;;cadastrarLogica;;51,1->52,1;;31,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;52,1->53,1;;31,50 semanas$$\n");
        sb.append("639;;cadastrarLogica;;53,1->54,1;;32,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;54,1->55,1;;33,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;55,1->56,1;;33,50 semanas$$\n");
        sb.append("639;;cadastrarLogica;;56,1->57,1;;34,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;57,1->58,1;;35,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;58,1->59,1;;35,50 semanas$$\n");
        sb.append("639;;cadastrarLogica;;59,1->60,1;;36,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;60,1->61,1;;37,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;61,1->62,1;;37,50 semanas$$\n");
        sb.append("639;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;63,1->64,1;;39,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;64,1->65,1;;39,50 semanas$$\n");
        sb.append("639;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("639;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.A.">

        sb.append("641;;cadastrarLogica;;0,0->39,3;;<11,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;39,3->40,6;;11,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;40,6->41,9;;11,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;41,9->43,2;;11,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;43,2->44,5;;11,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;44,5->45,8;;11,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;45,8->47,0;;11,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;47,0->48,3;;11,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;48,3->49,6;;11,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;49,6->50,9;;11,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;50,9->52,2;;11,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;52,2->53,5;;12,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;53,5->54,8;;12,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;54,8->56,0;;12,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;56,0->57,3;;12,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;57,3->58,6;;12,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;58,6->59,9;;12,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;59,9->61,2;;12,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;61,2->62,4;;12,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;62,4->63,7;;12,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;63,7->65,0;;12,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;65,0->66,3;;13,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;66,3->67,5;;13,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;67,5->68,8;;13,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;68,8->70,1;;13,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;70,1->71,4;;13,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;71,4->72,6;;13,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;72,6->73,9;;13,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;73,9->75,2;;13,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;75,2->76,4;;13,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;76,4->77,7;;13,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;77,7->79,0;;14,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;79,0->80,2;;14,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;80,2->81,4;;14,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;81,4->82,7;;14,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;82,7->84,0;;14,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;84,0->85,2;;14,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;85,2->86,4;;14,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;86,4->87,7;;14,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;87,7->89,0;;14,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;89,0->90,2;;14,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;90,2->91,4;;15,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;91,4->92,7;;15,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;92,7->94,0;;15,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;94,0->95,2;;15,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;95,2->96,4;;15,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;96,4->97,7;;15,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;97,7->99,0;;15,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;99,0->100,2;;15,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;100,2->101,4;;15,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;101,4->102,7;;15,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;102,7->103,9;;16,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;103,9->105,2;;16,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;105,2->106,4;;16,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;106,4->107,6;;16,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;107,6->108,8;;16,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;108,8->110,1;;16,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;110,1->111,3;;16,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;111,3->112,5;;16,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;112,5->113,8;;16,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;113,8->115,0;;16,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;115,0->116,2;;17,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;116,2->117,4;;17,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;117,4->118,7;;17,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;118,7->119,9;;17,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;119,9->121,1;;17,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;121,1->122,3;;17,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;122,3->123,5;;17,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;123,5->124,8;;17,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;124,8->126,0;;17,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;126,0->127,2;;17,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;127,2->128,4;;18,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;128,4->129,6;;18,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;129,6->130,8;;18,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;130,8->132,0;;18,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;132,0->133,2;;18,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;133,2->134,4;;18,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;134,4->135,6;;18,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;135,6->136,8;;18,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;136,8->138,0;;18,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;138,0->139,2;;18,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;139,2->140,4;;19,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;140,4->141,6;;19,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;141,6->142,8;;19,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;142,8->144,0;;19,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;144,0->145,1;;19,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;145,1->146,3;;19,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;146,3->147,5;;19,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;147,5->148,7;;19,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;148,7->149,9;;19,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;149,9->151,1;;19,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;151,1->152,3;;20,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;152,3->153,4;;20,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;153,4->154,6;;20,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;154,6->155,8;;20,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;155,8->157,0;;20,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;157,0->158,1;;20,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;158,1->159,3;;20,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;159,3->160,5;;20,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;160,5->161,6;;20,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;161,6->162,8;;20,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;162,8->164,0;;21,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;164,0->165,1;;21,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;165,1->166,3;;21,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;166,3->167,4;;21,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;167,4->168,6;;21,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;168,6->169,8;;21,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;169,8->170,9;;21,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;170,9->172,1;;21,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;172,1->173,2;;21,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;173,2->174,4;;21,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;174,4->175,5;;22,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;175,5->176,7;;22,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;176,7->177,8;;22,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;177,8->179,0;;22,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;179,0->180,1;;22,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;180,1->181,2;;22,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;181,2->182,4;;22,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;182,4->183,5;;22,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;183,5->184,7;;22,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;184,7->185,8;;22,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;185,8->186,9;;23,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;186,9->188,0;;23,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;188,0->189,2;;23,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;189,2->190,3;;23,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;190,3->191,4;;23,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;191,4->192,5;;23,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;192,5->193,6;;23,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;193,6->194,8;;23,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;194,8->195,9;;23,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;195,9->197,0;;23,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;197,0->198,1;;24,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;198,1->199,2;;24,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;199,2->200,3;;24,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;200,3->201,4;;24,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;201,4->202,5;;24,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;202,5->203,6;;24,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;203,6->204,7;;24,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;204,7->205,8;;24,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;205,8->206,9;;24,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;206,9->208,0;;24,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;208,0->209,1;;25,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;209,1->210,2;;25,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;210,2->211,2;;25,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;211,2->212,3;;25,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;212,3->213,4;;25,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;213,4->214,5;;25,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;214,5->215,6;;25,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;215,6->216,6;;25,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;216,6->217,7;;25,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;217,7->218,8;;25,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;218,8->219,9;;26,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;219,9->220,9;;26,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;220,9->222,0;;26,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;222,0->223,0;;26,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;223,0->224,1;;26,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;224,1->225,2;;26,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;225,2->226,2;;26,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;226,2->227,3;;26,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;227,3->228,3;;26,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;228,3->229,4;;26,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;229,4->230,4;;27,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;230,4->231,5;;27,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;231,5->232,5;;27,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;232,5->233,6;;27,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;233,6->234,6;;27,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;234,6->235,6;;27,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;235,6->236,7;;27,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;236,7->237,7;;27,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;237,7->238,8;;27,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;238,8->239,8;;27,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;239,8->240,8;;28,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;240,8->241,8;;28,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;241,8->242,8;;28,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;242,8->243,8;;28,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;243,8->244,9;;28,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;244,9->245,9;;28,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;245,9->246,9;;28,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;246,9->247,9;;28,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;247,9->248,9;;28,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;248,9->249,9;;28,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;249,9->250,9;;29,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;250,9->251,9;;29,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;251,9->252,9;;29,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;252,9->253,9;;29,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;253,9->254,9;;29,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;254,9->255,8;;29,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;255,8->256,8;;29,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;256,8->257,8;;29,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;257,8->258,8;;29,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;258,8->259,8;;29,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;259,8->260,8;;30,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;260,8->261,7;;30,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;261,7->262,7;;30,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;262,7->263,7;;30,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;263,7->264,6;;30,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;264,6->265,6;;30,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;265,6->266,6;;30,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;266,6->267,6;;30,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;267,6->268,5;;30,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;268,5->269,5;;30,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;269,5->270,4;;31,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;270,4->271,4;;31,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;271,4->272,4;;31,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;272,4->273,3;;31,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;273,3->274,2;;31,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;274,2->275,2;;31,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;275,2->276,2;;31,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;276,2->277,1;;31,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;277,1->278,0;;31,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;278,0->279,0;;31,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;279,0->279,9;;32,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;279,9->280,8;;32,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;280,8->281,7;;32,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;281,7->282,6;;32,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;282,6->283,6;;32,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;283,6->284,5;;32,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;284,5->285,4;;32,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;285,4->286,3;;32,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;286,3->287,2;;32,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;287,2->288,1;;32,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;288,1->289,0;;33,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;289,0->289,9;;33,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;289,9->290,8;;33,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;290,8->291,7;;33,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;291,7->292,6;;33,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;292,6->293,5;;33,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;293,5->294,4;;33,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;294,4->295,3;;33,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;295,3->296,2;;33,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;296,2->297,1;;33,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;297,1->298,0;;34,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;298,0->298,8;;34,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;298,8->299,7;;34,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;299,7->300,5;;34,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;300,5->301,4;;34,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;301,4->302,3;;34,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;302,3->303,1;;34,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;303,1->304,0;;34,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;304,0->304,8;;34,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;304,8->305,7;;34,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;305,7->306,5;;35,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;306,5->307,4;;35,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;307,4->308,2;;35,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;308,2->309,1;;35,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;309,1->309,9;;35,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;309,9->310,7;;35,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;310,7->311,6;;35,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;311,6->312,4;;35,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;312,4->313,3;;35,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;313,3->314,1;;35,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;314,1->314,9;;36,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;314,9->315,7;;36,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;315,7->316,5;;36,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;316,5->317,3;;36,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;317,3->318,1;;36,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;318,1->318,9;;36,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;318,9->319,7;;36,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;319,7->320,5;;36,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;320,5->321,3;;36,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;321,3->322,1;;36,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;322,1->322,9;;37,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;322,9->323,7;;37,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;323,7->324,4;;37,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;324,4->325,2;;37,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;325,2->326,0;;37,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;326,0->326,8;;37,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;326,8->327,6;;37,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;327,6->328,3;;37,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;328,3->329,1;;37,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;329,1->329,9;;37,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;329,9->330,6;;38,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;330,6->331,4;;38,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;331,4->332,2;;38,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;332,2->332,9;;38,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;332,9->333,6;;38,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;333,6->334,4;;38,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;334,4->335,2;;38,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;335,2->335,9;;38,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;335,9->336,6;;38,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;336,6->337,4;;38,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;337,4->338,1;;39,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;338,1->338,8;;39,10 semanas$$\n");
        sb.append("641;;cadastrarLogica;;338,8->339,5;;39,20 semanas$$\n");
        sb.append("641;;cadastrarLogica;;339,5->340,2;;39,30 semanas$$\n");
        sb.append("641;;cadastrarLogica;;340,2->341,0;;39,40 semanas$$\n");
        sb.append("641;;cadastrarLogica;;341,0->341,7;;39,50 semanas$$\n");
        sb.append("641;;cadastrarLogica;;341,7->342,4;;39,60 semanas$$\n");
        sb.append("641;;cadastrarLogica;;342,4->343,1;;39,70 semanas$$\n");
        sb.append("641;;cadastrarLogica;;343,1->343,8;;39,80 semanas$$\n");
        sb.append("641;;cadastrarLogica;;343,8->344,5;;39,90 semanas$$\n");
        sb.append("641;;cadastrarLogica;;344,5->346,1;;40,00 semanas$$\n");
        sb.append("641;;cadastrarLogica;;346,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.C.">

        sb.append("642;;cadastrarLogica;;0,0->53,2;;<11,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;53,2->54,6;;11,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;54,6->56,1;;11,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;56,1->57,5;;11,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;57,5->58,9;;11,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;58,9->60,4;;11,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;60,4->61,8;;11,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;61,8->63,2;;11,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;63,2->64,6;;11,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;64,6->66,1;;11,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;66,1->67,5;;11,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;67,5->68,9;;12,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;68,9->70,4;;12,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;70,4->71,8;;12,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;71,8->73,2;;12,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;73,2->74,6;;12,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;74,6->76,1;;12,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;76,1->77,5;;12,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;77,5->78,9;;12,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;78,9->80,4;;12,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;80,4->81,8;;12,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;81,8->83,2;;13,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;83,2->84,5;;13,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;84,5->85,9;;13,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;85,9->87,3;;13,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;87,3->88,6;;13,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;88,6->90,0;;13,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;90,0->91,4;;13,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;91,4->92,8;;13,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;92,8->94,1;;13,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;94,1->95,5;;13,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;95,5->96,9;;14,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;96,9->98,2;;14,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;98,2->99,6;;14,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;99,6->101,0;;14,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;101,0->102,4;;14,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;102,4->103,7;;14,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;103,7->105,1;;14,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;105,1->106,5;;14,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;106,5->107,8;;14,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;107,8->109,2;;14,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;109,2->110,6;;15,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;110,6->111,9;;15,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;111,9->113,2;;15,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;113,2->114,6;;15,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;114,6->116,0;;15,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;116,0->117,3;;15,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;117,3->118,6;;15,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;118,6->120,0;;15,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;120,0->121,4;;15,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;121,4->122,7;;15,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;122,7->124,0;;16,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;124,0->125,3;;16,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;125,3->126,6;;16,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;126,6->127,9;;16,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;127,9->129,2;;16,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;129,2->130,6;;16,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;130,6->131,9;;16,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;131,9->133,2;;16,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;133,2->134,5;;16,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;134,5->135,8;;16,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;135,8->137,1;;17,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;137,1->138,4;;17,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;138,4->139,7;;17,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;139,7->141,0;;17,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;141,0->142,2;;17,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;142,2->143,5;;17,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;143,5->144,8;;17,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;144,8->146,1;;17,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;146,1->147,4;;17,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;147,4->148,7;;17,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;148,7->150,0;;18,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;150,0->151,2;;18,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;151,2->152,5;;18,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;152,5->153,7;;18,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;153,7->155,0;;18,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;155,0->156,3;;18,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;156,3->157,5;;18,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;157,5->158,8;;18,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;158,8->160,0;;18,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;160,0->161,3;;18,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;161,3->162,5;;19,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;162,5->163,7;;19,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;163,7->165,0;;19,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;165,0->166,2;;19,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;166,2->167,4;;19,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;167,4->168,6;;19,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;168,6->169,8;;19,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;169,8->171,1;;19,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;171,1->172,3;;19,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;172,3->173,5;;19,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;173,5->174,7;;20,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;174,7->175,9;;20,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;175,9->177,1;;20,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;177,1->178,3;;20,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;178,3->179,5;;20,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;179,5->180,7;;20,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;180,7->181,9;;20,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;181,9->183,1;;20,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;183,1->184,3;;20,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;184,3->185,5;;20,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;185,5->186,6;;21,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;186,6->187,8;;21,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;187,8->189,0;;21,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;189,0->190,1;;21,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;190,1->191,2;;21,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;191,2->192,4;;21,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;192,4->193,6;;21,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;193,6->194,7;;21,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;194,7->195,8;;21,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;195,8->197,0;;21,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;197,0->198,1;;22,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;198,1->199,3;;22,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;199,3->200,4;;22,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;200,4->201,5;;22,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;201,5->202,6;;22,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;202,6->203,8;;22,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;203,8->204,9;;22,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;204,9->206,0;;22,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;206,0->207,2;;22,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;207,2->208,3;;22,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;208,3->209,4;;23,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;209,4->210,5;;23,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;210,5->211,5;;23,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;211,5->212,6;;23,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;212,6->213,7;;23,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;213,7->214,8;;23,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;214,8->215,9;;23,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;215,9->216,9;;23,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;216,9->218,0;;23,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;218,0->219,1;;23,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;219,1->220,1;;24,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;220,1->221,2;;24,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;221,2->222,2;;24,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;222,2->223,3;;24,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;223,3->224,3;;24,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;224,3->225,3;;24,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;225,3->226,4;;24,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;226,4->227,4;;24,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;227,4->228,5;;24,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;228,5->229,5;;24,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;229,5->230,5;;25,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;230,5->231,5;;25,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;231,5->232,5;;25,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;232,5->233,5;;25,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;233,5->234,5;;25,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;234,5->235,5;;25,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;235,5->236,5;;25,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;236,5->237,5;;25,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;237,5->238,5;;25,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;238,5->239,5;;25,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;239,5->240,5;;26,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;240,5->241,4;;26,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;241,4->242,4;;26,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;242,4->243,3;;26,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;243,3->244,3;;26,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;244,3->245,3;;26,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;245,3->246,2;;26,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;246,2->247,2;;26,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;247,2->248,1;;26,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;248,1->249,1;;26,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;249,1->250,0;;27,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;250,0->250,9;;27,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;250,9->251,9;;27,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;251,9->252,8;;27,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;252,8->253,7;;27,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;253,7->254,6;;27,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;254,6->255,5;;27,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;255,5->256,5;;27,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;256,5->257,4;;27,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;257,4->258,3;;27,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;258,3->259,2;;28,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;259,2->260,0;;28,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;260,0->260,9;;28,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;260,9->261,7;;28,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;261,7->262,6;;28,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;262,6->263,5;;28,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;263,5->264,3;;28,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;264,3->265,2;;28,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;265,2->266,0;;28,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;266,0->266,9;;28,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;266,9->267,7;;29,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;267,7->268,5;;29,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;268,5->269,4;;29,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;269,4->270,2;;29,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;270,2->271,0;;29,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;271,0->271,8;;29,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;271,8->272,6;;29,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;272,6->273,5;;29,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;273,5->274,3;;29,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;274,3->275,1;;29,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;275,1->275,9;;30,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;275,9->276,6;;30,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;276,6->277,4;;30,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;277,4->278,2;;30,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;278,2->279,0;;30,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;279,0->279,7;;30,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;279,7->280,5;;30,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;280,5->281,3;;30,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;281,3->282,0;;30,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;282,0->282,8;;30,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;282,8->283,5;;31,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;283,5->284,2;;31,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;284,2->284,9;;31,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;284,9->285,6;;31,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;285,6->286,4;;31,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;286,4->287,1;;31,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;287,1->287,8;;31,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;287,8->288,5;;31,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;288,5->289,2;;31,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;289,2->289,9;;31,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;289,9->290,6;;32,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;290,6->291,2;;32,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;291,2->291,9;;32,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;291,9->292,6;;32,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;292,6->293,2;;32,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;293,2->293,9;;32,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;293,9->294,6;;32,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;294,6->295,3;;32,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;295,3->295,9;;32,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;295,9->296,6;;32,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;296,6->297,2;;33,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;297,2->297,8;;33,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;297,8->298,4;;33,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;298,4->299,0;;33,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;299,0->299,6;;33,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;299,6->300,3;;33,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;300,3->300,9;;33,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;300,9->301,5;;33,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;301,5->302,1;;33,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;302,1->302,7;;33,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;302,7->303,2;;34,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;303,2->303,8;;34,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;303,8->304,3;;34,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;304,3->304,9;;34,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;304,9->305,4;;34,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;305,4->306,0;;34,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;306,0->306,6;;34,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;306,6->307,1;;34,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;307,1->307,6;;34,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;307,6->308,2;;34,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;308,2->308,7;;35,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;308,7->309,2;;35,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;309,2->309,7;;35,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;309,7->310,2;;35,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;310,2->310,6;;35,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;310,6->311,1;;35,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;311,1->311,6;;35,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;311,6->312,1;;35,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;312,1->312,6;;35,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;312,6->313,1;;35,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;313,1->313,5;;36,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;313,5->314,0;;36,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;314,0->314,4;;36,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;314,4->314,9;;36,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;314,9->315,3;;36,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;315,3->315,7;;36,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;315,7->316,2;;36,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;316,2->316,6;;36,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;316,6->317,1;;36,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;317,1->317,5;;36,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;317,5->317,9;;37,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;317,9->318,2;;37,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;318,2->318,6;;37,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;318,6->319,0;;37,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;319,0->319,4;;37,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;319,4->319,7;;37,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;319,7->320,1;;37,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;320,1->320,5;;37,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;320,5->320,8;;37,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;320,8->321,2;;37,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;321,2->321,5;;38,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;321,5->321,8;;38,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;321,8->322,1;;38,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;322,1->322,4;;38,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;322,4->322,8;;38,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;322,8->323,1;;38,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;323,1->323,4;;38,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;323,4->323,7;;38,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;323,7->324,0;;38,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;324,0->324,3;;38,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;324,3->324,5;;39,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;324,5->324,8;;39,10 semanas$$\n");
        sb.append("642;;cadastrarLogica;;324,8->325,0;;39,20 semanas$$\n");
        sb.append("642;;cadastrarLogica;;325,0->325,3;;39,30 semanas$$\n");
        sb.append("642;;cadastrarLogica;;325,3->325,5;;39,40 semanas$$\n");
        sb.append("642;;cadastrarLogica;;325,5->325,7;;39,50 semanas$$\n");
        sb.append("642;;cadastrarLogica;;325,7->326,0;;39,60 semanas$$\n");
        sb.append("642;;cadastrarLogica;;326,0->326,2;;39,70 semanas$$\n");
        sb.append("642;;cadastrarLogica;;326,2->326,5;;39,80 semanas$$\n");
        sb.append("642;;cadastrarLogica;;326,5->326,7;;39,90 semanas$$\n");
        sb.append("642;;cadastrarLogica;;326,7->328,1;;40,00 semanas$$\n");
        sb.append("642;;cadastrarLogica;;328,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("640;;cadastrarLogica;;0,0->15,7;;<11,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;15,7->16,0;;11,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;16,0->16,4;;11,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;16,4->16,7;;11,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;16,7->17,1;;11,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;17,1->17,4;;11,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;17,4->17,7;;11,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;17,7->18,1;;11,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;18,1->18,4;;11,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;18,4->18,8;;11,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;18,8->19,1;;11,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;19,1->19,4;;12,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;19,4->19,7;;12,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;19,7->20,1;;12,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;20,1->20,4;;12,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;20,4->20,7;;12,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;20,7->21,0;;12,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;21,0->21,3;;12,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;21,3->21,7;;12,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;21,7->22,0;;12,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;22,0->22,3;;12,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;22,3->22,8;;13,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;22,8->23,2;;13,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;23,2->23,7;;13,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;23,7->24,2;;13,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;24,2->24,6;;13,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;24,6->25,1;;13,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;25,1->25,6;;13,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;25,6->26,1;;13,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;26,1->26,5;;13,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;26,5->27,0;;13,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;27,0->27,4;;14,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;27,4->27,7;;14,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;27,7->28,1;;14,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;28,1->28,5;;14,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;28,5->28,8;;14,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;28,8->29,2;;14,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;29,2->29,6;;14,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;29,6->30,0;;14,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;30,0->30,3;;14,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;30,3->30,7;;14,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;30,7->31,1;;15,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;31,1->31,4;;15,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;31,4->31,8;;15,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;31,8->32,1;;15,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;32,1->32,5;;15,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;32,5->32,9;;15,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;32,9->33,2;;15,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;33,2->33,6;;15,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;33,6->33,9;;15,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;33,9->34,3;;15,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;34,3->34,7;;16,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;34,7->35,0;;16,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;35,0->35,4;;16,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;35,4->35,7;;16,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;35,7->36,1;;16,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;36,1->36,5;;16,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;36,5->36,8;;16,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;36,8->37,2;;16,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;37,2->37,5;;16,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;37,5->37,9;;16,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;37,9->38,2;;17,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;38,2->38,6;;17,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;38,6->38,9;;17,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;38,9->39,3;;17,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;39,3->39,6;;17,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;39,6->39,9;;17,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;39,9->40,3;;17,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;40,3->40,6;;17,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;40,6->41,0;;17,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;41,0->41,3;;17,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;41,3->41,6;;18,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;41,6->42,0;;18,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;42,0->42,3;;18,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;42,3->42,7;;18,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;42,7->43,0;;18,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;43,0->43,3;;18,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;43,3->43,7;;18,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;43,7->44,0;;18,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;44,0->44,4;;18,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;44,4->44,7;;18,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;44,7->45,0;;19,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;45,0->45,4;;19,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;45,4->45,7;;19,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;45,7->46,1;;19,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;46,1->46,4;;19,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;46,4->46,7;;19,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;46,7->47,1;;19,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;47,1->47,4;;19,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;47,4->47,8;;19,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;47,8->48,1;;19,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;48,1->48,4;;20,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;48,4->48,7;;20,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;48,7->49,1;;20,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;49,1->49,4;;20,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;49,4->49,7;;20,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;49,7->50,0;;20,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;50,0->50,3;;20,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;50,3->50,7;;20,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;50,7->51,0;;20,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;51,0->51,3;;20,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;51,3->51,6;;21,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;51,6->51,9;;21,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;51,9->52,3;;21,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;52,3->52,6;;21,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;52,6->52,9;;21,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;52,9->53,2;;21,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;53,2->53,5;;21,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;53,5->53,9;;21,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;53,9->54,2;;21,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;54,2->54,5;;21,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;54,5->54,8;;22,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;54,8->55,1;;22,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;55,1->55,4;;22,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;55,4->55,7;;22,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;55,7->56,0;;22,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;56,0->56,3;;22,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;56,3->56,6;;22,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;56,6->56,9;;22,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;56,9->57,2;;22,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;57,2->57,5;;22,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;57,5->57,8;;23,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;57,8->58,1;;23,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;58,1->58,4;;23,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;58,4->58,7;;23,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;58,7->59,0;;23,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;59,0->59,3;;23,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;59,3->59,6;;23,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;59,6->59,9;;23,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;59,9->60,2;;23,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;60,2->60,5;;23,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;60,5->60,8;;24,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;60,8->61,1;;24,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;61,1->61,4;;24,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;61,4->61,7;;24,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;61,7->62,0;;24,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;62,0->62,2;;24,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;62,2->62,5;;24,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;62,5->62,8;;24,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;62,8->63,1;;24,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;63,1->63,4;;24,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;63,4->63,7;;25,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;63,7->64,0;;25,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;64,0->64,2;;25,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;64,2->64,5;;25,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;64,5->64,8;;25,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;64,8->65,1;;25,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;65,1->65,4;;25,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;65,4->65,6;;25,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;65,6->65,9;;25,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;65,9->66,2;;25,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;66,2->66,5;;26,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;66,5->66,7;;26,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;66,7->67,0;;26,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;67,0->67,3;;26,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;67,3->67,6;;26,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;67,6->67,8;;26,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;67,8->68,1;;26,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;68,1->68,4;;26,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;68,4->68,6;;26,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;68,6->68,9;;26,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;68,9->69,2;;27,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;69,2->69,4;;27,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;69,4->69,6;;27,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;69,6->69,9;;27,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;69,9->70,2;;27,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;70,2->70,4;;27,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;70,4->70,6;;27,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;70,6->70,9;;27,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;70,9->71,2;;27,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;71,2->71,4;;27,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;71,4->71,6;;28,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;71,6->71,9;;28,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;71,9->72,2;;28,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;72,2->72,4;;28,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;72,4->72,6;;28,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;72,6->72,9;;28,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;72,9->73,2;;28,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;73,2->73,4;;28,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;73,4->73,6;;28,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;73,6->73,9;;28,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;73,9->74,1;;29,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;74,1->74,4;;29,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;74,4->74,6;;29,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;74,6->74,8;;29,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;74,8->75,1;;29,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;75,1->75,3;;29,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;75,3->75,5;;29,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;75,5->75,7;;29,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;75,7->76,0;;29,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;76,0->76,2;;29,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;76,2->76,4;;30,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;76,4->76,7;;30,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;76,7->76,9;;30,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;76,9->77,1;;30,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;77,1->77,4;;30,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;77,4->77,6;;30,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;77,6->77,8;;30,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;77,8->78,0;;30,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;78,0->78,3;;30,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;78,3->78,5;;30,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;78,5->78,7;;31,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;78,7->78,9;;31,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;78,9->79,1;;31,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;79,1->79,3;;31,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;79,3->79,6;;31,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;79,6->79,8;;31,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;79,8->80,0;;31,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;80,0->80,2;;31,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;80,2->80,4;;31,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;80,4->80,6;;31,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;80,6->80,8;;32,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;80,8->81,0;;32,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;81,0->81,2;;32,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;81,2->81,4;;32,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;81,4->81,6;;32,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;81,6->81,7;;32,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;81,7->81,9;;32,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;81,9->82,1;;32,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;82,1->82,3;;32,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;82,3->82,5;;32,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;82,5->82,7;;33,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;82,7->82,9;;33,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;82,9->83,1;;33,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;83,1->83,3;;33,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;83,3->83,4;;33,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;83,4->83,6;;33,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;83,6->83,8;;33,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;83,8->84,0;;33,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;84,0->84,2;;33,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;84,2->84,4;;33,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;84,4->84,6;;34,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;84,6->84,7;;34,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;84,7->84,9;;34,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;84,9->85,1;;34,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;85,1->85,2;;34,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;85,2->85,4;;34,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;85,4->85,6;;34,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;85,6->85,8;;34,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;85,8->85,9;;34,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;85,9->86,1;;34,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;86,1->86,2;;35,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;86,2->86,4;;35,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;86,4->86,6;;35,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;86,6->86,7;;35,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;86,7->86,8;;35,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;86,8->87,0;;35,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;87,0->87,1;;35,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;87,1->87,3;;35,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;87,3->87,4;;35,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;87,4->87,6;;35,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;87,6->87,8;;36,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;87,8->87,9;;36,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;87,9->88,0;;36,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;88,0->88,2;;36,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;88,2->88,4;;36,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;88,4->88,5;;36,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;88,5->88,6;;36,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;88,6->88,8;;36,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;88,8->88,9;;36,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;88,9->89,1;;36,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;89,1->89,2;;37,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;89,2->89,3;;37,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;89,3->89,5;;37,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;89,5->89,6;;37,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;89,6->89,7;;37,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;89,7->89,8;;37,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;89,8->89,9;;37,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;89,9->90,1;;37,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;90,1->90,2;;37,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;90,2->90,3;;37,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;90,3->90,4;;38,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;90,4->90,5;;38,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;90,5->90,6;;38,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;90,6->90,7;;38,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;90,7->90,8;;38,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;90,8->91,0;;38,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;91,0->91,1;;38,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;91,1->91,2;;38,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;91,2->91,3;;38,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;91,3->91,4;;38,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;91,4->91,5;;39,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;91,5->91,6;;39,10 semanas$$\n");
        sb.append("640;;cadastrarLogica;;91,6->91,7;;39,20 semanas$$\n");
        sb.append("640;;cadastrarLogica;;91,7->91,8;;39,30 semanas$$\n");
        sb.append("640;;cadastrarLogica;;91,8->91,9;;39,40 semanas$$\n");
        sb.append("640;;cadastrarLogica;;91,9->92,0;;39,50 semanas$$\n");
        sb.append("640;;cadastrarLogica;;92,0->92,1;;39,60 semanas$$\n");
        sb.append("640;;cadastrarLogica;;92,1->92,2;;39,70 semanas$$\n");
        sb.append("640;;cadastrarLogica;;92,2->92,3;;39,80 semanas$$\n");
        sb.append("640;;cadastrarLogica;;92,3->92,4;;39,90 semanas$$\n");
        sb.append("640;;cadastrarLogica;;92,4->93,1;;40,00 semanas$$\n");
        sb.append("640;;cadastrarLogica;;93,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

    }

}
