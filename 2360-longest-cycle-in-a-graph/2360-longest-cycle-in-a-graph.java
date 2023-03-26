class Solution {
    public int longestCycle(int[] edges) {
        int[] cycleLength = new int[edges.length];
        Arrays.fill(cycleLength, -1);
        boolean[] visited = new boolean[edges.length];
        int max = -1;
        for (int i = 0; i < edges.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int destination = edges[i];
                int length = 1;
                HashMap<Integer, Integer> nodeToDistance = new HashMap<>();
                nodeToDistance.put(i, 0);
                while (destination != -1 && !visited[destination]) {
                    nodeToDistance.put(destination, length);
                    visited[destination] = true;
                    destination = edges[destination];
                    length++;
                }
                if (destination != -1 && nodeToDistance.containsKey(destination)) {
                    System.out.println(nodeToDistance);
                    cycleLength[destination] = length - nodeToDistance.get(destination);
                    max = Math.max(length - nodeToDistance.get(destination), max);
                }
            } 
        }
        return max;
    }
}