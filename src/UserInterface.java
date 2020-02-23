/* Objetivo
 * Esta clase es la encargada de mostrar el GUI en el cual el usuario podra interactuar con la aplicacion.
 * Mediante esta, se monitorea todo lo que el usuario oprime para poder asi hacer la accion correspodiente.
 */

/* Precondiciones
 * El usuario sera bienvenido por una ventana en la cual vera una grafica en coordenadas polares.
 * En la parte izquierda de la ventana hay unas cajas de texto en la cuales el usuario podra escribir numeros que
   representan las coordenadas que este desee graficar; tanto polares como cartesianas.
 * Podra cambiar la grafica de modo polar a cartesiana y vice versa con los botones 'Polar plane' y 
   'Cartesian plane', graficar las coordenadas introducidas con el boton de 'Graph', borrar todas los
   trazos con el boton 'Reset' y  volver al origen sin borrar los trazos con el boton 'Return to origin'.
 */

/* Poscondiciones
 * Una vez que el usuario escriba las coordenadas en las cajas de texto correspodientes, se graficara una linea en el plano desde
 * el origen hasta las coordenadas provistas. Esto ocurrira una vez el usuaruo quiera graficar y oprima el boton de 'Graph'.
 * El usuario decidira que coordenadas ingresar, ya sean polares o cartesianas.
 * Si el usuario quiere ver ese mismo trazo en el plano contrario, simplemente debe presionar el boton del plano al que
   quiere ver; sea cartesiano o polar, y el plano cambiara correspondientemente sin borrar los trazos.
 * Del usuario no estar satisfecho con los trazos puede borrarlos oprimiendo el boton de 'Reset'.
 * Del usuario querer volver al origen de la grafica para dibujar trazos desde ese lugar, simplemente debe oprimir
   el boton de 'Return to origin' y listo.
 */  

// Autor: Angel D. Hernandez Denis
// Autor: Dianelys Saldana
// Autor: Carlos Rodriguez
// Autor: Jose Velazquez
// Fecha: 21/febrero/2020

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
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

	Calculator c = new Calculator();

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
			drawPlane(g, this);
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < x.size(); i++) {
			if (x.get(i) == null) {
				continue;
			}
			this.drawCircleByCenter(g, x.get(i) - 3, y.get(i) - 2);
		}

		for (int i = x.size() - 1; i > 0; i--) {
			if (x.get(i - 1) == null || x.get(i) == null) {
				continue;
			}
			if (xButton.getText() != null && yButton.getText() != null) {
				DecimalFormat numberFormat = new DecimalFormat("#0.00");
				c.cartToPolar(Double.parseDouble(xButton.getText()), Double.parseDouble(yButton.getText()));
				double r = c.getR();
				double ang = c.getTheta();
				ang = Math.toDegrees(ang);
				rButton.setText(numberFormat.format(r));
				angleButton.setText(numberFormat.format(ang));
			}
			g2.draw(new Line2D.Double(x.get(i - 1), y.get(i - 1), x.get(i), y.get(i)));
			this.drawCircleByCenter(g, 525 + (x.get(i) * 13.75), 300 - (y.get(i) * 14.5));
		}
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
	 * 
	 * @throws IOException
	 */
	public UserInterface() throws IOException {
		x.add(525.0);
		y.add(300.0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Buttons
		xButton = new JTextField();
		xButton.setBounds(35, 175, 55, 35);
		contentPane.add(xButton);
		xButton.setColumns(10);

		yButton = new JTextField();
		yButton.setColumns(10);
		yButton.setBounds(135, 175, 55, 35);
		contentPane.add(yButton);

		rButton = new JTextField();
		rButton.setColumns(10);
		rButton.setBounds(35, 290, 55, 35);
		contentPane.add(rButton);

		angleButton = new JTextField();
		angleButton.setColumns(10);
		angleButton.setBounds(135, 290, 55, 35);
		contentPane.add(angleButton);

		JButton btnGraph = new JButton("Graph");
		btnGraph.setBounds(75, 220, 75, 35);
		contentPane.add(btnGraph);
		btnGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!xButton.getText().matches("[-]?[0-9]+[.]?[0-9]*")
						|| !yButton.getText().matches("[-]?[0-9]+[.]?[0-9]*")) {
					JOptionPane.showMessageDialog(contentPane, "You should input correct coordinates.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (Double.parseDouble(xButton.getText()) > 20 || Double.parseDouble(xButton.getText()) < -20) {
					JOptionPane.showMessageDialog(contentPane, "Please use smaller coordinates", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (Double.parseDouble(yButton.getText()) > 20 || Double.parseDouble(yButton.getText()) < -20) {
					JOptionPane.showMessageDialog(contentPane, "Please use smaller coordinates", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				x.add(525 + (Double.parseDouble(xButton.getText()) * 13.75));
				y.add(300 - (Double.parseDouble(yButton.getText()) * 14.5));
				DecimalFormat numberFormat = new DecimalFormat("#0.00");
				if (Double.parseDouble(xButton.getText()) != 0.00 && Double.parseDouble(yButton.getText()) != 0.00) {
					c.cartToPolar(Double.parseDouble(xButton.getText()), Double.parseDouble(yButton.getText()));
					double r = c.getR();
					double ang = c.getTheta();
					ang = Math.toDegrees(ang);

					rButton.setText(numberFormat.format(r));
					angleButton.setText(numberFormat.format(ang));
				}
				repaint();
			}
		});

		JButton btnGraphPolar = new JButton("Graph");
		btnGraphPolar.setBounds(75, 335, 75, 35);
		contentPane.add(btnGraphPolar);
		btnGraphPolar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!rButton.getText().matches("[-]?[0-9]+[.]?[0-9]*")
						|| !angleButton.getText().matches("[-]?[0-9]+[.]?[0-9]*")) {
					JOptionPane.showMessageDialog(contentPane, "You should input a correct coordinate.", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				if (Double.parseDouble(rButton.getText()) > 20 || Double.parseDouble(rButton.getText()) < -20) {
					JOptionPane.showMessageDialog(contentPane, "Please use smaller coordinates", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				DecimalFormat numberFormat = new DecimalFormat("#0.00");

				if (Double.parseDouble(rButton.getText()) != 0.00
						&& Double.parseDouble(angleButton.getText()) != 0.00) {
					double radians = Math.toRadians(Double.parseDouble(angleButton.getText()));
					c.polarToCart(Double.parseDouble(rButton.getText()), radians);
					double xCoor = c.getX();
					double yCoor = c.getY();
					xButton.setText(numberFormat.format(xCoor));
					yButton.setText(numberFormat.format(yCoor));
					x.add(525 + (xCoor * 13.75));
					y.add(300 - (yCoor * 14.5));
				}
				repaint();
			}
		});

		btnReset = new JButton("Reset");
		btnReset.setBounds(50, 465, 130, 35);
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
		btnReturnToOrigin.setBounds(50, 510, 130, 35);
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
		btnClearCoordinates.setBounds(50, 420, 130, 35);
		contentPane.add(btnClearCoordinates);

		// Radio Buttons
		JRadioButton polarPlane = new JRadioButton("Polar Plane");
		polarPlane.setBounds(30, 85, 160, 35);
		contentPane.add(polarPlane);
		polarPlane.setSelected(true);
		polarPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					img = ImageIO.read(this.getClass().getResource("/Polar.png"));
					repaint();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		if (polarPlane.isEnabled()) {
			img = ImageIO.read(this.getClass().getResource("/Polar.png"));
			repaint();
		}

		JRadioButton cartesianPlane = new JRadioButton("Cartesian Plane");
		cartesianPlane.setBounds(30, 45, 160, 35);
		contentPane.add(cartesianPlane);
		cartesianPlane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					img = ImageIO.read(this.getClass().getResource("/Cartesian.png"));
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
		lblX = new JLabel("x:");
		lblX.setBounds(20, 175, 55, 35);
		contentPane.add(lblX);

		lblY = new JLabel("y:");
		lblY.setBounds(125, 175, 55, 35);
		contentPane.add(lblY);

		lblR = new JLabel("r:");
		lblR.setBounds(20, 290, 55, 35);
		contentPane.add(lblR);

		lblA = new JLabel("Theta:");
		lblA.setBounds(95, 290, 55, 35);
		contentPane.add(lblA);
	}
}
