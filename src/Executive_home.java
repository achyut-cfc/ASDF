import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JMenu;
import javax.swing.JList;

public class Executive_home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Executive_home frame = new Executive_home();
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
	public Executive_home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(260, 60, 700, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewInbox = new JButton("VIEW INBOX");
		btnViewInbox.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnViewInbox.setBackground(Color.DARK_GRAY);
		btnViewInbox.setBounds(281, 381, 127, 23);
		contentPane.add(btnViewInbox);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.setFont(new Font("Sitka Display", Font.BOLD, 13));
		btnLogOut.setBackground(Color.DARK_GRAY);
		btnLogOut.setBounds(298, 426, 89, 23);
		contentPane.add(btnLogOut);
	
		JLabel lblLoggedInAs = new JLabel("Logged In As:");
		lblLoggedInAs.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblLoggedInAs.setBounds(142, 247, 98, 25);
		contentPane.add(lblLoggedInAs);
		
		JLabel lblWelcome = new JLabel("WELCOME! ");
		lblWelcome.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(248, 180, 178, 25);
		contentPane.add(lblWelcome);
		
		JLabel lbllogdetails = new JLabel("");
		lbllogdetails.setBounds(250, 247, 176, 123);
		contentPane.add(lbllogdetails);
	}
}
