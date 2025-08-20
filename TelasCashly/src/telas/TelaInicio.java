package telas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class TelaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	boolean menuAberto = true;
	boolean meusProjetosAberto = true;
	private JPanel panelMenu_expanded;
	private JPanel panel_Central;
	private JPanel panelMenuContracted;
	private JPanel panelActual;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicio frame = new TelaInicio();
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
	public TelaInicio() {
		
		setBackground(new Color(216, 178, 184));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		panel.setLayout(new MigLayout("", "[5px,grow 5][60px][grow 10][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][grow 50]", "[fill]"));
		
		JButton btnAbrirMenu = new JButton("");
		btnAbrirMenu.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/BtnMenu.png")));
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
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/LogoCashly2.png")));
		panel.add(lblNewLabel_5, "cell 3 0,alignx center,growy");
		
		panel_Central = new JPanel();
		panel_Central.setBackground(new Color(255, 128, 128));
		contentPane.add(panel_Central, "cell 0 1,grow");
		panel_Central.setLayout(new BorderLayout(0, 0));
		
		panelMenu_expanded = new JPanel();
		panelMenu_expanded.setBackground(new Color(255, 245, 234));
		//panel_1.add(panelMenu_expanded, BorderLayout.WEST);
		panelMenu_expanded.setLayout(new MigLayout("", "[244px]", "[2px][grow 2][grow 2][grow 2][grow 2][][][][][grow][][][][][][]"));
		panel_Central.add(panelMenu_expanded, BorderLayout.WEST);
		
		JButton btnMeusProjetos = new JButton("");
		btnMeusProjetos.setMargin(new Insets(2, 2, 2, 2));
		btnMeusProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				
			}
		});
		btnMeusProjetos.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/BtnMeusProjetos.png")));
		panelMenu_expanded.add(btnMeusProjetos, "cell 0 1,growx,aligny center");
		
		btnMeusProjetos.setBorderPainted(false);
		btnMeusProjetos.setContentAreaFilled(false);
		btnMeusProjetos.setFocusPainted(false);
		btnMeusProjetos.setOpaque(false);
		
		
		
		JButton btnCriarProjetos = new JButton("");
		btnCriarProjetos.setMargin(new Insets(2, 2, 2, 2));
		btnCriarProjetos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCriarProjetos.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/BtnCriarProjetos.png")));
		panelMenu_expanded.add(btnCriarProjetos, "cell 0 2,growx,aligny center");
		
		btnCriarProjetos.setBorderPainted(false);
		btnCriarProjetos.setContentAreaFilled(false);
		btnCriarProjetos.setFocusPainted(false);
		btnCriarProjetos.setOpaque(false);
		
		
		
		JButton btnNotificacoes = new JButton("");
		btnNotificacoes.setMargin(new Insets(2, 2, 2, 2));
		btnNotificacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNotificacoes.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/BtnNotificacoes.png")));
		panelMenu_expanded.add(btnNotificacoes, "cell 0 3,growx,aligny center");
		
		btnNotificacoes.setBorderPainted(false);
		btnNotificacoes.setContentAreaFilled(false);
		btnNotificacoes.setFocusPainted(false);
		btnNotificacoes.setOpaque(false);
		
		
		
		JButton btnColaboradores = new JButton("");
		btnColaboradores.setMargin(new Insets(2, 2, 2, 2));
		btnColaboradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnColaboradores.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/BtnColaboradores.png")));
		panelMenu_expanded.add(btnColaboradores, "cell 0 4,growx,aligny center");
		
		btnColaboradores.setBorderPainted(false);
		btnColaboradores.setContentAreaFilled(false);
		btnColaboradores.setFocusPainted(false);
		btnColaboradores.setOpaque(false);
		
		
		
		JButton btnPerfil = new JButton("");
		btnPerfil.setMargin(new Insets(2, 2, 2, 2));
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPerfil.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/BtnPerfil.png")));
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
		btnNewButton.setIcon(new ImageIcon(TelaInicio.class.getResource("/imgs/BtnPerfilRe.png")));
		panelMenuContracted.add(btnNewButton, "cell 0 20,alignx center,growy");
		
		btnNewButton.setBorderPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setOpaque(false);
		
		
	}
}