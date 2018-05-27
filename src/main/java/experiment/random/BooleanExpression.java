package experiment.random;

/**
 * Created 4/19/2018 02:44
 *
 * @author Deepankar Sharma
 */
public class BooleanExpression {

  private static int[][] bools = {
      {0, 0, 0},
      {0, 0, 1},
      {0, 1, 0},
      {0, 1, 1},
      {1, 0, 0},
      {1, 0, 1},
      {1, 1, 0},
      {1, 1, 1},
  };

  public static void main(String[] args) {
    int count = 0;
    for(int[] row : bools) {
      boolean b1,b2,b3;
      b1 = row[0] == 1;
      b2 = row[1] == 1;
      b3 = row[2] == 1;
      System.out.println(count++ + " = " + row[0] + " " + row[1] + " " + row[2] + " = " + ((!b1 && !b2) || (!b1 && !b3) || (!b2 && !b3)));
    }
  }

}
