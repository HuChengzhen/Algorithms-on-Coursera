import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @org.junit.jupiter.api.Test
    void isEmpty() {
        Deque<Integer> deque = new Deque<Integer>();
        assertTrue(deque.isEmpty());

        deque.addFirst(1);
        assertFalse(deque.isEmpty());
        deque.removeLast();
        assertTrue(deque.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void size() {
        Deque<Integer> deque = new Deque<Integer>();
        assertEquals(0, deque.size());

        deque.addFirst(1);
        assertEquals(1, deque.size());

        deque.addFirst(1);
        assertEquals(2, deque.size());

        deque.addLast(3);
        assertEquals(3, deque.size());

        deque.removeFirst();
        assertEquals(2, deque.size());

        deque.removeLast();
        assertEquals(1, deque.size());

        deque.removeLast();
        assertEquals(0, deque.size());
        assertTrue(deque.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void addFirst() {
        Deque<Integer> deque = new Deque<Integer>();

        deque.addFirst(1);
        assertEquals(1, deque.removeLast().intValue());

        deque.addLast(2);
        deque.addFirst(1);
        assertEquals(2, deque.removeLast().intValue());
        assertEquals(1, deque.removeLast().intValue());

    }

    @org.junit.jupiter.api.Test
    void addLast() {
        Deque<Integer> deque = new Deque<Integer>();

        deque.addFirst(1);
        assertEquals(1, deque.removeLast().intValue());

        deque.addLast(2);
        deque.addFirst(1);
        assertEquals(2, deque.removeLast().intValue());
        assertEquals(1, deque.removeLast().intValue());


        deque.addLast(2);
        deque.addFirst(1);
        deque.addLast(3);
        assertEquals(3, deque.removeLast().intValue());
        assertEquals(1, deque.removeFirst().intValue());
        assertEquals(2, deque.removeLast().intValue());

        assertEquals(0, deque.size());
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addLast(2);
        deque.addFirst(1);
        deque.addLast(3);
        deque.addLast(4);

        int expected = 1;
        for (Integer i : deque) {
            assertEquals(expected++, i.intValue());
        }
    }
}