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
import java.awt.Color;

public class informer_report extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup btnGroupType = new ButtonGroup();
	private final ButtonGroup btnGroupGender = new ButtonGroup();
	private final ButtonGroup btnGroupSkintone = new ButtonGroup();
	private JTextField textField;

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
		setBounds(260, 60, 700,550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblReportANew = new JLabel("Report a new crime");
		lblReportANew.setForeground(Color.WHITE);
		lblReportANew.setHorizontalAlignment(SwingConstants.CENTER);
		lblReportANew.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		formpanel panel = new formpanel();
		panel.setBackground(Color.BLACK);
	
		
		
		
		JScrollPane scrollPane = new JScrollPane(panel);
		panel.setAutoscrolls(true);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		//scrollPane.setColumnHeaderView(panel);
		
		JButton btnSubmit = new JButton("Submit");
		
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
		
		JRadioButton rdbtnKidnap = new JRadioButton("Kidnap");
		rdbtnKidnap.setBackground(Color.BLACK);
		rdbtnKidnap.setForeground(Color.WHITE);
		btnGroupType.add(rdbtnKidnap);
		
		JRadioButton rdbtnHiests = new JRadioButton("Hiests");
		rdbtnHiests.setBackground(Color.BLACK);
		rdbtnHiests.setForeground(Color.WHITE);
		btnGroupType.add(rdbtnHiests);
		
		JRadioButton rdbtnMurder = new JRadioButton("Murder");
		rdbtnMurder.setBackground(Color.BLACK);
		rdbtnMurder.setForeground(Color.WHITE);
		btnGroupType.add(rdbtnMurder);
		
		JLabel lblSuspectDetails = new JLabel("Suspect Details");
		lblSuspectDetails.setForeground(Color.WHITE);
		lblSuspectDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblHeight = new JLabel("Height (Approx in cm)");
		lblHeight.setForeground(Color.WHITE);
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JSlider sliderheight = new JSlider();
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
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(Color.BLACK);
		rdbtnFemale.setForeground(Color.WHITE);
		btnGroupGender.add(rdbtnFemale);
		
		JRadioButton rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setBackground(Color.BLACK);
		rdbtnOther.setForeground(Color.WHITE);
		btnGroupGender.add(rdbtnOther);
		
		JLabel lblSkintone = new JLabel("Skintone");
		lblSkintone.setForeground(Color.WHITE);
		lblSkintone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Pale");
		rdbtnNewRadioButton_1.setBackground(Color.BLACK);
		rdbtnNewRadioButton_1.setForeground(Color.WHITE);
		btnGroupSkintone.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnFair = new JRadioButton("Fair");
		rdbtnFair.setBackground(Color.BLACK);
		rdbtnFair.setForeground(Color.WHITE);
		btnGroupSkintone.add(rdbtnFair);
		
		JRadioButton rdbtnTan = new JRadioButton("Tan");
		rdbtnTan.setBackground(Color.BLACK);
		rdbtnTan.setForeground(Color.WHITE);
		btnGroupSkintone.add(rdbtnTan);
		
		JRadioButton rdbtnDark = new JRadioButton("Dark");
		rdbtnDark.setBackground(Color.BLACK);
		rdbtnDark.setForeground(Color.WHITE);
		btnGroupSkintone.add(rdbtnDark);
		
		JLabel lblHair = new JLabel("Hair");
		lblHair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblColour = new JLabel("Colour");
		lblColour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox HaircolourCombobox = new JComboBox();
		HaircolourCombobox.setModel(new DefaultComboBoxModel(new String[] {"Black", "Grey", "White", "Blonde", "Brown", "Red", "Coloured", "...."}));
		
		JLabel lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox HairstyleCombobox = new JComboBox();
		HairstyleCombobox.setModel(new DefaultComboBoxModel(new String[] {"Straight", "Curly", "Wavy", "Bald", "..."}));
		
		JLabel lblFacialHair = new JLabel("Facial Hair");
		lblFacialHair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox FacialhairCombobox = new JComboBox();
		FacialhairCombobox.setModel(new DefaultComboBoxModel(new String[] {"Bearded", "Stubble", "Goatee", "Moustache only", "None", "..."}));
		
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
		
		JRadioButton rdbtnOther_1 = new JRadioButton("Other");
		rdbtnOther_1.setBackground(Color.BLACK);
		rdbtnOther_1.setForeground(Color.WHITE);
		btnGroupType.add(rdbtnOther_1);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(85)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(sliderheight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblHeight)
										.addComponent(lblGender)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(rdbtnMale)
											.addGap(18)
											.addComponent(rdbtnFemale, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(rdbtnOther, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblSkintone)
											.addPreferredGap(ComponentPlacement.RELATED, 468, Short.MAX_VALUE))
										.addComponent(lblHair)
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
												.addGroup(gl_panel.createSequentialGroup()
													.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(rdbtnFair, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(rdbtnTan, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGroup(gl_panel.createSequentialGroup()
													.addGap(69)
													.addComponent(lblColour)
													.addGap(18)
													.addComponent(HaircolourCombobox, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(lblNewLabel_1)))
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panel.createSequentialGroup()
													.addGap(18)
													.addComponent(HairstyleCombobox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addGap(27)
													.addComponent(lblFacialHair)
													.addGap(18)
													.addComponent(FacialhairCombobox, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED))
												.addGroup(gl_panel.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(rdbtnDark, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))))))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(rdbtnNewRadioButton)
									.addGap(18)
									.addComponent(rdbtnKidnap, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnHiests, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnMurder, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rdbtnOther_1)))
							.addGap(627))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblOtherDetails)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 509, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblType)
							.addContainerGap(1218, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblSuspectDetails)
							.addContainerGap(1138, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblLocation)
							.addContainerGap(1195, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(LocationComboBox, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(1114, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblType)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(rdbtnKidnap, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnHiests)
						.addComponent(rdbtnMurder, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnOther_1))
					.addGap(59)
					.addComponent(lblLocation)
					.addGap(18)
					.addComponent(LocationComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(lblSuspectDetails)
					.addGap(1)
					.addComponent(lblHeight)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sliderheight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblGender)
					.addGap(9)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnMale)
						.addComponent(rdbtnFemale)
						.addComponent(rdbtnOther))
					.addGap(18)
					.addComponent(lblSkintone)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnFair, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHair))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(rdbtnTan, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
							.addComponent(rdbtnDark, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addGap(4)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblColour)
						.addComponent(HaircolourCombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(HairstyleCombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFacialHair)
						.addComponent(FacialhairCombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOtherDetails))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
