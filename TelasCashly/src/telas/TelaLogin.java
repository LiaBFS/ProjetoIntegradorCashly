package telas;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private void abrirTelaCadastro() {
	    dispose(); // Fecha a tela atual
	    new TelaCadastro().setVisible(true); // Abre a tela de cadastro
	}
	
	private void abrirTelaApresentacao() {
	    dispose(); // Fecha a tela atual
	    new TelaApresentacao().setVisible(true); // Abre a tela de cadastro
	}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	 public TelaLogin() {
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Faz abrir em tela cheia
	        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 178, 184));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[100px,grow][35px,grow][100px][35px,grow][130px,grow]", "[grow][75px][70px,grow][75px,grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 178, 184));
		contentPane.add(panel, "cell 0 0 5 1,grow");
		panel.setLayout(new MigLayout("", "[grow 50][][][][][][][grow][][][][grow][][][][][][][][][][grow 50]", "[]"));
		
		JLabel lblLogo = new JLabel("");
		panel.add(lblLogo, "cell 1 0,alignx left");
		lblLogo.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/LogoCashly.png")));
		
		JButton btnInicio = new JButton("");
		panel.add(btnInicio, "cell 14 0");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				abrirTelaApresentacao();
			}
		});
		btnInicio.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/BtnInicio2.png")));
		
		btnInicio.setBorderPainted(false);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setFocusPainted(false);
		btnInicio.setOpaque(false);
		
		JButton btnCadastrar = new JButton("");
		panel.add(btnCadastrar, "cell 17 0,alignx right,growy");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastro();
			}
		});
		btnCadastrar.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/BtnCadastro.png")));
		
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setOpaque(false);
		
		JButton btnLogin = new JButton("");
		panel.add(btnLogin, "cell 20 0,alignx right");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/Login2.png")));
		
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setFocusPainted(false);
		btnLogin.setOpaque(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 178, 184));
		contentPane.add(panel_1, "cell 1 2,grow");
		panel_1.setLayout(new MigLayout("", "[grow]", "[grow][][grow]"));
		
		ImageIcon IrProCadastro = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/IrProCadastro.png")
			);	
		
	
		
		JButton btnIrCadastro = new JButton("");
		panel_1.add(btnIrCadastro, "cell 0 1,grow");
		btnIrCadastro.setBackground(new Color(216, 178, 184));
		btnIrCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaCadastro();
			}
		});
		
		btnIrCadastro.setMinimumSize(new Dimension(669, 549));
		btnIrCadastro.setPreferredSize(new Dimension(1000, 1000));
		
		panel_1.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        int largura = panel_1.getWidth();
		        int altura = panel_1.getHeight();

		        if (largura > 0 && altura > 0) {
		            double proporcaoOriginal = (double) IrProCadastro.getIconWidth() / IrProCadastro.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = IrProCadastro.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            btnIrCadastro.setIcon(new ImageIcon(img));
		        }
		    }
		});
		
		btnIrCadastro.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/IrProCadastro.png")));
		
		
		btnIrCadastro.setBorderPainted(false);
		btnIrCadastro.setContentAreaFilled(false);
		btnIrCadastro.setFocusPainted(false);
		btnIrCadastro.setOpaque(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(216, 178, 184));
		contentPane.add(panel_2, "cell 3 2,grow");
		panel_2.setLayout(new MigLayout("", "[315px,grow]", "[][][][][][][grow 50][][][][][][grow 75][][5px][][grow][][][][grow 50][][][][][][][][][][][]"));
		
		JLabel lblFazerLogin = new JLabel("");
		panel_2.add(lblFazerLogin, "cell 0 12,alignx center,growy");
		lblFazerLogin.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/FazerLogin.png")));
		
//		ImageIcon FazerLogin = new ImageIcon(
//			    TelaApresentacao.class.getResource("/imgs/FazerLogin.png")
//			);	
//		
//		lblFazerLogin.setMinimumSize(new Dimension(30, 30));
//		lblFazerLogin.setPreferredSize(new Dimension(1000, 1000));
//		
//		lblFazerLogin.addComponentListener(new ComponentAdapter() {
//		    public void componentResized(ComponentEvent e) {
//		        int largura = lblFazerLogin.getWidth();
//		        int altura = lblFazerLogin.getHeight();
//
//		        if (largura > 0 && altura > 0) {
//		            double proporcaoOriginal = (double) FazerLogin.getIconWidth() / FazerLogin.getIconHeight();
//		            int novaLargura = largura;
//		            int novaAltura = (int) (largura / proporcaoOriginal);
//
//		            if (novaAltura > altura) {
//		                novaAltura = altura;
//		                novaLargura = (int) (altura * proporcaoOriginal);
//		            }
//
//		            Image img = FazerLogin.getImage().getScaledInstance(
//		                novaLargura, novaAltura, Image.SCALE_SMOOTH
//		            );
//		            lblFazerLogin.setIcon(new ImageIcon(img));
//		        }
//		    }
//		});
		
		
		JLabel lblEmail = new JLabel("");
		panel_2.add(lblEmail, "cell 0 13,alignx center,growy");
		lblEmail.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/Email.png")));
		

		ImageIcon Email = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Email.png")
			);	
		
		lblEmail.setMinimumSize(new Dimension(10, 10));
		lblEmail.setPreferredSize(new Dimension(1000, 1000));
		
		lblEmail.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        int largura = lblEmail.getWidth();
		        int altura = lblEmail.getHeight();

		        if (largura > 0 && altura > 0) {
		            double proporcaoOriginal = (double) Email.getIconWidth() / Email.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = Email.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            lblEmail.setIcon(new ImageIcon(img));
		        }
		    }
		});
		
		JLabel lblSenha = new JLabel("");
		panel_2.add(lblSenha, "cell 0 15,alignx center,growy");
		lblSenha.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/Senha.png")));
		
		ImageIcon Senha = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Senha.png")
			);	
		
		lblSenha.setMinimumSize(new Dimension(10, 10));
		lblSenha.setPreferredSize(new Dimension(1000, 1000));
		
		lblSenha.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        int largura = lblSenha.getWidth();
		        int altura = lblSenha.getHeight();

		        if (largura > 0 && altura > 0) {
		            double proporcaoOriginal = (double) Senha.getIconWidth() / Senha.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = Senha.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            lblSenha.setIcon(new ImageIcon(img));
		        }
		    }
		});
		
		ImageIcon btnIniciarSessao = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/btnIniciarSessao.png")
			);	
		
		JButton BtnIniciarSessao = new JButton("");
		panel_2.add(BtnIniciarSessao, "cell 0 17,grow");
		BtnIniciarSessao.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/btnIniciarSessao.png")));
		
		BtnIniciarSessao.setMinimumSize(new Dimension(10, 10));
		BtnIniciarSessao.setPreferredSize(new Dimension(1000, 1000));
		
		BtnIniciarSessao.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        int largura = BtnIniciarSessao.getWidth();
		        int altura = BtnIniciarSessao.getHeight();

		        if (largura > 0 && altura > 0) {
		            double proporcaoOriginal = (double) btnIniciarSessao.getIconWidth() / btnIniciarSessao.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = btnIniciarSessao.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            BtnIniciarSessao.setIcon(new ImageIcon(img));
		        }
		    }
		});
		
		
		BtnIniciarSessao.setBorderPainted(false);
		BtnIniciarSessao.setContentAreaFilled(false);
		BtnIniciarSessao.setFocusPainted(false);
		BtnIniciarSessao.setOpaque(false);
		
		
		
	}
}