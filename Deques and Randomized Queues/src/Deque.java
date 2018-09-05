import java.util.NoSuchElementException;
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private LinkList<Item> first = null;
    private LinkList<Item> last = null;
    private int size = 0;

    private class LinkList<Item> {
        Item item;
        LinkList<Item> next = null;
        LinkList<Item> previous = null;

        public LinkList(Item item) {
            this.item = item;
        }
    }


    public Deque() {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        LinkList<Item> newFirst = new LinkList(item);
        if (isEmpty()) {
            first = last = newFirst;
        } else {
            first.previous = newFirst;
            newFirst.next = first;
            first = newFirst;
        }
        size += 1;
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        LinkList<Item> newLast = new LinkList(item);
        if (isEmpty()) {
            first = last = newLast;
        } else {
            last.next = newLast;
            newLast.previous = last;
            last = newLast;
        }
        size += 1;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        size -= 1;
        LinkList<Item> removedFirst = first;
        if (first == last) {
            first = last = null;
        } else {
            first = first.next;
            first.previous = null;
        }
        return removedFirst.item;
    }

    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        size -= 1;

        LinkList<Item> removedLast = last;

        if (first == last) {
            first = last = null;
        } else {
            last = last.previous;
            last.next = null;
        }

        return removedLast.item;
    }

    private class DequeIterator implements Iterator<Item> {
        private LinkList<Item> current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();

            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

}
