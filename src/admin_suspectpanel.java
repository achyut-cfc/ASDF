import javax.swing.JPanel;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class admin_suspectpanel extends JPanel {
  static JTable table;
 static DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public static void refresh(){
		

		java.sql.Connection conn;
		
		
		try {
			conn = DriverManager.getConnection (Main.url,"clint","passkey1");
			
			   java.sql.PreparedStatement pst=conn.prepareStatement("Select * from suspects");
			  model.setRowCount(0);
				model.addRow(new Object[]{"Case ID","Police Dept","Sex","Hair Colour","Hair Type","Facial Hair","Skin Colour","Height","Crime"});
			   ResultSet st=pst.executeQuery();
			   while(st.next()){

				   	
					model.addRow(new Object[] {st.getString(1),st.getString(2),st.getString(3),st.getString(4),st.getString(5),st.getString(6),st.getString(7),st.getString(8),st.getString(9)});
				   
			   }
			   
			   conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public admin_suspectpanel() {
		setBackground(Color.BLACK);
		setSize(580,400);
		
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newsuspect suspect=new newsuspect();
				suspect.setVisible(true);
			}
		});
		
		JButton button_2 = new JButton("Delete");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int row;
				if (( row=table.getSelectedRow()) > 0) {
			            
					
//					System.out.println(row);
					model.removeRow(row);
					
//				if(row==table.getRowCount())
//					row+=1;
			          java.sql.Connection conn;
					try {
						
						conn = DriverManager.getConnection (Main.url,"clint","passkey1");
						  java.sql.PreparedStatement pst=conn.prepareStatement("Delete from suspects where case_no=? ");
				          pst.setString(1,String.valueOf(row));
	
				          pst.executeUpdate();
				  
				          for(int  r=row;r<=model.getRowCount();r++){
				        	  
				        	    
					          pst=conn.prepareStatement("Update suspects set case_no=? where case_no=? ");
					          
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
			}
		});
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh();
			}
		});
		
		

		model = new DefaultTableModel();

	
	model.addColumn("Case ID");
	model.addColumn("Police Dept");
	
	
	model.addColumn("Hair Colour");
	model.addColumn("Hair Type");
	model.addColumn("Facial Hair");
	model.addColumn("Skin Colour");
	model.addColumn("Sex");
	model.addColumn("Height");
	model.addColumn("Crime");
	
	table = new JTable(model);
	table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	
	
	java.sql.Connection conn;
	
	
	try {
		conn = DriverManager.getConnection (Main.url,"clint","passkey1");
		
		   java.sql.PreparedStatement pst=conn.prepareStatement("Select * from suspects");
		  
			model.addRow(new Object[]{"Case ID","Police Dept","Sex","Hair Colour","Hair Type","Facial Hair","Skin Colour","Height","Crime"});
		   ResultSet st=pst.executeQuery();
		   while(st.next()){

			   	
				model.addRow(new Object[] {st.getString(1),st.getString(2),st.getString(3),st.getString(4),st.getString(5),st.getString(6),st.getString(7),st.getString(8),st.getString(9)});
			   
		   }
		   
		   conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(330, Short.MAX_VALUE)
					.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_2)
						.addComponent(btnRefresh))
					.addGap(27))
		);
		setLayout(groupLayout);

	}

}
