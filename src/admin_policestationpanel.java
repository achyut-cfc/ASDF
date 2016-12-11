import javax.swing.JPanel;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.StatementImpl;



import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin_policestationpanel extends JPanel {
	private JTable table;
	public DefaultTableModel model;
	public static JButton btnrefresh;
	
	/**
	 * Create the panel.
	 */
	public admin_policestationpanel() {
		
//		DefaultTableModel model;
		model = new DefaultTableModel();
	
		
		model.addColumn("Location");
		model.addColumn("Executives");
		model.addColumn("Executives");
		
		table = new JTable(model);
		table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		model.addRow(new Object[]{"Location","Executives","Phone number"});
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				newpolicestation station=new newpolicestation();
				station.row=model.getRowCount();
				station.setVisible(true);
			
			   
			}
			
		
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 int row;
				if (( row=table.getSelectedRow()) > 0) {
			            
					
//					System.out.println(row);
					model.removeRow(row);
					
				
					row+=1;
			          java.sql.Connection conn;
					try {
						
						conn = DriverManager.getConnection (Main.url,"clint","passkey1");
						  java.sql.PreparedStatement pst=conn.prepareStatement("Delete from police_dept where rowno=? ");
				          pst.setString(1,String.valueOf(row));
				       
				          
				          pst.executeUpdate();
				          
				        
				         
				  
				          for(int  r=row;r<=model.getRowCount();r++){
				        	  
				        	    
					          pst=conn.prepareStatement("Update police_dept set rowno=? where rowno=? ");
					          
				        	  pst.setString(1,String.valueOf(r));
				        	  pst.setString(2, String.valueOf(r+1));
				        	  pst.executeUpdate();
				        	  
				          }
				          conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			        
			        }
				
			}
		});
	
		

        java.sql.Connection conn;
		
			
			try {
				conn = DriverManager.getConnection (Main.url,"clint","passkey1");
				
				   java.sql.PreparedStatement pst=conn.prepareStatement("Select * from police_dept");
				   ResultSet st=pst.executeQuery();
				   while(st.next()){

					   	String location=st.getString("location");
					   	String executives=st.getString("executives");
					   	String phno=st.getString("ph_no");
						model.addRow(new Object[] {location,executives,phno});
					   
					   
				   }
				   
				   conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	btnrefresh = new JButton("Refresh");
		btnrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 java.sql.Connection conn;
					
					
					try {
						conn = DriverManager.getConnection (Main.url,"clint","passkey1");
						
						   java.sql.PreparedStatement pst=conn.prepareStatement("Select * from police_dept");
						   ResultSet st=pst.executeQuery();
						   
						  model.setRowCount(0);
						  model.addRow(new Object[]{"Location","Executives","Phone number"});
						   while(st.next()){

							   	String location=st.getString("location");
							   	String executives=st.getString("executives");
							   	String phno=st.getString("ph_no");
							   	
								model.addRow(new Object[] {location,executives,phno});
							   
							   
						   }
						   
						   conn.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnrefresh)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addComponent(table, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnDelete)
						.addComponent(btnrefresh)))
		);
		setLayout(groupLayout);

	}
}
