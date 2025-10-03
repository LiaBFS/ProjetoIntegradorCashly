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

	private ProjetoDAO projetoDAO;
	private JPanel panel_1;
	private JPanelComBackground panel_2;
	private JPanelComBackground panel_3;
	private JPanelComBackground panel_4;

	/**
	 * Create the panel.
	 */
	public TelaInternaCriar() {

		this.projetoDAO = new ProjetoDAO();

		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[][grow][]", "[][grow][]"));

		JPanelComBackground panel = new JPanelComBackground("/imgs/FundoCriarProjeto2.png");
		add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[49][grow][grow][grow][49]",
				"[][][grow 55][][grow][][grow 15][][grow 15][][grow 55]"));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(207, 114, 116));
		panel.add(panel_1, "cell 2 3 1 6,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow][]", "[grow][grow][grow]"));

		panel_2 = new JPanelComBackground("/imgs/NomeProjeto.png");
		panel_2.setBackground(new Color(207, 114, 116));
		panel_1.add(panel_2, "cell 0 0 4 1,grow");
		panel_2.setLayout(new MigLayout("", "[100][grow][]", "[][grow][]"));

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
		panel_3.setLayout(new MigLayout("", "[100][grow][]", "[][grow][]"));

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
		panel_4.setLayout(new MigLayout("", "[100][grow][]", "[][grow][]"));

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

		btnCriar = new JButton("");
		btnCriar.setIcon(new ImageIcon(TelaInternaCriar.class.getResource("/imgs/btnCriar.png")));
		btnCriar.setOpaque(false);
		btnCriar.setFocusPainted(false);
		btnCriar.setContentAreaFilled(false);
		btnCriar.setBorderPainted(false);
		panel.add(btnCriar, "cell 2 9,alignx center,growy");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = tfNomeProjeto.getText();
				String descricao = tfDescricaoProjeto.getText();
				String saldoTexto = tfSaldo.getText();

				if (nome.equals(placeholderNomeProjeto) || descricao.equals(placeholderDescricao)
						|| saldoTexto.equals(placeholderSaldo) || nome.isEmpty() || descricao.isEmpty()
						|| saldoTexto.isEmpty()) {

					JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios.",
							"Erro na Criação do Projeto", JOptionPane.ERROR_MESSAGE);
					return;
				}

				double saldo = 0.0;
				try {

					saldo = Double.parseDouble(saldoTexto.replace(",", "."));
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Saldo inválido. Digite apenas números!",
							"Erro na Criação do Projeto", JOptionPane.ERROR_MESSAGE);
					return;
				}

				model.Projeto novoProjeto = new model.Projeto();
				novoProjeto.setNome(nome);
				novoProjeto.setDescricao(descricao);
				novoProjeto.setSaldo(saldo);

				projetoDAO.adicionarProjeto(novoProjeto);
			}
		});

	}

}
