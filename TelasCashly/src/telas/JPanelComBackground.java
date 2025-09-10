package telas;

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

    // Construtor recebendo o caminho da imagem
    public JPanelComBackground(String caminhoImagem) {
        backgroundImage = new ImageIcon(getClass().getResource(caminhoImagem)).getImage();
    }
    
    public void setBackground(Color cor) {
    	this.cor=cor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Preenche fundo com a cor desejada (#d8b2b8)
        g.setColor(cor);
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
        System.out.println(getWidth());
        System.out.println(getHeight());
        System.out.println(imgWidth);
        System.out.println(imgHeight);
        System.out.println(panelRatio);
        System.out.println(imgRatio);
        System.out.println(drawWidth);
        System.out.println(drawHeight);


        int x = (getWidth() - drawWidth) / 2;
        int y = (getHeight() - drawHeight) / 2;

        System.out.println(x);
        System.out.println(y);
        // Renderização com qualidade
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



             	
        // Adicionando um componente com layout personalizado
        // A primeira e a última coluna têm tamanho 'a'
//        layout.setColumnConstraints("[][grow 20][grow 20][][][grow 70][][grow 15][][grow][" + a + "px]");

     //  String currentColConstraints = layout.getLayoutConstraints().getColumnConstraints().toString();
        
        // Verificando se há ao menos uma coluna
     //   if (colConstraints.length > 0) {
     //       ColumnConstraints primeiraColuna = colConstraints[0]; // A primeira coluna
     //       System.out.println("Primeira coluna: " + primeiraColuna);
     //   }
        // O MigLayout permite o uso de colunas relativas e absolutas, então esse valor pode ser ajustado para se adaptar ao layout
     //   layout.setColumnConstraints("[" + a + "][grow 20][grow 20][][][grow 70][][grow 15][][grow][]"); // Para definir a largura da primeira coluna
        }

    }
    
}

