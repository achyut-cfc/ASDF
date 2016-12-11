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

public class admin_suspectpanel extends JPanel {
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public admin_suspectpanel() {
		setSize(580,400);
		
		JButton button = new JButton("Add");
		
		JButton button_2 = new JButton("Delete");
		
		JButton btnRefresh = new JButton("Refresh");
		
		

		model = new DefaultTableModel();

	
	model.addColumn("Case ID");
	model.addColumn("Police Dept");
	model.addColumn("Sex");
	model.addColumn("Age");
	model.addColumn("Hair Colour");
	model.addColumn("Hair Type");
	model.addColumn("Facial Hair");
	model.addColumn("Skin Colour");
	
	model.addColumn("Height");
	
	table = new JTable(model);
	table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
	
	
	java.sql.Connection conn;
	
	
	try {
		conn = DriverManager.getConnection (Main.url,"clint","passkey1");
		
		   java.sql.PreparedStatement pst=conn.prepareStatement("Select * from suspects");
		  
			model.addRow(new Object[]{"Case ID","Police Dept","Sex","Age","Hair Colour","Hair Type","Facial Hair","Skin Colour","Height"});
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
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(346, Short.MAX_VALUE)
					.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
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
