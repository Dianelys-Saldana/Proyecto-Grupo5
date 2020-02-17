import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Panel;
import java.awt.Point;
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
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JEditorPane;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInterface extends JFrame {

	private JPanel contentPane;
	private JTextField xButton;
	private JTextField yButton;
	private JTextField rButton;
	private JTextField angleButton;
	ArrayList<Integer> x= new ArrayList<Integer>();
	ArrayList<Integer> y= new ArrayList<Integer>();
	

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
	
	public void paint(Graphics g){
	         // Circular Surface 
		super.paint(g);
		for(int i=0;i<x.size();i++) {
			this.drawCircleByCenter(g, x.get(i), y.get(i));
		}
		for(int i=x.size()-1;i>0;i--) {
			g.drawLine(x.get(i),y.get(i), x.get(i-1), y.get(i-1));
		}
		
		
			
	      
	     }

	     void drawCircleByCenter(Graphics g, int x, int y ){
	    	 g.drawOval(x, y, 5, 5);
	         g.fillOval(x, y, 5, 5);
	        
	     }
	     

	/**
	 * Create the frame.
	 */
	public UserInterface() {
		x.add(523);
		y.add(342);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		
		xButton = new JTextField();
		xButton.setText("X");
		xButton.setBounds(30, 90, 35, 35);
		contentPane.add(xButton);
		xButton.setColumns(10);
		
		yButton = new JTextField();
		yButton.setText("Y");
		yButton.setColumns(10);
		yButton.setBounds(75, 90, 35, 35);
		contentPane.add(yButton);
		
		rButton = new JTextField();
		rButton.setText("  r");
		rButton.setColumns(10);
		rButton.setBounds(30, 135, 35, 35);
		contentPane.add(rButton);
		
		angleButton = new JTextField();
		angleButton.setText("  θ");
		angleButton.setColumns(10);
		angleButton.setBounds(75, 135, 35, 35);
		contentPane.add(angleButton);
		
		JButton btnGraph = new JButton("Graph");
		btnGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  x.add(Integer.parseInt(xButton.getText()));
				  y.add(Integer.parseInt(yButton.getText()));
				  
				    repaint();
			}
		});
		btnGraph.setBounds(33, 175, 75, 35);
		contentPane.add(btnGraph);
		
		JRadioButton polarPlane = new JRadioButton("Polar Plane");
		polarPlane.setBounds(25, 275, 200, 35);
		contentPane.add(polarPlane);
		
		JRadioButton cartesianPlane = new JRadioButton("Cartesian Plane");
		cartesianPlane.setBounds(25, 315, 200, 35);
		contentPane.add(cartesianPlane);
		
//		JLabel backgroundCP;
//		Image img2 = new ImageIcon(this.getClass().getResource("/Background-cp.png")).getImage();
//		backgroundCP = new JLabel("", JLabel.CENTER);
//		backgroundCP.setIcon(new ImageIcon(img2));
//		backgroundCP.setBounds(0, 0, 800, 600);
//		getContentPane().add(backgroundCP);
		
		JLabel backgroundCC;
		Image img = new ImageIcon(this.getClass().getResource("/Background-cc.png")).getImage();
		backgroundCC = new JLabel("", JLabel.CENTER);
		backgroundCC.setIcon(new ImageIcon(img));
		backgroundCC.setBounds(0, 0, 800, 600);
		getContentPane().add(backgroundCC);
		
		
	
	}
	
}
