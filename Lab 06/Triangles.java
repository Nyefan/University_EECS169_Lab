/*--------------------------------------------------------------*
 *  File Name: Triangles.java									|
 *  Author: Anthony Davis St. Aubin								|
 *  KUID: 2482383												|
 *  Email Address: a162s797@ku.edu								|
 *  Lab Number: 06												|
 *  Description: Draws triangles to the screen in an Android 	|
 *  	environment that are centered wrt and fill the entire	|
 *  	bottom edge of the screen.  Users are given the options	|
 *  	to:														|
 *  		1. Add Triangles									|
 *  		2. Display randomly colored rows of triangles		|
 *  		3. Display randomly colored triangles				|
 *  		4. Display triangles that create a color gradient	|
 *  Last Changed: 12-March-2013									|
 ---------------------------------------------------------------|
 *  Base Code created by Justin Dawson (JDawson@ku.edu)			|
 ---------------------------------------------------------------*/


package edu.ku.eecs168.triangles;


import java.util.Random;
import java.lang.Math;

import android.graphics.Color;
import android.os.Bundle;


public class Triangles extends AbsTriangles {

    //private Random ranGenTriangles = new Random();
    private Random ranGen = new Random();
    private int numTriangles = ranGen.nextInt(10); // = 10;
    private int colorType;
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ranGen = new Random();
	}
	
	@Override
	public void onDialogReturned(int num) {
		numTriangles = num;
		repaint();
	}
	

    @Override
    public void colorRows() {
        colorType = 1;
        repaint();
    }

    @Override
    public void colorRandom() {
        colorType = 2;
        repaint();
    }

    @Override
    public void colorGradient() {
        colorType = 3;
        repaint();
    }
	
	// The setColor method of the Graphics class expects color to be specified as a single int.
	// This routine converts RGBalpha values into a single int that setColor can understand.
	// Specify the red, green, blue and alpha values as integers between 0 and 255.
	// Alpha is a transparency component - an alpha of 255 is fully opaque, 
	//   while an alpha of 0 is transparent.
	// The output of rgbToColor is an integer that is in the format expected by setColor,
	// which is specified by a hexidecimal value of the format 0xAARRGGBB
	public int rgbToColor(int red, int green, int blue, int alpha) {
		int color = 0;
		color += blue;
		color += 256*green;
		color += 256*256*red;
		color += 256*256*256*alpha;
		return color;
	}
	
	
	@Override
	public void paint(Graphics canvas) {
		//clear the screen before we draw;
		canvas.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		

		//Get size of screen and size of triangles to draw;
		int screenHeight = canvas.getHeight();
		int screenWidth = canvas.getWidth();
		int triangleSizeMax = Math.min(screenHeight, screenWidth); 	//Supports rotation of the screen
		int triangleSize = triangleSizeMax / numTriangles;			// for potential future iterations;
		
		//initialize the x, y coordinates;
		int x = 0; //left corner;
		int y = screenHeight; //bottom;
		
		
		//Draw triangles according to user-input numTriangles;
		
			
		if(colorType==1) { //colorRows;
			for(int ii = 0; ii < numTriangles; ii++) {	
				x = ii*triangleSize/2; 							//Calculate horizontal placement of first triangle in row jj;
				//canvas.setColor(rgbToColor(ranGen.nextInt(256), ranGen.nextInt(256), ranGen.nextInt(256), 155 + ranGen.nextInt(100))); //Generate random color for entire row;
				canvas.setColor(ranGen.nextInt(256*256*256*55) + 256*256*256*200);
				for(int jj = ii; jj < numTriangles; jj++) { 	//Draw Triangles;
					canvas.drawIsoTriangle(x, y, triangleSize, triangleSize);
					x+=triangleSize;
				}
				y -= triangleSize;  							//Calculate height for later triangles;
			}
		}
		
		else if(colorType==2) { //colorRandom;
			for(int ii = 0; ii < numTriangles; ii++) {	
				x = ii*triangleSize/2; 							//Calculate horizontal placement of first triangle in row ii;
				for(int jj = ii; jj < numTriangles; jj++) { 	//Draw Triangles;
					//canvas.setColor(rgbToColor(ranGen.nextInt(256), ranGen.nextInt(256), ranGen.nextInt(256), 155 + ranGen.nextInt(100))); //Generate random color for each individual triangle;
					canvas.setColor(ranGen.nextInt(256*256*256*55) + 256*256*256*200);
					canvas.drawIsoTriangle(x, y, triangleSize, triangleSize);
					x+=triangleSize;
				}
				y -= triangleSize;  							//Calculate height for later triangles;
			}
		}
		
		else if(colorType==3) { //colorGradient;
			int color = 0;
			int alpha = 245-ranGen.nextInt(50);
			int redPercent = 245-ranGen.nextInt(150);
			int greenPercent = 245-ranGen.nextInt(220);
			int bluePercent = 245-ranGen.nextInt(150);
			for(int ii = 0; ii < numTriangles; ii++) {	
				x = ii*triangleSize/2; 							//Calculate horizontal placement of first triangle in row ii;
				int percentY = 255*y/screenHeight; 			//Preparations for drawing yGradient;\
				for(int jj = ii; jj < numTriangles; jj++) { 	//Draw Triangles;
					int percentX = 255*x/triangleSizeMax; 		//Preparations for drawing xGradient;
					int red =  32 + 7*(redPercent*(percentX))/(8*256);  //Ensures red will be between 32 and 256;
					//int green = greenPercent;//32 + 7*(greenPercent*((percentX+percentY)/(2*8*256)));
					int blue =  32 + 7*(bluePercent*(percentY)/(8*256));
					color = (int) (blue + 256*greenPercent + 256*256*red + 256*256*256*alpha);
					//canvas.setColor(rgbToColor(red,green,blue,alpha));
					canvas.setColor((int) color);
					canvas.drawIsoTriangle(x, y, triangleSize, triangleSize);
					x+=triangleSize;
				}
				y -= triangleSize;  							//Calculate height for later triangles;
			}
		}
		
		else { //monoColor;
			canvas.setColor(rgbToColor(ranGen.nextInt(256), ranGen.nextInt(256), ranGen.nextInt(256), 155 + ranGen.nextInt(100))); //Generate random color for entire triangle;
			for(int ii = 0; ii < numTriangles; ii++) {	
				x = ii*triangleSize/2; 							//Calculate horizontal placement of first triangle in row ii;
				for(int jj = ii; jj < numTriangles; jj++) { 	//Draw Triangles;
					canvas.drawIsoTriangle(x, y, triangleSize, triangleSize);
					x+=triangleSize;
				}
				y -= triangleSize;  							//calculate height for later triangles;
			}
		}
		
	}
}
