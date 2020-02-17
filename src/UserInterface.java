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
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import java.awt.TextField;
import javax.swing.JEditorPane;
import javax.swing.DropMode;

public class UserInterface extends JFrame {

	private JPanel contentPane;
	private JTextField txtx;
	private JTextField txtY;

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
		
//		JLabel backgroundCC;
//		Image img = new ImageIcon(this.getClass().getResource("/Background-cc.png")).getImage();
//		backgroundCC = new JLabel("", JLabel.CENTER);
//		backgroundCC.setIcon(new ImageIcon(img));
//		backgroundCC.setBounds(0, 0, 800, 600);
//		getContentPane().add(backgroundCC);
		
		
		txtx = new JTextField();
		txtx.setText("X");
		txtx.setBounds(0, 10, 51, 32);
		contentPane.add(txtx);
		txtx.setColumns(10);
		
		txtY = new JTextField();
		txtY.setText("Y");
		txtY.setBounds(109, 10, 51, 32);
		contentPane.add(txtY);
		txtY.setColumns(10);
		
		JRadioButton rdbtnPolarPlane = new JRadioButton("Polar Plane");
		rdbtnPolarPlane.setBounds(0, 153, 201, 35);
		contentPane.add(rdbtnPolarPlane);
		
		JRadioButton rdbtnCartesianPlane = new JRadioButton("Cartesian Plane");
		rdbtnCartesianPlane.setBounds(0, 201, 201, 35);
		contentPane.add(rdbtnCartesianPlane);
		
		JLabel backgroundCP;
		Image img2 = new ImageIcon(this.getClass().getResource("/Background-cp.png")).getImage();
		
		JButton btnGraphic = new JButton("Graphic");
		btnGraphic.setBounds(21, 58, 141, 35);
		contentPane.add(btnGraphic);
		backgroundCP = new JLabel("", JLabel.CENTER);
		backgroundCP.setIcon(new ImageIcon(img2));
		backgroundCP.setBounds(0, 0, 800, 600);
		getContentPane().add(backgroundCP);
		
	
	}
}
