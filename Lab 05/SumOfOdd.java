/*--------------------------------------------------------------*
 *  File Name: SumOfOdd.java                                    |
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Lab Number: 05                                              |
 *  Description: Computes the sum of the odd integers from 1 to |
 *    a user-input number n.					|
 *  Last Changed: 15-February-2013				|
 ---------------------------------------------------------------*/
import java.util.Scanner;
public class SumOfOdd {
  public static void main(String[] args) {
    int sumOfOdd = 0;
    int keepTrack = 1;
    Scanner keyboard1 = new Scanner(System.in);

    System.out.print("Please input a positive integer as the end value: ");
    int sumUntil = keyboard1.nextInt();

    while (keepTrack <= sumUntil) {
      sumOfOdd += keepTrack;
      keepTrack += 2;
    }

    System.out.print("\nThe summation is: " + sumOfOdd);
  }
}
