package experiment.random;

/**
 * Created 5/15/2018 17:41
 *
 * @author Deepankar Sharma
 */
public class EnumNull {

  public enum ENUM {
    A, B, C;
  }

  public static void main(String[] args) {
    System.out.println(null != ENUM.A);
  }

}
