// PriorityQueue Challenge: 
// Create a PriorityQueue of Strings and add the words “banana”,
// “apple”, “date”, “cherry”, and “elderberry” to it. Print out the 
// first element of the PriorityQueue and then remove it. Loop through 
// the PriorityQueue and print out each remaining element.

package collectionsChlngs;

import java.util.PriorityQueue;

public class Prob5 {
    public static void main(String[] args) {
        // Initialize
        PriorityQueue<String> que = new PriorityQueue<String>();
        que.add("banana");
        que.add("apple");
        que.add("date");
        que.add("cherry");
        que.add("elderberry");

        // get first element of que
        System.out.println(que.peek());
        // remove first element of que
        que.poll();

        // Print remaining elements
        for(String s: que){
            System.out.println(s);
        }

    }
}
