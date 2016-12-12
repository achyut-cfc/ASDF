import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Executive_inbox extends JFrame {
	static JTable table;
	public DefaultTableModel model;
	private JPanel contentPane;
	private JTable table_1;


	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Executive_inbox frame = new Executive_inbox();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Executive_inbox() {
		model = new DefaultTableModel();
		
		
		model.addColumn("Case Number");
		model.addColumn("Location");
		model.addColumn("Crime");
		
//		
//		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(260, 60, 658, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INBOX");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(261, 24, 120, 53);
		contentPane.add(lblNewLabel);
		
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exec_view.main();
				
			}
		});
		btnView.setBounds(387, 369, 89, 23);
		contentPane.add(btnView);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Executive_home.main();
				setVisible(false);
			}
		});
		btnNewButton.setBounds(486, 369, 89, 23);
		contentPane.add(btnNewButton);
		
		table = new JTable(model);
		table.setBounds(31, 71, 578, 274);
		contentPane.add(table);
		
			
	table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		model.addRow(new Object[]{"Case number","Location","Crime"});

        java.sql.Connection conn;
		
			
			try {
				conn = DriverManager.getConnection (Main.url,"clint","passkey1");
				
				   java.sql.PreparedStatement pst=conn.prepareStatement("Select * from suspects");
				   ResultSet st=pst.executeQuery();
				   while(st.next()){

					   	String caseno=st.getString("case_no");
					   	String location=st.getString("police_dept");
					   	String crime=st.getString("crime");
						model.addRow(new Object[] {caseno,location,crime});
					   
					   
				   }
				   
				   conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	
		
	}}
