package experiment.lambdapilot.functional;

/**
 * Created 5/8/2017 19:07
 *
 * @author Deepankar Sharma
 */
public class TypeInference {

  public static void main(String[] args) {
    TestInterface t = s -> { return s.length(); };
    System.out.println(t.getLength("Hello"));
  }

  interface TestInterface {
    int getLength(String s);
  }

}
