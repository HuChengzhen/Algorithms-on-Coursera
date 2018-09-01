package com.huchengzhen.UnionFind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuccessorDeleteSetTest {

    @Test
    void testInit() {
        var n = 100;
        var set = new SuccessorDeleteSet(n);
        for (int i = 0; i < n; i++) {
            assertEquals(i, set.father[i]);
        }
    }

    @Test
    void testSuccessor() {
        var set = new SuccessorDeleteSet(100);

        assertEquals(10, set.successor(10));
        assertEquals(0, set.successor(0));
        assertEquals(99, set.successor(99));
        assertTrue(set.contains(0));
        assertTrue(set.contains(10));
        assertTrue(set.contains(99));

        set.delete(10);

        assertTrue(set.contains(9));
        assertFalse(set.contains(10));
        assertTrue(set.contains(11));
        assertTrue(set.contains(0));
        assertTrue(set.contains(99));
        assertEquals(11, set.successor(10));
        assertEquals(0, set.successor(0));
        assertEquals(99, set.successor(99));

        set.delete(11);

        assertTrue(set.contains(9));
        assertFalse(set.contains(10));
        assertFalse(set.contains(11));
        assertTrue(set.contains(12));
        assertTrue(set.contains(0));
        assertTrue(set.contains(99));
        assertEquals(12, set.successor(11));
        assertEquals(12, set.successor(10));
        assertEquals(0, set.successor(0));
        assertEquals(99, set.successor(99));


        set.delete(12);

        assertTrue(set.contains(9));
        assertFalse(set.contains(10));
        assertFalse(set.contains(11));
        assertFalse(set.contains(12));
        assertTrue(set.contains(0));
        assertTrue(set.contains(99));
        assertEquals(13, set.successor(12));
        assertEquals(13, set.successor(11));
        assertEquals(13, set.successor(10));
        assertEquals(0, set.successor(0));
        assertEquals(99, set.successor(99));
    }
}