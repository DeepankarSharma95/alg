package experiment.lambdapilot.oops;

/**
 * Created 5/8/2017 15:11
 *
 * @author Deepankar Sharma
 */
public class Greet {

  public void greet(Greeting greeter) {
    greeter.perform();
  }

  public static void main(String[] args) {
    Greet g = new Greet();
    g.greet(new Greeter());
  }

}
