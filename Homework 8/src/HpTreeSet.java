/** 
 * HpTreeSet.java
 *
 * @ Version: 
 *     $Id: HpTreeSet.java , Version 1.0 10/19/2014 $ 
 * 
 * Revisions: 
 *     $Log Initial Version $ 
 */

import java.util.Iterator;

/**
 * This program implements a Tree Set class
 *
 * @author      Dinesh Gudi
 * @author      Rithvik Gambhir 
 */

/**
 * The following class Node is the basic element of the Tree
 * It contains constructor which initializes all the variables to null
 */

class Node{
	Node parent;
    Node left;
    Node right;
    String key;
    Node(){
    	parent = null;
    	left=null;
    	right=null;
    	key=null;
    }
}

/**
 * The following class HpTreeSet implements the Tree Set  
 * The constructor sets the initial value of the root node to nulls
 */

public class HpTreeSet<E> extends java.util.TreeSet<E>{
	static Node root;
	HpTreeSet(){
		root = null;
	}
	
	/**
	 * The following method adds an element to the Tree Set
	 * 
	 * @param	e			Object being added 
	 * 
	 * @return 				Returns a boolean value depending on whether the Object was added successfully or not
	 */
	
	public boolean add(Object e){
		Node x=new Node();
		Node y=new Node();
		Node z=new Node();
		z.key=e.toString();
		y=null;
		x=root;
		while(x!=null){
			y=x;
			if(z.key.compareTo(x.key)<0) x=x.left;
			else if(z.key.compareTo(x.key)==0) return false;
			else x=x.right;
		}
		z.parent=y;
		if (y==null) {
			root=z;
			return true;
		}
		else if(z.key.compareTo(y.key)<0) {
			y.left=z;
			return true;
		}
		else if(z.key.compareTo(y.key)>0){
			y.right=z;
			return true;
		}
		else {
			return false;
		}

	}
	/**
	 * The following method checks whether the Tree Set is empty or not
	 * 
	 * @return				Returns a boolean value depending on whether the Tree Set is empty or not
	 */
	
	public boolean isEmpty(){
		if(root==null) return true;
		else return false;
	}
	
	/**
	 * The following method checks of the Tree Set contains the given Object
	 * 
	 * @param	key			Stores the value of the object being checked		
	 * 
	 * @return				Returns a boolean value depending on whether the Tree Set contains the object or not
	 */
	
	public boolean contains(Object key){
		String k=key.toString();
		Node x=this.root;
		while(x!=null){
			if(k.compareTo(x.key)==0) return true;
			else if(k.compareTo(x.key)<0) x=x.left;
			else x=x.right;
		}
		return false;
	}
	
	/**
	 * The following method clears the Tree Set by setting the root value to null
	 *
	 */
	
	public void clear(){
		this.root=null;
	}
		
	/**
	 * The following method traverses the Tree in order and adds the Object to the Linked List
	 * 
	 * @param 	currNode	Stores the value of the current node
	 * @param 	iter		Stores the iterator
	 * 
	 * @return				Returns the iterator object
	 */
	
	public MyIterator inOrderTraversal(Node currNode,MyIterator iter)
	{
		if(currNode!=null)
		{
			inOrderTraversal(currNode.left,iter);	
			iter.add(currNode.key);
			inOrderTraversal(currNode.right,iter);
		}
		return iter;
	}

	/**
	 * The following method implements the iterator by adding elements to it
	 * 
	 * @return				Returns the iterator
	 */
	
	public Iterator<E> iterator(){
		Node currNode=this.root;
		MyIterator iter=new MyIterator(this.root);
		return (Iterator<E>) (inOrderTraversal(currNode,iter));
	}

	/**
	 * The following method calculates the size of the Tree Set by using a counter
	 * 
	 * @return				Returns the int value size of the Tree Set
	 */
	
	public int size(){
		int count=0;
		MyIterator iter=(MyIterator) this.iterator();
		if(this.root==null) return 0;
		while(iter.hasNext()){
			count++;
		}
		return count;
	}
	
	/**
	 * The following main() was used in the initial revision process for debugging
	 * 
	 * @param 	args		 Not used anywhere
	 */
	
/*	public static void main(String[] args){
		HpTreeSet tree=new HpTreeSet();
		tree.add(4);
		tree.add(6);
		tree.add(3);
		tree.add(1);
		tree.add(7);
		tree.add(9);
		tree.clear();
		System.out.println(tree.size());
		MyIterator iter=(MyIterator) tree.iterator();
		System.out.println(iter+" "+tree.root+" "+iter.hasNext());
		while(iter.hasNext()){
			System.out.println("has element"+" "+iter.hasNext());
		}
	}*/
}