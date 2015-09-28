public class Ehalf
{
	public static void main(String args[])
	{
		double delta = 0.0001;
		//double e2 = calculateEversion2(delta, 1);
		//System.out.println(e2);
		calculateEversion2(delta, 1);
		//double e3 = calculateEversion3(delta, 0);
		//System.out.println(e3);
		calculateEversion3(delta, 0);
	}
	
	public static void calculateEversion2(double delta, int n)
	{
		double eValue=1.0;
		double partialValue = (1.0 + (1.0/n));
		
		for(int i=1; i<=n; i++)
			eValue=eValue*partialValue;
		
		if (compareWithDelta(eValue, delta))
			System.out.println("eValue in if of e2 for n = "+ n +" = " + eValue);
		
		else 
			calculateEversion2(delta, n+1);
	}
	
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
			System.out.println("eValue in if of e3 for n = "+ n +" = " + eValue);
		
		else
			calculateEversion3(delta, n+1);
	}
	
	public static int factorial(int n)
	{
		if (n == 0)
			return 1;
		
		else
			return n*factorial(n-1);
	}
	
	public static boolean compareWithDelta(double eValue, double delta)//for e value accuracy
	{		
		if ((Math.abs(eValue-Math.E))<=delta)
			return true;
		
		else
			return false;
	}

}

