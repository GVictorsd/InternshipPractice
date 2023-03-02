/*
 * Write a Java program to retrieve an element (at a specified index) from a given array list.
 */

import java.util.ArrayList;

public class Prob4 {
    public static void main(String[] args) {
        // initial array list
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        // get the second element(at index 1)
        int index = 1;
        Integer result = list.get(index);

        System.out.println(result);
    }
    
}
