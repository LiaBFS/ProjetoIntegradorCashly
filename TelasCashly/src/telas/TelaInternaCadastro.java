package telas;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class TelaInternaCadastro extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @param telaCredenciais 
	 */
	public TelaInternaCadastro(TelaCredenciais telaCredenciais) {
		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[50px,grow][100px,grow][35px,grow][70px][476px,grow][130px,grow]", "[grow][grow][75px,grow][70px,grow][75px,grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 178, 184));
		add(panel, "cell 0 0 6 1,grow");
		panel.setLayout(new MigLayout("", "[grow 50][][][][][][][grow][][][][grow][][][][][][][][][][grow 50]", "[70px,fill]"));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setPreferredSize(new Dimension(500, 500));
		lblLogo.setMinimumSize(new Dimension(10, 5));
		lblLogo.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/LogoCashly.png")));
		panel.add(lblLogo, "cell 1 0,growy");
		
		ImageIcon LogoCashly = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/LogoCashly.png")
			);	
		
		lblLogo.setMinimumSize(new Dimension(10, 5));
		lblLogo.setPreferredSize(new Dimension(500, 100));
		
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
		btnInicio.setOpaque(false);
		btnInicio.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/BtnInicio2.png")));
		btnInicio.setFocusPainted(false);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setBorderPainted(false);
		panel.add(btnInicio, "cell 14 0");
		
		JButton btnCadastro = new JButton("");
		btnCadastro.setOpaque(false);
		btnCadastro.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/BtnCadastroSel.png")));
		btnCadastro.setFocusPainted(false);
		btnCadastro.setContentAreaFilled(false);
		btnCadastro.setBorderPainted(false);
		panel.add(btnCadastro, "cell 17 0");
		
		JButton btnLogin = new JButton("");
		btnLogin.setOpaque(false);
		btnLogin.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/BtnLogin.png")));
		btnLogin.setFocusPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		panel.add(btnLogin, "cell 20 0");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 178, 184));
		add(panel_1, "cell 2 2 2 2,grow");
		panel_1.setLayout(new MigLayout("", "[grow]", "[grow][][grow]"));
		
		JButton btnIrProLogin = new JButton("");
		btnIrProLogin.setPreferredSize(new Dimension(1000, 1000));
		btnIrProLogin.setOpaque(false);
		btnIrProLogin.setMinimumSize(new Dimension(600, 600));
		btnIrProLogin.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/IrProLogin2.png")));
		btnIrProLogin.setFocusPainted(false);
		btnIrProLogin.setContentAreaFilled(false);
		btnIrProLogin.setBorderPainted(false);
		btnIrProLogin.setBackground(new Color(216, 178, 184));
		panel_1.add(btnIrProLogin, "cell 0 1 1 2,grow");
		
		ImageIcon IrProLogin2 = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/IrProLogin2.png")
			);	
		
		btnIrProLogin.setMinimumSize(new Dimension(600, 600));
		btnIrProLogin.setPreferredSize(new Dimension(900, 900));
		
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(216, 178, 184));
		add(panel_2, "cell 4 2 1 2,grow");
		panel_2.setLayout(new MigLayout("", "[grow]", "[grow 50][][grow 75][][5px][][5px][][grow 75][][grow 50]"));
		
		JLabel lblCriarConta = new JLabel("");
		lblCriarConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCriarConta.setPreferredSize(new Dimension(500, 100));
		lblCriarConta.setMinimumSize(new Dimension(200, 100));
		lblCriarConta.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/CriarConta.png")));
		panel_2.add(lblCriarConta, "cell 0 1,grow");
		
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
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setPreferredSize(new Dimension(500, 100));
		lblNome.setMinimumSize(new Dimension(300, 100));
		lblNome.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/Usuario.png")));
		panel_2.add(lblNome, "cell 0 3,grow");
		
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
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setPreferredSize(new Dimension(500, 100));
		lblEmail.setMinimumSize(new Dimension(300, 100));
		lblEmail.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/Email.png")));
		panel_2.add(lblEmail, "cell 0 5,grow");
		
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
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setPreferredSize(new Dimension(500, 100));
		lblSenha.setMinimumSize(new Dimension(300, 100));
		lblSenha.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/Senha.png")));
		panel_2.add(lblSenha, "cell 0 7,grow");
		
		ImageIcon Senha = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Senha.png")
			);	
		
		lblSenha.setMinimumSize(new Dimension(300, 100));
		lblSenha.setPreferredSize(new Dimension(500, 100));
		
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
		
		JButton btnCadastrar = new JButton("");
		btnCadastrar.setPreferredSize(new Dimension(500, 100));
		btnCadastrar.setOpaque(false);
		btnCadastrar.setMinimumSize(new Dimension(300, 100));
		btnCadastrar.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/ConfirmaCadastro.png")));
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setBorderPainted(false);
		panel_2.add(btnCadastrar, "cell 0 9,grow");
		
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

	}

}
