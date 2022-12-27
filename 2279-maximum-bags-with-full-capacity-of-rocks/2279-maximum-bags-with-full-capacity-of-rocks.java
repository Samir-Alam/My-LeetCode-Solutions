class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int left[] = new int[n];
        for(int i = 0; i < n; i++)
            left[i] = capacity[i] - rocks[i];
        int i = 0;
        Arrays.sort(left);
        while(additionalRocks > 0 && i < n)
            additionalRocks -= left[i++];
        return additionalRocks < 0 ? i - 1 : i;
    }
}