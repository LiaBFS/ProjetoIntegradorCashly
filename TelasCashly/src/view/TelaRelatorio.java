package view;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TelaRelatorio extends JPanel {
	public TelaRelatorio() {
		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[][grow][]", "[][][grow][][][]"));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaRelatorio.class.getResource("/imgs/Relatorios.png")));
		add(lblNewLabel, "cell 1 1");
	}
		
		private void adicionarGrafico() {
			DefaultPieDataset dataset = new DefaultPieDataset();
		    dataset.setValue("Categoria 1", 40);
		    dataset.setValue("Categoria 2", 24);
		    dataset.setValue("Categoria 3", 16);
		    dataset.setValue("Categoria 4", 8);
		    dataset.setValue("Categoria 5", 8);

		    // ----- Gráfico -----
		    JFreeChart chart = ChartFactory.createPieChart(
		        null,
		        dataset,
		        false,
		        false,
		        false
		    );

		    PiePlot plot = (PiePlot) chart.getPlot();
		    plot.setOutlineVisible(false);
		    plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{2}"));

		    // ----- ChartPanel -----
		    ChartPanel chartPanel = new ChartPanel(chart);
		    chartPanel.setOpaque(false);
		    chartPanel.setBackground(new Color(255, 255, 255, 0));
		    chartPanel.setPreferredSize(chartPanel.getSize()); // <- IMPORTANTÍSSIMO

		    // ----- Adiciona no painel da sua tela -----
		    chartPanel.setLayout(new BorderLayout());
		    chartPanel.removeAll();     // limpa conteúdo
		    chartPanel.add(chartPanel); // coloca o gráfico
		    chartPanel.revalidate();
		    chartPanel.repaint();
		}
		
	}
	


	
