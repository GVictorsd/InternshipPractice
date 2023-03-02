import java.util.ArrayList;
/*
 * Problem 2
 * Write a Java program to iterate through all elements in a array list
 */

import java.util.Iterator;

public class Prob2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator it = list.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
