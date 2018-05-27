package experiment.trees;

/**
 * Created 5/23/2018 17:48
 *
 * @author Deepankar Sharma
 */
public class Node {

  private Node left;
  private Node right;
  private Integer value;

  public Node(Integer value) {
    this.value = value;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public experiment.trees.Node getRight() {
    return right;
  }

  public void setRight(experiment.trees.Node right) {
    this.right = right;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  @Override public String toString() {
    return value.toString();
  }
}
