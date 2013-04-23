/* -----------------------------------------------------------------------------
 *
 * File Name:  ComputeCircleArea.java
 * Author: Davis St. Aubin; a162s797@ku.edu
 * Assignment:   EECS-169 Lab 02
 * Description:  This program will compute the area of the circle, where the radius is received
 *                      from the user.
 * Date: 5-February-2013
 *
 ---------------------------------------------------------------------------- */

import java.util.Scanner;

public class ComputeCircleArea
{
       public static void main(String[] args)
      {
			//Declare the variables and constants.
			double PI = 3.141592;

            //Read the input from the keyboard.
            Scanner input = new Scanner(System.in);  //sets up things to accept keyboard input
            System.out.println("Enter the number for radius:");
            double radius = input.nextDouble();   //reads one real number from the keyboard

            double area = PI*radius*radius ;
              
            //Display the output
            System.out.println("The area for the circle of radius " + radius + "m is " + area + "m^2.");
       }
}
