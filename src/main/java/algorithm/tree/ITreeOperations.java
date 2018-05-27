package algorithm.tree;

public interface ITreeOperations {

    void insert(Node parentNode, int value);
    default void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.getValue() + " ");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
    default void postOrder(Node node) {
        if(node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getValue() + " ");
        }
    }

    default void inOrder(Node node) {
        if(node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getValue() + " ");
            inOrder(node.getRight());
        }
    }
}
