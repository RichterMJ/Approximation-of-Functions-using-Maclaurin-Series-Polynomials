
public class polynomial extends function {
	// Stores the coefficients
	double[] coef;
	
	// Creates the polynomial
	polynomial(double[] window, double[] coef){
		super(window);
		this.coef = coef;
		calcFunction();
	}
	
	// Calculates the x and y arrays so we can plot the points
	public void calcFunction() {
		// X is the minimum x plus the index of the array times a fraction of the distance between the minimum and maximum x
		// This allows us to increase x by a fraction of the x width for each increment in the x array
		for(int i = 0; i < this.x.length; i++) {
			this.x[i] = this.xmin + i*((this.xmax-this.xmin) / this.x.length);
			
			// For each y value, it evaluates the value for every term in the polynomial and adds it to y
			for(int j = 0; j < coef.length; j++) {
				this.y[i] += coef[j] * Math.pow(this.x[i], j);
			}
		}
		
	}
	
}
