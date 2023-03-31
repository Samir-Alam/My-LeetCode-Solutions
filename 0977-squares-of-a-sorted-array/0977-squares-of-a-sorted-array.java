class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int i = nums.length - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                ans[i--] = (int)Math.pow(nums[left], 2);
                left++;
            } else {
                ans[i--] = (int)Math.pow(nums[right], 2);
                right--;
            }
        }
        return ans;
    }
}