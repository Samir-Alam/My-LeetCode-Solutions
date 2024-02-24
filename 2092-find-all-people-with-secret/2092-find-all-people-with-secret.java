class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] meeting : meetings) {
            int x = meeting[0], y = meeting[1], t = meeting[2];
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[]{t, y});
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(new int[]{t, x});
        }
        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);
        earliest[0] = 0;
        earliest[firstPerson] = 0;

        // Do DFS
        dfs(0, 0, graph, earliest);
        dfs(firstPerson, 0, graph, earliest);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (earliest[i] != Integer.MAX_VALUE) {
                ans.add(i);
            }
        }
        return ans;
    }
    private void dfs(int person, int time, Map<Integer, List<int[]>> graph, int[] earliest) {
        for (int[] nextPersonTime : graph.getOrDefault(person, new ArrayList<>())) {
            int t = nextPersonTime[0], nextPerson = nextPersonTime[1];
            if (t >= time && earliest[nextPerson] > t) {
                earliest[nextPerson] = t;
                dfs(nextPerson, t, graph, earliest);
            }
        }
    }
}