public class reverse
{
	public static void main(String args[])
	{
		String original = "Hello";
		String reversedPart="";
		for(int i=4; i>=0; i--)
		{
			reversedPart+=original.charAt(i);
			System.out.println("iteration number = "+i);
		}
		System.out.println(reversedPart);
	}
}