import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<10; i++){
            list.add(i);
        }

        list.forEach( i -> {
            System.out.println(i);
        });

    }
}