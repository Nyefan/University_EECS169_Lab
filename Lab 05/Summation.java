/*--------------------------------------------------------------*
 *  File Name: Summation.java                                   |
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Lab Number: 05                                              |
 *  Description: Computes the sum of the integers from a user-	|
 *    input sumFrom to a user-input sumTo.|			|
 *  Last Changed: 15-February-2013				|
 ---------------------------------------------------------------*/
import java.util.Scanner;
public class Summation {
  public static void main(String[] args) {

    Scanner keyboard1 = new Scanner(System.in);
    int sumFrom;
    int sumTo;
    int sumOut;

    System.out.println("Welcome! This program calculates the summation of consecutive integers.\n");

    do {
      System.out.print("Please enter a positive integer as the initial value: ");
      sumFrom = keyboard1.nextInt();
      if(sumFrom<0) {System.out.println("\nThat is not a positive integer.");}
    } while(sumFrom<0);

    do {
      System.out.print("Please enter a positive integer for the final value:");
      sumTo = keyboard1.nextInt();
      if (sumTo<sumFrom) {System.out.println("\nThat end value is invalid.");}
    } while(sumTo<sumFrom);

    for(sumOut = 0; sumFrom <= sumTo; sumFrom++) {
      sumOut += sumFrom;
    }

    System.out.printf("\nThe summation is: %d\n\n", sumOut);
  }
}
