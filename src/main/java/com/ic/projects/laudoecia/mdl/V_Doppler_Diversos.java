/*
 * V_Doppler_Diversos.java
 *
 * Created on 03/10/2012, 15:03:46
 */

package com.ic.projects.laudoecia.mdl;

/**
 *
 * @author Tekna <informatica@instrumental.net.br>
 */
public class V_Doppler_Diversos extends View
{

    /**
     * @param args the command line arguments
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        ecodopplerCardiograma();
        dopplerfluxometria();
        diversos();
        textoLivre();
        histeroscopia();
        endovaginalPelvica_AbdomenInferiorFeminino();
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
        sb.append("pc||Textura do miométrio;;f;;t||cdl@28@||gridy=2;;gridx=0$$\n");
        sb.append("pc||Canal endocervical;;t;;t||cdl@30@||gridx=1;;gridwidth=2$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@32@||gridy=3;;gridx=0;;gridwidth=4$$\n");
        sb.append("hs||0||||gridx=5;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;weightx=0$$\n");
        sb.append("hs||0||||gridx=0;;gridy=4;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Endométrio">

        sb.append("33;;Endométrio;;200;;14;;Útero$$\n");
        sb.append("pc||Presença;;f;;f||cdl@34@||$$\n");
        sb.append("hs||150||||gridx=0;;gridy=0$$\n");
        sb.append("pc||Limites;;t;;f||cdl@35@||gridx=1;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Contornos;;t;;f||cdl@36@||gridx=2$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Aspecto;;f;;t||cdl@37@||gridy=1;;gridx=0;;$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Espessura (mm);;t;;t||cdl@39@||gridx=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@41@||gridy=2;;gridx=0;;gridwidth=3$$\n");
        sb.append("hs||0||||gridx=4;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=3;;weightx=0$$\n");
        sb.append("hs||0||||gridx=0;;gridy=3;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovário Direito">

        sb.append("42;;Ovário direito;;160;;14;;Útero$$\n");
        sb.append("pc||Posição;;f;;f||cdl@44@||$$\n");
        sb.append("hs||150||||gridx=0;;gridy=0$$\n");
        sb.append("pc||Contornos;;t;;f||cdl@45@||gridx=1;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Limites;;t;;f||cdl@46@||gridx=2$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Parênquima;;f;;t||cdl@48@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||240||||$$\n");
        sb.append("pc||Superfície;;f;;t||cdl@49@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;t||cdl@51@||gridx=0;;gridy=3;;gridwidth=1$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;t||cdl@52@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;t||cdl@53@||gridx=2$$\n");
        sb.append("pc||Volume (cm³);;t;;t||cdl@55@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@58@||gridy=4;;gridx=0;;gridwidth=4$$\n");
        sb.append("hs||0||||gridx=5;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;weightx=0$$\n");
        sb.append("hs||0||||gridx=0;;gridy=6;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovário Esquerdo">

        sb.append("42;;Ovário esquerdo;;200;;42;;Ovários$$\n");
        sb.append("pc||Posição;;f;;f||cdl@60@||$$\n");
        sb.append("hs||150||||gridx=0;;gridy=0$$\n");
        sb.append("pc||Contornos;;t;;f||cdl@61@||gridx=1;;gridy=0$$\n");
        sb.append("hs||150||||$$\n");
        sb.append("pc||Limites;;t;;f||cdl@62@||gridx=2$$\n");
        sb.append("hs||130||||$$\n");
        sb.append("pc||Parênquima;;f;;t||cdl@64@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||240||||$$\n");
        sb.append("pc||Superfície;;f;;t||cdl@65@||gridx=0;;gridy=2$$\n");
        sb.append("pc||Diam. longitudinal (cm);;f;;t||cdl@67@||gridx=0;;gridy=3;;gridwidth=1$$\n");
        sb.append("pc||Diam. ant. post. (cm);;t;;t||cdl@68@||gridx=1$$\n");
        sb.append("pc||Diam. transversal (cm);;t;;t||cdl@69@||gridx=2$$\n");
        sb.append("pc||Volume (cm³);;t;;t||cdl@71@||gridx=3$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@74@||gridy=4;;gridx=0;;gridwidth=4$$\n");
        sb.append("hs||0||||gridx=5;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||200||||gridx=4;;weightx=0$$\n");
        sb.append("hs||0||||gridx=0;;gridy=6;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais Sobre o Ovário">

        sb.append("75;;Informações complementares dos ovários;;350;;42;;Ovários$$\n");
        sb.append("cdl||76||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fundo de saco Douglas">

        sb.append("77;;Fundo de saco Douglas;;350;;42;;Ovários$$\n");
        sb.append("pc||Situação;;f;;f||cdl@79@||$$\n");
        sb.append("hs||150||||gridx=1;;weightx=0.2;;gridwidth=1$$\n");
        sb.append("pc||Descrição;;f;;t||cdl@81@||gridwidth=2;;gridy=1;;gridx=0;;weightx=0.2$$\n");
        sb.append("pc||Faixa Etária;;f;;t||cdl@82@||gridwidth=1;;gridy=2;;weightx=0$$\n");
        sb.append("vs||200||||gridy=1;;gridx=2;;weightx=0.8$$\n");
        sb.append("hs||300||||gridx=0;;gridy=3;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">
        //campo descrito  Observações gerais
        sb.append("83;;Observações gerais;;200;;77;;Fundo de saco Douglas$$\n");
        sb.append("cdl||85||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("86;;Impressão diagnóstica;;200;;83;;Observações gerais$$\n");
        sb.append("cdl||90||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||88||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||270||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        //cid 10
        sb.append("\n86\n");

        // </editor-fold>

        alterarVisaoDeLaudo(32);

    }

    static void ecodopplerCardiograma () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Dados do paciente">

        sb.append("0;;Dados do paciente$$\n");
        sb.append("pc||Altura (cm);;f;;f||cdl@2@||$$\n");
        sb.append("pc||Peso (Kg);;t;;f||cdl@3@||gridx=1$$\n");
        sb.append("pc||Superfície Corporal (m²);;t;;f||cdl@5@||gridx=2$$\n");
        sb.append("pc||Frequência Cardíaca (btm);;f;;t||cdl@4@||gridx=0;;gridy=1$$\n");
        sb.append("hs||130||||gridx=0;;gridy=2;;weighty=1$$\n");
        sb.append("hs||130||||gridx=1$$\n");
        sb.append("hs||130||||gridx=2$$\n");
        sb.append("hs||130||||gridx=3$$\n");
        sb.append("hs||0||||gridx=4;;weightx=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Parâmetros estruturais">

        sb.append("6;;Parâmetros estruturais;;138;;0;;Dados do equipamento$$\n");
        sb.append("pc||f;;f||lbln@Aorta (diâmetro da raiz)@||$$\n");
        sb.append("pc||t;;f||cdl@8@||gridx=1;;$$\n");
        sb.append("pc||t;;f||lbln@mm@||gridx=2$$\n");
        sb.append("pc||Referências;;t;;f||txt@20 a 27@||gridx=3$$\n");
        sb.append("pc||t;;f||lbln@mm@||gridx=4$$\n");
        //2ª linha
        sb.append("pc||f;;t||lbln@Átrio esquerdo@||gridx=0;;gridy=1$$\n");
        sb.append("pc||t;;t||cdl@10@||gridx=1$$\n");
        sb.append("pc||t;;t||lbln@mm@||gridx=2$$\n");
        sb.append("pc||t;;t||txt@20 a 40@||gridx=3$$\n");
        sb.append("pc||t;;t||lbln@mm@||gridx=4$$\n");
        //3ª linha
        sb.append("pc||f;;t||lbln@Diâmetro ventricular direito@||gridx=0;;gridy=2$$\n");
        sb.append("pc||t;;t||cdl@12@||gridx=1$$\n");
        sb.append("pc||t;;t||lbln@mm@||gridx=2$$\n");
        sb.append("pc||t;;t||txt@07 a 26@||gridx=3$$\n");
        sb.append("pc||t;;t||lbln@mm@||gridx=4$$\n");
        //4ª linha
        sb.append("pc||f;;t||lbln@Diâmetro diastólico final do VE@||gridx=0;;gridy=3$$\n");
        sb.append("pc||t;;t||cdl@14@||gridx=1$$\n");
        sb.append("pc||t;;t||lbln@mm@||gridx=2$$\n");
        sb.append("pc||t;;t||txt@35 a 58@||gridx=3$$\n");
        sb.append("pc||t;;t||lbln@mm@||gridx=4$$\n");
        //5ª linha
        sb.append("pc||f;;t||lbln@Diâmetro sistólico final do VE@||gridx=0;;gridy=4$$\n");
        sb.append("pc||t;;t||cdl@16@||gridx=1$$\n");
        sb.append("pc||t;;t||lbln@mm@||gridx=2$$\n");
        sb.append("pc||t;;t||txt@25 a 40@||gridx=3$$\n");
        sb.append("pc||t;;t||lbln@mm@||gridx=4$$\n");
        //6ª linha
        sb.append("pc||f;;t||lbln@Espessura diastólica do septo@||gridx=0;;gridy=5$$\n");
        sb.append("pc||t;;t||cdl@18@||gridx=1$$\n");
        sb.append("pc||t;;t||lbln@mm@||gridx=2$$\n");
        sb.append("pc||t;;t||txt@07 a 11@||gridx=3$$\n");
        sb.append("pc||t;;t||lbln@mm@||gridx=4$$\n");
        //7ª linha
        sb.append("pc||f;;t||lbln@Espessura diastólica da PPVE@||gridx=0;;gridy=6$$\n");
        sb.append("pc||t;;t||cdl@20@||gridx=1$$\n");
        sb.append("pc||t;;t||lbln@mm@||gridx=2$$\n");
        sb.append("pc||t;;t||txt@07 a 11@||gridx=3$$\n");
        sb.append("pc||t;;t||lbln@mm@||gridx=4$$\n");
        //8ª linha
        sb.append("pc||f;;t||lbln@Volume AE@||gridx=0;;gridy=7$$\n");
        sb.append("pc||t;;t||cdl@22@||gridx=1$$\n");
        sb.append("pc||t;;t||lbln@cm³@||gridx=2$$\n");
        //9ª linha
        sb.append("pc||f;;t||lbln@Fórmula da massa@||gridx=0;;gridy=8$$\n");
        sb.append("pc||t;;t||cdl@33@||gridx=1;;gridwidth=3$$\n");
        sb.append("hs||65||||gridy=9;;gridx=1;;weighty=1;;gridwidth=1$$\n");
        sb.append("pc||t;;t||lbln@@||gridx=4;;weightx=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Relações e Funções Ventriculares">

        sb.append("23;;Relações e funções ventriculares;;280;;6;;Parâmetros Estruturais$$\n");
        sb.append("pc||f;;f||lbln@Rel. Át. Esq./Aor.@||$$\n");
        sb.append("pc||t;;f||cdl@29@||gridx=1;;$$\n");
        sb.append("pc||t;;f||lbln@@||gridx=2$$\n");
        sb.append("pc||Referências;;t;;f||txt@1,0 ± 0,8@||gridx=3$$\n");
        //2ª linha
        sb.append("pc||f;;t||lbln@Fração de Ej. (Teicholz)@||gridx=0;;gridy=1$$\n");
        sb.append("pc||t;;t||cdl@31@||gridx=1$$\n");
        sb.append("pc||t;;t||lbln@%@||gridx=2$$\n");
        sb.append("pc||t;;t||txt@>58%@||gridx=3$$\n");
        //3ª linha
        sb.append("pc||f;;t||lbln@Massa Vent. Esq.@||gridx=0;;gridy=2$$\n");
        sb.append("pc||t;;t||cdl@35@||gridx=1$$\n");
        sb.append("pc||t;;t||lbln@g@||gridx=2$$\n");
        sb.append("pc||t;;t||txt@94 a 300 g@||gridx=3$$\n");
        //4ª linha
        sb.append("pc||f;;t||lbln@Índice de Massa@||gridx=0;;gridy=3$$\n");
        sb.append("pc||t;;t||cdl@37@||gridx=1$$\n");
        sb.append("pc||t;;t||lbln@g/m²@||gridx=2$$\n");
        sb.append("pc||t;;t||txt@ @||gridx=3$$\n");
        //5ª linha
        sb.append("pc||f;;t||lbln@% de Enc. da Cav.@||gridx=0;;gridy=4$$\n");
        sb.append("pc||t;;t||cdl@39@||gridx=1$$\n");
        sb.append("pc||t;;t||lbln@%@||gridx=2$$\n");
        sb.append("pc||t;;t||txt@> 20%@||gridx=3$$\n");
        //6ª linha
        sb.append("pc||f;;t||lbln@Rel. Septo / PPVE@||gridx=0;;gridy=5$$\n");
        sb.append("pc||t;;t||cdl@41@||gridx=1$$\n");
        sb.append("pc||t;;t||lbln@@||gridx=2$$\n");
        sb.append("pc||t;;t||txt@< 1,3@||gridx=3$$\n");
        //7ª linha
        sb.append("pc||f;;t||lbln@Vol. Dias. Final@||gridx=5;;gridy=0$$\n");
        sb.append("pc||t;;t||cdl@25@||gridx=6$$\n");
        sb.append("pc||t;;t||lbln@ml@||gridx=7$$\n");
        sb.append("pc||Referências;;t;;t||txt@73 a 158 ml@||gridx=8$$\n");
        //8ª linha
        sb.append("pc||f;;t||lbln@Vol. Sist.@||gridx=5;;gridy=1$$\n");
        sb.append("pc||t;;t||cdl@43@||gridx=6$$\n");
        sb.append("pc||t;;t||lbln@ml@||gridx=7$$\n");
        sb.append("pc||t;;t||txt@59 a 99 ml@||gridx=8$$\n");
        //9ª linha
        sb.append("pc||f;;t||lbln@Rel. Vol. Massa@||gridx=5;;gridy=2$$\n");
        sb.append("pc||t;;t||cdl@45@||gridx=6$$\n");
        sb.append("pc||t;;t||lbln@ml/g@||gridx=7$$\n");
        sb.append("pc||t;;t||txt@> 0,42 ml/g @||gridx=8$$\n");
        //10ª linha
        sb.append("pc||f;;t||lbln@Vol. Sist. Final@||gridx=5;;gridy=3$$\n");
        sb.append("pc||t;;t||cdl@27@||gridx=6$$\n");
        sb.append("pc||t;;t||lbln@ml@||gridx=7$$\n");
        sb.append("pc||t;;t||txt@18 a 57 ml@||gridx=8$$\n");
        sb.append("hs||65||||gridy=10;;gridx=1$$\n");
        sb.append("pc||t;;t||lbln@@||gridx=9;;weighty=1$$\n");
        sb.append("hs||70||||gridx=6$$\n");
        sb.append("hs||90||||gridx=8$$\n");
        sb.append("hs||15||||gridx=4$$\n");
        sb.append("pc||t;;t||lbln@@||gridx=10;;weightx=1$$\n");
        //11ªlinha
        sb.append("pc||t;;t||lbln@Enter Ir p/ Imp. diag.@||gridx=5;;weighty=0;;weightx=0;;gridy=4$$\n");
        sb.append("pc||t;;t||cdl@56@||gridx=6$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Comentários ecocardiográficos">

        sb.append("46;;Comentários ecocardiográficos;;250;;23;;Relações e Funções Ventriculares$$\n");
        sb.append("cdl||50||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||48||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;weighty=1;;left_insets=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressão diagnóstica">

        sb.append("51;;Impressão diagnóstica;;320;;46;;Comentários ecocardiográficos$$\n");
        sb.append("cdl||55||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||53||||gridwidth=2;;gridy=1;;gridx=0;;weightx=1;;weighty=1;;left_insets=3$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        //cid 10
        sb.append("\n51\n");

        alterarVisaoDeLaudo(11);

    }

    static void dopplerfluxometria () throws Exception
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

        sb.append("4;;Dados da gestação;;200;;0;;Dados do equipamento$$\n");
        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||DUM;;f;;f||cdl@15@||1;;gridy=0;;gridx=0$$\n");
        sb.append("hs||100||||1$$\n");
        sb.append("pc||IGH;;t;;f||cdl@17@||1;;gridx=1$$\n");
        sb.append("hs||50||||1$$\n");
        sb.append("pc||t;;f||lbl@Sem.@||1;;gridx=2$$\n");
        sb.append("pc||t;;f||cdl@18@||1;;gridx=3$$\n");
        sb.append("hs||30||||1$$\n");
        sb.append("pc||t;;f||lbl@Dias@||1;;gridx=4$$\n");
        sb.append("hs||30||||1$$\n");
        sb.append("hs||0||||1;;gridx=5;;weightx=1$$\n");
        sb.append("pc||DPP;;t;;f||cdl@16@||1;;gridx=6;;weightx=0$$\n");
        sb.append("hs||100||||1$$\n");
        sb.append("pc||Pela amenorréia;;f;;f||subcont@1@||gridx=0;;gridy=0;;gridwidth=4$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Data;;f;;f||cdl@19@||2;;gridy=0;;gridx=0;;gridwidth=1$$\n");
        sb.append("hs||100||||2$$\n");
        sb.append("pc||t;;f||cdl@20@||2;;gridx=1$$\n");
        sb.append("hs||50||||2$$\n");
        sb.append("pc||t;;f||lbl@Sem.@||2;;gridx=2$$\n");
        sb.append("pc||t;;f||cdl@21@||2;;gridx=3$$\n");
        sb.append("hs||30||||2$$\n");
        sb.append("pc||t;;f||lbl@Dias@||2;;gridx=4$$\n");
        sb.append("hs||0||||2;;weightx=1;;gridx=5$$\n");
        sb.append("pc||IGH;;t;;f||cdl@24@||2;;gridx=6;;weightx=0$$\n");
        sb.append("hs||50||||2$$\n");
        sb.append("pc||t;;f||lbl@Sem.@||2;;gridx=7$$\n");
        sb.append("pc||t;;f||cdl@25@||2;;gridx=8$$\n");
        sb.append("hs||30||||2$$\n");
        sb.append("pc||t;;f||lbl@Dias@||2;;gridx=9$$\n");
        sb.append("pc||DPP;;t;;f||cdl@23@||2;;gridx=10$$\n");
        sb.append("hs||100||||2$$\n");
        sb.append("pc||Pelo último Exame;;f;;t||subcont@2@||gridx=0;;gridy=1;;gridwidth=4$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||Idade;;f;;f||cdl@27@||3;;gridy=0;;gridx=0;;gridwidth=1$$\n");
        sb.append("hs||50||||3$$\n");
        sb.append("pc||t;;f||lbl@Semanas e @||3;;gridx=1$$\n");
        sb.append("pc||t;;f||cdl@28@||3;;gridx=2$$\n");
        sb.append("hs||40||||3$$\n");
        sb.append("pc||t;;f||lbl@Dias@||3;;gridx=3$$\n");
        sb.append("hs||0||||3;;gridx=4;;weightx=1$$\n");
        sb.append("pc||Data do exame;;t;;f||cdl@13@||3;;gridx=5;;weightx=0$$\n");
        sb.append("hs||100||||3$$\n");
        sb.append("pc||DPP;;t;;f||cdl@29@||3;;gridx=6$$\n");
        sb.append("hs||100||||3;;$$\n");
        sb.append("pc||Definida pelo examinador;;f;;t||subcont@3@||gridx=0;;gridy=2;;gridwidth=4$$\n");

        sb.append("pc||Número de fetos  ;;f;;t||cdl@8@||gridy=3;;gridwidth=1$$\n");
        sb.append("pc||Corionicidade;;t;;t||cdl@11@1||gridx=1$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("pc||Amniocidade;;t;;t||cdl@12@1||gridx=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("hs||50||||gridx=3$$\n");

        sb.append("hs||0||||gridx=4;;gridy=4;;weightx=1;;weighty=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto único">

        // <editor-fold defaultstate="collapsed" desc="Artérias Uterinas">

        sb.append("30;;Artérias uterinas;;330;;4;;Dados da gestação$$\n");
        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||Relação S/D;;f;;f||cdl@32@||1;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR;;t;;f||cdl@35@||1;;gridx=1$$\n");
        sb.append("pc||IP;;t;;f||cdl@38@||1;;gridx=2$$\n");
        sb.append("pc||Incisura;;f;;t||cdl@41@||1;;gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||Relação A/C;;t;;t||cdl@44@||1;;gridx=2;;gridwidth=1$$\n");
        sb.append("hs||90||||1;;gridy=0;;gridx=0$$\n");
        sb.append("hs||90||||1;;gridx=1$$\n");
        sb.append("hs||90||||1;;gridx=2$$\n");
        sb.append("pc||Artéria uterina direita;;f;;f||subcont@1@||gridx=0;;gridy=0$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Relação S/D;;f;;f||cdl@33@||2;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR;;t;;f||cdl@36@||2;;gridx=1$$\n");
        sb.append("pc||IP;;t;;f||cdl@39@||2;;gridx=2$$\n");
        sb.append("pc||Incisura;;f;;t||cdl@42@||2;;gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||Relação A/C;;t;;t||cdl@45@||2;;gridx=2;;gridwidth=1$$\n");
        sb.append("hs||90||||2;;gridy=0;;gridx=0$$\n");
        sb.append("hs||90||||2;;gridx=1$$\n");
        sb.append("hs||90||||2;;gridx=2$$\n");
        sb.append("pc||Artéria uterina esquerda;;t;;f||subcont@2@||gridx=1;;gridy=0$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||Média rel. S/D;;f;;f||cdl@48@||3;;gridy=0;;gridx=0$$\n");
        sb.append("pc||Média de IR;;t;;f||cdl@50@||3;;gridx=1$$\n");
        sb.append("pc||Média de IP;;t;;f||cdl@52@||3;;gridx=2$$\n");
        sb.append("pc||Média rel. A/C;;t;;f||cdl@54@||3;;gridx=3$$\n");
        sb.append("pc||Incisura bilateral;;t;;f||cdl@56@||3;;gridx=4$$\n");
        sb.append("pc||f;;t||lbl@( <=2,6 )@cor=0,0,255||3;;gridx=0;;gridy=3$$\n");
        sb.append("pc||t;;t||lbl@( <1,0 )@cor=0,0,255||3;;gridx=1$$\n");
        sb.append("pc||t;;t||lbl@( <=1,5 )@cor=0,0,255||3;;gridx=2$$\n");
        sb.append("pc||t;;t||lbl@( <=2,30 )@cor=0,0,255||3;;gridx=3$$\n");
        sb.append("pc||t;;t||lbl@( Ausência )@cor=0,0,255||3;;gridx=4$$\n");
        sb.append("hs||100||||3;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("hs||100||||3;;gridx=1$$\n");
        sb.append("hs||100||||3;;gridx=2$$\n");
        sb.append("hs||100||||3;;gridx=3$$\n");
        sb.append("hs||150||||3;;gridx=4$$\n");
        sb.append("pc||Média das relações das artérias uterinas;;f;;t||subcont@3@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Artérias umbilical e cerebral média">
        sb.append("57;;Artérias umbilical e cerebral média;;330;;30;;Artérias uterinas$$\n");
        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@70@||1;;gridx=0;;gridy=0;;gridwidth=2$$\n");
        sb.append("pc||Relação S/D;;t;;f||cdl@59@||1;;gridx=2;;gridwidth=1$$\n");
        sb.append("pc||IR;;f;;t||cdl@62@||1;;gridx=0;;gridy=1$$\n");
        sb.append("pc||IP;;t;;t||cdl@65@||1;;gridx=1$$\n");
        sb.append("hs||70||||1;;gridy=0;;gridx=0$$\n");
        sb.append("hs||70||||1;;gridy=0;;gridx=1$$\n");
        sb.append("hs||50||||1;;gridx=2;;$$\n");
        sb.append("pc||Artéria umbilical;;f;;f||subcont@1@||gridx=0;;gridy=0$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@71@||2;;gridy=0;;gridx=0;;gridwidth=2$$\n");
        sb.append("pc||Relação S/D;;t;;f||cdl@60@||2;;gridx=2;;gridwidth=1$$\n");
        sb.append("pc||IR;;f;;t||cdl@63@||2;;gridx=0;;gridy=1$$\n");
        sb.append("pc||IP;;t;;t||cdl@66@||2;;gridx=1$$\n");
        sb.append("pc||Pico Sistólico (ACM);;t;;t||cdl@68@||2;;gridx=2;;gridy=1$$\n");
        sb.append("hs||70||||2;;gridy=0;;gridx=0$$\n");
        sb.append("hs||70||||2;;gridy=0;;gridx=1$$\n");
        sb.append("hs||50||||2;;gridy=1;;gridx=2;;$$\n");
        sb.append("pc||Artéria cerebral média;;t;;f||subcont@2@||gridx=1;;gridy=0$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||Média S/D (Umbilical)/(Cerebral);;f;;f||cdl@74@||3;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR (Umbilical)/(Cerebral);;t;;f||cdl@76@||3;;gridx=1$$\n");
        sb.append("pc||IP (Umbilical)/(Cerebral);;t;;f||cdl@78@||3;;gridx=2$$\n");
        sb.append("pc||f;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=0;;gridy=3$$\n");
        sb.append("pc||t;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=1$$\n");
        sb.append("pc||t;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=2$$\n");
        sb.append("hs||90||||3;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("hs||90||||3;;gridx=1;;$$\n");
        sb.append("hs||90||||3;;gridx=2;;$$\n");
        sb.append("pc||Média das relações das artérias uterinas;;f;;t||subcont@3@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||0||||3;;gridx=3;;weightx=1;;gridwidth=1$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ducto Venoso">
        sb.append("79;;Ducto venoso;;330;;57;;Artérias umbilical e cerebral média$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@81@||gridx=0;;gridy=0$$\n");
        sb.append("pc||IP;;t;;f||cdl@83@||gridx=1$$\n");
        sb.append("pc||t;;f||lbl@Normal: IP 2,3 (Fluxo Ant. em fase de Contração Art.)@cor=0,0,255||gridx=2$$\n");
        sb.append("pc||Veia umbilical;;f;;t||cdl@86@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||t;;t||lbl@Normal: Fluxo contínuo@cor=0,0,255||gridx=2$$\n");
        sb.append("hs||200||||gridy=0;;gridx=0;;gridwidth=1$$\n");
        sb.append("hs||120||||gridy=0;;gridx=1$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais feto unico">

        sb.append("87;;Observações gerais;;330;;79;;Ducto venoso$$\n");
        sb.append("cdl||89||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 1">

        // <editor-fold defaultstate="collapsed" desc="Artérias Uterinas">

        sb.append("90;;Artérias uterinas - Feto 1;;330;;4;;Dados da gestação$$\n");

        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||Relação S/D;;f;;f||cdl@92@||1;;gridy=0;;gridx=0;;top_insets=0;;left_insets=0$$\n");
        sb.append("pc||IR;;t;;f||cdl@95@||1;;gridx=1$$\n");
        sb.append("pc||IP;;t;;f||cdl@98@||1;;gridx=2$$\n");
        sb.append("pc||Incisura;;f;;t||cdl@101@||1;;gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||Relação A/C;;t;;t||cdl@104@||1;;gridx=2;;gridwidth=1$$\n");
        sb.append("hs||90||||1;;gridy=0;;gridx=0$$\n");
        sb.append("hs||90||||1;;gridx=1;;$$\n");
        sb.append("hs||90||||1;;gridx=2;;$$\n");
        sb.append("pc||Artéria uterina direita;;f;;f||subcont@1@||gridx=0;;gridy=0$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Relação S/D;;f;;f||cdl@93@||2;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR;;t;;f||cdl@96@||2;;gridx=1$$\n");
        sb.append("pc||IP;;t;;f||cdl@99@||2;;gridx=2$$\n");
        sb.append("pc||Incisura;;f;;t||cdl@102@||2;;gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||Relação A/C;;t;;t||cdl@105@||2;;gridx=2;;gridwidth=1$$\n");
        sb.append("hs||90||||2;;gridy=0;;gridx=0$$\n");
        sb.append("hs||90||||2;;gridx=1;;$$\n");
        sb.append("hs||90||||2;;gridx=2;;$$\n");
        sb.append("pc||Artéria uterina esquerda;;t;;f||subcont@2@||gridx=1;;gridy=0$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||Média rel. S/D;;f;;f||cdl@108@||3;;gridy=0;;gridx=0$$\n");
        sb.append("pc||Média de IR;;t;;f||cdl@110@||3;;gridx=1$$\n");
        sb.append("pc||Média de IP;;t;;f||cdl@112@||3;;gridx=2$$\n");
        sb.append("pc||Média rel. A/C;;t;;f||cdl@114@||3;;gridx=3$$\n");
        sb.append("pc||Incisura bilateral;;t;;f||cdl@116@||3;;gridx=4$$\n");
        sb.append("pc||f;;t||lbl@( <=2,6 )@cor=0,0,255||3;;gridx=0;;gridy=3$$\n");
        sb.append("pc||t;;t||lbl@( <1,0 )@cor=0,0,255||3;;gridx=1$$\n");
        sb.append("pc||t;;t||lbl@( <=1,5 )@cor=0,0,255||3;;gridx=2$$\n");
        sb.append("pc||t;;t||lbl@( <=2,30 )@cor=0,0,255||3;;gridx=3$$\n");
        sb.append("pc||t;;t||lbl@( Ausência )@cor=0,0,255||3;;gridx=4$$\n");
        sb.append("hs||100||||3;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("hs||100||||3;;gridx=1;;$$\n");
        sb.append("hs||100||||3;;gridx=2;;$$\n");
        sb.append("hs||100||||3;;gridx=3;;$$\n");
        sb.append("hs||150||||3;;gridx=4;;$$\n");
        sb.append("pc||Média das relações das artérias uterinas;;f;;t||subcont@3@||gridx=0;;gridy=1;;gridwidth=2$$\n");

        sb.append("hs||0||||gridx=2;;gridy=2;;weightx=1;;weighty=1;;gridwidth=1$$\n");

        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Artérias umbilical e cerebral média">

        sb.append("117;;Artérias umbilical e cerebral média - Feto 1;;330;;90;;Artérias uterinas - Feto 1$$\n");
        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@130@||1;;gridx=0;;gridy=0;;gridwidth=2$$\n");
        sb.append("pc||Relação S/D;;t;;f||cdl@119@||1;;gridx=2;;gridwidth=1$$\n");
        sb.append("pc||IR;;f;;t||cdl@122@||1;;gridx=0;;gridy=1$$\n");
        sb.append("pc||IP;;t;;t||cdl@125@||1;;gridx=1$$\n");
        sb.append("hs||70||||1;;gridy=0;;gridx=0$$\n");
        sb.append("hs||70||||1;;gridy=0;;gridx=1$$\n");
        sb.append("hs||50||||1;;gridx=2;;$$\n");
        sb.append("pc||Artéria umbilical;;f;;f||subcont@1@||gridx=0;;gridy=0$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@131@||2;;gridy=0;;gridx=0;;gridwidth=2$$\n");
        sb.append("pc||Relação S/D;;t;;f||cdl@120@||2;;gridx=2;;gridwidth=1$$\n");
        sb.append("pc||IR;;f;;t||cdl@123@||2;;gridx=0;;gridy=1$$\n");
        sb.append("pc||IP;;t;;t||cdl@126@||2;;gridx=1$$\n");
        sb.append("pc||Pico sistólico (ACM);;t;;t||cdl@128@||2;;gridx=2;;gridy=1$$\n");
        sb.append("hs||70||||2;;gridy=0;;gridx=0$$\n");
        sb.append("hs||70||||2;;gridy=0;;gridx=1$$\n");
        sb.append("hs||50||||2;;gridy=1;;gridx=2;;$$\n");
        sb.append("pc||Artéria cerebral média;;t;;f||subcont@2@||gridx=1;;gridy=0$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||Média S/D (Umbilical)/(Cerebral);;f;;f||cdl@134@||3;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR (Umbilical)/(Cerebral);;t;;f||cdl@136@||3;;gridx=1$$\n");
        sb.append("pc||IP (Umbilical)/(Cerebral);;t;;f||cdl@138@||3;;gridx=2$$\n");
        sb.append("pc||f;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=0;;gridy=3$$\n");
        sb.append("pc||t;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=1$$\n");
        sb.append("pc||t;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=2$$\n");
        sb.append("hs||90||||3;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("hs||90||||3;;gridx=1;;$$\n");
        sb.append("hs||90||||3;;gridx=2;;$$\n");
        sb.append("pc||Média das relações das artérias uterinas;;f;;t||subcont@3@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||0||||3;;gridx=3;;weightx=1;;gridwidth=1$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ducto venoso - Feto 1 ">
        sb.append("139;;Ducto venoso - Feto 1;;330;;117;;Artérias umbilical e cerebral média - Feto 1$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@141@||gridx=0;;gridy=0$$\n");
        sb.append("pc||IP;;t;;f||cdl@143@||gridx=1$$\n");
        sb.append("pc||t;;f||lbl@Normal: IP 2,3 (Fluxo anterogrado em fase de contração arterial)@cor=0,0,255||gridx=2$$\n");
        sb.append("pc||Veia umbilical;;f;;t||cdl@146@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||t;;t||lbl@Normal: Fluxo contínuo@cor=0,0,255||gridx=2$$\n");
        sb.append("hs||200||||gridy=0;;gridx=0;;gridwidth=1$$\n");
        sb.append("hs||120||||gridy=0;;gridx=1$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais 1">

        sb.append("147;;Observações gerais - Feto 1;;330;;139;;Ducto venoso - Feto 1$$\n");
        sb.append("cdl||149||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 2">

        // <editor-fold defaultstate="collapsed" desc="Artérias Uterinas">

        sb.append("150;;Artérias uterinas - Feto 2;;330;;147;;Observações gerais - Feto 1$$\n");
        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||Relação S/D;;f;;f||cdl@152@||1;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR;;t;;f||cdl@155@||1;;gridx=1$$\n");
        sb.append("pc||IP;;t;;f||cdl@158@||1;;gridx=2$$\n");
        sb.append("pc||Incisura;;f;;t||cdl@161@||1;;gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||Relação A/C;;t;;t||cdl@164@||1;;gridx=2;;gridwidth=1$$\n");
        sb.append("hs||90||||1;;gridy=0;;gridx=0$$\n");
        sb.append("hs||90||||1;;gridx=1;;$$\n");
        sb.append("hs||90||||1;;gridx=2;;$$\n");
        sb.append("pc||Artéria uterina direita;;f;;f||subcont@1@||gridx=0;;gridy=0$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Relação S/D;;f;;f||cdl@153@||2;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR;;t;;f||cdl@156@||2;;gridx=1$$\n");
        sb.append("pc||IP;;t;;f||cdl@159@||2;;gridx=2$$\n");
        sb.append("pc||Incisura;;f;;t||cdl@162@||2;;gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||Relação A/C;;t;;t||cdl@165@||2;;gridx=2;;gridwidth=1$$\n");
        sb.append("hs||90||||2;;gridy=0;;gridx=0$$\n");
        sb.append("hs||90||||2;;gridx=1;;$$\n");
        sb.append("hs||90||||2;;gridx=2;;$$\n");
        sb.append("pc||Artéria uterina esquerda;;t;;f||subcont@2@||gridx=1;;gridy=0$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||Média rel. S/D;;f;;f||cdl@168@||3;;gridy=0;;gridx=0$$\n");
        sb.append("pc||Média de IR;;t;;f||cdl@170@||3;;gridx=1$$\n");
        sb.append("pc||Média de IP;;t;;f||cdl@172@||3;;gridx=2$$\n");
        sb.append("pc||Média rel. A/C;;t;;f||cdl@174@||3;;gridx=3$$\n");
        sb.append("pc||Incisura bilateral;;t;;f||cdl@176@||3;;gridx=4$$\n");
        sb.append("pc||f;;t||lbl@( <=2,6 )@cor=0,0,255||3;;gridx=0;;gridy=3$$\n");
        sb.append("pc||t;;t||lbl@( <1,0 )@cor=0,0,255||3;;gridx=1$$\n");
        sb.append("pc||t;;t||lbl@( <=1,5 )@cor=0,0,255||3;;gridx=2$$\n");
        sb.append("pc||t;;t||lbl@( <=2,30 )@cor=0,0,255||3;;gridx=3$$\n");
        sb.append("pc||t;;t||lbl@( Ausência )@cor=0,0,255||3;;gridx=4$$\n");
        sb.append("hs||100||||3;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("hs||100||||3;;gridx=1;;$$\n");
        sb.append("hs||100||||3;;gridx=2;;$$\n");
        sb.append("hs||100||||3;;gridx=3;;$$\n");
        sb.append("hs||150||||3;;gridx=4;;$$\n");
        sb.append("pc||Média das relações das artérias uterinas;;f;;t||subcont@3@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Artérias umbilical e cerebral média">
        sb.append("177;;Artérias umbilical e cerebral média - Feto 2;;330;;150;;Artérias uterinas - Feto 2$$\n");
        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@190@||1;;gridx=0;;gridy=0;;gridwidth=2$$\n");
        sb.append("pc||Relação S/D;;t;;f||cdl@179@||1;;gridx=2;;gridwidth=1$$\n");
        sb.append("pc||IR;;f;;t||cdl@182@||1;;gridx=0;;gridy=1$$\n");
        sb.append("pc||IP;;t;;t||cdl@185@||1;;gridx=1$$\n");
        sb.append("hs||70||||1;;gridy=0;;gridx=0$$\n");
        sb.append("hs||70||||1;;gridy=0;;gridx=1$$\n");
        sb.append("hs||50||||1;;gridx=2;;$$\n");
        sb.append("pc||Artéria umbilical;;f;;f||subcont@1@||gridx=0;;gridy=0$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@191@||2;;gridy=0;;gridx=0;;gridwidth=2$$\n");
        sb.append("pc||Relação S/D;;t;;f||cdl@180@||2;;gridx=2;;gridwidth=1$$\n");
        sb.append("pc||IR;;f;;t||cdl@183@||2;;gridx=0;;gridy=1$$\n");
        sb.append("pc||IP;;t;;t||cdl@186@||2;;gridx=1$$\n");
        sb.append("pc||Pico sistólico (ACM);;t;;t||cdl@188@||2;;gridx=2;;gridy=1$$\n");
        sb.append("hs||70||||2;;gridy=0;;gridx=0$$\n");
        sb.append("hs||70||||2;;gridy=0;;gridx=1$$\n");
        sb.append("hs||50||||2;;gridy=1;;gridx=2;;$$\n");
        sb.append("pc||Artéria cerebral média;;t;;f||subcont@2@||gridx=1;;gridy=0$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||Média S/D (Umbilical)/(Cerebral);;f;;f||cdl@194@||3;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR (Umbilical)/(Cerebral);;t;;f||cdl@196@||3;;gridx=1$$\n");
        sb.append("pc||IP (Umbilical)/(Cerebral);;t;;f||cdl@198@||3;;gridx=2$$\n");
        sb.append("pc||f;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=0;;gridy=3$$\n");
        sb.append("pc||t;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=1$$\n");
        sb.append("pc||t;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=2$$\n");
        sb.append("hs||90||||3;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("hs||90||||3;;gridx=1;;$$\n");
        sb.append("hs||90||||3;;gridx=2;;$$\n");
        sb.append("pc||Média das relações das artérias uterinas;;f;;t||subcont@3@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||0||||3;;gridx=3;;weightx=1;;gridwidth=1$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ducto Venoso">
        sb.append("199;;Ducto venoso - Feto 2;;330;;177;;Artérias umbilical e cerebral média - Feto 2$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@201@||gridx=0;;gridy=0$$\n");
        sb.append("pc||IP;;t;;f||cdl@203@||gridx=1$$\n");
        sb.append("pc||t;;f||lbl@Normal: IP 2,3 (Fluxo anterogrado em fase de contração arterial)@cor=0,0,255||gridx=2$$\n");
        sb.append("pc||Veia umbilical;;f;;t||cdl@206@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||t;;t||lbl@Normal: Fluxo contínuo@cor=0,0,255||gridx=2$$\n");
        sb.append("hs||200||||gridy=0;;gridx=0;;gridwidth=1$$\n");
        sb.append("hs||120||||gridy=0;;gridx=1$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais - Feto 2">

        sb.append("207;;Observações gerais - Feto 2;;330;;199;;Ducto venoso - Feto 2$$\n");
        sb.append("cdl||209||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 3">

        // <editor-fold defaultstate="collapsed" desc="Artérias Uterinas">

        sb.append("210;;Artérias uterinas - Feto 3;;330;;207;;Observações gerais - Feto 2$$\n");
        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||Relação S/D;;f;;f||cdl@212@||1;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR;;t;;f||cdl@215@||1;;gridx=1$$\n");
        sb.append("pc||IP;;t;;f||cdl@218@||1;;gridx=2$$\n");
        sb.append("pc||Incisura;;f;;t||cdl@221@||1;;gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||Relação A/C;;t;;t||cdl@224@||1;;gridx=2;;gridwidth=1$$\n");
        sb.append("hs||90||||1;;gridy=0;;gridx=0$$\n");
        sb.append("hs||90||||1;;gridx=1;;$$\n");
        sb.append("hs||90||||1;;gridx=2;;$$\n");
        sb.append("pc||Artéria uterina direita;;f;;f||subcont@1@||gridx=0;;gridy=0$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Relação S/D;;f;;f||cdl@213@||2;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR;;t;;f||cdl@216@||2;;gridx=1$$\n");
        sb.append("pc||IP;;t;;f||cdl@219@||2;;gridx=2$$\n");
        sb.append("pc||Incisura;;f;;t||cdl@222@||2;;gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||Relação A/C;;t;;t||cdl@225@||2;;gridx=2;;gridwidth=1$$\n");
        sb.append("hs||90||||2;;gridy=0;;gridx=0$$\n");
        sb.append("hs||90||||2;;gridx=1;;$$\n");
        sb.append("hs||90||||2;;gridx=2;;$$\n");
        sb.append("pc||Artéria uterina esquerda;;t;;f||subcont@2@||gridx=1;;gridy=0$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||Média rel. S/D;;f;;f||cdl@228@||3;;gridy=0;;gridx=0$$\n");
        sb.append("pc||Média de IR;;t;;f||cdl@230@||3;;gridx=1$$\n");
        sb.append("pc||Média de IP;;t;;f||cdl@232@||3;;gridx=2$$\n");
        sb.append("pc||Média rel. A/C;;t;;f||cdl@234@||3;;gridx=3$$\n");
        sb.append("pc||Incisura bilateral;;t;;f||cdl@236@||3;;gridx=4$$\n");
        sb.append("pc||f;;t||lbl@( <=2,6 )@cor=0,0,255||3;;gridx=0;;gridy=3$$\n");
        sb.append("pc||t;;t||lbl@( <1,0 )@cor=0,0,255||3;;gridx=1$$\n");
        sb.append("pc||t;;t||lbl@( <=1,5 )@cor=0,0,255||3;;gridx=2$$\n");
        sb.append("pc||t;;t||lbl@( <=2,30 )@cor=0,0,255||3;;gridx=3$$\n");
        sb.append("pc||t;;t||lbl@( Ausência )@cor=0,0,255||3;;gridx=4$$\n");
        sb.append("hs||100||||3;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("hs||100||||3;;gridx=1;;$$\n");
        sb.append("hs||100||||3;;gridx=2;;$$\n");
        sb.append("hs||100||||3;;gridx=3;;$$\n");
        sb.append("hs||150||||3;;gridx=4;;$$\n");
        sb.append("pc||Média das relações das artérias uterinas;;f;;t||subcont@3@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Artérias umbilical e cerebral média">
        sb.append("237;;Artérias umbilical e cerebral média - Feto 3;;330;;210;;Artérias uterinas - Feto 3$$\n");
        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@250@||1;;gridx=0;;gridy=0;;gridwidth=2$$\n");
        sb.append("pc||Relação S/D;;t;;f||cdl@239@||1;;gridx=2;;gridwidth=1$$\n");
        sb.append("pc||IR;;f;;t||cdl@242@||1;;gridx=0;;gridy=1$$\n");
        sb.append("pc||IP;;t;;t||cdl@245@||1;;gridx=1$$\n");
        sb.append("hs||70||||1;;gridy=0;;gridx=0$$\n");
        sb.append("hs||70||||1;;gridy=0;;gridx=1$$\n");
        sb.append("hs||50||||1;;gridx=2;;$$\n");
        sb.append("pc||Artéria umbilical;;f;;f||subcont@1@||gridx=0;;gridy=0$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@251@||2;;gridy=0;;gridx=0;;gridwidth=2$$\n");
        sb.append("pc||Relação S/D;;t;;f||cdl@240@||2;;gridx=2;;gridwidth=1$$\n");
        sb.append("pc||IR;;f;;t||cdl@243@||2;;gridx=0;;gridy=1$$\n");
        sb.append("pc||IP;;t;;t||cdl@246@||2;;gridx=1$$\n");
        sb.append("pc||Pico sistólico (ACM);;t;;t||cdl@248@||2;;gridx=2;;gridy=1$$\n");
        sb.append("hs||70||||2;;gridy=0;;gridx=0$$\n");
        sb.append("hs||70||||2;;gridy=0;;gridx=1$$\n");
        sb.append("hs||50||||2;;gridy=1;;gridx=2;;$$\n");
        sb.append("pc||Artéria cerebral média;;t;;f||subcont@2@||gridx=1;;gridy=0$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||Média S/D (Umbilical)/(Cerebral);;f;;f||cdl@254@||3;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR (Umbilical)/(Cerebral);;t;;f||cdl@256@||3;;gridx=1$$\n");
        sb.append("pc||IP (Umbilical)/(Cerebral);;t;;f||cdl@258@||3;;gridx=2$$\n");
        sb.append("pc||f;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=0;;gridy=3$$\n");
        sb.append("pc||t;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=1$$\n");
        sb.append("pc||t;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=2$$\n");
        sb.append("hs||90||||3;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("hs||90||||3;;gridx=1;;$$\n");
        sb.append("hs||90||||3;;gridx=2;;$$\n");
        sb.append("pc||Média das relações das artérias uterinas;;f;;t||subcont@3@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||0||||3;;gridx=3;;weightx=1;;gridwidth=1$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ducto Venoso">
        sb.append("259;;Ducto venoso - Feto 3;;330;;237;;Artérias umbilical e cerebral média - Feto 3$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@261@||gridx=0;;gridy=0$$\n");
        sb.append("pc||IP;;t;;f||cdl@263@||gridx=1$$\n");
        sb.append("pc||t;;f||lbl@Normal: IP 2,3 (Fluxo anterogrado em fase de contração arterial)@cor=0,0,255||gridx=2$$\n");
        sb.append("pc||Veia umbilical;;f;;t||cdl@266@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||t;;t||lbl@Normal: Fluxo contínuo@cor=0,0,255||gridx=2$$\n");
        sb.append("hs||200||||gridy=0;;gridx=0;;gridwidth=1$$\n");
        sb.append("hs||120||||gridy=0;;gridx=1$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais - Feto">

        sb.append("267;;Observações gerais - Feto 3;;330;;259;;Ducto venoso - Feto 3$$\n");
        sb.append("cdl||269||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 4">

        // <editor-fold defaultstate="collapsed" desc="Artérias Uterinas">

        sb.append("270;;Artérias uterinas - Feto 4;;330;;267;;Observações gerais - Feto 3$$\n");
        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||Relação S/D;;f;;f||cdl@272@||1;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR;;t;;f||cdl@275@||1;;gridx=1$$\n");
        sb.append("pc||IP;;t;;f||cdl@278@||1;;gridx=2$$\n");
        sb.append("pc||Incisura;;f;;t||cdl@281@||1;;gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||Relação A/C;;t;;t||cdl@284@||1;;gridx=2;;gridwidth=1$$\n");
        sb.append("hs||90||||1;;gridy=0;;gridx=0$$\n");
        sb.append("hs||90||||1;;gridx=1;;$$\n");
        sb.append("hs||90||||1;;gridx=2;;$$\n");
        sb.append("pc||Artéria uterina direita;;f;;f||subcont@1@||gridx=0;;gridy=0$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Relação S/D;;f;;f||cdl@273@||2;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR;;t;;f||cdl@276@||2;;gridx=1$$\n");
        sb.append("pc||IP;;t;;f||cdl@279@||2;;gridx=2$$\n");
        sb.append("pc||Incisura;;f;;t||cdl@282@||2;;gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||Relação A/C;;t;;t||cdl@285@||2;;gridx=2;;gridwidth=1$$\n");
        sb.append("hs||90||||2;;gridy=0;;gridx=0$$\n");
        sb.append("hs||90||||2;;gridx=1;;$$\n");
        sb.append("hs||90||||2;;gridx=2;;$$\n");
        sb.append("pc||Artéria uterina esquerda;;t;;f||subcont@2@||gridx=1;;gridy=0$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||Média rel. S/D;;f;;f||cdl@288@||3;;gridy=0;;gridx=0$$\n");
        sb.append("pc||Média de IR;;t;;f||cdl@290@||3;;gridx=1$$\n");
        sb.append("pc||Média de IP;;t;;f||cdl@292@||3;;gridx=2$$\n");
        sb.append("pc||Média rel. A/C;;t;;f||cdl@294@||3;;gridx=3$$\n");
        sb.append("pc||Incisura bilateral;;t;;f||cdl@296@||3;;gridx=4$$\n");
        sb.append("pc||f;;t||lbl@( <=2,6 )@cor=0,0,255||3;;gridx=0;;gridy=3$$\n");
        sb.append("pc||t;;t||lbl@( <1,0 )@cor=0,0,255||3;;gridx=1$$\n");
        sb.append("pc||t;;t||lbl@( <=1,5 )@cor=0,0,255||3;;gridx=2$$\n");
        sb.append("pc||t;;t||lbl@( <=2,30 )@cor=0,0,255||3;;gridx=3$$\n");
        sb.append("pc||t;;t||lbl@( Ausência )@cor=0,0,255||3;;gridx=4$$\n");
        sb.append("hs||100||||3;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("hs||100||||3;;gridx=1;;$$\n");
        sb.append("hs||100||||3;;gridx=2;;$$\n");
        sb.append("hs||100||||3;;gridx=3;;$$\n");
        sb.append("hs||150||||3;;gridx=4;;$$\n");
        sb.append("pc||Média das relações das artérias uterinas;;f;;t||subcont@3@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Artérias umbilical e cerebral média">
        sb.append("297;;Artérias umbilical e cerebral média - Feto 4;;330;;270;;Artérias uterinas - Feto 4$$\n");
        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@310@||1;;gridx=0;;gridy=0;;gridwidth=2$$\n");
        sb.append("pc||Relação S/D;;t;;f||cdl@299@||1;;gridx=2;;gridwidth=1$$\n");
        sb.append("pc||IR;;f;;t||cdl@302@||1;;gridx=0;;gridy=1$$\n");
        sb.append("pc||IP;;t;;t||cdl@305@||1;;gridx=1$$\n");
        sb.append("hs||70||||1;;gridy=0;;gridx=0$$\n");
        sb.append("hs||70||||1;;gridy=0;;gridx=1$$\n");
        sb.append("hs||50||||1;;gridx=2;;$$\n");
        sb.append("pc||Artéria umbilical;;f;;f||subcont@1@||gridx=0;;gridy=0$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@311@||2;;gridy=0;;gridx=0;;gridwidth=2$$\n");
        sb.append("pc||Relação S/D;;t;;f||cdl@300@||2;;gridx=2;;gridwidth=1$$\n");
        sb.append("pc||IR;;f;;t||cdl@303@||2;;gridx=0;;gridy=1$$\n");
        sb.append("pc||IP;;t;;t||cdl@306@||2;;gridx=1$$\n");
        sb.append("pc||Pico sistólico (ACM);;t;;t||cdl@308@||2;;gridx=2;;gridy=1$$\n");
        sb.append("hs||70||||2;;gridy=0;;gridx=0$$\n");
        sb.append("hs||70||||2;;gridy=0;;gridx=1$$\n");
        sb.append("hs||50||||2;;gridy=1;;gridx=2;;$$\n");
        sb.append("pc||Artéria cerebral média;;t;;f||subcont@2@||gridx=1;;gridy=0$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||Média S/D (Umbilical)/(Cerebral);;f;;f||cdl@314@||3;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR (Umbilical)/(Cerebral);;t;;f||cdl@316@||3;;gridx=1$$\n");
        sb.append("pc||IP (Umbilical)/(Cerebral);;t;;f||cdl@318@||3;;gridx=2$$\n");
        sb.append("pc||f;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=0;;gridy=3$$\n");
        sb.append("pc||t;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=1$$\n");
        sb.append("pc||t;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=2$$\n");
        sb.append("hs||90||||3;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("hs||90||||3;;gridx=1;;$$\n");
        sb.append("hs||90||||3;;gridx=2;;$$\n");
        sb.append("pc||Média das relações das artérias uterinas;;f;;t||subcont@3@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||0||||3;;gridx=3;;weightx=1;;gridwidth=1$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ducto Venoso">
        sb.append("319;;Ducto venoso - Feto 4;;330;;297;;Artérias umbilical e cerebral média - Feto 4$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@321@||gridx=0;;gridy=0$$\n");
        sb.append("pc||IP;;t;;f||cdl@323@||gridx=1$$\n");
        sb.append("pc||t;;f||lbl@Normal: IP 2,3 (Fluxo anterogrado em fase de contração arterial)@cor=0,0,255||gridx=2$$\n");
        sb.append("pc||Veia umbilical;;f;;t||cdl@326@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||t;;t||lbl@Normal: Fluxo contínuo@cor=0,0,255||gridx=2$$\n");
        sb.append("hs||200||||gridy=0;;gridx=0;;gridwidth=1$$\n");
        sb.append("hs||120||||gridy=0;;gridx=1$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais  - Feto 4">

        sb.append("327;;Observações gerais - Feto 4;;330;;319;;Ducto venoso - Feto 4$$\n");
        sb.append("cdl||329||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 5">

        // <editor-fold defaultstate="collapsed" desc="Artérias Uterinas">

        sb.append("330;;Artérias uterinas - Feto 5;;330;;327;;Observações gerais - Feto 4$$\n");
        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||Relação S/D;;f;;f||cdl@332@||1;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR;;t;;f||cdl@335@||1;;gridx=1$$\n");
        sb.append("pc||IP;;t;;f||cdl@338@||1;;gridx=2$$\n");
        sb.append("pc||Incisura;;f;;t||cdl@341@||1;;gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||Relação A/C;;t;;t||cdl@344@||1;;gridx=2;;gridwidth=1$$\n");
        sb.append("hs||90||||1;;gridy=0;;gridx=0$$\n");
        sb.append("hs||90||||1;;gridx=1;;$$\n");
        sb.append("hs||90||||1;;gridx=2;;$$\n");
        sb.append("pc||Artéria uterina direita;;f;;f||subcont@1@||gridx=0;;gridy=0$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Relação S/D;;f;;f||cdl@333@||2;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR;;t;;f||cdl@336@||2;;gridx=1$$\n");
        sb.append("pc||IP;;t;;f||cdl@339@||2;;gridx=2$$\n");
        sb.append("pc||Incisura;;f;;t||cdl@342@||2;;gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||Relação A/C;;t;;t||cdl@345@||2;;gridx=2;;gridwidth=1$$\n");
        sb.append("hs||90||||2;;gridy=0;;gridx=0$$\n");
        sb.append("hs||90||||2;;gridx=1;;$$\n");
        sb.append("hs||90||||2;;gridx=2;;$$\n");
        sb.append("pc||Artéria uterina esquerda;;t;;f||subcont@2@||gridx=1;;gridy=0$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||Média rel. S/D;;f;;f||cdl@348@||3;;gridy=0;;gridx=0$$\n");
        sb.append("pc||Média de IR;;t;;f||cdl@350@||3;;gridx=1$$\n");
        sb.append("pc||Média de IP;;t;;f||cdl@352@||3;;gridx=2$$\n");
        sb.append("pc||Média rel. A/C;;t;;f||cdl@354@||3;;gridx=3$$\n");
        sb.append("pc||Incisura bilateral;;t;;f||cdl@356@||3;;gridx=4$$\n");
        sb.append("pc||f;;t||lbl@( <=2,6 )@cor=0,0,255||3;;gridx=0;;gridy=3$$\n");
        sb.append("pc||t;;t||lbl@( <1,0 )@cor=0,0,255||3;;gridx=1$$\n");
        sb.append("pc||t;;t||lbl@( <=1,5 )@cor=0,0,255||3;;gridx=2$$\n");
        sb.append("pc||t;;t||lbl@( <=2,30 )@cor=0,0,255||3;;gridx=3$$\n");
        sb.append("pc||t;;t||lbl@( Ausência )@cor=0,0,255||3;;gridx=4$$\n");
        sb.append("hs||100||||3;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("hs||100||||3;;gridx=1;;$$\n");
        sb.append("hs||100||||3;;gridx=2;;$$\n");
        sb.append("hs||100||||3;;gridx=3;;$$\n");
        sb.append("hs||150||||3;;gridx=4;;$$\n");
        sb.append("pc||Média das relações das artérias uterinas;;f;;t||subcont@3@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Artérias umbilical e cerebral média">
        sb.append("357;;Artérias umbilical e cerebral média - Feto 5;;330;;330;;Artérias uterinas - Feto 5$$\n");
        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@370@||1;;gridx=0;;gridy=0;;gridwidth=2$$\n");
        sb.append("pc||Relação S/D;;t;;f||cdl@359@||1;;gridx=2;;gridwidth=1$$\n");
        sb.append("pc||IR;;f;;t||cdl@362@||1;;gridx=0;;gridy=1$$\n");
        sb.append("pc||IP;;t;;t||cdl@365@||1;;gridx=1$$\n");
        sb.append("hs||70||||1;;gridy=0;;gridx=0$$\n");
        sb.append("hs||70||||1;;gridy=0;;gridx=1$$\n");
        sb.append("hs||50||||1;;gridx=2;;$$\n");
        sb.append("pc||Artéria umbilical;;f;;f||subcont@1@||gridx=0;;gridy=0$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@371@||2;;gridy=0;;gridx=0;;gridwidth=2$$\n");
        sb.append("pc||Relação S/D;;t;;f||cdl@360@||2;;gridx=2;;gridwidth=1$$\n");
        sb.append("pc||IR;;f;;t||cdl@363@||2;;gridx=0;;gridy=1$$\n");
        sb.append("pc||IP;;t;;t||cdl@366@||2;;gridx=1$$\n");
        sb.append("pc||Pico sistólico (ACM);;t;;t||cdl@368@||2;;gridx=2;;gridy=1$$\n");
        sb.append("hs||70||||2;;gridy=0;;gridx=0$$\n");
        sb.append("hs||70||||2;;gridy=0;;gridx=1$$\n");
        sb.append("hs||50||||2;;gridy=1;;gridx=2;;$$\n");
        sb.append("pc||Artéria cerebral média;;t;;f||subcont@2@||gridx=1;;gridy=0$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||Média S/D (Umbilical)/(Cerebral);;f;;f||cdl@374@||3;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR (Umbilical)/(Cerebral);;t;;f||cdl@376@||3;;gridx=1$$\n");
        sb.append("pc||IP (Umbilical)/(Cerebral);;t;;f||cdl@378@||3;;gridx=2$$\n");
        sb.append("pc||f;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=0;;gridy=3$$\n");
        sb.append("pc||t;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=1$$\n");
        sb.append("pc||t;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=2$$\n");
        sb.append("hs||90||||3;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("hs||90||||3;;gridx=1;;$$\n");
        sb.append("hs||90||||3;;gridx=2;;$$\n");
        sb.append("pc||Média das relações das artérias uterinas;;f;;t||subcont@3@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||0||||3;;gridx=3;;weightx=1;;gridwidth=1$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ducto Venoso">
        sb.append("379;;Ducto venoso - Feto 5;;330;;357;;Artérias umbilical e cerebral média - Feto 5$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@381@||gridx=0;;gridy=0$$\n");
        sb.append("pc||IP;;t;;f||cdl@383@||gridx=1$$\n");
        sb.append("pc||t;;f||lbl@Normal: IP 2,3 (Fluxo anterogrado em fase de contração arterial)@cor=0,0,255||gridx=2$$\n");
        sb.append("pc||Veia umbilical;;f;;t||cdl@386@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||t;;t||lbl@Normal: Fluxo contínuo@cor=0,0,255||gridx=2$$\n");
        sb.append("hs||200||||gridy=0;;gridx=0;;gridwidth=1$$\n");
        sb.append("hs||120||||gridy=0;;gridx=1$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais - Feto unico">

        sb.append("387;;Observações gerais - Feto 5;;330;;379;;Ducto venoso - Feto 5$$\n");
        sb.append("cdl||389||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Feto 6">

        // <editor-fold defaultstate="collapsed" desc="Artérias Uterinas">

        sb.append("390;;Artérias uterinas - Feto 6;;330;;387;;Observações gerais - Feto 5$$\n");
        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||Relação S/D;;f;;f||cdl@392@||1;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR;;t;;f||cdl@395@||1;;gridx=1$$\n");
        sb.append("pc||IP;;t;;f||cdl@398@||1;;gridx=2$$\n");
        sb.append("pc||Incisura;;f;;t||cdl@401@||1;;gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||Relação A/C;;t;;t||cdl@404@||1;;gridx=2;;gridwidth=1$$\n");
        sb.append("hs||90||||1;;gridy=0;;gridx=0$$\n");
        sb.append("hs||90||||1;;gridx=1;;$$\n");
        sb.append("hs||90||||1;;gridx=2;;$$\n");
        sb.append("pc||Artéria uterina direita;;f;;f||subcont@1@||gridx=0;;gridy=0$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Relação S/D;;f;;f||cdl@393@||2;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR;;t;;f||cdl@396@||2;;gridx=1$$\n");
        sb.append("pc||IP;;t;;f||cdl@399@||2;;gridx=2$$\n");
        sb.append("pc||Incisura;;f;;t||cdl@402@||2;;gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||Relação A/C;;t;;t||cdl@405@||2;;gridx=2;;gridwidth=1$$\n");
        sb.append("hs||90||||2;;gridy=0;;gridx=0$$\n");
        sb.append("hs||90||||2;;gridx=1;;$$\n");
        sb.append("hs||90||||2;;gridx=2;;$$\n");
        sb.append("pc||Artéria uterina esquerda;;t;;f||subcont@2@||gridx=1;;gridy=0$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||Média rel. S/D;;f;;f||cdl@408@||3;;gridy=0;;gridx=0$$\n");
        sb.append("pc||Média de IR;;t;;f||cdl@410@||3;;gridx=1$$\n");
        sb.append("pc||Média de IP;;t;;f||cdl@412@||3;;gridx=2$$\n");
        sb.append("pc||Média rel. A/C;;t;;f||cdl@414@||3;;gridx=3$$\n");
        sb.append("pc||Incisura bilateral;;t;;f||cdl@416@||3;;gridx=4$$\n");
        sb.append("pc||f;;t||lbl@( <=2,6 )@cor=0,0,255||3;;gridx=0;;gridy=3$$\n");
        sb.append("pc||t;;t||lbl@( <1,0 )@cor=0,0,255||3;;gridx=1$$\n");
        sb.append("pc||t;;t||lbl@( <=1,5 )@cor=0,0,255||3;;gridx=2$$\n");
        sb.append("pc||t;;t||lbl@( <=2,30 )@cor=0,0,255||3;;gridx=3$$\n");
        sb.append("pc||t;;t||lbl@( Ausência )@cor=0,0,255||3;;gridx=4$$\n");
        sb.append("hs||100||||3;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("hs||100||||3;;gridx=1;;$$\n");
        sb.append("hs||100||||3;;gridx=2;;$$\n");
        sb.append("hs||100||||3;;gridx=3;;$$\n");
        sb.append("hs||150||||3;;gridx=4;;$$\n");
        sb.append("pc||Média das relações das artérias uterinas;;f;;t||subcont@3@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Artérias umbilical e cerebral média">
        sb.append("417;;Artérias umbilical e cerebral média - Feto 6;;330;;390;;Artérias uterinas - Feto 6$$\n");
        sb.append("subpnl||||||->1$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@430@||1;;gridx=0;;gridy=0;;gridwidth=2$$\n");
        sb.append("pc||Relação S/D;;t;;f||cdl@419@||1;;gridx=2;;gridwidth=1$$\n");
        sb.append("pc||IR;;f;;t||cdl@422@||1;;gridx=0;;gridy=1$$\n");
        sb.append("pc||IP;;t;;t||cdl@425@||1;;gridx=1$$\n");
        sb.append("hs||70||||1;;gridy=0;;gridx=0$$\n");
        sb.append("hs||70||||1;;gridy=0;;gridx=1$$\n");
        sb.append("hs||50||||1;;gridx=2;;$$\n");
        sb.append("pc||Artéria umbilical;;f;;f||subcont@1@||gridx=0;;gridy=0$$\n");

        sb.append("subpnl||||||->2$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@431@||2;;gridy=0;;gridx=0;;gridwidth=2$$\n");
        sb.append("pc||Relação S/D;;t;;f||cdl@420@||2;;gridx=2;;gridwidth=1$$\n");
        sb.append("pc||IR;;f;;t||cdl@423@||2;;gridx=0;;gridy=1$$\n");
        sb.append("pc||IP;;t;;t||cdl@426@||2;;gridx=1$$\n");
        sb.append("pc||Pico sistólico (ACM);;t;;t||cdl@428@||2;;gridx=2;;gridy=1$$\n");
        sb.append("hs||70||||2;;gridy=0;;gridx=0$$\n");
        sb.append("hs||70||||2;;gridy=0;;gridx=1$$\n");
        sb.append("hs||50||||2;;gridy=1;;gridx=2;;$$\n");
        sb.append("pc||Artéria cerebral média;;t;;f||subcont@2@||gridx=1;;gridy=0$$\n");

        sb.append("subpnl||||||->3$$\n");
        sb.append("pc||Média S/D (Umbilical)/(Cerebral);;f;;f||cdl@434@||3;;gridy=0;;gridx=0$$\n");
        sb.append("pc||IR (Umbilical)/(Cerebral);;t;;f||cdl@436@||3;;gridx=1$$\n");
        sb.append("pc||IP (Umbilical)/(Cerebral);;t;;f||cdl@438@||3;;gridx=2$$\n");
        sb.append("pc||f;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=0;;gridy=3$$\n");
        sb.append("pc||t;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=1$$\n");
        sb.append("pc||t;;t||lbl@( < 1,0 )@cor=0,0,255||3;;gridx=2$$\n");
        sb.append("hs||90||||3;;gridy=2;;gridx=0;;weightx=0$$\n");
        sb.append("hs||90||||3;;gridx=1;;$$\n");
        sb.append("hs||90||||3;;gridx=2;;$$\n");
        sb.append("pc||Média das relações das artérias uterinas;;f;;t||subcont@3@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("hs||0||||3;;gridx=3;;weightx=1;;gridwidth=1$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ducto Venoso">
        sb.append("439;;Ducto venoso - Feto 6;;330;;417;;Artérias umbilical e cerebral média - Feto 6$$\n");
        sb.append("pc||Diástole;;f;;f||cdl@441@||gridx=0;;gridy=0$$\n");
        sb.append("pc||IP;;t;;f||cdl@443@||gridx=1$$\n");
        sb.append("pc||t;;f||lbl@Normal: IP 2,3 (Fluxo anterogrado em fase de contração arterial)@cor=0,0,255||gridx=2$$\n");
        sb.append("pc||Veia umbilical;;f;;t||cdl@446@||gridx=0;;gridy=1;;gridwidth=2$$\n");
        sb.append("pc||t;;t||lbl@Normal: Fluxo contínuo@cor=0,0,255||gridx=2$$\n");
        sb.append("hs||200||||gridy=0;;gridx=0;;gridwidth=1$$\n");
        sb.append("hs||120||||gridy=0;;gridx=1$$\n");
        sb.append("hs||0||||gridx=7;;weightx=1;;gridwidth=1$$\n");
        sb.append("vs||0||||gridx=0;;gridy=4;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("447;;Observações gerais - Feto 6;;330;;439;;Ducto venoso - Feto 6$$\n");
        sb.append("cdl||449||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressão diagnóstica ">

        sb.append("450;;Impressão diagnóstica;;330;;87;;Observações gerais$$\n");
        sb.append("cdl||454||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||200||||$$\n");
        sb.append("cdl||452||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||230||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        //cid 10
        sb.append("\n450\n");

        // </editor-fold>

        alterarVisaoDeLaudo(8);

    }

    static void diversos () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Descrição">

        sb.append("0;;{desc}$$\n");
        sb.append("cdl||2||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("3;;{desc};;400;;0;;{desc}$$\n");
        sb.append("cdl||5||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("6;;Impressão diagnóstica;;400;;3;;{desc}$$\n");
        sb.append("cdl||8||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        sb.append("\n6\n");

        // </editor-fold>

        alterarVisaoDeLaudo(5);

    }

    static void textoLivre () throws Exception
    {

        sb.append("0;;Texto livre$$\n");
        sb.append("cdl||2||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        sb.append("\n2\n");

        alterarVisaoDeLaudo(27);

    }

    static void histeroscopia () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Dados técnicos">

        sb.append("0;;Dados técnicos$$\n");
        sb.append("cdl||4||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||330||||$$\n");
        sb.append("cdl||2||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Canal endocervical">

        sb.append("5;;Canal endocervical;;300;;0;;Dados técnicos$$\n");
        sb.append("cdl||9||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||330||||$$\n");
        sb.append("cdl||7||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Orifício interno do colo uterino">

        sb.append("10;;Orifício interno do colo uterino;;300;;5;;Canal endocervical$$\n");
        sb.append("cdl||14||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||330||||$$\n");
        sb.append("cdl||12||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Cavidade endometrial">

        sb.append("15;;Cavidade endometrial;;300;;10;;Orifício interno do colo uterino$$\n");
        sb.append("cdl||19||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||330||||$$\n");
        sb.append("cdl||17||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Óstios tubários">

        sb.append("20;;Óstios tubários;;300;;15;;Cavidade endometrial$$\n");
        sb.append("cdl||24||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||330||||$$\n");
        sb.append("cdl||22||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biópsia">

        sb.append("25;;Biópsia;;300;;20;;Óstios tubários$$\n");
        sb.append("cdl||29||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||330||||$$\n");
        sb.append("cdl||27||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Procedimento realizado">

        sb.append("30;;Procedimento realizado;;300;;25;;Biópsia$$\n");
        sb.append("cdl||32||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações">

        sb.append("33;;Observações;;300;;30;;Procedimento realizado$$\n");
        sb.append("cdl||35||||weightx=1;;weighty=1$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressão diagnóstica">

        sb.append("36;;Impressão diagnóstica;;300;;33;;Observações$$\n");
        sb.append("cdl||40||||gridx=0;;gridy=0;;top_insets=0;;left_insets=2$$\n");
        sb.append("hs||330||||$$\n");
        sb.append("cdl||38||||gridwidth=2;;gridy=1;;gridx=0;;top_insets=0;;left_insets=3$$\n");
        sb.append("vs||250||||gridwidth=1;;gridx=2;;gridy=1;;weightx=1$$\n");
        sb.append("hs||0||||gridx=0;;gridy=2;;weighty=1;;weightx=0$$\n");
        sb.append("\n##\n");

        // </editor-fold>

        sb.append("\n36\n");

        alterarVisaoDeLaudo(28);

    }

}
