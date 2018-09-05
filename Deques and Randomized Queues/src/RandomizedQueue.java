import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class RandomizedQueue<Item> implements Iterable<Item> {
//    public class RandomizedQueue<Item> implements Iterable<Item> {
//        public RandomizedQueue()                 // construct an empty randomized queue
//        public boolean isEmpty()                 // is the randomized queue empty?
//        public int size()                        // return the number of items on the randomized queue
//        public void enqueue(Item item)           // add the item
//        public Item dequeue()                    // remove and return a random item
//        public Item sample()                     // return a random item (but do not remove it)
//        public Iterator<Item> iterator()         // return an independent iterator over items in random order
//        public static void main(String[] args)   // unit testing (optional)
//    }

    private Item[] s;
    private int size;

    public RandomizedQueue() {
        size = 0;
        s = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();

        if (size == s.length) {
            resize(2 * s.length);
        }
        s[size] = item;
        size += 1;
    }

    private void resize(int capacity)
    {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++)
            copy[i] = s[i];
        s = copy;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        do {
            int = 
        } while (true);
    }
}
