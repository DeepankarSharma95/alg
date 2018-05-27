package experiment.random;

import java.util.HashMap;
import java.util.Map;

/**
 * Created 7/7/2017 11:25
 *
 * @author Deepankar Sharma
 */
public class HashMapDemo {

  public static void main(String[] args) {
    Map<String, String> map = new HashMap<>();
    map.put("a", "a");
    map.put("b", "b");
    map.put("c", "c");
    map.put("d", "d");
    map.put("e", "e");
    map.put("f", "f");
    System.out.println("Map:" + map);
  }
}
