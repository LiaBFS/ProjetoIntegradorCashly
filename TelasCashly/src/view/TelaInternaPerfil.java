package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class TelaInternaPerfil extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TelaInternaPerfil() {
		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[][grow][]", "[][grow][]"));
		
		JPanelComBackground panel = new JPanelComBackground("/imgs/FundoPerfil22.png");
		add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[0][40][500][500,grow][200px][40][0]", "[150px][50px][][40,grow][][][60][][][60][][75px]"));
		
		JPanel panel_1 = new JPanel();
		
		panel.add(panel_1, "cell 2 3 3 7,grow");
		panel_1.setLayout(new MigLayout("", "[50px][grow][grow][grow]", "[50px,grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		
		
		panel_1.setOpaque(false);
		
		panel_1.setOpaque(false);
		
		ImageIcon JPNomePerfil = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/JPNomePerfil.png")
			);	
		
		
		ImageIcon Editar = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Editar.png")
			);	
		
		JLabel lblNomePerfil = new JLabel("");
		lblNomePerfil.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/JPNomePerfil.png")));
		panel_1.add(lblNomePerfil, "flowx,cell 1 1");
		lblNomePerfil.setForeground(new Color(72, 53, 40));
		lblNomePerfil.setFont(new Font("Carlito", Font.BOLD, 20));
		
		
		
		lblNomePerfil.setMinimumSize(new Dimension(50, 25));
		lblNomePerfil.setPreferredSize(new Dimension(250, 50));
		
		lblNomePerfil.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        int largura = lblNomePerfil.getWidth();
		        int altura = lblNomePerfil.getHeight();

		        if (largura > 0 && altura > 0) {
		            double proporcaoOriginal = (double) JPNomePerfil.getIconWidth() / JPNomePerfil.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = JPNomePerfil.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            lblNomePerfil.setIcon(new ImageIcon(img));
		        }
		    }
		});
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 1 2,growx");
		textField_1.setColumns(10);
		
		JButton btnEditarNome = new JButton("");
		btnEditarNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		btnEditarNome.setMinimumSize(new Dimension(100, 50));
		btnEditarNome.setPreferredSize(new Dimension(200, 100));
		
		btnEditarNome.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        int largura = btnEditarNome.getWidth();
		        int altura = btnEditarNome.getHeight();

		        if (largura > 0 && altura > 0) {
		            double proporcaoOriginal = (double) Editar.getIconWidth() / Editar.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = Editar.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            btnEditarNome.setIcon(new ImageIcon(img));
		        }
		    }
		});
		

		btnEditarNome.setBorderPainted(false);
		btnEditarNome.setContentAreaFilled(false);
		btnEditarNome.setFocusPainted(false);
		btnEditarNome.setOpaque(false);
		
		btnEditarNome.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/Editar.png")));
		panel_1.add(btnEditarNome, "cell 3 2,alignx right");
		btnEditarNome.setFont(new Font("Carlito", Font.BOLD, 19));
		btnEditarNome.setForeground(new Color(255, 245, 234));
		btnEditarNome.setBackground(new Color(207, 114, 116));
		
		JLabel lblEmailPerfil = new JLabel("");
		lblEmailPerfil.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/JPEmailPerfil.png")));
		panel_1.add(lblEmailPerfil, "cell 1 3");
		lblEmailPerfil.setForeground(new Color(72, 53, 40));
		lblEmailPerfil.setFont(new Font("Carlito", Font.BOLD, 20));
		
		ImageIcon JPEmailPerfil = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/JPEmailPerfil.png")
			);	
		
		
		
		lblEmailPerfil.setMinimumSize(new Dimension(50, 25));
		lblEmailPerfil.setPreferredSize(new Dimension(250, 50));
		
		lblEmailPerfil.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        int largura = lblEmailPerfil.getWidth();
		        int altura = lblEmailPerfil.getHeight();

		        if (largura > 0 && altura > 0) {
		            double proporcaoOriginal = (double) JPEmailPerfil.getIconWidth() / JPEmailPerfil.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = JPEmailPerfil.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            lblEmailPerfil.setIcon(new ImageIcon(img));
		        }
		    }
		});
		
		textField = new JTextField();
		panel_1.add(textField, "cell 1 4,growx");
		textField.setColumns(10);
		
		JButton btnEditarEmail = new JButton("");
		btnEditarEmail.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/Editar.png")));
		panel_1.add(btnEditarEmail, "cell 3 4,alignx right");
		btnEditarEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		ImageIcon Editar1 = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Editar.png")
			);	
		
		
		
		btnEditarEmail.setMinimumSize(new Dimension(100, 50));
		btnEditarEmail.setPreferredSize(new Dimension(200, 100));
		
		btnEditarEmail.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        int largura = btnEditarEmail.getWidth();
		        int altura = btnEditarEmail.getHeight();

		        if (largura > 0 && altura > 0) {
		            double proporcaoOriginal = (double) Editar1.getIconWidth() / Editar1.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = Editar1.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            btnEditarEmail.setIcon(new ImageIcon(img));
		        }
		    }
		});
		
		btnEditarEmail.setBorderPainted(false);
		btnEditarEmail.setContentAreaFilled(false);
		btnEditarEmail.setFocusPainted(false);
		btnEditarEmail.setOpaque(false);
		
		btnEditarEmail.setFont(new Font("Carlito", Font.BOLD, 19));
		btnEditarEmail.setForeground(new Color(255, 245, 234));
		btnEditarEmail.setBackground(new Color(207, 114, 116));
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/Sair.png")));
		panel_1.add(btnSair, "cell 1 7");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		ImageIcon Sair = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Sair.png")
			);	
		
		
		
		btnSair.setMinimumSize(new Dimension(100, 100));
		btnSair.setPreferredSize(new Dimension(300, 100));
		
		btnSair.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        int largura = btnSair.getWidth();
		        int altura = btnSair.getHeight();

		        if (largura > 0 && altura > 0) {
		            double proporcaoOriginal = (double) Sair.getIconWidth() / Sair.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = Sair.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            btnSair.setIcon(new ImageIcon(img));
		        }
		    }
		});
		
		
		btnSair.setBorderPainted(false);
		btnSair.setContentAreaFilled(false);
		btnSair.setFocusPainted(false);
		btnSair.setOpaque(false);
		btnSair.setFont(new Font("Carlito", Font.BOLD, 19));
		btnSair.setForeground(new Color(255, 245, 234));
		btnSair.setBackground(new Color(207, 114, 116));
		
		JButton btnExcluirPerfil = new JButton("");
		btnExcluirPerfil.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/Excluir.png")));
		panel_1.add(btnExcluirPerfil, "cell 2 7");
		btnExcluirPerfil.setFont(new Font("Carlito", Font.BOLD, 19));
		btnExcluirPerfil.setForeground(new Color(255, 245, 234));
		btnExcluirPerfil.setBackground(new Color(193, 31, 35));
		btnExcluirPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		ImageIcon Excluir = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Excluir.png")
			);	
		
		
		
		btnExcluirPerfil.setMinimumSize(new Dimension(100, 100));
		btnExcluirPerfil.setPreferredSize(new Dimension(300, 100));
		
		btnSair.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        int largura = btnExcluirPerfil.getWidth();
		        int altura = btnExcluirPerfil.getHeight();

		        if (largura > 0 && altura > 0) {
		            double proporcaoOriginal = (double) Excluir.getIconWidth() / Excluir.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = Excluir.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            btnExcluirPerfil.setIcon(new ImageIcon(img));
		        }
		    }
		});
		
		btnExcluirPerfil.setBorderPainted(false);
		btnExcluirPerfil.setContentAreaFilled(false);
		btnExcluirPerfil.setFocusPainted(false);
		btnExcluirPerfil.setOpaque(false);
		

	}

}
