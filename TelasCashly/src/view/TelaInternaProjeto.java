package view;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.BorderLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class TelaInternaProjeto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnIrGraficos;
	private JTable table;
	private JButton btnAdicionarLancamento;
	private JLabel lblDescricaoProjeto;
	private JLabel lblDataProjeto;
	private JLabel lblNomeProjeto;

	/**
	 * Create the panel.
	 */
	public TelaInternaProjeto() {
		setBackground(new Color(216, 178, 186));
		setLayout(new MigLayout("", "[grow 10][500px][grow 8][][grow 10]", "[grow 10][grow][][grow 10]"));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 1 1 1 2,grow");
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"VALOR DO LAN\u00C7AMENTO", "CATEGORIA", "DATA"
			}
		));
		
		scrollPane.setViewportView(table);
		
		JPanelComBackground panel_2 = new JPanelComBackground("/imgs/FundoHeaderProjeto.png");
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new MigLayout("", "[0][][grow][][0]", "[grow 10][][][grow 5][][grow 10]"));
		
		lblNomeProjeto = new JLabel("Nome Projeto");
		panel_2.add(lblNomeProjeto, "cell 1 1");
		
		lblDataProjeto = new JLabel("Data");
		panel_2.add(lblDataProjeto, "cell 3 1");
		
		lblDescricaoProjeto = new JLabel("Descricao");
		panel_2.add(lblDescricaoProjeto, "cell 1 2");
		
		JLabel lblAdicionar = new JLabel("");
		panel_2.add(lblAdicionar, "cell 1 4");
		
		btnAdicionarLancamento = new JButton("");
		btnAdicionarLancamento.setIcon(new ImageIcon(TelaInternaProjeto.class.getResource("/imgs/BtnAdicionarLancamento.png")));
		panel_2.add(btnAdicionarLancamento, "cell 3 4,growx,aligny center");
		btnAdicionarLancamento.setBorderPainted(false);
		btnAdicionarLancamento.setContentAreaFilled(false);
		btnAdicionarLancamento.setFocusPainted(false);
		btnAdicionarLancamento.setOpaque(false);
		
		
		
		JPanel panel = new JPanel();
		add(panel, "cell 3 1,grow");
		
		
		btnIrGraficos = new JButton("");
		btnIrGraficos.setMargin(new Insets(2, 2, 2, 2));
		btnIrGraficos.setIcon(new ImageIcon(TelaInternaProjeto.class.getResource("/imgs/BtnGrafico.png")));
		add(btnIrGraficos, "cell 3 2,grow");
		btnIrGraficos.setBorderPainted(false);
		btnIrGraficos.setContentAreaFilled(false);
        btnIrGraficos.setFocusPainted(false);
        btnIrGraficos.setOpaque(false);
        
        

	}
	
	
	public void adicionarLancamento(ActionListener actionListener) {
		this.btnAdicionarLancamento.addActionListener(actionListener);
	}
	
	public void irTelaGraficos(ActionListener actionListener) {
		this.btnIrGraficos.addActionListener(actionListener);
	}
	

	public JButton getBtnIrGraficos() {
		return btnIrGraficos;
	}



	public JLabel getLblDataProjeto() {
		return lblDataProjeto;
	}



	public JLabel getLblNomeProjeto() {
		return lblNomeProjeto;
	}



	public JLabel getLblDescricaoProjeto() {
		return lblDescricaoProjeto;
	}



	public JButton getBtnAdicionarLancamento() {
		return btnAdicionarLancamento;
	}



	public JButton getBtnNewButton() {
		return btnIrGraficos;
	}

}

