package experiment.random;

import java.util.ArrayList;
import java.util.List;

/**
 * Created 2/15/2018 01:23
 *
 * @author Deepankar Sharma
 */
public class BlankArrayList {

  public static void main(String[] args) {
    List<String> arrayList = new ArrayList<>();
    for(String str : arrayList) {
      System.out.println("Something");
    }
    System.out.println("Outside Something");
  }
}
