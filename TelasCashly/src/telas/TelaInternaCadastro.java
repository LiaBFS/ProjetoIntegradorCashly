package telas;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SwingConstants;

import classesBanco.UsuarioDAO;

import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInternaCadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private String placeholderUsuario = "Usuário";
	private String placeholderEmail = "Email";
	private String placeholderSenha = "Senha";
	
	private UsuarioDAO usuarioDAO;
	
	private void abrirTelaInicial(TelaCredenciais telaCredenciais) {
		telaCredenciais.dispose(); // Fecha a tela atual
        new TelaInicio().setVisible(true); // Abre a tela de cadastro
    }


	
	/**
	 * Create the panel.
	 * @param telaCredenciais 
	 */
	private void abrirTelaApresentacao() {
	    dispose(); // Fecha a tela atual
	    new TelaApresentacao().setVisible(true); // Abre a tela de cadastro
	}
	
	private void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	 private void abrirTelaLogin() {
	        dispose(); // Fecha a tela atual
	        new TelaCredenciais("login").setVisible(true); // Abre direto no login
	    }

	public TelaInternaCadastro(TelaCredenciais telaCredenciais, UsuarioDAO usuarioDAO) {
		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[50px,grow][100px,grow][35px,grow][70px][476px,grow][130px,grow]", "[grow][grow][75px,grow][70px,grow][75px,grow]"));
		
		this.usuarioDAO = usuarioDAO;
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 178, 184));
		add(panel, "cell 0 0 6 1,grow");
		panel.setLayout(new MigLayout("", "[grow 50][][][][][][][grow][][][][grow][][][][][][][][][][grow 50]", "[70px,fill]"));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setPreferredSize(new Dimension(500, 500));
		lblLogo.setMinimumSize(new Dimension(10, 5));
		lblLogo.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/LogoCashly.png")));
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
		
		JButton btnInicio = new JButton("");
		panel.add(btnInicio, "cell 14 0,growx,aligny center");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaApresentacao();
			}
		});
		btnInicio.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/BtnInicio2.png")));
		
		btnInicio.setBorderPainted(false);
		btnInicio.setContentAreaFilled(false);
		btnInicio.setFocusPainted(false);
		btnInicio.setOpaque(false);
		
		JButton btnCadastro = new JButton("");
		btnCadastro.setOpaque(false);
		btnCadastro.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/BtnCadastroSel.png")));
		btnCadastro.setFocusPainted(false);
		btnCadastro.setContentAreaFilled(false);
		btnCadastro.setBorderPainted(false);
		panel.add(btnCadastro, "cell 17 0");
		
		JButton btnLogin = new JButton("");
		panel.add(btnLogin, "cell 20 0,alignx left,aligny center");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaLogin();
			}
		});
		btnLogin.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/BtnLogin.png")));
		
		btnLogin.setBorderPainted(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setFocusPainted(false);
		btnLogin.setOpaque(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 178, 184));
		add(panel_1, "cell 2 2 2 2,grow");
		panel_1.setLayout(new MigLayout("", "[grow]", "[grow][][grow]"));
		
		JButton btnIrProLogin = new JButton("");
		btnIrProLogin.setPreferredSize(new Dimension(1000, 900));
		btnIrProLogin.setOpaque(false);
		btnIrProLogin.setMinimumSize(new Dimension(600, 600));
		btnIrProLogin.setIcon(new ImageIcon(TelaInternaCadastro.class.getResource("/imgs/IrProLogin2.png")));
		btnIrProLogin.setFocusPainted(false);
		btnIrProLogin.setContentAreaFilled(false);
		btnIrProLogin.setBorderPainted(false);
		btnIrProLogin.setBackground(new Color(216, 178, 184));
		panel_1.add(btnIrProLogin, "cell 0 1 1 2,grow");

		
		btnIrProLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirTelaLogin();
			}
		});
		
		ImageIcon IrProLogin2 = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/IrProLogin2.png")
			);	
		
		btnIrProLogin.setMinimumSize(new Dimension(600, 600));
		btnIrProLogin.setPreferredSize(new Dimension(950, 900));
		
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
		panel_2.setLayout(new MigLayout("", "[grow]", "[grow 50][][grow 30][grow][5px][grow][5px][grow][grow 30][][grow 50]"));
		
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
		
		ImageIcon Usuario = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Usuario.png")
			);
		
		ImageIcon Email = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Email.png")
			);
		
		ImageIcon Senha = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Senha.png")
			);
		
		JPanelComBackground panel_3 = new JPanelComBackground("/imgs/Usuario.png");
		panel_2.add(panel_3, "cell 0 3,grow");
		panel_3.setLayout(new MigLayout("", "[0][grow 20][100px,grow,left][0]", "[grow][grow][grow]"));
		
		txtNome = new JTextField();
		txtNome.setForeground(new Color(255, 245, 234));
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNome.setText(placeholderUsuario);
		txtNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtNome.getText().equals(placeholderUsuario)) {
					txtNome.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtNome.getText().isEmpty()) {
					txtNome.setText(placeholderUsuario);
				}
			}
		});
		
		txtNome.setBackground(new Color(207, 114, 116));
		panel_3.add(txtNome, "cell 2 1,growx");
		txtNome.setColumns(10);
		txtNome.setBorder(BorderFactory.createEmptyBorder());
		
		JPanelComBackground panel_4 = new JPanelComBackground("/imgs/Email.png");
		panel_2.add(panel_4, "cell 0 5,grow");
		panel_4.setLayout(new MigLayout("", "[0][grow 20][100px,grow,left][0]", "[grow][grow][grow]"));
		
		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(255, 245, 234));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setText(placeholderEmail);
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtEmail.getText().equals(placeholderEmail)) {
					txtEmail.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtEmail.getText().isEmpty()) {
					txtEmail.setText(placeholderEmail);
				}
			}
		});
		
		txtEmail.setInputVerifier(new InputVerifier() {
		    @Override
		    public boolean verify(JComponent input) {
		        String email = ((JTextField) input).getText();
		        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

		        if (!email.matches(regex)) {
		            JOptionPane.showMessageDialog(null, 
		                "Digite um email válido (exemplo: usuario@dominio.com)", 
		                "Email Inválido", JOptionPane.ERROR_MESSAGE);
		            return false; // impede o foco de sair se o email for inválido
		        }
		        return true;
		    }
		});
		
		txtEmail.setBackground(new Color(207, 114, 116));
		panel_4.add(txtEmail, "cell 2 1,growx");
		txtEmail.setColumns(10);
		txtEmail.setBorder(BorderFactory.createEmptyBorder());
		
		
		JPanelComBackground panel_5 = new JPanelComBackground("/imgs/Senha.png");
		panel_2.add(panel_5, "cell 0 7,grow");
		panel_5.setLayout(new MigLayout("", "[0][grow 20][100px,grow,left][0]", "[grow][grow][grow]"));
		
		txtSenha = new JPasswordField();
		txtSenha.setForeground(new Color(255, 245, 234));
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSenha.setEchoChar('•'); // aqui define o símbolo da senha

		// Placeholder para senha
		txtSenha.setText(placeholderSenha);
		txtSenha.setEchoChar((char) 0); // mostra texto normal enquanto placeholder

		txtSenha.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (String.valueOf(txtSenha.getPassword()).equals(placeholderSenha)) {
		            txtSenha.setText("");
		            txtSenha.setEchoChar('•'); // volta a esconder
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (String.valueOf(txtSenha.getPassword()).isEmpty()) {
		            txtSenha.setText(placeholderSenha);
		            txtSenha.setEchoChar((char) 0); // mostra texto normal de placeholder
		        }
		    }
		});

		txtSenha.setBackground(new Color(207, 114, 116));
		panel_5.add(txtSenha, "cell 2 1,growx");
		txtSenha.setColumns(10);
		txtSenha.setBorder(BorderFactory.createEmptyBorder());
		
		
		
	
		
		
		JButton btnCadastrar = new JButton("");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = txtNome.getText();
				String email = txtEmail.getText();
				String senha = String.valueOf(txtSenha.getPassword());
				
				
				if (nome.equals(placeholderUsuario) || email.equals(placeholderEmail) || senha.equals(placeholderSenha)|| nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Todos os campos do Cadastro são obrigatórios.", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
			        return;
			    }
				
				if(nome.length() < 3) {
					JOptionPane.showMessageDialog(null, "Crie um usuário contendo no mínimo 3 dígitos.", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
					txtNome.setText(placeholderUsuario);
					return;
				}
				
				if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
				    JOptionPane.showMessageDialog(null, "Formato de email inválido. Exemplo: usuario@dominio.com", "Erro de Cadastro", JOptionPane.ERROR_MESSAGE);
				    txtEmail.setText(placeholderEmail);
				    return;
				}
				
				if(senha.length() < 8 || senha.length() > 30) {
					JOptionPane.showMessageDialog(null, "Crie uma senha contendo de 8 a 30 dígitos.", "Erro de Senha", JOptionPane.ERROR_MESSAGE);
					txtSenha.setText(placeholderSenha);
					return;
				}
				
				
				classesBanco.Usuario novoUsuario = new classesBanco.Usuario();
                novoUsuario.setNome(txtNome.getText());
                novoUsuario.setEmail(txtEmail.getText());
                novoUsuario.setSenha(txtSenha.getText());
                
                usuarioDAO.adicionarUsuario(novoUsuario);
                
                abrirTelaLogin();
				
			}
		});
		
		
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
