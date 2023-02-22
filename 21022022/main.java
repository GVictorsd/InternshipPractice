import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



class Hello {
    public static void main(String[] args) {

        // Hi h = new Hi();
        // A a = new A(5);
        // a.a = 10;
        // pint(a.a);

        // int []a = {4,2,4,6,7};
        // int n = a.length;
        // printarr(a);
        // Arrays.sort(a);

        // printarr(a);

        Simple s = new Simple(4);
        Simple a = new Simple(4);
        String st = "hi this";
        String sa = "hi this";
        System.out.println(s.hashCode() + " " + a.hashCode());


        // final Scanner sc = new Scanner(System.in);
        // int a[];
        // int n = sc.nextInt();
        // a = new int[n];

        // for(int i=0; i<n; i++){
        //     a[i] = sc.nextInt();
        // }

        // for(int i=0; i<n; i++){
        //     System.out.println(a[i]);
        // }


        // try {
        //     int a = 1/0;
        // } catch (Exception e) {
        //     System.out.println("Exception!!!");
        // }

        // Simple s = new Simple();
        // System.out.println(s.geti());

        // Dum d = new Dum();
        // d.seti(3);
        // System.out.println(d.geti());

        // final int a;
        // a = 10;
        // // pint(a);

        // String s = "hello";
        // // pch(s.charAt(1));
        // // System.out.println(s.compareTo("hello"));
        // System.out.println(s.endsWith("hell"));

        // String c[];
        // c = new String[5];
        // Scanner sc = new Scanner(System.in);
        // for(int i=0; i<5; i++){
        //     c[i] = sc.nextLine();
        // }
        // // for(int i:c){
        // //     pint(i);
        // // }
        // for(int i=0; i<5; i++){
        //     System.out.println(c[i]);
        // }




        // System.out.println(a.geta());

        // B b = new B(9);
        // pint(b.geta());
        // pint(b.getb());

        // for (int I=0; I<5; I++){
        //     Scanner sc = new Scanner(System.in);
        //     int i = sc.nextInt();

        //     System.out.println(i%2==0 ? "even" : "odd");
        // }

        // int[] a = {1,2,3};
        // for(int i=0; i<a.length; i++){
        //     System.out.println(a[i]);
        // }


        // Scanner sc = new Scanner(System.in);
        // int i = sc.nextInt();

        // switch(i){
        //     case 0:
        //     System.out.print("zero");
        //     break;
        //     case 1:
        //     System.out.print("one");
        //     break;
        //     default:
        //     System.out.print("none");
        //     break;
        // }

        // switch(i)

        // switch (key) {
        //     case value:
                
        //         break;
        
        //     default:
        //         break;
        // }

        // if(i%2 == 0){
        //     System.out.println("even");
        // }else{
        //     System.out.println("odd");
        // }
    }


    public static void pint(int i){
        System.out.println(i);
    }
    public static void pstr(String i){
        System.out.println(i);
    }
    public static void pch(char i){
        System.out.println(i);
    }
    public static void printarr(int[] a){
        System.out.println();
        for(int i:a){
            System.out.print(i + " ");
        }

    }
}

// class Dum extends Ap{
//     public Dum(){
//         super();
//         System.out.println("Dum Con");
//     }
//     public int getab(){
//         return 0;
//         // return this.i;
//     }
// }

// class A{
//     int a;

//     A(int a){
//         this.a = a;
//     }

//     int geta(){
//         return a;
//     }
//     void seta(int i){
//         a = i;
//     }
// }

// class B extends A{
//     int b;
//     public B(int a, int b){
//         super(a);
//         this.b = b;
//     }

//     public B(int a){
//         super(a);
//     }

//     @Override
//     public int geta(){
//         return this.a;
//     }

//     public int getb(){
//         return this.b;
//     }

// }
