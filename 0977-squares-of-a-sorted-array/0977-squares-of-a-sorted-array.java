class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int i = nums.length - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                ans[i--] = nums[left] * nums[left];
                left++;
            } else {
                ans[i--] = nums[right] * nums[right];
                right--;
            }
        }
        return ans;
    }
}