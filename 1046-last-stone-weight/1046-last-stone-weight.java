class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones){
            pq.add(i);
        }
        while(!pq.isEmpty()){
            int y = pq.poll();
            if(pq.isEmpty())
                return y;
            int x = pq.poll();
            if(y == x)
                continue;
            else
                pq.add(y-x);
        }
        return 0;
    }
}