package kustudent;

import java.util.Scanner;

/*--------------------------------------------------------------*
 *  File Name: KUStudentTest.java				|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Lab Number: 08						|
 *  Description: Creates a new KUStudent Object with properties	|
 *    based on a requested user-input;				|
 *  File Created: Mar 29, 2013					|
 *  Last Changed: Mar 30, 2013					|
 ---------------------------------------------------------------*/

public class KUStudentTest {

  private static Scanner keyboard01 = new Scanner(System.in);
  private static KUStudent student = new KUStudent();

  public void main(String[] args) {

    requestStudentName();
    setName();
    requestKUInfo();
    setKUInfo();

    student.displayInfo();
  }

  private static void requestStudentName() {
    System.out.println("Please input the student's name (firstname lastname):");
  }

  private static void setName() {
    String fname = keyboard01.next();
    String lname = keyboard01.next();
    student.set_name(fname,lname);
  }

  private static void requestKUInfo() {
    System.out.println("Please input the student's KUID and department (KUID dpt):");
  }

  private static void setKUInfo() {
    String kuid = keyboard01.next();
    String dpt = keyboard01.next();
    student.set_kuinfo(kuid, dpt);
  }
}
