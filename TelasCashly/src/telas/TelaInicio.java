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

public class TelaInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	boolean menuAberto = true;
	private JPanel panelMenu_expanded;
	private JPanel panel_Central;
	private JPanel panelMenuContracted;

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
		panel.setLayout(new MigLayout("", "[grow 5][60px][grow 10][][][][][][][][][][][][grow][][][][][][][][][][][][][][][][][][][][][][grow 50]", "[fill]"));
		
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
		//panel_1.add(panelMenu_expanded, BorderLayout.WEST);
		panelMenu_expanded.setLayout(new MigLayout("", "[100px]", "[][][][]"));
		
		JLabel lblNewLabel = new JLabel("New label");
		panelMenu_expanded.add(lblNewLabel, "cell 0 1");
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panelMenu_expanded.add(lblNewLabel_1, "cell 0 2");
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		panelMenu_expanded.add(lblNewLabel_2, "cell 0 3");
		panel_Central.add(panelMenu_expanded, BorderLayout.WEST);
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(216, 178, 184));
		panel_Central.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][]", "[fill][][][][][][][][][fill]"));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		panel_3.add(lblNewLabel_3, "cell 18 9");
		
		panelMenuContracted = new JPanel();
		
		panelMenuContracted.setLayout(new MigLayout("", "[]", "[][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		panelMenuContracted.add(lblNewLabel_4, "cell 0 18");
		
		
	}
}