package view;

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
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Dimension;

public class TelaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	boolean menuAberto = true;
	boolean meusProjetosAberto = true;
	private JPanel panelMenu_expanded;
	private JPanel panel_Central;
	private JPanel panelMenuContracted;
	private JPanel panelActual;
	
	private JButton btnMeusProjetos;
	private JButton btnCriarProjetos;
	private JButton btnNotificacoes;
	private JButton btnColaboradores;
	private JButton btnPerfil;

	private ImageIcon iconMeusProjetos = new ImageIcon(getClass().getResource("/BtnMeusProjetos.png"));
	private ImageIcon iconMeusProjetosSel = new ImageIcon(getClass().getResource("/btnMeusProjetosSEL.png"));

	private ImageIcon iconCriarProjetos = new ImageIcon(getClass().getResource("/BtnCriarProjetos.png"));
	private ImageIcon iconCriarProjetosSel = new ImageIcon(getClass().getResource("/btnCriarProjetoSEL.png"));

	private ImageIcon iconNotificacoes = new ImageIcon(getClass().getResource("/BtnNotificacoes.png"));
	private ImageIcon iconNotificacoesSel = new ImageIcon(getClass().getResource("/btnNotificacoesSEL.png"));

	private ImageIcon iconColaboradores = new ImageIcon(getClass().getResource("/BtnColaboradores.png"));
	private ImageIcon iconColaboradoresSel = new ImageIcon(getClass().getResource("/btnColaboradoresSEL.png"));

	private ImageIcon iconPerfil = new ImageIcon(getClass().getResource("/BtnPerfil.png"));
	private ImageIcon iconPerfilSel = new ImageIcon(getClass().getResource("/btnPerfilSEL.png"));

	private void selecionarBotao(JButton botaoSelecionado) {
	    // Reseta todos os ícones
	    btnMeusProjetos.setIcon(iconMeusProjetos);
	    btnCriarProjetos.setIcon(iconCriarProjetos);
	    btnNotificacoes.setIcon(iconNotificacoes);
	    btnColaboradores.setIcon(iconColaboradores);
	    btnPerfil.setIcon(iconPerfil);

	    // Ativa o ícone selecionado do botão clicado
	    if (botaoSelecionado == btnMeusProjetos) {
	        botaoSelecionado.setIcon(iconMeusProjetosSel);
	    } else if (botaoSelecionado == btnCriarProjetos) {
	        botaoSelecionado.setIcon(iconCriarProjetosSel);
	    } else if (botaoSelecionado == btnNotificacoes) {
	        botaoSelecionado.setIcon(iconNotificacoesSel);
	    } else if (botaoSelecionado == btnColaboradores) {
	        botaoSelecionado.setIcon(iconColaboradoresSel);
	    } else if (botaoSelecionado == btnPerfil) {
	        botaoSelecionado.setIcon(iconPerfilSel);
	    }
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
					frame.setVisible(true);
					
					frame.addComponentListener(new ComponentAdapter() {
						public void componentResized(ComponentEvent e) {
							Dimension d=frame.getSize();
							Dimension minD=frame.getMinimumSize();
							if(d.width<minD.width) {
								d.width=minD.width;
							}
							if(d.height<minD.height) {
								d.height=minD.height;
							}
							
							frame.setSize(d);
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	
	
	public TelaInicio() {
		
		setBackground(new Color(216, 178, 184));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(950, 690)); // tamanho mínimo

		// Faz abrir em tela cheia
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza
        // setUndecorated(true); // Opcional: sem bordas e barra de título
        // setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize()); // Opcional: força resolução exata

        
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(180, 98, 100));
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBorder(null);
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("insets 0", "[958px,grow,fill]", "[70px,fill][630px,grow,fill]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(207, 114, 116));
		contentPane.add(panel, "cell 0 0,grow");
		panel.setLayout(new MigLayout("", "[5px,grow 5][60px][grow 10][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][5px,grow 5]", "[fill]"));
		
		JButton btnAbrirMenu = new JButton("");
		btnAbrirMenu.setIcon(new ImageIcon(TelaInicio.class.getResource("/BtnMenu.png")));
		btnAbrirMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (menuAberto == false) {
					menuAberto  = true;
					
					panel_Central.remove(panelMenu_expanded);

			        // Novo painel para o lado esquerdo
			        			        // Adiciona o novo painel na mesma posição
					panel_Central.add(panelMenuContracted, BorderLayout.WEST);

					
					
				} else {
					menuAberto = false; 
					
					panel_Central.remove(panelMenuContracted);

			        // Novo painel para o lado esquerdo
			        			        // Adiciona o novo painel na mesma posição
					panel_Central.add(panelMenu_expanded, BorderLayout.WEST);

				}
			    // Atualiza a interface
		        revalidate();
		        repaint();
				
			}
		});
		
		
		
		
		
		btnAbrirMenu.setBorderPainted(false);
		btnAbrirMenu.setContentAreaFilled(false);
		btnAbrirMenu.setFocusPainted(false);
		btnAbrirMenu.setOpaque(false);
		panel.add(btnAbrirMenu, "cell 1 0,alignx left,aligny bottom");
		
		JLabel lblLogoCashly = new JLabel("");
		lblLogoCashly.setIcon(new ImageIcon(TelaInicio.class.getResource("/LogoCashly2.png")));
		panel.add(lblLogoCashly, "cell 3 0,alignx center,growy");
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel_Central.remove(panelActual);
	  	        panelActual = new TelaInternaInicial(); // <- seu JPanel de projetos
		        panel_Central.add(panelActual, BorderLayout.CENTER);
		        
				selecionarBotao(null);


		        panelMenu_expanded.revalidate();
		        panelMenu_expanded.repaint();


		        panel_Central.revalidate();
		        panel_Central.repaint();
				
			}
		});
		btnNewButton_1.setMargin(new Insets(1, 1, 1, 1));
		btnNewButton_1.setIcon(new ImageIcon(TelaInicio.class.getResource("/BtnHome.png")));
		
		
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setOpaque(false);
		panel.add(btnNewButton_1, "cell 35 0");
		
		
		
		panel_Central = new JPanel();
		panel_Central.setBackground(new Color(255, 128, 128));
		contentPane.add(panel_Central, "cell 0 1,grow");
		panel_Central.setLayout(new BorderLayout(0, 0));
		
		panelMenu_expanded = new JPanel();
		panelMenu_expanded.setBackground(new Color(255, 245, 234));
		//panel_1.add(panelMenu_expanded, BorderLayout.WEST);
		panelMenu_expanded.setLayout(new MigLayout("", "[244px]", "[2px][grow 2][grow 2][grow 2][grow 2][][][][][grow][][][][][][]"));
		panel_Central.add(panelMenu_expanded, BorderLayout.WEST);
		
		
//		ImageIcon iconMeusProjetos = new ImageIcon(TelaInicio.class.getResource("/imgs/BtnMeusProjetos.png"));
		
		btnMeusProjetos = new JButton("");
		btnMeusProjetos.setMargin(new Insets(2, 2, 2, 2));
		btnMeusProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionarBotao(btnMeusProjetos);

//		        panel_Central.remove(panelActual);
	//	        panelActual = new TelaInternaProjetos(); // <- seu JPanel de projetos
		//        panel_Central.add(panelActual, BorderLayout.CENTER);

		        panelMenu_expanded.revalidate();
		        panelMenu_expanded.repaint();
		        panel_Central.revalidate();
		        panel_Central.repaint();
		        
			}
		});
		btnMeusProjetos.setIcon(new ImageIcon(TelaInicio.class.getResource("/BtnMeusProjetos.png")));
		panelMenu_expanded.add(btnMeusProjetos, "cell 0 1,growx,aligny center");
		
		btnMeusProjetos.setBorderPainted(false);
		btnMeusProjetos.setContentAreaFilled(false);
		btnMeusProjetos.setFocusPainted(false);
		btnMeusProjetos.setOpaque(false);
		
		btnMeusProjetos.setPreferredSize(new Dimension(70, 70));
		btnMeusProjetos.setMinimumSize(new Dimension(30, 30));
		
		
		
		
		btnCriarProjetos = new JButton("");
		btnCriarProjetos.setMargin(new Insets(2, 2, 2, 2));
		btnCriarProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selecionarBotao(btnCriarProjetos);

		        panel_Central.remove(panelActual);
		        panelActual = new TelaInternaCriar(); // <- seu JPanel de projetos
		        panel_Central.add(panelActual, BorderLayout.CENTER);

		        panelMenu_expanded.revalidate();
		        panelMenu_expanded.repaint();
		        panel_Central.revalidate();
		        panel_Central.repaint();
			}
		});
		btnCriarProjetos.setIcon(new ImageIcon(TelaInicio.class.getResource("/BtnCriarProjetos.png")));
		panelMenu_expanded.add(btnCriarProjetos, "cell 0 2,growx,aligny center");
		
		btnCriarProjetos.setBorderPainted(false);
		btnCriarProjetos.setContentAreaFilled(false);
		btnCriarProjetos.setFocusPainted(false);
		btnCriarProjetos.setOpaque(false);
		
		
		
		 btnNotificacoes = new JButton("");
		btnNotificacoes.setMargin(new Insets(2, 2, 2, 2));
		btnNotificacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selecionarBotao(btnNotificacoes);

//		        panel_Central.remove(panelActual);
	//	        panelActual = new TelaInternaProjetos(); // <- seu JPanel de projetos
		//        panel_Central.add(panelActual, BorderLayout.CENTER);

		        panelMenu_expanded.revalidate();
		        panelMenu_expanded.repaint();
		        panel_Central.revalidate();
		        panel_Central.repaint();
			}
		});
		btnNotificacoes.setIcon(new ImageIcon(TelaInicio.class.getResource("/BtnNotificacoes.png")));
		panelMenu_expanded.add(btnNotificacoes, "cell 0 3,growx,aligny center");
		
		btnNotificacoes.setBorderPainted(false);
		btnNotificacoes.setContentAreaFilled(false);
		btnNotificacoes.setFocusPainted(false);
		btnNotificacoes.setOpaque(false);
		
		
		
		 btnColaboradores = new JButton("");
		btnColaboradores.setMargin(new Insets(2, 2, 2, 2));
		btnColaboradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selecionarBotao(btnColaboradores);

//		        panel_Central.remove(panelActual);
	//	        panelActual = new TelaInternaProjetos(); // <- seu JPanel de projetos
		//        panel_Central.add(panelActual, BorderLayout.CENTER);

		        panelMenu_expanded.revalidate();
		        panelMenu_expanded.repaint();
		        panel_Central.revalidate();
		        panel_Central.repaint();
			}
		});
		btnColaboradores.setIcon(new ImageIcon(TelaInicio.class.getResource("/BtnColaboradores.png")));
		panelMenu_expanded.add(btnColaboradores, "cell 0 4,growx,aligny center");
		
		btnColaboradores.setBorderPainted(false);
		btnColaboradores.setContentAreaFilled(false);
		btnColaboradores.setFocusPainted(false);
		btnColaboradores.setOpaque(false);
		
		
		
		 btnPerfil = new JButton("");
		btnPerfil.setMargin(new Insets(2, 2, 2, 2));
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selecionarBotao(btnPerfil);

 		        panel_Central.remove(panelActual);
	  	        panelActual = new TelaInternaPerfil(); // <- seu JPanel de projetos
		        panel_Central.add(panelActual, BorderLayout.CENTER);

		        panelMenu_expanded.revalidate();
		        panelMenu_expanded.repaint();
		        panel_Central.revalidate();
		        panel_Central.repaint();
			}
		});
		btnPerfil.setIcon(new ImageIcon(TelaInicio.class.getResource("/BtnPerfil.png")));
		panelMenu_expanded.add(btnPerfil, "cell 0 14,alignx center,growy");
		
		btnPerfil.setBorderPainted(false);
		btnPerfil.setContentAreaFilled(false);
		btnPerfil.setFocusPainted(false);
		btnPerfil.setOpaque(false);
		
		
		JPanel panel_3 = new TelaInternaInicial();
		panel_3.setBackground(new Color(216, 178, 184));
		panelActual=panel_3;
		panel_Central.add(panel_3, BorderLayout.CENTER);
		//panel_3.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][]", "[fill][][][][][][][][][fill]"));
		
		
		
		panelMenuContracted = new JPanel();
		panelMenuContracted.setBackground(new Color(255, 245, 234));
		
		panelMenuContracted.setLayout(new MigLayout("", "[42px]", "[][][][][][][][][][][][][][][][][][grow][][][][]"));
		//panel_Central.add(panelMenuContracted, BorderLayout.WEST);
		
		
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setMargin(new Insets(2, 2, 2, 2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setIcon(new ImageIcon(TelaInicio.class.getResource("/BtnPerfilRe.png")));
		panelMenuContracted.add(btnNewButton, "cell 0 20,alignx center,growy");
		
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setOpaque(false);
		
		
		
		
		
		
	}
}