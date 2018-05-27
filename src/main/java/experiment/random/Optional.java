package experiment.random;

import java.util.Map;

/**
 * Created 5/7/2018 00:33
 *
 * @author Deepankar Sharma
 */
public class Optional {

  public void optionalMethod(java.util.Optional<Map<String, Object>> map) {
    if(map.isPresent()) {
      System.out.println("It's present");
    }
  }

  public static void main(String[] args) {
    Optional obj = new Optional();
    //obj.optionalMethod();
  }
}
