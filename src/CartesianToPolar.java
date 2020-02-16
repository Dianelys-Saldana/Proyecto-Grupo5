
public class CartesianToPolar {
	private double x;
	private double y;
	private double theta;
	private double r;
	public CartesianToPolar(double x,double y) {
		this.x=x;
		this.y=y;
		theta = Math.atan2(y, x); 
		r= Math.sqrt(x*x + y*y);   
	}


	public double getR() {
		return r;
	}
	public double getTheta() {
		return theta;
	}



}
