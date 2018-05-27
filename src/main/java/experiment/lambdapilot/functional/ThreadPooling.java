package experiment.lambdapilot.functional;

/**
 * Created 5/8/2017 19:21
 *
 * @author Deepankar Sharma
 */
public class ThreadPooling {

  public static void main(String[] args) {
    Thread myThread = new Thread(new Runnable() {

      @Override public void run() {
        System.out.println("Nacho");
      }
    });
    Thread myThread2 = new Thread(() -> System.out.println("Nacho, Lambda is working"));
    myThread.run();
    myThread2.run();
  }
}
