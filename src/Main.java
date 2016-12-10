import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Main {
	  static String url = "jdbc:mysql://10.6.7.119:3306/database1";
	public static void main(String[] args) {
		

		  Connection conn = null;

	       try
	       {
	    	   
	         
	           Class.forName ("com.mysql.jdbc.Driver");
	           conn = DriverManager.getConnection (Main.url,"clint","passkey1");
	           JOptionPane.showMessageDialog(null, "Connection Established");
	           Statement s=conn.createStatement();
	         
	           
	           EventQueue.invokeLater(new Runnable() {
	       		public void run() {
	       			try {
	       				Login LoginWindow = new Login();
	       				LoginWindow.frame.setVisible(true);
	       				
	       				
	       			} catch (Exception e) {
	       				JOptionPane.showMessageDialog(null,e);
	       			}
	       		}
	       	});
				         
	      
	       }
	       catch (Exception e)
	       {
	          JOptionPane.showMessageDialog(null,"Connection failed.\n"+ e);

	       }
	     
		
}
		// TODO Auto-generated method stub

	}


