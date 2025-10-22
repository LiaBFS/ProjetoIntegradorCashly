package view;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.block.BlockContainer;
import org.jfree.chart.block.BorderArrangement;
import org.jfree.chart.block.LabelBlock;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.ui.RectangleInsets;
import net.miginfocom.swing.MigLayout;
import java.awt.SystemColor;
 public class TelaInternaGráficos extends JFrame {
 
 public TelaInternaGráficos() {
 setBackground(new Color(0, 0, 0));
 setTitle("Gráfico de Categorias");
 setSize(600, 400);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
 // Dados do gráfico
 DefaultPieDataset dataset = new DefaultPieDataset();
 dataset.setValue("Categoria 1", 71.4);
 dataset.setValue("Categoria 2", 20.0);
 dataset.setValue("Categoria 3", 5.0);
 dataset.setValue("Categoria 4", 3.6);

 // Criando o gráfico
 JFreeChart grafico = ChartFactory.createPieChart(
 "Evolução das Metas",
 dataset,
 true, // legenda
 true, // tooltips
 false // URLs
 );
 
 grafico.setBackgroundPaint(new Color(255, 240, 220)); 
 
 PiePlot plot = (PiePlot) grafico.getPlot();
 plot.setBackgroundPaint(new Color(255, 240, 220)); // fundo interno do gráfico
 plot.setOutlineVisible(false);
 
 plot.setLabelGenerator(
         new StandardPieSectionLabelGenerator("{2}") // apenas o percentual
     );
     plot.setLabelFont(new Font("SansSerif", Font.BOLD, 12));
     plot.setLabelPaint(Color.DARK_GRAY);
     
     grafico.getLegend().setItemFont(new Font("SansSerif", Font.PLAIN, 13));
     grafico.getLegend().setPosition(RectangleEdge.LEFT);
     grafico.getLegend().setFrame(BlockBorder.NONE);
     grafico.getLegend().setBackgroundPaint(new Color(255, 245, 230));
     
     //grafico.getLegend().setMargin(new RectangleInsets(30, 0, 0, 0));
     
     BlockContainer wrapper = new BlockContainer(new BorderArrangement());
     wrapper.add(grafico.getLegend().getItemContainer(), RectangleEdge.TOP);
     wrapper.add(new LabelBlock(" "), RectangleEdge.TOP); // espaço extra
     wrapper.setFrame(new BlockBorder(new Color(200, 200, 200))); // borda cinza clara
     grafico.getLegend().setWrapper(wrapper);
 
 // Adiciona o gráfico ao painel Swing
 ChartPanel painel = new ChartPanel(grafico);
 painel.setBackground(SystemColor.activeCaption);
 setContentPane(painel);
 painel.setLayout(new MigLayout("", "[]", "[]"));
 
 plot.setSectionPaint("Categoria 1", new Color(193, 31, 35));
 plot.setSectionPaint("Categoria 2", new Color(242, 151, 151));
 plot.setSectionPaint("Categoria 3", new Color(202, 196, 190));
 plot.setSectionPaint("Categoria 4", new Color(214, 196, 190));
 
 grafico.setBackgroundPaint(new Color(255, 245, 230));
 
 
 TextTitle titulo = new TextTitle("Evolução das Metas");
 titulo.setFont(new Font("SansSerif", Font.BOLD, 22));
 titulo.setPaint(new Color(60, 30, 30));
 titulo.setPosition(RectangleEdge.TOP); // posição do título
 grafico.setTitle(titulo);
 }
 
 
 
 

 
 public static void main(String[] args) {
 SwingUtilities.invokeLater(() -> new TelaInternaGráficos().setVisible(true));
 }
 
 
 }