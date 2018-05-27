package algorithm.dyn;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created 5/20/2018 15:36
 *
 * @author Deepankar Sharma
 */
public class MatrixMultiplication {

  public static void main(String[] args) throws IOException {
    //BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    // original array
    int[] orderArray = new int[] { 10, 20, 30, 40, 30 };
    //int[] orderArray = new int[]{10, 20, 30, 40};
    Map<String, Integer[]> orderMap = new HashMap<>();
    Map<String, Integer> computationMap = new HashMap<>();
    Map<String, String> optimumMap = new HashMap<>();
    int initChar = 'A';
    StringBuilder matrix = new StringBuilder("");
    for (int i = 0; i < orderArray.length - 1; i++) {
      orderMap.put((char) (initChar + i) + "",
          new Integer[] { orderArray[i], orderArray[i + 1] });
      optimumMap.put((char) (initChar + i) + "", (char) (initChar + i) + "");
      matrix.append((char) (initChar + i));
    }
    if (matrix.toString().length() < 2) {
      System.out.println("Minimum 2 arrays are required for multiplication");
      return;
    }
    matrixMinMap(matrix.toString(), orderMap, computationMap, optimumMap);
    System.out.println(
        "Matrix = " + matrix.toString() + "; Optimum ContainingCharacters: " + optimumMap
            .get(matrix.toString()) + "; Total computations required: " + computationMap
            .get(matrix.toString()));
  }

  private static void matrixMinMap(String matrix, Map<String, Integer[]> orderMap,
      Map<String, Integer> computationMap, Map<String, String> optimumMap) {
    int matrixLength = matrix.length();
    Integer computation = computationMap.get(matrix);
    if (computation != null) {
      return;
    }
    if (matrixLength == 2) {
      computation =
          orderMap.get(matrix.charAt(0) + "")[0] * orderMap.get(matrix.charAt(0) + "")[1]
              * orderMap.get(matrix.charAt(1) + "")[1];
      computationMap.put(matrix, computation);
      optimumMap.put(matrix, "(" + matrix + ")");
      orderMap.put(matrix, new Integer[] { orderMap.get(matrix.charAt(0) + "")[0],
          orderMap.get(matrix.charAt(1) + "")[1] });
      return;
    }
    String key = null;
    int minComputation = Integer.MAX_VALUE;
    String optMat1 = null, optMat2 = null;
    for (int i = 0; i < matrixLength - 1; i++) {
      computation = 0;
      String thisKey;
      String mat1 = matrix.substring(0, i + 1);
      String mat2 = matrix.substring(i + 1, matrixLength);
      if (mat1.length() == 1) {
        // get computations for higher order
        matrixMinMap(mat2, orderMap, computationMap, optimumMap);
        computation = computationMap.get(mat2);
      } else if (mat2.length() == 1) {
        // get computations for higher order
        matrixMinMap(mat1, orderMap, computationMap, optimumMap);
        computation = computationMap.get(mat1);
      } else {
        matrixMinMap(mat1, orderMap, computationMap, optimumMap);
        matrixMinMap(mat2, orderMap, computationMap, optimumMap);
        computation = computationMap.get(mat1);
        computation += computationMap.get(mat2);
      }
      computation +=
          orderMap.get(mat1)[0] * orderMap.get(mat1)[1] * orderMap.get(mat2)[1];
      thisKey = "(" + optimumMap.get(mat1) + optimumMap.get(mat2) + ")";
      if (computation < minComputation) {
        minComputation = computation;
        key = thisKey;
        optMat1 = mat1;
        optMat2 = mat2;
      }
      System.out.println(mat1 + " " + mat2 + " = " + computation + "; key = " + thisKey);
    }
    computationMap.put(matrix, minComputation);
    optimumMap.put(matrix, key);
    orderMap.put(matrix,
        new Integer[] { orderMap.get(optMat1)[0], orderMap.get(optMat2)[1] });
  }
}
