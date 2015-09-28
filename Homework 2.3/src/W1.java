/*
 * Program to count each printable character, number of characters, number of words and number of lines
 * 
 * Authors: Dinesh Gudi, Rithivk Gambhir
 */
import java.util.Scanner;
import java.io.File;

public class W1 {
    public static void main( String[] args ) {
	try {
        /* Counts the number of times a charecter occurs and also counts the total number of charecters */
		Scanner sc  = new Scanner( new File("macbeth.txt"));
        sc.useDelimiter("");                    //delimiter to count charecters
        int letterCount=0;                      //stores the number of charecters
		String[] list=new String[10000];        //stores the charecters which are already counted
		while ( sc.hasNext() )	{
			String word=sc.next();
			if(!isElementInList(word,list)){       //if charecter is not in the list
				int count=countLetter(word);    //countLetter method to count the number of times that particular letter occurs
				addElement(word,list);             //add the letter which is already counted to the list
				System.out.println(word+": "+count);
			
            }
            letterCount++;
		}
        System.out.println("Letter Count: "+letterCount+"\n");
		sc.close();
        
        /* Counts the number of times a word occurs and also returns the total number of words */
		Scanner sc1  = new Scanner( new File("macbeth.txt"));
		String[] list1=new String[10000];       //stores the words which are already counted
        int wordCount=0;                        //stores the number of words
		while ( sc1.hasNext() )	{
			String word1=sc1.next();
			if(!isElementInList(word1,list1)){
				int count1=countWord(word1);    //countLetter method to count the number of times that particular word occurs
				addElement(word1,list1);
				System.out.println(word1+": "+count1);
			}
            wordCount++;
		}
        System.out.println("wordCount="+wordCount+"\n");
		sc1.close();
        
        /* Counts the number of times a line occurs and also returns the total number of lines */
		Scanner sc2  = new Scanner( new File("macbeth.txt"));
        sc2.useDelimiter("\n");                 //delimiter to count lines
        int lineCount=0;                        //stores the number of lines
		String[] list2=new String[10000];
		while ( sc2.hasNext() )	{
			String word2=sc2.next();
			if(!isElementInList(word2,list2)){
				int count2=countLine(word2);
				addElement(word2,list2);
				System.out.println(word2+": "+count2);
			}
            lineCount++;
		}
        System.out.println("Line Count: "+lineCount+"\n");
		sc2.close();
    
	} 
	catch ( Exception e )	{
		System.err.println("Something went wrong!");
	}
    }

	public static boolean isElementInList(String word, String[] list){//method to check if the given element is in the list
		for(String element:list){
			if (word.equals(element)) return true;
		}
		return false;
	}

	public static void addElement(String word, String[] list){//method to add a given element to the list
		int j=0;
		for (j=0; list[j]!=null ; j++ );
		list[j]=word;
	}

	public static int countWord(String word){//method to count the number of times the word occurs
		int count=0;		
		try{
			int j=0;
			Scanner sc  = new Scanner( new File("macbeth.txt"));
			while(sc.hasNext()){
				if (word.equals(sc.next())){ 
					count ++;
				}
			}
			sc.close();
		}
		catch ( Exception e )	{
			System.err.println("Something went wrong!");
		}
		return count;
	}
    public static int countLetter(String word){//method to count the number of times the letter occurs
		int count=0;
		try{
			int j=0;
			Scanner sc  = new Scanner( new File("macbeth.txt"));
            sc.useDelimiter("");
			while(sc.hasNext()){
				if (word.equals(sc.next())){
					count ++;
				}
			}
			sc.close();
		}
		catch ( Exception e )	{
			System.err.println("Something went wrong!");
		}
		return count;
	}
	public static int countLine(String word){
		int count=0;
		try{
			int j=0;
			Scanner sc  = new Scanner( new File("macbeth.txt"));
            sc.useDelimiter("\n");
			while(sc.hasNext()){
				if (word.equals(sc.next())){
					count ++;
				}
			}
			sc.close();
		}
		catch ( Exception e )	{
			System.err.println("Something went wrong!");
		}
		return count;
	}
}