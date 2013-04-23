package sortstudent;

import java.util.Scanner;

/*--------------------------------------------------------------*
 *  File Name: Students.java                                    |
 *  Author: Anthony Davis St. Aubin                             |
 *  KUID: 2482383                                               |
 *  Email Address: a162s797@ku.edu                              |
 *  Lab Number: 11                                              |
 *  Description: Contains the information for an individual     |
 *    student (name and id), methods for accessing that data,   |
 *    and an input method for that data in the constructor      |
 *  File Created: Apr 22, 2013                                  |
 *  Last Changed: Apr 23, 2013                                  |
 ---------------------------------------------------------------*/

public class Students {
	// Students's properties;
    private String name;
    private int id;
    private Scanner keyboard01;
    
    // Constructor requests user input for the name and id;
    public Students() {
        this.keyboard01 = new Scanner(System.in);
        readInput();
    }
    
    // Accepts name and id separated either by a space or a 
    // hard return;
    private void readInput() {
            System.out.print("Enter student's name and ID number: ");
            name = keyboard01.next();
            id = keyboard01.nextInt();
    }
    
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    

    
}
