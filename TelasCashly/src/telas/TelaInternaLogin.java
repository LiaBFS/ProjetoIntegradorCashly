package telas;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class TelaInternaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 * @param telaCredenciais 
	 */
	public TelaInternaLogin(TelaCredenciais telaCredenciais) {
		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[50px,grow][100px,grow][35px,grow][70px][476px,grow][130px,grow]", "[grow][grow][grow][75px][70px,grow][75px,grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 178, 184));
		add(panel, "cell 0 0 6 1,grow");
		panel.setLayout(new MigLayout("", "[grow 50][][][][][][][grow][][][][grow][][][][][][][][][][][grow 50]", "[70px]"));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setPreferredSize(new Dimension(500, 100));
		lblLogo.setMinimumSize(new Dimension(10, 5));
		lblLogo.setIcon(new ImageIcon(TelaInternaLogin.class.getResource("/imgs/LogoCashly.png")));
		panel.add(lblLogo, "cell 1 0");
		
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
		btnInicio.setIcon(new ImageIcon(TelaInternaLogin.class.getResource("/imgs/BtnInicio2.png")));
		btnInicio.setFocusPainted(false);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setBorderPainted(false);
		panel.add(btnInicio, "cell 14 0");
		
		JButton btnCadastrar = new JButton("");
		btnCadastrar.setOpaque(false);
		btnCadastrar.setIcon(new ImageIcon(TelaInternaLogin.class.getResource("/imgs/BtnCadastro.png")));
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setBorderPainted(false);
		panel.add(btnCadastrar, "cell 17 0");
		
		JButton btnLogin = new JButton("");
		btnLogin.setOpaque(false);
		btnLogin.setIcon(new ImageIcon(TelaInternaLogin.class.getResource("/imgs/Login2.png")));
		btnLogin.setFocusPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		panel.add(btnLogin, "cell 20 0");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 178, 184));
		add(panel_1, "cell 2 2 2 2,grow");
		panel_1.setLayout(new MigLayout("", "[grow]", "[][grow][]"));
		
		JButton btnIrCadastro = new JButton("");
		btnIrCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIrCadastro.setPreferredSize(new Dimension(1000, 1000));
		btnIrCadastro.setOpaque(false);
		btnIrCadastro.setMinimumSize(new Dimension(600, 600));
		btnIrCadastro.setIcon(new ImageIcon(TelaInternaLogin.class.getResource("/imgs/IrProCadastro.png")));
		btnIrCadastro.setFocusPainted(false);
		btnIrCadastro.setContentAreaFilled(false);
		btnIrCadastro.setBorderPainted(false);
		btnIrCadastro.setBackground(new Color(216, 178, 184));
		panel_1.add(btnIrCadastro, "cell 0 1");
		
		ImageIcon IrProCadastro = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/IrProCadastro.png")
			);	
		
		btnIrCadastro.setMinimumSize(new Dimension(600, 600));
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(216, 178, 184));
		add(panel_2, "cell 4 2 1 2,grow");
		panel_2.setLayout(new MigLayout("", "[grow]", "[grow 50][][grow 30][20px,grow][5px][15px,grow][grow 30][][grow 50]"));
		
		JLabel lblFazerLogin = new JLabel("");
		lblFazerLogin.setPreferredSize(new Dimension(500, 100));
		lblFazerLogin.setMinimumSize(new Dimension(200, 100));
		lblFazerLogin.setIcon(new ImageIcon(TelaInternaLogin.class.getResource("/imgs/FazerLogin.png")));
		lblFazerLogin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblFazerLogin, "cell 0 1");
		
		ImageIcon FazerLogin = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/FazerLogin.png")
			);	
		
		lblFazerLogin.setMinimumSize(new Dimension(200, 100));
		lblFazerLogin.setPreferredSize(new Dimension(500, 100));
		
		lblFazerLogin.addComponentListener(new ComponentAdapter() {
		    public void componentResized(ComponentEvent e) {
		        int largura = lblFazerLogin.getWidth();
		        int altura = lblFazerLogin.getHeight();

		        if (largura > 0 && altura > 0) {
		            double proporcaoOriginal = (double) FazerLogin.getIconWidth() / FazerLogin.getIconHeight();
		            int novaLargura = largura;
		            int novaAltura = (int) (largura / proporcaoOriginal);

		            if (novaAltura > altura) {
		                novaAltura = altura;
		                novaLargura = (int) (altura * proporcaoOriginal);
		            }

		            Image img = FazerLogin.getImage().getScaledInstance(
		                novaLargura, novaAltura, Image.SCALE_SMOOTH
		            );
		            lblFazerLogin.setIcon(new ImageIcon(img));
		        }
		    }
		});
		
		ImageIcon Email = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Email.png")
			);
		
		JPanelComBackground panel_3 = new JPanelComBackground("/imgs/Email.png");
		panel_2.add(panel_3, "cell 0 3,grow");
		panel_3.setLayout(new MigLayout("", "[0][][100px,grow,left][0]", "[][][]"));
		
		textField = new JTextField();
		panel_3.add(textField, "cell 2 1,growx");
		textField.setColumns(10);
		//panel_3.setLayout(new MigLayout("", "[]", "[]"));
		
		ImageIcon Senha = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Senha.png")
			);
		
		JPanelComBackground panel_4 = new JPanelComBackground("/imgs/Senha.png");
		panel_2.add(panel_4, "cell 0 5,grow");
		panel_4.setLayout(null);
		
		JButton BtnIniciarSessao = new JButton("");
		BtnIniciarSessao.setPreferredSize(new Dimension(500, 100));
		BtnIniciarSessao.setOpaque(false);
		BtnIniciarSessao.setMinimumSize(new Dimension(300, 100));
		BtnIniciarSessao.setIcon(new ImageIcon(TelaInternaLogin.class.getResource("/imgs/btnIniciarSessao.png")));
		BtnIniciarSessao.setFocusPainted(false);
		BtnIniciarSessao.setContentAreaFilled(false);
		BtnIniciarSessao.setBorderPainted(false);
		panel_2.add(BtnIniciarSessao, "cell 0 7");
		
		ImageIcon btnIniciarSessao = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/btnIniciarSessao.png")
			);	
		
		BtnIniciarSessao.setMinimumSize(new Dimension(300, 100));
		BtnIniciarSessao.setPreferredSize(new Dimension(500, 100));
		
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

	}
}
