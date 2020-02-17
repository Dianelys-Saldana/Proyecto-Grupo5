import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class UserInterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
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
	public UserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton x = new JButton("x");
		x.setBounds(25, 75, 50, 50);
		contentPane.add(x);
		
		JButton y = new JButton("y");
		y.setBounds(85, 75, 50, 50);
		contentPane.add(y);
		
//		JLabel backgroundCC;
//		Image img = new ImageIcon(this.getClass().getResource("/Background-cc.png")).getImage();
//		backgroundCC = new JLabel("", JLabel.CENTER);
//		backgroundCC.setIcon(new ImageIcon(img));
//		backgroundCC.setBounds(0, 0, 800, 600);
//		getContentPane().add(backgroundCC);
		
		JLabel backgroundCP;
		Image img2 = new ImageIcon(this.getClass().getResource("/Background-cp.png")).getImage();
		backgroundCP = new JLabel("", JLabel.CENTER);
		backgroundCP.setIcon(new ImageIcon(img2));
		backgroundCP.setBounds(0, 0, 800, 600);
		getContentPane().add(backgroundCP);
		
	}
}
