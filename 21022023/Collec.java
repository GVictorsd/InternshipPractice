import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;


public class Collec {
    public static void main(String[] argv){
        // ArrayList<ClassA> a = new ArrayList<ClassA>();
        // a.add(new ClassA());
        // a.add(new ClassA(2, "help"));
        // a.add(new ClassA(5, "hi"));
        // int n = a.size();
        // System.out.println(a);
        // Object[] lst = a.toArray();
        // System.out.println(lst[0]);


        // LinkedList<String> a = new LinkedList<String>();
        // a.add("hello");
        // a.add("hi");
        // a.add("bye");
        // int n = a.size();
        // for(String i:a){
        //     System.out.print(i + " ");
        // }
        // Iterator it = a.iterator();
        // while(it.hasNext()){
        //     System.out.println(it.next());
        // }

        // Vector<ClassA> a = new Vector<ClassA>();
        // a.add(new ClassA());
        // a.add(new ClassA(2, "help"));
        // for(ClassA i:a){
        //     System.out.print(i.geti() + " ");
        // }
        // a.contains(new ClassA(2, "help"));
        // Object[] lst = a.toArray();
        // System.out.println(lst[0]);

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
