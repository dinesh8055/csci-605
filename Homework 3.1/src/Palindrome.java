/**
 * The program finds and prints all possible Palindromes in a line
 *
 *
 * @version   $Id: Palindrom.java,v 1.3 2014/09/16 21:32:46 Rithvik Exp Rithivk $
 *
 * @author    Dinesh Gudi, Rithvik Gambhir
 *
 * Revisions:
 *
 *      Revision 1.40  2014/09/16 22:31:12  Rithvik
 *      Revision 1.41  2014/09/16 23:45:21  Rithvik
 *      Initial revision
 *
 */
import java.util.Scanner;
import java.io.File;
/**
 * 
 * @author Rithvik Gambhir, Dinesh Gudi
 *
 */
public class Palindrome
{
/**
 * The following method reads the text file and calls findPalindrome() to find and print the results
 * 
 * @param 	file 			Stores the given text file
 * @param 	sc   			Creates the scanner object for reading the file
 * @param 	line 			Reads the sentences one line at a time
 * @param	lowerCaseLine	Reads the line in lower case since character A is the same as character a
 * 
 */
	public static void main( String[] args )	
	{
		try		
		{
			File file = new File("palindrome.txt");
			Scanner sc  = new Scanner((file));
            while ( sc.hasNext() )              
            {
            	String line = sc.nextLine();
                System.out.println("\n"+line);// your code goes here
                System.out.println("The Palindromes in the above line are the following");
                String lowerCaseLine = line.toLowerCase();
                findPalindrome(line, lowerCaseLine);
            }
            sc.close();  
        }
		catch ( Exception e )		{
				System.err.println(e);
        }
	}  
/**
 * The following method travels through the entire line	and calls isPalindrome() and printPalindrome()
 * 
 * @param 	line			Passed from main() and reads the sentences one line at a time 
 * @param 	lowerCaseLine	Passed from main() and reads the line in lower case
 * @param 	startIndex		Stores the first index value of the String line to be compared
 * @param 	endIndex		Stores the next index value of the String line to be compared
 * 
 */
	public static void findPalindrome(String line, String lowerCaseLine)
	{
		for(int startIndex=0; startIndex<(lowerCaseLine.length()-2); startIndex++)
		{
			for(int endIndex=startIndex+2; endIndex<lowerCaseLine.length(); endIndex++)
			{
				if(isPalindrome(startIndex, endIndex, lowerCaseLine))
						printPalindrome(startIndex, endIndex, line);
			}
		}
	}
/**
 * 	The following method compares the characters to check whether it is a palindrome
 * 
 * A Palindrome is a word which reads the same when spelled backwards
 * Whitespaces are considered no different from other characters
 * 
 * @param startIndex		Stores the first index value of the String line to be compared
 * @param endIndex			Stores the next index value of the String line to be compared
 * @param lowerCaseLine		Passed from main() and reads the line in lower case
 * 
 * @return					Returns whether the given set of characters or words passed or failed
 * 							the palindrome test. This is a boolean value of true or false
 */
	public static boolean isPalindrome(int startIndex, int endIndex, String lowerCaseLine)
	{	
		while(startIndex<endIndex)
		{
			if(lowerCaseLine.charAt(startIndex) == lowerCaseLine.charAt(endIndex))
			{
				startIndex++;
				endIndex--;
			}
			else
				return false;
		}
		return true;
	}
/**
 * The palindrome found with the above methods is printed
 * Since we want to print the acutal line here, we take the substring() of the original line
 *
 * 	
 * @param startIndex		Stores the first index value of the String line to be compared
 * @param endIndex			Stores the next index value of the String line to be compared
 * @param line				Reads the sentences one line at a time
 */
	public static void printPalindrome(int startIndex, int endIndex, String line)
	{
		System.out.println(line.substring(startIndex,endIndex+1));
	}
}