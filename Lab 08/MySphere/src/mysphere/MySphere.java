package mysphere;

import static java.lang.Math.pow;
import java.util.Scanner;

/*--------------------------------------------------------------*
 *  File Name: MySphere.java					|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Lab Number: 08						|
 *  Description: TODO - WRITE DESCRIPTION OF THE PROGRAM HERE	|
 *  File Created: Mar 29, 2013					|
 *  Last Changed: Mar 29, 2013					|
 ---------------------------------------------------------------*/

public class MySphere {

  //Define the constant PI.
  private final double PI = 3.141592;
  //The MySphere class has one instance variable, diameter;
  private double diameter;

  //The MySphere class has four methods

  public void setDiameter(double newDiameter) {
    diameter = newDiameter;
  }

  public double getDiameter() {
    return diameter;
  }

  public double calculateVolume() {
    return 4/3*PI*pow(diameter,3);
  }

  public double calculateSurfaceArea() {
    return 4*PI*pow(diameter,2);
  }

}