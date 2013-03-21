import java.util.Scanner;

public class AddSubtract {
	static Scanner keyboard01 = new Scanner(System.in);
	public static void main(String[] args) { 
		boolean shouldLoop = false;
		
		do {
			int x = getInput("1st");
			int y = getInput("2nd");
			addSubtractIntegers(x,y);
		
			System.out.println("\nNow you are calling 2 different methods, add and sub, which return values as");
			int sum = addIntegers(x,y);
			int diff = subtractIntegers(x,y);
			System.out.println("Sum=" + sum + "\nDifference=" + diff);
		
			shouldLoop = checkShouldLoop();
		} while (shouldLoop);
		
	}
	
	public static void addSubtractIntegers(int x,int y) {
		int sum = addIntegers(x,y);
		int diff = subtractIntegers(x,y);
		System.out.println("You are inside the Method called addSub, where Sum=" + sum + " and Difference=" + diff);
	}
	
	public static int addIntegers(int x,int y) {
		return x + y;
	}

	public static int subtractIntegers(int x,int y) {
		return x - y;
	}
	
	public static int getInput(String x) {
		System.out.println("Please enter the " + x + " No:");
		return keyboard01.nextInt();
	}
	
	public static boolean checkShouldLoop() {
		System.out.println("\nIt was fun, right?!  Want to do it again? (y=1/n=0)");
		char chkChar = keyboard01.next().charAt(0);
		
		if (chkChar == '1' || chkChar == 'y' || chkChar == 'Y') {return true;}
		else if (chkChar == '0' || chkChar == 'n' || chkChar == 'N') {
			System.out.println("\nEnough of Addition and Subtraction.  I'm not in elementary school anymore!");
			return false;
		}
		else {
			System.out.println("That was an invalid selection; please try again!");
			return checkShouldLoop();
		}
		
	}
}
