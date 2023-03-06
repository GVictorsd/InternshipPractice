/*
 * Problem 14
 * Write a program to find the second smallest element in an array
 */

public class Prob14 {
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 7, 8, 10};

        int min = arr[0];
        int secMin = arr[0];
        for(int i: arr){
            if(i < min){
                secMin = min;
                min = i;
            }
        }

        System.out.println("Second max element: " + secMin);


    }
}