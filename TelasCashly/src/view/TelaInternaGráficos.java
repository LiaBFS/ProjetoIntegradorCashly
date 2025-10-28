package view;

import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

public class TelaInternaGráficos extends JFrame {

    public TelaInternaGráficos() {
        setTitle("Gráfico de Categorias");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(250, 240, 230)); // cor de fundo bege clara

        // Layout principal
        setLayout(new MigLayout("wrap, fillx, insets 20", "[grow]", "[][][grow][]"));

        // --- TÍTULO ---
        JLabel titulo = new JLabel("Gráfico de Categorias");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 26));
        titulo.setForeground(new Color(90, 40, 30));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(titulo, "growx, gapbottom 5");

        // --- DESCRIÇÃO ---
        JLabel descricao = new JLabel(
            "<html>O gráfico abaixo mostra a porcentagem da quantidade de renda utilizada em cada Categoria cadastrada.</html>"
        );
        descricao.setFont(new Font("SansSerif", Font.PLAIN, 14));
        descricao.setForeground(new Color(100, 70, 60));
        add(descricao, "growx, gapbottom 10");

        // --- DADOS DO GRÁFICO ---
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Categoria 1", 31.25);
        dataset.setValue("Categoria 2", 25.0);
        dataset.setValue("Categoria 3", 12.5);
        dataset.setValue("Categoria 4", 31.25);


        // --- CRIAÇÃO DO GRÁFICO ---
        JFreeChart grafico = ChartFactory.createPieChart(null, dataset, false, true, false);
        PiePlot plot = (PiePlot) grafico.getPlot();

        // Estilo do gráfico
        plot.setBackgroundPaint(new Color(250, 240, 230));
        plot.setOutlineVisible(false);
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{2}")); // mostra apenas porcentagem
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 13));
        plot.setLabelPaint(new Color(60, 40, 40));
        plot.setLabelBackgroundPaint(new Color(0, 0, 0, 0));
        plot.setLabelShadowPaint(null);
        plot.setLabelOutlinePaint(null);

        // cores das seções
        plot.setSectionPaint("Categoria 1", new Color(193, 31, 35));
        plot.setSectionPaint("Categoria 2", new Color(242, 151, 151));
        plot.setSectionPaint("Categoria 3", new Color(202, 196, 190));
        plot.setSectionPaint("Categoria 4", new Color(214, 100, 160));

        // Painel do gráfico
        ChartPanel painelGrafico = new ChartPanel(grafico);
        painelGrafico.setPreferredSize(new Dimension(350, 300));
        painelGrafico.setBackground(new Color(250, 240, 230));

        // --- LEGENDA PERSONALIZADA ---
        JPanel legenda = new JPanel(new MigLayout("wrap 1, insets 10, align left"));
        legenda.setBackground(new Color(250, 240, 230));
        legenda.add(criarItemLegenda("Categoria 1", new Color(193, 31, 35)));
        legenda.add(criarItemLegenda("Categoria 2", new Color(242, 151, 151)));
        legenda.add(criarItemLegenda("Categoria 3", new Color(202, 196, 190)));
        legenda.add(criarItemLegenda("Categoria 4", new Color(214, 100, 160)));


        // --- BOTÃO “+” ---
        JButton botaoAdd = new JButton("+");
        botaoAdd.setFont(new Font("SansSerif", Font.BOLD, 18));
        botaoAdd.setFocusPainted(false);
        botaoAdd.setBackground(new Color(250, 240, 230));
        botaoAdd.setForeground(new Color(90, 60, 50));
        botaoAdd.setBorder(BorderFactory.createLineBorder(new Color(90, 60, 50), 1));
        botaoAdd.setPreferredSize(new Dimension(40, 40));
        botaoAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botaoAdd.setFocusable(false);
        botaoAdd.setToolTipText("Adicionar nova categoria");

        // Deixa o botão com bordas arredondadas
        botaoAdd.setContentAreaFilled(false);
        botaoAdd.setOpaque(false);
        botaoAdd.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(90, 60, 50), 1, true),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));

        legenda.add(botaoAdd, "gaptop 10, align left");

        // --- PAINEL CENTRAL (LEGENDA + GRÁFICO) ---
        JPanel centro = new JPanel(new MigLayout("fillx, insets 0", "[200!][grow]", "[grow]"));
        centro.setBackground(new Color(250, 240, 230));
        centro.add(legenda, "growy, left");
        centro.add(painelGrafico, "grow");

        add(centro, "growx, growy, gapbottom 10");

        // --- TEXTO FINAL ---
        JLabel rodape = new JLabel(
            "<html><i>* Caso alguma categoria não esteja presente no gráfico, cheque a lista de lançamentos e suas categorias.</i></html>"
        );
        rodape.setFont(new Font("SansSerif", Font.ITALIC, 13));
        rodape.setForeground(new Color(120, 90, 70));
        add(rodape, "growx, gaptop 10");
    }

    // Método para montar os itens de legenda com cor + nome
    private JPanel criarItemLegenda(String texto, Color cor) {
        JPanel item = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        item.setBackground(new Color(250, 240, 230));

        JPanel corBox = new JPanel();
        corBox.setPreferredSize(new Dimension(20, 20));
        corBox.setBackground(cor);
        corBox.setBorder(BorderFactory.createLineBorder(new Color(100, 80, 70), 1));

        JLabel label = new JLabel(texto);
        label.setFont(new Font("SansSerif", Font.PLAIN, 14));
        label.setForeground(new Color(90, 60, 50));

        item.add(corBox);
        item.add(label);
        return item;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaInternaGráficos().setVisible(true));
    }
}
