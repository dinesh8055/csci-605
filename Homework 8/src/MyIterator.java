/** 
 * MyIterator.java
 *
 * @ Version: 
 *     $Id: MyIterator.java , Version 1.0 10/19/2014 $ 
 * 
 * Revisions: 
 *     $Log Initial Version $ 
 */

import java.util.*;

/**
 * This program implements a iterator class
 *
 * @author      Dinesh Gudi
 * @author      Rithvik Gambhir 
 */

/**
 * The following class Cell is defined as the basic element of the Linked List
 */

class Cell {
	String data;
	Cell next;
	Cell(){
		data=null;
		next=null;
	}
}
/**
 * The following class MyIterator implements the Linked List
 *
 */

class MyIterator<E> implements Iterator{
	Cell nextElem;
	Cell start=new Cell();
	int count=0;
	int nextCount=0;
	Node root;
	MyIterator(Node root){
		nextElem=null;
		this.root=root;
	}
	/**
	 * The adds elements to the Linked List
	 * 
	 * @param 	str			Stores the value of the String to be added
	 */
	
	void add(String str){
		Cell x=new Cell();
		Cell y=new Cell();
		Cell z=new Cell();
		y=null;
		x=start;
		z.data=str;
		while(x!=null){
			y=x;
			x=x.next;
		}
		if(count==0){
			start=z;
			count++;
		}
		y.next=z;
	}
	
	/**
	 * The following method checks whether Linked List contains a next element or not
	 * 
	 * @return				Returns a boolean value depending on whether Linked List contains a next element or not
	 */
	
	public boolean hasNext(){
		//if()
		if(nextCount==0){
			nextCount++;
			if(this.root==null) return false;
			nextElem=this.start;
			if(nextElem!=null) return true;
			else return false;
		}
		else if(nextElem!=null){
			nextElem=nextElem.next;
			if(nextElem!=null) return true;
			else return false;
			//System.out.println("NextElement!=null");
		}
		return false;
	}

	/**
	 * The following method returns the next element in the List
	 * 
	 * @return				Returns the Cell that is present in the next position in the List
	 */
	
	public Cell next(){
		return nextElem;
	}

	/**
	 * The following method is defined to use the interface. It's not used anywhere in the code
	 * 
	 * @return				Returns null
	 */
	
	public java.util.Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * The following method is defined to use the interface. It's not used anywhere in the code
	 * 
	 */
	
	public void remove() {
		// TODO Auto-generated method stub		
	}
}

/**
 * The following code was used in the initial revision process for debugging
 * 
 * @param 	args		 Not used anywhere			
 */

/*public class IteratorDemo{
	public static void main(String[] args){
		Iterator iter=new Iterator();
		iter.add("a");
		iter.add("g");
		iter.add("b");
		iter.add("c");
		//Cell x=iter.start;
		while(iter.hasNext()){
			System.out.println(iter.next().data);
		}
		Iterator iter1=new Iterator();
		iter1.add("1");
		iter1.add("4");
		iter1.add("2");
		iter1.add("3");
		//Cell x=iter1.start;
		while(iter1.hasNext()){
			System.out.println(iter1.next().data);
		}
	}
}*/