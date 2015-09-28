      public class  X {
        static int x1 = 0;
        int o1 = 1;

        public X()    {
        }
        static public void methodX1(int i){
              x1 = i;
              System.out.println("methodX1: " + x1 );
        }
        public void methodX2(int i){
              x1 = i;
              o1 = i;
              System.out.println("methodX2: " + this);
              System.out.println("    x1 " + x1);
              System.out.println("    o1 " + o1);
        }

        public static void main(String args[] )       {
              X aX = new X();
              X aaX = new X();

              aX.methodX1(1);
              aaX.methodX1(2);

              aX.methodX2(3);
              aaX.methodX2(4);
        }
}

/**
 * Explanation:
 * 
 *Here, the objects, aX and aaX for the class X are created.
 *The method methodX1() is called with object aX and parameter 1 
 *1 is passed. Now, x1 is assigned with integer value 3 and the 
 *System.out.println statement is executed resulting in the following
 *methodX1: 1
 *
 *Then method methodX1() is called with object aaX. This time, 
 *x1 is assigned with integer 2 and the System.out.println statement
 *is executed as follows
 *methodX1: 2
 *
 *Now methodX2() is called from object aX. Here, two assignments 
 *occur. x1 and o1 are assigned as integer 3. System.out.println 
 *statements following that are then executed. 
 *methodX2: (address of the object aX)
 *	x1 3
 *	o1 3
 *
 *Then, the method is called with object aaX and parameter 4 is 
 *passed. Here again the two assignments occur, namely, x1 to 4 
 *o1 to 4. Both being of type int. Then the System.out.println
 *statements are executed as follows.
 *methodX2: (address of the object aaX)
 *	x1 4
 *	o1 4
 */
    
      class  XX extends X {
          static int x1 = 0;
          int o1 = 1;

          public XX()    {
          }
          public void methodX2(int i){
                x1 = i;
                o1 = i;
                System.out.println("methodX2: " + this);
                System.out.println("    x1 " + x1);
                System.out.println("    o1 " + o1);
          }

          public static void main(String args[] )       {
                X aX = new X();
                X aXX = new XX();

                aX.methodX1(1);
                aXX.methodX1(2);

                aX.methodX2(3);
                aXX.methodX2(4);

  	      aX = (aXX);
                aX.methodX2(3);
                aX.methodX2(4);

  	      
          }
  }

/**
 * Explanation:
 * 
 * Here, class XX which is the subclass of X is defined.
 * Objects aX and aXX are created for the classes X and XX 
 * respectively. 
 * 
 * First, methodX1() is called with object aX. The control 
 * is then passed to parent class X where method X1 is defined
 * and parameter 1 is passed. Hence the following output.
 * methodX1: 1
 * 
 * Then, methodX1() is called with object aXX. The control goes
 * to parent class X since methodX1() is not defined in XX and
 * parameter 2 is passed. Hence the following output.
 * methodX2: 2
 * 
 *  Now, methodX2() is called with object aX. The control then 
 *  goes to the method defined in class X. Assignments to x1
 *  and o1 take place and the System.out.println statements are
 *  executed as follows
 *  methodX2: (address of object aX)
 *  	x1 3
 *  	o1 3
 *  
 *  Here, methodX2() is called with object aXX. The control this 
 *  time goes to the method defined in class XX. Assignments are
 *  done with integer 4 and the System.out.println statements are 
 *  executed as follows
 *  methodX2: (address of object aXX)
 *  	x1 4
 *  	o1 4
 *  
 *  Now, the object aX is assigned with aXX. Therefore, the methodX2()
 *  called with object aX takes control to the method defined in class
 *  XX this time. Hence the System.out.println statements are 
 *  executed as follows
 *  For parameter 3
 *  methodX2: (address of object aXX)
 *  	x1 3
 *  	o1 3
 *  
 *  method X2: (address of object aXX)
 *  	x1 4
 *  	o1 4
*/