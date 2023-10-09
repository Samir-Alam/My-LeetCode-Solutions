class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[]{-1, -1};
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                if(ans[0] == -1)
                    ans[0] = i; 
                ans[1] = i;
            }
        }
        return ans;
    }
}