package com.huchengzhen.UnionFind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuickFindUFTest {

    @Test
    void testInit() {
        var n = 10000;
        var uf = new QuickFindUF(n);
        for (var i = 0; i < n; i++) {
            assertEquals(i, uf.id[i]);
        }
    }

    @Test
    void testUnionConnected() {
        var nf = new QuickFindUF(10);

        nf.union(1,2);
        assertTrue(nf.connected(1,2));
        assertFalse(nf.connected(0, 1));

        nf.union(3, 4);
        assertTrue(nf.connected(3,4));
        assertFalse(nf.connected(0, 1));

        nf.union(2, 3);
        assertTrue(nf.connected(1,4));
        assertFalse(nf.connected(0, 1));
    }
}