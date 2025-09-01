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

public class TelaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	private void abrirTelaLogin() {
	    dispose(); // Fecha a tela atual
	    new TelaLogin().setVisible(true); // Abre a tela de cadastro
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
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setBackground(new Color(216, 178, 184));
		// Faz abrir em tela cheia
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(216, 178, 184));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[50px][100px,grow][35px,grow][70][476.00px,grow][130px,grow]", "[grow][grow][75px][70px,grow][75px,grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 178, 184));
		contentPane.add(panel, "cell 0 0 6 1,grow");
		panel.setLayout(new MigLayout("", "[grow 50][][][][][][][grow][][][][grow][][][][][][][][][][grow 50]", "[70]"));
		
		JLabel lblLogo = new JLabel("");
		panel.add(lblLogo, "cell 1 0,growx,aligny center");
		lblLogo.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/LogoCashly.png")));
		
		ImageIcon LogoCashly = new ImageIcon(
	    TelaApresentacao.class.getResource("/imgs/LogoCashly.png")
	);	

		lblLogo.setMinimumSize(new Dimension(10, 5));
		lblLogo.setPreferredSize(new Dimension(500, 500));

		lblLogo.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				int largura = lblLogo.getWidth();
				int altura = lblLogo.getHeight();

				if (largura > 0 && altura > 0) {
					double proporcaoOriginal = (double) LogoCashly.getIconWidth() / LogoCashly.getIconHeight();
					int novaLargura = largura;
					int novaAltura = (int) (largura / proporcaoOriginal);

					if (novaAltura > altura) {
						novaAltura = altura;
                novaLargura = (int) (altura * proporcaoOriginal);
					}

					Image img = LogoCashly.getImage().getScaledInstance(
							novaLargura, novaAltura, Image.SCALE_SMOOTH
							);
					lblLogo.setIcon(new ImageIcon(img));
				}
			}
		});
		
		JButton btnInicio = new JButton("");
		panel.add(btnInicio, "cell 14 0,growx,aligny center");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaApresentacao();
			}
		});
		btnInicio.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/BtnInicio2.png")));
		
		btnInicio.setBorderPainted(false);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setFocusPainted(false);
		btnInicio.setOpaque(false);
		
		JButton btnCadastro = new JButton("");
		panel.add(btnCadastro, "cell 17 0,grow");
		btnCadastro.setOpaque(false);
		btnCadastro.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/BtnCadastroSel.png")));
		btnCadastro.setFocusPainted(false);
		btnCadastro.setContentAreaFilled(false);
		btnCadastro.setBorderPainted(false);
		
		JButton btnLogin = new JButton("");
		panel.add(btnLogin, "cell 20 0,alignx left,aligny center");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaLogin();
			}
		});
		btnLogin.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/BtnLogin.png")));
		
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setFocusPainted(false);
		btnLogin.setOpaque(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 178, 184));
		contentPane.add(panel_1, "cell 0 2 3 3,alignx right,growy");
		panel_1.setLayout(new MigLayout("", "[grow]", "[grow][][grow]"));
		
//		JButton btnIrProLogin = new JButton("");
//		panel_1.add(btnIrProLogin, "cell 0 0 1 2");
//		btnIrProLogin.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				abrirTelaLogin();
//			}
//		});
		
		JButton btnIrProLogin = new JButton("");
		panel_1.add(btnIrProLogin, "cell 0 1,grow");
		btnIrProLogin.setBackground(new Color(216, 178, 184));
		btnIrProLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaLogin();
			}
		});
		
		ImageIcon IrProLogin2 = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/IrProLogin2.png")
			);	
		
		btnIrProLogin.setMinimumSize(new Dimension(600, 600));
		btnIrProLogin.setPreferredSize(new Dimension(1000, 1000));
		
		panel_1.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        int largura = panel_1.getWidth();
		        int altura = panel_1.getHeight();

		        if (largura > 0 && altura > 0) {
		            double proporcaoOriginal = (double) IrProLogin2.getIconWidth() / IrProLogin2.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = IrProLogin2.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            btnIrProLogin.setIcon(new ImageIcon(img));
		        }
		    }
		});
		
		btnIrProLogin.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/IrProLogin2.png")));
		
		btnIrProLogin.setBorderPainted(false);
		btnIrProLogin.setContentAreaFilled(false);
		btnIrProLogin.setFocusPainted(false);
		btnIrProLogin.setOpaque(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(216, 178, 184));
		contentPane.add(panel_2, "cell 4 3,grow");
		panel_2.setLayout(new MigLayout("", "[grow]", "[grow 50][][grow 75][][5px][][5px][][grow 75][][grow 50]"));
		
		JLabel lblCriarConta = new JLabel("");
		panel_2.add(lblCriarConta, "cell 0 1,grow");
		lblCriarConta.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/CriarConta.png")));
		
		ImageIcon CriarConta = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/CriarConta.png")
			);	
		
		lblCriarConta.setMinimumSize(new Dimension(200, 100));
		lblCriarConta.setPreferredSize(new Dimension(500, 100));
		
		lblCriarConta.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        int largura = lblCriarConta.getWidth();
		        int altura = lblCriarConta.getHeight();

		        if (largura > 0 && altura > 0) {
		            double proporcaoOriginal = (double) CriarConta.getIconWidth() / CriarConta.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = CriarConta.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            lblCriarConta.setIcon(new ImageIcon(img));
		        }
		    }
		});
		
		JLabel lblNome = new JLabel("");
		panel_2.add(lblNome, "cell 0 3,grow");
		lblNome.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/Usuario.png")));
		

		ImageIcon Usuario = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Usuario.png")
			);	
		
		lblNome.setMinimumSize(new Dimension(300, 100));
		lblNome.setPreferredSize(new Dimension(500, 100));
		
		lblNome.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        int largura = lblNome.getWidth();
		        int altura = lblNome.getHeight();

		        if (largura > 0 && altura > 0) {
		            double proporcaoOriginal = (double) Usuario.getIconWidth() / Usuario.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = Usuario.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            lblNome.setIcon(new ImageIcon(img));
		        }
		    }
		});
		
		JLabel lblEmail = new JLabel("");
		panel_2.add(lblEmail, "cell 0 5,grow");
		lblEmail.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/Email.png")));
		
		ImageIcon Email = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Email.png")
			);	
		
		lblEmail.setMinimumSize(new Dimension(300, 100));
		lblEmail.setPreferredSize(new Dimension(500, 100));
		
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
		panel_2.add(lblSenha, "cell 0 7,grow");
		lblSenha.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/Senha.png")));
		
		ImageIcon Senha = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Senha.png")
			);	
		
		lblSenha.setMinimumSize(new Dimension(300, 100));
		lblSenha.setPreferredSize(new Dimension(500, 100));
		
		lblEmail.addComponentListener(new ComponentAdapter() {
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
		
		JButton btnCadastrar = new JButton("");
		panel_2.add(btnCadastrar, "cell 0 9,grow");
		btnCadastrar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/ConfirmaCadastro.png")));
		
		ImageIcon ConfirmaCadastro = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/ConfirmaCadastro.png")
			);	
		
		btnCadastrar.setMinimumSize(new Dimension(300, 100));
		btnCadastrar.setPreferredSize(new Dimension(500, 100));
		
		btnCadastrar.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        int largura = btnCadastrar.getWidth();
		        int altura = btnCadastrar.getHeight();

		        if (largura > 0 && altura > 0) {
		            double proporcaoOriginal = (double) ConfirmaCadastro.getIconWidth() / ConfirmaCadastro.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = ConfirmaCadastro.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            btnCadastrar.setIcon(new ImageIcon(img));
		        }
		    }
		});	
		
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setOpaque(false);
		
	}
}