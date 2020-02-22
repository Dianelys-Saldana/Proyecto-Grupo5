import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.After;
import org.junit.Test;

// Autor: Angel D. Hernandez Denis
// Fecha: 21/febrero/2020

public class Tester {
	Calculator c = new Calculator();
	BigDecimal bd1 = new BigDecimal(0);
	BigDecimal bd2 = new BigDecimal(0);
	double x;
	double y;
	double r;
	double theta;
	double result1;
	double result2;

	@Test
	public void polarToCartTest() {

		r = 0.00;
		theta = 0.00;
		c.polarToCart(r, theta);
		result1 = c.getX();
		result2 = c.getY();
		bd1 = new BigDecimal(result1).setScale(1, RoundingMode.DOWN);
		bd2 = new BigDecimal(result2).setScale(1, RoundingMode.DOWN);
		assertEquals(0.0, bd1.doubleValue(), 0);
		assertEquals(0.0, bd2.doubleValue(), 0);

		r = 9.43;
		theta = 1.01;
		c.polarToCart(r, theta);
		result1 = c.getX();
		result2 = c.getY();
		bd1 = new BigDecimal(result1).setScale(1, RoundingMode.DOWN);
		bd2 = new BigDecimal(result2).setScale(1, RoundingMode.DOWN);
		assertEquals(5.0, bd1.doubleValue(), 0);
		assertEquals(7.9, bd2.doubleValue(), 0);

		r = 10.77;
		theta = 0.38;
		c.polarToCart(r, theta);
		result1 = c.getX();
		result2 = c.getY();
		bd1 = new BigDecimal(result1).setScale(1, RoundingMode.DOWN);
		bd2 = new BigDecimal(result2).setScale(1, RoundingMode.DOWN);
		assertEquals(10.0, bd1.doubleValue(), 0);
		assertEquals(3.9, bd2.doubleValue(), 0);

		r = 28.28;
		theta = 0.79;
		c.polarToCart(r, theta);
		result1 = c.getX();
		result2 = c.getY();
		bd1 = new BigDecimal(result1).setScale(1, RoundingMode.DOWN);
		bd2 = new BigDecimal(result2).setScale(1, RoundingMode.DOWN);
		assertEquals(19.9, bd1.doubleValue(), 0);
		assertEquals(20.0, bd2.doubleValue(), 0);

		r = 117.05;
		theta = 0.99;
		c.polarToCart(r, theta);
		result1 = c.getX();
		result2 = c.getY();
		bd1 = new BigDecimal(result1).setScale(1, RoundingMode.DOWN);
		bd2 = new BigDecimal(result2).setScale(1, RoundingMode.DOWN);
		assertEquals(64.2, bd1.doubleValue(), 0);
		assertEquals(97.8, bd2.doubleValue(), 0);

		r = 92.26;
		theta = 1.26;
		c.polarToCart(r, theta);
		result1 = c.getX();
		result2 = c.getY();
		bd1 = new BigDecimal(result1).setScale(1, RoundingMode.DOWN);
		bd2 = new BigDecimal(result2).setScale(1, RoundingMode.DOWN);
		assertEquals(28.2, bd1.doubleValue(), 0);
		assertEquals(87.8, bd2.doubleValue(), 0);
	}

	@Test
	public void cartToPolarTest() {
		x = 0;
		y = 0;
		c.cartToPolar(x, y);
		result1 = c.getTheta();
		result2 = c.getR();
		bd1 = new BigDecimal(result1).setScale(2, RoundingMode.DOWN);
		bd2 = new BigDecimal(result2).setScale(2, RoundingMode.DOWN);
		assertEquals(0.00, bd1.doubleValue(), 0);
		assertEquals(0.00, bd2.doubleValue(), 0);

		x = 9;
		y = 7;
		c.cartToPolar(x, y);
		result1 = c.getTheta();
		result2 = c.getR();
		bd1 = new BigDecimal(result1).setScale(2, RoundingMode.DOWN);
		bd2 = new BigDecimal(result2).setScale(2, RoundingMode.DOWN);
		assertEquals(0.66, bd1.doubleValue(), 0);
		assertEquals(11.40, bd2.doubleValue(), 0);

		x = 20;
		y = 20;
		c.cartToPolar(x, y);
		result1 = c.getTheta();
		result2 = c.getR();
		bd1 = new BigDecimal(result1).setScale(2, RoundingMode.DOWN);
		bd2 = new BigDecimal(result2).setScale(2, RoundingMode.DOWN);
		assertEquals(0.78, bd1.doubleValue(), 0);
		assertEquals(28.28, bd2.doubleValue(), 0);

		x = 34;
		y = 76;
		c.cartToPolar(x, y);
		result1 = c.getTheta();
		result2 = c.getR();
		bd1 = new BigDecimal(result1).setScale(2, RoundingMode.DOWN);
		bd2 = new BigDecimal(result2).setScale(2, RoundingMode.DOWN);
		assertEquals(1.15, bd1.doubleValue(), 0);
		assertEquals(83.25, bd2.doubleValue(), 0);

		x = 28;
		y = 88;
		c.cartToPolar(x, y);
		result1 = c.getTheta();
		result2 = c.getR();
		bd1 = new BigDecimal(result1).setScale(2, RoundingMode.DOWN);
		bd2 = new BigDecimal(result2).setScale(2, RoundingMode.DOWN);
		assertEquals(1.26, bd1.doubleValue(), 0);
		assertEquals(92.34, bd2.doubleValue(), 0);

		x = -6;
		y = -4;
		c.cartToPolar(x, y);
		result1 = c.getTheta();
		result2 = c.getR();
		bd1 = new BigDecimal(result1).setScale(2, RoundingMode.DOWN);
		bd2 = new BigDecimal(result2).setScale(2, RoundingMode.DOWN);
		assertEquals(-2.55, bd1.doubleValue(), 0);
		assertEquals(7.21, bd2.doubleValue(), 0);
	}
}
