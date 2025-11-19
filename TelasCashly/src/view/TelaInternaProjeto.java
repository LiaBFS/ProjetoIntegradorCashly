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
	private JTable table;
	private JButton btnAdicionarLancamento;
	private JLabel lblDescricaoProjeto;
	private JLabel lblTotalProjeto;
	private JLabel lblNomeProjeto;
	private JLabel lblObjetivoR;
	
	public static void aplicarEstilo(JTable table) {
      
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
		setLayout(new MigLayout("", "[grow 3][grow 8][500px][grow 8][grow 3]", "[grow 5][grow][][grow 10]"));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 1 1 3 3,grow");
		panel_1.setLayout(new BorderLayout(0, 0));
		

		
		 	Color fundoTabela = new Color(255, 245, 234);   // bege claro
		    Color corTexto = new Color(207, 114, 116);        // marrom escuro
		    Color corGrade = new Color(110, 60, 56);      // marrom suave
		    Color corGradeCabeçalho = new Color(92, 48, 45);
		    
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
		
		
		JPanelComBackground panel_2 = new JPanelComBackground("/imgs/FundoHeaderProjeto.png");
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new MigLayout("insets 35 10 30 10", "[0][][grow][][0]", "[grow 10][][][][grow 5][][grow 10][]"));
		panel_2.setOpaque(false);
		
		lblNomeProjeto = new JLabel("Nome Projeto");
		lblNomeProjeto.setForeground(new Color(255, 245, 234));
		lblNomeProjeto.setBackground(new Color(255, 245, 234));
		lblNomeProjeto.setFont(new Font("Carlito", Font.BOLD, 20));
		panel_2.add(lblNomeProjeto, "cell 1 2");
		
		lblTotalProjeto = new JLabel("Total R$:");
		lblTotalProjeto.setForeground(new Color(72, 53, 40));
		lblTotalProjeto.setBackground(new Color(255, 245, 234));
		lblTotalProjeto.setFont(new Font("Carlito", Font.BOLD, 20));
		panel_2.add(lblTotalProjeto, "cell 3 2,alignx right");
		
		lblDescricaoProjeto = new JLabel("Descricao");
		lblDescricaoProjeto.setForeground(new Color(255, 245, 234));
		lblDescricaoProjeto.setBackground(new Color(255, 245, 234));
		lblDescricaoProjeto.setFont(new Font("Carlito", Font.BOLD, 20));
		panel_2.add(lblDescricaoProjeto, "cell 1 3");
		
		lblObjetivoR = new JLabel("Objetivo R$:");
		lblObjetivoR.setForeground(new Color(72, 53, 40));
		lblObjetivoR.setFont(new Font("Carlito", Font.BOLD, 20));
		lblObjetivoR.setBackground(new Color(255, 245, 234));
		panel_2.add(lblObjetivoR, "cell 3 3,alignx right");
		
		JLabel lblAdicionar = new JLabel("");
		panel_2.add(lblAdicionar, "flowx,cell 1 5");
		
		btnAdicionarLancamento = new JButton("");
		btnAdicionarLancamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		btnAdicionarLancamento.setIcon(new ImageIcon(TelaInternaProjeto.class.getResource("/imgs/BtnAdicionarLancamento.png")));
		panel_2.add(btnAdicionarLancamento, "cell 4 5,growx,aligny center");
		btnAdicionarLancamento.setBorderPainted(false);
		btnAdicionarLancamento.setContentAreaFilled(false);
		btnAdicionarLancamento.setFocusPainted(false);
		btnAdicionarLancamento.setOpaque(false);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 40));
		table.setRowHeight(30);
		panel_1.add(table, BorderLayout.CENTER);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"VALOR DO LAN\u00C7AMENTO", "DATA"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		

		
		// Cabeçalho estilizado
		
		table.getTableHeader().setBackground(fundoTabela);
		table.getTableHeader().setForeground(corTexto);
		table.getTableHeader().setFont(new Font("Carlito", Font.BOLD, 30));
		table.getTableHeader().setOpaque(true);
		
		table.getTableHeader().setBorder(
			    BorderFactory.createMatteBorder(0, 0, 2, 0, corGradeCabeçalho)
			);
		table.setGridColor(corGrade);
		table.setDefaultRenderer(Object.class, renderer);
		
		table.setBackground(fundoTabela);
		table.setFillsViewportHeight(true);
        
		JScrollPane scrollPane = new JScrollPane(table);
		panel_1.add(scrollPane, BorderLayout.CENTER);
		

	}

	


	public JLabel getLblDataProjeto() {
		return lblTotalProjeto;
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
	
	public JTable getTable() {
	    return table;
	}

	public JLabel getLblObjetivoR() {
	    return lblObjetivoR;
	}

}
	


	
