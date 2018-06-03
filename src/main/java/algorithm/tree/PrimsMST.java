package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class PrimsMST {

    private static final BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

    /*
    Number of nodes: 9
    0 4 999 999 999 999 999 8 999
    4 0 8 999 999 999 999 11 999
    999 8 0 7 999 4 999 999 2
    999 999 7 0 9 14 999 999 999
    999 999 999 9 0 10 999 999 999
    999 999 4 14 10 0 2 999 999
    999 999 999 999 999 2 0 1 6
    8 11 999 999 999 999 1 0 7
    999 999 2 999 999 999 6 7 0
    Minimum spanning tree:
    0	4	999	999	999	999	999	999	999
    4	0	8	999	999	999	999	999	999
    999	8	0	7	999	4	999	999	2
    999	999	7	0	9	999	999	999	999
    999	999	999	9	0	999	999	999	999
    999	999	4	999	999	0	2	999	999
    999	999	999	999	999	2	0	1	999
    999	999	999	999	999	999	1	0	999
    999	999	2	999	999	999	999	999	0
    Weight of MST: 37
     */
    public static void main(String[] args) throws IOException {
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

    private static void alg(Integer[][] distanceVector) {
        // Initializing the environment
        Set<Integer> mst = new HashSet<>();
        Integer[] minDistance = new Integer[distanceVector.length];
        Integer[] pred = new Integer[distanceVector.length];
        for (int i = 0; i < minDistance.length; i++) {
            minDistance[i] = Integer.MAX_VALUE;
        }
        minDistance[0] = 0;
        pred[0] = 0;
        // Core Algorithm
        while (mst.size() != distanceVector.length) {
            int minVertex = getMinimumDistanceVertex(mst, minDistance);
            mst.add(minVertex);
            for (int i = 0; i < distanceVector.length; i++) {
                if (minVertex == i) {
                    continue;
                }
                if (minDistance[i] > distanceVector[minVertex][i] && !mst.contains(i)) {
                    minDistance[i] = distanceVector[minVertex][i];
                    pred[i] = minVertex;
                }
            }
        }
        // Printing the minimum spanning tree
        System.out.println("Minimum spanning tree: ");
        for (int i = 0; i < distanceVector.length; i++) {
            for (int j = 0; j < distanceVector.length; j++) {
                if (i == j)
                    System.out.print(0 + "\t");
                else if (pred[i] == j)
                    System.out.print(minDistance[i] + "\t");
                else if (pred[j] == i)
                    System.out.print(minDistance[j] + "\t");
                else
                    System.out.print(999 + "\t");
            }
            System.out.println();
        }
        // Printing the weight of MST
        int sum = 0;
        for (int i = 0; i < minDistance.length; i++) {
            sum += minDistance[i];
        }
        System.out.println("Weight of MST: " + sum);
    }

    private static Integer getMinimumDistanceVertex(Set<Integer> mst, Integer[] minDistance) {
        Integer minVertex = -1;
        int minVertexDistance = Integer.MAX_VALUE;
        for (int i = 0; i < minDistance.length; i++) {
            if (mst.contains(i)) {
                continue;
            }
            if (minVertexDistance > minDistance[i]) {
                minVertexDistance = minDistance[i];
                minVertex = i;
            }
        }
        return minVertex;
    }
}
