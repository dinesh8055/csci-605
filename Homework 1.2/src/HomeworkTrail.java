public class HomeworkTrail
{
	public static void main(String args[])
	{
		char arr[] = {'a','b','c'};
		int x,z,i,j;
		int n=3;
		char p;
		String s;
		for(i = 0;i < n;i++)
		{
			p = arr[i];
			System.out.println(p);
			z = n - (i + 1);
			x = i + 1;
			while(z < 0)
			{
				for(j = x;j < n;j++)
				{
					s = "" + p + arr[j];
					System.out.println(s);
				}
				x++;
				z--;
			}
		}
	}
}		