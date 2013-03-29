/*--------------------------------------------------------------*
 *  File Name: AddSubtract.java                                 |
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 248****						|
 *  Email Address: a162s797@ku.edu				|
 *  Lab Number:  07                                             |
 *  Description: An introduction to methods; requests two	|
 *    integers from the user and outputs the sum in two 	|
 *    ways.							|
 *  Last Changed: 26-March-2013					|
 ---------------------------------------------------------------*/

import java.util.Scanner;

public class AddSubtract {
	static Scanner keyboard01 = new Scanner(System.in);
	public static void main(String[] args) {
		boolean shouldLoop = false;

		do {
			int x = getInput("1st");
			int y = getInput("2nd");
			addSubtractIntegers(x,y); // Note[01];

			// Note[02];
			System.out.println("" +
				"\nNow you are calling 2 different methods, addIntegers and subtractIntegers, which return values as");
			int sum = addIntegers(x,y);
			int diff = subtractIntegers(x,y);
			System.out.println("Sum=" + sum +
				"\nDifference=" + diff);

			shouldLoop = checkShouldLoop(); // Asks the user if they would like to continue looping;
		} while (shouldLoop);

	}

	public static void addSubtractIntegers(int x,int y) { // Prints the values of (x + y) and (x - y) with appropriate notifiers;
		int sum = addIntegers(x,y);
		int diff = subtractIntegers(x,y);
		System.out.println("You are inside the Method called addSubtractIntegers, where Sum=" + sum +
			" and Difference=" + diff);
	}

	public static int addIntegers(int x,int y) {
		return x + y;
	}

	public static int subtractIntegers(int x,int y) {
		return x - y;
	}

	public static int getInput(String x) { // Requests and returns the user's input
		System.out.println("Please enter the " + x + " No:");
		return keyboard01.nextInt();
	}

	public static boolean checkShouldLoop() { // Note[01];
		System.out.println("\nIt was fun, right?!  Want to do it again? (y=1/n=0)");
		char chkChar = keyboard01.next().charAt(0);

		if (chkChar == '1' || chkChar == 'y' || chkChar == 'Y') {return true;}
		else if (chkChar == '0' || chkChar == 'n' || chkChar == 'N') {
			System.out.println("\nEnough of Addition and Subtraction." +
				"I'm not in elementary school anymore!");
			return false;
		}
		else {
			System.out.println("That was an invalid selection; please try again!");
			return checkShouldLoop();
		}

	}
}

/**---------------------------------------NOTES---------------------------------
 * main.01
 * 		Outputs the sum and difference of x and y and notifies the user
 *		that the operation has been handled inside the method;
 * main.02
 * 		Outputs the sum and difference of x and y, notifying the user
 *		that the operations have been handled separately from within
 *		main;
 *
 * checkShouldLoop.01
 * 		KNOWN BUG: any input followed by a hard return will be processed
 *		according to its first letter, resulting in entries like "yar"
 *		and "nargles" acting as 'y' and 'n' respectively
 */
