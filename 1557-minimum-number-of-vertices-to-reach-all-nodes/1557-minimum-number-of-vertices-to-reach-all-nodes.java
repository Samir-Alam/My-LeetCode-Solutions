class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> vertices = new ArrayList();
        boolean[] reachableVertics = new boolean[n];
        for(List<Integer> edge : edges)
            reachableVertics[edge.get(1)] = true;
        for(int vertex = 0; vertex < n; vertex++)
            if(!reachableVertics[vertex])
                vertices.add(vertex);
        return vertices;
    }
}