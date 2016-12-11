import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class informer_checkstatus_panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public informer_checkstatus_panel() {
		setBackground(Color.BLACK);
		
		JLabel lblCaseID = new JLabel("Case ID");
		lblCaseID.setForeground(Color.WHITE);
		lblCaseID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCaseID.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblAcknowledgement = new JLabel("Acknowledgement Status");
		lblAcknowledgement.setForeground(Color.WHITE);
		
		JTextArea txtAcknowledgement = new JTextArea();
		
		JLabel lblNewLabel_1 = new JLabel("Status");
		lblNewLabel_1.setForeground(Color.WHITE);
		
		JTextArea txtStatus = new JTextArea();
		
		JLabel lblPoliceStationAssigned = new JLabel("Police Station Assigned");
		lblPoliceStationAssigned.setForeground(Color.WHITE);
		
		JTextArea txtP = new JTextArea();
		
		JLabel lblExecutiveAssigned = new JLabel("Executive Assigned");
		lblExecutiveAssigned.setForeground(Color.WHITE);
		
		JTextArea textArea = new JTextArea();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblAcknowledgement, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPoliceStationAssigned)
						.addComponent(lblExecutiveAssigned))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCaseID, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtP, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
							.addGap(1))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtAcknowledgement, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
								.addComponent(txtStatus, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
							.addGap(1)))
					.addGap(30))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblCaseID, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAcknowledgement, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(txtAcknowledgement, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtStatus))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPoliceStationAssigned)
						.addComponent(txtP))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblExecutiveAssigned)
						.addComponent(textArea))
					.addGap(89))
		);
		setLayout(groupLayout);

	}
}
