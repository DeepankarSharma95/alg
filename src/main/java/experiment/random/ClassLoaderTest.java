package experiment.random;



/**
 * Created 12/6/2017 14:10
 *
 * @author Deepankar Sharma
 */
public class ClassLoaderTest {

  public static void main(String[] args) {
    new ClassLoaderTest().someMethod();
  }

  //@CallerSensitive
  public void someMethod() {
    //Reflection.getCallerClass(5);
  }

}
