package experiment.lambdapilot.functional;

import experiment.lambdapilot.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created 5/9/2017 22:34
 *
 * @author Deepankar Sharma
 */
public class ForEachExample {

  public static void main(String[] args) {
    List<Person> people = Arrays.asList(
        new Person("Deepankar", "Sharma", 22),
        new Person("Some", "Other", 30),
        new Person("Another", "Name", 22),
        new Person("Second", "Name", 23),
        new Person("Third", "Name", 34)
    );
    people.parallelStream().forEach(wrapperExceptionHandler(ForEachExample::updateAge));
    people.stream().forEach(System.out::println);
  }

  public static void updateAge(Person person) {
    person.setAge(10);
  }

  public static Consumer<Person> wrapperExceptionHandler(Consumer<Person> consumer) {
    return (groupie) -> {
      try {
        consumer.accept(groupie);
      } catch (Exception e) {
        System.out.println("EXception");
      }
    };
  }

}
