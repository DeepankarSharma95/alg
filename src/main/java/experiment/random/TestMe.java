package experiment.random;

/**
 * Created 2/6/2018 19:15
 *
 * @author Deepankar Sharma
 */
public class TestMe {

  private int instanceTypeIntA;

  private static float staticTypeFloatB;
  private static Object staticTypeObjectD;

  private int[] instanceTypeIntArrayE = new int[5];



  public static void main(String[] args) {
    float localVariableTypeFloatC;
    TestMe instance = new TestMe();
    System.out.println("A: " + instance.instanceTypeIntA);
    System.out.println("B: " + staticTypeFloatB);
    //System.out.println("C: " + localVariableTypeFloatC);
    System.out.println("D: " + staticTypeObjectD);
    System.out.println("E: " + instance.instanceTypeIntArrayE);
  }

}
