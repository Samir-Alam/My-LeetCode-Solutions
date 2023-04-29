class UnionFind {
    int parent[];
    int rank[];

    UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0 ; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    public void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) {
            return;
        }

        if (rank[parentA] > rank[parentB]) {
            parent[parentB] = parentA;
        } else if (rank[parentA] < rank[parentB]) {
            parent[parentA] = parentB;
        } else {
            parent[parentA] = parentB;
            rank[parentB]++;
        }
    }

    public boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
}

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);

        boolean ans[] = new boolean[queries.length];

        int copyQuery[][] = new int[queries.length][4];
        
        for (int i = 0; i < queries.length; i++) {
            copyQuery[i][0] = queries[i][0];
            copyQuery[i][1] = queries[i][1];
            copyQuery[i][2] = queries[i][2];
            copyQuery[i][3] = i;
        }

        Arrays.sort(copyQuery, (a, b) -> a[2] - b[2]);

        UnionFind uf = new UnionFind(n);

        int startEdge = 0;

        for (int i = 0; i < copyQuery.length; i++) {
            int start = copyQuery[i][0];
            int dest = copyQuery[i][1];
            int limit = copyQuery[i][2];
            int idx = copyQuery[i][3];

            while (startEdge < edgeList.length && edgeList[startEdge][2] < limit) {
                int a = edgeList[startEdge][0];
                int b = edgeList[startEdge][1];
                uf.union(a, b);
                startEdge++;
            }

            if (uf.isConnected(start, dest)) {
                ans[idx] = true;
            }
        }

        return ans;   
    }
}