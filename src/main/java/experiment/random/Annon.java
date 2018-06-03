package experiment.random;

/**
 * Created 01-06-2018 16:04
 *
 * @author Deepankar Sharma
 */
public class Annon {

  public static void main(String[] args) {
    Thread t = new Thread(new Runner());
  }

  public static class Runner implements Runnable {

    @Override public void run() {
      System.out.println("Something");
    }
  }

}
