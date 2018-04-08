public class DoublyLinkedList {
  private static class Node {
    int data;
    Node prev;
    Node next;

    public Node(Node prev, int data, Node next) {
      this.data = data;
      this.prev = prev;
      this.next = next;
    }
  }
  private int size = 0; 
  public int size() { return size; }

  private Node head;
  private Node tail;

  public DoublyLinkedList() {
    head = new Node(null, 0, null);
    tail = new Node(null, 0, null);
    head.next = tail;
    head.prev = head;
    tail.prev = head;
    tail.next = tail;
  }

  public void add(int data) {
    Node prev = tail.prev;
    Node next = tail;
    Node node = new Node(prev, data, next);
    prev.next = node;
    next.prev = node;
    ++size;
  }

  private Node toNode(int index) {
    Node node = null;
    if (index < (size / 2)) {
      node = head.next;
      for (int i = 0; i < index; i++)
        node = node.next;
      return node;
    } else {
      node = tail.prev;
      for (int i = size - 1; i > index; i--)
        node = node.prev;
      return node;
    }
  }

  public int get(int index) {
    if (index < 0 || index >= size)
      throw new RuntimeException();
    return toNode(index).data;
  }

  public int remove(int index) {
    if (index < 0 || index >= size)
      throw new RuntimeException();

    Node node = toNode(index);
    Node prev = node.prev;
    Node next = node.next;

    prev.next = next;
    next.prev = prev;
    --size;

    return node.data;
  }

  public int set(int index, int data) {
    if (index < 0 || index >= size)
      throw new RuntimeException();

    Node node = toNode(index);
    int oldValue = node.data;
    node.data = data;
    return oldValue;
  }

  public void insert(int index, int data) {
    if (index < 0 || index >= size)
      throw new RuntimeException();

    Node next = toNode(index);
    Node prev = next.prev;

    Node node = new Node(prev, data, next);
    prev.next = node;
    next.prev = node;
    ++size;
  }
}