package experiment.random;

/**
 * Created 8/15/2017 21:06
 *
 * @author Deepankar Sharma
 */
public class PlusAndConcat {

  public static void main(String[] args) {
    String s1 = "Hello";
    s1 = s1.concat(" World!");
    String s2 = "Hello";
    s2 += " World!";
    System.out.println(s1);
    System.out.println(s2);
  }
}
