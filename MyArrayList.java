
public class MyArrayList {
  private int size = 0;
  private int[] elements;

  public MyArrayList(int size) {
    elements = new int[size];
  }

  public int size() { return size; }
  public int capacity() { return elements.length; }

  public void add(int element) {
    if(size >= elements.length)
      throw new RuntimeException();
    elements[size++] = element;
    return;
  }

  public int get(int index) {
    if(index < 0 || index >= size)
      throw new RuntimeException();
    return elements[index];
  }

  public int remove(int index) {
    if (index < 0 || index >= size)
      throw new RuntimeException();

    int oldValue = elements[index];
    --size;
    System.arraycopy(elements, index + 1,
        elements, index, size - index);
    return oldValue;
  }

  public int set(int index, int element) {
    if (index < 0 || index >= size)
      throw new RuntimeException();

    int oldValue = elements[index];
    elements[index] = element;
    return oldValue;
  }

  public void insert(int index, int element) {
    if (index < 0 || index >= size)
      throw new RuntimeException();

    System.arraycopy(elements, index, elements,
        index+1, size - index);

    elements[index] = element;
    ++size;
  }
}
