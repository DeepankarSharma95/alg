package experiment.random;

import java.util.Timer;

/**
 * Created 1/4/2018 00:39
 *
 * @author Deepankar Sharma
 */
public class TimerTest {

  public static void main(String[] args) throws InterruptedException {
    long initialTime = System.currentTimeMillis();
    Thread.sleep(5000L);
    long finalTime = System.currentTimeMillis();
    System.out.println((double)(finalTime - initialTime) / 1000.0);
  }

}
