class Solution {
//     public int removeStones(int[][] stones) {
//         if (stones == null || stones.length <= 1)
//             return 0;

//         int n = stones.length;
//         UnionFind uf = new UnionFind();
   
//         for (int[] edge : stones)
//             uf.union(edge[0] + 10001, edge[1]);
//         return n - uf.getCount();
//     }

//     class UnionFind {
//         Map<Integer, Integer> parents;
//         int count;
    
//         public UnionFind() {
//             parents = new HashMap<>();
//             count = 0;
//         }
    
//         public int getCount() {
//             return count;
//         }
    
//         public int find(int x) {
//             if (!parents.containsKey(x)) {
//                 parents.put(x, x);
//                 count++;
//             }
//             if (x != parents.get(x))
//                 parents.put(x, find(parents.get(x)));
//             return parents.get(x);
//         }
    
//         public void union(int x, int y) {
//             int rootX = find(x);
//             int rootY = find(y);
//             if (rootX == rootY)
//                 return;
//             parents.put(rootX, rootY);
//             count--;
//         }
//     }
    
    public int removeStones(int[][] stones) {
        Set<int[]> visited = new HashSet();
        int numOfIslands = 0;
        for (int[] s1:stones){
            if (!visited.contains(s1)){
               dfs(s1, visited, stones); 
               numOfIslands++;
            }
        }
        return stones.length - numOfIslands;
    }
    
    private void dfs(int[] s1, Set<int[]> visited, int[][] stones){
        visited.add(s1);
        for (int[] s2: stones){
            if (!visited.contains(s2)){
				// stone with same row or column. group them into island
                if (s1[0] == s2[0] || s1[1] == s2[1])
                    dfs(s2, visited, stones);
            }
        }
    }
}