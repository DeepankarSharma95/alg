package experiment.random;

import java.util.ArrayList;
import java.util.List;

/**
 * Created 7/28/2017 19:10
 *
 * @author Deepankar Sharma
 */
public class RandomNumberTest {

  public static void main(String[] args) {
    getLink();
  }

  private static int getRandomIndex(int mn, int mx) {
    int p = 0;
    for (int i = 0; i < 1; i++) {
      int min = mn;
      int max = mx;
      p = ((int) (Math.random() * (max - min + 1)) + min);
    }
    return p;
  }

  public static void getLink() {
    List<String> arrList = new ArrayList<>();
    arrList.add("A");
    arrList.add("B");
    arrList.add("C");
    arrList.add("D");

    int index = getRandomIndex(0,3);
    System.out.println(index);
    String verical = arrList.get(index);
    System.out.println(verical);

  }


}
