package lettercounter;

import java.io.*;
import java.util.*;

/*--------------------------------------------------------------*
 *  File Name: LetterCounter.java				|
 *  Author: Anthony Davis St. Aubin				|
 *  KUID: 2482383						|
 *  Email Address: a162s797@ku.edu				|
 *  Lab Number: 12				                |
 *  Description: TODO - WRITE DESCRIPTION OF THE PROGRAM HERE	|
 *  File Created: Apr 29, 2013					|
 *  Last Changed: INSERT DATE HERE				|
 ---------------------------------------------------------------*/

public class LetterCounter {
  private static int[] alphabet = new int[28];
  public static void main(String[] args) {
    String filename = getName();
    readFile(filename);
    output("Output.txt");
  }

  private static String getName() {
    Scanner keyboard01 = new Scanner(System.in);
    while(true) {
      System.out.println("Enter a filename:");
      String filename = keyboard01.nextLine();
      if(filename.endsWith(".txt")) {
	return filename;
      }
      else{
	System.out.println("That is not a valid filename.  Please try again.\n");
      }
    }
  }
  private static void readFile(String filename) {
    try(BufferedReader in = new BufferedReader(new FileReader(filename))) {
      String line;
      char charAtI;
      do {
	line = in.readLine().toLowerCase();
//	System.out.println(line + line.length());
	for(int i = 0; i < line.length(); i++) {
	  charAtI = line.charAt(i);
//	  System.out.println(charAtI);
	  if('a' <= charAtI && charAtI <= 'z') {
	    alphabet[(int) charAtI - (int) 'a']++;
	  }
	  else if(charAtI == ' ') {
	    alphabet[26]++;
	  }
	  else {
	    alphabet[27]++;
	  }
	}
      } while (line != null);
    }
    catch(Exception e) {
//    Catch exception if any;
      System.err.println("Error: " + e.getMessage());
    }
  }
  private static void output(String filename) {
//    System.out.println("The file contains the following letters:");
//    int j = 0;
//    for(int i = 'A'; i <= 'Z'; i++) {
//      System.out.println((char)i + ": " + alphabet[j++]);
//    }
//    System.out.println("Other: " + alphabet[j]);
    try(BufferedWriter out = new BufferedWriter(new FileWriter(filename))) {
      int j = 0;
      for(char i = 'A'; i <= 'Z'; i++) {
//	System.out.println(i + ": " + alphabet[j]);
	out.write("    " + i + ": " + alphabet[j++]);
	out.newLine();
      }
//    System.out.println("Space: " + alphabet[j]);
      out.write("Space: " + alphabet[j++]);
      out.newLine();
//    System.out.println("Other: " + alphabet[j]);
      out.write("Other: " + alphabet[j]);
      out.newLine();
    }
    catch(Exception e) {
//    Catch exception if any;
      System.err.println("Error: " + e.getMessage());
    }
    finally {
      System.out.println(filename + " created.");
    }
  }
}
