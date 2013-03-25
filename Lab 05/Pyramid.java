/*--------------------------------------------------------------*
 *  File Name: Factorial.java                                   |
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Lab Number: 05                                              |
 *  Description: Outputs a triangle of asterisks of user-input	|
 *    size triangleSize						|
 *  Last Changed: 15-February-2013				|
 ---------------------------------------------------------------*/
import java.util.Scanner;
public class Pyramid {
  public static void main(String[] args) {

    Scanner keyboard1 = new Scanner(System.in);

    System.out.print("Please enter the number of rows: ");
    int numberRows = keyboard1.nextInt();

    for(int ii = 1; ii <= numberRows; ii++) {
      System.out.println("");
      for(int jj = 1; jj <= ii; jj++) {
	System.out.print("*");
      }
      //System.out.println("");
    }
  }
}
