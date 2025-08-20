package telas;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelComBackground extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image backgroundImage;

	/**
	 * Create the panel.
	 */
		
		
	    // Construtor recebendo o caminho da imagem
	    public JPanelComBackground(String caminhoImagem) {
	        backgroundImage = new ImageIcon(getClass().getResource(caminhoImagem)).getImage();
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        // Desenha a imagem no tamanho do painel
	        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	    }

	

}
