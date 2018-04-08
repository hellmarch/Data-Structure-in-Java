public class Stack {
  private int[] arr;
  private int top = 0;

  public Stack(int size) {
    arr = new int[size];
  }

  public int capacity() {
    return arr.length;
  }

  void push(int data) {
    arr[top++] = data;
  }

  public boolean isFull() {
    return top == arr.length;
  }

  public int pop() {
    return arr[--top];
  }

  public boolean isEmpty() {
    return top == 0;
  }
}
