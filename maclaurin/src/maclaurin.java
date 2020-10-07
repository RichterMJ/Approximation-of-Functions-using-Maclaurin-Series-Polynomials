
public class maclaurin extends function{
	// Stores the type of maclaurin and how many terms will be used to approximate the function
	public int[] maclaurinTerms;
	
	// Creates the Maclaurin function
	maclaurin(double[] window, int[] maclaurinTerms){
		super(window);
		this.maclaurinTerms = maclaurinTerms;
		calcFunction();
	}

	// Calculates the x and y arrays so we can plot the points
	public void calcFunction() {
		for(int i = 0; i < this.x.length; i++) {
			// X is the minimum x plus the index of the array times a fraction of the distance between the minimum and maximum x
			// This allows us to increase x by a fraction of the x width for each increment in the x array
			this.x[i] = this.xmin + i*((this.xmax-this.xmin) / this.x.length);
			
			// The switch case identifies which type of maclaurin function it is and evaluates y for that function
			switch (maclaurinTerms[0]) {
				case 1:
					// sin maclaurin
					 for(int j = 0; j < maclaurinTerms[1]; j++) {
						 this.y[i] += (Math.pow(-1, j) * Math.pow(this.x[i], 2 * j + 1) )/(factorial(2 * j + 1)); 
					 }
					break;
				case 2:
					// cos maclaurin
					for(int j = 0; j < maclaurinTerms[1]; j++) {
						 this.y[i] += (Math.pow(-1, j) * Math.pow(this.x[i], 2 * j) )/(factorial(2 * j)); 
					 }
					break;
				case 3:
					//e^x maclaurin
					for(int j = 0; j < maclaurinTerms[1]; j++) {
						 this.y[i] += Math.pow(this.x[i], j)/(factorial(j)); 
					 }
					break;
				case 4:
					// 1/(1-x) maclaurin
					for(int j = 0; j < maclaurinTerms[1]; j++) {
						 this.y[i] += Math.pow(this.x[i], j); 
					 }
					break;
				case 5:
					// ln(1+x) maclaurin
					for(int j = 1; j <= maclaurinTerms[1]; j++) {
						 this.y[i] += Math.pow(-1,j-1) * (Math.pow(this.x[i], j)/(j)); 
					 }
					break;
				default:
					break;
			}
			
		}
		
	}
	
	// Calculates the factorial of n
	public static int factorial(int n) {
		int sum = 1;
		for (int i = n; i >= 1; i--) {
			sum *= i;
		}
		return sum;
	}
	
}
