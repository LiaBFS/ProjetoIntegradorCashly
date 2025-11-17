package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

import model.CategoriaDeProjeto;
import model.ProjetoDAO;
import model.UsuarioDAO;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class TelaInternaCriar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnCriar;
	private String placeholderNomeProjeto = "Nome do Projeto";
	private String placeholderDescricao = "Descrição do Projeto";
	private String placeholderSaldo = "Saldo Atual";
	private String placeholderObjetivo = "Objetivo Final";
	private String placeholderCategoria = "Categoria do Projeto";
	private JTextField tfNomeProjeto;
	private JTextField tfDescricaoProjeto;
	private JTextField tfSaldo;
	private JTextField tfObjetivo;
	private JComboBox cbCategoria;

	/**
	 * Create the panel.
	 */
	public TelaInternaCriar() {
		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[][grow][]", "[][grow][]"));

		JPanelComBackground panel = new JPanelComBackground("/imgs/FundoCriarProjeto2.png");
		add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[94][grow][94]", "[90px][grow][grow][grow 30]"));

																										
		btnCriar = new JButton("");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				}
			});
																												
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "cell 1 1 1 2,grow");
		panel_1.setOpaque(false);
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow]"));
		
		JPanelComBackground panel_2 = new JPanelComBackground("/imgs/NomeProjetoPT2.png");
		panel_2.setBackground(new Color(207, 114, 116));
		panel_1.add(panel_2, "cell 0 0 3 1,grow");
		panel_2.setLayout(null);
		
		tfNomeProjeto = new JTextField();
		tfNomeProjeto.setBounds(158, 50, 613, 31);
		tfNomeProjeto.setForeground(new Color(153, 131, 116));
		tfNomeProjeto.setFont(new Font("Carlito", Font.PLAIN, 25));
		panel_2.add(tfNomeProjeto);
		tfNomeProjeto.setColumns(10);
		tfNomeProjeto.setText(placeholderNomeProjeto);
		tfNomeProjeto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfNomeProjeto.getText().equals(placeholderNomeProjeto)) {
					tfNomeProjeto.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (tfNomeProjeto.getText().isEmpty()) {
					tfNomeProjeto.setText(placeholderNomeProjeto);
				}
			}
		});
		tfNomeProjeto.setOpaque(false);
		tfNomeProjeto.setBorder(BorderFactory.createEmptyBorder());
		
		
		
		JPanelComBackground panel_3 = new JPanelComBackground("/imgs/DescricaoProjetoPT2.png");
		panel_3.setBackground(new Color(207, 114, 116));
		panel_1.add(panel_3, "cell 0 1 3 1,grow");
		panel_3.setLayout(null);
		
		tfDescricaoProjeto = new JTextField();
		tfDescricaoProjeto.setBounds(165, 49, 695, 31);
		tfDescricaoProjeto.setForeground(new Color(153, 131, 116));
		tfDescricaoProjeto.setFont(new Font("Carlito", Font.PLAIN, 25));
		panel_3.add(tfDescricaoProjeto);
		tfDescricaoProjeto.setColumns(10);
		tfDescricaoProjeto.setText(placeholderDescricao);
		tfDescricaoProjeto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfDescricaoProjeto.getText().equals(placeholderDescricao)) {
					tfDescricaoProjeto.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (tfDescricaoProjeto.getText().isEmpty()) {
					tfDescricaoProjeto.setText(placeholderDescricao);
				}
			}
		});
		tfDescricaoProjeto.setOpaque(false);
		tfDescricaoProjeto.setBorder(BorderFactory.createEmptyBorder());
		
		
		JPanelComBackground panel_4 = new JPanelComBackground("/imgs/SaldoInicialPT2.png");
		panel_4.setBackground(new Color(207, 114, 116));
		panel_1.add(panel_4, "cell 0 2,grow");
		panel_4.setLayout(null);
		
		tfSaldo = new JTextField();
		tfSaldo.setBounds(108, 54, 148, 31);
		tfSaldo.setForeground(new Color(153, 131, 116));
		tfSaldo.setFont(new Font("Carlito", Font.PLAIN, 25));
		panel_4.add(tfSaldo);
		tfSaldo.setColumns(10);
		tfSaldo.setText(placeholderSaldo);
		tfSaldo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfSaldo.getText().equals(placeholderSaldo)) {
					tfSaldo.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (tfSaldo.getText().isEmpty()) {
					tfSaldo.setText(placeholderSaldo);
				}
			}
		});
		tfSaldo.setOpaque(false);
		tfSaldo.setBorder(BorderFactory.createEmptyBorder());
		
		JPanelComBackground panel_5 = new JPanelComBackground("/imgs/ObjetivoPT2.png");
		panel_5.setBackground(new Color(207, 114, 116));
		panel_1.add(panel_5, "cell 2 2,grow");
		panel_5.setLayout(null);

		tfObjetivo = new JTextField();
		tfObjetivo.setBounds(101, 53, 175, 31);
		tfObjetivo.setForeground(new Color(153, 131, 116));
		tfObjetivo.setFont(new Font("Carlito", Font.PLAIN, 25));
		panel_5.add(tfObjetivo);		
		tfObjetivo.setColumns(10);
		tfObjetivo.setText(placeholderObjetivo);
		tfObjetivo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfObjetivo.getText().equals(placeholderObjetivo)) {
					tfObjetivo.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (tfObjetivo.getText().isEmpty()) {
					tfObjetivo.setText(placeholderObjetivo);
				}
			}
		});
		tfObjetivo.setOpaque(false);
		tfObjetivo.setBorder(BorderFactory.createEmptyBorder());
		
		
		JPanelComBackground panel_6 = new JPanelComBackground("/imgs/CategoriaProjetoPT2.png");
		panel_6.setBackground(new Color(207, 114, 116));
		panel_1.add(panel_6, "cell 0 3 3 1,grow");
		panel_6.setLayout(null);
		
		
		cbCategoria = new JComboBox<CategoriaDeProjeto>();
		cbCategoria.setForeground(new Color(153, 131, 116));
		cbCategoria.setFont(new Font("Carlito", Font.PLAIN, 25));
		panel_6.add(cbCategoria);
		cbCategoria.setOpaque(false);
		cbCategoria.setBorder(BorderFactory.createEmptyBorder());
		
for (CategoriaDeProjeto iterable_element : CategoriaDeProjeto.values()) {
	cbCategoria.addItem(iterable_element);
	
}

		
		btnCriar.setIcon(new ImageIcon(TelaInternaCriar.class.getResource("/imgs/btnCriar.png")));
		btnCriar.setOpaque(false);
		btnCriar.setFocusPainted(false);
		btnCriar.setContentAreaFilled(false);
		btnCriar.setBorderPainted(false);
		panel.add(btnCriar, "cell 1 3,alignx center,growy");
		

	}
	

	public String getPlaceholderCategoria() {
		return placeholderCategoria;
	}

	
	public String getPlaceholderNomeProjeto() {
		return placeholderNomeProjeto;
	}


	public String getPlaceholderDescricao() {
		return placeholderDescricao;
	}


	public String getPlaceholderSaldo() {
		return placeholderSaldo;
	}
	
	public String getPlaceholderObjetivo() {
		return placeholderObjetivo;
	}

	public JComboBox getCbCategoria() {
		return cbCategoria;
	}

	public JTextField getTfNomeProjeto() {
		return tfNomeProjeto;
	}


	public JTextField getTfDescricaoProjeto() {
		return tfDescricaoProjeto;
	}


	public JTextField getTfSaldo() {
		return tfSaldo;
	}
	
	
	public JButton getBtnCriar() {
		return btnCriar;
	}


	public JTextField getTfObjetivo() {
		return tfObjetivo;
	}

}
