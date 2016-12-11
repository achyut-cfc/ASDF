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

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {

	JFrame frame;
	static JTextField txtUsername;
	private JPasswordField passwordField;


	 // Create the application.
	 
	public Login() {
		initialize();
	}

	public static void main(){
		Login w = new Login();
	    w.frame.setVisible(true);
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
			public void actionPerformed(ActionEvent arg0) {
				
			           java.sql.Connection conn;
					try {
						
						conn = DriverManager.getConnection (Main.url,"clint","passkey1");
							
				          java.sql.PreparedStatement pst=conn.prepareStatement("Select * from user where user_id=? and password=?");
				          pst.setString(1, txtUsername.getText());
				          pst.setString(2, passwordField.getText());
				          
				          ResultSet set= pst.executeQuery();
				        int flag=0;
				          while(set.next()){
				        	  
				        	  flag=1;
				        	  if (set.getString("Designation").equals("Informer")){
				        		  
				        		  UserProf.main();
				        		  frame.setVisible(false); 
				        		  
				        	  }
				        	  else if(set.getString("Designation").equals("Admin")){
				        		  
				        		  admin_welcome.main();
				        		  frame.setVisible(false);
				        	  }
				        	  else if(set.getString("Designation").equals("Executive")) {
				        		  

				        		  Executive_home.main();
//github.com/achyut-cfc/ASDF.git
				        		  frame.setVisible(false);
				        	  }
				        	  else{
				        		  JOptionPane.showMessageDialog(null, "You have not been assigned a designation. Try contacting the admin");
				        	  }
				        	  
				        	  
				        	  
				          }
				          conn.close();
				          if (flag==0){
				        	  JOptionPane.showMessageDialog(null, "User not found");
				          }
				          
				           
					} catch (SQLException e) {
						// TODO Auto-generated catch block
//						JOptionPane.showMessageDialog(null, "Connection failed"+e);
						e.printStackTrace();
					}
				
			}
		});
	
		txtUsername = new JTextField();
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
		
		frame.getRootPane().setDefaultButton(btnLogin);
		btnLogin.requestFocus();
	}

}
