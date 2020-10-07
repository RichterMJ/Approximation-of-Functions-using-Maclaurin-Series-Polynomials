
public class other extends function{
	// Stores the type of function
	public int type;
	
	// Creates the function
	other(double[] window, int type){
		super(window);
		this.type = type;
		calcFunction();
	}

	// Calculates the x and y arrays so we can plot the points
	public void calcFunction() {
		// X is the minimum x plus the index of the array times a fraction of the distance between the minimum and maximum x
		// This allows us to increase x by a fraction of the x width for each increment in the x array
		for(int i = 0; i < this.x.length; i++) {
			this.x[i] = this.xmin + i*((this.xmax-this.xmin) / this.x.length);
			
			// The switch case identifies which type of other function it is and evaluates y for that function
			switch (type) {
				case 1:
					// e^x case
					this.y[i] = Math.pow(Math.E, this.x[i]);
					break;
				case 2:
					// 1/(1-x) case
					this.y[i] = 1/(1-this.x[i]);
					break;
				case 3:
					//ln(1+x)
					this.y[i] = Math.log(1+this.x[i]); 
					break;
				default:
					break;
			}
			
		}
		
	}
	
}
