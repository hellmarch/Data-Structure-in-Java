
public class BitArray {
  private int[] arr = new int[4];
  final static int ARRAY_LENGTH = 128;
  
  public int capacity() { return ARRAY_LENGTH; }
  
  public void set(int idx) {
    if (idx < 0 || idx >= ARRAY_LENGTH)
      throw new RuntimeException();
    arr[idx/32] |= 1 << (idx % 32);
  }
  
  public boolean get(int idx) {
    if (idx < 0 || idx >= ARRAY_LENGTH)
      throw new RuntimeException();
    return (arr[idx/32] & (1 << (idx%32))) != 0; 
  }
  
  public void clear(int idx) {
    if (idx < 0 || idx >= ARRAY_LENGTH)
      throw new RuntimeException();
    if(!get(idx))
      return;
    arr[idx/32] &= ~(1 << (idx % 32));
  }
}