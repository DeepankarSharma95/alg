package problem;

import java.util.*;

public class Competetion {
    // Complete the membersInTheLargestGroups function below.
    static void membersInTheLargestGroups(int n, int m, int a, int b, int f, int s, int t) {
        int[] catLimit = new int[] { f, s, t};
        Map<String, Set<String>> pairs = new HashMap<>();
        Map<String, Integer[]> limits = new HashMap<>();
        Set<String> names = new HashSet<>();
        Set<String> finalResult = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        Map<String, Integer> category = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String[] nameCat = scanner.nextLine().split(" ");
            names.add(nameCat[0]);
            category.put(nameCat[0], Integer.parseInt(nameCat[1]));
        }
        for(int i=0; i< m ; i++) {
            String[] requests = scanner.nextLine().split(" ");
            String name1 = requests[0];
            String name2 = requests[1];
            Set<String> pair = new HashSet<>();;
            Set<String> pair1 = pairs.get(name1);
            Set<String> pair2 = pairs.get(name2);
            if(pair1 != null) {
                pair.addAll(pair1);
            } else {
                pair.add(name1);
            }
            if(pair2 != null) {
                pair.addAll(pair2);
            } else {
                pair.add(name2);
            }
            if(pair.size() > b) {
                continue;
            }
            Integer[] limit = new Integer[] {0, 0, 0};
            for(String name : pair) {
                limit[category.get(name) - 1] ++;
            }
            if(limit[0] > catLimit[0] || limit[1] > catLimit[1] || limit[2] > catLimit[2]) {
                continue;
            }
            for(String name : pair) {
                pairs.put(name, pair);
                limits.put(name, limit);
            }
        }
        int max = 0;
        for(String person : pairs.keySet()) {
            if(pairs.get(person).size() > max) {
                max = pairs.get(person).size();
            }
        }
        if(max < a) {
            System.out.println("no groups");
        } else {
            for(String person : pairs.keySet()) {
                if(pairs.get(person).size() == max) {
                    finalResult.addAll(pairs.get(person));
                }
            }
        }
        for(String name: finalResult) {
            System.out.println(name);
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nmabfst = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nmabfst[0]);

        int m = Integer.parseInt(nmabfst[1]);

        int a = Integer.parseInt(nmabfst[2]);

        int b = Integer.parseInt(nmabfst[3]);

        int f = Integer.parseInt(nmabfst[4]);

        int s = Integer.parseInt(nmabfst[5]);

        int t = Integer.parseInt(nmabfst[6]);

        membersInTheLargestGroups(n, m, a, b, f, s, t);

        scanner.close();
    }
}

/*
5 7 2 3 2 2 2
A 1
B 2
C 3
D 1
E 2
A B
B A
C D
E D
E A
B D
B C
 */
