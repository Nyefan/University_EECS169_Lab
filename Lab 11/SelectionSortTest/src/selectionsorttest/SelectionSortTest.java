package selectionsorttest;

import java.util.Random;

/*--------------------------------------------------------------*
 *  File Name: SelectionSortTest.java                           |
 *  Author: Anthony Davis St. Aubin                             |
 *  KUID: 2482383                                               |
 *  Email Address: a162s797@ku.edu                              |
 *  Lab Number: 11                                              |
 *  Description: Creates an array of 10 random numbers and sorts|
 *    them, providing a printout of the results as it goes;     |
 *  File Created: Apr 22, 2013                                  |
 *  Last Changed: Apr 23, 2013                                  |
 ---------------------------------------------------------------*/

public class SelectionSortTest {

    private static Random random = new Random();
    
    public static void main(String[] args) {
    	// Generate and sort a new 10 element array of ints < 100;
        selectionSort(generate());
        System.out.println("Done.");
    }
    
    private static void selectionSort(int[] arr) {
    	// Bookkeeping variables;
        int minIndex // Index of the minimum value;
        int tmp; // Temporary variable used for switching;
        int n = arr.length;
        
        System.out.println("* Sorted numbers:");
        
        // Sort the numbers by placing the lowest value in the
        // first slot, second lowest in the second slot, and so
        // on;
        for(int i = 0; i < n; i++) {
            minIndex = i;
            
            // Determine the index of the minimum unsorted value;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // If the minimum unsorted value is not in the 
            // first unsorted slot, swap the two values;
            if (minIndex != i) {
                tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
            
            // Print out the results of each swap;
            System.out.print("round " + (i+1) + ": ");
            printIntArray(arr);
        }
    }
    
    // Generates a random array of 10 integers in (0,100) and 
    // prints it to the screen;
    private static int[] generate() {
        System.out.println("* Generating 10 random integers in range (0,100)");
        int[] arr = new int[10];
        
        // printIntArray is not called because the operation 
        // carried out by that method can be handled in the same 
        // for loop as the initialization of the values;
        for(int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return arr;
    }
    
    // Prints an array to the screen;
    private static void printIntArray(int[] arr) {
        for(int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
