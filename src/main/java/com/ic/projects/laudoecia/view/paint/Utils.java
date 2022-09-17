/*
 * Utils.java
 *
 * Created on 12/05/2011, 10:01:24
 */
package com.ic.projects.laudoecia.view.paint;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 *
 * @author Amsterdam Luís <al@instrumentalcientifico.com.br>
 */
class Utils
{
    
    /**
     * Cria um mapa com os valores RGB de cada ponto da imagem que contem o o
     * shape que sera desenhado. Esse mapa salva todos os pontos dentro do
     * shape, mesmo que o shape nao va ser preenchido com o metodo fill. No
     * entanto outra alternativa nao foi estudada.
     *
     * @param shape o objeto a ser desenhado
     * @param b a imagem cujos pixels queremos salvar
     * @return o mapa de valores do RBG de cada ponto contido no shape
     */
    static HashMap<Point2D, Integer> createMap (Shape shape, BufferedImage b)
    {
        Rectangle2D r = shape.getBounds2D();
        int xIni = (int) (r.getMinX() < 0 ? 0 : r.getMinX());
        int yIni = (int) (r.getMinY() < 0 ? 0 : r.getMinY());
        int xFim = (int) (r.getWidth() + xIni);
        int yFim = (int) (r.getHeight() + yIni);

        xFim = xFim > b.getWidth() ? b.getWidth() : xFim;
        yFim = yFim > b.getHeight() ? b.getHeight() : yFim;

        HashMap<Point2D, Integer> mapa = new HashMap<>();
        for (int x = xIni; x < xFim; x++)
        {
            for (int y = yIni; y < yFim; y++)
            {
                Point2D p = new Point2D.Double(x, y);
                if (shape.contains(p))
                {
                    mapa.put(p, b.getRGB(x, y));
                }
            }
        }
        return mapa;
    }

    /**
     * Cria um ponto de forma que o angulo entre o pontoFixo e a resposta seja
     * multiplo de 45º. Esse ponto eh criado a partir de outro ponto, de forma
     * que haja uma aproximacao do ponto auxiliar para o ponto resposta que eh a
     * extremidade do quadrado
     *
     * @param pontoFixo o ponto fixo do quadrado
     * @param pontoAuxiliar o ponto que sera aproximado para um vertice do
     * quadrado que contem pontoFixo
     * @return o vertice do quadrado criado
     */
    static Point2D makeSquare (Point2D pontoFixo, Point2D pontoAuxiliar)
    {

        double xFixo = pontoFixo.getX();
        double yFixo = pontoFixo.getY();
        double xAux = pontoAuxiliar.getX();
        double yAux = pontoAuxiliar.getY();

        double distanciaH = Math.abs(xFixo - pontoAuxiliar.getX());
        double distanciaV = Math.abs(yFixo - pontoAuxiliar.getY());

        double distEscolhida = Math.max(distanciaH, distanciaV);

        double sinalX = Math.max(xFixo, xAux) == xAux ? 1 : -1;
        double sinalY = Math.max(yFixo, yAux) == yAux ? 1 : -1;

        return new Point2D.Double(xFixo + distEscolhida * sinalX,
                                  yFixo + distEscolhida * sinalY);
    }

}
