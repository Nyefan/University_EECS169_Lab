package taxi;

import java.util.Scanner;
import java.lang.Math;

/*--------------------------------------------------------------*
 *  File Name: Taxi.java                                        |
 *  Author: Anthony Davis St. Aubin                             |
 *  KUID: 2482383                                               |
 *  Email Address: a162s797@ku.edu                              |
 *  Lab Number: 12                                              |
 *  Description: Finds all solutions to the problem a^3 + b^3 + |
 *    c^3 + d^3 where a, b, c, and d are all less than a        |
 *    requested user-input integer n;                           |
 *  File Created: Apr 30, 2013                                  |
 *  Last Changed: Apr 30, 2013                                  |
 ---------------------------------------------------------------*/

public class Taxi {
	public static void main(String[] args) {
		solve(getInteger(), 3);
	}
	
	private static int getInteger() {
		Scanner keyboard01 = new Scanner(System.in);
		System.out.println("Please enter a number:");
		int n = keyboard01.nextInt();
		System.out.println();
		keyboard01.close();
		return n;
	}
//	Finds unique solutions to a^x + b^x = c^x + d^x
	private static void solve(int n, int x) {
//		int cube;
		for (int a = 1; a < n-3; a++) {
			for (int b = a+1; b <= n; b++) {
				for (int c = a+1; c < n; c++) {
					if (c==b) {continue;}
					for (int d = c+1; d <= n; d++) {
						if (d==b) {continue;}
						if (Math.pow(a, x) + Math.pow(b, x) == Math.pow(c, x) + Math.pow(d, x)) {
							output(new int[] {a,b,c,d});
						}
//						if ((cube = (int) (Math.pow(a, x) + Math.pow(b, x))) == Math.pow(c, x) + Math.pow(d, x)) {
//							output(new int[] {a,b,c,d,cube});
//						}
					}
				}
			}
		}
	}
	private static void output(int[] solution) {
		for (int i = 0; i < solution.length; i++) {
			System.out.print(solution[i] + " ");
		}
		System.out.println();
	}
}
