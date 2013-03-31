package oldmacdonald;

/*--------------------------------------------------------------*
 *  File Name: OldMacDonaldTest.java				|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Lab Number: 08						|
 *  Description: Creates two Objects (one Animal and one	|
 *    OldMacDonald), sets the properties of the Animal, passes	|
 *    the Animal to the OldMacDonald, and tells OldMacDonald to |
 *    sing();
 *  File Created: Mar 30, 2013					|
 *  Last Changed: mar 30, 2013					|
 ---------------------------------------------------------------*/

public class OldMacDonaldTest {
  
  public static void main(String[] args) {

    //Create an animal and an OldMacdonald object;
    Animal animalA = new Animal();
    OldMacDonald md = new OldMacDonald();

    //Tell the animal what type it is and what sound it makes;
    animalA.setSound("moo");
    animalA.setType("cow");

    //Tell OldMacDonald which animal to sing about
    md.setAnimal(animalA);

    //Tell OldMacDonald to sing
    md.sing();
  }

}
