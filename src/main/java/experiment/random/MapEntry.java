package experiment.random;

import java.util.HashMap;
import java.util.Map;

/**
 * Created 3/7/2018 17:27
 *
 * @author Deepankar Sharma
 */
public class MapEntry {

  public static void main(String[] args) {
    Map<Long, String> map = new HashMap<>();
    map.put(1L,"A");
    map.put(1L,"B");
    System.out.println(map);
  }

}
