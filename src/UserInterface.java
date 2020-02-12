import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserInterface extends JFrame {

	private JPanel contentPane;
	private JTextField txtHg;
	private JTextField textField_1;

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
		setBounds(450, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Close  Plane");
		btnNewButton.setBounds(0, 0, 105, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear Plane");
		btnNewButton_1.setBounds(387, 0, 105, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Generate Plane");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Gui window = new Gui();
				window.cp.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(359, 338, 125, 23);
		contentPane.add(btnNewButton_2);
		
		txtHg = new JTextField();
		txtHg.setBounds(112, 79, 86, 20);
		contentPane.add(txtHg);
		txtHg.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(282, 79, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Cartesian Coordinates");
		btnNewButton_3.setBounds(156, 129, 162, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Polar Coordenates");
		btnNewButton_4.setBounds(169, 179, 140, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Return to Origine");
		btnNewButton_5.setBounds(175, 233, 130, 23);
		contentPane.add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("x Coordinate");
		lblNewLabel.setBounds(117, 54, 105, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("y Coordinate");
		lblNewLabel_1.setBounds(288, 54, 105, 14);
		contentPane.add(lblNewLabel_1);
	}

}
