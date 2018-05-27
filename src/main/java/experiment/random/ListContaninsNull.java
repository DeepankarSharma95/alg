package experiment.random;

import java.util.ArrayList;
import java.util.List;

/**
 * Created 12/29/2017 16:00
 *
 * @author Deepankar Sharma
 */
public class ListContaninsNull {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    System.out.println(list.containsAll(null));
  }

}
