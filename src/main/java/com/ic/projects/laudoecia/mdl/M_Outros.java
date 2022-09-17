/*
 * M_Outros.java
 *
 * Created on 28/08/2012, 10:57:37
 */

package com.ic.projects.laudoecia.mdl;

import com.ic.projects.laudoecia.control.build.StaticInfo;
import com.ic.projects.laudoecia.model.laudo.CampoDoLaudo;
import com.ic.projects.laudoecia.model.laudo.CampoRpnData;
import com.ic.projects.laudoecia.model.laudo.CampoSimples;
import static com.ic.projects.laudoecia.model.laudo.CampoSimples.identificador;
import com.ic.projects.laudoecia.model.laudo.Enumeracao;
import com.ic.projects.laudoecia.model.laudo.Label;
import com.ic.projects.laudoecia.model.laudo.Linha;

/**
 *
 * @author Tekna <informatica@instrumental.net.br>
 */
public class M_Outros extends Model
{

    public static void main(String[] args) throws Exception
    {
        laudoMamas();
        videoColposcopiaUS();
        videoColposcopiaIFCP2011();
        videoColposcopiaIFCP2011Revisado();
        tireoide();
        transfontanelaCranio();
        rinsAparelhoUrinarioMasc();
        monitoracaoOvulacaoEndovaginal();
        colonoscopia();
//        formatarStrMdl();
    }

    static void laudoMamas () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento">
        sb.append("\n0;;Topico;;Equipamento$$\n");
        sb.append("\n1;;Linha$$\n");
        sb.append("2;;Enumeracao;;").append("Exame realizado em modo bidimensional "
                                            + "com equipamento dinâmico ").
                append(identificador).append(" multifrequencial.;;true$$\n");

        sb.append("3;;CampoTexto;;\n$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Mama direita">

        sb.append("\n4;;Topico;;Mama direita$$\n");

        // <editor-fold defaultstate="collapsed" desc="Pele">

        sb.append("\n5;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("6;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">lisa, regular e de espessura normal.</p>\n");
        sb.append("$$\n");
        sb.append("\n7;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("8;;Enumeracao;;$6$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Complexo aréolo-papilar">
        sb.append("\n9;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("10;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">de textura habitual, adequado.</p>\n");
        sb.append("$$\n");
        sb.append("\n11;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("12;;Enumeracao;;$10$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tecido celular subcutâneo">

        sb.append("\n13;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("14;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">hipoecoico, homogêneo e sem nodulações.</p>\n");
        sb.append("$$\n");
        sb.append("\n15;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("16;;Enumeracao;;$14$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Parênquima glandular">

        sb.append("\n17;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("18;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">heterogêneo, apresentando tecido fibro ductal e adiposo de textura habitual.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Ausência de nodulações, degenerações ou calcificações patológicas.</p>\n");
        sb.append("$$\n");
        sb.append("\n19;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("20;;Enumeracao;;$18$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fáscia retromamária">

        sb.append("\n21;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("22;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">de integridade preservada.</p>\n");
        sb.append("$$\n");
        sb.append("\n23;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("24;;Enumeracao;;$22$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais sobre a mama direita">

        sb.append("\n25;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("26;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Mama esquerda">

        sb.append("\n27;;Topico;;Mama esquerda$$\n");

        // <editor-fold defaultstate="collapsed" desc="Pele">

        sb.append("\n28;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("29;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">lisa, regular e de espessura normal.</p>\n");
        sb.append("$$\n");
        sb.append("\n30;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("31;;Enumeracao;;$29$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Complexo aréolo-papilar">

        sb.append("\n32;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("33;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">de textura habitual, adequado.</p>\n");
        sb.append("$$\n");
        sb.append("\n34;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("35;;Enumeracao;;$33$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tecido celular subcutâneo">

        sb.append("\n36;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("37;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">hipoecoico, homogêneo e sem nodulações.</p>\n");
        sb.append("$$\n");
        sb.append("\n38;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("39;;Enumeracao;;$37$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Parênquima glandular">

        sb.append("\n40;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("41;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">heterogêneo, apresentando tecido fibro ductal e adiposo de textura habitual.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Ausência de nodulações, degenerações ou calcificações patológicas.</p>\n");
        sb.append("$$\n");
        sb.append("\n42;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("43;;Enumeracao;;$41$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fáscia retromamária">

        sb.append("\n44;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("45;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">de integridade preservada.</p>\n");
        sb.append("$$\n");
        sb.append("\n46;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("47;;Enumeracao;;$45$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais sobre a mama esquerda">

        sb.append("\n48;;Linha;;" + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("49;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("\n50;;Topico;;Observações gerais$$\n");
        sb.append("\n51;;Linha$$\n");
        sb.append("52;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("\n53;;Topico;;Impressão diagnóstica$$\n");

        sb.append("\n54;;Linha$$\n");
        sb.append("\n55;;ImpressaoDiagnostica;;"
                + "<p style=\"margin-top: 0\">Mamas acusticamente normais.</p>$$\n");
        sb.append("\n56;;Linha$$\n");
        sb.append("57;;Enumeracao;;$55CampoTexto$$\n");

        sb.append("\n58;;Linha$$\n");
        sb.append("59;;Enumeracao;;BI-RADS: ").append(identificador).append(".$$\n");

        sb.append("60;;Linha$$\n");
        sb.append("\n61;;Label;;As categorias de avaliação do BI-RADS são:\n");
        sb.append("</p><p style=\"margin-top: 0\">0: Incompleta.\n");
        sb.append("</p><p style=\"margin-top: 0\">1: Negativa.\n");
        sb.append("</p><p style=\"margin-top: 0\">2: Achado benigno.\n");
        sb.append("</p><p style=\"margin-top: 0\">3: Provavelmente benigno.\n");
        sb.append("</p><p style=\"margin-top: 0\">4: Suspeita de anormalidade.\n");
        sb.append("</p><p style=\"margin-top: 0\">5: Altamente sugestivo de malignidade.\n");
        sb.append("</p><p style=\"margin-top: 0\">6: Malignidade conhecida.$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ciclo menstrual">

        //label data do exame
        sb.append("62;;Linha$$\n");
        sb.append("63;;Label;;").append(Label.DATA_DO_EXAME).append(";;false").append("$$\n");
        //dum
        sb.append("64;;CampoDate;;").append(CampoSimples.NAO_IMPRIMIVEL).append("$$\n");
        //dias do ciclo
        sb.append("65;;CampoRpnData;;").append(CampoSimples.NAO_IMPRIMIVEL).append(";;C1 C2 - ");
        sb.append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 / 7 * 4 +$$\n");

        // </editor-fold>

        //btn avança para o próximo tópico
        sb.append("66;;CampoInteiro;;" + CampoSimples.NAO_IMPRIMIVEL + ";;3$$\n");

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

        // <editor-fold defaultstate="collapsed" desc="Descrição das mamas">

        sb.append("5;;setDescrPrimParag;;-Pele: $$\n");
        sb.append("7;;setDescrPrimParag;;-Pele: $$\n");

        sb.append("9;;setDescrPrimParag;;-Complexo aréolo-papilar: $$\n");
        sb.append("11;;setDescrPrimParag;;-Complexo aréolo-papilar: $$\n");

        sb.append("13;;setDescrPrimParag;;-Tecido celular subcutâneo: $$\n");
        sb.append("15;;setDescrPrimParag;;-Tecido celular subcutâneo: $$\n");

        sb.append("17;;setDescrPrimParag;;-Parênquima glandular: $$\n");
        sb.append("19;;setDescrPrimParag;;-Parênquima glandular: $$\n");

        sb.append("21;;setDescrPrimParag;;-Fáscia retromamária: $$\n");
        sb.append("23;;setDescrPrimParag;;-Fáscia retromamária: $$\n");

        sb.append("28;;setDescrPrimParag;;-Pele: $$\n");
        sb.append("30;;setDescrPrimParag;;-Pele: $$\n");

        sb.append("32;;setDescrPrimParag;;-Complexo aréolo-papilar: $$\n");
        sb.append("34;;setDescrPrimParag;;-Complexo aréolo-papilar: $$\n");

        sb.append("36;;setDescrPrimParag;;-Tecido celular subcutâneo: $$\n");
        sb.append("38;;setDescrPrimParag;;-Tecido celular subcutâneo: $$\n");

        sb.append("40;;setDescrPrimParag;;-Parênquima glandular: $$\n");
        sb.append("42;;setDescrPrimParag;;-Parênquima glandular: $$\n");

        sb.append("44;;setDescrPrimParag;;-Fáscia retromamária: $$\n");
        sb.append("46;;setDescrPrimParag;;-Fáscia retromamária: $$\n");

        // </editor-fold>

        sb.append("26;;setObrigatorio;;false$$\n");
        sb.append("49;;setObrigatorio;;false$$\n");
        sb.append("52;;setObrigatorio;;false$$\n");
        sb.append("64;;setObrigatorio;;false$$\n");
        sb.append("66;;setObrigatorio;;false$$\n");

        sb.append("65;;cadastrarParamFormula;;$63CampoDoLaudo$$\n");
        sb.append("65;;cadastrarParamFormula;;$64CampoDoLaudo$$\n");

        sb.append("\n59;;adicionarOpcao;;Incompleta$$\n");
        sb.append("59;;adicionarOpcao;;Negativa$$\n");
        sb.append("59;;adicionarOpcao;;Achado benigno$$\n");
        sb.append("59;;adicionarOpcao;;Provavelmente benigno$$\n");
        sb.append("59;;adicionarOpcao;;Suspeita de anormalidade$$\n");
        sb.append("59;;adicionarOpcao;;Altamente sugestivo de malignidade$$\n");
        sb.append("59;;adicionarOpcao;;Malignidade conhecida$$\n");
        sb.append("59;;adicionarOpcao;;Não imprimir$$\n");
        sb.append("59;;adicionarExcecao;;Não imprimir;;$$\n");
        sb.append("59;;setValor;;Negativa$$\n");

        sb.append("60;;vincularHabAoValorDoCampo;;$59CampoDoLaudo;;false;;{Incompleta|Negativa|Achado benigno|Provavelmente benigno|Suspeita de anormalidade|Altamente sugestivo de malignidade|Malignidade conhecida}$$\n");

        // </editor-fold>

        alterarModeloDeLaudo(10);

    }

    static void videoColposcopiaUS () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento">

        // equipamento
        sb.append("\n0;;Topico;;Equipamento$$\n");
        sb.append("\n1;;Linha$$\n");
        sb.append("2;;Enumeracao;;").append("Exame realizado em equipamento óptico com ").append(identificador).append(" vezes.$$\n");
        sb.append("3;;CampoTexto;;\n");
        sb.append("$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vulvoscopia">

        //campo descrito vulvoscopia
        sb.append("\n4;;Topico;;Vulvoscopia$$\n");
        sb.append("\n5;;Linha$$\n");
        sb.append("6;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Vulva revestida por pele e pelos apropriados para a idade.\n");
        sb.append("</p></p><p style=\"margin-top: 0\">Ausência de anormalidades à "
                + "vulvoscopia simples e com uso do ácido acético a 5%.</p>\n");
        sb.append("$$\n");
        sb.append("\n7;;Linha$$\n");
        sb.append("8;;Enumeracao;;$6$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vaginoscopia">

        //campo descrito Vaginoscopia
        sb.append("\n9;;Topico;;Vaginoscopia$$\n");
        sb.append("\n10;;Linha$$\n");
        sb.append("11;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Vagina apresentando revestimento epitelial normal.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Ausência de anormalidades ao uso do ácido acético a 5% e solução de Schiller.</p>\n");
        sb.append("$$\n");
        sb.append("\n12;;Linha$$\n");
        sb.append("13;;Enumeracao;;$11$$\n");

        // </editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Cervicoscopia">

        sb.append("\n14;;Topico;;Cervicoscopia$$\n");
        //cervicoscopia
        sb.append("\n15;;Linha$$\n");
        sb.append("16;;Enumeracao;;").append(identificador).append(";;true$$\n");
        // forma do colo
        sb.append("\n17;;Linha$$\n");
        sb.append("18;;Enumeracao;;").append("Colo uterino de forma ").append(identificador).append("$$\n");
        // posição
        sb.append("19;;Enumeracao;;").append(", voltado para a parede vaginal ").append(identificador).append(".$$\n");
        // volume
        sb.append("\n20;;Linha$$\n");
        sb.append("21;;Enumeracao;;").append("Apresentando volume ").append(identificador).append("$$\n");
        // orificio externo
        sb.append("22;;Enumeracao;;").append(", orifício externo ").append(identificador).append(".$$\n");
        //junção escamo
        sb.append("\n23;;Linha$$\n");
        sb.append("24;;Enumeracao;;").append("Junção escamo colunar ").append(identificador).append(";;true$$\n");
        //jec localização
        sb.append("25;;Enumeracao;;").append(", ").append(identificador).append("$$\n");
        //altura jec
        sb.append("26;;CampoInteiro;;").append(" em ").append(identificador).append(" mm.;;4$$\n");
        //espitélio escamoso
        sb.append("\n27;;Linha$$\n");
        sb.append("28;;Enumeracao;;").append("Epitélio escamoso ").append(identificador).append(".;;true$$\n");
        // epitelio cilindrico
        sb.append("\n29;;Linha$$\n");
        sb.append("30;;Enumeracao;;").append("Epitélio cilíndrico ").append(identificador).append(".;;true$$\n");
        // ectrópio
        sb.append("\n31;;Linha$$\n");
        sb.append("32;;Enumeracao;;").append("Ectrópio ").append(identificador).append(".;;true$$\n");
        // zona
        sb.append("\n33;;Linha$$\n");
        sb.append("34;;Enumeracao;;").append(identificador).append(";;true$$\n");

        // </editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Colposcopia alargada">

        //campo descrito Colposcopia alargada
        sb.append("\n35;;Topico;;Colposcopia alargada$$\n");
        sb.append("\n36;;Linha$$\n");
        sb.append("37;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Ausência de anormalidades ao uso"
                + " do ácido acético e solução de Schiller.</p>\n");
        sb.append("$$\n");
        sb.append("\n38;;Linha$$\n");
        sb.append("39;;Enumeracao;;$37$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observação do colo">

        //campo descrito Observação do colo
        sb.append("\n40;;Topico;;Observação do colo$$\n");
        sb.append("\n41;;Linha$$\n");
        sb.append("42;;CampoTexto;;\n");
        sb.append("$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Biópsia">

        //campo descrito  Biópsia
        sb.append("\n43;;Topico;;Biópsia$$\n");
        sb.append("\n44;;Linha$$\n");
        sb.append("45;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Não foi realizada.</p>\n");
        sb.append("$$\n");
        sb.append("\n46;;Linha$$\n");
        sb.append("47;;Enumeracao;;$45$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        //campo descrito  Observações gerais
        sb.append("\n48;;Topico;;Observações gerais$$\n");
        sb.append("\n49;;Linha$$\n");
        sb.append("50;;CampoTexto;;\n");
        sb.append("$$\n");
//        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito  Impressão diagnóstica
        sb.append("\n51;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n52;;Linha$$\n");
        sb.append("53;;ImpressaoDiagnostica;;\n");
        sb.append("<p style=\"margin-top: 0\">Achados colposcópicos normais.</p>\n");
        sb.append("$$\n");
        sb.append("\n54;;Linha$$\n");
        sb.append("55;;Enumeracao;;$53CampoTexto$$\n");

        // </editor-fold>

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Metodos">

        sb.append("42;;setObrigatorio;;false$$\n");
        sb.append("50;;setObrigatorio;;false$$\n");

        sb.append("\n2;;adicionarOpcao;;aumento de 3 a 6x;;aumento de 3 a 6$$\n");
        sb.append("2;;adicionarOpcao;;aumento de 6x;;aumento de 6$$\n");
        sb.append("2;;adicionarOpcao;;aumento de 10x;;aumento de 10$$\n");
        sb.append("2;;adicionarOpcao;;aumento de 16x;;aumento de 16$$\n");
        sb.append("2;;adicionarOpcao;;aumento de 25x;;aumento de 25$$\n");
        sb.append("2;;adicionarOpcao;;aumento de 40x;;aumento de 40$$\n");
        sb.append("2;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("2;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("3;;vincularHabAoValorDoCampo;;$2CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");

        sb.append("\n16;;adicionarOpcao;;normal;;Colo de forma cilíndrica,"
                  + " orifício externo de aspecto habitual.</p></p><p style=\"margin-top: 0\">"
                + "Nada foi revelado com a aplicação do ácido acético. Teste de Schiller negativo.$$\n");
        sb.append("16;;adicionarOpcao;;informar;;$$\n");

        sb.append("\n18;;adicionarOpcao;;cilíndrica$$\n");
        sb.append("18;;adicionarOpcao;;plana$$\n");
        sb.append("18;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{informar}$$\n");

        sb.append("\n19;;adicionarOpcao;;anterior$$\n");
        sb.append("19;;adicionarOpcao;;posterior$$\n");
        sb.append("19;;adicionarOpcao;;lateral esquerda$$\n");
        sb.append("19;;adicionarOpcao;;lateral direita$$\n");
        sb.append("19;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{").append("informar}$$\n");

        sb.append("\n21;;adicionarOpcao;;normal$$\n");
        sb.append("21;;adicionarOpcao;;atrófico$$\n");
        sb.append("21;;adicionarOpcao;;hipertrófico$$\n");
        sb.append("21;;adicionarOpcao;;hipotrófico$$\n");
        sb.append("21;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{").append("informar}$$\n");

        sb.append("\n22;;adicionarOpcao;;em fenda$$\n");
        sb.append("22;;adicionarOpcao;;puntiforme$$\n");
        sb.append("22;;adicionarOpcao;;arredondado$$\n");
        sb.append("22;;adicionarOpcao;;disforme$$\n");
        sb.append("22;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{").append("informar}$$\n");

        sb.append("\n24;;adicionarOpcao;;visível$$\n");
        sb.append("24;;adicionarOpcao;;visível total$$\n");
        sb.append("24;;adicionarOpcao;;visível parcial$$\n");
        sb.append("24;;adicionarOpcao;;não visível$$\n");

        sb.append("\n25;;adicionarOpcao;;sobre a exocervice$$\n");
        sb.append("25;;adicionarOpcao;;coincidente com orifício externo$$\n");
        sb.append("25;;adicionarOpcao;;sobre a endocérvice$$\n");
        sb.append("25;;vincularHabAoValorDoCampo;;$24CampoDoLaudo;;false;;{").append("visível|visível total|visível parcial}$$\n");

        sb.append("\n26;;vincularHabAoValorDoCampo;;$24CampoDoLaudo;;false;;{").append("visível|visível total|visível parcial}$$\n");
        sb.append("26;;setZeroDeveSerImpresso;;true$$\n");

        sb.append("\n28;;adicionarOpcao;;original$$\n");
        sb.append("28;;adicionarOpcao;;com linguetas sobre ectrópio$$\n");

        sb.append("\n30;;adicionarOpcao;;normal$$\n");
        sb.append("30;;adicionarOpcao;;ectópico$$\n");

        sb.append("\n32;;adicionarOpcao;;presente$$\n");
        sb.append("32;;adicionarOpcao;;ausente$$\n");

        sb.append("\n34;;adicionarOpcao;;texto normal;;Zona de transformação visualizada, "
                  + "periorificial, entre 0 e -1, de aspecto normal.$$\n");

//        //sb.append("38;;setObrigatorio;;false$$\n");
//
//        // </editor-fold>

        alterarModeloDeLaudo(12);

    }

    static void videoColposcopiaIFCP2011 () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Indicação do exame">

        sb.append("\n0;;Topico;;Indicação do exame$$\n");
        sb.append("\n1;;Linha$$\n");
        sb.append("2;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("3;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vulva">

        sb.append("\n4;;Topico;;Vulva$$\n");
        sb.append("\n5;;Linha$$\n");
        sb.append("6;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        sb.append("7;;CampoTexto;;$$\n");
        sb.append("8;;Linha$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Colo uterino">

        sb.append("\n9;;Topico;;Colo uterino$$\n");

        sb.append("\n10;;Linha;;Visibilidade da junção escamocolunar - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("11;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("12;;Linha$$\n");
        sb.append("13;;CampoTexto;;$$\n");

        sb.append("\n14;;Linha;;Zona de transformação - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("15;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("16;;Linha$$\n");
        sb.append("17;;CampoTexto;;$$\n");

        sb.append("\n18;;Linha;;Epitélio escamoso original - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("19;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("20;;Linha$$\n");
        sb.append("21;;CampoTexto;;$$\n");

        sb.append("\n22;;Linha;;Epitélio colunar - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("23;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("24;;Linha$$\n");
        sb.append("25;;CampoTexto;;$$\n");

        sb.append("\n26;;Linha;;Epitélio escamoso metaplástico - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("27;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("28;;Linha$$\n");
        sb.append("29;;CampoTexto;;$$\n");

        sb.append("\n30;;Linha;;Localização e tamanho da lesão - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("31;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        sb.append("32;;CampoAlfaNumerico;; e de acordo com a posição: ").append(CampoSimples.identificador).append(" hs.$$\n");
        sb.append("33;;CampoInteiro;; ").append(CampoSimples.identificador).append(" quadrantes do colo uterino envolvidos pela lesão;;2$$\n");
        sb.append("34;;CampoInteiro;; em ").append(CampoSimples.identificador).append("% do colo uterino.;;2$$\n");
        sb.append("35;;Linha$$\n");
        sb.append("36;;CampoTexto;;$$\n");

        sb.append("\n37;;Linha;;Grau de lesão - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("38;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("39;;Linha$$\n");
        sb.append("40;;CampoTexto;;$$\n");

        sb.append("\n41;;Linha;;Suspeita de invasão - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("42;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("43;;Linha$$\n");
        sb.append("44;;CampoTexto;;$$\n");

        sb.append("\n45;;Linha;;Biópsia - ").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("46;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        sb.append("47;;Linha$$\n");
        sb.append("48;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vagina">

        sb.append("\n49;;Topico;;Vagina$$\n");

        sb.append("\n50;;Linha;;Epitélio escamoso original - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("51;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("52;;Linha$$\n");
        sb.append("53;;CampoTexto;;$$\n");

        sb.append("\n54;;Linha;;Epitélio acetobranco tênue - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("55;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("56;;Linha$$\n");
        sb.append("57;;CampoTexto;;$$\n");

        sb.append("\n58;;Linha;;Epitélio acetobranco denso - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("59;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("60;;Linha$$\n");
        sb.append("61;;CampoTexto;;$$\n");

        sb.append("\n62;;Linha;;Vasos atípicos - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("63;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("64;;Linha$$\n");
        sb.append("65;;CampoTexto;;$$\n");

        sb.append("\n66;;Linha;;Epitélio colunar - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("67;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("68;;Linha$$\n");
        sb.append("69;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("\n70;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n71;;Linha$$\n");
        sb.append("72;;ImpressaoDiagnostica;;\n");
        sb.append("<p style=\"margin-top: 0\">Achados colposcópicos normais.</p>$$\n");
        sb.append("73;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("74;;Enumeracao;;$72CampoTexto$$\n");

        // </editor-fold>

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Metodos">

        // <editor-fold defaultstate="collapsed" desc="Indicação do exame">

        sb.append("\n2;;adicionarOpcao;;Exame de rotina$$\n");
        sb.append("2;;adicionarOpcao;;Adenoca in situ do colo uterino em biópsia prévia$$\n");
        sb.append("2;;adicionarOpcao;;Citologia - Ascus persistente$$\n");
        sb.append("2;;adicionarOpcao;;Citologia NIC I - HPV$$\n");
        sb.append("2;;adicionarOpcao;;Verrugas de vulva$$\n");
        sb.append("2;;adicionarOpcao;;Citologia sugestiva de ação viral - HPV$$\n");
        sb.append("2;;adicionarOpcao;;Mácula rubra do colo uterino$$\n");
        sb.append("2;;adicionarOpcao;;Citologia - NIC II + HPV$$\n");
        sb.append("2;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("2;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("3;;vincularHabAoValorDoCampo;;$2CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vulva">

        sb.append("\n6;;adicionarOpcao;;Normal;;Vulva revestida por pele e pelos apropriados para a idade. Ausência de anormalidade a vulvoscopia simples com uso do ácido acético a 5%.$$\n");
        sb.append("6;;adicionarOpcao;;Áreas esbranquiçadas;;Presença de área esbranquiçada na face interna dos grandes lábios.$$\n");
        sb.append("6;;adicionarOpcao;;Cândida;;Vulva com pele apresentando maceração com aspecto inflamatório, devido a purino crônico, sugestivo de micose por Cândida.$$\n");
        sb.append("6;;adicionarOpcao;;Condilomatosas;;Presença de lesões condilomatosas pequenas de vestíbulo vulvar.$$\n");
        sb.append("6;;adicionarOpcao;;Herpes;;Presença de lesão sugestiva de Herpes, em fase de pústula.$$\n");
        sb.append("6;;adicionarOpcao;;Vestíbulo vulvar;;Presença de múltiplas lesões acuminados pequenos de vestíbulo vulvar, face interna dos pequenos lábios e periorais.$$\n");
        sb.append("6;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("6;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("7;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Colo uterino">

        sb.append("\n11;;adicionarOpcao;;Parcialmente visível$$\n");
        sb.append("11;;adicionarOpcao;;Completamente visível$$\n");
        sb.append("11;;adicionarOpcao;;Não visível$$\n");
        sb.append("11;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("11;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("13;;vincularHabAoValorDoCampo;;$11CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("12;;setDescrPrimParag;;Visibilidade da junção escamocolunar - $$\n");

        sb.append("\n15;;adicionarOpcao;;Tipo 1;;Tipo 1: localizada no ectocérvix, totalmente visível$$\n");
        sb.append("15;;adicionarOpcao;;Tipo 2;;Tipo 2: com componente endocervical, totalmente visível$$\n");
        sb.append("15;;adicionarOpcao;;Tipo 3;;Tipo 3: com componente endocervical, não totalmente visível$$\n");
        sb.append("15;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("15;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("17;;vincularHabAoValorDoCampo;;$15CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("16;;setDescrPrimParag;;Zona de transformação - $$\n");

        sb.append("\n19;;adicionarOpcao;;Maduro$$\n");
        sb.append("19;;adicionarOpcao;;Atrófico$$\n");
        sb.append("19;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("19;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("21;;vincularHabAoValorDoCampo;;$19CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("20;;setDescrPrimParag;;Epitélio escamoso original - $$\n");

        sb.append("\n23;;adicionarOpcao;;Ectopia$$\n");
        sb.append("23;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("23;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("25;;vincularHabAoValorDoCampo;;$23CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("24;;setDescrPrimParag;;Epitélio colunar - $$\n");

        sb.append("\n27;;adicionarOpcao;;Cistos de Naboth$$\n");
        sb.append("27;;adicionarOpcao;;Orifícios (abertos), Deciduose na gravidez$$\n");
        sb.append("27;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("27;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("29;;vincularHabAoValorDoCampo;;$27CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("28;;setDescrPrimParag;;Epitélio escamoso metaplástico - $$\n");

        sb.append("31;;adicionarOpcao;;Dentro da ZT$$\n");
        sb.append("31;;adicionarOpcao;;Fora da ZT$$\n");
        sb.append("31;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("31;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("32;;vincularHabAoValorDoCampo;;$31CampoDoLaudo;;false;;{Dentro da ZT|Fora da ZT}$$\n");
        sb.append("33;;vincularHabAoValorDoCampo;;$31CampoDoLaudo;;false;;{Dentro da ZT|Fora da ZT}$$\n");
        sb.append("34;;vincularHabAoValorDoCampo;;$31CampoDoLaudo;;false;;{Dentro da ZT|Fora da ZT}$$\n");

        sb.append("36;;vincularHabAoValorDoCampo;;$31CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("35;;setDescrPrimParag;;Localização e tamanho da lesão - $$\n");

        sb.append("\n38;;adicionarOpcao;;Mosaico Fino;;Grau 1, Epitélio acetobranco tênue, de borda irregular ou geográfica. Mosaico fino$$\n");
        sb.append("38;;adicionarOpcao;;Pontilhado fino;;Grau 1, Epitélio acetobranco tênue, de borda irregular ou geográfica. Pontilhado fino$$\n");
        sb.append("38;;adicionarOpcao;;Mosaico grosseiro;;Grau 2, Epitélio acetobranco denso. Acetobranqueamento de aparecimento rápido. Orifícios glandulares espessados. Mosaico grosseiro$$\n");
        sb.append("38;;adicionarOpcao;;Pontilhado grosseiro;;Grau 2, Epitélio acetobranco denso. Acetobranqueamento de aparecimento rápido. Orifícios glandulares espessados. Pontilhado grosseiro$$\n");
        sb.append("38;;adicionarOpcao;;Leucoplasia (hiperqueratose);;Leucoplasia (hiperqueratose)$$\n");
        sb.append("38;;adicionarOpcao;;Leucoplasia (queratose);;Leucoplasia (queratose)$$\n");
        sb.append("38;;adicionarOpcao;;Schiller negativo;;Teste de Schiller negativo$$\n");
        sb.append("38;;adicionarOpcao;;Schiller positivo;;Teste de Schiller positivo$$\n");
        sb.append("38;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("38;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("40;;vincularHabAoValorDoCampo;;$38CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("39;;setDescrPrimParag;;Grau de lesão - $$\n");

        sb.append("\n42;;adicionarOpcao;;Lesão exofítica;;Vasos atípicos: lesão exofítica$$\n");
        sb.append("42;;adicionarOpcao;;Frágeis;;Vasos atípicos: frágeis$$\n");
        sb.append("42;;adicionarOpcao;;Superfície irregular;;Vasos atípicos: superfície irregular$$\n");
        sb.append("42;;adicionarOpcao;;Necrose;;Vasos atípicos: necrose$$\n");
        sb.append("42;;adicionarOpcao;;Neoplasia tumoral/grosseira;;Vasos atípicos: neoplasia tumoral/grosseira$$\n");
        sb.append("42;;adicionarOpcao;;Ulceração (necrótica);;Vasos atípicos: ulceração (necrótica)$$\n");
        sb.append("42;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("42;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("44;;vincularHabAoValorDoCampo;;$42CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("43;;setDescrPrimParag;;Suspeita de invasão - $$\n");

        sb.append("46;;adicionarOpcao;;Não realizada$$\n");
        sb.append("46;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("46;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("48;;vincularHabAoValorDoCampo;;$46CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("47;;setDescrPrimParag;;Biópsia - $$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vagina">

        sb.append("\n51;;adicionarOpcao;;Maduro$$\n");
        sb.append("51;;adicionarOpcao;;Atrófico$$\n");
        sb.append("51;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("51;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("53;;vincularHabAoValorDoCampo;;$51CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("52;;setDescrPrimParag;;Epitélio escamoso original - $$\n");

        sb.append("\n55;;adicionarOpcao;;Pontilhado fino$$\n");
        sb.append("55;;adicionarOpcao;;Mosaico fino$$\n");
        sb.append("55;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("55;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("57;;vincularHabAoValorDoCampo;;$55CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("56;;setDescrPrimParag;;Epitélio acetobranco tênue - $$\n");

        sb.append("\n59;;adicionarOpcao;;Pontilhado grosseiro$$\n");
        sb.append("59;;adicionarOpcao;;Mosaico grosseiro$$\n");
        sb.append("59;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("59;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("61;;vincularHabAoValorDoCampo;;$59CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("60;;setDescrPrimParag;;Epitélio acetobranco denso - $$\n");

        sb.append("\n63;;adicionarOpcao;;Lesão exofítica$$\n");
        sb.append("63;;adicionarOpcao;;Necrose$$\n");
        sb.append("63;;adicionarOpcao;;Neoplasia;;Neoplasia tumoral / grosseira$$\n");
        sb.append("63;;adicionarOpcao;;Ulceração;; Ulceração (necrótica)$$\n");
        sb.append("63;;adicionarOpcao;;Vasos frágeis$$\n");
        sb.append("63;;adicionarOpcao;;Vasos irregulares$$\n");
        sb.append("63;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("63;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("65;;vincularHabAoValorDoCampo;;$63CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("64;;setDescrPrimParag;;Vasos atípicos - $$\n");

        sb.append("\n67;;adicionarOpcao;;Teste de Schiller positivo$$\n");
        sb.append("67;;adicionarOpcao;;Teste de Schiller negativo$$\n");
        sb.append("67;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("67;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("69;;vincularHabAoValorDoCampo;;$67CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("68;;setDescrPrimParag;;Epitélio colunar - $$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressão diagnóstica">

        sb.append("\n74;;adicionarOpcao;;Cisto;;Cisto.$$\n");
        sb.append("\n74;;adicionarOpcao;;Condiloma;;Condiloma.$$\n");
        sb.append("\n74;;adicionarOpcao;;Endometriose;;Endometriose.$$\n");
        sb.append("\n74;;adicionarOpcao;;Erosão;;Erosão (traumática).$$\n");
        sb.append("\n74;;adicionarOpcao;;Estenose vaginal;;Estenose vaginal.$$\n");
        sb.append("\n74;;adicionarOpcao;;Inflamação;;Inflamação.$$\n");
        sb.append("\n74;;adicionarOpcao;;Pólipo;;Pólipo.$$\n");

        // </editor-fold>

        // </editor-fold>

        alterarModeloDeLaudo(26);

    }

    static void videoColposcopiaIFCP2011Revisado () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Indicação do exame">

        sb.append("\n0;;Topico;;Indicação do exame$$\n");
        sb.append("\n1;;Linha$$\n");
        sb.append("2;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("3;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vulvoscopia">

        sb.append("\n4;;Topico;;Vulvoscopia$$\n");
        sb.append("\n5;;Linha$$\n");
        sb.append("6;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        sb.append("7;;CampoAlfaNumerico;;: ").append(CampoSimples.identificador).append(".$$\n");
        sb.append("8;;CampoTexto;;$$\n");
        sb.append("9;;Linha$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vagina">

        sb.append("\n10;;Topico;;Vagina$$\n");
        sb.append("\n11;;Linha$$\n");
        sb.append("12;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        sb.append("13;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Cervicoscopia">

        sb.append("\n14;;Topico;;Cervicoscopia$$\n");

        sb.append("\n15;;Linha;;Visibilidade da JEC - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("16;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("17;;Linha$$\n");
        sb.append("18;;CampoTexto;;$$\n");

        sb.append("\n19;;Linha;;Localização da JEC: ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("20;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("21;;Linha$$\n");
        sb.append("22;;CampoTexto;;$$\n");

        sb.append("\n23;;Linha;;Zona de transformação - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("24;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("25;;Linha$$\n");
        sb.append("26;;CampoTexto;;$$\n");

        sb.append("\n27;;Linha;;Localização e tamanho da lesão - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("28;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("29;;Linha$$\n");
        sb.append("30;;CampoAlfaNumerico;;Posição em horas: ").append(CampoSimples.identificador).append(".$$\n");
        sb.append("31;;Linha$$\n");
        sb.append("32;;CampoInteiro;;Lesão de ").append(CampoSimples.identificador).append("% do colo uterino.;;2$$\n");
        sb.append("33;;Linha$$\n");
        sb.append("34;;CampoInteiro;;Nr de quadrantes envolvidos: ").append(CampoSimples.identificador).append(".;;2$$\n");
        sb.append("35;;Linha$$\n");
        sb.append("36;;CampoTexto;;$$\n");

        sb.append("\n37;;Linha;;Grau de lesão - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("38;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("39;;Linha$$\n");
        sb.append("40;;CampoTexto;;$$\n");

        sb.append("\n41;;Linha;;Achados anormais - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("42;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("43;;Linha$$\n");
        sb.append("44;;CampoTexto;;$$\n");

        sb.append("\n45;;Linha;;Captação do Lugol - ").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("46;;Enumeracao;;").append(CampoSimples.identificador).append(".;;true$$\n");
        sb.append("47;;Linha$$\n");
        sb.append("48;;CampoTexto;;$$\n");

        sb.append("\n49;;Linha;;Biópsia - ").append(Linha.TEXTO_CAMPOS_FILHOS).append(".$$\n");
        sb.append("50;;Enumeracao;;").append(CampoSimples.identificador).append(";;true$$\n");
        sb.append("51;;Linha$$\n");
        sb.append("52;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("\n53;;Topico;;Observações$$\n");
        sb.append("\n54;;Linha$$\n");
        sb.append("55;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("\n56;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n57;;Linha$$\n");
        sb.append("58;;ImpressaoDiagnostica;;\n");
        sb.append("<p style=\"margin-top: 0\">Achados colposcópicos normais.</p>$$\n");
        sb.append("59;;Linha;;").append(Linha.TEXTO_CAMPOS_FILHOS).append("$$\n");
        sb.append("60;;Enumeracao;;$58CampoTexto$$\n");

        // </editor-fold>

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Metodos">

        // <editor-fold defaultstate="collapsed" desc="Indicação do exame">

        sb.append("\n2;;adicionarOpcao;;Exame de rotina$$\n");
        sb.append("2;;adicionarOpcao;;Adenoca in situ do colo uterino em biópsia prévia$$\n");
        sb.append("2;;adicionarOpcao;;Citologia – ASC-US persistente$$\n");
        sb.append("2;;adicionarOpcao;;Citologia-LIEBG$$\n");
        sb.append("2;;adicionarOpcao;;Verrugas de vulva$$\n");
        sb.append("2;;adicionarOpcao;;Citologia sugestiva de ação viral – HPV$$\n");
        sb.append("2;;adicionarOpcao;;Ectrópio sangrante$$\n");
        sb.append("2;;adicionarOpcao;;Citologia-ASC-H$$\n");
        sb.append("2;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("2;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("3;;vincularHabAoValorDoCampo;;$2CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vulvoscopia">

        sb.append("\n6;;adicionarOpcao;;Normal;;Vulva revestida por pele e pelos apropriados para a idade. Ausência de anormalidades.$$\n");
        sb.append("6;;adicionarOpcao;;Área(s) esbranquiçada(s)$$\n");
        sb.append("6;;adicionarOpcao;;Aspecto de candidíase;;Aspecto de candidíase.$$\n");
        sb.append("6;;adicionarOpcao;;Condilomatosas;;Presença de lesões condilomatosas pequenas de vestíbulo vulvar.$$\n");
        sb.append("6;;adicionarOpcao;;Aspecto de herpes;;Presença de lesão sugestiva de Herpes, em fase de pústula.$$\n");
        sb.append("6;;adicionarOpcao;;Vestíbulo vulvar;;Presença de múltiplas lesões acuminados pequenos de vestíbulo vulvar, face interna dos pequenos lábios e periorais.$$\n");
        sb.append("6;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("6;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("8;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("7;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{Área(s) esbranquiçada(s)}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Vagina">

        sb.append("\n12;;adicionarOpcao;;Vagina apresentando revestimento epitelial normal;;Vagina apresentando revestimento epitelial normal.$$\n");
        sb.append("12;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("12;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("13;;vincularHabAoValorDoCampo;;$12CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Cervicoscopia">

        sb.append("16;;adicionarOpcao;;Completamente visível$$\n");
        sb.append("16;;adicionarOpcao;;Parcialmente visível$$\n");
        sb.append("16;;adicionarOpcao;;Não visível$$\n");
        sb.append("16;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("16;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("18;;vincularHabAoValorDoCampo;;$16CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("17;;setDescrPrimParag;;Visibilidade da junção escamocolunar - $$\n");

        sb.append("\n24;;adicionarOpcao;;Tipo 1;;Tipo 1: localizada no ectocérvix, totalmente visível$$\n");
        sb.append("24;;adicionarOpcao;;Tipo 2;;Tipo 2: com componente endocervical, totalmente visível$$\n");
        sb.append("24;;adicionarOpcao;;Tipo 3;;Tipo 3: com componente endocervical, não totalmente visível$$\n");
        sb.append("24;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("24;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("26;;vincularHabAoValorDoCampo;;$24CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("25;;setDescrPrimParag;;Zona de transformação - $$\n");

        sb.append("28;;adicionarOpcao;;Não possui lesão$$\n");
        sb.append("28;;adicionarOpcao;;Dentro da ZT$$\n");
        sb.append("28;;adicionarOpcao;;Fora da ZT$$\n");
        sb.append("28;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("28;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("30;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{Dentro da ZT|Fora da ZT}$$\n");
        sb.append("34;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{Dentro da ZT|Fora da ZT}$$\n");
        sb.append("32;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{Dentro da ZT|Fora da ZT}$$\n");

        sb.append("36;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("35;;setDescrPrimParag;;Localização e tamanho da lesão - $$\n");

        sb.append("20;;adicionarOpcao;;JEC 0;;JEC 0 (Exatamente no orifício externo (anatômico) do canal cervical)$$\n");
        sb.append("20;;adicionarOpcao;;JEC +1;;JEC +1 (Pouco acima de JEC 0, dentro do canal)$$\n");
        sb.append("20;;adicionarOpcao;;JEC +2;;JEC +2 (Entre JEC +1 até a quarta parte da altura do canal)$$\n");
        sb.append("20;;adicionarOpcao;;JEC +3;;JEC +3 (Entre JEC +2 e a metade da altura do canal)$$\n");
        sb.append("20;;adicionarOpcao;;JEC +4;;JEC +4 (Na metade superior do canal cervical)$$\n");
        sb.append("20;;adicionarOpcao;;JEC -1;;JEC -1 (Pouco abaixo de JEC 0)$$\n");
        sb.append("20;;adicionarOpcao;;JEC -2;;JEC -2 (Entre JEC –1 e a quarta parte da distância entre o orifício externo e o fundo de saco vaginal)$$\n");
        sb.append("20;;adicionarOpcao;;JEC -3;;JEC -3 (Entre JEC –2 até a metade da distância entre o orifício externo e o fundo de saco vaginal)$$\n");
        sb.append("20;;adicionarOpcao;;JEC -4;;JEC -4 (De JEC –3 até o fundo de saco vaginal)$$\n");
        sb.append("20;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("20;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("22;;vincularHabAoValorDoCampo;;$20CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("21;;setDescrPrimParag;;Localização e tamanho da lesão - $$\n");

        sb.append("37;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{Dentro da ZT|Fora da ZT|" + CampoSimples.DIGITAR + "|"+ Enumeracao.NAO_IMPRIMIR + "}$$\n");
        sb.append("\n38;;adicionarOpcao;;Epitélio acetobranco fino$$\n");
        sb.append("38;;adicionarOpcao;;De borda irregular ou geográfica$$\n");
        sb.append("38;;adicionarOpcao;;Mosaico fino$$\n");
        sb.append("38;;adicionarOpcao;;Pontilhado fino$$\n");
        sb.append("38;;adicionarOpcao;;Epitélio acetobranco denso$$\n");
        sb.append("38;;adicionarOpcao;;Acetobranqueamento de aparecimento rápido$$\n");
        sb.append("38;;adicionarOpcao;;Orifícios glandulares espessados$$\n");
        sb.append("38;;adicionarOpcao;;Mosaico grosseiro$$\n");
        sb.append("38;;adicionarOpcao;;Pontilhado grosseiro$$\n");
        sb.append("38;;adicionarOpcao;;Margem demarcada$$\n");
        sb.append("38;;adicionarOpcao;;Sinal da margem interna$$\n");
        sb.append("38;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("38;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("40;;vincularHabAoValorDoCampo;;$38CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("39;;setDescrPrimParag;;Grau de lesão - $$\n");

        sb.append("42;;adicionarOpcao;;Leucoplasia (queratose)$$\n");
        sb.append("42;;adicionarOpcao;;Leucoplasia (hiperqueratose)$$\n");
        sb.append("42;;adicionarOpcao;;Erosão$$\n");
        sb.append("42;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("42;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("44;;vincularHabAoValorDoCampo;;$42CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("43;;setDescrPrimParag;;Achados anormais - $$\n");

        sb.append("46;;adicionarOpcao;;Iodo negativo$$\n");
        sb.append("46;;adicionarOpcao;;Iodo positivo$$\n");
        sb.append("46;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("46;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("48;;vincularHabAoValorDoCampo;;$46CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("47;;setDescrPrimParag;;Captação do Lugol - $$\n");

        sb.append("50;;adicionarOpcao;;Não realizada$$\n");
        sb.append("50;;adicionarOpcao;;Foi realizada biópsia do colo uterino na área de epitélio aceto branco$$\n");
        sb.append("50;;adicionarOpcao;;Foi realizada biópsia do colo uterino na área iodo negativo$$\n");
        sb.append("50;;adicionarOpcao;;" + CampoSimples.DIGITAR + ";;$$\n");
        sb.append("50;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("52;;vincularHabAoValorDoCampo;;$50CampoDoLaudo;;false;;{" + CampoSimples.DIGITAR + "}$$\n");
        sb.append("51;;setDescrPrimParag;;Biópsia - $$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressão diagnóstica">

        sb.append("\n60;;adicionarOpcao;;Colposcopia negativa, porém insatisfatória;;Colposcopia negativa, porém insatisfatória.$$\n");
        sb.append("\n60;;adicionarOpcao;;Colposcopia inadequada;;Colposcopia inadequada.$$\n");
        sb.append("\n60;;adicionarOpcao;;Epitélio Aceto Branco no colo uterino;;Epitélio Aceto Branco no colo uterino.$$\n");
        sb.append("\n60;;adicionarOpcao;;Área iodo negativo no colo uterino;;Área iodo negativo no colo uterino.$$\n");

        // </editor-fold>

        sb.append("55;;setObrigatorio;;false$$\n");

        // </editor-fold>

        alterarModeloDeLaudo(30);

    }

    static void tireoide () throws Exception
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

        // <editor-fold defaultstate="collapsed" desc="Pele">

        sb.append("\n4;;Topico;;Pele$$\n");
        sb.append("\n5;;Linha$$\n");
        sb.append("6;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Lisa, regular e de espessura normal.</p>");
        sb.append("$$\n");
        sb.append("\n7;;Linha$$\n");
        sb.append("8;;Enumeracao;;$6$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Músculos pré-tireoidianos">

        sb.append("\n9;;Topico;;Músculos pré-tireoidianos$$\n");
        sb.append("\n10;;Linha$$\n");
        sb.append("11;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">De textura homogênea e sem alterações acústicas.</p>\n");
        sb.append("$$\n");
        sb.append("\n12;;Linha$$\n");
        sb.append("13;;Enumeracao;;$11$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Carótidas">

        sb.append("\n14;;Topico;;Carótidas$$\n");
        sb.append("\n15;;Linha$$\n");
        sb.append("16;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Com calibre e pulsatilidades normais.</p>");
        sb.append("<p style=\"margin-top: 0\">Paredes ecogênicas, lisas e conteúdo anecoico.</p>\n");
        sb.append("$$\n");
        sb.append("\n17;;Linha$$\n");
        sb.append("18;;Enumeracao;;$16$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tireoide">

        // <editor-fold defaultstate="collapsed" desc="Tireoide">
        //campo descrito pele
        sb.append("\n19;;Topico;;Tireoide$$\n");
        sb.append("\n20;;Linha$$\n");
        sb.append("21;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">De topografia habitual, com"
                + " contornos regulares e limites precisos.</p>\n");
        sb.append("$$\n");
        sb.append("\n22;;Linha$$\n");
        sb.append("23;;Enumeracao;;$21$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Lobo Direito">

        sb.append("\n24;;Linha$$\n");
        sb.append("\n25;;Linha;;-Lobo Direito: " + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("26;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Parênquima homogêneo, ausência de"
                + " nódulos, cistos ou calcificações.</p>\n");
        sb.append("$$\n");
        sb.append("27;;Enumeracao;;$26$$\n");
        sb.append("\n28;;Linha$$\n");
        sb.append("29;;CampoDouble;;Medidas do lobo direito: Long.: " + identificador + ";;2$$\n");
        //anterior pos
        sb.append("30;;CampoDouble;; x A.P.: " + identificador + ";;2$$\n");
        //transversal
        sb.append("31;;CampoDouble;; x Transv.: " + identificador + " cm;;2$$\n");
        //volume
        sb.append("32;;CampoRpn;;C1 C2 C3 @").append(StaticInfo.FATOR_VOL_DIVERSOS).append("@ * * *;;");
        sb.append(", com volume de " + identificador + " cm³.;;");
        sb.append("3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Lobo Esquerdo">

        sb.append("\n33;;Linha$$\n");
        sb.append("\n34;;Linha;;-Lobo Esquerdo: " + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("35;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Parênquima homogêneo, ausência "
                + "de nódulos, cistos ou calcificações.</p>\n");
        sb.append("$$\n");
        sb.append("36;;Enumeracao;;$35$$\n");
        sb.append("\n37;;Linha$$\n");
        sb.append("38;;CampoDouble;;Medidas do lobo esquerdo: Long.: " + identificador + ";;2$$\n");
        //anterior pos
        sb.append("39;;CampoDouble;; x A.P.: " + identificador + ";;2$$\n");
        //transversal
        sb.append("40;;CampoDouble;; x Transv.: " + identificador + " cm;;2$$\n");
        //volume
        sb.append("41;;CampoRpn;;C1 C2 C3 @").append(StaticInfo.FATOR_VOL_DIVERSOS).append("@ * * *;;");
        sb.append(", com volume de " + identificador + " cm³.;;");
        sb.append("3$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Istmo">

        sb.append("\n42;;Linha$$\n");
        sb.append("\n43;;Linha;;-Istmo: " + Linha.TEXTO_CAMPOS_FILHOS + "$$\n");
        sb.append("44;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Parênquima homogêneo, "
                + "ausência de nódulos, cistos ou calcificações.</p>\n");
        sb.append("$$\n");
        sb.append("45;;Enumeracao;;$44$$\n");
        sb.append("\n46;;Linha$$\n");
        sb.append("47;;CampoDouble;;Medidas do istmo: Long.: " + identificador + ";;2$$\n");
        //anterior pos
        sb.append("48;;CampoDouble;; x A.P.: " + identificador + ";;2$$\n");
        //transversal
        sb.append("49;;CampoDouble;; x Transv.: " + identificador + " cm;;2$$\n");
        //volume
        sb.append("50;;CampoRpn;;C1 C2 C3 @").append(StaticInfo.FATOR_VOL_DIVERSOS).append("@ * * *;;");
        sb.append(", com volume de " + identificador + " cm³.;;");
        sb.append("3$$\n");

        sb.append("\n51;;Linha$$\n");
        sb.append("\n52;;Linha$$\n");
        sb.append("53;;CampoRpn;;C1 C2 C3 + +;;<b>-VOLUME TOTAL DA TIREÓIDE: ");
        sb.append(identificador + " cm³.</b>;;");
        sb.append("3$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("\n54;;Topico;;Observações gerais$$\n");
        sb.append("\n55;;Linha$$\n");
        sb.append("56;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("\n57;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n58;;Linha$$\n");
        sb.append("\n59;;ImpressaoDiagnostica;;\n");
        sb.append("<p style=\"margin-top: 0\">Glândula tireoide de "
                + "características ecográficas dentro da normalidade.</p>\n");
        sb.append("$$\n");
        sb.append("\n60;;Linha$$\n");
        sb.append("61;;Enumeracao;;$59CampoTexto$$\n");

        sb.append("\n62;;Linha$$\n");
        sb.append("\n63;;Linha$$\n");
        sb.append("64;;Label;;<p style=\"margin-top: 0\"><font size=\"2\">Referências</font></p>" +
"<p style=\"margin-top: 0\"><font size=\"2\">0 a 5 anos: 0 a 2 cm³&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;11 anos: 5,7 a 10,9 cm³</font></p>\n" +
"<p style=\"margin-top: 0\"><font size=\"2\">7 anos: 2,79 a 5,89 cm³&nbsp;&nbsp;&nbsp;&nbsp;12 anos: 5,81 a 11,61 cm³</font></p>\n" +
"<p style=\"margin-top: 0\"><font size=\"2\">8 anos: 3,05 a 6,99 cm³&nbsp;&nbsp;&nbsp;&nbsp;13 anos: 6,35 a 12,99 cm³</font></p>\n" +
"<p style=\"margin-top: 0\"><font size=\"2\">9 anos: 3,64 a 7,64 cm³&nbsp;&nbsp;&nbsp;&nbsp;14 anos: 7,66 a 15,86 cm³</font></p>\n" +
"<p style=\"margin-top: 0\"><font size=\"2\">10 anos: 4,21 a 9,61 cm³&nbsp;&nbsp;&nbsp;&nbsp;Maior de 15 anos: 8,4 a 14,6 cm³</font></p>\n$$\n");

        // </editor-fold>

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Metodos">

        sb.append("\n2;;adicionarOpcao;;convexo$$\n");
        sb.append("2;;adicionarOpcao;;linear$$\n");
        sb.append("2;;adicionarOpcao;;endocavitário$$\n");
        sb.append("2;;adicionarOpcao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("3;;vincularHabAoValorDoCampo;;$2CampoDoLaudo;;false;;{CampoSimples."+CampoSimples.DIGITAR+"}$$\n");

        sb.append("29;;setObrigatorio;;false$$\n");
        sb.append("30;;setObrigatorio;;false$$\n");
        sb.append("31;;setObrigatorio;;false$$\n");

        sb.append("29;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$30CampoDoLaudo|$31CampoDoLaudo}$$\n");
        sb.append("29;;setMsgErroValidCampoObrig;;Termine de informar as medidas do lobo direito.$$\n");
        sb.append("30;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$29CampoDoLaudo|$31CampoDoLaudo}$$\n");
        sb.append("30;;setMsgErroValidCampoObrig;;Termine de informar as medidas do lobo direito.$$\n");
        sb.append("31;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$29CampoDoLaudo|$30CampoDoLaudo}$$\n");
        sb.append("31;;setMsgErroValidCampoObrig;;Termine de informar as medidas do lobo direito.$$\n");

        sb.append("\n25;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$29CampoDoLaudo|$30CampoDoLaudo|$31CampoDoLaudo}$$\n");
        sb.append("\n25;;setMsgErroValidCampoObrig;;Foi colocada alguma medida para o lobo direito e nenhum texto para este.$$\n");
        sb.append("\n25;;setTipoValidObrig;;").append(CampoDoLaudo.POR_HTML).append("$$\n");

        sb.append("38;;setObrigatorio;;false$$\n");
        sb.append("39;;setObrigatorio;;false$$\n");
        sb.append("40;;setObrigatorio;;false$$\n");

        sb.append("38;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$39CampoDoLaudo|$40CampoDoLaudo}$$\n");
        sb.append("38;;setMsgErroValidCampoObrig;;Termine de informar as medidas do lobo esquerdo.$$\n");
        sb.append("39;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$38CampoDoLaudo|$40CampoDoLaudo}$$\n");
        sb.append("39;;setMsgErroValidCampoObrig;;Termine de informar as medidas do lobo esquerdo.$$\n");
        sb.append("40;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$38CampoDoLaudo|$39CampoDoLaudo}$$\n");
        sb.append("40;;setMsgErroValidCampoObrig;;Termine de informar as medidas do lobo esquerdo.$$\n");

        sb.append("\n34;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$38CampoDoLaudo|$39CampoDoLaudo|$40CampoDoLaudo}$$\n");
        sb.append("\n34;;setMsgErroValidCampoObrig;;Foi colocada alguma medida para o lobo esquerdo e nenhum texto para este.$$\n");
        sb.append("\n34;;setTipoValidObrig;;").append(CampoDoLaudo.POR_HTML).append("$$\n");

        sb.append("47;;setObrigatorio;;false$$\n");
        sb.append("48;;setObrigatorio;;false$$\n");
        sb.append("49;;setObrigatorio;;false$$\n");

        sb.append("47;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$48CampoDoLaudo|$49CampoDoLaudo}$$\n");
        sb.append("47;;setMsgErroValidCampoObrig;;Termine de informar as medidas do istmo.$$\n");
        sb.append("48;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$47CampoDoLaudo|$49CampoDoLaudo}$$\n");
        sb.append("48;;setMsgErroValidCampoObrig;;Termine de informar as medidas do istmo.$$\n");
        sb.append("49;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$47CampoDoLaudo|$48CampoDoLaudo}$$\n");
        sb.append("49;;setMsgErroValidCampoObrig;;Termine de informar as medidas do istmo.$$\n");

        sb.append("\n43;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$47CampoDoLaudo|$48CampoDoLaudo|$49CampoDoLaudo}$$\n");
        sb.append("\n43;;setMsgErroValidCampoObrig;;Foi colocada alguma medida para o istmo e nenhum texto para este.$$\n");
        sb.append("\n43;;setTipoValidObrig;;").append(CampoDoLaudo.POR_HTML).append("$$\n");

        sb.append("32;;cadastrarParametroFormula;;$29CampoNumero$$\n");
        sb.append("32;;cadastrarParametroFormula;;$30CampoNumero$$\n");
        sb.append("32;;cadastrarParametroFormula;;$31CampoNumero$$\n");

        sb.append("41;;cadastrarParametroFormula;;$38CampoNumero$$\n");
        sb.append("41;;cadastrarParametroFormula;;$39CampoNumero$$\n");
        sb.append("41;;cadastrarParametroFormula;;$40CampoNumero$$\n");

        sb.append("50;;cadastrarParametroFormula;;$47CampoNumero$$\n");
        sb.append("50;;cadastrarParametroFormula;;$48CampoNumero$$\n");
        sb.append("50;;cadastrarParametroFormula;;$49CampoNumero$$\n");

        sb.append("53;;cadastrarParametroFormula;;$32CampoNumero$$\n");
        sb.append("53;;cadastrarParametroFormula;;$41CampoNumero$$\n");
        sb.append("53;;cadastrarParametroFormula;;$50CampoNumero$$\n");

        sb.append("51;;setHtmlDaProleEhObrigatorio;;false$$\n");
        sb.append("62;;setHtmlDaProleEhObrigatorio;;false$$\n");

        sb.append("56;;setObrigatorio;;false$$\n");

        // </editor-fold>

        alterarModeloDeLaudo(19);

    }

    static void transfontanelaCranio  () throws Exception
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

        // <editor-fold defaultstate="collapsed" desc="Estruturas do Eco Médio">

        sb.append("\n4;;Topico;;Estruturas do eco médio$$\n");
        sb.append("\n5;;Linha$$\n");
        sb.append("6;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Centradas.</p>\n");
        sb.append("$$\n");
        sb.append("\n7;;Linha$$\n");
        sb.append("8;;Enumeracao;;$6$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Parênquima Cerebral">

        sb.append("\n9;;Topico;;Parênquima cerebral$$\n");
        sb.append("\n10;;Linha$$\n");
        sb.append("11;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Homogêneo com circunvoluções "
                + "próprias para a idade e com vasos pulsáteis no seu interior.</p>\n");
        sb.append("$$\n");
        sb.append("\n12;;Linha$$\n");
        sb.append("13;;Enumeracao;;$11$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Tálamo">

        sb.append("\n14;;Topico;;Tálamo$$\n");
        sb.append("\n15;;Linha$$\n");
        sb.append("16;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Com parênquima homogêneo.</p>");
        sb.append("$$\n");
        sb.append("\n17;;Linha$$\n");
        sb.append("18;;Enumeracao;;$16$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Núcleos da Base">

        sb.append("\n19;;Topico;;Núcleos da base$$\n");
        sb.append("\n20;;Linha$$\n");
        sb.append("21;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Com parênquima homogêneo, "
                + "localizações e tamanhos normais.</p>");
        sb.append("$$\n");
        sb.append("\n22;;Linha$$\n");
        sb.append("23;;Enumeracao;;$21$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ventrículos">

        sb.append("\n24;;Topico;;Ventrículos$$\n");
        sb.append("\n25;;Linha$$\n");
        sb.append("26;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Com dimensões e formas anatômicas,"
                + " conteúdo anecoico e paredes lisas.</p>");
        sb.append("$$\n");
        sb.append("\n27;;Linha$$\n");
        sb.append("28;;Enumeracao;;$26$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Plexos Coroides">

        sb.append("\n29;;Topico;;Plexos coroides$$\n");
        sb.append("\n30;;Linha$$\n");
        sb.append("31;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Com dimensões e localizações anatômicas.</p>");
        sb.append("$$\n");
        sb.append("\n32;;Linha$$\n");
        sb.append("33;;Enumeracao;;$31$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Fossa Posterior">

        sb.append("\n34;;Topico;;Fossa posterior$$\n");
        sb.append("\n35;;Linha$$\n");
        sb.append("36;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Com estruturas preservadas.</p>");
        sb.append("$$\n");
        sb.append("\n37;;Linha$$\n");
        sb.append("38;;Enumeracao;;$36$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Espaço Subdural">

        sb.append("\n39;;Topico;;Espaço subdural$$\n");
        sb.append("\n40;;Linha$$\n");
        sb.append("41;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Sem coleções.</p>");
        sb.append("$$\n");
        sb.append("\n42;;Linha$$\n");
        sb.append("43;;Enumeracao;;$41$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("\n44;;Topico;;Observações gerais$$\n");
        sb.append("\n45;;Linha$$\n");
        sb.append("46;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("\n47;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n48;;Linha$$\n");
        sb.append("\n49;;ImpressaoDiagnostica;;\n");
        sb.append("<p style=\"margin-top: 0\">Cérebro acusticamente normal.</p>\n");
        sb.append("$$\n");
        sb.append("\n50;;Linha$$\n");
        sb.append("51;;Enumeracao;;$49CampoTexto$$\n");

        // </editor-fold>

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Metodos">

        sb.append("46;;setObrigatorio;;false$$\n");

        sb.append("\n2;;adicionarOpcao;;convexo$$\n");
        sb.append("2;;adicionarOpcao;;linear$$\n");
        sb.append("2;;adicionarOpcao;;endocavitário$$\n");
        sb.append("2;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("2;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("3;;vincularHabAoValorDoCampo;;$2CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        alterarModeloDeLaudo(20);

    }

    static void rinsAparelhoUrinarioMasc  () throws Exception
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

        // <editor-fold defaultstate="collapsed" desc="Rins">

        // <editor-fold defaultstate="collapsed" desc="Rim direito">

        sb.append("\n4;;Topico;;Rim direito$$\n");
        //descrição
        sb.append("\n5;;Linha$$\n");
        sb.append("6;;Enumeracao;;").append(identificador).append(";;true$$\n");
        sb.append("7;;Enumeracao;;").append(", ").append(identificador).append("$$\n");
        sb.append("8;;Enumeracao;;").append(", apresentando volume ").append(identificador).append("$$\n");
        sb.append("9;;Enumeracao;;").append(" e contorno ").append(identificador).append(".$$\n");
        sb.append("\n10;;Linha$$\n");
        sb.append("11;;Enumeracao;;").append("Textura do parênquima: ").append(identificador).append(".$$\n");
        sb.append("\n12;;Linha$$\n");
        sb.append("13;;Enumeracao;;").append("Seio renal ").append(identificador).append(".$$\n");
        sb.append("\n14;;Linha$$\n");
        sb.append("15;;Enumeracao;;").append("Hidronefrose: ").append(identificador).append(".$$\n");
        //long
        sb.append("\n16;;Linha$$\n");
        sb.append("17;;CampoDouble;;Medidas: Long.: " + identificador + ";;2$$\n");
        //anterior pos
        sb.append("18;;CampoDouble;; x Ant. Post.: " + identificador + ";;2$$\n");
        //transversal
        sb.append("19;;CampoDouble;; x Trans.: " + identificador + " cm.;;2$$\n");
        //volume
        sb.append("\n20;;Linha$$\n");
        sb.append("21;;CampoRpn;;C1 C2 C3 @").append(StaticInfo.FATOR_VOL_DIVERSOS).append("@ * * *;;");
        sb.append("Volume: " + identificador + " cm³.;;3$$\n");
        sb.append("\n22;;Linha$$\n");
        sb.append("23;;CampoDouble;;").append("Espessura do parênquima: ").append(identificador).append(" cm.;;2$$\n");
        sb.append("\n24;;Linha$$\n");
        sb.append("25;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Rim esquerdo">

        sb.append("\n26;;Topico;;Rim esquerdo$$\n");
        //descrição
        sb.append("\n27;;Linha$$\n");
        sb.append("28;;Enumeracao;;").append(identificador).append(";;true$$\n");
        sb.append("29;;Enumeracao;;").append(", ").append(identificador).append("$$\n");
        sb.append("30;;Enumeracao;;").append(", apresentando volume ").append(identificador).append("$$\n");
        sb.append("31;;Enumeracao;;").append(" e contorno ").append(identificador).append(".$$\n");
        sb.append("\n32;;Linha$$\n");
        sb.append("33;;Enumeracao;;").append("Textura do parênquima: ").append(identificador).append(".$$\n");
        sb.append("\n34;;Linha$$\n");
        sb.append("35;;Enumeracao;;").append("Seio renal ").append(identificador).append(".$$\n");
        sb.append("\n36;;Linha$$\n");
        sb.append("37;;Enumeracao;;").append("Hidronefrose: ").append(identificador).append(".$$\n");
        //long
        sb.append("\n38;;Linha$$\n");
        sb.append("39;;CampoDouble;;Medidas: Long.: " + identificador + ";;2$$\n");
        //anterior pos
        sb.append("40;;CampoDouble;; x Ant. Post.: " + identificador + ";;2$$\n");
        //transversal
        sb.append("41;;CampoDouble;; x Trans.: " + identificador + " cm.;;2$$\n");
        //volume
        sb.append("\n42;;Linha$$\n");
        sb.append("43;;CampoRpn;;C1 C2 C3 @").append(StaticInfo.FATOR_VOL_DIVERSOS).append("@ * * *;;");
        sb.append("Volume: " + identificador + " cm³.;;3$$\n");
        sb.append("\n44;;Linha$$\n");
        sb.append("45;;CampoDouble;;").append("Espessura do parênquima: ").append(identificador).append(" cm.;;2$$\n");
        sb.append("\n46;;Linha$$\n");
        sb.append("47;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Informações complementares">

        sb.append("\n48;;Topico;;Informações complementares dos rins$$\n");
        sb.append("49;;Linha$$\n");
        sb.append("50;;CampoTexto;;$$\n");

        // </editor-fold>

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Bexiga">

        sb.append("\n51;;Topico;;Bexiga$$\n");
        //descrição
        sb.append("\n52;;Linha$$\n");
        sb.append("53;;Enumeracao;;").append("Posição ").append(identificador).append(";;true$$\n");
        sb.append("54;;Enumeracao;;").append(", morfologia ").append(identificador).append("$$\n");
        sb.append("55;;Enumeracao;;").append(" e superfície ").append(identificador).append(".$$\n");
        sb.append("\n56;;Linha$$\n");
        sb.append("57;;Enumeracao;;").append("Contornos ").append(identificador).append("$$\n");
        sb.append("58;;Enumeracao;;").append(" e conteúdo ").append(identificador).append(".$$\n");
        sb.append("\n59;;Linha$$\n");
        sb.append("60;;Enumeracao;;").append("Assoalho ").append(identificador).append(".$$\n");
        sb.append("\n61;;Linha$$\n");
        sb.append("62;;Enumeracao;;").append("Capacidade ").append(identificador).append(".$$\n");

        // Descrição
        sb.append("\n63;;Linha$$\n");
        sb.append("64;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        sb.append("\n65;;Topico;;Observações gerais$$\n");
        sb.append("66;;Linha$$\n");
        sb.append("67;;CampoTexto;;$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("\n68;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n69;;Linha$$\n");
        sb.append("\n70;;ImpressaoDiagnostica;;\n");
        sb.append("<p style=\"margin-top: 0\">"
                + "Rins e bexiga ecograficamente normais.</p>\n");
        sb.append("$$\n");
        sb.append("\n71;;Linha$$\n");
        sb.append("72;;Enumeracao;;$70CampoTexto$$\n");

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

        // <editor-fold defaultstate="collapsed" desc="Rins">

        // <editor-fold defaultstate="collapsed" desc="Rim direito">

        sb.append("\n6;;adicionarOpcao;;Presente$$\n");
        sb.append("6;;adicionarOpcao;;Ausente;;Ausente.$$\n");
        sb.append("6;;adicionarOpcao;;" + CampoSimples.DIGITAR + "$$\n");
        sb.append("6;;adicionarExcecao;;" + CampoSimples.DIGITAR + ";;$$\n");

        sb.append("\n7;;adicionarOpcao;;tópico$$\n");
        sb.append("7;;adicionarOpcao;;distópico$$\n");
        sb.append("7;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{Presente}$$\n");

        sb.append("\n8;;adicionarOpcao;;normal$$\n");
        sb.append("8;;adicionarOpcao;;aumentado$$\n");
        sb.append("8;;adicionarOpcao;;reduzido$$\n");
        sb.append("8;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{Presente}$$\n");

        sb.append("\n9;;adicionarOpcao;;regular$$\n");
        sb.append("9;;adicionarOpcao;;irregular$$\n");
        sb.append("9;;adicionarOpcao;;lobulado$$\n");
        sb.append("9;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{Presente}$$\n");

        sb.append("\n11;;adicionarOpcao;;normal$$\n");
        sb.append("11;;adicionarOpcao;;hipoecogênica$$\n");
        sb.append("11;;adicionarOpcao;;hiperecogênica$$\n");
        sb.append("11;;adicionarOpcao;;heterogênea$$\n");
        sb.append("11;;adicionarOpcao;;hipo ecogenicidade focal$$\n");
        sb.append("11;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{Presente}$$\n");

        sb.append("\n13;;adicionarOpcao;;normal$$\n");
        sb.append("13;;adicionarOpcao;;espessado$$\n");
        sb.append("13;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{Presente}$$\n");

        sb.append("\n15;;adicionarOpcao;;não há$$\n");
        sb.append("15;;adicionarOpcao;;leve$$\n");
        sb.append("15;;adicionarOpcao;;moderada$$\n");
        sb.append("15;;adicionarOpcao;;severa$$\n");
        sb.append("15;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{Presente}$$\n");

        sb.append("\n17;;setObrigatorio;;false$$\n");
        sb.append("\n18;;setObrigatorio;;false$$\n");
        sb.append("\n19;;setObrigatorio;;false$$\n");

        sb.append("17;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{Presente}$$\n");
        sb.append("18;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{Presente}$$\n");
        sb.append("19;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{Presente}$$\n");

        sb.append("\n17;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$18CampoDoLaudo|$19CampoDoLaudo}$$\n");
        sb.append("17;;setMsgErroValidCampoObrig;;Termine de informar as medidas do rim direito.$$\n");
        sb.append("18;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$17CampoDoLaudo|$19CampoDoLaudo}$$\n");
        sb.append("18;;setMsgErroValidCampoObrig;;Termine de informar as medidas do rim direito.$$\n");
        sb.append("19;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$17CampoDoLaudo|$18CampoDoLaudo}$$\n");
        sb.append("19;;setMsgErroValidCampoObrig;;Termine de informar as medidas do rim direito.$$\n");

        sb.append("21;;cadastrarParametroFormula;;$17CampoNumero$$\n");
        sb.append("21;;cadastrarParametroFormula;;$18CampoNumero$$\n");
        sb.append("21;;cadastrarParametroFormula;;$19CampoNumero$$\n");
        sb.append("21;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{Presente}$$\n");

        sb.append("23;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{Presente}$$\n");

        sb.append("25;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{Presente|"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("25;;vincularObrigatorio;;$6CampoDoLaudo;;{"+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Rim esquerdo">

        sb.append("\n28;;adicionarOpcao;;Presente$$\n");
        sb.append("28;;adicionarOpcao;;Ausente;;Ausente.$$\n");
        sb.append("28;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("28;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        sb.append("\n29;;adicionarOpcao;;tópico$$\n");
        sb.append("29;;adicionarOpcao;;distópico$$\n");
        sb.append("29;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{Presente}$$\n");

        sb.append("\n30;;adicionarOpcao;;normal$$\n");
        sb.append("30;;adicionarOpcao;;aumentado$$\n");
        sb.append("30;;adicionarOpcao;;reduzido$$\n");
        sb.append("30;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{Presente}$$\n");

        sb.append("\n31;;adicionarOpcao;;regular$$\n");
        sb.append("31;;adicionarOpcao;;irregular$$\n");
        sb.append("31;;adicionarOpcao;;lobulado$$\n");
        sb.append("31;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{Presente}$$\n");

        sb.append("\n33;;adicionarOpcao;;normal$$\n");
        sb.append("33;;adicionarOpcao;;hipoecogênica$$\n");
        sb.append("33;;adicionarOpcao;;hiperecogênica$$\n");
        sb.append("33;;adicionarOpcao;;heterogênea$$\n");
        sb.append("33;;adicionarOpcao;;hipo ecogenicidade focal$$\n");
        sb.append("33;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{Presente}$$\n");

        sb.append("\n35;;adicionarOpcao;;normal$$\n");
        sb.append("35;;adicionarOpcao;;espessado$$\n");
        sb.append("35;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{Presente}$$\n");

        sb.append("\n37;;adicionarOpcao;;não há$$\n");
        sb.append("37;;adicionarOpcao;;leve$$\n");
        sb.append("37;;adicionarOpcao;;moderada$$\n");
        sb.append("37;;adicionarOpcao;;severa$$\n");
        sb.append("37;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{Presente}$$\n");

        sb.append("\n39;;setObrigatorio;;false$$\n");
        sb.append("40;;setObrigatorio;;false$$\n");
        sb.append("41;;setObrigatorio;;false$$\n");

        sb.append("39;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{Presente}$$\n");
        sb.append("40;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{Presente}$$\n");
        sb.append("41;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{Presente}$$\n");

        sb.append("\n39;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$40CampoDoLaudo|$41CampoDoLaudo}$$\n");
        sb.append("39;;setMsgErroValidCampoObrig;;Termine de informar as medidas do rim esquerdo.$$\n");
        sb.append("40;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$39CampoDoLaudo|$41CampoDoLaudo}$$\n");
        sb.append("40;;setMsgErroValidCampoObrig;;Termine de informar as medidas do rim esquerdo.$$\n");
        sb.append("41;;vincularObrigatorio;;").append(CampoDoLaudo.AO_MENOS_1_CAMPO_POSSUI_VALOR).append(";;{$39CampoDoLaudo|$40CampoDoLaudo}$$\n");
        sb.append("41;;setMsgErroValidCampoObrig;;Termine de informar as medidas do rim esquerdo.$$\n");

        sb.append("43;;cadastrarParametroFormula;;$39CampoNumero$$\n");
        sb.append("43;;cadastrarParametroFormula;;$40CampoNumero$$\n");
        sb.append("43;;cadastrarParametroFormula;;$41CampoNumero$$\n");
        sb.append("43;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{Presente}$$\n");

        sb.append("45;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{Presente}$$\n");

        sb.append("47;;vincularHabAoValorDoCampo;;$28CampoDoLaudo;;false;;{Presente|"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("47;;vincularObrigatorio;;$28CampoDoLaudo;;{"+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        sb.append("\n50;;setObrigatorio;;false$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Bexiga">

        sb.append("\n53;;adicionarOpcao;;tópica$$\n");
        sb.append("53;;adicionarOpcao;;atópica$$\n");
        sb.append("53;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("53;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");

        sb.append("\n54;;adicionarOpcao;;normal$$\n");
        sb.append("54;;adicionarOpcao;;disforme$$\n");
        sb.append("54;;vincularHabAoValorDoCampo;;$53CampoDoLaudo;;false;;{tópica|atópica}$$\n");

        sb.append("\n55;;adicionarOpcao;;lisa$$\n");
        sb.append("55;;adicionarOpcao;;rugosa$$\n");
        sb.append("55;;vincularHabAoValorDoCampo;;$53CampoDoLaudo;;false;;{tópica|atópica}$$\n");

        sb.append("\n57;;adicionarOpcao;;definidos$$\n");
        sb.append("57;;adicionarOpcao;;indefinidos$$\n");
        sb.append("57;;adicionarOpcao;;reduzido$$\n");
        sb.append("57;;vincularHabAoValorDoCampo;;$53CampoDoLaudo;;false;;{tópica|atópica}$$\n");

        sb.append("\n58;;adicionarOpcao;;anecoico$$\n");
        sb.append("58;;adicionarOpcao;;hipoecoico$$\n");
        sb.append("58;;adicionarOpcao;;hipercoico$$\n");
        sb.append("58;;vincularHabAoValorDoCampo;;$53CampoDoLaudo;;false;;{tópica|atópica}$$\n");

        sb.append("\n60;;adicionarOpcao;;normal$$\n");
        sb.append("60;;adicionarOpcao;;elevado$$\n");
        sb.append("60;;adicionarOpcao;;rebaixado$$\n");
        sb.append("60;;vincularHabAoValorDoCampo;;$53CampoDoLaudo;;false;;{tópica|atópica}$$\n");

        sb.append("\n62;;adicionarOpcao;;normal$$\n");
        sb.append("62;;adicionarOpcao;;diminuída$$\n");
        sb.append("62;;adicionarOpcao;;elevada$$\n");
        sb.append("62;;vincularHabAoValorDoCampo;;$53CampoDoLaudo;;false;;{tópica|atópica}$$\n");

        sb.append("64;;vincularHabAoValorDoCampo;;$53CampoDoLaudo;;false;;{tópica|atópica|"+CampoSimples.DIGITAR+"}$$\n");
        sb.append("64;;vincularObrigatorio;;$53CampoDoLaudo;;{"+CampoSimples.DIGITAR+"}$$\n");

        // </editor-fold>

        sb.append("\n67;;setObrigatorio;;false$$\n");

        // </editor-fold>

        alterarModeloDeLaudo(21);
    }

    static void monitoracaoOvulacaoEndovaginal  () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Dados do equipamento">

        sb.append("\n0;;Topico;;Dados do exame$$\n");
        //Equipamento
        sb.append("\n1;;Linha;;Paciente submetida a monitorização seriada da ovulação "
                  + Linha.TEXTO_CAMPOS_FILHOS + " sob os seguintes aspectos:$$\n");
        sb.append("2;;Enumeracao;;").append("por exame com transdutor ").
                      append(identificador).append(" multifrequencial;;true$$\n");

        // frequencia
        sb.append("3;;CampoTexto;;\n");
        sb.append("$$\n");
        // </editor-fold>

        //dum
        sb.append("\n4;;Linha$$\n");
        sb.append("5;;CampoDate;;").append("<b>Data da última menstruação:</b> ").append(identificador).append(".$$\n");
        sb.append("6;;CampoInteiro;;"+ CampoSimples.NAO_IMPRIMIVEL + ";;1$$\n");

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 1">

        sb.append("\n7;;Topico;;Ultrassom 1$$\n");
        sb.append("\n8;;Linha$$\n");
        sb.append("9;;CampoDate;;Data: ").append(CampoSimples.identificador).append(".</p>$$\n");
        sb.append("10;;CampoRpnData;;<p style=\"margin-top: 0\">Dia do ciclo: ").append(CampoSimples.identificador).append(".;;C1 C2 - "
                  + "").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 / 7 * 1 +$$\n");
        sb.append("11;;Enumeracao;;<p style=\"margin-top: 0\">Endométrio: ").append(identificador).append("$$\n");
        sb.append("12;;CampoDouble;; com espessura de " + identificador + " mm.;;2$$\n");
        sb.append("\n13;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("14;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n15;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("16;;CampoTexto;;\n");
        sb.append("$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 2">

        sb.append("\n17;;Topico;;Ultrassom 2$$\n");
        sb.append("\n18;;Linha$$\n");
        sb.append("19;;CampoDate;;Data: ").append(CampoSimples.identificador).append(".</p>$$\n");
        sb.append("20;;CampoRpnData;;<p style=\"margin-top: 0\">"
                + "Dia do ciclo: ").append(CampoSimples.identificador).append(".</p>;;C1 C2 - "
                  + "").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 / 7 * 1 +$$\n");
        sb.append("21;;Enumeracao;;<p style=\"margin-top: 0\">"
                + "Endométrio: ").append(identificador).append("$$\n");
        sb.append("22;;CampoDouble;; com espessura de " + identificador + " mm.;;2$$\n");
        sb.append("\n23;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("24;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n25;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("26;;CampoTexto;;\n");
        sb.append("$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 3">

        sb.append("\n27;;Topico;;Ultrassom 3$$\n");
        sb.append("\n28;;Linha$$\n");
        sb.append("29;;CampoDate;;Data: ").append(CampoSimples.identificador).append(".</p>$$\n");
        sb.append("30;;CampoRpnData;;<p style=\"margin-top: 0\">Dia do ciclo: ").append(CampoSimples.identificador)
                .append(".</p>;;C1 C2 - ").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 / 7 * 1 +$$\n");
        sb.append("31;;Enumeracao;;<p style=\"margin-top: 0\">Endométrio: ").
                append(identificador).append("$$\n");
        sb.append("32;;CampoDouble;; com espessura de " + identificador + " mm.;;2$$\n");
        sb.append("\n33;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("34;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n35;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("36;;CampoTexto;;\n");
        sb.append("$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 4">

        sb.append("\n37;;Topico;;Ultrassom 4$$\n");
        sb.append("\n38;;Linha$$\n");
        sb.append("39;;CampoDate;;Data: ").append(CampoSimples.identificador).append(".</p>$$\n");
        sb.append("40;;CampoRpnData;;<p style=\"margin-top: 0\">Dia do ciclo: ").append(
                CampoSimples.identificador).append(".</p>;;C1 C2 - ").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 / 7 * 1 +$$\n");
        sb.append("41;;Enumeracao;;<p style=\"margin-top: 0\">Endométrio: ").append(identificador).append("$$\n");
        sb.append("42;;CampoDouble;; com espessura de " + identificador + " mm.;;2$$\n");
        sb.append("\n43;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("44;;CampoTexto\n");
        sb.append("$$\n");
        sb.append("\n45;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("46;;CampoTexto;;\n");
        sb.append("$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 5">

        sb.append("\n47;;Topico;;Ultrassom 5$$\n");
        sb.append("\n48;;Linha$$\n");
        sb.append("49;;CampoDate;;Data: ").append(CampoSimples.identificador).append(".</p>$$\n");
        sb.append("50;;CampoRpnData;;<p style=\"margin-top: 0\">Dia do ciclo: ").append(CampoSimples.
                identificador).append(".</p>;;C1 C2 - ").append(CampoRpnData.UM_DIA_EM_MS)
                .append(" / 7 / 7 * 1 +$$\n");
        sb.append("51;;Enumeracao;;<p style=\"margin-top: 0\">Endométrio: ").append(identificador).append("$$\n");
        sb.append("52;;CampoDouble;; com espessura de " + identificador + " mm.;;2$$\n");
        sb.append("\n53;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("54;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n55;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("56;;CampoTexto;;\n");
        sb.append("$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 6">

        sb.append("\n57;;Topico;;Ultrassom 6$$\n");
        sb.append("\n58;;Linha$$\n");
        sb.append("59;;CampoDate;;Data: ").append(CampoSimples.identificador).append(".</p>$$\n");
        sb.append("60;;CampoRpnData;;<p style=\"margin-top: 0\">Dia do ciclo: ").append(CampoSimples.identificador).append(".;;C1 C2 - "
                  + "").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 / 7 * 1 +$$\n");
        sb.append("61;;Enumeracao;;<p style=\"margin-top: 0\">Endométrio: ").append(identificador).append("$$\n");
        sb.append("62;;CampoDouble;; com espessura de " + identificador + " mm.;;2$$\n");
        sb.append("\n63;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("64;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n65;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("66;;CampoTexto;;\n");
        sb.append("$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 7">

        sb.append("\n67;;Topico;;Ultrassom 7$$\n");
        sb.append("\n68;;Linha$$\n");
        sb.append("69;;CampoDate;;Data: ").append(CampoSimples.identificador).append(".</p>$$\n");
        sb.append("70;;CampoRpnData;;<p style=\"margin-top: 0\">Dia do ciclo: ").append(CampoSimples.identificador).append(".</p>;;C1 C2 - "
                  + "").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 / 7 * 1 +$$\n");
        sb.append("71;;Enumeracao;;<p style=\"margin-top: 0\">Endométrio: ").append(identificador).append("$$\n");
        sb.append("72;;CampoDouble;; com espessura de " + identificador + " mm.;;2$$\n");
        sb.append("\n73;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("74;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n75;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("76;;CampoTexto;;\n");
        sb.append("$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 8">

        sb.append("\n77;;Topico;;Ultrassom 8$$\n");
        sb.append("\n78;;Linha$$\n");
        sb.append("79;;CampoDate;;Data: ").append(CampoSimples.identificador).append(".</p>$$\n");
        sb.append("80;;CampoRpnData;;<p style=\"margin-top: 0\">Dia do ciclo: ").append(CampoSimples.identificador)
                .append(".</p>;;C1 C2 - ").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 / 7 * 1 +$$\n");
        sb.append("81;;Enumeracao;;<p style=\"margin-top: 0\">Endométrio: ").append(identificador).append(".$$\n");
        sb.append("82;;CampoDouble;; com espessura de " + identificador + " mm.;;2$$\n");
        sb.append("\n83;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("84;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n85;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("86;;CampoTexto;;\n");
        sb.append("$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 9">

        sb.append("\n87;;Topico;;Ultrassom 9$$\n");
        sb.append("\n88;;Linha$$\n");
        sb.append("89;;CampoDate;;Data: ").append(CampoSimples.identificador).append(".</p>$$\n");
        sb.append("90;;CampoRpnData;;<p style=\"margin-top: 0\">Dia do ciclo: ").append(CampoSimples.identificador).append(".;;C1 C2 - "
                  + "").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 / 7 * 1 +$$\n");
        sb.append("91;;Enumeracao;;<p style=\"margin-top: 0\">Endométrio: ").append(identificador).append("$$\n");
        sb.append("92;;CampoDouble;; com espessura de " + identificador + " mm.;;2$$\n");
        sb.append("\n93;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("94;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n95;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("96;;CampoTexto;;\n");
        sb.append("$$\n");
        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Ultrassom 10">

        sb.append("\n97;;Topico;;Ultrassom 10$$\n");
        sb.append("\n98;;Linha$$\n");
        sb.append("99;;CampoDate;;Data: ").append(CampoSimples.identificador).append(".</p>$$\n");
        sb.append("100;;CampoRpnData;;<p style=\"margin-top: 0\">Dia do ciclo: ").append(CampoSimples.identificador).
                append(".</p>;;C1 C2 - ").append(CampoRpnData.UM_DIA_EM_MS).append(" / 7 / 7 * 1 +$$\n");
        sb.append("101;;Enumeracao;;<p style=\"margin-top: 0\">Endométrio: ").append(identificador).append("$$\n");
        sb.append("102;;CampoDouble;; com espessura de " + identificador + " mm.;;2$$\n");
        sb.append("\n103;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("104;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n105;;Linha;;"+Linha.TEXTO_CAMPOS_FILHOS+"$$\n");
        sb.append("106;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Dados clínicos">

        sb.append("\n107;;Topico;;Dados clínicos$$\n");
        sb.append("\n108;;Linha$$\n");
        sb.append("109;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n110;;Linha$$\n");
        sb.append("111;;Enumeracao;;$109$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Esquema de indução">

        sb.append("\n112;;Topico;;Esquema de indução$$\n");
        sb.append("\n113;;Linha$$\n");
        sb.append("114;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n115;;Linha$$\n");
        sb.append("116;;Enumeracao;;$114$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="H.C.G.:">

        sb.append("\n117;;Topico;;H.C.G.$$\n");
        sb.append("\n118;;Linha$$\n");
        sb.append("119;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n120;;Linha$$\n");
        sb.append("121;;Enumeracao;;$119$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Suplementação fase 2">

        sb.append("\n122;;Topico;;Suplementação fase 2$$\n");
        sb.append("\n123;;Linha$$\n");
        sb.append("124;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n125;;Linha$$\n");
        sb.append("126;;Enumeracao;;$124$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Resposta folicular">

        sb.append("\n127;;Topico;;Resposta folicular$$\n");
        sb.append("\n128;;Linha$$\n");
        sb.append("129;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n130;;Linha$$\n");
        sb.append("131;;Enumeracao;;$129$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Resposta endometrial">

        sb.append("\n132;;Topico;;Resposta endometrial$$\n");
        sb.append("\n133;;Linha$$\n");
        sb.append("134;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n135;;Linha$$\n");
        sb.append("136;;Enumeracao;;$134$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Resposta fase lútea">

        sb.append("\n137;;Topico;;Resposta fase lútea$$\n");
        sb.append("\n138;;Linha$$\n");
        sb.append("139;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n140;;Linha$$\n");
        sb.append("141;;Enumeracao;;$139$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Procedimento realizado">

        sb.append("\n142;;Topico;;Procedimento realizado$$\n");
        sb.append("\n143;;Linha$$\n");
        sb.append("144;;CampoTexto;;\n");
        sb.append("$$\n");
        sb.append("\n145;;Linha$$\n");
        sb.append("146;;Enumeracao;;$144$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Observações gerais">

        //campo descrito  Observações gerais
        sb.append("\n147;;Topico;;Observações gerais$$\n");
        sb.append("\n148;;Linha$$\n");
        sb.append("149;;CampoTexto;;\n");
        sb.append("$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        //campo descrito Impressao diagnostica
        sb.append("\n150;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n151;;Linha$$\n");
        sb.append("\n152;;ImpressaoDiagnostica\n");
        sb.append("$$\n");
        sb.append("\n153;;Linha$$\n");
        sb.append("154;;Enumeracao;;$152CampoTexto$$\n");
        // </editor-fold>

        sb.append("\n##\n");

        // <editor-fold defaultstate="collapsed" desc="Metodos">

        sb.append("\n97;;setHabilitado;;false$$\n");

        sb.append("149;;setObrigatorio;;false$$\n");
        sb.append("1;;setHtmlDaProleEhObrigatorio;;false$$\n");

        sb.append("7;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{(/s)1|(/s)2|(/s)3|(/s)4|(/s)5|(/s)6|(/s)7|(/s)8|(/s)9|(/s)10}$$\n");
        sb.append("17;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{(/s)2|(/s)3|(/s)4|(/s)5|(/s)6|(/s)7|(/s)8|(/s)9|(/s)10}$$\n");
        sb.append("27;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{(/s)3|(/s)4|(/s)5|(/s)6|(/s)7|(/s)8|(/s)9|(/s)10}$$\n");
        sb.append("37;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{(/s)4|(/s)5|(/s)6|(/s)7|(/s)8|(/s)9|(/s)10}$$\n");
        sb.append("47;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{(/s)5|(/s)6|(/s)7|(/s)8|(/s)9|(/s)10}$$\n");
        sb.append("57;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{(/s)6|(/s)7|(/s)8|(/s)9|(/s)10}$$\n");
        sb.append("67;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{(/s)7|(/s)8|(/s)9|(/s)10}$$\n");
        sb.append("77;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{(/s)8|(/s)9|(/s)10}$$\n");
        sb.append("87;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{(/s)9|(/s)10}$$\n");
//        sb.append("97;;vincularHabAoValorDoCampo;;$6CampoDoLaudo;;false;;{(/s)10}$$\n");

        sb.append("\n2;;adicionarOpcao;;convexo$$\n");
        sb.append("2;;adicionarOpcao;;linear$$\n");
        sb.append("2;;adicionarOpcao;;endocavitário$$\n");
        sb.append("2;;adicionarOpcao;;"+CampoSimples.DIGITAR+"$$\n");
        sb.append("2;;adicionarExcecao;;"+CampoSimples.DIGITAR+";;$$\n");
        sb.append("3;;vincularHabAoValorDoCampo;;$2CampoDoLaudo;;false;;{"+CampoSimples.DIGITAR+"}$$\n");

        // <editor-fold defaultstate="collapsed" desc="ultrassom 1">
        sb.append("\n10;;cadastrarParamFormula;;$9CampoDoLaudo$$\n");
        sb.append("10;;cadastrarParamFormula;;$5CampoDoLaudo$$\n");

        sb.append("\n11;;adicionarOpcao;;linear e fino$$\n");
        sb.append("11;;adicionarOpcao;;trilaminar$$\n");
        sb.append("11;;adicionarOpcao;;isoecogênico$$\n");
        sb.append("11;;adicionarOpcao;;ecogênico$$\n");

        sb.append("13;;setDescrPrimParag;;-Ovário direito (Folículos): $$\n");
        sb.append("15;;setDescrPrimParag;;-Ovário esquerdo (Folículos): $$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ultrassom 2">
        sb.append("\n20;;cadastrarParamFormula;;$19CampoDoLaudo$$\n");
        sb.append("20;;cadastrarParamFormula;;$5CampoDoLaudo$$\n");

        sb.append("\n21;;adicionarOpcao;;linear e fino$$\n");
        sb.append("21;;adicionarOpcao;;trilaminar$$\n");
        sb.append("21;;adicionarOpcao;;isoecogênico$$\n");
        sb.append("21;;adicionarOpcao;;ecogênico$$\n");

        sb.append("23;;setDescrPrimParag;;-Ovário direito (Folículos): $$\n");
        sb.append("25;;setDescrPrimParag;;-Ovário esquerdo (Folículos): $$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ultrassom 3">
        sb.append("\n30;;cadastrarParamFormula;;$29CampoDoLaudo$$\n");
        sb.append("30;;cadastrarParamFormula;;$5CampoDoLaudo$$\n");

        sb.append("\n31;;adicionarOpcao;;linear e fino$$\n");
        sb.append("31;;adicionarOpcao;;trilaminar$$\n");
        sb.append("31;;adicionarOpcao;;isoecogênico$$\n");
        sb.append("31;;adicionarOpcao;;ecogênico$$\n");

        sb.append("33;;setDescrPrimParag;;-Ovário direito (Folículos): $$\n");
        sb.append("35;;setDescrPrimParag;;-Ovário esquerdo (Folículos): $$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ultrassom 4">
        sb.append("\n40;;cadastrarParamFormula;;$39CampoDoLaudo$$\n");
        sb.append("40;;cadastrarParamFormula;;$5CampoDoLaudo$$\n");

        sb.append("\n41;;adicionarOpcao;;linear e fino$$\n");
        sb.append("41;;adicionarOpcao;;trilaminar$$\n");
        sb.append("41;;adicionarOpcao;;isoecogênico$$\n");
        sb.append("41;;adicionarOpcao;;ecogênico$$\n");

        sb.append("43;;setDescrPrimParag;;-Ovário direito (Folículos): $$\n");
        sb.append("45;;setDescrPrimParag;;-Ovário esquerdo (Folículos): $$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ultrassom 5">
        sb.append("\n50;;cadastrarParamFormula;;$49CampoDoLaudo$$\n");
        sb.append("50;;cadastrarParamFormula;;$5CampoDoLaudo$$\n");

        sb.append("\n51;;adicionarOpcao;;linear e fino$$\n");
        sb.append("51;;adicionarOpcao;;trilaminar$$\n");
        sb.append("51;;adicionarOpcao;;isoecogênico$$\n");
        sb.append("51;;adicionarOpcao;;ecogênico$$\n");

        sb.append("53;;setDescrPrimParag;;-Ovário direito (Folículos): $$\n");
        sb.append("55;;setDescrPrimParag;;-Ovário esquerdo (Folículos): $$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ultrassom 6">
        sb.append("\n60;;cadastrarParamFormula;;$59CampoDoLaudo$$\n");
        sb.append("60;;cadastrarParamFormula;;$5CampoDoLaudo$$\n");

        sb.append("\n61;;adicionarOpcao;;linear e fino$$\n");
        sb.append("61;;adicionarOpcao;;trilaminar$$\n");
        sb.append("61;;adicionarOpcao;;isoecogênico$$\n");
        sb.append("61;;adicionarOpcao;;ecogênico$$\n");

        sb.append("63;;setDescrPrimParag;;-Ovário direito (Folículos): $$\n");
        sb.append("65;;setDescrPrimParag;;-Ovário esquerdo (Folículos): $$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ultrassom 7">
        sb.append("\n70;;cadastrarParamFormula;;$69CampoDoLaudo$$\n");
        sb.append("70;;cadastrarParamFormula;;$5CampoDoLaudo$$\n");

        sb.append("\n71;;adicionarOpcao;;linear e fino$$\n");
        sb.append("71;;adicionarOpcao;;trilaminar$$\n");
        sb.append("71;;adicionarOpcao;;isoecogênico$$\n");
        sb.append("71;;adicionarOpcao;;ecogênico$$\n");

        sb.append("73;;setDescrPrimParag;;-Ovário direito (Folículos): $$\n");
        sb.append("75;;setDescrPrimParag;;-Ovário esquerdo (Folículos): $$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ultrassom 8">
        sb.append("\n80;;cadastrarParamFormula;;$79CampoDoLaudo$$\n");
        sb.append("80;;cadastrarParamFormula;;$5CampoDoLaudo$$\n");

        sb.append("\n81;;adicionarOpcao;;linear e fino$$\n");
        sb.append("81;;adicionarOpcao;;trilaminar$$\n");
        sb.append("81;;adicionarOpcao;;isoecogênico$$\n");
        sb.append("81;;adicionarOpcao;;ecogênico$$\n");

        sb.append("83;;setDescrPrimParag;;-Ovário direito (Folículos): $$\n");
        sb.append("85;;setDescrPrimParag;;-Ovário esquerdo (Folículos): $$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ultrassom 9">
        sb.append("\n90;;cadastrarParamFormula;;$89CampoDoLaudo$$\n");
        sb.append("90;;cadastrarParamFormula;;$5CampoDoLaudo$$\n");

        sb.append("\n91;;adicionarOpcao;;linear e fino$$\n");
        sb.append("91;;adicionarOpcao;;trilaminar$$\n");
        sb.append("91;;adicionarOpcao;;isoecogênico$$\n");
        sb.append("91;;adicionarOpcao;;ecogênico$$\n");

        sb.append("93;;setDescrPrimParag;;-Ovário direito (Folículos): $$\n");
        sb.append("95;;setDescrPrimParag;;-Ovário esquerdo (Folículos): $$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="ultrassom 10">
        sb.append("\n100;;cadastrarParamFormula;;$99CampoDoLaudo$$\n");
        sb.append("100;;cadastrarParamFormula;;$5CampoDoLaudo$$\n");

        sb.append("\n101;;adicionarOpcao;;linear e fino$$\n");
        sb.append("101;;adicionarOpcao;;trilaminar$$\n");
        sb.append("101;;adicionarOpcao;;isoecogênico$$\n");
        sb.append("101;;adicionarOpcao;;ecogênico$$\n");

        sb.append("103;;setDescrPrimParag;;-Ovário direito (Folículos): $$\n");
        sb.append("105;;setDescrPrimParag;;-Ovário esquerdo (Folículos): $$\n");

        // </editor-fold>

        // </editor-fold>

        alterarModeloDeLaudo(23);
    }

    static void colonoscopia () throws Exception
    {

        // <editor-fold defaultstate="collapsed" desc="Indicação clínica">

        sb.append("\n0;;Topico;;Indicação clínica$$\n");
        sb.append("\n1;;Linha$$\n");
        sb.append("2;;CampoTexto;;$$\n");
        sb.append("\n3;;Linha$$\n");
        sb.append("4;;Enumeracao;;$2$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Pré-medicação">

        sb.append("\n5;;Topico;;Pré-medicação$$\n");
        sb.append("\n6;;Linha$$\n");
        sb.append("7;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Monitorização por oximetria de "
                + "pulso - SpO2: 98%, Pulso: 72 bat/min.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Pré-medicação: "
                + "Meperidina e diazepan endovenosa.</p>$$\n");
        sb.append("\n8;;Linha$$\n");
        sb.append("9;;Enumeracao;;$7$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Inspeção anal">

        sb.append("\n10;;Topico;;Inspeção anal$$\n");
        sb.append("11;;Linha$$\n");
        sb.append("12;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Sem alterações.</p>$$\n");
        sb.append("\n13;;Linha$$\n");
        sb.append("14;;Enumeracao;;$12$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Toque retal">

        sb.append("\n15;;Topico;;Toque retal$$\n");
        sb.append("16;;Linha$$\n");
        sb.append("17;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Sem alterações.</p>$$\n");
        sb.append("\n18;;Linha$$\n");
        sb.append("19;;Enumeracao;;$17$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Canal anal e reto">

        sb.append("\n20;;Topico;;Canal anal e reto$$\n");
        sb.append("21;;Linha$$\n");
        sb.append("22;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Até a linha pectínea sem alterações,"
                + " mucosa retal lisa, elástica, de coloração habitual, vasos "
                + "submucosos visíveis, junção retossigmóide ultrapassada sem "
                + "dificuldades.</p>$$\n");
        sb.append("\n23;;Linha$$\n");
        sb.append("24;;Enumeracao;;$22$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Cólon sigmóide">

        sb.append("\n25;;Topico;;Cólon sigmóide$$\n");
        sb.append("26;;Linha$$\n");
        sb.append("27;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Mucosa rósea, superfície lisa, "
                + "paredes elásticas, luz de calibre habitual, "
                + "peristaltismo presente.</p>$$\n");
        sb.append("\n28;;Linha$$\n");
        sb.append("29;;Enumeracao;;$27$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Cólon descendente">

        sb.append("\n30;;Topico;;Cólon descendente$$\n");
        sb.append("31;;Linha$$\n");
        sb.append("32;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Mucosa rósea, superfície lisa, "
                + "paredes elásticas, luz de calibre habitual, "
                + "peristaltismo presente, ângulo esplênico "
                + "ultrapassado com facilidade.</p>$$\n");
        sb.append("\n33;;Linha$$\n");
        sb.append("34;;Enumeracao;;$32$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Cólon transverso">

        sb.append("\n35;;Topico;;Cólon transverso$$\n");
        sb.append("36;;Linha$$\n");
        sb.append("37;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Mucosa rósea, superfície lisa, "
                + "paredes elásticas, luz de forma triangular e calibre "
                + "habitual, peristaltismo presente, sombra hepática visível, "
                + "ângulo hepático ultrapassado com facilidade.</p>$$\n");
        sb.append("\n38;;Linha$$\n");
        sb.append("39;;Enumeracao;;$37$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Cólon ascendente e ceco">

        sb.append("\n40;;Topico;;Cólon ascendente e ceco$$\n");
        sb.append("41;;Linha$$\n");
        sb.append("42;;CampoTexto;;\n");
        sb.append("<p style=\"margin-top: 0\">Mucosa rósea, superfície lisa, "
                + "paredes elásticas, confluência das tênias visível, válvula "
                + "íleo cecal sem alterações.</p>$$\n");
        sb.append("\n43;;Linha$$\n");
        sb.append("44;;Enumeracao;;$42$$\n");

        // </editor-fold>

        // <editor-fold defaultstate="collapsed" desc="Impressao diagnostica">

        sb.append("\n45;;Topico;;Impressão diagnóstica$$\n");
        sb.append("\n46;;Linha$$\n");
        sb.append("47;;ImpressaoDiagnostica;;\n");
        sb.append("<p style=\"margin-top: 0\">Colonoscopia normal.</p>\n");
        sb.append("<p style=\"margin-top: 0\">Realizada biópsia para estudo histológico.</p>\n");
        sb.append("<p style=\"margin-top: 0\">A critério clínico do médico solicitante este exame deve ser repetido.</p>$$\n");
        sb.append("\n48;;Linha$$\n");
        sb.append("49;;Enumeracao;;$47CampoTexto$$\n");

        // </editor-fold>

        alterarModeloDeLaudo(29);

    }

}

