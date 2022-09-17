/*
 * V_Outros.java
 *
 * Created on 29/08/2012, 09:53:00
 */

package com.ic.projects.laudoecia.mdl;

import java.awt.GridBagConstraints;

/**
 *
 * @author Tekna <informatica@instrumental.net.br>
 */
public class V_Outros extends View
{

    static void videoColposcopiaUS () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento">

        sb.append("0;;Dados do equipamento$$\n");
        sb.append("pc||Tipo;;f;;f||cdl@2@||gridx=0;;gridy=0$$\n");
        sb.append("hs||160||||$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@3@||gridwidth=2;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vulvoscopia">

        sb.append("4;;Vulvoscopia;;200;;0;;Dados do equipamento$$\n");
        sb.append("cdl||8||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||6||||gridwidth=2;;gridy=1;;gridx=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vaginoscopia">

        sb.append("9;;Vaginoscopia;;200;;4;;Vulvoscopia$$\n");
        sb.append("cdl||13||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||11||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Cervicoscopia">

        sb.append("14;;Cervicoscopia;;200;;9;;Vaginoscopia$$\n");
        sb.append("pc||Cervicoscopia;;f;;f||cdl@16@||gridx=0$$\n");
        sb.append("hs||140||||$$\n");
        sb.append("pc||Forma do colo;;t;;f||cdl@18@||gridx=1$$\n");
        sb.append("hs||120||||$$\n");
        sb.append("pc||Posição;;t;;f||cdl@19@||gridx=2$$\n");
        sb.append("hs||160||||$$\n");
        sb.append("pc||Volume;;t;;f||cdl@21@||gridx=3$$\n");
        sb.append("hs||140||||$$\n");
        sb.append("pc||Orifício extremo;;f;;t||cdl@22@||gridx=0;;gridy=1$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Junção escamo;;t;;t||cdl@24@||gridx=1$$\n");
        sb.append("pc||JEC - localização;;t;;t||cdl@25@||gridx=2;;gridwidth=2$$\n");
        sb.append("pc||Altura da JEC (mm);;f;;t||cdl@26@||gridx=0;;gridy=2;;gridwidth=1$$\n");
//        sb.append("pc||t;;f||lbl@@||gridx=4$$\n");
        sb.append("pc||Epitélio escamoso;;t;;t||cdl@28@||gridx=1;;gridwidth=2$$\n");
        sb.append("pc||Epitélio cilíndrico;;t;;t||cdl@30@||gridx=3;;gridwidth=1$$\n");
        sb.append("pc||Ectrópio;;f;;t||cdl@32@||gridx=0;;gridy=3$$\n");
        sb.append("pc||Zona de transformação;;t;;t||cdl@34@||gridx=1$$\n");
        sb.append("hs||0||||gridy=4;;gridx=0;;weighty=1;;gridwidth=1$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=6;;weightx=1$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Colposcopia alargada">

        sb.append("35;;Colposcopia alargada;;250;;14;;Cervicoscopia$$\n");
        sb.append("cdl||39||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||37||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observação do colo">

        sb.append("40;;Observação do colo;;200;;35;;Colposcopia alargada$$\n");
        sb.append("cdl||42||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biópsia">

        sb.append("43;;Biópsia;;200;;40;;Observação do colo$$\n");
        sb.append("cdl||47||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||45||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("48;;Observações gerais;;200;;43;;Biópsia$$\n");
        sb.append("cdl||50||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("51;;Impressão diagnóstica;;200;;40;;Observações gerais$$\n");
        sb.append("cdl||55||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||53||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        //cid 10
        sb.append("\n51\n");

        // </editor-fold>

        alterarVisaoDeLaudo(12);

    }

    static void videoColposcopiaIFCP2011 () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Indicação do exame">

        sb.append("0;;Indicação do exame$$\n");
        sb.append("cdl||2||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||330||||$$\n");
        sb.append("cdl||3||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vulva">

        sb.append("4;;Vulva;;200;;0;;Indicação do exame$$\n");
        sb.append("cdl||6||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||7||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Colo uterino">

        // <editor-fold defaultstate="collapsed" desc="Visibilidade da junção escamocolunar">

        sb.append("9;;Colo uterino - Visibilidade da junção escamocolunar;;200;;4;;Vulva$$\n");
        sb.append("cdl||11||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||13||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Zona de transformação">

        sb.append("9;;Colo uterino - Zona de transformação;;300;;9;;Colo uterino$$\n");
        sb.append("cdl||15||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||17||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Epitélio escamoso original">

        sb.append("9;;Colo uterino - Epitélio escamoso original;;200;;9;;Colo uterino$$\n");
        sb.append("cdl||19||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||21||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Epitélio colunar">

        sb.append("9;;Colo uterino - Epitélio colunar;;200;;9;;Colo uterino$$\n");
        sb.append("cdl||23||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||25||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Epitélio escamoso metaplástico">

        sb.append("9;;Colo uterino - Epitélio escamoso metaplástico;;200;;9;;Colo uterino$$\n");
        sb.append("cdl||27||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||320||||$$\n");
        sb.append("cdl||29||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Localização e tamanho da lesão">

        sb.append("9;;Colo uterino - Localização e tamanho da lesão;;200;;9;;Colo uterino$$\n");
        sb.append("pc||Valor;;f;;f||cdl@31@||gridx=0;;gridy=0$$\n");
        sb.append("hs||160||||$$\n");
        sb.append("pc||Posição (Horas);;t;;f||cdl@32@||gridx=1$$\n");
        sb.append("pc||Quadrantes envolvidos;;t;;f||cdl@33@||gridx=2$$\n");
        sb.append("pc||% do colo uterino lesionado;;t;;f||cdl@34@||gridx=3$$\n");
        sb.append("hs||50||||gridx=4$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@36@||gridwidth=5;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=6;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Grau de lesão">

        sb.append("9;;Colo uterino - Grau de lesão;;200;;9;;Colo uterino$$\n");
        sb.append("cdl||38||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||250||||$$\n");
        sb.append("cdl||40||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Suspeita de invasão">

        sb.append("9;;Colo uterino - Suspeita de invasão;;200;;9;;Colo uterino$$\n");
        sb.append("cdl||42||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||250||||$$\n");
        sb.append("cdl||44||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biópsia">

        sb.append("9;;Colo uterino - Biópsia;;200;;9;;Colo uterino$$\n");
        sb.append("cdl||46||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||48||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vagina">

        // <editor-fold defaultstate="collapsed" desc="Epitélio escamoso original">

        sb.append("49;;Vagina - Epitélio escamoso original;;200;;9;;Colo uterino$$\n");
        sb.append("cdl||51||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||53||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Epitélio acetobranco tênue">

        sb.append("49;;Vagina - Epitélio acetobranco tênue;;300;;49;;Vagina$$\n");
        sb.append("cdl||55||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||57||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Epitélio acetobranco denso">

        sb.append("49;;Vagina - Epitélio acetobranco denso;;200;;49;;Vagina$$\n");
        sb.append("cdl||59||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||61||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vasos atípicos">

        sb.append("49;;Vagina - Vasos atípicos;;200;;49;;Vagina$$\n");
        sb.append("cdl||63||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||65||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Epitélio colunar">

        sb.append("49;;Vagina - Epitélio colunar;;200;;49;;Vagina$$\n");
        sb.append("cdl||67||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||69||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("70;;Impressão diagnóstica;;200;;49;;Vagina$$\n");
        sb.append("cdl||74||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||72||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        //cid 10
        sb.append("\n70\n");

        // </editor-fold>

        alterarVisaoDeLaudo(26);

    }

    static void videoColposcopiaIFCP2011Revisado () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Indicação do exame">

        sb.append("0;;Indicação do exame$$\n");
        sb.append("cdl||2||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||330||||$$\n");
        sb.append("cdl||3||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vulvoscopia">

        sb.append("4;;Vulvoscopia;;200;;0;;Indicação do exame$$\n");
        sb.append("pc||Valor;;f;;f||cdl@6@||gridx=0;;gridy=0$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("pc||Área(s) esbranquiçada(s);;t;;f||cdl@7@||gridx=1$$\n");
        sb.append("hs||350||||gridx=1$$\n");
        sb.append("hs||40||||gridx=2$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@8@||gridwidth=3;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=6;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vagina">

        sb.append("10;;Vagina;;200;;4;;Vulvoscopia$$\n");
        sb.append("cdl||12||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||350||||$$\n");
        sb.append("cdl||13||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Cervicoscopia">

        // <editor-fold defaultstate="collapsed" desc="Visibilidade da JEC">

        sb.append("14;;Cervicoscopia - Visibilidade da JEC;;200;;10;;Vagina$$\n");
        sb.append("cdl||16||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||18||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Localização da JEC">

        sb.append("14;;Cervicoscopia - Localização da JEC;;200;;14;;Cervicoscopia$$\n");
        sb.append("cdl||20||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||175||||$$\n");
        sb.append("cdl||22||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Zona de transformação">

        sb.append("14;;Cervicoscopia - Zona de transformação;;300;;14;;Cervicoscopia$$\n");
        sb.append("cdl||24||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||26||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Localização e tamanho da lesão">

        sb.append("14;;Cervicoscopia - Localização e tamanho da lesão;;200;;14;;Cervicoscopia$$\n");
        sb.append("pc||Valor;;f;;f||cdl@28@||gridx=0;;gridy=0$$\n");
        sb.append("hs||160||||$$\n");
        sb.append("pc||Posição (Horas);;t;;f||cdl@30@||gridx=1$$\n");
        sb.append("pc||Quadrantes envolvidos;;t;;f||cdl@34@||gridx=2$$\n");
        sb.append("pc||% do colo uterino lesionado;;t;;f||cdl@32@||gridx=3$$\n");
        sb.append("hs||50||||gridx=4$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@36@||gridwidth=5;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=6;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Grau de lesão">

        sb.append("37;;Cervicoscopia - Grau de lesão;;200;;14;;Cervicoscopia$$\n");
        sb.append("cdl||38||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||350||||$$\n");
        sb.append("cdl||40||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Achados anormais">

        sb.append("14;;Cervicoscopia - Achados anormais;;200;;14;;Cervicoscopia$$\n");
        sb.append("cdl||42||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||250||||$$\n");
        sb.append("cdl||44||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Captação do Lugol">

        sb.append("14;;Cervicoscopia - Captação do Lugol;;200;;14;;Cervicoscopia$$\n");
        sb.append("cdl||46||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||48||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biópsia">

        sb.append("14;;Cervicoscopia - Biópsia;;200;;14;;Cervicoscopia$$\n");
        sb.append("cdl||50||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||450||||$$\n");
        sb.append("cdl||52||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações">

        sb.append("53;;Observações;;250;;13;;Cervicoscopia$$\n");
        sb.append("cdl||55||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("56;;Impressão diagnóstica;;200;;53;;Observações$$\n");
        sb.append("cdl||60||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||350||||$$\n");
        sb.append("cdl||58||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        //cid 10
        sb.append("\n56\n");

        // </editor-fold>

        alterarVisaoDeLaudo(30);

    }

    static void tireoide() throws Exception
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

        // <editor-fold defaultstate="collapsed" desc="Pele">

        sb.append("4;;Pele;;250;;0;;Dados do equipamento$$\n");
        sb.append("cdl||8||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||6||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Músculos pré-tireoidianos">

        sb.append("9;;Músculos pré-tireoidianos;;250;;4;;Pele$$\n");
        sb.append("cdl||13||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||11||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Carótidas">

        sb.append("14;;Carótidas;;250;;9;;Músculos pré-tireoidianos$$\n");
        sb.append("cdl||18||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||16||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tireoide">

        sb.append("19;;Tireoide;;250;;14;;Carótidas$$\n");
        sb.append("cdl||23||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||21||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Tireoide - Lobo Direito">

        sb.append("24;;Tireoide - lobo direito;;250;;19;;Tireoide$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;f||cdl@29@||$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;f||cdl@30@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;f||cdl@31@||gridx=2$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=3$$\n");
        sb.append("pc||Volume (cm³);;f;;t||cdl@32@||gridx=0;;gridy=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@27@||gridwidth=2;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||26||||gridx=0;;gridy=3;;gridwidth=4;;top_insets=0;;left_insets=2$$\n");
        sb.append("vs||200||||gridx=5;;weightx=1;;weighty=0$$\n");
        sb.append("hs||0||||gridy=4;;gridx=0;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tireoide - Lobo Esquerdo">

        sb.append("33;;Tireoide - lobo esquerdo;;250;;19;;Tireoide$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;f||cdl@38@||$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;f||cdl@39@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;f||cdl@40@||gridx=2$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=3$$\n");
        sb.append("pc||Volume (cm³);;f;;t||cdl@41@||gridx=0;;gridy=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@36@||gridwidth=2;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||35||||gridx=0;;gridy=3;;gridwidth=4;;top_insets=0;;left_insets=2$$\n");
        sb.append("vs||200||||gridx=5;;weightx=1;;weighty=0$$\n");
        sb.append("hs||0||||gridy=4;;gridx=0;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Istmo">

        sb.append("42;;Tireoide - istmo;;250;;19;;Tireoide$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;f||cdl@47@||$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;f||cdl@48@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;f||cdl@49@||gridx=2$$\n");
        sb.append("pc||t;;f||lbl@@||gridx=3$$\n");
        sb.append("pc||Volume (cm³);;f;;t||cdl@50@||gridx=0;;gridy=1$$\n");
        sb.append("pc||Volume total(cm³);;t;;t||cdl@53@||gridx=1;;gridy=1$$\n");
        sb.append("pc||f;;t;;t||lbln@" + getRefTir() + "@||gridx=2;;gridy=1;;gridwidth=2;;gridheight=2$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@45@||gridwidth=2;;gridx=0;;gridy=2;;gridheight=1$$\n");
        sb.append("cdl||44||||gridx=0;;gridy=3;;gridwidth=4;;top_insets=0;;left_insets=2$$\n");
        sb.append("vs||200||||gridx=5;;weightx=1;;weighty=0$$\n");
        sb.append("hs||0||||gridy=4;;gridx=0;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("54;;Observações gerais;;250;;19;;Tireoide$$\n");
        sb.append("cdl||56||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("57;;Impressão diagnóstica;;250;;54;;Observações gerais$$\n");
        sb.append("cdl||61||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||59||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("\n57\n");

        // </editor-fold>

        alterarVisaoDeLaudo(19);

    }

    static void transfontanelaCranio() throws Exception
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

        // <editor-fold defaultstate="collapsed" desc="Estruturas do Eco Médio">

        sb.append("4;;Estruturas do eco médio;;250;;0;;Dados do equipamento$$\n");
        sb.append("cdl||8||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||6||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Parênquima Cerebral">

        sb.append("9;;Parênquima cerebral;;250;;4;;Estruturas do eco médio$$\n");
        sb.append("cdl||13||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||11||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tálamo">

        sb.append("14;;Tálamo;;250;;9;;Parênquima cerebral$$\n");
        sb.append("cdl||18||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||16||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Núcleos da Base">

        sb.append("19;;Núcleos da base;;250;;14;;Tálamo$$\n");
        sb.append("cdl||23||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||21||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ventrílucos">

        sb.append("24;;Ventrílucos;;250;;19;;Núcleos da base$$\n");
        sb.append("cdl||28||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||26||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Plexos Coroides">

        sb.append("29;;Plexos coroides;;250;;24;;Ventrílucos$$\n");
        sb.append("cdl||33||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||31||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fossa Posterior">

        sb.append("34;;Fossa posterior;;250;;29;;Plexos coroides$$\n");
        sb.append("cdl||38||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||36||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Espaço Subdural">

        sb.append("39;;Espaço subdural;;250;;34;;Fossa posterior$$\n");
        sb.append("cdl||43||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||41||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("44;;Observações gerais;;250;;39;;Espaço subdural$$\n");
        sb.append("cdl||46||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("47;;Impressão diagnóstica;;250;;44;;Observações gerais$$\n");
        sb.append("cdl||51||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||49||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        //cid 10
        sb.append("\n47\n");

        // </editor-fold>

        alterarVisaoDeLaudo(20);

    }

    static void rinsAparelhoUrinarioMasc() throws Exception
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

        // <editor-fold defaultstate="collapsed" desc="Rim direito">
        sb.append("4;;Rim direito;;200;;0;;Dados do equipamento$$\n");
        sb.append("pc||Presença;;f;;f||cdl@6@||gridx=0;;gridy=0$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Topicidade;;t;;f||cdl@7@||gridx=1$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Volume;;t;;f||cdl@8@||gridx=2$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Contorno;;t;;f||cdl@9@||gridx=3$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Textura;;f;;t||cdl@11@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||Seio renal;;t;;t||cdl@13@||gridx=2;;gridwidth=1$$\n");
        sb.append("pc||Hidronefrose;;t;;t||cdl@15@||gridx=3$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;t||cdl@17@||gridy=2;;gridx=0$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;t||cdl@18@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;t||cdl@19@||gridx=2$$\n");
        sb.append("pc||Espessura do parênquima;;f;;t||cdl@23@||gridy=3;;gridx=0$$\n");
        sb.append("pc||Volume (cm³);;t;;t||cdl@21@||gridx=1$$\n");
//        sb.append("pc||Valores normais para o volume:;;t;;t||lbl@ Idade 46a e 2m: 125 a 300 cm³@||gridx=2$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@25@||gridx=0;;gridy=4;;gridwidth=4$$\n");
        sb.append("vs||200||||gridx=5;;weightx=1;;weighty=0$$\n");
        sb.append("hs||0||||gridy=5;;gridx=0;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Rim esquerdo">

        sb.append("26;;Rim esquerdo;;200;;4;;Rim direito$$\n");
        sb.append("pc||Presença;;f;;f||cdl@28@||gridx=0;;gridy=0$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Topicidade;;t;;f||cdl@29@||gridx=1$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Volume;;t;;f||cdl@30@||gridx=2$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Contorno;;t;;f||cdl@31@||gridx=3$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Textura;;f;;t||cdl@33@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||Seio renal;;t;;t||cdl@35@||gridx=2;;gridwidth=1$$\n");
        sb.append("pc||Hidronefrose;;t;;t||cdl@37@||gridx=3$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;t||cdl@39@||gridy=2;;gridx=0$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;t||cdl@40@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;t||cdl@41@||gridx=2$$\n");
        sb.append("pc||Espessura do parênquima;;f;;t||cdl@45@||gridy=3;;gridx=0$$\n");
        sb.append("pc||Volume (cm³);;t;;t||cdl@43@||gridx=1$$\n");
//        sb.append("pc||Valores normais para o volume:;;t;;t||lbl@ Idade 46a e 2m: 125 a 300 cm³@||gridx=2$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@47@||gridx=0;;gridy=4;;gridwidth=4$$\n");
        sb.append("vs||200||||gridx=5;;weightx=1;;weighty=0$$\n");
        sb.append("hs||0||||gridy=5;;gridx=0;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais rins">

        sb.append("48;;Informações complementares dos rins;;300;;26;;Rim esquerdo$$\n");
        sb.append("cdl||50||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Bexiga">
         sb.append("51;;Bexiga;;200;;48;;Informações complementares dos rins$$\n");
        sb.append("pc||Posição;;f;;f||cdl@53@||gridx=0;;gridy=0$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Morfologia;;t;;f||cdl@54@||gridx=1$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Superfície;;t;;f||cdl@55@||gridx=2$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Contornos;;t;;f||cdl@57@||gridx=3$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Conteúdo;;f;;t||cdl@58@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||Assoalho;;t;;t||cdl@60@||gridx=2;;gridwidth=1$$\n");
        sb.append("pc||Capacidade;;t;;t||cdl@62@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@64@||gridx=0;;gridy=4;;gridwidth=4$$\n");
        sb.append("vs||200||||gridx=5;;weightx=1;;weighty=0$$\n");
        sb.append("hs||0||||gridy=5;;gridx=0;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("65;;Observações gerais;;200;;51;;Bexiga$$\n");
        sb.append("cdl||67||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("68;;Impressão diagnóstica;;200;;65;;Observações gerais$$\n");
        sb.append("cdl||72||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||70||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        //cid 10
        sb.append("\n68\n");
        // </editor-fold>

        alterarVisaoDeLaudo(21);

    }

    static void mamas () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento">

        sb.append("0;;Dados do equipamento$$\n");
        sb.append("pc||Tipo;;f;;f||cdl@2@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@3@||gridwidth=5;;gridy=1$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||f;;t||lbln@\"Enter\" para digitar o laudo@fonte=16||gridx=0;;weightx=0;;gridy=2$$\n");
        sb.append("pc||t;;t||cdl@66@||gridx=1$$\n");
        sb.append("hs||40||||$$\n");
        sb.append("pc||t;;t||lbln@ ou @fonte=16||gridx=2$$\n");
        sb.append("pc||t;;t||btn@Autocompletar 'normal'@action=tn||gridx=3$$\n");
        sb.append("hs||10||||gridx=4$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ciclo Menstrual">

        sb.append("62;;Ciclo menstrual;;200;;0;;Dados do equipamento$$\n");
        sb.append("pc||Data do exame    ;;f;;f||cdl@63@||$$\n");
        sb.append("pc||D.U.M.;;t;;f||cdl@64@||gridx=1$$\n");
        sb.append("hs||100||||$$\n");
        sb.append("pc||Dia do ciclo;;t;;f||cdl@65@||gridx=2$$\n");
        sb.append("pc||f;;t||lbln@\"Enter\" para avançar@fonte=16||"
                + "gridwidth=2;;gridx=0;;gridy=1;;anchor=").append(
                GridBagConstraints.EAST).append(";;fill=").append(
                GridBagConstraints.NONE).append("$$\n");
        sb.append("pc||t;;t||cdl@66@||gridwidth=1;;gridx=2;;fill=").append(
                GridBagConstraints.BOTH).append("$$\n");
        sb.append("hs||0||||gridy=2;;gridx=3;;weighty=1;;weightx=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Mama direita">

        // <editor-fold defaultstate="collapsed" desc="Pele">

        sb.append("4;;Mama direita - pele;;200;;0;;Dados do equipamento$$\n");
        sb.append("cdl||8||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||6||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Complexo aréolo-papilar">
        sb.append("9;;Mama direita - complexo aréolo-papilar;;300;;4;;Mama direita$$\n");
        sb.append("cdl||12||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||10||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tecido celular subcutâneo">

        sb.append("13;;Mama direita - tecido celular subcutâneo;;300;;4;;Mama direita$$\n");
        sb.append("cdl||16||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||14||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Parênquima glandular">

        sb.append("17;;Mama direita - parênquima glandular;;300;;4;;Mama direita$$\n");
        sb.append("cdl||20||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||18||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fascia retromamária">

        sb.append("21;;Mama direita - fascia retromamária;;300;;4;;Mama direita$$\n");
        sb.append("cdl||24||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||22||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais sobre a mama direita">

        sb.append("25;;Mama direita - observações gerais;;300;;4;;Mama direita$$\n");
        sb.append("cdl||26||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Mama esquerda">

        // <editor-fold defaultstate="collapsed" desc="Pele">

        sb.append("27;;Mama esquerda - pele;;300;;4;;Mama direita$$\n");
        sb.append("cdl||31||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||29||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Complexo aréolo-papilar">

        sb.append("32;;Mama esquerda - complexo aréolo-papilar;;300;;27;;Mama esquerda$$\n");
        sb.append("cdl||35||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||33||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tecido celular subcutâneo">

        sb.append("36;;Mama esquerda - tecido celular subcutâneo;;300;;27;;Mama esquerda$$\n");
        sb.append("cdl||39||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||37||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Parênquima glandular">

        sb.append("40;;Mama esquerda - parênquima glandular;;300;;27;;Mama esquerda$$\n");
        sb.append("cdl||43||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||41||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fascia retromamária">

        sb.append("44;;Mama esquerda - fascia retromamária;;300;;27;;Mama esquerda$$\n");
        sb.append("cdl||47||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||45||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais sobre a mama esquerda">

        sb.append("48;;Mama esquerda - observações gerais;;300;;27;;Mama esquerda$$\n");
        sb.append("cdl||49||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("50;;Observações gerais;;200;;48;;Mama esquerda$$\n");
        sb.append("cdl||52||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("53;;Impressão diagnóstica;;200;;50;;Observações gerais$$\n");
        sb.append("cdl||57||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||320||||$$\n");
        sb.append("cdl||55||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("pc||Categoria - BIRADS;;f;;t||cdl@59@||weightx=0;;gridx=0;;gridy=2$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        sb.append("\n53\n");

        alterarVisaoDeLaudo(10);

    }

    static void monitoracaoOvulacaoEndovaginal() throws Exception
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

        //dum
        sb.append("4;;Data da última menstruação;;200;;0;;Dados do equipamento$$\n");
        sb.append("pc||Dum;;f;;f||cdl@5@||gridy=0;;gridx=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Quantidade de ultrassons;;t;;f||cdl@6@||gridy=0;;gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("vs||0||||gridwidth=1;;gridx=2;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=1;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 1">

        sb.append("7;;Ultrassom 1;;200;;0;;Dados do equipamento$$\n");
        sb.append("pc||Data;;f;;f||cdl@9@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Dia do ciclo;;t;;f||cdl@10@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Tipo do endométrio;;t;;f||cdl@11@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Espessura do endométrio (mm);;t;;f||cdl@12@||gridx=3$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Ovário direito (folículos);;f;;t||cdl@14@||gridwidth=4;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=4;;weightx=1$$\n");
        sb.append("pc||Ovário esquerdo (folículos);;f;;t||cdl@16@||gridwidth=4;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=5;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");


        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 2">

        sb.append("17;;Ultrassom 2;;200;;7;;Ultrassom 1$$\n");
        sb.append("pc||Data;;f;;f||cdl@19@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Dia do ciclo;;t;;f||cdl@20@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Tipo do endométrio;;t;;f||cdl@21@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Espessura do endométrio (mm);;t;;f||cdl@22@||gridx=3$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Ovário direito (folículos);;f;;t||cdl@24@||gridwidth=4;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=4;;weightx=1$$\n");
        sb.append("pc||Ovário esquerdo (folículos);;f;;t||cdl@26@||gridwidth=4;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=5;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");


        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 3">

        sb.append("27;;Ultrassom 3;;200;;17;;Ultrassom 2$$\n");
        sb.append("pc||Data;;f;;f||cdl@29@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Dia do ciclo;;t;;f||cdl@30@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Tipo do endométrio;;t;;f||cdl@31@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Espessura do endométrio (mm);;t;;f||cdl@32@||gridx=3$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Ovário direito (folículos);;f;;t||cdl@34@||gridwidth=4;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=4;;weightx=1$$\n");
        sb.append("pc||Ovário esquerdo (folículos);;f;;t||cdl@36@||gridwidth=4;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=5;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");


        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 4">

        sb.append("37;;Ultrassom 4;;200;;27;;Ultrassom 3$$\n");
        sb.append("pc||Data;;f;;f||cdl@39@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Dia do ciclo;;t;;f||cdl@40@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Tipo do endométrio;;t;;f||cdl@41@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Espessura do endométrio (mm);;t;;f||cdl@42@||gridx=3$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Ovário direito (folículos);;f;;t||cdl@44@||gridwidth=4;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=4;;weightx=1$$\n");
        sb.append("pc||Ovário esquerdo (folículos);;f;;t||cdl@46@||gridwidth=4;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=5;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");


        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 5">

        sb.append("47;;Ultrassom 5;;200;;37;;Ultrassom 4$$\n");
        sb.append("pc||Data;;f;;f||cdl@49@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Dia do ciclo;;t;;f||cdl@50@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Tipo do endométrio;;t;;f||cdl@51@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Espessura do endométrio (mm);;t;;f||cdl@52@||gridx=3$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Ovário direito (folículos);;f;;t||cdl@54@||gridwidth=4;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=4;;weightx=1$$\n");
        sb.append("pc||Ovário esquerdo (folículos);;f;;t||cdl@56@||gridwidth=4;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=5;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");


        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 6">

        sb.append("57;;Ultrassom 6;;200;;47;;Ultrassom 5$$\n");
        sb.append("pc||Data;;f;;f||cdl@59@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Dia do ciclo;;t;;f||cdl@60@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Tipo do endométrio;;t;;f||cdl@61@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Espessura do endométrio (mm);;t;;f||cdl@62@||gridx=3$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Ovário direito (folículos);;f;;t||cdl@64@||gridwidth=4;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=4;;weightx=1$$\n");
        sb.append("pc||Ovário esquerdo (folículos);;f;;t||cdl@66@||gridwidth=4;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=5;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");


        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 7">

        sb.append("67;;Ultrassom 7;;200;;57;;Ultrassom 6$$\n");
        sb.append("pc||Data;;f;;f||cdl@69@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Dia do ciclo;;t;;f||cdl@70@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Tipo do endométrio;;t;;f||cdl@71@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Espessura do endométrio (mm);;t;;f||cdl@72@||gridx=3$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Ovário direito (folículos);;f;;t||cdl@74@||gridwidth=4;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=4;;weightx=1$$\n");
        sb.append("pc||Ovário esquerdo (folículos);;f;;t||cdl@76@||gridwidth=4;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=5;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");


        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 8">

        sb.append("77;;Ultrassom 8;;200;;67;;Ultrassom 7$$\n");
        sb.append("pc||Data;;f;;f||cdl@79@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Dia do ciclo;;t;;f||cdl@80@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Tipo do endométrio;;t;;f||cdl@81@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Espessura do endométrio (mm);;t;;f||cdl@82@||gridx=3$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Ovário direito (folículos);;f;;t||cdl@84@||gridwidth=4;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=4;;weightx=1$$\n");
        sb.append("pc||Ovário esquerdo (folículos);;f;;t||cdl@86@||gridwidth=4;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=5;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");


        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 9">

        sb.append("87;;Ultrassom 9;;200;;77;;Ultrassom 8$$\n");
        sb.append("pc||Data;;f;;f||cdl@89@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Dia do ciclo;;t;;f||cdl@90@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Tipo do endométrio;;t;;f||cdl@91@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Espessura do endométrio (mm);;t;;f||cdl@92@||gridx=3$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Ovário direito (folículos);;f;;t||cdl@94@||gridwidth=4;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=4;;weightx=1$$\n");
        sb.append("pc||Ovário esquerdo (folículos);;f;;t||cdl@96@||gridwidth=4;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=5;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 10">

        sb.append("97;;Ultrassom 10;;200;;87;;Ultrassom 9$$\n");
        sb.append("pc||Data;;f;;f||cdl@99@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Dia do ciclo;;t;;f||cdl@100@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Tipo do endométrio;;t;;f||cdl@101@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Espessura do endométrio (mm);;t;;f||cdl@102@||gridx=3$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Ovário direito (folículos);;f;;t||cdl@104@||gridwidth=4;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=4;;weightx=1$$\n");
        sb.append("pc||Ovário esquerdo (folículos);;f;;t||cdl@106@||gridwidth=4;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=5;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados clínicos">

        sb.append("107;;Dados clínicos;;200;;87;;Ultrassom 9$$\n");
        sb.append("cdl||111||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||109||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Esquema de indução">
        sb.append("112;;Esquema de indução;;200;;107;;Dados clínicos$$\n");
        sb.append("cdl||116||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||114||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="H.C.G.:">
        sb.append("117;;H.C.G.;;200;;112;;Esquema de indução$$\n");
        sb.append("cdl||121||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||119||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Suplementação fase 2">
        sb.append("122;;Suplementação fase 2;;200;;117;;H.C.G.$$\n");
        sb.append("cdl||126||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||124||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Resposta folicular">
        sb.append("127;;Resposta folicular;;200;;122;;Suplementação fase 2$$\n");
        sb.append("cdl||131||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||129||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Resposta endometrial">
        sb.append("132;;Resposta endometrial;;200;;127;;Resposta folicular$$\n");
        sb.append("cdl||136||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||134||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Resposta fase lútea">
        sb.append("137;;Resposta fase lútea;;200;;132;;Resposta endometrial$$\n");
        sb.append("cdl||141||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||139||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Procedimento realizado">
        sb.append("142;;Procedimento realizado;;200;;137;;Resposta fase lútea$$\n");
        sb.append("cdl||146||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||144||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("147;;Observações gerais;;200;;142;;Procedimento realizado$$\n");
        sb.append("cdl||149||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("150;;Impressão diagnóstica;;200;;147;;Observações gerais$$\n");
        sb.append("cdl||154||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||152||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        //cid 10
        sb.append("\n150\n");
        // </editor-fold>

        alterarVisaoDeLaudo(23);

    }

    static void colonoscopia () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Indicação clínica">

        sb.append("0;;Indicação clínica$$\n");
        sb.append("cdl||4||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||2||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;weighty=1;;left_insets=3$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pré-medicação">

        sb.append("5;;Pré-medicação;;300;;0;;Indicação clínica$$\n");
        sb.append("cdl||9||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||7||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;weighty=1;;left_insets=3$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Inspeção anal">

        sb.append("10;;Inspeção anal;;300;;5;;Pré-medicação$$\n");
        sb.append("cdl||14||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||12||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;weighty=1;;left_insets=3$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Toque retal">

        sb.append("15;;Toque retal;;300;;10;;Inspeção anal$$\n");
        sb.append("cdl||19||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||17||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;weighty=1;;left_insets=3$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Canal anal e reto">

        sb.append("20;;Canal anal e reto;;300;;15;;Toque retal$$\n");
        sb.append("cdl||24||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||22||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;weighty=1;;left_insets=3$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Cólon sigmóide">

        sb.append("25;;Cólon sigmóide;;300;;20;;Canal anal e reto$$\n");
        sb.append("cdl||29||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||27||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;weighty=1;;left_insets=3$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Cólon descendente">

        sb.append("30;;Cólon descendente;;300;;25;;Cólon sigmóide$$\n");
        sb.append("cdl||34||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||32||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;weighty=1;;left_insets=3$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Cólon transverso">

        sb.append("35;;Cólon transverso;;300;;30;;Cólon descendente$$\n");
        sb.append("cdl||39||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||37||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;weighty=1;;left_insets=3$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Cólon ascendente e ceco">

        sb.append("40;;Cólon ascendente e ceco;;300;;35;;Cólon transverso$$\n");
        sb.append("cdl||44||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||42||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;weighty=1;;left_insets=3$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("45;;Impressão diagnóstica;;300;;40;;Cólon ascendente e ceco$$\n");
        sb.append("cdl||49||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||47||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;weighty=1;;left_insets=3$$\n");

        sb.append("\n##\n");

        //cid 10
        sb.append("\n45\n");

        // </editor-fold>

        alterarVisaoDeLaudo(29);

    }

    public static void main (String[] args) throws Exception
    {
        videoColposcopiaUS();
        videoColposcopiaIFCP2011();
        videoColposcopiaIFCP2011Revisado();
        tireoide();
        transfontanelaCranio();
        rinsAparelhoUrinarioMasc();
        mamas();
        monitoracaoOvulacaoEndovaginal();
        colonoscopia();
    }

    private static String getRefTir ()
    {
        return "<html><p style=\"margin-top: 0\"><font size=\"2\">Referências</font></p>" +
"<p style=\"margin-top: 0\"><font size=\"2\">0 a 5 anos: 0 a 2 cm³&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;11 anos: 5,7 a 10,9 cm³</font></p>\n" +
"<p style=\"margin-top: 0\"><font size=\"2\">7 anos: 2,79 a 5,89 cm³&nbsp;&nbsp;&nbsp;&nbsp;12 anos: 5,81 a 11,61 cm³</font></p>\n" +
"<p style=\"margin-top: 0\"><font size=\"2\">8 anos: 3,05 a 6,99 cm³&nbsp;&nbsp;&nbsp;&nbsp;13 anos: 6,35 a 12,99 cm³</font></p>\n" +
"<p style=\"margin-top: 0\"><font size=\"2\">9 anos: 3,64 a 7,64 cm³&nbsp;&nbsp;&nbsp;&nbsp;14 anos: 7,66 a 15,86 cm³</font></p>\n" +
"<p style=\"margin-top: 0\"><font size=\"2\">10 anos: 4,21 a 9,61 cm³&nbsp;&nbsp;&nbsp;&nbsp;Maior de 15 anos: 8,4 a 14,6 cm³</font></p></html>";
    }

}
