/*
 * M_Obstetricos.java
 *
 * Created on 15/06/2012, 09:48:58
 */
package com.ic.projects.laudoecia.mdl;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import static com.ic.projects.laudoecia.model.laudo.CampoSimples.identificador;
import com.ic.projects.laudoecia.model.laudo.*;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class M_Obstetricos extends Model
{

    public static void main (String[] args) throws Exception
    {
        obstetrico1Trimestre();
        obstetrico14Semanas();
//        formatarStrMdl();
    }

    static void obstetrico1Trimestre() throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento">

        sb.append("\n0;;Topico;;Equipamento$$\n");
        sb.append("\n1;;Linha$$\n");
        sb.append("2;;Enumeracao;;Exame realizado em modo bidimensional "
                + "com equipamento dinâmico ");
        sb.append(identificador).append(" multifrequencial.;;true$$\n");
        sb.append("3;;CampoTexto;;\n$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados da gestação">

        sb.append("\n4;;Topico;;Dados da gestação$$\n");

        sb.append("\n5;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("6;;Label;;").append("Gestação gemelar$$\n");
        sb.append("7;;Label;;").append("Gestação múltipla com $$\n");
        sb.append("8;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL + ";;1$$\n");
        sb.append("9;;CampoRpn;;C1;;" + identificador + ";;0$$\n");
        sb.append("10;;Label;;").append(" embriões / fetos$$\n");
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
        sb.append("26;;Linha$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Bexiga">

        sb.append("\n27;;Topico;;Bexiga$$\n");

        sb.append("\n28;;Linha$$\n");
        sb.append("29;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");

        sb.append("\n30;;Linha$$\n");
        sb.append("31;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vagina">

        sb.append("\n32;;Topico;;Vagina$$\n");
        sb.append("\n33;;Linha$$\n");
        //dados vagina
        sb.append("34;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        //descrição geral vagina
        sb.append("\n35;;Linha$$\n");
        sb.append("36;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Útero">

        sb.append("\n37;;Topico;;Útero$$\n");
        sb.append("\n38;;Linha$$\n");
        //situação
        sb.append("39;;Enumeracao;;").append("Em ").append(CampoSimples.identificador).append(";;true$$\n");
        //posição
        sb.append("40;;Enumeracao;;").append(", ").append(CampoSimples.identificador).append("$$\n");
        //contornos
        sb.append("41;;Enumeracao;;").append(", de contornos ").append(CampoSimples.identificador).append("$$\n");
        //limites
        sb.append("42;;Enumeracao;;").append(" e limites ").append(CampoSimples.identificador).append(".$$\n");

        //long
        sb.append("\n43;;Linha$$\n");
        sb.append("44;;CampoDouble;;Medidas: Long.: " + identificador + ";;2$$\n");
        //anterior pos
        sb.append("45;;CampoDouble;; x Ant. Post.: " + identificador + ";;2$$\n");
        //transversal
        sb.append("46;;CampoDouble;; x Transv.: " + identificador + " cm;;2$$\n");
        sb.append("47;;CampoRpn;;C1 C2 C3 @").append(StaticInfo.FATOR_VOL_DIVERSOS).append("@ * * *;;");
        sb.append(", Volume = " + identificador + " cm³.;;3$$\n");

        //textura miometrio
        sb.append("\n48;;Linha$$\n");
        sb.append("49;;Enumeracao;;").append("Miométrio de textura acústica ").append(CampoSimples.identificador).append(".$$\n");
        //Canal endocervical
        sb.append("\n50;;Linha$$\n");
        sb.append("51;;Enumeracao;;").append("Canal endocervical: ").append(CampoSimples.identificador).append(".;;true$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto único">

        sb.append("\n52;;Topico;;Embrião / Feto$$\n");

        // Saco gestacional
        sb.append("\n53;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        // Situação
        sb.append("54;;Enumeracao;;").append("Presença de saco gestacional ").append(CampoSimples.identificador).append(";;true$$\n");
        // Posição
        sb.append("55;;Enumeracao;;").append(" com forma ").append(CampoSimples.identificador).append("$$\n");
        // Medidas
        sb.append("56;;CampoDouble;;, medindo Long.: " + identificador + ";;2$$\n");
        sb.append("57;;CampoDouble;; x Ant. Post.: " + identificador + ";;2$$\n");
        sb.append("58;;CampoDouble;; x Transv.: " + identificador + " cm;;2$$\n");

        // Vesícula
        sb.append("\n59;;Linha$$\n");
        sb.append("60;;Enumeracao;;").append("Vesícula vitelínica ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Membrana
        sb.append("\n61;;Linha$$\n");
        sb.append("62;;Enumeracao;;").append("Membrana amniótica ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Presença
        sb.append("\n63;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        // Presença
        sb.append("64;;Enumeracao;;").append("Embrião / Feto ").append(CampoSimples.identificador).append(";;true$$\n");
        // CCN
        sb.append("65;;CampoDouble;;, CCN medindo ").append(CampoSimples.identificador).append(" mm;;2$$\n");
        // Movimentos
        sb.append("66;;Enumeracao;;").append(", com movimentos ").append(CampoSimples.identificador).append(";;true$$\n");

        // Batimentos cardíacos
        sb.append("\n67;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        // Situação
        sb.append("68;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Nº de bpm
        sb.append("69;;CampoInteiro;; de ").append(CampoSimples.identificador).append(" bpm;;3$$\n");

        // Translucência nucal
        sb.append("\n70;;Linha$$\n");
        sb.append("71;;CampoDouble;;").append("Translucência nucal de ").append(CampoSimples.identificador).append(" mm.;;2$$\n");

        // Descrição
        sb.append("\n72;;Linha$$\n");
        sb.append("73;;CampoTexto;;\n$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 1">

        sb.append("\n74;;Topico;;Embrião / Feto 1$$\n");
        sb.append("\n75;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        //situação
        sb.append("76;;Enumeracao;;").append("Presença de saco gestacional ").append(CampoSimples.identificador).append(";;true$$\n");
        //posição
        sb.append("77;;Enumeracao;;").append(" com forma ").append(CampoSimples.identificador).append("$$\n");
        //long
        sb.append("78;;CampoDouble;;, medindo Long.: " + identificador + ";;2$$\n");
        //anterior pos
        sb.append("79;;CampoDouble;; x Ant. Post.: " + identificador + ";;2$$\n");
        //transversal
        sb.append("80;;CampoDouble;; x Transv.: " + identificador + " cm;;2$$\n");

        //vesícula
        sb.append("\n81;;Linha$$\n");
        sb.append("82;;Enumeracao;;").append("Vesícula vitelínica ").append(CampoSimples.identificador).append(".;;true$$\n");
        //membrana
        sb.append("\n83;;Linha$$\n");
        sb.append("84;;Enumeracao;;").append("Membrana amniótica ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Presença
        sb.append("\n85;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        //presença
        sb.append("86;;Enumeracao;;").append("Embrião / Feto ").append(CampoSimples.identificador).append(";;true$$\n");
        // CCN
        sb.append("87;;CampoDouble;;, CCN medindo ").append(CampoSimples.identificador).append(" mm;;2$$\n");
        //movimentos
        sb.append("88;;Enumeracao;;").append(", com movimentos ").append(CampoSimples.identificador).append(";;true$$\n");

        // Batimentos cardíacos
        sb.append("\n89;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        // Situação
        sb.append("90;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Nº de bpm
        sb.append("91;;CampoInteiro;; de ").append(CampoSimples.identificador).append(" bpm;;3$$\n");

        //translucência
        sb.append("\n92;;Linha$$\n");
        sb.append("93;;CampoDouble;;").append("Translucência nucal de ").append(CampoSimples.identificador).append(" mm.;;2$$\n");

        sb.append("\n94;;Linha$$\n");
        sb.append("95;;CampoTexto;;\n$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 2">

         sb.append("\n96;;Topico;;Embrião / Feto 2$$\n");
        sb.append("\n97;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        //situação
        sb.append("98;;Enumeracao;;").append("Presença de saco gestacional ").append(CampoSimples.identificador).append(";;true$$\n");
        //posição
        sb.append("99;;Enumeracao;;").append(" com forma ").append(CampoSimples.identificador).append("$$\n");
        //long
        sb.append("100;;CampoDouble;;, medindo Long.: " + identificador + ";;2$$\n");
        //anterior pos
        sb.append("101;;CampoDouble;; x Ant. Post.: " + identificador + ";;2$$\n");
        //transversal
        sb.append("102;;CampoDouble;; x Transv.: " + identificador + " cm;;2$$\n");

        //vesícula
        sb.append("\n103;;Linha$$\n");
        sb.append("104;;Enumeracao;;").append("Vesícula vitelínica ").append(CampoSimples.identificador).append(".;;true$$\n");

        //membrana
        sb.append("\n105;;Linha$$\n");
        sb.append("106;;Enumeracao;;").append("Membrana amniótica ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Presença
        sb.append("\n107;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("108;;Enumeracao;;").append("Embrião / Feto ").append(CampoSimples.identificador).append(";;true$$\n");
        // CCN
        sb.append("109;;CampoDouble;;, CCN medindo ").append(CampoSimples.identificador).append(" mm;;2$$\n");
        // Movimentos
        sb.append("110;;Enumeracao;;").append(", com movimentos ").append(CampoSimples.identificador).append(";;true$$\n");

        // Batimentos cardíacos
        sb.append("\n111;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        // Situação
        sb.append("112;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Nº de bpm
        sb.append("113;;CampoInteiro;; de ").append(CampoSimples.identificador).append(" bpm;;3$$\n");

        //translucência
        sb.append("\n114;;Linha$$\n");
        sb.append("115;;CampoDouble;;").append("Translucência nucal de ").append(CampoSimples.identificador).append(" mm.;;2$$\n");
        sb.append("\n116;;Linha$$\n");
        sb.append("117;;CampoTexto;;\n$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 3">

        sb.append("\n118;;Topico;;Embrião / Feto 3$$\n");
        sb.append("\n119;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        //situação
        sb.append("120;;Enumeracao;;").append("Presença de saco gestacional ").append(CampoSimples.identificador).append(";;true$$\n");
        //posição
        sb.append("121;;Enumeracao;;").append(" com forma ").append(CampoSimples.identificador).append("$$\n");
        //long
        sb.append("122;;CampoDouble;;, medindo Long.: " + identificador + ";;2$$\n");
        //anterior pos
        sb.append("123;;CampoDouble;; x Ant. Post.: " + identificador + ";;2$$\n");
        //transversal
        sb.append("124;;CampoDouble;; x Transv.: " + identificador + " cm;;2$$\n");

        //vesícula
        sb.append("\n125;;Linha$$\n");
        sb.append("126;;Enumeracao;;").append("Vesícula vitelínica ").append(CampoSimples.identificador).append(".;;true$$\n");
        //membrana
        sb.append("\n127;;Linha$$\n");
        sb.append("128;;Enumeracao;;").append("Membrana amniótica ").append(CampoSimples.identificador).append(".;;true$$\n");

        sb.append("\n129;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        //presença
        sb.append("130;;Enumeracao;;").append("Embrião / Feto ").append(CampoSimples.identificador).append(";;true$$\n");
        // CCN
        sb.append("131;;CampoDouble;;, CCN medindo ").append(CampoSimples.identificador).append(" mm;;2$$\n");
        //movimentos
        sb.append("132;;Enumeracao;;").append(", com movimentos ").append(CampoSimples.identificador).append(";;true$$\n");

        // Batimentos cardíacos
        sb.append("\n133;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        // Situação
        sb.append("134;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Nº de bpm
        sb.append("135;;CampoInteiro;; de ").append(CampoSimples.identificador).append(" bpm;;3$$\n");

        //translucência
        sb.append("\n136;;Linha$$\n");
        sb.append("137;;CampoDouble;;").append("Translucência nucal de ").append(CampoSimples.identificador).append(" mm.;;2$$\n");
        sb.append("\n138;;Linha$$\n");
        sb.append("139;;CampoTexto;;\n$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 4">

        sb.append("\n140;;Topico;;Embrião / Feto 4$$\n");
        sb.append("\n141;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        //situação
        sb.append("142;;Enumeracao;;").append("Presença de saco gestacional ").append(CampoSimples.identificador).append(";;true$$\n");
        //posição
        sb.append("143;;Enumeracao;;").append(" com forma ").append(CampoSimples.identificador).append("$$\n");
        //long
        sb.append("144;;CampoDouble;;, medindo Long.: " + identificador + ";;2$$\n");
        //anterior pos
        sb.append("145;;CampoDouble;; x Ant. Post.: " + identificador + ";;2$$\n");
        //transversal
        sb.append("146;;CampoDouble;; x Transv.: " + identificador + " cm;;2$$\n");

        //vesícula
        sb.append("\n147;;Linha$$\n");
        sb.append("148;;Enumeracao;;").append("Vesícula vitelínica ").append(CampoSimples.identificador).append(".;;true$$\n");
        //membrana
        sb.append("\n149;;Linha$$\n");
        sb.append("150;;Enumeracao;;").append("Membrana amniótica ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Presença
        sb.append("\n151;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        // presença
        sb.append("152;;Enumeracao;;").append("Embrião / Feto ").append(CampoSimples.identificador).append(";;true$$\n");
        // CCN
        sb.append("153;;CampoDouble;;, CCN medindo ").append(CampoSimples.identificador).append(" mm;;2$$\n");
        // Movimentos
        sb.append("154;;Enumeracao;;").append(", com movimentos ").append(CampoSimples.identificador).append(";;true$$\n");

        // Batimentos cardíacos
        sb.append("\n155;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        // Situação
        sb.append("156;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Nº de bpm
        sb.append("157;;CampoInteiro;; de ").append(CampoSimples.identificador).append(" bpm;;3$$\n");

        //translucência
        sb.append("\n158;;Linha$$\n");
        sb.append("159;;CampoDouble;;").append("Translucência nucal de ").append(CampoSimples.identificador).append(" mm.;;2$$\n");

        sb.append("\n160;;Linha$$\n");
        sb.append("161;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 5">

        sb.append("\n162;;Topico;;Embrião / Feto 5$$\n");
        sb.append("\n163;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        //situação
        sb.append("164;;Enumeracao;;").append("Presença de saco gestacional ").append(CampoSimples.identificador).append(";;true$$\n");
        //posição
        sb.append("165;;Enumeracao;;").append(" com forma ").append(CampoSimples.identificador).append("$$\n");
        //long
        sb.append("166;;CampoDouble;;, medindo Long.: " + identificador + ";;2$$\n");
        //anterior pos
        sb.append("167;;CampoDouble;; x Ant. Post.: " + identificador + ";;2$$\n");
        //transversal
        sb.append("168;;CampoDouble;; x Transv.: " + identificador + " cm;;2$$\n");

        // Vesícula
        sb.append("\n169;;Linha$$\n");
        sb.append("170;;Enumeracao;;").append("Vesícula vitelínica ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Membrana
        sb.append("\n171;;Linha$$\n");
        sb.append("172;;Enumeracao;;").append("Membrana amniótica ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Presença
        sb.append("\n173;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        // Presença
        sb.append("174;;Enumeracao;;").append("Embrião / Feto ").append(CampoSimples.identificador).append(";;true$$\n");
        // CCN
        sb.append("175;;CampoDouble;;, CCN medindo ").append(CampoSimples.identificador).append(" mm;;2$$\n");
        // Movimentos
        sb.append("176;;Enumeracao;;").append(", com movimentos ").append(CampoSimples.identificador).append(";;true$$\n");

        // Batimentos cardíacos
        sb.append("\n177;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        // Situação
        sb.append("178;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Nº de bpm
        sb.append("179;;CampoInteiro;; de ").append(CampoSimples.identificador).append(" bpm;;3$$\n");

        //translucência
        sb.append("\n180;;Linha$$\n");
        sb.append("181;;CampoDouble;;").append("Translucência nucal de ").append(CampoSimples.identificador).append(" mm.;;2$$\n");
        sb.append("\n182;;Linha$$\n");
        sb.append("183;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 6">

        sb.append("\n184;;Topico;;Embrião / Feto 6$$\n");
        sb.append("\n185;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        //situação
        sb.append("186;;Enumeracao;;").append("Presença de saco gestacional ").append(CampoSimples.identificador).append(";;true$$\n");
        //posição
        sb.append("187;;Enumeracao;;").append(" com forma ").append(CampoSimples.identificador).append("$$\n");
        //long
        sb.append("188;;CampoDouble;;, medindo Long.: " + identificador + ";;2$$\n");
        //anterior pos
        sb.append("189;;CampoDouble;; x Ant. Post.: " + identificador + ";;2$$\n");
        //transversal
        sb.append("190;;CampoDouble;; x Transv.: " + identificador + " cm;;2$$\n");

        //vesícula
        sb.append("\n191;;Linha$$\n");
        sb.append("192;;Enumeracao;;").append("Vesícula vitelínica ").append(CampoSimples.identificador).append(".;;true$$\n");
        //membrana
        sb.append("\n193;;Linha$$\n");
        sb.append("194;;Enumeracao;;").append("Membrana amniótica ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Presença
        sb.append("\n195;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        //presença
        sb.append("196;;Enumeracao;;").append("Embrião / Feto ").append(CampoSimples.identificador).append(";;true$$\n");
        // CCN
        sb.append("197;;CampoDouble;;, CCN medindo ").append(CampoSimples.identificador).append(" mm;;2$$\n");
        //movimentos
        sb.append("198;;Enumeracao;;").append(", com movimentos ").append(CampoSimples.identificador).append(";;true$$\n");

        // Batimentos cardíacos
        sb.append("\n199;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        // Situação
        sb.append("200;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Nº de bpm
        sb.append("201;;CampoInteiro;; de ").append(CampoSimples.identificador).append(" bpm;;3$$\n");

        //translucência
        sb.append("\n202;;Linha$$\n");
        sb.append("203;;CampoDouble;;").append("Translucência nucal de ").append(CampoSimples.identificador).append(" mm.;;2$$\n");

        sb.append("\n204;;Linha$$\n");
        sb.append("205;;CampoTexto;;\n$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovários">

        // <editor-fold defaultstate="collapsed" desc="Ovário direito">

        sb.append("\n206;;Topico;;Ovários$$\n");
        sb.append("\n207;;Linha$$\n");

        // Posição
        sb.append("208;;Enumeracao;;").append("Ovário direito ").append(CampoSimples.identificador).append(";;true$$\n");
        // Contorno
        sb.append("209;;Enumeracao;;").append(", de contornos ").append(CampoSimples.identificador).append("$$\n");
        // Limites
        sb.append("210;;Enumeracao;;").append(" e limites ").append(CampoSimples.identificador).append(".$$\n");

        sb.append("\n211;;Linha$$\n");
        // Parênquima
        sb.append("212;;Enumeracao;;").append("Exibindo parênquima de textura ").append(CampoSimples.identificador).append(".$$\n");

        // Medidas
        sb.append("\n213;;Linha$$\n");
        // Long.
        sb.append("214;;CampoDouble;;Medidas: Long.: " + identificador + ";;2$$\n");
        // Anterior pos
        sb.append("215;;CampoDouble;; x Ant. Post.: " + identificador + ";;2$$\n");
        // Transversal
        sb.append("216;;CampoDouble;; x Transv.: " + identificador + " cm;;2$$\n");
        // Volume
        sb.append("217;;CampoRpn;;C1 C2 C3 @").append(StaticInfo.FATOR_VOL_DIVERSOS).append("@ * * *;;");
        sb.append(", Volume = " + identificador + " cm³.;;3$$\n");

        // Descrição
        sb.append("\n218;;Linha$$\n");
        sb.append("219;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovário esquerdo">

        sb.append("\n220;;Linha$$\n");
        //posição ovário esquerdo
        sb.append("221;;Enumeracao;;").append("Ovário esquerdo ").append(CampoSimples.identificador).append(";;true$$\n");
        //contorno ovário esquerdo
        sb.append("222;;Enumeracao;;").append(", de contornos ").append(CampoSimples.identificador).append("$$\n");
        //limites ovário esquerdo
        sb.append("223;;Enumeracao;;").append(" e limites ").append(CampoSimples.identificador).append(".$$\n");

        sb.append("\n224;;Linha$$\n");
        // Parênquima
        sb.append("225;;Enumeracao;;").append("Exibindo parênquima de textura ").append(CampoSimples.identificador).append(".$$\n");

        //long
        sb.append("\n226;;Linha$$\n");
        sb.append("227;;CampoDouble;;Medidas: Long.: " + identificador + ";;2$$\n");
        //anterior pos
        sb.append("228;;CampoDouble;; x Ant. Post.: " + identificador + ";;2$$\n");
        //transversal
        sb.append("229;;CampoDouble;; x Transv.: " + identificador + " cm;;2$$\n");
        //volume
        sb.append("230;;CampoRpn;;C1 C2 C3 @").append(StaticInfo.FATOR_VOL_DIVERSOS).append("@ * * *;;");
        sb.append(", Volume = " + identificador + " cm³.;;3$$\n");

        // Descrição
        sb.append("\n231;;Linha$$\n");
        sb.append("232;;CampoTexto;;$$\n");

        // </editor-fold>

        // Observações gerais
        sb.append("\n233;;Linha$$\n");
        sb.append("234;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fundo de saco Douglas">

        sb.append("\n235;;Topico;;F.S.D$$\n");
        sb.append("\n236;;Linha$$\n");
        sb.append("237;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");

        // Descrição
        sb.append("\n238;;Linha$$\n");
        sb.append("239;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("\n240;;Topico;;Observações gerais$$\n");
        sb.append("\n241;;Linha$$\n");
        sb.append("242;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Desvio padrao">

        sb.append("\n243;;Linha$$\n");
        sb.append("244;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        sb.append("245;;Linha$$\n");
        sb.append("246;;Linha$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("\n247;;Topico;;Impressão diagnóstica$$\n");

        sb.append("\n248;;Linha$$\n");
        sb.append("249;;Label;;").append("Gravidez tópica, com embrião / feto único, de $$\n");
        sb.append("250;;Label;;").append("Gravidez tópica, gemelar, de $$\n");
        sb.append("251;;Label;;").append("Gravidez tópica, múltipla com $$\n");
        sb.append("252;;CampoRpn;;C1;;").append(CampoSimples.identificador).append(" embriões / fetos, de ;;0$$\n");
        sb.append("253;;CampoInteiro;;").append(CampoSimples.identificador).append(";;2$$\n");
        sb.append("254;;Label;;").append(" semana(s) $$\n");
        sb.append("255;;Label;;$$\n");
        sb.append("256;;CampoInteiro;; e ").append(CampoSimples.identificador).append(" dia(s);;1$$\n");
        sb.append("257;;Label;;").append("$$\n");
        sb.append("258;;CampoLogico;; (± " + identificador + " semana(s)).$$\n");
        sb.append("259;;CampoDouble;; (± "+ CampoSimples.identificador + " semana(s)).;;1$$\n");

        sb.append("\n260;;Linha$$\n");
        sb.append("261;;ImpressaoDiagnostica;;$248CampoDoLaudo$$\n");

        sb.append("\n262;;Linha$$\n");
        sb.append("263;;Enumeracao;;$261CampoTexto$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="DPP">

        sb.append("\n264;;Linha$$\n");
        sb.append("265;;CampoRpnData;;Tempo de amenorreia: ").append(CampoSimples.identificador).append(";;C1 C2 - "
                  + "").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 /$$\n");
        //diasIghDum
        sb.append("266;;CampoRpnData;;").append(" semana(s) e ").append(CampoSimples.identificador).append(" dia(s).</p>;;C1 C2 - "
                  + "").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 %$$\n");

        //dppPeloValorInformado feto unico
         sb.append("267;;CampoRpnData;;").append(" Data aproximada do parto: " + CampoSimples.identificador + " (± 1,0 sem).").append(";;C1 280 "
                + "").append(CampoRpnData.UM_DIA_EM_MS).append(" * + C2 7 ")
        .append(CampoRpnData.UM_DIA_EM_MS).append(" * * - C3 ").append(CampoRpnData.UM_DIA_EM_MS).append(" * -$$\n");

        // dias totais da igh informado pelo usuario
        sb.append("268;;CampoRpn;;C1 7 * C2 +;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;0$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="IG pelo CCN">

        sb.append("269;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$65CampoDoLaudo|$87CampoDoLaudo}$$\n");

        // </editor-fold>

        sb.append("270;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Metodos">

        // <editor-fold defaultstate="collapsed" desc="Desvio padrão">

        sb.append("\n248;;setImprimivel;;false$$\n");

        sb.append("\n244;;adicionarOpcao;;padrão clássico$$\n");
        sb.append("244;;adicionarOpcao;;definido$$\n");

        sb.append("252;;cadastrarParametroFormula;;$8CampoNumero$$\n");

        sb.append("258;;vincularHabAoValorDoCampo;;$244CampoDoLaudo;;false;;{padrão clássico}$$\n");
        sb.append("258;;cadastrarLogica;;(/s);;").append(CampoLogico.INTERVALO).append(";;{0.00|0.1}$$\n");
        sb.append("258;;cadastrarLogica;;(/s)0,5;;").append(CampoLogico.INTERVALO).append(";;{0.00|105.00}$$\n");
        sb.append("258;;cadastrarLogica;;(/s)1,0;;").append(CampoLogico.INTERVALO).append(";;{105.00|161.00}$$\n");
        sb.append("258;;cadastrarLogica;;(/s)1,5;;").append(CampoLogico.INTERVALO).append(";;{161.00|203.00}$$\n");
        sb.append("258;;cadastrarLogica;;(/s)2,0;;").append(CampoLogico.INTERVALO).append(";;{203.00|245.00}$$\n");
        sb.append("258;;cadastrarLogica;;(/s)2,5;;").append(CampoLogico.INTERVALO).append(";;{245.00|266.00}$$\n");
        sb.append("258;;cadastrarLogica;;(/s)3,0;;").append(CampoLogico.INTERVALO).append(";;{266.00|999.00}$$\n");
        sb.append("258;;setDependencia;;$268CampoNumero$$\n");

        sb.append("259;;vincularHabAoValorDoCampo;;$244CampoDoLaudo;;false;;{definido}$$\n");

        sb.append("\n268;;cadastrarParametroFormula;;$253CampoNumero$$\n");
        sb.append("268;;cadastrarParametroFormula;;$256CampoNumero$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Metodos comuns a todos os fetos">

        sb.append("15;;setObrigatorio;;false$$\n");
        sb.append("19;;setObrigatorio;;false$$\n");
        sb.append("20;;setObrigatorio;;false$$\n");
        sb.append("21;;setObrigatorio;;false$$\n");
        sb.append("234;;setObrigatorio;;false$$\n");
        sb.append("242;;setObrigatorio;;false$$\n");

        //descriçao bexiga
        sb.append("31;;vincularHabAoValorDoCampo;;$29CampoDoLaudo;;false;;{").append(""+CampoSimples.DIGITAR+"}$$\n");

        //descriçao vagina
        sb.append("36;;vincularHabAoValorDoCampo;;$34CampoDoLaudo;;false;;{").append(""+CampoSimples.DIGITAR+"}$$\n");

        //dppPeloValorInformado
        sb.append("\n267;;cadastrarParamFormula;;$13CampoDoLaudo$$\n");
        sb.append("267;;cadastrarParamFormula;;$253CampoDoLaudo$$\n");
        sb.append("267;;cadastrarParamFormula;;$256CampoDoLaudo$$\n");
        //diasIghDum
        sb.append("\n265;;cadastrarParamFormula;;$13CampoDoLaudo$$\n");
        sb.append("265;;cadastrarParamFormula;;$15CampoDoLaudo$$\n");
        //semanaIghDum
        sb.append("\n266;;cadastrarParamFormula;;$13CampoDoLaudo$$\n");
        sb.append("266;;cadastrarParamFormula;;$15CampoDoLaudo$$\n");
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

        //topicos
        sb.append("52;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("74;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("96;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("118;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("140;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("162;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)5|(/s)6}$$\n");
        sb.append("184;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)6}$$\n");

        //linhas da HP
        sb.append("249;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("250;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2}$$\n");
        sb.append("251;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("252;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");

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

        //dados equipamento
        sb.append("\n2;;adicionarOpcao;;convexo$$\n");
        sb.append("2;;adicionarOpcao;;linear$$\n");
        sb.append("2;;adicionarOpcao;;endocavitário$$\n");
        sb.append("2;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("2;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("3;;vincularHabAoValorDoCampo;;$2CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        //vagina
        sb.append("\n34;;adicionarOpcao;;normal;;Acusticamente normal$$\n");
        sb.append("34;;adicionarOpcao;;Aumento da ecogenicidade luminar$$\n");
        sb.append("34;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("34;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        //bexiga
        sb.append("\n29;;adicionarOpcao;;normal;;Conteúdo anecoico, paredes lisas e bem delimitadas.$$\n");
        sb.append("29;;adicionarOpcao;;não visualizada;;Não visualizada.$$\n");
        sb.append("29;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("29;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        //textura Miometrio
        sb.append("\n49;;adicionarOpcao;;homogênea$$\n");
        sb.append("49;;adicionarOpcao;;heterogênea$$\n");
        sb.append("49;;vincularHabAoValorDoCampo;;$39CampoDoLaudo;;false;;{anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");

        //canal Endocervical
        sb.append("\n51;;adicionarOpcao;;fechado$$\n");
        sb.append("51;;adicionarOpcao;;pérveo$$\n");
        sb.append("51;;adicionarOpcao;;com presença de muco$$\n");
        sb.append("51;;adicionarOpcao;;não se visualiza muco$$\n");
        sb.append("51;;adicionarOpcao;;dilatado com muco de 1 mm$$\n");
        sb.append("51;;adicionarOpcao;;dilatado com muco de 2 mm$$\n");
        sb.append("51;;adicionarOpcao;;dilatado com muco de 3 mm$$\n");
        sb.append("51;;adicionarOpcao;;dilatado com muco de 4 mm$$\n");
        sb.append("51;;adicionarOpcao;;dilatado com muco superior a 4 mm$$\n");
        sb.append("51;;vincularHabAoValorDoCampo;;$39CampoDoLaudo;;false;;{anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Útero">

        // Situação
        sb.append("\n39;;adicionarOpcao;;anteversão$$\n");
        sb.append("\n39;;adicionarOpcao;;medioversão$$\n");
        sb.append("39;;adicionarOpcao;;RTV leve$$\n");
        sb.append("39;;adicionarOpcao;;RTV moderada$$\n");
        sb.append("39;;adicionarOpcao;;RTV acentuada$$\n");

        // Posição
        sb.append("\n40;;adicionarOpcao;;centrado$$\n");
        sb.append("40;;adicionarOpcao;;desviado para direita$$\n");
        sb.append("40;;adicionarOpcao;;desviado para esquerda$$\n");
        sb.append("40;;vincularHabAoValorDoCampo;;$39CampoDoLaudo;;false;;{anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");

        // Contornos
        sb.append("\n41;;adicionarOpcao;;regulares$$\n");
        sb.append("41;;adicionarOpcao;;irregulares$$\n");
        sb.append("41;;adicionarOpcao;;lobulados$$\n");
        sb.append("41;;vincularHabAoValorDoCampo;;$39CampoDoLaudo;;false;;{anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");

        // Limites
        sb.append("\n42;;adicionarOpcao;;precisos$$\n");
        sb.append("42;;adicionarOpcao;;imprecisos$$\n");
        sb.append("42;;vincularHabAoValorDoCampo;;$39CampoDoLaudo;;false;;{anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");

        // Medidas
        sb.append("44;;vincularHabAoValorDoCampo;;$39CampoDoLaudo;;false;;{anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");
        sb.append("45;;vincularHabAoValorDoCampo;;$39CampoDoLaudo;;false;;{anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");
        sb.append("46;;vincularHabAoValorDoCampo;;$39CampoDoLaudo;;false;;{anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");
        sb.append("44;;setObrigatorio;;false$$\n");
        sb.append("45;;setObrigatorio;;false$$\n");
        sb.append("46;;setObrigatorio;;false$$\n");
        sb.append("\n44;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$45CampoDoLaudo|$46CampoDoLaudo}$$\n");
        sb.append("44;;setMsgErroValidCampoObrig;;Termine de informar as medidas do útero.$$\n");
        sb.append("45;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$44CampoDoLaudo|$46CampoDoLaudo}$$\n");
        sb.append("45;;setMsgErroValidCampoObrig;;Termine de informar as medidas do útero.$$\n");
        sb.append("46;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$44CampoDoLaudo|$45CampoDoLaudo}$$\n");
        sb.append("46;;setMsgErroValidCampoObrig;;Termine de informar as medidas do útero.$$\n");

        // Volume
        sb.append("47;;vincularHabAoValorDoCampo;;$39CampoDoLaudo;;false;;{anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");
        sb.append("47;;cadastrarParametroFormula;;$44CampoNumero$$\n");
        sb.append("47;;cadastrarParametroFormula;;$45CampoNumero$$\n");
        sb.append("47;;cadastrarParametroFormula;;$46CampoNumero$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovários">

        // <editor-fold defaultstate="collapsed" desc="Direito">

        // Posição
        sb.append("\n208;;adicionarOpcao;;para-uterino$$\n");
        sb.append("208;;adicionarOpcao;;posterior$$\n");
        sb.append("208;;adicionarOpcao;;inferior$$\n");
        sb.append("208;;adicionarOpcao;;anterior$$\n");
        sb.append("208;;adicionarOpcao;;justa-uterino$$\n");
        sb.append("208;;adicionarOpcao;;pélvico$$\n");
        sb.append("208;;adicionarOpcao;;não visualizado;;não visualizado.$$\n");
        sb.append("208;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("208;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        // Contornos
        sb.append("\n209;;adicionarOpcao;;regulares$$\n");
        sb.append("209;;adicionarOpcao;;irregulares$$\n");
        sb.append("209;;vincularHabAoValorDoCampo;;$208CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|justa-uterino|pélvico}$$\n");

        // Limites
        sb.append("\n210;;adicionarOpcao;;precisos$$\n");
        sb.append("210;;adicionarOpcao;;imprecisos$$\n");
        sb.append("210;;vincularHabAoValorDoCampo;;$208CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|justa-uterino|pélvico}$$\n");

        // Parenquima
        sb.append("\n212;;adicionarOpcao;;mista$$\n");
        sb.append("212;;adicionarOpcao;;sólida$$\n");
        sb.append("212;;adicionarOpcao;;cística$$\n");
        sb.append("212;;adicionarOpcao;;sólido cística$$\n");
        sb.append("212;;adicionarOpcao;;múltiplos folículos subcorticais $$\n");
        sb.append("212;;vincularHabAoValorDoCampo;;$208CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|justa-uterino|pélvico}$$\n");

        // Medidas
        sb.append("214;;setObrigatorio;;false$$\n");
        sb.append("215;;setObrigatorio;;false$$\n");
        sb.append("216;;setObrigatorio;;false$$\n");

        sb.append("214;;vincularHabAoValorDoCampo;;$208CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|justa-uterino|pélvico}$$\n");
        sb.append("215;;vincularHabAoValorDoCampo;;$208CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|justa-uterino|pélvico}$$\n");
        sb.append("216;;vincularHabAoValorDoCampo;;$208CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|justa-uterino|pélvico}$$\n");

        sb.append("214;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$215CampoDoLaudo|$216CampoDoLaudo}$$\n");
        sb.append("214;;setMsgErroValidCampoObrig;;Termine de informar as medidas do ovário direito.$$\n");
        sb.append("215;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$214CampoDoLaudo|$216CampoDoLaudo}$$\n");
        sb.append("215;;setMsgErroValidCampoObrig;;Termine de informar as medidas do ovário direito.$$\n");
        sb.append("216;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$214CampoDoLaudo|$215CampoDoLaudo}$$\n");
        sb.append("216;;setMsgErroValidCampoObrig;;Termine de informar as medidas do ovário direito.$$\n");

        // Volume
        sb.append("217;;vincularHabAoValorDoCampo;;$208CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|justa-uterino|pélvico}$$\n");
        sb.append("217;;cadastrarParametroFormula;;$214CampoNumero$$\n");
        sb.append("217;;cadastrarParametroFormula;;$215CampoNumero$$\n");
        sb.append("217;;cadastrarParametroFormula;;$216CampoNumero$$\n");

        // Descrição
        sb.append("219;;vincularObrigatorio;;$208CampoDoLaudo;;{").append(CampoSimples.DIGITAR).append("}$$\n");
        sb.append("219;;vincularHabAoValorDoCampo;;$208CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|justa-uterino|pélvico|" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Esquerdo">

        // Posição
        sb.append("\n221;;adicionarOpcao;;para-uterino$$\n");
        sb.append("221;;adicionarOpcao;;posterior$$\n");
        sb.append("221;;adicionarOpcao;;inferior$$\n");
        sb.append("221;;adicionarOpcao;;anterior$$\n");
        sb.append("221;;adicionarOpcao;;justa-uterino$$\n");
        sb.append("221;;adicionarOpcao;;pélvico$$\n");
        sb.append("221;;adicionarOpcao;;não visualizado;;não visualizado.$$\n");
        sb.append("221;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("221;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        // Contornos
        sb.append("\n222;;adicionarOpcao;;regulares$$\n");
        sb.append("222;;adicionarOpcao;;irregulares$$\n");
        sb.append("222;;vincularHabAoValorDoCampo;;$221CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|justa-uterino|pélvico}$$\n");

        // Limites
        sb.append("\n223;;adicionarOpcao;;precisos$$\n");
        sb.append("223;;adicionarOpcao;;imprecisos$$\n");
        sb.append("223;;vincularHabAoValorDoCampo;;$221CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|justa-uterino|pélvico}$$\n");

        // Parenquima
        sb.append("\n225;;adicionarOpcao;;mista$$\n");
        sb.append("225;;adicionarOpcao;;sólida$$\n");
        sb.append("225;;adicionarOpcao;;cística$$\n");
        sb.append("225;;adicionarOpcao;;sólido cística$$\n");
        sb.append("225;;adicionarOpcao;;múltiplos folículos subcorticais $$\n");
        sb.append("225;;vincularHabAoValorDoCampo;;$221CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|justa-uterino|pélvico}$$\n");

        // Medidas
        sb.append("227;;setObrigatorio;;false$$\n");
        sb.append("228;;setObrigatorio;;false$$\n");
        sb.append("229;;setObrigatorio;;false$$\n");

        sb.append("227;;vincularHabAoValorDoCampo;;$221CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|justa-uterino|pélvico}$$\n");
        sb.append("228;;vincularHabAoValorDoCampo;;$221CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|justa-uterino|pélvico}$$\n");
        sb.append("229;;vincularHabAoValorDoCampo;;$221CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|justa-uterino|pélvico}$$\n");

        sb.append("227;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$228CampoDoLaudo|$229CampoDoLaudo}$$\n");
        sb.append("227;;setMsgErroValidCampoObrig;;Termine de informar as medidas do ovário esquerdo.$$\n");
        sb.append("228;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$227CampoDoLaudo|$229CampoDoLaudo}$$\n");
        sb.append("228;;setMsgErroValidCampoObrig;;Termine de informar as medidas do ovário esquerdo.$$\n");
        sb.append("229;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$227CampoDoLaudo|$228CampoDoLaudo}$$\n");
        sb.append("229;;setMsgErroValidCampoObrig;;Termine de informar as medidas do ovário esquerdo.$$\n");

        // Volume
        sb.append("\n230;;vincularHabAoValorDoCampo;;$221CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|justa-uterino|pélvico}$$\n");
        sb.append("230;;cadastrarParametroFormula;;$227CampoNumero$$\n");
        sb.append("230;;cadastrarParametroFormula;;$228CampoNumero$$\n");
        sb.append("230;;cadastrarParametroFormula;;$229CampoNumero$$\n");

        // Descricao
        sb.append("232;;vincularObrigatorio;;$221CampoDoLaudo;;{").append(CampoSimples.DIGITAR).append("}$$\n");
        sb.append("232;;vincularHabAoValorDoCampo;;$221CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|justa-uterino|pélvico|" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fundo de saco Douglas">

        sb.append("\n237;;adicionarOpcao;;Livre$$\n");
        sb.append("237;;adicionarOpcao;;Com líquido livre$$\n");
        sb.append("237;;adicionarOpcao;;Livre com ecogenicidade aumentada$$\n");
        sb.append("237;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("237;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("239;;vincularHabAoValorDoCampo;;$237CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto unico">

        // Vesicula
        sb.append("\n60;;adicionarOpcao;;presente e normal$$\n");
        sb.append("60;;adicionarOpcao;;presente e anômala$$\n");
        sb.append("60;;adicionarOpcao;;ausente$$\n");
        sb.append("60;;adicionarOpcao;;não visualizada$$\n");

        // Membrana amniotica
        sb.append("\n62;;adicionarOpcao;;visualizada e normal$$\n");
        sb.append("62;;adicionarOpcao;;não visualizada$$\n");

        // Presença
        sb.append("\n64;;adicionarOpcao;;presente$$\n");
        sb.append("64;;adicionarOpcao;;ausente$$\n");
        sb.append("64;;adicionarOpcao;;não visualizado$$\n");
        sb.append("64;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("64;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        // Linha presença
        sb.append("63;;vincularHabAoValorDoCampo;;$64CampoDoLaudo;;false;;{presente}$$\n");

        // Movimentos
        sb.append("\n66;;adicionarOpcao;;lentos$$\n");
        sb.append("66;;adicionarOpcao;;suaves$$\n");
        sb.append("66;;adicionarOpcao;;rápidos$$\n");
        sb.append("66;;adicionarOpcao;;bruscos$$\n");
        sb.append("66;;adicionarOpcao;;ausentes$$\n");
        sb.append("66;;adicionarOpcao;;não visualizados$$\n");
        sb.append("66;;vincularHabAoValorDoCampo;;$64CampoDoLaudo;;false;;{presente}$$\n");

        // Batimentos cardiacos
        sb.append("\n68;;adicionarOpcao;;presentes$$\n");
        sb.append("68;;adicionarOpcao;;ausentes$$\n");
        sb.append("68;;adicionarOpcao;;não visualizados$$\n");
        sb.append("68;;vincularHabAoValorDoCampo;;$64CampoDoLaudo;;false;;{presente}$$\n");
        // N° de batimentos cardiacos
        sb.append("69;;vincularHabAoValorDoCampo;;$68CampoDoLaudo;;false;;{presentes}$$\n");

        // Translucencia nucal
        sb.append("71;;vincularHabAoValorDoCampo;;$64CampoDoLaudo;;false;;{presente}$$\n");

        // Descrição
        sb.append("73;;vincularObrigatorio;;$64CampoDoLaudo;;{").append(CampoSimples.DIGITAR).append("}$$\n");

        // Saco gestacional - inserção
        sb.append("\n54;;adicionarOpcao;;normoinserido$$\n");
        sb.append("54;;adicionarOpcao;;inserção baixa$$\n");
        sb.append("54;;adicionarOpcao;;ectópico$$\n");

        // Saco gestacional - forma
        sb.append("\n55;;adicionarOpcao;;regular$$\n");
        sb.append("55;;adicionarOpcao;;irregular$$\n");
        sb.append("55;;vincularHabAoValorDoCampo;;$54CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");

        // Saco gestacional - medidas
        sb.append("56;;vincularHabAoValorDoCampo;;$54CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");
        sb.append("57;;vincularHabAoValorDoCampo;;$54CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");
        sb.append("58;;vincularHabAoValorDoCampo;;$54CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");

        sb.append("56;;setObrigatorio;;false$$\n");
        sb.append("57;;setObrigatorio;;false$$\n");
        sb.append("58;;setObrigatorio;;false$$\n");

        sb.append("\n56;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$57CampoDoLaudo|$58CampoDoLaudo}$$\n");
        sb.append("56;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");
        sb.append("57;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$56CampoDoLaudo|$58CampoDoLaudo}$$\n");
        sb.append("57;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");
        sb.append("58;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$56CampoDoLaudo|$57CampoDoLaudo}$$\n");
        sb.append("58;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 1">

        // Vesicula
        sb.append("\n82;;adicionarOpcao;;presente e normal$$\n");
        sb.append("82;;adicionarOpcao;;presente e anômala$$\n");
        sb.append("82;;adicionarOpcao;;ausente$$\n");
        sb.append("82;;adicionarOpcao;;não visualizada$$\n");

        // Membrana amniotica
        sb.append("\n84;;adicionarOpcao;;visualizada e normal$$\n");
        sb.append("84;;adicionarOpcao;;não visualizada$$\n");

        // Presença
        sb.append("\n86;;adicionarOpcao;;presente$$\n");
        sb.append("86;;adicionarOpcao;;ausente$$\n");
        sb.append("86;;adicionarOpcao;;não visualizado$$\n");
        sb.append("86;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("86;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        // Linha presença
        sb.append("85;;vincularHabAoValorDoCampo;;$86CampoDoLaudo;;false;;{presente}$$\n");

        // Movimentos
        sb.append("\n88;;adicionarOpcao;;lentos$$\n");
        sb.append("88;;adicionarOpcao;;suaves$$\n");
        sb.append("88;;adicionarOpcao;;rápidos$$\n");
        sb.append("88;;adicionarOpcao;;bruscos$$\n");
        sb.append("88;;adicionarOpcao;;ausentes$$\n");
        sb.append("88;;adicionarOpcao;;não visualizados$$\n");
        sb.append("88;;vincularHabAoValorDoCampo;;$86CampoDoLaudo;;false;;{presente}$$\n");

        // Batimentos cardiacos
        sb.append("\n90;;adicionarOpcao;;presentes$$\n");
        sb.append("90;;adicionarOpcao;;ausentes$$\n");
        sb.append("90;;adicionarOpcao;;não visualizados$$\n");
        sb.append("90;;vincularHabAoValorDoCampo;;$86CampoDoLaudo;;false;;{presente}$$\n");
        // N° de batimentos cardiacos
        sb.append("91;;vincularHabAoValorDoCampo;;$90CampoDoLaudo;;false;;{presentes}$$\n");

        // Translucencia nucal
        sb.append("93;;vincularHabAoValorDoCampo;;$86CampoDoLaudo;;false;;{presente}$$\n");

        // Descrição
        sb.append("95;;vincularObrigatorio;;$86CampoDoLaudo;;{").append(CampoSimples.DIGITAR).append("}$$\n");

        // Saco gestacional - inserção
        sb.append("\n76;;adicionarOpcao;;normoinserido$$\n");
        sb.append("76;;adicionarOpcao;;inserção baixa$$\n");
        sb.append("76;;adicionarOpcao;;ectópico$$\n");

        // Saco gestacional - forma
        sb.append("\n77;;adicionarOpcao;;regular$$\n");
        sb.append("77;;adicionarOpcao;;irregular$$\n");
        sb.append("77;;vincularHabAoValorDoCampo;;$76CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");

        // Saco gestacional - medidas
        sb.append("78;;vincularHabAoValorDoCampo;;$76CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");
        sb.append("79;;vincularHabAoValorDoCampo;;$76CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");
        sb.append("80;;vincularHabAoValorDoCampo;;$76CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");

        sb.append("78;;setObrigatorio;;false$$\n");
        sb.append("79;;setObrigatorio;;false$$\n");
        sb.append("80;;setObrigatorio;;false$$\n");

        sb.append("\n78;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$79CampoDoLaudo|$80CampoDoLaudo}$$\n");
        sb.append("78;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");
        sb.append("79;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$78CampoDoLaudo|$80CampoDoLaudo}$$\n");
        sb.append("79;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");
        sb.append("80;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$78CampoDoLaudo|$79CampoDoLaudo}$$\n");
        sb.append("80;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 2">

        // Vesicula
        sb.append("\n104;;adicionarOpcao;;presente e normal$$\n");
        sb.append("104;;adicionarOpcao;;presente e anômala$$\n");
        sb.append("104;;adicionarOpcao;;ausente$$\n");
        sb.append("104;;adicionarOpcao;;não visualizada$$\n");

        // Membrana amniotica
        sb.append("\n106;;adicionarOpcao;;visualizada e normal$$\n");
        sb.append("106;;adicionarOpcao;;não visualizada$$\n");

        // Inserção
        sb.append("\n108;;adicionarOpcao;;presente$$\n");
        sb.append("108;;adicionarOpcao;;ausente$$\n");
        sb.append("108;;adicionarOpcao;;não visualizado$$\n");
        sb.append("108;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("108;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        // Movimentos
        sb.append("\n110;;adicionarOpcao;;lentos$$\n");
        sb.append("110;;adicionarOpcao;;suaves$$\n");
        sb.append("110;;adicionarOpcao;;rápidos$$\n");
        sb.append("110;;adicionarOpcao;;bruscos$$\n");
        sb.append("110;;adicionarOpcao;;ausentes$$\n");
        sb.append("110;;adicionarOpcao;;não visualizados$$\n");
        sb.append("110;;vincularHabAoValorDoCampo;;$108CampoDoLaudo;;false;;{presente}$$\n");

        // Batimentos cardiacos
        sb.append("\n112;;adicionarOpcao;;presentes$$\n");
        sb.append("112;;adicionarOpcao;;ausentes$$\n");
        sb.append("112;;adicionarOpcao;;não visualizados$$\n");
        sb.append("112;;vincularHabAoValorDoCampo;;$108CampoDoLaudo;;false;;{presente}$$\n");
        // N° de batimentos cardiacos
        sb.append("113;;vincularHabAoValorDoCampo;;$112CampoDoLaudo;;false;;{presentes}$$\n");

        // CCN
        sb.append("109;;vincularHabAoValorDoCampo;;$108CampoDoLaudo;;false;;{presente}$$\n");

        // Translucencia nucal
        sb.append("115;;vincularHabAoValorDoCampo;;$108CampoDoLaudo;;false;;{presente}$$\n");

        // Descrição
        sb.append("117;;vincularObrigatorio;;$108CampoDoLaudo;;{").append(CampoSimples.DIGITAR).append("}$$\n");

        // Saco gestacional - inserção
        sb.append("\n98;;adicionarOpcao;;normoinserido$$\n");
        sb.append("98;;adicionarOpcao;;inserção baixa$$\n");
        sb.append("98;;adicionarOpcao;;ectópico$$\n");

        // Saco gestacional - forma
        sb.append("\n99;;adicionarOpcao;;regular$$\n");
        sb.append("99;;adicionarOpcao;;irregular$$\n");
        sb.append("99;;vincularHabAoValorDoCampo;;$98CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");

        // Saco gestacional - medidas
        sb.append("100;;vincularHabAoValorDoCampo;;$98CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");
        sb.append("101;;vincularHabAoValorDoCampo;;$98CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");
        sb.append("102;;vincularHabAoValorDoCampo;;$98CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");

        sb.append("100;;setObrigatorio;;false$$\n");
        sb.append("101;;setObrigatorio;;false$$\n");
        sb.append("102;;setObrigatorio;;false$$\n");

        sb.append("\n100;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$101CampoDoLaudo|$102CampoDoLaudo}$$\n");
        sb.append("100;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");
        sb.append("101;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$100CampoDoLaudo|$102CampoDoLaudo}$$\n");
        sb.append("101;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");
        sb.append("102;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$100CampoDoLaudo|$101CampoDoLaudo}$$\n");
        sb.append("102;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 3">

        // Vesicula
        sb.append("\n126;;adicionarOpcao;;presente e normal$$\n");
        sb.append("126;;adicionarOpcao;;presente e anômala$$\n");
        sb.append("126;;adicionarOpcao;;ausente$$\n");
        sb.append("126;;adicionarOpcao;;não visualizada$$\n");

        // Membrana amniotica
        sb.append("\n128;;adicionarOpcao;;visualizada e normal$$\n");
        sb.append("128;;adicionarOpcao;;não visualizada$$\n");

        // Inserção
        sb.append("\n130;;adicionarOpcao;;presente$$\n");
        sb.append("130;;adicionarOpcao;;ausente$$\n");
        sb.append("130;;adicionarOpcao;;não visualizado$$\n");
        sb.append("130;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("130;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        // Movimentos
        sb.append("\n132;;adicionarOpcao;;lentos$$\n");
        sb.append("132;;adicionarOpcao;;suaves$$\n");
        sb.append("132;;adicionarOpcao;;rápidos$$\n");
        sb.append("132;;adicionarOpcao;;bruscos$$\n");
        sb.append("132;;adicionarOpcao;;ausentes$$\n");
        sb.append("132;;adicionarOpcao;;não visualizados$$\n");
        sb.append("132;;vincularHabAoValorDoCampo;;$130CampoDoLaudo;;false;;{presente}$$\n");

        // Batimentos cardiacos
        sb.append("\n134;;adicionarOpcao;;presentes$$\n");
        sb.append("134;;adicionarOpcao;;ausentes$$\n");
        sb.append("134;;adicionarOpcao;;não visualizados$$\n");
        sb.append("134;;vincularHabAoValorDoCampo;;$130CampoDoLaudo;;false;;{presente}$$\n");
        // N° de batimentos cardiacos
        sb.append("135;;vincularHabAoValorDoCampo;;$134CampoDoLaudo;;false;;{presentes}$$\n");

        // CCN
        sb.append("131;;vincularHabAoValorDoCampo;;$130CampoDoLaudo;;false;;{presente}$$\n");

        // Translucencia nucal
        sb.append("137;;vincularHabAoValorDoCampo;;$130CampoDoLaudo;;false;;{presente}$$\n");

        // Descrição
        sb.append("139;;vincularObrigatorio;;$130CampoDoLaudo;;{").append(CampoSimples.DIGITAR).append("}$$\n");

        // Saco gestacional - inserção
        sb.append("\n120;;adicionarOpcao;;normoinserido$$\n");
        sb.append("120;;adicionarOpcao;;inserção baixa$$\n");
        sb.append("120;;adicionarOpcao;;ectópico$$\n");

        // Saco gestacional - forma
        sb.append("\n121;;adicionarOpcao;;regular$$\n");
        sb.append("121;;adicionarOpcao;;irregular$$\n");
        sb.append("121;;vincularHabAoValorDoCampo;;$120CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");

        // Saco gestacional - medidas
        sb.append("122;;vincularHabAoValorDoCampo;;$120CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");
        sb.append("123;;vincularHabAoValorDoCampo;;$120CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");
        sb.append("124;;vincularHabAoValorDoCampo;;$120CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");

        sb.append("122;;setObrigatorio;;false$$\n");
        sb.append("123;;setObrigatorio;;false$$\n");
        sb.append("124;;setObrigatorio;;false$$\n");

        sb.append("\n122;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$123CampoDoLaudo|$124CampoDoLaudo}$$\n");
        sb.append("122;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");
        sb.append("123;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$122CampoDoLaudo|$124CampoDoLaudo}$$\n");
        sb.append("123;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");
        sb.append("124;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$122CampoDoLaudo|$123CampoDoLaudo}$$\n");
        sb.append("124;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 4">

        // Vesicula
        sb.append("\n148;;adicionarOpcao;;presente e normal$$\n");
        sb.append("148;;adicionarOpcao;;presente e anômala$$\n");
        sb.append("148;;adicionarOpcao;;ausente$$\n");
        sb.append("148;;adicionarOpcao;;não visualizada$$\n");

        // Membrana amniotica
        sb.append("\n150;;adicionarOpcao;;visualizada e normal$$\n");
        sb.append("150;;adicionarOpcao;;não visualizada$$\n");

        // Inserção
        sb.append("\n152;;adicionarOpcao;;presente$$\n");
        sb.append("152;;adicionarOpcao;;ausente$$\n");
        sb.append("152;;adicionarOpcao;;não visualizado$$\n");
        sb.append("152;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("152;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        // Movimentos
        sb.append("\n154;;adicionarOpcao;;lentos$$\n");
        sb.append("154;;adicionarOpcao;;suaves$$\n");
        sb.append("154;;adicionarOpcao;;rápidos$$\n");
        sb.append("154;;adicionarOpcao;;bruscos$$\n");
        sb.append("154;;adicionarOpcao;;ausentes$$\n");
        sb.append("154;;adicionarOpcao;;não visualizados$$\n");
        sb.append("154;;vincularHabAoValorDoCampo;;$152CampoDoLaudo;;false;;{presente}$$\n");

        // Batimentos cardiacos
        sb.append("\n156;;adicionarOpcao;;presentes$$\n");
        sb.append("156;;adicionarOpcao;;ausentes$$\n");
        sb.append("156;;adicionarOpcao;;não visualizados$$\n");
        sb.append("156;;vincularHabAoValorDoCampo;;$152CampoDoLaudo;;false;;{presente}$$\n");
        // N° de batimentos cardiacos
        sb.append("157;;vincularHabAoValorDoCampo;;$156CampoDoLaudo;;false;;{presentes}$$\n");

        // CCN
        sb.append("153;;vincularHabAoValorDoCampo;;$152CampoDoLaudo;;false;;{presente}$$\n");

        // Translucencia nucal
        sb.append("159;;vincularHabAoValorDoCampo;;$152CampoDoLaudo;;false;;{presente}$$\n");

        // Descrição
        sb.append("161;;vincularObrigatorio;;$152CampoDoLaudo;;{").append(CampoSimples.DIGITAR).append("}$$\n");

        // Saco gestacional - inserção
        sb.append("\n142;;adicionarOpcao;;normoinserido$$\n");
        sb.append("142;;adicionarOpcao;;inserção baixa$$\n");
        sb.append("142;;adicionarOpcao;;ectópico$$\n");

        // Saco gestacional - forma
        sb.append("\n143;;adicionarOpcao;;regular$$\n");
        sb.append("143;;adicionarOpcao;;irregular$$\n");
        sb.append("143;;vincularHabAoValorDoCampo;;$142CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");

        // Saco gestacional - medidas
        sb.append("144;;vincularHabAoValorDoCampo;;$142CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");
        sb.append("145;;vincularHabAoValorDoCampo;;$142CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");
        sb.append("146;;vincularHabAoValorDoCampo;;$142CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");

        sb.append("144;;setObrigatorio;;false$$\n");
        sb.append("145;;setObrigatorio;;false$$\n");
        sb.append("146;;setObrigatorio;;false$$\n");

        sb.append("\n144;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$145CampoDoLaudo|$146CampoDoLaudo}$$\n");
        sb.append("144;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");
        sb.append("145;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$144CampoDoLaudo|$146CampoDoLaudo}$$\n");
        sb.append("145;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");
        sb.append("146;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$145CampoDoLaudo|$146CampoDoLaudo}$$\n");
        sb.append("146;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 5">

        // Vesicula
        sb.append("\n170;;adicionarOpcao;;presente e normal$$\n");
        sb.append("170;;adicionarOpcao;;presente e anômala$$\n");
        sb.append("170;;adicionarOpcao;;ausente$$\n");
        sb.append("170;;adicionarOpcao;;não visualizada$$\n");

        // Membrana amniotica
        sb.append("\n172;;adicionarOpcao;;visualizada e normal$$\n");
        sb.append("172;;adicionarOpcao;;não visualizada$$\n");

        // Inserção
        sb.append("\n174;;adicionarOpcao;;presente$$\n");
        sb.append("174;;adicionarOpcao;;ausente$$\n");
        sb.append("174;;adicionarOpcao;;não visualizado$$\n");
        sb.append("174;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("174;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        // Movimentos
        sb.append("\n176;;adicionarOpcao;;lentos$$\n");
        sb.append("176;;adicionarOpcao;;suaves$$\n");
        sb.append("176;;adicionarOpcao;;rápidos$$\n");
        sb.append("176;;adicionarOpcao;;bruscos$$\n");
        sb.append("176;;adicionarOpcao;;ausentes$$\n");
        sb.append("176;;adicionarOpcao;;não visualizados$$\n");
        sb.append("176;;vincularHabAoValorDoCampo;;$174CampoDoLaudo;;false;;{presente}$$\n");

        // Batimentos cardiacos
        sb.append("\n178;;adicionarOpcao;;presentes$$\n");
        sb.append("178;;adicionarOpcao;;ausentes$$\n");
        sb.append("178;;adicionarOpcao;;não visualizados$$\n");
        sb.append("178;;vincularHabAoValorDoCampo;;$174CampoDoLaudo;;false;;{presente}$$\n");
        // N° de batimentos cardiacos
        sb.append("179;;vincularHabAoValorDoCampo;;$178CampoDoLaudo;;false;;{presentes}$$\n");

        // CCN
        sb.append("175;;vincularHabAoValorDoCampo;;$174CampoDoLaudo;;false;;{presente}$$\n");

        // Translucencia nucal
        sb.append("181;;vincularHabAoValorDoCampo;;$174CampoDoLaudo;;false;;{presente}$$\n");

        // Descrição
        sb.append("183;;vincularObrigatorio;;$174CampoDoLaudo;;{").append(CampoSimples.DIGITAR).append("}$$\n");

        // Saco gestacional - inserção
        sb.append("\n164;;adicionarOpcao;;normoinserido$$\n");
        sb.append("164;;adicionarOpcao;;inserção baixa$$\n");
        sb.append("164;;adicionarOpcao;;ectópico$$\n");

        // Saco gestacional - forma
        sb.append("\n165;;adicionarOpcao;;regular$$\n");
        sb.append("165;;adicionarOpcao;;irregular$$\n");
        sb.append("165;;vincularHabAoValorDoCampo;;$164CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");

        // Saco gestacional - medidas
        sb.append("166;;vincularHabAoValorDoCampo;;$164CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");
        sb.append("167;;vincularHabAoValorDoCampo;;$164CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");
        sb.append("168;;vincularHabAoValorDoCampo;;$164CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");

        sb.append("166;;setObrigatorio;;false$$\n");
        sb.append("167;;setObrigatorio;;false$$\n");
        sb.append("168;;setObrigatorio;;false$$\n");

        sb.append("\n166;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$167CampoDoLaudo|$168CampoDoLaudo}$$\n");
        sb.append("166;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");
        sb.append("167;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$166CampoDoLaudo|$168CampoDoLaudo}$$\n");
        sb.append("167;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");
        sb.append("168;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$167CampoDoLaudo|$168CampoDoLaudo}$$\n");
        sb.append("168;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 6">

        // Vesicula
        sb.append("\n192;;adicionarOpcao;;presente e normal$$\n");
        sb.append("192;;adicionarOpcao;;presente e anômala$$\n");
        sb.append("192;;adicionarOpcao;;ausente$$\n");
        sb.append("192;;adicionarOpcao;;não visualizada$$\n");

        // Membrana amniotica
        sb.append("\n194;;adicionarOpcao;;visualizada e normal$$\n");
        sb.append("194;;adicionarOpcao;;não visualizada$$\n");

        // Inserção
        sb.append("\n196;;adicionarOpcao;;presente$$\n");
        sb.append("196;;adicionarOpcao;;ausente$$\n");
        sb.append("196;;adicionarOpcao;;não visualizado$$\n");
        sb.append("196;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("196;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        // Movimentos
        sb.append("\n198;;adicionarOpcao;;lentos$$\n");
        sb.append("198;;adicionarOpcao;;suaves$$\n");
        sb.append("198;;adicionarOpcao;;rápidos$$\n");
        sb.append("198;;adicionarOpcao;;bruscos$$\n");
        sb.append("198;;adicionarOpcao;;ausentes$$\n");
        sb.append("198;;adicionarOpcao;;não visualizados$$\n");
        sb.append("198;;vincularHabAoValorDoCampo;;$196CampoDoLaudo;;false;;{presente}$$\n");

        // Batimentos cardiacos
        sb.append("\n200;;adicionarOpcao;;presentes$$\n");
        sb.append("200;;adicionarOpcao;;ausentes$$\n");
        sb.append("200;;adicionarOpcao;;não visualizados$$\n");
        sb.append("200;;vincularHabAoValorDoCampo;;$196CampoDoLaudo;;false;;{presente}$$\n");
        // N° de batimentos cardiacos
        sb.append("201;;vincularHabAoValorDoCampo;;$200CampoDoLaudo;;false;;{presentes}$$\n");

        // CCN
        sb.append("197;;vincularHabAoValorDoCampo;;$196CampoDoLaudo;;false;;{presente}$$\n");

        // Translucencia nucal
        sb.append("203;;vincularHabAoValorDoCampo;;$196CampoDoLaudo;;false;;{presente}$$\n");

        // Descrição
        sb.append("205;;vincularObrigatorio;;$196CampoDoLaudo;;{").append(CampoSimples.DIGITAR).append("}$$\n");

        // Saco gestacional - inserção
        sb.append("\n186;;adicionarOpcao;;normoinserido$$\n");
        sb.append("186;;adicionarOpcao;;inserção baixa$$\n");
        sb.append("186;;adicionarOpcao;;ectópico$$\n");

        // Saco gestacional - forma
        sb.append("\n187;;adicionarOpcao;;regular$$\n");
        sb.append("187;;adicionarOpcao;;irregular$$\n");
        sb.append("187;;vincularHabAoValorDoCampo;;$186CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");

        // Saco gestacional - medidas
        sb.append("188;;vincularHabAoValorDoCampo;;$186CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");
        sb.append("189;;vincularHabAoValorDoCampo;;$186CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");
        sb.append("190;;vincularHabAoValorDoCampo;;$186CampoDoLaudo;;false;;{normoinserido|inserção baixa|ectópico}$$\n");

        sb.append("188;;setObrigatorio;;false$$\n");
        sb.append("189;;setObrigatorio;;false$$\n");
        sb.append("190;;setObrigatorio;;false$$\n");

        sb.append("\n188;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$189CampoDoLaudo|$190CampoDoLaudo}$$\n");
        sb.append("188;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");
        sb.append("189;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$188CampoDoLaudo|$190CampoDoLaudo}$$\n");
        sb.append("189;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");
        sb.append("190;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$189CampoDoLaudo|$190CampoDoLaudo}$$\n");
        sb.append("190;;setMsgErroValidCampoObrig;;Termine de informar as medidas do saco gestacional.$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="IG pelo CCN">

        sb.append("65;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("87;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");

        sb.append("269;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1|(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("269;;cadastrarLogica;;0.000->2.000;;$$\n");
        sb.append("269;;cadastrarLogica;;2.000->2.001;;Compatível com: 5 semanas e 5 dias$$\n");
        sb.append("269;;cadastrarLogica;;2.001->3.001;;Compatível com: 5 semanas e 6 dias$$\n");
        sb.append("269;;cadastrarLogica;;3.001->4.001;;Compatível com: 6 semanas$$\n");
        sb.append("269;;cadastrarLogica;;4.001->5.001;;Compatível com: 6 semanas e 2 dias$$\n");
        sb.append("269;;cadastrarLogica;;5.001->6.001;;Compatível com: 6 semanas e 3 dias$$\n");
        sb.append("269;;cadastrarLogica;;6.001->7.001;;Compatível com: 6 semanas e 4 dias$$\n");
        sb.append("269;;cadastrarLogica;;7.001->8.001;;Compatível com: 6 semanas e 6 dias$$\n");
        sb.append("269;;cadastrarLogica;;8.001->9.001;;Compatível com: 7 semanas$$\n");
        sb.append("269;;cadastrarLogica;;9.001->10.001;;Compatível com: 7 semanas e 2 dias$$\n");
        sb.append("269;;cadastrarLogica;;10.001->11.001;;Compatível com: 7 semanas e 3 dias$$\n");
        sb.append("269;;cadastrarLogica;;11.001->12.001;;Compatível com: 7 semanas e 4 dias$$\n");
        sb.append("269;;cadastrarLogica;;12.001->13.001;;Compatível com: 7 semanas e 5 dias$$\n");
        sb.append("269;;cadastrarLogica;;13.001->14.001;;Compatível com: 7 semanas e 6 dias$$\n");
        sb.append("269;;cadastrarLogica;;14.001->15.001;;Compatível com: 8 semanas$$\n");
        sb.append("269;;cadastrarLogica;;15.001->16.001;;Compatível com: 8 semanas e 1 dia$$\n");
        sb.append("269;;cadastrarLogica;;16.001->17.001;;Compatível com: 8 semanas e 2 dias$$\n");
        sb.append("269;;cadastrarLogica;;17.001->18.001;;Compatível com: 8 semanas e 3 dias$$\n");
        sb.append("269;;cadastrarLogica;;18.001->19.001;;Compatível com: 8 semanas e 4 dias$$\n");
        sb.append("269;;cadastrarLogica;;19.001->20.001;;Compatível com: 8 semanas e 5 dias$$\n");
        sb.append("269;;cadastrarLogica;;20.001->21.001;;Compatível com: 8 semanas e 6 dias$$\n");
        sb.append("269;;cadastrarLogica;;21.001->22.001;;Compatível com: 9 semanas$$\n");
        sb.append("269;;cadastrarLogica;;22.001->23.001;;Compatível com: 9 semanas e 1 dia$$\n");
        sb.append("269;;cadastrarLogica;;23.001->24.001;;Compatível com: 9 semanas e 2 dias$$\n");
        sb.append("269;;cadastrarLogica;;24.001->25.001;;Compatível com: 9 semanas e 3 dias$$\n");
        sb.append("269;;cadastrarLogica;;25.001->27.001;;Compatível com: 9 semanas e 4 dias$$\n");
        sb.append("269;;cadastrarLogica;;27.001->28.001;;Compatível com: 9 semanas e 5 dias$$\n");
        sb.append("269;;cadastrarLogica;;28.001->29.001;;Compatível com: 9 semanas e 6 dias$$\n");
        sb.append("269;;cadastrarLogica;;29.001->30.001;;Compatível com: 10 semanas$$\n");
        sb.append("269;;cadastrarLogica;;30.001->32.001;;Compatível com: 10 semanas e 1 dia$$\n");
        sb.append("269;;cadastrarLogica;;32.001->33.001;;Compatível com: 10 semanas e 2 dias$$\n");
        sb.append("269;;cadastrarLogica;;33.001->35.001;;Compatível com: 10 semanas e 3 dias$$\n");
        sb.append("269;;cadastrarLogica;;35.001->36.001;;Compatível com: 10 semanas e 4 dias$$\n");
        sb.append("269;;cadastrarLogica;;36.001->37.001;;Compatível com: 10 semanas e 5 dias$$\n");
        sb.append("269;;cadastrarLogica;;37.001->39.001;;Compatível com: 10 semanas e 6 dias$$\n");
        sb.append("269;;cadastrarLogica;;39.001->40.001;;Compatível com: 11 semanas$$\n");
        sb.append("269;;cadastrarLogica;;40.001->42.001;;Compatível com: 11 semanas e 1 dia$$\n");
        sb.append("269;;cadastrarLogica;;42.001->43.001;;Compatível com: 11 semanas e 2 dias$$\n");
        sb.append("269;;cadastrarLogica;;43.001->45.001;;Compatível com: 11 semanas e 3 dias$$\n");
        sb.append("269;;cadastrarLogica;;45.001->47.001;;Compatível com: 11 semanas e 4 dias$$\n");
        sb.append("269;;cadastrarLogica;;47.001->48.001;;Compatível com: 11 semanas e 5 dias$$\n");
        sb.append("269;;cadastrarLogica;;48.001->50.001;;Compatível com: 11 semanas e 6 dias$$\n");
        sb.append("269;;cadastrarLogica;;50.001->52.001;;Compatível com: 12 semanas$$\n");
        sb.append("269;;cadastrarLogica;;52.001->53.001;;Compatível com: 12 semanas e 1 dia$$\n");
        sb.append("269;;cadastrarLogica;;53.001->55.001;;Compatível com: 12 semanas e 2 dias$$\n");
        sb.append("269;;cadastrarLogica;;55.001->57.001;;Compatível com: 12 semanas e 3 dias$$\n");
        sb.append("269;;cadastrarLogica;;57.001->59.001;;Compatível com: 12 semanas e 4 dias$$\n");
        sb.append("269;;cadastrarLogica;;59.001->61.001;;Compatível com: 12 semanas e 5 dias$$\n");
        sb.append("269;;cadastrarLogica;;61.001->63.001;;Compatível com: 12 semanas e 6 dias$$\n");
        sb.append("269;;cadastrarLogica;;63.001->64.001;;Compatível com: 13 semanas$$\n");
        sb.append("269;;cadastrarLogica;;64.001->66.001;;Compatível com: 13 semanas e 1 dia$$\n");
        sb.append("269;;cadastrarLogica;;66.001->68.001;;Compatível com: 13 semanas e 2 dias$$\n");
        sb.append("269;;cadastrarLogica;;68.001->70.001;;Compatível com: 13 semanas e 3 dias$$\n");
        sb.append("269;;cadastrarLogica;;70.001->72.001;;Compatível com: 13 semanas e 4 dias$$\n");
        sb.append("269;;cadastrarLogica;;72.001->74.001;;Compatível com: 13 semanas e 5 dias$$\n");
        sb.append("269;;cadastrarLogica;;74.001->76.001;;Compatível com: 13 semanas e 6 dias$$\n");
        sb.append("269;;cadastrarLogica;;76.001->78.001;;Compatível com: 14 semanas$$\n");

        // </editor-fold>

        sb.append("270;;adicionarOpcao;;sim$$\n");
        sb.append("270;;adicionarOpcao;;não$$\n");
        sb.append("267;;vincularHabAoValorDoCampo;;$270CampoDoLaudo;;false;;{sim}$$\n");

        // </editor-fold>

        alterarModeloDeLaudo(4);

    }

    static void obstetrico14Semanas() throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Contrutores">

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento">

        sb.append("\n0;;Topico;;Equipamento$$\n");
        sb.append("\n1;;Linha$$\n");
        sb.append("2;;Enumeracao;;Exame realizado em modo bidimensional "
                + "com equipamento dinâmico ").append(identificador).
                append(" multifrequencial.;;true$$\n");

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

        sb.append("\n39;;Linha;;<b>Órgãos internos:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("40;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");

        // Descrição
        sb.append("41;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria">

        sb.append("\n42;;Linha;;\n");
        sb.append("<b>Biometria:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");

        //D.B.P (mm)
        sb.append("43;;CampoInteiro;;<p style=\"margin-top: 0\">Diâmetro biparietal de " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // IC
        sb.append("44;;CampoRpn;;C1 100 * C2 /;;<p style=\"margin-top: 0\">Índice cefálico: " + CampoSimples.identificador + ".</p>;;2$$\n");
        // C.A (mm)
        sb.append("45;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        sb.append("46;;CampoRpn;;1.57 C1 C2 + *;;<p style=\"margin-top: 0\">Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.</p>;;0$$\n");
        sb.append("47;;CampoInteiro;;<p style=\"margin-top: 0\">Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // CC
        sb.append("48;;CampoRpn;;C1 C2 + 2 / pi * 1.013 *;;<p style=\"margin-top: 0\">Circunferência craniana fetal: " + CampoSimples.identificador + " mm.</p>;;2$$\n");
       // CC Div CA
        sb.append("49;;CampoRpn;;C1 C2 /;;<p style=\"margin-top: 0\">Circunferência craniana / circunferência abdominal: " + CampoSimples.identificador + ".</p>;;2$$\n");
        //C.F (mm)
        sb.append("50;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento do fêmur: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // CF / CA
        sb.append("51;;CampoRpn;;C1 100 * C2 /;;<p style=\"margin-top: 0\">C.F. / C.A. (Hadlock): " + CampoSimples.identificador + ".</p>;;2$$\n");
        // Umero (mm)
        sb.append("52;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento do úmero: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Ulna (mm)
        sb.append("53;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento da ulna: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Tibia (mm)
        sb.append("54;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento da tíbia: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Peso
        sb.append("55;;CampoRpn;;10 -1.7492 .0166 C1 * + .0046 C2 * + 2.646 C1 C2 * 100000 / * - ^ 1000 *"
                  + ";;<p style=\"margin-top: 0\">Peso fetal provável: " + CampoSimples.identificador + " g (±10%).</p>;;2$$\n");
        // Estatura
        sb.append("56;;CampoRpn;;C1 0.55 *;;<p style=\"margin-top: 0\">Estatura fetal provável: " + CampoSimples.identificador + " cm.</p>;;2$$\n");
        // Sexo
        sb.append("57;;Enumeracao;;<p style=\"margin-top: 0\">Sexo fetal provável: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // Gordura
        sb.append("58;;Enumeracao;;<p style=\"margin-top: 0\">Gordura pré-peritoneal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // Estadiamento intestinal
        sb.append("59;;Enumeracao;;<p style=\"margin-top: 0\">Estadiamento intestinal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // D.O.F (mm)
        sb.append("60;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL +";;3$$\n");
        // D.A.P (mm)
        sb.append("61;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");
        // D.L.L (mm)
        sb.append("62;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        sb.append("\n63;;Linha;;\n");
        sb.append("<b>Placenta:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //inserção 1
        sb.append("64;;Enumeracao;;<p style=\"margin-top: 0\">De inserção ").append(CampoSimples.identificador).append(";;true$$\n");
        //insercao 2
        sb.append("65;;Enumeracao;; ").append(CampoSimples.identificador).append(".</p>$$\n");
        //espessura
        sb.append("66;;CampoInteiro;;<p style=\"margin-top: 0\">Espessura: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        //maturidade
        sb.append("67;;Enumeracao;;<p style=\"margin-top: 0\">Apresentando ").append(CampoSimples.identificador).append(" (grannum 0, 1, 2, 3).</p>$$\n");

        // Descrição
        sb.append("68;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados placenta">

        //cordão umbilical
        sb.append("\n69;;Linha;;<b>Cordão umbilical:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("70;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");

        //liquido amniótico
        sb.append("\n71;;Linha;;<b>Líquido amniótico:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("72;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append(";;true$$\n");
        //quadrante 1
        sb.append("73;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 2
        sb.append("74;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 3
        sb.append("75;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 4
        sb.append("76;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        // ILA
        sb.append("\n77;;Linha;;<b>Índice do líquido amniótico:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("78;;CampoRpn;;C1 C2 C3 C4 + + +;;<p style=\"margin-top: 0\">" + CampoSimples.identificador + " cm ;;2$$\n");
        sb.append("79;;CampoLogico;;$78CampoNumero;;"+CampoSimples.identificador + "$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 1">

        sb.append("\n80;;Topico;;Feto 1$$\n");

        // <editor-fold defaultstate="collapsed" desc="Feto 1">

        //situação
        sb.append("\n81;;Linha$$\n");
        sb.append("82;;Enumeracao;;").append("Feto em situação ").append(CampoSimples.identificador).append(";;true$$\n");
        //apresentacao
        sb.append("83;;Enumeracao;;").append(", apresentação ").append(CampoSimples.identificador).append(".$$\n");
        sb.append("\n84;;Linha$$\n");
        //dorso
        sb.append("85;;Enumeracao;;").append("Dorso ").append(CampoSimples.identificador).append("$$\n");
        //movimentos fetais
        sb.append("86;;Enumeracao;;").append(", movimentos fetais ").append(CampoSimples.identificador).append(".$$\n");
        //Movimentos respiratórios
        sb.append("\n87;;Linha$$\n");
        sb.append("88;;Enumeracao;;").append("Movimentos respiratórios ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Batimentos cardíacos fetais
        sb.append("\n89;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("90;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Ritmia
        sb.append("91;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        // BPM
        sb.append("92;;CampoInteiro;; de " + CampoSimples.identificador + " bpm;;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos internos">

        sb.append("\n93;;Linha;;<b>Órgãos internos:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("94;;Enumeracao;;<p style=\"margin-top: 0\">").
                append(CampoSimples.identificador).append("</p>;;true$$\n");

        // Descrição
        sb.append("95;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria">

        sb.append("\n96;;Linha;;<b>Biometria:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        //D.B.P (mm)
        sb.append("97;;CampoInteiro;;<p style=\"margin-top: 0\">Diâmetro biparietal de " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // IC
        sb.append("98;;CampoRpn;;C1 100 * C2 /;;<p style=\"margin-top: 0\">Índice cefálico: " + CampoSimples.identificador + ".</p>;;2$$\n");
        // C.A (mm)
        sb.append("99;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        sb.append("100;;CampoRpn;;1.57 C1 C2 + *;;<p style=\"margin-top: 0\">Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.</p>;;0$$\n");
        sb.append("101;;CampoInteiro;;<p style=\"margin-top: 0\">Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // CC
        sb.append("102;;CampoRpn;;C1 C2 + 2 / pi * 1.013 *;;<p style=\"margin-top: 0\">Circunferência craniana fetal: " + CampoSimples.identificador + " mm.</p>;;2$$\n");
        // CC Div CA
        sb.append("103;;CampoRpn;;C1 C2 /;;<p style=\"margin-top: 0\">Circunferência craniana / circunferência abdominal: " + CampoSimples.identificador + ".</p>;;2$$\n");
        //C.F (mm)
        sb.append("104;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento do fêmur: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // CF / CA
        sb.append("105;;CampoRpn;;C1 100 * C2 /;;<p style=\"margin-top: 0\">C.F. / C.A. (Hadlock): " + CampoSimples.identificador + ".</p>;;2$$\n");
        // Umero (mm)
        sb.append("106;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento do úmero: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Ulna (mm)
        sb.append("107;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento da ulna: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Tibia (mm)
        sb.append("108;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento da tíbia: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Peso
        sb.append("109;;CampoRpn;;10 -1.7492 .0166 C1 * + .0046 C2 * + 2.646 C1 C2 * 100000 / * - ^ 1000 *"
                  + ";;<p style=\"margin-top: 0\">Peso fetal provável: " + CampoSimples.identificador + " g (±10%).</p>;;2$$\n");
        // Estatura
        sb.append("110;;CampoRpn;;C1 0.55 *;;<p style=\"margin-top: 0\">Estatura fetal provável: " + CampoSimples.identificador + " cm.</p>;;2$$\n");
        //sexo
        sb.append("111;;Enumeracao;;<p style=\"margin-top: 0\">Sexo fetal provável: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        //gordura
        sb.append("112;;Enumeracao;;<p style=\"margin-top: 0\">Gordura pré-peritoneal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // Estadiamento intestinal
        sb.append("113;;Enumeracao;;<p style=\"margin-top: 0\">Estadiamento intestinal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // D.O.F (mm)
        sb.append("114;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL +";;3$$\n");
        // D.A.P (mm)
        sb.append("115;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");
        // D.L.L (mm)
        sb.append("116;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        sb.append("\n117;;Linha;;<b>Placenta:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        //inserção 1
        sb.append("118;;Enumeracao;;<p style=\"margin-top: 0\">De inserção ").append(CampoSimples.identificador).append(";;true$$\n");
        //insercao 2
        sb.append("119;;Enumeracao;; ").append(CampoSimples.identificador).append(".</p>$$\n");
        //espessura
        sb.append("120;;CampoInteiro;;<p style=\"margin-top: 0\">Espessura: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        //maturidade
        sb.append("121;;Enumeracao;;<p style=\"margin-top: 0\">Apresentando ").append(CampoSimples.identificador).append(" (grannum 0, 1, 2, 3).</p>$$\n");

        // Descrição
        sb.append("122;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras inf">

        //cordão umbilical
        sb.append("\n123;;Linha;;<b>Cordão umbilical:</b></p>").append(
                Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("124;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");

        //liquido amniótico
        sb.append("\n125;;Linha;;<b>Líquido amniótico:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("126;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        //quadrante 1
        sb.append("127;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 2
        sb.append("128;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 3
        sb.append("129;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 4
        sb.append("130;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        // ILA
        sb.append("\n131;;Linha;;<p style=\"margin-top: 0\"><b>Índice do líquido amniótico:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("132;;CampoRpn;;C1 C2 C3 C4 + + +;;<p style=\"margin-top: 0\">" + CampoSimples.identificador + " cm ;;2$$\n");
        sb.append("133;;CampoLogico;;$132CampoNumero;;"+CampoSimples.identificador + "</p>$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 2">

        sb.append("\n134;;Topico;;Feto 2$$\n");

        // <editor-fold defaultstate="collapsed" desc="Feto 2">

        //situação
        sb.append("\n135;;Linha$$\n");
        sb.append("136;;Enumeracao;;").append("Feto em situação ").append(CampoSimples.identificador).append(";;true$$\n");
        //apresentacao
        sb.append("137;;Enumeracao;;").append(", apresentação ").append(CampoSimples.identificador).append(".$$\n");
        sb.append("\n138;;Linha$$\n");
        //dorso
        sb.append("139;;Enumeracao;;").append("Dorso ").append(CampoSimples.identificador).append("$$\n");
        //movimentos fetais
        sb.append("140;;Enumeracao;;").append(", movimentos fetais ").append(CampoSimples.identificador).append(".$$\n");
        //Movimentos respiratórios
        sb.append("\n141;;Linha$$\n");
        sb.append("142;;Enumeracao;;").append("Movimentos respiratórios ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Batimentos cardíacos fetais
        sb.append("\n143;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("144;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Ritmia
        sb.append("145;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        // BPM
        sb.append("146;;CampoInteiro;; de " + CampoSimples.identificador + " bpm;;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="órgãos internos Feto2">

        sb.append("\n147;;Linha;;<b>Órgãos internos:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("148;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");

        // Descrição
        sb.append("149;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria Feto2">
        sb.append("\n150;;Linha;;\n");
        sb.append("<b>Biometria:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //D.B.P (mm)
        sb.append("151;;CampoInteiro;;<p style=\"margin-top: 0\">Diâmetro biparietal de " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // IC
        sb.append("152;;CampoRpn;;C1 100 * C2 /;;<p style=\"margin-top: 0\">Índice cefálico: " + CampoSimples.identificador + ".</p>;;2$$\n");
        // C.A (mm)
        sb.append("153;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        sb.append("154;;CampoRpn;;1.57 C1 C2 + *;;<p style=\"margin-top: 0\">Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.</p>;;0$$\n");
        sb.append("155;;CampoInteiro;;<p style=\"margin-top: 0\">Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // CC
        sb.append("156;;CampoRpn;;C1 C2 + 2 / pi * 1.013 *;;<p style=\"margin-top: 0\">Circunferência craniana fetal: " + CampoSimples.identificador + " mm.</p>;;2$$\n");
        // CC Div CA
        sb.append("157;;CampoRpn;;C1 C2 /;;<p style=\"margin-top: 0\">Circunferência craniana / circunferência abdominal: " + CampoSimples.identificador + ".</p>;;2$$\n");
        //C.F (mm)
        sb.append("158;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento do fêmur: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // CF / CA
        sb.append("159;;CampoRpn;;C1 100 * C2 /;;<p style=\"margin-top: 0\">C.F. / C.A. (Hadlock): " + CampoSimples.identificador + ".</p>;;2$$\n");
        // Umero (mm)
        sb.append("160;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento do úmero: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Ulna (mm)
        sb.append("161;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento da ulna: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Tibia (mm)
        sb.append("162;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento da tíbia: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Peso
        sb.append("163;;CampoRpn;;10 -1.7492 .0166 C1 * + .0046 C2 * + 2.646 C1 C2 * 100000 / * - ^ 1000 *"
                  + ";;<p style=\"margin-top: 0\">Peso fetal provável: " + CampoSimples.identificador + " g (±10%).</p>;;2$$\n");
        // Estatura
        sb.append("164;;CampoRpn;;C1 0.55 *;;<p style=\"margin-top: 0\">Estatura fetal provável: " + CampoSimples.identificador + " cm.</p>;;2$$\n");
        //sexo
        sb.append("165;;Enumeracao;;<p style=\"margin-top: 0\">Sexo fetal provável: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        //gordura
        sb.append("166;;Enumeracao;;<p style=\"margin-top: 0\">Gordura pré-peritoneal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // Estadiamento intestinal
        sb.append("167;;Enumeracao;;<p style=\"margin-top: 0\">Estadiamento intestinal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // D.O.F (mm)
        sb.append("168;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL +";;3$$\n");
        // D.A.P (mm)
        sb.append("169;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");
        // D.L.L (mm)
        sb.append("170;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta Feto2">
        sb.append("\n171;;Linha;;\n");
        sb.append("<b>Placenta:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //inserção 1
        sb.append("172;;Enumeracao;;<p style=\"margin-top: 0\">De inserção ").append(CampoSimples.identificador).append(";;true$$\n");
        //insercao 2
        sb.append("173;;Enumeracao;; ").append(CampoSimples.identificador).append(".</p>$$\n");
        //espessura
        sb.append("174;;CampoInteiro;;<p style=\"margin-top: 0\">Espessura: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        //maturidade
        sb.append("175;;Enumeracao;;<p style=\"margin-top: 0\">Apresentando ").append(CampoSimples.identificador).append(" (grannum 0, 1, 2, 3).</p>$$\n");

        // Descrição
        sb.append("176;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="dados placenta Feto2">
        sb.append("\n177;;Linha;;\n");
        sb.append("<b>Cordão umbilical:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //cordão umbilical
        sb.append("178;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");
        sb.append("\n179;;Linha;;\n");
        sb.append("<b>Líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //liquido amniótico
        sb.append("180;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append(".</p>;;true$$\n");

        //quadrante 1
        sb.append("181;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 2
        sb.append("182;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 3
        sb.append("183;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 4
        sb.append("184;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //soma
         sb.append("\n185;;Linha;;\n");
        sb.append("<b>Índice do líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        sb.append("186;;CampoRpn;;C1 C2 C3 C4 + + +;;<p style=\"margin-top: 0\">" + CampoSimples.identificador + " cm ;;2$$\n");
        sb.append("187;;CampoLogico;;$186CampoNumero;;"+CampoSimples.identificador + "</p>$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 3">

        sb.append("\n188;;Topico;;Feto 3$$\n");

        // <editor-fold defaultstate="collapsed" desc="Feto 3">

        //situação
        sb.append("\n189;;Linha$$\n");
        sb.append("190;;Enumeracao;;").append("Feto em situação ").append(CampoSimples.identificador).append(";;true$$\n");
        //apresentacao
        sb.append("191;;Enumeracao;;").append(", apresentação ").append(CampoSimples.identificador).append(".$$\n");
        sb.append("\n192;;Linha$$\n");
        //dorso
        sb.append("193;;Enumeracao;;").append("Dorso ").append(CampoSimples.identificador).append("$$\n");
        //movimentos fetais
        sb.append("194;;Enumeracao;;").append(", movimentos fetais ").append(CampoSimples.identificador).append(".$$\n");
        //Movimentos respiratórios
        sb.append("\n195;;Linha$$\n");
        sb.append("196;;Enumeracao;;").append("Movimentos respiratórios ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Batimentos cardíacos fetais
        sb.append("\n197;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("198;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Ritmia
        sb.append("199;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        // BPM
        sb.append("200;;CampoInteiro;; de " + CampoSimples.identificador + " bpm;;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="órgãos internos Feto3">

        sb.append("\n201;;Linha;;<b>Órgãos internos:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("202;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");

        // Descrição
        sb.append("203;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria Feto3">
        sb.append("\n204;;Linha;;\n");
        sb.append("<b>Biometria:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //D.B.P (mm)
        sb.append("205;;CampoInteiro;;<p style=\"margin-top: 0\">Diâmetro biparietal de " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // IC
        sb.append("206;;CampoRpn;;C1 100 * C2 /;;<p style=\"margin-top: 0\">Índice cefálico: " + CampoSimples.identificador + ".</p>;;2$$\n");
        // C.A (mm)
        sb.append("207;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        sb.append("208;;CampoRpn;;1.57 C1 C2 + *;;<p style=\"margin-top: 0\">Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.</p>;;0$$\n");
        sb.append("209;;CampoInteiro;;<p style=\"margin-top: 0\">Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // CC
        sb.append("210;;CampoRpn;;C1 C2 + 2 / pi * 1.013 *;;<p style=\"margin-top: 0\">Circunferência craniana fetal: " + CampoSimples.identificador + " mm.</p>;;2$$\n");
        // CC Div CA
        sb.append("211;;CampoRpn;;C1 C2 /;;<p style=\"margin-top: 0\">Circunferência craniana / circunferência abdominal: " + CampoSimples.identificador + " .</p>;;2$$\n");
        //C.F (mm)
        sb.append("212;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento do fêmur: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // CF / CA
        sb.append("213;;CampoRpn;;C1 100 * C2 /;;<p style=\"margin-top: 0\">C.F. / C.A. (Hadlock): " + CampoSimples.identificador + ".</p>;;2$$\n");
        // Umero (mm)
        sb.append("214;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento do úmero: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Ulna (mm)
        sb.append("215;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento da ulna: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Tibia (mm)
        sb.append("216;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento da tíbia: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Peso
        sb.append("217;;CampoRpn;;10 -1.7492 .0166 C1 * + .0046 C2 * + 2.646 C1 C2 * 100000 / * - ^ 1000 *"
                  + ";;<p style=\"margin-top: 0\">Peso fetal provável: " + CampoSimples.identificador + " g (±10%).</p>;;2$$\n");
        // Estatura
        sb.append("218;;CampoRpn;;C1 0.55 *;;<p style=\"margin-top: 0\">Estatura fetal provável: " + CampoSimples.identificador + " cm.</p>;;2$$\n");
        //sexo
        sb.append("219;;Enumeracao;;<p style=\"margin-top: 0\">Sexo fetal provável: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        //gordura
        sb.append("220;;Enumeracao;;<p style=\"margin-top: 0\">Gordura pré-peritoneal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // Estadiamento intestinal
        sb.append("221;;Enumeracao;;<p style=\"margin-top: 0\">Estadiamento intestinal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // D.O.F (mm)
        sb.append("222;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL +";;3$$\n");
        // D.A.P (mm)
        sb.append("223;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");
        // D.L.L (mm)
        sb.append("224;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta Feto3">
        sb.append("\n225;;Linha;;\n");
        sb.append("<b>Placenta:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //inserção 1
        sb.append("226;;Enumeracao;;<p style=\"margin-top: 0\">De inserção ").append(CampoSimples.identificador).append(";;true$$\n");
        //insercao 2
        sb.append("227;;Enumeracao;; ").append(CampoSimples.identificador).append(".</p>$$\n");
        //espessura
        sb.append("228;;CampoInteiro;;<p style=\"margin-top: 0\">Espessura: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        //maturidade
        sb.append("229;;Enumeracao;;<p style=\"margin-top: 0\">Apresentando ").append(CampoSimples.identificador).append(" (grannum 0, 1, 2, 3).</p>$$\n");

        // Descrição
        sb.append("230;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="dados placenta Feto3">
        sb.append("\n231;;Linha;;\n");
        sb.append("<b>Cordão umbilical:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //cordão umbilical
        sb.append("232;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");
        sb.append("\n233;;Linha;;\n");
        sb.append("<b>Líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //liquido amniótico
        sb.append("234;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append(".</p>;;true$$\n");

        //quadrante 1
        sb.append("235;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 2
        sb.append("236;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 3
        sb.append("237;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 4
        sb.append("238;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //soma
         sb.append("\n239;;Linha;;\n");
        sb.append("<b>Índice do líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        sb.append("240;;CampoRpn;;C1 C2 C3 C4 + + +;;<p style=\"margin-top: 0\">" + CampoSimples.identificador + " cm ;;2$$\n");
        sb.append("241;;CampoLogico;;$240CampoNumero;;"+CampoSimples.identificador + "</p>$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 4">

        sb.append("\n242;;Topico;;Feto 4$$\n");

        // <editor-fold defaultstate="collapsed" desc="Feto 4">

        //situação
        sb.append("\n243;;Linha$$\n");
        sb.append("244;;Enumeracao;;").append("Feto em situação ").append(CampoSimples.identificador).append(";;true$$\n");
        //apresentacao
        sb.append("245;;Enumeracao;;").append(", apresentação ").append(CampoSimples.identificador).append(".$$\n");
        sb.append("\n246;;Linha$$\n");
        //dorso
        sb.append("247;;Enumeracao;;").append("Dorso ").append(CampoSimples.identificador).append("$$\n");
        //movimentos fetais
        sb.append("248;;Enumeracao;;").append(", movimentos fetais ").append(CampoSimples.identificador).append(".$$\n");
        //Movimentos respiratórios
        sb.append("\n249;;Linha$$\n");
        sb.append("250;;Enumeracao;;").append("Movimentos respiratórios ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Batimentos cardíacos fetais
        sb.append("\n251;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("252;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Ritmia
        sb.append("253;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        // BPM
        sb.append("254;;CampoInteiro;; de " + CampoSimples.identificador + " bpm;;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="órgãos internos Feto4">
        sb.append("\n255;;Linha;;<b>Órgãos internos:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("256;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");

        // Descrição
        sb.append("257;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria Feto4">
        sb.append("\n258;;Linha;;\n");
        sb.append("<b>Biometria:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //D.B.P (mm)
        sb.append("259;;CampoInteiro;;<p style=\"margin-top: 0\">Diâmetro biparietal de " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // IC
        sb.append("260;;CampoRpn;;C1 100 * C2 /;;<p style=\"margin-top: 0\">Índice cefálico: " + CampoSimples.identificador + ".</p>;;2$$\n");
        // C.A (mm)
        sb.append("261;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        sb.append("262;;CampoRpn;;1.57 C1 C2 + *;;<p style=\"margin-top: 0\">Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.</p>;;0$$\n");
        sb.append("263;;CampoInteiro;;<p style=\"margin-top: 0\">Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // CC
        sb.append("264;;CampoRpn;;C1 C2 + 2 / pi * 1.013 *;;<p style=\"margin-top: 0\">Circunferência craniana fetal: " + CampoSimples.identificador + " mm.</p>;;2$$\n");
        // CC Div CA
        sb.append("265;;CampoRpn;;C1 C2 /;;<p style=\"margin-top: 0\">Circunferência craniana / circunferência abdominal: " + CampoSimples.identificador + ".</p>;;2$$\n");
        //C.F (mm)
        sb.append("266;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento do fêmur: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // CF / CA
        sb.append("267;;CampoRpn;;C1 100 * C2 /;;<p style=\"margin-top: 0\">C.F. / C.A. (Hadlock): " + CampoSimples.identificador + ".</p>;;2$$\n");
        // Umero (mm)
        sb.append("268;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento do úmero: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Ulna (mm)
        sb.append("269;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento da ulna: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Tibia (mm)
        sb.append("270;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento da tíbia: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Peso
        sb.append("271;;CampoRpn;;10 -1.7492 .0166 C1 * + .0046 C2 * + 2.646 C1 C2 * 100000 / * - ^ 1000 *"
                  + ";;<p style=\"margin-top: 0\">Peso fetal provável: " + CampoSimples.identificador + " g (±10%).</p>;;2$$\n");
        // Estatura
        sb.append("272;;CampoRpn;;C1 0.55 *;;<p style=\"margin-top: 0\">Estatura fetal provável: " + CampoSimples.identificador + " cm.</p>;;2$$\n");
        //sexo
        sb.append("273;;Enumeracao;;<p style=\"margin-top: 0\">Sexo fetal provável: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        //gordura
        sb.append("274;;Enumeracao;;<p style=\"margin-top: 0\">Gordura pré-peritoneal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // Estadiamento intestinal
        sb.append("275;;Enumeracao;;<p style=\"margin-top: 0\">Estadiamento intestinal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // D.O.F (mm)
        sb.append("276;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL +";;3$$\n");
        // D.A.P (mm)
        sb.append("277;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");
        // D.L.L (mm)
        sb.append("278;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta Feto4">
        sb.append("\n279;;Linha;;\n");
        sb.append("<b>Placenta:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //inserção 1
        sb.append("280;;Enumeracao;;<p style=\"margin-top: 0\">De inserção ").append(CampoSimples.identificador).append(";;true$$\n");
        //insercao 2
        sb.append("281;;Enumeracao;; ").append(CampoSimples.identificador).append(".</p>$$\n");
        //espessura
        sb.append("282;;CampoInteiro;;<p style=\"margin-top: 0\">Espessura: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        //maturidade
        sb.append("283;;Enumeracao;;<p style=\"margin-top: 0\">Apresentando ").append(CampoSimples.identificador).append(" (grannum 0, 1, 2, 3).</p>$$\n");

        // Descrição
        sb.append("284;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="dados placenta Feto4">
        sb.append("\n285;;Linha;;\n");
        sb.append("<b>Cordão umbilical:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //cordão umbilical
        sb.append("286;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");
        sb.append("\n287;;Linha;;\n");
        sb.append("<b>Líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //liquido amniótico
        sb.append("288;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append(".</p>;;true$$\n");

        //quadrante 1
        sb.append("289;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 2
        sb.append("290;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 3
        sb.append("291;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 4
        sb.append("292;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //soma
        sb.append("\n293;;Linha;;\n");
        sb.append("<b>Índice do líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        sb.append("294;;CampoRpn;;C1 C2 C3 C4 + + +;;<p style=\"margin-top: 0\">" + CampoSimples.identificador + " cm ;;2$$\n");
        sb.append("295;;CampoLogico;;$294CampoNumero;;"+CampoSimples.identificador + "</p>$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 5">

        sb.append("\n296;;Topico;;Feto 5$$\n");

        // <editor-fold defaultstate="collapsed" desc="Feto 5">

        //situação
        sb.append("\n297;;Linha$$\n");
        sb.append("298;;Enumeracao;;").append("Feto em situação ").append(CampoSimples.identificador).append(";;true$$\n");
        //apresentacao
        sb.append("299;;Enumeracao;;").append(", apresentação ").append(CampoSimples.identificador).append(".$$\n");
        sb.append("\n300;;Linha$$\n");
        //dorso
        sb.append("301;;Enumeracao;;").append("Dorso ").append(CampoSimples.identificador).append("$$\n");
        //movimentos fetais
        sb.append("302;;Enumeracao;;").append(", movimentos fetais ").append(CampoSimples.identificador).append(".$$\n");
        //Movimentos respiratórios
        sb.append("\n303;;Linha$$\n");
        sb.append("304;;Enumeracao;;").append("Movimentos respiratórios ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Batimentos cardíacos fetais
        sb.append("\n305;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("306;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Ritmia
        sb.append("307;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        // BPM
        sb.append("308;;CampoInteiro;; de " + CampoSimples.identificador + " bpm;;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="órgãos internos Feto5">
        sb.append("\n309;;Linha;;<b>Órgãos internos:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("310;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");

        // Descrição
        sb.append("311;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria Feto5">
        sb.append("\n312;;Linha;;\n");
        sb.append("<b>Biometria:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //D.B.P (mm)
        sb.append("313;;CampoInteiro;;<p style=\"margin-top: 0\">Diâmetro biparietal de " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // IC
        sb.append("314;;CampoRpn;;C1 100 * C2 /;;<p style=\"margin-top: 0\">Índice cefálico: " + CampoSimples.identificador + ".</p>;;2$$\n");
        // C.A (mm)
        sb.append("315;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        sb.append("316;;CampoRpn;;1.57 C1 C2 + *;;<p style=\"margin-top: 0\">Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.</p>;;0$$\n");
        sb.append("317;;CampoInteiro;;<p style=\"margin-top: 0\">Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // CC
        sb.append("318;;CampoRpn;;C1 C2 + 2 / pi * 1.013 *;;<p style=\"margin-top: 0\">Circunferência craniana fetal: " + CampoSimples.identificador + " mm.</p>;;2$$\n");
        // CC Div CA
        sb.append("319;;CampoRpn;;C1 C2 /;;<p style=\"margin-top: 0\">Circunferência craniana / circunferência abdominal: " + CampoSimples.identificador + ".</p>;;2$$\n");
        //C.F (mm)
        sb.append("320;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento do fêmur: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // CF / CA
        sb.append("321;;CampoRpn;;C1 100 * C2 /;;<p style=\"margin-top: 0\">C.F. / C.A. (Hadlock): " + CampoSimples.identificador + ".</p>;;2$$\n");
        // Umero (mm)
        sb.append("322;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento do úmero: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Ulna (mm)
        sb.append("323;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento da ulna: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Tibia (mm)
        sb.append("324;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento da tíbia: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Peso
        sb.append("325;;CampoRpn;;10 -1.7492 .0166 C1 * + .0046 C2 * + 2.646 C1 C2 * 100000 / * - ^ 1000 *"
                  + ";;<p style=\"margin-top: 0\">Peso fetal provável: " + CampoSimples.identificador + " g (±10%).</p>;;2$$\n");
        // Estatura
        sb.append("326;;CampoRpn;;C1 0.55 *;;<p style=\"margin-top: 0\">Estatura fetal provável: " + CampoSimples.identificador + " cm.</p>;;2$$\n");
        //sexo
        sb.append("327;;Enumeracao;;<p style=\"margin-top: 0\">Sexo fetal provável: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        //gordura
        sb.append("328;;Enumeracao;;<p style=\"margin-top: 0\">Gordura pré-peritoneal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // Estadiamento intestinal
        sb.append("329;;Enumeracao;;<p style=\"margin-top: 0\">Estadiamento intestinal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // D.O.F (mm)
        sb.append("330;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL +";;3$$\n");
        // D.A.P (mm)
        sb.append("331;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");
        // D.L.L (mm)
        sb.append("332;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta Feto5">
        sb.append("\n333;;Linha;;\n");
        sb.append("<b>Placenta:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //inserção 1
        sb.append("334;;Enumeracao;;<p style=\"margin-top: 0\">De inserção ").append(CampoSimples.identificador).append(";;true$$\n");
        //insercao 2
        sb.append("335;;Enumeracao;; ").append(CampoSimples.identificador).append(".</p>$$\n");
        //espessura
        sb.append("336;;CampoInteiro;;<p style=\"margin-top: 0\">Espessura: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        //maturidade
        sb.append("337;;Enumeracao;;<p style=\"margin-top: 0\">Apresentando ").append(CampoSimples.identificador).append(" (grannum 0, 1, 2, 3).</p>$$\n");

        // Descrição
        sb.append("338;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="dados placenta Feto5">
        sb.append("\n339;;Linha;;\n");
        sb.append("<b>Cordão umbilical:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //cordão umbilical
        sb.append("340;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");
        sb.append("\n341;;Linha;;\n");
        sb.append("<b>Líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //liquido amniótico
        sb.append("342;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append(".</p>;;true$$\n");

        //quadrante 1
        sb.append("343;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 2
        sb.append("344;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 3
        sb.append("345;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 4
        sb.append("346;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //soma
         sb.append("\n347;;Linha;;\n");
        sb.append("<b>Índice do líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        sb.append("348;;CampoRpn;;C1 C2 C3 C4 + + +;;<p style=\"margin-top: 0\">" + CampoSimples.identificador + " cm ;;2$$\n");
        sb.append("349;;CampoLogico;;$348CampoNumero;;"+CampoSimples.identificador + "</p>$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 6">

        sb.append("\n350;;Topico;;Feto 6$$\n");

        // <editor-fold defaultstate="collapsed" desc="Feto 6">

        //situação
        sb.append("\n351;;Linha$$\n");
        sb.append("352;;Enumeracao;;").append("Feto em situação ").append(CampoSimples.identificador).append(";;true$$\n");
        //apresentacao
        sb.append("353;;Enumeracao;;").append(", apresentação ").append(CampoSimples.identificador).append(".$$\n");
        sb.append("\n354;;Linha$$\n");
        //dorso
        sb.append("355;;Enumeracao;;").append("Dorso ").append(CampoSimples.identificador).append("$$\n");
        //movimentos fetais
        sb.append("356;;Enumeracao;;").append(", movimentos fetais ").append(CampoSimples.identificador).append(".$$\n");
        //Movimentos respiratórios
        sb.append("\n357;;Linha$$\n");
        sb.append("358;;Enumeracao;;").append("Movimentos respiratórios ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Batimentos cardíacos fetais
        sb.append("\n359;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("360;;Enumeracao;;Batimentos cardíacos fetais ").append(CampoSimples.identificador).append(";;true$$\n");
        // Ritmia
        sb.append("361;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        // BPM
        sb.append("362;;CampoInteiro;; de " + CampoSimples.identificador + " bpm;;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="órgãos internos Feto6">
        sb.append("\n363;;Linha;;<b>Órgãos internos:</b></p>").
                append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("364;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");

        // Descrição
        sb.append("365;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria Feto6">
        sb.append("\n366;;Linha;;\n");
        sb.append("<b>Biometria:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //D.B.P (mm)
        sb.append("367;;CampoInteiro;;<p style=\"margin-top: 0\">Diâmetro biparietal de " + CampoSimples.identificador + " mm. </p>;;3$$\n");
        // IC
        sb.append("368;;CampoRpn;;C1 100 * C2 /;;<p style=\"margin-top: 0\">Índice cefálico: " + CampoSimples.identificador + ".</p>;;2$$\n");
        // C.A (mm)
        sb.append("369;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        sb.append("370;;CampoRpn;;1.57 C1 C2 + *;;<p style=\"margin-top: 0\">Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.</p>;;0$$\n");
        sb.append("371;;CampoInteiro;;<p style=\"margin-top: 0\">Circunferência abdominal fetal: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // CC
        sb.append("372;;CampoRpn;;C1 C2 + 2 / pi * 1.013 *;;<p style=\"margin-top: 0\">Circunferência craniana fetal: " + CampoSimples.identificador + " mm.</p>;;2$$\n");
        // CC Div CA
        sb.append("373;;CampoRpn;;C1 C2 /;;<p style=\"margin-top: 0\">Circunferência craniana / circunferência abdominal: " + CampoSimples.identificador + ".</p>;;2$$\n");
        //C.F (mm)
        sb.append("374;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento do fêmur: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // CF / CA
        sb.append("375;;CampoRpn;;C1 100 * C2 /;;<p style=\"margin-top: 0\">C.F. / C.A. (Hadlock): " + CampoSimples.identificador + ".</p>;;2$$\n");
        // Umero (mm)
        sb.append("376;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento do úmero: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Ulna (mm)
        sb.append("377;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento da ulna: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Tibia (mm)
        sb.append("378;;CampoInteiro;;<p style=\"margin-top: 0\">Comprimento da tíbia: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        // Peso
        sb.append("379;;CampoRpn;;10 -1.7492 .0166 C1 * + .0046 C2 * + 2.646 C1 C2 * 100000 / * - ^ 1000 *"
                  + ";;<p style=\"margin-top: 0\">Peso fetal provável: " + CampoSimples.identificador + " g (±10%).</p>;;2$$\n");
        // Estatura
        sb.append("380;;CampoRpn;;C1 0.55 *;;<p style=\"margin-top: 0\">Estatura fetal provável: " + CampoSimples.identificador + " cm.</p>;;2$$\n");
        //sexo
        sb.append("381;;Enumeracao;;<p style=\"margin-top: 0\">Sexo fetal provável: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        //gordura
        sb.append("382;;Enumeracao;;<p style=\"margin-top: 0\">Gordura pré-peritoneal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // Estadiamento intestinal
        sb.append("383;;Enumeracao;;<p style=\"margin-top: 0\">Estadiamento intestinal: ").append(CampoSimples.identificador).append(".</p>;;true$$\n");
        // D.O.F (mm)
        sb.append("384;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL +";;3$$\n");
        // D.A.P (mm)
        sb.append("385;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");
        // D.L.L (mm)
        sb.append("386;;CampoInteiro;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta Feto6">
        sb.append("\n387;;Linha;;\n");
        sb.append("<b>Placenta:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //inserção 1
        sb.append("388;;Enumeracao;;<p style=\"margin-top: 0\">De inserção ").append(CampoSimples.identificador).append(";;true$$\n");
        //insercao 2
        sb.append("389;;Enumeracao;; ").append(CampoSimples.identificador).append(".</p>$$\n");
        //espessura
        sb.append("390;;CampoInteiro;;<p style=\"margin-top: 0\">Espessura: " + CampoSimples.identificador + " mm.</p>;;3$$\n");
        //maturidade
        sb.append("391;;Enumeracao;;<p style=\"margin-top: 0\">Apresentando ").append(CampoSimples.identificador).append(" (grannum 0, 1, 2, 3).</p>$$\n");

        // Descrição
        sb.append("392;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="dados placenta Feto6">
        sb.append("\n393;;Linha;;\n");
        sb.append("<b>Cordão umbilical:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //cordão umbilical
        sb.append("394;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append("</p>;;true$$\n");
        sb.append("\n395;;Linha;;\n");
        sb.append("<b>Líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        //liquido amniótico
        sb.append("396;;Enumeracao;;<p style=\"margin-top: 0\">").append(CampoSimples.identificador).append(".</p>;;true$$\n");

        //quadrante 1
        sb.append("397;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 2
        sb.append("398;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 3
        sb.append("399;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //quadrante 4
        sb.append("400;;CampoDouble;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");
        //soma
         sb.append("\n401;;Linha;;\n");
        sb.append("<b>Índice do líquido amniótico:</b></p>").append(Linha.TEXTO_CAMPOS_FILHOS);
        sb.append("$$\n");
        sb.append("402;;CampoRpn;;C1 C2 C3 C4 + + +;;<p style=\"margin-top: 0\">" + CampoSimples.identificador + " cm ;;2$$\n");
        sb.append("403;;CampoLogico;;$402CampoNumero;;"+CampoSimples.identificador + "</p>$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("\n404;;Topico;;Observações gerais$$\n");
        sb.append("\n405;;Linha$$\n");
        sb.append("406;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Desvio padrao">

        sb.append("\n407;;Linha$$\n");
        // tipo
        sb.append("408;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        sb.append("\n409;;Linha$$\n");
        sb.append("\n410;;Linha$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("\n411;;Topico;;Impressão diagnóstica$$\n");

        sb.append("\n412;;Linha$$\n");
        sb.append("413;;Label;;").append("Gravidez tópica, com feto único, de $$\n");
        sb.append("414;;Label;;").append("Gravidez tópica, gemelar, de $$\n");
        sb.append("415;;Label;;").append("Gravidez tópica, múltipla com $$\n");
        sb.append("416;;CampoRpn;;C1;;").append(CampoSimples.identificador).append(" fetos, de ;;0$$\n");
        // Semanas IGH
        sb.append("417;;CampoInteiro;;").append(CampoSimples.identificador).append(";;2$$\n");
        sb.append("418;;Label;;").append(" semanas $$\n");
        sb.append("419;;Label;;$$\n");
        // Dias IGH
        sb.append("420;;CampoInteiro;; e ").append(CampoSimples.identificador).append(" dia(s);;1$$\n");
        sb.append("421;;Label;;$$\n");
        sb.append("422;;CampoLogico;; (± " + identificador + " semana(s)).$$\n");
        sb.append("423;;CampoDouble;; (± "+ CampoSimples.identificador + " semana(s)).;;1$$\n");

        sb.append("\n424;;Linha$$\n");
        sb.append("425;;ImpressaoDiagnostica;;$412CampoDoLaudo$$\n");

        sb.append("\n426;;Linha$$\n");
        sb.append("427;;Enumeracao;;$425CampoTexto$$\n");

        sb.append("\n428;;Linha$$\n");
        sb.append("429;;CampoRpnData;;").append("Tempo de amenorreia: ").
                append(CampoSimples.identificador).append(";;C1 C2 - ").
                append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 /$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outros">

        //diasIghDum
        sb.append("430;;CampoRpnData;;").append(" semanas e ").append(CampoSimples.identificador).append(" dia(s).;;C1 C2 - "
                  + "").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 %$$\n");

        //dppPeloValorInformado
         sb.append("431;;CampoRpnData;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;C1 280 "
                + "").append(CampoRpnData.UM_DIA_EM_MS).append(" * + C2 7 ")
        .append(CampoRpnData.UM_DIA_EM_MS).append(" * * - C3 ").append(CampoRpnData.UM_DIA_EM_MS).append(" * -$$\n");

         // dias totais da igh informado pelo usuario
        sb.append("432;;CampoRpn;;C1 7 * C2 +;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;0$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="IGH pela biometria">

        // <editor-fold defaultstate="collapsed" desc="Feto 1">

        // Fêmur
        sb.append("433;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$50CampoDoLaudo|$104CampoDoLaudo}$$\n");
        // Úmero
        sb.append("434;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$52CampoDoLaudo|$106CampoDoLaudo}$$\n");
        // Ulna
        sb.append("435;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$53CampoDoLaudo|$107CampoDoLaudo}$$\n");
        // Tíbia
        sb.append("436;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$54CampoDoLaudo|$108CampoDoLaudo}$$\n");

        // D.B.P.
        sb.append("437;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$43CampoDoLaudo|$97CampoDoLaudo}$$\n");

        // C.A.
        sb.append("438;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL +
                  ";;{$46CampoDoLaudo|$47CampoDoLaudo|$100CampoDoLaudo|$101CampoDoLaudo}$$\n");

        // C.C.
        sb.append("439;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$48CampoDoLaudo|$102CampoDoLaudo}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 2">

        // Fêmur
        sb.append("440;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$158CampoDoLaudo}$$\n");
        // Úmero
        sb.append("441;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$160CampoDoLaudo}$$\n");
        // Ulna
        sb.append("442;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$161CampoDoLaudo}$$\n");
        // Tíbia
        sb.append("443;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$162CampoDoLaudo}$$\n");

        // D.B.P.
        sb.append("444;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$151CampoDoLaudo}$$\n");

        // C.A.
        sb.append("445;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$154CampoDoLaudo|$155CampoDoLaudo}$$\n");

        // C.C.
        sb.append("446;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$156CampoDoLaudo}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 3">

        // Fêmur
        sb.append("447;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$212CampoDoLaudo}$$\n");
        // Úmero
        sb.append("448;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$214CampoDoLaudo}$$\n");
        // Ulna
        sb.append("449;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$215CampoDoLaudo}$$\n");
        // Tíbia
        sb.append("450;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$216CampoDoLaudo}$$\n");

        // D.B.P.
        sb.append("451;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$205CampoDoLaudo}$$\n");

        // C.A.
        sb.append("452;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$208CampoDoLaudo|$209CampoDoLaudo}$$\n");

        // C.C.
        sb.append("453;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$210CampoDoLaudo}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 4">

        // Fêmur
        sb.append("454;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$266CampoDoLaudo}$$\n");
        // Úmero
        sb.append("455;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$268CampoDoLaudo}$$\n");
        // Ulna
        sb.append("456;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$269CampoDoLaudo}$$\n");
        // Tíbia
        sb.append("457;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$270CampoDoLaudo}$$\n");

        // D.B.P.
        sb.append("458;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$259CampoDoLaudo}$$\n");

        // C.A.
        sb.append("459;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$262CampoDoLaudo|$263CampoDoLaudo}$$\n");

        // C.C.
        sb.append("460;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$264CampoDoLaudo}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 5">

        // Fêmur
        sb.append("461;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$320CampoDoLaudo}$$\n");
        // Úmero
        sb.append("462;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$322CampoDoLaudo}$$\n");
        // Ulna
        sb.append("463;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$323CampoDoLaudo}$$\n");
        // Tíbia
        sb.append("464;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$324CampoDoLaudo}$$\n");

        // D.B.P.
        sb.append("465;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$313CampoDoLaudo}$$\n");

        // C.A.
        sb.append("466;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$316CampoDoLaudo|$317CampoDoLaudo}$$\n");

        // C.C.
        sb.append("467;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$318CampoDoLaudo}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 6">

        // Fêmur
        sb.append("468;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$374CampoDoLaudo}$$\n");
        // Úmero
        sb.append("469;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$376CampoDoLaudo}$$\n");
        // Ulna
        sb.append("470;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$377CampoDoLaudo}$$\n");
        // Tíbia
        sb.append("471;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$378CampoDoLaudo}$$\n");

        // D.B.P.
        sb.append("472;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$367CampoDoLaudo}$$\n");

        // C.A.
        sb.append("473;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$370CampoDoLaudo|$371CampoDoLaudo}$$\n");

        // C.C.
        sb.append("474;;CampoLogicoTexto;;" + CampoSimples.NAO_IMPRIMIVEL + ";;{$372CampoDoLaudo}$$\n");

        // </editor-fold>

        // </editor-fold>

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

        sb.append("\n412;;setImprimivel;;false$$\n");

        sb.append("\n408;;adicionarOpcao;;padrão clássico$$\n");
        sb.append("408;;adicionarOpcao;;definido$$\n");

        sb.append("\n413;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("414;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2}$$\n");
        sb.append("415;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("416;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("416;;cadastrarParametroFormula;;$8CampoNumero$$\n");

        sb.append("\n422;;vincularHabAoValorDoCampo;;$408CampoDoLaudo;;false;;{padrão clássico}$$\n");
        sb.append("422;;cadastrarLogica;;(/s).;;").append(CampoLogico.INTERVALO).append(";;{0.00|0.1}$$\n");
        sb.append("422;;cadastrarLogica;;(/s)0,5;;").append(CampoLogico.INTERVALO).append(";;{0.00|105.00}$$\n");
        sb.append("422;;cadastrarLogica;;(/s)1,0;;").append(CampoLogico.INTERVALO).append(";;{105.00|161.00}$$\n");
        sb.append("422;;cadastrarLogica;;(/s)1,5;;").append(CampoLogico.INTERVALO).append(";;{161.00|203.00}$$\n");
        sb.append("422;;cadastrarLogica;;(/s)2,0;;").append(CampoLogico.INTERVALO).append(";;{203.00|245.00}$$\n");
        sb.append("422;;cadastrarLogica;;(/s)2,5;;").append(CampoLogico.INTERVALO).append(";;{245.00|266.00}$$\n");
        sb.append("422;;cadastrarLogica;;(/s)3,0;;").append(CampoLogico.INTERVALO).append(";;{266.00|999.00}$$\n");
        sb.append("422;;setDependencia;;$432CampoNumero$$\n");

        sb.append("\n423;;vincularHabAoValorDoCampo;;$408CampoDoLaudo;;false;;{definido}$$\n");

        sb.append("\n432;;cadastrarParametroFormula;;$417CampoNumero$$\n");
        sb.append("432;;cadastrarParametroFormula;;$420CampoNumero$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Metodos diversos">

        sb.append("15;;setObrigatorio;;false$$\n");
        sb.append("19;;setObrigatorio;;false$$\n");
        sb.append("20;;setObrigatorio;;false$$\n");
        sb.append("21;;setObrigatorio;;false$$\n");
        sb.append("406;;setObrigatorio;;false$$\n");

        //dppPeloValorInformado
        sb.append("\n431;;cadastrarParamFormula;;$13CampoDoLaudo$$\n");
        sb.append("431;;cadastrarParamFormula;;$417CampoDoLaudo$$\n");
        sb.append("431;;cadastrarParamFormula;;$420CampoDoLaudo$$\n");

        //diasIghDum
        sb.append("\n429;;cadastrarParamFormula;;$13CampoDoLaudo$$\n");
        sb.append("429;;cadastrarParamFormula;;$15CampoDoLaudo$$\n");
        //semanaIghDum
        sb.append("\n430;;cadastrarParamFormula;;$13CampoDoLaudo$$\n");
        sb.append("430;;cadastrarParamFormula;;$15CampoDoLaudo$$\n");

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
        sb.append("\n57;;adicionarOpcao;;masculino$$\n");
        sb.append("57;;adicionarOpcao;;feminino$$\n");
        sb.append("57;;adicionarOpcao;;não visualizado$$\n");
        sb.append("57;;adicionarOpcao;;não impresso a pedido (masculino)$$\n");
        sb.append("57;;adicionarOpcao;;não impresso a pedido (feminino)$$\n");
        sb.append("57;;adicionarExcecao;;não impresso a pedido (masculino);;$$\n");
        sb.append("57;;adicionarExcecao;;não impresso a pedido (feminino);;$$\n");

        // gordura Peritonial
        sb.append("\n58;;adicionarOpcao;;presente$$\n");
        sb.append("58;;adicionarOpcao;;ausente$$\n");

        // estadiamento Intestinal
        sb.append("\n59;;adicionarOpcao;;grau I$$\n");
        sb.append("59;;adicionarOpcao;;grau II$$\n");
        sb.append("59;;adicionarOpcao;;grau III$$\n");
        sb.append("59;;adicionarOpcao;;grau IV$$\n");

        // Órgãos internos
        sb.append("40;;adicionarOpcao;;normal;;Sem alterações visíveis.$$\n");
        sb.append("40;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("40;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("41;;vincularHabAoValorDoCampo;;$40CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        // ILA
        sb.append("\n79;;cadastrarLogica;;;;").append(CampoLogico.INTERVALO).append(";;{0.00|0.01}$$\n");
        sb.append("79;;cadastrarLogica;;(Oligoâmnio - ILA está entre 0,00 e 5,00).;;").append(CampoLogico.INTERVALO).append(";;{0.0|5.0}$$\n");
        sb.append("79;;cadastrarLogica;;(Reduzido - ILA está entre 5,00 e 8,00).;;").append(CampoLogico.INTERVALO).append(";;{5.0|8.0}$$\n");
        sb.append("79;;cadastrarLogica;;(Normal - ILA está entre 8,00 e 22,00).;;").append(CampoLogico.INTERVALO).append(";;{8.0|22.0}$$\n");
        sb.append("79;;cadastrarLogica;;(Aumentado - ILA está entre 22,00 e 25,00).;;").append(CampoLogico.INTERVALO).append(";;{22.0|25.0}$$\n");
        sb.append("79;;cadastrarLogica;;(Poliidrâmnio - ILA é maior ou igual a 25,00).;;").append(CampoLogico.INTERVALO).append(";;{25.0|999.00}$$\n");

        //cordão umbilical
        sb.append("\n70;;adicionarOpcao;;normal;;Com duas artérias e uma veia normoinserida.$$\n");
        sb.append("70;;adicionarOpcao;;artéria única;;Artéria única.$$\n");
        sb.append("70;;adicionarOpcao;;não visualizado;;Não visualizado.$$\n");

        //liquido Amniotico
        sb.append("\n72;;adicionarOpcao;;Normal$$\n");
        sb.append("72;;adicionarOpcao;;Aumento leve$$\n");
        sb.append("72;;adicionarOpcao;;Aumento moderado$$\n");
        sb.append("72;;adicionarOpcao;;Aumento acentuado$$\n");
        sb.append("72;;adicionarOpcao;;Diminuição leve$$\n");
        sb.append("72;;adicionarOpcao;;Diminuição moderada$$\n");
        sb.append("72;;adicionarOpcao;;Diminuição acentuada$$\n");
        sb.append("72;;vincularHabAoValorDoCampo;;$64CampoDoLaudo;;{").append(Enumeracao.NAO_IMPRIMIR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        //insercao
        sb.append("\n64;;adicionarOpcao;;tópica$$\n");
        sb.append("64;;adicionarOpcao;;heterotópica$$\n");
        sb.append("64;;adicionarOpcao;;prévia marginal$$\n");
        sb.append("64;;adicionarOpcao;;prévia centro parcial$$\n");
        sb.append("64;;adicionarOpcao;;prévia centro total$$\n");
        sb.append("64;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("64;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        //insercao 2
        sb.append("\n65;;adicionarOpcao;;anterior$$\n");
        sb.append("65;;adicionarOpcao;;posterior$$\n");
        sb.append("65;;adicionarOpcao;;fúndica$$\n");
        sb.append("65;;adicionarOpcao;;fúndica anterior$$\n");
        sb.append("65;;adicionarOpcao;;fúndica posterior$$\n");
        sb.append("65;;adicionarOpcao;;anterior lateral direita$$\n");
        sb.append("65;;adicionarOpcao;;anterior lateral esquerda$$\n");
        sb.append("65;;adicionarOpcao;;posterior lateral direita$$\n");
        sb.append("65;;adicionarOpcao;;posterior lateral esquerda$$\n");
        sb.append("65;;vincularHabAoValorDoCampo;;$64CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //espessura
        sb.append("66;;vincularHabAoValorDoCampo;;$64CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //maturidade
        sb.append("\n67;;adicionarOpcao;;grau 0;;textura homogênea e maturidade grau 0$$\n");
        sb.append("67;;adicionarOpcao;;grau 1;;textura heterogênea e maturidade grau 1$$\n");
        sb.append("67;;adicionarOpcao;;grau 2;;textura heterogênea e maturidade grau 2$$\n");
        sb.append("67;;adicionarOpcao;;grau 3;;maturidade grau 3$$\n");
        sb.append("67;;vincularHabAoValorDoCampo;;$64CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");
        sb.append("67;;setComecarDoZero;;").append(Enumeracao.COMECAR_DO_ZERO_SIM).append("$$\n");

        // Descrição
        sb.append("68;;vincularObrigatorio;;$64CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("68;;vincularHabAoValorDoCampo;;$64CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total|" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria">

        //campo soma biometria
        sb.append("\n78;;cadastrarParametroFormula;;$73CampoNumero$$\n");
        sb.append("78;;cadastrarParametroFormula;;$74CampoNumero$$\n");
        sb.append("78;;cadastrarParametroFormula;;$75CampoNumero$$\n");
        sb.append("78;;cadastrarParametroFormula;;$76CampoNumero$$\n");

        //ic
        sb.append("\n44;;cadastrarParametroFormula;;$43CampoNumero$$\n");
        sb.append("44;;cadastrarParametroFormula;;$60CampoNumero$$\n");
        //cc
        sb.append("\n48;;cadastrarParametroFormula;;$43CampoNumero$$\n");
        sb.append("48;;cadastrarParametroFormula;;$60CampoNumero$$\n");

        //ca
        sb.append("\n45;;adicionarOpcao;;informar$$\n");
        sb.append("45;;adicionarOpcao;;calcular$$\n");
        sb.append("45;;setValor;;informar$$\n");

        sb.append("\n46;;cadastrarParametroFormula;;$61CampoNumero$$\n");
        sb.append("46;;cadastrarParametroFormula;;$62CampoNumero$$\n");
        sb.append("46;;vincularHabAoValorDoCampo;;$45CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("47;;vincularHabAoValorDoCampo;;$45CampoDoLaudo;;false;;{informar}$$\n");

        sb.append("61;;vincularHabAoValorDoCampo;;$45CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("62;;vincularHabAoValorDoCampo;;$45CampoDoLaudo;;false;;{calcular}$$\n");

        //ccDivca
        sb.append("\n49;;cadastrarParametroFormula;;$48CampoNumero$$\n");
        sb.append("49;;cadastrarParametroFormula;;$46CampoNumero$$\n");
        sb.append("49;;cadastrarParametroFormula;;$47CampoNumero;;2$$\n");
        //cfDivca
        sb.append("\n51;;cadastrarParametroFormula;;$50CampoNumero$$\n");
        sb.append("51;;cadastrarParametroFormula;;$46CampoNumero$$\n");
        sb.append("51;;cadastrarParametroFormula;;$47CampoNumero;;2$$\n");
        //peso fetal
        sb.append("\n55;;cadastrarParametroFormula;;$43CampoNumero$$\n");
        sb.append("55;;cadastrarParametroFormula;;$46CampoNumero$$\n");
        sb.append("55;;cadastrarParametroFormula;;$47CampoNumero;;2$$\n");
        //estatuta fetal
        sb.append("\n56;;cadastrarParametroFormula;;$43CampoNumero$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 1">

        sb.append("80;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");

        // <editor-fold defaultstate="collapsed" desc="Dados do feto">

        // situação
        sb.append("\n82;;adicionarOpcao;;longitudinal$$\n");
        sb.append("82;;adicionarOpcao;;transversal com polo cefálico à direita$$\n");
        sb.append("82;;adicionarOpcao;;transversal com polo cefálico à esquerda$$\n");
        sb.append("82;;adicionarOpcao;;oblíqua$$\n");
        sb.append("82;;adicionarOpcao;;indiferente$$\n");

        // apresentacao
        sb.append("\n83;;adicionarOpcao;;cefálica$$\n");
        sb.append("83;;adicionarOpcao;;pélvica$$\n");
        sb.append("83;;adicionarOpcao;;córmica$$\n");
        sb.append("83;;adicionarOpcao;;indiferente$$\n");
        sb.append("83;;vincularHabAoValorDoCampo;;$82CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // dorso
        sb.append("\n85;;adicionarOpcao;;à esquerda$$\n");
        sb.append("85;;adicionarOpcao;;à direita$$\n");
        sb.append("85;;adicionarOpcao;;anterior$$\n");
        sb.append("85;;adicionarOpcao;;posterior$$\n");
        sb.append("85;;adicionarOpcao;;superior$$\n");
        sb.append("85;;adicionarOpcao;;inferior$$\n");
        sb.append("85;;adicionarOpcao;;indiferente$$\n");
        sb.append("85;;vincularHabAoValorDoCampo;;$82CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // movimentos fetais
        sb.append("\n86;;adicionarOpcao;;presentes$$\n");
        sb.append("86;;adicionarOpcao;;ausentes$$\n");
        sb.append("86;;vincularHabAoValorDoCampo;;$82CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //movimentos respiratorios
        sb.append("\n88;;adicionarOpcao;;presentes$$\n");
        sb.append("88;;adicionarOpcao;;ausentes$$\n");
        sb.append("88;;adicionarOpcao;;não visualizados$$\n");
        sb.append("88;;vincularHabAoValorDoCampo;;$82CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // batimentos cardiacos
        sb.append("\n90;;adicionarOpcao;;presentes;;$$\n");
        sb.append("90;;adicionarOpcao;;ausentes$$\n");
        sb.append("90;;adicionarOpcao;;não visualizados$$\n");
        sb.append("90;;vincularHabAoValorDoCampo;;$82CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //ritmia
        sb.append("\n91;;adicionarOpcao;;rítmicos$$\n");
        sb.append("91;;adicionarOpcao;;arrítmicos$$\n");
        sb.append("91;;vincularHabAoValorDoCampo;;$90CampoDoLaudo;;false;;{presentes}$$\n");

        //numero batimentos / min
        sb.append("92;;vincularHabAoValorDoCampo;;$90CampoDoLaudo;;false;;{presentes}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos internos">

        // sexo
        sb.append("\n111;;adicionarOpcao;;masculino$$\n");
        sb.append("111;;adicionarOpcao;;feminino$$\n");
        sb.append("111;;adicionarOpcao;;não visualizado$$\n");
        sb.append("111;;adicionarOpcao;;não impresso a pedido (masculino)$$\n");
        sb.append("111;;adicionarOpcao;;não impresso a pedido (feminino)$$\n");
        sb.append("111;;adicionarExcecao;;não impresso a pedido (masculino);;$$\n");
        sb.append("111;;adicionarExcecao;;não impresso a pedido (feminino);;$$\n");

        //gordura Peritonial
        sb.append("\n112;;adicionarOpcao;;presente$$\n");
        sb.append("112;;adicionarOpcao;;ausente$$\n");

        //estadiamento Instestinal
        sb.append("\n113;;adicionarOpcao;;grau I$$\n");
        sb.append("113;;adicionarOpcao;;grau II$$\n");
        sb.append("113;;adicionarOpcao;;grau III$$\n");
        sb.append("113;;adicionarOpcao;;grau IV$$\n");

        // Órgãos internos
        sb.append("94;;adicionarOpcao;;normal;;Sem alterações visíveis.$$\n");
        sb.append("94;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("94;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("95;;vincularHabAoValorDoCampo;;$94CampoDoLaudo;;false;;{").append(""+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        // ILA
        sb.append("\n133;;cadastrarLogica;;;;").append(CampoLogico.INTERVALO).append(";;{0.00|0.01}$$\n");
        sb.append("133;;cadastrarLogica;;(Oligoâmnio - ILA está entre 0,00 e 5,00).;;").append(CampoLogico.INTERVALO).append(";;{0.0|5.0}$$\n");
        sb.append("133;;cadastrarLogica;;(Reduzido - ILA está entre 5,00 e 8,00).;;").append(CampoLogico.INTERVALO).append(";;{5.0|8.0}$$\n");
        sb.append("133;;cadastrarLogica;;(Normal - ILA está entre 8,00 e 22,00).;;").append(CampoLogico.INTERVALO).append(";;{8.0|22.0}$$\n");
        sb.append("133;;cadastrarLogica;;(Aumentado - ILA está entre 22,00 e 25,00).;;").append(CampoLogico.INTERVALO).append(";;{22.0|25.0}$$\n");
        sb.append("133;;cadastrarLogica;;(Poliidrâmnio - ILA é maior ou igual a 25,00).;;").append(CampoLogico.INTERVALO).append(";;{25.0|999.00}$$\n");

        //cordão umbilical
        sb.append("\n124;;adicionarOpcao;;normal;;Com duas artérias e uma veia normoinserida.$$\n");
        sb.append("124;;adicionarOpcao;;artéria única;;Artéria única.$$\n");
        sb.append("124;;adicionarOpcao;;não visualizado;;Não visualizado.$$\n");

        //liquido Amniotico
        sb.append("\n126;;adicionarOpcao;;Normal$$\n");
        sb.append("126;;adicionarOpcao;;Aumento leve$$\n");
        sb.append("126;;adicionarOpcao;;Aumento moderado$$\n");
        sb.append("126;;adicionarOpcao;;Aumento acentuado$$\n");
        sb.append("126;;adicionarOpcao;;Diminuição leve$$\n");
        sb.append("126;;adicionarOpcao;;Diminuição moderada$$\n");
        sb.append("126;;adicionarOpcao;;Diminuição acentuada$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria">

        //campo soma biometria
        sb.append("\n132;;cadastrarParametroFormula;;$127CampoNumero$$\n");
        sb.append("132;;cadastrarParametroFormula;;$128CampoNumero$$\n");
        sb.append("132;;cadastrarParametroFormula;;$129CampoNumero$$\n");
        sb.append("132;;cadastrarParametroFormula;;$130CampoNumero$$\n");

        //ic
        sb.append("\n98;;cadastrarParametroFormula;;$97CampoNumero$$\n");
        sb.append("98;;cadastrarParametroFormula;;$114CampoNumero$$\n");
        //cc
        sb.append("\n102;;cadastrarParametroFormula;;$97CampoNumero$$\n");
        sb.append("102;;cadastrarParametroFormula;;$114CampoNumero$$\n");

        //ca

        sb.append("\n99;;adicionarOpcao;;informar$$\n");
        sb.append("99;;adicionarOpcao;;calcular$$\n");
        sb.append("99;;setValor;;informar$$\n");

        sb.append("\n100;;cadastrarParametroFormula;;$115CampoNumero$$\n");
        sb.append("100;;cadastrarParametroFormula;;$116CampoNumero$$\n");
        sb.append("100;;vincularHabAoValorDoCampo;;$99CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("101;;vincularHabAoValorDoCampo;;$99CampoDoLaudo;;false;;{informar}$$\n");

        sb.append("115;;vincularHabAoValorDoCampo;;$99CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("116;;vincularHabAoValorDoCampo;;$99CampoDoLaudo;;false;;{calcular}$$\n");

        //ccDivca
        sb.append("\n103;;cadastrarParametroFormula;;$102CampoNumero$$\n");
        sb.append("103;;cadastrarParametroFormula;;$100CampoNumero$$\n");
        sb.append("103;;cadastrarParametroFormula;;$101CampoNumero;;2$$\n");
        //cfDivca
        sb.append("\n105;;cadastrarParametroFormula;;$104CampoNumero$$\n");
        sb.append("105;;cadastrarParametroFormula;;$100CampoNumero$$\n");
        sb.append("105;;cadastrarParametroFormula;;$101CampoNumero;;2$$\n");
        //peso fetal
        sb.append("\n109;;cadastrarParametroFormula;;$97CampoNumero$$\n");
        sb.append("109;;cadastrarParametroFormula;;$100CampoNumero$$\n");
        sb.append("109;;cadastrarParametroFormula;;$101CampoNumero;;2$$\n");
        //estatuta fetal
        sb.append("\n110;;cadastrarParametroFormula;;$97CampoNumero$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        //insercao
        sb.append("\n118;;adicionarOpcao;;tópica$$\n");
        sb.append("118;;adicionarOpcao;;heterotópica$$\n");
        sb.append("118;;adicionarOpcao;;prévia marginal$$\n");
        sb.append("118;;adicionarOpcao;;prévia centro parcial$$\n");
        sb.append("118;;adicionarOpcao;;prévia centro total$$\n");
        sb.append("118;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("118;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        //insercao 2
        sb.append("\n119;;adicionarOpcao;;anterior$$\n");
        sb.append("119;;adicionarOpcao;;posterior$$\n");
        sb.append("119;;adicionarOpcao;;fúndica$$\n");
        sb.append("119;;adicionarOpcao;;fúndica anterior$$\n");
        sb.append("119;;adicionarOpcao;;fúndica posterior$$\n");
        sb.append("119;;adicionarOpcao;;anterior lateral direita$$\n");
        sb.append("119;;adicionarOpcao;;anterior lateral esquerda$$\n");
        sb.append("119;;adicionarOpcao;;posterior lateral direita$$\n");
        sb.append("119;;adicionarOpcao;;posterior lateral esquerda$$\n");
        sb.append("119;;vincularHabAoValorDoCampo;;$118CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //espesssura
        sb.append("120;;vincularHabAoValorDoCampo;;$118CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //maturidade
        sb.append("\n121;;adicionarOpcao;;grau 0;;textura homogênea e maturidade grau 0$$\n");
        sb.append("121;;adicionarOpcao;;grau 1;;textura heterogênea e maturidade grau 1$$\n");
        sb.append("121;;adicionarOpcao;;grau 2;;textura heterogênea e maturidade grau 2$$\n");
        sb.append("121;;adicionarOpcao;;grau 3;;maturidade grau 3$$\n");
        sb.append("121;;vincularHabAoValorDoCampo;;$118CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");
        sb.append("121;;setComecarDoZero;;").append(Enumeracao.COMECAR_DO_ZERO_SIM).append("$$\n");

        // Descrição
        sb.append("122;;vincularObrigatorio;;$118CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("122;;vincularHabAoValorDoCampo;;$118CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total|" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 2">

        sb.append("134;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");

        // <editor-fold defaultstate="collapsed" desc="Dados do feto">

        // situação
        sb.append("\n136;;adicionarOpcao;;longitudinal$$\n");
        sb.append("136;;adicionarOpcao;;transversal com polo cefálico à direita$$\n");
        sb.append("136;;adicionarOpcao;;transversal com polo cefálico à esquerda$$\n");
        sb.append("136;;adicionarOpcao;;oblíqua$$\n");
        sb.append("136;;adicionarOpcao;;indiferente$$\n");

        // apresentacao
        sb.append("\n137;;adicionarOpcao;;cefálica$$\n");
        sb.append("137;;adicionarOpcao;;pélvica$$\n");
        sb.append("137;;adicionarOpcao;;córmica$$\n");
        sb.append("137;;adicionarOpcao;;indiferente$$\n");
        sb.append("137;;vincularHabAoValorDoCampo;;$136CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // dorso
        sb.append("\n139;;adicionarOpcao;;à esquerda$$\n");
        sb.append("139;;adicionarOpcao;;à direita$$\n");
        sb.append("139;;adicionarOpcao;;anterior$$\n");
        sb.append("139;;adicionarOpcao;;posterior$$\n");
        sb.append("139;;adicionarOpcao;;superior$$\n");
        sb.append("139;;adicionarOpcao;;inferior$$\n");
        sb.append("139;;adicionarOpcao;;indiferente$$\n");
        sb.append("139;;vincularHabAoValorDoCampo;;$136CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // movimentos fetais
        sb.append("\n140;;adicionarOpcao;;presentes$$\n");
        sb.append("140;;adicionarOpcao;;ausentes$$\n");
        sb.append("140;;vincularHabAoValorDoCampo;;$136CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //movimentos respiratorios
        sb.append("\n142;;adicionarOpcao;;presentes$$\n");
        sb.append("142;;adicionarOpcao;;ausentes$$\n");
        sb.append("142;;adicionarOpcao;;não visualizados$$\n");
        sb.append("142;;vincularHabAoValorDoCampo;;$136CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // batimentos cardiacos
        sb.append("\n144;;adicionarOpcao;;presentes;;$$\n");
        sb.append("144;;adicionarOpcao;;ausentes$$\n");
        sb.append("144;;adicionarOpcao;;não visualizados$$\n");
        sb.append("144;;vincularHabAoValorDoCampo;;$136CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //ritmia
        sb.append("\n145;;adicionarOpcao;;rítmicos$$\n");
        sb.append("145;;adicionarOpcao;;arrítmicos$$\n");
        sb.append("145;;vincularHabAoValorDoCampo;;$144CampoDoLaudo;;false;;{presentes}$$\n");

        //numero batimentos / min
        sb.append("146;;vincularHabAoValorDoCampo;;$144CampoDoLaudo;;false;;{presentes}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos internos">

        // sexo
        sb.append("\n165;;adicionarOpcao;;masculino$$\n");
        sb.append("165;;adicionarOpcao;;feminino$$\n");
        sb.append("165;;adicionarOpcao;;não visualizado$$\n");
        sb.append("165;;adicionarOpcao;;não impresso a pedido (masculino)$$\n");
        sb.append("165;;adicionarOpcao;;não impresso a pedido (feminino)$$\n");
        sb.append("165;;adicionarExcecao;;não impresso a pedido (masculino);;$$\n");
        sb.append("165;;adicionarExcecao;;não impresso a pedido (feminino);;$$\n");

        //gordura Peritonial
        sb.append("\n166;;adicionarOpcao;;presente$$\n");
        sb.append("166;;adicionarOpcao;;ausente$$\n");

        //estadiamento Instestinal
        sb.append("\n167;;adicionarOpcao;;grau I$$\n");
        sb.append("167;;adicionarOpcao;;grau II$$\n");
        sb.append("167;;adicionarOpcao;;grau III$$\n");
        sb.append("167;;adicionarOpcao;;grau IV$$\n");

        // Órgãos internos
        sb.append("148;;adicionarOpcao;;normal;;Sem alterações visíveis.$$\n");
        sb.append("148;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("148;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("149;;vincularHabAoValorDoCampo;;$148CampoDoLaudo;;false;;{").append(""+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        // ILA
        sb.append("\n187;;cadastrarLogica;;;;").append(CampoLogico.INTERVALO).append(";;{0.00|0.01}$$\n");
        sb.append("187;;cadastrarLogica;;(Oligoâmnio - ILA está entre 0,00 e 5,00).;;").append(CampoLogico.INTERVALO).append(";;{0.0|5.0}$$\n");
        sb.append("187;;cadastrarLogica;;(Reduzido - ILA está entre 5,00 e 8,00).;;").append(CampoLogico.INTERVALO).append(";;{5.0|8.0}$$\n");
        sb.append("187;;cadastrarLogica;;(Normal - ILA está entre 8,00 e 22,00).;;").append(CampoLogico.INTERVALO).append(";;{8.0|22.0}$$\n");
        sb.append("187;;cadastrarLogica;;(Aumentado - ILA está entre 22,00 e 25,00).;;").append(CampoLogico.INTERVALO).append(";;{22.0|25.0}$$\n");
        sb.append("187;;cadastrarLogica;;(Poliidrâmnio - ILA é maior ou igual a 25,00).;;").append(CampoLogico.INTERVALO).append(";;{25.0|999.00}$$\n");

        //cordão umbilical
        sb.append("\n178;;adicionarOpcao;;normal;;Com duas artérias e uma veia normoinserida.$$\n");
        sb.append("178;;adicionarOpcao;;artéria única;;Artéria única.$$\n");
        sb.append("178;;adicionarOpcao;;não visualizado;;Não visualizado.$$\n");

        //liquido Amniotico
        sb.append("\n180;;adicionarOpcao;;Normal$$\n");
        sb.append("180;;adicionarOpcao;;Aumento leve$$\n");
        sb.append("180;;adicionarOpcao;;Aumento moderado$$\n");
        sb.append("180;;adicionarOpcao;;Aumento acentuado$$\n");
        sb.append("180;;adicionarOpcao;;Diminuição leve$$\n");
        sb.append("180;;adicionarOpcao;;Diminuição moderada$$\n");
        sb.append("180;;adicionarOpcao;;Diminuição acentuada$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        //insercao
        sb.append("\n172;;adicionarOpcao;;tópica$$\n");
        sb.append("172;;adicionarOpcao;;heterotópica$$\n");
        sb.append("172;;adicionarOpcao;;prévia marginal$$\n");
        sb.append("172;;adicionarOpcao;;prévia centro parcial$$\n");
        sb.append("172;;adicionarOpcao;;prévia centro total$$\n");
        sb.append("172;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("172;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        //insercao 2
        sb.append("\n173;;adicionarOpcao;;anterior$$\n");
        sb.append("173;;adicionarOpcao;;posterior$$\n");
        sb.append("173;;adicionarOpcao;;fúndica$$\n");
        sb.append("173;;adicionarOpcao;;fúndica anterior$$\n");
        sb.append("173;;adicionarOpcao;;fúndica posterior$$\n");
        sb.append("173;;adicionarOpcao;;anterior lateral direita$$\n");
        sb.append("173;;adicionarOpcao;;anterior lateral esquerda$$\n");
        sb.append("173;;adicionarOpcao;;posterior lateral direita$$\n");
        sb.append("173;;adicionarOpcao;;posterior lateral esquerda$$\n");
        sb.append("173;;vincularHabAoValorDoCampo;;$172CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //espesssura
        sb.append("174;;vincularHabAoValorDoCampo;;$172CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //maturidade
        sb.append("\n175;;adicionarOpcao;;grau 0;;textura homogênea e maturidade grau 0$$\n");
        sb.append("175;;adicionarOpcao;;grau 1;;textura heterogênea e maturidade grau 1$$\n");
        sb.append("175;;adicionarOpcao;;grau 2;;textura heterogênea e maturidade grau 2$$\n");
        sb.append("175;;adicionarOpcao;;grau 3;;maturidade grau 3$$\n");
        sb.append("175;;vincularHabAoValorDoCampo;;$172CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");
        sb.append("175;;setComecarDoZero;;").append(Enumeracao.COMECAR_DO_ZERO_SIM).append("$$\n");

        // Descrição
        sb.append("176;;vincularObrigatorio;;$172CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("176;;vincularHabAoValorDoCampo;;$172CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total|" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria">

        //campo soma biometria
        sb.append("\n186;;cadastrarParametroFormula;;$181CampoNumero$$\n");
        sb.append("186;;cadastrarParametroFormula;;$182CampoNumero$$\n");
        sb.append("186;;cadastrarParametroFormula;;$183CampoNumero$$\n");
        sb.append("186;;cadastrarParametroFormula;;$184CampoNumero$$\n");

        //ic
        sb.append("\n152;;cadastrarParametroFormula;;$151CampoNumero$$\n");
        sb.append("152;;cadastrarParametroFormula;;$168CampoNumero$$\n");
        //cc
        sb.append("\n156;;cadastrarParametroFormula;;$151CampoNumero$$\n");
        sb.append("156;;cadastrarParametroFormula;;$168CampoNumero$$\n");

        //ca

        sb.append("\n153;;adicionarOpcao;;informar$$\n");
        sb.append("153;;adicionarOpcao;;calcular$$\n");
        sb.append("153;;setValor;;informar$$\n");

        sb.append("\n154;;cadastrarParametroFormula;;$169CampoNumero$$\n");
        sb.append("154;;cadastrarParametroFormula;;$170CampoNumero$$\n");
        sb.append("154;;vincularHabAoValorDoCampo;;$153CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("155;;vincularHabAoValorDoCampo;;$153CampoDoLaudo;;false;;{informar}$$\n");

        sb.append("169;;vincularHabAoValorDoCampo;;$153CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("170;;vincularHabAoValorDoCampo;;$153CampoDoLaudo;;false;;{calcular}$$\n");

        //ccDivca
        sb.append("\n157;;cadastrarParametroFormula;;$156CampoNumero$$\n");
        sb.append("157;;cadastrarParametroFormula;;$154CampoNumero$$\n");
        sb.append("157;;cadastrarParametroFormula;;$155CampoNumero;;2$$\n");
        //cfDivca
        sb.append("\n159;;cadastrarParametroFormula;;$158CampoNumero$$\n");
        sb.append("159;;cadastrarParametroFormula;;$154CampoNumero$$\n");
        sb.append("159;;cadastrarParametroFormula;;$155CampoNumero;;2$$\n");
        //peso fetal
        sb.append("\n163;;cadastrarParametroFormula;;$151CampoNumero$$\n");
        sb.append("163;;cadastrarParametroFormula;;$154CampoNumero$$\n");
        sb.append("163;;cadastrarParametroFormula;;$155CampoNumero;;2$$\n");
        //estatuta fetal
        sb.append("\n164;;cadastrarParametroFormula;;$151CampoNumero$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 3">

        sb.append("188;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6}$$\n");

        // <editor-fold defaultstate="collapsed" desc="Dados do feto">

        // situação
        sb.append("\n190;;adicionarOpcao;;longitudinal$$\n");
        sb.append("190;;adicionarOpcao;;transversal com polo cefálico à direita$$\n");
        sb.append("190;;adicionarOpcao;;transversal com polo cefálico à esquerda$$\n");
        sb.append("190;;adicionarOpcao;;oblíqua$$\n");
        sb.append("190;;adicionarOpcao;;indiferente$$\n");

        // apresentacao
        sb.append("\n191;;adicionarOpcao;;cefálica$$\n");
        sb.append("191;;adicionarOpcao;;pélvica$$\n");
        sb.append("191;;adicionarOpcao;;córmica$$\n");
        sb.append("191;;adicionarOpcao;;indiferente$$\n");
        sb.append("191;;vincularHabAoValorDoCampo;;$190CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // dorso
        sb.append("\n193;;adicionarOpcao;;à esquerda$$\n");
        sb.append("193;;adicionarOpcao;;à direita$$\n");
        sb.append("193;;adicionarOpcao;;anterior$$\n");
        sb.append("193;;adicionarOpcao;;posterior$$\n");
        sb.append("193;;adicionarOpcao;;superior$$\n");
        sb.append("193;;adicionarOpcao;;inferior$$\n");
        sb.append("193;;adicionarOpcao;;indiferente$$\n");
        sb.append("193;;vincularHabAoValorDoCampo;;$190CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // movimentos fetais
        sb.append("\n194;;adicionarOpcao;;presentes$$\n");
        sb.append("194;;adicionarOpcao;;ausentes$$\n");
        sb.append("194;;vincularHabAoValorDoCampo;;$190CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //movimentos respiratorios
        sb.append("\n196;;adicionarOpcao;;presentes$$\n");
        sb.append("196;;adicionarOpcao;;ausentes$$\n");
        sb.append("196;;adicionarOpcao;;não visualizados$$\n");
        sb.append("196;;vincularHabAoValorDoCampo;;$190CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // batimentos cardiacos
        sb.append("\n198;;adicionarOpcao;;presentes;;$$\n");
        sb.append("198;;adicionarOpcao;;ausentes$$\n");
        sb.append("198;;adicionarOpcao;;não visualizados$$\n");
        sb.append("198;;vincularHabAoValorDoCampo;;$190CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //ritmia
        sb.append("\n199;;adicionarOpcao;;rítmicos$$\n");
        sb.append("199;;adicionarOpcao;;arrítmicos$$\n");
        sb.append("199;;vincularHabAoValorDoCampo;;$198CampoDoLaudo;;false;;{presentes}$$\n");

        //numero batimentos / min
        sb.append("200;;vincularHabAoValorDoCampo;;$198CampoDoLaudo;;false;;{presentes}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos internos">

        // sexo
        sb.append("\n219;;adicionarOpcao;;masculino$$\n");
        sb.append("219;;adicionarOpcao;;feminino$$\n");
        sb.append("219;;adicionarOpcao;;não visualizado$$\n");
        sb.append("219;;adicionarOpcao;;não impresso a pedido (masculino)$$\n");
        sb.append("219;;adicionarOpcao;;não impresso a pedido (feminino)$$\n");
        sb.append("219;;adicionarExcecao;;não impresso a pedido (masculino);;$$\n");
        sb.append("219;;adicionarExcecao;;não impresso a pedido (feminino);;$$\n");

        //gordura Peritonial
        sb.append("\n220;;adicionarOpcao;;presente$$\n");
        sb.append("220;;adicionarOpcao;;ausente$$\n");

        //estadiamento Instestinal
        sb.append("\n221;;adicionarOpcao;;grau I$$\n");
        sb.append("221;;adicionarOpcao;;grau II$$\n");
        sb.append("221;;adicionarOpcao;;grau III$$\n");
        sb.append("221;;adicionarOpcao;;grau IV$$\n");

        // Órgãos internos
        sb.append("202;;adicionarOpcao;;normal;;Sem alterações visíveis.$$\n");
        sb.append("202;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("202;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("203;;vincularHabAoValorDoCampo;;$202CampoDoLaudo;;false;;{").append(""+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        //insercao
        sb.append("\n226;;adicionarOpcao;;tópica$$\n");
        sb.append("226;;adicionarOpcao;;heterotópica$$\n");
        sb.append("226;;adicionarOpcao;;prévia marginal$$\n");
        sb.append("226;;adicionarOpcao;;prévia centro parcial$$\n");
        sb.append("226;;adicionarOpcao;;prévia centro total$$\n");
        sb.append("226;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("226;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        //insercao 2
        sb.append("\n227;;adicionarOpcao;;anterior$$\n");
        sb.append("227;;adicionarOpcao;;posterior$$\n");
        sb.append("227;;adicionarOpcao;;fúndica$$\n");
        sb.append("227;;adicionarOpcao;;fúndica anterior$$\n");
        sb.append("227;;adicionarOpcao;;fúndica posterior$$\n");
        sb.append("227;;adicionarOpcao;;anterior lateral direita$$\n");
        sb.append("227;;adicionarOpcao;;anterior lateral esquerda$$\n");
        sb.append("227;;adicionarOpcao;;posterior lateral direita$$\n");
        sb.append("227;;adicionarOpcao;;posterior lateral esquerda$$\n");
        sb.append("227;;vincularHabAoValorDoCampo;;$226CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //espesssura
        sb.append("228;;vincularHabAoValorDoCampo;;$226CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //maturidade
        sb.append("\n229;;adicionarOpcao;;grau 0;;textura homogênea e maturidade grau 0$$\n");
        sb.append("229;;adicionarOpcao;;grau 1;;textura heterogênea e maturidade grau 1$$\n");
        sb.append("229;;adicionarOpcao;;grau 2;;textura heterogênea e maturidade grau 2$$\n");
        sb.append("229;;adicionarOpcao;;grau 3;;maturidade grau 3$$\n");
        sb.append("229;;vincularHabAoValorDoCampo;;$226CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");
        sb.append("229;;setComecarDoZero;;").append(Enumeracao.COMECAR_DO_ZERO_SIM).append("$$\n");

        // Descrição
        sb.append("230;;vincularObrigatorio;;$226CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("230;;vincularHabAoValorDoCampo;;$226CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total|" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        // ILA
        sb.append("\n241;;cadastrarLogica;;;;").append(CampoLogico.INTERVALO).append(";;{0.00|0.01}$$\n");
        sb.append("241;;cadastrarLogica;;(Oligoâmnio - ILA está entre 0,00 e 5,00).;;").append(CampoLogico.INTERVALO).append(";;{0.0|5.0}$$\n");
        sb.append("241;;cadastrarLogica;;(Reduzido - ILA está entre 5,00 e 8,00).;;").append(CampoLogico.INTERVALO).append(";;{5.0|8.0}$$\n");
        sb.append("241;;cadastrarLogica;;(Normal - ILA está entre 8,00 e 22,00).;;").append(CampoLogico.INTERVALO).append(";;{8.0|22.0}$$\n");
        sb.append("241;;cadastrarLogica;;(Aumentado - ILA está entre 22,00 e 25,00).;;").append(CampoLogico.INTERVALO).append(";;{22.0|25.0}$$\n");
        sb.append("241;;cadastrarLogica;;(Poliidrâmnio - ILA é maior ou igual a 25,00).;;").append(CampoLogico.INTERVALO).append(";;{25.0|999.00}$$\n");

        //cordão umbilical
        sb.append("\n232;;adicionarOpcao;;normal;;Com duas artérias e uma veia normoinserida.$$\n");
        sb.append("232;;adicionarOpcao;;artéria única;;Artéria única.$$\n");
        sb.append("232;;adicionarOpcao;;não visualizado;;Não visualizado.$$\n");

        //liquido Amniotico
        sb.append("\n234;;adicionarOpcao;;Normal$$\n");
        sb.append("234;;adicionarOpcao;;Aumento leve$$\n");
        sb.append("234;;adicionarOpcao;;Aumento moderado$$\n");
        sb.append("234;;adicionarOpcao;;Aumento acentuado$$\n");
        sb.append("234;;adicionarOpcao;;Diminuição leve$$\n");
        sb.append("234;;adicionarOpcao;;Diminuição moderada$$\n");
        sb.append("234;;adicionarOpcao;;Diminuição acentuada$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria">

        //campo soma biometria
        sb.append("\n240;;cadastrarParametroFormula;;$235CampoNumero$$\n");
        sb.append("240;;cadastrarParametroFormula;;$236CampoNumero$$\n");
        sb.append("240;;cadastrarParametroFormula;;$237CampoNumero$$\n");
        sb.append("240;;cadastrarParametroFormula;;$238CampoNumero$$\n");

        //ic
        sb.append("\n206;;cadastrarParametroFormula;;$205CampoNumero$$\n");
        sb.append("206;;cadastrarParametroFormula;;$222CampoNumero$$\n");
        //cc
        sb.append("\n210;;cadastrarParametroFormula;;$205CampoNumero$$\n");
        sb.append("210;;cadastrarParametroFormula;;$222CampoNumero$$\n");

        //ca
        sb.append("\n207;;adicionarOpcao;;informar$$\n");
        sb.append("207;;adicionarOpcao;;calcular$$\n");
        sb.append("207;;setValor;;informar$$\n");

        sb.append("\n208;;cadastrarParametroFormula;;$223CampoNumero$$\n");
        sb.append("208;;cadastrarParametroFormula;;$224CampoNumero$$\n");
        sb.append("208;;vincularHabAoValorDoCampo;;$207CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("209;;vincularHabAoValorDoCampo;;$207CampoDoLaudo;;false;;{informar}$$\n");

        sb.append("223;;vincularHabAoValorDoCampo;;$207CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("224;;vincularHabAoValorDoCampo;;$207CampoDoLaudo;;false;;{calcular}$$\n");

        //ccDivca
        sb.append("\n211;;cadastrarParametroFormula;;$210CampoNumero$$\n");
        sb.append("211;;cadastrarParametroFormula;;$208CampoNumero$$\n");
        sb.append("211;;cadastrarParametroFormula;;$209CampoNumero;;2$$\n");
        //cfDivca
        sb.append("\n213;;cadastrarParametroFormula;;$212CampoNumero$$\n");
        sb.append("213;;cadastrarParametroFormula;;$208CampoNumero$$\n");
        sb.append("213;;cadastrarParametroFormula;;$209CampoNumero;;2$$\n");
        //peso fetal
        sb.append("\n217;;cadastrarParametroFormula;;$205CampoNumero$$\n");
        sb.append("217;;cadastrarParametroFormula;;$208CampoNumero$$\n");
        sb.append("217;;cadastrarParametroFormula;;$209CampoNumero;;2$$\n");
        //estatuta fetal
        sb.append("\n218;;cadastrarParametroFormula;;$205CampoNumero$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 4">

        sb.append("242;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)4|(/s)5|(/s)6}$$\n");

        // <editor-fold defaultstate="collapsed" desc="Dados do feto">

        // situação
        sb.append("\n244;;adicionarOpcao;;longitudinal$$\n");
        sb.append("244;;adicionarOpcao;;transversal com polo cefálico à direita$$\n");
        sb.append("244;;adicionarOpcao;;transversal com polo cefálico à esquerda$$\n");
        sb.append("244;;adicionarOpcao;;oblíqua$$\n");
        sb.append("244;;adicionarOpcao;;indiferente$$\n");

        // apresentacao
        sb.append("\n245;;adicionarOpcao;;cefálica$$\n");
        sb.append("245;;adicionarOpcao;;pélvica$$\n");
        sb.append("245;;adicionarOpcao;;córmica$$\n");
        sb.append("245;;adicionarOpcao;;indiferente$$\n");
        sb.append("245;;vincularHabAoValorDoCampo;;$244CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // dorso
        sb.append("\n247;;adicionarOpcao;;à esquerda$$\n");
        sb.append("247;;adicionarOpcao;;à direita$$\n");
        sb.append("247;;adicionarOpcao;;anterior$$\n");
        sb.append("247;;adicionarOpcao;;posterior$$\n");
        sb.append("247;;adicionarOpcao;;superior$$\n");
        sb.append("247;;adicionarOpcao;;inferior$$\n");
        sb.append("247;;adicionarOpcao;;indiferente$$\n");
        sb.append("247;;vincularHabAoValorDoCampo;;$244CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // movimentos fetais
        sb.append("\n248;;adicionarOpcao;;presentes$$\n");
        sb.append("248;;adicionarOpcao;;ausentes$$\n");
        sb.append("248;;vincularHabAoValorDoCampo;;$244CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //movimentos respiratorios
        sb.append("\n250;;adicionarOpcao;;presentes$$\n");
        sb.append("250;;adicionarOpcao;;ausentes$$\n");
        sb.append("250;;adicionarOpcao;;não visualizados$$\n");
        sb.append("250;;vincularHabAoValorDoCampo;;$244CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // batimentos cardiacos
        sb.append("\n252;;adicionarOpcao;;presentes;;$$\n");
        sb.append("252;;adicionarOpcao;;ausentes$$\n");
        sb.append("252;;adicionarOpcao;;não visualizados$$\n");
        sb.append("252;;vincularHabAoValorDoCampo;;$244CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //ritmia
        sb.append("\n253;;adicionarOpcao;;rítmicos$$\n");
        sb.append("253;;adicionarOpcao;;arrítmicos$$\n");
        sb.append("253;;vincularHabAoValorDoCampo;;$252CampoDoLaudo;;false;;{presentes}$$\n");

        //numero batimentos / min
        sb.append("254;;vincularHabAoValorDoCampo;;$252CampoDoLaudo;;false;;{presentes}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos internos">

        // sexo
        sb.append("\n273;;adicionarOpcao;;masculino$$\n");
        sb.append("273;;adicionarOpcao;;feminino$$\n");
        sb.append("273;;adicionarOpcao;;não visualizado$$\n");
        sb.append("273;;adicionarOpcao;;não impresso a pedido (masculino)$$\n");
        sb.append("273;;adicionarOpcao;;não impresso a pedido (feminino)$$\n");
        sb.append("273;;adicionarExcecao;;não impresso a pedido (masculino);;$$\n");
        sb.append("273;;adicionarExcecao;;não impresso a pedido (feminino);;$$\n");

        //gordura Peritonial
        sb.append("\n274;;adicionarOpcao;;presente$$\n");
        sb.append("58;;adicionarOpcao;;ausente$$\n");

        //estadiamento Instestinal
        sb.append("\n275;;adicionarOpcao;;grau I$$\n");
        sb.append("275;;adicionarOpcao;;grau II$$\n");
        sb.append("275;;adicionarOpcao;;grau III$$\n");
        sb.append("275;;adicionarOpcao;;grau IV$$\n");

        // Órgãos internos
        sb.append("256;;adicionarOpcao;;normal;;Sem alterações visíveis.$$\n");
        sb.append("256;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("256;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("257;;vincularHabAoValorDoCampo;;$256CampoDoLaudo;;false;;{").append(""+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        // ILA
        sb.append("\n295;;cadastrarLogica;;;;").append(CampoLogico.INTERVALO).append(";;{0.00|0.01}$$\n");
        sb.append("295;;cadastrarLogica;;(Oligoâmnio - ILA está entre 0,00 e 5,00).;;").append(CampoLogico.INTERVALO).append(";;{0.0|5.0}$$\n");
        sb.append("295;;cadastrarLogica;;(Reduzido - ILA está entre 5,00 e 8,00).;;").append(CampoLogico.INTERVALO).append(";;{5.0|8.0}$$\n");
        sb.append("295;;cadastrarLogica;;(Normal - ILA está entre 8,00 e 22,00).;;").append(CampoLogico.INTERVALO).append(";;{8.0|22.0}$$\n");
        sb.append("295;;cadastrarLogica;;(Aumentado - ILA está entre 22,00 e 25,00).;;").append(CampoLogico.INTERVALO).append(";;{22.0|25.0}$$\n");
        sb.append("295;;cadastrarLogica;;(Poliidrâmnio - ILA é maior ou igual a 25,00).;;").append(CampoLogico.INTERVALO).append(";;{25.0|999.00}$$\n");

        //cordão umbilical
        sb.append("\n286;;adicionarOpcao;;normal;;Com duas artérias e uma veia normoinserida.$$\n");
        sb.append("286;;adicionarOpcao;;artéria única;;Artéria única.$$\n");
        sb.append("286;;adicionarOpcao;;não visualizado;;Não visualizado.$$\n");

        //liquido Amniotico
        sb.append("\n288;;adicionarOpcao;;Normal$$\n");
        sb.append("288;;adicionarOpcao;;Aumento leve$$\n");
        sb.append("288;;adicionarOpcao;;Aumento moderado$$\n");
        sb.append("288;;adicionarOpcao;;Aumento acentuado$$\n");
        sb.append("288;;adicionarOpcao;;Diminuição leve$$\n");
        sb.append("288;;adicionarOpcao;;Diminuição moderada$$\n");
        sb.append("288;;adicionarOpcao;;Diminuição acentuada$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        //insercao
        sb.append("\n280;;adicionarOpcao;;tópica$$\n");
        sb.append("280;;adicionarOpcao;;heterotópica$$\n");
        sb.append("280;;adicionarOpcao;;prévia marginal$$\n");
        sb.append("280;;adicionarOpcao;;prévia centro parcial$$\n");
        sb.append("280;;adicionarOpcao;;prévia centro total$$\n");
        sb.append("280;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("280;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        //insercao 2
        sb.append("\n281;;adicionarOpcao;;anterior$$\n");
        sb.append("281;;adicionarOpcao;;posterior$$\n");
        sb.append("281;;adicionarOpcao;;fúndica$$\n");
        sb.append("281;;adicionarOpcao;;fúndica anterior$$\n");
        sb.append("281;;adicionarOpcao;;fúndica posterior$$\n");
        sb.append("281;;adicionarOpcao;;anterior lateral direita$$\n");
        sb.append("281;;adicionarOpcao;;anterior lateral esquerda$$\n");
        sb.append("281;;adicionarOpcao;;posterior lateral direita$$\n");
        sb.append("281;;adicionarOpcao;;posterior lateral esquerda$$\n");
        sb.append("281;;vincularHabAoValorDoCampo;;$280CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //espesssura
        sb.append("282;;vincularHabAoValorDoCampo;;$280CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //maturidade
        sb.append("\n283;;adicionarOpcao;;grau 0;;textura homogênea e maturidade grau 0$$\n");
        sb.append("283;;adicionarOpcao;;grau 1;;textura heterogênea e maturidade grau 1$$\n");
        sb.append("283;;adicionarOpcao;;grau 2;;textura heterogênea e maturidade grau 2$$\n");
        sb.append("283;;adicionarOpcao;;grau 3;;maturidade grau 3$$\n");
        sb.append("283;;vincularHabAoValorDoCampo;;$280CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");
        sb.append("283;;setComecarDoZero;;").append(Enumeracao.COMECAR_DO_ZERO_SIM).append("$$\n");

        // Descrição
        sb.append("284;;vincularObrigatorio;;$280CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("284;;vincularHabAoValorDoCampo;;$280CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total|" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria">

        //campo soma biometria
        sb.append("\n294;;cadastrarParametroFormula;;$289CampoNumero$$\n");
        sb.append("294;;cadastrarParametroFormula;;$290CampoNumero$$\n");
        sb.append("294;;cadastrarParametroFormula;;$291CampoNumero$$\n");
        sb.append("294;;cadastrarParametroFormula;;$292CampoNumero$$\n");

        //ic
        sb.append("\n260;;cadastrarParametroFormula;;$205CampoNumero$$\n");
        sb.append("260;;cadastrarParametroFormula;;$276CampoNumero$$\n");
        //cc
        sb.append("\n264;;cadastrarParametroFormula;;$205CampoNumero$$\n");
        sb.append("264;;cadastrarParametroFormula;;$276CampoNumero$$\n");

        //ca

        sb.append("\n261;;adicionarOpcao;;informar$$\n");
        sb.append("261;;adicionarOpcao;;calcular$$\n");
        sb.append("261;;setValor;;informar$$\n");

        sb.append("\n262;;cadastrarParametroFormula;;$277CampoNumero$$\n");
        sb.append("262;;cadastrarParametroFormula;;$278CampoNumero$$\n");
        sb.append("262;;vincularHabAoValorDoCampo;;$261CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("263;;vincularHabAoValorDoCampo;;$261CampoDoLaudo;;false;;{informar}$$\n");

        sb.append("277;;vincularHabAoValorDoCampo;;$261CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("278;;vincularHabAoValorDoCampo;;$261CampoDoLaudo;;false;;{calcular}$$\n");

        //ccDivca
        sb.append("\n265;;cadastrarParametroFormula;;$264CampoNumero$$\n");
        sb.append("265;;cadastrarParametroFormula;;$262CampoNumero$$\n");
        sb.append("265;;cadastrarParametroFormula;;$263CampoNumero;;2$$\n");
        //cfDivca
        sb.append("\n267;;cadastrarParametroFormula;;$266CampoNumero$$\n");
        sb.append("267;;cadastrarParametroFormula;;$262CampoNumero$$\n");
        sb.append("267;;cadastrarParametroFormula;;$263CampoNumero;;2$$\n");
        //peso fetal
        sb.append("\n271;;cadastrarParametroFormula;;$259CampoNumero$$\n");
        sb.append("271;;cadastrarParametroFormula;;$262CampoNumero$$\n");
        sb.append("271;;cadastrarParametroFormula;;$263CampoNumero;;2$$\n");
        //estatuta fetal
        sb.append("\n272;;cadastrarParametroFormula;;$259CampoNumero$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 5">

        sb.append("296;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)5|(/s)6}$$\n");

        // <editor-fold defaultstate="collapsed" desc="Dados do feto">

        // situação
        sb.append("\n298;;adicionarOpcao;;longitudinal$$\n");
        sb.append("298;;adicionarOpcao;;transversal com polo cefálico à direita$$\n");
        sb.append("298;;adicionarOpcao;;transversal com polo cefálico à esquerda$$\n");
        sb.append("298;;adicionarOpcao;;oblíqua$$\n");
        sb.append("298;;adicionarOpcao;;indiferente$$\n");

        // apresentacao
        sb.append("\n299;;adicionarOpcao;;cefálica$$\n");
        sb.append("299;;adicionarOpcao;;pélvica$$\n");
        sb.append("299;;adicionarOpcao;;córmica$$\n");
        sb.append("299;;adicionarOpcao;;indiferente$$\n");
        sb.append("299;;vincularHabAoValorDoCampo;;$298CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // dorso
        sb.append("\n301;;adicionarOpcao;;à esquerda$$\n");
        sb.append("301;;adicionarOpcao;;à direita$$\n");
        sb.append("301;;adicionarOpcao;;anterior$$\n");
        sb.append("301;;adicionarOpcao;;posterior$$\n");
        sb.append("301;;adicionarOpcao;;superior$$\n");
        sb.append("301;;adicionarOpcao;;inferior$$\n");
        sb.append("301;;adicionarOpcao;;indiferente$$\n");
        sb.append("301;;vincularHabAoValorDoCampo;;$298CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // movimentos fetais
        sb.append("\n302;;adicionarOpcao;;presentes$$\n");
        sb.append("302;;adicionarOpcao;;ausentes$$\n");
        sb.append("302;;vincularHabAoValorDoCampo;;$298CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //movimentos respiratorios
        sb.append("\n304;;adicionarOpcao;;presentes$$\n");
        sb.append("304;;adicionarOpcao;;ausentes$$\n");
        sb.append("304;;adicionarOpcao;;não visualizados$$\n");
        sb.append("304;;vincularHabAoValorDoCampo;;$298CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // batimentos cardiacos
        sb.append("\n306;;adicionarOpcao;;presentes;;$$\n");
        sb.append("306;;adicionarOpcao;;ausentes$$\n");
        sb.append("306;;adicionarOpcao;;não visualizados$$\n");
        sb.append("306;;vincularHabAoValorDoCampo;;$298CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //ritmia
        sb.append("\n307;;adicionarOpcao;;rítmicos$$\n");
        sb.append("307;;adicionarOpcao;;arrítmicos$$\n");
        sb.append("307;;vincularHabAoValorDoCampo;;$306CampoDoLaudo;;false;;{presentes}$$\n");

        //numero batimentos / min
        sb.append("308;;vincularHabAoValorDoCampo;;$306CampoDoLaudo;;false;;{presentes}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos internos">

        //sexo Fetal
        sb.append("\n327;;adicionarOpcao;;masculino$$\n");
        sb.append("327;;adicionarOpcao;;feminino$$\n");
        sb.append("327;;adicionarOpcao;;não visualizado$$\n");
        sb.append("327;;adicionarOpcao;;não impresso a pedido (masculino)$$\n");
        sb.append("327;;adicionarOpcao;;não impresso a pedido (feminino)$$\n");
        sb.append("327;;adicionarExcecao;;não impresso a pedido (masculino);;$$\n");
        sb.append("327;;adicionarExcecao;;não impresso a pedido (feminino);;$$\n");

        //gordura Peritonial
        sb.append("\n328;;adicionarOpcao;;presente$$\n");
        sb.append("328;;adicionarOpcao;;ausente$$\n");

        //estadiamento Instestinal
        sb.append("\n329;;adicionarOpcao;;grau I$$\n");
        sb.append("329;;adicionarOpcao;;grau II$$\n");
        sb.append("329;;adicionarOpcao;;grau III$$\n");
        sb.append("329;;adicionarOpcao;;grau IV$$\n");

        // Órgãos internos
        sb.append("310;;adicionarOpcao;;normal;;Sem alterações visíveis.$$\n");
        sb.append("310;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("310;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("311;;vincularHabAoValorDoCampo;;$310CampoDoLaudo;;false;;{").append(""+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        // ILA
        sb.append("\n349;;cadastrarLogica;;;;").append(CampoLogico.INTERVALO).append(";;{0.00|0.01}$$\n");
        sb.append("349;;cadastrarLogica;;(Oligoâmnio - ILA está entre 0,00 e 5,00).;;").append(CampoLogico.INTERVALO).append(";;{0.0|5.0}$$\n");
        sb.append("349;;cadastrarLogica;;(Reduzido - ILA está entre 5,00 e 8,00).;;").append(CampoLogico.INTERVALO).append(";;{5.0|8.0}$$\n");
        sb.append("349;;cadastrarLogica;;(Normal - ILA está entre 8,00 e 22,00).;;").append(CampoLogico.INTERVALO).append(";;{8.0|22.0}$$\n");
        sb.append("349;;cadastrarLogica;;(Aumentado - ILA está entre 22,00 e 25,00).;;").append(CampoLogico.INTERVALO).append(";;{22.0|25.0}$$\n");
        sb.append("349;;cadastrarLogica;;(Poliidrâmnio - ILA é maior ou igual a 25,00).;;").append(CampoLogico.INTERVALO).append(";;{25.0|999.00}$$\n");

        //cordão umbilical
        sb.append("\n340;;adicionarOpcao;;normal;;Com duas artérias e uma veia normoinserida.$$\n");
        sb.append("340;;adicionarOpcao;;artéria única;;Artéria única.$$\n");
        sb.append("340;;adicionarOpcao;;não visualizado;;Não visualizado.$$\n");

        //liquido Amniotico
        sb.append("\n342;;adicionarOpcao;;Normal$$\n");
        sb.append("342;;adicionarOpcao;;Aumento leve$$\n");
        sb.append("342;;adicionarOpcao;;Aumento moderado$$\n");
        sb.append("342;;adicionarOpcao;;Aumento acentuado$$\n");
        sb.append("342;;adicionarOpcao;;Diminuição leve$$\n");
        sb.append("342;;adicionarOpcao;;Diminuição moderada$$\n");
        sb.append("342;;adicionarOpcao;;Diminuição acentuada$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        //insercao
        sb.append("\n334;;adicionarOpcao;;tópica$$\n");
        sb.append("334;;adicionarOpcao;;heterotópica$$\n");
        sb.append("334;;adicionarOpcao;;prévia marginal$$\n");
        sb.append("334;;adicionarOpcao;;prévia centro parcial$$\n");
        sb.append("334;;adicionarOpcao;;prévia centro total$$\n");
        sb.append("334;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("334;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        //insercao 2
        sb.append("\n335;;adicionarOpcao;;anterior$$\n");
        sb.append("335;;adicionarOpcao;;posterior$$\n");
        sb.append("335;;adicionarOpcao;;fúndica$$\n");
        sb.append("335;;adicionarOpcao;;fúndica anterior$$\n");
        sb.append("335;;adicionarOpcao;;fúndica posterior$$\n");
        sb.append("335;;adicionarOpcao;;anterior lateral direita$$\n");
        sb.append("335;;adicionarOpcao;;anterior lateral esquerda$$\n");
        sb.append("335;;adicionarOpcao;;posterior lateral direita$$\n");
        sb.append("335;;adicionarOpcao;;posterior lateral esquerda$$\n");
        sb.append("335;;vincularHabAoValorDoCampo;;$334CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //maturidade
        sb.append("\n337;;adicionarOpcao;;grau 0;;textura homogênea e maturidade grau 0$$\n");
        sb.append("337;;adicionarOpcao;;grau 1;;textura heterogênea e maturidade grau 1$$\n");
        sb.append("337;;adicionarOpcao;;grau 2;;textura heterogênea e maturidade grau 2$$\n");
        sb.append("337;;adicionarOpcao;;grau 3;;maturidade grau 3$$\n");
        sb.append("337;;vincularHabAoValorDoCampo;;$334CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");
        sb.append("337;;setComecarDoZero;;").append(Enumeracao.COMECAR_DO_ZERO_SIM).append("$$\n");

        //espesssura
        sb.append("336;;vincularHabAoValorDoCampo;;$334CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        // Descrição
        sb.append("338;;vincularObrigatorio;;$334CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("338;;vincularHabAoValorDoCampo;;$334CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total|" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria">

        //campo soma biometria
        sb.append("\n348;;cadastrarParametroFormula;;$343CampoNumero$$\n");
        sb.append("348;;cadastrarParametroFormula;;$344CampoNumero$$\n");
        sb.append("348;;cadastrarParametroFormula;;$345CampoNumero$$\n");
        sb.append("348;;cadastrarParametroFormula;;$346CampoNumero$$\n");

        //ic
        sb.append("\n314;;cadastrarParametroFormula;;$313CampoNumero$$\n");
        sb.append("314;;cadastrarParametroFormula;;$330CampoNumero$$\n");
        //cc
        sb.append("\n318;;cadastrarParametroFormula;;$313CampoNumero$$\n");
        sb.append("318;;cadastrarParametroFormula;;$330CampoNumero$$\n");

        //ca

        sb.append("\n315;;adicionarOpcao;;informar$$\n");
        sb.append("315;;adicionarOpcao;;calcular$$\n");
        sb.append("315;;setValor;;informar$$\n");

        sb.append("\n316;;cadastrarParametroFormula;;$331CampoNumero$$\n");
        sb.append("316;;cadastrarParametroFormula;;$332CampoNumero$$\n");
        sb.append("316;;vincularHabAoValorDoCampo;;$315CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("317;;vincularHabAoValorDoCampo;;$315CampoDoLaudo;;false;;{informar}$$\n");

        sb.append("331;;vincularHabAoValorDoCampo;;$315CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("332;;vincularHabAoValorDoCampo;;$315CampoDoLaudo;;false;;{calcular}$$\n");

        //ccDivca
        sb.append("\n319;;cadastrarParametroFormula;;$318CampoNumero$$\n");
        sb.append("319;;cadastrarParametroFormula;;$316CampoNumero$$\n");
        sb.append("319;;cadastrarParametroFormula;;$317CampoNumero;;2$$\n");
        //cfDivca
        sb.append("\n321;;cadastrarParametroFormula;;$320CampoNumero$$\n");
        sb.append("321;;cadastrarParametroFormula;;$316CampoNumero$$\n");
        sb.append("321;;cadastrarParametroFormula;;$317CampoNumero;;2$$\n");
        //peso fetal
        sb.append("\n325;;cadastrarParametroFormula;;$313CampoNumero$$\n");
        sb.append("325;;cadastrarParametroFormula;;$316CampoNumero$$\n");
        sb.append("325;;cadastrarParametroFormula;;$317CampoNumero;;2$$\n");
        //estatuta fetal
        sb.append("\n326;;cadastrarParametroFormula;;$313CampoNumero$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 6">

        sb.append("350;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)6}$$\n");

        // <editor-fold defaultstate="collapsed" desc="Dados do feto">

        // situação
        sb.append("\n352;;adicionarOpcao;;longitudinal$$\n");
        sb.append("352;;adicionarOpcao;;transversal com polo cefálico à direita$$\n");
        sb.append("352;;adicionarOpcao;;transversal com polo cefálico à esquerda$$\n");
        sb.append("352;;adicionarOpcao;;oblíqua$$\n");
        sb.append("352;;adicionarOpcao;;indiferente$$\n");

        // apresentacao
        sb.append("\n353;;adicionarOpcao;;cefálica$$\n");
        sb.append("353;;adicionarOpcao;;pélvica$$\n");
        sb.append("353;;adicionarOpcao;;córmica$$\n");
        sb.append("353;;adicionarOpcao;;indiferente$$\n");
        sb.append("353;;vincularHabAoValorDoCampo;;$352CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // dorso
        sb.append("\n355;;adicionarOpcao;;à esquerda$$\n");
        sb.append("355;;adicionarOpcao;;à direita$$\n");
        sb.append("355;;adicionarOpcao;;anterior$$\n");
        sb.append("355;;adicionarOpcao;;posterior$$\n");
        sb.append("355;;adicionarOpcao;;superior$$\n");
        sb.append("355;;adicionarOpcao;;inferior$$\n");
        sb.append("355;;adicionarOpcao;;indiferente$$\n");
        sb.append("355;;vincularHabAoValorDoCampo;;$352CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // movimentos fetais
        sb.append("\n356;;adicionarOpcao;;presentes$$\n");
        sb.append("356;;adicionarOpcao;;ausentes$$\n");
        sb.append("356;;vincularHabAoValorDoCampo;;$352CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //movimentos respiratorios
        sb.append("\n358;;adicionarOpcao;;presentes$$\n");
        sb.append("358;;adicionarOpcao;;ausentes$$\n");
        sb.append("358;;adicionarOpcao;;não visualizados$$\n");
        sb.append("358;;vincularHabAoValorDoCampo;;$352CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        // batimentos cardiacos
        sb.append("\n360;;adicionarOpcao;;presentes;;$$\n");
        sb.append("360;;adicionarOpcao;;ausentes$$\n");
        sb.append("360;;adicionarOpcao;;não visualizados$$\n");
        sb.append("360;;vincularHabAoValorDoCampo;;$352CampoDoLaudo;;false;;{longitudinal|transversal com polo cefálico à direita|transversal com polo cefálico à esquerda|oblíqua|indiferente}$$\n");

        //ritmia
        sb.append("\n361;;adicionarOpcao;;rítmicos$$\n");
        sb.append("361;;adicionarOpcao;;arrítmicos$$\n");
        sb.append("361;;vincularHabAoValorDoCampo;;$360CampoDoLaudo;;false;;{presentes}$$\n");

        //numero batimentos / min
        sb.append("362;;vincularHabAoValorDoCampo;;$360CampoDoLaudo;;false;;{presentes}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos internos">

        // sexo
        sb.append("\n381;;adicionarOpcao;;masculino$$\n");
        sb.append("381;;adicionarOpcao;;feminino$$\n");
        sb.append("381;;adicionarOpcao;;não visualizado$$\n");
        sb.append("381;;adicionarOpcao;;não impresso a pedido (masculino)$$\n");
        sb.append("381;;adicionarOpcao;;não impresso a pedido (feminino)$$\n");
        sb.append("381;;adicionarExcecao;;não impresso a pedido (masculino);;$$\n");
        sb.append("381;;adicionarExcecao;;não impresso a pedido (feminino);;$$\n");

        //gordura Peritonial
        sb.append("\n382;;adicionarOpcao;;presente$$\n");
        sb.append("382;;adicionarOpcao;;ausente$$\n");

        //estadiamento Instestinal
        sb.append("\n383;;adicionarOpcao;;grau I$$\n");
        sb.append("383;;adicionarOpcao;;grau II$$\n");
        sb.append("383;;adicionarOpcao;;grau III$$\n");
        sb.append("383;;adicionarOpcao;;grau IV$$\n");

        // Órgãos internos
        sb.append("364;;adicionarOpcao;;normal;;Sem alterações visíveis.$$\n");
        sb.append("364;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("364;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("365;;vincularHabAoValorDoCampo;;$364CampoDoLaudo;;false;;{").append(""+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        // ILA
        sb.append("\n403;;cadastrarLogica;;;;").append(CampoLogico.INTERVALO).append(";;{0.00|0.01}$$\n");
        sb.append("403;;cadastrarLogica;;(Oligoâmnio - ILA está entre 0,00 e 5,00).;;").append(CampoLogico.INTERVALO).append(";;{0.0|5.0}$$\n");
        sb.append("403;;cadastrarLogica;;(Reduzido - ILA está entre 5,00 e 8,00).;;").append(CampoLogico.INTERVALO).append(";;{5.0|8.0}$$\n");
        sb.append("403;;cadastrarLogica;;(Normal - ILA está entre 8,00 e 22,00).;;").append(CampoLogico.INTERVALO).append(";;{8.0|22.0}$$\n");
        sb.append("403;;cadastrarLogica;;(Aumentado - ILA está entre 22,00 e 25,00).;;").append(CampoLogico.INTERVALO).append(";;{22.0|25.0}$$\n");
        sb.append("403;;cadastrarLogica;;(Poliidrâmnio - ILA é maior ou igual a 25,00).;;").append(CampoLogico.INTERVALO).append(";;{25.0|999.00}$$\n");

        //cordão umbilical
        sb.append("\n394;;adicionarOpcao;;normal;;Com duas artérias e uma veia normoinserida.$$\n");
        sb.append("394;;adicionarOpcao;;artéria única;;Artéria única.$$\n");
        sb.append("394;;adicionarOpcao;;não visualizado$$\n");

        //liquido Amniotico
        sb.append("\n396;;adicionarOpcao;;Normal$$\n");
        sb.append("396;;adicionarOpcao;;Aumento leve$$\n");
        sb.append("396;;adicionarOpcao;;Aumento moderado$$\n");
        sb.append("396;;adicionarOpcao;;Aumento acentuado$$\n");
        sb.append("396;;adicionarOpcao;;Diminuição leve$$\n");
        sb.append("396;;adicionarOpcao;;Diminuição moderada$$\n");
        sb.append("396;;adicionarOpcao;;Diminuição acentuada$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria">

        //campo soma biometria
        sb.append("\n402;;cadastrarParametroFormula;;$397CampoNumero$$\n");
        sb.append("402;;cadastrarParametroFormula;;$398CampoNumero$$\n");
        sb.append("402;;cadastrarParametroFormula;;$399CampoNumero$$\n");
        sb.append("402;;cadastrarParametroFormula;;$400CampoNumero$$\n");

        //ic
        sb.append("\n368;;cadastrarParametroFormula;;$367CampoNumero$$\n");
        sb.append("368;;cadastrarParametroFormula;;$384CampoNumero$$\n");
        //cc
        sb.append("\n372;;cadastrarParametroFormula;;$367CampoNumero$$\n");
        sb.append("372;;cadastrarParametroFormula;;$384CampoNumero$$\n");

        //ca

        sb.append("\n369;;adicionarOpcao;;informar$$\n");
        sb.append("369;;adicionarOpcao;;calcular$$\n");
        sb.append("369;;setValor;;informar$$\n");

        sb.append("\n370;;cadastrarParametroFormula;;$385CampoNumero$$\n");
        sb.append("370;;cadastrarParametroFormula;;$386CampoNumero$$\n");
        sb.append("370;;vincularHabAoValorDoCampo;;$369CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("371;;vincularHabAoValorDoCampo;;$369CampoDoLaudo;;false;;{informar}$$\n");

        sb.append("385;;vincularHabAoValorDoCampo;;$369CampoDoLaudo;;false;;{calcular}$$\n");

        sb.append("386;;vincularHabAoValorDoCampo;;$369CampoDoLaudo;;false;;{calcular}$$\n");

        //ccDivca
        sb.append("\n373;;cadastrarParametroFormula;;$372CampoNumero$$\n");
        sb.append("373;;cadastrarParametroFormula;;$370CampoNumero$$\n");
        sb.append("373;;cadastrarParametroFormula;;$371CampoNumero;;2$$\n");
        //cfDivca
        sb.append("\n375;;cadastrarParametroFormula;;$374CampoNumero$$\n");
        sb.append("375;;cadastrarParametroFormula;;$370CampoNumero$$\n");
        sb.append("375;;cadastrarParametroFormula;;$371CampoNumero;;2$$\n");
        //peso fetal
        sb.append("\n379;;cadastrarParametroFormula;;$367CampoNumero$$\n");
        sb.append("379;;cadastrarParametroFormula;;$370CampoNumero$$\n");
        sb.append("379;;cadastrarParametroFormula;;$371CampoNumero;;2$$\n");
        //estatuta fetal
        sb.append("\n380;;cadastrarParametroFormula;;$367CampoNumero$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        //insercao
        sb.append("\n388;;adicionarOpcao;;tópica$$\n");
        sb.append("388;;adicionarOpcao;;heterotópica$$\n");
        sb.append("388;;adicionarOpcao;;prévia marginal$$\n");
        sb.append("388;;adicionarOpcao;;prévia centro parcial$$\n");
        sb.append("388;;adicionarOpcao;;prévia centro total$$\n");
        sb.append("388;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("388;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        //insercao 2
        sb.append("\n389;;adicionarOpcao;;anterior$$\n");
        sb.append("389;;adicionarOpcao;;posterior$$\n");
        sb.append("389;;adicionarOpcao;;fúndica$$\n");
        sb.append("389;;adicionarOpcao;;fúndica anterior$$\n");
        sb.append("389;;adicionarOpcao;;fúndica posterior$$\n");
        sb.append("389;;adicionarOpcao;;anterior lateral direita$$\n");
        sb.append("389;;adicionarOpcao;;anterior lateral esquerda$$\n");
        sb.append("389;;adicionarOpcao;;posterior lateral direita$$\n");
        sb.append("389;;adicionarOpcao;;posterior lateral esquerda$$\n");
        sb.append("389;;vincularHabAoValorDoCampo;;$388CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        //espesssura
        sb.append("390;;vincularHabAoValorDoCampo;;$388CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");

        // maturidade
        sb.append("\n391;;adicionarOpcao;;grau 0;;textura homogênea e maturidade grau 0$$\n");
        sb.append("391;;adicionarOpcao;;grau 1;;textura heterogênea e maturidade grau 1$$\n");
        sb.append("391;;adicionarOpcao;;grau 2;;textura heterogênea e maturidade grau 2$$\n");
        sb.append("391;;adicionarOpcao;;grau 3;;maturidade grau 3$$\n");
        sb.append("391;;vincularHabAoValorDoCampo;;$388CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total}$$\n");
        sb.append("391;;setComecarDoZero;;").append(Enumeracao.COMECAR_DO_ZERO_SIM).append("$$\n");

        // Descrição
        sb.append("392;;vincularObrigatorio;;$388CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("392;;vincularHabAoValorDoCampo;;$388CampoDoLaudo;;false;;{tópica|heterotópica|prévia marginal|prévia centro parcial|prévia centro total|" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="IGH pela biometria">

        sb.append("43;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("46;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("47;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("48;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("50;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("52;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("53;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("54;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("61;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");
        sb.append("62;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)1}$$\n");

        sb.append("97;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("100;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("101;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("102;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("104;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("106;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("107;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("108;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("115;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");
        sb.append("116;;vincularHabAoValorDoCampo;;$8CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6}$$\n");

        preencherIghFeto1();
        preencherIghFeto2();
        preencherIghFeto3();
        preencherIghFeto4();
        preencherIghFeto5();
        preencherIghFeto6();

        // </editor-fold>

        // </editor-fold>

        alterarModeloDeLaudo(24);

    }

    private static void preencherIghFeto1 ()
    {

        // <editor-fold defaultstate="collapsed" desc="Fêmur">

        sb.append("433;;cadastrarLogica;;0,0->7,1;;<12,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;7,1->8,1;;12,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;8,1->9,1;;12,33 semanas$$\n");
        sb.append("433;;cadastrarLogica;;9,1->10,1;;12,67 semanas$$\n");
        sb.append("433;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("433;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("433;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("433;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("433;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("433;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("433;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;20,1->21,1;;16,33 semanas$$\n");
        sb.append("433;;cadastrarLogica;;21,1->22,1;;16,67 semanas$$\n");
        sb.append("433;;cadastrarLogica;;22,1->23,1;;17,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;23,1->24,1;;17,50 semanas$$\n");
        sb.append("433;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("433;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("433;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;28,1->29,1;;19,33 semanas$$\n");
        sb.append("433;;cadastrarLogica;;29,1->30,1;;19,67 semanas$$\n");
        sb.append("433;;cadastrarLogica;;30,1->31,1;;20,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;31,1->32,1;;20,33 semanas$$\n");
        sb.append("433;;cadastrarLogica;;32,1->33,1;;20,67 semanas$$\n");
        sb.append("433;;cadastrarLogica;;33,1->34,1;;21,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;34,1->35,1;;21,50 semanas$$\n");
        sb.append("433;;cadastrarLogica;;35,1->36,1;;22,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;36,1->37,1;;22,33 semanas$$\n");
        sb.append("433;;cadastrarLogica;;37,1->38,1;;22,67 semanas$$\n");
        sb.append("433;;cadastrarLogica;;38,1->39,1;;23,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;39,1->40,1;;23,33 semanas$$\n");
        sb.append("433;;cadastrarLogica;;40,1->41,1;;23,67 semanas$$\n");
        sb.append("433;;cadastrarLogica;;41,1->42,1;;24,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;42,1->43,1;;24,50 semanas$$\n");
        sb.append("433;;cadastrarLogica;;43,1->44,1;;25,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;44,1->45,1;;25,33 semanas$$\n");
        sb.append("433;;cadastrarLogica;;45,1->46,1;;25,67 semanas$$\n");
        sb.append("433;;cadastrarLogica;;46,1->47,1;;26,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;47,1->48,1;;26,50 semanas$$\n");
        sb.append("433;;cadastrarLogica;;48,1->49,1;;27,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;49,1->50,1;;27,33 semanas$$\n");
        sb.append("433;;cadastrarLogica;;50,1->51,1;;27,67 semanas$$\n");
        sb.append("433;;cadastrarLogica;;51,1->52,1;;28,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;52,1->53,1;;28,50 semanas$$\n");
        sb.append("433;;cadastrarLogica;;53,1->54,1;;29,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;54,1->55,1;;29,50 semanas$$\n");
        sb.append("433;;cadastrarLogica;;55,1->56,1;;30,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;56,1->57,1;;30,33 semanas$$\n");
        sb.append("433;;cadastrarLogica;;57,1->58,1;;30,67 semanas$$\n");
        sb.append("433;;cadastrarLogica;;58,1->59,1;;31,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;59,1->60,1;;31,50 semanas$$\n");
        sb.append("433;;cadastrarLogica;;60,1->61,1;;32,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;61,1->62,1;;32,50 semanas$$\n");
        sb.append("433;;cadastrarLogica;;62,1->63,1;;33,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;63,1->64,1;;33,50 semanas$$\n");
        sb.append("433;;cadastrarLogica;;64,1->65,1;;34,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;65,1->66,1;;34,50 semanas$$\n");
        sb.append("433;;cadastrarLogica;;66,1->67,1;;35,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;67,1->68,1;;36,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;68,1->69,1;;36,50 semanas$$\n");
        sb.append("433;;cadastrarLogica;;69,1->70,1;;37,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;70,1->71,1;;38,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;71,1->72,1;;38,50 semanas$$\n");
        sb.append("433;;cadastrarLogica;;72,1->73,1;;39,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;73,1->74,1;;40,00 semanas$$\n");
        sb.append("433;;cadastrarLogica;;74,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Úmero">

        sb.append("434;;cadastrarLogica;;0,0->8,1;;<12,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;8,1->9,1;;12,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;9,1->10,1;;12,50 semanas$$\n");
        sb.append("434;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("434;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("434;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("434;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("434;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("434;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("434;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;20,1->21,1;;16,50 semanas$$\n");
        sb.append("434;;cadastrarLogica;;21,1->22,1;;17,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;22,1->23,1;;17,33 semanas$$\n");
        sb.append("434;;cadastrarLogica;;23,1->24,1;;17,67 semanas$$\n");
        sb.append("434;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("434;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("434;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;28,1->29,1;;19,50 semanas$$\n");
        sb.append("434;;cadastrarLogica;;29,1->30,1;;20,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;30,1->31,1;;20,33 semanas$$\n");
        sb.append("434;;cadastrarLogica;;31,1->32,1;;20,67 semanas$$\n");
        sb.append("434;;cadastrarLogica;;32,1->33,1;;21,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;33,1->34,1;;21,50 semanas$$\n");
        sb.append("434;;cadastrarLogica;;34,1->35,1;;22,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;35,1->36,1;;22,33 semanas$$\n");
        sb.append("434;;cadastrarLogica;;36,1->37,1;;22,67 semanas$$\n");
        sb.append("434;;cadastrarLogica;;37,1->38,1;;23,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;38,1->39,1;;23,50 semanas$$\n");
        sb.append("434;;cadastrarLogica;;39,1->40,1;;24,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;40,1->41,1;;24,50 semanas$$\n");
        sb.append("434;;cadastrarLogica;;41,1->42,1;;25,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;42,1->43,1;;25,50 semanas$$\n");
        sb.append("434;;cadastrarLogica;;43,1->44,1;;26,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;44,1->45,1;;26,50 semanas$$\n");
        sb.append("434;;cadastrarLogica;;45,1->46,1;;27,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;46,1->47,1;;27,50 semanas$$\n");
        sb.append("434;;cadastrarLogica;;47,1->48,1;;28,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;48,1->49,1;;28,50 semanas$$\n");
        sb.append("434;;cadastrarLogica;;49,1->50,1;;29,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;50,1->51,1;;30,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;51,1->52,1;;30,50 semanas$$\n");
        sb.append("434;;cadastrarLogica;;52,1->53,1;;31,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;53,1->54,1;;31,50 semanas$$\n");
        sb.append("434;;cadastrarLogica;;54,1->55,1;;32,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;55,1->56,1;;33,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;56,1->57,1;;33,50 semanas$$\n");
        sb.append("434;;cadastrarLogica;;57,1->58,1;;34,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;58,1->59,1;;35,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;59,1->60,1;;35,50 semanas$$\n");
        sb.append("434;;cadastrarLogica;;60,1->61,1;;36,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;61,1->62,1;;37,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;63,1->64,1;;38,50 semanas$$\n");
        sb.append("434;;cadastrarLogica;;64,1->65,1;;39,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("434;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ulna">

        sb.append("435;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("435;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("435;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;10,1->11,1;;13,33 semanas$$\n");
        sb.append("435;;cadastrarLogica;;11,1->12,1;;13,67 semanas$$\n");
        sb.append("435;;cadastrarLogica;;12,1->13,1;;14,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;13,1->14,1;;14,50 semanas$$\n");
        sb.append("435;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;15,1->16,1;;15,33 semanas$$\n");
        sb.append("435;;cadastrarLogica;;16,1->17,1;;15,67 semanas$$\n");
        sb.append("435;;cadastrarLogica;;17,1->18,1;;16,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;18,1->19,1;;16,33 semanas$$\n");
        sb.append("435;;cadastrarLogica;;19,1->20,1;;16,67 semanas$$\n");
        sb.append("435;;cadastrarLogica;;20,1->21,1;;17,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;21,1->22,1;;17,50 semanas$$\n");
        sb.append("435;;cadastrarLogica;;22,1->23,1;;18,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;23,1->24,1;;18,33 semanas$$\n");
        sb.append("435;;cadastrarLogica;;24,1->25,1;;18,67 semanas$$\n");
        sb.append("435;;cadastrarLogica;;25,1->26,1;;19,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;26,1->27,1;;19,50 semanas$$\n");
        sb.append("435;;cadastrarLogica;;27,1->28,1;;20,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;28,1->29,1;;20,33 semanas$$\n");
        sb.append("435;;cadastrarLogica;;29,1->30,1;;20,67 semanas$$\n");
        sb.append("435;;cadastrarLogica;;30,1->31,1;;21,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;31,1->32,1;;21,50 semanas$$\n");
        sb.append("435;;cadastrarLogica;;32,1->33,1;;22,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;33,1->34,1;;22,50 semanas$$\n");
        sb.append("435;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("435;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;37,1->38,1;;24,50 semanas$$\n");
        sb.append("435;;cadastrarLogica;;38,1->39,1;;25,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;39,1->40,1;;25,50 semanas$$\n");
        sb.append("435;;cadastrarLogica;;40,1->41,1;;26,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;41,1->42,1;;26,50 semanas$$\n");
        sb.append("435;;cadastrarLogica;;42,1->43,1;;27,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;43,1->44,1;;27,50 semanas$$\n");
        sb.append("435;;cadastrarLogica;;44,1->45,1;;28,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;45,1->46,1;;28,50 semanas$$\n");
        sb.append("435;;cadastrarLogica;;46,1->47,1;;29,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;47,1->48,1;;30,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;48,1->49,1;;30,50 semanas$$\n");
        sb.append("435;;cadastrarLogica;;49,1->50,1;;31,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;50,1->51,1;;31,50 semanas$$\n");
        sb.append("435;;cadastrarLogica;;51,1->52,1;;32,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;52,1->53,1;;33,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;53,1->54,1;;33,50 semanas$$\n");
        sb.append("435;;cadastrarLogica;;54,1->55,1;;34,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;55,1->56,1;;35,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;56,1->57,1;;36,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;57,1->58,1;;37,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;58,1->59,1;;38,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;59,1->60,1;;39,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;60,1->61,1;;40,00 semanas$$\n");
        sb.append("435;;cadastrarLogica;;61,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tíbia">

        sb.append("436;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("436;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("436;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;10,1->11,1;;13,50 semanas$$\n");
        sb.append("436;;cadastrarLogica;;11,1->12,1;;14,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;12,1->13,1;;14,33 semanas$$\n");
        sb.append("436;;cadastrarLogica;;13,1->14,1;;14,67 semanas$$\n");
        sb.append("436;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;15,1->16,1;;15,50 semanas$$\n");
        sb.append("436;;cadastrarLogica;;16,1->17,1;;16,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;17,1->18,1;;16,33 semanas$$\n");
        sb.append("436;;cadastrarLogica;;18,1->19,1;;16,67 semanas$$\n");
        sb.append("436;;cadastrarLogica;;19,1->20,1;;17,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;20,1->21,1;;17,50 semanas$$\n");
        sb.append("436;;cadastrarLogica;;21,1->22,1;;18,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;22,1->23,1;;18,33 semanas$$\n");
        sb.append("436;;cadastrarLogica;;23,1->24,1;;18,67 semanas$$\n");
        sb.append("436;;cadastrarLogica;;24,1->25,1;;19,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;25,1->26,1;;19,50 semanas$$\n");
        sb.append("436;;cadastrarLogica;;26,1->27,1;;20,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;27,1->28,1;;20,33 semanas$$\n");
        sb.append("436;;cadastrarLogica;;28,1->29,1;;20,67 semanas$$\n");
        sb.append("436;;cadastrarLogica;;29,1->30,1;;21,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;30,1->31,1;;21,50 semanas$$\n");
        sb.append("436;;cadastrarLogica;;31,1->32,1;;22,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;32,1->33,1;;22,33 semanas$$\n");
        sb.append("436;;cadastrarLogica;;33,1->34,1;;22,67 semanas$$\n");
        sb.append("436;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("436;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;37,1->38,1;;24,33 semanas$$\n");
        sb.append("436;;cadastrarLogica;;38,1->39,1;;24,67 semanas$$\n");
        sb.append("436;;cadastrarLogica;;39,1->40,1;;25,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;40,1->41,1;;25,50 semanas$$\n");
        sb.append("436;;cadastrarLogica;;41,1->42,1;;26,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;42,1->43,1;;26,50 semanas$$\n");
        sb.append("436;;cadastrarLogica;;43,1->44,1;;27,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;44,1->45,1;;27,50 semanas$$\n");
        sb.append("436;;cadastrarLogica;;45,1->46,1;;28,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;46,1->47,1;;28,50 semanas$$\n");
        sb.append("436;;cadastrarLogica;;47,1->48,1;;29,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;48,1->49,1;;29,50 semanas$$\n");
        sb.append("436;;cadastrarLogica;;49,1->50,1;;30,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;50,1->51,1;;30,50 semanas$$\n");
        sb.append("436;;cadastrarLogica;;51,1->52,1;;31,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;52,1->53,1;;31,50 semanas$$\n");
        sb.append("436;;cadastrarLogica;;53,1->54,1;;32,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;54,1->55,1;;33,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;55,1->56,1;;33,50 semanas$$\n");
        sb.append("436;;cadastrarLogica;;56,1->57,1;;34,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;57,1->58,1;;35,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;58,1->59,1;;35,50 semanas$$\n");
        sb.append("436;;cadastrarLogica;;59,1->60,1;;36,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;60,1->61,1;;37,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;61,1->62,1;;37,50 semanas$$\n");
        sb.append("436;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;63,1->64,1;;39,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;64,1->65,1;;39,50 semanas$$\n");
        sb.append("436;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("436;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.A.">

        sb.append("438;;cadastrarLogica;;0,0->39,3;;<11,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;39,3->40,6;;11,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;40,6->41,9;;11,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;41,9->43,2;;11,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;43,2->44,5;;11,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;44,5->45,8;;11,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;45,8->47,0;;11,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;47,0->48,3;;11,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;48,3->49,6;;11,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;49,6->50,9;;11,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;50,9->52,2;;11,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;52,2->53,5;;12,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;53,5->54,8;;12,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;54,8->56,0;;12,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;56,0->57,3;;12,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;57,3->58,6;;12,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;58,6->59,9;;12,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;59,9->61,2;;12,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;61,2->62,4;;12,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;62,4->63,7;;12,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;63,7->65,0;;12,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;65,0->66,3;;13,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;66,3->67,5;;13,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;67,5->68,8;;13,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;68,8->70,1;;13,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;70,1->71,4;;13,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;71,4->72,6;;13,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;72,6->73,9;;13,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;73,9->75,2;;13,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;75,2->76,4;;13,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;76,4->77,7;;13,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;77,7->79,0;;14,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;79,0->80,2;;14,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;80,2->81,4;;14,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;81,4->82,7;;14,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;82,7->84,0;;14,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;84,0->85,2;;14,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;85,2->86,4;;14,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;86,4->87,7;;14,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;87,7->89,0;;14,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;89,0->90,2;;14,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;90,2->91,4;;15,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;91,4->92,7;;15,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;92,7->94,0;;15,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;94,0->95,2;;15,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;95,2->96,4;;15,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;96,4->97,7;;15,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;97,7->99,0;;15,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;99,0->100,2;;15,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;100,2->101,4;;15,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;101,4->102,7;;15,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;102,7->103,9;;16,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;103,9->105,2;;16,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;105,2->106,4;;16,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;106,4->107,6;;16,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;107,6->108,8;;16,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;108,8->110,1;;16,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;110,1->111,3;;16,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;111,3->112,5;;16,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;112,5->113,8;;16,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;113,8->115,0;;16,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;115,0->116,2;;17,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;116,2->117,4;;17,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;117,4->118,7;;17,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;118,7->119,9;;17,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;119,9->121,1;;17,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;121,1->122,3;;17,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;122,3->123,5;;17,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;123,5->124,8;;17,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;124,8->126,0;;17,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;126,0->127,2;;17,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;127,2->128,4;;18,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;128,4->129,6;;18,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;129,6->130,8;;18,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;130,8->132,0;;18,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;132,0->133,2;;18,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;133,2->134,4;;18,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;134,4->135,6;;18,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;135,6->136,8;;18,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;136,8->138,0;;18,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;138,0->139,2;;18,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;139,2->140,4;;19,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;140,4->141,6;;19,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;141,6->142,8;;19,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;142,8->144,0;;19,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;144,0->145,1;;19,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;145,1->146,3;;19,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;146,3->147,5;;19,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;147,5->148,7;;19,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;148,7->149,9;;19,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;149,9->151,1;;19,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;151,1->152,3;;20,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;152,3->153,4;;20,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;153,4->154,6;;20,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;154,6->155,8;;20,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;155,8->157,0;;20,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;157,0->158,1;;20,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;158,1->159,3;;20,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;159,3->160,5;;20,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;160,5->161,6;;20,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;161,6->162,8;;20,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;162,8->164,0;;21,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;164,0->165,1;;21,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;165,1->166,3;;21,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;166,3->167,4;;21,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;167,4->168,6;;21,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;168,6->169,8;;21,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;169,8->170,9;;21,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;170,9->172,1;;21,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;172,1->173,2;;21,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;173,2->174,4;;21,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;174,4->175,5;;22,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;175,5->176,7;;22,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;176,7->177,8;;22,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;177,8->179,0;;22,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;179,0->180,1;;22,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;180,1->181,2;;22,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;181,2->182,4;;22,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;182,4->183,5;;22,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;183,5->184,7;;22,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;184,7->185,8;;22,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;185,8->186,9;;23,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;186,9->188,0;;23,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;188,0->189,2;;23,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;189,2->190,3;;23,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;190,3->191,4;;23,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;191,4->192,5;;23,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;192,5->193,6;;23,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;193,6->194,8;;23,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;194,8->195,9;;23,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;195,9->197,0;;23,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;197,0->198,1;;24,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;198,1->199,2;;24,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;199,2->200,3;;24,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;200,3->201,4;;24,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;201,4->202,5;;24,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;202,5->203,6;;24,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;203,6->204,7;;24,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;204,7->205,8;;24,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;205,8->206,9;;24,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;206,9->208,0;;24,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;208,0->209,1;;25,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;209,1->210,2;;25,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;210,2->211,2;;25,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;211,2->212,3;;25,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;212,3->213,4;;25,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;213,4->214,5;;25,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;214,5->215,6;;25,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;215,6->216,6;;25,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;216,6->217,7;;25,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;217,7->218,8;;25,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;218,8->219,9;;26,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;219,9->220,9;;26,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;220,9->222,0;;26,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;222,0->223,0;;26,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;223,0->224,1;;26,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;224,1->225,2;;26,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;225,2->226,2;;26,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;226,2->227,3;;26,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;227,3->228,3;;26,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;228,3->229,4;;26,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;229,4->230,4;;27,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;230,4->231,5;;27,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;231,5->232,5;;27,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;232,5->233,6;;27,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;233,6->234,6;;27,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;234,6->235,6;;27,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;235,6->236,7;;27,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;236,7->237,7;;27,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;237,7->238,8;;27,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;238,8->239,8;;27,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;239,8->240,8;;28,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;240,8->241,8;;28,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;241,8->242,8;;28,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;242,8->243,8;;28,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;243,8->244,9;;28,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;244,9->245,9;;28,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;245,9->246,9;;28,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;246,9->247,9;;28,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;247,9->248,9;;28,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;248,9->249,9;;28,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;249,9->250,9;;29,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;250,9->251,9;;29,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;251,9->252,9;;29,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;252,9->253,9;;29,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;253,9->254,9;;29,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;254,9->255,8;;29,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;255,8->256,8;;29,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;256,8->257,8;;29,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;257,8->258,8;;29,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;258,8->259,8;;29,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;259,8->260,8;;30,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;260,8->261,7;;30,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;261,7->262,7;;30,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;262,7->263,7;;30,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;263,7->264,6;;30,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;264,6->265,6;;30,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;265,6->266,6;;30,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;266,6->267,6;;30,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;267,6->268,5;;30,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;268,5->269,5;;30,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;269,5->270,4;;31,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;270,4->271,4;;31,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;271,4->272,4;;31,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;272,4->273,3;;31,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;273,3->274,2;;31,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;274,2->275,2;;31,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;275,2->276,2;;31,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;276,2->277,1;;31,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;277,1->278,0;;31,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;278,0->279,0;;31,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;279,0->279,9;;32,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;279,9->280,8;;32,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;280,8->281,7;;32,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;281,7->282,6;;32,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;282,6->283,6;;32,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;283,6->284,5;;32,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;284,5->285,4;;32,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;285,4->286,3;;32,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;286,3->287,2;;32,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;287,2->288,1;;32,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;288,1->289,0;;33,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;289,0->289,9;;33,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;289,9->290,8;;33,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;290,8->291,7;;33,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;291,7->292,6;;33,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;292,6->293,5;;33,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;293,5->294,4;;33,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;294,4->295,3;;33,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;295,3->296,2;;33,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;296,2->297,1;;33,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;297,1->298,0;;34,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;298,0->298,8;;34,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;298,8->299,7;;34,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;299,7->300,5;;34,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;300,5->301,4;;34,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;301,4->302,3;;34,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;302,3->303,1;;34,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;303,1->304,0;;34,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;304,0->304,8;;34,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;304,8->305,7;;34,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;305,7->306,5;;35,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;306,5->307,4;;35,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;307,4->308,2;;35,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;308,2->309,1;;35,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;309,1->309,9;;35,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;309,9->310,7;;35,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;310,7->311,6;;35,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;311,6->312,4;;35,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;312,4->313,3;;35,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;313,3->314,1;;35,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;314,1->314,9;;36,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;314,9->315,7;;36,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;315,7->316,5;;36,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;316,5->317,3;;36,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;317,3->318,1;;36,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;318,1->318,9;;36,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;318,9->319,7;;36,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;319,7->320,5;;36,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;320,5->321,3;;36,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;321,3->322,1;;36,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;322,1->322,9;;37,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;322,9->323,7;;37,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;323,7->324,4;;37,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;324,4->325,2;;37,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;325,2->326,0;;37,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;326,0->326,8;;37,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;326,8->327,6;;37,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;327,6->328,3;;37,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;328,3->329,1;;37,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;329,1->329,9;;37,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;329,9->330,6;;38,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;330,6->331,4;;38,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;331,4->332,2;;38,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;332,2->332,9;;38,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;332,9->333,6;;38,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;333,6->334,4;;38,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;334,4->335,2;;38,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;335,2->335,9;;38,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;335,9->336,6;;38,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;336,6->337,4;;38,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;337,4->338,1;;39,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;338,1->338,8;;39,10 semanas$$\n");
        sb.append("438;;cadastrarLogica;;338,8->339,5;;39,20 semanas$$\n");
        sb.append("438;;cadastrarLogica;;339,5->340,2;;39,30 semanas$$\n");
        sb.append("438;;cadastrarLogica;;340,2->341,0;;39,40 semanas$$\n");
        sb.append("438;;cadastrarLogica;;341,0->341,7;;39,50 semanas$$\n");
        sb.append("438;;cadastrarLogica;;341,7->342,4;;39,60 semanas$$\n");
        sb.append("438;;cadastrarLogica;;342,4->343,1;;39,70 semanas$$\n");
        sb.append("438;;cadastrarLogica;;343,1->343,8;;39,80 semanas$$\n");
        sb.append("438;;cadastrarLogica;;343,8->344,5;;39,90 semanas$$\n");
        sb.append("438;;cadastrarLogica;;344,5->346,1;;40,00 semanas$$\n");
        sb.append("438;;cadastrarLogica;;346,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.C.">

        sb.append("439;;cadastrarLogica;;0,0->53,2;;<11,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;53,2->54,6;;11,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;54,6->56,1;;11,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;56,1->57,5;;11,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;57,5->58,9;;11,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;58,9->60,4;;11,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;60,4->61,8;;11,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;61,8->63,2;;11,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;63,2->64,6;;11,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;64,6->66,1;;11,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;66,1->67,5;;11,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;67,5->68,9;;12,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;68,9->70,4;;12,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;70,4->71,8;;12,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;71,8->73,2;;12,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;73,2->74,6;;12,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;74,6->76,1;;12,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;76,1->77,5;;12,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;77,5->78,9;;12,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;78,9->80,4;;12,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;80,4->81,8;;12,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;81,8->83,2;;13,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;83,2->84,5;;13,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;84,5->85,9;;13,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;85,9->87,3;;13,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;87,3->88,6;;13,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;88,6->90,0;;13,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;90,0->91,4;;13,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;91,4->92,8;;13,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;92,8->94,1;;13,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;94,1->95,5;;13,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;95,5->96,9;;14,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;96,9->98,2;;14,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;98,2->99,6;;14,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;99,6->101,0;;14,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;101,0->102,4;;14,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;102,4->103,7;;14,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;103,7->105,1;;14,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;105,1->106,5;;14,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;106,5->107,8;;14,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;107,8->109,2;;14,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;109,2->110,6;;15,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;110,6->111,9;;15,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;111,9->113,2;;15,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;113,2->114,6;;15,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;114,6->116,0;;15,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;116,0->117,3;;15,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;117,3->118,6;;15,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;118,6->120,0;;15,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;120,0->121,4;;15,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;121,4->122,7;;15,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;122,7->124,0;;16,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;124,0->125,3;;16,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;125,3->126,6;;16,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;126,6->127,9;;16,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;127,9->129,2;;16,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;129,2->130,6;;16,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;130,6->131,9;;16,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;131,9->133,2;;16,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;133,2->134,5;;16,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;134,5->135,8;;16,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;135,8->137,1;;17,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;137,1->138,4;;17,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;138,4->139,7;;17,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;139,7->141,0;;17,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;141,0->142,2;;17,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;142,2->143,5;;17,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;143,5->144,8;;17,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;144,8->146,1;;17,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;146,1->147,4;;17,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;147,4->148,7;;17,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;148,7->150,0;;18,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;150,0->151,2;;18,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;151,2->152,5;;18,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;152,5->153,7;;18,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;153,7->155,0;;18,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;155,0->156,3;;18,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;156,3->157,5;;18,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;157,5->158,8;;18,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;158,8->160,0;;18,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;160,0->161,3;;18,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;161,3->162,5;;19,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;162,5->163,7;;19,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;163,7->165,0;;19,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;165,0->166,2;;19,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;166,2->167,4;;19,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;167,4->168,6;;19,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;168,6->169,8;;19,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;169,8->171,1;;19,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;171,1->172,3;;19,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;172,3->173,5;;19,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;173,5->174,7;;20,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;174,7->175,9;;20,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;175,9->177,1;;20,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;177,1->178,3;;20,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;178,3->179,5;;20,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;179,5->180,7;;20,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;180,7->181,9;;20,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;181,9->183,1;;20,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;183,1->184,3;;20,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;184,3->185,5;;20,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;185,5->186,6;;21,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;186,6->187,8;;21,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;187,8->189,0;;21,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;189,0->190,1;;21,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;190,1->191,2;;21,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;191,2->192,4;;21,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;192,4->193,6;;21,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;193,6->194,7;;21,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;194,7->195,8;;21,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;195,8->197,0;;21,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;197,0->198,1;;22,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;198,1->199,3;;22,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;199,3->200,4;;22,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;200,4->201,5;;22,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;201,5->202,6;;22,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;202,6->203,8;;22,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;203,8->204,9;;22,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;204,9->206,0;;22,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;206,0->207,2;;22,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;207,2->208,3;;22,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;208,3->209,4;;23,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;209,4->210,5;;23,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;210,5->211,5;;23,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;211,5->212,6;;23,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;212,6->213,7;;23,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;213,7->214,8;;23,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;214,8->215,9;;23,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;215,9->216,9;;23,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;216,9->218,0;;23,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;218,0->219,1;;23,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;219,1->220,1;;24,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;220,1->221,2;;24,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;221,2->222,2;;24,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;222,2->223,3;;24,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;223,3->224,3;;24,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;224,3->225,3;;24,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;225,3->226,4;;24,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;226,4->227,4;;24,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;227,4->228,5;;24,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;228,5->229,5;;24,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;229,5->230,5;;25,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;230,5->231,5;;25,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;231,5->232,5;;25,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;232,5->233,5;;25,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;233,5->234,5;;25,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;234,5->235,5;;25,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;235,5->236,5;;25,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;236,5->237,5;;25,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;237,5->238,5;;25,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;238,5->239,5;;25,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;239,5->240,5;;26,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;240,5->241,4;;26,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;241,4->242,4;;26,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;242,4->243,3;;26,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;243,3->244,3;;26,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;244,3->245,3;;26,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;245,3->246,2;;26,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;246,2->247,2;;26,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;247,2->248,1;;26,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;248,1->249,1;;26,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;249,1->250,0;;27,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;250,0->250,9;;27,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;250,9->251,9;;27,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;251,9->252,8;;27,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;252,8->253,7;;27,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;253,7->254,6;;27,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;254,6->255,5;;27,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;255,5->256,5;;27,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;256,5->257,4;;27,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;257,4->258,3;;27,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;258,3->259,2;;28,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;259,2->260,0;;28,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;260,0->260,9;;28,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;260,9->261,7;;28,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;261,7->262,6;;28,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;262,6->263,5;;28,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;263,5->264,3;;28,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;264,3->265,2;;28,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;265,2->266,0;;28,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;266,0->266,9;;28,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;266,9->267,7;;29,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;267,7->268,5;;29,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;268,5->269,4;;29,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;269,4->270,2;;29,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;270,2->271,0;;29,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;271,0->271,8;;29,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;271,8->272,6;;29,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;272,6->273,5;;29,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;273,5->274,3;;29,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;274,3->275,1;;29,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;275,1->275,9;;30,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;275,9->276,6;;30,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;276,6->277,4;;30,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;277,4->278,2;;30,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;278,2->279,0;;30,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;279,0->279,7;;30,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;279,7->280,5;;30,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;280,5->281,3;;30,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;281,3->282,0;;30,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;282,0->282,8;;30,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;282,8->283,5;;31,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;283,5->284,2;;31,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;284,2->284,9;;31,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;284,9->285,6;;31,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;285,6->286,4;;31,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;286,4->287,1;;31,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;287,1->287,8;;31,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;287,8->288,5;;31,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;288,5->289,2;;31,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;289,2->289,9;;31,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;289,9->290,6;;32,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;290,6->291,2;;32,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;291,2->291,9;;32,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;291,9->292,6;;32,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;292,6->293,2;;32,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;293,2->293,9;;32,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;293,9->294,6;;32,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;294,6->295,3;;32,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;295,3->295,9;;32,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;295,9->296,6;;32,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;296,6->297,2;;33,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;297,2->297,8;;33,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;297,8->298,4;;33,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;298,4->299,0;;33,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;299,0->299,6;;33,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;299,6->300,3;;33,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;300,3->300,9;;33,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;300,9->301,5;;33,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;301,5->302,1;;33,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;302,1->302,7;;33,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;302,7->303,2;;34,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;303,2->303,8;;34,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;303,8->304,3;;34,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;304,3->304,9;;34,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;304,9->305,4;;34,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;305,4->306,0;;34,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;306,0->306,6;;34,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;306,6->307,1;;34,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;307,1->307,6;;34,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;307,6->308,2;;34,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;308,2->308,7;;35,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;308,7->309,2;;35,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;309,2->309,7;;35,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;309,7->310,2;;35,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;310,2->310,6;;35,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;310,6->311,1;;35,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;311,1->311,6;;35,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;311,6->312,1;;35,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;312,1->312,6;;35,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;312,6->313,1;;35,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;313,1->313,5;;36,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;313,5->314,0;;36,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;314,0->314,4;;36,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;314,4->314,9;;36,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;314,9->315,3;;36,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;315,3->315,7;;36,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;315,7->316,2;;36,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;316,2->316,6;;36,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;316,6->317,1;;36,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;317,1->317,5;;36,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;317,5->317,9;;37,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;317,9->318,2;;37,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;318,2->318,6;;37,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;318,6->319,0;;37,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;319,0->319,4;;37,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;319,4->319,7;;37,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;319,7->320,1;;37,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;320,1->320,5;;37,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;320,5->320,8;;37,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;320,8->321,2;;37,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;321,2->321,5;;38,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;321,5->321,8;;38,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;321,8->322,1;;38,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;322,1->322,4;;38,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;322,4->322,8;;38,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;322,8->323,1;;38,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;323,1->323,4;;38,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;323,4->323,7;;38,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;323,7->324,0;;38,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;324,0->324,3;;38,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;324,3->324,5;;39,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;324,5->324,8;;39,10 semanas$$\n");
        sb.append("439;;cadastrarLogica;;324,8->325,0;;39,20 semanas$$\n");
        sb.append("439;;cadastrarLogica;;325,0->325,3;;39,30 semanas$$\n");
        sb.append("439;;cadastrarLogica;;325,3->325,5;;39,40 semanas$$\n");
        sb.append("439;;cadastrarLogica;;325,5->325,7;;39,50 semanas$$\n");
        sb.append("439;;cadastrarLogica;;325,7->326,0;;39,60 semanas$$\n");
        sb.append("439;;cadastrarLogica;;326,0->326,2;;39,70 semanas$$\n");
        sb.append("439;;cadastrarLogica;;326,2->326,5;;39,80 semanas$$\n");
        sb.append("439;;cadastrarLogica;;326,5->326,7;;39,90 semanas$$\n");
        sb.append("439;;cadastrarLogica;;326,7->328,1;;40,00 semanas$$\n");
        sb.append("439;;cadastrarLogica;;328,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("437;;cadastrarLogica;;0,0->15,7;;<11,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;15,7->16,0;;11,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;16,0->16,4;;11,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;16,4->16,7;;11,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;16,7->17,1;;11,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;17,1->17,4;;11,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;17,4->17,7;;11,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;17,7->18,1;;11,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;18,1->18,4;;11,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;18,4->18,8;;11,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;18,8->19,1;;11,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;19,1->19,4;;12,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;19,4->19,7;;12,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;19,7->20,1;;12,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;20,1->20,4;;12,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;20,4->20,7;;12,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;20,7->21,0;;12,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;21,0->21,3;;12,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;21,3->21,7;;12,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;21,7->22,0;;12,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;22,0->22,3;;12,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;22,3->22,8;;13,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;22,8->23,2;;13,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;23,2->23,7;;13,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;23,7->24,2;;13,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;24,2->24,6;;13,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;24,6->25,1;;13,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;25,1->25,6;;13,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;25,6->26,1;;13,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;26,1->26,5;;13,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;26,5->27,0;;13,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;27,0->27,4;;14,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;27,4->27,7;;14,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;27,7->28,1;;14,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;28,1->28,5;;14,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;28,5->28,8;;14,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;28,8->29,2;;14,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;29,2->29,6;;14,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;29,6->30,0;;14,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;30,0->30,3;;14,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;30,3->30,7;;14,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;30,7->31,1;;15,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;31,1->31,4;;15,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;31,4->31,8;;15,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;31,8->32,1;;15,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;32,1->32,5;;15,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;32,5->32,9;;15,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;32,9->33,2;;15,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;33,2->33,6;;15,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;33,6->33,9;;15,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;33,9->34,3;;15,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;34,3->34,7;;16,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;34,7->35,0;;16,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;35,0->35,4;;16,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;35,4->35,7;;16,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;35,7->36,1;;16,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;36,1->36,5;;16,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;36,5->36,8;;16,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;36,8->37,2;;16,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;37,2->37,5;;16,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;37,5->37,9;;16,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;37,9->38,2;;17,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;38,2->38,6;;17,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;38,6->38,9;;17,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;38,9->39,3;;17,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;39,3->39,6;;17,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;39,6->39,9;;17,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;39,9->40,3;;17,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;40,3->40,6;;17,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;40,6->41,0;;17,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;41,0->41,3;;17,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;41,3->41,6;;18,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;41,6->42,0;;18,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;42,0->42,3;;18,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;42,3->42,7;;18,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;42,7->43,0;;18,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;43,0->43,3;;18,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;43,3->43,7;;18,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;43,7->44,0;;18,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;44,0->44,4;;18,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;44,4->44,7;;18,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;44,7->45,0;;19,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;45,0->45,4;;19,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;45,4->45,7;;19,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;45,7->46,1;;19,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;46,1->46,4;;19,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;46,4->46,7;;19,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;46,7->47,1;;19,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;47,1->47,4;;19,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;47,4->47,8;;19,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;47,8->48,1;;19,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;48,1->48,4;;20,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;48,4->48,7;;20,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;48,7->49,1;;20,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;49,1->49,4;;20,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;49,4->49,7;;20,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;49,7->50,0;;20,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;50,0->50,3;;20,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;50,3->50,7;;20,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;50,7->51,0;;20,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;51,0->51,3;;20,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;51,3->51,6;;21,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;51,6->51,9;;21,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;51,9->52,3;;21,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;52,3->52,6;;21,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;52,6->52,9;;21,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;52,9->53,2;;21,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;53,2->53,5;;21,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;53,5->53,9;;21,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;53,9->54,2;;21,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;54,2->54,5;;21,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;54,5->54,8;;22,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;54,8->55,1;;22,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;55,1->55,4;;22,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;55,4->55,7;;22,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;55,7->56,0;;22,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;56,0->56,3;;22,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;56,3->56,6;;22,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;56,6->56,9;;22,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;56,9->57,2;;22,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;57,2->57,5;;22,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;57,5->57,8;;23,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;57,8->58,1;;23,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;58,1->58,4;;23,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;58,4->58,7;;23,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;58,7->59,0;;23,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;59,0->59,3;;23,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;59,3->59,6;;23,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;59,6->59,9;;23,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;59,9->60,2;;23,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;60,2->60,5;;23,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;60,5->60,8;;24,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;60,8->61,1;;24,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;61,1->61,4;;24,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;61,4->61,7;;24,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;61,7->62,0;;24,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;62,0->62,2;;24,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;62,2->62,5;;24,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;62,5->62,8;;24,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;62,8->63,1;;24,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;63,1->63,4;;24,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;63,4->63,7;;25,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;63,7->64,0;;25,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;64,0->64,2;;25,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;64,2->64,5;;25,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;64,5->64,8;;25,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;64,8->65,1;;25,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;65,1->65,4;;25,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;65,4->65,6;;25,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;65,6->65,9;;25,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;65,9->66,2;;25,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;66,2->66,5;;26,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;66,5->66,7;;26,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;66,7->67,0;;26,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;67,0->67,3;;26,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;67,3->67,6;;26,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;67,6->67,8;;26,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;67,8->68,1;;26,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;68,1->68,4;;26,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;68,4->68,6;;26,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;68,6->68,9;;26,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;68,9->69,2;;27,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;69,2->69,4;;27,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;69,4->69,6;;27,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;69,6->69,9;;27,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;69,9->70,2;;27,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;70,2->70,4;;27,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;70,4->70,6;;27,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;70,6->70,9;;27,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;70,9->71,2;;27,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;71,2->71,4;;27,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;71,4->71,6;;28,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;71,6->71,9;;28,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;71,9->72,2;;28,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;72,2->72,4;;28,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;72,4->72,6;;28,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;72,6->72,9;;28,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;72,9->73,2;;28,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;73,2->73,4;;28,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;73,4->73,6;;28,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;73,6->73,9;;28,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;73,9->74,1;;29,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;74,1->74,4;;29,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;74,4->74,6;;29,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;74,6->74,8;;29,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;74,8->75,1;;29,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;75,1->75,3;;29,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;75,3->75,5;;29,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;75,5->75,7;;29,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;75,7->76,0;;29,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;76,0->76,2;;29,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;76,2->76,4;;30,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;76,4->76,7;;30,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;76,7->76,9;;30,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;76,9->77,1;;30,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;77,1->77,4;;30,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;77,4->77,6;;30,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;77,6->77,8;;30,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;77,8->78,0;;30,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;78,0->78,3;;30,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;78,3->78,5;;30,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;78,5->78,7;;31,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;78,7->78,9;;31,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;78,9->79,1;;31,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;79,1->79,3;;31,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;79,3->79,6;;31,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;79,6->79,8;;31,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;79,8->80,0;;31,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;80,0->80,2;;31,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;80,2->80,4;;31,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;80,4->80,6;;31,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;80,6->80,8;;32,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;80,8->81,0;;32,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;81,0->81,2;;32,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;81,2->81,4;;32,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;81,4->81,6;;32,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;81,6->81,7;;32,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;81,7->81,9;;32,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;81,9->82,1;;32,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;82,1->82,3;;32,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;82,3->82,5;;32,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;82,5->82,7;;33,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;82,7->82,9;;33,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;82,9->83,1;;33,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;83,1->83,3;;33,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;83,3->83,4;;33,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;83,4->83,6;;33,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;83,6->83,8;;33,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;83,8->84,0;;33,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;84,0->84,2;;33,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;84,2->84,4;;33,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;84,4->84,6;;34,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;84,6->84,7;;34,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;84,7->84,9;;34,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;84,9->85,1;;34,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;85,1->85,2;;34,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;85,2->85,4;;34,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;85,4->85,6;;34,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;85,6->85,8;;34,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;85,8->85,9;;34,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;85,9->86,1;;34,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;86,1->86,2;;35,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;86,2->86,4;;35,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;86,4->86,6;;35,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;86,6->86,7;;35,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;86,7->86,8;;35,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;86,8->87,0;;35,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;87,0->87,1;;35,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;87,1->87,3;;35,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;87,3->87,4;;35,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;87,4->87,6;;35,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;87,6->87,8;;36,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;87,8->87,9;;36,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;87,9->88,0;;36,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;88,0->88,2;;36,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;88,2->88,4;;36,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;88,4->88,5;;36,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;88,5->88,6;;36,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;88,6->88,8;;36,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;88,8->88,9;;36,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;88,9->89,1;;36,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;89,1->89,2;;37,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;89,2->89,3;;37,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;89,3->89,5;;37,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;89,5->89,6;;37,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;89,6->89,7;;37,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;89,7->89,8;;37,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;89,8->89,9;;37,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;89,9->90,1;;37,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;90,1->90,2;;37,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;90,2->90,3;;37,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;90,3->90,4;;38,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;90,4->90,5;;38,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;90,5->90,6;;38,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;90,6->90,7;;38,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;90,7->90,8;;38,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;90,8->91,0;;38,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;91,0->91,1;;38,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;91,1->91,2;;38,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;91,2->91,3;;38,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;91,3->91,4;;38,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;91,4->91,5;;39,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;91,5->91,6;;39,10 semanas$$\n");
        sb.append("437;;cadastrarLogica;;91,6->91,7;;39,20 semanas$$\n");
        sb.append("437;;cadastrarLogica;;91,7->91,8;;39,30 semanas$$\n");
        sb.append("437;;cadastrarLogica;;91,8->91,9;;39,40 semanas$$\n");
        sb.append("437;;cadastrarLogica;;91,9->92,0;;39,50 semanas$$\n");
        sb.append("437;;cadastrarLogica;;92,0->92,1;;39,60 semanas$$\n");
        sb.append("437;;cadastrarLogica;;92,1->92,2;;39,70 semanas$$\n");
        sb.append("437;;cadastrarLogica;;92,2->92,3;;39,80 semanas$$\n");
        sb.append("437;;cadastrarLogica;;92,3->92,4;;39,90 semanas$$\n");
        sb.append("437;;cadastrarLogica;;92,4->93,1;;40,00 semanas$$\n");
        sb.append("437;;cadastrarLogica;;93,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

    }

    private static void preencherIghFeto2 ()
    {

        // <editor-fold defaultstate="collapsed" desc="Fêmur">

        sb.append("440;;cadastrarLogica;;0,0->7,1;;<12,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;7,1->8,1;;12,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;8,1->9,1;;12,33 semanas$$\n");
        sb.append("440;;cadastrarLogica;;9,1->10,1;;12,67 semanas$$\n");
        sb.append("440;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("440;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("440;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("440;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("440;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("440;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("440;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;20,1->21,1;;16,33 semanas$$\n");
        sb.append("440;;cadastrarLogica;;21,1->22,1;;16,67 semanas$$\n");
        sb.append("440;;cadastrarLogica;;22,1->23,1;;17,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;23,1->24,1;;17,50 semanas$$\n");
        sb.append("440;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("440;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("440;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;28,1->29,1;;19,33 semanas$$\n");
        sb.append("440;;cadastrarLogica;;29,1->30,1;;19,67 semanas$$\n");
        sb.append("440;;cadastrarLogica;;30,1->31,1;;20,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;31,1->32,1;;20,33 semanas$$\n");
        sb.append("440;;cadastrarLogica;;32,1->33,1;;20,67 semanas$$\n");
        sb.append("440;;cadastrarLogica;;33,1->34,1;;21,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;34,1->35,1;;21,50 semanas$$\n");
        sb.append("440;;cadastrarLogica;;35,1->36,1;;22,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;36,1->37,1;;22,33 semanas$$\n");
        sb.append("440;;cadastrarLogica;;37,1->38,1;;22,67 semanas$$\n");
        sb.append("440;;cadastrarLogica;;38,1->39,1;;23,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;39,1->40,1;;23,33 semanas$$\n");
        sb.append("440;;cadastrarLogica;;40,1->41,1;;23,67 semanas$$\n");
        sb.append("440;;cadastrarLogica;;41,1->42,1;;24,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;42,1->43,1;;24,50 semanas$$\n");
        sb.append("440;;cadastrarLogica;;43,1->44,1;;25,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;44,1->45,1;;25,33 semanas$$\n");
        sb.append("440;;cadastrarLogica;;45,1->46,1;;25,67 semanas$$\n");
        sb.append("440;;cadastrarLogica;;46,1->47,1;;26,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;47,1->48,1;;26,50 semanas$$\n");
        sb.append("440;;cadastrarLogica;;48,1->49,1;;27,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;49,1->50,1;;27,33 semanas$$\n");
        sb.append("440;;cadastrarLogica;;50,1->51,1;;27,67 semanas$$\n");
        sb.append("440;;cadastrarLogica;;51,1->52,1;;28,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;52,1->53,1;;28,50 semanas$$\n");
        sb.append("440;;cadastrarLogica;;53,1->54,1;;29,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;54,1->55,1;;29,50 semanas$$\n");
        sb.append("440;;cadastrarLogica;;55,1->56,1;;30,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;56,1->57,1;;30,33 semanas$$\n");
        sb.append("440;;cadastrarLogica;;57,1->58,1;;30,67 semanas$$\n");
        sb.append("440;;cadastrarLogica;;58,1->59,1;;31,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;59,1->60,1;;31,50 semanas$$\n");
        sb.append("440;;cadastrarLogica;;60,1->61,1;;32,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;61,1->62,1;;32,50 semanas$$\n");
        sb.append("440;;cadastrarLogica;;62,1->63,1;;33,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;63,1->64,1;;33,50 semanas$$\n");
        sb.append("440;;cadastrarLogica;;64,1->65,1;;34,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;65,1->66,1;;34,50 semanas$$\n");
        sb.append("440;;cadastrarLogica;;66,1->67,1;;35,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;67,1->68,1;;36,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;68,1->69,1;;36,50 semanas$$\n");
        sb.append("440;;cadastrarLogica;;69,1->70,1;;37,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;70,1->71,1;;38,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;71,1->72,1;;38,50 semanas$$\n");
        sb.append("440;;cadastrarLogica;;72,1->73,1;;39,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;73,1->74,1;;40,00 semanas$$\n");
        sb.append("440;;cadastrarLogica;;74,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Úmero">

        sb.append("441;;cadastrarLogica;;0,0->8,1;;<12,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;8,1->9,1;;12,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;9,1->10,1;;12,50 semanas$$\n");
        sb.append("441;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("441;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("441;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("441;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("441;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("441;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("441;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;20,1->21,1;;16,50 semanas$$\n");
        sb.append("441;;cadastrarLogica;;21,1->22,1;;17,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;22,1->23,1;;17,33 semanas$$\n");
        sb.append("441;;cadastrarLogica;;23,1->24,1;;17,67 semanas$$\n");
        sb.append("441;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("441;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("441;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;28,1->29,1;;19,50 semanas$$\n");
        sb.append("441;;cadastrarLogica;;29,1->30,1;;20,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;30,1->31,1;;20,33 semanas$$\n");
        sb.append("441;;cadastrarLogica;;31,1->32,1;;20,67 semanas$$\n");
        sb.append("441;;cadastrarLogica;;32,1->33,1;;21,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;33,1->34,1;;21,50 semanas$$\n");
        sb.append("441;;cadastrarLogica;;34,1->35,1;;22,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;35,1->36,1;;22,33 semanas$$\n");
        sb.append("441;;cadastrarLogica;;36,1->37,1;;22,67 semanas$$\n");
        sb.append("441;;cadastrarLogica;;37,1->38,1;;23,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;38,1->39,1;;23,50 semanas$$\n");
        sb.append("441;;cadastrarLogica;;39,1->40,1;;24,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;40,1->41,1;;24,50 semanas$$\n");
        sb.append("441;;cadastrarLogica;;41,1->42,1;;25,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;42,1->43,1;;25,50 semanas$$\n");
        sb.append("441;;cadastrarLogica;;43,1->44,1;;26,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;44,1->45,1;;26,50 semanas$$\n");
        sb.append("441;;cadastrarLogica;;45,1->46,1;;27,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;46,1->47,1;;27,50 semanas$$\n");
        sb.append("441;;cadastrarLogica;;47,1->48,1;;28,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;48,1->49,1;;28,50 semanas$$\n");
        sb.append("441;;cadastrarLogica;;49,1->50,1;;29,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;50,1->51,1;;30,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;51,1->52,1;;30,50 semanas$$\n");
        sb.append("441;;cadastrarLogica;;52,1->53,1;;31,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;53,1->54,1;;31,50 semanas$$\n");
        sb.append("441;;cadastrarLogica;;54,1->55,1;;32,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;55,1->56,1;;33,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;56,1->57,1;;33,50 semanas$$\n");
        sb.append("441;;cadastrarLogica;;57,1->58,1;;34,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;58,1->59,1;;35,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;59,1->60,1;;35,50 semanas$$\n");
        sb.append("441;;cadastrarLogica;;60,1->61,1;;36,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;61,1->62,1;;37,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;63,1->64,1;;38,50 semanas$$\n");
        sb.append("441;;cadastrarLogica;;64,1->65,1;;39,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("441;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ulna">

        sb.append("442;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("442;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("442;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;10,1->11,1;;13,33 semanas$$\n");
        sb.append("442;;cadastrarLogica;;11,1->12,1;;13,67 semanas$$\n");
        sb.append("442;;cadastrarLogica;;12,1->13,1;;14,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;13,1->14,1;;14,50 semanas$$\n");
        sb.append("442;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;15,1->16,1;;15,33 semanas$$\n");
        sb.append("442;;cadastrarLogica;;16,1->17,1;;15,67 semanas$$\n");
        sb.append("442;;cadastrarLogica;;17,1->18,1;;16,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;18,1->19,1;;16,33 semanas$$\n");
        sb.append("442;;cadastrarLogica;;19,1->20,1;;16,67 semanas$$\n");
        sb.append("442;;cadastrarLogica;;20,1->21,1;;17,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;21,1->22,1;;17,50 semanas$$\n");
        sb.append("442;;cadastrarLogica;;22,1->23,1;;18,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;23,1->24,1;;18,33 semanas$$\n");
        sb.append("442;;cadastrarLogica;;24,1->25,1;;18,67 semanas$$\n");
        sb.append("442;;cadastrarLogica;;25,1->26,1;;19,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;26,1->27,1;;19,50 semanas$$\n");
        sb.append("442;;cadastrarLogica;;27,1->28,1;;20,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;28,1->29,1;;20,33 semanas$$\n");
        sb.append("442;;cadastrarLogica;;29,1->30,1;;20,67 semanas$$\n");
        sb.append("442;;cadastrarLogica;;30,1->31,1;;21,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;31,1->32,1;;21,50 semanas$$\n");
        sb.append("442;;cadastrarLogica;;32,1->33,1;;22,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;33,1->34,1;;22,50 semanas$$\n");
        sb.append("442;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("442;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;37,1->38,1;;24,50 semanas$$\n");
        sb.append("442;;cadastrarLogica;;38,1->39,1;;25,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;39,1->40,1;;25,50 semanas$$\n");
        sb.append("442;;cadastrarLogica;;40,1->41,1;;26,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;41,1->42,1;;26,50 semanas$$\n");
        sb.append("442;;cadastrarLogica;;42,1->43,1;;27,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;43,1->44,1;;27,50 semanas$$\n");
        sb.append("442;;cadastrarLogica;;44,1->45,1;;28,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;45,1->46,1;;28,50 semanas$$\n");
        sb.append("442;;cadastrarLogica;;46,1->47,1;;29,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;47,1->48,1;;30,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;48,1->49,1;;30,50 semanas$$\n");
        sb.append("442;;cadastrarLogica;;49,1->50,1;;31,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;50,1->51,1;;31,50 semanas$$\n");
        sb.append("442;;cadastrarLogica;;51,1->52,1;;32,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;52,1->53,1;;33,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;53,1->54,1;;33,50 semanas$$\n");
        sb.append("442;;cadastrarLogica;;54,1->55,1;;34,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;55,1->56,1;;35,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;56,1->57,1;;36,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;57,1->58,1;;37,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;58,1->59,1;;38,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;59,1->60,1;;39,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;60,1->61,1;;40,00 semanas$$\n");
        sb.append("442;;cadastrarLogica;;61,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tíbia">

        sb.append("443;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("443;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("443;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;10,1->11,1;;13,50 semanas$$\n");
        sb.append("443;;cadastrarLogica;;11,1->12,1;;14,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;12,1->13,1;;14,33 semanas$$\n");
        sb.append("443;;cadastrarLogica;;13,1->14,1;;14,67 semanas$$\n");
        sb.append("443;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;15,1->16,1;;15,50 semanas$$\n");
        sb.append("443;;cadastrarLogica;;16,1->17,1;;16,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;17,1->18,1;;16,33 semanas$$\n");
        sb.append("443;;cadastrarLogica;;18,1->19,1;;16,67 semanas$$\n");
        sb.append("443;;cadastrarLogica;;19,1->20,1;;17,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;20,1->21,1;;17,50 semanas$$\n");
        sb.append("443;;cadastrarLogica;;21,1->22,1;;18,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;22,1->23,1;;18,33 semanas$$\n");
        sb.append("443;;cadastrarLogica;;23,1->24,1;;18,67 semanas$$\n");
        sb.append("443;;cadastrarLogica;;24,1->25,1;;19,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;25,1->26,1;;19,50 semanas$$\n");
        sb.append("443;;cadastrarLogica;;26,1->27,1;;20,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;27,1->28,1;;20,33 semanas$$\n");
        sb.append("443;;cadastrarLogica;;28,1->29,1;;20,67 semanas$$\n");
        sb.append("443;;cadastrarLogica;;29,1->30,1;;21,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;30,1->31,1;;21,50 semanas$$\n");
        sb.append("443;;cadastrarLogica;;31,1->32,1;;22,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;32,1->33,1;;22,33 semanas$$\n");
        sb.append("443;;cadastrarLogica;;33,1->34,1;;22,67 semanas$$\n");
        sb.append("443;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("443;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;37,1->38,1;;24,33 semanas$$\n");
        sb.append("443;;cadastrarLogica;;38,1->39,1;;24,67 semanas$$\n");
        sb.append("443;;cadastrarLogica;;39,1->40,1;;25,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;40,1->41,1;;25,50 semanas$$\n");
        sb.append("443;;cadastrarLogica;;41,1->42,1;;26,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;42,1->43,1;;26,50 semanas$$\n");
        sb.append("443;;cadastrarLogica;;43,1->44,1;;27,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;44,1->45,1;;27,50 semanas$$\n");
        sb.append("443;;cadastrarLogica;;45,1->46,1;;28,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;46,1->47,1;;28,50 semanas$$\n");
        sb.append("443;;cadastrarLogica;;47,1->48,1;;29,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;48,1->49,1;;29,50 semanas$$\n");
        sb.append("443;;cadastrarLogica;;49,1->50,1;;30,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;50,1->51,1;;30,50 semanas$$\n");
        sb.append("443;;cadastrarLogica;;51,1->52,1;;31,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;52,1->53,1;;31,50 semanas$$\n");
        sb.append("443;;cadastrarLogica;;53,1->54,1;;32,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;54,1->55,1;;33,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;55,1->56,1;;33,50 semanas$$\n");
        sb.append("443;;cadastrarLogica;;56,1->57,1;;34,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;57,1->58,1;;35,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;58,1->59,1;;35,50 semanas$$\n");
        sb.append("443;;cadastrarLogica;;59,1->60,1;;36,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;60,1->61,1;;37,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;61,1->62,1;;37,50 semanas$$\n");
        sb.append("443;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;63,1->64,1;;39,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;64,1->65,1;;39,50 semanas$$\n");
        sb.append("443;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("443;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.A.">

        sb.append("445;;cadastrarLogica;;0,0->39,3;;<11,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;39,3->40,6;;11,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;40,6->41,9;;11,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;41,9->43,2;;11,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;43,2->44,5;;11,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;44,5->45,8;;11,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;45,8->47,0;;11,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;47,0->48,3;;11,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;48,3->49,6;;11,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;49,6->50,9;;11,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;50,9->52,2;;11,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;52,2->53,5;;12,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;53,5->54,8;;12,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;54,8->56,0;;12,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;56,0->57,3;;12,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;57,3->58,6;;12,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;58,6->59,9;;12,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;59,9->61,2;;12,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;61,2->62,4;;12,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;62,4->63,7;;12,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;63,7->65,0;;12,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;65,0->66,3;;13,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;66,3->67,5;;13,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;67,5->68,8;;13,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;68,8->70,1;;13,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;70,1->71,4;;13,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;71,4->72,6;;13,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;72,6->73,9;;13,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;73,9->75,2;;13,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;75,2->76,4;;13,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;76,4->77,7;;13,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;77,7->79,0;;14,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;79,0->80,2;;14,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;80,2->81,4;;14,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;81,4->82,7;;14,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;82,7->84,0;;14,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;84,0->85,2;;14,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;85,2->86,4;;14,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;86,4->87,7;;14,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;87,7->89,0;;14,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;89,0->90,2;;14,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;90,2->91,4;;15,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;91,4->92,7;;15,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;92,7->94,0;;15,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;94,0->95,2;;15,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;95,2->96,4;;15,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;96,4->97,7;;15,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;97,7->99,0;;15,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;99,0->100,2;;15,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;100,2->101,4;;15,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;101,4->102,7;;15,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;102,7->103,9;;16,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;103,9->105,2;;16,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;105,2->106,4;;16,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;106,4->107,6;;16,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;107,6->108,8;;16,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;108,8->110,1;;16,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;110,1->111,3;;16,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;111,3->112,5;;16,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;112,5->113,8;;16,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;113,8->115,0;;16,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;115,0->116,2;;17,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;116,2->117,4;;17,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;117,4->118,7;;17,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;118,7->119,9;;17,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;119,9->121,1;;17,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;121,1->122,3;;17,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;122,3->123,5;;17,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;123,5->124,8;;17,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;124,8->126,0;;17,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;126,0->127,2;;17,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;127,2->128,4;;18,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;128,4->129,6;;18,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;129,6->130,8;;18,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;130,8->132,0;;18,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;132,0->133,2;;18,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;133,2->134,4;;18,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;134,4->135,6;;18,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;135,6->136,8;;18,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;136,8->138,0;;18,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;138,0->139,2;;18,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;139,2->140,4;;19,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;140,4->141,6;;19,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;141,6->142,8;;19,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;142,8->144,0;;19,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;144,0->145,1;;19,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;145,1->146,3;;19,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;146,3->147,5;;19,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;147,5->148,7;;19,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;148,7->149,9;;19,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;149,9->151,1;;19,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;151,1->152,3;;20,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;152,3->153,4;;20,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;153,4->154,6;;20,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;154,6->155,8;;20,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;155,8->157,0;;20,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;157,0->158,1;;20,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;158,1->159,3;;20,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;159,3->160,5;;20,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;160,5->161,6;;20,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;161,6->162,8;;20,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;162,8->164,0;;21,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;164,0->165,1;;21,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;165,1->166,3;;21,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;166,3->167,4;;21,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;167,4->168,6;;21,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;168,6->169,8;;21,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;169,8->170,9;;21,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;170,9->172,1;;21,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;172,1->173,2;;21,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;173,2->174,4;;21,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;174,4->175,5;;22,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;175,5->176,7;;22,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;176,7->177,8;;22,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;177,8->179,0;;22,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;179,0->180,1;;22,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;180,1->181,2;;22,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;181,2->182,4;;22,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;182,4->183,5;;22,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;183,5->184,7;;22,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;184,7->185,8;;22,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;185,8->186,9;;23,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;186,9->188,0;;23,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;188,0->189,2;;23,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;189,2->190,3;;23,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;190,3->191,4;;23,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;191,4->192,5;;23,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;192,5->193,6;;23,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;193,6->194,8;;23,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;194,8->195,9;;23,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;195,9->197,0;;23,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;197,0->198,1;;24,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;198,1->199,2;;24,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;199,2->200,3;;24,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;200,3->201,4;;24,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;201,4->202,5;;24,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;202,5->203,6;;24,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;203,6->204,7;;24,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;204,7->205,8;;24,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;205,8->206,9;;24,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;206,9->208,0;;24,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;208,0->209,1;;25,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;209,1->210,2;;25,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;210,2->211,2;;25,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;211,2->212,3;;25,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;212,3->213,4;;25,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;213,4->214,5;;25,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;214,5->215,6;;25,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;215,6->216,6;;25,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;216,6->217,7;;25,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;217,7->218,8;;25,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;218,8->219,9;;26,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;219,9->220,9;;26,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;220,9->222,0;;26,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;222,0->223,0;;26,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;223,0->224,1;;26,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;224,1->225,2;;26,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;225,2->226,2;;26,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;226,2->227,3;;26,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;227,3->228,3;;26,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;228,3->229,4;;26,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;229,4->230,4;;27,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;230,4->231,5;;27,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;231,5->232,5;;27,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;232,5->233,6;;27,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;233,6->234,6;;27,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;234,6->235,6;;27,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;235,6->236,7;;27,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;236,7->237,7;;27,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;237,7->238,8;;27,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;238,8->239,8;;27,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;239,8->240,8;;28,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;240,8->241,8;;28,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;241,8->242,8;;28,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;242,8->243,8;;28,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;243,8->244,9;;28,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;244,9->245,9;;28,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;245,9->246,9;;28,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;246,9->247,9;;28,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;247,9->248,9;;28,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;248,9->249,9;;28,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;249,9->250,9;;29,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;250,9->251,9;;29,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;251,9->252,9;;29,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;252,9->253,9;;29,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;253,9->254,9;;29,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;254,9->255,8;;29,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;255,8->256,8;;29,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;256,8->257,8;;29,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;257,8->258,8;;29,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;258,8->259,8;;29,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;259,8->260,8;;30,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;260,8->261,7;;30,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;261,7->262,7;;30,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;262,7->263,7;;30,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;263,7->264,6;;30,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;264,6->265,6;;30,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;265,6->266,6;;30,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;266,6->267,6;;30,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;267,6->268,5;;30,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;268,5->269,5;;30,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;269,5->270,4;;31,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;270,4->271,4;;31,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;271,4->272,4;;31,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;272,4->273,3;;31,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;273,3->274,2;;31,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;274,2->275,2;;31,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;275,2->276,2;;31,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;276,2->277,1;;31,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;277,1->278,0;;31,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;278,0->279,0;;31,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;279,0->279,9;;32,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;279,9->280,8;;32,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;280,8->281,7;;32,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;281,7->282,6;;32,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;282,6->283,6;;32,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;283,6->284,5;;32,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;284,5->285,4;;32,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;285,4->286,3;;32,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;286,3->287,2;;32,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;287,2->288,1;;32,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;288,1->289,0;;33,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;289,0->289,9;;33,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;289,9->290,8;;33,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;290,8->291,7;;33,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;291,7->292,6;;33,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;292,6->293,5;;33,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;293,5->294,4;;33,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;294,4->295,3;;33,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;295,3->296,2;;33,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;296,2->297,1;;33,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;297,1->298,0;;34,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;298,0->298,8;;34,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;298,8->299,7;;34,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;299,7->300,5;;34,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;300,5->301,4;;34,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;301,4->302,3;;34,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;302,3->303,1;;34,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;303,1->304,0;;34,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;304,0->304,8;;34,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;304,8->305,7;;34,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;305,7->306,5;;35,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;306,5->307,4;;35,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;307,4->308,2;;35,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;308,2->309,1;;35,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;309,1->309,9;;35,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;309,9->310,7;;35,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;310,7->311,6;;35,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;311,6->312,4;;35,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;312,4->313,3;;35,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;313,3->314,1;;35,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;314,1->314,9;;36,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;314,9->315,7;;36,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;315,7->316,5;;36,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;316,5->317,3;;36,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;317,3->318,1;;36,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;318,1->318,9;;36,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;318,9->319,7;;36,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;319,7->320,5;;36,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;320,5->321,3;;36,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;321,3->322,1;;36,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;322,1->322,9;;37,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;322,9->323,7;;37,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;323,7->324,4;;37,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;324,4->325,2;;37,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;325,2->326,0;;37,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;326,0->326,8;;37,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;326,8->327,6;;37,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;327,6->328,3;;37,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;328,3->329,1;;37,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;329,1->329,9;;37,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;329,9->330,6;;38,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;330,6->331,4;;38,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;331,4->332,2;;38,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;332,2->332,9;;38,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;332,9->333,6;;38,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;333,6->334,4;;38,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;334,4->335,2;;38,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;335,2->335,9;;38,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;335,9->336,6;;38,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;336,6->337,4;;38,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;337,4->338,1;;39,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;338,1->338,8;;39,10 semanas$$\n");
        sb.append("445;;cadastrarLogica;;338,8->339,5;;39,20 semanas$$\n");
        sb.append("445;;cadastrarLogica;;339,5->340,2;;39,30 semanas$$\n");
        sb.append("445;;cadastrarLogica;;340,2->341,0;;39,40 semanas$$\n");
        sb.append("445;;cadastrarLogica;;341,0->341,7;;39,50 semanas$$\n");
        sb.append("445;;cadastrarLogica;;341,7->342,4;;39,60 semanas$$\n");
        sb.append("445;;cadastrarLogica;;342,4->343,1;;39,70 semanas$$\n");
        sb.append("445;;cadastrarLogica;;343,1->343,8;;39,80 semanas$$\n");
        sb.append("445;;cadastrarLogica;;343,8->344,5;;39,90 semanas$$\n");
        sb.append("445;;cadastrarLogica;;344,5->346,1;;40,00 semanas$$\n");
        sb.append("445;;cadastrarLogica;;346,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.C.">

        sb.append("446;;cadastrarLogica;;0,0->53,2;;<11,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;53,2->54,6;;11,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;54,6->56,1;;11,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;56,1->57,5;;11,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;57,5->58,9;;11,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;58,9->60,4;;11,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;60,4->61,8;;11,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;61,8->63,2;;11,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;63,2->64,6;;11,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;64,6->66,1;;11,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;66,1->67,5;;11,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;67,5->68,9;;12,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;68,9->70,4;;12,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;70,4->71,8;;12,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;71,8->73,2;;12,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;73,2->74,6;;12,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;74,6->76,1;;12,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;76,1->77,5;;12,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;77,5->78,9;;12,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;78,9->80,4;;12,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;80,4->81,8;;12,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;81,8->83,2;;13,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;83,2->84,5;;13,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;84,5->85,9;;13,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;85,9->87,3;;13,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;87,3->88,6;;13,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;88,6->90,0;;13,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;90,0->91,4;;13,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;91,4->92,8;;13,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;92,8->94,1;;13,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;94,1->95,5;;13,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;95,5->96,9;;14,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;96,9->98,2;;14,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;98,2->99,6;;14,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;99,6->101,0;;14,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;101,0->102,4;;14,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;102,4->103,7;;14,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;103,7->105,1;;14,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;105,1->106,5;;14,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;106,5->107,8;;14,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;107,8->109,2;;14,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;109,2->110,6;;15,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;110,6->111,9;;15,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;111,9->113,2;;15,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;113,2->114,6;;15,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;114,6->116,0;;15,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;116,0->117,3;;15,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;117,3->118,6;;15,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;118,6->120,0;;15,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;120,0->121,4;;15,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;121,4->122,7;;15,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;122,7->124,0;;16,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;124,0->125,3;;16,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;125,3->126,6;;16,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;126,6->127,9;;16,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;127,9->129,2;;16,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;129,2->130,6;;16,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;130,6->131,9;;16,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;131,9->133,2;;16,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;133,2->134,5;;16,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;134,5->135,8;;16,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;135,8->137,1;;17,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;137,1->138,4;;17,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;138,4->139,7;;17,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;139,7->141,0;;17,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;141,0->142,2;;17,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;142,2->143,5;;17,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;143,5->144,8;;17,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;144,8->146,1;;17,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;146,1->147,4;;17,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;147,4->148,7;;17,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;148,7->150,0;;18,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;150,0->151,2;;18,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;151,2->152,5;;18,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;152,5->153,7;;18,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;153,7->155,0;;18,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;155,0->156,3;;18,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;156,3->157,5;;18,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;157,5->158,8;;18,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;158,8->160,0;;18,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;160,0->161,3;;18,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;161,3->162,5;;19,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;162,5->163,7;;19,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;163,7->165,0;;19,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;165,0->166,2;;19,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;166,2->167,4;;19,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;167,4->168,6;;19,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;168,6->169,8;;19,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;169,8->171,1;;19,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;171,1->172,3;;19,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;172,3->173,5;;19,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;173,5->174,7;;20,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;174,7->175,9;;20,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;175,9->177,1;;20,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;177,1->178,3;;20,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;178,3->179,5;;20,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;179,5->180,7;;20,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;180,7->181,9;;20,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;181,9->183,1;;20,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;183,1->184,3;;20,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;184,3->185,5;;20,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;185,5->186,6;;21,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;186,6->187,8;;21,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;187,8->189,0;;21,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;189,0->190,1;;21,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;190,1->191,2;;21,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;191,2->192,4;;21,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;192,4->193,6;;21,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;193,6->194,7;;21,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;194,7->195,8;;21,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;195,8->197,0;;21,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;197,0->198,1;;22,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;198,1->199,3;;22,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;199,3->200,4;;22,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;200,4->201,5;;22,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;201,5->202,6;;22,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;202,6->203,8;;22,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;203,8->204,9;;22,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;204,9->206,0;;22,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;206,0->207,2;;22,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;207,2->208,3;;22,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;208,3->209,4;;23,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;209,4->210,5;;23,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;210,5->211,5;;23,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;211,5->212,6;;23,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;212,6->213,7;;23,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;213,7->214,8;;23,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;214,8->215,9;;23,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;215,9->216,9;;23,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;216,9->218,0;;23,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;218,0->219,1;;23,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;219,1->220,1;;24,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;220,1->221,2;;24,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;221,2->222,2;;24,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;222,2->223,3;;24,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;223,3->224,3;;24,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;224,3->225,3;;24,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;225,3->226,4;;24,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;226,4->227,4;;24,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;227,4->228,5;;24,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;228,5->229,5;;24,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;229,5->230,5;;25,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;230,5->231,5;;25,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;231,5->232,5;;25,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;232,5->233,5;;25,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;233,5->234,5;;25,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;234,5->235,5;;25,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;235,5->236,5;;25,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;236,5->237,5;;25,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;237,5->238,5;;25,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;238,5->239,5;;25,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;239,5->240,5;;26,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;240,5->241,4;;26,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;241,4->242,4;;26,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;242,4->243,3;;26,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;243,3->244,3;;26,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;244,3->245,3;;26,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;245,3->246,2;;26,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;246,2->247,2;;26,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;247,2->248,1;;26,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;248,1->249,1;;26,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;249,1->250,0;;27,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;250,0->250,9;;27,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;250,9->251,9;;27,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;251,9->252,8;;27,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;252,8->253,7;;27,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;253,7->254,6;;27,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;254,6->255,5;;27,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;255,5->256,5;;27,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;256,5->257,4;;27,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;257,4->258,3;;27,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;258,3->259,2;;28,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;259,2->260,0;;28,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;260,0->260,9;;28,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;260,9->261,7;;28,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;261,7->262,6;;28,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;262,6->263,5;;28,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;263,5->264,3;;28,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;264,3->265,2;;28,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;265,2->266,0;;28,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;266,0->266,9;;28,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;266,9->267,7;;29,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;267,7->268,5;;29,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;268,5->269,4;;29,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;269,4->270,2;;29,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;270,2->271,0;;29,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;271,0->271,8;;29,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;271,8->272,6;;29,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;272,6->273,5;;29,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;273,5->274,3;;29,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;274,3->275,1;;29,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;275,1->275,9;;30,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;275,9->276,6;;30,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;276,6->277,4;;30,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;277,4->278,2;;30,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;278,2->279,0;;30,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;279,0->279,7;;30,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;279,7->280,5;;30,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;280,5->281,3;;30,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;281,3->282,0;;30,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;282,0->282,8;;30,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;282,8->283,5;;31,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;283,5->284,2;;31,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;284,2->284,9;;31,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;284,9->285,6;;31,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;285,6->286,4;;31,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;286,4->287,1;;31,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;287,1->287,8;;31,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;287,8->288,5;;31,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;288,5->289,2;;31,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;289,2->289,9;;31,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;289,9->290,6;;32,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;290,6->291,2;;32,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;291,2->291,9;;32,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;291,9->292,6;;32,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;292,6->293,2;;32,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;293,2->293,9;;32,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;293,9->294,6;;32,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;294,6->295,3;;32,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;295,3->295,9;;32,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;295,9->296,6;;32,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;296,6->297,2;;33,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;297,2->297,8;;33,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;297,8->298,4;;33,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;298,4->299,0;;33,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;299,0->299,6;;33,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;299,6->300,3;;33,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;300,3->300,9;;33,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;300,9->301,5;;33,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;301,5->302,1;;33,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;302,1->302,7;;33,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;302,7->303,2;;34,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;303,2->303,8;;34,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;303,8->304,3;;34,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;304,3->304,9;;34,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;304,9->305,4;;34,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;305,4->306,0;;34,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;306,0->306,6;;34,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;306,6->307,1;;34,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;307,1->307,6;;34,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;307,6->308,2;;34,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;308,2->308,7;;35,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;308,7->309,2;;35,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;309,2->309,7;;35,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;309,7->310,2;;35,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;310,2->310,6;;35,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;310,6->311,1;;35,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;311,1->311,6;;35,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;311,6->312,1;;35,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;312,1->312,6;;35,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;312,6->313,1;;35,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;313,1->313,5;;36,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;313,5->314,0;;36,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;314,0->314,4;;36,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;314,4->314,9;;36,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;314,9->315,3;;36,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;315,3->315,7;;36,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;315,7->316,2;;36,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;316,2->316,6;;36,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;316,6->317,1;;36,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;317,1->317,5;;36,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;317,5->317,9;;37,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;317,9->318,2;;37,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;318,2->318,6;;37,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;318,6->319,0;;37,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;319,0->319,4;;37,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;319,4->319,7;;37,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;319,7->320,1;;37,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;320,1->320,5;;37,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;320,5->320,8;;37,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;320,8->321,2;;37,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;321,2->321,5;;38,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;321,5->321,8;;38,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;321,8->322,1;;38,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;322,1->322,4;;38,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;322,4->322,8;;38,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;322,8->323,1;;38,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;323,1->323,4;;38,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;323,4->323,7;;38,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;323,7->324,0;;38,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;324,0->324,3;;38,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;324,3->324,5;;39,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;324,5->324,8;;39,10 semanas$$\n");
        sb.append("446;;cadastrarLogica;;324,8->325,0;;39,20 semanas$$\n");
        sb.append("446;;cadastrarLogica;;325,0->325,3;;39,30 semanas$$\n");
        sb.append("446;;cadastrarLogica;;325,3->325,5;;39,40 semanas$$\n");
        sb.append("446;;cadastrarLogica;;325,5->325,7;;39,50 semanas$$\n");
        sb.append("446;;cadastrarLogica;;325,7->326,0;;39,60 semanas$$\n");
        sb.append("446;;cadastrarLogica;;326,0->326,2;;39,70 semanas$$\n");
        sb.append("446;;cadastrarLogica;;326,2->326,5;;39,80 semanas$$\n");
        sb.append("446;;cadastrarLogica;;326,5->326,7;;39,90 semanas$$\n");
        sb.append("446;;cadastrarLogica;;326,7->328,1;;40,00 semanas$$\n");
        sb.append("446;;cadastrarLogica;;328,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("444;;cadastrarLogica;;0,0->15,7;;<11,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;15,7->16,0;;11,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;16,0->16,4;;11,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;16,4->16,7;;11,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;16,7->17,1;;11,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;17,1->17,4;;11,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;17,4->17,7;;11,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;17,7->18,1;;11,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;18,1->18,4;;11,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;18,4->18,8;;11,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;18,8->19,1;;11,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;19,1->19,4;;12,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;19,4->19,7;;12,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;19,7->20,1;;12,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;20,1->20,4;;12,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;20,4->20,7;;12,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;20,7->21,0;;12,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;21,0->21,3;;12,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;21,3->21,7;;12,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;21,7->22,0;;12,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;22,0->22,3;;12,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;22,3->22,8;;13,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;22,8->23,2;;13,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;23,2->23,7;;13,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;23,7->24,2;;13,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;24,2->24,6;;13,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;24,6->25,1;;13,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;25,1->25,6;;13,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;25,6->26,1;;13,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;26,1->26,5;;13,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;26,5->27,0;;13,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;27,0->27,4;;14,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;27,4->27,7;;14,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;27,7->28,1;;14,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;28,1->28,5;;14,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;28,5->28,8;;14,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;28,8->29,2;;14,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;29,2->29,6;;14,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;29,6->30,0;;14,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;30,0->30,3;;14,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;30,3->30,7;;14,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;30,7->31,1;;15,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;31,1->31,4;;15,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;31,4->31,8;;15,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;31,8->32,1;;15,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;32,1->32,5;;15,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;32,5->32,9;;15,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;32,9->33,2;;15,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;33,2->33,6;;15,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;33,6->33,9;;15,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;33,9->34,3;;15,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;34,3->34,7;;16,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;34,7->35,0;;16,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;35,0->35,4;;16,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;35,4->35,7;;16,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;35,7->36,1;;16,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;36,1->36,5;;16,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;36,5->36,8;;16,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;36,8->37,2;;16,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;37,2->37,5;;16,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;37,5->37,9;;16,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;37,9->38,2;;17,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;38,2->38,6;;17,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;38,6->38,9;;17,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;38,9->39,3;;17,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;39,3->39,6;;17,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;39,6->39,9;;17,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;39,9->40,3;;17,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;40,3->40,6;;17,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;40,6->41,0;;17,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;41,0->41,3;;17,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;41,3->41,6;;18,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;41,6->42,0;;18,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;42,0->42,3;;18,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;42,3->42,7;;18,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;42,7->43,0;;18,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;43,0->43,3;;18,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;43,3->43,7;;18,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;43,7->44,0;;18,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;44,0->44,4;;18,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;44,4->44,7;;18,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;44,7->45,0;;19,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;45,0->45,4;;19,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;45,4->45,7;;19,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;45,7->46,1;;19,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;46,1->46,4;;19,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;46,4->46,7;;19,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;46,7->47,1;;19,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;47,1->47,4;;19,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;47,4->47,8;;19,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;47,8->48,1;;19,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;48,1->48,4;;20,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;48,4->48,7;;20,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;48,7->49,1;;20,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;49,1->49,4;;20,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;49,4->49,7;;20,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;49,7->50,0;;20,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;50,0->50,3;;20,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;50,3->50,7;;20,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;50,7->51,0;;20,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;51,0->51,3;;20,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;51,3->51,6;;21,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;51,6->51,9;;21,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;51,9->52,3;;21,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;52,3->52,6;;21,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;52,6->52,9;;21,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;52,9->53,2;;21,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;53,2->53,5;;21,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;53,5->53,9;;21,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;53,9->54,2;;21,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;54,2->54,5;;21,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;54,5->54,8;;22,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;54,8->55,1;;22,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;55,1->55,4;;22,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;55,4->55,7;;22,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;55,7->56,0;;22,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;56,0->56,3;;22,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;56,3->56,6;;22,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;56,6->56,9;;22,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;56,9->57,2;;22,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;57,2->57,5;;22,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;57,5->57,8;;23,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;57,8->58,1;;23,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;58,1->58,4;;23,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;58,4->58,7;;23,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;58,7->59,0;;23,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;59,0->59,3;;23,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;59,3->59,6;;23,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;59,6->59,9;;23,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;59,9->60,2;;23,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;60,2->60,5;;23,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;60,5->60,8;;24,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;60,8->61,1;;24,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;61,1->61,4;;24,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;61,4->61,7;;24,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;61,7->62,0;;24,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;62,0->62,2;;24,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;62,2->62,5;;24,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;62,5->62,8;;24,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;62,8->63,1;;24,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;63,1->63,4;;24,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;63,4->63,7;;25,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;63,7->64,0;;25,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;64,0->64,2;;25,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;64,2->64,5;;25,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;64,5->64,8;;25,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;64,8->65,1;;25,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;65,1->65,4;;25,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;65,4->65,6;;25,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;65,6->65,9;;25,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;65,9->66,2;;25,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;66,2->66,5;;26,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;66,5->66,7;;26,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;66,7->67,0;;26,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;67,0->67,3;;26,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;67,3->67,6;;26,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;67,6->67,8;;26,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;67,8->68,1;;26,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;68,1->68,4;;26,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;68,4->68,6;;26,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;68,6->68,9;;26,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;68,9->69,2;;27,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;69,2->69,4;;27,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;69,4->69,6;;27,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;69,6->69,9;;27,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;69,9->70,2;;27,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;70,2->70,4;;27,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;70,4->70,6;;27,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;70,6->70,9;;27,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;70,9->71,2;;27,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;71,2->71,4;;27,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;71,4->71,6;;28,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;71,6->71,9;;28,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;71,9->72,2;;28,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;72,2->72,4;;28,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;72,4->72,6;;28,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;72,6->72,9;;28,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;72,9->73,2;;28,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;73,2->73,4;;28,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;73,4->73,6;;28,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;73,6->73,9;;28,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;73,9->74,1;;29,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;74,1->74,4;;29,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;74,4->74,6;;29,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;74,6->74,8;;29,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;74,8->75,1;;29,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;75,1->75,3;;29,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;75,3->75,5;;29,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;75,5->75,7;;29,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;75,7->76,0;;29,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;76,0->76,2;;29,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;76,2->76,4;;30,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;76,4->76,7;;30,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;76,7->76,9;;30,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;76,9->77,1;;30,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;77,1->77,4;;30,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;77,4->77,6;;30,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;77,6->77,8;;30,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;77,8->78,0;;30,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;78,0->78,3;;30,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;78,3->78,5;;30,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;78,5->78,7;;31,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;78,7->78,9;;31,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;78,9->79,1;;31,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;79,1->79,3;;31,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;79,3->79,6;;31,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;79,6->79,8;;31,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;79,8->80,0;;31,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;80,0->80,2;;31,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;80,2->80,4;;31,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;80,4->80,6;;31,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;80,6->80,8;;32,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;80,8->81,0;;32,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;81,0->81,2;;32,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;81,2->81,4;;32,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;81,4->81,6;;32,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;81,6->81,7;;32,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;81,7->81,9;;32,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;81,9->82,1;;32,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;82,1->82,3;;32,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;82,3->82,5;;32,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;82,5->82,7;;33,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;82,7->82,9;;33,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;82,9->83,1;;33,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;83,1->83,3;;33,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;83,3->83,4;;33,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;83,4->83,6;;33,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;83,6->83,8;;33,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;83,8->84,0;;33,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;84,0->84,2;;33,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;84,2->84,4;;33,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;84,4->84,6;;34,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;84,6->84,7;;34,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;84,7->84,9;;34,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;84,9->85,1;;34,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;85,1->85,2;;34,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;85,2->85,4;;34,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;85,4->85,6;;34,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;85,6->85,8;;34,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;85,8->85,9;;34,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;85,9->86,1;;34,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;86,1->86,2;;35,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;86,2->86,4;;35,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;86,4->86,6;;35,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;86,6->86,7;;35,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;86,7->86,8;;35,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;86,8->87,0;;35,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;87,0->87,1;;35,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;87,1->87,3;;35,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;87,3->87,4;;35,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;87,4->87,6;;35,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;87,6->87,8;;36,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;87,8->87,9;;36,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;87,9->88,0;;36,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;88,0->88,2;;36,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;88,2->88,4;;36,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;88,4->88,5;;36,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;88,5->88,6;;36,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;88,6->88,8;;36,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;88,8->88,9;;36,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;88,9->89,1;;36,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;89,1->89,2;;37,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;89,2->89,3;;37,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;89,3->89,5;;37,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;89,5->89,6;;37,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;89,6->89,7;;37,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;89,7->89,8;;37,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;89,8->89,9;;37,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;89,9->90,1;;37,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;90,1->90,2;;37,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;90,2->90,3;;37,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;90,3->90,4;;38,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;90,4->90,5;;38,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;90,5->90,6;;38,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;90,6->90,7;;38,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;90,7->90,8;;38,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;90,8->91,0;;38,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;91,0->91,1;;38,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;91,1->91,2;;38,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;91,2->91,3;;38,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;91,3->91,4;;38,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;91,4->91,5;;39,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;91,5->91,6;;39,10 semanas$$\n");
        sb.append("444;;cadastrarLogica;;91,6->91,7;;39,20 semanas$$\n");
        sb.append("444;;cadastrarLogica;;91,7->91,8;;39,30 semanas$$\n");
        sb.append("444;;cadastrarLogica;;91,8->91,9;;39,40 semanas$$\n");
        sb.append("444;;cadastrarLogica;;91,9->92,0;;39,50 semanas$$\n");
        sb.append("444;;cadastrarLogica;;92,0->92,1;;39,60 semanas$$\n");
        sb.append("444;;cadastrarLogica;;92,1->92,2;;39,70 semanas$$\n");
        sb.append("444;;cadastrarLogica;;92,2->92,3;;39,80 semanas$$\n");
        sb.append("444;;cadastrarLogica;;92,3->92,4;;39,90 semanas$$\n");
        sb.append("444;;cadastrarLogica;;92,4->93,1;;40,00 semanas$$\n");
        sb.append("444;;cadastrarLogica;;93,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

    }

    private static void preencherIghFeto3 ()
    {

        // <editor-fold defaultstate="collapsed" desc="Fêmur">

        sb.append("447;;cadastrarLogica;;0,0->7,1;;<12,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;7,1->8,1;;12,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;8,1->9,1;;12,33 semanas$$\n");
        sb.append("447;;cadastrarLogica;;9,1->10,1;;12,67 semanas$$\n");
        sb.append("447;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("447;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("447;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("447;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("447;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("447;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("447;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;20,1->21,1;;16,33 semanas$$\n");
        sb.append("447;;cadastrarLogica;;21,1->22,1;;16,67 semanas$$\n");
        sb.append("447;;cadastrarLogica;;22,1->23,1;;17,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;23,1->24,1;;17,50 semanas$$\n");
        sb.append("447;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("447;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("447;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;28,1->29,1;;19,33 semanas$$\n");
        sb.append("447;;cadastrarLogica;;29,1->30,1;;19,67 semanas$$\n");
        sb.append("447;;cadastrarLogica;;30,1->31,1;;20,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;31,1->32,1;;20,33 semanas$$\n");
        sb.append("447;;cadastrarLogica;;32,1->33,1;;20,67 semanas$$\n");
        sb.append("447;;cadastrarLogica;;33,1->34,1;;21,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;34,1->35,1;;21,50 semanas$$\n");
        sb.append("447;;cadastrarLogica;;35,1->36,1;;22,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;36,1->37,1;;22,33 semanas$$\n");
        sb.append("447;;cadastrarLogica;;37,1->38,1;;22,67 semanas$$\n");
        sb.append("447;;cadastrarLogica;;38,1->39,1;;23,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;39,1->40,1;;23,33 semanas$$\n");
        sb.append("447;;cadastrarLogica;;40,1->41,1;;23,67 semanas$$\n");
        sb.append("447;;cadastrarLogica;;41,1->42,1;;24,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;42,1->43,1;;24,50 semanas$$\n");
        sb.append("447;;cadastrarLogica;;43,1->44,1;;25,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;44,1->45,1;;25,33 semanas$$\n");
        sb.append("447;;cadastrarLogica;;45,1->46,1;;25,67 semanas$$\n");
        sb.append("447;;cadastrarLogica;;46,1->47,1;;26,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;47,1->48,1;;26,50 semanas$$\n");
        sb.append("447;;cadastrarLogica;;48,1->49,1;;27,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;49,1->50,1;;27,33 semanas$$\n");
        sb.append("447;;cadastrarLogica;;50,1->51,1;;27,67 semanas$$\n");
        sb.append("447;;cadastrarLogica;;51,1->52,1;;28,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;52,1->53,1;;28,50 semanas$$\n");
        sb.append("447;;cadastrarLogica;;53,1->54,1;;29,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;54,1->55,1;;29,50 semanas$$\n");
        sb.append("447;;cadastrarLogica;;55,1->56,1;;30,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;56,1->57,1;;30,33 semanas$$\n");
        sb.append("447;;cadastrarLogica;;57,1->58,1;;30,67 semanas$$\n");
        sb.append("447;;cadastrarLogica;;58,1->59,1;;31,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;59,1->60,1;;31,50 semanas$$\n");
        sb.append("447;;cadastrarLogica;;60,1->61,1;;32,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;61,1->62,1;;32,50 semanas$$\n");
        sb.append("447;;cadastrarLogica;;62,1->63,1;;33,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;63,1->64,1;;33,50 semanas$$\n");
        sb.append("447;;cadastrarLogica;;64,1->65,1;;34,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;65,1->66,1;;34,50 semanas$$\n");
        sb.append("447;;cadastrarLogica;;66,1->67,1;;35,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;67,1->68,1;;36,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;68,1->69,1;;36,50 semanas$$\n");
        sb.append("447;;cadastrarLogica;;69,1->70,1;;37,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;70,1->71,1;;38,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;71,1->72,1;;38,50 semanas$$\n");
        sb.append("447;;cadastrarLogica;;72,1->73,1;;39,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;73,1->74,1;;40,00 semanas$$\n");
        sb.append("447;;cadastrarLogica;;74,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Úmero">

        sb.append("448;;cadastrarLogica;;0,0->8,1;;<12,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;8,1->9,1;;12,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;9,1->10,1;;12,50 semanas$$\n");
        sb.append("448;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("448;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("448;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("448;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("448;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("448;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("448;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;20,1->21,1;;16,50 semanas$$\n");
        sb.append("448;;cadastrarLogica;;21,1->22,1;;17,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;22,1->23,1;;17,33 semanas$$\n");
        sb.append("448;;cadastrarLogica;;23,1->24,1;;17,67 semanas$$\n");
        sb.append("448;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("448;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("448;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;28,1->29,1;;19,50 semanas$$\n");
        sb.append("448;;cadastrarLogica;;29,1->30,1;;20,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;30,1->31,1;;20,33 semanas$$\n");
        sb.append("448;;cadastrarLogica;;31,1->32,1;;20,67 semanas$$\n");
        sb.append("448;;cadastrarLogica;;32,1->33,1;;21,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;33,1->34,1;;21,50 semanas$$\n");
        sb.append("448;;cadastrarLogica;;34,1->35,1;;22,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;35,1->36,1;;22,33 semanas$$\n");
        sb.append("448;;cadastrarLogica;;36,1->37,1;;22,67 semanas$$\n");
        sb.append("448;;cadastrarLogica;;37,1->38,1;;23,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;38,1->39,1;;23,50 semanas$$\n");
        sb.append("448;;cadastrarLogica;;39,1->40,1;;24,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;40,1->41,1;;24,50 semanas$$\n");
        sb.append("448;;cadastrarLogica;;41,1->42,1;;25,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;42,1->43,1;;25,50 semanas$$\n");
        sb.append("448;;cadastrarLogica;;43,1->44,1;;26,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;44,1->45,1;;26,50 semanas$$\n");
        sb.append("448;;cadastrarLogica;;45,1->46,1;;27,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;46,1->47,1;;27,50 semanas$$\n");
        sb.append("448;;cadastrarLogica;;47,1->48,1;;28,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;48,1->49,1;;28,50 semanas$$\n");
        sb.append("448;;cadastrarLogica;;49,1->50,1;;29,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;50,1->51,1;;30,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;51,1->52,1;;30,50 semanas$$\n");
        sb.append("448;;cadastrarLogica;;52,1->53,1;;31,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;53,1->54,1;;31,50 semanas$$\n");
        sb.append("448;;cadastrarLogica;;54,1->55,1;;32,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;55,1->56,1;;33,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;56,1->57,1;;33,50 semanas$$\n");
        sb.append("448;;cadastrarLogica;;57,1->58,1;;34,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;58,1->59,1;;35,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;59,1->60,1;;35,50 semanas$$\n");
        sb.append("448;;cadastrarLogica;;60,1->61,1;;36,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;61,1->62,1;;37,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;63,1->64,1;;38,50 semanas$$\n");
        sb.append("448;;cadastrarLogica;;64,1->65,1;;39,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("448;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ulna">

        sb.append("449;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("449;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("449;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;10,1->11,1;;13,33 semanas$$\n");
        sb.append("449;;cadastrarLogica;;11,1->12,1;;13,67 semanas$$\n");
        sb.append("449;;cadastrarLogica;;12,1->13,1;;14,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;13,1->14,1;;14,50 semanas$$\n");
        sb.append("449;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;15,1->16,1;;15,33 semanas$$\n");
        sb.append("449;;cadastrarLogica;;16,1->17,1;;15,67 semanas$$\n");
        sb.append("449;;cadastrarLogica;;17,1->18,1;;16,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;18,1->19,1;;16,33 semanas$$\n");
        sb.append("449;;cadastrarLogica;;19,1->20,1;;16,67 semanas$$\n");
        sb.append("449;;cadastrarLogica;;20,1->21,1;;17,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;21,1->22,1;;17,50 semanas$$\n");
        sb.append("449;;cadastrarLogica;;22,1->23,1;;18,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;23,1->24,1;;18,33 semanas$$\n");
        sb.append("449;;cadastrarLogica;;24,1->25,1;;18,67 semanas$$\n");
        sb.append("449;;cadastrarLogica;;25,1->26,1;;19,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;26,1->27,1;;19,50 semanas$$\n");
        sb.append("449;;cadastrarLogica;;27,1->28,1;;20,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;28,1->29,1;;20,33 semanas$$\n");
        sb.append("449;;cadastrarLogica;;29,1->30,1;;20,67 semanas$$\n");
        sb.append("449;;cadastrarLogica;;30,1->31,1;;21,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;31,1->32,1;;21,50 semanas$$\n");
        sb.append("449;;cadastrarLogica;;32,1->33,1;;22,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;33,1->34,1;;22,50 semanas$$\n");
        sb.append("449;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("449;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;37,1->38,1;;24,50 semanas$$\n");
        sb.append("449;;cadastrarLogica;;38,1->39,1;;25,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;39,1->40,1;;25,50 semanas$$\n");
        sb.append("449;;cadastrarLogica;;40,1->41,1;;26,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;41,1->42,1;;26,50 semanas$$\n");
        sb.append("449;;cadastrarLogica;;42,1->43,1;;27,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;43,1->44,1;;27,50 semanas$$\n");
        sb.append("449;;cadastrarLogica;;44,1->45,1;;28,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;45,1->46,1;;28,50 semanas$$\n");
        sb.append("449;;cadastrarLogica;;46,1->47,1;;29,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;47,1->48,1;;30,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;48,1->49,1;;30,50 semanas$$\n");
        sb.append("449;;cadastrarLogica;;49,1->50,1;;31,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;50,1->51,1;;31,50 semanas$$\n");
        sb.append("449;;cadastrarLogica;;51,1->52,1;;32,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;52,1->53,1;;33,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;53,1->54,1;;33,50 semanas$$\n");
        sb.append("449;;cadastrarLogica;;54,1->55,1;;34,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;55,1->56,1;;35,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;56,1->57,1;;36,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;57,1->58,1;;37,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;58,1->59,1;;38,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;59,1->60,1;;39,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;60,1->61,1;;40,00 semanas$$\n");
        sb.append("449;;cadastrarLogica;;61,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tíbia">

        sb.append("450;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("450;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("450;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;10,1->11,1;;13,50 semanas$$\n");
        sb.append("450;;cadastrarLogica;;11,1->12,1;;14,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;12,1->13,1;;14,33 semanas$$\n");
        sb.append("450;;cadastrarLogica;;13,1->14,1;;14,67 semanas$$\n");
        sb.append("450;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;15,1->16,1;;15,50 semanas$$\n");
        sb.append("450;;cadastrarLogica;;16,1->17,1;;16,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;17,1->18,1;;16,33 semanas$$\n");
        sb.append("450;;cadastrarLogica;;18,1->19,1;;16,67 semanas$$\n");
        sb.append("450;;cadastrarLogica;;19,1->20,1;;17,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;20,1->21,1;;17,50 semanas$$\n");
        sb.append("450;;cadastrarLogica;;21,1->22,1;;18,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;22,1->23,1;;18,33 semanas$$\n");
        sb.append("450;;cadastrarLogica;;23,1->24,1;;18,67 semanas$$\n");
        sb.append("450;;cadastrarLogica;;24,1->25,1;;19,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;25,1->26,1;;19,50 semanas$$\n");
        sb.append("450;;cadastrarLogica;;26,1->27,1;;20,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;27,1->28,1;;20,33 semanas$$\n");
        sb.append("450;;cadastrarLogica;;28,1->29,1;;20,67 semanas$$\n");
        sb.append("450;;cadastrarLogica;;29,1->30,1;;21,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;30,1->31,1;;21,50 semanas$$\n");
        sb.append("450;;cadastrarLogica;;31,1->32,1;;22,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;32,1->33,1;;22,33 semanas$$\n");
        sb.append("450;;cadastrarLogica;;33,1->34,1;;22,67 semanas$$\n");
        sb.append("450;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("450;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;37,1->38,1;;24,33 semanas$$\n");
        sb.append("450;;cadastrarLogica;;38,1->39,1;;24,67 semanas$$\n");
        sb.append("450;;cadastrarLogica;;39,1->40,1;;25,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;40,1->41,1;;25,50 semanas$$\n");
        sb.append("450;;cadastrarLogica;;41,1->42,1;;26,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;42,1->43,1;;26,50 semanas$$\n");
        sb.append("450;;cadastrarLogica;;43,1->44,1;;27,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;44,1->45,1;;27,50 semanas$$\n");
        sb.append("450;;cadastrarLogica;;45,1->46,1;;28,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;46,1->47,1;;28,50 semanas$$\n");
        sb.append("450;;cadastrarLogica;;47,1->48,1;;29,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;48,1->49,1;;29,50 semanas$$\n");
        sb.append("450;;cadastrarLogica;;49,1->50,1;;30,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;50,1->51,1;;30,50 semanas$$\n");
        sb.append("450;;cadastrarLogica;;51,1->52,1;;31,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;52,1->53,1;;31,50 semanas$$\n");
        sb.append("450;;cadastrarLogica;;53,1->54,1;;32,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;54,1->55,1;;33,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;55,1->56,1;;33,50 semanas$$\n");
        sb.append("450;;cadastrarLogica;;56,1->57,1;;34,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;57,1->58,1;;35,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;58,1->59,1;;35,50 semanas$$\n");
        sb.append("450;;cadastrarLogica;;59,1->60,1;;36,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;60,1->61,1;;37,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;61,1->62,1;;37,50 semanas$$\n");
        sb.append("450;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;63,1->64,1;;39,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;64,1->65,1;;39,50 semanas$$\n");
        sb.append("450;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("450;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.A.">

        sb.append("452;;cadastrarLogica;;0,0->39,3;;<11,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;39,3->40,6;;11,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;40,6->41,9;;11,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;41,9->43,2;;11,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;43,2->44,5;;11,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;44,5->45,8;;11,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;45,8->47,0;;11,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;47,0->48,3;;11,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;48,3->49,6;;11,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;49,6->50,9;;11,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;50,9->52,2;;11,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;52,2->53,5;;12,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;53,5->54,8;;12,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;54,8->56,0;;12,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;56,0->57,3;;12,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;57,3->58,6;;12,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;58,6->59,9;;12,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;59,9->61,2;;12,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;61,2->62,4;;12,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;62,4->63,7;;12,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;63,7->65,0;;12,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;65,0->66,3;;13,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;66,3->67,5;;13,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;67,5->68,8;;13,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;68,8->70,1;;13,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;70,1->71,4;;13,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;71,4->72,6;;13,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;72,6->73,9;;13,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;73,9->75,2;;13,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;75,2->76,4;;13,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;76,4->77,7;;13,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;77,7->79,0;;14,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;79,0->80,2;;14,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;80,2->81,4;;14,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;81,4->82,7;;14,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;82,7->84,0;;14,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;84,0->85,2;;14,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;85,2->86,4;;14,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;86,4->87,7;;14,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;87,7->89,0;;14,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;89,0->90,2;;14,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;90,2->91,4;;15,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;91,4->92,7;;15,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;92,7->94,0;;15,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;94,0->95,2;;15,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;95,2->96,4;;15,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;96,4->97,7;;15,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;97,7->99,0;;15,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;99,0->100,2;;15,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;100,2->101,4;;15,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;101,4->102,7;;15,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;102,7->103,9;;16,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;103,9->105,2;;16,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;105,2->106,4;;16,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;106,4->107,6;;16,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;107,6->108,8;;16,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;108,8->110,1;;16,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;110,1->111,3;;16,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;111,3->112,5;;16,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;112,5->113,8;;16,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;113,8->115,0;;16,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;115,0->116,2;;17,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;116,2->117,4;;17,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;117,4->118,7;;17,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;118,7->119,9;;17,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;119,9->121,1;;17,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;121,1->122,3;;17,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;122,3->123,5;;17,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;123,5->124,8;;17,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;124,8->126,0;;17,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;126,0->127,2;;17,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;127,2->128,4;;18,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;128,4->129,6;;18,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;129,6->130,8;;18,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;130,8->132,0;;18,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;132,0->133,2;;18,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;133,2->134,4;;18,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;134,4->135,6;;18,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;135,6->136,8;;18,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;136,8->138,0;;18,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;138,0->139,2;;18,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;139,2->140,4;;19,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;140,4->141,6;;19,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;141,6->142,8;;19,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;142,8->144,0;;19,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;144,0->145,1;;19,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;145,1->146,3;;19,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;146,3->147,5;;19,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;147,5->148,7;;19,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;148,7->149,9;;19,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;149,9->151,1;;19,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;151,1->152,3;;20,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;152,3->153,4;;20,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;153,4->154,6;;20,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;154,6->155,8;;20,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;155,8->157,0;;20,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;157,0->158,1;;20,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;158,1->159,3;;20,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;159,3->160,5;;20,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;160,5->161,6;;20,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;161,6->162,8;;20,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;162,8->164,0;;21,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;164,0->165,1;;21,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;165,1->166,3;;21,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;166,3->167,4;;21,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;167,4->168,6;;21,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;168,6->169,8;;21,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;169,8->170,9;;21,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;170,9->172,1;;21,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;172,1->173,2;;21,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;173,2->174,4;;21,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;174,4->175,5;;22,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;175,5->176,7;;22,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;176,7->177,8;;22,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;177,8->179,0;;22,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;179,0->180,1;;22,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;180,1->181,2;;22,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;181,2->182,4;;22,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;182,4->183,5;;22,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;183,5->184,7;;22,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;184,7->185,8;;22,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;185,8->186,9;;23,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;186,9->188,0;;23,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;188,0->189,2;;23,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;189,2->190,3;;23,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;190,3->191,4;;23,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;191,4->192,5;;23,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;192,5->193,6;;23,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;193,6->194,8;;23,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;194,8->195,9;;23,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;195,9->197,0;;23,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;197,0->198,1;;24,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;198,1->199,2;;24,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;199,2->200,3;;24,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;200,3->201,4;;24,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;201,4->202,5;;24,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;202,5->203,6;;24,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;203,6->204,7;;24,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;204,7->205,8;;24,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;205,8->206,9;;24,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;206,9->208,0;;24,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;208,0->209,1;;25,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;209,1->210,2;;25,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;210,2->211,2;;25,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;211,2->212,3;;25,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;212,3->213,4;;25,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;213,4->214,5;;25,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;214,5->215,6;;25,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;215,6->216,6;;25,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;216,6->217,7;;25,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;217,7->218,8;;25,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;218,8->219,9;;26,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;219,9->220,9;;26,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;220,9->222,0;;26,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;222,0->223,0;;26,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;223,0->224,1;;26,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;224,1->225,2;;26,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;225,2->226,2;;26,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;226,2->227,3;;26,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;227,3->228,3;;26,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;228,3->229,4;;26,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;229,4->230,4;;27,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;230,4->231,5;;27,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;231,5->232,5;;27,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;232,5->233,6;;27,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;233,6->234,6;;27,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;234,6->235,6;;27,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;235,6->236,7;;27,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;236,7->237,7;;27,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;237,7->238,8;;27,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;238,8->239,8;;27,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;239,8->240,8;;28,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;240,8->241,8;;28,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;241,8->242,8;;28,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;242,8->243,8;;28,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;243,8->244,9;;28,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;244,9->245,9;;28,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;245,9->246,9;;28,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;246,9->247,9;;28,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;247,9->248,9;;28,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;248,9->249,9;;28,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;249,9->250,9;;29,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;250,9->251,9;;29,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;251,9->252,9;;29,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;252,9->253,9;;29,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;253,9->254,9;;29,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;254,9->255,8;;29,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;255,8->256,8;;29,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;256,8->257,8;;29,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;257,8->258,8;;29,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;258,8->259,8;;29,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;259,8->260,8;;30,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;260,8->261,7;;30,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;261,7->262,7;;30,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;262,7->263,7;;30,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;263,7->264,6;;30,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;264,6->265,6;;30,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;265,6->266,6;;30,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;266,6->267,6;;30,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;267,6->268,5;;30,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;268,5->269,5;;30,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;269,5->270,4;;31,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;270,4->271,4;;31,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;271,4->272,4;;31,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;272,4->273,3;;31,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;273,3->274,2;;31,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;274,2->275,2;;31,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;275,2->276,2;;31,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;276,2->277,1;;31,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;277,1->278,0;;31,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;278,0->279,0;;31,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;279,0->279,9;;32,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;279,9->280,8;;32,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;280,8->281,7;;32,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;281,7->282,6;;32,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;282,6->283,6;;32,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;283,6->284,5;;32,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;284,5->285,4;;32,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;285,4->286,3;;32,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;286,3->287,2;;32,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;287,2->288,1;;32,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;288,1->289,0;;33,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;289,0->289,9;;33,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;289,9->290,8;;33,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;290,8->291,7;;33,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;291,7->292,6;;33,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;292,6->293,5;;33,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;293,5->294,4;;33,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;294,4->295,3;;33,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;295,3->296,2;;33,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;296,2->297,1;;33,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;297,1->298,0;;34,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;298,0->298,8;;34,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;298,8->299,7;;34,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;299,7->300,5;;34,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;300,5->301,4;;34,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;301,4->302,3;;34,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;302,3->303,1;;34,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;303,1->304,0;;34,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;304,0->304,8;;34,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;304,8->305,7;;34,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;305,7->306,5;;35,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;306,5->307,4;;35,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;307,4->308,2;;35,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;308,2->309,1;;35,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;309,1->309,9;;35,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;309,9->310,7;;35,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;310,7->311,6;;35,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;311,6->312,4;;35,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;312,4->313,3;;35,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;313,3->314,1;;35,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;314,1->314,9;;36,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;314,9->315,7;;36,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;315,7->316,5;;36,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;316,5->317,3;;36,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;317,3->318,1;;36,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;318,1->318,9;;36,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;318,9->319,7;;36,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;319,7->320,5;;36,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;320,5->321,3;;36,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;321,3->322,1;;36,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;322,1->322,9;;37,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;322,9->323,7;;37,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;323,7->324,4;;37,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;324,4->325,2;;37,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;325,2->326,0;;37,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;326,0->326,8;;37,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;326,8->327,6;;37,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;327,6->328,3;;37,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;328,3->329,1;;37,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;329,1->329,9;;37,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;329,9->330,6;;38,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;330,6->331,4;;38,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;331,4->332,2;;38,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;332,2->332,9;;38,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;332,9->333,6;;38,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;333,6->334,4;;38,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;334,4->335,2;;38,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;335,2->335,9;;38,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;335,9->336,6;;38,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;336,6->337,4;;38,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;337,4->338,1;;39,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;338,1->338,8;;39,10 semanas$$\n");
        sb.append("452;;cadastrarLogica;;338,8->339,5;;39,20 semanas$$\n");
        sb.append("452;;cadastrarLogica;;339,5->340,2;;39,30 semanas$$\n");
        sb.append("452;;cadastrarLogica;;340,2->341,0;;39,40 semanas$$\n");
        sb.append("452;;cadastrarLogica;;341,0->341,7;;39,50 semanas$$\n");
        sb.append("452;;cadastrarLogica;;341,7->342,4;;39,60 semanas$$\n");
        sb.append("452;;cadastrarLogica;;342,4->343,1;;39,70 semanas$$\n");
        sb.append("452;;cadastrarLogica;;343,1->343,8;;39,80 semanas$$\n");
        sb.append("452;;cadastrarLogica;;343,8->344,5;;39,90 semanas$$\n");
        sb.append("452;;cadastrarLogica;;344,5->346,1;;40,00 semanas$$\n");
        sb.append("452;;cadastrarLogica;;346,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.C.">

        sb.append("453;;cadastrarLogica;;0,0->53,2;;<11,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;53,2->54,6;;11,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;54,6->56,1;;11,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;56,1->57,5;;11,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;57,5->58,9;;11,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;58,9->60,4;;11,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;60,4->61,8;;11,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;61,8->63,2;;11,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;63,2->64,6;;11,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;64,6->66,1;;11,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;66,1->67,5;;11,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;67,5->68,9;;12,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;68,9->70,4;;12,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;70,4->71,8;;12,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;71,8->73,2;;12,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;73,2->74,6;;12,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;74,6->76,1;;12,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;76,1->77,5;;12,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;77,5->78,9;;12,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;78,9->80,4;;12,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;80,4->81,8;;12,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;81,8->83,2;;13,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;83,2->84,5;;13,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;84,5->85,9;;13,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;85,9->87,3;;13,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;87,3->88,6;;13,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;88,6->90,0;;13,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;90,0->91,4;;13,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;91,4->92,8;;13,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;92,8->94,1;;13,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;94,1->95,5;;13,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;95,5->96,9;;14,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;96,9->98,2;;14,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;98,2->99,6;;14,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;99,6->101,0;;14,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;101,0->102,4;;14,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;102,4->103,7;;14,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;103,7->105,1;;14,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;105,1->106,5;;14,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;106,5->107,8;;14,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;107,8->109,2;;14,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;109,2->110,6;;15,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;110,6->111,9;;15,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;111,9->113,2;;15,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;113,2->114,6;;15,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;114,6->116,0;;15,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;116,0->117,3;;15,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;117,3->118,6;;15,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;118,6->120,0;;15,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;120,0->121,4;;15,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;121,4->122,7;;15,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;122,7->124,0;;16,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;124,0->125,3;;16,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;125,3->126,6;;16,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;126,6->127,9;;16,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;127,9->129,2;;16,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;129,2->130,6;;16,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;130,6->131,9;;16,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;131,9->133,2;;16,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;133,2->134,5;;16,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;134,5->135,8;;16,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;135,8->137,1;;17,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;137,1->138,4;;17,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;138,4->139,7;;17,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;139,7->141,0;;17,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;141,0->142,2;;17,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;142,2->143,5;;17,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;143,5->144,8;;17,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;144,8->146,1;;17,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;146,1->147,4;;17,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;147,4->148,7;;17,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;148,7->150,0;;18,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;150,0->151,2;;18,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;151,2->152,5;;18,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;152,5->153,7;;18,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;153,7->155,0;;18,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;155,0->156,3;;18,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;156,3->157,5;;18,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;157,5->158,8;;18,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;158,8->160,0;;18,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;160,0->161,3;;18,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;161,3->162,5;;19,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;162,5->163,7;;19,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;163,7->165,0;;19,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;165,0->166,2;;19,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;166,2->167,4;;19,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;167,4->168,6;;19,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;168,6->169,8;;19,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;169,8->171,1;;19,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;171,1->172,3;;19,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;172,3->173,5;;19,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;173,5->174,7;;20,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;174,7->175,9;;20,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;175,9->177,1;;20,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;177,1->178,3;;20,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;178,3->179,5;;20,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;179,5->180,7;;20,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;180,7->181,9;;20,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;181,9->183,1;;20,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;183,1->184,3;;20,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;184,3->185,5;;20,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;185,5->186,6;;21,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;186,6->187,8;;21,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;187,8->189,0;;21,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;189,0->190,1;;21,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;190,1->191,2;;21,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;191,2->192,4;;21,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;192,4->193,6;;21,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;193,6->194,7;;21,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;194,7->195,8;;21,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;195,8->197,0;;21,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;197,0->198,1;;22,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;198,1->199,3;;22,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;199,3->200,4;;22,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;200,4->201,5;;22,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;201,5->202,6;;22,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;202,6->203,8;;22,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;203,8->204,9;;22,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;204,9->206,0;;22,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;206,0->207,2;;22,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;207,2->208,3;;22,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;208,3->209,4;;23,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;209,4->210,5;;23,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;210,5->211,5;;23,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;211,5->212,6;;23,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;212,6->213,7;;23,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;213,7->214,8;;23,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;214,8->215,9;;23,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;215,9->216,9;;23,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;216,9->218,0;;23,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;218,0->219,1;;23,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;219,1->220,1;;24,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;220,1->221,2;;24,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;221,2->222,2;;24,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;222,2->223,3;;24,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;223,3->224,3;;24,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;224,3->225,3;;24,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;225,3->226,4;;24,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;226,4->227,4;;24,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;227,4->228,5;;24,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;228,5->229,5;;24,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;229,5->230,5;;25,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;230,5->231,5;;25,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;231,5->232,5;;25,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;232,5->233,5;;25,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;233,5->234,5;;25,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;234,5->235,5;;25,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;235,5->236,5;;25,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;236,5->237,5;;25,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;237,5->238,5;;25,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;238,5->239,5;;25,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;239,5->240,5;;26,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;240,5->241,4;;26,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;241,4->242,4;;26,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;242,4->243,3;;26,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;243,3->244,3;;26,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;244,3->245,3;;26,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;245,3->246,2;;26,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;246,2->247,2;;26,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;247,2->248,1;;26,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;248,1->249,1;;26,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;249,1->250,0;;27,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;250,0->250,9;;27,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;250,9->251,9;;27,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;251,9->252,8;;27,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;252,8->253,7;;27,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;253,7->254,6;;27,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;254,6->255,5;;27,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;255,5->256,5;;27,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;256,5->257,4;;27,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;257,4->258,3;;27,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;258,3->259,2;;28,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;259,2->260,0;;28,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;260,0->260,9;;28,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;260,9->261,7;;28,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;261,7->262,6;;28,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;262,6->263,5;;28,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;263,5->264,3;;28,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;264,3->265,2;;28,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;265,2->266,0;;28,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;266,0->266,9;;28,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;266,9->267,7;;29,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;267,7->268,5;;29,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;268,5->269,4;;29,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;269,4->270,2;;29,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;270,2->271,0;;29,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;271,0->271,8;;29,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;271,8->272,6;;29,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;272,6->273,5;;29,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;273,5->274,3;;29,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;274,3->275,1;;29,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;275,1->275,9;;30,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;275,9->276,6;;30,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;276,6->277,4;;30,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;277,4->278,2;;30,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;278,2->279,0;;30,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;279,0->279,7;;30,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;279,7->280,5;;30,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;280,5->281,3;;30,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;281,3->282,0;;30,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;282,0->282,8;;30,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;282,8->283,5;;31,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;283,5->284,2;;31,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;284,2->284,9;;31,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;284,9->285,6;;31,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;285,6->286,4;;31,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;286,4->287,1;;31,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;287,1->287,8;;31,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;287,8->288,5;;31,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;288,5->289,2;;31,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;289,2->289,9;;31,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;289,9->290,6;;32,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;290,6->291,2;;32,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;291,2->291,9;;32,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;291,9->292,6;;32,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;292,6->293,2;;32,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;293,2->293,9;;32,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;293,9->294,6;;32,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;294,6->295,3;;32,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;295,3->295,9;;32,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;295,9->296,6;;32,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;296,6->297,2;;33,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;297,2->297,8;;33,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;297,8->298,4;;33,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;298,4->299,0;;33,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;299,0->299,6;;33,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;299,6->300,3;;33,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;300,3->300,9;;33,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;300,9->301,5;;33,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;301,5->302,1;;33,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;302,1->302,7;;33,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;302,7->303,2;;34,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;303,2->303,8;;34,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;303,8->304,3;;34,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;304,3->304,9;;34,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;304,9->305,4;;34,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;305,4->306,0;;34,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;306,0->306,6;;34,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;306,6->307,1;;34,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;307,1->307,6;;34,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;307,6->308,2;;34,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;308,2->308,7;;35,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;308,7->309,2;;35,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;309,2->309,7;;35,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;309,7->310,2;;35,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;310,2->310,6;;35,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;310,6->311,1;;35,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;311,1->311,6;;35,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;311,6->312,1;;35,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;312,1->312,6;;35,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;312,6->313,1;;35,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;313,1->313,5;;36,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;313,5->314,0;;36,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;314,0->314,4;;36,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;314,4->314,9;;36,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;314,9->315,3;;36,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;315,3->315,7;;36,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;315,7->316,2;;36,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;316,2->316,6;;36,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;316,6->317,1;;36,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;317,1->317,5;;36,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;317,5->317,9;;37,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;317,9->318,2;;37,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;318,2->318,6;;37,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;318,6->319,0;;37,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;319,0->319,4;;37,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;319,4->319,7;;37,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;319,7->320,1;;37,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;320,1->320,5;;37,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;320,5->320,8;;37,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;320,8->321,2;;37,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;321,2->321,5;;38,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;321,5->321,8;;38,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;321,8->322,1;;38,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;322,1->322,4;;38,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;322,4->322,8;;38,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;322,8->323,1;;38,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;323,1->323,4;;38,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;323,4->323,7;;38,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;323,7->324,0;;38,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;324,0->324,3;;38,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;324,3->324,5;;39,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;324,5->324,8;;39,10 semanas$$\n");
        sb.append("453;;cadastrarLogica;;324,8->325,0;;39,20 semanas$$\n");
        sb.append("453;;cadastrarLogica;;325,0->325,3;;39,30 semanas$$\n");
        sb.append("453;;cadastrarLogica;;325,3->325,5;;39,40 semanas$$\n");
        sb.append("453;;cadastrarLogica;;325,5->325,7;;39,50 semanas$$\n");
        sb.append("453;;cadastrarLogica;;325,7->326,0;;39,60 semanas$$\n");
        sb.append("453;;cadastrarLogica;;326,0->326,2;;39,70 semanas$$\n");
        sb.append("453;;cadastrarLogica;;326,2->326,5;;39,80 semanas$$\n");
        sb.append("453;;cadastrarLogica;;326,5->326,7;;39,90 semanas$$\n");
        sb.append("453;;cadastrarLogica;;326,7->328,1;;40,00 semanas$$\n");
        sb.append("453;;cadastrarLogica;;328,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("451;;cadastrarLogica;;0,0->15,7;;<11,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;15,7->16,0;;11,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;16,0->16,4;;11,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;16,4->16,7;;11,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;16,7->17,1;;11,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;17,1->17,4;;11,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;17,4->17,7;;11,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;17,7->18,1;;11,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;18,1->18,4;;11,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;18,4->18,8;;11,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;18,8->19,1;;11,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;19,1->19,4;;12,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;19,4->19,7;;12,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;19,7->20,1;;12,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;20,1->20,4;;12,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;20,4->20,7;;12,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;20,7->21,0;;12,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;21,0->21,3;;12,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;21,3->21,7;;12,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;21,7->22,0;;12,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;22,0->22,3;;12,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;22,3->22,8;;13,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;22,8->23,2;;13,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;23,2->23,7;;13,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;23,7->24,2;;13,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;24,2->24,6;;13,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;24,6->25,1;;13,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;25,1->25,6;;13,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;25,6->26,1;;13,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;26,1->26,5;;13,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;26,5->27,0;;13,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;27,0->27,4;;14,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;27,4->27,7;;14,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;27,7->28,1;;14,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;28,1->28,5;;14,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;28,5->28,8;;14,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;28,8->29,2;;14,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;29,2->29,6;;14,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;29,6->30,0;;14,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;30,0->30,3;;14,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;30,3->30,7;;14,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;30,7->31,1;;15,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;31,1->31,4;;15,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;31,4->31,8;;15,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;31,8->32,1;;15,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;32,1->32,5;;15,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;32,5->32,9;;15,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;32,9->33,2;;15,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;33,2->33,6;;15,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;33,6->33,9;;15,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;33,9->34,3;;15,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;34,3->34,7;;16,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;34,7->35,0;;16,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;35,0->35,4;;16,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;35,4->35,7;;16,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;35,7->36,1;;16,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;36,1->36,5;;16,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;36,5->36,8;;16,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;36,8->37,2;;16,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;37,2->37,5;;16,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;37,5->37,9;;16,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;37,9->38,2;;17,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;38,2->38,6;;17,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;38,6->38,9;;17,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;38,9->39,3;;17,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;39,3->39,6;;17,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;39,6->39,9;;17,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;39,9->40,3;;17,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;40,3->40,6;;17,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;40,6->41,0;;17,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;41,0->41,3;;17,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;41,3->41,6;;18,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;41,6->42,0;;18,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;42,0->42,3;;18,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;42,3->42,7;;18,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;42,7->43,0;;18,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;43,0->43,3;;18,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;43,3->43,7;;18,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;43,7->44,0;;18,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;44,0->44,4;;18,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;44,4->44,7;;18,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;44,7->45,0;;19,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;45,0->45,4;;19,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;45,4->45,7;;19,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;45,7->46,1;;19,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;46,1->46,4;;19,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;46,4->46,7;;19,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;46,7->47,1;;19,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;47,1->47,4;;19,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;47,4->47,8;;19,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;47,8->48,1;;19,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;48,1->48,4;;20,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;48,4->48,7;;20,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;48,7->49,1;;20,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;49,1->49,4;;20,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;49,4->49,7;;20,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;49,7->50,0;;20,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;50,0->50,3;;20,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;50,3->50,7;;20,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;50,7->51,0;;20,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;51,0->51,3;;20,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;51,3->51,6;;21,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;51,6->51,9;;21,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;51,9->52,3;;21,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;52,3->52,6;;21,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;52,6->52,9;;21,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;52,9->53,2;;21,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;53,2->53,5;;21,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;53,5->53,9;;21,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;53,9->54,2;;21,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;54,2->54,5;;21,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;54,5->54,8;;22,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;54,8->55,1;;22,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;55,1->55,4;;22,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;55,4->55,7;;22,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;55,7->56,0;;22,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;56,0->56,3;;22,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;56,3->56,6;;22,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;56,6->56,9;;22,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;56,9->57,2;;22,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;57,2->57,5;;22,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;57,5->57,8;;23,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;57,8->58,1;;23,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;58,1->58,4;;23,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;58,4->58,7;;23,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;58,7->59,0;;23,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;59,0->59,3;;23,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;59,3->59,6;;23,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;59,6->59,9;;23,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;59,9->60,2;;23,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;60,2->60,5;;23,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;60,5->60,8;;24,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;60,8->61,1;;24,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;61,1->61,4;;24,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;61,4->61,7;;24,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;61,7->62,0;;24,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;62,0->62,2;;24,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;62,2->62,5;;24,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;62,5->62,8;;24,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;62,8->63,1;;24,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;63,1->63,4;;24,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;63,4->63,7;;25,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;63,7->64,0;;25,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;64,0->64,2;;25,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;64,2->64,5;;25,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;64,5->64,8;;25,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;64,8->65,1;;25,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;65,1->65,4;;25,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;65,4->65,6;;25,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;65,6->65,9;;25,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;65,9->66,2;;25,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;66,2->66,5;;26,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;66,5->66,7;;26,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;66,7->67,0;;26,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;67,0->67,3;;26,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;67,3->67,6;;26,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;67,6->67,8;;26,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;67,8->68,1;;26,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;68,1->68,4;;26,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;68,4->68,6;;26,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;68,6->68,9;;26,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;68,9->69,2;;27,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;69,2->69,4;;27,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;69,4->69,6;;27,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;69,6->69,9;;27,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;69,9->70,2;;27,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;70,2->70,4;;27,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;70,4->70,6;;27,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;70,6->70,9;;27,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;70,9->71,2;;27,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;71,2->71,4;;27,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;71,4->71,6;;28,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;71,6->71,9;;28,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;71,9->72,2;;28,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;72,2->72,4;;28,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;72,4->72,6;;28,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;72,6->72,9;;28,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;72,9->73,2;;28,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;73,2->73,4;;28,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;73,4->73,6;;28,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;73,6->73,9;;28,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;73,9->74,1;;29,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;74,1->74,4;;29,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;74,4->74,6;;29,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;74,6->74,8;;29,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;74,8->75,1;;29,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;75,1->75,3;;29,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;75,3->75,5;;29,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;75,5->75,7;;29,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;75,7->76,0;;29,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;76,0->76,2;;29,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;76,2->76,4;;30,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;76,4->76,7;;30,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;76,7->76,9;;30,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;76,9->77,1;;30,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;77,1->77,4;;30,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;77,4->77,6;;30,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;77,6->77,8;;30,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;77,8->78,0;;30,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;78,0->78,3;;30,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;78,3->78,5;;30,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;78,5->78,7;;31,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;78,7->78,9;;31,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;78,9->79,1;;31,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;79,1->79,3;;31,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;79,3->79,6;;31,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;79,6->79,8;;31,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;79,8->80,0;;31,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;80,0->80,2;;31,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;80,2->80,4;;31,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;80,4->80,6;;31,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;80,6->80,8;;32,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;80,8->81,0;;32,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;81,0->81,2;;32,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;81,2->81,4;;32,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;81,4->81,6;;32,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;81,6->81,7;;32,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;81,7->81,9;;32,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;81,9->82,1;;32,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;82,1->82,3;;32,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;82,3->82,5;;32,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;82,5->82,7;;33,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;82,7->82,9;;33,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;82,9->83,1;;33,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;83,1->83,3;;33,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;83,3->83,4;;33,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;83,4->83,6;;33,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;83,6->83,8;;33,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;83,8->84,0;;33,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;84,0->84,2;;33,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;84,2->84,4;;33,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;84,4->84,6;;34,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;84,6->84,7;;34,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;84,7->84,9;;34,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;84,9->85,1;;34,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;85,1->85,2;;34,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;85,2->85,4;;34,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;85,4->85,6;;34,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;85,6->85,8;;34,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;85,8->85,9;;34,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;85,9->86,1;;34,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;86,1->86,2;;35,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;86,2->86,4;;35,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;86,4->86,6;;35,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;86,6->86,7;;35,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;86,7->86,8;;35,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;86,8->87,0;;35,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;87,0->87,1;;35,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;87,1->87,3;;35,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;87,3->87,4;;35,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;87,4->87,6;;35,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;87,6->87,8;;36,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;87,8->87,9;;36,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;87,9->88,0;;36,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;88,0->88,2;;36,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;88,2->88,4;;36,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;88,4->88,5;;36,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;88,5->88,6;;36,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;88,6->88,8;;36,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;88,8->88,9;;36,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;88,9->89,1;;36,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;89,1->89,2;;37,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;89,2->89,3;;37,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;89,3->89,5;;37,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;89,5->89,6;;37,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;89,6->89,7;;37,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;89,7->89,8;;37,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;89,8->89,9;;37,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;89,9->90,1;;37,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;90,1->90,2;;37,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;90,2->90,3;;37,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;90,3->90,4;;38,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;90,4->90,5;;38,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;90,5->90,6;;38,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;90,6->90,7;;38,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;90,7->90,8;;38,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;90,8->91,0;;38,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;91,0->91,1;;38,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;91,1->91,2;;38,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;91,2->91,3;;38,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;91,3->91,4;;38,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;91,4->91,5;;39,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;91,5->91,6;;39,10 semanas$$\n");
        sb.append("451;;cadastrarLogica;;91,6->91,7;;39,20 semanas$$\n");
        sb.append("451;;cadastrarLogica;;91,7->91,8;;39,30 semanas$$\n");
        sb.append("451;;cadastrarLogica;;91,8->91,9;;39,40 semanas$$\n");
        sb.append("451;;cadastrarLogica;;91,9->92,0;;39,50 semanas$$\n");
        sb.append("451;;cadastrarLogica;;92,0->92,1;;39,60 semanas$$\n");
        sb.append("451;;cadastrarLogica;;92,1->92,2;;39,70 semanas$$\n");
        sb.append("451;;cadastrarLogica;;92,2->92,3;;39,80 semanas$$\n");
        sb.append("451;;cadastrarLogica;;92,3->92,4;;39,90 semanas$$\n");
        sb.append("451;;cadastrarLogica;;92,4->93,1;;40,00 semanas$$\n");
        sb.append("451;;cadastrarLogica;;93,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

    }

    private static void preencherIghFeto4 ()
    {

        // <editor-fold defaultstate="collapsed" desc="Fêmur">

        sb.append("454;;cadastrarLogica;;0,0->7,1;;<12,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;7,1->8,1;;12,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;8,1->9,1;;12,33 semanas$$\n");
        sb.append("454;;cadastrarLogica;;9,1->10,1;;12,67 semanas$$\n");
        sb.append("454;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("454;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("454;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("454;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("454;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("454;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("454;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;20,1->21,1;;16,33 semanas$$\n");
        sb.append("454;;cadastrarLogica;;21,1->22,1;;16,67 semanas$$\n");
        sb.append("454;;cadastrarLogica;;22,1->23,1;;17,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;23,1->24,1;;17,50 semanas$$\n");
        sb.append("454;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("454;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("454;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;28,1->29,1;;19,33 semanas$$\n");
        sb.append("454;;cadastrarLogica;;29,1->30,1;;19,67 semanas$$\n");
        sb.append("454;;cadastrarLogica;;30,1->31,1;;20,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;31,1->32,1;;20,33 semanas$$\n");
        sb.append("454;;cadastrarLogica;;32,1->33,1;;20,67 semanas$$\n");
        sb.append("454;;cadastrarLogica;;33,1->34,1;;21,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;34,1->35,1;;21,50 semanas$$\n");
        sb.append("454;;cadastrarLogica;;35,1->36,1;;22,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;36,1->37,1;;22,33 semanas$$\n");
        sb.append("454;;cadastrarLogica;;37,1->38,1;;22,67 semanas$$\n");
        sb.append("454;;cadastrarLogica;;38,1->39,1;;23,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;39,1->40,1;;23,33 semanas$$\n");
        sb.append("454;;cadastrarLogica;;40,1->41,1;;23,67 semanas$$\n");
        sb.append("454;;cadastrarLogica;;41,1->42,1;;24,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;42,1->43,1;;24,50 semanas$$\n");
        sb.append("454;;cadastrarLogica;;43,1->44,1;;25,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;44,1->45,1;;25,33 semanas$$\n");
        sb.append("454;;cadastrarLogica;;45,1->46,1;;25,67 semanas$$\n");
        sb.append("454;;cadastrarLogica;;46,1->47,1;;26,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;47,1->48,1;;26,50 semanas$$\n");
        sb.append("454;;cadastrarLogica;;48,1->49,1;;27,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;49,1->50,1;;27,33 semanas$$\n");
        sb.append("454;;cadastrarLogica;;50,1->51,1;;27,67 semanas$$\n");
        sb.append("454;;cadastrarLogica;;51,1->52,1;;28,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;52,1->53,1;;28,50 semanas$$\n");
        sb.append("454;;cadastrarLogica;;53,1->54,1;;29,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;54,1->55,1;;29,50 semanas$$\n");
        sb.append("454;;cadastrarLogica;;55,1->56,1;;30,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;56,1->57,1;;30,33 semanas$$\n");
        sb.append("454;;cadastrarLogica;;57,1->58,1;;30,67 semanas$$\n");
        sb.append("454;;cadastrarLogica;;58,1->59,1;;31,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;59,1->60,1;;31,50 semanas$$\n");
        sb.append("454;;cadastrarLogica;;60,1->61,1;;32,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;61,1->62,1;;32,50 semanas$$\n");
        sb.append("454;;cadastrarLogica;;62,1->63,1;;33,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;63,1->64,1;;33,50 semanas$$\n");
        sb.append("454;;cadastrarLogica;;64,1->65,1;;34,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;65,1->66,1;;34,50 semanas$$\n");
        sb.append("454;;cadastrarLogica;;66,1->67,1;;35,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;67,1->68,1;;36,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;68,1->69,1;;36,50 semanas$$\n");
        sb.append("454;;cadastrarLogica;;69,1->70,1;;37,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;70,1->71,1;;38,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;71,1->72,1;;38,50 semanas$$\n");
        sb.append("454;;cadastrarLogica;;72,1->73,1;;39,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;73,1->74,1;;40,00 semanas$$\n");
        sb.append("454;;cadastrarLogica;;74,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Úmero">

        sb.append("455;;cadastrarLogica;;0,0->8,1;;<12,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;8,1->9,1;;12,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;9,1->10,1;;12,50 semanas$$\n");
        sb.append("455;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("455;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("455;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("455;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("455;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("455;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("455;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;20,1->21,1;;16,50 semanas$$\n");
        sb.append("455;;cadastrarLogica;;21,1->22,1;;17,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;22,1->23,1;;17,33 semanas$$\n");
        sb.append("455;;cadastrarLogica;;23,1->24,1;;17,67 semanas$$\n");
        sb.append("455;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("455;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("455;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;28,1->29,1;;19,50 semanas$$\n");
        sb.append("455;;cadastrarLogica;;29,1->30,1;;20,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;30,1->31,1;;20,33 semanas$$\n");
        sb.append("455;;cadastrarLogica;;31,1->32,1;;20,67 semanas$$\n");
        sb.append("455;;cadastrarLogica;;32,1->33,1;;21,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;33,1->34,1;;21,50 semanas$$\n");
        sb.append("455;;cadastrarLogica;;34,1->35,1;;22,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;35,1->36,1;;22,33 semanas$$\n");
        sb.append("455;;cadastrarLogica;;36,1->37,1;;22,67 semanas$$\n");
        sb.append("455;;cadastrarLogica;;37,1->38,1;;23,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;38,1->39,1;;23,50 semanas$$\n");
        sb.append("455;;cadastrarLogica;;39,1->40,1;;24,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;40,1->41,1;;24,50 semanas$$\n");
        sb.append("455;;cadastrarLogica;;41,1->42,1;;25,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;42,1->43,1;;25,50 semanas$$\n");
        sb.append("455;;cadastrarLogica;;43,1->44,1;;26,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;44,1->45,1;;26,50 semanas$$\n");
        sb.append("455;;cadastrarLogica;;45,1->46,1;;27,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;46,1->47,1;;27,50 semanas$$\n");
        sb.append("455;;cadastrarLogica;;47,1->48,1;;28,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;48,1->49,1;;28,50 semanas$$\n");
        sb.append("455;;cadastrarLogica;;49,1->50,1;;29,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;50,1->51,1;;30,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;51,1->52,1;;30,50 semanas$$\n");
        sb.append("455;;cadastrarLogica;;52,1->53,1;;31,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;53,1->54,1;;31,50 semanas$$\n");
        sb.append("455;;cadastrarLogica;;54,1->55,1;;32,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;55,1->56,1;;33,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;56,1->57,1;;33,50 semanas$$\n");
        sb.append("455;;cadastrarLogica;;57,1->58,1;;34,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;58,1->59,1;;35,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;59,1->60,1;;35,50 semanas$$\n");
        sb.append("455;;cadastrarLogica;;60,1->61,1;;36,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;61,1->62,1;;37,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;63,1->64,1;;38,50 semanas$$\n");
        sb.append("455;;cadastrarLogica;;64,1->65,1;;39,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("455;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ulna">

        sb.append("456;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("456;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("456;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;10,1->11,1;;13,33 semanas$$\n");
        sb.append("456;;cadastrarLogica;;11,1->12,1;;13,67 semanas$$\n");
        sb.append("456;;cadastrarLogica;;12,1->13,1;;14,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;13,1->14,1;;14,50 semanas$$\n");
        sb.append("456;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;15,1->16,1;;15,33 semanas$$\n");
        sb.append("456;;cadastrarLogica;;16,1->17,1;;15,67 semanas$$\n");
        sb.append("456;;cadastrarLogica;;17,1->18,1;;16,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;18,1->19,1;;16,33 semanas$$\n");
        sb.append("456;;cadastrarLogica;;19,1->20,1;;16,67 semanas$$\n");
        sb.append("456;;cadastrarLogica;;20,1->21,1;;17,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;21,1->22,1;;17,50 semanas$$\n");
        sb.append("456;;cadastrarLogica;;22,1->23,1;;18,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;23,1->24,1;;18,33 semanas$$\n");
        sb.append("456;;cadastrarLogica;;24,1->25,1;;18,67 semanas$$\n");
        sb.append("456;;cadastrarLogica;;25,1->26,1;;19,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;26,1->27,1;;19,50 semanas$$\n");
        sb.append("456;;cadastrarLogica;;27,1->28,1;;20,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;28,1->29,1;;20,33 semanas$$\n");
        sb.append("456;;cadastrarLogica;;29,1->30,1;;20,67 semanas$$\n");
        sb.append("456;;cadastrarLogica;;30,1->31,1;;21,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;31,1->32,1;;21,50 semanas$$\n");
        sb.append("456;;cadastrarLogica;;32,1->33,1;;22,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;33,1->34,1;;22,50 semanas$$\n");
        sb.append("456;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("456;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;37,1->38,1;;24,50 semanas$$\n");
        sb.append("456;;cadastrarLogica;;38,1->39,1;;25,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;39,1->40,1;;25,50 semanas$$\n");
        sb.append("456;;cadastrarLogica;;40,1->41,1;;26,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;41,1->42,1;;26,50 semanas$$\n");
        sb.append("456;;cadastrarLogica;;42,1->43,1;;27,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;43,1->44,1;;27,50 semanas$$\n");
        sb.append("456;;cadastrarLogica;;44,1->45,1;;28,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;45,1->46,1;;28,50 semanas$$\n");
        sb.append("456;;cadastrarLogica;;46,1->47,1;;29,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;47,1->48,1;;30,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;48,1->49,1;;30,50 semanas$$\n");
        sb.append("456;;cadastrarLogica;;49,1->50,1;;31,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;50,1->51,1;;31,50 semanas$$\n");
        sb.append("456;;cadastrarLogica;;51,1->52,1;;32,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;52,1->53,1;;33,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;53,1->54,1;;33,50 semanas$$\n");
        sb.append("456;;cadastrarLogica;;54,1->55,1;;34,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;55,1->56,1;;35,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;56,1->57,1;;36,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;57,1->58,1;;37,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;58,1->59,1;;38,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;59,1->60,1;;39,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;60,1->61,1;;40,00 semanas$$\n");
        sb.append("456;;cadastrarLogica;;61,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tíbia">

        sb.append("457;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("457;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("457;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;10,1->11,1;;13,50 semanas$$\n");
        sb.append("457;;cadastrarLogica;;11,1->12,1;;14,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;12,1->13,1;;14,33 semanas$$\n");
        sb.append("457;;cadastrarLogica;;13,1->14,1;;14,67 semanas$$\n");
        sb.append("457;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;15,1->16,1;;15,50 semanas$$\n");
        sb.append("457;;cadastrarLogica;;16,1->17,1;;16,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;17,1->18,1;;16,33 semanas$$\n");
        sb.append("457;;cadastrarLogica;;18,1->19,1;;16,67 semanas$$\n");
        sb.append("457;;cadastrarLogica;;19,1->20,1;;17,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;20,1->21,1;;17,50 semanas$$\n");
        sb.append("457;;cadastrarLogica;;21,1->22,1;;18,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;22,1->23,1;;18,33 semanas$$\n");
        sb.append("457;;cadastrarLogica;;23,1->24,1;;18,67 semanas$$\n");
        sb.append("457;;cadastrarLogica;;24,1->25,1;;19,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;25,1->26,1;;19,50 semanas$$\n");
        sb.append("457;;cadastrarLogica;;26,1->27,1;;20,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;27,1->28,1;;20,33 semanas$$\n");
        sb.append("457;;cadastrarLogica;;28,1->29,1;;20,67 semanas$$\n");
        sb.append("457;;cadastrarLogica;;29,1->30,1;;21,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;30,1->31,1;;21,50 semanas$$\n");
        sb.append("457;;cadastrarLogica;;31,1->32,1;;22,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;32,1->33,1;;22,33 semanas$$\n");
        sb.append("457;;cadastrarLogica;;33,1->34,1;;22,67 semanas$$\n");
        sb.append("457;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("457;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;37,1->38,1;;24,33 semanas$$\n");
        sb.append("457;;cadastrarLogica;;38,1->39,1;;24,67 semanas$$\n");
        sb.append("457;;cadastrarLogica;;39,1->40,1;;25,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;40,1->41,1;;25,50 semanas$$\n");
        sb.append("457;;cadastrarLogica;;41,1->42,1;;26,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;42,1->43,1;;26,50 semanas$$\n");
        sb.append("457;;cadastrarLogica;;43,1->44,1;;27,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;44,1->45,1;;27,50 semanas$$\n");
        sb.append("457;;cadastrarLogica;;45,1->46,1;;28,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;46,1->47,1;;28,50 semanas$$\n");
        sb.append("457;;cadastrarLogica;;47,1->48,1;;29,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;48,1->49,1;;29,50 semanas$$\n");
        sb.append("457;;cadastrarLogica;;49,1->50,1;;30,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;50,1->51,1;;30,50 semanas$$\n");
        sb.append("457;;cadastrarLogica;;51,1->52,1;;31,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;52,1->53,1;;31,50 semanas$$\n");
        sb.append("457;;cadastrarLogica;;53,1->54,1;;32,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;54,1->55,1;;33,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;55,1->56,1;;33,50 semanas$$\n");
        sb.append("457;;cadastrarLogica;;56,1->57,1;;34,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;57,1->58,1;;35,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;58,1->59,1;;35,50 semanas$$\n");
        sb.append("457;;cadastrarLogica;;59,1->60,1;;36,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;60,1->61,1;;37,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;61,1->62,1;;37,50 semanas$$\n");
        sb.append("457;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;63,1->64,1;;39,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;64,1->65,1;;39,50 semanas$$\n");
        sb.append("457;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("457;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.A.">

        sb.append("459;;cadastrarLogica;;0,0->39,3;;<11,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;39,3->40,6;;11,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;40,6->41,9;;11,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;41,9->43,2;;11,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;43,2->44,5;;11,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;44,5->45,8;;11,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;45,8->47,0;;11,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;47,0->48,3;;11,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;48,3->49,6;;11,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;49,6->50,9;;11,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;50,9->52,2;;11,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;52,2->53,5;;12,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;53,5->54,8;;12,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;54,8->56,0;;12,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;56,0->57,3;;12,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;57,3->58,6;;12,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;58,6->59,9;;12,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;59,9->61,2;;12,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;61,2->62,4;;12,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;62,4->63,7;;12,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;63,7->65,0;;12,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;65,0->66,3;;13,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;66,3->67,5;;13,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;67,5->68,8;;13,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;68,8->70,1;;13,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;70,1->71,4;;13,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;71,4->72,6;;13,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;72,6->73,9;;13,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;73,9->75,2;;13,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;75,2->76,4;;13,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;76,4->77,7;;13,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;77,7->79,0;;14,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;79,0->80,2;;14,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;80,2->81,4;;14,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;81,4->82,7;;14,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;82,7->84,0;;14,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;84,0->85,2;;14,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;85,2->86,4;;14,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;86,4->87,7;;14,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;87,7->89,0;;14,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;89,0->90,2;;14,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;90,2->91,4;;15,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;91,4->92,7;;15,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;92,7->94,0;;15,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;94,0->95,2;;15,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;95,2->96,4;;15,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;96,4->97,7;;15,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;97,7->99,0;;15,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;99,0->100,2;;15,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;100,2->101,4;;15,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;101,4->102,7;;15,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;102,7->103,9;;16,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;103,9->105,2;;16,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;105,2->106,4;;16,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;106,4->107,6;;16,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;107,6->108,8;;16,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;108,8->110,1;;16,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;110,1->111,3;;16,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;111,3->112,5;;16,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;112,5->113,8;;16,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;113,8->115,0;;16,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;115,0->116,2;;17,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;116,2->117,4;;17,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;117,4->118,7;;17,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;118,7->119,9;;17,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;119,9->121,1;;17,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;121,1->122,3;;17,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;122,3->123,5;;17,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;123,5->124,8;;17,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;124,8->126,0;;17,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;126,0->127,2;;17,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;127,2->128,4;;18,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;128,4->129,6;;18,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;129,6->130,8;;18,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;130,8->132,0;;18,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;132,0->133,2;;18,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;133,2->134,4;;18,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;134,4->135,6;;18,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;135,6->136,8;;18,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;136,8->138,0;;18,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;138,0->139,2;;18,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;139,2->140,4;;19,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;140,4->141,6;;19,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;141,6->142,8;;19,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;142,8->144,0;;19,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;144,0->145,1;;19,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;145,1->146,3;;19,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;146,3->147,5;;19,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;147,5->148,7;;19,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;148,7->149,9;;19,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;149,9->151,1;;19,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;151,1->152,3;;20,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;152,3->153,4;;20,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;153,4->154,6;;20,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;154,6->155,8;;20,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;155,8->157,0;;20,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;157,0->158,1;;20,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;158,1->159,3;;20,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;159,3->160,5;;20,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;160,5->161,6;;20,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;161,6->162,8;;20,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;162,8->164,0;;21,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;164,0->165,1;;21,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;165,1->166,3;;21,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;166,3->167,4;;21,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;167,4->168,6;;21,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;168,6->169,8;;21,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;169,8->170,9;;21,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;170,9->172,1;;21,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;172,1->173,2;;21,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;173,2->174,4;;21,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;174,4->175,5;;22,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;175,5->176,7;;22,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;176,7->177,8;;22,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;177,8->179,0;;22,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;179,0->180,1;;22,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;180,1->181,2;;22,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;181,2->182,4;;22,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;182,4->183,5;;22,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;183,5->184,7;;22,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;184,7->185,8;;22,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;185,8->186,9;;23,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;186,9->188,0;;23,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;188,0->189,2;;23,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;189,2->190,3;;23,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;190,3->191,4;;23,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;191,4->192,5;;23,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;192,5->193,6;;23,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;193,6->194,8;;23,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;194,8->195,9;;23,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;195,9->197,0;;23,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;197,0->198,1;;24,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;198,1->199,2;;24,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;199,2->200,3;;24,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;200,3->201,4;;24,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;201,4->202,5;;24,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;202,5->203,6;;24,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;203,6->204,7;;24,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;204,7->205,8;;24,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;205,8->206,9;;24,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;206,9->208,0;;24,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;208,0->209,1;;25,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;209,1->210,2;;25,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;210,2->211,2;;25,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;211,2->212,3;;25,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;212,3->213,4;;25,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;213,4->214,5;;25,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;214,5->215,6;;25,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;215,6->216,6;;25,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;216,6->217,7;;25,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;217,7->218,8;;25,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;218,8->219,9;;26,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;219,9->220,9;;26,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;220,9->222,0;;26,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;222,0->223,0;;26,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;223,0->224,1;;26,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;224,1->225,2;;26,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;225,2->226,2;;26,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;226,2->227,3;;26,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;227,3->228,3;;26,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;228,3->229,4;;26,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;229,4->230,4;;27,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;230,4->231,5;;27,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;231,5->232,5;;27,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;232,5->233,6;;27,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;233,6->234,6;;27,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;234,6->235,6;;27,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;235,6->236,7;;27,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;236,7->237,7;;27,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;237,7->238,8;;27,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;238,8->239,8;;27,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;239,8->240,8;;28,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;240,8->241,8;;28,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;241,8->242,8;;28,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;242,8->243,8;;28,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;243,8->244,9;;28,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;244,9->245,9;;28,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;245,9->246,9;;28,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;246,9->247,9;;28,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;247,9->248,9;;28,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;248,9->249,9;;28,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;249,9->250,9;;29,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;250,9->251,9;;29,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;251,9->252,9;;29,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;252,9->253,9;;29,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;253,9->254,9;;29,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;254,9->255,8;;29,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;255,8->256,8;;29,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;256,8->257,8;;29,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;257,8->258,8;;29,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;258,8->259,8;;29,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;259,8->260,8;;30,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;260,8->261,7;;30,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;261,7->262,7;;30,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;262,7->263,7;;30,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;263,7->264,6;;30,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;264,6->265,6;;30,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;265,6->266,6;;30,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;266,6->267,6;;30,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;267,6->268,5;;30,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;268,5->269,5;;30,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;269,5->270,4;;31,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;270,4->271,4;;31,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;271,4->272,4;;31,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;272,4->273,3;;31,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;273,3->274,2;;31,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;274,2->275,2;;31,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;275,2->276,2;;31,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;276,2->277,1;;31,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;277,1->278,0;;31,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;278,0->279,0;;31,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;279,0->279,9;;32,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;279,9->280,8;;32,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;280,8->281,7;;32,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;281,7->282,6;;32,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;282,6->283,6;;32,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;283,6->284,5;;32,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;284,5->285,4;;32,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;285,4->286,3;;32,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;286,3->287,2;;32,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;287,2->288,1;;32,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;288,1->289,0;;33,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;289,0->289,9;;33,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;289,9->290,8;;33,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;290,8->291,7;;33,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;291,7->292,6;;33,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;292,6->293,5;;33,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;293,5->294,4;;33,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;294,4->295,3;;33,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;295,3->296,2;;33,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;296,2->297,1;;33,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;297,1->298,0;;34,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;298,0->298,8;;34,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;298,8->299,7;;34,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;299,7->300,5;;34,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;300,5->301,4;;34,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;301,4->302,3;;34,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;302,3->303,1;;34,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;303,1->304,0;;34,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;304,0->304,8;;34,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;304,8->305,7;;34,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;305,7->306,5;;35,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;306,5->307,4;;35,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;307,4->308,2;;35,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;308,2->309,1;;35,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;309,1->309,9;;35,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;309,9->310,7;;35,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;310,7->311,6;;35,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;311,6->312,4;;35,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;312,4->313,3;;35,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;313,3->314,1;;35,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;314,1->314,9;;36,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;314,9->315,7;;36,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;315,7->316,5;;36,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;316,5->317,3;;36,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;317,3->318,1;;36,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;318,1->318,9;;36,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;318,9->319,7;;36,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;319,7->320,5;;36,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;320,5->321,3;;36,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;321,3->322,1;;36,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;322,1->322,9;;37,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;322,9->323,7;;37,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;323,7->324,4;;37,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;324,4->325,2;;37,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;325,2->326,0;;37,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;326,0->326,8;;37,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;326,8->327,6;;37,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;327,6->328,3;;37,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;328,3->329,1;;37,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;329,1->329,9;;37,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;329,9->330,6;;38,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;330,6->331,4;;38,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;331,4->332,2;;38,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;332,2->332,9;;38,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;332,9->333,6;;38,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;333,6->334,4;;38,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;334,4->335,2;;38,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;335,2->335,9;;38,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;335,9->336,6;;38,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;336,6->337,4;;38,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;337,4->338,1;;39,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;338,1->338,8;;39,10 semanas$$\n");
        sb.append("459;;cadastrarLogica;;338,8->339,5;;39,20 semanas$$\n");
        sb.append("459;;cadastrarLogica;;339,5->340,2;;39,30 semanas$$\n");
        sb.append("459;;cadastrarLogica;;340,2->341,0;;39,40 semanas$$\n");
        sb.append("459;;cadastrarLogica;;341,0->341,7;;39,50 semanas$$\n");
        sb.append("459;;cadastrarLogica;;341,7->342,4;;39,60 semanas$$\n");
        sb.append("459;;cadastrarLogica;;342,4->343,1;;39,70 semanas$$\n");
        sb.append("459;;cadastrarLogica;;343,1->343,8;;39,80 semanas$$\n");
        sb.append("459;;cadastrarLogica;;343,8->344,5;;39,90 semanas$$\n");
        sb.append("459;;cadastrarLogica;;344,5->346,1;;40,00 semanas$$\n");
        sb.append("459;;cadastrarLogica;;346,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.C.">

        sb.append("460;;cadastrarLogica;;0,0->53,2;;<11,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;53,2->54,6;;11,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;54,6->56,1;;11,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;56,1->57,5;;11,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;57,5->58,9;;11,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;58,9->60,4;;11,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;60,4->61,8;;11,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;61,8->63,2;;11,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;63,2->64,6;;11,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;64,6->66,1;;11,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;66,1->67,5;;11,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;67,5->68,9;;12,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;68,9->70,4;;12,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;70,4->71,8;;12,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;71,8->73,2;;12,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;73,2->74,6;;12,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;74,6->76,1;;12,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;76,1->77,5;;12,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;77,5->78,9;;12,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;78,9->80,4;;12,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;80,4->81,8;;12,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;81,8->83,2;;13,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;83,2->84,5;;13,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;84,5->85,9;;13,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;85,9->87,3;;13,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;87,3->88,6;;13,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;88,6->90,0;;13,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;90,0->91,4;;13,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;91,4->92,8;;13,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;92,8->94,1;;13,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;94,1->95,5;;13,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;95,5->96,9;;14,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;96,9->98,2;;14,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;98,2->99,6;;14,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;99,6->101,0;;14,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;101,0->102,4;;14,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;102,4->103,7;;14,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;103,7->105,1;;14,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;105,1->106,5;;14,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;106,5->107,8;;14,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;107,8->109,2;;14,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;109,2->110,6;;15,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;110,6->111,9;;15,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;111,9->113,2;;15,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;113,2->114,6;;15,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;114,6->116,0;;15,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;116,0->117,3;;15,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;117,3->118,6;;15,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;118,6->120,0;;15,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;120,0->121,4;;15,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;121,4->122,7;;15,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;122,7->124,0;;16,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;124,0->125,3;;16,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;125,3->126,6;;16,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;126,6->127,9;;16,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;127,9->129,2;;16,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;129,2->130,6;;16,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;130,6->131,9;;16,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;131,9->133,2;;16,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;133,2->134,5;;16,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;134,5->135,8;;16,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;135,8->137,1;;17,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;137,1->138,4;;17,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;138,4->139,7;;17,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;139,7->141,0;;17,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;141,0->142,2;;17,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;142,2->143,5;;17,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;143,5->144,8;;17,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;144,8->146,1;;17,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;146,1->147,4;;17,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;147,4->148,7;;17,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;148,7->150,0;;18,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;150,0->151,2;;18,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;151,2->152,5;;18,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;152,5->153,7;;18,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;153,7->155,0;;18,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;155,0->156,3;;18,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;156,3->157,5;;18,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;157,5->158,8;;18,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;158,8->160,0;;18,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;160,0->161,3;;18,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;161,3->162,5;;19,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;162,5->163,7;;19,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;163,7->165,0;;19,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;165,0->166,2;;19,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;166,2->167,4;;19,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;167,4->168,6;;19,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;168,6->169,8;;19,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;169,8->171,1;;19,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;171,1->172,3;;19,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;172,3->173,5;;19,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;173,5->174,7;;20,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;174,7->175,9;;20,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;175,9->177,1;;20,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;177,1->178,3;;20,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;178,3->179,5;;20,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;179,5->180,7;;20,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;180,7->181,9;;20,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;181,9->183,1;;20,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;183,1->184,3;;20,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;184,3->185,5;;20,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;185,5->186,6;;21,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;186,6->187,8;;21,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;187,8->189,0;;21,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;189,0->190,1;;21,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;190,1->191,2;;21,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;191,2->192,4;;21,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;192,4->193,6;;21,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;193,6->194,7;;21,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;194,7->195,8;;21,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;195,8->197,0;;21,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;197,0->198,1;;22,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;198,1->199,3;;22,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;199,3->200,4;;22,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;200,4->201,5;;22,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;201,5->202,6;;22,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;202,6->203,8;;22,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;203,8->204,9;;22,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;204,9->206,0;;22,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;206,0->207,2;;22,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;207,2->208,3;;22,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;208,3->209,4;;23,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;209,4->210,5;;23,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;210,5->211,5;;23,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;211,5->212,6;;23,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;212,6->213,7;;23,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;213,7->214,8;;23,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;214,8->215,9;;23,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;215,9->216,9;;23,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;216,9->218,0;;23,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;218,0->219,1;;23,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;219,1->220,1;;24,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;220,1->221,2;;24,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;221,2->222,2;;24,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;222,2->223,3;;24,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;223,3->224,3;;24,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;224,3->225,3;;24,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;225,3->226,4;;24,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;226,4->227,4;;24,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;227,4->228,5;;24,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;228,5->229,5;;24,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;229,5->230,5;;25,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;230,5->231,5;;25,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;231,5->232,5;;25,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;232,5->233,5;;25,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;233,5->234,5;;25,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;234,5->235,5;;25,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;235,5->236,5;;25,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;236,5->237,5;;25,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;237,5->238,5;;25,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;238,5->239,5;;25,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;239,5->240,5;;26,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;240,5->241,4;;26,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;241,4->242,4;;26,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;242,4->243,3;;26,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;243,3->244,3;;26,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;244,3->245,3;;26,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;245,3->246,2;;26,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;246,2->247,2;;26,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;247,2->248,1;;26,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;248,1->249,1;;26,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;249,1->250,0;;27,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;250,0->250,9;;27,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;250,9->251,9;;27,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;251,9->252,8;;27,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;252,8->253,7;;27,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;253,7->254,6;;27,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;254,6->255,5;;27,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;255,5->256,5;;27,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;256,5->257,4;;27,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;257,4->258,3;;27,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;258,3->259,2;;28,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;259,2->260,0;;28,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;260,0->260,9;;28,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;260,9->261,7;;28,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;261,7->262,6;;28,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;262,6->263,5;;28,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;263,5->264,3;;28,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;264,3->265,2;;28,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;265,2->266,0;;28,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;266,0->266,9;;28,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;266,9->267,7;;29,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;267,7->268,5;;29,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;268,5->269,4;;29,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;269,4->270,2;;29,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;270,2->271,0;;29,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;271,0->271,8;;29,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;271,8->272,6;;29,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;272,6->273,5;;29,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;273,5->274,3;;29,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;274,3->275,1;;29,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;275,1->275,9;;30,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;275,9->276,6;;30,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;276,6->277,4;;30,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;277,4->278,2;;30,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;278,2->279,0;;30,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;279,0->279,7;;30,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;279,7->280,5;;30,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;280,5->281,3;;30,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;281,3->282,0;;30,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;282,0->282,8;;30,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;282,8->283,5;;31,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;283,5->284,2;;31,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;284,2->284,9;;31,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;284,9->285,6;;31,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;285,6->286,4;;31,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;286,4->287,1;;31,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;287,1->287,8;;31,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;287,8->288,5;;31,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;288,5->289,2;;31,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;289,2->289,9;;31,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;289,9->290,6;;32,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;290,6->291,2;;32,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;291,2->291,9;;32,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;291,9->292,6;;32,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;292,6->293,2;;32,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;293,2->293,9;;32,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;293,9->294,6;;32,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;294,6->295,3;;32,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;295,3->295,9;;32,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;295,9->296,6;;32,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;296,6->297,2;;33,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;297,2->297,8;;33,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;297,8->298,4;;33,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;298,4->299,0;;33,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;299,0->299,6;;33,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;299,6->300,3;;33,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;300,3->300,9;;33,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;300,9->301,5;;33,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;301,5->302,1;;33,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;302,1->302,7;;33,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;302,7->303,2;;34,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;303,2->303,8;;34,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;303,8->304,3;;34,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;304,3->304,9;;34,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;304,9->305,4;;34,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;305,4->306,0;;34,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;306,0->306,6;;34,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;306,6->307,1;;34,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;307,1->307,6;;34,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;307,6->308,2;;34,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;308,2->308,7;;35,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;308,7->309,2;;35,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;309,2->309,7;;35,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;309,7->310,2;;35,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;310,2->310,6;;35,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;310,6->311,1;;35,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;311,1->311,6;;35,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;311,6->312,1;;35,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;312,1->312,6;;35,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;312,6->313,1;;35,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;313,1->313,5;;36,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;313,5->314,0;;36,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;314,0->314,4;;36,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;314,4->314,9;;36,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;314,9->315,3;;36,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;315,3->315,7;;36,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;315,7->316,2;;36,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;316,2->316,6;;36,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;316,6->317,1;;36,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;317,1->317,5;;36,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;317,5->317,9;;37,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;317,9->318,2;;37,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;318,2->318,6;;37,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;318,6->319,0;;37,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;319,0->319,4;;37,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;319,4->319,7;;37,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;319,7->320,1;;37,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;320,1->320,5;;37,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;320,5->320,8;;37,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;320,8->321,2;;37,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;321,2->321,5;;38,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;321,5->321,8;;38,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;321,8->322,1;;38,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;322,1->322,4;;38,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;322,4->322,8;;38,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;322,8->323,1;;38,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;323,1->323,4;;38,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;323,4->323,7;;38,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;323,7->324,0;;38,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;324,0->324,3;;38,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;324,3->324,5;;39,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;324,5->324,8;;39,10 semanas$$\n");
        sb.append("460;;cadastrarLogica;;324,8->325,0;;39,20 semanas$$\n");
        sb.append("460;;cadastrarLogica;;325,0->325,3;;39,30 semanas$$\n");
        sb.append("460;;cadastrarLogica;;325,3->325,5;;39,40 semanas$$\n");
        sb.append("460;;cadastrarLogica;;325,5->325,7;;39,50 semanas$$\n");
        sb.append("460;;cadastrarLogica;;325,7->326,0;;39,60 semanas$$\n");
        sb.append("460;;cadastrarLogica;;326,0->326,2;;39,70 semanas$$\n");
        sb.append("460;;cadastrarLogica;;326,2->326,5;;39,80 semanas$$\n");
        sb.append("460;;cadastrarLogica;;326,5->326,7;;39,90 semanas$$\n");
        sb.append("460;;cadastrarLogica;;326,7->328,1;;40,00 semanas$$\n");
        sb.append("460;;cadastrarLogica;;328,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("458;;cadastrarLogica;;0,0->15,7;;<11,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;15,7->16,0;;11,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;16,0->16,4;;11,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;16,4->16,7;;11,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;16,7->17,1;;11,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;17,1->17,4;;11,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;17,4->17,7;;11,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;17,7->18,1;;11,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;18,1->18,4;;11,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;18,4->18,8;;11,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;18,8->19,1;;11,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;19,1->19,4;;12,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;19,4->19,7;;12,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;19,7->20,1;;12,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;20,1->20,4;;12,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;20,4->20,7;;12,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;20,7->21,0;;12,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;21,0->21,3;;12,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;21,3->21,7;;12,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;21,7->22,0;;12,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;22,0->22,3;;12,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;22,3->22,8;;13,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;22,8->23,2;;13,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;23,2->23,7;;13,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;23,7->24,2;;13,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;24,2->24,6;;13,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;24,6->25,1;;13,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;25,1->25,6;;13,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;25,6->26,1;;13,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;26,1->26,5;;13,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;26,5->27,0;;13,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;27,0->27,4;;14,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;27,4->27,7;;14,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;27,7->28,1;;14,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;28,1->28,5;;14,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;28,5->28,8;;14,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;28,8->29,2;;14,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;29,2->29,6;;14,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;29,6->30,0;;14,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;30,0->30,3;;14,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;30,3->30,7;;14,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;30,7->31,1;;15,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;31,1->31,4;;15,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;31,4->31,8;;15,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;31,8->32,1;;15,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;32,1->32,5;;15,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;32,5->32,9;;15,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;32,9->33,2;;15,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;33,2->33,6;;15,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;33,6->33,9;;15,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;33,9->34,3;;15,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;34,3->34,7;;16,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;34,7->35,0;;16,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;35,0->35,4;;16,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;35,4->35,7;;16,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;35,7->36,1;;16,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;36,1->36,5;;16,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;36,5->36,8;;16,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;36,8->37,2;;16,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;37,2->37,5;;16,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;37,5->37,9;;16,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;37,9->38,2;;17,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;38,2->38,6;;17,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;38,6->38,9;;17,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;38,9->39,3;;17,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;39,3->39,6;;17,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;39,6->39,9;;17,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;39,9->40,3;;17,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;40,3->40,6;;17,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;40,6->41,0;;17,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;41,0->41,3;;17,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;41,3->41,6;;18,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;41,6->42,0;;18,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;42,0->42,3;;18,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;42,3->42,7;;18,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;42,7->43,0;;18,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;43,0->43,3;;18,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;43,3->43,7;;18,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;43,7->44,0;;18,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;44,0->44,4;;18,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;44,4->44,7;;18,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;44,7->45,0;;19,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;45,0->45,4;;19,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;45,4->45,7;;19,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;45,7->46,1;;19,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;46,1->46,4;;19,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;46,4->46,7;;19,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;46,7->47,1;;19,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;47,1->47,4;;19,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;47,4->47,8;;19,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;47,8->48,1;;19,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;48,1->48,4;;20,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;48,4->48,7;;20,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;48,7->49,1;;20,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;49,1->49,4;;20,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;49,4->49,7;;20,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;49,7->50,0;;20,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;50,0->50,3;;20,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;50,3->50,7;;20,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;50,7->51,0;;20,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;51,0->51,3;;20,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;51,3->51,6;;21,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;51,6->51,9;;21,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;51,9->52,3;;21,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;52,3->52,6;;21,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;52,6->52,9;;21,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;52,9->53,2;;21,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;53,2->53,5;;21,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;53,5->53,9;;21,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;53,9->54,2;;21,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;54,2->54,5;;21,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;54,5->54,8;;22,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;54,8->55,1;;22,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;55,1->55,4;;22,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;55,4->55,7;;22,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;55,7->56,0;;22,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;56,0->56,3;;22,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;56,3->56,6;;22,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;56,6->56,9;;22,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;56,9->57,2;;22,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;57,2->57,5;;22,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;57,5->57,8;;23,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;57,8->58,1;;23,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;58,1->58,4;;23,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;58,4->58,7;;23,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;58,7->59,0;;23,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;59,0->59,3;;23,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;59,3->59,6;;23,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;59,6->59,9;;23,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;59,9->60,2;;23,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;60,2->60,5;;23,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;60,5->60,8;;24,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;60,8->61,1;;24,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;61,1->61,4;;24,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;61,4->61,7;;24,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;61,7->62,0;;24,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;62,0->62,2;;24,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;62,2->62,5;;24,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;62,5->62,8;;24,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;62,8->63,1;;24,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;63,1->63,4;;24,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;63,4->63,7;;25,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;63,7->64,0;;25,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;64,0->64,2;;25,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;64,2->64,5;;25,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;64,5->64,8;;25,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;64,8->65,1;;25,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;65,1->65,4;;25,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;65,4->65,6;;25,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;65,6->65,9;;25,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;65,9->66,2;;25,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;66,2->66,5;;26,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;66,5->66,7;;26,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;66,7->67,0;;26,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;67,0->67,3;;26,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;67,3->67,6;;26,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;67,6->67,8;;26,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;67,8->68,1;;26,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;68,1->68,4;;26,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;68,4->68,6;;26,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;68,6->68,9;;26,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;68,9->69,2;;27,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;69,2->69,4;;27,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;69,4->69,6;;27,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;69,6->69,9;;27,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;69,9->70,2;;27,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;70,2->70,4;;27,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;70,4->70,6;;27,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;70,6->70,9;;27,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;70,9->71,2;;27,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;71,2->71,4;;27,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;71,4->71,6;;28,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;71,6->71,9;;28,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;71,9->72,2;;28,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;72,2->72,4;;28,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;72,4->72,6;;28,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;72,6->72,9;;28,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;72,9->73,2;;28,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;73,2->73,4;;28,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;73,4->73,6;;28,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;73,6->73,9;;28,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;73,9->74,1;;29,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;74,1->74,4;;29,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;74,4->74,6;;29,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;74,6->74,8;;29,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;74,8->75,1;;29,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;75,1->75,3;;29,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;75,3->75,5;;29,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;75,5->75,7;;29,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;75,7->76,0;;29,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;76,0->76,2;;29,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;76,2->76,4;;30,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;76,4->76,7;;30,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;76,7->76,9;;30,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;76,9->77,1;;30,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;77,1->77,4;;30,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;77,4->77,6;;30,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;77,6->77,8;;30,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;77,8->78,0;;30,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;78,0->78,3;;30,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;78,3->78,5;;30,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;78,5->78,7;;31,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;78,7->78,9;;31,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;78,9->79,1;;31,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;79,1->79,3;;31,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;79,3->79,6;;31,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;79,6->79,8;;31,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;79,8->80,0;;31,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;80,0->80,2;;31,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;80,2->80,4;;31,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;80,4->80,6;;31,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;80,6->80,8;;32,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;80,8->81,0;;32,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;81,0->81,2;;32,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;81,2->81,4;;32,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;81,4->81,6;;32,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;81,6->81,7;;32,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;81,7->81,9;;32,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;81,9->82,1;;32,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;82,1->82,3;;32,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;82,3->82,5;;32,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;82,5->82,7;;33,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;82,7->82,9;;33,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;82,9->83,1;;33,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;83,1->83,3;;33,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;83,3->83,4;;33,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;83,4->83,6;;33,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;83,6->83,8;;33,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;83,8->84,0;;33,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;84,0->84,2;;33,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;84,2->84,4;;33,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;84,4->84,6;;34,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;84,6->84,7;;34,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;84,7->84,9;;34,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;84,9->85,1;;34,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;85,1->85,2;;34,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;85,2->85,4;;34,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;85,4->85,6;;34,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;85,6->85,8;;34,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;85,8->85,9;;34,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;85,9->86,1;;34,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;86,1->86,2;;35,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;86,2->86,4;;35,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;86,4->86,6;;35,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;86,6->86,7;;35,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;86,7->86,8;;35,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;86,8->87,0;;35,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;87,0->87,1;;35,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;87,1->87,3;;35,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;87,3->87,4;;35,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;87,4->87,6;;35,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;87,6->87,8;;36,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;87,8->87,9;;36,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;87,9->88,0;;36,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;88,0->88,2;;36,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;88,2->88,4;;36,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;88,4->88,5;;36,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;88,5->88,6;;36,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;88,6->88,8;;36,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;88,8->88,9;;36,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;88,9->89,1;;36,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;89,1->89,2;;37,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;89,2->89,3;;37,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;89,3->89,5;;37,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;89,5->89,6;;37,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;89,6->89,7;;37,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;89,7->89,8;;37,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;89,8->89,9;;37,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;89,9->90,1;;37,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;90,1->90,2;;37,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;90,2->90,3;;37,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;90,3->90,4;;38,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;90,4->90,5;;38,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;90,5->90,6;;38,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;90,6->90,7;;38,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;90,7->90,8;;38,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;90,8->91,0;;38,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;91,0->91,1;;38,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;91,1->91,2;;38,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;91,2->91,3;;38,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;91,3->91,4;;38,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;91,4->91,5;;39,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;91,5->91,6;;39,10 semanas$$\n");
        sb.append("458;;cadastrarLogica;;91,6->91,7;;39,20 semanas$$\n");
        sb.append("458;;cadastrarLogica;;91,7->91,8;;39,30 semanas$$\n");
        sb.append("458;;cadastrarLogica;;91,8->91,9;;39,40 semanas$$\n");
        sb.append("458;;cadastrarLogica;;91,9->92,0;;39,50 semanas$$\n");
        sb.append("458;;cadastrarLogica;;92,0->92,1;;39,60 semanas$$\n");
        sb.append("458;;cadastrarLogica;;92,1->92,2;;39,70 semanas$$\n");
        sb.append("458;;cadastrarLogica;;92,2->92,3;;39,80 semanas$$\n");
        sb.append("458;;cadastrarLogica;;92,3->92,4;;39,90 semanas$$\n");
        sb.append("458;;cadastrarLogica;;92,4->93,1;;40,00 semanas$$\n");
        sb.append("458;;cadastrarLogica;;93,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

    }

    private static void preencherIghFeto5 ()
    {

        // <editor-fold defaultstate="collapsed" desc="Fêmur">

        sb.append("461;;cadastrarLogica;;0,0->7,1;;<12,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;7,1->8,1;;12,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;8,1->9,1;;12,33 semanas$$\n");
        sb.append("461;;cadastrarLogica;;9,1->10,1;;12,67 semanas$$\n");
        sb.append("461;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("461;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("461;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("461;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("461;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("461;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("461;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;20,1->21,1;;16,33 semanas$$\n");
        sb.append("461;;cadastrarLogica;;21,1->22,1;;16,67 semanas$$\n");
        sb.append("461;;cadastrarLogica;;22,1->23,1;;17,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;23,1->24,1;;17,50 semanas$$\n");
        sb.append("461;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("461;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("461;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;28,1->29,1;;19,33 semanas$$\n");
        sb.append("461;;cadastrarLogica;;29,1->30,1;;19,67 semanas$$\n");
        sb.append("461;;cadastrarLogica;;30,1->31,1;;20,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;31,1->32,1;;20,33 semanas$$\n");
        sb.append("461;;cadastrarLogica;;32,1->33,1;;20,67 semanas$$\n");
        sb.append("461;;cadastrarLogica;;33,1->34,1;;21,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;34,1->35,1;;21,50 semanas$$\n");
        sb.append("461;;cadastrarLogica;;35,1->36,1;;22,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;36,1->37,1;;22,33 semanas$$\n");
        sb.append("461;;cadastrarLogica;;37,1->38,1;;22,67 semanas$$\n");
        sb.append("461;;cadastrarLogica;;38,1->39,1;;23,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;39,1->40,1;;23,33 semanas$$\n");
        sb.append("461;;cadastrarLogica;;40,1->41,1;;23,67 semanas$$\n");
        sb.append("461;;cadastrarLogica;;41,1->42,1;;24,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;42,1->43,1;;24,50 semanas$$\n");
        sb.append("461;;cadastrarLogica;;43,1->44,1;;25,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;44,1->45,1;;25,33 semanas$$\n");
        sb.append("461;;cadastrarLogica;;45,1->46,1;;25,67 semanas$$\n");
        sb.append("461;;cadastrarLogica;;46,1->47,1;;26,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;47,1->48,1;;26,50 semanas$$\n");
        sb.append("461;;cadastrarLogica;;48,1->49,1;;27,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;49,1->50,1;;27,33 semanas$$\n");
        sb.append("461;;cadastrarLogica;;50,1->51,1;;27,67 semanas$$\n");
        sb.append("461;;cadastrarLogica;;51,1->52,1;;28,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;52,1->53,1;;28,50 semanas$$\n");
        sb.append("461;;cadastrarLogica;;53,1->54,1;;29,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;54,1->55,1;;29,50 semanas$$\n");
        sb.append("461;;cadastrarLogica;;55,1->56,1;;30,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;56,1->57,1;;30,33 semanas$$\n");
        sb.append("461;;cadastrarLogica;;57,1->58,1;;30,67 semanas$$\n");
        sb.append("461;;cadastrarLogica;;58,1->59,1;;31,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;59,1->60,1;;31,50 semanas$$\n");
        sb.append("461;;cadastrarLogica;;60,1->61,1;;32,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;61,1->62,1;;32,50 semanas$$\n");
        sb.append("461;;cadastrarLogica;;62,1->63,1;;33,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;63,1->64,1;;33,50 semanas$$\n");
        sb.append("461;;cadastrarLogica;;64,1->65,1;;34,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;65,1->66,1;;34,50 semanas$$\n");
        sb.append("461;;cadastrarLogica;;66,1->67,1;;35,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;67,1->68,1;;36,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;68,1->69,1;;36,50 semanas$$\n");
        sb.append("461;;cadastrarLogica;;69,1->70,1;;37,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;70,1->71,1;;38,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;71,1->72,1;;38,50 semanas$$\n");
        sb.append("461;;cadastrarLogica;;72,1->73,1;;39,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;73,1->74,1;;40,00 semanas$$\n");
        sb.append("461;;cadastrarLogica;;74,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Úmero">

        sb.append("462;;cadastrarLogica;;0,0->8,1;;<12,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;8,1->9,1;;12,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;9,1->10,1;;12,50 semanas$$\n");
        sb.append("462;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("462;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("462;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("462;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("462;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("462;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("462;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;20,1->21,1;;16,50 semanas$$\n");
        sb.append("462;;cadastrarLogica;;21,1->22,1;;17,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;22,1->23,1;;17,33 semanas$$\n");
        sb.append("462;;cadastrarLogica;;23,1->24,1;;17,67 semanas$$\n");
        sb.append("462;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("462;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("462;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;28,1->29,1;;19,50 semanas$$\n");
        sb.append("462;;cadastrarLogica;;29,1->30,1;;20,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;30,1->31,1;;20,33 semanas$$\n");
        sb.append("462;;cadastrarLogica;;31,1->32,1;;20,67 semanas$$\n");
        sb.append("462;;cadastrarLogica;;32,1->33,1;;21,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;33,1->34,1;;21,50 semanas$$\n");
        sb.append("462;;cadastrarLogica;;34,1->35,1;;22,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;35,1->36,1;;22,33 semanas$$\n");
        sb.append("462;;cadastrarLogica;;36,1->37,1;;22,67 semanas$$\n");
        sb.append("462;;cadastrarLogica;;37,1->38,1;;23,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;38,1->39,1;;23,50 semanas$$\n");
        sb.append("462;;cadastrarLogica;;39,1->40,1;;24,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;40,1->41,1;;24,50 semanas$$\n");
        sb.append("462;;cadastrarLogica;;41,1->42,1;;25,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;42,1->43,1;;25,50 semanas$$\n");
        sb.append("462;;cadastrarLogica;;43,1->44,1;;26,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;44,1->45,1;;26,50 semanas$$\n");
        sb.append("462;;cadastrarLogica;;45,1->46,1;;27,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;46,1->47,1;;27,50 semanas$$\n");
        sb.append("462;;cadastrarLogica;;47,1->48,1;;28,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;48,1->49,1;;28,50 semanas$$\n");
        sb.append("462;;cadastrarLogica;;49,1->50,1;;29,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;50,1->51,1;;30,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;51,1->52,1;;30,50 semanas$$\n");
        sb.append("462;;cadastrarLogica;;52,1->53,1;;31,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;53,1->54,1;;31,50 semanas$$\n");
        sb.append("462;;cadastrarLogica;;54,1->55,1;;32,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;55,1->56,1;;33,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;56,1->57,1;;33,50 semanas$$\n");
        sb.append("462;;cadastrarLogica;;57,1->58,1;;34,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;58,1->59,1;;35,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;59,1->60,1;;35,50 semanas$$\n");
        sb.append("462;;cadastrarLogica;;60,1->61,1;;36,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;61,1->62,1;;37,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;63,1->64,1;;38,50 semanas$$\n");
        sb.append("462;;cadastrarLogica;;64,1->65,1;;39,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("462;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ulna">

        sb.append("463;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("463;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("463;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;10,1->11,1;;13,33 semanas$$\n");
        sb.append("463;;cadastrarLogica;;11,1->12,1;;13,67 semanas$$\n");
        sb.append("463;;cadastrarLogica;;12,1->13,1;;14,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;13,1->14,1;;14,50 semanas$$\n");
        sb.append("463;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;15,1->16,1;;15,33 semanas$$\n");
        sb.append("463;;cadastrarLogica;;16,1->17,1;;15,67 semanas$$\n");
        sb.append("463;;cadastrarLogica;;17,1->18,1;;16,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;18,1->19,1;;16,33 semanas$$\n");
        sb.append("463;;cadastrarLogica;;19,1->20,1;;16,67 semanas$$\n");
        sb.append("463;;cadastrarLogica;;20,1->21,1;;17,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;21,1->22,1;;17,50 semanas$$\n");
        sb.append("463;;cadastrarLogica;;22,1->23,1;;18,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;23,1->24,1;;18,33 semanas$$\n");
        sb.append("463;;cadastrarLogica;;24,1->25,1;;18,67 semanas$$\n");
        sb.append("463;;cadastrarLogica;;25,1->26,1;;19,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;26,1->27,1;;19,50 semanas$$\n");
        sb.append("463;;cadastrarLogica;;27,1->28,1;;20,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;28,1->29,1;;20,33 semanas$$\n");
        sb.append("463;;cadastrarLogica;;29,1->30,1;;20,67 semanas$$\n");
        sb.append("463;;cadastrarLogica;;30,1->31,1;;21,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;31,1->32,1;;21,50 semanas$$\n");
        sb.append("463;;cadastrarLogica;;32,1->33,1;;22,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;33,1->34,1;;22,50 semanas$$\n");
        sb.append("463;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("463;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;37,1->38,1;;24,50 semanas$$\n");
        sb.append("463;;cadastrarLogica;;38,1->39,1;;25,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;39,1->40,1;;25,50 semanas$$\n");
        sb.append("463;;cadastrarLogica;;40,1->41,1;;26,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;41,1->42,1;;26,50 semanas$$\n");
        sb.append("463;;cadastrarLogica;;42,1->43,1;;27,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;43,1->44,1;;27,50 semanas$$\n");
        sb.append("463;;cadastrarLogica;;44,1->45,1;;28,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;45,1->46,1;;28,50 semanas$$\n");
        sb.append("463;;cadastrarLogica;;46,1->47,1;;29,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;47,1->48,1;;30,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;48,1->49,1;;30,50 semanas$$\n");
        sb.append("463;;cadastrarLogica;;49,1->50,1;;31,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;50,1->51,1;;31,50 semanas$$\n");
        sb.append("463;;cadastrarLogica;;51,1->52,1;;32,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;52,1->53,1;;33,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;53,1->54,1;;33,50 semanas$$\n");
        sb.append("463;;cadastrarLogica;;54,1->55,1;;34,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;55,1->56,1;;35,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;56,1->57,1;;36,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;57,1->58,1;;37,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;58,1->59,1;;38,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;59,1->60,1;;39,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;60,1->61,1;;40,00 semanas$$\n");
        sb.append("463;;cadastrarLogica;;61,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tíbia">

        sb.append("464;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("464;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("464;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;10,1->11,1;;13,50 semanas$$\n");
        sb.append("464;;cadastrarLogica;;11,1->12,1;;14,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;12,1->13,1;;14,33 semanas$$\n");
        sb.append("464;;cadastrarLogica;;13,1->14,1;;14,67 semanas$$\n");
        sb.append("464;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;15,1->16,1;;15,50 semanas$$\n");
        sb.append("464;;cadastrarLogica;;16,1->17,1;;16,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;17,1->18,1;;16,33 semanas$$\n");
        sb.append("464;;cadastrarLogica;;18,1->19,1;;16,67 semanas$$\n");
        sb.append("464;;cadastrarLogica;;19,1->20,1;;17,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;20,1->21,1;;17,50 semanas$$\n");
        sb.append("464;;cadastrarLogica;;21,1->22,1;;18,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;22,1->23,1;;18,33 semanas$$\n");
        sb.append("464;;cadastrarLogica;;23,1->24,1;;18,67 semanas$$\n");
        sb.append("464;;cadastrarLogica;;24,1->25,1;;19,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;25,1->26,1;;19,50 semanas$$\n");
        sb.append("464;;cadastrarLogica;;26,1->27,1;;20,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;27,1->28,1;;20,33 semanas$$\n");
        sb.append("464;;cadastrarLogica;;28,1->29,1;;20,67 semanas$$\n");
        sb.append("464;;cadastrarLogica;;29,1->30,1;;21,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;30,1->31,1;;21,50 semanas$$\n");
        sb.append("464;;cadastrarLogica;;31,1->32,1;;22,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;32,1->33,1;;22,33 semanas$$\n");
        sb.append("464;;cadastrarLogica;;33,1->34,1;;22,67 semanas$$\n");
        sb.append("464;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("464;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;37,1->38,1;;24,33 semanas$$\n");
        sb.append("464;;cadastrarLogica;;38,1->39,1;;24,67 semanas$$\n");
        sb.append("464;;cadastrarLogica;;39,1->40,1;;25,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;40,1->41,1;;25,50 semanas$$\n");
        sb.append("464;;cadastrarLogica;;41,1->42,1;;26,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;42,1->43,1;;26,50 semanas$$\n");
        sb.append("464;;cadastrarLogica;;43,1->44,1;;27,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;44,1->45,1;;27,50 semanas$$\n");
        sb.append("464;;cadastrarLogica;;45,1->46,1;;28,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;46,1->47,1;;28,50 semanas$$\n");
        sb.append("464;;cadastrarLogica;;47,1->48,1;;29,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;48,1->49,1;;29,50 semanas$$\n");
        sb.append("464;;cadastrarLogica;;49,1->50,1;;30,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;50,1->51,1;;30,50 semanas$$\n");
        sb.append("464;;cadastrarLogica;;51,1->52,1;;31,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;52,1->53,1;;31,50 semanas$$\n");
        sb.append("464;;cadastrarLogica;;53,1->54,1;;32,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;54,1->55,1;;33,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;55,1->56,1;;33,50 semanas$$\n");
        sb.append("464;;cadastrarLogica;;56,1->57,1;;34,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;57,1->58,1;;35,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;58,1->59,1;;35,50 semanas$$\n");
        sb.append("464;;cadastrarLogica;;59,1->60,1;;36,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;60,1->61,1;;37,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;61,1->62,1;;37,50 semanas$$\n");
        sb.append("464;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;63,1->64,1;;39,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;64,1->65,1;;39,50 semanas$$\n");
        sb.append("464;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("464;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.A.">

        sb.append("466;;cadastrarLogica;;0,0->39,3;;<11,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;39,3->40,6;;11,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;40,6->41,9;;11,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;41,9->43,2;;11,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;43,2->44,5;;11,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;44,5->45,8;;11,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;45,8->47,0;;11,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;47,0->48,3;;11,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;48,3->49,6;;11,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;49,6->50,9;;11,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;50,9->52,2;;11,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;52,2->53,5;;12,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;53,5->54,8;;12,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;54,8->56,0;;12,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;56,0->57,3;;12,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;57,3->58,6;;12,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;58,6->59,9;;12,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;59,9->61,2;;12,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;61,2->62,4;;12,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;62,4->63,7;;12,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;63,7->65,0;;12,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;65,0->66,3;;13,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;66,3->67,5;;13,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;67,5->68,8;;13,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;68,8->70,1;;13,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;70,1->71,4;;13,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;71,4->72,6;;13,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;72,6->73,9;;13,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;73,9->75,2;;13,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;75,2->76,4;;13,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;76,4->77,7;;13,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;77,7->79,0;;14,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;79,0->80,2;;14,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;80,2->81,4;;14,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;81,4->82,7;;14,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;82,7->84,0;;14,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;84,0->85,2;;14,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;85,2->86,4;;14,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;86,4->87,7;;14,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;87,7->89,0;;14,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;89,0->90,2;;14,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;90,2->91,4;;15,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;91,4->92,7;;15,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;92,7->94,0;;15,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;94,0->95,2;;15,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;95,2->96,4;;15,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;96,4->97,7;;15,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;97,7->99,0;;15,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;99,0->100,2;;15,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;100,2->101,4;;15,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;101,4->102,7;;15,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;102,7->103,9;;16,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;103,9->105,2;;16,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;105,2->106,4;;16,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;106,4->107,6;;16,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;107,6->108,8;;16,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;108,8->110,1;;16,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;110,1->111,3;;16,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;111,3->112,5;;16,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;112,5->113,8;;16,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;113,8->115,0;;16,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;115,0->116,2;;17,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;116,2->117,4;;17,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;117,4->118,7;;17,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;118,7->119,9;;17,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;119,9->121,1;;17,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;121,1->122,3;;17,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;122,3->123,5;;17,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;123,5->124,8;;17,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;124,8->126,0;;17,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;126,0->127,2;;17,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;127,2->128,4;;18,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;128,4->129,6;;18,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;129,6->130,8;;18,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;130,8->132,0;;18,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;132,0->133,2;;18,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;133,2->134,4;;18,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;134,4->135,6;;18,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;135,6->136,8;;18,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;136,8->138,0;;18,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;138,0->139,2;;18,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;139,2->140,4;;19,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;140,4->141,6;;19,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;141,6->142,8;;19,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;142,8->144,0;;19,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;144,0->145,1;;19,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;145,1->146,3;;19,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;146,3->147,5;;19,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;147,5->148,7;;19,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;148,7->149,9;;19,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;149,9->151,1;;19,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;151,1->152,3;;20,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;152,3->153,4;;20,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;153,4->154,6;;20,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;154,6->155,8;;20,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;155,8->157,0;;20,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;157,0->158,1;;20,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;158,1->159,3;;20,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;159,3->160,5;;20,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;160,5->161,6;;20,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;161,6->162,8;;20,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;162,8->164,0;;21,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;164,0->165,1;;21,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;165,1->166,3;;21,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;166,3->167,4;;21,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;167,4->168,6;;21,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;168,6->169,8;;21,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;169,8->170,9;;21,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;170,9->172,1;;21,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;172,1->173,2;;21,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;173,2->174,4;;21,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;174,4->175,5;;22,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;175,5->176,7;;22,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;176,7->177,8;;22,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;177,8->179,0;;22,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;179,0->180,1;;22,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;180,1->181,2;;22,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;181,2->182,4;;22,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;182,4->183,5;;22,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;183,5->184,7;;22,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;184,7->185,8;;22,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;185,8->186,9;;23,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;186,9->188,0;;23,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;188,0->189,2;;23,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;189,2->190,3;;23,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;190,3->191,4;;23,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;191,4->192,5;;23,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;192,5->193,6;;23,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;193,6->194,8;;23,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;194,8->195,9;;23,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;195,9->197,0;;23,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;197,0->198,1;;24,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;198,1->199,2;;24,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;199,2->200,3;;24,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;200,3->201,4;;24,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;201,4->202,5;;24,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;202,5->203,6;;24,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;203,6->204,7;;24,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;204,7->205,8;;24,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;205,8->206,9;;24,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;206,9->208,0;;24,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;208,0->209,1;;25,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;209,1->210,2;;25,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;210,2->211,2;;25,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;211,2->212,3;;25,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;212,3->213,4;;25,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;213,4->214,5;;25,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;214,5->215,6;;25,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;215,6->216,6;;25,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;216,6->217,7;;25,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;217,7->218,8;;25,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;218,8->219,9;;26,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;219,9->220,9;;26,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;220,9->222,0;;26,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;222,0->223,0;;26,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;223,0->224,1;;26,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;224,1->225,2;;26,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;225,2->226,2;;26,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;226,2->227,3;;26,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;227,3->228,3;;26,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;228,3->229,4;;26,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;229,4->230,4;;27,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;230,4->231,5;;27,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;231,5->232,5;;27,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;232,5->233,6;;27,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;233,6->234,6;;27,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;234,6->235,6;;27,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;235,6->236,7;;27,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;236,7->237,7;;27,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;237,7->238,8;;27,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;238,8->239,8;;27,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;239,8->240,8;;28,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;240,8->241,8;;28,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;241,8->242,8;;28,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;242,8->243,8;;28,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;243,8->244,9;;28,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;244,9->245,9;;28,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;245,9->246,9;;28,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;246,9->247,9;;28,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;247,9->248,9;;28,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;248,9->249,9;;28,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;249,9->250,9;;29,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;250,9->251,9;;29,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;251,9->252,9;;29,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;252,9->253,9;;29,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;253,9->254,9;;29,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;254,9->255,8;;29,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;255,8->256,8;;29,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;256,8->257,8;;29,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;257,8->258,8;;29,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;258,8->259,8;;29,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;259,8->260,8;;30,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;260,8->261,7;;30,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;261,7->262,7;;30,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;262,7->263,7;;30,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;263,7->264,6;;30,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;264,6->265,6;;30,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;265,6->266,6;;30,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;266,6->267,6;;30,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;267,6->268,5;;30,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;268,5->269,5;;30,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;269,5->270,4;;31,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;270,4->271,4;;31,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;271,4->272,4;;31,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;272,4->273,3;;31,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;273,3->274,2;;31,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;274,2->275,2;;31,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;275,2->276,2;;31,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;276,2->277,1;;31,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;277,1->278,0;;31,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;278,0->279,0;;31,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;279,0->279,9;;32,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;279,9->280,8;;32,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;280,8->281,7;;32,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;281,7->282,6;;32,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;282,6->283,6;;32,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;283,6->284,5;;32,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;284,5->285,4;;32,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;285,4->286,3;;32,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;286,3->287,2;;32,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;287,2->288,1;;32,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;288,1->289,0;;33,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;289,0->289,9;;33,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;289,9->290,8;;33,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;290,8->291,7;;33,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;291,7->292,6;;33,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;292,6->293,5;;33,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;293,5->294,4;;33,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;294,4->295,3;;33,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;295,3->296,2;;33,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;296,2->297,1;;33,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;297,1->298,0;;34,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;298,0->298,8;;34,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;298,8->299,7;;34,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;299,7->300,5;;34,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;300,5->301,4;;34,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;301,4->302,3;;34,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;302,3->303,1;;34,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;303,1->304,0;;34,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;304,0->304,8;;34,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;304,8->305,7;;34,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;305,7->306,5;;35,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;306,5->307,4;;35,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;307,4->308,2;;35,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;308,2->309,1;;35,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;309,1->309,9;;35,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;309,9->310,7;;35,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;310,7->311,6;;35,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;311,6->312,4;;35,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;312,4->313,3;;35,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;313,3->314,1;;35,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;314,1->314,9;;36,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;314,9->315,7;;36,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;315,7->316,5;;36,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;316,5->317,3;;36,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;317,3->318,1;;36,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;318,1->318,9;;36,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;318,9->319,7;;36,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;319,7->320,5;;36,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;320,5->321,3;;36,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;321,3->322,1;;36,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;322,1->322,9;;37,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;322,9->323,7;;37,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;323,7->324,4;;37,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;324,4->325,2;;37,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;325,2->326,0;;37,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;326,0->326,8;;37,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;326,8->327,6;;37,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;327,6->328,3;;37,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;328,3->329,1;;37,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;329,1->329,9;;37,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;329,9->330,6;;38,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;330,6->331,4;;38,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;331,4->332,2;;38,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;332,2->332,9;;38,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;332,9->333,6;;38,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;333,6->334,4;;38,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;334,4->335,2;;38,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;335,2->335,9;;38,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;335,9->336,6;;38,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;336,6->337,4;;38,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;337,4->338,1;;39,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;338,1->338,8;;39,10 semanas$$\n");
        sb.append("466;;cadastrarLogica;;338,8->339,5;;39,20 semanas$$\n");
        sb.append("466;;cadastrarLogica;;339,5->340,2;;39,30 semanas$$\n");
        sb.append("466;;cadastrarLogica;;340,2->341,0;;39,40 semanas$$\n");
        sb.append("466;;cadastrarLogica;;341,0->341,7;;39,50 semanas$$\n");
        sb.append("466;;cadastrarLogica;;341,7->342,4;;39,60 semanas$$\n");
        sb.append("466;;cadastrarLogica;;342,4->343,1;;39,70 semanas$$\n");
        sb.append("466;;cadastrarLogica;;343,1->343,8;;39,80 semanas$$\n");
        sb.append("466;;cadastrarLogica;;343,8->344,5;;39,90 semanas$$\n");
        sb.append("466;;cadastrarLogica;;344,5->346,1;;40,00 semanas$$\n");
        sb.append("466;;cadastrarLogica;;346,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.C.">

        sb.append("467;;cadastrarLogica;;0,0->53,2;;<11,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;53,2->54,6;;11,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;54,6->56,1;;11,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;56,1->57,5;;11,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;57,5->58,9;;11,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;58,9->60,4;;11,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;60,4->61,8;;11,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;61,8->63,2;;11,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;63,2->64,6;;11,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;64,6->66,1;;11,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;66,1->67,5;;11,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;67,5->68,9;;12,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;68,9->70,4;;12,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;70,4->71,8;;12,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;71,8->73,2;;12,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;73,2->74,6;;12,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;74,6->76,1;;12,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;76,1->77,5;;12,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;77,5->78,9;;12,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;78,9->80,4;;12,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;80,4->81,8;;12,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;81,8->83,2;;13,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;83,2->84,5;;13,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;84,5->85,9;;13,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;85,9->87,3;;13,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;87,3->88,6;;13,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;88,6->90,0;;13,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;90,0->91,4;;13,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;91,4->92,8;;13,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;92,8->94,1;;13,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;94,1->95,5;;13,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;95,5->96,9;;14,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;96,9->98,2;;14,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;98,2->99,6;;14,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;99,6->101,0;;14,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;101,0->102,4;;14,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;102,4->103,7;;14,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;103,7->105,1;;14,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;105,1->106,5;;14,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;106,5->107,8;;14,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;107,8->109,2;;14,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;109,2->110,6;;15,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;110,6->111,9;;15,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;111,9->113,2;;15,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;113,2->114,6;;15,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;114,6->116,0;;15,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;116,0->117,3;;15,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;117,3->118,6;;15,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;118,6->120,0;;15,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;120,0->121,4;;15,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;121,4->122,7;;15,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;122,7->124,0;;16,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;124,0->125,3;;16,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;125,3->126,6;;16,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;126,6->127,9;;16,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;127,9->129,2;;16,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;129,2->130,6;;16,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;130,6->131,9;;16,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;131,9->133,2;;16,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;133,2->134,5;;16,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;134,5->135,8;;16,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;135,8->137,1;;17,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;137,1->138,4;;17,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;138,4->139,7;;17,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;139,7->141,0;;17,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;141,0->142,2;;17,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;142,2->143,5;;17,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;143,5->144,8;;17,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;144,8->146,1;;17,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;146,1->147,4;;17,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;147,4->148,7;;17,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;148,7->150,0;;18,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;150,0->151,2;;18,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;151,2->152,5;;18,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;152,5->153,7;;18,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;153,7->155,0;;18,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;155,0->156,3;;18,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;156,3->157,5;;18,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;157,5->158,8;;18,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;158,8->160,0;;18,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;160,0->161,3;;18,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;161,3->162,5;;19,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;162,5->163,7;;19,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;163,7->165,0;;19,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;165,0->166,2;;19,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;166,2->167,4;;19,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;167,4->168,6;;19,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;168,6->169,8;;19,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;169,8->171,1;;19,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;171,1->172,3;;19,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;172,3->173,5;;19,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;173,5->174,7;;20,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;174,7->175,9;;20,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;175,9->177,1;;20,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;177,1->178,3;;20,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;178,3->179,5;;20,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;179,5->180,7;;20,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;180,7->181,9;;20,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;181,9->183,1;;20,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;183,1->184,3;;20,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;184,3->185,5;;20,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;185,5->186,6;;21,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;186,6->187,8;;21,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;187,8->189,0;;21,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;189,0->190,1;;21,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;190,1->191,2;;21,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;191,2->192,4;;21,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;192,4->193,6;;21,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;193,6->194,7;;21,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;194,7->195,8;;21,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;195,8->197,0;;21,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;197,0->198,1;;22,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;198,1->199,3;;22,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;199,3->200,4;;22,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;200,4->201,5;;22,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;201,5->202,6;;22,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;202,6->203,8;;22,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;203,8->204,9;;22,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;204,9->206,0;;22,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;206,0->207,2;;22,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;207,2->208,3;;22,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;208,3->209,4;;23,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;209,4->210,5;;23,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;210,5->211,5;;23,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;211,5->212,6;;23,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;212,6->213,7;;23,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;213,7->214,8;;23,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;214,8->215,9;;23,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;215,9->216,9;;23,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;216,9->218,0;;23,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;218,0->219,1;;23,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;219,1->220,1;;24,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;220,1->221,2;;24,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;221,2->222,2;;24,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;222,2->223,3;;24,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;223,3->224,3;;24,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;224,3->225,3;;24,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;225,3->226,4;;24,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;226,4->227,4;;24,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;227,4->228,5;;24,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;228,5->229,5;;24,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;229,5->230,5;;25,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;230,5->231,5;;25,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;231,5->232,5;;25,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;232,5->233,5;;25,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;233,5->234,5;;25,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;234,5->235,5;;25,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;235,5->236,5;;25,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;236,5->237,5;;25,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;237,5->238,5;;25,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;238,5->239,5;;25,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;239,5->240,5;;26,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;240,5->241,4;;26,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;241,4->242,4;;26,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;242,4->243,3;;26,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;243,3->244,3;;26,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;244,3->245,3;;26,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;245,3->246,2;;26,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;246,2->247,2;;26,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;247,2->248,1;;26,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;248,1->249,1;;26,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;249,1->250,0;;27,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;250,0->250,9;;27,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;250,9->251,9;;27,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;251,9->252,8;;27,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;252,8->253,7;;27,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;253,7->254,6;;27,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;254,6->255,5;;27,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;255,5->256,5;;27,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;256,5->257,4;;27,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;257,4->258,3;;27,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;258,3->259,2;;28,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;259,2->260,0;;28,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;260,0->260,9;;28,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;260,9->261,7;;28,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;261,7->262,6;;28,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;262,6->263,5;;28,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;263,5->264,3;;28,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;264,3->265,2;;28,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;265,2->266,0;;28,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;266,0->266,9;;28,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;266,9->267,7;;29,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;267,7->268,5;;29,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;268,5->269,4;;29,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;269,4->270,2;;29,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;270,2->271,0;;29,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;271,0->271,8;;29,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;271,8->272,6;;29,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;272,6->273,5;;29,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;273,5->274,3;;29,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;274,3->275,1;;29,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;275,1->275,9;;30,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;275,9->276,6;;30,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;276,6->277,4;;30,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;277,4->278,2;;30,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;278,2->279,0;;30,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;279,0->279,7;;30,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;279,7->280,5;;30,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;280,5->281,3;;30,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;281,3->282,0;;30,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;282,0->282,8;;30,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;282,8->283,5;;31,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;283,5->284,2;;31,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;284,2->284,9;;31,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;284,9->285,6;;31,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;285,6->286,4;;31,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;286,4->287,1;;31,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;287,1->287,8;;31,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;287,8->288,5;;31,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;288,5->289,2;;31,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;289,2->289,9;;31,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;289,9->290,6;;32,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;290,6->291,2;;32,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;291,2->291,9;;32,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;291,9->292,6;;32,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;292,6->293,2;;32,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;293,2->293,9;;32,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;293,9->294,6;;32,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;294,6->295,3;;32,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;295,3->295,9;;32,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;295,9->296,6;;32,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;296,6->297,2;;33,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;297,2->297,8;;33,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;297,8->298,4;;33,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;298,4->299,0;;33,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;299,0->299,6;;33,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;299,6->300,3;;33,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;300,3->300,9;;33,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;300,9->301,5;;33,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;301,5->302,1;;33,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;302,1->302,7;;33,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;302,7->303,2;;34,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;303,2->303,8;;34,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;303,8->304,3;;34,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;304,3->304,9;;34,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;304,9->305,4;;34,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;305,4->306,0;;34,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;306,0->306,6;;34,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;306,6->307,1;;34,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;307,1->307,6;;34,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;307,6->308,2;;34,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;308,2->308,7;;35,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;308,7->309,2;;35,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;309,2->309,7;;35,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;309,7->310,2;;35,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;310,2->310,6;;35,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;310,6->311,1;;35,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;311,1->311,6;;35,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;311,6->312,1;;35,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;312,1->312,6;;35,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;312,6->313,1;;35,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;313,1->313,5;;36,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;313,5->314,0;;36,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;314,0->314,4;;36,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;314,4->314,9;;36,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;314,9->315,3;;36,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;315,3->315,7;;36,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;315,7->316,2;;36,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;316,2->316,6;;36,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;316,6->317,1;;36,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;317,1->317,5;;36,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;317,5->317,9;;37,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;317,9->318,2;;37,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;318,2->318,6;;37,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;318,6->319,0;;37,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;319,0->319,4;;37,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;319,4->319,7;;37,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;319,7->320,1;;37,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;320,1->320,5;;37,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;320,5->320,8;;37,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;320,8->321,2;;37,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;321,2->321,5;;38,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;321,5->321,8;;38,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;321,8->322,1;;38,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;322,1->322,4;;38,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;322,4->322,8;;38,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;322,8->323,1;;38,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;323,1->323,4;;38,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;323,4->323,7;;38,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;323,7->324,0;;38,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;324,0->324,3;;38,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;324,3->324,5;;39,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;324,5->324,8;;39,10 semanas$$\n");
        sb.append("467;;cadastrarLogica;;324,8->325,0;;39,20 semanas$$\n");
        sb.append("467;;cadastrarLogica;;325,0->325,3;;39,30 semanas$$\n");
        sb.append("467;;cadastrarLogica;;325,3->325,5;;39,40 semanas$$\n");
        sb.append("467;;cadastrarLogica;;325,5->325,7;;39,50 semanas$$\n");
        sb.append("467;;cadastrarLogica;;325,7->326,0;;39,60 semanas$$\n");
        sb.append("467;;cadastrarLogica;;326,0->326,2;;39,70 semanas$$\n");
        sb.append("467;;cadastrarLogica;;326,2->326,5;;39,80 semanas$$\n");
        sb.append("467;;cadastrarLogica;;326,5->326,7;;39,90 semanas$$\n");
        sb.append("467;;cadastrarLogica;;326,7->328,1;;40,00 semanas$$\n");
        sb.append("467;;cadastrarLogica;;328,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("465;;cadastrarLogica;;0,0->15,7;;<11,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;15,7->16,0;;11,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;16,0->16,4;;11,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;16,4->16,7;;11,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;16,7->17,1;;11,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;17,1->17,4;;11,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;17,4->17,7;;11,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;17,7->18,1;;11,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;18,1->18,4;;11,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;18,4->18,8;;11,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;18,8->19,1;;11,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;19,1->19,4;;12,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;19,4->19,7;;12,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;19,7->20,1;;12,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;20,1->20,4;;12,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;20,4->20,7;;12,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;20,7->21,0;;12,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;21,0->21,3;;12,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;21,3->21,7;;12,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;21,7->22,0;;12,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;22,0->22,3;;12,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;22,3->22,8;;13,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;22,8->23,2;;13,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;23,2->23,7;;13,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;23,7->24,2;;13,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;24,2->24,6;;13,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;24,6->25,1;;13,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;25,1->25,6;;13,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;25,6->26,1;;13,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;26,1->26,5;;13,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;26,5->27,0;;13,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;27,0->27,4;;14,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;27,4->27,7;;14,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;27,7->28,1;;14,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;28,1->28,5;;14,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;28,5->28,8;;14,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;28,8->29,2;;14,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;29,2->29,6;;14,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;29,6->30,0;;14,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;30,0->30,3;;14,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;30,3->30,7;;14,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;30,7->31,1;;15,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;31,1->31,4;;15,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;31,4->31,8;;15,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;31,8->32,1;;15,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;32,1->32,5;;15,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;32,5->32,9;;15,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;32,9->33,2;;15,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;33,2->33,6;;15,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;33,6->33,9;;15,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;33,9->34,3;;15,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;34,3->34,7;;16,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;34,7->35,0;;16,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;35,0->35,4;;16,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;35,4->35,7;;16,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;35,7->36,1;;16,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;36,1->36,5;;16,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;36,5->36,8;;16,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;36,8->37,2;;16,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;37,2->37,5;;16,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;37,5->37,9;;16,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;37,9->38,2;;17,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;38,2->38,6;;17,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;38,6->38,9;;17,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;38,9->39,3;;17,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;39,3->39,6;;17,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;39,6->39,9;;17,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;39,9->40,3;;17,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;40,3->40,6;;17,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;40,6->41,0;;17,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;41,0->41,3;;17,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;41,3->41,6;;18,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;41,6->42,0;;18,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;42,0->42,3;;18,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;42,3->42,7;;18,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;42,7->43,0;;18,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;43,0->43,3;;18,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;43,3->43,7;;18,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;43,7->44,0;;18,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;44,0->44,4;;18,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;44,4->44,7;;18,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;44,7->45,0;;19,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;45,0->45,4;;19,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;45,4->45,7;;19,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;45,7->46,1;;19,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;46,1->46,4;;19,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;46,4->46,7;;19,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;46,7->47,1;;19,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;47,1->47,4;;19,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;47,4->47,8;;19,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;47,8->48,1;;19,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;48,1->48,4;;20,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;48,4->48,7;;20,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;48,7->49,1;;20,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;49,1->49,4;;20,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;49,4->49,7;;20,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;49,7->50,0;;20,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;50,0->50,3;;20,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;50,3->50,7;;20,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;50,7->51,0;;20,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;51,0->51,3;;20,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;51,3->51,6;;21,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;51,6->51,9;;21,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;51,9->52,3;;21,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;52,3->52,6;;21,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;52,6->52,9;;21,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;52,9->53,2;;21,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;53,2->53,5;;21,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;53,5->53,9;;21,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;53,9->54,2;;21,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;54,2->54,5;;21,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;54,5->54,8;;22,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;54,8->55,1;;22,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;55,1->55,4;;22,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;55,4->55,7;;22,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;55,7->56,0;;22,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;56,0->56,3;;22,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;56,3->56,6;;22,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;56,6->56,9;;22,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;56,9->57,2;;22,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;57,2->57,5;;22,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;57,5->57,8;;23,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;57,8->58,1;;23,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;58,1->58,4;;23,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;58,4->58,7;;23,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;58,7->59,0;;23,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;59,0->59,3;;23,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;59,3->59,6;;23,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;59,6->59,9;;23,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;59,9->60,2;;23,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;60,2->60,5;;23,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;60,5->60,8;;24,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;60,8->61,1;;24,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;61,1->61,4;;24,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;61,4->61,7;;24,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;61,7->62,0;;24,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;62,0->62,2;;24,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;62,2->62,5;;24,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;62,5->62,8;;24,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;62,8->63,1;;24,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;63,1->63,4;;24,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;63,4->63,7;;25,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;63,7->64,0;;25,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;64,0->64,2;;25,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;64,2->64,5;;25,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;64,5->64,8;;25,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;64,8->65,1;;25,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;65,1->65,4;;25,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;65,4->65,6;;25,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;65,6->65,9;;25,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;65,9->66,2;;25,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;66,2->66,5;;26,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;66,5->66,7;;26,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;66,7->67,0;;26,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;67,0->67,3;;26,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;67,3->67,6;;26,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;67,6->67,8;;26,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;67,8->68,1;;26,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;68,1->68,4;;26,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;68,4->68,6;;26,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;68,6->68,9;;26,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;68,9->69,2;;27,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;69,2->69,4;;27,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;69,4->69,6;;27,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;69,6->69,9;;27,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;69,9->70,2;;27,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;70,2->70,4;;27,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;70,4->70,6;;27,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;70,6->70,9;;27,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;70,9->71,2;;27,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;71,2->71,4;;27,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;71,4->71,6;;28,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;71,6->71,9;;28,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;71,9->72,2;;28,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;72,2->72,4;;28,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;72,4->72,6;;28,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;72,6->72,9;;28,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;72,9->73,2;;28,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;73,2->73,4;;28,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;73,4->73,6;;28,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;73,6->73,9;;28,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;73,9->74,1;;29,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;74,1->74,4;;29,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;74,4->74,6;;29,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;74,6->74,8;;29,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;74,8->75,1;;29,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;75,1->75,3;;29,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;75,3->75,5;;29,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;75,5->75,7;;29,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;75,7->76,0;;29,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;76,0->76,2;;29,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;76,2->76,4;;30,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;76,4->76,7;;30,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;76,7->76,9;;30,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;76,9->77,1;;30,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;77,1->77,4;;30,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;77,4->77,6;;30,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;77,6->77,8;;30,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;77,8->78,0;;30,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;78,0->78,3;;30,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;78,3->78,5;;30,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;78,5->78,7;;31,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;78,7->78,9;;31,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;78,9->79,1;;31,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;79,1->79,3;;31,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;79,3->79,6;;31,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;79,6->79,8;;31,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;79,8->80,0;;31,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;80,0->80,2;;31,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;80,2->80,4;;31,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;80,4->80,6;;31,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;80,6->80,8;;32,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;80,8->81,0;;32,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;81,0->81,2;;32,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;81,2->81,4;;32,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;81,4->81,6;;32,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;81,6->81,7;;32,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;81,7->81,9;;32,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;81,9->82,1;;32,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;82,1->82,3;;32,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;82,3->82,5;;32,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;82,5->82,7;;33,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;82,7->82,9;;33,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;82,9->83,1;;33,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;83,1->83,3;;33,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;83,3->83,4;;33,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;83,4->83,6;;33,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;83,6->83,8;;33,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;83,8->84,0;;33,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;84,0->84,2;;33,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;84,2->84,4;;33,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;84,4->84,6;;34,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;84,6->84,7;;34,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;84,7->84,9;;34,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;84,9->85,1;;34,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;85,1->85,2;;34,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;85,2->85,4;;34,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;85,4->85,6;;34,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;85,6->85,8;;34,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;85,8->85,9;;34,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;85,9->86,1;;34,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;86,1->86,2;;35,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;86,2->86,4;;35,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;86,4->86,6;;35,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;86,6->86,7;;35,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;86,7->86,8;;35,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;86,8->87,0;;35,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;87,0->87,1;;35,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;87,1->87,3;;35,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;87,3->87,4;;35,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;87,4->87,6;;35,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;87,6->87,8;;36,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;87,8->87,9;;36,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;87,9->88,0;;36,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;88,0->88,2;;36,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;88,2->88,4;;36,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;88,4->88,5;;36,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;88,5->88,6;;36,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;88,6->88,8;;36,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;88,8->88,9;;36,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;88,9->89,1;;36,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;89,1->89,2;;37,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;89,2->89,3;;37,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;89,3->89,5;;37,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;89,5->89,6;;37,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;89,6->89,7;;37,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;89,7->89,8;;37,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;89,8->89,9;;37,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;89,9->90,1;;37,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;90,1->90,2;;37,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;90,2->90,3;;37,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;90,3->90,4;;38,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;90,4->90,5;;38,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;90,5->90,6;;38,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;90,6->90,7;;38,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;90,7->90,8;;38,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;90,8->91,0;;38,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;91,0->91,1;;38,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;91,1->91,2;;38,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;91,2->91,3;;38,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;91,3->91,4;;38,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;91,4->91,5;;39,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;91,5->91,6;;39,10 semanas$$\n");
        sb.append("465;;cadastrarLogica;;91,6->91,7;;39,20 semanas$$\n");
        sb.append("465;;cadastrarLogica;;91,7->91,8;;39,30 semanas$$\n");
        sb.append("465;;cadastrarLogica;;91,8->91,9;;39,40 semanas$$\n");
        sb.append("465;;cadastrarLogica;;91,9->92,0;;39,50 semanas$$\n");
        sb.append("465;;cadastrarLogica;;92,0->92,1;;39,60 semanas$$\n");
        sb.append("465;;cadastrarLogica;;92,1->92,2;;39,70 semanas$$\n");
        sb.append("465;;cadastrarLogica;;92,2->92,3;;39,80 semanas$$\n");
        sb.append("465;;cadastrarLogica;;92,3->92,4;;39,90 semanas$$\n");
        sb.append("465;;cadastrarLogica;;92,4->93,1;;40,00 semanas$$\n");
        sb.append("465;;cadastrarLogica;;93,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

    }

    private static void preencherIghFeto6 ()
    {

        // <editor-fold defaultstate="collapsed" desc="Fêmur">

        sb.append("468;;cadastrarLogica;;0,0->7,1;;<12,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;7,1->8,1;;12,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;8,1->9,1;;12,33 semanas$$\n");
        sb.append("468;;cadastrarLogica;;9,1->10,1;;12,67 semanas$$\n");
        sb.append("468;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("468;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("468;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("468;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("468;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("468;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("468;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;20,1->21,1;;16,33 semanas$$\n");
        sb.append("468;;cadastrarLogica;;21,1->22,1;;16,67 semanas$$\n");
        sb.append("468;;cadastrarLogica;;22,1->23,1;;17,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;23,1->24,1;;17,50 semanas$$\n");
        sb.append("468;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("468;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("468;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;28,1->29,1;;19,33 semanas$$\n");
        sb.append("468;;cadastrarLogica;;29,1->30,1;;19,67 semanas$$\n");
        sb.append("468;;cadastrarLogica;;30,1->31,1;;20,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;31,1->32,1;;20,33 semanas$$\n");
        sb.append("468;;cadastrarLogica;;32,1->33,1;;20,67 semanas$$\n");
        sb.append("468;;cadastrarLogica;;33,1->34,1;;21,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;34,1->35,1;;21,50 semanas$$\n");
        sb.append("468;;cadastrarLogica;;35,1->36,1;;22,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;36,1->37,1;;22,33 semanas$$\n");
        sb.append("468;;cadastrarLogica;;37,1->38,1;;22,67 semanas$$\n");
        sb.append("468;;cadastrarLogica;;38,1->39,1;;23,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;39,1->40,1;;23,33 semanas$$\n");
        sb.append("468;;cadastrarLogica;;40,1->41,1;;23,67 semanas$$\n");
        sb.append("468;;cadastrarLogica;;41,1->42,1;;24,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;42,1->43,1;;24,50 semanas$$\n");
        sb.append("468;;cadastrarLogica;;43,1->44,1;;25,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;44,1->45,1;;25,33 semanas$$\n");
        sb.append("468;;cadastrarLogica;;45,1->46,1;;25,67 semanas$$\n");
        sb.append("468;;cadastrarLogica;;46,1->47,1;;26,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;47,1->48,1;;26,50 semanas$$\n");
        sb.append("468;;cadastrarLogica;;48,1->49,1;;27,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;49,1->50,1;;27,33 semanas$$\n");
        sb.append("468;;cadastrarLogica;;50,1->51,1;;27,67 semanas$$\n");
        sb.append("468;;cadastrarLogica;;51,1->52,1;;28,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;52,1->53,1;;28,50 semanas$$\n");
        sb.append("468;;cadastrarLogica;;53,1->54,1;;29,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;54,1->55,1;;29,50 semanas$$\n");
        sb.append("468;;cadastrarLogica;;55,1->56,1;;30,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;56,1->57,1;;30,33 semanas$$\n");
        sb.append("468;;cadastrarLogica;;57,1->58,1;;30,67 semanas$$\n");
        sb.append("468;;cadastrarLogica;;58,1->59,1;;31,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;59,1->60,1;;31,50 semanas$$\n");
        sb.append("468;;cadastrarLogica;;60,1->61,1;;32,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;61,1->62,1;;32,50 semanas$$\n");
        sb.append("468;;cadastrarLogica;;62,1->63,1;;33,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;63,1->64,1;;33,50 semanas$$\n");
        sb.append("468;;cadastrarLogica;;64,1->65,1;;34,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;65,1->66,1;;34,50 semanas$$\n");
        sb.append("468;;cadastrarLogica;;66,1->67,1;;35,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;67,1->68,1;;36,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;68,1->69,1;;36,50 semanas$$\n");
        sb.append("468;;cadastrarLogica;;69,1->70,1;;37,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;70,1->71,1;;38,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;71,1->72,1;;38,50 semanas$$\n");
        sb.append("468;;cadastrarLogica;;72,1->73,1;;39,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;73,1->74,1;;40,00 semanas$$\n");
        sb.append("468;;cadastrarLogica;;74,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Úmero">

        sb.append("469;;cadastrarLogica;;0,0->8,1;;<12,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;8,1->9,1;;12,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;9,1->10,1;;12,50 semanas$$\n");
        sb.append("469;;cadastrarLogica;;10,1->11,1;;13,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;11,1->12,1;;13,33 semanas$$\n");
        sb.append("469;;cadastrarLogica;;12,1->13,1;;13,67 semanas$$\n");
        sb.append("469;;cadastrarLogica;;13,1->14,1;;14,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;14,1->15,1;;14,33 semanas$$\n");
        sb.append("469;;cadastrarLogica;;15,1->16,1;;14,67 semanas$$\n");
        sb.append("469;;cadastrarLogica;;16,1->17,1;;15,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;17,1->18,1;;15,33 semanas$$\n");
        sb.append("469;;cadastrarLogica;;18,1->19,1;;15,67 semanas$$\n");
        sb.append("469;;cadastrarLogica;;19,1->20,1;;16,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;20,1->21,1;;16,50 semanas$$\n");
        sb.append("469;;cadastrarLogica;;21,1->22,1;;17,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;22,1->23,1;;17,33 semanas$$\n");
        sb.append("469;;cadastrarLogica;;23,1->24,1;;17,67 semanas$$\n");
        sb.append("469;;cadastrarLogica;;24,1->25,1;;18,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;25,1->26,1;;18,33 semanas$$\n");
        sb.append("469;;cadastrarLogica;;26,1->27,1;;18,67 semanas$$\n");
        sb.append("469;;cadastrarLogica;;27,1->28,1;;19,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;28,1->29,1;;19,50 semanas$$\n");
        sb.append("469;;cadastrarLogica;;29,1->30,1;;20,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;30,1->31,1;;20,33 semanas$$\n");
        sb.append("469;;cadastrarLogica;;31,1->32,1;;20,67 semanas$$\n");
        sb.append("469;;cadastrarLogica;;32,1->33,1;;21,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;33,1->34,1;;21,50 semanas$$\n");
        sb.append("469;;cadastrarLogica;;34,1->35,1;;22,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;35,1->36,1;;22,33 semanas$$\n");
        sb.append("469;;cadastrarLogica;;36,1->37,1;;22,67 semanas$$\n");
        sb.append("469;;cadastrarLogica;;37,1->38,1;;23,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;38,1->39,1;;23,50 semanas$$\n");
        sb.append("469;;cadastrarLogica;;39,1->40,1;;24,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;40,1->41,1;;24,50 semanas$$\n");
        sb.append("469;;cadastrarLogica;;41,1->42,1;;25,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;42,1->43,1;;25,50 semanas$$\n");
        sb.append("469;;cadastrarLogica;;43,1->44,1;;26,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;44,1->45,1;;26,50 semanas$$\n");
        sb.append("469;;cadastrarLogica;;45,1->46,1;;27,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;46,1->47,1;;27,50 semanas$$\n");
        sb.append("469;;cadastrarLogica;;47,1->48,1;;28,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;48,1->49,1;;28,50 semanas$$\n");
        sb.append("469;;cadastrarLogica;;49,1->50,1;;29,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;50,1->51,1;;30,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;51,1->52,1;;30,50 semanas$$\n");
        sb.append("469;;cadastrarLogica;;52,1->53,1;;31,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;53,1->54,1;;31,50 semanas$$\n");
        sb.append("469;;cadastrarLogica;;54,1->55,1;;32,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;55,1->56,1;;33,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;56,1->57,1;;33,50 semanas$$\n");
        sb.append("469;;cadastrarLogica;;57,1->58,1;;34,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;58,1->59,1;;35,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;59,1->60,1;;35,50 semanas$$\n");
        sb.append("469;;cadastrarLogica;;60,1->61,1;;36,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;61,1->62,1;;37,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;63,1->64,1;;38,50 semanas$$\n");
        sb.append("469;;cadastrarLogica;;64,1->65,1;;39,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("469;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ulna">

        sb.append("470;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("470;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("470;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;10,1->11,1;;13,33 semanas$$\n");
        sb.append("470;;cadastrarLogica;;11,1->12,1;;13,67 semanas$$\n");
        sb.append("470;;cadastrarLogica;;12,1->13,1;;14,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;13,1->14,1;;14,50 semanas$$\n");
        sb.append("470;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;15,1->16,1;;15,33 semanas$$\n");
        sb.append("470;;cadastrarLogica;;16,1->17,1;;15,67 semanas$$\n");
        sb.append("470;;cadastrarLogica;;17,1->18,1;;16,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;18,1->19,1;;16,33 semanas$$\n");
        sb.append("470;;cadastrarLogica;;19,1->20,1;;16,67 semanas$$\n");
        sb.append("470;;cadastrarLogica;;20,1->21,1;;17,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;21,1->22,1;;17,50 semanas$$\n");
        sb.append("470;;cadastrarLogica;;22,1->23,1;;18,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;23,1->24,1;;18,33 semanas$$\n");
        sb.append("470;;cadastrarLogica;;24,1->25,1;;18,67 semanas$$\n");
        sb.append("470;;cadastrarLogica;;25,1->26,1;;19,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;26,1->27,1;;19,50 semanas$$\n");
        sb.append("470;;cadastrarLogica;;27,1->28,1;;20,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;28,1->29,1;;20,33 semanas$$\n");
        sb.append("470;;cadastrarLogica;;29,1->30,1;;20,67 semanas$$\n");
        sb.append("470;;cadastrarLogica;;30,1->31,1;;21,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;31,1->32,1;;21,50 semanas$$\n");
        sb.append("470;;cadastrarLogica;;32,1->33,1;;22,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;33,1->34,1;;22,50 semanas$$\n");
        sb.append("470;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("470;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;37,1->38,1;;24,50 semanas$$\n");
        sb.append("470;;cadastrarLogica;;38,1->39,1;;25,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;39,1->40,1;;25,50 semanas$$\n");
        sb.append("470;;cadastrarLogica;;40,1->41,1;;26,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;41,1->42,1;;26,50 semanas$$\n");
        sb.append("470;;cadastrarLogica;;42,1->43,1;;27,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;43,1->44,1;;27,50 semanas$$\n");
        sb.append("470;;cadastrarLogica;;44,1->45,1;;28,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;45,1->46,1;;28,50 semanas$$\n");
        sb.append("470;;cadastrarLogica;;46,1->47,1;;29,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;47,1->48,1;;30,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;48,1->49,1;;30,50 semanas$$\n");
        sb.append("470;;cadastrarLogica;;49,1->50,1;;31,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;50,1->51,1;;31,50 semanas$$\n");
        sb.append("470;;cadastrarLogica;;51,1->52,1;;32,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;52,1->53,1;;33,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;53,1->54,1;;33,50 semanas$$\n");
        sb.append("470;;cadastrarLogica;;54,1->55,1;;34,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;55,1->56,1;;35,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;56,1->57,1;;36,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;57,1->58,1;;37,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;58,1->59,1;;38,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;59,1->60,1;;39,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;60,1->61,1;;40,00 semanas$$\n");
        sb.append("470;;cadastrarLogica;;61,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tíbia">

        sb.append("471;;cadastrarLogica;;0,0->6,1;;<12,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;6,1->7,1;;12,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;7,1->8,1;;12,33 semanas$$\n");
        sb.append("471;;cadastrarLogica;;8,1->9,1;;12,67 semanas$$\n");
        sb.append("471;;cadastrarLogica;;9,1->10,1;;13,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;10,1->11,1;;13,50 semanas$$\n");
        sb.append("471;;cadastrarLogica;;11,1->12,1;;14,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;12,1->13,1;;14,33 semanas$$\n");
        sb.append("471;;cadastrarLogica;;13,1->14,1;;14,67 semanas$$\n");
        sb.append("471;;cadastrarLogica;;14,1->15,1;;15,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;15,1->16,1;;15,50 semanas$$\n");
        sb.append("471;;cadastrarLogica;;16,1->17,1;;16,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;17,1->18,1;;16,33 semanas$$\n");
        sb.append("471;;cadastrarLogica;;18,1->19,1;;16,67 semanas$$\n");
        sb.append("471;;cadastrarLogica;;19,1->20,1;;17,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;20,1->21,1;;17,50 semanas$$\n");
        sb.append("471;;cadastrarLogica;;21,1->22,1;;18,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;22,1->23,1;;18,33 semanas$$\n");
        sb.append("471;;cadastrarLogica;;23,1->24,1;;18,67 semanas$$\n");
        sb.append("471;;cadastrarLogica;;24,1->25,1;;19,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;25,1->26,1;;19,50 semanas$$\n");
        sb.append("471;;cadastrarLogica;;26,1->27,1;;20,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;27,1->28,1;;20,33 semanas$$\n");
        sb.append("471;;cadastrarLogica;;28,1->29,1;;20,67 semanas$$\n");
        sb.append("471;;cadastrarLogica;;29,1->30,1;;21,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;30,1->31,1;;21,50 semanas$$\n");
        sb.append("471;;cadastrarLogica;;31,1->32,1;;22,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;32,1->33,1;;22,33 semanas$$\n");
        sb.append("471;;cadastrarLogica;;33,1->34,1;;22,67 semanas$$\n");
        sb.append("471;;cadastrarLogica;;34,1->35,1;;23,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;35,1->36,1;;23,50 semanas$$\n");
        sb.append("471;;cadastrarLogica;;36,1->37,1;;24,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;37,1->38,1;;24,33 semanas$$\n");
        sb.append("471;;cadastrarLogica;;38,1->39,1;;24,67 semanas$$\n");
        sb.append("471;;cadastrarLogica;;39,1->40,1;;25,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;40,1->41,1;;25,50 semanas$$\n");
        sb.append("471;;cadastrarLogica;;41,1->42,1;;26,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;42,1->43,1;;26,50 semanas$$\n");
        sb.append("471;;cadastrarLogica;;43,1->44,1;;27,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;44,1->45,1;;27,50 semanas$$\n");
        sb.append("471;;cadastrarLogica;;45,1->46,1;;28,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;46,1->47,1;;28,50 semanas$$\n");
        sb.append("471;;cadastrarLogica;;47,1->48,1;;29,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;48,1->49,1;;29,50 semanas$$\n");
        sb.append("471;;cadastrarLogica;;49,1->50,1;;30,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;50,1->51,1;;30,50 semanas$$\n");
        sb.append("471;;cadastrarLogica;;51,1->52,1;;31,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;52,1->53,1;;31,50 semanas$$\n");
        sb.append("471;;cadastrarLogica;;53,1->54,1;;32,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;54,1->55,1;;33,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;55,1->56,1;;33,50 semanas$$\n");
        sb.append("471;;cadastrarLogica;;56,1->57,1;;34,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;57,1->58,1;;35,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;58,1->59,1;;35,50 semanas$$\n");
        sb.append("471;;cadastrarLogica;;59,1->60,1;;36,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;60,1->61,1;;37,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;61,1->62,1;;37,50 semanas$$\n");
        sb.append("471;;cadastrarLogica;;62,1->63,1;;38,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;63,1->64,1;;39,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;64,1->65,1;;39,50 semanas$$\n");
        sb.append("471;;cadastrarLogica;;65,1->66,1;;40,00 semanas$$\n");
        sb.append("471;;cadastrarLogica;;66,1->999,9;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.A.">

        sb.append("473;;cadastrarLogica;;0,0->39,3;;<11,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;39,3->40,6;;11,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;40,6->41,9;;11,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;41,9->43,2;;11,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;43,2->44,5;;11,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;44,5->45,8;;11,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;45,8->47,0;;11,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;47,0->48,3;;11,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;48,3->49,6;;11,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;49,6->50,9;;11,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;50,9->52,2;;11,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;52,2->53,5;;12,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;53,5->54,8;;12,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;54,8->56,0;;12,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;56,0->57,3;;12,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;57,3->58,6;;12,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;58,6->59,9;;12,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;59,9->61,2;;12,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;61,2->62,4;;12,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;62,4->63,7;;12,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;63,7->65,0;;12,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;65,0->66,3;;13,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;66,3->67,5;;13,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;67,5->68,8;;13,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;68,8->70,1;;13,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;70,1->71,4;;13,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;71,4->72,6;;13,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;72,6->73,9;;13,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;73,9->75,2;;13,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;75,2->76,4;;13,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;76,4->77,7;;13,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;77,7->79,0;;14,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;79,0->80,2;;14,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;80,2->81,4;;14,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;81,4->82,7;;14,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;82,7->84,0;;14,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;84,0->85,2;;14,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;85,2->86,4;;14,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;86,4->87,7;;14,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;87,7->89,0;;14,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;89,0->90,2;;14,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;90,2->91,4;;15,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;91,4->92,7;;15,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;92,7->94,0;;15,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;94,0->95,2;;15,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;95,2->96,4;;15,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;96,4->97,7;;15,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;97,7->99,0;;15,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;99,0->100,2;;15,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;100,2->101,4;;15,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;101,4->102,7;;15,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;102,7->103,9;;16,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;103,9->105,2;;16,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;105,2->106,4;;16,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;106,4->107,6;;16,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;107,6->108,8;;16,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;108,8->110,1;;16,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;110,1->111,3;;16,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;111,3->112,5;;16,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;112,5->113,8;;16,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;113,8->115,0;;16,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;115,0->116,2;;17,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;116,2->117,4;;17,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;117,4->118,7;;17,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;118,7->119,9;;17,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;119,9->121,1;;17,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;121,1->122,3;;17,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;122,3->123,5;;17,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;123,5->124,8;;17,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;124,8->126,0;;17,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;126,0->127,2;;17,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;127,2->128,4;;18,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;128,4->129,6;;18,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;129,6->130,8;;18,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;130,8->132,0;;18,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;132,0->133,2;;18,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;133,2->134,4;;18,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;134,4->135,6;;18,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;135,6->136,8;;18,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;136,8->138,0;;18,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;138,0->139,2;;18,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;139,2->140,4;;19,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;140,4->141,6;;19,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;141,6->142,8;;19,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;142,8->144,0;;19,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;144,0->145,1;;19,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;145,1->146,3;;19,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;146,3->147,5;;19,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;147,5->148,7;;19,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;148,7->149,9;;19,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;149,9->151,1;;19,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;151,1->152,3;;20,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;152,3->153,4;;20,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;153,4->154,6;;20,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;154,6->155,8;;20,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;155,8->157,0;;20,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;157,0->158,1;;20,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;158,1->159,3;;20,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;159,3->160,5;;20,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;160,5->161,6;;20,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;161,6->162,8;;20,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;162,8->164,0;;21,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;164,0->165,1;;21,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;165,1->166,3;;21,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;166,3->167,4;;21,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;167,4->168,6;;21,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;168,6->169,8;;21,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;169,8->170,9;;21,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;170,9->172,1;;21,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;172,1->173,2;;21,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;173,2->174,4;;21,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;174,4->175,5;;22,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;175,5->176,7;;22,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;176,7->177,8;;22,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;177,8->179,0;;22,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;179,0->180,1;;22,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;180,1->181,2;;22,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;181,2->182,4;;22,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;182,4->183,5;;22,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;183,5->184,7;;22,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;184,7->185,8;;22,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;185,8->186,9;;23,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;186,9->188,0;;23,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;188,0->189,2;;23,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;189,2->190,3;;23,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;190,3->191,4;;23,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;191,4->192,5;;23,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;192,5->193,6;;23,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;193,6->194,8;;23,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;194,8->195,9;;23,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;195,9->197,0;;23,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;197,0->198,1;;24,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;198,1->199,2;;24,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;199,2->200,3;;24,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;200,3->201,4;;24,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;201,4->202,5;;24,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;202,5->203,6;;24,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;203,6->204,7;;24,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;204,7->205,8;;24,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;205,8->206,9;;24,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;206,9->208,0;;24,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;208,0->209,1;;25,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;209,1->210,2;;25,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;210,2->211,2;;25,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;211,2->212,3;;25,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;212,3->213,4;;25,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;213,4->214,5;;25,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;214,5->215,6;;25,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;215,6->216,6;;25,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;216,6->217,7;;25,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;217,7->218,8;;25,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;218,8->219,9;;26,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;219,9->220,9;;26,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;220,9->222,0;;26,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;222,0->223,0;;26,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;223,0->224,1;;26,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;224,1->225,2;;26,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;225,2->226,2;;26,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;226,2->227,3;;26,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;227,3->228,3;;26,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;228,3->229,4;;26,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;229,4->230,4;;27,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;230,4->231,5;;27,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;231,5->232,5;;27,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;232,5->233,6;;27,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;233,6->234,6;;27,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;234,6->235,6;;27,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;235,6->236,7;;27,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;236,7->237,7;;27,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;237,7->238,8;;27,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;238,8->239,8;;27,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;239,8->240,8;;28,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;240,8->241,8;;28,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;241,8->242,8;;28,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;242,8->243,8;;28,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;243,8->244,9;;28,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;244,9->245,9;;28,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;245,9->246,9;;28,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;246,9->247,9;;28,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;247,9->248,9;;28,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;248,9->249,9;;28,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;249,9->250,9;;29,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;250,9->251,9;;29,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;251,9->252,9;;29,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;252,9->253,9;;29,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;253,9->254,9;;29,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;254,9->255,8;;29,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;255,8->256,8;;29,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;256,8->257,8;;29,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;257,8->258,8;;29,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;258,8->259,8;;29,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;259,8->260,8;;30,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;260,8->261,7;;30,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;261,7->262,7;;30,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;262,7->263,7;;30,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;263,7->264,6;;30,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;264,6->265,6;;30,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;265,6->266,6;;30,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;266,6->267,6;;30,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;267,6->268,5;;30,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;268,5->269,5;;30,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;269,5->270,4;;31,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;270,4->271,4;;31,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;271,4->272,4;;31,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;272,4->273,3;;31,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;273,3->274,2;;31,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;274,2->275,2;;31,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;275,2->276,2;;31,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;276,2->277,1;;31,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;277,1->278,0;;31,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;278,0->279,0;;31,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;279,0->279,9;;32,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;279,9->280,8;;32,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;280,8->281,7;;32,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;281,7->282,6;;32,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;282,6->283,6;;32,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;283,6->284,5;;32,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;284,5->285,4;;32,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;285,4->286,3;;32,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;286,3->287,2;;32,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;287,2->288,1;;32,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;288,1->289,0;;33,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;289,0->289,9;;33,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;289,9->290,8;;33,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;290,8->291,7;;33,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;291,7->292,6;;33,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;292,6->293,5;;33,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;293,5->294,4;;33,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;294,4->295,3;;33,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;295,3->296,2;;33,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;296,2->297,1;;33,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;297,1->298,0;;34,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;298,0->298,8;;34,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;298,8->299,7;;34,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;299,7->300,5;;34,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;300,5->301,4;;34,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;301,4->302,3;;34,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;302,3->303,1;;34,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;303,1->304,0;;34,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;304,0->304,8;;34,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;304,8->305,7;;34,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;305,7->306,5;;35,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;306,5->307,4;;35,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;307,4->308,2;;35,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;308,2->309,1;;35,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;309,1->309,9;;35,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;309,9->310,7;;35,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;310,7->311,6;;35,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;311,6->312,4;;35,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;312,4->313,3;;35,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;313,3->314,1;;35,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;314,1->314,9;;36,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;314,9->315,7;;36,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;315,7->316,5;;36,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;316,5->317,3;;36,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;317,3->318,1;;36,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;318,1->318,9;;36,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;318,9->319,7;;36,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;319,7->320,5;;36,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;320,5->321,3;;36,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;321,3->322,1;;36,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;322,1->322,9;;37,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;322,9->323,7;;37,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;323,7->324,4;;37,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;324,4->325,2;;37,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;325,2->326,0;;37,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;326,0->326,8;;37,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;326,8->327,6;;37,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;327,6->328,3;;37,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;328,3->329,1;;37,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;329,1->329,9;;37,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;329,9->330,6;;38,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;330,6->331,4;;38,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;331,4->332,2;;38,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;332,2->332,9;;38,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;332,9->333,6;;38,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;333,6->334,4;;38,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;334,4->335,2;;38,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;335,2->335,9;;38,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;335,9->336,6;;38,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;336,6->337,4;;38,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;337,4->338,1;;39,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;338,1->338,8;;39,10 semanas$$\n");
        sb.append("473;;cadastrarLogica;;338,8->339,5;;39,20 semanas$$\n");
        sb.append("473;;cadastrarLogica;;339,5->340,2;;39,30 semanas$$\n");
        sb.append("473;;cadastrarLogica;;340,2->341,0;;39,40 semanas$$\n");
        sb.append("473;;cadastrarLogica;;341,0->341,7;;39,50 semanas$$\n");
        sb.append("473;;cadastrarLogica;;341,7->342,4;;39,60 semanas$$\n");
        sb.append("473;;cadastrarLogica;;342,4->343,1;;39,70 semanas$$\n");
        sb.append("473;;cadastrarLogica;;343,1->343,8;;39,80 semanas$$\n");
        sb.append("473;;cadastrarLogica;;343,8->344,5;;39,90 semanas$$\n");
        sb.append("473;;cadastrarLogica;;344,5->346,1;;40,00 semanas$$\n");
        sb.append("473;;cadastrarLogica;;346,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="C.C.">

        sb.append("474;;cadastrarLogica;;0,0->53,2;;<11,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;53,2->54,6;;11,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;54,6->56,1;;11,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;56,1->57,5;;11,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;57,5->58,9;;11,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;58,9->60,4;;11,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;60,4->61,8;;11,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;61,8->63,2;;11,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;63,2->64,6;;11,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;64,6->66,1;;11,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;66,1->67,5;;11,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;67,5->68,9;;12,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;68,9->70,4;;12,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;70,4->71,8;;12,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;71,8->73,2;;12,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;73,2->74,6;;12,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;74,6->76,1;;12,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;76,1->77,5;;12,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;77,5->78,9;;12,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;78,9->80,4;;12,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;80,4->81,8;;12,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;81,8->83,2;;13,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;83,2->84,5;;13,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;84,5->85,9;;13,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;85,9->87,3;;13,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;87,3->88,6;;13,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;88,6->90,0;;13,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;90,0->91,4;;13,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;91,4->92,8;;13,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;92,8->94,1;;13,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;94,1->95,5;;13,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;95,5->96,9;;14,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;96,9->98,2;;14,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;98,2->99,6;;14,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;99,6->101,0;;14,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;101,0->102,4;;14,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;102,4->103,7;;14,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;103,7->105,1;;14,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;105,1->106,5;;14,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;106,5->107,8;;14,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;107,8->109,2;;14,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;109,2->110,6;;15,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;110,6->111,9;;15,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;111,9->113,2;;15,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;113,2->114,6;;15,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;114,6->116,0;;15,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;116,0->117,3;;15,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;117,3->118,6;;15,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;118,6->120,0;;15,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;120,0->121,4;;15,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;121,4->122,7;;15,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;122,7->124,0;;16,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;124,0->125,3;;16,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;125,3->126,6;;16,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;126,6->127,9;;16,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;127,9->129,2;;16,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;129,2->130,6;;16,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;130,6->131,9;;16,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;131,9->133,2;;16,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;133,2->134,5;;16,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;134,5->135,8;;16,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;135,8->137,1;;17,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;137,1->138,4;;17,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;138,4->139,7;;17,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;139,7->141,0;;17,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;141,0->142,2;;17,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;142,2->143,5;;17,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;143,5->144,8;;17,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;144,8->146,1;;17,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;146,1->147,4;;17,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;147,4->148,7;;17,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;148,7->150,0;;18,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;150,0->151,2;;18,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;151,2->152,5;;18,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;152,5->153,7;;18,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;153,7->155,0;;18,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;155,0->156,3;;18,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;156,3->157,5;;18,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;157,5->158,8;;18,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;158,8->160,0;;18,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;160,0->161,3;;18,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;161,3->162,5;;19,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;162,5->163,7;;19,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;163,7->165,0;;19,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;165,0->166,2;;19,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;166,2->167,4;;19,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;167,4->168,6;;19,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;168,6->169,8;;19,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;169,8->171,1;;19,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;171,1->172,3;;19,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;172,3->173,5;;19,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;173,5->174,7;;20,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;174,7->175,9;;20,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;175,9->177,1;;20,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;177,1->178,3;;20,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;178,3->179,5;;20,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;179,5->180,7;;20,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;180,7->181,9;;20,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;181,9->183,1;;20,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;183,1->184,3;;20,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;184,3->185,5;;20,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;185,5->186,6;;21,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;186,6->187,8;;21,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;187,8->189,0;;21,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;189,0->190,1;;21,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;190,1->191,2;;21,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;191,2->192,4;;21,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;192,4->193,6;;21,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;193,6->194,7;;21,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;194,7->195,8;;21,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;195,8->197,0;;21,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;197,0->198,1;;22,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;198,1->199,3;;22,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;199,3->200,4;;22,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;200,4->201,5;;22,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;201,5->202,6;;22,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;202,6->203,8;;22,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;203,8->204,9;;22,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;204,9->206,0;;22,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;206,0->207,2;;22,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;207,2->208,3;;22,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;208,3->209,4;;23,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;209,4->210,5;;23,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;210,5->211,5;;23,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;211,5->212,6;;23,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;212,6->213,7;;23,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;213,7->214,8;;23,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;214,8->215,9;;23,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;215,9->216,9;;23,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;216,9->218,0;;23,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;218,0->219,1;;23,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;219,1->220,1;;24,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;220,1->221,2;;24,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;221,2->222,2;;24,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;222,2->223,3;;24,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;223,3->224,3;;24,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;224,3->225,3;;24,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;225,3->226,4;;24,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;226,4->227,4;;24,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;227,4->228,5;;24,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;228,5->229,5;;24,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;229,5->230,5;;25,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;230,5->231,5;;25,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;231,5->232,5;;25,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;232,5->233,5;;25,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;233,5->234,5;;25,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;234,5->235,5;;25,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;235,5->236,5;;25,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;236,5->237,5;;25,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;237,5->238,5;;25,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;238,5->239,5;;25,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;239,5->240,5;;26,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;240,5->241,4;;26,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;241,4->242,4;;26,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;242,4->243,3;;26,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;243,3->244,3;;26,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;244,3->245,3;;26,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;245,3->246,2;;26,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;246,2->247,2;;26,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;247,2->248,1;;26,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;248,1->249,1;;26,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;249,1->250,0;;27,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;250,0->250,9;;27,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;250,9->251,9;;27,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;251,9->252,8;;27,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;252,8->253,7;;27,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;253,7->254,6;;27,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;254,6->255,5;;27,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;255,5->256,5;;27,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;256,5->257,4;;27,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;257,4->258,3;;27,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;258,3->259,2;;28,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;259,2->260,0;;28,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;260,0->260,9;;28,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;260,9->261,7;;28,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;261,7->262,6;;28,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;262,6->263,5;;28,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;263,5->264,3;;28,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;264,3->265,2;;28,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;265,2->266,0;;28,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;266,0->266,9;;28,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;266,9->267,7;;29,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;267,7->268,5;;29,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;268,5->269,4;;29,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;269,4->270,2;;29,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;270,2->271,0;;29,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;271,0->271,8;;29,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;271,8->272,6;;29,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;272,6->273,5;;29,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;273,5->274,3;;29,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;274,3->275,1;;29,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;275,1->275,9;;30,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;275,9->276,6;;30,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;276,6->277,4;;30,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;277,4->278,2;;30,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;278,2->279,0;;30,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;279,0->279,7;;30,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;279,7->280,5;;30,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;280,5->281,3;;30,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;281,3->282,0;;30,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;282,0->282,8;;30,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;282,8->283,5;;31,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;283,5->284,2;;31,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;284,2->284,9;;31,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;284,9->285,6;;31,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;285,6->286,4;;31,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;286,4->287,1;;31,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;287,1->287,8;;31,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;287,8->288,5;;31,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;288,5->289,2;;31,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;289,2->289,9;;31,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;289,9->290,6;;32,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;290,6->291,2;;32,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;291,2->291,9;;32,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;291,9->292,6;;32,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;292,6->293,2;;32,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;293,2->293,9;;32,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;293,9->294,6;;32,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;294,6->295,3;;32,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;295,3->295,9;;32,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;295,9->296,6;;32,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;296,6->297,2;;33,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;297,2->297,8;;33,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;297,8->298,4;;33,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;298,4->299,0;;33,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;299,0->299,6;;33,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;299,6->300,3;;33,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;300,3->300,9;;33,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;300,9->301,5;;33,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;301,5->302,1;;33,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;302,1->302,7;;33,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;302,7->303,2;;34,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;303,2->303,8;;34,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;303,8->304,3;;34,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;304,3->304,9;;34,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;304,9->305,4;;34,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;305,4->306,0;;34,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;306,0->306,6;;34,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;306,6->307,1;;34,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;307,1->307,6;;34,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;307,6->308,2;;34,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;308,2->308,7;;35,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;308,7->309,2;;35,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;309,2->309,7;;35,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;309,7->310,2;;35,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;310,2->310,6;;35,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;310,6->311,1;;35,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;311,1->311,6;;35,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;311,6->312,1;;35,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;312,1->312,6;;35,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;312,6->313,1;;35,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;313,1->313,5;;36,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;313,5->314,0;;36,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;314,0->314,4;;36,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;314,4->314,9;;36,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;314,9->315,3;;36,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;315,3->315,7;;36,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;315,7->316,2;;36,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;316,2->316,6;;36,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;316,6->317,1;;36,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;317,1->317,5;;36,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;317,5->317,9;;37,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;317,9->318,2;;37,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;318,2->318,6;;37,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;318,6->319,0;;37,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;319,0->319,4;;37,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;319,4->319,7;;37,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;319,7->320,1;;37,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;320,1->320,5;;37,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;320,5->320,8;;37,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;320,8->321,2;;37,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;321,2->321,5;;38,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;321,5->321,8;;38,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;321,8->322,1;;38,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;322,1->322,4;;38,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;322,4->322,8;;38,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;322,8->323,1;;38,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;323,1->323,4;;38,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;323,4->323,7;;38,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;323,7->324,0;;38,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;324,0->324,3;;38,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;324,3->324,5;;39,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;324,5->324,8;;39,10 semanas$$\n");
        sb.append("474;;cadastrarLogica;;324,8->325,0;;39,20 semanas$$\n");
        sb.append("474;;cadastrarLogica;;325,0->325,3;;39,30 semanas$$\n");
        sb.append("474;;cadastrarLogica;;325,3->325,5;;39,40 semanas$$\n");
        sb.append("474;;cadastrarLogica;;325,5->325,7;;39,50 semanas$$\n");
        sb.append("474;;cadastrarLogica;;325,7->326,0;;39,60 semanas$$\n");
        sb.append("474;;cadastrarLogica;;326,0->326,2;;39,70 semanas$$\n");
        sb.append("474;;cadastrarLogica;;326,2->326,5;;39,80 semanas$$\n");
        sb.append("474;;cadastrarLogica;;326,5->326,7;;39,90 semanas$$\n");
        sb.append("474;;cadastrarLogica;;326,7->328,1;;40,00 semanas$$\n");
        sb.append("474;;cadastrarLogica;;328,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="D.B.P.">

        sb.append("472;;cadastrarLogica;;0,0->15,7;;<11,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;15,7->16,0;;11,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;16,0->16,4;;11,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;16,4->16,7;;11,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;16,7->17,1;;11,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;17,1->17,4;;11,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;17,4->17,7;;11,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;17,7->18,1;;11,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;18,1->18,4;;11,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;18,4->18,8;;11,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;18,8->19,1;;11,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;19,1->19,4;;12,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;19,4->19,7;;12,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;19,7->20,1;;12,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;20,1->20,4;;12,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;20,4->20,7;;12,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;20,7->21,0;;12,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;21,0->21,3;;12,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;21,3->21,7;;12,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;21,7->22,0;;12,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;22,0->22,3;;12,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;22,3->22,8;;13,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;22,8->23,2;;13,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;23,2->23,7;;13,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;23,7->24,2;;13,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;24,2->24,6;;13,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;24,6->25,1;;13,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;25,1->25,6;;13,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;25,6->26,1;;13,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;26,1->26,5;;13,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;26,5->27,0;;13,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;27,0->27,4;;14,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;27,4->27,7;;14,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;27,7->28,1;;14,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;28,1->28,5;;14,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;28,5->28,8;;14,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;28,8->29,2;;14,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;29,2->29,6;;14,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;29,6->30,0;;14,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;30,0->30,3;;14,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;30,3->30,7;;14,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;30,7->31,1;;15,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;31,1->31,4;;15,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;31,4->31,8;;15,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;31,8->32,1;;15,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;32,1->32,5;;15,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;32,5->32,9;;15,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;32,9->33,2;;15,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;33,2->33,6;;15,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;33,6->33,9;;15,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;33,9->34,3;;15,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;34,3->34,7;;16,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;34,7->35,0;;16,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;35,0->35,4;;16,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;35,4->35,7;;16,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;35,7->36,1;;16,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;36,1->36,5;;16,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;36,5->36,8;;16,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;36,8->37,2;;16,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;37,2->37,5;;16,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;37,5->37,9;;16,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;37,9->38,2;;17,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;38,2->38,6;;17,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;38,6->38,9;;17,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;38,9->39,3;;17,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;39,3->39,6;;17,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;39,6->39,9;;17,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;39,9->40,3;;17,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;40,3->40,6;;17,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;40,6->41,0;;17,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;41,0->41,3;;17,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;41,3->41,6;;18,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;41,6->42,0;;18,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;42,0->42,3;;18,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;42,3->42,7;;18,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;42,7->43,0;;18,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;43,0->43,3;;18,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;43,3->43,7;;18,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;43,7->44,0;;18,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;44,0->44,4;;18,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;44,4->44,7;;18,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;44,7->45,0;;19,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;45,0->45,4;;19,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;45,4->45,7;;19,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;45,7->46,1;;19,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;46,1->46,4;;19,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;46,4->46,7;;19,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;46,7->47,1;;19,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;47,1->47,4;;19,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;47,4->47,8;;19,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;47,8->48,1;;19,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;48,1->48,4;;20,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;48,4->48,7;;20,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;48,7->49,1;;20,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;49,1->49,4;;20,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;49,4->49,7;;20,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;49,7->50,0;;20,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;50,0->50,3;;20,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;50,3->50,7;;20,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;50,7->51,0;;20,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;51,0->51,3;;20,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;51,3->51,6;;21,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;51,6->51,9;;21,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;51,9->52,3;;21,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;52,3->52,6;;21,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;52,6->52,9;;21,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;52,9->53,2;;21,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;53,2->53,5;;21,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;53,5->53,9;;21,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;53,9->54,2;;21,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;54,2->54,5;;21,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;54,5->54,8;;22,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;54,8->55,1;;22,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;55,1->55,4;;22,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;55,4->55,7;;22,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;55,7->56,0;;22,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;56,0->56,3;;22,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;56,3->56,6;;22,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;56,6->56,9;;22,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;56,9->57,2;;22,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;57,2->57,5;;22,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;57,5->57,8;;23,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;57,8->58,1;;23,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;58,1->58,4;;23,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;58,4->58,7;;23,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;58,7->59,0;;23,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;59,0->59,3;;23,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;59,3->59,6;;23,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;59,6->59,9;;23,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;59,9->60,2;;23,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;60,2->60,5;;23,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;60,5->60,8;;24,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;60,8->61,1;;24,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;61,1->61,4;;24,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;61,4->61,7;;24,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;61,7->62,0;;24,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;62,0->62,2;;24,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;62,2->62,5;;24,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;62,5->62,8;;24,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;62,8->63,1;;24,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;63,1->63,4;;24,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;63,4->63,7;;25,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;63,7->64,0;;25,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;64,0->64,2;;25,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;64,2->64,5;;25,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;64,5->64,8;;25,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;64,8->65,1;;25,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;65,1->65,4;;25,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;65,4->65,6;;25,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;65,6->65,9;;25,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;65,9->66,2;;25,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;66,2->66,5;;26,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;66,5->66,7;;26,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;66,7->67,0;;26,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;67,0->67,3;;26,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;67,3->67,6;;26,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;67,6->67,8;;26,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;67,8->68,1;;26,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;68,1->68,4;;26,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;68,4->68,6;;26,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;68,6->68,9;;26,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;68,9->69,2;;27,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;69,2->69,4;;27,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;69,4->69,6;;27,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;69,6->69,9;;27,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;69,9->70,2;;27,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;70,2->70,4;;27,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;70,4->70,6;;27,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;70,6->70,9;;27,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;70,9->71,2;;27,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;71,2->71,4;;27,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;71,4->71,6;;28,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;71,6->71,9;;28,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;71,9->72,2;;28,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;72,2->72,4;;28,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;72,4->72,6;;28,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;72,6->72,9;;28,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;72,9->73,2;;28,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;73,2->73,4;;28,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;73,4->73,6;;28,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;73,6->73,9;;28,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;73,9->74,1;;29,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;74,1->74,4;;29,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;74,4->74,6;;29,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;74,6->74,8;;29,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;74,8->75,1;;29,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;75,1->75,3;;29,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;75,3->75,5;;29,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;75,5->75,7;;29,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;75,7->76,0;;29,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;76,0->76,2;;29,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;76,2->76,4;;30,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;76,4->76,7;;30,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;76,7->76,9;;30,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;76,9->77,1;;30,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;77,1->77,4;;30,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;77,4->77,6;;30,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;77,6->77,8;;30,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;77,8->78,0;;30,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;78,0->78,3;;30,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;78,3->78,5;;30,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;78,5->78,7;;31,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;78,7->78,9;;31,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;78,9->79,1;;31,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;79,1->79,3;;31,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;79,3->79,6;;31,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;79,6->79,8;;31,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;79,8->80,0;;31,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;80,0->80,2;;31,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;80,2->80,4;;31,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;80,4->80,6;;31,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;80,6->80,8;;32,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;80,8->81,0;;32,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;81,0->81,2;;32,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;81,2->81,4;;32,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;81,4->81,6;;32,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;81,6->81,7;;32,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;81,7->81,9;;32,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;81,9->82,1;;32,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;82,1->82,3;;32,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;82,3->82,5;;32,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;82,5->82,7;;33,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;82,7->82,9;;33,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;82,9->83,1;;33,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;83,1->83,3;;33,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;83,3->83,4;;33,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;83,4->83,6;;33,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;83,6->83,8;;33,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;83,8->84,0;;33,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;84,0->84,2;;33,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;84,2->84,4;;33,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;84,4->84,6;;34,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;84,6->84,7;;34,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;84,7->84,9;;34,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;84,9->85,1;;34,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;85,1->85,2;;34,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;85,2->85,4;;34,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;85,4->85,6;;34,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;85,6->85,8;;34,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;85,8->85,9;;34,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;85,9->86,1;;34,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;86,1->86,2;;35,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;86,2->86,4;;35,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;86,4->86,6;;35,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;86,6->86,7;;35,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;86,7->86,8;;35,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;86,8->87,0;;35,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;87,0->87,1;;35,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;87,1->87,3;;35,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;87,3->87,4;;35,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;87,4->87,6;;35,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;87,6->87,8;;36,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;87,8->87,9;;36,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;87,9->88,0;;36,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;88,0->88,2;;36,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;88,2->88,4;;36,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;88,4->88,5;;36,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;88,5->88,6;;36,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;88,6->88,8;;36,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;88,8->88,9;;36,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;88,9->89,1;;36,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;89,1->89,2;;37,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;89,2->89,3;;37,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;89,3->89,5;;37,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;89,5->89,6;;37,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;89,6->89,7;;37,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;89,7->89,8;;37,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;89,8->89,9;;37,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;89,9->90,1;;37,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;90,1->90,2;;37,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;90,2->90,3;;37,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;90,3->90,4;;38,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;90,4->90,5;;38,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;90,5->90,6;;38,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;90,6->90,7;;38,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;90,7->90,8;;38,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;90,8->91,0;;38,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;91,0->91,1;;38,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;91,1->91,2;;38,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;91,2->91,3;;38,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;91,3->91,4;;38,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;91,4->91,5;;39,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;91,5->91,6;;39,10 semanas$$\n");
        sb.append("472;;cadastrarLogica;;91,6->91,7;;39,20 semanas$$\n");
        sb.append("472;;cadastrarLogica;;91,7->91,8;;39,30 semanas$$\n");
        sb.append("472;;cadastrarLogica;;91,8->91,9;;39,40 semanas$$\n");
        sb.append("472;;cadastrarLogica;;91,9->92,0;;39,50 semanas$$\n");
        sb.append("472;;cadastrarLogica;;92,0->92,1;;39,60 semanas$$\n");
        sb.append("472;;cadastrarLogica;;92,1->92,2;;39,70 semanas$$\n");
        sb.append("472;;cadastrarLogica;;92,2->92,3;;39,80 semanas$$\n");
        sb.append("472;;cadastrarLogica;;92,3->92,4;;39,90 semanas$$\n");
        sb.append("472;;cadastrarLogica;;92,4->93,1;;40,00 semanas$$\n");
        sb.append("472;;cadastrarLogica;;93,1->999,99;;>40,00 semanas$$\n");

        // </editor-fold>

    }

}
