package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JScrollBar;

public class TelaInternaProjetos extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaInternaProjetos() {
		
		
		
		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[grow]", "[grow][grow][grow][grow][grow]"));
		
		
		
		JPanelComBackground panel_4 = new JPanelComBackground("/imgs/FundoBtn.png");
		add(panel_4, "cell 0 0,grow");
		
		JPanelComBackground panel_3 = new JPanelComBackground("/imgs/FundoBtn.png");
		add(panel_3, "cell 0 1,grow");
		
		JPanelComBackground panel_2 = new JPanelComBackground("/imgs/FundoBtn.png");
		add(panel_2, "cell 0 2,grow");
		
		JPanelComBackground panel_1 = new JPanelComBackground("/imgs/FundoBtn.png");
		add(panel_1, "cell 0 3,grow");
		
		JPanelComBackground panel = new JPanelComBackground("/imgs/FundoBtn.png");
		add(panel, "cell 0 4,grow");

	}

}
