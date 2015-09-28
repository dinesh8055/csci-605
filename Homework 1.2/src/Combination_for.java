public class Combination_for
{

	public static void main(String args[])
	{
		String object[] = {"a","b","c","d"};
		int n = 4;
		System.out.print("{ {}");
		for(int i=0;i<n;i++)
		{
			System.out.print(", {"+object[i]+"}");
			for(int j=i+1;j<n;j++)
			{
				System.out.print(", {"+object[i]+object[j]+"}");
				for(int k=j+1;k<n;k++)
				{
					System.out.print(", {"+object[i]+object[j]+object[k]+"}");
					for(int l=k+1;l<n;l++)
					{
						System.out.print(", {"+object[i]+object[j]+object[k]+object[l]+"}");
					}
				}	
			}
		}
		System.out.print(" }");
	}
}