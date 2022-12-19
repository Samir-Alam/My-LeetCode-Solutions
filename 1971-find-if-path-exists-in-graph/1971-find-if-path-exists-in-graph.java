// class DisjointSetUnion{
//     private int[] parent;
//     private int N;
//     public DisjointSetUnion(int n){
//         this.N = n;
//         this.parent = new int[this.N];
//         for(int i = 0; i < this.N; i++){
//             this.parent[i] = i;
//         }
//     }
//     public boolean areConnected(int u, int v){
//         return find(u) == find(v);
//     }
//     public void union(int u, int v){
//         if(u != v){
//             int a = find(u);
//             int b = find(v);
//             parent[a] = b;
//         }
//     }
//     private int find(int u){
//         int x = u;
//         while(x != this.parent[x]){
//             x = this.parent[x];
//         }
//         this.parent[u] = x;
//         return x;
//     }
// }
// class Solution {
//     public boolean validPath(int n, int[][] edges, int start, int end) {
//         DisjointSetUnion set = new DisjointSetUnion(n);
//         for(int[] edge : edges)
//             set.union(edge[0], edge[1]);
//         return set.areConnected(start, end);
//     }
// }

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //Store all edges in 'graph'.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }
        
        // Store all the nodes to be visited in 'queue'.
        boolean[] seen = new boolean[n];
        seen[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        
        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            if (currNode == destination) {
                return true; 
            }

            // For all the neighbors of the current node, if we haven't visit it before,            
            // add it to 'queue' and mark it as visited.
            for (int nextNode : graph.get(currNode)) {
                if (!seen[nextNode]) {
                    seen[nextNode] = true;
                    queue.offer(nextNode);
                }
            }
        }
        
        return false;
    }
}