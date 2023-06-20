class Solution {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0)
            return nums;
        int n = nums.length;
        int[] averages = new int[n];
        Arrays.fill(averages, -1);
        if (2 * k + 1 > n)
            return averages;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; ++i)
            prefix[i + 1] = prefix[i] + nums[i];
        for (int i = k; i < (n - k); ++i) {
            long subArraySum = prefix[i + k + 1] - prefix[i - k];
            int average = (int) (subArraySum / (2 * k + 1));
            averages[i] = average;
        }
        return averages;
    }
}