/*
 * Problem 12
 * Write a program to empty a HashSet
 */

import java.util.HashSet;

public class Prob12 {
    public static void main(String[] args) {
        // initialize hashset
        HashSet <Integer> set = new HashSet<Integer>();
        set.add(10);
        set.add(2);
        set.add(8);

        System.out.println("set before clearing: " + set);
        set.clear();
        System.out.println("set after clearing: " + set);

    }
}
