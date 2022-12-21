class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {        
        List<Integer>[] graph = new List[N + 1];  

        for (int i = 1; i <= N; ++i) graph[i] = new ArrayList<>();        

        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }

        Integer[] colors = new Integer[N + 1];

        for (int i = 1; i <= N; ++i) {
            // If the connected component that node i belongs to hasn't been colored yet then try coloring it.
            if (colors[i] == null && !dfs(graph, colors, i, 1)) return false;
        }
        return true;   
    }

    private boolean dfs(List<Integer>[] graph, Integer[] colors, int currNode, int currColor) {
        colors[currNode] = currColor;

        // Color all uncolored adjacent nodes.
        for (Integer adjacentNode : graph[currNode]) {

            if (colors[adjacentNode] == null) {
                if (!dfs(graph, colors, adjacentNode, currColor * -1)) return false;     

            } else if (colors[adjacentNode] == currColor) {
                return false;                                     
            }
        }
        return true;        
    }
}