package selectionsorttest;

import java.util.Random;

/*--------------------------------------------------------------*
 *  File Name: SelectionSortTest.java				|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Lab Number: 11						|
 *  Description:                                                |
 *  File Created: Apr 22, 2013					|
 *  Last Changed: Apr 22, 2013					|
 ---------------------------------------------------------------*/

public class SelectionSortTest {

    private static Random random = new Random();
    
    public static void main(String[] args) {
        selectionSort(generate());
        System.out.println("Done.");
    }
    
    private static void selectionSort(int[] arr) {
        int minIndex, tmp;
        int n = arr.length;
        
        System.out.println("* Sorted numbers:");
        
        for(int i = 0; i < n; i++) {
            minIndex = i;
            
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            if (minIndex != i) {
                //swap two values
                tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
            
            System.out.print("round " + (i+1) + ": ");
            printIntArray(arr);
        }
    }
    
    private static int[] generate() {
        System.out.println("* Generating 10 random integers in range (0,100)");
        int[] arr = new int[10];
        for(int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return arr;
    }
    
    private static void printIntArray(int[] arr) {
        for(int i = 0; i < 10; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
