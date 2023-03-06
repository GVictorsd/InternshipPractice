/*
 * Problem 8
 * Write a program to traverse a LinkedList 
 */

import java.util.LinkedList;
import java.util.Iterator;

public class Prob8 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(2);
        list.add(8);
        list.add(14);

        Iterator <Integer> it = list.iterator();
        System.out.println("using Iterator" );
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }

        System.out.println();

        System.out.println("using for each loop");
        for(Integer i : list) {
            System.out.print(i+ " ");
        }
    }
}
