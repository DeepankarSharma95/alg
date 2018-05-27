package experiment.random;

/**
 * Created 5/24/2018 13:35
 *
 * @author Deepankar Sharma
 */
public class EnumTest {

  public enum Test {
    VAL1, VAL2, VAL3;

    public boolean equals(Test val2) {
      return true;
    }
  }

  public static void main(String[] args) {
    System.out.println(Test.VAL1.equals(Test.VAL2));
    System.out.println(Test.VAL1 == Test.VAL2);
  }

}
