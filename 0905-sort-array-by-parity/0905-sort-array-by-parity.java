class Solution {
    public int[] sortArrayByParity(int[] nums) {
        // int ans[] = new int[nums.length];
        // int ind = 0;
        // for(int i : nums){
        //     if((i & 1) == 0)
        //         ans[ind++] = i;
        // }
        // for(int i : nums){
        //     if((i & 1) == 1)
        //         ans[ind++] = i;
        // }
        // return ans;
    
        for (int i = 0, j = 0; j < nums.length; j++)
            if (nums[j] % 2 == 0) {
                int tmp = nums[i];
                nums[i++] = nums[j];
                nums[j] = tmp;;
            }
        return nums;
    }
}