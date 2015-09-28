//class FlowC
//{
//   int[] numbers = { 3, 5, 6, 1, 0, -1, 22, 14, 5, 9, 0, 1, -1 };
//
//   static boolean trueIfZero(double n) {
//	return n == 0.0;
//   }
//   static boolean greaterZero(double n) {
//	return n > 0.0;
//   }
//   static double aDividedByN(double a, double b)      {
//	return a / b;
//   }
//
//   static int test_1(int n)	{
//	if ( ++n == 1 )
//		return 1;
//	else if ( n-- == 1 )
//		return 2;
//	else if ( --n == 0 )
//		return 3;
//	else
//		return 4;
//   }
//   static int test_2(int n)	{
//        n = -1;
//	while ( n < 4 )	{
//		if ( n-- == -1 )
//			n = 1;
//		if ( ( n + 1 ) % 2 == 0 )
//			n = 2;
//		else if ( n == 3 )
//			n = n++;
//		n = n + n;
//	}
//	if ( ( n = 1 ) == 1 )
//		n = 3;
//	return n;
//   }
//   static int test_3(int a, int b)	{
//	if ( a < b )
//		return a;
//	else
//		return b;
//   }
//   static double test_4(double a, double b)	{
//	if  (trueIfZero(a) )
//		return aDividedByN(b , a );
//	if  (greaterZero(a) | trueIfZero(a) )
//		return aDividedByN(b , a );
//	if  (greaterZero(a) || trueIfZero(a) )
//		return aDividedByN(b , a );
//	if  (greaterZero(a) & trueIfZero(a) )
//		return aDividedByN(b , a );
//	if  (greaterZero(a) && trueIfZero(a) )
//		return aDividedByN(b , a );
//	if  (! greaterZero(a) && ! trueIfZero(a) )
//		return aDividedByN(b , a );
//	if  ( greaterZero((int)a >>1 ) && trueIfZero(a) )
//		return aDividedByN(b , a );
//	if  ( greaterZero((int)a >>>1 ) && trueIfZero(a) )
//		return aDividedByN(b , a );
//   }
//
//
//   public static void main(String args[])
//   {  
//
//	// a) create 4 statements so such test_1 returns all possible values
//	// is it possible to get all 4 possible values?
//	 System.out.println("a:	test_1(0):	" + test_1(i) );
//	 
//	 /**
//	  * It is not possible to get all the 4 possible values This is because
//	  * the third else if statement is exactly the same as the second one. 
//	  * Therefore, for any number satisfying the second else if condition, 
//	  * the second return statement is reached after which the following
//	  * if statements are not executed. The following 3 statements show how
//	  * we may obtain the other 3 return statements.
//	  * 
//	  * System.out.println("a:	test_1(0):	" + test_1(0) );
//	  * System.out.println("a:	test_1(1):	" + test_1(0) );
//	  * System.out.println("a:	test_1(4):	" + test_1(4) );
//	  *  
//	  */
//
//	// b) explain the execution of test_2
//	System.out.println("b:	test_2(2):	" + test_2(2) );
//	
//	/**
//	 * Firstly, the value n=2 is passed from the method. Then, n is assigned
//	 * a new value -1 in the method. This passes the while condition since
//	 * -1 is less than 4. The first if statement changes the value of n to -2 
//	 * and the equality test fails. The second if condition also fails and so 
//	 * does the else if statement since n is now -2 and not 3. Finally, n=n+n
//	 * is executed making n=-4. This way the while loop runs infinitely. However, 
//	 * the if condition always returns true since n is assigned the value 1 and 
//	 * then compared with value 1. This makes the value of n, 3 and hence making
//	 * it return value 3.
//	 * 
//	 */
//
//	// c) simplyfiy test_3 by using a ?: statement
//	System.out.println("c:	test_2(2):	" + test_2(2) );
//	
//	/**
//	 * The above code may be replaced with the following
//	 * 
//	 * static int test_3(int a, int b)	{
//	 * 		return (a > b ? a : b);
//	 * }
//	 *  
//	 */
//	
//	// d) find the minumum of all numbers in number by using one for loop
//	
//	/**
//	 * int minimum = number[0];
//	 * for (int i=0; i <  numbers.length; i++ )
//	 * {
//	 *		minimum = minimum<number[i] ? minimum : number[i];
//	 *	}
//	 */
//
//	// e) test_4 wil not compile, why? Fix it?
//	// create a/b pairs, so such all return statements are executed
//	// is it possible to execute all  return statements.
//	System.out.println("e:	test_3(2, 2):	" + test_3(2, 2) );
//	
//	/**
//	 * test_4 will fail because it is expecting double value in return. 
//	 * Since all the statements are if statements, there is no certainty 
//	 * that the statements will be executed. We may add an else statement 
//	 * to remove the aforementioned error. 
//	 * 
//	 * All the return values are not possible. See the following possible statements.
//	 * 
//	 * System.out.println("e1:	test_4(0, 1):	" + test_4(0, 1) );
//	 * System.out.println("e2:	test_4(1, 1):	" + test_4(1, 1) );
//	 * System.out.println("e6:	test_4(2, 2):	" + test_4(-1, 1) );
//	 */
//
//   }
//}
