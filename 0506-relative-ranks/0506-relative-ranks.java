class Solution {
    public String[] findRelativeRanks(int[] score) {
        int N = score.length;
        int[] scoreCopy = new int[N];
        System.arraycopy(score, 0, scoreCopy, 0, N);
       
        // Save the index of each athlete
        Map<Integer, Integer> scoreToIndex = new HashMap<>();
        for (int i = 0; i < N; i++) {
            scoreToIndex.put(scoreCopy[i], i);
        }
        
        // Sort scoreCopy in ascending order
        Arrays.sort(scoreCopy);

        // Assign ranks to athletes
        // Traverse scoreCopy in reverse
        String[] rank = new String[N]; 
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                rank[scoreToIndex.get(scoreCopy[N - i - 1])] = "Gold Medal";
            } else if (i == 1) {
                rank[scoreToIndex.get(scoreCopy[N - i - 1])] = "Silver Medal";
            } else if (i == 2) {
                rank[scoreToIndex.get(scoreCopy[N - i - 1])] = "Bronze Medal";
            } else {
                rank[scoreToIndex.get(scoreCopy[N - i - 1])] = Integer.toString(i + 1);
            }
        }
        
        return rank;
    }
}