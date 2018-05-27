package problem;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        findTruckCargo(limit, cargo);
    }

    public static int knap(int weightLimit, int[] weights, int[] profits, int itemNumber, int[] ids, List<Integer> idList) {
        if (itemNumber == 0 || weightLimit == 0) {
            return 0;
        }
        if (weights[itemNumber - 1] > weightLimit) {
            return knap(weightLimit, weights, profits, itemNumber - 1, ids, idList);
        } else {
            return max(profits[itemNumber - 1] + knap(weightLimit - weights[itemNumber - 1], weights, profits, itemNumber - 1, ids, idList), knap(weightLimit, weights, profits, itemNumber - 1, ids, idList), ids[itemNumber - 1], idList);
        }
    }

    public static int max(int a, int b, int id, List<Integer> idList) {
        if(a > b) {
            idList.add(id);
        } else if( b >= a) {
            idList.add(-1);
        }
        return a > b ? a : b;
    }

    public static void findTruckCargo(int maxCargoWeight, int[][] cargoList) {
        int[] ids = new int[cargoList.length];
        int[] weights = new int[cargoList.length];
        int[] profits = new int[cargoList.length];
        int i = 0;
        for (int[] vals : cargoList) {
            ids[i] = vals[0];
            weights[i] = vals[1];
            profits[i++] = vals[2];
        }
        List<Integer> idList = new ArrayList<>();
        System.out.println(knap(maxCargoWeight, weights, profits, cargoList.length, ids, idList));
        System.out.println(idList);
    }

}