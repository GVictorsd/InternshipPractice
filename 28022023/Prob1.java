/*
 * Problem 1
 * Write a Java program to create a new Array list, add some elements (string) and print out the collection.
 */

import java.util.ArrayList;

public class Prob1 {
        
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("string1");
        list.add("string2");
        list.add("string3");

        for (String s : list) {
            System.out.println(s);
        }
    }
}
