class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int MOD = (int) (1e9 + 7);
        int[][] engineers = new int[n][2];
        for (int i = 0; i < n; ++i) 
            engineers[i] = new int[] {efficiency[i], speed[i]};

        Arrays.sort(engineers, (a, b) -> b[0] - a[0]);  //sorting in descending order

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);    ////sorting in ascending order
        long res = Long.MIN_VALUE, totalSpeed = 0;

        for (int[] engineer : engineers) {
            if (pq.size() == k) totalSpeed -= pq.poll();  // layoff the one with min speed
            pq.add(engineer[1]);
            totalSpeed = (totalSpeed + engineer[1]);
            res = Math.max(res, (totalSpeed * engineer[0]));  // min efficiency is the efficiency of new engineer
        }
        return (int) (res % MOD);
    }
}