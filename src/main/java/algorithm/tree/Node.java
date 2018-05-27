package algorithm.tree;

public class Node {

    private Node left;
    private int value;
    private Node right;
    private Node predecessor;
    private int balanceFactor;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node predecessor) {
        this.value = value;
        this.predecessor = predecessor;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }

    public int getBalanceFactor() {
        return balanceFactor;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

    @Override
    public String toString() {
        return getValue() + "";
    }
}
