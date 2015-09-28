public class  XX  extends X {

        static int staticX = 0;
        int instanceX = 0;

        public XX(int i)    {
		staticX   = i;
		instanceX = i * 2;
		System.out.println("XX cons static " + staticX);
		System.out.println("XX cons ins " + instanceX);		
        }
        public String  toString(){
		return "X: staticX/instanceX = " + staticX + "/" + instanceX;
  	}
        //static public void sMethod(int i){
        public static void sMethod(int i){
		staticX   += i;
		System.out.println("sMethod in XX static " + staticX);
	}
        public static void iMethod(int i){
		staticX   += i;
		System.out.println("iMethod in XX static " + staticX);
        }
        public void iMethodX(int i){
		staticX   += i;
		instanceX += i * 2;
		System.out.println("iMethodX in XX static " + staticX);
		System.out.println("iMethodX in XX ins " + instanceX);
        }
        public void iMethodXX(int i){
		staticX   += i;
		instanceX += i * 2;
		System.out.println("iMethodXX in XX static " + staticX);
		System.out.println("iMethodXX in XX ins " + instanceX);
        }
        public static void main(String args[] )       {
		X   aX1 = new X(1);
		X   aX2 = new XX(2);
		XX aXX1 = new XX(3);
			
		System.out.println("\naX1.sMethod(4);");
		aX1.sMethod(4);
		System.out.println("\naX1.iMethodX(5);");
		aX1.iMethodX(5);
		//aX1.iMethodXX(6); This must be removed because iMethodXX(int) is not defined in class X

		System.out.println("\naX2.sMethod(7);");
		aX2.sMethod(7);
		System.out.println("\naX2.iMethodX(8);");
		aX2.iMethodX(8);
		//aX2.iMethodXX(9); This must be removed because iMethodXX(int) is not defined in class X of which type object aX2 is.

		System.out.println("\naXX1.sMethod(10);");
		aXX1.sMethod(10);
		System.out.println("\naXX1.iMethodX(11);");
		aXX1.iMethodX(11);
		System.out.println("\naXX1.iMethodXX(11);");
		aXX1.iMethodXX(11);

		aX1 = aXX1;
		System.out.println("\naX1.sMethod(4);");
		aX1.sMethod(4);
		System.out.println("\naX1.iMethodX(5);");
		aX1.iMethodX(5);
		//aX1.iMethodXX(6); This must be removed because iMethodXX(int) is not defined in class X of which aXX1 is now assigned to.
        }
}

/**
 * When XX.java is executed, the following takes place.
 * 
 * Firstly, objects aX1, aX2 and aXX1 are created which are of
 * the types X, X and XX respectively. These are however referenced
 * with the class objects X, XX and XX respectively. Then methods
 * from both classes are being called. The following then takes place.
 * 
 * Constructor in class X is called first and parameters are passed setting 
 * staticX to 1 and instance X to 2. The above is repeated for the other two 
 * objects setting in class XX, staticX to 2 and instantX to 4. Then to 3 
 * and 6 respectively with the creation of the next object.
 * 
 * Then aX1.sMethod(4) sets staticX in X to 5. aX1.iMethodX(5) sets
 * in X, staticX to 10 and instantX to 12. 
 * 
 * aX2.sMethod(7) overwrites the existing value of staicX in X to 17.
 * aX2.iMethod(8) sets staticX and instantX in XX to 11 and 20 respectively.
 * 
 * aXX1.sMethod(10) then overwrites staticX in XX to 21. aXX1.iMethodX(11) 
 * sets staticX in XX to 32 and instantX to 28. Then aXX1.iMethodXX(11) changes
 * the value of staticX in XX class to 43 and instantX to 50. 
 * 
 * Then object aX1 is assigned to aXX1. The following sMethod then overwites
 * staticX in X to 21 and aX1.iMethod(5) overwites staticX in XX to 48
 * and instantX to 60.
 * 
 *
 */