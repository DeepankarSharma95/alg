package experiment.random;

/**
 * Created 2/15/2018 01:26
 *
 * @author Deepankar Sharma
 */
public class StringSplit {

  public static void main(String[] args) {
    String str = "ABC";
    for(String s : str.split(","))
    System.out.println(s);
  }
}
