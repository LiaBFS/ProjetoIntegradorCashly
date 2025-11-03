package view;

import javax.swing.*;
import java.awt.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.RectangleEdge;

public class TelaInternaGraficoPlano extends JFrame {

    public TelaInternaGraficoPlano() {
        setTitle("Gráfico do Plano");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(250, 245, 240)); // cor de fundo bege claro

        // ==============================
        // Descrição superior
        // ==============================
        JLabel descricao = new JLabel("<html><div style='text-align:center;'>"
                + "<b>O gráfico abaixo mostra a porcentagem de evolução das Metas</b><br>"
                + "presentes no Plano Financeiro atual."
                + "</div></html>", SwingConstants.CENTER);
        descricao.setFont(new Font("SansSerif", Font.PLAIN, 14));
        descricao.setForeground(new Color(80, 50, 50));
        descricao.setBorder(BorderFactory.createEmptyBorder(15, 0, 10, 0));
        add(descricao, BorderLayout.NORTH);

        // ==============================
        // Dataset (simulação)
        // ==============================
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Meta 1", "Meta1");
        dataset.addValue(25, "Meta 2", "Meta2");
        dataset.addValue(100, "Meta 3", "Meta3");
        dataset.addValue(50, "Meta 4", "Meta4");

        // ==============================
        // Criação do gráfico
        // ==============================
        JFreeChart grafico = ChartFactory.createBarChart(
                "Gráfico de Metas",
                "Metas",
                "Porcentagem (%)",
                dataset
        );

        grafico.setBackgroundPaint(new Color(250, 245, 240));
        grafico.getTitle().setFont(new Font("SansSerif", Font.BOLD, 22));
        grafico.getTitle().setPaint(new Color(80, 50, 50));
        grafico.getTitle().setPosition(RectangleEdge.TOP);

        // ==============================
        // Customização do plot
        // ==============================
        CategoryPlot plot = grafico.getCategoryPlot();
        plot.setBackgroundPaint(new Color(245, 240, 235));
        plot.setOutlineVisible(false);
        plot.setRangeGridlinePaint(new Color(180, 160, 160));

        // ==============================
        // Customização das cores das barras
        // ==============================
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(193, 31, 35));   // vermelho escuro
        renderer.setSeriesPaint(1, new Color(242, 151, 151)); // rosa claro
        renderer.setSeriesPaint(2, new Color(202, 196, 190)); // cinza
        renderer.setSeriesPaint(3, new Color(160, 60, 60));   // vermelho médio

        renderer.setBarPainter(new org.jfree.chart.renderer.category.StandardBarPainter());
        renderer.setItemMargin(0.1);

        // ==============================
        // Adiciona gráfico ao painel
        // ==============================
        ChartPanel painel = new ChartPanel(grafico);
        painel.setBackground(new Color(250, 245, 240));
        add(painel, BorderLayout.CENTER);

        // ==============================
        // Rodapé com observação
        // ==============================
        JLabel rodape = new JLabel("<html><center>* Caso alguma meta não esteja presente no gráfico, "
                + "verifique a lista de metas cadastradas.</center></html>", SwingConstants.CENTER);
        rodape.setFont(new Font("SansSerif", Font.ITALIC, 12));
        rodape.setForeground(new Color(90, 70, 70));
        rodape.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(rodape, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaInternaGraficoPlano().setVisible(true));
    }
}
