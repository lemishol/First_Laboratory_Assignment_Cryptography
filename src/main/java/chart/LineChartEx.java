package chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

public class LineChartEx extends JFrame {
    public static ArrayList<Double> workingList = null;
    public LineChartEx() {
        initUI();
    }

    private void initUI() {

        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Line chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private XYDataset createDataset() {

        XYSeries series = new XYSeries("");
        for (int i=0; i<32; i++){
            series.add(i, workingList.get(i));
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Логарифмічна функція ймовірності для кожного ключа",
                "Номер за алфавітом",
                "Логарифм",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Логарифмічна функція ймовірності для кожного ключа",
                        new Font("CalibriLight", java.awt.Font.BOLD, 18)
                )
        );

        return chart;
    }

    public static void chart(ArrayList<Double> array) {
        workingList = array;
        EventQueue.invokeLater(() -> {

            LineChartEx ex = new LineChartEx();
            ex.setVisible(true);
        });
    }
}
