public class E2
{
	public static void main(String args[])
	{
		double delta = 0.0001;
		double e2 = calculateEversion2(delta, 1);
		System.out.println("The value of e2 = "+e2);
	}
	public static double calculateEversion2(double delta, int n)
	{
		double eValue=1.0;
		double reci=(1.0/n);
		double part=(1.0+reci);
		for(int i=0; i<n; i++)
		{
			eValue=eValue*part;
		}
		if (compareWithDelta(eValue, delta))
		{
			System.out.println("Error "+Math.abs(eValue-Math.E));
			System.out.println("Calc eValue " + eValue);
			System.out.println("Actual eValue "+Math.E);
			return eValue;
		}
		else 
		{
			n++;
			System.out.println("Hi");
			calculateEversion2(delta, n);
			return 0;
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

