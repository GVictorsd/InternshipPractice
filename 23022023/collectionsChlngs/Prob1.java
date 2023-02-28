// ArrayList Challenge: 
// Create an ArrayList of integers and add the numbers 1 through 10 to it. 
// Loop through the ArrayList and print out each number.


package collectionsChlngs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Prob1 {
    public static void main(String[] args) {
        // Initialize an ArrayList with the elements:
        ArrayList<Integer> arr = new ArrayList<Integer>(
            Arrays.asList(1,2,3,4,5,6,7,8,9,10)
        );

        // arr.add(1);
        // arr.add(2);
        // arr.add(3);
        // arr.add(4);
        // arr.add(5);
        // arr.add(6);
        // arr.add(7);
        // arr.add(8);
        // arr.add(9);
        // arr.add(10);

        // Print using a for-each loop
        for(Integer i: arr){
            System.out.print(i + " ");
        }

        System.out.println();

        // Print using an iterator
        Iterator<Integer> it = arr.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }

        System.out.println();
    }
}
