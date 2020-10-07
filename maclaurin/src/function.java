
public class function {
	public double xmin;
	public double xmax;
	public double ymin;
	public double ymax;
	public double[] x;
	public double[] y;
	
	public function(double[] window) {
		this.xmin = window[0];
		this.xmax = window[1];
		this.ymin = window[2];
		this.ymax = window[3];
		// x and y are arrays that hold a 1000 values to approximate the curve on a graph
		x = new double[1000];
		y = new double[1000];
	}
	
	// Prints the coordinates in [x,y] format
	public void print() {
		for(int i = 0; i < x.length; i++)
		System.out.print("["+x[i]+","+y[i]+"]\n");
	}
	
}
