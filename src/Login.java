import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;



import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
<<<<<<< HEAD
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;
=======
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
>>>>>>> branch 'master' of https://github.com/achyut-cfc/ASDF.git

public class Login {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
<<<<<<< HEAD
	public static void main( ) {
=======
	
	public static void main(String[] args) {
>>>>>>> branch 'master' of https://github.com/achyut-cfc/ASDF.git
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
<<<<<<< HEAD
			        
			        
					Login window = new Login();
					window.frame.setVisible(true);
=======
					Login newlogin = new Login();
					
					newlogin.frame.setVisible(true);
>>>>>>> branch 'master' of https://github.com/achyut-cfc/ASDF.git
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 842, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Password");
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
<<<<<<< HEAD
			
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		//frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setVisible(true);
		//frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
=======
			public void actionPerformed(ActionEvent arg0) {

				
		           String url = "jdbc:mysql://10.6.7.119:3306/database1";
		           try {
					Class.forName ("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		           Connection conn;
				try {
					conn = DriverManager.getConnection (url,"clint","passkey1");
						
			          PreparedStatement pst=conn.prepareStatement("Select * from user where user_id=? and password=?");
			          pst.setString(1, txtUsername.getText());
			          pst.setString(2, passwordField.getText());
			          
			          ResultSet set= pst.executeQuery();
			          
			          if (set.next()){
			        	  JOptionPane.showMessageDialog(null, "Login Successful");
			        	  
			        	  UserProf frame = new UserProf();
			        	  frame.setVisible(true);
			          }
			          else
			        	  JOptionPane.showMessageDialog(null, "User ID or password incorrect> try Again");
			           
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         
		    
		         
				
			}
		});
		
>>>>>>> branch 'master' of https://github.com/achyut-cfc/ASDF.git
		
		txtUsername = new JTextField();
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				txtUsername.setText("");
				txtUsername.setForeground(Color.BLACK);
			}
		});
		txtUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtUsername.setText("");
				
				txtUsername.setForeground(Color.black);
				}
		});
		
		txtUsername.setForeground(Color.LIGHT_GRAY);
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setText("Username");
		txtUsername.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(87)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
								.addComponent(txtUsername, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(145)
							.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(58)))
					.addGap(74))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(32, Short.MAX_VALUE)
					.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(btnLogin)
					.addGap(27))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(246)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 334, Short.MAX_VALUE)
					.addGap(246))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(229, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
