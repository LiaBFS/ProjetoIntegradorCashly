package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

public class TelaInternaNotificacoes extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaInternaNotificacoes() {
		setLayout(new MigLayout("", "[][][][][][][][]", "[][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("TELA NOTIFICACOES");
		add(lblNewLabel, "cell 5 4");

	}

}
