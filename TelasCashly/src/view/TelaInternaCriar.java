package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;

import model.ProjetoDAO;
import model.UsuarioDAO;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TelaInternaCriar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeProjeto;
	private JTextField tfDescricaoProjeto;
	private JButton btnCriar;
	private JTextField tfSaldo;
	private String placeholderNomeProjeto = "Nome do Projeto";
	private String placeholderDescricao = "Descrição do Projeto";
	private String placeholderSaldo = "Saldo Atual Disponível para o Projeto";
	private String placeholderObjetivo = "Objetivo Final";


	
	private JPanel panel_1;
	private JPanelComBackground panel_2;
	private JPanelComBackground panel_3;
	private JPanelComBackground panel_4;
	private JPanelComBackground panel_5;
	private JTextField tfObjetivo;

	/**
	 * Create the panel.
	 */
	public TelaInternaCriar() {

		

		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[][grow][]", "[][grow][]"));

		JPanelComBackground panel = new JPanelComBackground("/imgs/FundoCriarProjeto2.png");
		add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[52][grow][grow][grow][52]", "[][][grow 55][][grow][][grow 15][][grow 15][][grow 55]"));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(207, 114, 116));
		panel.add(panel_1, "cell 2 4 1 5,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow]", "[50px,grow][100px,grow][50px,grow][50px,grow]"));

		panel_2 = new JPanelComBackground("/imgs/NomeProjeto.png");
		panel_2.setBackground(new Color(207, 114, 116));
		panel_1.add(panel_2, "cell 0 0 4 1,grow");
		panel_2.setLayout(new MigLayout("", "[100px][grow][0]", "[][grow][]"));

		tfNomeProjeto = new JTextField();
		tfNomeProjeto.setForeground(new Color(153, 131, 116));
		tfNomeProjeto.setFont(new Font("Tahoma", Font.PLAIN, 16));
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

		tfNomeProjeto.setBackground(new Color(255, 245, 234));
		panel_2.add(tfNomeProjeto, "cell 1 1,growx");
		tfNomeProjeto.setColumns(10);
		tfNomeProjeto.setBorder(BorderFactory.createEmptyBorder());

		panel_3 = new JPanelComBackground("/imgs/DescricaoProjeto.png");
		panel_3.setBackground(new Color(207, 114, 116));
		panel_1.add(panel_3, "cell 0 1 4 1,grow");
		panel_3.setLayout(new MigLayout("", "[100px][grow][0]", "[][grow][]"));

		tfDescricaoProjeto = new JTextField();
		tfDescricaoProjeto.setForeground(new Color(153, 131, 116));
		tfDescricaoProjeto.setFont(new Font("Tahoma", Font.PLAIN, 16));
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

		tfDescricaoProjeto.setBackground(new Color(255, 245, 234));
		panel_3.add(tfDescricaoProjeto, "cell 1 1,growx");
		tfDescricaoProjeto.setColumns(10);
		tfDescricaoProjeto.setBorder(BorderFactory.createEmptyBorder());
		
				panel_4 = new JPanelComBackground("/imgs/SaldoInicialProjeto.png");
				panel_4.setBackground(new Color(207, 114, 116));
				panel_1.add(panel_4, "cell 0 2 4 1,grow");
				panel_4.setLayout(new MigLayout("", "[100px][grow][0]", "[][grow][]"));
				
						tfSaldo = new JTextField();
						tfSaldo.setForeground(new Color(153, 131, 116));
						tfSaldo.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
						
								tfSaldo.setBackground(new Color(255, 245, 234));
								panel_4.add(tfSaldo, "cell 1 1,growx");
								tfSaldo.setColumns(10);
								tfSaldo.setBorder(BorderFactory.createEmptyBorder());
								
								panel_5 = new JPanelComBackground("/imgs/objetivoFinal.png");
								panel_5.setBackground(new Color(207, 114, 116));
								panel_1.add(panel_5, "cell 0 3 4 1,grow");
								panel_5.setLayout(new MigLayout("", "[100px][grow][0]", "[][grow][]"));
								
								
								
						tfObjetivo = new JTextField();
						tfObjetivo.setForeground(new Color(153, 131, 116));
						tfObjetivo.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
								
						tfObjetivo.setColumns(10);
						tfObjetivo.setBorder(BorderFactory.createEmptyBorder());
						tfObjetivo.setBackground(new Color(255, 245, 234));
						panel_5.add(tfObjetivo, "cell 1 1 2 1,growx");
								
										btnCriar = new JButton("");
										btnCriar.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
											}
										});
										btnCriar.setIcon(new ImageIcon(TelaInternaCriar.class.getResource("/imgs/btnCriar.png")));
										btnCriar.setOpaque(false);
										btnCriar.setFocusPainted(false);
										btnCriar.setContentAreaFilled(false);
										btnCriar.setBorderPainted(false);
										panel.add(btnCriar, "cell 2 9,alignx center,growy");
		

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
