
public class trig extends function {
	// Used to store the type of trigonometric function and the transformations to the trigonometric function
	double[] trigTransformations;
	
	// Creates the trigonometric function
	trig(double[] window, double[] trigTransformations){
		super(window);
		this.trigTransformations = trigTransformations;
		calcFunction();
	}
	
	// Calculates the x and y arrays so we can plot the points
	public void calcFunction() {
		// Goes through to set every x and y element
		for(int i = 0; i < this.x.length; i++) {
			// X is the minimum x plus the index of the array times a fraction of the distance between the minimum and maximum x
			// This allows us to increase x by a fraction of the x width for each increment in the x array
			this.x[i] = this.xmin + i*((this.xmax-this.xmin) / this.x.length);
			
			// The switch case identifies which type of trigonometric function it is and evaluates y for that function
			switch ((int) trigTransformations[0]) {
				case 1:
					this.y[i] = trigTransformations[1] * Math.sin( (trigTransformations[4]/(2 * Math.PI)) * this.x[i] - trigTransformations[2]) + trigTransformations[3];
					break;
				case 2:
					this.y[i] = trigTransformations[1] * Math.cos( (trigTransformations[4]/(2 * Math.PI)) * this.x[i] - trigTransformations[2]) + trigTransformations[3];
					break;
				case 3:
					this.y[i] = trigTransformations[1] * Math.tan( (trigTransformations[4]/(1 * Math.PI)) * this.x[i] - trigTransformations[2]) + trigTransformations[3];
					break;
				default:
					break;
			}
			
		}
		
	}
	
}
