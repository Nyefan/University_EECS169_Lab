package edu.ku.eecs168.circleArray;

import java.util.Random;

/*--------------------------------------------------------------*
 *  File Name: CircleArray.java									|
 *  Author: Anthony Davis St. Aubin								|
 *  KUID: 2482383												|
 *  Email Address: a162s797@ku.edu								|
 *  Lab Number: 10												|
 *  Description: Defines an Object, CircleArray, that handles 	|
 *	  the initialization and drawing of Circles on an android	|
 *	  OS;														|
 *    eight instanced variables:								|
 *		int circleDiamter; int nCircles;						|
 *		int[] X; int[] Y;										|
 *		int[] Color; boolean[] isFill; 							|
 *		int currentCircle; boolean isFirstTime;					|
 *		Random random;											|
 *    two public methods:										|
 *    	paint(Graphics)											|
 *    	  to draw the circles to the screen;					|
 *    	onDialogReturned(int)									|
 *    	  to handle user input;									|
 *  File Created: April 16, 2013								|
 *  Last Changed: April 16, 2013								|
 ---------------------------------------------------------------*/

public class CircleArray extends AbsCircleArray {
	private Random random;
	
	// Universal circle properties;
	private int circleDiameter;
	private int nCircles;
	// Individualized circle properties;
	private int[] X;
	private int[] Y;
	private int[] Color;
	private boolean[] isFill; // Determines draw type;
	// Bookkeeping variables;
	private int currentCircle;
	private boolean isFirstTime; 
	
	public CircleArray() {
		// Instantiate a Random object;
		random = new Random();
		
		// Declare universal circle properties;
		circleDiameter = 100;
		nCircles = 20;
		// Make room for individualized circle properties;
		X = new int[nCircles];
		Y = new int[nCircles];
		Color = new int[nCircles];
		isFill = new boolean[nCircles];
		// Declare bookkeeping variables
		currentCircle = 0;
		isFirstTime = false;
		
	}
	public CircleArray(int nCirc) {
		// Instantiate a Random object;
		random = new Random();

		// Declare universal circle properties;
		circleDiameter = 100;
		nCircles = nCirc;
		// Make room for individualized circle properties;
		X = new int[nCircles];
		Y = new int[nCircles];
		Color = new int[nCircles];
		isFill = new boolean[nCircles];
		// Declare bookkeeping variables
		currentCircle = 0;
		isFirstTime = false;
	}
	
	
	@Override
	// Paints circles to the canvas, according to the parameters X, Y, Color, isFill, as declared by the prepareCircle method;
	public void paint(Graphics canvas) {
		// Clear the canvas for future painting;
		canvas.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		//Prepares all of the circles to print to the screen when the program is initialized;
		if (!isFirstTime) {
			for(int i = 0; i < nCircles; i++) {
				prepareCircle(canvas, i);
			}
			isFirstTime = true;
		}
		
		//Moves the least recently adjusted circle to a new random location with a new random color;
		else {
			prepareCircle(canvas, currentCircle);
		}
		
		//Paints the circles to the screen; Multiple for loops ensure that the most recently painted circles remain on top;
		for(int i = currentCircle + 1; i < nCircles; i++) {
			paintCircle(canvas, i);
		}
		for(int i = 0; i <= currentCircle; i++) {
			paintCircle(canvas, i);
		}
		
		//Pushes currentCircle forward through the Arrays; resets currentCircle at the end of the cycle;
		currentCircle++;
		if(currentCircle==nCircles) {currentCircle = 0;}
	}
	// Private methods created to clean up Paint(Graphics);
	private void prepareCircle(Graphics canvas, int i) {
		// Chooses a random location on the canvas to paint circle number i;
		X[i] = random.nextInt(canvas.getWidth()-circleDiameter); 
		Y[i] = random.nextInt(canvas.getWidth()-circleDiameter);
		// Chooses a random color for circle number i;
		Color[i] = rgbToColor(random.nextInt(256),random.nextInt(256),random.nextInt(256),255);
		// Randomly selects whether circle number i will be an outline or a filled object;
		isFill[i] = (random.nextDouble() < 0.5);
	}
	private void paintCircle(Graphics canvas, int i) {
		if(isFill[i]) {
			canvas.setColor(Color[i]);
			canvas.fillOval(X[i], Y[i], circleDiameter, circleDiameter);
		}
		else {
			canvas.setColor(Color[i]);
			canvas.drawOval(X[i], Y[i], circleDiameter, circleDiameter);
		}
	}
	
	@Override
	// Called when the user uses the "Add Shapes" button to change the number of circles;
	public void onDialogReturned(int num) {
		// Must call super.onDialogReturned to start the simulation
		super.onDialogReturned(num);
		// Sets the number of circles drawn by the Paint(Graphics) method according to user input num;
		setNCircles(num);
		
	}
// Private method created to clean up onDialogReturned;
	private void setNCircles(int n) {
		// Refresh the CircleArray according to user input n;
		// Redeclare universal circle properties;
		nCircles = n;
		// Resize individualized circle properties;
		X = new int[nCircles];
		Y = new int[nCircles];
		Color = new int[nCircles];
		isFill = new boolean[nCircles];
		// Refresh bookkeeping variables
		currentCircle = 0;
		isFirstTime = false;
	}

	// The setColor method of the Graphics class expects color to be specified as a single int.
	// This routine converts RGBalpha values into a single int that setColor can understand.
	// Specify the red, green, blue and alpha values as integers between 0 and 255.
	// Alpha is a transparency component - an alpha of 255 is fully opaque, 
	//   while an alpha of 0 is transparent.
	// The output of rgbToColor is an integer that is in the format expected by setColor,
	// which is specified by a hexidecimal value of the format 0xAARRGGBB
	static public int rgbToColor(int red, int green, int blue, int alpha) {
		int color = 0;
		color += blue;
		color += 256*green;
		color += 256*256*red;
		color += 256*256*256*alpha;
		return color;
	}
}
