/* Objetivo
 * Cambiar las coordenadas de polares a cartesianas y de cartesiana a polares
 */

/* Precondiciones
 * Recibe las coordenadas polares o cartesiana que escribio el usuario.
 */

/* Poscondiciones
 * Camabia las coodenadas recibidas de polares a cartesianas o de cartesianas a polares.
 */

// Autor: Carlos Rodriguez
// Fecha: 17/febrero/2020

public class Calculator {
	private double x;
	private double y;
	private double theta;
	private double r;

	public Calculator() {

	}

	public void polarToCart(double r, double theta) {
		this.theta = theta;
		this.r = r;
		x = r * Math.cos(theta);
		y = r * Math.sin(theta);
	}

	public void cartToPolar(double x, double y) {
		this.x = x;
		this.y = y;
		theta = Math.atan2(y, x);
		r = Math.sqrt(x * x + y * y);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getTheta() {
		return theta;
	}

	public double getR() {
		return r;
	}
}
