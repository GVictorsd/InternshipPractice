public class Varargs {
    public static void main(String... args){
        for(String i : args){
            print(i);
        }

        method1("str1", "str2", "str3");
        method2(56, "str1", "str2", "str3");
    }


    public static void method1(String... str){
        for(String i:str){
            print(i);
        }
    }

    public static void method2(int n, String... str){
        print(n);
        for(String i: str){
            print(i);
        }
    }

    public static void print(Object ob){
        System.out.println(ob);
    }
}
