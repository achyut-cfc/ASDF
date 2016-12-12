import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class admin_welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		admin_welcome frame = new admin_welcome();
		frame.setVisible(true);
		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					admin_welcome frame = new admin_welcome();
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
	public admin_welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(260, 60, 700,550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblYouAreLogged = new JLabel("You are logged in as Admin");
		lblYouAreLogged.setForeground(Color.WHITE);
		lblYouAreLogged.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouAreLogged.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.RED);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Login.main();
				setVisible(false);
				
				
			}
		});
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		admin_policestationpanel PstnPanel = new admin_policestationpanel();
		admin_criminalrecordpanel crimPanel = new admin_criminalrecordpanel();
		admin_suspectpanel susPanel = new admin_suspectpanel();
		susPanel.setBackground(Color.BLACK);
		tabbedPane.addTab("Police Departments", PstnPanel);
		tabbedPane.addTab("Criminal Records", crimPanel);
		tabbedPane.addTab("Suspects Record", susPanel);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(608, Short.MAX_VALUE)
					.addComponent(btnLogout)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 673, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(50, Short.MAX_VALUE)
					.addComponent(lblYouAreLogged, GroupLayout.PREFERRED_SIZE, 601, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblYouAreLogged, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btnLogout)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
