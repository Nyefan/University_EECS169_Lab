/* -----------------------------------------------------------------------------
 *
 * File Name:  	ConvertTemperature.java
 * Author: 	Davis St. Aubin; a162s797@ku.edu
 * Assignment:  EECS-169 Lab 02
 * Description: Converts user-input temperature from Fahrenheit to Celcius
 * Date: 5-February-2013
 *
 ---------------------------------------------------------------------------- */

import java.util.Scanner;

public class ConvertTemperature {
	public static void main(String[] args) {
		

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the temperature in Fahrenheit:\n");
		double tempin = input.nextDouble();
		double tempout = (tempin - 32)*5/9;
		System.out.println(tempin + " degrees Fahrenheit = " + tempout + " degrees Celcius.");
	}
}
