/*

**

* Program that displays all possible combinations of objects

*

* @version   $Id: Combination.java,v 1.02 2014/31/08 23:05:46 dinesh Exp dinesh  $

*

* @authors   Dinesh Gudi, Rithvik Gambhir

*

* Revisions:

*

*        Revision 1.01  2014/31/08 16:19:12  rithvik

*        Revision 1.02  2014/31/08 19:19:12  dinesh

*

*/



import java.util.*;

public class Combination{

    public static void main(String[] args){//main program

        /* Creates new ArrayList and adds elements */

        ArrayList objects=new ArrayList();

        objects.add("a");

        objects.add("b");

        objects.add("c");

//        objects.add("d");

//        objects.add("e");

        objects=subsetsOf(objects);        //Calls subsetsOf() and copies the returned reference in objects.

        /* Prints the ArrayList in desired format. */

        System.out.print("{ ");

        for(Object temp:objects){

            System.out.print("{"+temp+"}, ");

        }

        System.out.print("\b\b }\n");

    }



    public static ArrayList subsetsOf(ArrayList objects){// The subsetsOf() function.

        Object an=objects.get(objects.size()-1);               //gets nth element in the ArrayList

        if (objects.size()<2){//base case when there is only one element in the list

            ArrayList bcl=new ArrayList();

            bcl.add(" ");

            bcl.add(an);

            return(bcl);

        }

        objects.remove(objects.indexOf(an));

        return combine(subsetsOf(objects),an,subsetsOf(objects));    //recursive function call to subsetOf()

    }

/* combines lists subsetsOf(objects) and subsetsOf(objects) X nth element. */

    public static ArrayList combine(ArrayList list1, Object nth_element,ArrayList cpy_list1){

        ArrayList list2=new ArrayList();    //creates new ArrayList object

        list2.addAll(list1);                //adds all elements in subsetsOf(objects) to list2

        for(Object temp:list1){// appends all the objects in list2 with nth element

            if(temp.equals(" ")){// checks redundant " " and replaces them with nth element

                list2.set(list2.indexOf(temp),(String)nth_element);

            }

            else{

                list2.set(list2.indexOf(temp),(String)nth_element+(String)temp);

            }

        }

        list1.addAll(list2); // adds the lists

        return list1;

    }

}