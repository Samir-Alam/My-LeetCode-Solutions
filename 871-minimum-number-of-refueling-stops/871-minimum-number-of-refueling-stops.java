class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length, ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for (int i = 0; i <= n; i++) {
            int dist = i == n ? target : stations[i][0];
            while (startFuel < dist) {
                if (pq.size() == 0) return -1;
                startFuel += pq.poll();
                ans++;
            }
            if (i < n) pq.add(stations[i][1]);
        }
        return ans;
        
    }
}