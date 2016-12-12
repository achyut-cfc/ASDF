import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
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
	private JLabel lblNewLabel;


	/**
	 * Launch the application.
	 */
	


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


		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\kinjolnath\\Desktop\\logo2.jpg"));
		frame.setTitle("Crime Reporting System");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 842, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		
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
	

		btnLogin.setBackground(Color.GREEN);
		btnLogin.setForeground(Color.BLACK);
		//frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setVisible(true);
		//frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		

		txtUsername = new JTextField();
		txtUsername.setForeground(Color.BLACK);
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
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
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("./src/logo2.jpg"));

		

		
	//	JLabel lblNewLabel_1 = new JLabel("New label");
		//lblNewLabel_1.setIcon(new ImageIcon("./src/logo2.jpg"));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(200)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(226)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(220, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 241, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);

		frame.getContentPane().setLayout(groupLayout);
		
		frame.getRootPane().setDefaultButton(btnLogin);

		
		btnLogin.requestFocus();
	}
}
