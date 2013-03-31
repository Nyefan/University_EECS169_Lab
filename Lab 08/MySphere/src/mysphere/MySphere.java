package mysphere;

import static java.lang.Math.pow;

/*--------------------------------------------------------------*
 *  File Name: MySphere.java					|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Lab Number: 08						|
 *  Description: Defines an Object, MySphere, that has:		|
 *    one instanced variable:					|
 *	double diameter;					|
 *    four methods:					|
 *	void setDiameter(double){;}				|
 *	double getDiameter(){;}					|
 *	double calculateVolume(){;}				|
 *	double calculateSurfaceArea(){;}			|
 *  File Created: Mar 29, 2013					|
 *  Last Changed: Mar 29, 2013					|
 ---------------------------------------------------------------*/

public class MySphere {

  //Define the constant PI.
  private final double PI = 3.141592;
  private double diameter;

  public void setDiameter(double newDiameter) {
    diameter = newDiameter;
  }

  public double getDiameter() {
    return diameter;
  }

  public double calculateVolume() {
    return PI*pow(diameter,3)/6;
  }

  public double calculateSurfaceArea() {
    return PI*pow(diameter,2);
  }

}