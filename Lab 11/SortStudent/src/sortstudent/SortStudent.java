/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sortstudent;

import java.text.Collator;
import java.util.Scanner;

/*--------------------------------------------------------------*
 *  File Name: SortStudent.java					|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Lab Number: 11						|
 *  Description:                                                |
 *  File Created: Apr 22, 2013					|
 *  Last Changed: Apr 22, 2013					|
 ---------------------------------------------------------------*/

public class SortStudent {

    private static int numStudents;
    private static Students[] student;
    private static Scanner keyboard01 = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.println("Enter the number of students");
        numStudents = keyboard01.nextInt();
        student = new Students[numStudents];
        for(int i = 0; i < numStudents; i++) {
            student[i] = new Students();
        }
        
        System.out.println("\n* Sort by name:");
        bubbleSort(student,0);
        printArray(student);
        
        System.out.println("\n* Sort by name:");
        bubbleSort(student,1);
        printArray(student);
    }
    
    private static void bubbleSort(Students[] arr, int sortType) {
        boolean swapped = true;
        int j = 0;
        Students tmp;
        
        while(swapped) {
            swapped = false;
            j++;
            
            //Compare the first and the second and so on...
            for(int i = 0; i < arr.length - j; i++) {
                if(compare(arr, sortType, i)) {//arr[i].getProperty(sortType) > arr[i+1].getProperty(sortType)) {
                    //swap arr[i] and arr[i+1];
                    tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    
                    
                    swapped = true;
                }
            }
        }
    }
    
    private static boolean compare(Students[] arr, int sortType, int i) {
        if(sortType == 0) {
            Collator myCollator = Collator.getInstance();
            return myCollator.compare(arr[i].getName(), arr[i+1].getName()) > 0;
        }
        else {
            return arr[i].getId() > arr[i+1].getId();
        }
    }

    private static void printArray(Students[] arr) {
        for(int i = 0; i < numStudents; i++) {
            System.out.println(arr[i].getName() + " " + arr[i].getId());
        }
    }
}
