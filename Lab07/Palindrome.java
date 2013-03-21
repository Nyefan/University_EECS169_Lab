import java.util.Scanner;
import java.lang.Math;

public class Palindrome {
	static Scanner keyboard01 = new Scanner(System.in);
	public static void main(String[] args) {
		
		do {
			System.out.println("\nPlease enter a No:");
			
			if (isPalindrome(keyboard01.nextInt())) {//Note[01];
				System.out.println("The Number is a palindrome.");
				}
			else {System.out.println("The Number is not a palindrome.");}
			
		} while (checkShouldLoop()); //Asks the user whether to rerun the program
		
		
	}
	
	public static boolean isPalindrome(int x) { //Note[01];
		if (x == reverse(x)) {return true;}
		else {return false;}
	}
	
	public static int reverse(int x) { //Note[01];
		int numberLength = lengthOfNumber(x)-1; //Note[02];
		String inputNumber = String.valueOf(x);
		String reverseNumber = "";
		for(int ii = 0; ii < numberLength+1; ii++) {
			reverseNumber += inputNumber.charAt(numberLength-ii);
		}
		System.out.println("The Reverse of the Number is:" + reverseNumber);
		return Integer.parseInt(reverseNumber);
	}
	
	public static int lengthOfNumber(int x) { 
		int ii=1;
		while(Math.pow(10,ii)<x) { //finds the smallest power of 10 that will not fit into x;
			ii++;
		}
		System.out.println("The Length of the Number is:" + ii);
		return ii;
	}
	
	public static boolean checkShouldLoop() { //Note[01];
		System.out.println("\nIt was fun, right?!  Want to do it again? (y=1/n=0)");
		char chkChar = keyboard01.next().charAt(0);
		
		if (chkChar == '1' || chkChar == 'y' || chkChar == 'Y') {return true;}
		else if (chkChar == '0' || chkChar == 'n' || chkChar == 'N') {
			System.out.println("Thank you!");
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
 * isPalindrome.01
 * 		It is likely that this could be made more efficient for the majority of numbers (ie. 
 * 		non-palindromes) by removing the reverse function and enabling the function isPalindrome
 * 		to call lengthOfNumber and then alternate checking the first and last elements of the
 * 		equivalent string.
 * 
 * reverse.01
 * 		Reverses input number by converting it to a string and then concatenating the elements
 * 		of that string onto a new string in reversed order.
 * reverse.02
 * 		Subtracting 1 from the 'real' length of the inputNumber brings it in line with the 
 * 		index of the final digit in the String representation of the inputNumber.  This allows
 * 		for fewer operations when analyzing any number greater than 3 digits while maintaining
 * 		a < check in the for loop instead of the slower <= check.  It is undetermined whether
 * 		this is faster than a modulo operation that allows reverse and lengthOfNumber to both be
 * 		determined in the same for loop; however, it is suspected that the latter solution will 
 * 		simply be faster for smaller numbers and slower for larger numbers.
 * 
 * checkShouldLoop.01
 * 		KNOWN BUG: any input followed by a hard return will be processed according to its first
 * 		letter, resulting in entries like "yar" and "nargles" acting as 'y' and 'n' respectively
 */