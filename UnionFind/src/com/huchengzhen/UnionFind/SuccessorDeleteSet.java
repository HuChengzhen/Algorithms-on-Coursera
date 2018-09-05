package com.huchengzhen.UnionFind;

public class SuccessorDeleteSet {

    int[] father;

    public SuccessorDeleteSet(int n) {
        father = new int[n];

        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }


    public int successor(int n) {
        return root(n);
    }

    public void delete(int n) {
        union(n, n + 1);
    }

    public boolean contains(int n) {
        return father[n] == n;
    }

    private void union(int p, int q) { // q == p + 1
        if (contains(p)) {
            var rootP = p;
            var rootQ = root(q);
            father[rootP] = rootQ;
        }
    }

    private int root(int n) {
        while (father[n] != n) {
            father[n] = father[father[n]];
            n = father[n];
        }
        return n;
    }
}
