import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Splashscreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Splashscreen frame = new Splashscreen();
					frame.setVisible(true);
					JWindow window = new JWindow();
					window.getContentPane().add(
					    new JLabel(" ", new ImageIcon(new URL("http://i.gifntext.com/94fUbIglnM-projects.gif")), SwingConstants.CENTER));
					window.setBounds(500, 150, 300, 200);
					window.setVisible(true);
					try {
					    Thread.sleep(2000);
					} catch (InterruptedException e) {
					    e.printStackTrace();
					}
					
					window.setVisible(false);
					Login window1 = new Login();
					Login.main();
					window.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame  99.
	 */
	public Splashscreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
