/*
 * Problem 13
 * Write a program to calculate the average of an array
 */

public class Prob13 {
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6};

        float sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("average: " + sum / arr.length);
    }
}
