/*
 * Problem 10
 * Write a program to convert a LinkedList to an ArrayList
 */

import java.util.LinkedList;
import java.util.ArrayList;

public class Prob10 {
    public static void main(String[] args) {
        // initialize linkedList
        LinkedList <Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(2);
        list.add(8);
        list.add(14);

        // convert to arrayList
        ArrayList <Integer> arrayList = new ArrayList<Integer>(list);

        for(Integer i: arrayList){
            System.out.println(i);
        }

        
    }
}
