package experiment.random;

/**
 * Created 5/27/2018 22:30
 *
 * @author Deepankar Sharma
 */
public class R extends Q {

  @Override public void print() {
    super.print();
    System.out.println("R");
  }

  public static void main(String[] args) {
    R obj = new R();
    obj.print();
  }
}
