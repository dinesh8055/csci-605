///*
//*Program to find the maximum number of queens possible in the given board
//*
//*Authors: Dinesh Gudi, Rithvik Gambhir
//*
//*Still working on the program
//*
//*/
//public class Board
//{
//	static int maxQueen=0;
//	static int count=0;
//	static int N=8;
//	
//	public static void main(String args[])
//	{
//		int[][] arr = new int[N][N];
//		for(int row=0; row<N; row++)
//		{
//			for(int column=0; column<N; column++)
//			{
//				arr[row][column]=0;
//			}
//		}
//		recursion(0,0,arr[N][N]);
//		System.out.println("The maximum number of queens that can be placed on the board is" + maxQueen);
//	}
//	public static boolean isQueenSafe(int x, int y, int arr)
//	{
//		for(int row=0; row<N; row++)
//		{
//			for(int column=0; column<N; column++)
//			{
//				if(x==row||
//				   y==column||
//				   x-row==y-column)
//				{
//					return false;
//				}
//				else
//				{
//					return true;
//				}
//			}
//		}
//		return true;
//	}		  
//	public static void maxQueen(int count)
//	{
//		if(count>maxQueen)
//		{
//			maxQueen=count;
//		}
//	}
//	public static void recursion(int x, int y, int arr)
//	{
//		for(int row=0; row<N; row++)
//		{
//			for(int column=0; column<N; column++)
//			{
//				if(isQueenSafe(x, y, arr))
//				{
//					arr[row][column]=1; //place queen if true
//					count++;
//					maxQueen(count);
//				}
//				else
//				{
//					if(y==N-1)
//					{
//						y=0;
//						x++;
//					}
//				}
//				recursion(x,(y+1),arr);
//			}
//		}
//	}
//}