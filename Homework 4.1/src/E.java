/**
 * The program calculates the value of mathematical constant e using three methods
 *
 *
 * @version   $Id: E.java,v 1.3 2014/09/23 21:32:46 Rithvik Exp Rithivk $
 *
 * @author    Dinesh Gudi, Rithvik Gambhir
 *
 * Revisions:
 *
 *      Revision 1.40  2014/09/21 22:31:12  Rithvik
 *      Revision 1.41  2014/09/20 23:45:21  Rithvik
 *      Initial revision
 *
 */

public class E
{
	
/**
 * The following method calls methods which implement the three methods
 * 
 * @param 	delta 			Stores the value of error between actual value and calculated value
 * 
 */	
	
    public static void main(String args[])
    {
        double delta = 0.0001;
        calculateEversion1(delta, 0);
        calculateEversion2(delta, 1);
        calculateEversion3(delta, 0);
    }
    
/**
 * The following method implements the first method to calculate e
 * 
 * The formula implemented is e = Sum of series (1/n!) from n=0 to infinity
 * 
 * The method uses a for loop to the required iteration value for desired accuracy
 * Methods factorial and reciprocal are called here to compute the factorial and reciprocal
 * The calculated value is then compared with delta and n is incremented to include another iteration
 * if need or else it is printed
 * 
 * @param 	delta			Stores the value of error between actual value and calculated value
 * @param 	n				Stores the number of iterations required to achieve the required
 * 							level of accuracy for e
 * @param	eValue			Stores the calculated e value
 * @param	i				Stores the iteration value
 */
    
    public static void calculateEversion1(double delta, int n)
    {
        double eValue = 0.0;
        for(int i=0;i<=n;i++)
                eValue=eValue+reciprocal(factorial(i));
        
        if (compareWithDelta(eValue, delta))
            System.out.println("e with first method = " + eValue);
        
        else 
            calculateEversion1(delta, n+1);
    }

/**
 * The following method returns the reciprocal of a number
 * 
 * @param 	n			Stores the number whose reciprocal we want
 * 
 * @return				Returns the reciprocal of the value n
 */
    
    public static  double reciprocal(double n)
    {
        return 1/n;
    }
    
/**
 * The following method implements the third method to calculate e
 * 
 * The formula implemented is e = lim n tends to infinity(1 + 1/n)^n
 * 
 * The following code implements the formula and checks the accuracy of calculated e with
 * delta and increments n or prints the value. This is done recursively.
 * 
 * @param 	delta			Stores the value of error between actual value and calculated value
 * @param 	n				Stores the number of iterations required to achieve the required
 * 							level of accuracy for e
 * @param	eValue			Stores the calculated e value
 * @param	i				Stores the iteration value
 */
    
    
    public static void calculateEversion2(double delta, int n)
    {
        double eValue=1.0;
        double partialValue = (1.0 + (1.0/n));
        
        for(int i=1; i<=n; i++)
            eValue=eValue*partialValue;
        
        if (compareWithDelta(eValue, delta))
            System.out.println("e with second method = " + eValue);
        
        else 
            calculateEversion2(delta, n+1);
    }
    
/**
 * The following method implements the second method to calculate e
 * 
 * Brother's formula is implemented here
 * 
 * The formula is e = Sum of the series from n = 0 to infinity (2*n + 2)/(2*n + 1)!
 * The factorial method is called here to calculate the above denominator value
 * 
 * @param 	delta			Stores the value of error between actual value and calculated value
 * @param 	n				Stores the number of iterations required to achieve the required
 * 							level of accuracy for e
 * @param	eValue			Stores the calculated e value
 * @param	i				Stores the iteration value
 */
    
    
    public static void calculateEversion3(double delta, int n)
    {    
        double eValue = 0;
        
        for(int i = 0; i<=n; i++)
        {
            int denominator = factorial(2*i + 1);
            double numerator = 2*i + 2;
            double partialValue = numerator/denominator;
            eValue = eValue + partialValue;
        }
        
        if(compareWithDelta(eValue, delta))
            System.out.println("e with third method = " + eValue);
        
        else
            calculateEversion3(delta, n+1);
    }
    
/**
 * The following method calculates the factorial of a number
 * Recursion is used to calculate the value using 0!=1 as the base case
 * 
 * @param 	n			Stores the number whose factorial is to be calculated
 * 
 * @return				Returns the factorial calculated so far and finally the factorial of n
 */
    
    
    public static int factorial(int n)
    {
        if (n == 0)
            return 1;
        
        else
            return n*factorial(n-1);
    }
    
/**
 * The following method compares the calculated value of e using the above three methods with
 * the actual value of e computed with Math.E
 * 
 * @param 	delta			Stores the value of error between actual value and calculated value
 * @param 	n				Stores the number of iterations required to achieve the required
 * 							level of accuracy for e
 * 
 * @return					returns boolean value true if the condition is satisfied or else
 * 							it returns false
 */
    
    
    public static boolean compareWithDelta(double eValue, double delta)
    {        
        if ((Math.abs(eValue-Math.E))<=delta)
            return true;
        
        else
            return false;
    }
    
}  