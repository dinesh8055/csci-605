//public class Hanoi 
//{
//	public static int maximumDisks = 3;
//	public static void main(String[] args)
//	{
//		int diskStart[] = new int [maximumDisks];
//		int diskOver[] = new int [maximumDisks];
//		int diskEnd[] = new int [maximumDisks];
//		System.out.println("The following moves are made\n");
//		move(maximumDisks, "0", "1", "2");
//	}
//	public static void initialize(int n)
//	{
//		
//	}
//	public static void move(int n, String poleStart, String poleOver, String poleEnd)
//	{
//		if(n == 1)
//		{
//			System.out.println(poleStart+" --> "+poleEnd+"\n");
//			tower(maximumDisk, diskStart, diskOver, diskEnd);
//		}
//		else
//		{
//			move(n-1, poleStart, poleEnd, poleOver);
//			
//			move(1, poleStart, poleOver, poleEnd);
//			move(n-1, poleOver, poleStart, poleEnd);
//		}
//	}
//	if (poleStart == "0" && poleOver == "1" && poleEnd == "2") {
//
//        for (int i = maximumDisks - 1; i >= 0; i--) {
//            if (diskEnd[i] != 0) {
//                diskEnd[i + 1] = diskEnd[i];
//            }
//        }
//
//        diskEnd[0] = diskStart[0];
//
//        for (int j = 0; j < maximumDisks; j++) {
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