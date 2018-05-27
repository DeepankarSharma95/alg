package experiment.lambdapilot.functional;

/**
 * Created 5/8/2017 16:55
 *
 * @author Deepankar Sharma
 */
public class Greet {

  private void greet(Greeting greeting) {
    greeting.perform();
  }

  public static void main(String[] args) {
    Greet greet = new Greet();
    greet.greet(() -> System.out.println("Hello World! ~ Lambda"));
    Greeting greeting = () -> System.out.println("Hello World! ~ From interface instance");
    greet.greet(greeting);
  }
}
