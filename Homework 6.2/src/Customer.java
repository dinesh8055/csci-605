/** 
 * Customer.java
 *
 * @ Version: 
 *     $Id: Customer.java , Version 1.0 10/05/2014 $ 
 * 
 * Revisions: 
 *     $Log Initial Version $ 
 */

import java.util.Scanner;
import java.text.*;
/**
 * This program simulates a supermarket using the concept of abstract classes
 *
 * @author      Dinesh Gudi
 * @author      Rithvik Gambhir 
 */

abstract class BagOperations{
    abstract void add(String item_description, int number);
    abstract int getCount(String item_name);
}

abstract class CartOperations{
    abstract void add(String item_description, int number);
    abstract void addBag(Bag bag_object, int bag_number);
    abstract int getCount(String item_name);
    abstract int getTotalCount();

}
public class Customer{
    public static Cart cart1=new Cart();
    public static Cart cart2=new Cart();
    
/**
 * The following main() method takes the input from the customer
 * 
 * @param 	args 					Not used anywhere
 */
    
    public static void main(String[] args){
    	String more="no";
    	do{
	    takeDecisions();
	    System.out.println("Do you want to checkout? (yes/no)");
	    Scanner sc_more=new Scanner(System.in);
	    more=sc_more.nextLine();
    	}while(more.equals("no"));
    	Cashier ch=new Cashier(cart1,cart2);
    }
    
/**
 *  The following method takes the shopping decisions from the customer
 */
    
    static void takeDecisions(){
	String item;
	boolean item_valid = false;
        do{
        	System.out.println("Which of the following items do you want to add?\n"+"1. apple  2.orange  3.kiwi  4.flour  5.milk");
        	Scanner sc=new Scanner(System.in);
        	item = sc.nextLine();
        	item_valid=(item.equals("apple")||item.equals("orange")||item.equals("kiwi")||item.equals("flour")||item.equals("milk"));
		if(!item_valid) System.out.println("Choose from above given inputs");
	}while(!item_valid);
        	selectBagCart(item);
    }
    
/**
 * The following method asks the customer to select the bag and cart number to store the items
 * 
 * @param 	item_description		Stores the description of the item
 */
    
    static void selectBagCart(String item_description){
        System.out.println("Sure, how many would you like?");
        Scanner sc_number=new Scanner(System.in);
        int number_of_items = sc_number.nextInt();
	int cart_number,bag_number;
	String bag_decision;
	boolean valid_cart_number,valid_bag_decision,valid_bag_number;
	do{
	    System.out.println("Select a cart (1/2)");
            Scanner sc_cart_number=new Scanner(System.in);
            cart_number = sc_cart_number.nextInt();
	    valid_cart_number=(cart_number==1||cart_number==2);
	    if(!valid_cart_number) System.out.println("Enter from above given options");
	}while(!valid_cart_number);
	do{
            System.out.println("Do you want to put them in a bag? (yes/no)");
            Scanner sc_bag_decision=new Scanner(System.in);
	    bag_decision=sc_bag_decision.nextLine();
	    valid_bag_decision=bag_decision.equals("yes")||bag_decision.equals("no");
	    if(!valid_bag_decision) System.out.println("Enter valid input");
	}while(!valid_bag_decision);
        if(bag_decision.equals("no")&&cart_number==1){
            cart1.add(item_description,number_of_items);
        }
        else if(bag_decision.equals("no")&&cart_number==2){
            cart2.add(item_description,number_of_items);
        }
	else if(bag_decision.equals("yes")&&cart_number==1){
	    do{
		System.out.println("Which bag?(select a number from 1 to 100)");
            	Scanner sc_bag_number=new Scanner(System.in);
            	bag_number = sc_bag_number.nextInt();
	    	valid_bag_number=bag_number>0&&bag_number<100;
	    	if(!valid_bag_number) System.out.println("Enter Valid input");
	    }while(!valid_bag_number);
	    Bag bag=new Bag();
	    bag.add(item_description,number_of_items);
	    cart1.addBag(bag,bag_number);
	}
	else if(bag_decision.equals("yes")&&cart_number==2){
            do{	
		System.out.println("Which bag?(select a number from 1 to 100)");
            	Scanner sc_bag_number=new Scanner(System.in);
            	bag_number = sc_bag_number.nextInt();
            	valid_bag_number=bag_number>0&&bag_number<100;
            	if(!valid_bag_number) System.out.println("Enter Valid input");
	    }while(!valid_bag_number);
            Bag bag=new Bag();
            bag.add(item_description,number_of_items);
            cart2.addBag(bag,bag_number);
	}
    }  
}

/**
 * The following class Item contains the setItem method
 * 
 */

class Item{
    String description;
    int count;
    double price;
    
/**
 *  The following method stores the price of the chooses item
 *  
 * @param 	item_description		Stores the description of the item
 * @param 	number					Stores the number of items chosen
 */
    
    void setItem(String item_description, int number){
    	description=new String(item_description);
    	count=number;
    	if (item_description.equals("apple")) price=0.50;
    	else if(item_description.equals("orange")) price=0.70;
    	else if(item_description.equals("kiwi")) price=0.70;
    	else if(item_description.equals("flour")) price=0.70;
    	else price=0.33;
    }
}

/**
 * The following class Bag contains the add, remove and getCount methods
 */

class Bag extends BagOperations{
    Item[] items_bag=new Item[5];
    Bag(){
	for(int i=0;i<5;i++){
	    items_bag[i]=new Item();
        }
	items_bag[0].setItem("apple",0);
	items_bag[1].setItem("orange",0);
	items_bag[2].setItem("kiwi",0);
	items_bag[3].setItem("flour",0);
	items_bag[4].setItem("milk",0);
    }
    
/**
 * The following method adds the chosen items to a bag
 * 
 * @param 	item_description		Stores the description of the item
 * @param 	number					Stores the number of items chosen
 */
    
    public void add(String item_description, int number){
	for(int i=0;i<5;i++){
	    if(item_description.equals(items_bag[i].description)){
		items_bag[i].count=items_bag[i].count+number;
		break;
	    }
	}
    }
    
/**
 * The following method may be used to remove an item from the bag
 * 
 * @param 	item_description		Stores the description of the item
 * @param 	number					Stores the number of items chosen
 * 
 * @return							Return a boolean value to represent the successful removal of the item
 */
    
    public boolean remove(String item_description, int number){
	int remaining_items=0;
        for(int i=0;i<5;i++){
            if(item_description.equals(items_bag[i].description)){
		        if(remaining_items>=0){
                    items_bag[i].count=items_bag[i].count-number;
		            return true;
		        }
		        else{
		            return false;
		        }
            }
        }
        return false;
    }

/**
 *  The following method counts the number of items in the bag
 *  
 *  @param 	  item_name				Stores the description of the item
 *  
 *  @return							Returns the integer of the number of items in the bag
 */
    
    public int getCount(String item_name){
	for(int j=0;j<5;j++){
	    if(item_name.equals(items_bag[j].description))
		return items_bag[j].count;
	    }
	return 999;
    }
}

/**
 * The following class Cart contains the remove_cart, remove_bag_cart and add methods
 */

class Cart extends CartOperations{
    Item[] items_cart=new Item[5];
    Bag[] bags=new Bag[100];
    Cart(){
    	for(int i=0;i<5;i++){
	    items_cart[i]=new Item();
	}
	items_cart[0].setItem("apple",0);
	items_cart[1].setItem("orange",0);
	items_cart[2].setItem("kiwi",0);
	items_cart[3].setItem("flour",0);
	items_cart[4].setItem("milk",0);
    	for(int k=0;k<bags.length;k++){
    	    bags[k]=new Bag();
    	}
    }

/**
 * The following method may be used to remove an item from the cart
 * 
 * @param 	   item_description		Stores the description of the item
 * @param 	   number				Stores the number of items chosen
 * 
 * @return							Return a boolean value to represent the successful removal of the item
 */
    
    public boolean remove_cart(String item_description, int number){
    	int remaining_items=0;
        for(int i=0;i<5;i++){
            if(item_description.equals(items_cart[i].description)){
                if(remaining_items>=0){
                    items_cart[i].count=items_cart[i].count-number;
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }

/**
 * The following method may be used to remove an item from the bag in the cart
 * 
 * @param 	item_description		Stores the description of the item
 * @param 	number					Stores the number of items chosen
 * 
 * @return							Return a boolean value to represent the successful removal of the item
 */
    
    public boolean remove_bag_cart(String item_description, int number, int bag_number){
    	return bags[bag_number].remove(item_description,number);
    }

/**
 * The following method adds the chosen items to a cart
 * 
 * @param 	item_description		Stores the description of the item
 * @param 	number					Stores the number of items chosen
 */
    
    public void add(String item_description,int number){
	for(int i=0;i<5;i++){
	    if(item_description.equals(items_cart[i].description)){
		items_cart[i].count=items_cart[i].count+number;
	    	}
		}
    }

/**
 * The following method adds a bag to the cart
 * 
 * @param	bag_object				Stores the reference of the object bag
 * @param	bag_number				Stores the bag number
 */
    
    public void addBag(Bag bag_object, int bag_number){
	bags[bag_number]=bag_object;
    }

/**
 *  The following method counts the number of the particular  item in the cart
 *  
 *  @param 	  item_name				Stores the description of the item
 *  
 *  @return							Returns the integer of the number of items in the cart
 */
        
    public int getCount(String item_name){
	int count_in_bags=0;
	int count_in_cart=0;
	for(int i=0;i<100;i++){
	    count_in_bags=count_in_bags+bags[i].getCount(item_name);
	}
	for(int j=0;j<5;j++){
	    if(item_name.equals(items_cart[j].description)){
	        count_in_cart=count_in_cart+items_cart[j].count;
		    break;
	    }
	}
	return count_in_bags+count_in_cart;
    }

/**
 *  The following method counts the total number of items in the bag   
 *  
 *  @return							Return the total number of items in the cart
 */
    
    public int getTotalCount(){
	return getCount("apple")+getCount("orange")+getCount("kiwi")+getCount("flour")+getCount("milk");
    }    
}

/**
 * The following class Cashier contains a constructor to add the total items in the cart and bag 
 */

class Cashier{
    public Cashier(Cart cart1, Cart cart2){
	int total_items=cart1.getTotalCount()+cart2.getTotalCount();
	int total_apples=cart1.getCount("apple")+cart2.getCount("apple");
	int total_oranges=cart1.getCount("orange")+cart2.getCount("orange");
	int total_kiwis=cart1.getCount("kiwi")+cart2.getCount("kiwi");
	int total_flour=cart1.getCount("flour")+cart2.getCount("flour");
	int total_milk=cart1.getCount("milk")+cart2.getCount("milk");
	double total_cost=0;
	if(total_items>100){
	    System.out.println("you cannot shop more than 100 items");
	    System.out.println();
	}
	else{
	    Item[] items_total=new Item[5];
	    for(int i=0;i<5;i++){
    		items_total[i]=new Item();
    	    }
    	    items_total[0].setItem("apple",total_apples);
    	    items_total[1].setItem("orange",total_oranges);
    	    items_total[2].setItem("kiwi",total_kiwis);
    	    items_total[3].setItem("flour",total_flour);
    	    items_total[4].setItem("milk",total_milk);
    	    for(int j=0;j<5;j++){
    		total_cost=total_cost+(items_total[j].count*items_total[j].price);
    	    }
    	    Reciept bill=new Reciept();
    	    bill.printBill(items_total,total_cost);
	}
    }
}

/**
 * The following class Receipt contains the printBill method 
 */

class Reciept{
/**
 * The following method prints the bill in the required format
 * 
 * @param 	  items					Stores the description of the item
 * @param 	  total					Stores the bill generated
 * 
 */
	
    void printBill(Item[] items,double total){
	String item;
	for(int i=0;i<5;i++){
	    item=items[i].description;
	    if(item.length()==5){
		System.out.println(item+"  :  "+items[i].count+"("+(items[i].price)+")");
	    }
	    else if(item.length()==6){
	        System.out.println(item+" :  "+items[i].count+"("+(items[i].price)+")");
	    }
	    else{
		System.out.println(item+"   :  "+items[i].count+"("+(items[i].price)+")");
	    }
	}
	System.out.println("------------------");
	DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("cost   :  "+df.format(total));
        System.out.println("\nThank you for Shopping with us!\n");
    }
}
