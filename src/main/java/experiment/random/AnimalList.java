package experiment.random;

import java.util.ArrayList;
import java.util.List;

/**
 * Created 7/24/2017 16:25
 *
 * @author Deepankar Sharma
 */
public class AnimalList {

  static public List<Dog> dogs() {
    List dogs = new ArrayList<Dog>();
    dogs.add(new Dog());
    return dogs;
  }

  public static void main(String... arg) {
    List animals = dogs();
  }

}
