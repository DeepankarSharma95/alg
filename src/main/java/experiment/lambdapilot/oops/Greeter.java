package experiment.lambdapilot.oops;

/**
 * Created 5/8/2017 15:07
 *
 * @author Deepankar Sharma
 */
public class Greeter implements Greeting {

  @Override public void perform() {
    System.out.println("Hello World!");
  }
}
