/*
 * Write a Java program to update specific array element by given element 
 */

import java.util.ArrayList;
public class Prob5 {
    public static void main(String[] args) {
        // initial array list
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("Before update ");
        for(Integer i : list) {
            System.out.println(i);
        }

        // replace the second element with 5
        int index = 1;
        list.set(index, 5);


        System.out.println("After replacing");
        for(Integer i : list) {
            System.out.println(i);
        }
    }
    
}
