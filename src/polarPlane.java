
import javax.swing.*;

import java.awt.*;

public class polarPlane extends JFrame {

	public polarPlane() {

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		
		// Circulos
		g.drawOval(100, 100, 600, 600);
		g.drawOval(150,150,500,500);
		g.drawOval(200,200,400,400);
		g.drawOval(250,250,300,300);
		g.drawOval(300,300,200,200);
		g.drawOval(350,350,100,100);
		
//		for(int i = 100; i < 1000; i+=50) {
//			for(int j = 600; j > 0; j-=100) {
//				g.drawOval(i, i+50, j, j+100);
//			}
//		}
		
//		int x = 0;
//		int  y = 1000;
//		
//		for(int i = 900; i < 1500; i += 150) {
//			g.drawOval(x += 100, x, y -= 1000, y);
//		}
		
		// Lineas
		g.drawLine(400, 0, 400, 1000); // Vertical
		g.drawLine(0, 400, 1000, 400); // Horizontal
		// Diagonal 1
		g.drawLine(-400, -400, 400, 400); 
		g.drawLine(-800, -800, 800, 800); 
		// Diagonal 2
	}

}

