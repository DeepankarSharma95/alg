package experiment.lambdapilot.oops;

import experiment.lambdapilot.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created 5/8/2017 20:20
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
    people.sort(new Comparator<Person>() {

      @Override public int compare(Person o1, Person o2) {
        return o1.getLastName().compareToIgnoreCase(o2.getLastName());
      }
    });
    System.out.println("Sorted");
    printList(people);
    System.out.println("L name beginning with N");
    printWithLastName('N', people);
  }

  private static void printList(List<Person> people) {
    for(Person p : people) {
      System.out.println(p.toString());
    }
  }

  private static void printWithLastName(Character character, List<Person> people) {
    for(Person p : people) {
      if(p.getLastName().startsWith(character.toString(), 0)) {
        System.out.println(p.toString());
      }
    }
  }



}
