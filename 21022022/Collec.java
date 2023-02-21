import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;


public class Collec {
    public static void main(String[] argv){
        Stack<ClassA> a = new Stack<ClassA>();
        a.push(new ClassA());
        a.push(new ClassA(2, "help"));
        a.push(new ClassA(5, "hi"));
        int n = a.size();
        System.out.println(a);
        Object[] lst = a.toArray();
        System.out.println(lst[0]);

        // for(ClassA i:a){
        //     System.out.print(i.geti() + " ");
        // }

        // System.out.println();
        // Iterator<> it = a.iterator();
        // while(it.hasNext()){
        //     System.out.println(it.next());
        // }

    }
}

class ClassA{
    int i;
    String state;
    public ClassA(){}
    public ClassA(int i, String s){
        this.i = i;
        this.state = s;
    }
    public int geti(){
        return this.i;
    }
    public String gets(){
        return this.state;  
    }
    public void seti(int i){
        this.i = i;
    }
}