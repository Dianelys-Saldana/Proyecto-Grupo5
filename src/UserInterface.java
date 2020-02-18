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
	private JTextField xButton;
	private JTextField yButton;
	private JTextField rButton;
	private JTextField angleButton;
	private JLabel lblX;
	private JLabel lblY;
	private JLabel lblR;
	private JLabel label_1;
	private JButton btnReset;
	private JButton btnReturnToOrigine;

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
		
		xButton = new JTextField();
		xButton.setBounds(37, 42, 55, 35);
		contentPane.add(xButton);
		xButton.setColumns(10);
		
		yButton = new JTextField();
		yButton.setColumns(10);
		yButton.setBounds(133, 42, 55, 35);
		contentPane.add(yButton);
		
		rButton = new JTextField();
		rButton.setColumns(10);
		rButton.setBounds(37, 98, 55, 35);
		contentPane.add(rButton);
		
		angleButton = new JTextField();
		angleButton.setColumns(10);
		angleButton.setBounds(133, 98, 55, 35);
		contentPane.add(angleButton);
		
		JButton btnGraph = new JButton("Graph");
		btnGraph.setBounds(25, 165, 75, 35);
		contentPane.add(btnGraph);
		
		btnReset = new JButton("Reset");
		btnReset.setBounds(124, 165, 75, 35);
		contentPane.add(btnReset);
		
		btnReturnToOrigine = new JButton("Return to origin");
		btnReturnToOrigine.setBounds(45, 220, 132, 35);
		contentPane.add(btnReturnToOrigine);
		
		JRadioButton polarPlane = new JRadioButton("Polar Plane");
		polarPlane.setBounds(47, 268, 159, 35);
		contentPane.add(polarPlane);
		
		JRadioButton cartesianPlane = new JRadioButton("Cartesian Plane");
		cartesianPlane.setBounds(47, 306, 159, 35);
		contentPane.add(cartesianPlane);
		
//		JLabel backgroundCP;
//		Image img2 = new ImageIcon(this.getClass().getResource("/Background-cp.png")).getImage();
//		backgroundCP = new JLabel("", JLabel.CENTER);
//		backgroundCP.setIcon(new ImageIcon(img2));
//		backgroundCP.setBounds(0, 0, 800, 600);
//		getContentPane().add(backgroundCP);
		
		JLabel backgroundCC;
		Image img = new ImageIcon(this.getClass().getResource("/Background-cc.png")).getImage();
		
		lblX = new JLabel("x: ");
		lblX.setBounds(22, 42, 56, 35);
		contentPane.add(lblX);
		
		lblY = new JLabel("y:");
		lblY.setBounds(120, 42, 56, 35);
		contentPane.add(lblY);
		
		lblR = new JLabel("r:");
		lblR.setBounds(25, 98, 56, 35);
		contentPane.add(lblR);
		
		label_1 = new JLabel("\u00CE\u00B8:");
		label_1.setBounds(120, 98, 56, 35);
		contentPane.add(label_1);
		backgroundCC = new JLabel("", JLabel.CENTER);
		backgroundCC.setIcon(new ImageIcon(img));
		backgroundCC.setBounds(0, 0, 800, 600);
		getContentPane().add(backgroundCC);
		
		
	
	}
}
