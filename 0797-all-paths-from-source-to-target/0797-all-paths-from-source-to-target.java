class Solution {
    // public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    //     List<List<Integer>> list = new ArrayList<>();
    //     ArrayList<Integer> temp = new ArrayList<>();
    //     temp.add(0);
    //     solve(list, temp, graph, 0);
    //     return list;
    // }
    // private void solve(List<List<Integer>> list,ArrayList<Integer> temp,int[][] graph,int i){
    //     if(i == graph.length - 1)
    //         list.add(new ArrayList<Integer>(temp));
    //     for(int x : graph[i]){
    //         temp.add(x);
    //         solve(list, temp, graph, x);
    //         temp.remove(temp.size() - 1);
    //     }
    // }
    
    //Iterative Solution
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Integer end = graph.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> path  = new ArrayDeque<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            Integer current = stack.peek();
            if (current == path.peekLast()) {
                stack.pop(); 
                path.removeLast();
                continue;
            }
            path.offer(current);
            if (current == end) {
                result.add(new ArrayList(path));
                path.removeLast();
                stack.pop(); 
                continue;
            }
            for (int neighbor : graph[current]) {
                stack.push(neighbor);
            }
        }
        return result;
    }
}