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

	/**
	 * Create the panel.
	 */
	public admin_policestationpanel() {
		
		JButton btnAdd = new JButton("Add");
		
		JButton btnEdit = new JButton("Edit");
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				   int[] selection = table.getSelectedRows();
				
			}
		});
		DefaultTableModel model;
		model = new DefaultTableModel();
		model.addColumn("Location");
		model.addColumn("Executives");
		model.addColumn("Phone number");
		
		table = new JTable(model);
		model.addRow(new Object[]{"Location","Executives","Phone number"});
		

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
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(223)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(table, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDelete)
						.addComponent(btnEdit)
						.addComponent(btnAdd)))
		);
		setLayout(groupLayout);

	}
}
