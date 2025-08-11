package telas;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

public class TelaApresentacao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// >>> ADIÇÃO: método para abrir a TelaCadastro <<<
	private void abrirTelaCadastro() {
	    dispose(); // Fecha a tela atual
	    new TelaCadastro().setVisible(true); // Abre a tela de cadastro
	}
	
	private void abrirTelaLogin() {
	    dispose(); // Fecha a tela atual
	    new TelaLogin().setVisible(true); // Abre a tela de cadastro
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaApresentacao frame = new TelaApresentacao();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public TelaApresentacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 178, 184));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[365px][50,grow][grow][376px,grow][50,grow][180px][71px][126px]", "[48px][404px,grow,fill][235px,grow]"));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/LogoCashly.png")));
		contentPane.add(lblLogo, "cell 0 0,alignx left,aligny bottom");
		
		JButton btnInicio = new JButton("");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastro(); // <<< ADIÇÃO
			}
		});
		btnInicio.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/BtnInicio.png")));
		contentPane.add(btnInicio, "cell 3 0,alignx right,growy");
		
		btnInicio.setBorderPainted(false);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setFocusPainted(false);
		btnInicio.setOpaque(false);
		
		JButton btnCadastrar = new JButton("");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/BtnCadastro.png")));
		contentPane.add(btnCadastrar, "cell 5 0,alignx right,aligny center");
		
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setOpaque(false);
		
		JButton btnLogin = new JButton("");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaLogin(); // <<< ADIÇÃO
			}
		});
		btnLogin.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/BtnLogin.png")));
		contentPane.add(btnLogin, "cell 7 0,alignx left,aligny center");
		
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setFocusPainted(false);
		btnLogin.setOpaque(false);
		
		JButton btnFacaProjetos = new JButton("");
		btnFacaProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastro(); // <<< ADIÇÃO
			}
		});
		btnFacaProjetos.setIcon(new ImageIcon(TelaApresentacao.class.getResource("/imgs/FacaProjetos.png")));
		contentPane.add(btnFacaProjetos, "cell 0 2,grow");
		
		btnFacaProjetos.setBorderPainted(false);
		btnFacaProjetos.setContentAreaFilled(false);
		btnFacaProjetos.setFocusPainted(false);
		btnFacaProjetos.setOpaque(false);
		
		JButton btnRecebaAvisos = new JButton("");
		btnRecebaAvisos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastro(); // <<< ADIÇÃO
			}
		});
		ImageIcon RecebaAvisos= new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/RecebaAvisos.png")
			);
		
		btnRecebaAvisos.setIcon(RecebaAvisos);
		contentPane.add(btnRecebaAvisos, "cell 3 2,grow");
		
		btnRecebaAvisos.setBorderPainted(false);
		btnRecebaAvisos.setContentAreaFilled(false);
		btnRecebaAvisos.setFocusPainted(false);
		btnRecebaAvisos.setOpaque(false);
		
		btnRecebaAvisos.setMinimumSize(new Dimension(30, 30)); // mínimo
		btnRecebaAvisos.setPreferredSize(new Dimension(1000, 1000)); // inicial
		
		btnRecebaAvisos.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentResized(ComponentEvent e) {
		        int largura = btnRecebaAvisos.getWidth();
		        int altura = btnRecebaAvisos.getHeight();

		        if (largura > 0 && altura > 0) {
		            // Mantém proporção original da imagem
		            double proporcaoOriginal = (double) RecebaAvisos.getIconWidth() / RecebaAvisos.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = RecebaAvisos.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            btnRecebaAvisos.setIcon(new ImageIcon(img));
		        }
		    }
		});
		
		JButton btnGrafica = new JButton("");
		btnGrafica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastro(); // <<< ADIÇÃO
			}
		});
		ImageIcon iconOriginal = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/RepresentacoesGraficas.png")
			);

		btnGrafica.setIcon(iconOriginal);
		contentPane.add(btnGrafica, "cell 5 2 3 1,grow");
		
		btnGrafica.setMinimumSize(new Dimension(30, 30)); // mínimo
		btnGrafica.setPreferredSize(new Dimension(1000, 1000)); // inicial
		
		btnGrafica.setBorderPainted(false);
		btnGrafica.setContentAreaFilled(false);
		btnGrafica.setFocusPainted(false);
		btnGrafica.setOpaque(false);
		
		// Listener para redimensionar a imagem mantendo proporção
		btnGrafica.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentResized(ComponentEvent e) {
		        int largura = btnGrafica.getWidth();
		        int altura = btnGrafica.getHeight();

		        if (largura > 0 && altura > 0) {
		            // Mantém proporção original da imagem
		            double proporcaoOriginal = (double) iconOriginal.getIconWidth() / iconOriginal.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = iconOriginal.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            btnGrafica.setIcon(new ImageIcon(img));
		        }
		    }
		});
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastro();
			}
		});
		
		
		ImageIcon iconBemVindo= new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/SejaBemVindo.png")
			);
		btnNewButton.setIcon(iconBemVindo);
		contentPane.add(btnNewButton, "cell 0 1 8 1,grow");
		
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setOpaque(false);
		
		btnNewButton.setMinimumSize(new Dimension(30, 30)); // mínimo
		btnNewButton.setPreferredSize(new Dimension(1000, 1000)); // inicial

		
		// Listener para redimensionar a imagem mantendo proporção
		btnNewButton.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentResized(ComponentEvent e) {
		        int largura = btnNewButton.getWidth();
		        int altura = btnNewButton.getHeight();

		        if (largura > 0 && altura > 0) {
		            // Mantém proporção original da imagem
		            double proporcaoOriginal = (double) iconBemVindo.getIconWidth() / iconBemVindo.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = iconBemVindo.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            btnNewButton.setIcon(new ImageIcon(img));
		        }
		    }
		});
	}
}