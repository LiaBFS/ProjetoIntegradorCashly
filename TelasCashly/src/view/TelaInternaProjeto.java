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
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TelaInternaProjeto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnIrGraficos;
	private JTable table;
	private JButton btnAdicionarLancamento;
	private JLabel lblDescricaoProjeto;
	private JLabel lblDataProjeto;
	private JLabel lblNomeProjeto;
	
	public static void aplicarEstilo(JTable table) {
        // ======= CABEÇALHO =======
        table.getTableHeader().setBackground(new Color(200, 200, 255)); // azul claro
        table.getTableHeader().setForeground(Color.DARK_GRAY);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
        table.getTableHeader().setOpaque(true);
        table.setRowHeight(25);
	}
	
	
	

	
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
		
		 	Color fundoTabela = new Color(255, 245, 234);   // bege claro
		    Color corTexto = new Color(207, 114, 116);        // marrom escuro
		    Color corGrade = new Color(110, 60, 56);      // marrom suave
		    Color corGradeCabeçalho = new Color(92, 48, 45);
		    
		    // Cabeçalho estilizado
		    
		    table.getTableHeader().setBackground(fundoTabela);
		    table.getTableHeader().setForeground(corTexto);
		    table.getTableHeader().setFont(new Font("Carlito", Font.BOLD, 13));
		    table.getTableHeader().setOpaque(true);
		    
		    table.getTableHeader().setBorder(
		    	    BorderFactory.createMatteBorder(0, 0, 2, 0, corGradeCabeçalho)
		    	);
		    table.setGridColor(corGrade);
		    
		    DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
		        @Override
		        public Component getTableCellRendererComponent(JTable table, Object value,
		                                                       boolean isSelected, boolean hasFocus,
		                                                       int row, int column) {
		            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

		            // Fundo bege
		            c.setBackground(fundoTabela);

		            // Texto marrom escuro
		            c.setForeground(corTexto);
		            c.setFont(new Font("SansSerif", Font.PLAIN, 13));

		            // Se estiver selecionado, muda o fundo levemente
		            if (isSelected) {
		                c.setBackground(new Color(255, 232, 215)); // leve tom de destaque
		            }

		            return c;
		        }
		    };
		    table.setDefaultRenderer(Object.class, renderer);
		    
		    table.setBackground(fundoTabela);
		
		
		JPanelComBackground panel_2 = new JPanelComBackground("/imgs/FundoHeaderProjeto.png");
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new MigLayout("insets 35 10 30 10", "[0][][grow][][0]", "[grow 10][][][grow 5][][grow 10]"));
		
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

