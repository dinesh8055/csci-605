import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class Exceptions_Kamal implements Cloneable{
	
	 public Object clone() throws CloneNotSupportedException {  
	       return super.clone();  
	   }  
	
	public static void IllegalArgumentMethod(int num)
	{
		if(num<1)
		{
			throw new IllegalArgumentException();
		}
		
		else
		{
			System.out.println(num);	
		}
	}
	
	
	public static void main(String args[])
	{		
		int num=1;
		
		switch(num)
		{
		case 0:
			
			try
			{	
				int a=8,b=0;		
				int result=(a/b);			
				System.out.println(result);
			}
		
		catch(ArithmeticException ae)
		{
			System.out.println(ae);
		}
			break;
		
		case 1:
			
			try
			{
			
				int array[]=new int[3];
			
				for(int i=3;i>0;i++)
				{
					System.out.println(array[i]);
				}
			
			}
			catch(ArrayIndexOutOfBoundsException ai)
			{
				System.out.println(ai);
			}
					
		case 2:
			try
			{
				String test=null;			
				System.out.println(test.equals(null));		
					
			}
			
			catch(NullPointerException np)
			{
				System.out.println(np);
			
			}
			
		case 3:
			
			try
			{
				int array[]= new int [-1];
			}
			
			catch(NegativeArraySizeException nae)
			{
				System.out.println(nae);
			}
			
		case 4:
			
			try
			{
				String test="Hello";
				System.out.println(test.charAt(test.length()+1));
			}
			
			catch(StringIndexOutOfBoundsException siob)
			{
				System.out.println(siob);
			}
			
		case 5:
			
			try
			{
				Object obj[]=new String[3];
				obj[0]=new int[1];
			}
			
			catch(ArrayStoreException ase)
			{
				System.out.println(ase);
			}
			
		case 6:
			
			try
			{					
				Object obj=(Exception)new Object();
				
			}
			
			catch(ClassCastException cce)
			{
				System.out.println(cce);
			}
						
						
		case 7:
			
			try
			{								
				IllegalArgumentMethod(0);
			}
			
			catch(IllegalArgumentException iae)
			{
				System.out.println(iae);
			}
			
		case 8:
			
			try
			{
				String Test="hello";
				
				int number=Integer.parseInt(Test);
				
				System.out.println(number);
			}
			
			catch(NumberFormatException nfe)
			{
				System.out.println(nfe);
			}
			
		case 9:
			
			try
			{
				Thread T=new Thread();
				T.start();
				T.start();
			}
			
			catch(IllegalThreadStateException itse)
			{
				System.out.println(itse);
			}
			
		case 10:
			
			try
			{
				Set<Random> sample=new HashSet<Random>(10);
				Random rnum=new Random();
				for(int i=0;i<sample.size();i++)
				{
					sample.add(rnum);
				}
				
				Set<Random> unmodifiableSet =Collections.unmodifiableSet (sample);
				
				unmodifiableSet.add(rnum);
						
			}
			catch(UnsupportedOperationException  usoe)
			{
				System.out.println(usoe);
			}
			
			// checked Exceptions
			
		case 11:
			
			try
			{
				Class<?> load= Class.forName("java.Util.Collections");
				
			}
			
			catch(ClassNotFoundException cne)
			{
				System.out.println(cne);
			}
			
		case 12:
			
			try
			{
				@SuppressWarnings("resource")
				Scanner sc=new Scanner(new File("sample.txt"));
				while(sc.hasNext());
				System.out.println("found file");
				
				
			}
			
			catch(FileNotFoundException fnfe)
			{
				System.out.println(fnfe);
			}
			
		case 13:
			
			try
			{
				Class<?> c= Class.forName("InstantiationEx");
				Object o=c.newInstance();
			}
			
			 catch (IllegalAccessException e) {
				
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (InstantiationException e) {
				
				e.printStackTrace();
			}
			
			
		case 14:
			
			DateformatEx df=new DateformatEx();
			df.dateFormatChecker();
		
		}
		
	}
}



 class InstantiationEx
{
	 public InstantiationEx(int num)
	 {
		 
	 }
}
 
 class DateformatEx{
	 
	 public void dateFormatChecker()
	 {
	 try
	 {
		 SimpleDateFormat format= new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

	 String input="Sep 22, 2014 11:03 AM";//Mon Sep 22 23:53:43 EST 2014
	 
		 Date date=format.parse(input);
		 
		 System.out.println(date);
	 }
	 catch(ParseException pe)
	 {
		 System.out.println(pe);
	 }	 
	}
 }
 
 
 
 

 