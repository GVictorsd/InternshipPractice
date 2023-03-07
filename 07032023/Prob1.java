/*
 * Create a string array and print each element using for-each loop
 */

public class Prob1 {
    public static void main(String[] args){
        String [] arr = new String[4];

        arr[0] = "str1";
        arr[1] = "str2";
        arr[2] = "str3";
        arr[3] = "str4";

        for(String i : arr){
            System.out.println(i);
        }

    }
}