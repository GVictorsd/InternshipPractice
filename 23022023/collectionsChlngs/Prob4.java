// TreeSet Challenge: 
// Create a TreeSet of integers and add the numbers 5, 3, 8, 2, 
// and 6 to it. Loop through the TreeSet and print out each number in ascending order.

package collectionsChlngs;
import java.util.TreeSet;

public class Prob4 {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(5);
        set.add(3);
        set.add(8);
        set.add(2);
        set.add(6);

        // print elements of set in ascending order
        for(Integer i: set){
            System.out.println(i);
        }

    }
}
