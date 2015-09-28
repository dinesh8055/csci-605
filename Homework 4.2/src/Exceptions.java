/**
 * The program finds and prints all Exceptions
 *
 *
 * @version   $Id: Exceptions.java,v 1.3 2014/09/23 21:32:46 Rithvik Exp Rithivk $
 *
 * @author    Dinesh Gudi, Rithvik Gambhir
 *
 * Revisions:
 *
 *      Revision 1.40  2014/09/21 22:31:12  Rithvik
 *      Revision 1.41  2014/09/22 23:45:21  Rithvik
 *      Initial revision
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * 
 * @author Rithvik Gambhir, Dinesh Gudi
 *
 */
class Exceptions{

    public static void main(String[] args){//the main program
        try{//ArithmaticException
            //int n;
            int n=1/0;
        }
        catch(ArithmeticException ae){
          ae.printStackTrace();
          try{//ArrayIndexOutOfBoundsException
            int[] arr=new int[2];
            arr[1]=10;
            arr[2]=20;
            System.out.println(arr[3]);
          }

          catch(ArrayIndexOutOfBoundsException aiobe){
            aiobe.printStackTrace();
            try{
              Object x[] = new String[3];
              x[0] = new Integer(0);
            }
            catch(ArrayStoreException ase){
              ase.printStackTrace();
              try{//code that produces classCastException
                Object x=new Integer(0);
                System.out.println((String)x);
              }
                catch(ClassCastException cce){
                  cce.printStackTrace();
                  try{//IllegalArgumentException
                    m1(0);
                  }
                  catch(IllegalArgumentException iae){
                    iae.printStackTrace();
                    try{//IllegalThreadStateException
       				  Thread th=new Thread();
    				  th.start();
    				  th.start();
                    }

                    catch(IllegalThreadStateException itse){
                      itse.printStackTrace();
                      try{//NegativeArraySizeException
               		    int arr[]= new int [-1];
                      }

                     catch(NegativeArraySizeException nase){
                      nase.printStackTrace();
                      try{//NullPointerException
                        String str=new String();
                          str=null;
                          str.length();
                      }
                      catch(NullPointerException npe){
                        npe.printStackTrace();
                        try{//NumberFormatException
                          String Test="hello";
                   	      int number=Integer.parseInt(Test);
                   	      System.out.println(number);
                        }

                        catch(NumberFormatException nfe){
                          nfe.printStackTrace();
                          try{//StringIndexOutOfBounds
                            String str="Hello";
                       	    System.out.println(str.charAt(str.length()+1));
                          }

                          catch(StringIndexOutOfBoundsException siob){
                            siob.printStackTrace();
                            try{//ClassNotFoundException
                   		      Class<?> load= Class.forName("java.Util.Collections");
                            }

                            catch(ClassNotFoundException cnfe){
                              cnfe.printStackTrace();
                           	  try{//FileNotFoundException
                        	    Scanner sc=new Scanner(new File("nofile.txt"));
                        	  }
                        	  catch(FileNotFoundException fnfe)
                        	  {
                        	    fnfe.printStackTrace();
                        	  }


                            }
                          }
                        }
                      }
                    }  

                }

             }

          }

       }

     }

    }

    }
    /**
     * This method produces the IllegalArgumentException
     * 
     * @param n    				if it is less than 1 it produces exception
     */
    public static void m1(int n)
	{
		if(n<1)
		{
			throw new IllegalArgumentException();
		}
		
		else
		{
			System.out.println(n);	
		}
	}
}