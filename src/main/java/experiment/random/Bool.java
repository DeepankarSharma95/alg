package experiment.random;

/**
 * Created 7/19/2017 21:36
 *
 * @author Deepankar Sharma
 */
public class Bool {

  public static void main(String[] args) {
    printBools();
    /*Boolean bool = null;
    System.out.println(bool);
    bool = new Boolean(null);
    System.out.println(bool);
    bool = new Boolean(null);
    System.out.println(bool);
    bool = new Boolean("Some random text");
    System.out.println(bool);*/
  }

  public static void printBools(){
    Boolean b1 = new Boolean(true);
    System.out.println(true == b1);
  }

}
