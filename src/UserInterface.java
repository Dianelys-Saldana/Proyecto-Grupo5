import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.text.DecimalFormat;
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
	private JLabel lblA;
	private JButton btnReset;
	private JButton btnReturnToOrigin;
	private Image img;

	ArrayList<Double> x = new ArrayList<Double>();
	ArrayList<Double> y = new ArrayList<Double>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Draw lines and circles in Cartesian Plane
	public void paint(Graphics g) {
		// Circular Surface
		Graphics2D g2 = (Graphics2D) g; 
		super.paint(g);

		try {
			drawPlane(g,this);
		} catch (IOException e) {
			e.printStackTrace();
		}

		for(int i = 0; i < x.size(); i++) {
			if(x.get(i) == null) {
				continue;
			}
			this.drawCircleByCenter(g, x.get(i) - 3, y.get(i) - 2);
		}

		for(int i = x.size() -1; i > 0; i--) {
			if(x.get(i-1) == null || x.get(i) == null) {
				continue;
			}
			if(xButton.getText() != null && yButton.getText() != null) {
				DecimalFormat numberFormat = new DecimalFormat("#0.00");
				double r = Math.sqrt(Math.pow(Double.parseDouble(xButton.getText()), 2)
						+ Math.pow(Double.parseDouble(yButton.getText()), 2));
				double ang = Math.atan2(Double.parseDouble(yButton.getText()), 
						Double.parseDouble(xButton.getText()));
				ang = Math.toDegrees(ang);
				rButton.setText(numberFormat.format(r));
				angleButton.setText(numberFormat.format(ang));
			}
			g2.draw(new Line2D.Double(x.get(i-1), y.get(i-1), x.get(i), y.get(i)));
			this.drawCircleByCenter(g, 525 + (x.get(i) * 14.5), 300 - (y.get(i) * 14.5));
		}

		//		for(int i = 0; i < r.size(); i++) {
		//			if(r.get(i) == null) {
		//				continue;
		//			}
		//			this.drawCircleByCenter(g, r.get(i) - 3, a.get(i) - 2);
		//		}
		//
		//		for(int i = r.size() -1; i > 0; i--) {
		//			g2.draw(new Line2D.Double(r.get(i-1), a.get(i-1), r.get(i), a.get(i)));
		//			this.drawCircleByCenter(g, 525 + (r.get(i) * 13.75), 300 - (a.get(i) * 15));
		//		}
	}

	void drawPlane(Graphics g, ImageObserver observer) throws IOException {
		g.drawImage(img, 250, 0, observer);
	}

	void drawCircleByCenter(Graphics g, double x, double y) {
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(new Ellipse2D.Double(x, y, 5, 5));
		g2.fill(new Ellipse2D.Double(x, y, 5, 5));
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public UserInterface() throws IOException {
		x.add(525.0);
		y.add(300.0);
		//		r.add(525.0);
		//		a.add(300.0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Buttons
		xButton = new JTextField();
		xButton.setBounds(37, 173, 55, 35);
		contentPane.add(xButton);
		xButton.setColumns(10);

		yButton = new JTextField();
		yButton.setColumns(10);
		yButton.setBounds(133, 173, 55, 35);
		contentPane.add(yButton);

		rButton = new JTextField();
		rButton.setColumns(10);
		rButton.setBounds(37, 290, 55, 35);
		contentPane.add(rButton);

		angleButton = new JTextField();
		angleButton.setColumns(10);
		angleButton.setBounds(133, 290, 55, 35);
		contentPane.add(angleButton);

		JButton btnGraph = new JButton("Graph");
		btnGraph.setBounds(73, 220, 75, 35);
		contentPane.add(btnGraph);
		btnGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!xButton.getText().matches("[-]?[0-9]+[.]?[0-9]*") || !yButton.getText().matches("[-]?[0-9]+[.]?[0-9]*")) {
					JOptionPane.showMessageDialog(contentPane, "You should input correct coordinates.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(Double.parseDouble(xButton.getText())>20||Double.parseDouble(xButton.getText())<-20) {
					JOptionPane.showMessageDialog(contentPane, "Please use smaller coordinates", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(Double.parseDouble(yButton.getText())>20||Double.parseDouble(yButton.getText())<-20) {
					JOptionPane.showMessageDialog(contentPane, "Please use smaller coordinates", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				x.add(525+Double.parseDouble(xButton.getText())*13.75);
				y.add(300-15*Double.parseDouble(yButton.getText()));
				DecimalFormat numberFormat = new DecimalFormat("#.00");
				if(Double.parseDouble(xButton.getText()) != 0.00 && Double.parseDouble(yButton.getText()) != 0.00) {
					double r = Math.sqrt(Math.pow(Double.parseDouble(xButton.getText()), 2)
							+ Math.pow(Double.parseDouble(yButton.getText()), 2));
					double ang = Math.atan(Double.parseDouble(yButton.getText())/ 
							Double.parseDouble(xButton.getText()));
					ang = Math.toDegrees(ang);

					rButton.setText(numberFormat.format(r));
					angleButton.setText(numberFormat.format(ang));

				}

				repaint();

			}
		});

		JButton btnGraphPolar = new JButton("Graph");
		btnGraphPolar.setBounds(73, 337, 75, 35);
		contentPane.add(btnGraphPolar);
		btnGraphPolar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!rButton.getText().matches("[-]?[0-9]+[.]?[0-9]*") || !angleButton.getText().matches("[-]?[0-9]+[.]?[0-9]*")) {
					JOptionPane.showMessageDialog(contentPane, "You should input a correct coordinate.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(Double.parseDouble(rButton.getText())>20||Double.parseDouble(rButton.getText())<-20) {
					JOptionPane.showMessageDialog(contentPane, "Please use smaller coordinates", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				DecimalFormat numberFormat = new DecimalFormat("#0.00");
				
				if(Double.parseDouble(rButton.getText()) != 0.00 && Double.parseDouble(angleButton.getText()) != 0.00) {
					double radians = Math.toRadians(Double.parseDouble(angleButton.getText()));
					double  xCoor = Double.parseDouble(rButton.getText())*
							Math.cos(radians);
					double  yCoor = Double.parseDouble(rButton.getText())*
							Math.sin(radians);
					System.out.println(radians);
					xButton.setText(numberFormat.format(xCoor));
					yButton.setText(numberFormat.format(yCoor));
					x.add(xCoor*14.5+525);
					y.add(300-14.5*yCoor);
				}
				repaint();

			}
		});

		btnReset = new JButton("Reset");
		btnReset.setBounds(37, 437, 132, 35);
		contentPane.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x.clear();
				y.clear();
				x.add(525.0);
				y.add(300.0);
				repaint();
			}
		});

		btnReturnToOrigin = new JButton("Return to origin");
		btnReturnToOrigin.setBounds(37, 496, 132, 35);
		contentPane.add(btnReturnToOrigin);
		btnReturnToOrigin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x.add(null);
				y.add(null);
				x.add(525.0);
				y.add(300.0);
				repaint();
			}
		});
		
		JButton btnClearCoordinates = new JButton("Clear Coordinates");
		btnClearCoordinates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				xButton.setText("");
				yButton.setText("");
				angleButton.setText("");
				rButton.setText("");
			}
		});
		btnClearCoordinates.setBounds(28, 393, 141, 35);
		contentPane.add(btnClearCoordinates);


		// Radio Buttons
		JRadioButton polarPlane = new JRadioButton("Polar Plane");
		polarPlane.setBounds(22, 80, 159, 35);
		contentPane.add(polarPlane);
		polarPlane.setSelected(true);
		polarPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					img =  ImageIO.read(this.getClass().getResource("/Polar.png"));
					repaint();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		if(polarPlane.isEnabled()) {
			img =  ImageIO.read(this.getClass().getResource("/Polar.png"));
			repaint();
		}

		JRadioButton cartesianPlane = new JRadioButton("Cartesian Plane");
		cartesianPlane.setBounds(22, 46, 159, 35);
		contentPane.add(cartesianPlane);
		cartesianPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					img =  ImageIO.read(this.getClass().getResource("/Cartesian.png"));
					repaint();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		ButtonGroup radioButtons = new ButtonGroup();
		radioButtons.add(cartesianPlane);
		radioButtons.add(polarPlane);


		// Labels
		lblX = new JLabel("x: ");
		lblX.setBounds(22, 173, 56, 35);
		contentPane.add(lblX);

		lblY = new JLabel("y:");
		lblY.setBounds(113, 173, 56, 35);
		contentPane.add(lblY);

		lblR = new JLabel("r:");
		lblR.setBounds(22, 290, 56, 35);
		contentPane.add(lblR);

		lblA = new JLabel("Theta:");
		lblA.setBounds(95, 290, 56, 35);
		contentPane.add(lblA);
	}
}
