package experiment.random;

import java.io.File;
import java.util.Date;

/**
 * Created 3/14/2018 22:33
 *
 * @author Deepankar Sharma
 */
public class TouchingTheFile {

  public static void main(String[] args) {
    File file = new File("FILE PATH GOES HERE");
    System.out.println(new Date(file.lastModified()));
  }

}
