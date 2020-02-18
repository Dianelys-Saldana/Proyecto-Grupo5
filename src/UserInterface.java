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
import javax.swing.ButtonGroup;
import javax.swing.DropMode;
import java.awt.Font;
import java.awt.Graphics;

public class UserInterface extends JFrame {

	private JPanel contentPane;
	private JTextField xButton;
	private JTextField yButton;
	private JTextField rButton;
	private JTextField angleButton;
	private JLabel titleCartesian;
	private JLabel polar;
	private JLabel titleOfPlane;
	
	int x = 500;
	int y = 300;

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
			
			ButtonGroup radioButtons = new ButtonGroup();
			radioButtons.add(cartesianPlane);
			radioButtons.add(polarPlane);
			
			
			
		
		//titulo de cordenadas 
			JLabel cordinatesTitle = new JLabel("Write coordinate to graph");
			cordinatesTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
			cordinatesTitle.setBounds(21, 52, 180, 27);
			contentPane.add(cordinatesTitle);
		
		//titulo cordenada cartesiana 
			titleCartesian = new JLabel("Cartesian Coordinate");
			titleCartesian.setFont(new Font("Tahoma", Font.PLAIN, 10));
			titleCartesian.setBounds(120, 90, 98, 35);
			contentPane.add(titleCartesian);
		
		//titulo cordenada polar
			polar = new JLabel("Polar Coordinate");
			polar.setFont(new Font("Tahoma", Font.PLAIN, 10));
			polar.setBounds(120, 145, 98, 14);
			contentPane.add(polar);
		
		//titulo en display	
			titleOfPlane = new JLabel("Plane to display\r\n");
			titleOfPlane.setBounds(21, 253, 125, 14);
			contentPane.add(titleOfPlane);
		

		//imagen plano cartesiano 		
//			JLabel backgroundCP;
//			Image img2 = new ImageIcon(this.getClass().getResource("/Background-cp.png")).getImage();
//			backgroundCP = new JLabel("", JLabel.CENTER);
//			backgroundCP.setIcon(new ImageIcon(img2));
//			backgroundCP.setBounds(0, 0, 800, 600);
//			getContentPane().add(backgroundCP);
		
		//imagen plano polar
//			JLabel backgroundCC;
//			Image img = new ImageIcon(this.getClass().getResource("/Background-cc.png")).getImage();
//			backgroundCC = new JLabel("", JLabel.CENTER);
//			backgroundCC.setIcon(new ImageIcon(img));
//			backgroundCC.setBounds(0, 0, 800, 600);
//			getContentPane().add(backgroundCC);
			
			if(cartesianPlane.isEnabled()) {
				JLabel backgroundCP;
				Image img2 = new ImageIcon(this.getClass().getResource("/Background-cp.png")).getImage();
				backgroundCP = new JLabel("", JLabel.CENTER);
				backgroundCP.setIcon(new ImageIcon(img2));
				backgroundCP.setBounds(0, 0, 800, 600);
				getContentPane().add(backgroundCP);
			}	
			else if(polarPlane.isEnabled()) {
				JLabel backgroundCC;
				Image img = new ImageIcon(this.getClass().getResource("/Background-cc.png")).getImage();
				backgroundCC = new JLabel("", JLabel.CENTER);
				backgroundCC.setIcon(new ImageIcon(img));
				backgroundCC.setBounds(0, 0, 800, 600);
				getContentPane().add(backgroundCC);
			}
		
	
	}
	
}
