class Solution {
    public int minimumDeviation(int[] nums) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int min = Integer.MAX_VALUE;
        for(int num : nums) {
            if(num % 2 == 1) {
                num *= 2;
            }
            min = Math.min(min, num);
            pq.offer(num);
        }
        int diff = Integer.MAX_VALUE;
        while(pq.peek() % 2 == 0) {
            int max = pq.poll();
            diff = Math.min(diff, max - min);
            max /= 2;
            min = Math.min(min, max);
            pq.offer(max);
        }
        return Math.min(diff, pq.peek() - min);
    }
}