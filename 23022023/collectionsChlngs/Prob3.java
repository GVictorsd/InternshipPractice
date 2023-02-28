// LinkedList Challenge: 
// Create a LinkedList of Strings and add the words “apple”, 
// “banana”, “cherry”, “date”, and “elderberry” to it. Remove the third 
// element from the LinkedList and print out the resulting list.

package collectionsChlngs;

import java.util.LinkedList;
import java.util.Iterator;

public class Prob3 {
    public static void main(String... args){
        // Initialize
        LinkedList<String> list = new LinkedList<String>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("date");
        list.add("elderberry");

        // Remove third element(element at index 2)
        list.remove(2);

        // Print the elements
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
