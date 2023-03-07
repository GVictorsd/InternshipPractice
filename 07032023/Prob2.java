/*
 * create an integer array and print the sum of elements using for each loop
 */

public class Prob2 {
    public static void main(String[] args) {
        int [] arr = new int[10];

        for(int i=0; i<10; i++){
            arr[i] = i+1;
        }

        int sum = 0;
        for(int i : arr){
            sum += i;
        }

        System.out.println(sum);
    }
    
}
