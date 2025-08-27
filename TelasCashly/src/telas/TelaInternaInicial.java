package telas;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
		setLayout(new MigLayout("", "[][][grow,fill][][]", "[][grow 10][5px][191px,grow][][380px,grow][]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaInternaInicial.class.getResource("/imgs/ProjetoRecente.png")));
		
		
		add(lblNewLabel, "cell 2 1,alignx left,aligny center");
		ImageIcon iconProjetoRecente = new ImageIcon(TelaApresentacao.class.getResource("/imgs/ProjetoRecente.png"));
		lblNewLabel.setIcon(iconProjetoRecente);
		
		lblNewLabel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int largura = lblNewLabel.getWidth();
                int altura = lblNewLabel.getHeight();
                if (largura > 0 && altura > 0) {
                    double proporcaoOriginal = (double) iconProjetoRecente.getIconWidth() / iconProjetoRecente.getIconHeight();
                    int novaLargura = largura;
                    int novaAltura = (int) (largura / proporcaoOriginal);
                    if (novaAltura > altura) {
                        novaAltura = altura;
                        novaLargura = (int) (altura * proporcaoOriginal);
                    }
                    Image img = iconProjetoRecente.getImage().getScaledInstance(novaLargura, novaAltura, Image.SCALE_SMOOTH);
                    lblNewLabel.setIcon(new ImageIcon(img));
                }
            }
        });
		
		JPanelComBackground panel = new JPanelComBackground("/imgs/FundoBtn.png");
		add(panel, "cell 1 3 3 1,grow");
		panel.setLayout(new MigLayout("", "[][][][][grow 15][][][][][][grow 70][][][][][][][grow 15][][][][]", "[grow 25][][grow 10][][][][grow 25]"));
		
		JButton btnNewButton = new JButton("Nome do Projeto Criado");
		panel.add(btnNewButton, "cell 4 1,alignx right,growy");
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2, "cell 17 1,growy");
		
		JButton btnNewButton_1 = new JButton("Descrição");
		panel.add(btnNewButton_1, "cell 4 3 1 2,alignx right,growy");
		
		JPanelComBackground panel_1 = new JPanelComBackground("/imgs/BemVindoDeVolta.png");
		add(panel_1, "cell 1 5 3 1,grow");

	}

}
