package oldmacdonald;

/*--------------------------------------------------------------*
 *  File Name: Animal.java					|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Lab Number: 08			 			|
 *  Description: Defines an Object, Animal, that has:		|
 *    two instanced variables:					|
 *	String animalType;					|
 *	String animalSound;					|
 *    four methods:						|
 *	String setType(String type)				|
 *	String setSound(String sound)				|
 *	void getType()						|
 *	void getSound()						|
 *  File Created: Mar 30, 2013					|
 *  Last Changed: Mar 30, 2013					|
 ---------------------------------------------------------------*/

public class Animal {
  private String animalType;
  private String animalSound;

  public void setType(String type) {
    animalType = type;
  }

  public void setSound(String sound) {
    animalSound = sound;
  }

  public String getSound() {
    return animalSound;
  }

  public String getType() {
    return animalType;
  }

}
