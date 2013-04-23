package edu.ku.eecs168.lab4;

import android.graphics.Color;
import edu.ku.swingemu.AndroidJApplet;

public class Lab4 extends AndroidJApplet {
	//The value of counter has been initialized to help keep track of current frame
	public int counter=0;
	@Override
	public void paint(Graphics canvas) {
                //increments the counter value by one (recall increment decrement operator in previous lab
			counter++;
                
                //the value of counter is now 1; so the following lines draws the smiley face on screen when counter=1 is true
			if(counter==1){
				canvas.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
				canvas.setColor(Color.YELLOW);
				canvas.fillOval(25, 50, 200, 200);
				canvas.setColor(Color.BLACK);
				canvas.fillOval(80, 100, 10, 20);
				canvas.fillOval(155, 100, 10, 20);		
				canvas.drawArc(75, 160, 100, 50, 180, 180);
			}
                //in the next refresh, the value of counter is 2. So, counter=1 is false and else statement is executed. we again set the
                //counter to 0. This forces the counter to rotate between 0 and 1.
			else{
				canvas.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
				canvas.setColor(Color.YELLOW);
				canvas.fillOval(250, 50, 200, 200);
				canvas.setColor(Color.BLACK);
				canvas.fillOval(305, 100, 10, 20);
				canvas.fillOval(380, 100, 10, 20);		
				canvas.drawArc(300, 160, 100, 50, 180, -180);		
				counter=0;
				}
                //this line clears the screen every time the screen is refreshed
			
	}
}
