/*
 * Problem 9
 * Program to check if an element exists in a LinkedList
 */

import java.util.LinkedList;

public class Prob9 {
    public static void main(String[] args) {
        LinkedList <Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(2);
        list.add(8);
        list.add(14);

        int key = 2;
        System.out.println("key " + key + " exists: " + exists(list, key));

        key = 20;
        System.out.println("key " + key + " exists: " + exists(list, key));

    }

    public static Boolean exists(LinkedList<Integer> list, int key) {
        return list.indexOf(key) != -1;
    }
}
