package rearrangingcartons;

import java.util.Scanner;

public class RearrangingCartons {
	private static int numCartons;
	private static int numOperations = 0;
	private static int[] currentArrangement;
	private static int[] finalArrangement;
	public static void main(String[] args) {
		initialize();
		sort();
		printClose();
	}
	private static void initialize() {
		int index;
		Scanner keyboard01 = new Scanner(System.in);
		System.out.println("Please enter the number of cartons:");
		numCartons = keyboard01.nextInt();
		currentArrangement = new int[numCartons];
		finalArrangement = new int[numCartons];
		System.out.println("Please enter the current arrangement of cartons:");
		for(index = 0; index < numCartons; index++) {
			currentArrangement[index] = keyboard01.nextInt();
		}
		System.out.println("Please enter the final arrangment of cartons:");
		for(index = 0; index < numCartons; index++) {
			finalArrangement[index] = keyboard01.nextInt();
		}
		keyboard01.close();
	}
	private static void sort() {
		boolean moved = true;
		while(moved) {
			moved = false;
			
			for(int i = 0; i < numCartons; i++) {
				for(int j = i+1; j < numCartons; j++) {
					if (finalArrangement[j]==currentArrangement[i] && 
						finalArrangement[j]!=currentArrangement[j]) {
						move(i,j);
						moved = true;
						break;
					}
				}
			}
		}
	}
	private static void move(int i, int j) {
		int temp;
		for(;i<j;i++) {
			temp = currentArrangement[i+1];
			currentArrangement[i+1] = currentArrangement[i];
			currentArrangement[i] = temp;
			numOperations++;
//			printOperation(i);
		}
	}
	private static void printOperation(int i) {
		System.out.print("* Operation " + numOperations + ", Exchange " + currentArrangement[i] + " " + currentArrangement[i+1] + ": ");
		for(i=0;i<numCartons;i++) {
			System.out.print(currentArrangement[i] + " ");
		}
		System.out.println();
	}
	private static void printClose() {
		System.out.println("\nThis took " + numOperations + " swaps!");
	}

}
