
import javax.swing.*;

import java.awt.*;

public class cartesianPlane extends JFrame {

	public cartesianPlane() {

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);

		for(int i = 0; i < 1500; i += 150) {
			g.drawLine(i, 0, i, 1000);
		}
		for(int i = 0; i < 1000; i += 100) {
			g.drawLine(0, i, 1500, i);
		}
		g.setColor(Color.RED);
		g.drawLine(0, 500, 1500, 500);
		g.drawLine(750, 0, 750,1000 );
		


	}

}

