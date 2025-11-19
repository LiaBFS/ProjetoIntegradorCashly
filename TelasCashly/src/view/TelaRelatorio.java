package view;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import net.miginfocom.swing.MigLayout;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.Dimension;
import java.awt.BorderLayout;

public class TelaRelatorio extends JPanel {

    private JPanel panelGrafico;
    private JPanel panelInfo;

    public TelaRelatorio() {
        setBackground(new Color(216, 178, 184));
        setLayout(new MigLayout("", "[grow]", "[116px][grow]"));

        // Adiciona ícone no topo
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(TelaRelatorio.class.getResource("/imgs/Relatorios.png")));
        add(lblNewLabel, "cell 0 0,growx,aligny top");

        // Painel com bordas arredondadas ao fundo
        RoundedPanel panelBranco = new RoundedPanel(30);
        panelBranco.setLayout(new MigLayout("insets 20", "[400px][grow]", "[grow]"));
        panelBranco.setBackground(new Color(246, 237, 227));

        // Painel de informações (à esquerda)
        panelInfo = criarPainelInfo();
        panelBranco.add(panelInfo, "cell 0 0,grow");

        // Painel do gráfico (à direita)
        panelGrafico = new JPanel(new BorderLayout());
        panelGrafico.setOpaque(false);
        panelBranco.add(panelGrafico, "cell 1 0,grow");

        add(panelBranco, "cell 0 1,grow,gap 30 30 30 30");

        // Adiciona o gráfico
        adicionarGrafico();
    }

    private JPanel criarPainelInfo() {
        RoundedPanel panel = new RoundedPanel(20);
        panel.setLayout(new MigLayout("insets 20", "[grow]", "[]20[]20[]30[]"));
        panel.setBackground(new Color(229, 206, 210));
        panel.setPreferredSize(new Dimension(400, 400));

        // Título Categorias
        JLabel lblCategorias = new JLabel("Categorias");
        lblCategorias.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblCategorias.setForeground(new Color(80, 40, 40));
        panel.add(lblCategorias, "cell 0 0");

        // Descrição
        JLabel lblDescricao = new JLabel("<html>O gráfico ao lado mostra a porcentagem de divisão da<br>renda utilizada em cada Categoria de seus Projetos.<br><br>Ao todo, você direcionou:</html>");
        lblDescricao.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblDescricao.setForeground(new Color(60, 30, 30));
        panel.add(lblDescricao, "cell 0 1");

        // Total
        JLabel lblTotal = new JLabel("Total: R$");
        lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTotal.setForeground(new Color(80, 40, 40));
        panel.add(lblTotal, "cell 0 2");

        JLabel lblProjetos = new JLabel("para seus Projetos.");
        lblProjetos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblProjetos.setForeground(new Color(60, 30, 30));
        panel.add(lblProjetos, "cell 0 2,gaptop 5");

        // Legendas
        JPanel panelLegendas = new JPanel(new MigLayout("insets 0", "[]20[]", "[]10[]10[]"));
        panelLegendas.setOpaque(false);

        // Coluna 1
        adicionarLegenda(panelLegendas, new Color(112, 49, 49), "Bens e Aquisições", 0, 0);
        adicionarLegenda(panelLegendas, new Color(207, 114, 116), "Viagens e Lazer", 0, 1);
        adicionarLegenda(panelLegendas, new Color(165, 51, 46), "Reserva Financeira", 0, 2);

        // Coluna 2
        adicionarLegenda(panelLegendas, new Color(165, 51, 46), "Educação", 1, 0);
        adicionarLegenda(panelLegendas, new Color(242, 151, 151), "Eventos", 1, 1);
        adicionarLegenda(panelLegendas, new Color(202, 196, 190), "Saúde e Bem-Estar", 1, 2);

        panel.add(panelLegendas, "cell 0 3");

        return panel;
    }

    private void adicionarLegenda(JPanel panel, Color cor, String texto, int col, int row) {
        JPanel circulo = new JPanel();
        circulo.setBackground(cor);
        circulo.setPreferredSize(new Dimension(16, 16));
        circulo.setBorder(BorderFactory.createLineBorder(cor));
        
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        label.setForeground(new Color(60, 30, 30));
        
        panel.add(circulo, "cell " + col + " " + row + ",aligny center");
        panel.add(label, "cell " + col + " " + row + ",aligny center");
    }

    private void adicionarGrafico() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Categoria 1", 40);
        dataset.setValue("Categoria 2", 16);
        dataset.setValue("Categoria 3", 8);
        dataset.setValue("Categoria 4", 24);
        dataset.setValue("Categoria 5", 8);
        dataset.setValue("Categoria 6", 4);

        JFreeChart chart = ChartFactory.createPieChart(
            null, dataset, false, false, false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionPaint("Categoria 1", new Color(112, 49, 49));
        plot.setSectionPaint("Categoria 2", new Color(165, 51, 46));
        plot.setSectionPaint("Categoria 3", new Color(202, 196, 190));
        plot.setSectionPaint("Categoria 4", new Color(207, 114, 116));
        plot.setSectionPaint("Categoria 5", new Color(242, 151, 151));
        plot.setSectionPaint("Categoria 6", new Color(229, 175, 177));

        // Remove fundo
        chart.setBackgroundPaint(new Color(0, 0, 0, 0));
        plot.setBackgroundPaint(new Color(0, 0, 0, 0));

        // Remove sombras e bordas
        plot.setOutlineVisible(false);
        plot.setShadowPaint(null);

        // Adiciona as porcentagens ao redor do gráfico (fora das fatias)
        plot.setLabelFont(new Font("Segoe UI", Font.BOLD, 14));
        plot.setLabelPaint(new Color(60, 30, 30));
        plot.setLabelBackgroundPaint(null);
        plot.setLabelOutlinePaint(null);
        plot.setLabelShadowPaint(null);
        plot.setSimpleLabels(false);
        plot.setLabelGap(0.05); // Distância das fatias
        
        // Formato para mostrar apenas a porcentagem
        plot.setLabelGenerator(new org.jfree.chart.labels.StandardPieSectionLabelGenerator("{2}"));

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setOpaque(false);
        chartPanel.setBackground(new Color(0, 0, 0, 0));
        chartPanel.setPreferredSize(new Dimension(400, 400));
        chartPanel.setPopupMenu(null);

        panelGrafico.removeAll();
        panelGrafico.add(chartPanel, BorderLayout.CENTER);
        panelGrafico.revalidate();
        panelGrafico.repaint();
    }

    // Classe interna para criar painéis com bordas arredondadas
    private class RoundedPanel extends JPanel {
        private int cornerRadius;

        public RoundedPanel(int radius) {
            super();
            this.cornerRadius = radius;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
            g2.dispose();
            super.paintComponent(g);
        }
    }
}