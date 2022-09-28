class Solution {
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(Math.abs(nums[i] - nums[j]) == k)
                    res++;
                else if(Math.abs(nums[i] - nums[j]) > k)
                    break;
            }
        }
        return res;
    }
}