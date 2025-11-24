package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmailIncorreto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmailIncorreto frame = new EmailIncorreto();
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
	public EmailIncorreto() {
		setTitle("Email Inválido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated (true);
		setBounds(100, 100, 190, 120);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 234));

		this.getRootPane().setBorder(BorderFactory.createLineBorder(Color.RED,5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Incorreto");
		lblNewLabel.setFont(new Font("Carlito", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(77, 41, 98, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(EmailIncorreto.class.getResource("/imgs/EmailInvalido.png")));
		lblNewLabel_1.setBounds(10, 11, 63, 70);
		contentPane.add(lblNewLabel_1);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOK.setBackground(new Color(207, 114, 116));
		btnOK.setBounds(77, 80, 53, 28);
		contentPane.add(btnOK);
	}
}
