package sortstudent;

import java.util.Scanner;

/*--------------------------------------------------------------*
 *  File Name: Students.java					|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Lab Number: 11						|
 *  Description:                                                |
 *  File Created: Apr 22, 2013					|
 *  Last Changed: Apr 22, 2013					|
 ---------------------------------------------------------------*/

public class Students {
    private String name;
    private int id;
    private Scanner keyboard01;
    
    public Students() {
        this.keyboard01 = new Scanner(System.in);
        readInput();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    
    private void readInput() {
            System.out.print("Enter student's name and ID number: ");
            name = keyboard01.next();
            id = keyboard01.nextInt();
    }
    
}
