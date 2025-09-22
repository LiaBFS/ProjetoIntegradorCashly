package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaInternaPerfil extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TelaInternaPerfil() {
		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[][grow][]", "[][grow][]"));
		
		JPanelComBackground panel = new JPanelComBackground("/imgs/FundoPerfil.png");
		add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[0][100][500][500,grow][200px][100px][0]", "[150px][50px][][40,grow][][][60][][][60][][75px]"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 245, 234));
		panel.add(panel_1, "cell 2 3 3 7,grow");
		panel_1.setLayout(new MigLayout("", "[][][]", "[80px][][][][][][][][]"));
		
		JPanelComBackground panelFundoIcone = new JPanelComBackground("/imgs/FundoIcone.png");
		panel_1.add(panelFundoIcone, "cell 0 1,alignx left");
		panelFundoIcone.setBackground(new Color(255, 245, 234));
		panelFundoIcone.repaint();
		panelFundoIcone.setLayout(new MigLayout("", "[401][][][20][][][][][][401]", "[][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		panel_1.add(lblNewLabel_1, "cell 0 3");
		lblNewLabel_1.setForeground(new Color(72, 53, 40));
		lblNewLabel_1.setFont(new Font("Carlito", Font.BOLD, 18));
		
		JButton btnNewButton_4 = new JButton("Alterar Ícone");
		panel_1.add(btnNewButton_4, "cell 2 3");
		btnNewButton_4.setFont(new Font("Carlito", Font.BOLD, 19));
		btnNewButton_4.setForeground(new Color(255, 245, 234));
		btnNewButton_4.setBackground(new Color(207, 114, 116));
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 0 4,growx");
		textField_1.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Editar");
		panel_1.add(btnNewButton_3, "cell 2 4");
		btnNewButton_3.setFont(new Font("Carlito", Font.BOLD, 19));
		btnNewButton_3.setForeground(new Color(255, 245, 234));
		btnNewButton_3.setBackground(new Color(207, 114, 116));
		
		JLabel lblNewLabel = new JLabel("Endereço de Email");
		panel_1.add(lblNewLabel, "cell 0 5");
		lblNewLabel.setForeground(new Color(72, 53, 40));
		lblNewLabel.setFont(new Font("Carlito", Font.BOLD, 18));
		
		JButton btnNewButton_2 = new JButton("Editar");
		panel_1.add(btnNewButton_2, "cell 2 5");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Carlito", Font.BOLD, 19));
		btnNewButton_2.setForeground(new Color(255, 245, 234));
		btnNewButton_2.setBackground(new Color(207, 114, 116));
		
		textField = new JTextField();
		panel_1.add(textField, "cell 0 6,growx");
		textField.setColumns(10);
		
		JButton btnSair = new JButton("Sair");
		panel_1.add(btnSair, "cell 0 8");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSair.setFont(new Font("Carlito", Font.BOLD, 19));
		btnSair.setForeground(new Color(255, 245, 234));
		btnSair.setBackground(new Color(207, 114, 116));
		
		JButton btnExcluirPerfil = new JButton("Excluir Perfil");
		panel_1.add(btnExcluirPerfil, "cell 1 8");
		btnExcluirPerfil.setFont(new Font("Carlito", Font.BOLD, 19));
		btnExcluirPerfil.setForeground(new Color(255, 245, 234));
		btnExcluirPerfil.setBackground(new Color(193, 31, 35));
		btnExcluirPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

	}

}
