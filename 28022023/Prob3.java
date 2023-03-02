/*
 * Problem 3
 * Write a program to insert an element into the array list at the first position.
 */

import java.util.ArrayList;

public class Prob3 {
    public static void main(String[] args) {
        // initial array list
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        // insert 0 at the beginning of the list
        list.add(0, 0);

        for(Integer i : list) {
            System.out.println(i);
        }

    }
    
}
