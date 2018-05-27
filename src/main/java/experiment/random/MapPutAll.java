package experiment.random;

import java.util.HashMap;
import java.util.Map;

/**
 * Created 5/7/2018 00:48
 *
 * @author Deepankar Sharma
 */
public class MapPutAll {

  public static void main(String[] args) {
    Map<String, Object> innerMap = new HashMap<>();
    innerMap.put("X", "x");
    innerMap.put("Y", "y");
    Map<String, Object> outerMap = new HashMap<>();
    outerMap.put("Z", "z");
    outerMap.putAll(innerMap);
    System.out.println(outerMap);
    System.out.println(true == Boolean.TRUE);
  }

}
