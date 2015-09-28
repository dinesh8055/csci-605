//public class Hanoi_int
//{
//	public static int count = 0;
//	public static int maximumDisks = 3;
//	public static void main(String[] args)
//	{
//		int poleStart[] = new int [maximumDisks];
//		int poleOver[] = new int [maximumDisks];
//		int poleEnd[] = new int [maximumDisks];
//		initialize(maximumDisks, poleStart, poleOver, poleEnd);
//		System.out.println("\nThe following moves are made\n");
//		move(maximumDisks, poleStart, poleOver, poleEnd);
//		print();
//	}
//	public static void move(int n, int poleStart[], int poleOver[], int poleEnd[])
//	{
//		//int j;
//		if(n == 1)
//		{
//			count++;
//			System.out.println(poleStart+" --> "+poleEnd);
//		}
//		else
//		{
//			
//			move(n-1, poleStart, poleEnd, poleOver);
//			print();
//			move(1, poleStart, poleOver, poleEnd);
//			print();
//			move(n-1, poleOver, poleStart, poleEnd);
//		}
//	}
//	public static void initialize(int maximumDisks, int poleStart[], int poleOver[], int poleEnd[])
//	{
//		for (int i = 0; i<maximumDisks; i++)
//		{
//			poleStart[i] = i+1;
//			poleOver[i] = 0;
//			poleEnd[i] = 0;
//			System.out.print(poleStart[i]+" ");
//			System.out.print(poleOver[i]+" ");
//			System.out.println(poleEnd[i]+" ");
//		}
//		System.out.println("------\n0 1 2");
//		
//	}
//	public static void print()
//	{
//		System.out.println("------\n0 1 2");
//	}
//	if (poleStart == "0" && poleOver == "1" && poleEnd == "2") {
//
//        for (int i = disks - 1; i >= 0; i--) {
//            if (disk_end[i] != 0) {
//                disk_end[i + 1] = disk_end[i];
//            }
//        }
//
//        disk_end[0] = disk_start[0];
//
//        for (int j = 0; j < disks; j++) {
//            if (disk_start[j] != 0) {
//                disk_start[j] = disk_start[j + 1];
//            }
//        }
//
//        for (int k = 0; k < disks; k++) {
//
//            System.out.println(disk_start[k] + " " + disk_aux[k] + " "
//                    + disk_end[k]);
//           
//
//           
//
//        }
//}