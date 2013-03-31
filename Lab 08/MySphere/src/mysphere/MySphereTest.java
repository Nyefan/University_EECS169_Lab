package mysphere;

import java.util.Scanner;

/*--------------------------------------------------------------*
 *  File Name: MySphereTest.java				|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Lab Number: 08						|
 *  Description: Tests the Object, MySphere, in an interactive	|
 *    way, requesting an input for MySphere's instanced		|
 *    variable, diameter, and outputing the results of each of	|
 *    MySphere's methods in an organized manner.		|
 *  File Created: Mar 29, 2013					|
 *  Last Changed: Mar 29, 2013					|
 ---------------------------------------------------------------*/

public class MySphereTest {
  private static Scanner keyboard01  = new Scanner(System.in);
  private MySphere myBall = new MySphere();

  public void main(String[] args) {

    //MySphere myBall = new MySphere();

    boolean shouldContinue;
    do {
      myBall.setDiameter(getInput());
      printStats(myBall);
      shouldContinue = checkShouldLoop();
    } while(shouldContinue == true);
  }

  private static double getInput() {
    System.out.print("Enter the diameter of the ball: ");
    return keyboard01.nextDouble();
  }

  private void printStats(MySphere myBall) {
    System.out.println("The diameter of the ball is " + myBall.getDiameter());
    System.out.printf("The volume is %7.2f\n", myBall.calculateVolume());
    System.out.printf("the surface area is %7.2f\n", myBall.calculateSurfaceArea());
  }

  private static boolean checkShouldLoop() { // Note[01];
    System.out.print("\nDo you want to try another ball?"
	    + "\nPlease enter 1 for Yes, 0 for No: ");
    //Grab the first character of the user's response for if/else checking
    char chkChar = keyboard01.next().charAt(0);

    if (chkChar == '1' || chkChar == 'y' || chkChar == 'Y') {return true;}
    else if (chkChar == '0' || chkChar == 'n' || chkChar == 'N') {
      System.out.println("\nGoodbye!");
      return false;
    }
    else {
      System.out.println("That was an invalid selection; please try again!");
      return checkShouldLoop();
    }
  }
}
