package experiment.random;

/**
 * Created 3/14/2018 11:57
 *
 * @author Deepankar Sharma
 */
public class SwitchFallThru {

  public static void main(String[] args) {
    fallThru("A");
    fallThru("B");
    fallThru("C");
    fallThru("D");
    fallThru("E");
    fallThru("X");


  }

  public static void fallThru(String x) {
    System.out.println("\n\nFor " + x);
    switch(x) {
    case "A":
    case "B":
    case "C":
      System.out.println("Hello World");
    case "D":
      System.out.println("Post hello world without break");
      break;
    case "E":
      System.out.println("Case E");
      break;
    default:
      System.out.println("Default");
      break;
    }
  }

}
