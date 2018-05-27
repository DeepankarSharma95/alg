package experiment.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created 5/13/2018 15:43
 *
 * @author Deepankar Sharma
 */
public class Knapsack {

  public static void main(String[] args) throws IOException {
    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    int limit = Integer.parseInt(buf.readLine());
    int num = Integer.parseInt(buf.readLine());
    int fixed = Integer.parseInt(buf.readLine());
    int[][] cargo = new int[num][3];
    for (int i = 0; i < num; i++) {
      int[] thisCargo = new int[3];
      int x = 0;
      for (String str : buf.readLine().split(" ")) {
        thisCargo[x++] = Integer.parseInt(str);
      }
      cargo[i] = thisCargo;
    }
    System.out.println(findTruckCargo(limit, cargo));
  }

  public static int knap(int weightLimit, int[] weights, int[] profits, int itemNumber) {
    if (itemNumber == 0 || weightLimit == 0) {
      return 0;
    }
    if (weights[itemNumber - 1] > weightLimit) {
      return knap(weightLimit, weights, profits, itemNumber - 1);
    } else {
      return max(
          profits[itemNumber - 1] + knap(weightLimit - weights[itemNumber - 1], weights,
              profits, itemNumber - 1), knap(weightLimit, weights, profits, itemNumber - 1));
    }
  }

  public static int max(int a, int b) {
    return a > b ? a : b;
  }

  public static int[] findTruckCargo(int maxCargoWeight, int[][] cargoList) {
    int[] ids = new int[cargoList.length];
    int[] weights = new int[cargoList.length];
    int[] profits = new int[cargoList.length];
    int i = 0;
    for (int[] vals : cargoList) {
      ids[i] = vals[0];
      weights[i] = vals[1];
      profits[i++] = vals[2];
    }
    int val = knap(maxCargoWeight, weights, profits, cargoList.length);
    List<Integer> sub = printSubsets(profits, val);
    Collections.sort(sub);
    List<Integer> result = new ArrayList<>();
    for(int index : sub) {
      result.add(ids[index]);
    }
    result.add(val);
    return new int[]{};
  }

  static List<Integer> printSubsets(int set[], int max) {
    int n = set.length;
    for (int i = 0; i < (1 << n); i++) {
      int sum = 0;
      List<Integer> dummyList = new ArrayList<Integer>();
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) > 0)
        {
          sum += set[j];
          dummyList.add(j);
          if (sum == max) {
            return dummyList;
          }
        }
      }
    }
    return null;
  }
}