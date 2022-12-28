class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : piles)
            pq.add(i);
        while(k-- > 0){
            int n = pq.poll();
            if(n%2 == 0) pq.add(n/2);
            else pq.add(n/2 + 1);
        }
        int ans = 0;
        while(!pq.isEmpty())
            ans += pq.poll();
        return ans;
    }
}