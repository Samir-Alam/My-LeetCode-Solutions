class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sumOfCurrentWindow = 0, n = nums.length;
        int res = Integer.MAX_VALUE;
        for(right = 0; right < n; right++) {
            sumOfCurrentWindow += nums[right];
            while (sumOfCurrentWindow >= target) {
                res = Math.min(res, right - left + 1);
                sumOfCurrentWindow -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}