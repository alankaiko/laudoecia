
/*
 * V_Endoscopia_Laparoscopia_Abdomen.java
 *
 * Created on 20/06/2012, 09:35:13
 */
package com.ic.projects.laudoecia.mdl;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class V_Endoscopia_Laparoscopia_Abdomen extends View
{

    static void laparoscopiaDigestivaComOuSemBiopsia() throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Dados técnicos">

        sb.append("0;;Dados técnicos$$\n");
        sb.append("cdl||9||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||7||||gridy=1;;gridwidth=3;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=4;;gridy=1;;weightx=1;;gridwidth=1$$\n");
        sb.append("pc||Anestesia;;f;;t||cdl@2@||gridx=0;;gridy=2;;weightx=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Número de punções;;t;;t||cdl@3@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Medidas das punções (mm);;t;;t||cdl@5@||gridx=2$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Cavidade Peritoneal">
        sb.append("10;;Cavidade peritoneal;;200;;0;;Dados técnicos$$\n");
        sb.append("cdl||14||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||12||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Bexiga">
        sb.append("15;;Bexiga;;200;;10;;Cavidade peritoneal$$\n");
        sb.append("cdl||19||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||17||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Útero">
        sb.append("20;;Útero;;200;;15;;Bexiga$$\n");
        sb.append("cdl||24||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||22||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tuba direita">
        sb.append("25;;Tuba direita;;200;;20;;Útero$$\n");
        sb.append("cdl||29||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||27||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;weightx=1$$\n");
        sb.append("pc||Cromotubagem;;f;;t||cdl@31@||gridx=0;;gridy=2;;weightx=0$$\n");
        sb.append("hs||250||||$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tuba esquerda">
        sb.append("32;;Tuba esquerda;;200;;25;;Tuba direita$$\n");
        sb.append("cdl||36||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||34||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;weightx=1$$\n");
        sb.append("pc||Cromotubagem;;f;;t||cdl@38@||gridx=0;;gridy=2;;weightx=0$$\n");
        sb.append("hs||250||||$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovário direito">
        sb.append("39;;Ovário direito;;200;;32;;Tuba esquerda$$\n");
        sb.append("cdl||43||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||41||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovário esquerdo">
        sb.append("44;;Ovário esquerdo;;200;;39;;Ovário direito$$\n");
        sb.append("cdl||48||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||46||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biópsia">
        sb.append("49;;Biópsia;;200;;44;;Ovário esquerdo$$\n");
        sb.append("cdl||53||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||51||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Procedimento">
        sb.append("54;;Procedimento;;200;;49;;Biópsia$$\n");
        sb.append("cdl||58||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||56||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        //campo descrito  Observações gerais
        sb.append("59;;Observações gerais;;200;;54;;Procedimento$$\n");
        sb.append("cdl||61||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("62;;Impressão diagnóstica;;200;;59;;Observações gerais$$\n");
        sb.append("cdl||66||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||64||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        //cid 10
        sb.append("\n62\n");
        // </editor-fold>

        alterarVisaoDeLaudo(22);

    }

    static void videoFaringoLaringoscopiaEndoscópico() throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Indicação clínica">

        //campo descrito  Descrição
        sb.append("0;;Indicação clínica$$\n");
        sb.append("cdl||4||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||2||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pré-medicação / Equipamento">

        sb.append("5;;Pré-medicação / Equipamento;;300;;0;;Indicação clínica$$\n");
        sb.append("pc||Óptica;;f;;f||cdl@7@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Grau da ótica rígida;;t;;f||cdl@8@||gridx=1;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||% Lidocaína ;;t;;f||cdl@9@||gridx=2;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("vs||0||||gridwidth=1;;gridx=4;;gridy=2;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tonsilas palatinas">

        sb.append("10;;Tonsilas palatinas;;300;;5;;Pré-medicação / Equipamento$$\n");
        sb.append("cdl||12||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||13||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Base de língua">
        sb.append("14;;Base de língua;;300;;10;;Tonsilas palatinas$$\n");
        sb.append("cdl||16||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||17||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Valéculas">
        sb.append("18;;Valéculas;;300;;14;;Base de língua$$\n");
        sb.append("cdl||20||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||21||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Seios piriformes">
        sb.append("22;;Seios piriformes;;300;;18;;Valéculas$$\n");
        sb.append("cdl||24||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||25||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Epiglote">
        sb.append("26;;Epiglote;;300;;22;;Seios piriformes$$\n");
        sb.append("cdl||28||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||29||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pregas ariepiglótica">
        sb.append("30;;Pregas ariepiglótica;;300;;26;;Epiglote$$\n");
        sb.append("cdl||32||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||33||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Aritenoides">
        sb.append("34;;Aritenoides;;300;;30;;Pregas ariepiglótica$$\n");
        sb.append("cdl||36||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||37||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Bandas ventriculares">
        sb.append("38;;Bandas ventriculares;;300;;34;;Aritenoides$$\n");
        sb.append("cdl||40||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||41||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pregas vocais">
        sb.append("42;;Pregas vocais - superfície mucosa;;300;;38;;Bandas ventriculares$$\n");
        sb.append("cdl||44||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||45||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("42;;Pregas vocais - bordos;;300;;42;;Pregas vocais$$\n");
        sb.append("cdl||47||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||48||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("42;;Pregas vocais - coaptação;;300;;42;;Pregas vocais$$\n");
        sb.append("cdl||50||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||51||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("42;;Pregas vocais - mobilidade;;300;;42;;Pregas vocais$$\n");
        sb.append("cdl||53||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||54||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("42;;Pregas vocais - fenda;;300;;42;;Pregas vocais$$\n");
        sb.append("cdl||56||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||57||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        //campo descrito  Observações gerais
        sb.append("58;;Observações gerais;;300;;42;;Pregas vocais$$\n");
        sb.append("cdl||60||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("61;;Impressão diagnóstica;;300;;58;;Pregas vocais$$\n");
        sb.append("cdl||65||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||63||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        //cid 10
        sb.append("\n61\n");
        // </editor-fold>

        alterarVisaoDeLaudo(16);

    }

    static void videoEndoscopiaNasalOtica() throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Indicação clínica">

        //campo descrito  Descrição
        sb.append("0;;Indicação clínica$$\n");
        sb.append("cdl||4||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||2||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pré-medicação / Equipamento">

        sb.append("5;;Pré-medicação / Equipamento;;300;;0;;Indicação clínica$$\n");
        sb.append("pc||Óptica;;f;;f||cdl@7@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Grau da ótica rígida;;t;;f||cdl@8@||gridx=1;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||% Lidocaína ;;t;;f||cdl@10@||gridx=2;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("vs||0||||gridwidth=1;;gridx=4;;gridy=2;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Septo nasal">

        sb.append("11;;Septo nasal;;300;;5;;Pré-medicação / Equipamento$$\n");
        sb.append("pc||Septo nasal;;f;;f||cdl@13@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Desvio;;t;;f||cdl@14@||gridx=1;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Direção;;t;;f||cdl@16@||gridx=2;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Tipo de desvio;;t;;f||cdl@15@||gridx=3$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("hs||0||||gridx=4;;weightx=1$$\n");
        sb.append("pc||Descrição - Tipo de desvio;;f;;t||cdl@17@1||weightx=0;;gridwidth=4;;gridy=1;;gridx=0$$\n");
        sb.append("pc||Descrição - Septo nasal;;f;;t||cdl@18@1||$$\n");
        sb.append("vs||200||||$$\n");

        sb.append("vs||0||||gridy=2;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fossa nasal">

        sb.append("19;;Fossa nasal - mucosa direita;;300;;11;;Septo nasal$$\n");
        sb.append("cdl||21||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||22||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("19;;Fossa nasal - mucosa esquerda;;300;;19;;Fossa nasal$$\n");
        sb.append("cdl||23||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||24||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("19;;Fossa nasal - concha inferior direita;;300;;19;;Fossa nasal$$\n");
        sb.append("cdl||26||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||350||||$$\n");
        sb.append("cdl||27||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("19;;Fossa nasal - concha inferior esquerda;;300;;19;;Fossa nasal$$\n");
        sb.append("cdl||28||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||350||||$$\n");
        sb.append("cdl||29||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("19;;Fossa nasal - meato inferior direito;;300;;19;;Fossa nasal$$\n");
        sb.append("cdl||31||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||300||||$$\n");
        sb.append("cdl||32||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("19;;Fossa nasal - meato inferior esquerdo;;300;;19;;Fossa nasal$$\n");
        sb.append("cdl||33||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||300||||$$\n");
        sb.append("cdl||34||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("19;;Fossa nasal - concha média direita;;300;;19;;Fossa nasal$$\n");
        sb.append("cdl||36||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||350||||$$\n");
        sb.append("cdl||37||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("19;;Fossa nasal - concha média esquerda;;300;;19;;Fossa nasal$$\n");
        sb.append("cdl||38||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||350||||$$\n");
        sb.append("cdl||39||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("19;;Fossa nasal - meato médio direito;;300;;19;;Fossa nasal$$\n");
        sb.append("cdl||41||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||320||||$$\n");
        sb.append("cdl||42||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("19;;Fossa nasal - meato médio esquerdo;;300;;19;;Fossa nasal$$\n");
        sb.append("cdl||43||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||320||||$$\n");
        sb.append("cdl||44||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Rinofaringe">

        sb.append("45;;Rinofaringe - cavum;;300;;19;;Fossa nasal$$\n");
        sb.append("pc||Cavum;;f;;f||cdl@47@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||% Adenóide;;t;;f||cdl@48@||gridx=1;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||% Descrita;;t;;f||cdl@49@||gridx=2;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@50@||gridwidth=3;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=4;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("45;;Rinofaringe - óstios das tubas auditivas;;300;;45;;Rinofaringe$$\n");
        sb.append("cdl||52||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||250||||$$\n");
        sb.append("cdl||53||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("45;;Rinofaringe - mobilidade palatal;;300;;45;;Rinofaringe$$\n");
        sb.append("cdl||55||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||56||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        //campo descrito  Observações gerais
        sb.append("57;;Observações gerais;;300;;43;;Rinofaringe$$\n");
        sb.append("cdl||59||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("60;;Impressão diagnóstica;;300;;57;;Observações gerais$$\n");
        sb.append("cdl||64||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||62||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        //cid 10
        sb.append("\n60\n");
        // </editor-fold>

        alterarVisaoDeLaudo(17);

    }

    static void videoNasofibrolaringoscopia() throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Indicação clínica">

        sb.append("0;;Indicação Clínica$$\n");
        sb.append("cdl||4||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||2||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pré-medicação / Equipamento">

        sb.append("5;;Pré-medicação / Equipamento;;340;;0;;Indicação clínica$$\n");
        sb.append("pc||Óptica;;f;;f||cdl@7@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Grau da ótica rígida;;t;;f||cdl@8@||gridx=1;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||% Lidocaína fossas nasais ;;t;;f||cdl@9@||gridx=2;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||% Lidocaína orofaringe ;;t;;f||cdl@10@||gridx=3$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("hs||0||||gridx=4;;gridy=1;;weighty=1;;weightx=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Septo nasal">

        sb.append("11;;Septo nasal;;340;;5;;Pré-medicação / Equipamento$$\n");
        sb.append("pc||Septo nasal;;f;;f||cdl@13@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Desvio;;t;;f||cdl@14@||gridx=1;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Direção;;t;;f||cdl@16@||gridx=2;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Tipo de desvio;;t;;f||cdl@15@||gridx=3$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("hs||0||||gridx=4;;weightx=1$$\n");
        sb.append("pc||Descrição - Tipo de desvio;;f;;t||cdl@17@1||weightx=0;;gridwidth=4;;gridy=1;;gridx=0$$\n");
        sb.append("pc||Descrição - Septo nasal;;f;;t||cdl@18@1||$$\n");
        sb.append("vs||200||||$$\n");

        sb.append("vs||0||||gridy=2;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fossa nasal">

        sb.append("19;;Fossa nasal - mucosa direita;;340;;11;;Septo nasal$$\n");
        sb.append("cdl||21||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||22||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("19;;Fossa nasal - mucosa esquerda;;340;;19;;Fossa nasal$$\n");
        sb.append("cdl||23||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||24||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("25;;Fossa nasal - concha inferior direita;;340;;19;;Fossa nasal$$\n");
        sb.append("cdl||26||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||350||||$$\n");
        sb.append("cdl||27||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("25;;Fossa nasal - concha inferior esquerda;;340;;19;;Fossa nasal$$\n");
        sb.append("cdl||28||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||350||||$$\n");
        sb.append("cdl||29||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("30;;Fossa nasal - meato inferior direito;;340;;19;;Fossa nasal$$\n");
        sb.append("cdl||31||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||250||||$$\n");
        sb.append("cdl||32||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("30;;Fossa nasal - meato inferior esquerdo;;340;;19;;Fossa nasal$$\n");
        sb.append("cdl||33||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||250||||$$\n");
        sb.append("cdl||34||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("35;;Fossa nasal - concha média direita;;340;;19;;Fossa nasal$$\n");
        sb.append("cdl||36||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||350||||$$\n");
        sb.append("cdl||37||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("35;;Fossa nasal - concha média esquerda;;340;;19;;Fossa nasal$$\n");
        sb.append("cdl||38||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||350||||$$\n");
        sb.append("cdl||39||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("40;;Fossa nasal - meato médio direito;;340;;19;;Fossa nasal$$\n");
        sb.append("cdl||41||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||310||||$$\n");
        sb.append("cdl||42||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("40;;Fossa nasal - meato médio esquerdo;;340;;19;;Fossa nasal$$\n");
        sb.append("cdl||43||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||310||||$$\n");
        sb.append("cdl||44||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Rinofaringe">

        sb.append("45;;Rinofaringe - cavum;;340;;19;;Fossa nasal$$\n");
        sb.append("pc||Cavum;;f;;f||cdl@47@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||% Adenóide;;t;;f||cdl@48@||gridx=1;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||% Descrita;;t;;f||cdl@49@||gridx=2;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@50@||gridwidth=3;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=4;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("45;;Rinofaringe - óstios das tubas auditivas;;340;;45;;Rinofaringe$$\n");
        sb.append("cdl||52||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||250||||$$\n");
        sb.append("cdl||53||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("45;;Rinofaringe - mobilidade palatal;;340;;45;;Rinofaringe$$\n");
        sb.append("cdl||55||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||56||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Orofaringe, Hipofaringe e Laringe">

        // <editor-fold defaultstate="collapsed" desc="Tonsilas palatinas">

        sb.append("57;;Tonsilas palatinas;;340;;45;;Rinofaringe$$\n");
        sb.append("cdl||59||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||60||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Úvula">

        sb.append("57;;Úvula;;340;;57;;Orofaringe, hipofaringe e laringe$$\n");
        sb.append("cdl||62||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||63||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Base de língua">

        sb.append("57;;Base de língua;;340;;57;;Orofaringe, hipofaringe e laringe$$\n");
        sb.append("cdl||65||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||66||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Valéculas">

        sb.append("57;;Valéculas;;340;;57;;Orofaringe, hipofaringe e laringe$$\n");
        sb.append("cdl||68||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||69||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Seios piriformes">

        sb.append("57;;Seios piriformes;;340;;57;;Orofaringe, hipofaringe e laringe$$\n");
        sb.append("cdl||71||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||72||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Epiglote">

        sb.append("57;;Epiglote;;340;;57;;Orofaringe, hipofaringe e laringe$$\n");
        sb.append("cdl||74||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||75||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pregas ariepiglótica">

        sb.append("57;;Pregas ariepiglótica;;340;;57;;Orofaringe, hipofaringe e laringe$$\n");
        sb.append("cdl||77||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||78||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Aritenóides">

        sb.append("57;;Aritenóides;;340;;57;;Orofaringe, hipofaringe e laringe$$\n");
        sb.append("cdl||80||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||81||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Bandas ventriculares">

        sb.append("57;;Bandas ventriculares;;340;;57;;Orofaringe, hipofaringe e laringe$$\n");
        sb.append("cdl||83||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||84||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pregas vocais">

        sb.append("57;;Pregas vocais - superfície mucosa;;340;;57;;Orofaringe, hipofaringe e laringe$$\n");
        sb.append("cdl||87||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||88||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("57;;Pregas vocais - bordos;;340;;57;;Orofaringe, hipofaringe e laringe$$\n");
        sb.append("cdl||90||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||91||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("57;;Pregas vocais - coaptação;;340;;57;;Orofaringe, hipofaringe e laringe$$\n");
        sb.append("cdl||93||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||94||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("57;;Pregas vocais - mobilidade;;340;;57;;Orofaringe, hipofaringe e laringe$$\n");
        sb.append("cdl||96||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||97||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        sb.append("57;;Pregas vocais - fenda;;340;;57;;Orofaringe, hipofaringe e laringe$$\n");
        sb.append("cdl||99||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||100||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("101;;Observações gerais;;340;;57;;Orofaringe, hipofaringe e laringe$$\n");
        sb.append("cdl||103||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("104;;Impressão diagnóstica;;340;;101;;Observações gerais$$\n");
        sb.append("cdl||108||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||106||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        //cid 10
        sb.append("\n102\n");
        // </editor-fold>

        alterarVisaoDeLaudo(18);

    }

    static void abdomeInferiorMasculino () throws Exception
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

        // <editor-fold defaultstate="collapsed" desc="Bexiga">

        sb.append("4;;Bexiga;;160;;0;;Dados do equipamento$$\n");
        sb.append("pc||Presença;;f;;f||cdl@6@||gridx=0;;gridy=0$$\n");
        sb.append("hs||140||||$$\n");
        sb.append("pc||Espessura;;t;;f||cdl@13@||gridx=1$$\n");
        sb.append("hs||140||||$$\n");
        sb.append("pc||Morfologia;;t;;f||cdl@8@||gridx=2$$\n");
        sb.append("hs||140||||$$\n");
        sb.append("pc||Posição;;t;;f||cdl@7@||gridx=3$$\n");
        sb.append("hs||120||||$$\n");
        sb.append("pc||Superfície;;f;;t||cdl@9@||gridy=1;;gridx=0$$\n");
        sb.append("pc||Textura;;t;;t||cdl@10@||gridx=1$$\n");
        sb.append("pc||Contornos;;t;;t||cdl@11@||gridx=2$$\n");
        sb.append("pc||Limites;;t;;t||cdl@12@||gridx=3$$\n");
        sb.append("pc||Textura do conteúdo da bexiga;;f;;t||cdl@15@||gridx=0;;gridy=2;;gridwidth=2$$\n");
        sb.append("pc||Debris - conteúdo da bexiga;;t;;t||cdl@16@||gridx=2$$\n");
        sb.append("pc||Posição do assoalho da bexiga;;f;;t||cdl@18@||gridx=0;;gridy=3$$\n");
        sb.append("pc||Capacidade da bexiga;;t;;t||cdl@20@||gridx=2$$\n");
        sb.append("pc||Resíduo pós-miccional;;f;;t||cdl@22@||gridx=0;;gridy=4$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@24@||gridx=0;;gridy=5;;gridwidth=4$$\n");
        sb.append("hs||0||||gridy=6;;gridx=0;;weighty=1;;gridwidth=1$$\n");
        sb.append("vs||150||||gridy=5;;gridx=5;;weighty=0;;weightx=1$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Próstata">

        sb.append("25;;Próstata;;300;;4;;Bexiga$$\n");
        sb.append("pc||Presença;;f;;f||cdl@27@||gridx=0;;gridy=0$$\n");
        sb.append("hs||140||||$$\n");
        sb.append("pc||Posição;;t;;f||cdl@28@||gridx=1$$\n");
        sb.append("hs||120||||$$\n");
        sb.append("pc||Morfologia;;t;;f||cdl@29@||gridx=2$$\n");
        sb.append("hs||160||||$$\n");
        sb.append("pc||Superfície;;t;;f||cdl@30@||gridx=3$$\n");
        sb.append("hs||140||||$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;t||cdl@32@||gridx=0;;gridy=1$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;t||cdl@33@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;t||cdl@34@||gridx=2$$\n");
        sb.append("pc||Peso (g);;t;;t||cdl@36@||gridx=3$$\n");
        sb.append("pc||Biópsia;;f;;t||cdl@38@||gridx=0;;gridy=2$$\n");
        sb.append("pc||N° de fragmentos;;t;;t||cdl@39@||gridx=1$$\n");
        sb.append("hs||0||||gridy=3;;gridx=0;;weighty=1$$\n");
        sb.append("vs||0||||gridy=3;;gridx=5;;weighty=0;;weightx=1$$\n");
        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Prostata Periferica">

        sb.append("40;;Próstata - zona periférica (lobo posterior);;300;;25;;Próstata$$\n");
        sb.append("pc||Textura;;f;;f||cdl@41@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Limites;;t;;f||cdl@42@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Contornos;;t;;f||cdl@43@||gridx=2$$\n");
        sb.append("hs||120||||$$\n");
        sb.append("pc||Informações complementares;;f;;t||cdl@45@||gridx=0;;gridy=2;;gridwidth=3$$\n");
        sb.append("hs||0||||gridy=3;;gridx=0;;weighty=1$$\n");
        sb.append("vs||150||||gridy=2;;gridx=4;;weighty=0;;weightx=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Próstata - Zona Central">

        sb.append("46;;Próstata - zona central;;200;;25;;Próstata$$\n");
        sb.append("pc||Textura;;f;;f||cdl@47@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Limites;;t;;f||cdl@49@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Contornos;;t;;f||cdl@48@||gridx=2$$\n");
        sb.append("hs||120||||$$\n");
        sb.append("pc||Informações complementares;;f;;t||cdl@51@||gridx=0;;gridy=2;;gridwidth=3$$\n");
        sb.append("hs||0||||gridy=3;;gridx=0;;weighty=1$$\n");
        sb.append("vs||150||||gridy=2;;gridx=4;;weighty=0;;weightx=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Próstata - Zona Transição (Lobo Médio)">

        sb.append("52;;Próstata - zona transição (lobo médio);;200;;25;;Próstata$$\n");
        sb.append("pc||Textura;;f;;f||cdl@53@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Limites;;t;;f||cdl@55@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Contornos;;t;;f||cdl@54@||gridx=2$$\n");
        sb.append("hs||120||||$$\n");
        sb.append("pc||Informações complementares;;f;;t||cdl@57@||gridx=0;;gridy=2;;gridwidth=3$$\n");
        sb.append("hs||0||||gridy=3;;gridx=0;;weighty=1$$\n");
        sb.append("vs||150||||gridy=2;;gridx=4;;weighty=0;;weightx=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Próstata - Estroma Fibromuscular Anterior">

        sb.append("58;;Próstata - estroma fibromuscular anterior;;200;;25;;Próstata$$\n");
        sb.append("pc||Textura;;f;;f||cdl@59@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Limites;;t;;f||cdl@60@||gridx=1$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Contornos;;t;;f||cdl@61@||gridx=2$$\n");
        sb.append("hs||120||||$$\n");
        sb.append("pc||Informações complementares;;f;;t||cdl@63@||gridx=0;;gridy=2;;gridwidth=3$$\n");
        sb.append("hs||0||||gridy=3;;gridx=0;;weighty=1$$\n");
        sb.append("vs||150||||gridy=2;;gridx=4;;weighty=0;;weightx=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Descrição próstata">

        sb.append("64;;Descrição da próstata;;200;;25;;Próstata$$\n");
        sb.append("cdl||65||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vesículas Seminais">

        sb.append("66;;Vesículas seminais;;200;;25;;Próstata$$\n");
        sb.append("pc||Presença;;f;;f||cdl@68@||gridx=0;;gridy=0$$\n");
        sb.append("hs||140||||$$\n");
        sb.append("pc||Simetria;;t;;f||cdl@69@||gridx=1$$\n");
        sb.append("hs||160||||$$\n");
        sb.append("pc||Morfologia;;t;;f||cdl@70@||gridx=2$$\n");
        sb.append("hs||160||||$$\n");
        sb.append("pc||Superfície;;t;;f||cdl@71@||gridx=3$$\n");
        sb.append("hs||140||||$$\n");
        sb.append("pc||Textura;;f;;t||cdl@72@||gridx=0;;gridy=1$$\n");
        sb.append("pc||Limites;;t;;t||cdl@73@||gridx=1$$\n");
        sb.append("pc||Contornos;;t;;t||cdl@74@||gridx=2$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@76@||gridx=0;;gridy=2;;gridwidth=4$$\n");
        sb.append("hs||0||||gridy=3;;gridx=0;;weighty=1;;gridwidth=1$$\n");
        sb.append("vs||150||||gridy=2;;gridx=5;;gridy=2;;weighty=0;;weightx=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("77;;Observações gerais;;200;;66;;Vesículas seminais$$\n");
        sb.append("cdl||79||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("80;;Impressão diagnóstica;;200;;77;;Observações gerais$$\n");
        sb.append("cdl||84||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||82||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        //cid 10
        sb.append("\n81\n");

        alterarVisaoDeLaudo(2);

    }

    static void endovaginalPelvica_AbdomenInferiorFeminino() throws Exception
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

        // <editor-fold defaultstate="collapsed" desc="Bexiga">

        sb.append("4;;Bexiga;;200;;0;;Dados do equipamento$$\n");
        sb.append("pc||Situação;;f;;f||cdl@6@||gridx=0;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@8@||gridwidth=2;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vagina">

        sb.append("9;;Vagina;;200;;4;;Bexiga$$\n");
        sb.append("pc||Situação;;f;;f||cdl@11@||gridx=0;;gridy=0$$\n");
        sb.append("hs||260||||$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@13@||gridwidth=2;;gridy=1;;gridx=0$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Útero">

        sb.append("14;;Útero;;200;;9;;Vagina$$\n");
        sb.append("pc||Situação;;f;;f||cdl@16@||$$\n");
        sb.append("hs||180||||gridx=0;;gridy=0$$\n");
        sb.append("pc||Posição;;t;;f||cdl@17@||gridx=1;;gridy=0$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("pc||Contornos;;t;;f||cdl@18@||gridx=2$$\n");
        sb.append("hs||105||||$$\n");
        sb.append("pc||Limites;;t;;f||cdl@19@||gridx=3$$\n");
        sb.append("hs||124||||$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;t||cdl@21@||gridx=0;;gridy=1$$\n");
        sb.append("pc||Diam. ant. post (cm);;t;;t||cdl@22@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;t||cdl@23@||gridx=2$$\n");
        sb.append("pc||Volume (cm³);;t;;t||cdl@25@||gridx=3$$\n");
        sb.append("pc||Textura do miométrio;;f;;t||cdl@27@||gridy=2;;gridx=0$$\n");
        sb.append("pc||Canal endocervical;;t;;t||cdl@29@||gridx=1;;gridwidth=2$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@31@||gridy=3;;gridx=0;;gridwidth=4$$\n");
        sb.append("hs||0||||gridx=5;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;weightx=0$$\n");
        sb.append("hs||0||||gridx=0;;gridy=4;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Endométrio">

        sb.append("32;;Endométrio;;200;;14;;Útero$$\n");
        sb.append("pc||Presença;;f;;f||cdl@33@||$$\n");
        sb.append("hs||150||||gridx=0;;gridy=0$$\n");
        sb.append("pc||Limites;;t;;f||cdl@34@||gridx=1;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Contornos;;t;;f||cdl@35@||gridx=2$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Aspecto;;f;;t||cdl@36@||gridy=1;;gridx=0;;$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Espessura (mm);;t;;t||cdl@38@||gridx=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@40@||gridy=2;;gridx=0;;gridwidth=3$$\n");
        sb.append("hs||0||||gridx=4;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=3;;weightx=0$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovário Direito">

        sb.append("41;;Ovário direito;;160;;14;;Útero$$\n");
        sb.append("pc||Posição;;f;;f||cdl@43@||$$\n");
        sb.append("hs||150||||gridx=0;;gridy=0$$\n");
        sb.append("pc||Contornos;;t;;f||cdl@44@||gridx=1;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Limites;;t;;f||cdl@45@||gridx=2$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Parênquima;;f;;t||cdl@47@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||240||||$$\n");
        sb.append("pc||Superfície;;f;;t||cdl@48@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;t||cdl@50@||gridx=0;;gridy=3;;gridwidth=1$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;t||cdl@51@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;t||cdl@52@||gridx=2$$\n");
        sb.append("pc||Volume (cm³);;t;;t||cdl@54@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@56@||gridy=4;;gridx=0;;gridwidth=4$$\n");
        sb.append("hs||0||||gridx=5;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;weightx=0$$\n");
        sb.append("hs||0||||gridx=0;;gridy=6;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovário Esquerdo">

        sb.append("41;;Ovário esquerdo;;200;;41;;Ovários$$\n");
        sb.append("pc||Posição;;f;;f||cdl@58@||$$\n");
        sb.append("hs||150||||gridx=0;;gridy=0$$\n");
        sb.append("pc||Contornos;;t;;f||cdl@59@||gridx=1;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Limites;;t;;f||cdl@60@||gridx=2$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Parênquima;;f;;t||cdl@62@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||240||||$$\n");
        sb.append("pc||Superfície;;f;;t||cdl@63@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;t||cdl@65@||gridx=0;;gridy=3;;gridwidth=1$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;t||cdl@66@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;t||cdl@67@||gridx=2$$\n");
        sb.append("pc||Volume (cm³);;t;;t||cdl@69@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@71@||gridy=4;;gridx=0;;gridwidth=4$$\n");
        sb.append("hs||0||||gridx=5;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;weightx=0$$\n");
        sb.append("hs||0||||gridx=0;;gridy=6;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais Sobre o Ovário">

        sb.append("72;;Informações complementares dos ovários;;350;;41;;Ovários$$\n");
        sb.append("cdl||73||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fundo de saco Douglas">

        sb.append("74;;Fundo de saco Douglas;;350;;41;;Ovários$$\n");
        sb.append("pc||Situação;;f;;f||cdl@76@||$$\n");
        sb.append("hs||150||||gridx=1;;weightx=0.2;;gridwidth=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@78@||gridwidth=2;;gridy=1;;gridx=0;;weightx=0.2$$\n");
        sb.append("pc||Faixa Etária;;f;;t||cdl@79@||gridwidth=1;;gridy=2;;weightx=0$$\n");
        sb.append("vs||200||||gridy=1;;gridx=2;;weightx=0.8$$\n");
        sb.append("hs||300||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">
        //campo descrito  Observações gerais
        sb.append("80;;Observações gerais;;200;;74;;Fundo de saco Douglas$$\n");
        sb.append("cdl||82||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("83;;Impressão diagnóstica;;200;;80;;Observações gerais$$\n");
        sb.append("cdl||87||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||85||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        //cid 10
        sb.append("\n83\n");

        // </editor-fold>

        alterarVisaoDeLaudo(14);

    }

    static void abdomeSuperior () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento">

        sb.append("0;;Dados do equipamento$$\n");
        sb.append("pc||Tipo;;f;;f||cdl@2@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@3@||gridwidth=5;;gridy=1$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||f;;t||lbln@\"Enter\" para digitar o laudo@fonte=16||gridx=0;;weightx=0;;gridy=2$$\n");
        sb.append("pc||t;;t||cdl@72@||gridx=1$$\n");
        sb.append("hs||40||||$$\n");
        sb.append("pc||t;;t||lbln@ ou @fonte=16||gridx=2$$\n");
        sb.append("pc||t;;t||btn@Autocompletar 'normal'@action=tn||gridx=3$$\n");
        sb.append("hs||10||||gridx=4$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Figado">

        sb.append("4;;Fígado;;250;;0;;Dados do equipamento$$\n");
        sb.append("cdl||8||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||6||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vias biliares">

        sb.append("9;;Vias biliares;;250;;4;;Fígado$$\n");
        sb.append("cdl||13||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||11||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vesícula biliar">

        sb.append("14;;Vesícula biliar;;250;;9;;Vias biliares$$\n");
        sb.append("cdl||18||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||16||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pâncreas">

        sb.append("19;;Pâncreas;;250;;14;;Vesícula Biliar$$\n");
        sb.append("cdl||23||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||21||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Rim direito">

        sb.append("24;;Rim direito;;250;;19;;Pâncreas$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;f||cdl@29@||$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;f||cdl@30@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;f||cdl@31@||gridx=2$$\n");
        sb.append("pc||Volume (cm³);;f;;t||cdl@33@||gridx=0;;gridy=1$$\n");
        sb.append("pc||Valores normais para o volume:;;t;;t||lbl@ Idade 24a e 11m: 125 a 300 cm³@||gridx=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@27@||gridwidth=2;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||26||||gridx=0;;gridy=3;;gridwidth=4;;top_insets=0;;left_insets=2$$\n");
        sb.append("vs||200||||gridx=5;;weightx=1;;weighty=0$$\n");
        sb.append("hs||0||||gridy=4;;gridx=0;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Rim esquerdo">

        sb.append("34;;Rim esquerdo;;250;;24;;Rim direito$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;f||cdl@39@||$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;f||cdl@40@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;f||cdl@41@||gridx=2$$\n");
        sb.append("pc||Volume (cm³);;f;;t||cdl@43@||gridx=0;;gridy=1$$\n");
        sb.append("pc||Valores normais para o volume:;;t;;t||lbl@ Idade 24a e 11m: 125 a 300 cm³@||gridx=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@37@||gridwidth=2;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||36||||gridx=0;;gridy=3;;gridwidth=4;;top_insets=0;;left_insets=2$$\n");
        sb.append("vs||200||||gridx=5;;weightx=1;;weighty=0$$\n");
        sb.append("hs||0||||gridy=4;;gridx=0;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Baço">

        sb.append("44;;Baço;;250;;34;;Rim esquerdo$$\n");
        sb.append("cdl||48||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||46||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vasos">

        sb.append("49;;Vasos;;250;;44;;Baço$$\n");
        sb.append("cdl||53||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||51||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Retroperitônio">

        sb.append("54;;Retroperitônio;;250;;49;;Vasos$$\n");
        sb.append("cdl||58||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||56||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Seios costofrênicos">

        sb.append("59;;Seios costo-frênicos;;250;;54;;Retroperitônio$$\n");
        sb.append("cdl||63||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||61||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("64;;Observações gerais;;250;;59;;Seios costofrênicos$$\n");
        sb.append("cdl||66||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("67;;Impressão diagnóstica;;250;;64;;Observações gerais$$\n");
        sb.append("cdl||71||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||69||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        //cid 10
        sb.append("\n67\n");

        // </editor-fold>

        alterarVisaoDeLaudo(13);

    }

    static void abdomeTotal () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento">

        sb.append("0;;Dados do equipamento$$\n");
        sb.append("pc||Tipo;;f;;f||cdl@2@||gridx=0;;gridy=0$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@3@||gridwidth=5;;gridy=1$$\n");
        sb.append("vs||170||||gridwidth=1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||f;;t||lbln@\"Enter\" para digitar o laudo@fonte=16||gridx=0;;weightx=0;;gridy=2$$\n");
        sb.append("pc||t;;t||cdl@82@||gridx=1$$\n");
        sb.append("hs||40||||$$\n");
        sb.append("pc||t;;t||lbln@ ou @fonte=16||gridx=2$$\n");
        sb.append("pc||t;;t||btn@Autocompletar 'normal'@action=tn||gridx=3$$\n");
        sb.append("hs||10||||gridx=4$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1$$\n");

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Figado">

        sb.append("4;;Fígado;;250;;0;;Dados do equipamento$$\n");
        sb.append("cdl||8||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");

        sb.append("cdl||6||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vias biliares">

        sb.append("9;;Vias biliares;;250;;4;;Fígado$$\n");
        sb.append("cdl||13||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||11||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vesícula biliar">

        sb.append("14;;Vesícula biliar;;250;;9;;Vias biliares$$\n");
        sb.append("cdl||18||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||16||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pâncreas">

        sb.append("19;;Pâncreas;;250;;14;;Vesícula Biliar$$\n");
        sb.append("cdl||23||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||21||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Rim direito">

        sb.append("44;;Rim direito;;250;;19;;Pâncreas$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;f||cdl@49@||$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;f||cdl@50@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;f||cdl@51@||gridx=2$$\n");
        sb.append("pc||Volume (cm³);;f;;t||cdl@53@||gridx=0;;gridy=1$$\n");
        sb.append("pc||Valores normais para o volume:;;t;;t||lbl@ Idade 24a e 11m: 125 a 300 cm³@||gridx=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@47@||gridwidth=2;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||46||||gridx=0;;gridy=3;;gridwidth=4;;top_insets=0;;left_insets=2$$\n");
        sb.append("vs||200||||gridx=5;;weightx=1;;weighty=0$$\n");
        sb.append("hs||0||||gridy=4;;gridx=0;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Rim esquerdo">

        sb.append("54;;Rim esquerdo;;250;;44;;Rim direito$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;f||cdl@59@||$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;f||cdl@60@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;f||cdl@61@||gridx=2$$\n");
        sb.append("pc||Volume (cm³);;f;;t||cdl@63@||gridx=0;;gridy=1$$\n");
        sb.append("pc||Valores normais para o volume:;;t;;t||lbl@ Idade 24a e 11m: 125 a 300 cm³@||gridx=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@57@||gridwidth=2;;gridx=0;;gridy=2$$\n");
        sb.append("cdl||56||||gridx=0;;gridy=3;;gridwidth=4;;top_insets=0;;left_insets=2$$\n");
        sb.append("vs||200||||gridx=5;;weightx=1;;weighty=0$$\n");
        sb.append("hs||0||||gridy=4;;gridx=0;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Bexiga">

        sb.append("64;;Bexiga;;250;;54;;Rim Esquerdo$$\n");
        sb.append("cdl||68||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||66||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Baço">

        sb.append("24;;Baço;;250;;64;;Bexiga$$\n");
        sb.append("cdl||28||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||26||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vasos">

        sb.append("29;;Vasos;;250;;24;;Baço$$\n");
        sb.append("cdl||33||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||31||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Retroperitônio">

        sb.append("34;;Retroperitônio;;250;;29;;Vasos$$\n");
        sb.append("cdl||38||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||36||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Seios costofrênicos">

        sb.append("39;;Seios costofrênicos;;250;;34;;Retroperitônio$$\n");
        sb.append("cdl||43||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||41||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Demais órgãos pélvicos">

        sb.append("69;;Demais órgãos pélvicos;;250;;39;;Seios costofrênicos$$\n");
        sb.append("cdl||73||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||71||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("74;;Observações gerais;;250;;69;;Demais ógãos pélvicos$$\n");
        sb.append("cdl||76||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("77;;Impressão diagnóstica;;250;;74;;Observações gerais$$\n");
        sb.append("cdl||81||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||79||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        //cid 10
        sb.append("\n77\n");
        // </editor-fold>

        alterarVisaoDeLaudo(3);
    }

    static void endoscopia () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Indicação clínica">

        sb.append("0;;Indicação clínica$$\n");
        sb.append("cdl||4||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||500||||gridx=1$$\n");
        sb.append("cdl||2||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||400||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pré-medicação">

        sb.append("5;;Pré-medicação;;300;;0;;Indicação clínica$$\n");
        sb.append("cdl||9||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||7||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;weighty=1;;left_insets=3$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Informações adicionais">

        sb.append("10;;Informações adicionais;;300;;5;;Pré-medicação$$\n");
        sb.append("cdl||14||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||12||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;weighty=1;;left_insets=3$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Esôfago">

        sb.append("15;;Esôfago;;300;;10;;Informações adicionais$$\n");
        sb.append("cdl||19||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||17||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;weighty=1;;left_insets=3$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Estômago">

        sb.append("20;;Estômago;;300;;15;;Esôfago$$\n");
        sb.append("cdl||24||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||22||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;weighty=1;;left_insets=3$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Duodeno">

        sb.append("25;;Duodeno;;300;;20;;Estômago$$\n");
        sb.append("cdl||29||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||27||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;weighty=1;;left_insets=3$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("30;;Observações gerais;;300;;25;;Duodeno$$\n");
        sb.append("cdl||32||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("33;;Impressão diagnóstica;;300;;30;;Observações gerais$$\n");
        sb.append("cdl||37||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||35||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;weighty=1;;left_insets=3$$\n");

        sb.append("\n##\n");

        //cid 10
        sb.append("\n33\n");

        // </editor-fold>

        alterarVisaoDeLaudo(9);

    }

    public static void main (String[] args) throws Exception
    {
        endoscopia();
        abdomeTotal();
        abdomeSuperior();
        endovaginalPelvica_AbdomenInferiorFeminino();
        abdomeInferiorMasculino();
        videoNasofibrolaringoscopia();
        videoEndoscopiaNasalOtica();
        videoFaringoLaringoscopiaEndoscópico();
        laparoscopiaDigestivaComOuSemBiopsia();
    }

}