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
		
		//panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
		//text box cordenada x
		xButton = new JTextField();
		xButton.setText("  x");
		xButton.setBounds(30, 90, 35, 35);
		contentPane.add(xButton);
		xButton.setColumns(10);
		
		//text box cordenada y
		yButton = new JTextField();
		yButton.setText("  y");
		yButton.setColumns(10);
		yButton.setBounds(75, 90, 35, 35);
		contentPane.add(yButton);
		
		//text box radio
		rButton = new JTextField();
		rButton.setText("  r");
		rButton.setColumns(10);
		rButton.setBounds(30, 135, 35, 35);
		contentPane.add(rButton);
		
		//text box grado
		angleButton = new JTextField();
		angleButton.setText("  θ");
		angleButton.setColumns(10);
		angleButton.setBounds(75, 135, 35, 35);
		contentPane.add(angleButton);
		
		//boton de graph
		JButton btnGraph = new JButton("Graph");
		btnGraph.setBounds(33, 175, 75, 35);
		contentPane.add(btnGraph);
		
		//imagen escoger plano polar
		JRadioButton polarPlane = new JRadioButton("Polar Plane");
		polarPlane.setBounds(25, 275, 200, 35);
		contentPane.add(polarPlane);
		
		//boton escoger plano cartesiano 
		JRadioButton cartesianPlane = new JRadioButton("Cartesian Plane");
		cartesianPlane.setBounds(25, 315, 200, 35);
		contentPane.add(cartesianPlane);

		//imagen plano cartesiano 		
//		JLabel backgroundCP;
//		Image img2 = new ImageIcon(this.getClass().getResource("/Background-cp.png")).getImage();
//		backgroundCP = new JLabel("", JLabel.CENTER);
//		backgroundCP.setIcon(new ImageIcon(img2));
//		backgroundCP.setBounds(0, 0, 800, 600);
//		getContentPane().add(backgroundCP);
		
		//imagen plano polar
		JLabel backgroundCC;
		Image img = new ImageIcon(this.getClass().getResource("/Background-cc.png")).getImage();
		backgroundCC = new JLabel("", JLabel.CENTER);
		backgroundCC.setIcon(new ImageIcon(img));
		backgroundCC.setBounds(0, 0, 800, 600);
		getContentPane().add(backgroundCC);
		
		
	
	}
}
