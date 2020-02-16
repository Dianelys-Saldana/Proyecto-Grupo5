
public class PolartoCart {
	private double x;
	private double y;
	private double theta;
	private double r;
	public PolartoCart(double r,double theta) {
		this.r=r;
		this.theta=theta;
		x=r*Math.cos(theta);
		y=r*Math.sin(theta);
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
      

        
    


}
