package algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AVLTree implements ITreeOperations {

    private Node rootNode;

    public void rightRotate(Node x) {
        Node y = x.getLeft();
        Node T2 = y.getRight();
        y.setPredecessor(x.getPredecessor());
        if (x.getPredecessor() == null) {
            rootNode = y;
        } else {
            Node pred = x.getPredecessor();
            if (pred.getLeft().getValue() == x.getValue()) {
                pred.setLeft(y);
            } else {
                pred.setRight(y);
            }
        }
        x.setPredecessor(y);
        if (T2 != null) {
            T2.setPredecessor(x);
        }
        y.setRight(x);
        x.setLeft(T2);
    }

    public void leftRotate(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();
        y.setPredecessor(x.getPredecessor());
        if (x.getPredecessor() == null) {
            rootNode = y;
        } else {
            Node pred = x.getPredecessor();
            if (pred.getLeft().getValue() == x.getValue()) {
                pred.setLeft(y);
            } else {
                pred.setRight(y);
            }
        }
        x.setPredecessor(y);
        if (T2 != null)
            T2.setPredecessor(x);
        y.setLeft(x);
        x.setRight(T2);
    }

    public void balance(Node node) {
        if (node.getBalanceFactor() > 0) {
            balance(node.getLeft());
        } else if (node.getBalanceFactor() < 0) {
            balance(node.getRight());
        }
        boolean treeModified = false;
        if (node.getBalanceFactor() == 2) {
            if (node.getLeft().getBalanceFactor() == 1) {
                rightRotate(node);
                treeModified = true;
            } else if (node.getLeft().getBalanceFactor() == -1) {
                leftRotate(node.getLeft());
                rightRotate(node);
                treeModified = true;
            }
        } else if (node.getBalanceFactor() == -2) {
            if (node.getLeft().getBalanceFactor() == -1) {
                leftRotate(node);
                treeModified = true;
            } else if (node.getLeft().getBalanceFactor() == 1) {
                rightRotate(node.getRight());
                leftRotate(node);
                treeModified = true;
            }
        }
        if (treeModified) {
            evaluateBalanceFactor();
        }
    }

    @Override
    public void insert(Node parentNode, int value) {
        if (parentNode == null) {
            rootNode = new Node(value);
            return;
        }
        if (value < parentNode.getValue()) {
            if (parentNode.getLeft() != null) {
                insert(parentNode.getLeft(), value);
            } else {
                Node node = new Node(value, parentNode);
                parentNode.setLeft(node);
                rebalanceTree();

            }
        } else if (value > parentNode.getValue()) {
            if (parentNode.getRight() != null) {
                insert(parentNode.getRight(), value);
            } else {
                Node node = new Node(value, parentNode);
                parentNode.setRight(node);
                rebalanceTree();
            }
        }
    }

    public void rebalanceTree() {
        evaluateBalanceFactor();
        balance(rootNode);
    }

    public void evaluateBalanceFactor() {
        depth(rootNode);
    }

    public int depth(Node node) {
        if (node == null) {
            return 0;
        } else {
            node.setBalanceFactor(depth(node.getLeft()) - depth(node.getRight()));
            return 1 + max(depth(node.getLeft()), depth(node.getRight()));
        }
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) throws IOException {
        AVLTree tree = new AVLTree();
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Nodes: ");
        Integer n = Integer.parseInt(buf.readLine());
        for (int i = 0; i < n; i++) {
            System.out.print("Node: ");
            Integer val = Integer.parseInt(buf.readLine());
            tree.insert(tree.rootNode, val);

        }
        System.out.print("In-Order: ");
        tree.inOrder(tree.rootNode);
        System.out.print("\nPre-Order: ");
        tree.preOrder(tree.rootNode);
        System.out.println();
    }
}
