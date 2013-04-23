package JFrameAnimation;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JComponent;

/*--------------------------------------------------------------*
 *  File Name: MySphereTest.java								|
 *  Author: Anthony Davis St. Aubin								|
 *  KUID: 2482383												|
 *  Email Address: a162s797@ku.edu								|
 *  Lab Number: 09												|
 *  Description: Defines an Object, Character, that has:		|
 *    eight instanced variables:								|
 *		int x; int y;											|
 *		double speed; 											|
 *		int minSpeed = 0; int maxSpeed = 50;					|
 *		Colors colorBlade, colorHilt, colorPommel;				|
 *		Random random;											|
 *    eight methods:											|
 *    	draw(Graphics)											|
 *    	  to draw the character;								|
 *    	moveLeft, moveRight, moveUp, moveDown(JComponent)		|
 *    	  to change the location of the character;				|
 *    	incSpeed, decSpeed(double)								|
 *    	  to change the movement rate of the character;			|
 *    	changeColors											|
 *    	  to change the colors of the blade, hilt, and pommel	|
 *    The object drawn, in this case, is a sword;				|
 *  File Created: April 9, 2013									|
 *  Last Changed: April 9, 2013									|
 ---------------------------------------------------------------*/

public class Character {
	private int x;
	private int y;
	private int width;
	private int height;
	private double speed;
	private static int minSpeed = 0;
	private static int maxSpeed = 50;
	private Color colorBlade;
	private Color colorHilt;
	private Color colorPommel;
	private Random random = new Random();
	

	public Character(int xIn, int yIn, double speedIn) { // Constructor;
		x = xIn; //initial draw x-Coordinate;
		y = yIn; //initial draw y-Coordinate;
		speed = speedIn; //initial movement speed;
		//initial color configuration for the sword;
		colorBlade = Color.darkGray;
		colorHilt = Color.lightGray;
		colorPommel = Color.cyan;
	}
	
	public void draw(Graphics canvas) {
		//create two arrays to represent the tip of sword;
		int[] xTipArray = new int[3]; int[] yTipArray = new int[3];
		xTipArray[0] = this.x + 15; xTipArray[1] = this.x + 25; xTipArray[2] = this.x + 35;
		yTipArray[0] = this.y + 10; yTipArray[1] = this.y; yTipArray[2] = this.y + 10;
		//draw the sword;
		canvas.setColor(this.colorBlade);
		canvas.fillRect(this.x+15, this.y+10, 20, 80);
		canvas.fillPolygon(xTipArray, yTipArray, 3);
		canvas.setColor(this.colorHilt);
		canvas.fillRect(this.x + 5, this.y + 90, 40, 10);
		canvas.fillRect(this.x + 20, this.y + 100, 10, 20);
		canvas.fillOval(this.x + 16, this.y + 115, 17, 22);
		canvas.setColor(this.colorPommel);
		canvas.fillOval(this.x + 20, this.y + 121, 10, 12);
		//set object size for movement constraints;
		this.width = 50;
		this.height = 138;
		
	}
	
	/* moveLeft, moveRight, moveUp, and moveDown
	 * each move the sword around the screen if 
	 * and only if there is room to move;
	 */
	public void moveLeft(JComponent canvas) {
		if(speed > x) x = 0;
		else x -= speed;
		draw(canvas.getGraphics());
	}
	public void moveRight(JComponent canvas) {
		int xMax = canvas.getWidth() - this.width;
		if(speed + x > xMax) x = xMax;
		else x += speed;
		draw(canvas.getGraphics());
	}
	public void moveUp(JComponent canvas) {
		if(speed > y) y = 0;
		else y -= speed;
		draw(canvas.getGraphics());
	}
	public void moveDown(JComponent canvas) {
		int yMax = canvas.getHeight() - this.height;
		if(speed + y > yMax) y = yMax;
		else y += speed;
		draw(canvas.getGraphics());
	}
	
	/* incSpeed and decSpeed
	 * increase and decrease the value of speed
	 * if and only if the change would keep the 
	 * value of speed between minSpeed and 
	 * maxSpeed;
	 */
	public void incSpeed(double val) {
		if(val+speed>maxSpeed) speed = maxSpeed;
		else speed += val;
	}
	public void decSpeed(double val) {
		if(val>minSpeed) speed = 0;
		else speed -= val;
	}
	
	/* changeColors
	 * randomly generates new colors for the Blade,
	 * Hilt, and Pommel in a way that preserves the
	 * aesthetic of the sword;
	 */
	public void changeColors() {
		float bladeCenter = 0.1f + 0.25f*random.nextFloat();
		colorBlade = new Color(bladeCenter + 0.05f*random.nextFloat(), bladeCenter + 0.05f*random.nextFloat(), bladeCenter + 0.05f*random.nextFloat());
		colorHilt = new Color(0.45f*random.nextFloat(), 0.35f*random.nextFloat(), 0.4f*random.nextFloat());
		colorPommel = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()).brighter();
	}
}
