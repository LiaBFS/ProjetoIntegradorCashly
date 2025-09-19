package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TelaInternaInicial extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaInternaInicial() {
		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[][][grow,fill][][]", "[][grow 10][5px][191px,grow][][380px,grow][]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaInternaInicial.class.getResource("/ProjetoRecente.png")));
		
		
		add(lblNewLabel, "cell 2 1,alignx left,aligny center");
		ImageIcon iconProjetoRecente = new ImageIcon(TelaApresentacao.class.getResource("/ProjetoRecente.png"));
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
		
		JPanelComBackground panel = new JPanelComBackground("/FundoBtn.png");
		add(panel, "cell 1 3 3 1,grow");
		panel.setLayout(new MigLayout("", "[][grow 20][grow 20][][][grow 70][][grow 15][][grow][]", "[grow 25][][grow 10][][][][grow 25]"));
		
		JButton btnNomeProjeto = new JButton("Nome do Projeto Criado");
		btnNomeProjeto.setFont(new Font("Carlito", Font.BOLD, 29));
		
		btnNomeProjeto.setBorderPainted(false);
		btnNomeProjeto.setContentAreaFilled(false);
		btnNomeProjeto.setFocusPainted(false);
        btnNomeProjeto.setOpaque(false);
		
		panel.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentResized(ComponentEvent e) {
		        int largura = panel.getWidth();
		        int altura = panel.getHeight();

		        if (largura > 0 && altura > 0) {
		            // calcula o tamanho da fonte com base na largura ou altura
		            int novoTamanho = Math.min(largura / 10, altura / 5);

		            // garante um mínimo para não sumir
		            if (novoTamanho < 14) {
		                novoTamanho = 14;
		            }

		            btnNomeProjeto.setFont(new Font("Carlito", Font.BOLD, novoTamanho));
		        }
		    }
		});
		
		btnNomeProjeto.setForeground(new Color(255, 245, 234));
		btnNomeProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		panel.add(btnNomeProjeto, "cell 2 1,alignx left,growy");
		
		JButton btnData = new JButton("dd/mm/aa");
		btnData.setBorderPainted(false);
		btnData.setContentAreaFilled(false);
		btnData.setFocusPainted(false);
		btnData.setOpaque(false);
		btnData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnData.setFont(new Font("Carlito", Font.PLAIN, 19));
		
		btnData.setFont(new Font("Carlito", Font.PLAIN, 19));

		panel.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentResized(ComponentEvent e) {
		        int largura = panel.getWidth();
		        int altura = panel.getHeight();

		        if (largura > 0 && altura > 0) {
		            // Fonte menor que o NomeProjeto
		            int novoTamanho = Math.min(largura / 15, altura / 7);
		            if (novoTamanho < 12) novoTamanho = 12;
		            btnData.setFont(new Font("Carlito", Font.PLAIN, novoTamanho));
		        }
		    }
		});
		
		btnData.setForeground(new Color(153, 131, 116));
		panel.add(btnData, "cell 7 1,alignx right,growy");
		
		JButton btnDescrição = new JButton("Descrição");
		btnDescrição.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDescrição.setFont(new Font("Carlito", Font.PLAIN, 14));
		
		btnDescrição.setFont(new Font("Carlito", Font.PLAIN, 14));

		btnDescrição.setBorderPainted(false);
		btnDescrição.setContentAreaFilled(false);
		btnDescrição.setFocusPainted(false);
		btnDescrição.setOpaque(false);
		
		panel.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentResized(ComponentEvent e) {
		        int largura = panel.getWidth();
		        int altura = panel.getHeight();

		        if (largura > 0 && altura > 0) {
		            // Fonte ainda menor, pois é apenas descritiva
		            int novoTamanho = Math.min(largura / 20, altura / 10);
		            if (novoTamanho < 11) novoTamanho = 11;
		            btnDescrição.setFont(new Font("Carlito", Font.PLAIN, novoTamanho));
		        }
		    }
		});
		
		btnDescrição.setForeground(new Color(255, 245, 234));
		panel.add(btnDescrição, "cell 2 3 1 2,alignx left,growy");
		
		JPanelComBackground panel_1 = new JPanelComBackground("/BemVindoDeVolta.png");
		add(panel_1, "cell 1 5 3 1,grow");

	}

}
