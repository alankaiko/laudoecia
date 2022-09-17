/*
 * MyCustomChart.java
 * Clase que customiza os graficos em algumas particularidades.
 * Atenção: Não mudar este arquivo de pasta!
 * Caso for mudar, alterar propriedade dos graficos com o caminho da classe.
 *
 * Created on 03/02/2012, 08:39:10
 */
package com.ic.projects.laudoecia.view.reports;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import net.sf.jasperreports.engine.JRChart;
import net.sf.jasperreports.engine.JRChartCustomizer;
import net.sf.jasperreports.engine.JRPropertiesMap;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;

/**
 * @author Danilo Brito <danilobrito@instrumentalcientifico.com.br>
 */
public class MyCustomChart implements JRChartCustomizer
{
    @Override
    public void customize (JFreeChart chart, JRChart jasperChart)
    {
        // Gather all of the properties set on the chart object
        JRPropertiesMap pm = jasperChart.getPropertiesMap();
        double upperMargin = (pm.getProperty("UpperMargin") == null) ? -1 : Double.parseDouble(pm.getProperty("UpperMargin"));
        float maximumCategoryLabelWidthRatio = (pm.getProperty("MaximumCategoryLabelWidthRatio") == null) ? -1 : Float.parseFloat(pm.getProperty("MaximumCategoryLabelWidthRatio"));
        float itemMargin = (pm.getProperty("ItemMargin") == null) ? -1 : Float.parseFloat(pm.getProperty("ItemMargin"));
        int maximumCategoryLabelLines = (pm.getProperty("MaximumCategoryLabelLines") == null) ? -1 : Integer.parseInt(pm.getProperty("MaximumCategoryLabelLines"));
        boolean useIntegerTickUnits = (pm.getProperty("IntegerTickUnits") == null || !pm.getProperty("IntegerTickUnits").equals("true")) ? false : true;
        String labelFormat = (pm.getProperty("LabelFormat") == null) ? null : pm.getProperty("LabelFormat").toString();

        // This customizer works only with Category Plots (like Line Charts and Bar Charts).
        // It silently ignores all other chart types.
        Plot plot = chart.getPlot();
        if (plot instanceof CategoryPlot)
        {
            CategoryPlot categoryPlot = (CategoryPlot) plot;
            CategoryItemRenderer catRenderer = categoryPlot.getRenderer();
            ValueAxis valueAxis = categoryPlot.getRangeAxis();
            CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
            
            //verifica se tem formato de numero para label e seta-o
            if (labelFormat != null)
            {
                catRenderer.setBaseItemLabelGenerator(new MyNumberFormat(labelFormat));
            }

            //cria ticks so com numeros inteiros
            if (useIntegerTickUnits)
            {
                valueAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
            }

            // The default upper margin is 5%.
            // This is nearly always no good if labels are displayed.
            // We should calculate the height needed for the top label
            // and then set the upper margin appropriately.
            // Instead of doing that, we let the report designer choose a value.
            // The value must be a percentage between 0 and 1.
            if (upperMargin >= 0 && upperMargin <= 1)
            {
                valueAxis.setUpperMargin(upperMargin);
            }

            // I don't know what the default MaximumCategoryLabelWidthRatio is,
            // but it's too small in many cases.
            if (maximumCategoryLabelWidthRatio > 0)
            {
                categoryAxis.setMaximumCategoryLabelWidthRatio(maximumCategoryLabelWidthRatio);
            }

            // The ItemMargin is the space between bars within a single category.
            // The default value is 10% (0.10).
            // It's common to want this smaller.
            if (categoryPlot.getRenderer() instanceof BarRenderer)
            {
                BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();
                if (itemMargin >= 0 && itemMargin <= 1)
                {
                    barRenderer.setItemMargin(itemMargin);
                }
            }


            // By default category labels are a single line.
            if (maximumCategoryLabelLines > 0)
            {
                categoryAxis.setMaximumCategoryLabelLines(maximumCategoryLabelLines);
            }

        }
    }
    
    static class MyNumberFormat implements CategoryItemLabelGenerator
    {
        private String format;
        
        MyNumberFormat (String format)
        {
            this.format = format;
        }        
        
        @Override
        public String generateRowLabel (CategoryDataset cd, int i)
        {
            return "";
        }

        @Override
        public String generateColumnLabel (CategoryDataset cd, int i)
        {
            return "";
        }

        @Override
        public String generateLabel (CategoryDataset cd, int i, int i1)
        {
            NumberFormat nf = new DecimalFormat(format);
            return nf.format(cd.getValue(i, i1));
        }
        
    }

}
