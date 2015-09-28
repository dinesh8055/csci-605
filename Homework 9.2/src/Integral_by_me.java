//
//public class Integral {
//	
//	public static int result = 0;
//	public static final double delta = 0.01;
//	
//	public void calculateIntegral() {
//		int partResult = 0;
//		for(int x = -1; x <= 1; x+=1) {
//			for(int y = -2; y <= 2; y+=1) {
//				partResult += x * x + y + y;
//				System.out.println("partResult " + partResult);
//			}
//		}
//		System.out.println("partResult " + partResult);
//	}
//	
//	public void printIntegrand() {
//		System.out.println("The delta allowed was " + delta);
//		System.out.println("The Integrand is " + result);
//	}
//	
////	public void run() {
////		
////	}
//	
//	public static void main(String args[]) {
//		Integral aIntegral = new Integral();
//		aIntegral.calculateIntegral();
//		aIntegral.printIntegrand();
//	}
//}
////double integral will use the fact that the function is f(x,y) =  x * x + y + y
////
////limits are
////-1 <= x <= 1
////-2 <= y <= 2
////
////check with delta
////
////each thread computes area of 0.1*0.1. However, this can be done later
////
////methods needed
////main() - call the calc method and print result
////run() - later, it'll basically split the threads using for loops which will then calc 
////		in multi threads
////calcIntegral() - calcultes the integral, uses the fact that area under the curve goes in 
////				steps of 0.1 for x and y and send the result to print method so that
////				it may be printed
////printResult() - prints the result

