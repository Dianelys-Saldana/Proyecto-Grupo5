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
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.awt.event.ActionEvent;

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
	private Image img;

	ArrayList<Integer> x = new ArrayList<Integer>();
	ArrayList<Integer> y = new ArrayList<Integer>();

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

	public void paint(Graphics g) {
		// Circular Surface
		super.paint(g);
		try {
			drawPlane(g,this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < x.size(); i++) {
			this.drawCircleByCenter(g, x.get(i), y.get(i));
		}
		for (int i = x.size() - 1; i > 0; i--) {
			g.drawLine(x.get(i), y.get(i), x.get(i - 1), y.get(i - 1));
		}
	}
	void drawPlane(Graphics g, ImageObserver observer) throws IOException {
		g.drawImage(img,256,0,observer);
	}
	void drawCircleByCenter(Graphics g, int x, int y) {
		g.drawOval(x, y, 5, 5);
		g.fillOval(x, y, 5, 5);
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public UserInterface() throws IOException {
		x.add(523);
		y.add(342);
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
		btnGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x.add(Integer.parseInt(xButton.getText()));
				y.add(Integer.parseInt(yButton.getText()));

				repaint();
			}
		});

		contentPane.add(btnGraph);

		btnReset = new JButton("Reset");
		btnReset.setBounds(124, 165, 75, 35);
		contentPane.add(btnReset);

		btnReturnToOrigine = new JButton("Return to origin");
		btnReturnToOrigine.setBounds(45, 220, 132, 35);
		contentPane.add(btnReturnToOrigine);
		
		JRadioButton polarPlane = new JRadioButton("Polar Plane");
		polarPlane.setSelected(true);
		polarPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					img =  ImageIO.read(this.getClass().getResource("/Polar.png"));
					repaint();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		if(polarPlane.isEnabled()) {
			img =  ImageIO.read(this.getClass().getResource("/Polar.png"));
			repaint();
		}
		polarPlane.setBounds(47, 268, 159, 35);
		contentPane.add(polarPlane);

		JRadioButton cartesianPlane = new JRadioButton("Cartesian Plane");
		cartesianPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					img =  ImageIO.read(this.getClass().getResource("/Cartesian.png"));
					repaint();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		cartesianPlane.setBounds(47, 306, 159, 35);
		contentPane.add(cartesianPlane);
		ButtonGroup radioButtons = new ButtonGroup();
		radioButtons.add(cartesianPlane);
		radioButtons.add(polarPlane);
		// JLabel backgroundCP;
		// Image img2 = new
		// ImageIcon(this.getClass().getResource("/Background-cp.png")).getImage();
		// backgroundCP = new JLabel("", JLabel.CENTER);
		// backgroundCP.setIcon(new ImageIcon(img2));
		// backgroundCP.setBounds(0, 0, 800, 600);
		// getContentPane().add(backgroundCP);

		JLabel backgroundCC;
		Image img =  ImageIO.read(this.getClass().getResource("/Background-bar.png"));

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
		backgroundCC.setBounds(0, 0, 256, 600);
		getContentPane().add(backgroundCC);
	}
}
