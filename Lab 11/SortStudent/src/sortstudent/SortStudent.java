package sortstudent;

import java.text.Collator;
import java.util.Scanner;

/*--------------------------------------------------------------*
 *  File Name: SortStudent.java                                 |
 *  Author: Anthony Davis St. Aubin                             |
 *  KUID: 2482383                                               |
 *  Email Address: a162s797@ku.edu                              |
 *  Lab Number: 11                                              |
 *  Description: Initializes an array of Students objects and   |
 *    sorts them by name and ID                                 |
 *  File Created: Apr 22, 2013                                  |
 *  Last Changed: Apr 23, 2013                                  |
 ---------------------------------------------------------------*/

public class SortStudent {

	
    private static int numStudents;
    private static Students[] student;
    private static Scanner keyboard01 = new Scanner(System.in);
    
    public static void main(String[] args) {
        
    	// Initializes the Students[n] depending on a user-input n;
        System.out.println("Enter the number of students");
        numStudents = keyboard01.nextInt();
        student = new Students[numStudents];
        for(int i = 0; i < numStudents; i++) {
            student[i] = new Students();
        }
        
        // Sorts and prints the Students[];
        System.out.println("\n* Sort by name:");
        bubbleSort(student,0);
        printArray(student);
        
        System.out.println("\n* Sort by ID:");
        bubbleSort(student,1);
        printArray(student);
    }
    
    private static void bubbleSort(Students[] arr, int sortType) {
    	// Bookkeeping variables;
        boolean swapped = true;
        int j = 0; // the number of Students that are definitely sorted;
        Students tmp; // temporary object for swapping;
        
        while(swapped) {
            swapped = false;
            j++;
            
            //Compare the first and the second and so on...
            for(int i = 0; i < arr.length - j; i++) {
                if(compare(arr, sortType, i)) {
                    //swap arr[i] and arr[i+1];
                    tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    
                    
                    swapped = true;
                }
            }
        }
    }
    
    // Returns true if the Students should be swapped, else false;
    private static boolean compare(Students[] arr, int sortType, int i) {
    	// Sorts by name;
        if(sortType == 0) {
            Collator myCollator = Collator.getInstance();
            return myCollator.compare(arr[i].getName(), arr[i+1].getName()) > 0;
        }
        // Sorts by ID;
        else {
            return arr[i].getId() > arr[i+1].getId();
        }
    }
    
    // Prints out the array of Students with one Students per line;
    private static void printArray(Students[] arr) {
        for(int i = 0; i < numStudents; i++) {
            System.out.println(arr[i].getName() + " " + arr[i].getId());
        }
    }
}
