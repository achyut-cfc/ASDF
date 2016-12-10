

	import java.sql.*;
	import javax.sql.*;

	public class Connect
	{
	   public static void main (String[] args)
	   {
	       Connection conn = null;

	       try
	       {

	           String url = "jdbc:mysql://10.6.7.119:3306/database1";
	           Class.forName ("com.mysql.jdbc.Driver");
	           conn = DriverManager.getConnection (url,"clint","passkey1");
	           System.out.println ("Database connection established");
	           Statement s=conn.createStatement();
	         
	        //   s.executeUpdate("Delete from criminals where Name='horse'");
	           System.out.println("completed!");
	          ResultSet set =s.executeQuery("select * from criminals");
	          while(set.next()){
	           System.out.println(set.getString("Name")+ " "+set.getString("Age"));
	           }
	       }
	       catch (Exception e)
	       {
	           e.printStackTrace();

	       }
	       finally
	       {
	           if (conn != null)
	           {
	               try
	               {
	                   conn.close ();
	                   System.out.println ("Database connection terminated");
	               }
	               catch (Exception e) { /* ignore close errors */ }
	           }
	       }
	   }
	}

