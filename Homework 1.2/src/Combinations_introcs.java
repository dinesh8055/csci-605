//public class Combinations_introcs {
//	
//	public static void main(String[] args) {
//	       int N = Integer.parseInt(args[0]);
//		   String a = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
//	       String e = a.substring(0, N);
//
//	      combo(e);
//	       System.out.println();
//	    }
//
//    public static void combo(String s) { 
//    	combo("", s);
//    	}
//    private static void combo(String prefix, String s) {
//        System.out.println("result "+prefix);
//        
//        for (int i = 0; i < s.length(); i++)
//        {
//        	
//        
//            comb2(prefix + s.charAt(i), s.substring(i + 1));
//           
//          
//        }
//    } 
//
//    
//}