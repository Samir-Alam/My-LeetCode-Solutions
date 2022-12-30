class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(0);
        solve(list, temp, graph, 0);
        return list;
    }
    private void solve(List<List<Integer>> list,ArrayList<Integer> temp,int[][] graph,int i){
        if(i == graph.length - 1)
            list.add(new ArrayList<Integer>(temp));
        for(int x : graph[i]){
            temp.add(x);
            solve(list, temp, graph, x);
            temp.remove(temp.size() - 1);
        }
    }
}