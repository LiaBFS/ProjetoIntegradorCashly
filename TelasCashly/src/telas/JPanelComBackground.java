package telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

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

        // Preenche fundo com a cor desejada (#d8b2b8)
        g.setColor(new Color(216, 178, 184));
        g.fillRect(0, 0, getWidth(), getHeight());

        int imgWidth = backgroundImage.getWidth(this);
        int imgHeight = backgroundImage.getHeight(this);

        double panelRatio = (double) getWidth() / getHeight();
        double imgRatio = (double) imgWidth / imgHeight;

        int drawWidth, drawHeight;

        if (panelRatio > imgRatio) {
            // Ajusta pela altura do painel → imagem cabe inteira
            drawHeight = getHeight();
            drawWidth = (int) (imgRatio * drawHeight);
        } else {
            // Ajusta pela largura do painel → imagem cabe inteira
            drawWidth = getWidth();
            drawHeight = (int) (drawWidth / imgRatio);
        }
        
        


        int x = (getWidth() - drawWidth) / 2;
        int y = (getHeight() - drawHeight) / 2;

        // Renderização com qualidade
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(backgroundImage, x, y, drawWidth, drawHeight, this);
        g2d.dispose();
    }
    
}

