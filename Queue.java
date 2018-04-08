
public class Queue {
  private int head = 0;
  private int tail = 0;

  private int[] arr;

  public Queue(int size) {
    arr = new int[size];
  }

  public int capacity() { return arr.length; }

  public void put(int data) {
    arr[tail] = data;
    tail = (tail + 1) % arr.length;
  }

  public boolean isFull() {
    return ((tail+1) % arr.length) == head;
  }

  public int get() {
    int temp = arr[head];
    head = (head + 1) % arr.length;
    return temp;
  }

  public boolean isEmpty() {
    return head == tail;
  }
}


