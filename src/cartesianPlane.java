
import javax.swing.*;

import java.awt.*;

public class cartesianPlane extends JFrame {

	public cartesianPlane() {

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		//crear lineas 
		for(int i = 0; i < 1500; i += 150) {
			g.drawLine(i, 0, i, 1000);
		}
		for(int i = 0; i < 1000; i += 100) {
			g.drawLine(0, i, 1500, i);
		}
		g.setColor(Color.RED);
		g.drawLine(0, 500, 1500, 500);//linea vertical del origen 
		g.drawLine(750, 0, 750,1000 );//linea horizontal del origen
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		int x =1;
		//Enumeracion en x
		for(int i = 900; i < 1500; i += 150) {
			g.drawString(""+x++, i, 500);
		}
		//Enumeracion en Y
		x=1;
		for(int i = 400 ; i > 0; i -= 100) {
			g.drawString(""+x++, 750, i);
		}
		g.drawString("X", 1450,500);//label x
		g.drawString("Y", 700 ,100);//label y
		g.drawString("(0, 0)",750,500);//label the origin
		
		
		


	}

}

