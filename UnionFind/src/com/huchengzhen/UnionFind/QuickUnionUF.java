package com.huchengzhen.UnionFind;

public class QuickUnionUF {

    int[] id;// Negative value mean it's the root and -value is the size.

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = -1;
        }
    }

    private int root(int i) {
        while (id[i] >=0) {
            var grandparent = id[id[i]]; // path compress
            if (grandparent >= 0) {
                id[i] = grandparent;
            }
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i != j) {
            if (id[i] < id[j]) { // size i > j
                id[i] += id[j];
                id[j] = i;
            } else {
                id[j] += id[i];
                id[i] = j;
            }
        }

    }

}
