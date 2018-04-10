
public class HashMap {
    private static class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int HASH_SIZE = 10;
    private int hashFunc(int key) { return key % HASH_SIZE; }

    private Node[] tables;
    public HashMap() { tables = new Node[HASH_SIZE]; }


    public void put(int key, int value) {
        Node node = new Node(key, value);
        int idx = hashFunc(key);

        node.next = tables[idx];
        tables[idx] = node;
    }

    public int get(int key) {
        int idx = hashFunc(key);

        for (Node node = tables[idx]; node != null; node = node.next) {
            if (node.key == key)
                return node.value;
        }
        throw new RuntimeException("no value");
    }

    public int remove(int key) {
        int idx = hashFunc(key);

        if (tables[idx] == null)
            throw new RuntimeException("no value");

        Node prev = null, node;
        for (node = tables[idx]; node != null; node = node.next) {
            if (node.key == key)
                break;
            prev = node;
        }

        if (node == null)
            throw new RuntimeException("no value");

        if (prev == null) { // cur is first node
            tables[idx] = node.next;
            node.next = null;
            return node.value;
        }

        prev.next = node.next;
        node.next = null;
        return node.value;

    }

    private static void clearScreen() {
        for (int i = 0; i < 80; i++)
            System.out.println();
    }

    private void displayList(Node node) {
        for (; node != null; node = node.next)
            System.out.print("->[" + node.key + ", " + node.value + "]");
    }

    public void display() {
        clearScreen();
        for (int i = 0; i < HASH_SIZE; i++) {
            System.out.print("Map[" + i + "]");
            displayList(tables[i]);
            System.out.println();
        }
        System.out.flush();
        try { System.in.read(); System.in.read(); } catch (IOException e) { }
    }
}
