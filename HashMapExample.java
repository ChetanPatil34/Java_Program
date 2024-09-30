import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();


        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);


        System.out.println("Value for key 'Apple': " + map.get("Apple"));


        if (map.containsKey("Banana")) {
            System.out.println("Banana is available in the map.");
        }


        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }


        map.remove("Orange");
        System.out.println("After removing 'Orange', map contains: " + map);


        if (map.isEmpty()) {
            System.out.println("Map is empty.");
        } else {
            System.out.println("Map is not empty.");
        }
    }
}
