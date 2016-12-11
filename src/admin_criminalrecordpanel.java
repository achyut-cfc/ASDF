import javax.swing.JPanel;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin_criminalrecordpanel extends JPanel {
	
	public DefaultTableModel model;
	 JTable table_1;
	 public JButton btnRefresh;
	/**
	 * Create the panel.
	 */
	public admin_criminalrecordpanel() {
		setSize(580,400);
		
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		JButton button_2 = new JButton("Delete");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int row;
					if (( row=table_1.getSelectedRow()) > 0) {
				            
						
//						System.out.println(row);
						model.removeRow(row);
						
					
						row+=1;
				          java.sql.Connection conn;
						try {
							
							conn = DriverManager.getConnection (Main.url,"clint","passkey1");
							  java.sql.PreparedStatement pst=conn.prepareStatement("Delete from criminals where rowno=? ");
					          pst.setString(1,String.valueOf(row));
					       
					          
					          pst.executeUpdate();
					          
					        
					         
					  
					          for(int  r=row;r<=model.getRowCount();r++){
					        	  
					        	    
						          pst=conn.prepareStatement("Update criminals set rowno=? where rowno=? ");
						          
					        	  pst.setString(1,String.valueOf(r));
					        	  pst.setString(2, String.valueOf(r+1));
					        	  pst.executeUpdate();
					        	  
					          }
					          conn.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			}
			}});
		
		
		 btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				java.sql.Connection conn;
				
				
				try {
					conn = DriverManager.getConnection (Main.url,"clint","passkey1");
					
					   java.sql.PreparedStatement pst=conn.prepareStatement("Select * from criminals");
					  model.setRowCount(0);
						model.addRow(new Object[]{"ID","Name","Sex","Age","Hair Colour","Skin Colour","Associates","Height"});
					   ResultSet st=pst.executeQuery();
					   while(st.next()){

						   	
							model.addRow(new Object[] {st.getString(1),st.getString(2),st.getString(3),st.getString(4),st.getString(5),st.getString(6),st.getString(7),st.getString(8)});
						   
					   }
					   
					   conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		
		
			model = new DefaultTableModel();
	
		
		model.addColumn("ID");
		model.addColumn("Name");
		model.addColumn("Sex");
		model.addColumn("Age");
		model.addColumn("Hair Colour");
		model.addColumn("Skin Colour");
		model.addColumn("Associates");
		model.addColumn("Height");
		
		table_1 = new JTable(model);
		table_1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(table_1, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(9)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_2)
						.addComponent(btnRefresh))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

		java.sql.Connection conn;
		
		
		try {
			conn = DriverManager.getConnection (Main.url,"clint","passkey1");
			
			   java.sql.PreparedStatement pst=conn.prepareStatement("Select * from criminals");
			  
				model.addRow(new Object[]{"ID","Name","Sex","Age","Hair Colour","Skin Colour","Associates","Height"});
			   ResultSet st=pst.executeQuery();
			   while(st.next()){

				   	
					model.addRow(new Object[] {st.getString(1),st.getString(2),st.getString(3),st.getString(4),st.getString(5),st.getString(6),st.getString(7),st.getString(8)});
				   
			   }
			   
			   conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
