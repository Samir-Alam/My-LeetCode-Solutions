class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                if(sum == goal)
                    ans++;
            }
        }
        return ans;
    }
}