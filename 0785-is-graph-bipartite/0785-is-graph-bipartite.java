class Solution {
     public boolean isBipartite(int[][] G) {        
        int n = G.length, colors[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !dfs(G, colors, i, 1)) 
                return false;            
        }
        return true;
    }
    
    private boolean dfs(int[][] G, int[] colors, int i, int color) {
        colors[i] = color;
        for (int j = 0; j < G[i].length; j++) {
            int k = G[i][j]; // adjacent node
            if (colors[k] == -color) continue;
            if (colors[k] == color || !dfs(G, colors, k, -color)) return false;
        }
        return true;   
    }
}