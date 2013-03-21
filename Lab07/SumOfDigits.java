import java.util.Scanner;

public class SumOfDigits {
	static Scanner keyboard01 = new Scanner(System.in);
	public static void main(String[] args) {
		boolean shouldLoop = false;
		
		do {
			System.out.println("The sum of the digits is:" + addDigits(getInput()));
			shouldLoop = checkShouldLoop();
		} while (shouldLoop);
		
	}
	
	public static int getInput() {
		System.out.println("Please enter a No:");
		return keyboard01.nextInt();
	}
	
	public static int addDigits(int x) {
		if (x>9) {
			int sum = x%10;
			x -= sum; x /= 10;
			sum += addDigits(x);
			return sum;
		}
		else {return x;}
	}
	
	public static boolean checkShouldLoop() {
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
