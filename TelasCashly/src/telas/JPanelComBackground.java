package telas;

import java.awt.Color;
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

        if (backgroundImage != null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            double imgAspect = (double) backgroundImage.getWidth(null) / backgroundImage.getHeight(null);
            double panelAspect = (double) panelWidth / panelHeight;

            int drawWidth, drawHeight;

            if (panelAspect > imgAspect) {
                // painel mais largo → limitar pela altura
                drawHeight = panelHeight;
                drawWidth = (int) (panelHeight * imgAspect);
            } else {
                // painel mais alto → limitar pela largura
                drawWidth = panelWidth;
                drawHeight = (int) (panelWidth / imgAspect);
            }

            int x = (panelWidth - drawWidth) / 2;
            int y = (panelHeight - drawHeight) / 2;
            
            g.setColor(new Color(216, 178, 184));
            g.fillRect(0, 0, panelWidth, panelHeight);

            g.drawImage(backgroundImage, x, y, drawWidth, drawHeight, this);
        }
    }
}