/*
 * Problem 11
 * Write a program to compare two LinkedLists
 */

import java.util.LinkedList;
public class Prob11 {
    public static void main(String[] args) {
        // initialize linkedList
        LinkedList <Integer> list1 = new LinkedList<Integer>();
        list1.add(10);
        list1.add(2);
        list1.add(8);
        list1.add(14);

        LinkedList <Integer> list2 = new LinkedList<Integer>();
        list2.add(10);
        list2.add(23);
        list2.add(8);
        list2.add(14);


        System.out.println("list1 equals list2: " + list1.equals(list2));

    }
}
