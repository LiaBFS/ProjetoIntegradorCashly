package telas;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TelaInternaInicial extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaInternaInicial() {
		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[][grow,fill][]", "[][grow][5px][191px,grow][][380px,grow][]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaInternaInicial.class.getResource("/imgs/ProjetoRecente.png")));
		add(lblNewLabel, "cell 1 1");
		
		JPanelComBackground panel = new JPanelComBackground("/imgs/FundoBtn.png");
		add(panel, "cell 1 3,grow");
		panel.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][]", "[100px]"));
		
		JPanelComBackground panel_1 = new JPanelComBackground("/imgs/BemVindoDeVolta.png");
		add(panel_1, "cell 1 5,grow");

	}

}
