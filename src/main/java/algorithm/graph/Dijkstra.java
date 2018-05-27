package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created 5/23/2018 23:26
 *
 * @author Deepankar Sharma
 */
public class Dijkstra {

  /**
   *
   * Exceptation:
   * Input:
   * Number of nodes: 5
   * 0 10 5 999 999
   * 999 0 2 1 999
   * 999 3 0 9 2
   * 999 999 999 0 4
   * 7 999 999 6 0
   *
   * Output
   * 0 -> 0 = 0
   * 0 -> 2 -> 1 = 8
   * 0 -> 2 = 5
   * 0 -> 2 -> 1 -> 3 = 9
   * 0 -> 2 -> 4 = 7
   *
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Number of nodes: ");
    Integer n = Integer.parseInt(buf.readLine());
    Integer[][] distance = new Integer[n][n];
    for (int i = 0; i < n; i++) {
      int x = 0;
      String[] dist = buf.readLine().split(" ");
      for (String str : dist) {
        distance[i][x++] = Integer.parseInt(str);
      }
    }
    alg(distance);
  }

  public static void alg(Integer[][] distance) {
    Set<Integer> visited = new HashSet<>();
    Integer[] minimumDistance = distance[0];
    Integer[] predecessor = new Integer[distance.length];
    while (visited.size() != distance.length) {
      int minIndex = -1, min = Integer.MAX_VALUE;
      for (int i = 0; i < minimumDistance.length; i++) {
        if (visited.contains(i))
          continue;
        if (min > minimumDistance[i]) {
          min = minimumDistance[i];
          minIndex = i;
        }
      }
      visited.add(minIndex);
      for (int i = 0; i < distance.length; i++) {
        if (minimumDistance[i] > minimumDistance[minIndex] + distance[minIndex][i]) {
          minimumDistance[i] = minimumDistance[minIndex] + distance[minIndex][i];
          predecessor[i] = minIndex;
        }
      }
    }
    for (int i = 0; i < distance.length; i++) {
      String str = i + "";
      Integer pred = predecessor[i];
      while (pred != null) {
        str = pred + " -> " + str;
        pred = predecessor[pred];
      }
      str = "0 -> " + str;
      System.out.println(str + " = " + minimumDistance[i]);
    }
  }
}
