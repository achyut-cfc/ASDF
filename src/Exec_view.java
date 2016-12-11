import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Exec_view extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Exec_view frame = new Exec_view();
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
	public Exec_view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCasedetails = new JLabel("Case details");
		lblCasedetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCasedetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblCasedetails.setBounds(112, 21, 219, 34);
		contentPane.add(lblCasedetails);
		
		JLabel lblCaseNumber = new JLabel("Case Number : ");
		lblCaseNumber.setBounds(54, 67, 94, 19);
		contentPane.add(lblCaseNumber);
		
		JLabel lbllocation = new JLabel("Location: ");
		lbllocation.setBounds(54, 95, 80, 14);
		contentPane.add(lbllocation);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setBounds(54, 127, 72, 14);
		contentPane.add(lblAge);
		
		JLabel lblHairColour = new JLabel("Hair colour :");
		lblHairColour.setBounds(51, 152, 83, 19);
		contentPane.add(lblHairColour);
		
		JLabel lblHairType = new JLabel("Hair type:");
		lblHairType.setBounds(54, 182, 65, 19);
		contentPane.add(lblHairType);
		
		JLabel lblcaseno = new JLabel();
		lblcaseno.setBounds(150, 69, 80, 17);
		contentPane.add(lblcaseno);
		
		JLabel lblloc = new JLabel("");
		lblloc.setBounds(112, 97, 82, 19);
		contentPane.add(lblloc);
		
		JLabel lblage = new JLabel("");
		lblage.setBounds(132, 127, 83, 14);
		contentPane.add(lblage);
		
		JLabel lblhairc = new JLabel("");
		lblhairc.setBounds(132, 154, 72, 14);
		contentPane.add(lblhairc);
		
		JLabel lblhairt = new JLabel("");
		lblhairt.setBounds(129, 184, 80, 19);
		contentPane.add(lblhairt);
		
		JLabel lblCrime = new JLabel("Crime:");
		lblCrime.setBounds(214, 66, 71, 19);
		contentPane.add(lblCrime);
		
		JLabel lblcrimev = new JLabel("");
		lblcrimev.setBounds(275, 66, 108, 19);
		contentPane.add(lblcrimev);
		
		JLabel lblSex = new JLabel("Sex: ");
		lblSex.setBounds(214, 95, 61, 14);
		contentPane.add(lblSex);
		
		JLabel lblSexv = new JLabel("");
		lblSexv.setBounds(275, 95, 65, 14);
		contentPane.add(lblSexv);
		
		JLabel lblSkinColour = new JLabel("Skin colour:");
		lblSkinColour.setBounds(214, 125, 76, 19);
		contentPane.add(lblSkinColour);
		
		JLabel lblskinc = new JLabel("");
		lblskinc.setBounds(285, 122, 55, 19);
		contentPane.add(lblskinc);
		
		JLabel lblFacialHair = new JLabel("Facial hair:");
		lblFacialHair.setBounds(214, 152, 76, 19);
		contentPane.add(lblFacialHair);
		
		JLabel labelfh = new JLabel("");
		labelfh.setBounds(284, 152, 72, 19);
		contentPane.add(labelfh);
		
		JLabel lblHeight = new JLabel("Height: ");
		lblHeight.setBounds(214, 184, 81, 19);
		contentPane.add(lblHeight);
		
		JLabel lblht = new JLabel("");
		lblht.setBounds(275, 182, 65, 19);
		contentPane.add(lblht);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setBounds(242, 266, 89, 19);
		contentPane.add(btnClose);
		 java.sql.Connection conn;
			
			
			try {
				conn = DriverManager.getConnection (Main.url,"clint","passkey1");
				
				   java.sql.PreparedStatement pst=conn.prepareStatement("Select * from suspects where case_no="+Executive_inbox.table.getSelectedRow());
				   ResultSet st=pst.executeQuery();
				   while(st.next()){

					   //	String caseno=st.getString("case_no");
					   	//String location=st.getString("police_dept");
					   	//String crime=st.getString("crime");
						//model.addRow(new Object[] {caseno,location,crime});
					   lblcaseno.setText(st.getString("case_no"));
					   lblloc.setText(st.getString("police_dept"));
					   lblage.setText(st.getString("age"));
					   lblhairc.setText(st.getString("hair_colour"));
					   lblhairt.setText(st.getString("hair_type"));
					   lblcrimev.setText(st.getString("crime"));
					   lblSexv.setText(st.getString("sex"));
					   lblskinc.setText(st.getString("skin_colour"));
					   labelfh.setText(st.getString("facial_hair"));
					   lblht.setText(st.getString("height"));
				   }
				   
				   conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
