
public class Tree {
  private static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) { this.data = data; }
  }

  private Node root;

  public boolean remove(int data) {
    if (root == null)
      return true;

    Node parent = null;
    Node node = root;
    while (node != null) {
      if (data < node.data) {
        parent = node;
        node = node.left;
      } else if (data > node.data) {
        parent = node;
        node = node.right;
      } else
        break;
    }

    if (node == null)
      return true;

    Node candidate = null;
    if (node.right == null) {
      candidate = node.left;
      node.left = null; // help GC
    }
    else if (node.right.left == null) {
      candidate = node.right;
      candidate.left = node.left;
    }
    else {
      Node cParent = node.right;
      candidate = node.right.left;

      while (candidate.left != null) {
        cParent = candidate;
        candidate = candidate.left;
      }
      cParent.left = candidate.right;

      candidate.left = node.left;
      candidate.right = node.right;
    }

    if (parent != null) {
      if (data < parent.data)
        parent.left = candidate;
      else
        parent.right = candidate;
    } else {
      root = candidate;
    }
    return false;
  }

  public boolean contains(int data) {
    if (root == null)
      return false;

    Node cur = root;
    while (cur != null) {
      if (data < cur.data)
        cur = cur.left;
      else if (data > cur.data)
        cur = cur.right;
      else
        return true;
    }
    return false;
  }

  public int insert(int data) {
    Node node = new Node(data);

    if (root == null) {
      root = node;
      return 0;
    }

    Node prev = null;
    Node cur = root;
    while (cur != null) {
      prev = cur;
      if (data < cur.data)
        cur = cur.left;
      else if (data > cur.data)
        cur = cur.right;
      else
        return -1;
    }

    if (data < prev.data)
      prev.left = node;
    else
      prev.right = node;
    return 0;
  }

  private void __preorder(Node node) {
    if (node == null)
      return;
    System.out.print(" " + node.data);
    __preorder(node.left);
    __preorder(node.right);
  }

  public void preorder() {
    System.out.print(" Preorder:");
    __preorder(root);
    System.out.println();
  }

  private void __inorder(Node node) {
    if (node == null)
      return;
    __inorder(node.left);
    System.out.print(" " + node.data);
    __inorder(node.right);
  }

  public void inorder() {
    System.out.print("  Inorder:");
    __inorder(root);
    System.out.println();
  }

  private void __postorder(Node node) {
    if (node == null)
      return;
    __postorder(node.left);
    __postorder(node.right);
    System.out.print(" " + node.data);
  }

  public void postorder() {
    System.out.print("Postorder:");
    __postorder(root);
    System.out.println();
  }

  private int row, col;

  private void fillArray(int[][] arr, Node node) {
    if (node == null)
      return;
    ++row;
    fillArray(arr, node.left);
    arr[row][col++] = node.data;
    fillArray(arr, node.right);
    --row;
  }

  public void display() {
    row = -1;
    col = 0;

    for (int i = 0; i < 80; i++)
      System.out.println();

    int[][] arr = new int[10][10];
    fillArray(arr, root);

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        if (arr[i][j] == 0)
          System.out.printf("%4c", ' ');
        else
          System.out.printf("(%2d)", arr[i][j]);
      }
      System.out.println();
    }
    try { System.in.read(); System.in.read(); } catch (IOException e) { }
  }
}

