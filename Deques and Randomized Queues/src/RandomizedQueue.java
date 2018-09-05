import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

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
        int random = StdRandom.uniform(size);
        Item item = s[random];

        s[random] = s[size - 1];
        s[size - 1] = null;
        size -= 1;

        if (size > 0 && size == s.length/4) resize(s.length/2);
        return item;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException();
        int random = StdRandom.uniform(size);
        Item item = s[random];
        return item;
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private int current = 0;
        private final Item[] randomCopy;

        private RandomizedQueueIterator() {
            randomCopy = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                randomCopy[i] = s[i];
            }
            StdRandom.shuffle(randomCopy);
        }

        public boolean hasNext() {
            return current < randomCopy.length;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = randomCopy[current];
            current += 1;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }
}
