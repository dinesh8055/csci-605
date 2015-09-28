/** 
 * RandomNumbers.java
 *
 * @ Version: 
 *     $Id: RandomNumbers.java , Version 1.0 10/12/2014 $ 
 * 
 * Revisions: 
 *     $Log Initial Version $ 
 */

import java.util.Iterator;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * This program stores 1000 random generated numbers with the following given requirements
 *
 *Requirement 1: Duplicate numbers are ignored; the elements are ordered using their natural ordering, the first is < 
 *than the second, etc;
 *
 *Requirement 2: Duplicate numbers are ignored; constant time performance for the basic operation;
 *
 *Requirement 3: Duplicate numbers are not ignored; constant time performance for the basic operation;
 *
 * @author      Dinesh Gudi
 * @author      Rithvik Gambhir 
 */

class NoDuplicateTree{

/**
 * The following method generates the required random numbers
 * 
 * @return				Returns an int datatype, randomly generated number
 */
	
    public static int randInt() {
        int abc= (int)(Math.random()*10000);
        return(abc);
    }

/**
 * The following method prints the tree according to Requirement 1
 * 
 * @param 	iter		Stores the value of the number of iterations required
 */
    
    public static void printTree(Iterator<Integer> iter){
        System.out.print("[ ");
        while (iter.hasNext()) {
		System.out.print(iter.next() + " "+",");
	}
	System.out.print("\b\b ]\n");
    }

/**
 * The following method is used to make the tree and store the values
 * 
 * @return				Returns the iterator
 */
    
    public static Iterator<Integer> makeTree(){
	TreeSet<Integer> tree = new TreeSet<Integer>();
	while(tree.size()<1000){
	    tree.add(randInt());
	}
	Iterator<Integer> iterator = tree.iterator();
	return iterator;
    }
}
   
/**
 * The following class NoDuplicateHash implements Requirement 2
 * 
 */

class NoDuplicateHash{

/**
 * The following method generates the required random numbers
 * 
 * @return				Returns an int datatype, randomly generated number
 */
    public static int randInt() {
        int abc= (int)(Math.random()*10000);
        return(abc);
    }

/**
 * The following method prints the HashSet
 * 
 * @param 	iter		Stores the value of the number of iterations required
 */
    
    public static void printHash(Iterator<Integer> iter){
        System.out.print("[ ");
        while (iter.hasNext()) {
		System.out.print(iter.next() + " "+",");
	}
	System.out.print("\b\b ]\n");
    }

/**
 * The following method makes the HashSet and stores the values
 * 
 * @return				Returns the iterator
 */
    public static Iterator<Integer> makeHash(){
	HashSet hash = new HashSet(1000);
	while(hash.size()<1000){
	    hash.add(randInt());
	}
	Iterator<Integer> iterator = hash.iterator();
	return iterator;
    }
}

/**
 * The following class implements Requirement 3
 * 
 */

class ListWithDuplicates{

/**
 * The following method generates the required random numbers
 * 
 * @return				Returns an int datatype, randomly generated number
 */
	
    public static int randInt() {
        int abc= (int)(Math.random()*10000);
        return(abc);
    }

/**
 * The following method prints the LinkedList
 * 
 * @param 	iter		Stores the value of the number of iterations required
 */
    
    public static void printList(Iterator<Integer> iter){
        System.out.print("[ ");
        while (iter.hasNext()) {
		System.out.print(iter.next() + " "+",");
	}
	System.out.print("\b\b ]\n");
    }

/**
 * The following method makes the LinkedList and stores the values
 * 
 * @return				Returns the iterator
 */
    
    public static Iterator<Integer> makeList(){
	LinkedList list = new LinkedList();
	while(list.size()<1000){
	    list.add(randInt());
	}
	Iterator<Integer> iterator = list.iterator();
	return iterator;
    }
}

/**
 * The following class creates objects to other classes
 * 
 */

class RandomNumbers{
	
/**
 * The following main() method creates the objects to the other classes
 * 
 * @param 	args		Not used
 */
	
    public static void main(String[] args){
        Iterator<Integer> iter1=NoDuplicateTree.makeTree();
        NoDuplicateTree.printTree(iter1);
        Iterator<Integer> iter2=NoDuplicateHash.makeHash();
        NoDuplicateHash.printHash(iter2);
	Iterator<Integer> iter3=ListWithDuplicates.makeList();
	ListWithDuplicates.printList(iter3);
    }
}
