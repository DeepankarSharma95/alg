package problem;
import java.util.*;

public class Station {

    // Complete the minimumTimeToEnd function below.
    static void minimumTimeToEnd(long[] x, long w, long v, int q) {
        // Take the descriptions of the people from standard input and print the answers to standard output
        /*double[] p = new double[q];
        double[] t = new double[q];
        double[] u = new double[q];
        double[] minTime = new double[q];
        int n = x.length;
        for(int i = 0; i < q; i++) {
            String[] ptu = scanner.nextLine().split(" ");
            p[i] = Double.parseDouble(ptu[0]);
            t[i] = Double.parseDouble(ptu[1]);
            u[i] = Double.parseDouble(ptu[2]);
        }
        long streetLength = x[n - 1];
        // loop for all people
        for(int i = 0; i < q; i++) {
            double min = Double.MAX_VALUE;
            for(int j = 0; j < n; j++) {
                double nextBusTime = 0;
                double walkingTime = Math.abs(p[i] - x[j]) / u[i];
                double travellingTime = Math.abs(streetLength - x[j]) / v;
                double busTimeToStop = (x[j] - x[0])/v;
                double totalTime;
                if(min > totalTime) {
                    min = totalTime;
                }
            }
            minTime[i] = min;
        }
        for(double min : minTime)
        System.out.println(min);
        */
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] x = new long[n];

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int xItr = 0; xItr < n; xItr++) {
            long xItem = Long.parseLong(xItems[xItr]);
            x[xItr] = xItem;
        }

        String[] wv = scanner.nextLine().split(" ");

        long w = Long.parseLong(wv[0]);

        long v = Long.parseLong(wv[1]);

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        minimumTimeToEnd(x, w, v, q);

        scanner.close();
    }
}
