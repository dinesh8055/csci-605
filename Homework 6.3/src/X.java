public class  X {
        static int staticX = 0;
        int instanceX = 0;

        public X()    {		
        	// why is this one needed?
        	/*
        	 * Default constructor, though does not interfere with the compilation of X.java, it is needed when 
        	 * XX.java is compiled. This is because the constructor in XX need it to be defined explicitly as X 
        	 * is the super class. 
        	 */
        }
        public X(int i)    {
		staticX   = i;
		instanceX = i * 2;
		System.out.println("X cons static " + staticX);
		System.out.println("X cons ins " + instanceX);		
        }
        public String  toString(){
		return "X: staticX/instanceX = " + staticX + "/" + instanceX;
  	}
        //static public void sMethod(int i){
        public static void sMethod(int i){
		staticX   += i;
		System.out.println("sMethod in X static " + staticX);
	}
        public static void iMethod(int i){
		staticX   += i;
		System.out.println("iMethod in X static " + staticX);
        }
        public void iMethodX(int i){
		staticX   += i;
		instanceX += i * 2;
		System.out.println("iMethodX in X static " + staticX);
		System.out.println("iMethodX in X ins " + instanceX);
        }
        public static void main(String args[] )       {
        }
}