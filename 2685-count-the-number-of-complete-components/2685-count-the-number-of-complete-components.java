public class DSU {
    private int[] p, rank, count;

    public DSU(int n) {
        p = new int[n];
        rank = new int[n];
        count = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            count[i] = 1;
        }
    }

    public int find(int x) {
        if (x != p[x])
            p[x] = find(p[x]);
        return p[x];
    }

    public void unionSet(int x, int y) {
        int xx = find(x), yy = find(y);
        if (xx == yy) return;
        count[xx] = count[yy] = count[xx] + count[yy];
        if (rank[xx] < rank[yy]) p[xx] = yy;
        else p[yy] = xx;
        if (rank[xx] == rank[yy]) rank[xx]++;
    }

    public int sizeOfGroupThatXIsAPartOf(int x) {
        return count[find(x)];
    }
}

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        DSU uf = new DSU(n);
        Set<Integer> groups = new HashSet<>();
        int[] counter = new int[n];
        for (int[] e : edges) {
            uf.unionSet(e[0], e[1]);
            counter[e[0]]++; counter[e[1]]++;
        }

        for (int i = 0; i < n; i++)
            groups.add(uf.find(i));

        for (int i = 0; i < n; i++)
            if (uf.sizeOfGroupThatXIsAPartOf(i) != counter[i] + 1)
                groups.remove(uf.find(i));

        return groups.size();
    }
}