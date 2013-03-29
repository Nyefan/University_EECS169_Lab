/*--------------------------------------------------------------*
 *  File Name: SumOfDigits.java                                 |
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 248****						|
 *  Email Address: a162s797@ku.edu				|
 *  Lab Number:  07                                             |
 *  Description: An introduction to methods; requests two 	|
 *    numbers from the user, adds the individual digits together|
 *    and outputs the result to the terminal.			|
 *  Last Changed: 26-March-2013					|
 ---------------------------------------------------------------*/

import java.util.Scanner;

public class SumOfDigits {
	static Scanner keyboard01 = new Scanner(System.in);
	public static void main(String[] args) {
		boolean shouldLoop = false;
		
		do {
			System.out.println("The sum of the digits is:" + addDigits(getInput())); // Note[01];
			shouldLoop = checkShouldLoop();
		} while (shouldLoop);
		
	}
	
	public static int getInput() { // Requests and returns a number from the user;
		System.out.println("Please enter a No:");
		return keyboard01.nextInt();
	}
	
	public static int addDigits(int x) { // Reterns the sum of the decimal digits in x;
		if (x>9) {
			int sum = x%10;
			x -= sum; x /= 10;
			sum += addDigits(x);
			return sum;
		}
		else {return x;}
	}
	
	public static boolean checkShouldLoop() { // checkShouldLoop[01];
		System.out.println("\nIt was fun, right?!  Want to do it again? (y=1/n=0)");
		char chkChar = keyboard01.next().charAt(0);
		
		if (chkChar == '1' || chkChar == 'y' || chkChar == 'Y') {return true;}
		else if (chkChar == '0' || chkChar == 'n' || chkChar == 'N') {
			System.out.println("\nThank you!");
			return false;
		}
		else {
			System.out.println("That was an invalid selection; please try again!");
			return checkShouldLoop();
		}
	}
	
}

/**--------------------------------------------NOTES--------------------------------------------
 * main.01
 * 		This syntax is chosen to remove a variable assignment because the variable, if created,
 * 		would only be called once.
 * 
 * checkShouldLoop.01
 * 		KNOWN BUG: any input followed by a hard return will be processed according to its first
 * 		letter, resulting in entries like "yar" and "nargles" acting as 'y' and 'n' respectively
 */
