package problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created 5/21/2018 00:30
 *
 * @author Deepankar Sharma
 */
public class VeryBigSum {

  /*
   * Complete the aVeryBigSum function below.
   */
  static long aVeryBigSum(int n, long[] ar) {
    BigDecimal sum = new BigDecimal(0L);
    for(long element : ar) {
      sum = sum.add(new BigDecimal(element));
    }
    return sum.longValue();
  }

  private static final Scanner scan = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = Integer.parseInt(scan.nextLine().trim());

    long[] ar = new long[n];

    String[] arItems = scan.nextLine().split(" ");

    for (int arItr = 0; arItr < n; arItr++) {
      long arItem = Long.parseLong(arItems[arItr].trim());
      ar[arItr] = arItem;
    }

    long result = aVeryBigSum(n, ar);

    bw.write(String.valueOf(result));
    bw.newLine();

    bw.close();
  }
}
