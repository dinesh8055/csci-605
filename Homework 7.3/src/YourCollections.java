///** 
// * YourCollections.java
// *
// * @ Version: 
// *     $Id: YourCollections.java , Version 1.0 10/12/2014 $ 
// * 
// * Revisions: 
// *     $Log Initial Version $ 
// */
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
///**
// * This program implement the shuffle and sort methods
// * @author      Dinesh Gudi
// * @author      Rithvik Gambhir 
// */
//
//class YourCollections{
//
///**
// * The following method implements the shuffling algorithm
// * 
// * @param 	list1			Stores the given list
// */
//	
//    public static void shuffle(List list1){
//    ArrayList list2=new ArrayList();
//    int x;
//    while(!list1.isEmpty()){
//        x=randNum(0,list1.size()-1);
//        list2.add(list1.get(x));
//        list1.remove(x);
//    }
//    list1.addAll(list2);
//    }
//
///**
// * The following method sorts the List using bubble sort
// * 
// * @param 	list			Stores the list to be sorted
// * @param 	c				Stores the comparator
// */
//    
//    public static void sort(List list,Comparator c) {
//          Object[] arr = list.toArray();
//          boolean swapped = true;     
//          int j = 0;
//          Object tmp;
//          while (swapped) {
//
//            swapped = false;
//
//            j++;
//           
//            int x;
//
//            for (int i = 0; i < arr.length - j; i++) {                                      
//                  x=c.compare(arr[i],arr[i+1]);
//                  if (x>0) {                         
//
//                        tmp = arr[i];
//
//                        arr[i] = arr[i + 1];
//
//                        arr[i + 1] = tmp;
//
//                        swapped = true;
//
//                  }
//
//
//            }
//           
//
//
//          }
//      list.clear();
//      List al=new ArrayList();
//      al=Arrays.asList(arr);
//      list.addAll(al);   
//
//    }
//}