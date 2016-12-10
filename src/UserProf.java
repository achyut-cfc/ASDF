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
//	public static void main(String[] args) {
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
//	}

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
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(15, 16, 143, 57);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		JLabel lblRank = new JLabel("Rank :");
		lblRank.setBounds(15, 79, 90, 17);
		lblRank.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		JButton btnMissionReport = new JButton("(informer report)");
		btnMissionReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMissionReport.setBounds(72, 190, 113, 23);
		
		JButton btnReportStatus = new JButton("Check  Status");
		btnReportStatus.setBounds(191, 190, 99, 23);
		
		JButton btnBack = new JButton("Log Out");
		btnBack.setBounds(314, 190, 113, 23);
		contentPane.setLayout(null);
		contentPane.add(btnBack);
		contentPane.add(btnMissionReport);
		contentPane.add(btnReportStatus);
		contentPane.add(lblRank);
		contentPane.add(lblName);
	}
}
