import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Color;


public class informer_report extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup btnGroupType = new ButtonGroup();
	private final ButtonGroup btnGroupGender = new ButtonGroup();
	private final ButtonGroup btnGroupSkintone = new ButtonGroup();
	private JTextField textField;
	static String Gender;
	static String Skintone;
	static String Type;
	static String Haircolour;
	static String HaircolourType;
	static String FacialHair;
	static String Location;
	static int Height;
	static int row = 0;
	int check = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					informer_report frame = new informer_report();
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
	public informer_report() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(260, 60, 779, 734);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblReportANew = new JLabel("Report a new crime");
		lblReportANew.setForeground(Color.RED);
		lblReportANew.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportANew.setFont(new Font("Tahoma", Font.BOLD, 14));

		JPanel panel = new JPanel();



		panel.setBackground(Color.BLACK);
	
		
		
		

		JScrollPane scrollPane = new JScrollPane(panel);
		panel.setAutoscrolls(true);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// scrollPane.setColumnHeaderView(panel);

		/*
		 * JButton btnBack = new JButton("Back"); GroupLayout gl_contentPane =
		 * new GroupLayout(contentPane); gl_contentPane.setHorizontalGroup(
		 * gl_contentPane.createParallelGroup(Alignment.LEADING)
		 * .addComponent(lblReportANew, GroupLayout.PREFERRED_SIZE, 664,
		 * GroupLayout.PREFERRED_SIZE) .addComponent(scrollPane,
		 * GroupLayout.PREFERRED_SIZE, 674, GroupLayout.PREFERRED_SIZE)
		 * .addGroup(gl_contentPane.createSequentialGroup() .addGap(520)
		 * .addComponent(btnBack) .addPreferredGap(ComponentPlacement.UNRELATED)
		 * .addComponent(btnSubmit)) ); gl_contentPane.setVerticalGroup(
		 * gl_contentPane.createParallelGroup(Alignment.LEADING)
		 * .addGroup(gl_contentPane.createSequentialGroup()
		 * .addComponent(lblReportANew, GroupLayout.PREFERRED_SIZE, 42,
		 * GroupLayout.PREFERRED_SIZE)
		 * .addPreferredGap(ComponentPlacement.RELATED)
		 * .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 420,
		 * GroupLayout.PREFERRED_SIZE)
		 * .addPreferredGap(ComponentPlacement.RELATED)
		 * .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		 * .addComponent(btnBack) .addComponent(btnSubmit))) );
		 */


		//scrollPane.setColumnHeaderView(panel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(Color.GREEN);
		
		JButton btnBack = new JButton("Back");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblReportANew, GroupLayout.PREFERRED_SIZE, 664, GroupLayout.PREFERRED_SIZE)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 674, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(520)
					.addComponent(btnBack)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSubmit))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblReportANew, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnSubmit)))
		);
		
		
		JLabel lblType = new JLabel("Type");
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Tahoma", Font.BOLD, 15));

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Terrorist Attack");
		rdbtnNewRadioButton.setBackground(Color.BLACK);
		rdbtnNewRadioButton.setForeground(Color.WHITE);
		btnGroupType.add(rdbtnNewRadioButton);
//		if (rdbtnNewRadioButton.isSelected()) {
//			Type = "Terrorist Attack";
//		}

		JRadioButton rdbtnKidnap = new JRadioButton("Kidnap");
		rdbtnKidnap.setBackground(Color.BLACK);
		rdbtnKidnap.setForeground(Color.WHITE);
		btnGroupType.add(rdbtnKidnap);
//		if (rdbtnKidnap.isSelected()) {
//			Type = "Kidnap";
//		}

		JRadioButton rdbtnHiests = new JRadioButton("Hiests");
		rdbtnHiests.setBackground(Color.BLACK);
		rdbtnHiests.setForeground(Color.WHITE);
		btnGroupType.add(rdbtnHiests);
//		if (rdbtnHiests.isSelected()) {
//			Type = "Hiests";
//		}

		JRadioButton rdbtnMurder = new JRadioButton("Murder");
		rdbtnMurder.setBackground(Color.BLACK);
		rdbtnMurder.setForeground(Color.WHITE);
		btnGroupType.add(rdbtnMurder);
//		if (rdbtnMurder.isSelected()) {
//			Type = "Hiests";
//		}

		JLabel lblSuspectDetails = new JLabel("Suspect Details");
		lblSuspectDetails.setForeground(Color.WHITE);
		lblSuspectDetails.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblHeight = new JLabel("Height (Approx in cm)");
		lblHeight.setForeground(Color.WHITE);
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JSlider sliderheight = new JSlider();

		sliderheight.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				Height = sliderheight.getValue();
			}
		});

		sliderheight.setBackground(Color.BLACK);
		sliderheight.setForeground(Color.WHITE);
		sliderheight.setToolTipText("120 cm is about 4 feet\r\n220 cm is over 7 feet");
		sliderheight.setSnapToTicks(true);
		sliderheight.setPaintLabels(true);
		sliderheight.setPaintTicks(true);
		sliderheight.setMajorTickSpacing(20);
		sliderheight.setMinorTickSpacing(1);
		sliderheight.setMaximum(220);
		sliderheight.setMinimum(120);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(Color.BLACK);
		rdbtnMale.setForeground(Color.WHITE);
		btnGroupGender.add(rdbtnMale);
//		if (rdbtnMale.isSelected()) {
//			Gender = "Male";
//
//		}

		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(Color.BLACK);
		rdbtnFemale.setForeground(Color.WHITE);
		btnGroupGender.add(rdbtnFemale);
//		if (rdbtnFemale.isSelected()) {
//			Gender = "Female";
//
//		}

		JRadioButton rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setBackground(Color.BLACK);
		rdbtnOther.setForeground(Color.WHITE);
		btnGroupGender.add(rdbtnOther);
//		if (rdbtnOther.isSelected()) {
//			Gender = "Other";
//
//		}

		JLabel lblSkintone = new JLabel("Skintone");
		lblSkintone.setForeground(Color.WHITE);
		lblSkintone.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Pale");
		rdbtnNewRadioButton_1.setBackground(Color.BLACK);
		rdbtnNewRadioButton_1.setForeground(Color.WHITE);
		btnGroupSkintone.add(rdbtnNewRadioButton_1);
//		if (rdbtnNewRadioButton_1.isSelected()) {
//			Skintone = "Pale";
//
//		}

		JRadioButton rdbtnFair = new JRadioButton("Fair");
		rdbtnFair.setBackground(Color.BLACK);
		rdbtnFair.setForeground(Color.WHITE);
		btnGroupSkintone.add(rdbtnFair);
//		if (rdbtnFair.isSelected()) {
//			Skintone = "Fair";
//
//		}
		

		JRadioButton rdbtnTan = new JRadioButton("Tan");
		rdbtnTan.setBackground(Color.BLACK);
		rdbtnTan.setForeground(Color.WHITE);
		btnGroupSkintone.add(rdbtnTan);
//		if (rdbtnTan.isSelected()) {
//			Skintone = "Tan";
//
//		}

		JRadioButton rdbtnDark = new JRadioButton("Dark");
		rdbtnDark.setBackground(Color.BLACK);
		rdbtnDark.setForeground(Color.WHITE);
		btnGroupSkintone.add(rdbtnDark);
//		if (rdbtnDark.isSelected()) {
//			Skintone = "Dark";
//
//		}

		JLabel lblHair = new JLabel("Hair");
		lblHair.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblColour = new JLabel("Colour");
		lblColour.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JComboBox HaircolourCombobox = new JComboBox();
		HaircolourCombobox.setModel(new DefaultComboBoxModel(
				new String[] { "" ,"Black", "Grey", "White", "Blonde", "Brown", "Red", "Coloured",  }));
//		Haircolour = (String) HaircolourCombobox.getSelectedItem();

		JLabel lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JComboBox HairstyleCombobox = new JComboBox();
		HairstyleCombobox
				.setModel(new DefaultComboBoxModel(new String[] { "", "Straight", "Curly", "Wavy", "Bald",  }));
//		HaircolourType = (String) HairstyleCombobox.getSelectedItem();

		JLabel lblFacialHair = new JLabel("Facial Hair");
		lblFacialHair.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JComboBox FacialhairCombobox = new JComboBox();
		FacialhairCombobox.setModel(new DefaultComboBoxModel(
				new String[] { "", "Bearded", "Stubble", "Goatee", "Moustache only", "None",  }));
//		FacialHair = (String) FacialhairCombobox.getSelectedItem();

		textField = new JTextField();
		textField.setToolTipText("Enter Tags like Names ,Places ,Associates, etc");
		textField.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);

		JLabel lblOtherDetails = new JLabel("Other Details:");
		lblOtherDetails.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblLocation = new JLabel("Location");
		lblLocation.setForeground(Color.WHITE);
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 14));

		JComboBox LocationComboBox = new JComboBox();
		LocationComboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Noida", "Delhi", "Dadri", "Other" }));
//		Location = (String) FacialhairCombobox.getSelectedItem();

		JRadioButton rdbtnOther_1 = new JRadioButton("Other");
		rdbtnOther_1.setBackground(Color.BLACK);
		rdbtnOther_1.setForeground(Color.WHITE);
		btnGroupType.add(rdbtnOther_1);

//		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnMale.isSelected()) {
					Gender = "Male";

				}
				
				if (rdbtnNewRadioButton.isSelected()) {
					Type = "Terrorist Attack";
				}
				if (rdbtnKidnap.isSelected()) {
					Type = "Kidnap";
				}
				if (rdbtnHiests.isSelected()) {
					Type = "Hiests";
				}
				if (rdbtnFemale.isSelected()) {
					Gender = "Female";

				}
				if (rdbtnMurder.isSelected()) {
					Type = "Hiests";
				}
				if (rdbtnOther.isSelected()) {
					Gender = "Other";

				}
				if (rdbtnNewRadioButton_1.isSelected()) {
					Skintone = "Pale";

				}
				if (rdbtnFair.isSelected()) {
					Skintone = "Fair";

				}
				if (rdbtnTan.isSelected()) {
					Skintone = "Tan";

				}
				if (rdbtnDark.isSelected()) {
					Skintone = "Dark";

				}
				Haircolour = (String) HaircolourCombobox.getSelectedItem();
				HaircolourType = (String) HairstyleCombobox.getSelectedItem();
				FacialHair = (String) FacialhairCombobox.getSelectedItem();
				Location = (String) LocationComboBox.getSelectedItem();
				
				java.sql.Connection conn;

				try {

					conn = DriverManager.getConnection(Main.url, "clint", "passkey1");

					java.sql.PreparedStatement pst1 = conn.prepareStatement("select count(*) from suspects");
					java.sql.ResultSet result = pst1.executeQuery();
					
					if (result.next()) {
						row = result.getInt(1);
					}
					
					row++;
					
					java.sql.PreparedStatement pst = conn
							.prepareStatement("insert into suspects values(?,?,?,?,?,?,?,?,?)");
					pst.setString(1, String.valueOf(row));
					pst.setString(2, informer_report.Location);
					pst.setString(3, informer_report.Gender);
					pst.setString(4, informer_report.Haircolour);
					pst.setString(5, informer_report.HaircolourType);
					pst.setString(6, informer_report.FacialHair);
					pst.setString(7, informer_report.Skintone);
					pst.setString(8, String.valueOf(informer_report.Height));
					pst.setString(9, informer_report.Type);

					// pst.setString(1,String.valueOf(row));
					pst.executeUpdate();
					conn.close();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				
					
				}
				finally {
					UserProf a = new UserProf();
					a.setVisible(true);

					   setVisible(false);
				}
			}
		});

		//JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserProf a = new UserProf();
a.setVisible(true);

   setVisible(false);
			}
		});
		//GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblReportANew, GroupLayout.PREFERRED_SIZE, 664, GroupLayout.PREFERRED_SIZE)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 674, GroupLayout.PREFERRED_SIZE)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(531, Short.MAX_VALUE)
					.addComponent(btnBack)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSubmit)
					.addGap(59))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblReportANew, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnSubmit))
					.addContainerGap())
		);

		/*
		 * java.sql.Connection conn;
		 * 
		 * 
		 * try {
		 * 
		 * conn = DriverManager.getConnection (Main.url,"clint","passkey1");
		 * 
		 * row+=1; java.sql.PreparedStatement pst=conn.prepareStatement(
		 * "insert into suspects values(?,?,?,?,?,?,?,?,?,?)");
		 * pst.setString(1,String.valueOf(row)); pst.setString(2,this.Location);
		 * pst.setString(3,this.Gender); pst.setString(4, "23");
		 * pst.setString(5,this.Haircolour);
		 * pst.setString(6,this.HaircolourType);
		 * pst.setString(7,this.FacialHair); pst.setString(8,this.Skintone);
		 * pst.setString(9,String.valueOf(this.Height));
		 * pst.setString(10,this.Type);
		 * 
		 * 
		 * // pst.setString(1,String.valueOf(row)); pst.executeUpdate();
		 * conn.close();
		 * 
		 * 
		 * } catch (SQLException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap().addGroup(gl_panel
								.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel
												.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
														.createSequentialGroup().addGap(85)
														.addGroup(gl_panel
																.createParallelGroup(Alignment.LEADING)
																.addComponent(sliderheight, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)
																.addComponent(lblHeight).addComponent(lblGender)
																.addGroup(gl_panel.createSequentialGroup()
																		.addComponent(rdbtnMale).addGap(18)
																		.addComponent(rdbtnFemale,
																				GroupLayout.PREFERRED_SIZE, 75,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(rdbtnOther,
																				GroupLayout.DEFAULT_SIZE, 381,
																				Short.MAX_VALUE))
																.addGroup(gl_panel.createSequentialGroup()
																		.addComponent(lblSkintone)
																		.addPreferredGap(ComponentPlacement.RELATED,
																				468, Short.MAX_VALUE))
																.addComponent(lblHair)
																.addGroup(gl_panel.createSequentialGroup()
																		.addGroup(gl_panel
																				.createParallelGroup(Alignment.LEADING,
																						false)
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addComponent(
																										rdbtnNewRadioButton_1,
																										GroupLayout.PREFERRED_SIZE,
																										97,
																										GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(rdbtnFair,
																										GroupLayout.PREFERRED_SIZE,
																										97,
																										GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(rdbtnTan,
																										GroupLayout.DEFAULT_SIZE,
																										GroupLayout.DEFAULT_SIZE,
																										Short.MAX_VALUE))
																				.addGroup(gl_panel
																						.createSequentialGroup()
																						.addGap(69)
																						.addComponent(lblColour)
																						.addGap(18)
																						.addComponent(
																								HaircolourCombobox,
																								GroupLayout.PREFERRED_SIZE,
																								89,
																								GroupLayout.PREFERRED_SIZE)
																						.addGap(18)
																						.addComponent(lblNewLabel_1)))
																		.addGroup(gl_panel
																				.createParallelGroup(Alignment.LEADING)
																				.addGroup(gl_panel
																						.createSequentialGroup()
																						.addGap(18)
																						.addComponent(HairstyleCombobox,
																								0,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addGap(27)
																						.addComponent(lblFacialHair)
																						.addGap(18)
																						.addComponent(
																								FacialhairCombobox,
																								GroupLayout.PREFERRED_SIZE,
																								92,
																								GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(
																								ComponentPlacement.RELATED))
																				.addGroup(
																						gl_panel.createSequentialGroup()
																								.addPreferredGap(
																										ComponentPlacement.RELATED)
																								.addComponent(rdbtnDark,
																										GroupLayout.PREFERRED_SIZE,
																										97,
																										GroupLayout.PREFERRED_SIZE))))))
												.addGroup(gl_panel.createSequentialGroup()
														.addComponent(rdbtnNewRadioButton).addGap(18)
														.addComponent(rdbtnKidnap, GroupLayout.PREFERRED_SIZE, 83,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(rdbtnHiests, GroupLayout.PREFERRED_SIZE, 84,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(rdbtnMurder, GroupLayout.PREFERRED_SIZE, 83,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(rdbtnOther_1)))
										.addGap(627))
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblOtherDetails)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 509,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblType).addContainerGap(1218,
										Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblSuspectDetails)
										.addContainerGap(1138, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblLocation)
										.addContainerGap(1195, Short.MAX_VALUE))
								.addGroup(gl_panel
										.createSequentialGroup().addComponent(LocationComboBox,
												GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(1114, Short.MAX_VALUE)))));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(lblType)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel
										.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnNewRadioButton)
										.addComponent(rdbtnKidnap, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(rdbtnHiests)
										.addComponent(rdbtnMurder, GroupLayout.PREFERRED_SIZE, 33,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(rdbtnOther_1))
								.addGap(59).addComponent(lblLocation).addGap(18)
								.addComponent(LocationComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(26).addComponent(lblSuspectDetails).addGap(1).addComponent(lblHeight)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(sliderheight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblGender).addGap(9)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(rdbtnMale)
										.addComponent(rdbtnFemale).addComponent(rdbtnOther))
								.addGap(18).addComponent(lblSkintone)
								.addPreferredGap(ComponentPlacement.RELATED).addGroup(gl_panel.createParallelGroup(
										Alignment.LEADING)
										.addGroup(gl_panel
												.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE,
																40, GroupLayout.PREFERRED_SIZE)
														.addComponent(rdbtnFair, GroupLayout.PREFERRED_SIZE, 40,
																GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblHair))
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(rdbtnTan, GroupLayout.PREFERRED_SIZE, 40,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(rdbtnDark, GroupLayout.PREFERRED_SIZE, 40,
														GroupLayout.PREFERRED_SIZE)))
								.addGap(4)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblColour)
										.addComponent(HaircolourCombobox, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1)
										.addComponent(HairstyleCombobox, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFacialHair).addComponent(FacialhairCombobox,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(25)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 133,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblOtherDetails))
								.addContainerGap()));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
