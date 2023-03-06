/*
 * Problem 6
 * Write a program to search an element in an ArrayList.
 */

import java.util.ArrayList;

public class Prob6 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(7);
        list.add(3);
        list.add(10);
        list.add(14);

        int key = 10;
        int index = list.indexOf(key);

        if(index == -1) {
            System.out.println("Element not found");
        }
        else {
            System.out.println("Element found at index " + index);
        }

    }
}
