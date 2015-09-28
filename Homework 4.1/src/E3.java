public class E3
{
	public static void main(String args[])
	{
		double delta = 0.0001;
		double e3 = calculateEversion3(delta, 0);
		System.out.println("The value of e3 = "+e3);
	}
	public static double calculateEversion3(double delta, int n)
	{	
		double eValue = 0;
		for(int i = 0; i<=n; i++)
		{
			int denominatorPartial = 2*i + 1;
			int denominatorFull = factorial(denominatorPartial);
			double numerator = 2*i + 2;
			double partialValue = numerator/denominatorFull;
			eValue = eValue + partialValue;
		}
		if(compareWithDelta(eValue, delta))
		{
			System.out.println("For n value in if "+n+"eValue is "+eValue);			
			return eValue;
		}
		else
		{
			n++;
			calculateEversion3(delta, n);
			System.out.println("For n value in else "+n+"eValue is "+eValue);
			return eValue;
		}
	}
	public static int factorial(int n)
	{
		if (n == 0)
			return 1;
		else
		{
			return n*factorial(n-1);
		}
	}
	public static boolean compareWithDelta(double eValue, double delta)//for e value accuracy
	{		
		if ((Math.abs(eValue-Math.E))<=delta)
			return true;
		else
			return false;
	}
}
