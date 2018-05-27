package experiment.random;

import java.util.ArrayList;
import java.util.List;

/**
 * Created 5/31/2017 12:02
 *
 * @author Deepankar Sharma
 */
public class AB {

  public static void main(String arg[]) {
    List<Long> longList = new ArrayList<>();
    longList.add(1l);
    longList.add(null);
    longList.add(null);
    System.out.println(longList.size());
  }
}
