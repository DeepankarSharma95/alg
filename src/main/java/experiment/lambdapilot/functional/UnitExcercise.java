package experiment.lambdapilot.functional;

import experiment.lambdapilot.Person;

import java.util.Arrays;
import java.util.List;

/**
 * Created 5/8/2017 20:32
 *
 * @author Deepankar Sharma
 */
public class UnitExcercise {

  public static void main(String[] args) {
    List<Person> people = Arrays.asList(
        new Person("Deepankar", "Sharma", 22),
        new Person("Some", "Other", 30),
        new Person("Another", "Name", 22),
        new Person("Second", "Name", 23),
        new Person("Third", "Name", 34)
    );
    System.out.println("Unsorted");
    printList(people);
    people.sort((o1, o2) -> o1.getLastName().compareToIgnoreCase(o2.getLastName()));
    System.out.println("Sorted");
    printList(people);
    System.out.println("L name beginning with N");
    people.stream().filter(g -> g.getFirstName().startsWith("D")).forEach(System.out::println);
    //printWithLastName("N", people);
  }

  private static void printList(List<Person> people) {
    for(Person p : people) {
      System.out.println(p.toString());
    }
  }

  private static void printWithLastName(String lNameStartsWithList, List<Person> people) {
    Condition c = (p) -> p.getLastName().startsWith(lNameStartsWithList);
    for(Person p : people) {
      if(c.test(p)) {
        System.out.println(p.toString());
      }
    }

  }

  interface Condition {
    boolean test(Person p);
  }

}
