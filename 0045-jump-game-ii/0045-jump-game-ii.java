class Solution {
    public int jump(int[] nums) {
        int ans = 0, n = nums.length, maxfar = 0, curend = 0;
        for(int i = 0; i < n - 1; i++){
            maxfar = Math.max(maxfar, i + nums[i]);
            if(i == curend){
                ans++;
                curend = maxfar;
            }
        }
        return ans;
    }
}