package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;

public class LoginIncorreto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginIncorreto frame = new LoginIncorreto();
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
	public LoginIncorreto() {
		setBackground(new Color(255, 245, 234));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 122);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginIncorreto.class.getResource("/imgs/EmailInvalido.png")));
		lblNewLabel_1.setBounds(10, 13, 63, 70);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Digite um email válido (exemplo: exemplo@gmail.com)");
		lblNewLabel.setFont(new Font("Carlito", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(77, 43, 345, 28);
		contentPane.add(lblNewLabel);
		
		JButton btnOK = new JButton("OK");
		btnOK.setBackground(new Color(207, 114, 116));
		btnOK.setBounds(180, 83, 53, 28);
		contentPane.add(btnOK);
	}

}
