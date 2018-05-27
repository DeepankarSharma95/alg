package experiment.random;

/**
 * Created 8/12/2017 21:02
 *
 * @author Deepankar Sharma
 */
public class SingleTonClass {

  private static SingleTonClass ourInstance = new SingleTonClass();

  public static SingleTonClass getInstance() {
    return ourInstance;
  }

  private SingleTonClass() {
  }
}
