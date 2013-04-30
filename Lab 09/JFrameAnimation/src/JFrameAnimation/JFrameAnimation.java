package JFrameAnimation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


/* -----------------------------------------------------------------------------
*
* File Name:  JFrameAnimation.java
* Author: Meeyoung Park & Anthony Davis St. Aubin 
* Assignment:   EECS-168/169 Lab 9
* Description:  This program creates a JFrame with a JPanel with a Character 
* object being drawn.
*
---------------------------------------------------------------------------- */

public class JFrameAnimation extends JFrame implements ActionListener{
 
    private static final long serialVersionUID = -6802627392222008997L;
    MyJPanel animationPanel;
    Character player;
    Timer timer;
    
    //JFrameAnimation Constructor
    public JFrameAnimation(){
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("JFrameAnimation");
        timer = new Timer(15,this);
        player = new Character(10,10,5);
    }
    
    //This method gets called every 15 milliseconds from the timer
    //If you want animation call your method here
    @Override
    public void actionPerformed(ActionEvent e) {
        animationPanel.repaint();
        animationPanel.revalidate();
    }
    
    public void play(){
    	//Create the modified JPanel and set the size   	
        animationPanel = new MyJPanel();
        animationPanel.setPreferredSize(new Dimension(600,600));
            
        //Register the Mouse and Key listeners with the JFrame
        this.addMouseListener(animationPanel);
        this.addMouseMotionListener(animationPanel);
        this.addKeyListener(animationPanel);

        //Add the modified panel to the JFrame
        this.add(animationPanel);

        //Make sure it is visible
        this.setVisible(true);
        this.pack();
        
        //Start the timer so that we redraw every 15 milliseconds
        timer.start();
        
    }
    
    /**Create our JFrame and have it play
     * @param args
     */
    public static void main(String[] args) {

        JFrameAnimation j = new JFrameAnimation();
        
        j.play();
    }


    //This is a private class. It doesn't exist outside of this file
    // We create a JPanel that listens to the mouse and keys
    private class MyJPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener{

        private static final long serialVersionUID = -4833677924626085778L;

        //We override the original paint method for JPanel and draw our object
        public void paintComponent (Graphics g)  
        {
            //clear the screen
            g.setColor (Color.white);
            g.fillRect (0, 0, animationPanel.getWidth(),animationPanel.getHeight()); 
            
            //draw our object
            player.draw(g);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        	player.changeColors();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }

		@Override
		public void keyPressed(KeyEvent e) {
		    /*Check to see which key is pressed
		    * If the key is one of the cursor keys
		    * or the += or -_ keys then do something
		    */
			if (e.getKeyCode() == KeyEvent.VK_LEFT){
				player.moveLeft(this);
				System.out.println("Moving LEFT");

			}else if ( e.getKeyCode() == KeyEvent.VK_RIGHT){
				player.moveRight(this);
				System.out.println("Moving RIGHT");

			}else if ( e.getKeyCode() == KeyEvent.VK_DOWN){
				player.moveDown(this);
				System.out.println("Moving DOWN");

			}else if ( e.getKeyCode() == KeyEvent.VK_UP){
				player.moveUp(this);
				System.out.println("Moving UP");
			}else if ( e.getKeyCode() == KeyEvent.VK_EQUALS || e.getKeyCode() == KeyEvent.VK_PLUS){
				player.incSpeed(1.5);
				System.out.println("Speed UP");

			}else if ( e.getKeyCode() == KeyEvent.VK_MINUS || e.getKeyCode() == KeyEvent.VK_UNDERSCORE){
				player.decSpeed(1.5);
				System.out.println("Speed DOWN");

			}
				
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
	
		}


    }


}
