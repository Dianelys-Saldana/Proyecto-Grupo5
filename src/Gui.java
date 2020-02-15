import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Gui  {
	cartesianPlane cp = new cartesianPlane();
	polarPlane pp = new polarPlane();
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = pp;
		frame.setBounds(100, 100, 1500,1000 );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
