class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++)
            queue.add(i);
        int time = 0;
        while (!queue.isEmpty()) {
            time++;
            int front = queue.poll();
            tickets[front]--;
            if (k == front && tickets[front] == 0)
                return time;
            if (tickets[front] != 0)
                queue.add(front);
        }
        return time;
    }
}