package com.ic.projects.laudoecia.mdl;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.CampoSimples;
import static com.ic.projects.laudoecia.model.laudo.CampoSimples.identificador;
import static com.ic.projects.laudoecia.model.laudo.Composite.HTML_CAMPOS_FILHOS;
import com.ic.projects.laudoecia.model.laudo.Linha;
import com.ic.projects.laudoecia.model.laudo.LinhaDaTbl;
import static com.ic.projects.laudoecia.model.laudo.Topico.ID_DESCRICAO_TOPICO;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
public class M_Endoscopia_Laparoscopia_Abdomen extends Model
{

    public static void main (String[] args) throws Exception
    {
//        formatarStrMdl();
        abdomenInferiorMasculino();
        abdomenTotal();
        abdomenSuperior();
        endovaginalPelvica_AbdomenInferiorFeminino();
        endoscopia();
        videoFaringLaringoscopiaEndoscópico();
        videoEndoscopiaNasalOtica();
        videoNasofibrolaringoscopia();
        laparoscopiaDiagnosticaComOuSemBiopsia();
    }

    static void abdomenInferiorMasculino () throws Exception
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
        //presença
        sb.append("6;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        //posição
        sb.append("7;;Enumeracao;;").append(CampoSimples.identificador).append("$$\n");
        //morfologia
        sb.append("8;;Enumeracao;;, morfologia ").append(CampoSimples.identificador).append("$$\n");
        //superficie
        sb.append("9;;Enumeracao;;, parede ").append(CampoSimples.identificador).append("$$\n");
        //textura
        sb.append("10;;Enumeracao;; com textura acústica ").append(CampoSimples.identificador).append(", $$\n");
        //contornos
        sb.append("11;;Enumeracao;; contornos ").append(CampoSimples.identificador).append("$$\n");
        //limites
        sb.append("12;;Enumeracao;;, limites ").append(CampoSimples.identificador).append("$$\n");
        //espessura
        sb.append("13;;Enumeracao;; e espessura ").append(CampoSimples.identificador).append(".;;true$$\n");

        sb.append("\n14;;Linha$$\n");
        //conteudo
        sb.append("15;;Enumeracao;;Conteúdo ").append(CampoSimples.identificador).append(", $$\n");
        //debris
        sb.append("16;;Enumeracao;; com ").append(CampoSimples.identificador).append(" de debris no seu interior.$$\n");

        sb.append("\n17;;Linha$$\n");
        //assoalho
        sb.append("18;;Enumeracao;;Assoalho vesical em posição ").append(CampoSimples.identificador).append(".$$\n");

        sb.append("\n19;;Linha$$\n");
        //capacidade
        sb.append("20;;Enumeracao;;Capacidade vesical ").append(CampoSimples.identificador).append(".;;true$$\n");

        sb.append("\n21;;Linha$$\n");
        //residuo
        sb.append("22;;Enumeracao;;Resíduo pós-miccional ").append(CampoSimples.identificador).append(".;;true$$\n");

        sb.append("23;;Linha$$\n");
        sb.append("24;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Prostata">

        sb.append("\n25;;Topico;;Próstata$$\n");
        sb.append("\n26;;Linha$$\n");
        //presença
        sb.append("27;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");

        //posição
        sb.append("28;;Enumeracao;;").append(CampoSimples.identificador).append("$$\n");
        //morfologia
        sb.append("29;;Enumeracao;;, morfologia ").append(CampoSimples.identificador).append("$$\n");
        //superficie
        sb.append("30;;Enumeracao;; e superfície ").append(CampoSimples.identificador).append(".$$\n");

        //long
        sb.append("\n31;;Linha$$\n");
        sb.append("32;;CampoDouble;;Medidas: Long.: " + identificador + " cm.;;2$$\n");
        //anterior pos
        sb.append("33;;CampoDouble;; x Ant. Post.: " + identificador + " cm.;;2$$\n");
        //transversal
        sb.append("34;;CampoDouble;; x Trans.: " + identificador + " cm.;;2$$\n");
        //volume
        sb.append("\n35;;Linha$$\n");
        sb.append("36;;CampoRpn;;C1 C2 C3 @").append(StaticInfo.FATOR_PESO_PROST).append("@ * * *;;");
        sb.append("Peso: " + identificador + " g.;;3$$\n");

        sb.append("\n37;;Linha$$\n");
        //biopsia
        sb.append("38;;Enumeracao;;").append(CampoSimples.identificador).append("$$\n");

        sb.append("39;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL + ";;2$$\n");

        // <editor-fold defaultstate="collapsed" desc="Prostata Periferica">

        sb.append("\n40;;Linha$$\n");
        //textura
        sb.append("41;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        //contornos
        sb.append("42;;Enumeracao;;, contornos ").append(CampoSimples.identificador).append("$$\n");
        //limites
        sb.append("43;;Enumeracao;; e limites ").append(CampoSimples.identificador).append(".$$\n");

        sb.append("\n44;;Linha$$\n");
        sb.append("45;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Prostata Central">
        sb.append("\n46;;Linha$$\n");
        //textura
        sb.append("47;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        //contornos
        sb.append("48;;Enumeracao;;, contornos ").append(CampoSimples.identificador).append("$$\n");
        //limites
        sb.append("49;;Enumeracao;; e limites ").append(CampoSimples.identificador).append(".$$\n");

        sb.append("\n50;;Linha$$\n");
        sb.append("51;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Prostata Transição">
        sb.append("\n52;;Linha$$\n");
        //textura
        sb.append("53;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        //contornos
        sb.append("54;;Enumeracao;;, contornos ").append(CampoSimples.identificador).append("$$\n");
        //limites
        sb.append("55;;Enumeracao;; e limites ").append(CampoSimples.identificador).append(".$$\n");

        sb.append("\n56;;Linha$$\n");
        sb.append("57;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Prostata Estroma">

        sb.append("\n58;;Linha$$\n");
        //textura
        sb.append("59;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        //contornos
        sb.append("60;;Enumeracao;;, contornos ").append(CampoSimples.identificador).append("$$\n");
        //limites
        sb.append("61;;Enumeracao;; e limites ").append(CampoSimples.identificador).append(".$$\n");

        sb.append("\n62;;Linha$$\n");
        sb.append("63;;CampoTexto;;$$\n");

        // </editor-fold>

        // Descrição da prostata
        sb.append("\n64;;Linha$$\n");
        sb.append("65;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vesículas Seminais">

        sb.append("\n66;;Topico;;Vesículas seminais$$\n");
        sb.append("\n67;;Linha$$\n");
        //presença
        sb.append("68;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        //simetria
        sb.append("69;;Enumeracao;;").append(CampoSimples.identificador).append("$$\n");
        //morfologia
        sb.append("70;;Enumeracao;;").append(", morfologia ").append(CampoSimples.identificador).append("$$\n");
        //superficie
        sb.append("71;;Enumeracao;;").append(", superfície ").append(CampoSimples.identificador).append("$$\n");
        //textura
        sb.append("72;;Enumeracao;;").append(", textura acústica ").append(CampoSimples.identificador).append("$$\n");
        //limites
        sb.append("73;;Enumeracao;;").append(", limites ").append(CampoSimples.identificador).append("$$\n");
        //contornos
        sb.append("74;;Enumeracao;;").append(" e contornos ").append(CampoSimples.identificador).append(".$$\n");

        sb.append("\n75;;Linha$$\n");
        sb.append("76;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        //campo descrito  Observações gerais
        sb.append("\n77;;Topico;;Observações gerais$$\n");
        sb.append("\n78;;Linha$$\n");
        sb.append("79;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("\n80;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n81;;Linha$$\n");
        sb.append("82;;ImpressaoDiagnostica;;\n");
        sb.append("<p style=\"margin-top: 0\">Exame ecográfico compatível com "
                + "próstata, bexiga e vesículas seminais normais.</p>\n");
        sb.append("$$\n");
        sb.append("\n83;;Linha$$\n");
        sb.append("84;;Enumeracao;;$82CampoTexto$$\n");

        // </editor-fold>

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

        // <editor-fold defaultstate="collapsed" desc="Bexiga">

        //presenca
        sb.append("\n6;;adicionarOpcao;;presente;;$$\n");
        sb.append("6;;adicionarOpcao;;ausente;;Ausente.$$\n");
        sb.append("6;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");

        //posição
        sb.append("\n7;;adicionarOpcao;;Tópica$$\n");
        sb.append("7;;adicionarOpcao;;Atópica$$\n");
        sb.append("7;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{presente}$$\n");

        //morfologia
        sb.append("\n8;;adicionarOpcao;;normal$$\n");
        sb.append("8;;adicionarOpcao;;disforme$$\n");
        sb.append("8;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{presente}$$\n");

        //superficie
        sb.append("\n9;;adicionarOpcao;;lisa$$\n");
        sb.append("9;;adicionarOpcao;;rugosa$$\n");
        sb.append("9;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{presente}$$\n");

        //textura
        sb.append("\n10;;adicionarOpcao;;homogênea$$\n");
        sb.append("10;;adicionarOpcao;;heterogênea$$\n");
        sb.append("10;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{presente}$$\n");

        //contornos
        sb.append("\n11;;adicionarOpcao;;definidos$$\n");
        sb.append("11;;adicionarOpcao;;indefinidos$$\n");
        sb.append("11;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{presente}$$\n");

        //espessura
        sb.append("\n13;;adicionarOpcao;;normal$$\n");
        sb.append("13;;adicionarOpcao;;espessa$$\n");
        sb.append("13;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{presente}$$\n");

        //conteudo
        sb.append("\n15;;adicionarOpcao;;anecoico$$\n");
        sb.append("15;;adicionarOpcao;;hipoecoica$$\n");
        sb.append("15;;adicionarOpcao;;hiperecoica$$\n");
        sb.append("15;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{presente}$$\n");

        //debris
        sb.append("\n16;;adicionarOpcao;;ausente;;ausência$$\n");
        sb.append("16;;adicionarOpcao;;presente;;presença$$\n");
        sb.append("16;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{presente}$$\n");

        //assoalho
        sb.append("\n18;;adicionarOpcao;;normal$$\n");
        sb.append("18;;adicionarOpcao;;elevado$$\n");
        sb.append("18;;adicionarOpcao;;rebaixado$$\n");
        sb.append("18;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{presente}$$\n");

        //capacidade
        sb.append("\n20;;adicionarOpcao;;normal$$\n");
        sb.append("20;;adicionarOpcao;;diminuida$$\n");
        sb.append("20;;adicionarOpcao;;elevada$$\n");
        sb.append("20;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{presente}$$\n");

        //residuo
        sb.append("\n22;;adicionarOpcao;;ausente$$\n");
        sb.append("22;;adicionarOpcao;;desprezível (0 a 40ml)$$\n");
        sb.append("22;;adicionarOpcao;;moderado (40 a 100ml)$$\n");
        sb.append("22;;adicionarOpcao;;acentuado (> que 100ml)$$\n");
        sb.append("22;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{presente}$$\n");

        // Descrição
        sb.append("24;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{presente|").append(CampoSimples.DIGITAR).append("}$$\n");
        sb.append("24;;vincularObrigatorio;;$6CampoDoLaudo;;{").append(CampoSimples.DIGITAR).append("}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vesículas">

        // Presença
        sb.append("\n68;;adicionarOpcao;;presente;;$$\n");
        sb.append("68;;adicionarOpcao;;ausente;;Ausente.$$\n");
        sb.append("68;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");

        // Simetria
        sb.append("\n69;;adicionarOpcao;;Simétricas$$\n");
        sb.append("69;;adicionarOpcao;;Assimétricas$$\n");
        sb.append("69;;adicionarOpcao;;não-visualizadas$$\n");
        sb.append("69;;vincularHabAoValorDoCampo;;$68CampoDoLaudo;;false;;{presente}$$\n");

        // Morfologia
        sb.append("\n70;;adicionarOpcao;;normal$$\n");
        sb.append("70;;adicionarOpcao;;disforme$$\n");
        sb.append("70;;vincularHabAoValorDoCampo;;$68CampoDoLaudo;;false;;{presente}$$\n");

        // Superficie
        sb.append("\n71;;adicionarOpcao;;lisa$$\n");
        sb.append("71;;adicionarOpcao;;rugosa$$\n");
        sb.append("71;;vincularHabAoValorDoCampo;;$68CampoDoLaudo;;false;;{presente}$$\n");

        // Textura
        sb.append("\n72;;adicionarOpcao;;homogênea$$\n");
        sb.append("72;;adicionarOpcao;;heterogênea$$\n");
        sb.append("72;;vincularHabAoValorDoCampo;;$68CampoDoLaudo;;false;;{presente}$$\n");

        // Limites
        sb.append("\n73;;adicionarOpcao;;precisos$$\n");
        sb.append("73;;adicionarOpcao;;imprecisos$$\n");
        sb.append("73;;vincularHabAoValorDoCampo;;$68CampoDoLaudo;;false;;{presente}$$\n");

        // Contornos
        sb.append("\n74;;adicionarOpcao;;definidos$$\n");
        sb.append("74;;adicionarOpcao;;indefinidos$$\n");
        sb.append("74;;vincularHabAoValorDoCampo;;$68CampoDoLaudo;;false;;{presente}$$\n");

        // Descrição
        sb.append("76;;vincularHabAoValorDoCampo;;$68CampoDoLaudo;;false;;{presente|").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("76;;vincularObrigatorio;;$68CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        sb.append("\n45;;setObrigatorio;;false$$\n");
        sb.append("\n51;;setObrigatorio;;false$$\n");
        sb.append("\n57;;setObrigatorio;;false$$\n");
        sb.append("\n63;;setObrigatorio;;false$$\n");
        sb.append("\n79;;setObrigatorio;;false$$\n");

        sb.append("\n32;;setObrigatorio;;false$$\n");
        sb.append("\n33;;setObrigatorio;;false$$\n");
        sb.append("\n34;;setObrigatorio;;false$$\n");

        sb.append("\n32;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$33CampoDoLaudo|$34CampoDoLaudo}$$\n");
        sb.append("\n32;;setMsgErroValidCampoObrig;;Termine de informar as medidas da próstata.$$\n");
        sb.append("\n33;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$32CampoDoLaudo|$34CampoDoLaudo}$$\n");
        sb.append("\n33;;setMsgErroValidCampoObrig;;Termine de informar as medidas da próstata.$$\n");
        sb.append("\n34;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$32CampoDoLaudo|$33CampoDoLaudo}$$\n");
        sb.append("\n34;;setMsgErroValidCampoObrig;;Termine de informar as medidas da próstata.$$\n");

        //topicos da próstata
        sb.append("36;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");
        sb.append("40;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");
        sb.append("44;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");
        sb.append("46;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");
        sb.append("50;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");
        sb.append("52;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");
        sb.append("56;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");
        sb.append("58;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");
        sb.append("62;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");
        sb.append("64;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");

        // descrição da próstata
        sb.append("65;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{").append(CampoSimples.DIGITAR + "}$$\n");

        //biopsia e numero de fragmentos
        sb.append("38;;adicionarOpcao;;sim;;Realizada biópsia transretal utilizando agulha acoplada em pistola automática."
                  + "</p><p style=\"margin-top: 0\">Dirigida por ultrassonografia, sendo retirado @C1 fragmento(s) de próstata.$$\n");
        sb.append("38;;adicionarOpcao;;não$$\n");
        sb.append("38;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");

        sb.append("39;;vincularHabAoValorDoCampo;;$38CampoDoLaudo;;").append("false;;{").append("sim}$$\n");
        sb.append("38;;cadastrarParametro;;$39CampoDoLaudo$$\n");

        //cadastrar Formula
        sb.append("36;;cadastrarParametroFormula;;$32CampoNumero$$\n");
        sb.append("36;;cadastrarParametroFormula;;$33CampoNumero$$\n");
        sb.append("36;;cadastrarParametroFormula;;$34CampoNumero$$\n");
        sb.append("32;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");
        sb.append("33;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");
        sb.append("34;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");

        //morfologia prostata
        sb.append("\n29;;adicionarOpcao;;normal$$\n");
        sb.append("29;;adicionarOpcao;;disforme$$\n");
        sb.append("29;;adicionarOpcao;;globosa$$\n");
        sb.append("29;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");

        //posição prostata
        sb.append("\n28;;adicionarOpcao;;Tópica$$\n");
        sb.append("28;;adicionarOpcao;;Atópica$$\n");
        sb.append("28;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");

        //superficie prostata
        sb.append("\n30;;adicionarOpcao;;regular$$\n");
        sb.append("30;;adicionarOpcao;;irregular$$\n");
        sb.append("30;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");

        //textura prostata zona periferica
        sb.append("\n41;;adicionarOpcao;;homogênea$$\n");
        sb.append("41;;adicionarOpcao;;heterogênea$$\n");
        sb.append("41;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");
        //campo texto
        sb.append("45;;vincularHabAoValorDoCampo;;$41CampoDoLaudo;;false;;{homogênea|heterogênea}$$\n");

        //textura prostata Zona central
        sb.append("\n47;;adicionarOpcao;;homogênea$$\n");
        sb.append("47;;adicionarOpcao;;heterogênea$$\n");
        sb.append("47;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");
        //campo texto
        sb.append("51;;vincularHabAoValorDoCampo;;$47CampoDoLaudo;;false;;{homogênea|heterogênea}$$\n");
        //textura prostata zona transiçao
        sb.append("\n53;;adicionarOpcao;;homogênea$$\n");
        sb.append("53;;adicionarOpcao;;heterogênea$$\n");
        sb.append("53;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");
        //campo texto
        sb.append("57;;vincularHabAoValorDoCampo;;$53CampoDoLaudo;;false;;{homogênea|heterogênea}$$\n");

        //textura prostata zona estroma
        sb.append("\n59;;adicionarOpcao;;homogênea$$\n");
        sb.append("59;;adicionarOpcao;;heterogênea$$\n");
        sb.append("59;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");
        //campo texto
        sb.append("63;;vincularHabAoValorDoCampo;;$59CampoDoLaudo;;false;;{homogênea|heterogênea}$$\n");

        //presenca prostata
        sb.append("\n27;;adicionarOpcao;;presente;;$$\n");
        sb.append("27;;adicionarOpcao;;ausente;;Ausente.$$\n");
        sb.append("27;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");

        //contornos zona periferica
        sb.append("\n42;;adicionarOpcao;;definidos$$\n");
        sb.append("42;;adicionarOpcao;;indefinidos$$\n");
        sb.append("42;;vincularHabAoValorDoCampo;;$41CampoDoLaudo;;false;;{homogênea|heterogênea}$$\n");
        sb.append("42;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");

        //contornos Zona central
        sb.append("\n48;;adicionarOpcao;;definidos$$\n");
        sb.append("48;;adicionarOpcao;;indefinidos$$\n");
        sb.append("48;;vincularHabAoValorDoCampo;;$47CampoDoLaudo;;false;;{homogênea|heterogênea}$$\n");
        sb.append("48;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");

        //contornos zona transição
        sb.append("\n54;;adicionarOpcao;;definidos$$\n");
        sb.append("54;;adicionarOpcao;;indefinidos$$\n");
        sb.append("54;;vincularHabAoValorDoCampo;;$53CampoDoLaudo;;false;;{homogênea|heterogênea}$$\n");
        sb.append("54;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");

        //contornos zona estroma
        sb.append("\n60;;adicionarOpcao;;definidos$$\n");
        sb.append("60;;adicionarOpcao;;indefinidos$$\n");
        sb.append("60;;vincularHabAoValorDoCampo;;$59CampoDoLaudo;;false;;{homogênea|heterogênea}$$\n");
        sb.append("60;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");

        //limites
        sb.append("\n12;;adicionarOpcao;;precisos$$\n");
        sb.append("12;;adicionarOpcao;;imprecisos$$\n");
        sb.append("12;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{presente}$$\n");

        //limites zonas perifericas
        sb.append("\n43;;adicionarOpcao;;precisos$$\n");
        sb.append("43;;adicionarOpcao;;imprecisos$$\n");
        sb.append("43;;vincularHabAoValorDoCampo;;$41CampoDoLaudo;;false;;{homogênea|heterogênea}$$\n");
        sb.append("43;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");

        //limites zonas cetral
        sb.append("\n49;;adicionarOpcao;;precisos$$\n");
        sb.append("49;;adicionarOpcao;;imprecisos$$\n");
        sb.append("49;;vincularHabAoValorDoCampo;;$47CampoDoLaudo;;false;;{homogênea|heterogênea}$$\n");
        sb.append("49;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");

        //limites zonas transição
        sb.append("\n55;;adicionarOpcao;;precisos$$\n");
        sb.append("55;;adicionarOpcao;;imprecisos$$\n");
        sb.append("55;;vincularHabAoValorDoCampo;;$53CampoDoLaudo;;false;;{homogênea|heterogênea}$$\n");
        sb.append("55;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");

        //limites zonas estroma
        sb.append("\n61;;adicionarOpcao;;precisos$$\n");
        sb.append("61;;adicionarOpcao;;imprecisos$$\n");
        sb.append("61;;vincularHabAoValorDoCampo;;$59CampoDoLaudo;;false;;{homogênea|heterogênea}$$\n");
        sb.append("61;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");

        //descriçoes prostatas
        sb.append("\n45;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");
        sb.append("51;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");
        sb.append("57;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");
        sb.append("63;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{presente}$$\n");

        // <editor-fold defaultstate="collapsed" desc="Próstata">

        sb.append("\n40;;setDescrPrimParag;; -Zona periférica (lobo posterior) com textura acústica $$\n");
        sb.append("46;;setDescrPrimParag;; -Zona central com textura acústica $$\n");
        sb.append("52;;setDescrPrimParag;; -Zona de transição (lobo médio) com textura acústica $$\n");
        sb.append("58;;setDescrPrimParag;; -Estroma fibromuscular anterior com textura acústica $$\n");

        // </editor-fold>

        // </editor-fold>

        alterarModeloDeLaudo(2);
    }

    static void abdomenTotal () throws Exception
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

        // <editor-fold defaultstate="collapsed" desc="Figado">

        //campo descrito Figado
        sb.append("\n4;;Topico;;Fígado$$\n");
        sb.append("\n5;;Linha$$\n");
        sb.append("6;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Apresenta-se com topografia, forma,"
                + " dimensões, contornos e superfície normais.</p>\n");
        sb.append("<p style=\"margin-top: 0\">A ecogenicidade do parênquima hepático está preservada.</p>\n");
        sb.append("<p style=\"margin-top: 0\">O sistema porta e veias supra-hepáticas estão com trajeto e calibre normais.</p>\n");
        sb.append("$$\n");
        sb.append("\n7;;Linha$$\n");
        sb.append("8;;Enumeracao;;$6$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vias biliares">

        //campo descrito Vias biliares
        sb.append("\n9;;Topico;;Vias biliares$$\n");
        sb.append("\n10;;Linha$$\n");
        sb.append("11;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">As vias biliares intra e extra-"
                + "hepáticas foram identificadas com o calibre e aspectos normais.</p>\n");
        sb.append("$$\n");
        sb.append("\n12;;Linha$$\n");
        sb.append("13;;Enumeracao;;$11$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vesícula biliar">

        //campo descrito Vesícula biliar
        sb.append("\n14;;Topico;;Vesícula biliar$$\n");
        sb.append("\n15;;Linha$$\n");
        sb.append("16;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">A vesícula biliar tem forma, volume, contornos, paredes e conteúdo normais.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Não há sinais de presença de cálculos.</p>\n");
        sb.append("$$\n");
        sb.append("\n17;;Linha$$\n");
        sb.append("18;;Enumeracao;;$16$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pâncreas">

        //campo descrito Pâncreas
        sb.append("\n19;;Topico;;Pâncreas$$\n");
        sb.append("\n20;;Linha$$\n");
        sb.append("21;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Com topografia, forma, "
                + "dimensões e parênquima normais.</p>\n");
        sb.append("$$\n");
        sb.append("\n22;;Linha$$\n");
        sb.append("23;;Enumeracao;;$21$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Baço">

        //campo descrito Baço
        sb.append("\n24;;Topico;;Baço$$\n");
        sb.append("\n25;;Linha$$\n");
        sb.append("26;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">De tamanho normal, apresentando "
                + "parênquima acusticamente homogêneo.</p>\n");
        sb.append("$$\n");
        sb.append("\n27;;Linha$$\n");
        sb.append("28;;Enumeracao;;$26$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vasos">

        //campo descrito Vasos
        sb.append("\n29;;Topico;;Vasos$$\n");
        sb.append("\n30;;Linha$$\n");
        sb.append("31;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Veia cava inferior e aorta "
                + "abdominal apresentam trajeto, calibre e pulsatilidade normais.</p>\n");
        sb.append("$$\n");
        sb.append("\n32;;Linha$$\n");
        sb.append("33;;Enumeracao;;$31$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Retroperitônio">

        //campo descrito Retroperitônio
        sb.append("\n34;;Topico;;Retroperitônio$$\n");
        sb.append("\n35;;Linha$$\n");
        sb.append("36;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Sem alterações ecográficas visíveis.</p>\n");
        sb.append("$$\n");
        sb.append("\n37;;Linha$$\n");
        sb.append("38;;Enumeracao;;$36$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Seios costo frênicos">

        //campo descrito Seios costo frênicos
        sb.append("\n39;;Topico;;Seios costo-frênicos$$\n");
        sb.append("\n40;;Linha$$\n");
        sb.append("41;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Seios costo-frênicos livres.</p>\n");
        sb.append("$$\n");
        sb.append("\n42;;Linha$$\n");
        sb.append("43;;Enumeracao;;$41$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Rim direito">

        sb.append("\n44;;Topico;;Rim direito$$\n");
        //descrição
        sb.append("\n45;;Linha$$\n");
        sb.append("46;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Tópico, com contornos regulares e "
                  + "volume normal.</p><p style=\"margin-top: 0\">"
                + "Cortical preservada e sistema pielo calicinal "
                  + "com distribuição normal e textura acústica habitual.</p>");
        sb.append("$$\n");
        sb.append("47;;Enumeracao;;$46$$\n");
        //long
        sb.append("\n48;;Linha$$\n");
        sb.append("49;;CampoDouble;;Medidas: Long.: " + identificador + " cm;;2$$\n");
        //anterior pos
        sb.append("50;;CampoDouble;; x Ant. Post.: " + identificador + " cm;;2$$\n");
        //transversal
        sb.append("51;;CampoDouble;; x Trans.: " + identificador + " cm.;;2$$\n");
        //volume
        sb.append("\n52;;Linha$$\n");
        sb.append("53;;CampoRpn;;C1 C2 C3 @").append(StaticInfo.FATOR_VOL_DIVERSOS).append("@ * * *;;");
        sb.append("Volume: " + identificador + " cm³.;;");
        sb.append("3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Rim esquerdo">

        sb.append("54;;Topico;;Rim esquerdo$$\n");
        //descrição
        sb.append("\n55;;Linha$$\n");
        sb.append("56;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Tópico, com contornos regulares e "
                  + "volume normal.</p><p style=\"margin-top: 0\">"
                + "Cortical preservada e sistema pielo calicinal "
                  + "com distribuição normal e textura acústica habitual.</p>");
        sb.append("$$\n");
        sb.append("57;;Enumeracao;;$56$$\n");
        //long
        sb.append("\n58;;Linha$$\n");
        sb.append("59;;CampoDouble;;Medidas: Long.: " + identificador + " cm;;2$$\n");
        //anterior pos
        sb.append("60;;CampoDouble;; x Ant. Post.: " + identificador + " cm;;2$$\n");
        //transversal
        sb.append("61;;CampoDouble;; x Trans.: " + identificador + " cm.;;2$$\n");
        //volume
        sb.append("\n62;;Linha$$\n");
        sb.append("63;;CampoRpn;;C1 C2 C3 @").append(StaticInfo.FATOR_VOL_DIVERSOS).append("@ * * *;;");
        sb.append("Volume: " + identificador + " cm³.;;");
        sb.append("3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Bexiga">

        //campo descrito Bexiga
        sb.append("\n64;;Topico;;Bexiga$$\n");
        sb.append("\n65;;Linha$$\n");
        sb.append("66;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Sem alterações ecográficas visíveis.</p>\n");
        sb.append("$$\n");
        sb.append("\n67;;Linha$$\n");
        sb.append("68;;Enumeracao;;$66$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Demais órgãos pélvicos">

        //campo descrito Demais órgãos pélvicos
        sb.append("\n69;;Topico;;Demais órgãos pélvicos$$\n");
        sb.append("\n70;;Linha$$\n");
        sb.append("71;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n72;;Linha$$\n");
        sb.append("73;;Enumeracao;;$71$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        //campo descrito  Observações gerais
        sb.append("\n74;;Topico;;Observações gerais$$\n");
        sb.append("\n75;;Linha$$\n");
        sb.append("76;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("\n77;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n78;;Linha$$\n");
        sb.append("79;;ImpressaoDiagnostica;;\n");
        sb.append("<p style=\"margin-top: 0\">Abdome total acusticamente dentro"
                + " dos padrões de normalidade.</p>\n");
        sb.append("$$\n");
        sb.append("\n80;;Linha$$\n");
        sb.append("81;;Enumeracao;;$79CampoTexto$$\n");

        //btn avança para o próximo tópico
        sb.append("82;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL + ";;3$$\n");

        // </editor-fold>

        sb.append("##");

        // <editor-fold defaultstate="collapsed" desc="Metodos">

        sb.append("49;;setObrigatorio;;false$$\n");
        sb.append("50;;setObrigatorio;;false$$\n");
        sb.append("51;;setObrigatorio;;false$$\n");
        sb.append("59;;setObrigatorio;;false$$\n");
        sb.append("60;;setObrigatorio;;false$$\n");
        sb.append("61;;setObrigatorio;;false$$\n");
        sb.append("73;;setObrigatorio;;false$$\n");
        sb.append("76;;setObrigatorio;;false$$\n");
        sb.append("82;;setObrigatorio;;false$$\n");

        sb.append("\n2;;adicionarOpcao;;convexo$$\n");
        sb.append("2;;adicionarOpcao;;linear$$\n");
        sb.append("2;;adicionarOpcao;;endocavitário$$\n");
        sb.append("2;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("2;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("3;;vincularHabAoValorDoCampo;;$2CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");

        sb.append("\n45;;setTipoValidObrig;;").append(CampoDoLaudo.POR_HTML).append("$$\n");
        sb.append("\n45;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$49CampoDoLaudo|$50CampoDoLaudo|$51CampoDoLaudo}$$\n");
        sb.append("\n45;;setMsgErroValidCampoObrig;;Foi colocada alguma medida para o rim e nenhum texto para este.$$\n");
        sb.append("53;;cadastrarParametroFormula;;$49CampoNumero$$\n");
        sb.append("53;;cadastrarParametroFormula;;$50CampoNumero$$\n");
        sb.append("53;;cadastrarParametroFormula;;$51CampoNumero$$\n");

        sb.append("\n55;;setTipoValidObrig;;").append(CampoDoLaudo.POR_HTML).append("$$\n");
        sb.append("\n55;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$59CampoDoLaudo|$60CampoDoLaudo|$61CampoDoLaudo}$$\n");
        sb.append("\n55;;setMsgErroValidCampoObrig;;Foi colocada alguma medida para o rim e nenhum texto para este.$$\n");
        sb.append("63;;cadastrarParametroFormula;;$59CampoNumero$$\n");
        sb.append("63;;cadastrarParametroFormula;;$60CampoNumero$$\n");
        sb.append("63;;cadastrarParametroFormula;;$61CampoNumero$$\n");

        sb.append("\n49;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$50CampoDoLaudo|$51CampoDoLaudo}$$\n");
        sb.append("\n49;;setMsgErroValidCampoObrig;;Termine de informar as medidas do rim direito.$$\n");
        sb.append("\n50;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$49CampoDoLaudo|$51CampoDoLaudo}$$\n");
        sb.append("\n50;;setMsgErroValidCampoObrig;;Termine de informar as medidas do rim direito.$$\n");
        sb.append("\n51;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$49CampoDoLaudo|$50CampoDoLaudo}$$\n");
        sb.append("\n51;;setMsgErroValidCampoObrig;;Termine de informar as medidas do rim direito.$$\n");

        sb.append("\n59;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$60CampoDoLaudo|$61CampoDoLaudo}$$\n");
        sb.append("\n59;;setMsgErroValidCampoObrig;;Termine de informar as medidas do rim esquerdo.$$\n");
        sb.append("\n60;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$59CampoDoLaudo|$61CampoDoLaudo}$$\n");
        sb.append("\n60;;setMsgErroValidCampoObrig;;Termine de informar as medidas do rim esquerdo.$$\n");
        sb.append("\n61;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$59CampoDoLaudo|$60CampoDoLaudo}$$\n");
        sb.append("\n61;;setMsgErroValidCampoObrig;;Termine de informar as medidas do rim esquerdo.$$\n");

        // </editor-fold>

        alterarModeloDeLaudo(3);
    }

    static void abdomenSuperior () throws Exception
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

        // <editor-fold defaultstate="collapsed" desc="Figado">

        //campo descrito Figado
        sb.append("\n4;;Topico;;Fígado$$\n");
        sb.append("\n5;;Linha$$\n");
        sb.append("6;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Apresenta-se com topografia, "
                + "forma, dimensões, contornos e superfície normais.\n");
        sb.append("</p><p style=\"margin-top: 0\">A ecogenicidade do parênquima hepático está preservada.\n");
        sb.append("</p><p style=\"margin-top: 0\">O sistema porta e veias supra-hepáticas estão com trajeto e calibre normais.</p>\n");
        sb.append("$$\n");
        sb.append("\n7;;Linha$$\n");
        sb.append("8;;Enumeracao;;$6$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vias biliares">

        //campo descrito Vias biliares
        sb.append("\n9;;Topico;;Vias biliares$$\n");
        sb.append("\n10;;Linha$$\n");
        sb.append("11;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">As vias biliares intra e extra-"
                + "hepáticas foram identificadas com o calibre e aspectos normais.</p>\n");
        sb.append("$$\n");
        sb.append("\n12;;Linha$$\n");
        sb.append("13;;Enumeracao;;$11$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vesícula biliar">

        //campo descrito Vesícula biliar
        sb.append("\n14;;Topico;;Vesícula biliar$$\n");
        sb.append("\n15;;Linha$$\n");
        sb.append("16;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">A vesícula biliar tem forma, volume, contornos, paredes e conteúdo normais.\n");
        sb.append("</p><p style=\"margin-top: 0\">Não há sinais de presença de cálculos.</p>\n");
        sb.append("$$\n");
        sb.append("\n17;;Linha$$\n");
        sb.append("18;;Enumeracao;;$16$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pâncreas">

        //campo descrito Pâncreas
        sb.append("\n19;;Topico;;Pâncreas$$\n");
        sb.append("\n20;;Linha$$\n");
        sb.append("21;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Com topografia, forma, dimensões "
                + "e parênquima normais.</p>\n");
        sb.append("$$\n");
        sb.append("\n22;;Linha$$\n");
        sb.append("23;;Enumeracao;;$21$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Rim direito">

        sb.append("\n24;;Topico;;Rim direito$$\n");
        //descrição
        sb.append("\n25;;Linha$$\n");
        sb.append("26;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Tópico, com contornos regulares e "
                  + "volume normal.</p><p style=\"margin-top: 0\">Cortical preservada e sistema pielo calicinal "
                  + "com distribuição normal e textura acústica habitual.</p>$$\n");
        sb.append("27;;Enumeracao;;$26$$\n");
        //long
        sb.append("\n28;;Linha$$\n");
        sb.append("29;;CampoDouble;;Medidas: Long.: " + identificador + " cm;;2$$\n");
        //anterior pos
        sb.append("30;;CampoDouble;; x Ant. Post.: " + identificador + " cm;;2$$\n");
        //transversal
        sb.append("31;;CampoDouble;; x Trans.: " + identificador + " cm.;;2$$\n");
        //volume
        sb.append("\n32;;Linha$$\n");
        sb.append("33;;CampoRpn;;C1 C2 C3 @").append(StaticInfo.FATOR_VOL_DIVERSOS).append("@ * * *;;");
        sb.append("Volume: " + identificador + " cm³.;;");
        sb.append("3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Rim esquerdo">

        sb.append("34;;Topico;;Rim esquerdo$$\n");
        //descrição
        sb.append("\n35;;Linha$$\n");
        sb.append("36;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Tópico, com contornos regulares e "
                  + "volume normal.</p><p style=\"margin-top: 0\">"
                + "Cortical preservada e sistema pielo calicinal "
                  + "com distribuição normal e textura acústica habitual.</p>$$\n");
        sb.append("37;;Enumeracao;;$36$$\n");
        //long
        sb.append("\n38;;Linha$$\n");
        sb.append("39;;CampoDouble;;Medidas: Long.: " + identificador + " cm;;2$$\n");
        //anterior pos
        sb.append("40;;CampoDouble;; x Ant. Post.: " + identificador + " cm;;2$$\n");
        //transversal
        sb.append("41;;CampoDouble;; x Trans.: " + identificador + " cm.;;2$$\n");
        //volume
        sb.append("\n42;;Linha$$\n");
        sb.append("43;;CampoRpn;;C1 C2 C3 @").append(StaticInfo.FATOR_VOL_DIVERSOS).append("@ * * *;;");
        sb.append("Volume: " + identificador + " cm³.;;");
        sb.append("3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Baço">

        //campo descrito Baço
        sb.append("\n44;;Topico;;Baço$$\n");
        sb.append("\n45;;Linha$$\n");
        sb.append("46;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">De tamanho normal, apresentando "
                + "parênquima acusticamente homogêneo.</p>\n");
        sb.append("$$\n");
        sb.append("\n47;;Linha$$\n");
        sb.append("48;;Enumeracao;;$46$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vasos">

        //campo descrito Vasos
        sb.append("\n49;;Topico;;Vasos$$\n");
        sb.append("\n50;;Linha$$\n");
        sb.append("51;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Veia cava inferior e aorta "
                + "abdominal apresentam trajeto, calibre e pulsatilidade normais.</p>\n");
        sb.append("$$\n");
        sb.append("\n52;;Linha$$\n");
        sb.append("53;;Enumeracao;;$51$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Retroperitônio">

        //campo descrito Retroperitônio
        sb.append("\n54;;Topico;;Retroperitônio$$\n");
        sb.append("\n55;;Linha$$\n");
        sb.append("56;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Sem alterações ecográficas visíveis.</p>\n");
        sb.append("$$\n");
        sb.append("\n57;;Linha$$\n");
        sb.append("58;;Enumeracao;;$56$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Seios costo frênicos">

        //campo descrito Seios costo frênicos
        sb.append("\n59;;Topico;;Seios costo-frênicos$$\n");
        sb.append("\n60;;Linha$$\n");
        sb.append("61;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Seios costo-frênicos livres.</p>\n");
        sb.append("$$\n");
        sb.append("\n62;;Linha$$\n");
        sb.append("63;;Enumeracao;;$61$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        //campo descrito  Observações gerais
        sb.append("\n64;;Topico;;Observações gerais$$\n");
        sb.append("\n65;;Linha$$\n");
        sb.append("66;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("\n67;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n68;;Linha$$\n");
        sb.append("69;;ImpressaoDiagnostica;;\n");
        sb.append("<p style=\"margin-top: 0\">Abdome superior acusticamente "
                + "dentro dos padrões de normalidade.</p>$$\n");
        sb.append("\n70;;Linha$$\n");
        sb.append("71;;Enumeracao;;$69CampoTexto$$\n");

        // </editor-fold>

        //btn avança para o próximo tópico
        sb.append("72;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL + ";;3$$\n");
        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Metodos">

        sb.append("\n72;;setObrigatorio;;false$$\n");
        sb.append("66;;setObrigatorio;;false$$\n");

        sb.append("29;;setObrigatorio;;false$$\n");
        sb.append("30;;setObrigatorio;;false$$\n");
        sb.append("31;;setObrigatorio;;false$$\n");

        sb.append("39;;setObrigatorio;;false$$\n");
        sb.append("40;;setObrigatorio;;false$$\n");
        sb.append("41;;setObrigatorio;;false$$\n");

        sb.append("\n2;;adicionarOpcao;;convexo$$\n");
        sb.append("2;;adicionarOpcao;;linear$$\n");
        sb.append("2;;adicionarOpcao;;endocavitário$$\n");
        sb.append("2;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("2;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("3;;vincularHabAoValorDoCampo;;$2CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");

        sb.append("\n25;;setTipoValidObrig;;").append(CampoDoLaudo.POR_HTML).append("$$\n");
        sb.append("\n25;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$30CampoDoLaudo|$31CampoDoLaudo|$29CampoDoLaudo}$$\n");
        sb.append("\n25;;setMsgErroValidCampoObrig;;Foi colocada alguma medida para o rim e nenhum texto para este.$$\n");
        sb.append("33;;cadastrarParametroFormula;;$29CampoNumero$$\n");
        sb.append("33;;cadastrarParametroFormula;;$30CampoNumero$$\n");
        sb.append("33;;cadastrarParametroFormula;;$31CampoNumero$$\n");

        sb.append("\n35;;setTipoValidObrig;;").append(CampoDoLaudo.POR_HTML).append("$$\n");
        sb.append("\n35;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$39CampoDoLaudo|$40CampoDoLaudo|$41CampoDoLaudo}$$\n");
        sb.append("\n35;;setMsgErroValidCampoObrig;;Foi colocada alguma medida para o rim e nenhum texto para este.$$\n");
        sb.append("43;;cadastrarParametroFormula;;$39CampoNumero$$\n");
        sb.append("43;;cadastrarParametroFormula;;$40CampoNumero$$\n");
        sb.append("43;;cadastrarParametroFormula;;$41CampoNumero$$\n");

        sb.append("\n29;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$30CampoDoLaudo|$31CampoDoLaudo}$$\n");
        sb.append("\n29;;setMsgErroValidCampoObrig;;Termine de informar as medidas do rim direito.$$\n");
        sb.append("\n30;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$29CampoDoLaudo|$31CampoDoLaudo}$$\n");
        sb.append("\n30;;setMsgErroValidCampoObrig;;Termine de informar as medidas do rim direito.$$\n");
        sb.append("\n31;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$29CampoDoLaudo|$30CampoDoLaudo}$$\n");
        sb.append("\n31;;setMsgErroValidCampoObrig;;Termine de informar as medidas do rim direito.$$\n");

        sb.append("\n39;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$40CampoDoLaudo|$41CampoDoLaudo}$$\n");
        sb.append("\n39;;setMsgErroValidCampoObrig;;Termine de informar as medidas do rim esquerdo.$$\n");
        sb.append("\n40;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$39CampoDoLaudo|$41CampoDoLaudo}$$\n");
        sb.append("\n40;;setMsgErroValidCampoObrig;;Termine de informar as medidas do rim esquerdo.$$\n");
        sb.append("\n41;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$39CampoDoLaudo|$40CampoDoLaudo}$$\n");
        sb.append("\n41;;setMsgErroValidCampoObrig;;Termine de informar as medidas do rim esquerdo.$$\n");

        // </editor-fold>

        alterarModeloDeLaudo(13);
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

        // textura miometrio
        sb.append("\n26;;Linha$$\n");
        sb.append("27;;Enumeracao;;").append("Miométrio de textura acústica ").append(CampoSimples.identificador).append(".$$\n");
        // Canal endocervical
        sb.append("\n28;;Linha$$\n");
        sb.append("29;;Enumeracao;;").append("Canal endocervical ").append(CampoSimples.identificador).append(".;;true$$\n");

        // Descrição
        sb.append("\n30;;Linha$$\n");
        sb.append("31;;CampoTexto;;$$\n");

        // Endométrio
        sb.append("\n32;;Linha$$\n");
        //presença
        sb.append("33;;Enumeracao;;").append("Eco endometrial ").append(CampoSimples.identificador).append(";;true$$\n");
        //limites
        sb.append("34;;Enumeracao;;").append(", ").append(CampoSimples.identificador).append("$$\n");
        //contornos
        sb.append("35;;Enumeracao;;").append(", ").append(CampoSimples.identificador).append("$$\n");
        //aspecto
        sb.append("36;;Enumeracao;;").append(", ").append(CampoSimples.identificador).append(".$$\n");
        //espessura
        sb.append("\n37;;Linha$$\n");
        sb.append("38;;CampoDouble;;").append("Espessura do eco endometrial: ").append(CampoSimples.identificador).append(" mm.;;2$$\n");

        // Descrição
        sb.append("\n39;;Linha$$\n");
        sb.append("40;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovários">

        sb.append("\n41;;Topico;;Anexos$$\n");
        sb.append("\n42;;Linha$$\n");
        //posição ovário direito
        sb.append("43;;Enumeracao;;").append("Ovário direito ").append(CampoSimples.identificador).append(";;true$$\n");
        //contorno ovário direito
        sb.append("44;;Enumeracao;;").append(", de contornos ").append(CampoSimples.identificador).append("$$\n");
        //limites ovário direito
        sb.append("45;;Enumeracao;;").append(" e limites ").append(CampoSimples.identificador).append(".$$\n");

        sb.append("\n46;;Linha$$\n");
        // parênquima de textura  ovário direito
        sb.append("47;;Enumeracao;;").append("Exibindo parênquima de textura ").append(CampoSimples.identificador).append("$$\n");
        //superfície de textura  ovário direito
        sb.append("48;;Enumeracao;;").append(" e ").append(CampoSimples.identificador).append(".;;true$$\n");

        //long
        sb.append("\n49;;Linha$$\n");
        sb.append("50;;CampoDouble;;Medindo: " + identificador + ";;2$$\n");
        //anterior pos
        sb.append("51;;CampoDouble;; x " + identificador + ";;2$$\n");
        //transversal
        sb.append("52;;CampoDouble;; x " + identificador + " cm;;2$$\n");
        //massa
        sb.append("53;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        //volume
        sb.append("54;;CampoRpn;;C1 C2 C3 @").append(StaticInfo.FATOR_VOL_DIVERSOS).append("@ * * *;;");
        sb.append(", com volume de: " + identificador + " cm³.;;");
        sb.append("3$$\n");

        // Desscrição ovario direito
        sb.append("\n55;;Linha$$\n");
        sb.append("56;;CampoTexto;;\n");
        sb.append("$$\n");

        sb.append("\n57;;Linha$$\n");
        //posição ovário esquerdo
        sb.append("58;;Enumeracao;;").append("Ovário esquerdo ").append(CampoSimples.identificador).append(";;true$$\n");
        //contorno ovário esquerdo
        sb.append("59;;Enumeracao;;").append(", de contornos ").append(CampoSimples.identificador).append("$$\n");
        //limites ovário esquerdo
        sb.append("60;;Enumeracao;;").append(" e limites ").append(CampoSimples.identificador).append(".$$\n");

        sb.append("\n61;;Linha$$\n");
        // parênquima de textura  ovário esquerdo
        sb.append("62;;Enumeracao;;").append("Exibindo parênquima de textura ").append(CampoSimples.identificador).append("$$\n");
        //superfície de textura  ovário esquerdo
        sb.append("63;;Enumeracao;;").append(" e ").append(CampoSimples.identificador).append(".;;true$$\n");

        //long
        sb.append("\n64;;Linha$$\n");
        sb.append("65;;CampoDouble;;Medindo: " + identificador + ";;2$$\n");
        //anterior pos
        sb.append("66;;CampoDouble;; x " + identificador + ";;2$$\n");
        //transversal
        sb.append("67;;CampoDouble;; x " + identificador + " cm;;2$$\n");
        //massa
        sb.append("68;;Enumeracao;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        //volume
        sb.append("69;;CampoRpn;;C1 C2 C3 @").append(StaticInfo.FATOR_VOL_DIVERSOS ).append("@ * * *;;");

        sb.append(", com volume de: " + identificador + " cm³.;;");
        sb.append("3$$\n");

        // Descrição ovário esquerdo
        sb.append("\n70;;Linha$$\n");
        sb.append("71;;CampoTexto;;\n");
        sb.append("$$\n");

        // Observações gerais dos ovários
        sb.append("\n72;;Linha$$\n");
        sb.append("73;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fundo de saco Douglas">

        sb.append("\n74;;Topico;;F.S.D$$\n");
        sb.append("\n75;;Linha$$\n");
        sb.append("76;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");

        //campo descrito  F.S.D
        sb.append("\n77;;Linha$$\n");
        sb.append("78;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        //faixa etária
        sb.append("\n79;;Enumeracao;;").append(CampoSimples.identificador).append("$$\n");

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        //campo descrito  Observações gerais
        sb.append("\n80;;Topico;;Observações gerais$$\n");
        sb.append("\n81;;Linha$$\n");
        sb.append("82;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("\n83;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n84;;Linha$$\n");
        sb.append("85;;ImpressaoDiagnostica;;\n");
        sb.append("<p style=\"margin-top: 0\">Aspecto ecográfico pélvico normal.</p>\n");
        sb.append("$$\n");
        sb.append("\n86;;Linha$$\n");
        sb.append("87;;Enumeracao;;$85CampoTexto$$\n");

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

        sb.append("31;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada|histerectomia|histerectomia subtotal|").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("31;;vincularObrigatorio;;$16CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Endométrio">

        // Presença
        sb.append("32;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{").
                append("anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada|"
                + CampoSimples.DIGITAR + "}$$\n");

        sb.append("\n33;;adicionarOpcao;;presente$$\n");
        sb.append("33;;adicionarOpcao;;ausente;;ausente.$$\n");
        sb.append("33;;adicionarOpcao;;não visualizado;;não visualizado.$$\n");
        sb.append("33;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("33;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        // Limites
        sb.append("\n34;;adicionarOpcao;;bem delimitado$$\n");
        sb.append("34;;adicionarOpcao;;mal delimitado$$\n");
        sb.append("34;;vincularHabAoValorDoCampo;;$33CampoDoLaudo;;false;;{presente}$$\n");

        // Contornos
        sb.append("\n35;;adicionarOpcao;;regular$$\n");
        sb.append("35;;adicionarOpcao;;irregular$$\n");
        sb.append("35;;adicionarOpcao;;mal visualizado$$\n");
        sb.append("35;;vincularHabAoValorDoCampo;;$33CampoDoLaudo;;false;;{presente}$$\n");

        // Aspecto
        sb.append("\n36;;adicionarOpcao;;linear e fino$$\n");
        sb.append("36;;adicionarOpcao;;trilaminar$$\n");
        sb.append("36;;adicionarOpcao;;ecogênico$$\n");
        sb.append("36;;adicionarOpcao;;isoecogênico$$\n");
        sb.append("36;;vincularHabAoValorDoCampo;;$33CampoDoLaudo;;false;;{presente}$$\n");

        // Espessura
        sb.append("38;;vincularHabAoValorDoCampo;;$33CampoDoLaudo;;false;;{presente}$$\n");

        // Descrição
        sb.append("40;;vincularHabAoValorDoCampo;;$33CampoDoLaudo;;false;;{presente|ausente|não visualizado|").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("40;;vincularObrigatorio;;$33CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovário direito">

        // Posição
        sb.append("\n43;;adicionarOpcao;;para-uterino$$\n");
        sb.append("43;;adicionarOpcao;;posterior$$\n");
        sb.append("43;;adicionarOpcao;;inferior$$\n");
        sb.append("43;;adicionarOpcao;;anterior$$\n");
        sb.append("43;;adicionarOpcao;;pélvico$$\n");
        sb.append("43;;adicionarOpcao;;não visualizado;;não visualizado.$$\n");
        sb.append("43;;adicionarOpcao;;justa-uterino$$\n");
        sb.append("43;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("43;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        // Contornos
        sb.append("\n44;;adicionarOpcao;;regulares$$\n");
        sb.append("44;;adicionarOpcao;;irregulares$$\n");
        sb.append("44;;vincularHabAoValorDoCampo;;$43CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Limites
        sb.append("\n45;;adicionarOpcao;;precisos$$\n");
        sb.append("45;;adicionarOpcao;;imprecisos$$\n");
        sb.append("45;;vincularHabAoValorDoCampo;;$43CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Parenquima
        sb.append("\n47;;adicionarOpcao;;mista$$\n");
        sb.append("47;;adicionarOpcao;;sólida$$\n");
        sb.append("47;;adicionarOpcao;;cística$$\n");
        sb.append("47;;adicionarOpcao;;sólido cística$$\n");
        sb.append("47;;adicionarOpcao;;múltiplos folículos subcorticais $$\n");
        sb.append("47;;vincularHabAoValorDoCampo;;$43CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Superficie
        sb.append("\n48;;adicionarOpcao;;ecogenicidade normal$$\n");
        sb.append("48;;adicionarOpcao;;ecogenicidade aumentada$$\n");
        sb.append("48;;vincularHabAoValorDoCampo;;$43CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Medidas
        sb.append("\n50;;setObrigatorio;;false$$\n");
        sb.append("\n51;;setObrigatorio;;false$$\n");
        sb.append("\n52;;setObrigatorio;;false$$\n");

        sb.append("\n50;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$51CampoDoLaudo|$52CampoDoLaudo}$$\n");
        sb.append("\n50;;setMsgErroValidCampoObrig;;Termine de informar as medidas do ovário direito.$$\n");
        sb.append("\n51;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$50CampoDoLaudo|$52CampoDoLaudo}$$\n");
        sb.append("\n51;;setMsgErroValidCampoObrig;;Termine de informar as medidas do ovário direito.$$\n");
        sb.append("\n52;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$50CampoDoLaudo|$51CampoDoLaudo}$$\n");
        sb.append("\n52;;setMsgErroValidCampoObrig;;Termine de informar as medidas do ovário direito.$$\n");

        //

        sb.append("54;;cadastrarParametroFormula;;$50CampoNumero$$\n");
        sb.append("54;;cadastrarParametroFormula;;$51CampoNumero$$\n");
        sb.append("54;;cadastrarParametroFormula;;$52CampoNumero$$\n");
        sb.append("50;;vincularHabAoValorDoCampo;;$43CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");
        sb.append("51;;vincularHabAoValorDoCampo;;$43CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");
        sb.append("52;;vincularHabAoValorDoCampo;;$43CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");
        sb.append("54;;vincularHabAoValorDoCampo;;$43CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Descrição
        sb.append("56;;vincularHabAoValorDoCampo;;$43CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino|").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("56;;vincularObrigatorio;;$43CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovário esquerdo">

        // Posição
        sb.append("\n58;;adicionarOpcao;;para-uterino$$\n");
        sb.append("58;;adicionarOpcao;;posterior$$\n");
        sb.append("58;;adicionarOpcao;;inferior$$\n");
        sb.append("58;;adicionarOpcao;;anterior$$\n");
        sb.append("58;;adicionarOpcao;;pélvico$$\n");
        sb.append("58;;adicionarOpcao;;não visualizado;;não visualizado.$$\n");
        sb.append("58;;adicionarOpcao;;justa-uterino$$\n");
        sb.append("58;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("58;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        // Contornos
        sb.append("\n59;;adicionarOpcao;;regulares$$\n");
        sb.append("59;;adicionarOpcao;;irregulares$$\n");
        sb.append("59;;vincularHabAoValorDoCampo;;$58CampoDoLaudo;;false;;{").append("para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Limites
        sb.append("\n60;;adicionarOpcao;;precisos$$\n");
        sb.append("60;;adicionarOpcao;;imprecisos$$\n");
        sb.append("60;;vincularHabAoValorDoCampo;;$58CampoDoLaudo;;false;;{").append("para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Parenquima
        sb.append("\n62;;adicionarOpcao;;mista$$\n");
        sb.append("62;;adicionarOpcao;;sólida$$\n");
        sb.append("62;;adicionarOpcao;;cística$$\n");
        sb.append("62;;adicionarOpcao;;sólido cística$$\n");
        sb.append("62;;adicionarOpcao;;múltiplos folículos subcorticais $$\n");
        sb.append("62;;vincularHabAoValorDoCampo;;$58CampoDoLaudo;;false;;{").append("para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Superficie
        sb.append("\n63;;adicionarOpcao;;ecogenicidade normal$$\n");
        sb.append("63;;adicionarOpcao;;ecogenicidade aumentada$$\n");
        sb.append("63;;vincularHabAoValorDoCampo;;$58CampoDoLaudo;;false;;{").append("para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Medidas
        sb.append("\n65;;setObrigatorio;;false$$\n");
        sb.append("\n66;;setObrigatorio;;false$$\n");
        sb.append("\n67;;setObrigatorio;;false$$\n");

        sb.append("\n65;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$66CampoDoLaudo|$67CampoDoLaudo}$$\n");
        sb.append("\n65;;setMsgErroValidCampoObrig;;Termine de informar as medidas do ovário esquerdo.$$\n");
        sb.append("\n66;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$65CampoDoLaudo|$67CampoDoLaudo}$$\n");
        sb.append("\n66;;setMsgErroValidCampoObrig;;Termine de informar as medidas do ovário esquerdo.$$\n");
        sb.append("\n67;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$65CampoDoLaudo|$66CampoDoLaudo}$$\n");
        sb.append("\n67;;setMsgErroValidCampoObrig;;Termine de informar as medidas do ovário esquerdo.$$\n");

        //

        sb.append("\n69;;cadastrarParametroFormula;;$65CampoNumero$$\n");
        sb.append("69;;cadastrarParametroFormula;;$66CampoNumero$$\n");
        sb.append("69;;cadastrarParametroFormula;;$67CampoNumero$$\n");
        sb.append("65;;vincularHabAoValorDoCampo;;$58CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");
        sb.append("66;;vincularHabAoValorDoCampo;;$58CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");
        sb.append("67;;vincularHabAoValorDoCampo;;$58CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");
        sb.append("69;;vincularHabAoValorDoCampo;;$58CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino}$$\n");

        // Descrição
        sb.append("71;;vincularHabAoValorDoCampo;;$58CampoDoLaudo;;false;;{para-uterino|posterior|inferior|anterior|pélvico|justa-uterino|").append(CampoSimples.DIGITAR + "}$$\n");
        sb.append("71;;vincularObrigatorio;;$58CampoDoLaudo;;{").append(CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fundo de saco Douglas">

        sb.append("\n76;;adicionarOpcao;;Livre$$\n");
        sb.append("76;;adicionarOpcao;;Com líquido livre$$\n");
        sb.append("76;;adicionarOpcao;;Livre com ecogenicidade aumentada$$\n");
        sb.append("76;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("76;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        // Descrição
        sb.append("78;;vincularHabAoValorDoCampo;;$76CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        sb.append("\n24;;setObrigatorio;;false$$\n");
        sb.append("\n53;;setObrigatorio;;false$$\n");
        sb.append("\n68;;setObrigatorio;;false$$\n");
        sb.append("\n73;;setObrigatorio;;false$$\n");
        sb.append("\n79;;setObrigatorio;;false$$\n");
        sb.append("\n82;;setObrigatorio;;false$$\n");

        //faixa etária
        sb.append("\n79;;adicionarOpcao;;adulta (paridade: 0)$$\n");
        sb.append("79;;adicionarOpcao;;adulta (paridade: 1-2)$$\n");
        sb.append("79;;adicionarOpcao;;adulta (paridade: 3)$$\n");
        sb.append("79;;adicionarOpcao;;adulta (paridade: >4)$$\n");
        sb.append("79;;adicionarOpcao;;menopausa$$\n");
        sb.append("79;;adicionarOpcao;;adolescente$$\n");
        sb.append("79;;adicionarOpcao;;criança$$\n");
        sb.append("79;;adicionarOpcao;;indefinida$$\n");

        //textura Miometrio
        sb.append("\n27;;adicionarOpcao;;homogênea$$\n");
        sb.append("27;;adicionarOpcao;;heterogênea$$\n");
        sb.append("27;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{").append("anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");

        //canal Endocervical
        sb.append("\n29;;adicionarOpcao;;fechado$$\n");
        sb.append("29;;adicionarOpcao;;pérveo$$\n");
        sb.append("29;;adicionarOpcao;;com presença de múcuo$$\n");
        sb.append("29;;adicionarOpcao;;não se visualiza múcuo$$\n");
        sb.append("29;;adicionarOpcao;;dilatado com múcuo de 1 mm$$\n");
        sb.append("29;;adicionarOpcao;;dilatado com múcuo de 2 mm$$\n");
        sb.append("29;;adicionarOpcao;;dilatado com múcuo de 3 mm$$\n");
        sb.append("29;;adicionarOpcao;;dilatado com múcuo de 4 mm$$\n");
        sb.append("29;;adicionarOpcao;;dilatado com múcuo superior a 4 mm$$\n");
        sb.append("29;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{").append("anteversão|medioversão|RTV leve|RTV moderada|RTV acentuada}$$\n");

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

        // </editor-fold>

        alterarModeloDeLaudo(14);
    }

    static void endoscopia () throws Exception
    {
        // <editor-fold defaultstate="collapsed" desc="Indicação clínica">

        sb.append("\n0;;Topico;;Indicação clínica$$\n");
        sb.append("\n1;;Linha$$\n");
        sb.append("2;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n3;;Linha$$\n");
        sb.append("4;;Enumeracao;;$2$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pré-medicação">

        sb.append("\n5;;Topico;;Pré-medicação$$\n");
        sb.append("\n6;;Linha$$\n");
        sb.append("7;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Monitorização por oximetria de "
                + "pulso: SpO2: 98%, pulso: 72 bat/min.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Meperidina e diazepan endovenosa."
                + " Anestesia tópica no orofaringe com xylocaína a 10%.</p>\n");
        sb.append("$$\n");
        sb.append("\n8;;Linha$$\n");
        sb.append("9;;Enumeracao;;$7$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Informações adicionais">

        //campo descrito Informações adicionais
        sb.append("\n10;;Topico;;Informações adicionais$$\n");
        sb.append("\n11;;Linha$$\n");
        sb.append("12;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Realizada biópsia, no antro, para pesquisa de helicobacter pylori: positivo.\n");
        sb.append("</p><p style=\"margin-top: 0\">A critério clínico do médico "
                + "solicitante, repetir este exame.</p>\n");
        sb.append("$$\n");
        sb.append("\n13;;Linha$$\n");
        sb.append("14;;Enumeracao;;$12$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Esôfago">
        //campo descrito Esôfago
        sb.append("\n15;;Topico;;Esôfago$$\n");
        sb.append("\n16;;Linha$$\n");
        sb.append("17;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Forma, calibre e distensibilidade"
                + " normais.</p><p style=\"margin-top: 0\">\n");
        sb.append("Mucosa de aspecto normal.</p><p style=\"margin-top: 0\">\n");
        sb.append("Padrão vascular conservado.</p><p style=\"margin-top: 0\">\n");
        sb.append("Transição esôfago gástrica ao nível do pinçamento diafragmático e a 40 cm da arcada dentária superior.</p>\n");
        sb.append("$$\n");
        sb.append("\n18;;Linha$$\n");
        sb.append("19;;Enumeracao;;$17$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Estômago">

        sb.append("\n20;;Topico;;Estômago$$\n");
        sb.append("\n21;;Linha$$\n");
        sb.append("22;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Forma, volume e distensibilidade normais.\n");
        sb.append("</p><p style=\"margin-top: 0\">Presença de líquido hialino de estase em pequena quantidade e coloração habitual.\n");
        sb.append("</p><p style=\"margin-top: 0\">Pregas regulares e anatômicas.\n");
        sb.append("</p><p style=\"margin-top: 0\">Manobra de retro visão demonstra cárdia bem ajustada ao aparelho e mucosa do fundo normal.\n");
        sb.append("</p><p style=\"margin-top: 0\">Mucosa do corpo apresenta-se macroscopicamente normal.\n");
        sb.append("</p><p style=\"margin-top: 0\">Peristaltismo antral preservado.\n");
        sb.append("</p><p style=\"margin-top: 0\">Mucosa antral de aspecto normal.\n");
        sb.append("</p><p style=\"margin-top: 0\">Piloro centrado e pérvio.</p>\n");
        sb.append("$$\n");
        sb.append("\n23;;Linha$$\n");
        sb.append("24;;Enumeracao;;$22$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Duodeno">

        //campo descrito Duodeno
        sb.append("\n25;;Topico;;Duodeno$$\n");
        sb.append("\n26;;Linha$$\n");
        sb.append("27;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Forma, calibre e distensibilidade normais.\n");
        sb.append("</p><p style=\"margin-top: 0\">Mucosa de aspecto normal.\n");
        sb.append("</p><p style=\"margin-top: 0\">Padrão vascular conservado.\n");
        sb.append("</p><p style=\"margin-top: 0\">Transição esôfago gástrica ao nível do pinçamento"
                + " diafragmático e a 40 cm da arcada dentária superior.</p>\n");
        sb.append("$$\n");
        sb.append("\n28;;Linha$$\n");
        sb.append("29;;Enumeracao;;$27$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        //campo descrito  Observações gerais
        sb.append("\n30;;Topico;;Observações gerais$$\n");
        sb.append("\n31;;Linha$$\n");
        sb.append("32;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("\n33;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n34;;Linha$$\n");
        sb.append("35;;ImpressaoDiagnostica;;\n");
        sb.append("<p style=\"margin-top: 0\">Endoscopia digestiva alta normal.</p>\n");
        sb.append("$$\n");
        sb.append("\n36;;Linha$$\n");
        sb.append("37;;Enumeracao;;$35CampoTexto$$\n");

        // </editor-fold>

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Metodos">
        sb.append("32;;setObrigatorio;;false$$\n");
        // </editor-fold>

        alterarModeloDeLaudo(9);

    }

    static void videoFaringLaringoscopiaEndoscópico () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Indicação clínica">

        //campo descrito  Descrição
        sb.append("\n0;;Topico;;Indicação clínica$$\n");
        sb.append("\n1;;Linha$$\n");
        sb.append("2;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n3;;Linha$$\n");
        sb.append("4;;Enumeracao;;$2$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pré-medicação / Equipamento">

        sb.append("\n5;;Topico;;Pré-medicação / Equipamento$$\n");
        sb.append("\n6;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+".$$\n");
        //presença
        sb.append("7;;Enumeracao;;Exame realizado com óptica ").append(CampoSimples.identificador).append("$$\n");

        sb.append("8;;CampoInteiro;; de "+CampoSimples.identificador).append("°;;2$$\n");

        sb.append("9;;CampoDouble;; após anestesia tópica de orofaringe com lidocaína ").append(CampoSimples.identificador).append("%;;1$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tonsilas palatinas">

        sb.append("\n10;;Topico;;Tonsilas palatinas$$\n");
        sb.append("\n11;;Linha$$\n");
        sb.append("12;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("13;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Base de língua">
        sb.append("\n14;;Topico;;Base de língua$$\n");
        sb.append("\n15;;Linha$$\n");
        sb.append("16;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("17;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Valéculas">
        sb.append("\n18;;Topico;;Valéculas$$\n");
        sb.append("\n19;;Linha$$\n");
        sb.append("20;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("21;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Seios piriformes">
        sb.append("\n22;;Topico;;Seios piriformes$$\n");
        sb.append("\n23;;Linha$$\n");
        sb.append("24;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("25;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Epiglote">
        sb.append("\n26;;Topico;;Epiglote$$\n");
        sb.append("\n27;;Linha$$\n");
        sb.append("28;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("29;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pregas ariepiglótica">
        sb.append("\n30;;Topico;;Pregas ariepiglótica$$\n");
        sb.append("\n31;;Linha$$\n");
        sb.append("32;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("33;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Aritenoides">
        sb.append("\n34;;Topico;;Aritenoides$$\n");
        sb.append("\n35;;Linha$$\n");
        sb.append("36;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("37;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Bandas ventriculares">
        sb.append("\n38;;Topico;;Bandas ventriculares$$\n");
        sb.append("\n39;;Linha$$\n");
        sb.append("40;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("41;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pregas vocais">

        sb.append("\n42;;Topico;;Pregas vocais$$\n");
        sb.append("\n43;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("44;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("45;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n46;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("47;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("48;;CampoTexto;;\n");
        sb.append("$$\n");

        sb.append("\n49;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("50;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("51;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n52;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("53;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("54;;CampoTexto;;\n");
        sb.append("$$\n");

        sb.append("\n55;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("56;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("57;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        //campo descrito  Observações gerais
        sb.append("\n58;;Topico;;Observações gerais$$\n");
        sb.append("\n59;;Linha$$\n");
        sb.append("60;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("\n61;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n62;;Linha$$\n");
        sb.append("63;;ImpressaoDiagnostica;;\n");
        sb.append("$$\n");
        sb.append("\n64;;Linha$$\n");
        sb.append("65;;Enumeracao;;$63CampoTexto$$\n");
        // </editor-fold>

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Metodos">

        // <editor-fold defaultstate="collapsed" desc="Pregas vocais">

        sb.append("\n43;;setDescrPrimParag;;Superfície mucosa: $$\n");
        sb.append("46;;setDescrPrimParag;;Bordos: $$\n");
        sb.append("49;;setDescrPrimParag;;Coaptação: $$\n");
        sb.append("52;;setDescrPrimParag;;Mobilidade: $$\n");
        sb.append("55;;setDescrPrimParag;;Fenda: $$\n");

        // </editor-fold>

        sb.append("\n7;;adicionarOpcao;;flexível$$\n");
        sb.append("7;;adicionarOpcao;;rígida$$\n");
        sb.append("8;;vincularHabAoValorDoCampo;;$7CampoDoLaudo;;false;;{rígida}$$\n");

        sb.append("\n12;;adicionarOpcao;;Normotróficas$$\n");
        sb.append("\n12;;adicionarOpcao;;Hipertróficas$$\n");
        sb.append("\n12;;adicionarOpcao;;Atróficas$$\n");
        sb.append("\n12;;adicionarOpcao;;Assimétricas$$\n");
        sb.append("\n12;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("12;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("13;;vincularHabAoValorDoCampo;;$12CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n16;;adicionarOpcao;;Normal$$\n");
        sb.append("\n16;;adicionarOpcao;;Volume aumentado$$\n");
        sb.append("\n16;;adicionarOpcao;;Presença de varizes$$\n");
        sb.append("\n16;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("16;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("17;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n20;;adicionarOpcao;;Livres$$\n");
        sb.append("\n20;;adicionarOpcao;;Estase salivar$$\n");
        sb.append("\n20;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("20;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("21;;vincularHabAoValorDoCampo;;$20CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n24;;adicionarOpcao;;Livres$$\n");
        sb.append("\n24;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("24;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("25;;vincularHabAoValorDoCampo;;$24CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n28;;adicionarOpcao;;Normal$$\n");
        sb.append("\n28;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("28;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("29;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n32;;adicionarOpcao;;Normais$$\n");
        sb.append("\n32;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("32;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("33;;vincularHabAoValorDoCampo;;$32CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n36;;adicionarOpcao;;Normais$$\n");
        sb.append("\n36;;adicionarOpcao;;Hiperemiadas$$\n");
        sb.append("\n36;;adicionarOpcao;;Edemaciadas$$\n");
        sb.append("\n36;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("36;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("37;;vincularHabAoValorDoCampo;;$36CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n40;;adicionarOpcao;;Livres$$\n");
        sb.append("\n40;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("40;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("41;;vincularHabAoValorDoCampo;;$40CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n44;;adicionarOpcao;;lisa$$\n");
        sb.append("\n44;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("44;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("45;;vincularHabAoValorDoCampo;;$44CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n47;;adicionarOpcao;;regulares$$\n");
        sb.append("\n47;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("47;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("48;;vincularHabAoValorDoCampo;;$47CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n50;;adicionarOpcao;;completa$$\n");
        sb.append("\n50;;adicionarOpcao;;incompleta$$\n");
        sb.append("\n50;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("50;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("51;;vincularHabAoValorDoCampo;;$50CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n53;;adicionarOpcao;;normal$$\n");
        sb.append("\n53;;adicionarOpcao;;paresia direita$$\n");
        sb.append("\n53;;adicionarOpcao;;paresia esquerda$$\n");
        sb.append("\n53;;adicionarOpcao;;paralisia direita$$\n");
        sb.append("\n53;;adicionarOpcao;;paralisia esquerda$$\n");
        sb.append("\n53;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("53;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("54;;vincularHabAoValorDoCampo;;$53CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n56;;adicionarOpcao;;anterior$$\n");
        sb.append("\n56;;adicionarOpcao;;posterior$$\n");
        sb.append("\n56;;adicionarOpcao;;em ampulheta$$\n");
        sb.append("\n56;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("\n56;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("\n57;;vincularHabAoValorDoCampo;;$56CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n60;;setObrigatorio;;false$$\n");

        // </editor-fold>

        alterarModeloDeLaudo(16);

    }

    static void videoEndoscopiaNasalOtica () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Indicação clínica">

        //campo descrito  Descrição
        sb.append("\n0;;Topico;;Indicação clínica$$\n");
        sb.append("\n1;;Linha$$\n");
        sb.append("2;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n3;;Linha$$\n");
        sb.append("4;;Enumeracao;;$2$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pré-medicação / Equipamento">

        sb.append("\n5;;Topico;;Pré-medicação / Equipamento$$\n");
        sb.append("\n6;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+".$$\n");
        //presença
        sb.append("7;;Enumeracao;;Exame realizado com óptica ").append(CampoSimples.identificador).append("$$\n");

        sb.append("8;;CampoInteiro;; de "+CampoSimples.identificador+"°;;2$$\n");

        sb.append("\n9;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+".$$\n");
        sb.append("10;;CampoDouble;; Anestesia tópica de orofaringe com lidocaína ").
                append(CampoSimples.identificador).append("% e retração de cornetos nasais com efedrina;;1$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Septo nasal">

        sb.append("\n11;;Topico;;Septo nasal$$\n");
        sb.append("\n12;;Linha$$\n");
        sb.append("13;;Enumeracao;;").append(CampoSimples.identificador).append("$$\n");
        sb.append("14;;Enumeracao;; ").append(CampoSimples.identificador).append("$$\n");
        sb.append("15;;Enumeracao;;, ").append(CampoSimples.identificador).append("$$\n");
        sb.append("16;;Enumeracao;; e ").append(CampoSimples.identificador).append(".$$\n");
        sb.append("17;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("18;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fossa nasal">

        sb.append("\n19;;Topico;;Fossa nasal;;\n");
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
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Direita").append("</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t<b>Esquerda</b></td>\n");
        sb.append("\t</tr>\n");
        sb.append(HTML_CAMPOS_FILHOS).append("\n");
        sb.append("</table>$$\n");

        sb.append("\n20;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_3).append("\n").append(LinhaDaTbl.HTML_FILHO_4).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("21;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("22;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("23;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("24;;CampoTexto;;\n");
        sb.append("$$\n");

        sb.append("\n25;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_3).append("\n").append(LinhaDaTbl.HTML_FILHO_4).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("26;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("27;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("28;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("29;;CampoTexto;;\n");
        sb.append("$$\n");

        sb.append("\n30;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_3).append("\n").append(LinhaDaTbl.HTML_FILHO_4).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("31;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("32;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("33;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("34;;CampoTexto;;\n");
        sb.append("$$\n");

        sb.append("\n35;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_3).append("\n").append(LinhaDaTbl.HTML_FILHO_4).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("36;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("37;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("38;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("39;;CampoTexto;;\n");
        sb.append("$$\n");

        sb.append("\n40;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_3).append("\n").append(LinhaDaTbl.HTML_FILHO_4).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("41;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("42;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("43;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("44;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Rinofaringe">

        sb.append("\n45;;Topico;;Rinofaringe$$\n");
        sb.append("\n46;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("47;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        sb.append("48;;Enumeracao;; ocupando ").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("49;;CampoDouble;; ocupando ").append(CampoSimples.identificador).append("%.;;1$$\n");
        sb.append("50;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n51;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("52;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("53;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n54;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("55;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("56;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        //campo descrito  Observações gerais
        sb.append("\n57;;Topico;;Observações gerais$$\n");
        sb.append("\n58;;Linha$$\n");
        sb.append("59;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("\n60;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n61;;Linha$$\n");
        sb.append("\n62;;ImpressaoDiagnostica;;\n");
        sb.append("$$\n");
        sb.append("\n63;;Linha$$\n");
        sb.append("64;;Enumeracao;;$62CampoTexto$$\n");
        // </editor-fold>

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Metodos">

        // <editor-fold defaultstate="collapsed" desc="Rinofaringe">

        sb.append("\n46;;setDescrPrimParag;;Cavum: $$\n");
        sb.append("51;;setDescrPrimParag;;Óstios das tubas auditivas: $$\n");
        sb.append("54;;setDescrPrimParag;;Mobilidade palatal: $$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fossa nasal">

        sb.append("\n20;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_1 + ";;Mucosa: $$\n");
        sb.append("20;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_2 + ";;Mucosa: $$\n");
        sb.append("20;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_3 + ";;Mucosa: $$\n");
        sb.append("20;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_4 + ";;Mucosa: $$\n");

        sb.append("\n25;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_1 + ";;Concha inferior: $$\n");
        sb.append("25;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_2 + ";;Concha inferior: $$\n");
        sb.append("25;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_3 + ";;Concha inferior: $$\n");
        sb.append("25;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_4 + ";;Concha inferior: $$\n");

        sb.append("\n30;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_1 + ";;Meato inferior: $$\n");
        sb.append("30;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_2 + ";;Meato inferior: $$\n");
        sb.append("30;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_3 + ";;Meato inferior: $$\n");
        sb.append("30;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_4 + ";;Meato inferior: $$\n");

        sb.append("\n35;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_1 + ";;Concha média: $$\n");
        sb.append("35;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_2 + ";;Concha média: $$\n");
        sb.append("35;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_3 + ";;Concha média: $$\n");
        sb.append("35;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_4 + ";;Concha média: $$\n");

        sb.append("\n40;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_1 + ";;Meato médio: $$\n");
        sb.append("40;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_2 + ";;Meato médio: $$\n");
        sb.append("40;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_3 + ";;Meato médio: $$\n");
        sb.append("40;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_4 + ";;Meato médio: $$\n");

        // </editor-fold>

        sb.append("\n59;;setObrigatorio;;false$$\n");

        sb.append("\n7;;adicionarOpcao;;flexível$$\n");
        sb.append("7;;adicionarOpcao;;rígida$$\n");
        sb.append("8;;vincularHabAoValorDoCampo;;$7CampoDoLaudo;;false;;{rígida}$$\n");

        sb.append("\n13;;adicionarOpcao;;Centrado;;Centrado.$$\n");
        sb.append("\n13;;adicionarOpcao;;Desvio;;Desvio: $$\n");
        sb.append("\n13;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("13;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("18;;vincularHabAoValorDoCampo;;$13CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n14;;adicionarOpcao;;caudal$$\n");
        sb.append("\n14;;adicionarOpcao;;anterior$$\n");
        sb.append("\n14;;adicionarOpcao;;médio$$\n");
        sb.append("\n14;;adicionarOpcao;;posterior$$\n");
        sb.append("14;;vincularHabAoValorDoCampo;;$13CampoDoLaudo;;false;;{Desvio}$$\n");

        sb.append("\n15;;adicionarOpcao;;leve$$\n");
        sb.append("\n15;;adicionarOpcao;;moderado$$\n");
        sb.append("\n15;;adicionarOpcao;;obstrutivo$$\n");
        sb.append("\n15;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("15;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("17;;vincularHabAoValorDoCampo;;$15CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("15;;vincularHabAoValorDoCampo;;$13CampoDoLaudo;;false;;{Desvio}$$\n");

        sb.append("\n16;;adicionarOpcao;;para direita$$\n");
        sb.append("\n16;;adicionarOpcao;;para esquerda$$\n");
        sb.append("16;;vincularHabAoValorDoCampo;;$13CampoDoLaudo;;false;;{Desvio}$$\n");
        //mucosa direita
        sb.append("\n21;;adicionarOpcao;;normotrófica$$\n");
        sb.append("\n21;;adicionarOpcao;;pálida$$\n");
        sb.append("\n21;;adicionarOpcao;;hiperemiada$$\n");
        sb.append("\n21;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("21;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("22;;vincularHabAoValorDoCampo;;$21CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("20;;setarHtmlCampoDes;;$21CampoDoLaudo;;$$\n");
        sb.append("20;;setarHtmlCampoDes;;$22CampoDoLaudo;;$$\n");
        //mucosa esquerda
        sb.append("\n23;;adicionarOpcao;;normotrófica$$\n");
        sb.append("\n23;;adicionarOpcao;;pálida$$\n");
        sb.append("\n23;;adicionarOpcao;;hiperemiada$$\n");
        sb.append("\n23;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("23;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("24;;vincularHabAoValorDoCampo;;$23CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("20;;setarHtmlCampoDes;;$23CampoDoLaudo;;$$\n");
        sb.append("20;;setarHtmlCampoDes;;$24CampoDoLaudo;;$$\n");
        //concha inferior direita
        sb.append("\n26;;adicionarOpcao;;normotrófica$$\n");
        sb.append("\n26;;adicionarOpcao;;hipertrofiada, pouco responsiva ao vasoconstritor$$\n");
        sb.append("\n26;;adicionarOpcao;;hipertrofiada, mas responsiva ao vasoconstritor$$\n");
        sb.append("\n26;;adicionarOpcao;;hipertrofiada, não responsiva ao vasoconstritor$$\n");
        sb.append("\n26;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("26;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("27;;vincularHabAoValorDoCampo;;$26CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("25;;setarHtmlCampoDes;;$26CampoDoLaudo;;$$\n");
        sb.append("25;;setarHtmlCampoDes;;$27CampoDoLaudo;;$$\n");
        //concha inferior esquerda
        sb.append("\n28;;adicionarOpcao;;normotrófica$$\n");
        sb.append("\n28;;adicionarOpcao;;hipertrofiada, pouco responsiva ao vasoconstritor$$\n");
        sb.append("\n28;;adicionarOpcao;;hipertrofiada, mas responsiva ao vasoconstritor$$\n");
        sb.append("\n28;;adicionarOpcao;;hipertrofiada, não responsiva ao vasoconstritor$$\n");
        sb.append("\n28;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("28;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("29;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("25;;setarHtmlCampoDes;;$28CampoDoLaudo;;$$\n");
        sb.append("25;;setarHtmlCampoDes;;$29CampoDoLaudo;;$$\n");
        //meato inferior direito
        sb.append("\n31;;adicionarOpcao;;ausência de secreção$$\n");
        sb.append("\n31;;adicionarOpcao;;presença de secreção hialina$$\n");
        sb.append("\n31;;adicionarOpcao;;presença de secreção purulenta$$\n");
        sb.append("\n31;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("31;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("32;;vincularHabAoValorDoCampo;;$31CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("30;;setarHtmlCampoDes;;$31CampoDoLaudo;;$$\n");
        sb.append("30;;setarHtmlCampoDes;;$32CampoDoLaudo;;$$\n");
        //meato inferior esquerdo
        sb.append("\n33;;adicionarOpcao;;ausência de secreção$$\n");
        sb.append("\n33;;adicionarOpcao;;presença de secreção hialina$$\n");
        sb.append("\n33;;adicionarOpcao;;presença de secreção purulenta$$\n");
        sb.append("\n33;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("33;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("34;;vincularHabAoValorDoCampo;;$33CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("30;;setarHtmlCampoDes;;$33CampoDoLaudo;;$$\n");
        sb.append("30;;setarHtmlCampoDes;;$34CampoDoLaudo;;$$\n");
        //concha média direita
        sb.append("\n36;;adicionarOpcao;;normotrófica$$\n");
        sb.append("\n36;;adicionarOpcao;;hipertrofiada, pouco responsiva ao vasoconstritor$$\n");
        sb.append("\n36;;adicionarOpcao;;hipertrofiada, mas responsiva ao vasoconstritor$$\n");
        sb.append("\n36;;adicionarOpcao;;hipertrofiada, não responsiva ao vasoconstritor$$\n");
        sb.append("\n36;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("36;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("37;;vincularHabAoValorDoCampo;;$36CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("35;;setarHtmlCampoDes;;$36CampoDoLaudo;;$$\n");
        sb.append("35;;setarHtmlCampoDes;;$37CampoDoLaudo;;$$\n");
        //concha média esquerda
        sb.append("\n38;;adicionarOpcao;;normotrófica$$\n");
        sb.append("\n38;;adicionarOpcao;;hipertrofiada, pouco responsiva ao vasoconstritor$$\n");
        sb.append("\n38;;adicionarOpcao;;hipertrofiada, mas responsiva ao vasoconstritor$$\n");
        sb.append("\n38;;adicionarOpcao;;hipertrofiada, não responsiva ao vasoconstritor$$\n");
        sb.append("\n38;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("38;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("39;;vincularHabAoValorDoCampo;;$38CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("35;;setarHtmlCampoDes;;$38CampoDoLaudo;;$$\n");
        sb.append("35;;setarHtmlCampoDes;;$39CampoDoLaudo;;$$\n");
        //meato médio direito
        sb.append("\n41;;adicionarOpcao;;ausência de secreção ou material obstrutivo$$\n");
        sb.append("\n41;;adicionarOpcao;;presença de secreção hialina$$\n");
        sb.append("\n41;;adicionarOpcao;;presença de secreção purulenta$$\n");
        sb.append("\n41;;adicionarOpcao;;presença de tecido polipoide$$\n");
        sb.append("\n41;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("41;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("42;;vincularHabAoValorDoCampo;;$41CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("40;;setarHtmlCampoDes;;$41CampoDoLaudo;;$$\n");
        sb.append("40;;setarHtmlCampoDes;;$42CampoDoLaudo;;$$\n");
        //meato médio esquerdo
        sb.append("\n43;;adicionarOpcao;;ausência de secreção ou material obstrutivo$$\n");
        sb.append("\n43;;adicionarOpcao;;presença de secreção hialina$$\n");
        sb.append("\n43;;adicionarOpcao;;presença de secreção purulenta$$\n");
        sb.append("\n43;;adicionarOpcao;;presença de tecido polipoide$$\n");
        sb.append("\n43;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("43;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("44;;vincularHabAoValorDoCampo;;$43CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("40;;setarHtmlCampoDes;;$43CampoDoLaudo;;$$\n");
        sb.append("40;;setarHtmlCampoDes;;$44CampoDoLaudo;;$$\n");
        //Rinofaringe
        sb.append("\n47;;adicionarOpcao;;livre;;livre.$$\n");
        sb.append("\n47;;adicionarOpcao;;adenoide$$\n");
        sb.append("\n47;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("47;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("48;;vincularHabAoValorDoCampo;;$47CampoDoLaudo;;false;;{adenoide}$$\n");
        sb.append("50;;vincularHabAoValorDoCampo;;$47CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n48;;adicionarOpcao;;30%$$\n");
        sb.append("\n48;;adicionarOpcao;;50%$$\n");
        sb.append("\n48;;adicionarOpcao;;70%$$\n");
        sb.append("\n48;;adicionarOpcao;;90% ou mais$$\n");
        sb.append("\n48;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("48;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("49;;vincularHabAoValorDoCampo;;$48CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n52;;adicionarOpcao;;livres$$\n");
        sb.append("\n52;;adicionarOpcao;;ocupados por tecido adenoidiano$$\n");
        sb.append("\n52;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("52;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("53;;vincularHabAoValorDoCampo;;$52CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n55;;adicionarOpcao;;preservada$$\n");
        sb.append("\n55;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("55;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("56;;vincularHabAoValorDoCampo;;$55CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        alterarModeloDeLaudo(17);

    }

    static void videoNasofibrolaringoscopia () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Indicação clínica">

        //campo descrito  Descrição
        sb.append("\n0;;Topico;;Indicação clínica$$\n");
        sb.append("\n1;;Linha$$\n");
        sb.append("2;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n3;;Linha$$\n");
        sb.append("4;;Enumeracao;;$2$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pré-medicação / Equipamento">

        sb.append("\n5;;Topico;;Pré-medicação / Equipamento$$\n");
        sb.append("\n6;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+".$$\n");
        //presença
        sb.append("7;;Enumeracao;;").append("Exame realizado com óptica ").append(CampoSimples.identificador).append("$$\n");

        sb.append("8;;CampoInteiro;;").append(" de "+CampoSimples.identificador).append("°;;2$$\n");

        sb.append("9;;CampoDouble;; após anestesia tópica de orofaringe com lidocaína ").
                append(CampoSimples.identificador).append("% e retração de cornetos nasais com efedrina;;1$$\n");
        sb.append("10;;CampoDouble;; e anestesia tópica de orofaringe com lidocaína ").
                append(CampoSimples.identificador).append("%;;1$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Septo nasal">

        sb.append("\n11;;Topico;;Septo nasal$$\n");
        sb.append("\n12;;Linha$$\n");
        sb.append("13;;Enumeracao;;").append(CampoSimples.identificador).append("$$\n");
        sb.append("14;;Enumeracao;; ").append(CampoSimples.identificador).append("$$\n");
        sb.append("15;;Enumeracao;;, ").append(CampoSimples.identificador).append("$$\n");
        sb.append("16;;Enumeracao;; e ").append(CampoSimples.identificador).append(".$$\n");
        sb.append("17;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("18;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fossa nasal">
        sb.append("\n19;;Topico;;Fossa nasal;;\n");
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
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t<b>").append("Direita").append("</b>\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td colspan=\"1\">\n");
        sb.append("\t\t\t<b></b>\n");
        sb.append("\t\t<b>Esquerda</b></td>\n");
        sb.append("\t</tr>\n");
        sb.append(HTML_CAMPOS_FILHOS).append("\n");
        sb.append("</table>$$\n");

        sb.append("\n20;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_3).append("\n").append(LinhaDaTbl.HTML_FILHO_4).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("21;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("22;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("23;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("24;;CampoTexto;;\n");
        sb.append("$$\n");

        sb.append("\n25;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_3).append("\n").append(LinhaDaTbl.HTML_FILHO_4).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("26;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("27;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("28;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("29;;CampoTexto;;\n");
        sb.append("$$\n");

        sb.append("\n30;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_3).append("\n").append(LinhaDaTbl.HTML_FILHO_4).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("31;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("32;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("33;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("34;;CampoTexto;;\n");
        sb.append("$$\n");

        sb.append("\n35;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_3).append("\n").append(LinhaDaTbl.HTML_FILHO_4).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("36;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("37;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("38;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("39;;CampoTexto;;\n");
        sb.append("$$\n");

        sb.append("\n40;;LinhaDaTbl;;\n");
        sb.append("\t<tr>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_1).append("\n").append(LinhaDaTbl.HTML_FILHO_2).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t\t<td width=\"50%\">\n");
        sb.append("\t\t\t").append(LinhaDaTbl.HTML_FILHO_3).append("\n").append(LinhaDaTbl.HTML_FILHO_4).append("\n");
        sb.append("\t\t</td>\n");
        sb.append("\t</tr>\n");
        sb.append("$$\n");
        sb.append("41;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("42;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("43;;Enumeracao;;\n");
        sb.append(identificador + ".\n");
        sb.append(";;true$$\n");
        sb.append("44;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Rinofaringe">

        sb.append("\n45;;Topico;;Rinofaringe$$\n");
        sb.append("\n46;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("47;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        sb.append("48;;Enumeracao;; ocupando ").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("49;;CampoDouble;; ocupando ").append(CampoSimples.identificador).append("%.;;1$$\n");
        sb.append("50;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n51;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("52;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("53;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n54;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("55;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("56;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Orofaringe, Hipofaringe e Laringe">

        sb.append("\n57;;Topico;;Orofaringe, hipofaringe e laringe$$\n");

        // <editor-fold defaultstate="collapsed" desc="Tonsilas palatinas">

        sb.append("\n58;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("59;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("60;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Úvula">
        sb.append("\n61;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("62;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("63;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Base de língua">
        sb.append("\n64;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("65;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("66;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Valéculas">
        sb.append("\n67;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("68;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("69;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Seios piriformes">
        sb.append("\n70;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("71;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("72;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Epiglote">
        sb.append("\n73;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("74;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("75;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pregas ariepiglótica">
        sb.append("\n76;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("77;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("78;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Aritenoides">
        sb.append("\n79;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("80;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("81;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Bandas ventriculares">
        sb.append("\n82;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("83;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("84;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pregas vocais">

        sb.append("\n85;;Grupo;;Pregas vocais$$\n");

        sb.append("\n86;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("87;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("88;;CampoTexto;;\n");
        sb.append("$$\n");

        sb.append("\n89;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("90;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("91;;CampoTexto;;\n");
        sb.append("$$\n");

        sb.append("\n92;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("93;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("94;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n95;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("96;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("97;;CampoTexto;;\n");
        sb.append("$$\n");

        sb.append("\n98;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("99;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("100;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        //campo descrito  Observações gerais
        sb.append("\n101;;Topico;;Observações gerais$$\n");
        sb.append("\n102;;Linha$$\n");
        sb.append("103;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("\n104;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n105;;Linha$$\n");
        sb.append("\n106;;ImpressaoDiagnostica;;\n");
        sb.append("$$\n");
        sb.append("\n107;;Linha$$\n");
        sb.append("108;;Enumeracao;;$106CampoTexto$$\n");
        // </editor-fold>

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Metodos">

        // <editor-fold defaultstate="collapsed" desc="Rinofaringe">

        sb.append("\n46;;setDescrPrimParag;;Cavum: $$\n");
        sb.append("51;;setDescrPrimParag;;Óstios das tubas auditivas: $$\n");
        sb.append("54;;setDescrPrimParag;;Mobilidade palatal: $$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Orofaringe, Hipofaringe e Laringe">

        sb.append("\n58;;setDescrPrimParag;;Tonsilas palatinas: $$\n");
        sb.append("61;;setDescrPrimParag;;Úvula: $$\n");
        sb.append("64;;setDescrPrimParag;;Base de língua: $$\n");
        sb.append("67;;setDescrPrimParag;;Valéculas: $$\n");
        sb.append("70;;setDescrPrimParag;;Seios piriformes: $$\n");
        sb.append("73;;setDescrPrimParag;;Epiglote: $$\n");
        sb.append("76;;setDescrPrimParag;;Pregas ariepiglótica: $$\n");
        sb.append("79;;setDescrPrimParag;;Aritenoides: $$\n");
        sb.append("82;;setDescrPrimParag;;Bandas ventriculares: $$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pregas vocais">

        sb.append("\n86;;setDescrPrimParag;;Superfície mucosa: $$\n");
        sb.append("89;;setDescrPrimParag;;Bordos: $$\n");
        sb.append("92;;setDescrPrimParag;;Coaptação: $$\n");
        sb.append("95;;setDescrPrimParag;;Mobilidade: $$\n");
        sb.append("98;;setDescrPrimParag;;Fenda: $$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fossa nasal">

        sb.append("\n20;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_1 + ";;Mucosa: $$\n");
        sb.append("20;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_2 + ";;Mucosa: $$\n");
        sb.append("20;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_3 + ";;Mucosa: $$\n");
        sb.append("20;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_4 + ";;Mucosa: $$\n");

        sb.append("\n25;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_1 + ";;Concha inferior: $$\n");
        sb.append("25;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_2 + ";;Concha inferior: $$\n");
        sb.append("25;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_3 + ";;Concha inferior: $$\n");
        sb.append("25;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_4 + ";;Concha inferior: $$\n");

        sb.append("\n30;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_1 + ";;Meato inferior: $$\n");
        sb.append("30;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_2 + ";;Meato inferior: $$\n");
        sb.append("30;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_3 + ";;Meato inferior: $$\n");
        sb.append("30;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_4 + ";;Meato inferior: $$\n");

        sb.append("\n35;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_1 + ";;Concha média: $$\n");
        sb.append("35;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_2 + ";;Concha média: $$\n");
        sb.append("35;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_3 + ";;Concha média: $$\n");
        sb.append("35;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_4 + ";;Concha média: $$\n");

        sb.append("\n40;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_1 + ";;Meato médio: $$\n");
        sb.append("40;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_2 + ";;Meato médio: $$\n");
        sb.append("40;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_3 + ";;Meato médio: $$\n");
        sb.append("40;;setDescrPrimParag;;" + LinhaDaTbl.HTML_FILHO_4 + ";;Meato médio: $$\n");

        // </editor-fold>

        sb.append("\n103;;setObrigatorio;;false$$\n");

        sb.append("\n7;;adicionarOpcao;;flexível$$\n");
        sb.append("7;;adicionarOpcao;;rígida$$\n");
        sb.append("8;;vincularHabAoValorDoCampo;;$7CampoDoLaudo;;false;;{rígida}$$\n");

        sb.append("\n13;;adicionarOpcao;;Centrado;;Centrado.$$\n");
        sb.append("\n13;;adicionarOpcao;;Desvio;;Desvio: $$\n");
        sb.append("\n13;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("13;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("18;;vincularHabAoValorDoCampo;;$13CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n14;;adicionarOpcao;;caudal$$\n");
        sb.append("\n14;;adicionarOpcao;;anterior$$\n");
        sb.append("\n14;;adicionarOpcao;;médio$$\n");
        sb.append("\n14;;adicionarOpcao;;posterior$$\n");
        sb.append("14;;vincularHabAoValorDoCampo;;$13CampoDoLaudo;;false;;{Desvio}$$\n");

        sb.append("\n15;;adicionarOpcao;;leve$$\n");
        sb.append("\n15;;adicionarOpcao;;moderado$$\n");
        sb.append("\n15;;adicionarOpcao;;obstrutivo$$\n");
        sb.append("\n15;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("15;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("17;;vincularHabAoValorDoCampo;;$15CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("15;;vincularHabAoValorDoCampo;;$13CampoDoLaudo;;false;;{Desvio}$$\n");

        sb.append("\n16;;adicionarOpcao;;para direita$$\n");
        sb.append("\n16;;adicionarOpcao;;para esquerda$$\n");
        sb.append("16;;vincularHabAoValorDoCampo;;$13CampoDoLaudo;;false;;{Desvio}$$\n");
        //mucosa direita
        sb.append("\n21;;adicionarOpcao;;normotrófica$$\n");
        sb.append("\n21;;adicionarOpcao;;pálida$$\n");
        sb.append("\n21;;adicionarOpcao;;hiperemiada$$\n");
        sb.append("\n21;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("21;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("22;;vincularHabAoValorDoCampo;;$21CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("20;;setarHtmlCampoDes;;$21CampoDoLaudo;;$$\n");
        sb.append("20;;setarHtmlCampoDes;;$22CampoDoLaudo;;$$\n");
        //mucosa esquerda
        sb.append("\n23;;adicionarOpcao;;normotrófica$$\n");
        sb.append("\n23;;adicionarOpcao;;pálida$$\n");
        sb.append("\n23;;adicionarOpcao;;hiperemiada$$\n");
        sb.append("\n23;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("23;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("24;;vincularHabAoValorDoCampo;;$23CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("20;;setarHtmlCampoDes;;$23CampoDoLaudo;;$$\n");
        sb.append("20;;setarHtmlCampoDes;;$24CampoDoLaudo;;$$\n");
        //concha inferior direita
        sb.append("\n26;;adicionarOpcao;;normotrófica$$\n");
        sb.append("\n26;;adicionarOpcao;;hipertrofiada, pouco responsiva ao vasoconstritor$$\n");
        sb.append("\n26;;adicionarOpcao;;hipertrofiada, mas responsiva ao vasoconstritor$$\n");
        sb.append("\n26;;adicionarOpcao;;hipertrofiada, não responsiva ao vasoconstritor$$\n");
        sb.append("\n26;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("26;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("27;;vincularHabAoValorDoCampo;;$26CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("25;;setarHtmlCampoDes;;$26CampoDoLaudo;;$$\n");
        sb.append("25;;setarHtmlCampoDes;;$27CampoDoLaudo;;$$\n");
        //concha inferior esquerda
        sb.append("\n28;;adicionarOpcao;;normotrófica$$\n");
        sb.append("\n28;;adicionarOpcao;;hipertrofiada, pouco responsiva ao vasoconstritor$$\n");
        sb.append("\n28;;adicionarOpcao;;hipertrofiada, mas responsiva ao vasoconstritor$$\n");
        sb.append("\n28;;adicionarOpcao;;hipertrofiada, não responsiva ao vasoconstritor$$\n");
        sb.append("\n28;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("28;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("29;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("25;;setarHtmlCampoDes;;$28CampoDoLaudo;;$$\n");
        sb.append("25;;setarHtmlCampoDes;;$29CampoDoLaudo;;$$\n");
        //meato inferior direito
        sb.append("\n31;;adicionarOpcao;;ausência de secreção$$\n");
        sb.append("\n31;;adicionarOpcao;;presença de secreção hialina$$\n");
        sb.append("\n31;;adicionarOpcao;;presença de secreção purulenta$$\n");
        sb.append("\n31;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("31;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("32;;vincularHabAoValorDoCampo;;$31CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("30;;setarHtmlCampoDes;;$31CampoDoLaudo;;$$\n");
        sb.append("30;;setarHtmlCampoDes;;$32CampoDoLaudo;;$$\n");
        //meato inferior esquerdo
        sb.append("\n33;;adicionarOpcao;;ausência de secreção$$\n");
        sb.append("\n33;;adicionarOpcao;;presença de secreção hialina$$\n");
        sb.append("\n33;;adicionarOpcao;;presença de secreção purulenta$$\n");
        sb.append("\n33;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("33;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("34;;vincularHabAoValorDoCampo;;$33CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("30;;setarHtmlCampoDes;;$32CampoDoLaudo;;$$\n");
        sb.append("30;;setarHtmlCampoDes;;$34CampoDoLaudo;;$$\n");
        //concha média direita
        sb.append("\n36;;adicionarOpcao;;normotrófica$$\n");
        sb.append("\n36;;adicionarOpcao;;hipertrofiada, pouco responsiva ao vasoconstritor$$\n");
        sb.append("\n36;;adicionarOpcao;;hipertrofiada, mas responsiva ao vasoconstritor$$\n");
        sb.append("\n36;;adicionarOpcao;;hipertrofiada, não responsiva ao vasoconstritor$$\n");
        sb.append("\n36;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("36;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("37;;vincularHabAoValorDoCampo;;$36CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("35;;setarHtmlCampoDes;;$36CampoDoLaudo;;$$\n");
        sb.append("35;;setarHtmlCampoDes;;$37CampoDoLaudo;;$$\n");
        //concha média esquerda
        sb.append("\n38;;adicionarOpcao;;normotrófica$$\n");
        sb.append("\n38;;adicionarOpcao;;hipertrofiada, pouco responsiva ao vasoconstritor$$\n");
        sb.append("\n38;;adicionarOpcao;;hipertrofiada, mas responsiva ao vasoconstritor$$\n");
        sb.append("\n38;;adicionarOpcao;;hipertrofiada, não responsiva ao vasoconstritor$$\n");
        sb.append("\n38;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("38;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("39;;vincularHabAoValorDoCampo;;$38CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("35;;setarHtmlCampoDes;;$38CampoDoLaudo;;$$\n");
        sb.append("35;;setarHtmlCampoDes;;$39CampoDoLaudo;;$$\n");
        //meato médio direito
        sb.append("\n41;;adicionarOpcao;;ausência de secreção ou material obstrutivo$$\n");
        sb.append("\n41;;adicionarOpcao;;presença de secreção hialina$$\n");
        sb.append("\n41;;adicionarOpcao;;presença de secreção purulenta$$\n");
        sb.append("\n41;;adicionarOpcao;;presença de tecido polipoide$$\n");
        sb.append("\n41;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("41;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("42;;vincularHabAoValorDoCampo;;$41CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("40;;setarHtmlCampoDes;;$41CampoDoLaudo;;$$\n");
        sb.append("40;;setarHtmlCampoDes;;$42CampoDoLaudo;;$$\n");
        //meato médio esquerdo
        sb.append("\n43;;adicionarOpcao;;ausência de secreção ou material obstrutivo$$\n");
        sb.append("\n43;;adicionarOpcao;;presença de secreção hialina$$\n");
        sb.append("\n43;;adicionarOpcao;;presença de secreção purulenta$$\n");
        sb.append("\n43;;adicionarOpcao;;presença de tecido polipoide$$\n");
        sb.append("\n43;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("43;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("44;;vincularHabAoValorDoCampo;;$43CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("40;;setarHtmlCampoDes;;$43CampoDoLaudo;;$$\n");
        sb.append("40;;setarHtmlCampoDes;;$44CampoDoLaudo;;$$\n");
        //Rinofaringe
        sb.append("\n47;;adicionarOpcao;;livre;;Livre.$$\n");
        sb.append("\n47;;adicionarOpcao;;adenoide$$\n");
        sb.append("\n47;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("47;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("48;;vincularHabAoValorDoCampo;;$47CampoDoLaudo;;false;;{adenoide}$$\n");
        sb.append("50;;vincularHabAoValorDoCampo;;$47CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n48;;adicionarOpcao;;30%$$\n");
        sb.append("\n48;;adicionarOpcao;;50%$$\n");
        sb.append("\n48;;adicionarOpcao;;70%$$\n");
        sb.append("\n48;;adicionarOpcao;;90% ou mais$$\n");
        sb.append("\n48;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("48;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("49;;vincularHabAoValorDoCampo;;$48CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n52;;adicionarOpcao;;livres$$\n");
        sb.append("\n52;;adicionarOpcao;;ocupados por tecido adenoidiano$$\n");
        sb.append("\n52;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("52;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("53;;vincularHabAoValorDoCampo;;$52CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n55;;adicionarOpcao;;preservada$$\n");
        sb.append("\n55;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("55;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("56;;vincularHabAoValorDoCampo;;$55CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        //2ª parte

        sb.append("\n59;;adicionarOpcao;;normotróficas$$\n");
        sb.append("\n59;;adicionarOpcao;;hipertróficas$$\n");
        sb.append("\n59;;adicionarOpcao;;atróficas$$\n");
        sb.append("\n59;;adicionarOpcao;;assimétricas$$\n");
        sb.append("\n59;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("59;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("60;;vincularHabAoValorDoCampo;;$59CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n62;;adicionarOpcao;;normal$$\n");
        sb.append("\n62;;adicionarOpcao;;alongada$$\n");
        sb.append("\n62;;adicionarOpcao;;bífida$$\n");
        sb.append("\n62;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("62;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("63;;vincularHabAoValorDoCampo;;$62CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n65;;adicionarOpcao;;normal$$\n");
        sb.append("\n65;;adicionarOpcao;;volume aumentado$$\n");
        sb.append("\n65;;adicionarOpcao;;presença de varizes$$\n");
        sb.append("\n65;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("65;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("66;;vincularHabAoValorDoCampo;;$65CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n68;;adicionarOpcao;;livres$$\n");
        sb.append("\n68;;adicionarOpcao;;estase salivar$$\n");
        sb.append("\n68;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("68;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("69;;vincularHabAoValorDoCampo;;$68CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n71;;adicionarOpcao;;livres$$\n");
        sb.append("\n71;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("71;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("72;;vincularHabAoValorDoCampo;;$71CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n74;;adicionarOpcao;;normal$$\n");
        sb.append("\n74;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("74;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("75;;vincularHabAoValorDoCampo;;$74CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n77;;adicionarOpcao;;normais$$\n");
        sb.append("\n77;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("77;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("78;;vincularHabAoValorDoCampo;;$77CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n80;;adicionarOpcao;;normais$$\n");
        sb.append("\n80;;adicionarOpcao;;hiperemiadas$$\n");
        sb.append("\n80;;adicionarOpcao;;edemaciadas$$\n");
        sb.append("\n80;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("80;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("81;;vincularHabAoValorDoCampo;;$80CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n83;;adicionarOpcao;;livres$$\n");
        sb.append("\n83;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("83;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("84;;vincularHabAoValorDoCampo;;$83CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n87;;adicionarOpcao;;lisa$$\n");
        sb.append("\n87;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("87;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("88;;vincularHabAoValorDoCampo;;$87CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n90;;adicionarOpcao;;regulares$$\n");
        sb.append("\n90;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("90;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("91;;vincularHabAoValorDoCampo;;$90CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n93;;adicionarOpcao;;completa$$\n");
        sb.append("\n93;;adicionarOpcao;;incompleta$$\n");
        sb.append("\n93;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("93;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("94;;vincularHabAoValorDoCampo;;$93CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n96;;adicionarOpcao;;normal$$\n");
        sb.append("\n96;;adicionarOpcao;;paresia direita$$\n");
        sb.append("\n96;;adicionarOpcao;;paresia esquerda$$\n");
        sb.append("\n96;;adicionarOpcao;;paralisia direita$$\n");
        sb.append("\n96;;adicionarOpcao;;paralisia esquerda$$\n");
        sb.append("\n96;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("96;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("97;;vincularHabAoValorDoCampo;;$96CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        sb.append("\n99;;adicionarOpcao;;anterior$$\n");
        sb.append("\n99;;adicionarOpcao;;posterior$$\n");
        sb.append("\n99;;adicionarOpcao;;em ampulheta$$\n");
        sb.append("\n99;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("99;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("100;;vincularHabAoValorDoCampo;;$99CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        alterarModeloDeLaudo(18);

    }

    static void laparoscopiaDiagnosticaComOuSemBiopsia  () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Dados técnicos">
        sb.append("\n0;;Topico;;Equipamento$$\n");
        //Equipamento
        sb.append("\n1;;Linha;;Realizada Laparoscopia, ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("2;;Enumeracao;;").append("sob anestesia  ").
                      append(identificador).append(",;;true$$\n");
        sb.append("3;;CampoInteiro;; com " + identificador + " punções abdominais.;;2$$\n");
        sb.append("\n4;;Linha$$\n");
        sb.append("5;;CampoDouble;;Medida(s) da(s) punção(ões): " + identificador + " mm.;;2$$\n");

        // frequencia
        sb.append("\n6;;Linha$$\n");
        sb.append("7;;CampoTexto;;\n");
        sb.append("Distensão da cavidade endometrial com gás carbônico.\n");
        sb.append("$$\n");
        sb.append("\n8;;Linha$$\n");
        sb.append("9;;Enumeracao;;$7$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Cavidade Peritoneal">

        sb.append("\n10;;Topico;;Cavidade peritoneal$$\n");
        sb.append("\n11;;Linha$$\n");
        sb.append("12;;CampoTexto;;\n");
        sb.append("Lisa, brilhante, de aspecto normal.\n");
        sb.append("$$\n");
        sb.append("\n13;;Linha$$\n");
        sb.append("14;;Enumeracao;;$12$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Bexiga">

        sb.append("\n15;;Topico;;Bexiga$$\n");
        sb.append("\n16;;Linha$$\n");
        sb.append("17;;CampoTexto;;\n");
        sb.append("Normal.\n");
        sb.append("$$\n");
        sb.append("\n18;;Linha$$\n");
        sb.append("19;;Enumeracao;;$17$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Útero">

        sb.append("\n20;;Topico;;Útero$$\n");
        sb.append("\n21;;Linha$$\n");
        sb.append("22;;CampoTexto;;\n");
        sb.append("Em ante verso flexão, de volume, forma, superfície e mobilidade normais.");
        sb.append("$$\n");
        sb.append("\n23;;Linha$$\n");
        sb.append("24;;Enumeracao;;$22$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tuba direita">

        sb.append("\n25;;Topico;;Tuba direita$$\n");
        sb.append("\n26;;Linha$$\n");
        sb.append("27;;CampoTexto;;\n");
        sb.append("De comprimento, volume, superfície, mobilidade e fímbrias normais.");
        sb.append("$$\n");
        sb.append("\n28;;Linha$$\n");
        sb.append("29;;Enumeracao;;$27$$\n");
        sb.append("\n30;;Linha$$\n");
        sb.append("31;;Enumeracao;;").append("Cromo tubagem: ").
                      append(identificador).append(".;;true$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tuba esquerda">

        sb.append("\n32;;Topico;;Tuba esquerda$$\n");
        sb.append("\n33;;Linha$$\n");
        sb.append("34;;CampoTexto;;\n");
        sb.append("De comprimento, volume, superfície, mobilidade e fímbrias normais.");
        sb.append("$$\n");
        sb.append("\n35;;Linha$$\n");
        sb.append("36;;Enumeracao;;$34$$\n");
        sb.append("\n37;;Linha$$\n");
        sb.append("38;;Enumeracao;;").append("Cromo tubagem: ").
                      append(identificador).append(".;;true$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovário direito">

        sb.append("\n39;;Topico;;Ovário direito$$\n");
        sb.append("\n40;;Linha$$\n");
        sb.append("41;;CampoTexto;;\n");
        sb.append("De volume, superfície, forma e mobilidade normais.");
        sb.append("$$\n");
        sb.append("\n42;;Linha$$\n");
        sb.append("43;;Enumeracao;;$41$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ovário esquerdo">

        sb.append("\n44;;Topico;;Ovário esquerdo$$\n");
        sb.append("\n45;;Linha$$\n");
        sb.append("46;;CampoTexto;;\n");
        sb.append("De volume, superfície, forma e mobilidade normais.");
        sb.append("$$\n");
        sb.append("\n47;;Linha$$\n");
        sb.append("48;;Enumeracao;;$46$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biopsia">

        sb.append("\n49;;Topico;;Biópsia$$\n");
        sb.append("\n50;;Linha$$\n");
        sb.append("51;;CampoTexto;;\n");
        sb.append("Não realizada.");
        sb.append("$$\n");
        sb.append("\n52;;Linha$$\n");
        sb.append("53;;Enumeracao;;$51$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Procedimento">

        sb.append("\n54;;Topico;;Procedimento$$\n");
        sb.append("\n55;;Linha$$\n");
        sb.append("56;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n57;;Linha$$\n");
        sb.append("58;;Enumeracao;;$56$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        //campo descrito  Observações gerais
        sb.append("\n59;;Topico;;Observações gerais$$\n");
        sb.append("\n60;;Linha$$\n");
        sb.append("61;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("\n62;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n63;;Linha$$\n");
        sb.append("\n64;;ImpressaoDiagnostica;;\n");
        sb.append("<p style=\"margin-top: 0\">Cavidade peritonial e órgãos pélvicos normais.</p>\n");
        sb.append("$$\n");
        sb.append("\n65;;Linha$$\n");
        sb.append("66;;Enumeracao;;$64CampoTexto$$\n");

        // </editor-fold>

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Metodos">

        sb.append("\n61;;setObrigatorio;;false$$\n");

        sb.append("\n2;;adicionarOpcao;;geral$$\n");
        sb.append("2;;adicionarOpcao;;peridural$$\n");
        sb.append("2;;adicionarOpcao;;ráqui$$\n");
        sb.append("2;;adicionarOpcao;;geral + peridural$$\n");

        sb.append("\n31;;adicionarOpcao;;pérvia com facilidade$$\n");
        sb.append("31;;adicionarOpcao;;pérvia com relativa dificuldade$$\n");
        sb.append("31;;adicionarOpcao;;pérvia com muita dificuldade$$\n");
        sb.append("31;;adicionarOpcao;;obstruída no terço proximal$$\n");
        sb.append("31;;adicionarOpcao;;obstruída no terço médio$$\n");
        sb.append("31;;adicionarOpcao;;obstruída no terço distal$$\n");

        sb.append("\n38;;adicionarOpcao;;pérvia com facilidade$$\n");
        sb.append("38;;adicionarOpcao;;pérvia com relativa dificuldade$$\n");
        sb.append("38;;adicionarOpcao;;pérvia com muita dificuldade$$\n");
        sb.append("38;;adicionarOpcao;;obstruída no terço proximal$$\n");
        sb.append("38;;adicionarOpcao;;obstruída no terço médio$$\n");
        sb.append("38;;adicionarOpcao;;obstruída no terço distal$$\n");

        // </editor-fold>

        alterarModeloDeLaudo(22);

    }

}