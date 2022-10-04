class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        int fi = 0, si = 0, n = nums.length;
        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i] + nums[j] == target){
                    fi = i;
                    si = j;
                    break;
                }
            }
        }
        ans[0] = fi;
        ans[1] = si;
        return ans;
    }
}