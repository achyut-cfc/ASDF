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
import javax.swing.JTextArea;
import java.awt.Color;

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
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCasedetails = new JLabel("Case details");
		lblCasedetails.setForeground(Color.WHITE);
		lblCasedetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCasedetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblCasedetails.setBounds(112, 21, 219, 34);
		contentPane.add(lblCasedetails);
		
		JLabel lblCaseNumber = new JLabel("Case Number : ");
		lblCaseNumber.setForeground(Color.WHITE);
		lblCaseNumber.setBounds(54, 67, 94, 19);
		contentPane.add(lblCaseNumber);
		
		JLabel lbllocation = new JLabel("Location: ");
		lbllocation.setForeground(Color.WHITE);
		lbllocation.setBounds(54, 95, 80, 14);
		contentPane.add(lbllocation);
		
		JLabel lblHairColour = new JLabel("Hair colour :");
		lblHairColour.setForeground(Color.WHITE);
		lblHairColour.setBounds(51, 120, 83, 19);
		contentPane.add(lblHairColour);
		
		JLabel lblHairType = new JLabel("Hair type:");
		lblHairType.setForeground(Color.WHITE);
		lblHairType.setBounds(54, 150, 65, 19);
		contentPane.add(lblHairType);
		
		JLabel lblcaseno = new JLabel();
		lblcaseno.setForeground(Color.WHITE);
		lblcaseno.setBounds(150, 69, 80, 17);
		contentPane.add(lblcaseno);
		
		JLabel lblloc = new JLabel("");
		lblloc.setForeground(Color.WHITE);
		lblloc.setBounds(112, 97, 82, 19);
		contentPane.add(lblloc);
		
		JLabel lblhairc = new JLabel("");
		lblhairc.setForeground(Color.WHITE);
		lblhairc.setBounds(122, 125, 72, 14);
		contentPane.add(lblhairc);
		
		JLabel lblhairt = new JLabel("");
		lblhairt.setForeground(Color.WHITE);
		lblhairt.setBounds(112, 152, 80, 19);
		contentPane.add(lblhairt);
		
		JLabel lblCrime = new JLabel("Crime:");
		lblCrime.setForeground(Color.WHITE);
		lblCrime.setBounds(214, 66, 71, 19);
		contentPane.add(lblCrime);
		
		JLabel lblcrimev = new JLabel("");
		lblcrimev.setForeground(Color.WHITE);
		lblcrimev.setBounds(275, 66, 108, 19);
		contentPane.add(lblcrimev);
		
		JLabel lblSex = new JLabel("Sex: ");
		lblSex.setForeground(Color.WHITE);
		lblSex.setBounds(214, 95, 61, 14);
		contentPane.add(lblSex);
		
		JLabel lblSexv = new JLabel("");
		lblSexv.setForeground(Color.WHITE);
		lblSexv.setBounds(275, 95, 65, 14);
		contentPane.add(lblSexv);
		
		JLabel lblSkinColour = new JLabel("Skin colour:");
		lblSkinColour.setForeground(Color.WHITE);
		lblSkinColour.setBounds(214, 125, 76, 19);
		contentPane.add(lblSkinColour);
		
		JLabel lblskinc = new JLabel("");
		lblskinc.setForeground(Color.WHITE);
		lblskinc.setBounds(285, 122, 55, 19);
		contentPane.add(lblskinc);
		
		JLabel lblFacialHair = new JLabel("Facial hair:");
		lblFacialHair.setForeground(Color.WHITE);
		lblFacialHair.setBounds(214, 152, 76, 19);
		contentPane.add(lblFacialHair);
		
		JLabel labelfh = new JLabel("");
		labelfh.setForeground(Color.WHITE);
		labelfh.setBounds(284, 152, 72, 19);
		contentPane.add(labelfh);
		
		JLabel lblHeight = new JLabel("Height: ");
		lblHeight.setForeground(Color.WHITE);
		lblHeight.setBounds(214, 184, 81, 19);
		contentPane.add(lblHeight);
		
		JLabel lblht = new JLabel("");
		lblht.setForeground(Color.WHITE);
		lblht.setBounds(275, 182, 65, 19);
		contentPane.add(lblht);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setBounds(242, 343, 89, 19);
		contentPane.add(btnClose);
		
		JLabel lblPossibleCriminals = new JLabel("possible criminals:");
		lblPossibleCriminals.setForeground(Color.WHITE);
		lblPossibleCriminals.setBounds(36, 212, 124, 34);
		contentPane.add(lblPossibleCriminals);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(190, 217, 141, 115);
		contentPane.add(textArea);
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
java.sql.Connection conn1;
			
//System.out.println(lblhairc.getText());
			try {
				conn1 = DriverManager.getConnection (Main.url,"clint","passkey1");
				
				   java.sql.PreparedStatement pst=conn1.prepareStatement("Select * from criminals where Sex=? and (hair_colour=? or hair_type=?) and (facial_hair=? or skin_colour=? or height=?)");
				   pst.setString(1,lblSexv.getText());
				   pst.setString(2,lblhairc.getText());
						  
				   pst.setString(3,lblhairt.getText());
				   pst.setString(4,labelfh.getText());
				   pst.setString(5,lblskinc.getText());
				   pst.setString(6,lblht.getText());
				   ResultSet st1=pst.executeQuery();
				   while(st1.next()){
					   
					   //System.out.println(lblhairc.getText());

					   //	String caseno=st.getString("case_no");
					   	//String location=st.getString("police_dept");
					   	//String crime=st.getString("crime");
						//model.addRow(new Object[] {caseno,location,crime});
					  textArea.append(st1.getString("Name")+"\n");
				   }
				   
				   conn1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
}
