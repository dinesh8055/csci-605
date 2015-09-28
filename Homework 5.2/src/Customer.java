/** 
 * Customer.java
 *
 * @ Version: 
 *     $Id: Customer.java , Version 1.0 09/29/2014 $ 
 * 
 * Revisions: 
 *     $Log Initial Version $ 
 */

import java.util.Scanner;
import java.text.*;
/**
 * This program simulates a supermarket
 *
 * @author      Dinesh Gudi
 * @author      Rithvik Gambhir 
 */

public class Customer{
    public static Cart cart1=new Cart();
    public static Cart cart2=new Cart();
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
    static void takeDecisions(){
        System.out.println("Which of the following items do you want to add?\n"+"1. apple  2.orange  3.kiwi  4.flour  5.milk");
        Scanner sc=new Scanner(System.in);
        String item = sc.nextLine();
        selectBagCart(item);
    }

    static void selectBagCart(String item_description){
        System.out.println("Sure, how many would you like?");
        Scanner sc_number=new Scanner(System.in);
        int number_of_items = sc_number.nextInt();
	    System.out.println("Select a cart (1/2)");
        Scanner sc_cart_number=new Scanner(System.in);
        int cart_number = sc_cart_number.nextInt();
        System.out.println("Do you want to put them in a bag? (yes/no)");
        Scanner sc_bag_decision=new Scanner(System.in);
	    String bag_decision=sc_bag_decision.nextLine();
        if(bag_decision.equals("no")&&cart_number==1){
            cart1.add(item_description,number_of_items);
        }
        else if(bag_decision.equals("no")&&cart_number==2){
            cart2.add(item_description,number_of_items);
        }
	    else if(bag_decision.equals("yes")&&cart_number==1){
			System.out.println("Which bag?(select a number from 1 to 100)");
            Scanner sc_bag_number=new Scanner(System.in);
            int bag_number = sc_bag_number.nextInt();
			Bag bag=new Bag();
			bag.add(item_description,number_of_items);
			cart1.addBag(bag,bag_number);
	    }
	    else if(bag_decision.equals("yes")&&cart_number==2){
            System.out.println("Which bag?(select a number from 1 to 100)");
            Scanner sc_bag_number=new Scanner(System.in);
            int bag_number = sc_bag_number.nextInt();
            Bag bag=new Bag();
            bag.add(item_description,number_of_items);
            cart2.addBag(bag,bag_number);
	    }
    }  
}

class Item{
    String description;
    int count;
    double price;
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

class Bag{
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
    void add(String item_description, int number){
		for(int i=0;i<5;i++){
	    	if(item_description.equals(items_bag[i].description)){
				items_bag[i].count=items_bag[i].count+number;
				break;
	    	}
		}
    }
    int getCount(String item_name){
		for(int j=0;j<5;j++){
	    	if(item_name.equals(items_bag[j].description))
				return items_bag[j].count;
		}
		return 999;
    }
}

class Cart{
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

    public void add(String item_description,int number){
		for(int i=0;i<5;i++){
	    	if(item_description.equals(items_cart[i].description)){
				items_cart[i].count=items_cart[i].count+number;
				//System.out.println(items_cart[i].count);
			}
			//System.out.println(items_cart[i].count);
		}
    }

    public void addBag(Bag bag_object, int bag_number){
		bags[bag_number]=bag_object;
    }

    int getCount(String item_name){
	    int count_in_bags=0;
		int count_in_cart=0;
		for(int i=0;i<100;i++){
	    	count_in_bags=count_in_bags+bags[i].getCount(item_name);
		}
		for(int j=0;j<5;j++){
	    	if(item_name.equals(items_cart[j].description))
	    	{
				count_in_cart=count_in_cart+items_cart[j].count;
				break;
			}
		}
		return count_in_bags+count_in_cart;
    }

    int getTotalCount(){
		return getCount("apple")+getCount("orange")+getCount("kiwi")+getCount("flour")+getCount("milk");
    }    
}

class Cashier{
    public Cashier(Cart cart1, Cart cart2){
	    int total_items=cart1.getTotalCount()+cart2.getTotalCount();
	    int total_apples=cart1.getCount("apple")+cart2.getCount("apple");
	    int total_oranges=cart1.getCount("orange")+cart2.getCount("orange");
	    int total_kiwis=cart1.getCount("kiwi")+cart2.getCount("kiwi");
	    int total_flour=cart1.getCount("flour")+cart2.getCount("flour");
	    int total_milk=cart1.getCount("milk")+cart2.getCount("milk");
	    double total_cost=0;
	    if(total_items>100) System.out.println("Sorry, you cannot shop for more than 100 items");
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

class Reciept{
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
        System.out.println("\nThank you for shpping with us!\n");
	}
}
