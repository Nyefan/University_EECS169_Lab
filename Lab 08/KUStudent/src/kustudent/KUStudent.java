package kustudent;

/*--------------------------------------------------------------*
 *  File Name: KUStudent.java					|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Lab Number: 08						|
 *  Description: Defines an Object, KUStudent, that has:	|
 *    four instanced variables:					|
 *	String stud_fname;					|
 *	String stud_lname;					|
 *	String stud_kuid;					|
 *	String stud_dpt;					|
 *    two methods:						|
 *	String set_name(fname, lname){;}			|
 *	String set_kuinfo(kuid, dpt){;}				|
 *  File Created: Mar 29, 2013					|
 *  Last Changed: Mar 30, 2013					|
 ---------------------------------------------------------------*/

public class KUStudent {

  private String stud_fname;
  private String stud_lname;
  private String stud_kuid;
  private String stud_dpt;

  public void set_name(String fname, String lname) {
    stud_fname = fname;
    stud_lname = lname;
  }

  public void set_kuinfo(String kuid, String dpt) {
    stud_kuid = kuid;
    stud_dpt = dpt;
  }

  public void displayInfo() {
    System.out.printf("Student: %s %s"
	    + "\nKUID: %s"
	    + "\nDepartment: %s",
	    stud_fname, stud_lname, stud_kuid, stud_dpt);
  }
}
