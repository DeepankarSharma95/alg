package experiment.random;

/**
 * Created 2/9/2018 15:29
 *
 * @author Deepankar Sharma
 */
public class TestMee {

  private static void iConsumeParent(Parent parent) {
  }

  private static void iConsumeChild(Child child) {
  }

  public static void main(String[] args) {
    Parent p = new Parent();
  }
}


class Parent {
  public Parent(){}
  private Parent(int x) {}
}

class Child extends Parent {

   public Child() {
    //super(5);
  }
}
