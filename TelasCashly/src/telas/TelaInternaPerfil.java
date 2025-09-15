package telas;

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
		panel.setLayout(new MigLayout("", "[100][][200px][][][][0]", "[150px][100px][][40][][][60][][][60][][75px]"));
		
		JPanelComBackground panelFundoIcone = new JPanelComBackground("/imgs/FundoIcone.png");
		panelFundoIcone.setBackground(new Color(255, 245, 234));
		panelFundoIcone.repaint();
		panel.add(panelFundoIcone, "cell 1 2,grow");
		panelFundoIcone.setLayout(new MigLayout("", "[401][][][20][][][][][][401]", "[][][]"));
		
		JButton btnNewButton_4 = new JButton("Alterar Ícone");
		btnNewButton_4.setFont(new Font("Carlito", Font.BOLD, 19));
		btnNewButton_4.setForeground(new Color(255, 245, 234));
		btnNewButton_4.setBackground(new Color(207, 114, 116));
		panel.add(btnNewButton_4, "cell 2 2,alignx left");
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setForeground(new Color(72, 53, 40));
		lblNewLabel_1.setFont(new Font("Carlito", Font.BOLD, 18));
		panel.add(lblNewLabel_1, "cell 1 4");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "cell 1 5,growx");
		textField_1.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Editar");
		btnNewButton_3.setFont(new Font("Carlito", Font.BOLD, 19));
		btnNewButton_3.setForeground(new Color(255, 245, 234));
		btnNewButton_3.setBackground(new Color(207, 114, 116));
		panel.add(btnNewButton_3, "cell 2 5");
		
		JLabel lblNewLabel = new JLabel("Endereço de Email");
		lblNewLabel.setForeground(new Color(72, 53, 40));
		lblNewLabel.setFont(new Font("Carlito", Font.BOLD, 18));
		panel.add(lblNewLabel, "cell 1 7");
		
		textField = new JTextField();
		panel.add(textField, "cell 1 8,growx");
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Editar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setFont(new Font("Carlito", Font.BOLD, 19));
		btnNewButton_2.setForeground(new Color(255, 245, 234));
		btnNewButton_2.setBackground(new Color(207, 114, 116));
		panel.add(btnNewButton_2, "cell 2 8");
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSair.setFont(new Font("Carlito", Font.BOLD, 19));
		btnSair.setForeground(new Color(255, 245, 234));
		btnSair.setBackground(new Color(207, 114, 116));
		panel.add(btnSair, "flowx,cell 1 10,alignx left");
		
		JButton btnExcluirPerfil = new JButton("Excluir Perfil");
		btnExcluirPerfil.setFont(new Font("Carlito", Font.BOLD, 19));
		btnExcluirPerfil.setForeground(new Color(255, 245, 234));
		btnExcluirPerfil.setBackground(new Color(193, 31, 35));
		btnExcluirPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnExcluirPerfil, "cell 2 10,alignx left");

	}

}
