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
    boolean shouldContinue;
    
    do {
      myBall.setDiameter(getInput());     // Note[01];
      printStats(myBall);                 // Note[02];
      shouldContinue = checkShouldLoop(); // Note[03];
    } while(shouldContinue == true);
  }

  private static double getInput() {
    System.out.print("Enter the diameter of the ball: ");
    return keyboard01.nextDouble();
  }

  private void printStats(MySphere myBall) { //Note[main.02];
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

/**--------------------------------NOTES--------------------------------
 * main.01
 * 		Requests a diameter from the user and sets the myBall 
 * 		instance of mySphere's diameter to that value;
 * main.o2
 * 		Prints the diameter, volume, and surface area of myBall 
 * 		in an appropriate format;
 * main.03
 * 		Asks the user if they would like to continue using the 
 * 		program and returns an appropriate boolean value;
 * 
 * checkShouldLoop.01
 * 		KNOWN BUG: any input followed by a hard return will be 
 * 		processed according to its first letter, resulting in 
 * 		entries like "yar" and "nargles" acting as 'y' and 'n', 
 * 		respectively
 */
