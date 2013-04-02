package oldmacdonald;

/*--------------------------------------------------------------*
 *  File Name: OldMacDonald.java				|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Lab Number: 08			 			|
 *  Description: Defines an Object, OldMacDonald, that has:	|
 *    three instanced variables:				|
 *	Animal animal						|
 *	String type;						|
 *	String sound;						|
 *    two methods:						|
 *	void setAnimal(Animal)					|
 *	void sing()						|
 *  File Created: Mar 30, 2013					|
 *  Last Changed: Mar 30, 2013					|
 ---------------------------------------------------------------*/

public class OldMacDonald {
  private Animal animal;
  private String type;
  private String sound;
  
  public void setAnimal(Animal animalIn) {
    animal = animalIn;
    type = animal.getType();
    sound = animal.getSound();
  }

  public void sing() {
    System.out.printf(""
      + "\nOld MacDonald had a farm, EE-I-EE-I-O,"
      + "\nAnd on that farm he had a %s, EE-I-EE-I-O,"
      + "\nWith a %s-%s here and a %s-%s there, EE-I-EE-I-O,"
      + "\nHere a %s, there a %s, everywhere a %s-%s,"
      + "\nOld MacDonald had a farm, EE-I-EE-I-O.",
      type,
      sound,sound,sound,sound,
      sound,sound,sound,sound
    );
  }
}

/**--------------------------------NOTES--------------------------------
 * setAnimal.01
 *              Takes an Animal as input and assigns OldMacDonald's 
 *              properties, type and sound, based on the input Animal's
 *              properties
 * 
 * sing.01
 *              Outputs a verse of "Old MacDonald Had A Farm" with the
 *              appropriate animal type and sound for a given instance;
 **/
