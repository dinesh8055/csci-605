/** 
 * Center.java 
 * 
 * @ Version: 
 *     $Id: Center.java , Version 1.0 09/23/2014 $ 
 * 
 * Revisions: 
 *     $Log Initial Version $ 
 */

import java.util.Scanner;
import java.io.File;

/**
 * This program finds the center object of all given objects 
 *
 * @author      Dinesh Gudi
 * @author      Rithvik Gambhir
 */

class Center
{

/**
 * The following method distance formula
 * The distance formula is given as follows 
 * The distance between two points is the square root of the difference of the corresponding co-ordinates squared
 * 
 * @param 		p1		This stores the co-ordinates of the first point 
 * @param 		p2		This stores the co-ordinates of the the second point to which the distance is to be measured
 * @return				Returns the distance between both the points in question. Return is of the datatype double
 */
 
    public static double findDist(int[] p1,int[] p2)
    {
    	double sum=0;
    	double dist=0;
    	for(int i=0;i<3;i++)
    	{
    		sum=sum+Math.pow(p1[i]-p2[i],2);
    	}
    	dist=Math.sqrt(sum);
    	return dist;
    }

/**
 * The following method converts the String read from the scanner file to array of integers, to store the value of the point
 * 
 * @param 		str		Stores the co-ordainates of the point read from the file
 * @return				Returns the value of the co-ordinates which is read from the String
 */

    public static int[] stringToPoint(String str)
    {
    	int [] point={0,0,0};
        char[] str1=new char[str.length()];
        for (int i = 0; i < str.length(); i++) 
        {
            str1[i] = str.charAt(i);
        } 
        for(int i=0,j=0;i<str.length();i++)
        {
        	if(str1[i]!=' ')
        	{
        		point[j]=Character.getNumericValue(str1[i]);
        		j++;
        	}	
        }
        return point;
    }

/**
 * The following method prints the point in the required format corresponding to the location in the Cartesian co-ordinate plane
 * 
 * @param 		point		Stores the co-ordinates of the point in an integer array 
 */
    public static void printPoint(int [] point)
    {
    	System.out.print("( ");
        for(int i=0;i<3;i++)
        {
        	System.out.print(point[i]);
        	System.out.print(", ");
        }
        System.out.println("\b\b "+")");
    }
    
/**
 * The following method creates scanner objects of the text file which stores the given points
 * If the distance between the point in question and other points is minimum, then it is stored as the center point
 * 
 */

    public static void findCenter()
    {
        try
        {
        	double low=0;
        	int count=0;
        	int[] midPoint={0,0,0};
        	Scanner sc = new Scanner(new File("points.txt"));
        	while(sc.hasNext())
        	{
    	        double sum=0;
    	        String line=sc.nextLine();
    	        int[] p1=stringToPoint(line);
    	        Scanner sc1 = new Scanner(new File("points.txt"));
    	        while(sc1.hasNext())
    	        {
    	        	String line1=sc1.nextLine();
    	        	int[] p2=stringToPoint(line1);		
    	        	sum=sum+findDist(p1,p2);
    	        }
    	        if(count==0)
    	        {
    	        	low=sum;
    	        	midPoint=p1;
    	        }
    	        count++;
    	        if(sum<low)
    	        {
    	        	low=sum;
    	        	midPoint=p1;
    	        } 
        	}
        	printPoint(midPoint);
        }
        catch ( Exception e )
        {
        	e.printStackTrace();
        	System.err.println("Something went wrong!");
        }
    }

/**
 * main() calls the method findCenter() and hence the minimum distance and center point assignment is made
 * 
 */
    
    public static void main(String[] args)
    {
    	findCenter();
    }
}

/**
 * The text file points.text chosen to test the above program is as follows
 * 
 * 1 2 1
 * 1 1 1
 * 0 4 9
 * 0 5 9
 * 
 */