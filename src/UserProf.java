import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserProf extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		UserProf frame = new UserProf();
		frame.setVisible(true);
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserProf frame = new UserProf();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public UserProf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		JLabel lblName = new JLabel("UserID :" + Login.txtUsername.getText());
		lblName.setBounds(15, 64, 494, 57);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		JLabel lblRank = new JLabel("Rank : Informer ");
		lblRank.setBounds(15, 139, 294, 17);
		lblRank.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		JButton btnMissionReport = new JButton("(informer report)");
		btnMissionReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				informer_report b = new informer_report();
				b.setVisible(true);
				setVisible(false);
			}
		});
		btnMissionReport.setBounds(110, 190, 170, 23);
		
		JButton btnBack = new JButton("Log Out");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login.main();
				setVisible(false);
			}
		});
		
		btnBack.setBounds(314, 190, 113, 23);
		contentPane.setLayout(null);
		contentPane.add(btnBack);
		contentPane.add(btnMissionReport);
		contentPane.add(lblRank);
		contentPane.add(lblName);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblWelcome.setBounds(203, 0, 278, 57);
		contentPane.add(lblWelcome);
	}
}
