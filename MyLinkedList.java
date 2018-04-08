public class MyLinkedList {
  private static class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  private int size = 0;
  public int size() { return size; }

  private Node head;

  public MyLinkedList() {
    head = new Node(0, null);
    head.next = head;
  }

  public void add(int data) {
    Node node = new Node(data, head);
    Node cur = head;
    while (cur.next != head)
      cur = cur.next;
    cur.next = node;
    ++size;
  }

  public int get(int index) {
    if (index < 0 || index >= size)
      throw new RuntimeException();
    Node node = head.next;
    for(int i = 0; i < index; i++)
      node = node.next;
    return node.data;
  }

  public int remove(int index) {
    if (index < 0 || index >= size)
      throw new RuntimeException();

    Node prev = head;
    for(int i = 0; i < index; i++)
      prev = prev.next;

    Node temp = prev.next;
    prev.next = temp.next;
    --size;
    return temp.data;
  }

  public int set(int index, int data) {
    if (index < 0 || index >= size)
      throw new RuntimeException();

    Node node = head.next;
    for(int i = 0; i < index; i++)
      node = node.next;

    int oldValue = node.data;
    node.data = data;
    return oldValue;
  }

  public void insert(int index, int data) {
    if(index < 0 || index >= size)
      throw new RuntimeException();

    Node prev = head;
    for(int i = 0; i < index; i++)
      prev = prev.next;
    prev.next = new Node(data, prev.next);
    ++size;
  }

  public void reverse() {
    Node prev = head;
    Node cur = head.next;
    Node next = null;

    while (cur != head) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    cur.next = prev;
  }
}
