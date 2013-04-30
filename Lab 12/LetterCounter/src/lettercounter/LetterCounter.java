package lettercounter;

import java.io.*;
import java.util.*;

/*--------------------------------------------------------------*
 *  File Name: LetterCounter.java                               |
 *  Author: Anthony Davis St. Aubin                             |
 *  KUID: 2482383                                               |
 *  Email Address: a162s797@ku.edu                              |
 *  Lab Number: 12                                              |
 *  Description: Counts the number of each letter, space, and   |
 *    other characters in a user-input *.txt file and outputs   |
 *    the results to the file Output.txt                        |
 *  File Created: Apr 29, 2013                                  |
 *  Last Changed: Apr 30, 2013                                  |
 ---------------------------------------------------------------*/

public class LetterCounter {
  private static int[] alphabet = new int[28];
  
  public static void main(String[] args) {
    readFile(getName());
    output("Output.txt");
  }
  
//Requests from the user and returns a file to analyze;
  private static String getName() {
    Scanner keyboard01 = new Scanner(System.in);
    String filename;
//  Ensures that a meaningful input is entered;
    while(true) {
      System.out.println("Enter a filename with extension .txt:");
      filename = keyboard01.nextLine();
      if(filename.endsWith(".txt")) {
	    break;
      }
      else{
    	System.out.println("That is not a valid filename.  Please try again.\n");
      }
    }
//  Cleanup to prevent resource leaks;
    keyboard01.close();
    return filename;
  }
  
//Reads the input file line-by-line and stores the number of each letter
//encountered in the int[] alphabet;
  private static void readFile(String filename) {
//	try-with-resources used to prevent resourse leaks;
    try(BufferedReader in = new BufferedReader(new FileReader(filename))) {
//    Pre-initialize variables;
      String line;
      char charAtI;
      do {
//    Read the file;
		line = in.readLine().toLowerCase();
		for(int i = 0; i < line.length(); i++) {
		  charAtI = line.charAt(i);
//		  Increment the value in alphabet corresponding to the character charAtI;
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
//	  Break when reaching the end of the file;
      } while (line != null);
    }
    catch(Exception e) {
//    Catch exception if any;
      System.err.println("Error in function readFile(String filename): \n  " + e.getMessage());
    }
  }
  
//Writes a new file detailing the results of readFile;
  private static void output(String filename) {
    try(BufferedWriter out = new BufferedWriter(new FileWriter(filename))) {
      int j = 0;
      for(char i = 'A'; i <= 'Z'; i++) {
	out.write("    " + i + ": " + alphabet[j++]);
	out.newLine();
      }
      out.write("Space: " + alphabet[j++]);
      out.newLine();
      out.write("Other: " + alphabet[j]);
      out.newLine();
    }
    catch(Exception e) {
//    Catch exception if any;
      System.err.println("Error in function output(String filename): " + e.getMessage());
    }
    finally {
      System.out.println(filename + " created.");
    }
  }
}
