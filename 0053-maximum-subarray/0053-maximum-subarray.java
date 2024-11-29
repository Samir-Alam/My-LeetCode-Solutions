class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], temp = nums[0];
        for(int i = 1; i < nums.length; i++){
            temp = Math.max(temp + nums[i], nums[i]);
            sum = Math.max(sum, temp);
        }
        return sum;
    }
}