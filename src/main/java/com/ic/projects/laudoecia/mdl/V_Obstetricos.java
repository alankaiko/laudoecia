/*
 * V_Obstetricos.java
 *
 * Created on 04/07/2012, 16:34:41
 */

package com.ic.projects.laudoecia.mdl;

/**
 *
 * @author Marcelo <marcelo@instrumental.net.br>
 */
public class V_Obstetricos extends View
{

    static void obstetrico1Trimestre () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento">

        sb.append("0;;Dados do equipamento$$\n");
        sb.append("pc||Tipo;;f;;f||cdl@2@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@3@||gridwidth=2;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados da gestação">

        sb.append("4;;Dados da gestação;;170;;0;;Dados do equipamento$$\n");

        sb.append("pc||Número de fetos;;f;;f||cdl@8@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Corionicidade;;t;;f||cdl@11@1||gridx=1;;gridwidth=3$$\n");
        sb.append("pc||Amniocidade;;t;;f||cdl@12@1||gridx=4;;gridwidth=1$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||DUM;;f;;f||cdl@15@||1;;gridy=0;;gridx=0$$\n");
        sb.append("hs||100||||1$$\n");
        sb.append("pc||IGH;;t;;f||cdl@17@||1;;gridx=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||t;;f||lbl@Sem.@||1;;gridx=2$$\n");
        sb.append("pc||t;;f||cdl@18@||1;;gridx=3$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||t;;f||lbl@Dias@||1;;gridx=4$$\n");
        sb.append("hs||0||||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||DPP;;t;;f||cdl@16@||1;;gridx=6;;weightx=0$$\n");
        sb.append("hs||100||||1$$\n");
        sb.append("pc||IGH pela amenorréia;;f;;t||subcont@1@||gridx=0;;gridy=1;;gridwidth=6$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Data;;f;;f||cdl@19@||2;;gridwidth=1$$\n");
        sb.append("hs||100||||2$$\n");
        sb.append("pc||t;;f||cdl@20@||2;;gridx=1$$\n");
        sb.append("hs||50||||2$$\n");
        sb.append("pc||t;;f||lbl@Sem.@||2;;gridx=2$$\n");
        sb.append("pc||t;;f||cdl@21@||2;;gridx=3$$\n");
        sb.append("hs||50||||2$$\n");
        sb.append("pc||t;;f||lbl@Dias@||2;;gridx=4$$\n");
        sb.append("hs||50||||2;;gridx=5;;weightx=1$$\n");
        sb.append("pc||IGH;;t;;f||cdl@24@||2;;gridx=6;;weightx=0$$\n");
        sb.append("hs||50||||2$$\n");
        sb.append("pc||t;;f||lbl@Sem.@||2;;gridx=7$$\n");
        sb.append("pc||t;;f||cdl@25@||2;;gridx=8$$\n");
        sb.append("hs||50||||2$$\n");
        sb.append("pc||t;;f||lbl@Dias@||2;;gridx=9$$\n");
        sb.append("pc||DPP;;t;;f||cdl@23@||2;;gridx=10$$\n");
        sb.append("hs||100||||2$$\n");
        sb.append("pc||IGH pelo último exame;;f;;t||subcont@2@||gridx=0;;gridy=2;;gridwidth=6$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||CCN (mm);;f;;f||cdl@65@1||3;;gridy=0;;gridx=0;;gridwidth=1$$\n");
        sb.append("pc||CCN (mm) Feto 1;;f;;f||cdl@87@1||3$$\n");
        sb.append("hs||110||||3$$\n");
        sb.append("pc|| ;;t;;f||cdl@269@1||3;;gridx=1$$\n");
        sb.append("hs||230||||3$$\n");
        sb.append("vs||50||||3;;gridx=2;;weightx=1$$\n");
        sb.append("pc||IGH pelo CCN;;f;;t||subcont@3@||gridx=0;;gridy=3;;gridwidth=6;;weightx=0$$\n");

        sb.append("subpnl||||||->4$$\n");
        sb.append("pc||Idade;;f;;f||cdl@253@||4;;gridy=0;;gridwidth=1$$\n");
        sb.append("hs||50||||4$$\n");
        sb.append("pc||t;;f||lbl@Semanas@||4;;gridx=1$$\n");
        sb.append("pc||t;;f||cdl@256@||4;;gridx=2$$\n");
        sb.append("hs||50||||4$$\n");
        sb.append("pc||t;;f||lbl@dias@||4;;gridx=3$$\n");
        sb.append("hs||0||||4;;weightx=1;;gridx=4$$\n");
        sb.append("pc||Data do exame;;f;;f||cdl@13@||4;;gridx=5;;weightx=0$$\n");
        sb.append("hs||100||||4$$\n");
        sb.append("pc||DPP;;t;;f||cdl@267@||4;;gridx=6$$\n");
        sb.append("hs||100||||4$$\n");
        sb.append("pc||IGH definida pelo examinador;;f;;t||subcont@4@||gridx=0;;gridy=4;;gridwidth=6$$\n");

        sb.append("pc||Desvio padrão da idade gest.  ;;f;;t||cdl@244@||gridwidth=2;;gridy=5$$\n");
        sb.append("pc||± semana(s);;t;;t||cdl@259@||gridx=2;;gridwidth=1$$\n");
        sb.append("hs||80||||gridx=3$$\n");
        sb.append("hs||200||||gridx=4$$\n");
        sb.append("hs||20||||gridx=5$$\n");

        sb.append("hs||0||||gridx=6;;gridy=6;;weightx=1;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Bexiga">

        sb.append("27;;Bexiga;;200;;4;;Dados da gestação$$\n");
        sb.append("pc||Situação;;f;;f||cdl@29@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@31@||gridwidth=2;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vagina">

        sb.append("32;;Vagina;;200;;27;;Bexiga$$\n");
        sb.append("pc||Situação;;f;;f||cdl@34@||gridx=0;;gridy=0$$\n");
        sb.append("hs||265||||$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@36@||gridwidth=2;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Útero">

        sb.append("37;;Útero;;200;;32;;Vagina$$\n");
        sb.append("pc||Situação;;f;;f||cdl@39@||$$\n");
        sb.append("hs||150||||gridx=0;;gridy=0$$\n");
        sb.append("pc||Posição;;t;;f||cdl@40@||gridx=1;;gridy=0$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("pc||Contornos;;t;;f||cdl@41@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Limites;;t;;f||cdl@42@||gridx=3$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;t||cdl@44@||gridx=0;;gridy=1$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;t||cdl@45@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;t||cdl@46@||gridx=2$$\n");
        sb.append("pc||Volume (cm³);;t;;t||cdl@47@||gridx=3$$\n");
        sb.append("pc||Textura do miométrio;;f;;t||cdl@49@||gridy=2;;gridx=0$$\n");
        sb.append("pc||Canal endocervical;;t;;t||cdl@51@||gridx=1;;gridwidth=2$$\n");
        sb.append("hs||0||||gridx=5;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=4;;weightx=0$$\n");
        sb.append("hs||0||||gridx=0;;gridy=4;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados Feto Único">

        // <editor-fold defaultstate="collapsed" desc="Saco Gestacional">

        sb.append("52;;Saco gestacional;;200;;37;;Útero$$\n");
        sb.append("pc||Inserção;;f;;f||cdl@54@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Forma;;t;;f||cdl@55@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;t||cdl@56@||gridx=0;;gridy=1$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;t||cdl@57@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;t||cdl@58@||gridx=2$$\n");
        sb.append("hs||0||||gridx=4;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=4;;weightx=0$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Embrião / Feto">

        sb.append("52;;Embrião / Feto;;250;;52;;Embrião / Feto$$\n");

        sb.append("pc||Vesícula vitelínica;;f;;f||cdl@60@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Membrana amniótica;;t;;f||cdl@62@||gridx=1$$\n");

        sb.append("pc||Presença;;f;;t||cdl@64@||gridx=0;;gridy=1$$\n");
        sb.append("hs||180||||$$\n");
        sb.append("pc||Batimentos cardíacos;;t;;t||cdl@68@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("pc||N° (bat/min);;t;;t||cdl@69@||gridx=2$$\n");
        sb.append("hs||100||||$$\n");
        sb.append("pc||;;t;;t||lbln@ @||gridx=3$$\n");

        sb.append("pc||Movimentos;;f;;t||cdl@66@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Translucência nucal (mm);;t;;t||cdl@71@||gridx=1$$\n");
//        sb.append("pc||CCN (mm);;t;;t||cdl@65@||gridx=2$$\n");

        sb.append("pc||Descrição;;f;;t||cdl@73@||gridy=3;;gridx=0;;gridwidth=4$$\n");
        sb.append("vs||200||||$$\n");

        sb.append("hs||0||||gridx=4;;gridy=4;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados Feto 1">

        // <editor-fold defaultstate="collapsed" desc="Saco Gestacional">

        sb.append("74;;Saco gestacional - Embrião / Feto 1;;200;;37;;Útero$$\n");

        sb.append("pc||Inserção;;f;;f||cdl@76@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Forma;;t;;f||cdl@77@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");

        sb.append("pc||Diam. longitudinal (cm);;f;;t||cdl@78@||gridx=0;;gridy=1$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;t||cdl@79@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;t||cdl@80@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");

        sb.append("hs||0||||gridx=3;;gridy=2;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Embrião / Feto">

        sb.append("74;;Embrião / Feto 1;;250;;74;;Embrião / Feto 1$$\n");

        sb.append("pc||Vesícula vitelínica;;f;;f||cdl@82@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Membrana amniótica;;t;;f||cdl@84@||gridx=1$$\n");

        sb.append("pc||Presença;;f;;t||cdl@86@||gridx=0;;gridy=1$$\n");
        sb.append("hs||180||||$$\n");
        sb.append("pc||Batimentos cardíacos;;t;;t||cdl@90@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("pc||N° (bat/min);;t;;t||cdl@91@||gridx=2$$\n");
        sb.append("hs||125||||$$\n");
        sb.append("pc||;;t;;t||lbln@ @||gridx=3$$\n");

        sb.append("pc||Movimentos;;f;;t||cdl@88@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Translucência nucal (mm);;t;;t||cdl@93@||gridx=1$$\n");
//        sb.append("pc||CCN (mm);;t;;t||cdl@87@||gridx=2$$\n");

        sb.append("pc||Descrição;;f;;t||cdl@95@||gridy=3;;gridx=0;;gridwidth=4$$\n");
        sb.append("vs||200||||$$\n");

        sb.append("hs||0||||gridx=4;;gridy=4;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados Feto 2">

        // <editor-fold defaultstate="collapsed" desc="Saco Gestacional">

        sb.append("96;;Saco gestacional - Embrião / Feto 2;;200;;74;;Embrião / Feto 1$$\n");
        sb.append("pc||Inserção;;f;;f||cdl@98@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Forma;;t;;f||cdl@99@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;t||cdl@100@||gridx=0;;gridy=1$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;t||cdl@101@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;t||cdl@102@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("hs||0||||gridx=4;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=4;;weightx=0$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Embrião / Feto">

        sb.append("96;;Embrião / Feto 2;;250;;96;;Embrião / Feto 2$$\n");

        sb.append("pc||Vesícula vitelínica;;f;;f||cdl@104@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Membrana amniótica;;t;;f||cdl@106@||gridx=1$$\n");

        sb.append("pc||Presença;;f;;t||cdl@108@||gridx=0;;gridy=1$$\n");
        sb.append("hs||180||||$$\n");
        sb.append("pc||Batimentos cardíacos;;t;;t||cdl@112@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("pc||N° (bat/min);;t;;t||cdl@113@||gridx=2$$\n");
        sb.append("hs||125||||$$\n");
        sb.append("pc||;;t;;t||lbln@ @||gridx=3$$\n");

        sb.append("pc||Movimentos;;f;;t||cdl@110@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Translucência nucal (mm);;t;;t||cdl@115@||gridx=1$$\n");
        sb.append("pc||CCN (mm);;t;;t||cdl@109@||gridx=2$$\n");

        sb.append("pc||Descrição;;f;;t||cdl@117@||gridy=3;;gridx=0;;gridwidth=4$$\n");
        sb.append("vs||200||||$$\n");

        sb.append("hs||0||||gridx=4;;gridy=4;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados Feto 3">

        // <editor-fold defaultstate="collapsed" desc="Saco Gestacional">

        sb.append("118;;Saco gestacional - Embrião / Feto 3;;200;;96;;Embrião / Feto 2$$\n");
        sb.append("pc||Inserção;;f;;f||cdl@120@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Forma;;t;;f||cdl@121@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;t||cdl@122@||gridx=0;;gridy=1$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;t||cdl@123@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;t||cdl@124@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("hs||0||||gridx=4;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=4;;weightx=0$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Embrião / Feto">

        sb.append("118;;Embrião / Feto 3;;250;;118;;Embrião / Feto 3$$\n");

        sb.append("pc||Vesícula vitelínica;;f;;f||cdl@126@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Membrana amniótica;;t;;f||cdl@128@||gridx=1$$\n");

        sb.append("pc||Presença;;f;;t||cdl@130@||gridx=0;;gridy=1$$\n");
        sb.append("hs||180||||$$\n");
        sb.append("pc||Batimentos cardíacos;;t;;t||cdl@134@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("pc||N° (bat/min);;t;;t||cdl@135@||gridx=2$$\n");
        sb.append("hs||125||||$$\n");
        sb.append("pc||;;t;;t||lbln@ @||gridx=3$$\n");

        sb.append("pc||Movimentos;;f;;t||cdl@132@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Translucência nucal (mm);;t;;t||cdl@137@||gridx=1$$\n");
        sb.append("pc||CCN (mm);;t;;t||cdl@131@||gridx=2$$\n");

        sb.append("pc||Descrição;;f;;t||cdl@139@||gridy=3;;gridx=0;;gridwidth=4$$\n");
        sb.append("vs||200||||$$\n");

        sb.append("hs||0||||gridx=4;;gridy=4;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados Feto 4">

        // <editor-fold defaultstate="collapsed" desc="Saco Gestacional">

        sb.append("140;;Saco gestacional - Embrião / Feto 4;;200;;118;;Embrião / Feto 3$$\n");
        sb.append("pc||Inserção;;f;;f||cdl@142@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Forma;;t;;f||cdl@143@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;t||cdl@144@||gridx=0;;gridy=1$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;t||cdl@145@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;t||cdl@146@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("hs||0||||gridx=4;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=4;;weightx=0$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Embrião / Feto">

        sb.append("140;;Embrião / Feto 4;;250;;140;;Embrião / Feto 4$$\n");

        sb.append("pc||Vesícula vitelínica;;f;;f||cdl@148@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Membrana amniótica;;t;;f||cdl@150@||gridx=1$$\n");

        sb.append("pc||Presença;;f;;t||cdl@152@||gridx=0;;gridy=1$$\n");
        sb.append("hs||180||||$$\n");
        sb.append("pc||Batimentos cardíacos;;t;;t||cdl@156@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("pc||N° (bat/min);;t;;t||cdl@157@||gridx=2$$\n");
        sb.append("hs||125||||$$\n");
        sb.append("pc||;;t;;t||lbln@  @||gridx=3$$\n");

        sb.append("pc||Movimentos;;f;;t||cdl@154@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Translucência nucal (mm);;t;;t||cdl@159@||gridx=1$$\n");
        sb.append("pc||CCN (mm);;t;;t||cdl@153@||gridx=2$$\n");

        sb.append("pc||Descrição;;f;;t||cdl@161@||gridy=3;;gridx=0;;gridwidth=4$$\n");
        sb.append("vs||200||||$$\n");

        sb.append("hs||0||||gridx=4;;gridy=4;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados Feto 5">

        // <editor-fold defaultstate="collapsed" desc="Saco Gestacional">

        sb.append("162;;Saco gestacional - Embrião / Feto 5;;200;;140;;Embrião / Feto 4$$\n");
        sb.append("pc||Inserção;;f;;f||cdl@164@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Forma;;t;;f||cdl@165@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;t||cdl@166@||gridx=0;;gridy=1$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;t||cdl@167@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;t||cdl@168@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("hs||0||||gridx=4;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=4;;weightx=0$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Embrião / Feto">

        sb.append("162;;Embrião / Feto 5;;250;;162;;Embrião / Feto 5$$\n");

        sb.append("pc||Vesícula vitelínica;;f;;f||cdl@170@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Membrana amniótica;;t;;f||cdl@172@||gridx=1$$\n");

        sb.append("pc||Presença;;f;;t||cdl@174@||gridx=0;;gridy=1$$\n");
        sb.append("hs||180||||$$\n");
        sb.append("pc||Batimentos cardíacos;;t;;t||cdl@178@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("pc||N° (bat/min);;t;;t||cdl@179@||gridx=2$$\n");
        sb.append("hs||125||||$$\n");
        sb.append("pc||;;t;;t||lbln@  @||gridx=3$$\n");

        sb.append("pc||Movimentos;;f;;t||cdl@176@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Translucência nucal (mm);;t;;t||cdl@181@||gridx=1$$\n");
        sb.append("pc||CCN (mm);;t;;t||cdl@175@||gridx=2$$\n");

        sb.append("pc||Descrição;;f;;t||cdl@183@||gridy=3;;gridx=0;;gridwidth=4$$\n");
        sb.append("vs||200||||$$\n");

        sb.append("hs||0||||gridx=4;;gridy=4;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados Feto 6">

        // <editor-fold defaultstate="collapsed" desc="Saco Gestacional">

        sb.append("184;;Saco gestacional - Embrião / Feto 6;;200;;162;;Embrião / Feto 5$$\n");
        sb.append("pc||Inserção;;f;;f||cdl@186@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Forma;;t;;f||cdl@187@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;t||cdl@188@||gridx=0;;gridy=1$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;t||cdl@189@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;t||cdl@190@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("hs||0||||gridx=4;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=4;;weightx=0$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Embrião / Feto">

        sb.append("184;;Embrião / Feto 6;;250;;184;;Embrião / Feto 6$$\n");

        sb.append("pc||Vesícula vitelínica;;f;;f||cdl@192@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Membrana amniótica;;t;;f||cdl@194@||gridx=1$$\n");

        sb.append("pc||Presença;;f;;t||cdl@196@||gridx=0;;gridy=1$$\n");
        sb.append("hs||180||||$$\n");
        sb.append("pc||Batimentos cardíacos;;t;;t||cdl@200@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("pc||N° (bat/min);;t;;t||cdl@201@||gridx=2$$\n");
        sb.append("hs||125||||$$\n");
        sb.append("pc||;;t;;t||lbln@  @||gridx=3$$\n");

        sb.append("pc||Movimentos;;f;;t||cdl@198@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Translucência nucal (mm);;t;;t||cdl@203@||gridx=1$$\n");
        sb.append("pc||CCN (mm);;t;;t||cdl@197@||gridx=2$$\n");

        sb.append("pc||Descrição;;f;;t||cdl@205@||gridy=3;;gridx=0;;gridwidth=4$$\n");
        sb.append("vs||200||||$$\n");

        sb.append("hs||0||||gridx=4;;gridy=4;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovário Direito">

        sb.append("206;;Ovário direito;;250;;184;;Embrião / Feto 6$$\n");
        sb.append("pc||Posição;;f;;f||cdl@208@||$$\n");
        sb.append("hs||150||||gridx=0;;gridy=0$$\n");
        sb.append("pc||Contornos;;t;;f||cdl@209@||gridx=1;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Limites;;t;;f||cdl@210@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Parênquima;;f;;t||cdl@212@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||240||||$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;t||cdl@214@||gridx=0;;gridy=2;;gridwidth=1$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;t||cdl@215@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;t||cdl@216@||gridx=2$$\n");
        sb.append("pc||Volume (cm³);;t;;t||cdl@217@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@219@||gridy=3;;gridx=0;;gridwidth=4$$\n");
        sb.append("vs||200||||gridwidth=1$$\n");
        sb.append("hs||0||||gridx=4;;gridy=4;;weighty=1;;weightx=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovário Esquerdo">

        sb.append("206;;Ovário esquerdo;;250;;206;;Ovários$$\n");
        sb.append("pc||Posição;;f;;f||cdl@221@||$$\n");
        sb.append("hs||150||||gridx=0;;gridy=0$$\n");
        sb.append("pc||Contornos;;t;;f||cdl@222@||gridx=1;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Limites;;t;;f||cdl@223@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Parênquima;;f;;t||cdl@225@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||240||||$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;t||cdl@227@||gridx=0;;gridy=2;;gridwidth=1$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;t||cdl@228@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;t||cdl@229@||gridx=2$$\n");
        sb.append("pc||Volume (cm³);;t;;t||cdl@230@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@232@||gridy=3;;gridx=0;;gridwidth=4$$\n");
        sb.append("vs||200||||gridwidth=1$$\n");
        sb.append("hs||0||||gridx=4;;gridy=4;;weighty=1;;weightx=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais sobre os ovários">

        sb.append("234;;Informações complementares sobre os ovários;;200;;206;;Ovários$$\n");
        sb.append("cdl||234||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fundo de saco Douglas">

        sb.append("235;;Fundo de saco Douglas;;200;;206;;Ovários$$\n");
        sb.append("pc||Situação;;f;;f||cdl@237@||$$\n");
        sb.append("hs||120||||gridx=1;;weightx=0.2;;gridwidth=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@239@||gridwidth=2;;gridy=1;;gridx=0;;weightx=0.2$$\n");
        sb.append("vs||200||||gridy=1;;gridx=2;;weightx=0.8;;gridwidth=1$$\n");
        sb.append("hs||300||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("240;;Observações gerais;;200;;235;;Fundo de saco Douglas$$\n");
        sb.append("pc||f;;t;;f||cdl@242@||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("247;;Impressão diagnóstica;;200;;240;;Observações gerais$$\n");
        sb.append("cdl||263||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||261||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("pc||Imprimir DPP;;f;;t||cdl@270@||gridx=0;;gridy=2;;weightx=0$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1$$\n");
        sb.append("\n##\n");
        //cid 10
        sb.append("\n247\n");
        // </editor-fold>

        alterarVisaoDeLaudo(4);

    }

    static void obstetrico14Semanas () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento e da gestação">

        sb.append("0;;Dados do equipamento e da gestação$$\n");

        sb.append("pc||Tipo;;f;;f||cdl@2@||gridx=0;;gridy=0$$\n");
        sb.append("hs||140||||$$\n");

        sb.append("pc||Descrição;;t;;t||cdl@3@||gridwidth=3;;gridy=1$$\n");
        sb.append("vs||170||||$$\n");

        sb.append("pc||Número de fetos;;f;;t||cdl@8@||gridx=0;;gridy=2;;gridwidth=1$$\n");
        sb.append("pc||Corionicidade;;t;;t||cdl@11@1||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("pc||Amniocidade;;t;;t||cdl@12@1||gridx=2$$\n");
        sb.append("hs||200||||$$\n");

        sb.append("hs||0||||gridx=3;;gridy=5;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 1">

        //  <editor-fold defaultstate="collapsed" desc="Biometria">

        sb.append("26;;IGH e biometria$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||DUM;;f;;f||cdl@15@||1;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IGH;;t;;f||cdl@17@||1;;gridx=1$$\n");
        sb.append("pc||t;;f||lbl@Sem.@||1;;gridx=2$$\n");
        sb.append("pc||t;;f||cdl@18@||1;;gridx=3$$\n");
        sb.append("pc||t;;f||lbl@Dias@||1;;gridx=4$$\n");
        sb.append("pc||t;;f||lbl@@||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||DPP;;t;;f||cdl@16@3||1;;gridx=6;;weightx=0$$\n");
        sb.append("hs||100||||1;;gridy=1;;gridx=0$$\n");
        sb.append("hs||50||||1;;gridx=1;;$$\n");
        sb.append("hs||30||||1;;gridx=2;;$$\n");
        sb.append("hs||50||||1;;gridx=3;;$$\n");
        sb.append("hs||30||||1;;gridx=4;;$$\n");
        sb.append("hs||100||||1;;gridx=6;;$$\n");
        sb.append("pc||IGH pela amenorréia;;f;;f||subcont@1@||gridx=0;;gridy=0;;weightx=0;;gridwidth=3$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Data;;f;;f||cdl@19@||2;;gridwidth=1;;gridy=0;;gridx=0$$\n");
        sb.append("pc||t;;f||cdl@20@||2;;gridx=1$$\n");
        sb.append("pc||t;;f||lbl@Sem.@||2;;gridx=2$$\n");
        sb.append("pc||t;;f||cdl@21@||2;;gridx=3$$\n");
        sb.append("pc||t;;f||lbl@Dias@||2;;gridx=4$$\n");
        sb.append("hs||0||||2;;gridx=5;;weightx=1$$\n");
        sb.append("pc||IGH;;t;;f||cdl@24@||2;;gridx=6;;weightx=0$$\n");
        sb.append("pc||t;;f||lbl@Sem.@||2;;gridx=7$$\n");
        sb.append("pc||t;;f||cdl@25@||2;;gridx=8$$\n");
        sb.append("pc||t;;f||lbl@Dias@||2;;gridx=9$$\n");
        sb.append("pc||DPP;;t;;f||cdl@23@3||2;;gridx=11$$\n");
        sb.append("hs||100||||2;;gridy=1;;gridx=0$$\n");
        sb.append("hs||50||||2;;gridx=1;;$$\n");
        sb.append("hs||30||||2;;gridx=2;;$$\n");
        sb.append("hs||50||||2;;gridx=3;;$$\n");
        sb.append("hs||30||||2;;gridx=4;;$$\n");
        sb.append("hs||50||||2;;gridx=6;;$$\n");
        sb.append("hs||30||||2;;gridx=7;;$$\n");
        sb.append("hs||50||||2;;gridx=8;;$$\n");
        sb.append("hs||30||||2;;gridx=9;;$$\n");
        sb.append("hs||100||||2;;gridx=11;;$$\n");
        sb.append("pc||IGH pelo último exame;;f;;t||subcont@2@||gridx=0;;gridy=1;;gridwidth=3$$\n");

        sb.append("subpnl||||||->4$$\n");
        sb.append("pc||<html>&nbsp;I.C. <font color=\"0000ff\">(70 a 86)</html>"
                + ";;f;;f||cdl@44@||4;;gridy=0;;gridwidth=1$$\n");
        sb.append("pc||C.C. (mm);;t;;f||cdl@48@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;f||cdl@439@||4;;gridx=2$$\n");
        sb.append("pc||C.C./C.A.;;f;;t||cdl@49@||4;;gridy=1;;gridx=0$$\n");
        sb.append("pc||C.F./C.A. (Hadlock);;t;;t||cdl@51@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(20 a 24)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("pc||Estatura (cm)   ;;f;;t||cdl@56@||4;;gridx=0;;gridy=2$$\n");
        sb.append("pc||Peso fetal provável (g);;t;;t||cdl@55@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(pelo D.B.P e C.A.)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("hs||0||||4;;gridx=3;;gridy=3;;weightx=1$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||;;f;;f||lbln@ D.B.P.@||3;;gridy=0;;gridx=0;;weightx=0$$\n");
        sb.append("pc||em mm  ;;t;;f||cdl@43@||3;;gridx=1$$\n");
        sb.append("pc||I.G.;;t;;f||cdl@437@||3;;gridx=2$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.O.F. (mm);;t;;f||cdl@60@||3;;gridx=3$$\n");
        sb.append("pc||Valor do C.A.;;t;;f||cdl@45@||3;;gridx=4$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.A.P. (mm);;t;;f||cdl@61@1||3;;gridx=5$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||D.L.L. (mm);;t;;f||cdl@62@1||3;;gridx=6$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||Resultados;;t;;t||subcont@4@||3;;gridx=3;;gridy=1;;gridwidth=4;;gridheight=8$$\n");
        sb.append("lbln||C.A.||||3;;gridx=0;;gridheight=1;;gridwidth=1;;left_insets=4;;top_insets=8$$\n");
        sb.append("cdl||46||1||3;;gridx=1$$\n");
        sb.append("cdl||47||1||3$$\n");
        sb.append("cdl||438||||3;;gridx=2$$\n");
        sb.append("lbln||C.F.||||3;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||50||||3;;gridx=1$$\n");
        sb.append("cdl||433||||3;;gridx=2$$\n");
        sb.append("lbln||Úmero||||3;;gridx=0;;gridy=3$$\n");
        sb.append("cdl||52||||3;;gridx=1$$\n");
        sb.append("cdl||434||||3;;gridx=2$$\n");
        sb.append("lbln||Ulna||||3;;gridx=0;;gridy=4$$\n");
        sb.append("cdl||53||||3;;gridx=1$$\n");
        sb.append("cdl||435||||3;;gridx=2$$\n");
        sb.append("lbln||Tíbia||||3;;gridx=0;;gridy=5$$\n");
        sb.append("cdl||54||||3;;gridx=1$$\n");
        sb.append("cdl||436||||3;;gridx=2$$\n");
        sb.append("hs||0||||3;;gridy=8$$\n");
        sb.append("hs||0||||3;;gridx=7;;gridy=9;;weightx=1;;left_insets=0;;top_insets=0$$\n");
        sb.append("pc||IGH pela biometria (baseado no percentil 50);;f;;t||subcont@3@||gridx=0;;gridy=2;;weightx=0;;gridwidth=3$$\n");

        sb.append("subpnl||||||->5$$\n");
        sb.append("pc||IGH     ;;f;;f||cdl@417@||5;;gridy=0;;gridx=0;;gridwidth=1$$\n");
        sb.append("pc||t;;f||lbl@Sem. @||5;;gridx=1$$\n");
        sb.append("pc||t;;f||cdl@420@||5;;gridx=2$$\n");
        sb.append("hs||30||||5$$\n");
        sb.append("pc||t;;f||lbl@Dias@||5;;gridx=3$$\n");
        sb.append("pc||Data do exame;;t;;f||cdl@13@||5;;gridx=4$$\n");
        sb.append("pc||Desvio padrão da I.G.;;t;;f||cdl@408@||5;;gridx=5$$\n");
        sb.append("hs||150||||5$$\n");
        sb.append("pc||± semana(s);;t;;f||cdl@423@||5;;gridx=6$$\n");
        sb.append("hs||0||||5;;gridx=7;;weightx=1$$\n");
        sb.append("pc||DPP;;t;;f||cdl@431@3||5;;gridx=8;;weightx=0$$\n");
        sb.append("hs||100||||5$$\n");
        sb.append("pc||IGH definida pelo examinador;;f;;t||subcont@5@||gridx=0;;gridy=4;;gridwidth=3$$\n");

        sb.append("vs||0||||gridx=3;;gridy=6;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        //  </editor-fold>

        //  <editor-fold defaultstate="collapsed" desc="Biometria 1">

        sb.append("80;;IGH e biometria - Feto 1$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||DUM;;f;;f||cdl@15@||1;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IGH;;t;;f||cdl@17@||1;;gridx=1$$\n");
        sb.append("pc||t;;f||lbl@Sem.@||1;;gridx=2$$\n");
        sb.append("pc||t;;f||cdl@18@||1;;gridx=3$$\n");
        sb.append("pc||t;;f||lbl@Dias@||1;;gridx=4$$\n");
        sb.append("pc||t;;f||lbl@@||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||DPP;;t;;f||cdl@16@3||1;;gridx=6;;weightx=0$$\n");
        sb.append("hs||100||||1;;gridy=1;;gridx=0$$\n");
        sb.append("hs||50||||1;;gridx=1;;$$\n");
        sb.append("hs||30||||1;;gridx=2;;$$\n");
        sb.append("hs||50||||1;;gridx=3;;$$\n");
        sb.append("hs||30||||1;;gridx=4;;$$\n");
        sb.append("hs||100||||1;;gridx=6;;$$\n");
        sb.append("pc||IGH pela amenorréia;;f;;f||subcont@1@||gridx=0;;gridy=0;;weightx=0;;gridwidth=3$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Data;;f;;f||cdl@19@||2;;gridwidth=1;;gridy=0;;gridx=0$$\n");
        sb.append("pc||t;;f||cdl@20@||2;;gridx=1$$\n");
        sb.append("pc||t;;f||lbl@Sem.@||2;;gridx=2$$\n");
        sb.append("pc||t;;f||cdl@21@||2;;gridx=3$$\n");
        sb.append("pc||t;;f||lbl@Dias@||2;;gridx=4$$\n");
        sb.append("hs||0||||2;;gridx=5;;weightx=1$$\n");
        sb.append("pc||IGH;;t;;f||cdl@24@||2;;gridx=6;;weightx=0$$\n");
        sb.append("pc||t;;f||lbl@Sem.@||2;;gridx=7$$\n");
        sb.append("pc||t;;f||cdl@25@||2;;gridx=8$$\n");
        sb.append("pc||t;;f||lbl@Dias@||2;;gridx=9$$\n");
        sb.append("pc||DPP;;t;;f||cdl@23@3||2;;gridx=11$$\n");
        sb.append("hs||100||||2;;gridy=1;;gridx=0$$\n");
        sb.append("hs||50||||2;;gridx=1;;$$\n");
        sb.append("hs||30||||2;;gridx=2;;$$\n");
        sb.append("hs||50||||2;;gridx=3;;$$\n");
        sb.append("hs||30||||2;;gridx=4;;$$\n");
        sb.append("hs||50||||2;;gridx=6;;$$\n");
        sb.append("hs||30||||2;;gridx=7;;$$\n");
        sb.append("hs||50||||2;;gridx=8;;$$\n");
        sb.append("hs||30||||2;;gridx=9;;$$\n");
        sb.append("hs||100||||2;;gridx=11;;$$\n");
        sb.append("pc||IGH pelo último exame;;f;;t||subcont@2@||gridx=0;;gridy=1;;gridwidth=3$$\n");

        sb.append("subpnl||||||->4$$\n");
        sb.append("pc||<html>&nbsp;I.C. <font color=\"0000ff\">(70 a 86)</html>"
                + ";;f;;f||cdl@98@||4;;gridy=0;;gridwidth=1$$\n");
        sb.append("pc||C.C. (mm);;t;;f||cdl@102@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;f||cdl@439@||4;;gridx=2$$\n");
        sb.append("pc||C.C./C.A.;;f;;t||cdl@103@||4;;gridy=1;;gridx=0$$\n");
        sb.append("pc||C.F./C.A. (Hadlock);;t;;t||cdl@105@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(20 a 24)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("pc||Estatura (cm)   ;;f;;t||cdl@110@||4;;gridx=0;;gridy=2$$\n");
        sb.append("pc||Peso fetal provável (g);;t;;t||cdl@109@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(pelo D.B.P e C.A.)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("hs||0||||4;;gridx=3;;gridy=5;;weightx=1$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||;;f;;f||lbln@ D.B.P.@||3;;gridy=0;;gridx=0;;weightx=0$$\n");
        sb.append("pc||em mm  ;;t;;f||cdl@97@||3;;gridx=1$$\n");
        sb.append("pc||I.G.;;t;;f||cdl@437@||3;;gridx=2$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.O.F. (mm);;t;;f||cdl@114@||3;;gridx=3$$\n");
        sb.append("pc||Valor do C.A.;;t;;f||cdl@99@||3;;gridx=4$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.A.P. (mm);;t;;f||cdl@115@1||3;;gridx=5$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||D.L.L. (mm);;t;;f||cdl@116@1||3;;gridx=6$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||Resultados;;t;;t||subcont@4@||3;;gridx=3;;gridy=1;;gridwidth=4;;gridheight=8$$\n");
        sb.append("lbln||C.A.||||3;;gridx=0;;gridheight=1;;gridwidth=1;;left_insets=4;;top_insets=8$$\n");
        sb.append("cdl||100||1||3;;gridx=1$$\n");
        sb.append("cdl||101||1||3$$\n");
        sb.append("cdl||438||||3;;gridx=2$$\n");
        sb.append("lbln||C.F.||||3;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||104||||3;;gridx=1$$\n");
        sb.append("cdl||433||||3;;gridx=2$$\n");
        sb.append("lbln||Úmero||||3;;gridx=0;;gridy=3$$\n");
        sb.append("cdl||106||||3;;gridx=1$$\n");
        sb.append("cdl||434||||3;;gridx=2$$\n");
        sb.append("lbln||Ulna||||3;;gridx=0;;gridy=4$$\n");
        sb.append("cdl||107||||3;;gridx=1$$\n");
        sb.append("cdl||435||||3;;gridx=2$$\n");
        sb.append("lbln||Tíbia||||3;;gridx=0;;gridy=5$$\n");
        sb.append("cdl||108||||3;;gridx=1$$\n");
        sb.append("cdl||436||||3;;gridx=2$$\n");
        sb.append("hs||0||||3;;gridy=8$$\n");
        sb.append("hs||0||||3;;gridx=7;;gridy=9;;weightx=1;;left_insets=0;;top_insets=0$$\n");
        sb.append("pc||IGH pela biometria (baseado no percentil 50);;f;;t||subcont@3@||gridx=0;;gridy=2;;weightx=0;;gridwidth=3$$\n");

        sb.append("subpnl||||||->5$$\n");
        sb.append("pc||IGH     ;;f;;f||cdl@417@||5;;gridy=0;;gridx=0;;gridwidth=1$$\n");
        sb.append("pc||t;;f||lbl@Sem. @||5;;gridx=1$$\n");
        sb.append("pc||t;;f||cdl@420@||5;;gridx=2$$\n");
        sb.append("hs||30||||5$$\n");
        sb.append("pc||t;;f||lbl@Dias@||5;;gridx=3$$\n");
        sb.append("pc||Data do exame;;t;;f||cdl@13@||5;;gridx=4$$\n");
        sb.append("pc||Desvio padrão da I.G.;;t;;f||cdl@408@||5;;gridx=5$$\n");
        sb.append("hs||150||||5$$\n");
        sb.append("pc||± semana(s);;t;;f||cdl@423@||5;;gridx=6$$\n");
        sb.append("hs||0||||5;;gridx=7;;weightx=1$$\n");
        sb.append("pc||DPP;;t;;f||cdl@431@3||5;;gridx=8;;weightx=0$$\n");
        sb.append("hs||100||||5$$\n");
        sb.append("pc||IGH definida pelo examinador;;f;;t||subcont@5@||gridx=0;;gridy=4;;gridwidth=3$$\n");

        sb.append("vs||0||||gridx=3;;gridy=6;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

       //  </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto">

        sb.append("26;;Feto;;200;;4;;Dados da gestação$$\n");

        sb.append("pc||Situação;;f;;f||cdl@28@||gridx=0;;gridy=0$$\n");
        sb.append("hs||300||||$$\n");
        sb.append("pc||Apresentação;;t;;f||cdl@29@||gridx=1$$\n");
        sb.append("hs||175||||$$\n");
        sb.append("pc||Dorso;;t;;f||cdl@31@||gridx=2;;gridwidth=2$$\n");

        sb.append("pc||Movimentos fetais;;f;;t||cdl@32@||gridx=0;;gridy=1;;gridwidth=1$$\n");
        sb.append("pc||Movimentos respiratórios;;t;;t||cdl@34@||gridx=1$$\n");

        sb.append("pc||Batimentos cardíacos;;f;;t||cdl@36@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Ritmo;;t;;t||cdl@37@||gridx=1$$\n");
        sb.append("pc||Nº (bat/min);;t;;t||cdl@38@||gridx=2$$\n");
        sb.append("hs||80||||gridx=3$$\n");

        sb.append("hs||0||||gridx=4;;gridy=3;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos Internos">

        sb.append("26;;Órgãos internos;;300;;26;;Feto$$\n");
        sb.append("pc||Situação;;f;;f||cdl@40@||gridx=0;;gridy=0;;gridwidth=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@41@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||Estadiamento intestinal;;f;;t||cdl@59@||gridx=0;;gridy=2;;gridwidth=2$$\n");
        sb.append("pc||Gordura pré-peritonial;;t;;t||cdl@58@||gridx=2;;gridwidth=1$$\n");
        sb.append("pc||Sexo fetal;;t;;t||cdl@57@||gridx=3$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=5;;weightx=0$$\n");
        sb.append("vs||200||||gridx=5;;gridy=1;;weightx=1$$\n");
        sb.append("hs||150||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        sb.append("26;;Placenta;;300;;26;;Feto$$\n");
        sb.append("pc||Inserção 1;;f;;f||cdl@64@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Inserção 2;;t;;f||cdl@65@||gridx=1$$\n");
        sb.append("pc||Espessura (mm);;t;;f||cdl@66@||gridx=2$$\n");
        sb.append("pc||Maturidade;;t;;f||cdl@67@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@68@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=4;;gridy=2;;weightx=1;;weighty=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;gridy=1;;weightx=0;;weighty=0$$\n");
        sb.append("hs||180||||gridx=0;;gridy=0$$\n");
        sb.append("hs||220||||gridx=1$$\n");
        sb.append("hs||40||||gridx=2$$\n");
        sb.append("hs||110||||gridx=3$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        sb.append("26;;Outras informações;;300;;26;;Feto$$\n");
        sb.append("pc||Cordão umbilical;;f;;f||cdl@70@||gridx=0;;gridy=0$$\n");
        sb.append("hs||170||||$$\n");
        sb.append("pc||Líquido amniótico;;t;;f||cdl@72@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||200||||gridx=2$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||f;;t;;f||lbl@Medidas dos quadrantes (cm)@||1;;gridx=0;;gridy=0;;gridwidth=7$$\n");
        sb.append("pc||I;;t;;f||cdl@73@||1;;gridy=1;;gridwidth=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||II;;t;;f||cdl@74@||1;;gridx=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||III;;t;;f||cdl@75@||1;;gridx=2$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||IV;;t;;f||cdl@76@||1;;gridx=3$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||ILA (cm);;t;;f||cdl@78@||1;;gridx=4$$\n");
        sb.append("hs||70||||1$$\n");
        sb.append("pc||t;;f||cdl@79@||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||ILA (Índice do líquido amniótico);;f;;t||subcont@1@||weightx=0;;gridx=0;;gridwidth=3;;gridy=1$$\n");

        sb.append("hs||0||||gridx=3;;gridy=2;;weightx=1;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 1">

        sb.append("80;;Feto 1;;200;;4;;Dados da gestação$$\n");

        sb.append("pc||Situação;;f;;f||cdl@82@||gridx=0;;gridy=0$$\n");
        sb.append("hs||300||||$$\n");
        sb.append("pc||Apresentação;;t;;f||cdl@83@||gridx=1$$\n");
        sb.append("hs||175||||$$\n");
        sb.append("pc||Dorso;;t;;f||cdl@85@||gridx=2;;gridwidth=2$$\n");

        sb.append("pc||Movimentos fetais;;f;;t||cdl@86@||gridx=0;;gridy=1;;gridwidth=1$$\n");
        sb.append("pc||Movimentos respiratórios;;t;;t||cdl@88@||gridx=1$$\n");

        sb.append("pc||Batimentos cardíacos;;f;;t||cdl@90@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Ritmo;;t;;t||cdl@91@||gridx=1$$\n");
        sb.append("pc||Nº (bat/min);;t;;t||cdl@92@||gridx=2$$\n");
        sb.append("hs||80||||gridx=3$$\n");

        sb.append("hs||0||||gridx=4;;gridy=3;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos internos 1">

        sb.append("80;;Órgãos internos - Feto 1;;300;;80;;Feto 1$$\n");
        sb.append("pc||Situação;;f;;f||cdl@94@||gridx=0;;gridy=0;;gridwidth=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@95@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||Estadiamento intestinal;;f;;t||cdl@113@||gridx=0;;gridy=2;;gridwidth=2$$\n");
        sb.append("pc||Gordura pré-peritonial;;t;;t||cdl@112@||gridx=2;;gridwidth=1$$\n");
        sb.append("pc||Sexo fetal;;t;;t||cdl@111@||gridx=3$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=5;;weightx=0$$\n");
        sb.append("vs||170||||gridx=5;;gridy=1;;weightx=1$$\n");
        sb.append("hs||150||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta 1">

        sb.append("80;;Placenta - Feto 1 ;;300;;80;;Feto 1$$\n");
        sb.append("pc||Inserção 1;;f;;f||cdl@118@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Inserção 2;;t;;f||cdl@119@||gridx=1$$\n");
        sb.append("pc||Espessura (mm);;t;;f||cdl@120@||gridx=2$$\n");
        sb.append("pc||Maturidade;;t;;f||cdl@121@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@122@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=4;;gridy=2;;weightx=1;;weighty=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;gridy=1;;weightx=0;;weighty=0$$\n");
        sb.append("hs||180||||gridx=0;;gridy=0$$\n");
        sb.append("hs||220||||gridx=1$$\n");
        sb.append("hs||40||||gridx=2$$\n");
        sb.append("hs||110||||gridx=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações 1">

        sb.append("80;;Outras informações - Feto 1;;300;;80;;Feto 1$$\n");
        sb.append("pc||Cordão umbilical;;f;;f||cdl@124@||gridx=0;;gridy=0$$\n");
        sb.append("hs||170||||$$\n");
        sb.append("pc||Líquido amniótico;;t;;f||cdl@126@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||200||||gridx=2$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||f;;t;;f||lbl@Medidas dos quadrantes (cm)@||1;;gridx=0;;gridy=0;;gridwidth=7$$\n");
        sb.append("pc||I;;t;;f||cdl@127@||1;;gridy=1;;gridwidth=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||II;;t;;f||cdl@128@||1;;gridx=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||III;;t;;f||cdl@129@||1;;gridx=2$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||IV;;t;;f||cdl@130@||1;;gridx=3$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||ILA (cm);;t;;f||cdl@132@||1;;gridx=4$$\n");
        sb.append("hs||70||||1$$\n");
        sb.append("pc||t;;f||cdl@133@||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||ILA (Índice do líquido amniótico);;f;;t||subcont@1@||weightx=0;;gridx=0;;gridwidth=3;;gridy=1$$\n");

        sb.append("hs||0||||gridx=3;;gridy=2;;weightx=1;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 2">

        //  <editor-fold defaultstate="collapsed" desc="Biometria">

        sb.append("134;;Biometria - Feto 2;;300;;80;;Feto 1$$\n");

        sb.append("subpnl||||||->4$$\n");
        sb.append("pc||<html>&nbsp;I.C. <font color=\"0000ff\">(70 a 86)</html>"
                + ";;f;;f||cdl@152@||4;;gridx=0;;gridy=0$$\n");
        sb.append("pc||C.C. (mm);;t;;f||cdl@156@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;f||cdl@446@||4;;gridx=2$$\n");
        sb.append("pc||C.C./C.A.;;f;;t||cdl@157@||4;;gridy=1;;gridx=0$$\n");
        sb.append("pc||C.F./C.A. (Hadlock);;t;;t||cdl@159@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(20 a 24)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("pc||Estatura (cm)   ;;f;;t||cdl@164@||4;;gridx=0;;gridy=2$$\n");
        sb.append("pc||Peso fetal provável (g);;t;;t||cdl@163@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(pelo D.B.P e C.A.)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("hs||0||||4;;gridx=3;;gridy=3;;weightx=1$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||;;f;;f||lbln@ D.B.P.@||3;;gridy=0;;gridx=0;;weightx=0$$\n");
        sb.append("pc||em mm  ;;t;;f||cdl@151@||3;;gridx=1$$\n");
        sb.append("pc||I.G.;;t;;f||cdl@444@||3;;gridx=2$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.O.F. (mm);;t;;f||cdl@168@||3;;gridx=3$$\n");
        sb.append("pc||Valor do C.A.;;t;;f||cdl@153@||3;;gridx=4$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.A.P. (mm);;t;;f||cdl@169@1||3;;gridx=5$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||D.L.L. (mm);;t;;f||cdl@170@1||3;;gridx=6$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||Resultados;;t;;t||subcont@4@||3;;gridx=3;;gridy=1;;gridwidth=4;;gridheight=8$$\n");
        sb.append("lbln||C.A.||||3;;gridx=0;;gridheight=1;;gridwidth=1;;left_insets=4;;top_insets=8$$\n");
        sb.append("cdl||154||1||3;;gridx=1$$\n");
        sb.append("cdl||155||1||3$$\n");
        sb.append("cdl||445||||3;;gridx=2$$\n");
        sb.append("lbln||C.F.||||3;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||158||||3;;gridx=1$$\n");
        sb.append("cdl||440||||3;;gridx=2$$\n");
        sb.append("lbln||Úmero||||3;;gridx=0;;gridy=3$$\n");
        sb.append("cdl||160||||3;;gridx=1$$\n");
        sb.append("cdl||441||||3;;gridx=2$$\n");
        sb.append("lbln||Ulna||||3;;gridx=0;;gridy=4$$\n");
        sb.append("cdl||161||||3;;gridx=1$$\n");
        sb.append("cdl||442||||3;;gridx=2$$\n");
        sb.append("lbln||Tíbia||||3;;gridx=0;;gridy=5$$\n");
        sb.append("cdl||162||||3;;gridx=1$$\n");
        sb.append("cdl||443||||3;;gridx=2$$\n");
        sb.append("hs||0||||3;;gridy=8$$\n");
        sb.append("hs||0||||3;;gridx=7;;gridy=9;;weightx=1;;left_insets=0;;top_insets=0$$\n");
        sb.append("pc||Biometria;;f;;f||subcont@3@||gridx=0;;gridy=0;;weightx=0$$\n");

        sb.append("hs||0||||gridy=1;;gridx=1;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

       //  </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto">

        sb.append("134;;Feto 2;;300;;134;;Feto 2$$\n");

        sb.append("pc||Situação;;f;;f||cdl@136@||gridx=0;;gridy=0$$\n");
        sb.append("hs||300||||$$\n");
        sb.append("pc||Apresentação;;t;;f||cdl@137@||gridx=1$$\n");
        sb.append("hs||175||||$$\n");
        sb.append("pc||Dorso;;t;;f||cdl@139@||gridx=2;;gridwidth=2$$\n");

        sb.append("pc||Movimentos fetais;;f;;t||cdl@140@||gridx=0;;gridy=1;;gridwidth=1$$\n");
        sb.append("pc||Movimentos respiratórios;;t;;t||cdl@142@||gridx=1$$\n");

        sb.append("pc||Batimentos cardíacos;;f;;t||cdl@144@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Ritmo;;t;;t||cdl@145@||gridx=1$$\n");
        sb.append("pc||Nº (bat/min);;t;;t||cdl@146@||gridx=2$$\n");
        sb.append("hs||80||||gridx=3$$\n");

        sb.append("hs||0||||gridx=4;;gridy=3;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos Internos">

        sb.append("134;;Órgãos internos - Feto 2;;300;;134;;Feto 2$$\n");
        sb.append("pc||Situação;;f;;f||cdl@148@||gridx=0;;gridy=0;;gridwidth=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@149@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||Estadiamento intestinal;;f;;t||cdl@167@||gridx=0;;gridy=2;;gridwidth=2$$\n");
        sb.append("pc||Gordura pré-peritonial;;t;;t||cdl@166@||gridx=2;;gridwidth=1$$\n");
        sb.append("pc||Sexo fetal;;t;;t||cdl@165@||gridx=3$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=5;;weightx=0$$\n");
        sb.append("vs||200||||gridx=5;;gridy=1;;weightx=1$$\n");
        sb.append("hs||150||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        sb.append("134;;Placenta - Feto 2;;300;;134;;Feto 2$$\n");
        sb.append("pc||Inserção 1;;f;;f||cdl@172@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Inserção 2;;t;;f||cdl@173@||gridx=1$$\n");
        sb.append("pc||Espessura (mm);;t;;f||cdl@174@||gridx=2$$\n");
        sb.append("pc||Maturidade;;t;;f||cdl@175@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@176@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=4;;gridy=2;;weightx=1;;weighty=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;gridy=1;;weightx=0;;weighty=0$$\n");
        sb.append("hs||180||||gridx=0;;gridy=0$$\n");
        sb.append("hs||220||||gridx=1$$\n");
        sb.append("hs||40||||gridx=2$$\n");
        sb.append("hs||110||||gridx=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        sb.append("134;;Outras informações - Feto 2;;300;;134;;Feto 2$$\n");
        sb.append("pc||Cordão umbilical;;f;;f||cdl@178@||gridx=0;;gridy=0$$\n");
        sb.append("hs||170||||$$\n");
        sb.append("pc||Líquido amniótico;;t;;f||cdl@180@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");

        sb.append("hs||200||||gridx=2$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||f;;t;;f||lbl@Medidas dos quadrantes (cm)@||1;;gridx=0;;gridy=0;;gridwidth=7$$\n");
        sb.append("pc||I;;t;;f||cdl@181@||1;;gridy=1;;gridwidth=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||II;;t;;f||cdl@182@||1;;gridx=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||III;;t;;f||cdl@183@||1;;gridx=2$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||IV;;t;;f||cdl@184@||1;;gridx=3$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||ILA (cm);;t;;f||cdl@186@||1;;gridx=4$$\n");
        sb.append("hs||70||||1$$\n");
        sb.append("pc||t;;f||cdl@187@||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||ILA (Índice do líquido amniótico);;f;;t||subcont@1@||weightx=0;;gridx=0;;gridwidth=3;;gridy=1$$\n");

        sb.append("hs||0||||gridx=3;;gridy=2;;weightx=1;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 3">

        //  <editor-fold defaultstate="collapsed" desc="Biometria">

        sb.append("188;;Biometria - Feto 3;;300;;134;;Feto 2$$\n");

        sb.append("subpnl||||||->4$$\n");
        sb.append("pc||<html>&nbsp;I.C. <font color=\"0000ff\">(70 a 86)</html>"
                + ";;f;;f||cdl@206@||4;;gridx=0;;gridy=0$$\n");
        sb.append("pc||C.C. (mm);;t;;f||cdl@210@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;f||cdl@453@||4;;gridx=2$$\n");
        sb.append("pc||C.C./C.A.;;f;;t||cdl@211@||4;;gridy=1;;gridx=0$$\n");
        sb.append("pc||C.F./C.A. (Hadlock);;t;;t||cdl@213@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(20 a 24)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("pc||Estatura (cm)   ;;f;;t||cdl@218@||4;;gridx=0;;gridy=2$$\n");
        sb.append("pc||Peso fetal provável (g);;t;;t||cdl@217@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(pelo D.B.P e C.A.)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("hs||0||||4;;gridx=3;;gridy=3;;weightx=1$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||;;f;;f||lbln@ D.B.P.@||3;;gridy=0;;gridx=0;;weightx=0$$\n");
        sb.append("pc||em mm  ;;t;;f||cdl@205@||3;;gridx=1$$\n");
        sb.append("pc||I.G.;;t;;f||cdl@451@||3;;gridx=2$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.O.F. (mm);;t;;f||cdl@222@||3;;gridx=3$$\n");
        sb.append("pc||Valor do C.A.;;t;;f||cdl@207@||3;;gridx=4$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.A.P. (mm);;t;;f||cdl@223@1||3;;gridx=5$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||D.L.L. (mm);;t;;f||cdl@224@1||3;;gridx=6$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||Resultados;;t;;t||subcont@4@||3;;gridx=3;;gridy=1;;gridwidth=4;;gridheight=8$$\n");
        sb.append("lbln||C.A.||||3;;gridx=0;;gridheight=1;;gridwidth=1;;left_insets=4;;top_insets=8$$\n");
        sb.append("cdl||208||1||3;;gridx=1$$\n");
        sb.append("cdl||209||1||3$$\n");
        sb.append("cdl||452||||3;;gridx=2$$\n");
        sb.append("lbln||C.F.||||3;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||212||||3;;gridx=1$$\n");
        sb.append("cdl||447||||3;;gridx=2$$\n");
        sb.append("lbln||Úmero||||3;;gridx=0;;gridy=3$$\n");
        sb.append("cdl||214||||3;;gridx=1$$\n");
        sb.append("cdl||448||||3;;gridx=2$$\n");
        sb.append("lbln||Ulna||||3;;gridx=0;;gridy=4$$\n");
        sb.append("cdl||215||||3;;gridx=1$$\n");
        sb.append("cdl||449||||3;;gridx=2$$\n");
        sb.append("lbln||Tíbia||||3;;gridx=0;;gridy=5$$\n");
        sb.append("cdl||216||||3;;gridx=1$$\n");
        sb.append("cdl||450||||3;;gridx=2$$\n");
        sb.append("hs||0||||3;;gridy=8$$\n");
        sb.append("hs||0||||3;;gridx=7;;gridy=9;;weightx=1;;left_insets=0;;top_insets=0$$\n");
        sb.append("pc||Biometria;;f;;f||subcont@3@||gridx=0;;gridy=0;;weightx=0$$\n");

        sb.append("hs||0||||gridy=1;;gridx=1;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

       //  </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto">

        sb.append("188;;Feto 3;;300;;188;;Feto 3$$\n");

        sb.append("pc||Situação;;f;;f||cdl@190@||gridx=0;;gridy=0$$\n");
        sb.append("hs||300||||$$\n");
        sb.append("pc||Apresentação;;t;;f||cdl@191@||gridx=1$$\n");
        sb.append("hs||175||||$$\n");
        sb.append("pc||Dorso;;t;;f||cdl@193@||gridx=2;;gridwidth=2$$\n");

        sb.append("pc||Movimentos fetais;;f;;t||cdl@194@||gridx=0;;gridy=1;;gridwidth=1$$\n");
        sb.append("pc||Movimentos respiratórios;;t;;t||cdl@196@||gridx=1$$\n");

        sb.append("pc||Batimentos cardíacos;;f;;t||cdl@198@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Ritmo;;t;;t||cdl@199@||gridx=1$$\n");
        sb.append("pc||Nº (bat/min);;t;;t||cdl@200@||gridx=2$$\n");
        sb.append("hs||80||||gridx=3$$\n");

        sb.append("hs||0||||gridx=4;;gridy=3;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos Internos">

        sb.append("188;;Órgãos internos - Feto 3;;300;;188;;Feto 3$$\n");
        sb.append("pc||Situação;;f;;f||cdl@202@||gridx=0;;gridy=0;;gridwidth=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@203@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||Estadiamento intestinal;;f;;t||cdl@221@||gridx=0;;gridy=2;;gridwidth=2$$\n");
        sb.append("pc||Gordura pré-peritonial;;t;;t||cdl@220@||gridx=2;;gridwidth=1$$\n");
        sb.append("pc||Sexo fetal;;t;;t||cdl@219@||gridx=3$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=5;;weightx=0$$\n");
        sb.append("vs||200||||gridx=5;;gridy=1;;weightx=1$$\n");
        sb.append("hs||150||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        sb.append("188;;Placenta - Feto 3;;300;;188;;Feto 3$$\n");
        sb.append("pc||Inserção 1;;f;;f||cdl@226@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Inserção 2;;t;;f||cdl@227@||gridx=1$$\n");
        sb.append("pc||Espessura (mm);;t;;f||cdl@228@||gridx=2$$\n");
        sb.append("pc||Maturidade;;t;;f||cdl@229@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@230@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=4;;gridy=2;;weightx=1;;weighty=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;gridy=1;;weightx=0;;weighty=0$$\n");
        sb.append("hs||180||||gridx=0;;gridy=0$$\n");
        sb.append("hs||220||||gridx=1$$\n");
        sb.append("hs||40||||gridx=2$$\n");
        sb.append("hs||110||||gridx=3$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        sb.append("188;;Outras informações - Feto 3;;300;;188;;Feto 3$$\n");
        sb.append("pc||Cordão umbilical;;f;;f||cdl@232@||gridx=0;;gridy=0$$\n");
        sb.append("hs||170||||$$\n");
        sb.append("pc||Líquido amniótico;;t;;f||cdl@234@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||200||||gridx=2$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||f;;t;;f||lbl@Medidas dos quadrantes (cm)@||1;;gridx=0;;gridy=0;;gridwidth=7$$\n");
        sb.append("pc||I;;t;;f||cdl@235@||1;;gridy=1;;gridwidth=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||II;;t;;f||cdl@236@||1;;gridx=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||III;;t;;f||cdl@237@||1;;gridx=2$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||IV;;t;;f||cdl@238@||1;;gridx=3$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||ILA (cm);;t;;f||cdl@240@||1;;gridx=4$$\n");
        sb.append("hs||70||||1$$\n");
        sb.append("pc||t;;f||cdl@241@||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||ILA (Índice do líquido amniótico);;f;;t||subcont@1@||weightx=0;;gridx=0;;gridwidth=3;;gridy=1$$\n");

        sb.append("hs||0||||gridx=3;;gridy=2;;weightx=1;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 4">

        //  <editor-fold defaultstate="collapsed" desc="Biometria">

        sb.append("242;;Biometria - Feto 4;;300;;188;;Feto 3$$\n");

        sb.append("subpnl||||||->4$$\n");
        sb.append("pc||<html>&nbsp;I.C. <font color=\"0000ff\">(70 a 86)</html>"
                + ";;f;;f||cdl@260@||4;;gridx=0;;gridy=0$$\n");
        sb.append("pc||C.C. (mm);;t;;f||cdl@264@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;f||cdl@460@||4;;gridx=2$$\n");
        sb.append("pc||C.C./C.A.;;f;;t||cdl@265@||4;;gridy=1;;gridx=0$$\n");
        sb.append("pc||C.F./C.A. (Hadlock);;t;;t||cdl@267@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(20 a 24)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("pc||Estatura (cm)   ;;f;;t||cdl@272@||4;;gridx=0;;gridy=2$$\n");
        sb.append("pc||Peso fetal provável (g);;t;;t||cdl@271@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(pelo D.B.P e C.A.)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("hs||0||||4;;gridx=3;;gridy=3;;weightx=1$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||;;f;;f||lbln@ D.B.P.@||3;;gridy=0;;gridx=0;;weightx=0$$\n");
        sb.append("pc||em mm  ;;t;;f||cdl@259@||3;;gridx=1$$\n");
        sb.append("pc||I.G.;;t;;f||cdl@458@||3;;gridx=2$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.O.F. (mm);;t;;f||cdl@276@||3;;gridx=3$$\n");
        sb.append("pc||Valor do C.A.;;t;;f||cdl@261@||3;;gridx=4$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.A.P. (mm);;t;;f||cdl@277@1||3;;gridx=5$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||D.L.L. (mm);;t;;f||cdl@278@1||3;;gridx=6$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||Resultados;;t;;t||subcont@4@||3;;gridx=3;;gridy=1;;gridwidth=4;;gridheight=8$$\n");
        sb.append("lbln||C.A.||||3;;gridx=0;;gridheight=1;;gridwidth=1;;left_insets=4;;top_insets=8$$\n");
        sb.append("cdl||262||1||3;;gridx=1$$\n");
        sb.append("cdl||263||1||3$$\n");
        sb.append("cdl||459||||3;;gridx=2$$\n");
        sb.append("lbln||C.F.||||3;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||266||||3;;gridx=1$$\n");
        sb.append("cdl||454||||3;;gridx=2$$\n");
        sb.append("lbln||Úmero||||3;;gridx=0;;gridy=3$$\n");
        sb.append("cdl||268||||3;;gridx=1$$\n");
        sb.append("cdl||455||||3;;gridx=2$$\n");
        sb.append("lbln||Ulna||||3;;gridx=0;;gridy=4$$\n");
        sb.append("cdl||269||||3;;gridx=1$$\n");
        sb.append("cdl||456||||3;;gridx=2$$\n");
        sb.append("lbln||Tíbia||||3;;gridx=0;;gridy=5$$\n");
        sb.append("cdl||270||||3;;gridx=1$$\n");
        sb.append("cdl||457||||3;;gridx=2$$\n");
        sb.append("hs||0||||3;;gridy=8$$\n");
        sb.append("hs||0||||3;;gridx=7;;gridy=9;;weightx=1;;left_insets=0;;top_insets=0$$\n");
        sb.append("pc||Biometria;;f;;f||subcont@3@||gridx=0;;gridy=0;;weightx=0$$\n");

        sb.append("hs||0||||gridy=1;;gridx=1;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

       //  </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto">

        sb.append("242;;Feto 4;;300;;242;;Feto 4$$\n");

        sb.append("pc||Situação;;f;;f||cdl@244@||gridx=0;;gridy=0$$\n");
        sb.append("hs||300||||$$\n");
        sb.append("pc||Apresentação;;t;;f||cdl@245@||gridx=1$$\n");
        sb.append("hs||175||||$$\n");
        sb.append("pc||Dorso;;t;;f||cdl@247@||gridx=2;;gridwidth=2$$\n");

        sb.append("pc||Movimentos fetais;;f;;t||cdl@248@||gridx=0;;gridy=1;;gridwidth=1$$\n");
        sb.append("pc||Movimentos respiratórios;;t;;t||cdl@250@||gridx=1$$\n");

        sb.append("pc||Batimentos cardíacos;;f;;t||cdl@252@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Ritmo;;t;;t||cdl@253@||gridx=1$$\n");
        sb.append("pc||Nº (bat/min);;t;;t||cdl@254@||gridx=2$$\n");
        sb.append("hs||80||||gridx=3$$\n");

        sb.append("hs||0||||gridx=4;;gridy=3;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos Internos">

        sb.append("242;;Órgãos internos - Feto 4;;300;;242;;Feto 4$$\n");
        sb.append("pc||Situação;;f;;f||cdl@256@||gridx=0;;gridy=0;;gridwidth=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@257@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||Estadiamento intestinal;;f;;t||cdl@275@||gridx=0;;gridy=2;;gridwidth=2$$\n");
        sb.append("pc||Gordura pré-peritonial;;t;;t||cdl@274@||gridx=2;;gridwidth=1$$\n");
        sb.append("pc||Sexo fetal;;t;;t||cdl@273@||gridx=3$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=5;;weightx=0$$\n");
        sb.append("vs||200||||gridx=5;;gridy=1;;weightx=1$$\n");
        sb.append("hs||150||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        sb.append("242;;Placenta - Feto 4;;300;;242;;Feto 4$$\n");
        sb.append("pc||Inserção 1;;f;;f||cdl@280@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Inserção 2;;t;;f||cdl@281@||gridx=1$$\n");
        sb.append("pc||Espessura (mm);;t;;f||cdl@282@||gridx=2$$\n");
        sb.append("pc||Maturidade;;t;;f||cdl@283@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@284@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=4;;gridy=2;;weightx=1;;weighty=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;gridy=1;;weightx=0;;weighty=0$$\n");
        sb.append("hs||180||||gridx=0;;gridy=0$$\n");
        sb.append("hs||220||||gridx=1$$\n");
        sb.append("hs||40||||gridx=2$$\n");
        sb.append("hs||110||||gridx=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        sb.append("242;;Outras informações - Feto 4;;300;;242;;Feto 4$$\n");
        sb.append("pc||Cordão umbilical;;f;;f||cdl@286@||gridx=0;;gridy=0$$\n");
        sb.append("hs||170||||$$\n");
        sb.append("pc||Líquido amniótico;;t;;f||cdl@288@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||200||||gridx=2$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||f;;t;;f||lbl@Medidas dos quadrantes (cm)@||1;;gridx=0;;gridy=0;;gridwidth=7$$\n");
        sb.append("pc||I;;t;;f||cdl@289@||1;;gridy=1;;gridwidth=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||II;;t;;f||cdl@290@||1;;gridx=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||III;;t;;f||cdl@291@||1;;gridx=2$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||IV;;t;;f||cdl@292@||1;;gridx=3$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||ILA (cm);;t;;f||cdl@294@||1;;gridx=4$$\n");
        sb.append("hs||70||||1$$\n");
        sb.append("pc||t;;f||cdl@295@||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||ILA (Índice do líquido amniótico);;f;;t||subcont@1@||weightx=0;;gridx=0;;gridwidth=3;;gridy=1$$\n");

        sb.append("hs||0||||gridx=3;;gridy=2;;weightx=1;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 5">

        //  <editor-fold defaultstate="collapsed" desc="Biometria">

        sb.append("296;;Biometria - Feto 5;;300;;242;;Feto 4$$\n");

        sb.append("subpnl||||||->4$$\n");
        sb.append("pc||<html>&nbsp;I.C. <font color=\"0000ff\">(70 a 86)</html>"
                + ";;f;;f||cdl@314@||4;;gridx=0;;gridy=0$$\n");
        sb.append("pc||C.C. (mm);;t;;f||cdl@318@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;f||cdl@467@||4;;gridx=2$$\n");
        sb.append("pc||C.C./C.A.;;f;;t||cdl@319@||4;;gridy=1;;gridx=0$$\n");
        sb.append("pc||C.F./C.A. (Hadlock);;t;;t||cdl@321@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(20 a 24)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("pc||Estatura (cm)   ;;f;;t||cdl@326@||4;;gridx=0;;gridy=2$$\n");
        sb.append("pc||Peso fetal provável (g);;t;;t||cdl@325@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(pelo D.B.P e C.A.)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("hs||0||||4;;gridx=3;;gridy=3;;weightx=1$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||;;f;;f||lbln@ D.B.P.@||3;;gridy=0;;gridx=0;;weightx=0$$\n");
        sb.append("pc||em mm  ;;t;;f||cdl@313@||3;;gridx=1$$\n");
        sb.append("pc||I.G.;;t;;f||cdl@465@||3;;gridx=2$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.O.F. (mm);;t;;f||cdl@330@||3;;gridx=3$$\n");
        sb.append("pc||Valor do C.A.;;t;;f||cdl@315@||3;;gridx=4$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.A.P. (mm);;t;;f||cdl@331@1||3;;gridx=5$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||D.L.L. (mm);;t;;f||cdl@332@1||3;;gridx=6$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||Resultados;;t;;t||subcont@4@||3;;gridx=3;;gridy=1;;gridwidth=4;;gridheight=8$$\n");
        sb.append("lbln||C.A.||||3;;gridx=0;;gridheight=1;;gridwidth=1;;left_insets=4;;top_insets=8$$\n");
        sb.append("cdl||316||1||3;;gridx=1$$\n");
        sb.append("cdl||317||1||3$$\n");
        sb.append("cdl||466||||3;;gridx=2$$\n");
        sb.append("lbln||C.F.||||3;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||320||||3;;gridx=1$$\n");
        sb.append("cdl||461||||3;;gridx=2$$\n");
        sb.append("lbln||Úmero||||3;;gridx=0;;gridy=3$$\n");
        sb.append("cdl||322||||3;;gridx=1$$\n");
        sb.append("cdl||462||||3;;gridx=2$$\n");
        sb.append("lbln||Ulna||||3;;gridx=0;;gridy=4$$\n");
        sb.append("cdl||323||||3;;gridx=1$$\n");
        sb.append("cdl||463||||3;;gridx=2$$\n");
        sb.append("lbln||Tíbia||||3;;gridx=0;;gridy=5$$\n");
        sb.append("cdl||324||||3;;gridx=1$$\n");
        sb.append("cdl||464||||3;;gridx=2$$\n");
        sb.append("hs||0||||3;;gridy=8$$\n");
        sb.append("hs||0||||3;;gridx=7;;gridy=9;;weightx=1;;left_insets=0;;top_insets=0$$\n");
        sb.append("pc||Biometria;;f;;f||subcont@3@||gridx=0;;gridy=0;;weightx=0$$\n");

        sb.append("hs||0||||gridy=1;;gridx=1;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

       //  </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto">

        sb.append("296;;Feto 5;;300;;296;;Feto 5$$\n");

        sb.append("pc||Situação;;f;;f||cdl@298@||gridx=0;;gridy=0$$\n");
        sb.append("hs||300||||$$\n");
        sb.append("pc||Apresentação;;t;;f||cdl@299@||gridx=1$$\n");
        sb.append("hs||175||||$$\n");
        sb.append("pc||Dorso;;t;;f||cdl@301@||gridx=2;;gridwidth=2$$\n");

        sb.append("pc||Movimentos fetais;;f;;t||cdl@302@||gridx=0;;gridy=1;;gridwidth=1$$\n");
        sb.append("pc||Movimentos respiratórios;;t;;t||cdl@304@||gridx=1$$\n");

        sb.append("pc||Batimentos cardíacos;;f;;t||cdl@306@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Ritmo;;t;;t||cdl@307@||gridx=1$$\n");
        sb.append("pc||Nº (bat/min);;t;;t||cdl@308@||gridx=2$$\n");
        sb.append("hs||80||||gridx=3$$\n");

        sb.append("hs||0||||gridx=4;;gridy=3;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos Internos">

        sb.append("296;;Órgãos internos - Feto 5;;300;;296;;Feto 5$$\n");
        sb.append("pc||Situação;;f;;f||cdl@310@||gridx=0;;gridy=0;;gridwidth=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@311@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||Estadiamento intestinal;;f;;t||cdl@329@||gridx=0;;gridy=2;;gridwidth=2$$\n");
        sb.append("pc||Gordura pré-peritonial;;t;;t||cdl@328@||gridx=2;;gridwidth=1$$\n");
        sb.append("pc||Sexo fetal;;t;;t||cdl@327@||gridx=3$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=5;;weightx=0$$\n");
        sb.append("vs||200||||gridx=5;;gridy=1;;weightx=1$$\n");
        sb.append("hs||150||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        //   <editor-fold defaultstate="collapsed" desc="Placenta">

        sb.append("296;;Placenta - Feto 5;;300;;296;;Feto 5$$\n");
        sb.append("pc||Inserção 1;;f;;f||cdl@334@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Inserção 2;;t;;f||cdl@335@||gridx=1$$\n");
        sb.append("pc||Espessura (mm);;t;;f||cdl@336@||gridx=2$$\n");
        sb.append("pc||Maturidade;;t;;f||cdl@337@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@338@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=4;;gridy=2;;weightx=1;;weighty=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;gridy=1;;weightx=0;;weighty=0$$\n");
        sb.append("hs||180||||gridx=0;;gridy=0$$\n");
        sb.append("hs||220||||gridx=1$$\n");
        sb.append("hs||40||||gridx=2$$\n");
        sb.append("hs||110||||gridx=3$$\n");

        sb.append("\n##\n");

        //  </editor-fold>

        //  <editor-fold defaultstate="collapsed" desc="Outras informações">

        sb.append("296;;Outras informações - Feto 5;;300;;296;;Feto 5$$\n");
        sb.append("pc||Cordão umbilical;;f;;f||cdl@340@||gridx=0;;gridy=0$$\n");
        sb.append("hs||170||||$$\n");
        sb.append("pc||Líquido amniótico;;t;;f||cdl@342@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||200||||gridx=2$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||f;;t;;f||lbl@Medidas dos quadrantes (cm)@||1;;gridx=0;;gridy=0;;gridwidth=7$$\n");
        sb.append("pc||I;;t;;f||cdl@343@||1;;gridy=1;;gridwidth=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||II;;t;;f||cdl@344@||1;;gridx=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||III;;t;;f||cdl@345@||1;;gridx=2$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||IV;;t;;f||cdl@346@||1;;gridx=3$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||ILA (cm);;t;;f||cdl@348@||1;;gridx=4$$\n");
        sb.append("hs||70||||1$$\n");
        sb.append("pc||t;;f||cdl@349@||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||ILA (Índice do líquido amniótico);;f;;t||subcont@1@||weightx=0;;gridx=0;;gridwidth=3;;gridy=1$$\n");

        sb.append("hs||0||||gridx=3;;gridy=2;;weightx=1;;weighty=1$$\n");

        sb.append("\n##\n");

       //  </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 6">

        //  <editor-fold defaultstate="collapsed" desc="Biometria">

        sb.append("350;;Biometria - Feto 6;;300;;296;;Feto 5$$\n");

        sb.append("subpnl||||||->4$$\n");
        sb.append("pc||<html>&nbsp;I.C. <font color=\"0000ff\">(70 a 86)</html>"
                + ";;f;;f||cdl@368@||4;;gridx=0;;gridy=0$$\n");
        sb.append("pc||C.C. (mm);;t;;f||cdl@372@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;f||cdl@474@||4;;gridx=2$$\n");
        sb.append("pc||C.C./C.A.;;f;;t||cdl@373@||4;;gridy=1;;gridx=0$$\n");
        sb.append("pc||C.F./C.A. (Hadlock);;t;;t||cdl@375@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(20 a 24)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("pc||Estatura (cm)   ;;f;;t||cdl@380@||4;;gridx=0;;gridy=2$$\n");
        sb.append("pc||Peso fetal provável (g);;t;;t||cdl@379@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(pelo D.B.P e C.A.)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("hs||0||||4;;gridx=3;;gridy=3;;weightx=1$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||;;f;;f||lbln@ D.B.P.@||3;;gridy=0;;gridx=0;;weightx=0$$\n");
        sb.append("pc||em mm  ;;t;;f||cdl@367@||3;;gridx=1$$\n");
        sb.append("pc||I.G.;;t;;f||cdl@472@||3;;gridx=2$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.O.F. (mm);;t;;f||cdl@384@||3;;gridx=3$$\n");
        sb.append("pc||Valor do C.A.;;t;;f||cdl@369@||3;;gridx=4$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.A.P. (mm);;t;;f||cdl@385@1||3;;gridx=5$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||D.L.L. (mm);;t;;f||cdl@386@1||3;;gridx=6$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||Resultados;;t;;t||subcont@4@||3;;gridx=3;;gridy=1;;gridwidth=4;;gridheight=8$$\n");
        sb.append("lbln||C.A.||||3;;gridx=0;;gridheight=1;;gridwidth=1;;left_insets=4;;top_insets=8$$\n");
        sb.append("cdl||370||1||3;;gridx=1$$\n");
        sb.append("cdl||371||1||3$$\n");
        sb.append("cdl||473||||3;;gridx=2$$\n");
        sb.append("lbln||C.F.||||3;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||374||||3;;gridx=1$$\n");
        sb.append("cdl||468||||3;;gridx=2$$\n");
        sb.append("lbln||Úmero||||3;;gridx=0;;gridy=3$$\n");
        sb.append("cdl||376||||3;;gridx=1$$\n");
        sb.append("cdl||469||||3;;gridx=2$$\n");
        sb.append("lbln||Ulna||||3;;gridx=0;;gridy=4$$\n");
        sb.append("cdl||377||||3;;gridx=1$$\n");
        sb.append("cdl||470||||3;;gridx=2$$\n");
        sb.append("lbln||Tíbia||||3;;gridx=0;;gridy=5$$\n");
        sb.append("cdl||378||||3;;gridx=1$$\n");
        sb.append("cdl||471||||3;;gridx=2$$\n");
        sb.append("hs||0||||3;;gridy=8$$\n");
        sb.append("hs||0||||3;;gridx=7;;gridy=9;;weightx=1;;left_insets=0;;top_insets=0$$\n");
        sb.append("pc||Biometria;;f;;f||subcont@3@||gridx=0;;gridy=0;;weightx=0$$\n");

        sb.append("hs||0||||gridy=1;;gridx=1;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

       //  </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto">

        sb.append("350;;Feto 6;;300;;350;;Feto 6$$\n");

        sb.append("pc||Situação;;f;;f||cdl@352@||gridx=0;;gridy=0$$\n");
        sb.append("hs||300||||$$\n");
        sb.append("pc||Apresentação;;t;;f||cdl@353@||gridx=1$$\n");
        sb.append("hs||175||||$$\n");
        sb.append("pc||Dorso;;t;;f||cdl@355@||gridx=2;;gridwidth=2$$\n");

        sb.append("pc||Movimentos fetais;;f;;t||cdl@356@||gridx=0;;gridy=1;;gridwidth=1$$\n");
        sb.append("pc||Movimentos respiratórios;;t;;t||cdl@358@||gridx=1$$\n");

        sb.append("pc||Batimentos cardíacos;;f;;t||cdl@360@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Ritmo;;t;;t||cdl@361@||gridx=1$$\n");
        sb.append("pc||Nº (bat/min);;t;;t||cdl@362@||gridx=2$$\n");
        sb.append("hs||80||||gridx=3$$\n");

        sb.append("hs||0||||gridx=4;;gridy=3;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos Internos">

        sb.append("350;;Órgãos internos - Feto 6;;300;;350;;Feto 6$$\n");
        sb.append("pc||Situação;;f;;f||cdl@364@||gridx=0;;gridy=0;;gridwidth=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@365@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||Estadiamento intestinal;;f;;t||cdl@383@||gridx=0;;gridy=2;;gridwidth=2$$\n");
        sb.append("pc||Gordura pré-peritonial;;t;;t||cdl@382@||gridx=2;;gridwidth=1$$\n");
        sb.append("pc||Sexo fetal;;t;;t||cdl@381@||gridx=3$$\n");
        sb.append("pc||t;;t||lbl@@||gridx=5;;weightx=0$$\n");
        sb.append("vs||200||||gridx=5;;gridy=1;;weightx=1$$\n");
        sb.append("hs||150||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        sb.append("350;;Placenta - Feto 6;;300;;350;;Feto 6$$\n");
        sb.append("pc||Inserção 1;;f;;f||cdl@388@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Inserção 2;;t;;f||cdl@389@||gridx=1$$\n");
        sb.append("pc||Espessura (mm);;t;;f||cdl@390@||gridx=2$$\n");
        sb.append("pc||Maturidade;;t;;f||cdl@391@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@392@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=4;;gridy=2;;weightx=1;;weighty=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;gridy=1;;weightx=0;;weighty=0$$\n");
        sb.append("hs||180||||gridx=0;;gridy=0$$\n");
        sb.append("hs||220||||gridx=1$$\n");
        sb.append("hs||40||||gridx=2$$\n");
        sb.append("hs||110||||gridx=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        sb.append("350;;Outras informações - Feto 6;;300;;350;;Feto 6$$\n");
        sb.append("pc||Cordão umbilical;;f;;f||cdl@394@||gridx=0;;gridy=0$$\n");
        sb.append("hs||170||||$$\n");
        sb.append("pc||Líquido amniótico;;t;;f||cdl@396@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||200||||gridx=2$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||f;;t;;f||lbl@Medidas dos quadrantes (cm)@||1;;gridx=0;;gridy=0;;gridwidth=7$$\n");
        sb.append("pc||I;;t;;f||cdl@397@||1;;gridy=1;;gridwidth=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||II;;t;;f||cdl@398@||1;;gridx=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||III;;t;;f||cdl@399@||1;;gridx=2$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||IV;;t;;f||cdl@400@||1;;gridx=3$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||ILA (cm);;t;;f||cdl@402@||1;;gridx=4$$\n");
        sb.append("hs||70||||1$$\n");
        sb.append("pc||t;;f||cdl@403@||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||ILA (Índice do líquido amniótico);;f;;t||subcont@1@||weightx=0;;gridx=0;;gridwidth=3;;gridy=1$$\n");

        sb.append("hs||0||||gridx=3;;gridy=2;;weightx=1;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("404;;Observações gerais;;300;;350;;Feto 6$$\n");
        sb.append("cdl||406||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        //    </editor-fold>

        //  <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("411;;Impressão diagnóstica;;200;;404;;Observações gerais$$\n");
        sb.append("cdl||427||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||425||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        //cid 10
        sb.append("\n411\n");
        // </editor-fold>

        alterarVisaoDeLaudo(24);

    }

    public static void main (String[] args) throws Exception
    {
        obstetrico1Trimestre();
        obstetrico14Semanas();
    }

}
