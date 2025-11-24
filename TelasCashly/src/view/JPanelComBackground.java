package view;

import net.miginfocom.swing.MigLayout;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
public class JPanelComBackground extends JPanel {

    private static final long serialVersionUID = 1L;
    private Image backgroundImage;
    private Color cor = new Color(216, 178, 184);

    /**
     * Create the panel.
     */

  
    public JPanelComBackground(String caminhoImagem) {
        backgroundImage = new ImageIcon(getClass().getResource(caminhoImagem)).getImage();
    }
    
    public void setBackground(Color cor) {
    	this.cor=cor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    
        g.setColor(cor);
        g.fillRect(0, 0, getWidth(), getHeight());

        int imgWidth = backgroundImage.getWidth(this);
        int imgHeight = backgroundImage.getHeight(this);

        double panelRatio = (double) getWidth() / getHeight();
        double imgRatio = (double) imgWidth / imgHeight;

        int drawWidth, drawHeight;

        if (panelRatio > imgRatio) {
        
            drawHeight = getHeight();
            drawWidth = (int) (imgRatio * drawHeight);
        } else {
        
            drawWidth = getWidth();
            drawHeight = (int) (drawWidth / imgRatio);
        }
        


        int x = (getWidth() - drawWidth) / 2;
        int y = (getHeight() - drawHeight) / 2;

        
       
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        
         int a = (getWidth()-drawWidth)/2;
         
        
        g2d.drawImage(backgroundImage, x, y, drawWidth, drawHeight, this);
        g2d.dispose();
        
        
        	 if( getLayout() instanceof MigLayout) {

             	MigLayout layout = (MigLayout) getLayout();

             

             	MigLayout layoutMig = (MigLayout) getLayout();

             	

             	String colunas= (String) layoutMig.getColumnConstraints();

             	int posPrimeira = colunas.indexOf("]");

             	int posUltima = colunas.lastIndexOf("[");
             	if(posUltima>posPrimeira) {

                 	String novoConstraints = "[" + a + "]"+colunas.substring(posPrimeira+1, posUltima)+"[" + a + "]";

                 	layout.setColumnConstraints(novoConstraints); // Para definir a largura da primeira coluna
             		
             	}


        }

    }
    
}

