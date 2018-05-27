package experiment.random;

/**
 * Created 7/7/2017 15:02
 *
 * @author Deepankar Sharma
 */
public class CastNullToBoolean {

  public static void main(String[] args) {
    Object o = null;
    Boolean b = (Boolean) o;
    System.out.println(b);
  }

}
