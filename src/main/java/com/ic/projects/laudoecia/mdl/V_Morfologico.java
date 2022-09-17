/*
 * V_Morfologico.java
 *
 * Created on 26/10/2012, 10:42:09
 */

package com.ic.projects.laudoecia.mdl;

/**
 *
 * @author Tekna <informatica@teknamed.com.br>
 */
public class V_Morfologico extends View
{

    static void morfologicoFetal() throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento">

        sb.append("0;;Dados do equipamento$$\n");
        sb.append("pc||Tipo;;f;;f||cdl@2@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@3@||gridwidth=2;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");

        sb.append("hs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        //  <editor-fold defaultstate="collapsed" desc="IGH e biometria">

        sb.append("1;;IGH e biometria$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||DUM;;f;;f||cdl@5@||1;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IGH;;t;;f||cdl@153@||1;;gridx=1$$\n");
        sb.append("pc||t;;f||lbl@Sem.@||1;;gridx=2$$\n");
        sb.append("pc||t;;f||cdl@154@||1;;gridx=3$$\n");
        sb.append("pc||t;;f||lbl@Dias@||1;;gridx=4$$\n");
        sb.append("pc||t;;f||lbl@@||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||DPP;;t;;f||cdl@6@3||1;;gridx=6;;weightx=0$$\n");
        sb.append("hs||100||||1;;gridy=1;;gridx=0$$\n");
        sb.append("hs||50||||1;;gridx=1;;$$\n");
        sb.append("hs||30||||1;;gridx=2;;$$\n");
        sb.append("hs||50||||1;;gridx=3;;$$\n");
        sb.append("hs||30||||1;;gridx=4;;$$\n");
        sb.append("hs||100||||1;;gridx=6;;$$\n");
        sb.append("pc||IGH pela amenorréia;;f;;f||subcont@1@||gridx=0;;gridy=0;;weightx=0;;gridwidth=3$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Data;;f;;f||cdl@7@||2;;gridwidth=1;;gridy=0;;gridx=0$$\n");
        sb.append("pc||t;;f||cdl@8@||2;;gridx=1$$\n");
        sb.append("pc||t;;f||lbl@Sem.@||2;;gridx=2$$\n");
        sb.append("pc||t;;f||cdl@9@||2;;gridx=3$$\n");
        sb.append("pc||t;;f||lbl@Dias@||2;;gridx=4$$\n");
        sb.append("hs||0||||2;;gridx=5;;weightx=1$$\n");
        sb.append("pc||IGH;;t;;f||cdl@12@||2;;gridx=6;;weightx=0$$\n");
        sb.append("pc||t;;f||lbl@Sem.@||2;;gridx=7$$\n");
        sb.append("pc||t;;f||cdl@156@||2;;gridx=8$$\n");
        sb.append("pc||t;;f||lbl@Dias@||2;;gridx=9$$\n");
        sb.append("pc||DPP;;t;;f||cdl@11@3||2;;gridx=11$$\n");
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
        sb.append("pc||I.C.;;f;;f||cdl@81@||4;;gridy=0;;gridwidth=1$$\n");
        sb.append("pc||;;t;;f||lbln@(74 a 86)@cor=0,0,255||4;;gridx=1$$\n");
        sb.append("pc||C.C. (mm);;f;;t||cdl@82@||4;;gridy=1;;gridx=0$$\n");
        sb.append("pc||;;t;;t||cdl@166@||4;;gridx=1;;gridwidth=2$$\n");
        sb.append("pc||C.C./C.A.;;f;;t||cdl@83@||4;;gridy=2;;gridwidth=1;;gridx=0$$\n");
        sb.append("pc||C.F./C.A. (Hadlock);;t;;t||cdl@84@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(20 a 24)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("pc||Estatura (cm)   ;;f;;t||cdl@121@||4;;gridx=0;;gridy=3$$\n");
        sb.append("pc||Peso fetal provável (g);;t;;t||cdl@123@||4;;gridx=1;;gridwidth=2$$\n");
        sb.append("pc||;;t;;t||lbln@(pelo D.B.P e C.A.)@cor=0,0,255||4;;gridx=3;;gridwidth=1$$\n");
        sb.append("hs||0||||4;;gridx=4;;gridy=5;;weightx=1$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||;;f;;f||lbln@ D.B.P.@||3;;gridy=0;;gridx=0;;weightx=0$$\n");
        sb.append("pc||em mm  ;;t;;f||cdl@26@||3;;gridx=1$$\n");
        sb.append("pc||I.G.;;t;;f||cdl@164@||3;;gridx=2$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.O.F. (mm);;t;;f||cdl@28@||3;;gridx=3$$\n");
        sb.append("pc||Valor do C.A.;;t;;f||cdl@71@||3;;gridx=4$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.A.P. (mm);;t;;f||cdl@74@1||3;;gridx=5$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||D.L.L. (mm);;t;;f||cdl@75@1||3;;gridx=6$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||Resultados;;t;;t||subcont@4@||3;;gridx=3;;gridy=1;;gridwidth=4;;gridheight=8$$\n");
        sb.append("lbln||C.A.||||3;;gridx=0;;gridheight=1;;gridwidth=1;;left_insets=4;;top_insets=4$$\n");
        sb.append("cdl||72||1||3;;gridx=1$$\n");
        sb.append("cdl||73||1||3$$\n");
        sb.append("cdl||165||||3;;gridx=2$$\n");
        sb.append("lbln||C.F.||||3;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||106||||3;;gridx=1$$\n");
        sb.append("cdl||158||||3;;gridx=2$$\n");
        sb.append("lbln||Úmero||||3;;gridx=0;;gridy=3$$\n");
        sb.append("cdl||96||||3;;gridx=1$$\n");
        sb.append("cdl||159||||3;;gridx=2$$\n");
        sb.append("lbln||Ulna||||3;;gridx=0;;gridy=4$$\n");
        sb.append("cdl||98||||3;;gridx=1$$\n");
        sb.append("cdl||160||||3;;gridx=2$$\n");
        sb.append("lbln||Tíbia||||3;;gridx=0;;gridy=5$$\n");
        sb.append("cdl||100||||3;;gridx=1$$\n");
        sb.append("cdl||161||||3;;gridx=2$$\n");
        sb.append("lbln||Fíbula||||3;;gridx=0;;gridy=6$$\n");
        sb.append("cdl||102||||3;;gridx=1$$\n");
        sb.append("cdl||162||||3;;gridx=2$$\n");
        sb.append("lbln||Rádio||||3;;gridx=0;;gridy=7$$\n");
        sb.append("cdl||104||||3;;gridx=1$$\n");
        sb.append("cdl||163||||3;;gridx=2$$\n");
        sb.append("hs||0||||3;;gridy=8$$\n");
        sb.append("hs||0||||3;;gridx=7;;gridy=9;;weightx=1;;left_insets=0;;top_insets=0$$\n");
        sb.append("pc||IGH pela biometria (baseado no percentil 50);;f;;t||subcont@3@||gridx=0;;gridy=2;;weightx=0;;gridwidth=3$$\n");

        sb.append("subpnl||||||->5$$\n");
        sb.append("pc||IGH     ;;f;;f||cdl@144@||5;;gridy=0;;gridx=0;;gridwidth=1$$\n");
        sb.append("pc||t;;f||lbl@Sem. @||5;;gridx=1$$\n");
        sb.append("pc||t;;f||cdl@145@||5;;gridx=2$$\n");
        sb.append("hs||30||||5$$\n");
        sb.append("pc||t;;f||lbl@Dias@||5;;gridx=3$$\n");
        sb.append("pc||Data do exame;;t;;f||cdl@4@||5;;gridx=4$$\n");
        sb.append("pc||Desvio padrão da I.G.;;t;;f||cdl@141@||5;;gridx=5$$\n");
        sb.append("hs||150||||5$$\n");
        sb.append("pc||± semana(s);;t;;f||cdl@147@||5;;gridx=6$$\n");
        sb.append("hs||0||||5;;gridx=7;;weightx=1$$\n");
        sb.append("pc||DPP;;t;;f||cdl@155@3||5;;gridx=8;;weightx=0$$\n");
        sb.append("hs||100||||5$$\n");
        sb.append("pc||IGH definida pelo examinador;;f;;t||subcont@5@||gridx=0;;gridy=4;;gridwidth=3$$\n");

        sb.append("vs||0||||gridx=3;;gridy=6;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        //  </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biometria (complementar)">

        sb.append("1;;Biometria (complementar);;200;;0;;Dados do equipamento$$\n");
        sb.append("pc||f;;f||lbln@Diâmetro ventricular (mm)@||gridx=0;;gridy=0$$\n");
        sb.append("pc||t;;f||cdl@24@||gridx=1$$\n");
        sb.append("pc||f;;t||lbln@Diâmetro transversal do cerebelo (mm)@||gridx=0;;gridy=1$$\n");
        sb.append("pc||t;;t||cdl@32@||gridx=1;;gridy=1$$\n");
        sb.append("pc||f;;t||lbln@Cisterna magna (mm)@||gridx=0;;gridy=2$$\n");
        sb.append("pc||t;;t||cdl@30@||gridx=1$$\n");
        sb.append("pc||f;;t||lbln@Prega nucal (mm)@||gridx=0;;gridy=3$$\n");
        sb.append("pc||t;;t||cdl@46@||gridx=1$$\n");
        sb.append("pc||f;;t||lbln@Distância inter-orbitária interna (mm)@||gridx=0;;gridy=4$$\n");
        sb.append("pc||t;;t||cdl@39@||gridx=1$$\n");
        sb.append("pc||f;;t||lbln@Ritmia@||gridx=0;;gridy=5$$\n");
        sb.append("pc||t;;t||cdl@63@||gridx=1$$\n");
        sb.append("pc||f;;t||lbln@Nº de batimentos cardíacos / min@||gridx=0;;gridy=6$$\n");
        sb.append("pc||t;;t||cdl@64@||gridx=1$$\n");
        sb.append("pc||t;;t||lbln@  @||gridx=2$$\n");
        sb.append("hs||80||||gridy=0;;gridx=1$$\n");
        sb.append("hs||80||||gridy=1$$\n");
        sb.append("hs||80||||gridy=2$$\n");
        sb.append("hs||80||||gridy=3$$\n");
        sb.append("hs||80||||gridy=4$$\n");
        sb.append("hs||80||||gridy=5$$\n");
        sb.append("hs||140||||gridy=6;;$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=3;;gridy=0;;gridwidth=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=3;;gridy=0;;weightx=0$$\n");
        sb.append("vs||0||||gridx=0;;gridy=8;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Estática Fetal">

        sb.append("13;;Estática fetal$$\n");
        sb.append("pc||Situação;;t;;f||cdl@15@||gridwidth=2;;gridx=0;;gridy=0$$\n");
        sb.append("pc||Apresentação;;t;;f||cdl@16@||gridx=2;;gridwidth=1$$\n");
        sb.append("pc||Dorso;;t;;f||cdl@17@||gridx=3$$\n");
        sb.append("hs||150||||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||gridx=1$$\n");
        sb.append("hs||150||||gridx=2$$\n");
        sb.append("hs||150||||gridx=3$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1$$\n");
        sb.append("vs||0||||gridx=4;;gridy=0;;weightx=1;;weighty=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Crânio Fetal e S.N.C">

        sb.append("18;;Crânio fetal e S.N.C.;;300;;13;;Estática fetal$$\n");
        sb.append("cdl||22||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||0||||gridx=1;;weightx=1$$\n");

        sb.append("cdl||20||||gridwidth=2;;gridy=1;;gridx=0;;weighty=1;;weightx=0;;left_insets=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Face Fetal">

        sb.append("33;;Face fetal;;300;;18;;Crânio fetal e S.N.C.$$\n");
        sb.append("cdl||37||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||0||||gridx=1;;weightx=1$$\n");

        sb.append("cdl||35||||gridwidth=2;;gridy=1;;gridx=0;;weighty=1;;weightx=0;;left_insets=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pescoço Fetal">

        sb.append("40;;Pescoço fetal;;300;;33;;Face fetal$$\n");
        sb.append("cdl||44||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||0||||gridx=1;;weightx=1$$\n");

        sb.append("cdl||42||||gridwidth=2;;gridy=1;;gridx=0;;weighty=1;;weightx=0;;left_insets=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Coluna Fetal">
        sb.append("47;;Coluna fetal;;300;;40;;Pescoço fetal$$\n");
        sb.append("cdl||51||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||0||||gridx=1;;weightx=1$$\n");

        sb.append("cdl||49||||gridwidth=2;;gridy=1;;gridx=0;;weighty=1;;weightx=0;;left_insets=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tórax">

        sb.append("52;;Tórax;;300;;47;;Coluna fetal$$\n");
        sb.append("cdl||56||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||0||||gridx=1;;weightx=1$$\n");

        sb.append("cdl||54||||gridwidth=2;;gridy=1;;gridx=0;;weighty=1;;weightx=0;;left_insets=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Coração">

        sb.append("57;;Coração;;300;;52;;Tórax$$\n");
        sb.append("cdl||61||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||0||||gridx=1;;weightx=1$$\n");

        sb.append("cdl||59||||gridwidth=2;;gridy=1;;gridx=0;;weighty=1;;weightx=0;;left_insets=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Abdome Fetal">

        sb.append("65;;Abdome fetal;;300;;57;;Coração$$\n");
        sb.append("cdl||69||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||0||||gridx=1;;weightx=1$$\n");

        sb.append("cdl||67||||gridwidth=2;;gridy=1;;gridx=0;;weighty=1;;weightx=0;;left_insets=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vias Urinárias">

        sb.append("76;;Vias urinárias;;300;;65;;Abdome fetal$$\n");
        sb.append("cdl||80||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||0||||gridx=1;;weightx=1$$\n");

        sb.append("cdl||78||||gridwidth=2;;gridy=1;;gridx=0;;weighty=1;;weightx=0;;left_insets=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Membros Fetais">

        sb.append("90;;Membros fetais;;300;;76;;Vias urinárias$$\n");
        sb.append("cdl||94||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||0||||gridx=1;;weightx=1$$\n");

        sb.append("cdl||92||||gridwidth=2;;gridy=1;;gridx=0;;weighty=1;;weightx=0;;left_insets=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        sb.append("107;;Placenta;;300;;90;;Membros fetais$$\n");
        sb.append("pc||Inserção 1;;f;;f||cdl@109@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Inserção 2;;t;;f||cdl@110@||gridx=1$$\n");
        sb.append("pc||Espessura (mm);;t;;f||cdl@112@||gridx=2$$\n");
        sb.append("pc||Maturidade;;t;;f||cdl@114@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@116@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=4;;gridy=2;;weightx=1;;weighty=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;gridy=1;;weightx=0;;weighty=0$$\n");
        sb.append("hs||170||||gridx=0;;gridy=0$$\n");
        sb.append("hs||220||||gridx=1$$\n");
        sb.append("hs||40||||gridx=2$$\n");
        sb.append("hs||110||||gridx=3$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        sb.append("107;;Outras informações;;250;;107;;Placenta$$\n");

        sb.append("pc||Sexo;;f;;f||cdl@119@||gridx=0;;gridy=0;;gridwidth=2$$\n");

        sb.append("pc||Cordão umbilical;;f;;t||cdl@125@||gridy=1;;gridwidth=1$$\n");
        sb.append("hs||170||||$$\n");
        sb.append("pc||Líquido amniótico;;t;;t||cdl@127@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("pc||Canal endocervical;;t;;t||cdl@129@||gridx=2$$\n");
        sb.append("hs||200||||$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||f;;t;;f||lbl@Medidas dos quadrantes (cm)@||1;;gridx=0;;gridy=0;;gridwidth=7$$\n");
        sb.append("pc||I;;t;;f||cdl@130@||1;;gridy=1;;gridwidth=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||II;;t;;f||cdl@131@||1;;gridx=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||III;;t;;f||cdl@132@||1;;gridx=2$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||IV;;t;;f||cdl@133@||1;;gridx=3$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||ILA (cm);;t;;f||cdl@135@||1;;gridx=4$$\n");
        sb.append("hs||70||||1$$\n");
        sb.append("pc||t;;f||cdl@136@||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||ILA (Índice do líquido amniótico);;f;;t||subcont@1@||weightx=0;;gridx=0;;gridwidth=3;;gridy=2$$\n");

        sb.append("vs||0||||gridy=3;;gridx=3;;weightx=1;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("137;;Observações gerais$$\n");
        sb.append("cdl||139||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("142;;Impressão diagnóstica;;270;;137;;Observações gerais$$\n");
        sb.append("cdl||151||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||149||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;left_insets=3;;weighty=1$$\n");
        sb.append("pc||Imprimir DPP;;f;;t||cdl@167@||gridy=2;;gridwidth=1;;weightx=0;;weighty=0$$\n");

        sb.append("\n##\n");

        //cid 10
        sb.append("\n142\n");

        // </editor-fold>

        alterarVisaoDeLaudo(25);

    }

    static void obs14semanasComRef () throws Exception
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
        sb.append("pc||<html>&nbsp;I.C. <font color=\"0000ff\">(74 a 86)</html>;;f;;f||cdl@48@||4;;gridy=0;;gridwidth=1$$\n");
        sb.append("pc||C.C. (mm);;t;;f||cdl@56@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;f||cdl@607@||4;;gridx=2$$\n");
        sb.append("pc||C.C./C.A.;;f;;t||cdl@59@||4;;gridy=1;;gridx=0$$\n");
        sb.append("pc||C.F./C.A. (Hadlock);;t;;t||cdl@65@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(20 a 24)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("pc||Estatura (cm)   ;;f;;t||cdl@80@||4;;gridx=0;;gridy=2$$\n");
        sb.append("pc||Peso fetal provável (g);;t;;t||cdl@77@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(pelo D.B.P e C.A.)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("hs||0||||4;;gridx=3;;gridy=3;;weightx=1$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||;;f;;f||lbln@ D.B.P.@||3;;gridy=0;;gridx=0;;weightx=0$$\n");
        sb.append("pc||em mm  ;;t;;f||cdl@45@||3;;gridx=1$$\n");
        sb.append("pc||I.G.;;t;;f||cdl@605@||3;;gridx=2$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.O.F. (mm);;t;;f||cdl@84@||3;;gridx=3$$\n");
        sb.append("pc||Valor do C.A.;;t;;f||cdl@51@||3;;gridx=4$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.A.P. (mm);;t;;f||cdl@85@1||3;;gridx=5$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||D.L.L. (mm);;t;;f||cdl@86@1||3;;gridx=6$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||Resultados;;t;;t||subcont@4@||3;;gridx=3;;gridy=1;;gridwidth=4;;gridheight=8$$\n");
        sb.append("lbln||C.A.||||3;;gridx=0;;gridheight=1;;gridwidth=1;;left_insets=4;;top_insets=8$$\n");
        sb.append("cdl||52||1||3;;gridx=1$$\n");
        sb.append("cdl||53||1||3$$\n");
        sb.append("cdl||606||||3;;gridx=2$$\n");
        sb.append("lbln||C.F.||||3;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||62||||3;;gridx=1$$\n");
        sb.append("cdl||601||||3;;gridx=2$$\n");
        sb.append("lbln||Úmero||||3;;gridx=0;;gridy=3$$\n");
        sb.append("cdl||68||||3;;gridx=1$$\n");
        sb.append("cdl||602||||3;;gridx=2$$\n");
        sb.append("lbln||Ulna||||3;;gridx=0;;gridy=4$$\n");
        sb.append("cdl||71||||3;;gridx=1$$\n");
        sb.append("cdl||603||||3;;gridx=2$$\n");
        sb.append("lbln||Tíbia||||3;;gridx=0;;gridy=5$$\n");
        sb.append("cdl||74||||3;;gridx=1$$\n");
        sb.append("cdl||604||||3;;gridx=2$$\n");
        sb.append("hs||0||||3;;gridy=8$$\n");
        sb.append("hs||0||||3;;gridx=7;;gridy=9;;weightx=1;;left_insets=0;;top_insets=0$$\n");
        sb.append("pc||IGH pela biometria (baseado no percentil 50);;f;;t||subcont@3@||gridx=0;;gridy=2;;weightx=0;;gridwidth=3$$\n");

        sb.append("subpnl||||||->5$$\n");
        sb.append("pc||IGH     ;;f;;f||cdl@585@||5;;gridy=0;;gridx=0;;gridwidth=1$$\n");
        sb.append("pc||t;;f||lbl@Sem. @||5;;gridx=1$$\n");
        sb.append("pc||t;;f||cdl@588@||5;;gridx=2$$\n");
        sb.append("hs||30||||5$$\n");
        sb.append("pc||t;;f||lbl@Dias@||5;;gridx=3$$\n");
        sb.append("pc||Data do exame;;t;;f||cdl@13@||5;;gridx=4$$\n");
        sb.append("pc||Desvio padrão da I.G.;;t;;f||cdl@576@||5;;gridx=5$$\n");
        sb.append("hs||150||||5$$\n");
        sb.append("pc||± semana(s);;t;;f||cdl@591@||5;;gridx=6$$\n");
        sb.append("hs||0||||5;;gridx=7;;weightx=1$$\n");
        sb.append("pc||DPP;;t;;f||cdl@599@3||5;;gridx=8;;weightx=0$$\n");
        sb.append("hs||100||||5$$\n");
        sb.append("pc||IGH definida pelo examinador;;f;;t||subcont@5@||gridx=0;;gridy=4;;gridwidth=3$$\n");

        sb.append("vs||0||||gridx=3;;gridy=6;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        //  </editor-fold>

        //  <editor-fold defaultstate="collapsed" desc="Biometria 1">

        sb.append("104;;IGH e biometria - Feto 1$$\n");

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
        sb.append("pc||<html>&nbsp;I.C. <font color=\"0000ff\">(74 a 86)</html>;;f;;f||cdl@126@||4;;gridy=0;;gridwidth=1$$\n");
        sb.append("pc||C.C. (mm);;t;;f||cdl@134@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;f||cdl@607@||4;;gridx=2$$\n");
        sb.append("pc||C.C./C.A.;;f;;t||cdl@137@||4;;gridy=1;;gridx=0$$\n");
        sb.append("pc||C.F./C.A. (Hadlock);;t;;t||cdl@143@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(20 a 24)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("pc||Estatura (cm)   ;;f;;t||cdl@158@||4;;gridx=0;;gridy=2$$\n");
        sb.append("pc||Peso fetal provável (g);;t;;t||cdl@155@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(pelo D.B.P e C.A.)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("hs||0||||4;;gridx=3;;gridy=5;;weightx=1$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||;;f;;f||lbln@ D.B.P.@||3;;gridy=0;;gridx=0;;weightx=0$$\n");
        sb.append("pc||em mm  ;;t;;f||cdl@123@||3;;gridx=1$$\n");
        sb.append("pc||I.G.;;t;;f||cdl@605@||3;;gridx=2$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.O.F. (mm);;t;;f||cdl@162@||3;;gridx=3$$\n");
        sb.append("pc||Valor do C.A.;;t;;f||cdl@129@||3;;gridx=4$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.A.P. (mm);;t;;f||cdl@163@1||3;;gridx=5$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||D.L.L. (mm);;t;;f||cdl@164@1||3;;gridx=6$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||Resultados;;t;;t||subcont@4@||3;;gridx=3;;gridy=1;;gridwidth=4;;gridheight=8$$\n");
        sb.append("lbln||C.A.||||3;;gridx=0;;gridheight=1;;gridwidth=1;;left_insets=4;;top_insets=8$$\n");
        sb.append("cdl||130||1||3;;gridx=1$$\n");
        sb.append("cdl||131||1||3$$\n");
        sb.append("cdl||606||||3;;gridx=2$$\n");
        sb.append("lbln||C.F.||||3;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||140||||3;;gridx=1$$\n");
        sb.append("cdl||601||||3;;gridx=2$$\n");
        sb.append("lbln||Úmero||||3;;gridx=0;;gridy=3$$\n");
        sb.append("cdl||146||||3;;gridx=1$$\n");
        sb.append("cdl||602||||3;;gridx=2$$\n");
        sb.append("lbln||Ulna||||3;;gridx=0;;gridy=4$$\n");
        sb.append("cdl||149||||3;;gridx=1$$\n");
        sb.append("cdl||603||||3;;gridx=2$$\n");
        sb.append("lbln||Tíbia||||3;;gridx=0;;gridy=5$$\n");
        sb.append("cdl||152||||3;;gridx=1$$\n");
        sb.append("cdl||604||||3;;gridx=2$$\n");
        sb.append("hs||0||||3;;gridy=8$$\n");
        sb.append("hs||0||||3;;gridx=7;;gridy=9;;weightx=1;;left_insets=0;;top_insets=0$$\n");
        sb.append("pc||IGH pela biometria (baseado no percentil 50);;f;;t||subcont@3@||gridx=0;;gridy=2;;weightx=0;;gridwidth=3$$\n");

        sb.append("subpnl||||||->5$$\n");
        sb.append("pc||IGH     ;;f;;f||cdl@585@||5;;gridy=0;;gridx=0;;gridwidth=1$$\n");
        sb.append("pc||t;;f||lbl@Sem. @||5;;gridx=1$$\n");
        sb.append("pc||t;;f||cdl@588@||5;;gridx=2$$\n");
        sb.append("hs||30||||5$$\n");
        sb.append("pc||t;;f||lbl@Dias@||5;;gridx=3$$\n");
        sb.append("pc||Data do exame;;t;;f||cdl@13@||5;;gridx=4$$\n");
        sb.append("pc||Desvio padrão da I.G.;;t;;f||cdl@576@||5;;gridx=5$$\n");
        sb.append("hs||150||||5$$\n");
        sb.append("pc||± semana(s);;t;;f||cdl@591@||5;;gridx=6$$\n");
        sb.append("hs||0||||5;;gridx=7;;weightx=1$$\n");
        sb.append("pc||DPP;;t;;f||cdl@599@3||5;;gridx=8;;weightx=0$$\n");
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
        sb.append("pc||Estadiamento intestinal;;f;;t||cdl@83@||gridx=0;;gridy=2;;gridwidth=2$$\n");
        sb.append("pc||Gordura pré-peritonial;;t;;t||cdl@82@||gridx=2;;gridwidth=1$$\n");
        sb.append("pc||Sexo fetal;;t;;t||cdl@81@||gridx=3$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=5;;weightx=0$$\n");
        sb.append("vs||200||||gridx=5;;gridy=1;;weightx=1$$\n");
        sb.append("hs||150||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        sb.append("26;;Placenta;;300;;26;;Feto$$\n");
        sb.append("pc||Inserção 1;;f;;f||cdl@88@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Inserção 2;;t;;f||cdl@89@||gridx=1$$\n");
        sb.append("pc||Espessura (mm);;t;;f||cdl@90@||gridx=2$$\n");
        sb.append("pc||Maturidade;;t;;f||cdl@91@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@92@||gridx=0;;gridy=1;;gridwidth=4$$\n");
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
        sb.append("pc||Cordão umbilical;;f;;f||cdl@94@||gridx=0;;gridy=0$$\n");
        sb.append("hs||170||||$$\n");
        sb.append("pc||Líquido amniótico;;t;;f||cdl@96@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||200||||gridx=2$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||f;;t;;f||lbl@Medidas dos quadrantes (cm)@||1;;gridx=0;;gridy=0;;gridwidth=7$$\n");
        sb.append("pc||I;;t;;f||cdl@97@||1;;gridy=1;;gridwidth=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||II;;t;;f||cdl@98@||1;;gridx=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||III;;t;;f||cdl@99@||1;;gridx=2$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||IV;;t;;f||cdl@100@||1;;gridx=3$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||ILA (cm);;t;;f||cdl@102@||1;;gridx=4$$\n");
        sb.append("hs||70||||1$$\n");
        sb.append("pc||t;;f||cdl@103@||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||ILA (Índice do líquido amniótico);;f;;t||subcont@1@||weightx=0;;gridx=0;;gridwidth=3;;gridy=1$$\n");

        sb.append("hs||0||||gridx=3;;gridy=2;;weightx=1;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 1">

        sb.append("104;;Feto 1;;200;;4;;Dados da gestação$$\n");

        sb.append("pc||Situação;;f;;f||cdl@106@||gridx=0;;gridy=0$$\n");
        sb.append("hs||300||||$$\n");
        sb.append("pc||Apresentação;;t;;f||cdl@107@||gridx=1$$\n");
        sb.append("hs||175||||$$\n");
        sb.append("pc||Dorso;;t;;f||cdl@109@||gridx=2;;gridwidth=2$$\n");

        sb.append("pc||Movimentos fetais;;f;;t||cdl@110@||gridx=0;;gridy=1;;gridwidth=1$$\n");
        sb.append("pc||Movimentos respiratórios;;t;;t||cdl@112@||gridx=1$$\n");

        sb.append("pc||Batimentos cardíacos;;f;;t||cdl@114@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Ritmo;;t;;t||cdl@115@||gridx=1$$\n");
        sb.append("pc||Nº (bat/min);;t;;t||cdl@116@||gridx=2$$\n");
        sb.append("hs||80||||gridx=3$$\n");

        sb.append("hs||0||||gridx=4;;gridy=3;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos internos 1">

        sb.append("104;;Órgãos internos - Feto 1;;300;;104;;Feto 1$$\n");
        sb.append("pc||Situação;;f;;f||cdl@118@||gridx=0;;gridy=0;;gridwidth=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@119@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||Estadiamento intestinal;;f;;t||cdl@161@||gridx=0;;gridy=2;;gridwidth=2$$\n");
        sb.append("pc||Gordura pré-peritonial;;t;;t||cdl@160@||gridx=2;;gridwidth=1$$\n");
        sb.append("pc||Sexo fetal;;t;;t||cdl@159@||gridx=3$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=5;;weightx=0$$\n");
        sb.append("vs||170||||gridx=5;;gridy=1;;weightx=1$$\n");
        sb.append("hs||150||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta 1">

        sb.append("104;;Placenta - Feto 1 ;;300;;104;;Feto 1$$\n");
        sb.append("pc||Inserção 1;;f;;f||cdl@166@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Inserção 2;;t;;f||cdl@167@||gridx=1$$\n");
        sb.append("pc||Espessura (mm);;t;;f||cdl@168@||gridx=2$$\n");
        sb.append("pc||Maturidade;;t;;f||cdl@169@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@170@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=4;;gridy=2;;weightx=1;;weighty=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;gridy=1;;weightx=0;;weighty=0$$\n");
        sb.append("hs||180||||gridx=0;;gridy=0$$\n");
        sb.append("hs||220||||gridx=1$$\n");
        sb.append("hs||40||||gridx=2$$\n");
        sb.append("hs||110||||gridx=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações 1">

        sb.append("104;;Outras informações - Feto 1;;300;;104;;Feto 1$$\n");
        sb.append("pc||Cordão umbilical;;f;;f||cdl@172@||gridx=0;;gridy=0$$\n");
        sb.append("hs||170||||$$\n");
        sb.append("pc||Líquido amniótico;;t;;f||cdl@174@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||200||||gridx=2$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||f;;t;;f||lbl@Medidas dos quadrantes (cm)@||1;;gridx=0;;gridy=0;;gridwidth=7$$\n");
        sb.append("pc||I;;t;;f||cdl@175@||1;;gridy=1;;gridwidth=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||II;;t;;f||cdl@176@||1;;gridx=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||III;;t;;f||cdl@177@||1;;gridx=2$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||IV;;t;;f||cdl@178@||1;;gridx=3$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||ILA (cm);;t;;f||cdl@180@||1;;gridx=4$$\n");
        sb.append("hs||70||||1$$\n");
        sb.append("pc||t;;f||cdl@181@||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||ILA (Índice do líquido amniótico);;f;;t||subcont@1@||weightx=0;;gridx=0;;gridwidth=3;;gridy=1$$\n");

        sb.append("hs||0||||gridx=3;;gridy=2;;weightx=1;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 2">

        //  <editor-fold defaultstate="collapsed" desc="Biometria">

        sb.append("182;;Biometria - Feto 2;;300;;104;;Feto 1$$\n");

        sb.append("subpnl||||||->4$$\n");
        sb.append("pc||<html>&nbsp;I.C. <font color=\"0000ff\">(74 a 86)</html>;;f;;f||cdl@204@||4;;gridx=0;;gridy=0$$\n");
        sb.append("pc||C.C. (mm);;t;;f||cdl@212@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;f||cdl@614@||4;;gridx=2$$\n");
        sb.append("pc||C.C./C.A.;;f;;t||cdl@215@||4;;gridy=1;;gridx=0$$\n");
        sb.append("pc||C.F./C.A. (Hadlock);;t;;t||cdl@221@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(20 a 24)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("pc||Estatura (cm)   ;;f;;t||cdl@236@||4;;gridx=0;;gridy=2$$\n");
        sb.append("pc||Peso fetal provável (g);;t;;t||cdl@233@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(pelo D.B.P e C.A.)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("hs||0||||4;;gridx=3;;gridy=3;;weightx=1$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||;;f;;f||lbln@ D.B.P.@||3;;gridy=0;;gridx=0;;weightx=0$$\n");
        sb.append("pc||em mm  ;;t;;f||cdl@201@||3;;gridx=1$$\n");
        sb.append("pc||I.G.;;t;;f||cdl@612@||3;;gridx=2$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.O.F. (mm);;t;;f||cdl@240@||3;;gridx=3$$\n");
        sb.append("pc||Valor do C.A.;;t;;f||cdl@207@||3;;gridx=4$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.A.P. (mm);;t;;f||cdl@241@1||3;;gridx=5$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||D.L.L. (mm);;t;;f||cdl@242@1||3;;gridx=6$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||Resultados;;t;;t||subcont@4@||3;;gridx=3;;gridy=1;;gridwidth=4;;gridheight=8$$\n");
        sb.append("lbln||C.A.||||3;;gridx=0;;gridheight=1;;gridwidth=1;;left_insets=4;;top_insets=8$$\n");
        sb.append("cdl||208||1||3;;gridx=1$$\n");
        sb.append("cdl||209||1||3$$\n");
        sb.append("cdl||613||||3;;gridx=2$$\n");
        sb.append("lbln||C.F.||||3;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||218||||3;;gridx=1$$\n");
        sb.append("cdl||608||||3;;gridx=2$$\n");
        sb.append("lbln||Úmero||||3;;gridx=0;;gridy=3$$\n");
        sb.append("cdl||224||||3;;gridx=1$$\n");
        sb.append("cdl||609||||3;;gridx=2$$\n");
        sb.append("lbln||Ulna||||3;;gridx=0;;gridy=4$$\n");
        sb.append("cdl||227||||3;;gridx=1$$\n");
        sb.append("cdl||610||||3;;gridx=2$$\n");
        sb.append("lbln||Tíbia||||3;;gridx=0;;gridy=5$$\n");
        sb.append("cdl||230||||3;;gridx=1$$\n");
        sb.append("cdl||611||||3;;gridx=2$$\n");
        sb.append("hs||0||||3;;gridy=8$$\n");
        sb.append("hs||0||||3;;gridx=7;;gridy=9;;weightx=1;;left_insets=0;;top_insets=0$$\n");
        sb.append("pc||Biometria;;f;;f||subcont@3@||gridx=0;;gridy=0;;weightx=0$$\n");

        sb.append("hs||0||||gridy=1;;gridx=1;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

       //  </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto">

        sb.append("182;;Feto 2;;300;;182;;Feto 2$$\n");

        sb.append("pc||Situação;;f;;f||cdl@184@||gridx=0;;gridy=0$$\n");
        sb.append("hs||300||||$$\n");
        sb.append("pc||Apresentação;;t;;f||cdl@185@||gridx=1$$\n");
        sb.append("hs||175||||$$\n");
        sb.append("pc||Dorso;;t;;f||cdl@187@||gridx=2;;gridwidth=2$$\n");

        sb.append("pc||Movimentos fetais;;f;;t||cdl@188@||gridx=0;;gridy=1;;gridwidth=1$$\n");
        sb.append("pc||Movimentos respiratórios;;t;;t||cdl@190@||gridx=1$$\n");

        sb.append("pc||Batimentos cardíacos;;f;;t||cdl@192@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Ritmo;;t;;t||cdl@193@||gridx=1$$\n");
        sb.append("pc||Nº (bat/min);;t;;t||cdl@194@||gridx=2$$\n");
        sb.append("hs||80||||gridx=3$$\n");

        sb.append("hs||0||||gridx=4;;gridy=3;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos Internos">

        sb.append("182;;Órgãos internos - Feto 2;;300;;182;;Feto 2$$\n");
        sb.append("pc||Situação;;f;;f||cdl@196@||gridx=0;;gridy=0;;gridwidth=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@197@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||Estadiamento intestinal;;f;;t||cdl@239@||gridx=0;;gridy=2;;gridwidth=2$$\n");
        sb.append("pc||Gordura pré-peritonial;;t;;t||cdl@238@||gridx=2;;gridwidth=1$$\n");
        sb.append("pc||Sexo fetal;;t;;t||cdl@237@||gridx=3$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=5;;weightx=0$$\n");
        sb.append("vs||200||||gridx=5;;gridy=1;;weightx=1$$\n");
        sb.append("hs||150||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        sb.append("182;;Placenta - Feto 2;;300;;182;;Feto 2$$\n");
        sb.append("pc||Inserção 1;;f;;f||cdl@244@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Inserção 2;;t;;f||cdl@245@||gridx=1$$\n");
        sb.append("pc||Espessura (mm);;t;;f||cdl@246@||gridx=2$$\n");
        sb.append("pc||Maturidade;;t;;f||cdl@247@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@248@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=4;;gridy=2;;weightx=1;;weighty=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;gridy=1;;weightx=0;;weighty=0$$\n");
        sb.append("hs||180||||gridx=0;;gridy=0$$\n");
        sb.append("hs||220||||gridx=1$$\n");
        sb.append("hs||40||||gridx=2$$\n");
        sb.append("hs||110||||gridx=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        sb.append("182;;Outras informações - Feto 2;;300;;182;;Feto 2$$\n");
        sb.append("pc||Cordão umbilical;;f;;f||cdl@250@||gridx=0;;gridy=0$$\n");
        sb.append("hs||170||||$$\n");
        sb.append("pc||Líquido amniótico;;t;;f||cdl@252@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");

        sb.append("hs||200||||gridx=2$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||f;;t;;f||lbl@Medidas dos quadrantes (cm)@||1;;gridx=0;;gridy=0;;gridwidth=7$$\n");
        sb.append("pc||I;;t;;f||cdl@253@||1;;gridy=1;;gridwidth=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||II;;t;;f||cdl@254@||1;;gridx=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||III;;t;;f||cdl@255@||1;;gridx=2$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||IV;;t;;f||cdl@256@||1;;gridx=3$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||ILA (cm);;t;;f||cdl@258@||1;;gridx=4$$\n");
        sb.append("hs||70||||1$$\n");
        sb.append("pc||t;;f||cdl@259@||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||ILA (Índice do líquido amniótico);;f;;t||subcont@1@||weightx=0;;gridx=0;;gridwidth=3;;gridy=1$$\n");

        sb.append("hs||0||||gridx=3;;gridy=2;;weightx=1;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 3">

        //  <editor-fold defaultstate="collapsed" desc="Biometria">

        sb.append("260;;Biometria - Feto 3;;300;;182;;Feto 2$$\n");

        sb.append("subpnl||||||->4$$\n");
        sb.append("pc||<html>&nbsp;I.C. <font color=\"0000ff\">(74 a 86)</html>;;f;;f||cdl@282@||4;;gridx=0;;gridy=0$$\n");
        sb.append("pc||C.C. (mm);;t;;f||cdl@290@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;f||cdl@621@||4;;gridx=2$$\n");
        sb.append("pc||C.C./C.A.;;f;;t||cdl@293@||4;;gridy=1;;gridx=0$$\n");
        sb.append("pc||C.F./C.A. (Hadlock);;t;;t||cdl@299@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(20 a 24)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("pc||Estatura (cm)   ;;f;;t||cdl@314@||4;;gridx=0;;gridy=2$$\n");
        sb.append("pc||Peso fetal provável (g);;t;;t||cdl@311@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(pelo D.B.P e C.A.)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("hs||0||||4;;gridx=3;;gridy=3;;weightx=1$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||;;f;;f||lbln@ D.B.P.@||3;;gridy=0;;gridx=0;;weightx=0$$\n");
        sb.append("pc||em mm  ;;t;;f||cdl@279@||3;;gridx=1$$\n");
        sb.append("pc||I.G.;;t;;f||cdl@619@||3;;gridx=2$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.O.F. (mm);;t;;f||cdl@318@||3;;gridx=3$$\n");
        sb.append("pc||Valor do C.A.;;t;;f||cdl@285@||3;;gridx=4$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.A.P. (mm);;t;;f||cdl@319@1||3;;gridx=5$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||D.L.L. (mm);;t;;f||cdl@320@1||3;;gridx=6$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||Resultados;;t;;t||subcont@4@||3;;gridx=3;;gridy=1;;gridwidth=4;;gridheight=8$$\n");
        sb.append("lbln||C.A.||||3;;gridx=0;;gridheight=1;;gridwidth=1;;left_insets=4;;top_insets=8$$\n");
        sb.append("cdl||286||1||3;;gridx=1$$\n");
        sb.append("cdl||287||1||3$$\n");
        sb.append("cdl||620||||3;;gridx=2$$\n");
        sb.append("lbln||C.F.||||3;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||296||||3;;gridx=1$$\n");
        sb.append("cdl||615||||3;;gridx=2$$\n");
        sb.append("lbln||Úmero||||3;;gridx=0;;gridy=3$$\n");
        sb.append("cdl||302||||3;;gridx=1$$\n");
        sb.append("cdl||616||||3;;gridx=2$$\n");
        sb.append("lbln||Ulna||||3;;gridx=0;;gridy=4$$\n");
        sb.append("cdl||305||||3;;gridx=1$$\n");
        sb.append("cdl||617||||3;;gridx=2$$\n");
        sb.append("lbln||Tíbia||||3;;gridx=0;;gridy=5$$\n");
        sb.append("cdl||308||||3;;gridx=1$$\n");
        sb.append("cdl||618||||3;;gridx=2$$\n");
        sb.append("hs||0||||3;;gridy=8$$\n");
        sb.append("hs||0||||3;;gridx=7;;gridy=9;;weightx=1;;left_insets=0;;top_insets=0$$\n");
        sb.append("pc||Biometria;;f;;f||subcont@3@||gridx=0;;gridy=0;;weightx=0$$\n");

        sb.append("hs||0||||gridy=1;;gridx=1;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

       //  </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto">

        sb.append("260;;Feto 3;;300;;260;;Feto 3$$\n");

        sb.append("pc||Situação;;f;;f||cdl@262@||gridx=0;;gridy=0$$\n");
        sb.append("hs||300||||$$\n");
        sb.append("pc||Apresentação;;t;;f||cdl@263@||gridx=1$$\n");
        sb.append("hs||175||||$$\n");
        sb.append("pc||Dorso;;t;;f||cdl@265@||gridx=2;;gridwidth=2$$\n");

        sb.append("pc||Movimentos fetais;;f;;t||cdl@266@||gridx=0;;gridy=1;;gridwidth=1$$\n");
        sb.append("pc||Movimentos respiratórios;;t;;t||cdl@268@||gridx=1$$\n");

        sb.append("pc||Batimentos cardíacos;;f;;t||cdl@270@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Ritmo;;t;;t||cdl@271@||gridx=1$$\n");
        sb.append("pc||Nº (bat/min);;t;;t||cdl@272@||gridx=2$$\n");
        sb.append("hs||80||||gridx=3$$\n");

        sb.append("hs||0||||gridx=4;;gridy=3;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos Internos">

        sb.append("260;;Órgãos internos - Feto 3;;300;;260;;Feto 3$$\n");
        sb.append("pc||Situação;;f;;f||cdl@274@||gridx=0;;gridy=0;;gridwidth=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@275@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||Estadiamento intestinal;;f;;t||cdl@317@||gridx=0;;gridy=2;;gridwidth=2$$\n");
        sb.append("pc||Gordura pré-peritonial;;t;;t||cdl@316@||gridx=2;;gridwidth=1$$\n");
        sb.append("pc||Sexo fetal;;t;;t||cdl@315@||gridx=3$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=5;;weightx=0$$\n");
        sb.append("vs||200||||gridx=5;;gridy=1;;weightx=1$$\n");
        sb.append("hs||150||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        sb.append("260;;Placenta - Feto 3;;300;;260;;Feto 3$$\n");
        sb.append("pc||Inserção 1;;f;;f||cdl@322@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Inserção 2;;t;;f||cdl@323@||gridx=1$$\n");
        sb.append("pc||Espessura (mm);;t;;f||cdl@324@||gridx=2$$\n");
        sb.append("pc||Maturidade;;t;;f||cdl@325@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@326@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=4;;gridy=2;;weightx=1;;weighty=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;gridy=1;;weightx=0;;weighty=0$$\n");
        sb.append("hs||180||||gridx=0;;gridy=0$$\n");
        sb.append("hs||220||||gridx=1$$\n");
        sb.append("hs||40||||gridx=2$$\n");
        sb.append("hs||110||||gridx=3$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        sb.append("260;;Outras informações - Feto 3;;300;;260;;Feto 3$$\n");
        sb.append("pc||Cordão umbilical;;f;;f||cdl@328@||gridx=0;;gridy=0$$\n");
        sb.append("hs||170||||$$\n");
        sb.append("pc||Líquido amniótico;;t;;f||cdl@330@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||200||||gridx=2$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||f;;t;;f||lbl@Medidas dos quadrantes (cm)@||1;;gridx=0;;gridy=0;;gridwidth=7$$\n");
        sb.append("pc||I;;t;;f||cdl@331@||1;;gridy=1;;gridwidth=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||II;;t;;f||cdl@332@||1;;gridx=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||III;;t;;f||cdl@333@||1;;gridx=2$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||IV;;t;;f||cdl@334@||1;;gridx=3$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||ILA (cm);;t;;f||cdl@336@||1;;gridx=4$$\n");
        sb.append("hs||70||||1$$\n");
        sb.append("pc||t;;f||cdl@337@||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||ILA (Índice do líquido amniótico);;f;;t||subcont@1@||weightx=0;;gridx=0;;gridwidth=3;;gridy=1$$\n");

        sb.append("hs||0||||gridx=3;;gridy=2;;weightx=1;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 4">

        //  <editor-fold defaultstate="collapsed" desc="Biometria">

        sb.append("338;;Biometria - Feto 4;;300;;260;;Feto 3$$\n");

        sb.append("subpnl||||||->4$$\n");
        sb.append("pc||<html>&nbsp;I.C. <font color=\"0000ff\">(74 a 86)</html>;;f;;f||cdl@360@||4;;gridx=0;;gridy=0$$\n");
        sb.append("pc||C.C. (mm);;t;;f||cdl@368@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;f||cdl@628@||4;;gridx=2$$\n");
        sb.append("pc||C.C./C.A.;;f;;t||cdl@371@||4;;gridy=1;;gridx=0$$\n");
        sb.append("pc||C.F./C.A. (Hadlock);;t;;t||cdl@377@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(20 a 24)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("pc||Estatura (cm)   ;;f;;t||cdl@392@||4;;gridx=0;;gridy=2$$\n");
        sb.append("pc||Peso fetal provável (g);;t;;t||cdl@389@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(pelo D.B.P e C.A.)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("hs||0||||4;;gridx=3;;gridy=3;;weightx=1$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||;;f;;f||lbln@ D.B.P.@||3;;gridy=0;;gridx=0;;weightx=0$$\n");
        sb.append("pc||em mm  ;;t;;f||cdl@357@||3;;gridx=1$$\n");
        sb.append("pc||I.G.;;t;;f||cdl@626@||3;;gridx=2$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.O.F. (mm);;t;;f||cdl@396@||3;;gridx=3$$\n");
        sb.append("pc||Valor do C.A.;;t;;f||cdl@363@||3;;gridx=4$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.A.P. (mm);;t;;f||cdl@397@1||3;;gridx=5$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||D.L.L. (mm);;t;;f||cdl@398@1||3;;gridx=6$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||Resultados;;t;;t||subcont@4@||3;;gridx=3;;gridy=1;;gridwidth=4;;gridheight=8$$\n");
        sb.append("lbln||C.A.||||3;;gridx=0;;gridheight=1;;gridwidth=1;;left_insets=4;;top_insets=8$$\n");
        sb.append("cdl||364||1||3;;gridx=1$$\n");
        sb.append("cdl||365||1||3$$\n");
        sb.append("cdl||627||||3;;gridx=2$$\n");
        sb.append("lbln||C.F.||||3;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||374||||3;;gridx=1$$\n");
        sb.append("cdl||622||||3;;gridx=2$$\n");
        sb.append("lbln||Úmero||||3;;gridx=0;;gridy=3$$\n");
        sb.append("cdl||380||||3;;gridx=1$$\n");
        sb.append("cdl||623||||3;;gridx=2$$\n");
        sb.append("lbln||Ulna||||3;;gridx=0;;gridy=4$$\n");
        sb.append("cdl||383||||3;;gridx=1$$\n");
        sb.append("cdl||624||||3;;gridx=2$$\n");
        sb.append("lbln||Tíbia||||3;;gridx=0;;gridy=5$$\n");
        sb.append("cdl||386||||3;;gridx=1$$\n");
        sb.append("cdl||625||||3;;gridx=2$$\n");
        sb.append("hs||0||||3;;gridy=8$$\n");
        sb.append("hs||0||||3;;gridx=7;;gridy=9;;weightx=1;;left_insets=0;;top_insets=0$$\n");
        sb.append("pc||Biometria;;f;;f||subcont@3@||gridx=0;;gridy=0;;weightx=0$$\n");

        sb.append("hs||0||||gridy=1;;gridx=1;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

       //  </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto">

        sb.append("338;;Feto 4;;300;;338;;Feto 4$$\n");

        sb.append("pc||Situação;;f;;f||cdl@340@||gridx=0;;gridy=0$$\n");
        sb.append("hs||300||||$$\n");
        sb.append("pc||Apresentação;;t;;f||cdl@341@||gridx=1$$\n");
        sb.append("hs||175||||$$\n");
        sb.append("pc||Dorso;;t;;f||cdl@343@||gridx=2;;gridwidth=2$$\n");

        sb.append("pc||Movimentos fetais;;f;;t||cdl@344@||gridx=0;;gridy=1;;gridwidth=1$$\n");
        sb.append("pc||Movimentos respiratórios;;t;;t||cdl@346@||gridx=1$$\n");

        sb.append("pc||Batimentos cardíacos;;f;;t||cdl@348@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Ritmo;;t;;t||cdl@349@||gridx=1$$\n");
        sb.append("pc||Nº (bat/min);;t;;t||cdl@350@||gridx=2$$\n");
        sb.append("hs||80||||gridx=3$$\n");

        sb.append("hs||0||||gridx=4;;gridy=3;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos Internos">

        sb.append("338;;Órgãos internos - Feto 4;;300;;338;;Feto 4$$\n");
        sb.append("pc||Situação;;f;;f||cdl@352@||gridx=0;;gridy=0;;gridwidth=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@353@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||Estadiamento intestinal;;f;;t||cdl@395@||gridx=0;;gridy=2;;gridwidth=2$$\n");
        sb.append("pc||Gordura pré-peritonial;;t;;t||cdl@394@||gridx=2;;gridwidth=1$$\n");
        sb.append("pc||Sexo fetal;;t;;t||cdl@393@||gridx=3$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=5;;weightx=0$$\n");
        sb.append("vs||200||||gridx=5;;gridy=1;;weightx=1$$\n");
        sb.append("hs||150||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        sb.append("338;;Placenta - Feto 4;;300;;338;;Feto 4$$\n");
        sb.append("pc||Inserção 1;;f;;f||cdl@400@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Inserção 2;;t;;f||cdl@401@||gridx=1$$\n");
        sb.append("pc||Espessura (mm);;t;;f||cdl@402@||gridx=2$$\n");
        sb.append("pc||Maturidade;;t;;f||cdl@403@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@404@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=4;;gridy=2;;weightx=1;;weighty=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;gridy=1;;weightx=0;;weighty=0$$\n");
        sb.append("hs||180||||gridx=0;;gridy=0$$\n");
        sb.append("hs||220||||gridx=1$$\n");
        sb.append("hs||40||||gridx=2$$\n");
        sb.append("hs||110||||gridx=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        sb.append("338;;Outras informações - Feto 4;;300;;338;;Feto 4$$\n");
        sb.append("pc||Cordão umbilical;;f;;f||cdl@406@||gridx=0;;gridy=0$$\n");
        sb.append("hs||170||||$$\n");
        sb.append("pc||Líquido amniótico;;t;;f||cdl@408@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||200||||gridx=2$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||f;;t;;f||lbl@Medidas dos quadrantes (cm)@||1;;gridx=0;;gridy=0;;gridwidth=7$$\n");
        sb.append("pc||I;;t;;f||cdl@409@||1;;gridy=1;;gridwidth=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||II;;t;;f||cdl@410@||1;;gridx=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||III;;t;;f||cdl@411@||1;;gridx=2$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||IV;;t;;f||cdl@412@||1;;gridx=3$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||ILA (cm);;t;;f||cdl@414@||1;;gridx=4$$\n");
        sb.append("hs||70||||1$$\n");
        sb.append("pc||t;;f||cdl@415@||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||ILA (Índice do líquido amniótico);;f;;t||subcont@1@||weightx=0;;gridx=0;;gridwidth=3;;gridy=1$$\n");

        sb.append("hs||0||||gridx=3;;gridy=2;;weightx=1;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 5">

        //  <editor-fold defaultstate="collapsed" desc="Biometria">

        sb.append("416;;Biometria - Feto 5;;300;;338;;Feto 4$$\n");

        sb.append("subpnl||||||->4$$\n");
        sb.append("pc||<html>&nbsp;I.C. <font color=\"0000ff\">(74 a 86)</html>;;f;;f||cdl@438@||4;;gridx=0;;gridy=0$$\n");
        sb.append("pc||C.C. (mm);;t;;f||cdl@446@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;f||cdl@635@||4;;gridx=2$$\n");
        sb.append("pc||C.C./C.A.;;f;;t||cdl@449@||4;;gridy=1;;gridx=0$$\n");
        sb.append("pc||C.F./C.A. (Hadlock);;t;;t||cdl@455@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(20 a 24)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("pc||Estatura (cm)   ;;f;;t||cdl@470@||4;;gridx=0;;gridy=2$$\n");
        sb.append("pc||Peso fetal provável (g);;t;;t||cdl@467@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(pelo D.B.P e C.A.)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("hs||0||||4;;gridx=3;;gridy=3;;weightx=1$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||;;f;;f||lbln@ D.B.P.@||3;;gridy=0;;gridx=0;;weightx=0$$\n");
        sb.append("pc||em mm  ;;t;;f||cdl@435@||3;;gridx=1$$\n");
        sb.append("pc||I.G.;;t;;f||cdl@633@||3;;gridx=2$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.O.F. (mm);;t;;f||cdl@474@||3;;gridx=3$$\n");
        sb.append("pc||Valor do C.A.;;t;;f||cdl@441@||3;;gridx=4$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.A.P. (mm);;t;;f||cdl@475@1||3;;gridx=5$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||D.L.L. (mm);;t;;f||cdl@476@1||3;;gridx=6$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||Resultados;;t;;t||subcont@4@||3;;gridx=3;;gridy=1;;gridwidth=4;;gridheight=8$$\n");
        sb.append("lbln||C.A.||||3;;gridx=0;;gridheight=1;;gridwidth=1;;left_insets=4;;top_insets=8$$\n");
        sb.append("cdl||442||1||3;;gridx=1$$\n");
        sb.append("cdl||443||1||3$$\n");
        sb.append("cdl||634||||3;;gridx=2$$\n");
        sb.append("lbln||C.F.||||3;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||452||||3;;gridx=1$$\n");
        sb.append("cdl||629||||3;;gridx=2$$\n");
        sb.append("lbln||Úmero||||3;;gridx=0;;gridy=3$$\n");
        sb.append("cdl||458||||3;;gridx=1$$\n");
        sb.append("cdl||630||||3;;gridx=2$$\n");
        sb.append("lbln||Ulna||||3;;gridx=0;;gridy=4$$\n");
        sb.append("cdl||461||||3;;gridx=1$$\n");
        sb.append("cdl||631||||3;;gridx=2$$\n");
        sb.append("lbln||Tíbia||||3;;gridx=0;;gridy=5$$\n");
        sb.append("cdl||464||||3;;gridx=1$$\n");
        sb.append("cdl||632||||3;;gridx=2$$\n");
        sb.append("hs||0||||3;;gridy=8$$\n");
        sb.append("hs||0||||3;;gridx=7;;gridy=9;;weightx=1;;left_insets=0;;top_insets=0$$\n");
        sb.append("pc||Biometria;;f;;f||subcont@3@||gridx=0;;gridy=0;;weightx=0$$\n");

        sb.append("hs||0||||gridy=1;;gridx=1;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

       //  </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto">

        sb.append("416;;Feto 5;;300;;416;;Feto 5$$\n");

        sb.append("pc||Situação;;f;;f||cdl@418@||gridx=0;;gridy=0$$\n");
        sb.append("hs||300||||$$\n");
        sb.append("pc||Apresentação;;t;;f||cdl@419@||gridx=1$$\n");
        sb.append("hs||175||||$$\n");
        sb.append("pc||Dorso;;t;;f||cdl@421@||gridx=2;;gridwidth=2$$\n");

        sb.append("pc||Movimentos fetais;;f;;t||cdl@422@||gridx=0;;gridy=1;;gridwidth=1$$\n");
        sb.append("pc||Movimentos respiratórios;;t;;t||cdl@424@||gridx=1$$\n");

        sb.append("pc||Batimentos cardíacos;;f;;t||cdl@426@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Ritmo;;t;;t||cdl@427@||gridx=1$$\n");
        sb.append("pc||Nº (bat/min);;t;;t||cdl@428@||gridx=2$$\n");
        sb.append("hs||80||||gridx=3$$\n");

        sb.append("hs||0||||gridx=4;;gridy=3;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos Internos">

        sb.append("416;;Órgãos internos - Feto 5;;300;;416;;Feto 5$$\n");
        sb.append("pc||Situação;;f;;f||cdl@430@||gridx=0;;gridy=0;;gridwidth=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@431@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||Estadiamento intestinal;;f;;t||cdl@473@||gridx=0;;gridy=2;;gridwidth=2$$\n");
        sb.append("pc||Gordura pré-peritonial;;t;;t||cdl@472@||gridx=2;;gridwidth=1$$\n");
        sb.append("pc||Sexo fetal;;t;;t||cdl@471@||gridx=3$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=5;;weightx=0$$\n");
        sb.append("vs||200||||gridx=5;;gridy=1;;weightx=1$$\n");
        sb.append("hs||150||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        //   <editor-fold defaultstate="collapsed" desc="Placenta">

        sb.append("416;;Placenta - Feto 5;;300;;416;;Feto 5$$\n");
        sb.append("pc||Inserção 1;;f;;f||cdl@478@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Inserção 2;;t;;f||cdl@479@||gridx=1$$\n");
        sb.append("pc||Espessura (mm);;t;;f||cdl@480@||gridx=2$$\n");
        sb.append("pc||Maturidade;;t;;f||cdl@481@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@482@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=4;;gridy=2;;weightx=1;;weighty=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;gridy=1;;weightx=0;;weighty=0$$\n");
        sb.append("hs||180||||gridx=0;;gridy=0$$\n");
        sb.append("hs||220||||gridx=1$$\n");
        sb.append("hs||40||||gridx=2$$\n");
        sb.append("hs||110||||gridx=3$$\n");

        sb.append("\n##\n");

        //  </editor-fold>

        //  <editor-fold defaultstate="collapsed" desc="Outras informações">

        sb.append("416;;Outras informações - Feto 5;;300;;416;;Feto 5$$\n");
        sb.append("pc||Cordão umbilical;;f;;f||cdl@484@||gridx=0;;gridy=0$$\n");
        sb.append("hs||170||||$$\n");
        sb.append("pc||Líquido amniótico;;t;;f||cdl@486@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||200||||gridx=2$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||f;;t;;f||lbl@Medidas dos quadrantes (cm)@||1;;gridx=0;;gridy=0;;gridwidth=7$$\n");
        sb.append("pc||I;;t;;f||cdl@487@||1;;gridy=1;;gridwidth=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||II;;t;;f||cdl@488@||1;;gridx=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||III;;t;;f||cdl@489@||1;;gridx=2$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||IV;;t;;f||cdl@490@||1;;gridx=3$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||ILA (cm);;t;;f||cdl@492@||1;;gridx=4$$\n");
        sb.append("hs||70||||1$$\n");
        sb.append("pc||t;;f||cdl@493@||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||ILA (Índice do líquido amniótico);;f;;t||subcont@1@||weightx=0;;gridx=0;;gridwidth=3;;gridy=1$$\n");

        sb.append("hs||0||||gridx=3;;gridy=2;;weightx=1;;weighty=1$$\n");

        sb.append("\n##\n");

       //  </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 6">

        //  <editor-fold defaultstate="collapsed" desc="Biometria">

        sb.append("494;;Biometria - Feto 6;;300;;416;;Feto 5$$\n");

        sb.append("subpnl||||||->4$$\n");
        sb.append("pc||<html>&nbsp;I.C. <font color=\"0000ff\">(74 a 86)</html>;;f;;f||cdl@516@||4;;gridx=0;;gridy=0$$\n");
        sb.append("pc||C.C. (mm);;t;;f||cdl@524@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;f||cdl@642@||4;;gridx=2$$\n");
        sb.append("pc||C.C./C.A.;;f;;t||cdl@527@||4;;gridy=1;;gridx=0$$\n");
        sb.append("pc||C.F./C.A. (Hadlock);;t;;t||cdl@533@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(20 a 24)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("pc||Estatura (cm)   ;;f;;t||cdl@548@||4;;gridx=0;;gridy=2$$\n");
        sb.append("pc||Peso fetal provável (g);;t;;t||cdl@545@||4;;gridx=1$$\n");
        sb.append("pc||;;t;;t||lbln@(pelo D.B.P e C.A.)@cor=0,0,255||4;;gridx=2$$\n");
        sb.append("hs||0||||4;;gridx=3;;gridy=3;;weightx=1$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||;;f;;f||lbln@ D.B.P.@||3;;gridy=0;;gridx=0;;weightx=0$$\n");
        sb.append("pc||em mm  ;;t;;f||cdl@513@||3;;gridx=1$$\n");
        sb.append("pc||I.G.;;t;;f||cdl@640@||3;;gridx=2$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.O.F. (mm);;t;;f||cdl@552@||3;;gridx=3$$\n");
        sb.append("pc||Valor do C.A.;;t;;f||cdl@519@||3;;gridx=4$$\n");
        sb.append("hs||120||||3$$\n");
        sb.append("pc||D.A.P. (mm);;t;;f||cdl@553@1||3;;gridx=5$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||D.L.L. (mm);;t;;f||cdl@554@1||3;;gridx=6$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||Resultados;;t;;t||subcont@4@||3;;gridx=3;;gridy=1;;gridwidth=4;;gridheight=8$$\n");
        sb.append("lbln||C.A.||||3;;gridx=0;;gridheight=1;;gridwidth=1;;left_insets=4;;top_insets=8$$\n");
        sb.append("cdl||520||1||3;;gridx=1$$\n");
        sb.append("cdl||521||1||3$$\n");
        sb.append("cdl||641||||3;;gridx=2$$\n");
        sb.append("lbln||C.F.||||3;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||530||||3;;gridx=1$$\n");
        sb.append("cdl||636||||3;;gridx=2$$\n");
        sb.append("lbln||Úmero||||3;;gridx=0;;gridy=3$$\n");
        sb.append("cdl||536||||3;;gridx=1$$\n");
        sb.append("cdl||637||||3;;gridx=2$$\n");
        sb.append("lbln||Ulna||||3;;gridx=0;;gridy=4$$\n");
        sb.append("cdl||539||||3;;gridx=1$$\n");
        sb.append("cdl||638||||3;;gridx=2$$\n");
        sb.append("lbln||Tíbia||||3;;gridx=0;;gridy=5$$\n");
        sb.append("cdl||542||||3;;gridx=1$$\n");
        sb.append("cdl||639||||3;;gridx=2$$\n");
        sb.append("hs||0||||3;;gridy=8$$\n");
        sb.append("hs||0||||3;;gridx=7;;gridy=9;;weightx=1;;left_insets=0;;top_insets=0$$\n");
        sb.append("pc||Biometria;;f;;f||subcont@3@||gridx=0;;gridy=0;;weightx=0$$\n");

        sb.append("hs||0||||gridy=1;;gridx=1;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

       //  </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto">

        sb.append("494;;Feto 6;;300;;494;;Feto 6$$\n");

        sb.append("pc||Situação;;f;;f||cdl@496@||gridx=0;;gridy=0$$\n");
        sb.append("hs||300||||$$\n");
        sb.append("pc||Apresentação;;t;;f||cdl@497@||gridx=1$$\n");
        sb.append("hs||175||||$$\n");
        sb.append("pc||Dorso;;t;;f||cdl@499@||gridx=2;;gridwidth=2$$\n");

        sb.append("pc||Movimentos fetais;;f;;t||cdl@500@||gridx=0;;gridy=1;;gridwidth=1$$\n");
        sb.append("pc||Movimentos respiratórios;;t;;t||cdl@502@||gridx=1$$\n");

        sb.append("pc||Batimentos cardíacos;;f;;t||cdl@504@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Ritmo;;t;;t||cdl@505@||gridx=1$$\n");
        sb.append("pc||Nº (bat/min);;t;;t||cdl@506@||gridx=2$$\n");
        sb.append("hs||80||||gridx=3$$\n");

        sb.append("hs||0||||gridx=4;;gridy=3;;weighty=1;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Órgãos Internos">

        sb.append("494;;Órgãos internos - Feto 6;;300;;494;;Feto 6$$\n");
        sb.append("pc||Situação;;f;;f||cdl@508@||gridx=0;;gridy=0;;gridwidth=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@509@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||Estadiamento intestinal;;f;;t||cdl@551@||gridx=0;;gridy=2;;gridwidth=2$$\n");
        sb.append("pc||Gordura pré-peritonial;;t;;t||cdl@550@||gridx=2;;gridwidth=1$$\n");
        sb.append("pc||Sexo fetal;;t;;t||cdl@549@||gridx=3$$\n");
        sb.append("pc||t;;t||lbl@@||gridx=5;;weightx=0$$\n");
        sb.append("vs||200||||gridx=5;;gridy=1;;weightx=1$$\n");
        sb.append("hs||150||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Placenta">

        sb.append("494;;Placenta - Feto 6;;300;;494;;Feto 6$$\n");
        sb.append("pc||Inserção 1;;f;;f||cdl@556@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Inserção 2;;t;;f||cdl@557@||gridx=1$$\n");
        sb.append("pc||Espessura (mm);;t;;f||cdl@558@||gridx=2$$\n");
        sb.append("pc||Maturidade;;t;;f||cdl@559@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@560@||gridx=0;;gridy=1;;gridwidth=4$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=4;;gridy=2;;weightx=1;;weighty=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;gridy=1;;weightx=0;;weighty=0$$\n");
        sb.append("hs||180||||gridx=0;;gridy=0$$\n");
        sb.append("hs||220||||gridx=1$$\n");
        sb.append("hs||40||||gridx=2$$\n");
        sb.append("hs||110||||gridx=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Outras informações">

        sb.append("494;;Outras informações - Feto 6;;300;;494;;Feto 6$$\n");
        sb.append("pc||Cordão umbilical;;f;;f||cdl@562@||gridx=0;;gridy=0$$\n");
        sb.append("hs||170||||$$\n");
        sb.append("pc||Líquido amniótico;;t;;f||cdl@564@||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||200||||gridx=2$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||f;;t;;f||lbl@Medidas dos quadrantes (cm)@||1;;gridx=0;;gridy=0;;gridwidth=7$$\n");
        sb.append("pc||I;;t;;f||cdl@565@||1;;gridy=1;;gridwidth=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||II;;t;;f||cdl@566@||1;;gridx=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||III;;t;;f||cdl@567@||1;;gridx=2$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||IV;;t;;f||cdl@568@||1;;gridx=3$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||ILA (cm);;t;;f||cdl@570@||1;;gridx=4$$\n");
        sb.append("hs||70||||1$$\n");
        sb.append("pc||t;;f||cdl@571@||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||ILA (Índice do líquido amniótico);;f;;t||subcont@1@||weightx=0;;gridx=0;;gridwidth=3;;gridy=1$$\n");

        sb.append("hs||0||||gridx=3;;gridy=2;;weightx=1;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("572;;Observações gerais;;300;;494;;Feto 6$$\n");
        sb.append("cdl||574||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("579;;Impressão diagnóstica;;200;;572;;Observações gerais$$\n");
        sb.append("cdl||595||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||593||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("pc||Imprimir DPP;;f;;t||cdl@643@||gridx=0;;gridy=2;;weightx=0$$\n");
        sb.append("hs||0||||gridy=3;;weighty=1$$\n");
        sb.append("\n##\n");
        //cid 10
        sb.append("\n579\n");
        // </editor-fold>

        alterarVisaoDeLaudo(31);

    }

    public static void main (String[] args) throws Exception
    {
        morfologicoFetal();
        obs14semanasComRef();
    }

}
