/* -----------------------------------------------------------------------------
 *
 * File Name: Color.java
 * Author: Davis St. Aubin; a162s797@ku.edu
 * Assignment:   EECS-169 Lab 03
 * Description:  Outputs the color of an input wavelength(nm).
 * Date: 12-February-2013
 *
 ---------------------------------------------------------------------------- */

import java.util.Scanner;

public class Color {
	public static void main(String[] args) {
		//INITIALIZE VARIABLES
		String color;
		String error = "outside the visible spectrum.";
		//INITIALIZE SCANNER; REQUEST INPUT; READ INPUT;
		Scanner input1 = new Scanner(System.in);
		System.out.println("\n\nChoose a wavelength in nanometers:");
		double wavelength = input1.nextDouble();
		//ALLOW FOR NEGATIVE NUMBERS;
		//if(wavelength < 0) {wavelength = -1*wavelength;}

		//DETERMINE FUJITA VALUE;
		if(wavelength > 0) {
			if(wavelength > 380) {
				if(wavelength > 450) {
					if(wavelength > 495) {
						if(wavelength > 570) {
							if(wavelength > 590) {
								if(wavelength > 620) {
									if(wavelength > 750) {color = error;}
									else {color = "red.";}
								}
								else {color = "orange.";}
							}
							else {color = "yellow.";}
						}
						else {color = "green.";}
					}
					else {color = "blue.";}
				}
				else {color = "violet.";}
			}
			else {color = error;}
		}
		else {color = "invalid";}

		//PRINT RESULT
		System.out.println("\nThat wavelength is " + color + "\n\n");
	}
}
