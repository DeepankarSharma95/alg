package experiment.random;

/**
 * Created 3/25/2018 11:46
 *
 * @author Deepankar Sharma
 */
public class PassingNull {

  public static void main(String[] args) {
    callMe(null);
  }

  public static void callMe(Object obj) {
    System.out.println("inside object: " + obj);
  }

  public static void callMe(String str) {
    System.out.println("inside string: " + str);
  }

  /*public static void callMe(Integer integer) {
    System.out.println("inside integer: " + integer);
  }*/

}
