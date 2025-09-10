package telas;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

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
		panel.setLayout(new MigLayout("", "[0][grow][][][][][0]", "[90px][100px][grow][][][][][][]"));
		
		JPanelComBackground panelFundoIcone = new JPanelComBackground("/imgs/FundoIcone.png");
		panelFundoIcone.setBackground(new Color(255, 245, 234));
		panelFundoIcone.repaint();
		panel.add(panelFundoIcone, "cell 1 2,grow");
		
		JButton btnNewButton_4 = new JButton("New button");
		panel.add(btnNewButton_4, "cell 4 2");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel.add(lblNewLabel_1, "cell 1 3");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "cell 1 4 2 1,growx");
		textField_1.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel.add(btnNewButton_3, "cell 4 4");
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel, "cell 1 5");
		
		textField = new JTextField();
		panel.add(textField, "cell 1 6 2 1,growx");
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2, "cell 4 6");
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton, "cell 1 7");
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1, "cell 2 7");

	}

}
