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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

public class TelaInternaPerfil extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfEmail;
	private JTextField tfNome;
	private String placeholderUsuario = "Nome de Usuário";
	private String placeholderEmail = "Email Cadastrado";
	private JButton btnEditarNome;
	private JButton btnEditarEmail;
	private JButton btnExcluirPerfil;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton btnSair;

	/**
	 * Create the panel.
	 */
	public TelaInternaPerfil() {
		setBackground(new Color(216, 178, 184));
		setLayout(new MigLayout("", "[][grow][]", "[][grow][]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[100][40][500][500,grow][200px][40][0]", "[150px][50px][][40,grow][][][60][][][60][][75px]"));
		panel.setOpaque(false);
		
		
		JPanelComBackground panel_1 = new JPanelComBackground("/imgs/FundoPerfilFinal.png");
		
		
		panel.add(panel_1, "flowx,cell 0 0 7 10,grow");
		panel_1.setLayout(new MigLayout("", "[50][grow][grow][0]", "[60px,grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		
		panel_1.setOpaque(false);
		
		ImageIcon JPNomePerfil = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/JPNomePerfil.png")
			);	
		
		
		ImageIcon Editar = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Editar.png")
			);	
		
		ImageIcon JPEmailPerfil = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/JPEmailPerfil.png")
			);	
		
		
		ImageIcon Editar1 = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Editar.png")
			);	
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/SeuPerfil.png")));
		panel_1.add(lblNewLabel, "cell 1 1 2 1,alignx center");
		
		JLabel lblNomePerfil = new JLabel("");
		lblNomePerfil.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/JPNomePerfil.png")));
		panel_1.add(lblNomePerfil, "flowx,cell 1 2,growx");
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
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Carlito", Font.PLAIN, 25));
		panel_1.add(tfNome, "cell 1 3,grow");
		tfNome.setColumns(10);
		tfNome.setText(placeholderUsuario);
		tfNome.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfNome.getText().equals(placeholderUsuario)) {
					tfNome.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (tfNome.getText().isEmpty()) {
					tfNome.setText(placeholderUsuario);
				}
			}
		});
		tfNome.setOpaque(false);
		tfNome.setBorder(BorderFactory.createEmptyBorder());

	
		btnEditarNome = new JButton("");
		panel_1.add(btnEditarNome, "cell 2 3,alignx right");
		
		
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
		btnEditarNome.setFont(new Font("Carlito", Font.BOLD, 19));
		btnEditarNome.setForeground(new Color(255, 245, 234));
		btnEditarNome.setBackground(new Color(207, 114, 116));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/LinhaFundoPerfil.png")));
		panel_1.add(lblNewLabel_1, "cell 1 4 2 1,alignx center");
		
		JLabel lblEmailPerfil = new JLabel("");
		lblEmailPerfil.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/JPEmailPerfil.png")));
		panel_1.add(lblEmailPerfil, "cell 1 5,growx");
		lblEmailPerfil.setForeground(new Color(72, 53, 40));
		lblEmailPerfil.setFont(new Font("Carlito", Font.BOLD, 20));
		
		
		
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
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Carlito", Font.PLAIN, 25));
		panel_1.add(tfEmail, "cell 1 6,grow");
		tfEmail.setColumns(10);
		tfEmail.setText(placeholderEmail);
		tfEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfEmail.getText().equals(placeholderEmail)) {
					tfEmail.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (tfEmail.getText().isEmpty()) {
					tfEmail.setText(placeholderEmail);
				}
			}
		});
		
		tfEmail.setOpaque(false);
		tfEmail.setBorder(BorderFactory.createEmptyBorder());
		
		btnEditarEmail = new JButton("");
		btnEditarEmail.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/Editar.png")));
		panel_1.add(btnEditarEmail, "cell 2 6,alignx right");
		btnEditarEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
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
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/LinhaFundoPerfil.png")));
		panel_1.add(lblNewLabel_2, "cell 1 7 2 1,alignx center");
		
		btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/Sair.png")));
		panel_1.add(btnSair, "cell 1 8,alignx right");
		
		
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
		            double proporcaoOriginal = (double) Sair.getIconWidth() /  Sair.getIconHeight();
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
		
		
		
		
		
		
		btnExcluirPerfil = new JButton("");
		btnExcluirPerfil.setIcon(new ImageIcon(TelaInternaPerfil.class.getResource("/imgs/Excluir.png")));
		panel_1.add(btnExcluirPerfil, "cell 2 8");
		btnExcluirPerfil.setFont(new Font("Carlito", Font.BOLD, 19));
		btnExcluirPerfil.setForeground(new Color(255, 245, 234));
		btnExcluirPerfil.setBackground(new Color(193, 31, 35));
		
		
		ImageIcon Excluir = new ImageIcon(
			    TelaApresentacao.class.getResource("/imgs/Excluir.png")
			);	
		
		btnExcluirPerfil.setMinimumSize(new Dimension(100, 100));
		btnExcluirPerfil.setPreferredSize(new Dimension(300, 100));
		
		
		btnExcluirPerfil.addComponentListener(new ComponentAdapter() {
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

	public JButton getBtnSair() {
		return btnSair;
	}

	public JButton getBtnExcluirPerfil() {
		return btnExcluirPerfil;
	}

	public String getPlaceholderUsuario() {
		return placeholderUsuario;
	}

	public String getPlaceholderEmail() {
		return placeholderEmail;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public JTextField getTfNome() {
		return tfNome;
	}

	public JButton getBtnEditarEmail() {
		return btnEditarEmail;
	}

	public JButton getBtnEditarNome() {
		return btnEditarNome;
	}

}
