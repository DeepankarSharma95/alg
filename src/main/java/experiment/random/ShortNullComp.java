package experiment.random;

/**
 * Created 12/31/2017 01:11
 *
 * @author Deepankar Sharma
 */
public class ShortNullComp {

  public static void main(String[] args) {
    Short s = null;
    System.out.println(s > new Short((short)0));
  }

}
