class Solution {
    public int findCenter(int[][] edges) {
        
        //every edges has to connect to the center node,
        //so you just need to find the common node which is connected to every node
        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
            return edges[0][0];
        else
            return edges[0][1];
    }
}