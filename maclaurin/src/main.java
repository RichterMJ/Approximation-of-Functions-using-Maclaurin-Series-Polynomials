import java.util.ArrayList;
import java.util.Scanner;

/* Michael Richter
 * Approximation of functions using maclaurin series
 * Graphs polynomials, trigonometric functions and taylor series representations of different functions.
 */

public class main {
		
	public static void main(String[] args) {
		// Holds the number of each type of function the user wants to graph
		int poly = 0;
		int trig = 0;
		int maclaurin = 0;
		int other = 0;
		
		// Holds all the functions the user creates
		ArrayList<function> functionList = new ArrayList<function>();
		
		// Gets the window for the graph
		double[] window = findWindow();
	
		// Sets up scanner
		Scanner s = new Scanner(System.in);
		
		// Asks user what they want to graph
		System.out.println("Menu \n1. Add Polynomial \n2. Add trig function\n3. Add Maclaurin function\n4. Add other functions(e^x, 1/(1-x), ln(1+x))\n5. Graph functions\n");
		int option = s.nextInt();
		
		// Runs a while loop to continue asking what they want to graph, until they select the graph option
		while(option != 5) {
			switch (option) {
				
				case 1:
					// Polynomial Case
					// Asks how many polynomials the user want to graph
					System.out.println("How many polynomial functions would you like to graph?\n");
					poly += s.nextInt();
					
					// Runs for loop for the user to create each function
					for (int i = 0; i < poly; i++) {
						System.out.println("For polynomial #" + (i + 1) +",\n");
						double[] coef = createPoly();
						polynomial p = new polynomial(window, coef);
						functionList.add(p);
					}
					break;
				
				case 2:
					// Trigonometric function case
					// Asks how many trigonometric functions the user want to graph
					System.out.println("How many trig functions would you like to graph?\n");
					trig += s.nextInt();
					
					// Runs for loop for the user to create each function
					for (int i = 0; i < trig; i++) {
						System.out.println("For trigonometric function #" + (i + 1) +",\n");
						double[] trigTransformations = createTrig();
						trig t = new trig(window, trigTransformations);
						functionList.add(t);
					}
					break;
				
				case 3: 
					// Maclaurin Series Case
					// Asks how many Maclaurin series functions the user want to graph
					System.out.println("How many Maclaurin functions would you like to graph?\n");
					maclaurin += s.nextInt();
					
					// Runs for loop for the user to create each function
					for (int i = 0; i < maclaurin; i++) {
						System.out.println("For Maclaurin series function #" + (i + 1) +",\n");
						int[] maclaurinTerms = createMaclaurin();
						maclaurin m = new maclaurin(window, maclaurinTerms);
						functionList.add(m);
					}
					break;
					
				case 4:
					// Other function case
					// Asks how many other functions the user want to graph
					System.out.println("How many other functions would you like to graph?\n");
					other += s.nextInt();
					
					// Runs for loop for the user to create each function
					for (int i = 0; i < other; i++) {
						System.out.println("For function #" + (i + 1) +",\n");
						int type = createOtherFunction();
						other o = new other(window, type);
						functionList.add(o);
					}
					
				case 5:
					// Graph Case
					// If the user selects graph, then break out of switch case.
					break;
				default:
					// Break the switch case if the user entered an incorrect option
					break;
			}
			
			// Reprint option till they graph functions
			System.out.println("Menu \n1. Add Polynomial \n2. Add trig function\n3. Add Maclaurin function\n4. Add other functions(e^x, 1/(1-x), ln(1+x))\n5. Graph functions\n");
			option = s.nextInt();
		}
		// Set up the graph, and graph the functions
		setupGraph(window);
		for (int i = 0; i < functionList.size(); i++) {
			graph(functionList.get(i));
		}
		// End of main
	}
	
	// Other Functions
	
	
	// Graphs each function using a line to approximate the function between each point in the x and y array
	public static void graph(function f) {
		for (int i = 0; i < f.x.length-1; i++) {
			StdDraw.line(f.x[i], f.y[i], f.x[i+1], f.y[i+1]);
		}
		
	}
	
	
	// Asks the user for the terms and coefficients for a polynomial function, and returns an array with this information
	public static double[] createPoly() {
		Scanner s = new Scanner(System.in);
		
		// Asks for how many terms the polynomial is
		System.out.println("What is the degree of the polynomial\n");
		int terms = s.nextInt();
		
		// Creates a double array for the coefficients of the polynomial
		double[] coef = new double[terms];
		
		// Gets the coefficient of each term
		double num;
		for(int i = 0; i < terms; i++) {
			System.out.println("What is the coefficient of the x^"+i+" term?\n");
			num = s.nextDouble();
			coef[i] = num; // c+bx+ax^2
		}
		return coef;
	}
	
	
	// Asks the user for the type of polynomial function, along with the transformations to a trig function, and returns an array with this information
	public static double[] createTrig() {
		// sin function: a * sin(bx+c)+d (period=2pi/b)
		// cos function: a * cos(bx+c)+d (period=2pi/b)
		// tan function: a * tan(bx+c)+d (period=pi/b)
		
		Scanner s = new Scanner(System.in);
		
		// Gets type of function
		System.out.println("What type of Trigonometric function is it?\n1.Sin\n2.Cos\n3.tan\n");
		double type = s.nextDouble();
		
		// Gets amplitude of function
		System.out.println("What is the amplitude?\n");
		double amp = s.nextDouble();
		
		// Gets horizontal translation of function
		System.out.println("What is the horizontal translation (+ is moving right, - is moving left)?\n");
		double hTranslation = s.nextDouble();
	
		// Gets vertical translation of function
		System.out.println("What is the vertical translation?\n");
		double yTranslation = s.nextDouble();
		
		// Gets period of function
		System.out.println("What is the period of the function(usually 2 * pi or 6.24)?\n");
		double period = s.nextDouble();
		
		// Adds all the trigonometric transformations to an array
		double[] trigTransformations = {type, amp, hTranslation, yTranslation, period};
		
		return trigTransformations;
		
	}
	
	
	// Asks for what type of Maclaurin function the user wants to graph, then asks for how many functions they want to use to approximate it
	public static int[] createMaclaurin() {
		
		// Gets the type of Maclaurin function 
		Scanner s = new Scanner(System.in);
		System.out.println("What type of maclaurin function would you like to graph?\n1.Sin \n2.Cos \n3.e^x \n4.1/(1-x) (-1 < x < 1) \n5.ln(1+x) (-1 < x < 1)\n");
		int type = s.nextInt();
		
		// Gets the number of terms
		System.out.println("How many terms would you like to use to approximate the function?\n");
		int terms = s.nextInt();
		
		// Returns information in an array
		int[] maclaurinTerms = {type, terms};
		return maclaurinTerms;
	}
	
	// Asks user what type of other function the user wants to graph and returns info
	public static int createOtherFunction() {
		Scanner s = new Scanner(System.in);
		System.out.println("What type of function would you like to graph?\n1.e^x \n2.1/(1-x) \n3.ln(1+x)\n");
		int type = s.nextInt();
		return type;
	}
	
	
	// Asks user for the window of the graph, then returns this information so it can be used in creating each function
	public static double[] findWindow() {
		Scanner s = new Scanner(System.in);
		double xmin;
		double xmax;
		double ymin;
		double ymax;
		
		System.out.println("For the graph window,\n");
		System.out.println("enter a min x, max x, min y and max y (seperated with spaces)\n");
		xmin = s.nextDouble();
		xmax = s.nextDouble();
		ymin = s.nextDouble();
		ymax = s.nextDouble();
		double[] window = {xmin, xmax, ymin, ymax};
		return window;
		
	}
	
	
	// Sets up graph by setting the scale, adding the x and y axis, and adding scale lines to the graph 
	public static void setupGraph(double[] window) {
		//sets up new window
		StdDraw.setCanvasSize(800,800);
		StdDraw.setXscale(window[0], window[1]);
		StdDraw.setYscale(window[2], window[3]);
		StdDraw.clear();
		
		
		//sets up x and y axis
		StdDraw.line(window[0], 0, window[1], 0); //y axis
		StdDraw.line(0, window[2], 0, window[3]); //x axis
		
		// Draw perpendicular lines on each axis(with each whole number as an interval) to show scale
		for (int i = 0; i < 1000; i++) {
			double x = window[0] + (i * ((window[1] - window[0])/1000));
			double y = window[2] + (i * ((window[3] - window[2])/1000));
			if (x % 1 == 0) {
				StdDraw.line(x, -((window[3]-window[2])/30), x, ((window[3]-window[2])/30));
				StdDraw.text(x,((window[3]-window[2])/25) , ""+(int)x);
			}
			
			if(y % 1 == 0) {
				StdDraw.line(-((window[1]-window[0])/30), y, ((window[1]-window[0])/30), y);
				StdDraw.text(-((window[1]-window[0])/25), y , ""+(int)y);
			}
			
		}
	}
}
