import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		

		  Connection conn = null;

	       try
	       {

	           String url = "jdbc:mysql://10.6.7.119:3306/database1";
	           Class.forName ("com.mysql.jdbc.Driver");
	           conn = DriverManager.getConnection (url,"clint","passkey1");
	           JOptionPane.showMessageDialog(null, "Connection Established");
	           Statement s=conn.createStatement();
	         
	           
	           EventQueue.invokeLater(new Runnable() {
	       		public void run() {
	       			try {
	       				Login window = new Login();
	       				window.frame.setVisible(true);
	       				
	       				
	       			} catch (Exception e) {
	       				JOptionPane.showMessageDialog(null,e);
	       			}
	       		}
	       	});
				         
	      
	       }
	       catch (Exception e)
	       {
	          JOptionPane.showMessageDialog(null, e);

	       }
	       finally
	       {
	           if (conn != null)
	           {
	               
	               
	                   try {
						conn.close ();
						 JOptionPane.showMessageDialog(null, "Connection closed");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e);
					}
	                  
	                   
	               
	               
	           }
	       }
		
}
		// TODO Auto-generated method stub

	}


