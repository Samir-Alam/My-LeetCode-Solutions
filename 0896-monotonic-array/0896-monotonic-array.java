class Solution {
    public boolean isMonotonic(int[] nums) {
        // boolean inc = true, dec = true;
        // for (int i = 1; i < nums.length; ++i) {
        //     inc &= nums[i - 1] <= nums[i];
        //     dec &= nums[i - 1] >= nums[i];
        // }
        // return inc || dec;
        
        if (nums.length == 1) return true;
        int n = nums.length;
        boolean up= (nums[n - 1] - nums[0]) > 0;
        for (int i = 0; i < n - 1; i++)
            if (nums[i + 1] != nums[i] && (nums[i + 1] - nums[i] > 0) != up) 
                return false;
        return true;
    }
}