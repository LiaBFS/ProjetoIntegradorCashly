package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class TelaEscolhaOGraficoo extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaEscolhaOGraficoo() {
		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[1118px][537px]", "[88px][552px]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaEscolhaOGraficoo.class.getResource("/imgs/Gráficos.png")));
		add(lblNewLabel, "cell 0 0,alignx left,aligny top");
		
		JButton Categorias = new JButton("");
		Categorias.setIcon(new ImageIcon(TelaEscolhaOGraficoo.class.getResource("/imgs/GraficoCategorias.png")));
		add(Categorias, "flowx,cell 0 1,alignx left,aligny center");
		
		Categorias.setBorderPainted(false);
		Categorias.setContentAreaFilled(false);
		Categorias.setFocusPainted(false);
		Categorias.setOpaque(false);
		 
		 JButton Plano = new JButton("");
		 Plano.setIcon(new ImageIcon(TelaEscolhaOGraficoo.class.getResource("/imgs/GráficoPlano.png")));
		 add( Plano, "cell 0 1,alignx left,aligny top");
		 
		  Plano.setBorderPainted(false);
		  Plano.setContentAreaFilled(false);
		  Plano.setFocusPainted(false);
		  Plano.setOpaque(false);

	}

}
