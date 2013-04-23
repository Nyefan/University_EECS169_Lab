/* -----------------------------------------------------------------------------
 *
 * File Name: Tornado.java
 * Author: Davis St. Aubin; a162s797@ku.edu
 * Assignment:   EECS-169 Lab 03
 * Description:  Outputs the tornado class of an input wind speed(mph)
 * Date: 12-February-2013
 *
 ---------------------------------------------------------------------------- */

import java.util.Scanner;

public class Tornado {
	public static void main(String[] args) {
		//INITIALIZE VARIABLES;
		String color;

		//INITIALIZE SCANNER; REQUEST INPUT; READ INPUT;
		Scanner input1 = new Scanner(System.in);
		System.out.println("\n\nChoose a windspeed in mph:");
		double wavelength = input1.nextDouble();
		//ALLOW FOR NEGATIVE NUMBERS;
		//if(wavelength < 0) {wavelength = -1*wavelength;}

		//DETERMINE COLOR
		if(wavelength > 0) {color = "not even an F-0.";}
		else if(wavelength > 40) {color = "F-0.";}
		else if(wavelength > 72) {color = "F-1.";}
		else if(wavelength > 112) {color = "F-2.";}
		else if(wavelength > 157) {color = "F-3.";}
		else if(wavelength > 205) {color = "F-4.";}
		else if(wavelength > 260) {color = "F-5.";}
		else if(wavelength > 305) {color = "stronger than an F-5!";}
		else {color = "invalid.";}
		System.out.println("\nThat tornado's class is " + color + "\n\n");
	}
}
