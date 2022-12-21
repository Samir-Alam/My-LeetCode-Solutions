// class Solution {
//     public boolean possibleBipartition(int N, int[][] dislikes) {        
//         List<Integer>[] graph = new List[N + 1];  
//         for (int i = 1; i <= N; ++i) 
//             graph[i] = new ArrayList<>();        
//         for (int[] dislike : dislikes) {
//             graph[dislike[0]].add(dislike[1]);
//             graph[dislike[1]].add(dislike[0]);
//         }
//         Integer[] colors = new Integer[N + 1];
//         for (int i = 1; i <= N; ++i)
//             if (colors[i] == null && !dfs(graph, colors, i, 1)) 
//                 return false;
//         return true;   
//     }
//     private boolean dfs(List<Integer>[] graph, Integer[] colors, int currNode, int currColor) {
//         colors[currNode] = currColor;
//         for (Integer adjacentNode : graph[currNode]) {
//             if (colors[adjacentNode] == null) {
//                 if (!dfs(graph, colors, adjacentNode, currColor * -1)) 
//                     return false;
//             } else if (colors[adjacentNode] == currColor) 
//                 return false;                                     
//         }
//         return true;        
//     }
// }

class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
        rank = new int[size];
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        int xset = find(x), yset = find(y);
        if (xset == yset) {
            return;
        } else if (rank[xset] < rank[yset]) {
            parent[xset] = yset;
        } else if (rank[xset] > rank[yset]) {
            parent[yset] = xset;
        } else {
            parent[yset] = xset;
            rank[xset]++;
        }
    }
}

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : dislikes) {
            int a = edge[0], b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        UnionFind dsu = new UnionFind(n + 1);
        for (int node = 1; node <= n; node++) {
            if (!adj.containsKey(node))
                continue;
            for (int neighbor : adj.get(node)) {
                // Check if the node and its neighbor is in the same set.
                if (dsu.find(node) == dsu.find(neighbor))
                    return false;
                // Move all the neighbours into same set as the first neighbour.
                dsu.union(adj.get(node).get(0), neighbor);
            }
        }
        return true;
    }
}