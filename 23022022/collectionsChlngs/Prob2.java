// HashMap Challenge: 
// Create a HashMap with String keys and Integer values. Add key-value 
// pairs for “John” - 25, “Mary” - 30, and “Bob” - 35. Loop through the 
// HashMap and print out each key-value pair.

package collectionsChlngs;
import java.util.HashMap;
import java.util.Set;

public class Prob2 {
    public static void main(String... args){
        // Initialize
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("John", 25);
        map.put("Mary", 30);
        map.put("Bob", 35);

        // Iterate and print the elements
        Set<String> keys = map.keySet();
        for(String key: keys){
            System.out.println(key + " " + map.get(key));
        }
    }
}
