package algorithm.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class EulerPathAndCircuit {

    private static final BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    private static final Map<Integer, List<Integer>> accessible = new HashMap<>();
    private static Integer startingNode;

    /*
    Number of edges: 12
    Edges:
    1 2
    2 3
    3 4
    2 4
    1 9
    1 6
    6 9
    1 8
    8 5
    5 7
    7 8
    2 8
    The graph has Euler Circuit
    The Euler Circuit is:
    1 -> 2 -> 3 -> 4 -> 2 -> 8 -> 5 -> 7 -> 8 -> 1 -> 9 -> 6 -> 1
     */
    public static void main(String[] args) throws IOException {
        System.out.print("Number of edges: ");
        Integer nE = Integer.parseInt(buf.readLine());
        System.out.println("Edges: ");
        for (int i = 0; i < nE; i++) {
            String[] input = buf.readLine().split(" ");
            Integer u = Integer.parseInt(input[0]);
            Integer v = Integer.parseInt(input[1]);
            List<Integer> accessibleU = accessible.get(u);
            List<Integer> accessibleV = accessible.get(v);
            if(accessibleU == null) {
                accessibleU = new ArrayList<>();
            }
            if(accessibleV == null) {
                accessibleV = new ArrayList<>();
            }
            accessibleU.add(v);
            accessibleV.add(u);
            accessible.put(u, accessibleU);
            accessible.put(v, accessibleV);
        }
        Integer eulerStatus = evaluateEulerStatus();
        if(eulerStatus == -1) {
            return;
        }
        if(eulerStatus == 0) {
            System.out.println("The Euler Path is: ");
        } else {
            System.out.println("The Euler Circuit is: ");
        }
        printEuler();
    }

    /**
     *
     * @return The euler status of the undirected graph
     *         0  => Euler Path
     *         1  => Euler Circuit
     *         -1 => Neither Euler Path nor Euler Circuit
     */
    private static int evaluateEulerStatus() {
        Integer nEven = 0;
        Integer nOdd = 0;
        for (Integer i : accessible.keySet()) {
            if(accessible.get(i).size() % 2 == 0) {
                nEven++;
            } else {
                nOdd++;
                if(startingNode == null)
                    startingNode = i;
            }
        }
        if(nOdd == 2) {
            System.out.println("The graph has Euler Path");
            return 0;
        } else if (nOdd == 0) {
            System.out.println("The graph has Euler Circuit");
            startingNode = accessible.keySet().iterator().next();
            return 1;
        } else {
            System.out.println("The graph is neither Euler Path nor Euler Circuit");
            return -1;
        }
    }

    private static void printEuler() {
        Stack<Integer> stack = new Stack<>();
        Integer location = startingNode;
        Stack<Integer> euler = new Stack<>();
        while(accessible.size() != 0) {
            List<Integer> accessibleFromNode = accessible.get(location);
            if(accessibleFromNode != null && !accessibleFromNode.isEmpty()) {
                Integer previousLocation = location;
                stack.push(location);
                location = accessibleFromNode.get(0);
                List<Integer> nextNode = accessible.get(location);
                nextNode.remove(previousLocation);
                if(nextNode.size() == 0) {
                    accessible.remove(location);
                }
                accessibleFromNode.remove(location);
                if(accessibleFromNode.size() == 0) {
                    accessible.remove(previousLocation);
                }
            } else {
                euler.push(location);
                location = stack.pop();
            }
        }
        euler.push(location);
        while(!stack.isEmpty()) {
            euler.push(stack.pop());
        }
        while(!euler.isEmpty()) {
            System.out.print(euler.pop());
            if(!euler.isEmpty()) {
                System.out.print(" -> ");
            } else {
                break;
            }
        }
    }
}
