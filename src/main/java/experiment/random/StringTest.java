package experiment.random;

/**
 * Created 11/23/2017 16:46
 *
 * @author Deepankar Sharma
 */
public class StringTest {

  public static void main(String[] args) {
    String str = "Deepankar";
    int index = str.lastIndexOf("Alpha");
    System.out.println(str.substring(0, index));
  }

}
