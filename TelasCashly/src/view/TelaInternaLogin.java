package view;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import model.PasswordUtils;
import model.Usuario;
import model.UsuarioDAO;

import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;

public class TelaInternaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtEmail;
	private String placeholderEmail = "Email";
	public String getPlaceholderEmail() {
		return placeholderEmail;
	}

	public String getPlaceholderSenha() {
		return placeholderSenha;
	}

	private JPasswordField txtSenha;
	private String placeholderSenha = "Senha";
	
//	private UsuarioDAO usuarioDAO;
	private JButton btnCadastrar;
	private JButton btnIrCadastro;
	private JButton btnInicio;
	private JButton BtnIniciarSessao;
	


	public JButton getBtnInicio() {
		return btnInicio;
	}

	
	
	

	/**
	 * Create the panel.
	 * @param telaCredenciais 
	 * @param usuarioDAO 
	 */
	
	
	public TelaInternaLogin(TelaCredenciais telaCredenciais) {
		setForeground(new Color(255, 245, 234));
		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[50px,grow][100px,grow][35px,grow][70px][476px,grow][130px,grow]", "[grow][grow][grow][75px][70px,grow][75px,grow]"));
		
//		this.usuarioDAO = usuarioDAO;
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 178, 184));
		add(panel, "cell 0 0 6 1,growx,aligny center");
		panel.setLayout(new MigLayout("", "[grow 50][][][][][][][grow][][][][grow][][][][][][][][][][][grow 50]", "[70px]"));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setPreferredSize(new Dimension(500, 100));
		lblLogo.setMinimumSize(new Dimension(10, 5));
		lblLogo.setIcon(new ImageIcon(TelaInternaLogin.class.getResource("/imgs/LogoCashly.png")));
		panel.add(lblLogo, "cell 1 0,growx,aligny center");
		
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
		
		btnInicio = new JButton("");
		panel.add(btnInicio, "cell 14 0,growx,aligny center");
		btnInicio.setIcon(new ImageIcon(TelaInternaLogin.class.getResource("/imgs/BtnInicio2.png")));
		
		btnInicio.setBorderPainted(false);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setFocusPainted(false);
		btnInicio.setOpaque(false);
		
		btnCadastrar = new JButton("");
		panel.add(btnCadastrar, "cell 17 0,grow");
		
		
		btnCadastrar.setIcon(new ImageIcon(TelaInternaLogin.class.getResource("/imgs/BtnCadastro.png")));
		
		btnCadastrar.setBorderPainted(false);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setOpaque(false);
		
		
		JButton btnLogin = new JButton("");
		btnLogin.setOpaque(false);
		btnLogin.setIcon(new ImageIcon(TelaInternaLogin.class.getResource("/imgs/Login2.png")));
		btnLogin.setFocusPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		panel.add(btnLogin, "cell 20 0,alignx left,aligny center");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 178, 184));
		add(panel_1, "cell 2 2 2 2,grow");
		panel_1.setLayout(new MigLayout("", "[grow]", "[][grow][]"));
		
		btnIrCadastro = new JButton("");
		
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
		panel_2.setLayout(new MigLayout("", "[grow]", "[grow 150][][grow 30][20px,grow][5px][15px,grow][grow 30][][grow 150]"));
		
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
		panel_3.setLayout(new MigLayout("", "[0][grow 20][100px,grow,left][0]", "[grow][grow][grow]"));
		
		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(255, 245, 234));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setText(placeholderEmail);
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEmail.getText().equals(placeholderEmail)){
					txtEmail.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtEmail.getText().isEmpty()){
					txtEmail.setText(placeholderEmail);
				}
			}
		});
		txtEmail.setBackground(new Color(207, 114, 116));
		txtEmail.setToolTipText("");
		panel_3.add(txtEmail, "cell 2 1,growx");
		txtEmail.setColumns(10);
		txtEmail.setBorder(BorderFactory.createEmptyBorder()); 
		
		
		ImageIcon Senha = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Senha.png")
			);
		
		JPanelComBackground panel_4 = new JPanelComBackground("/imgs/Senha.png");
		panel_2.add(panel_4, "cell 0 5,grow");
		panel_4.setLayout(new MigLayout("", "[0][grow 20][100px,grow,left][0]", "[grow][grow][grow]"));
		
		txtSenha = new JPasswordField();
		txtSenha.setForeground(new Color(255, 245, 234));
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSenha.setText(placeholderSenha);

		// 🔹 enquanto for placeholder, não censura
		txtSenha.setEchoChar((char)0);

		txtSenha.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if(new String(txtSenha.getPassword()).equals(placeholderSenha)){
		            txtSenha.setText("");
		            txtSenha.setEchoChar('•'); // ativa censura só quando usuário digitar
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if(txtSenha.getPassword().length == 0){
		            txtSenha.setText(placeholderSenha);
		            txtSenha.setEchoChar((char)0); // volta a mostrar texto normal
		        }
		    }
		});

		txtSenha.setBackground(new Color(207, 114, 116));
		panel_4.add(txtSenha, "cell 2 1,growx");
		txtSenha.setColumns(10);
		txtSenha.setBorder(BorderFactory.createEmptyBorder());
		
		BtnIniciarSessao = new JButton("");
		
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
	
	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	public JPasswordField getTxtSenha() {
		return txtSenha;
	}

	public void setTxtSenha(JPasswordField txtSenha) {
		this.txtSenha = txtSenha;
	}

	public JButton getBtnIniciarSessao() {
		return BtnIniciarSessao;
	}

	public JButton getBtnIrCadastro() {
		return btnIrCadastro;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public void resetarTxtEmail() {
		// TODO Auto-generated method stub
		
	}

	public void resetarTxtSenha() {
		// TODO Auto-generated method stub
		
	}

	
}
