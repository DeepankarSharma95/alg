package algorithm.dyn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LongestIncreasingSubsequence {

  private static final BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    System.out.print("Number of elements: ");
    Integer n = Integer.parseInt(buf.readLine());
    Integer[] arr = new Integer[n];
    System.out.println("Numbers: ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(buf.readLine());
    }
    alg(arr);
  }

  private static void alg(Integer[] arr) {
    Integer n = arr.length;
    Integer[] lis = new Integer[n];
    Integer[] predecessor = new Integer[n];
    for (int i = 0; i < n; i++) {
      lis[i] = 1;
      predecessor[i] = null;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if(arr[j] < arr[i]) {
          if(lis[i] < 1 + lis[j]) {
            lis[i] = lis[j] + 1;
            predecessor[i] = j;
          }
        }
      }
    }
    int maxIndex = -1;
    int max = -1;
    for (int i = 0; i < n; i++) {
      if(max < lis[i]) {
        max = lis[i];
        maxIndex = i;
      }
    }
    System.out.println("Longest increasing subsequence of length " + lis[maxIndex] + " is ");
    Stack<Integer> stack = new Stack<>();
    stack.push(arr[maxIndex]);
    while(predecessor[maxIndex] != null) {
      stack.push(arr[predecessor[maxIndex]]);
      maxIndex = predecessor[maxIndex];
    }
    while (!stack.isEmpty()) {
      System.out.print(stack.pop());
      if(!stack.isEmpty()) {
        System.out.print(", ");
      } else {
        System.out.println();
      }
    }
  }
}
