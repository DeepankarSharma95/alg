package experiment.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created 5/23/2018 19:42
 *
 * @author Deepankar Sharma
 */
public class AVLTree {

  private Node rootNode;
  private int maxLevel;
  private int minLevel;

  public void insert(Integer value) {
    Node node = new Node(value);
    if(rootNode == null) {
      rootNode = node;
    } else {
      Node head = rootNode;
      while (true) {
        if (value < head.getValue()) {
          if (head.getLeft() == null) {
            head.setLeft(node);
            break;
          } else {
            head = head.getLeft();
          }
        } else {
          if (head.getRight() == null) {
            head.setRight(node);
            break;
          } else {
            head = head.getRight();
          }
        }
      }
    }
    traverse();
  }

  public void traverse() {
    this.maxLevel = 0;
    this.minLevel = Integer.MAX_VALUE;
    traverse(rootNode, 1);
  }

  public void traverse(Node node, int level) {
    if(level > this.maxLevel) {
      this.maxLevel = level;
    }
    if(node.getLeft() == null && node.getRight() == null && this.minLevel > level) {
      this.minLevel = level;
    }
    if(node.getLeft() != null) {
      traverse(node.getLeft(), level + 1);
    }
    if(node.getRight() != null) {
      traverse(node.getRight(), level + 1);
    }
  }

  public int getMaxLevel() {
    return maxLevel;
  }

  public int getMinLevel() {
    return minLevel;
  }

  public boolean isAVLTree() {
    return maxLevel - minLevel <= 1;
  }

  public static void main(String[] args) throws IOException {
    AVLTree obj = new AVLTree();
    BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter number of nodes: ");
    Integer num = Integer.parseInt(buf.readLine());
    while (num-- > 0) {
      System.out.print("Value = ");
      Integer val = Integer.parseInt(buf.readLine());
      obj.insert(val);
    }
    System.out.println(obj.getMaxLevel());
    System.out.println(obj.getMinLevel());
    System.out.println(obj.isAVLTree());
  }
}
