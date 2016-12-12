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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Executive_home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		
					Executive_home frame = new Executive_home();
					frame.setVisible(true);
					}

	/**
	 * Create the frame.
	 */
	public Executive_home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(260, 60, 700, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewInbox = new JButton("VIEW INBOX");
		btnViewInbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Executive_inbox.main();
				setVisible(false);
				
			}
		});
		btnViewInbox.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnViewInbox.setBackground(Color.LIGHT_GRAY);
		btnViewInbox.setBounds(281, 330, 145, 23);
		contentPane.add(btnViewInbox);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.main();
				setVisible(false);
				
			}
		});
		btnLogOut.setFont(new Font("Sitka Display", Font.BOLD, 13));
		btnLogOut.setBackground(Color.RED);
		btnLogOut.setBounds(305, 391, 89, 23);
		contentPane.add(btnLogOut);
	
		JLabel lblLoggedInAs = new JLabel("Logged In As:");
		lblLoggedInAs.setForeground(Color.WHITE);
		lblLoggedInAs.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblLoggedInAs.setBounds(142, 247, 98, 25);
		contentPane.add(lblLoggedInAs);
		
		JLabel lblWelcome = new JLabel("WELCOME! ");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(248, 180, 178, 25);
		contentPane.add(lblWelcome);
		
		JLabel lbllogdetails = new JLabel(Login.txtUsername.getText());
		lbllogdetails.setForeground(Color.WHITE);
		lbllogdetails.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbllogdetails.setHorizontalAlignment(SwingConstants.CENTER);
		lbllogdetails.setBounds(250, 233, 176, 51);
		contentPane.add(lbllogdetails);
	}
}
