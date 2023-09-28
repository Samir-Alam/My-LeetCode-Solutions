class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int ans[] = new int[nums.length];
        int ind = 0;
        for(int i : nums){
            if((i & 1) == 0)
                ans[ind++] = i;
        }
        for(int i : nums){
            if((i & 1) == 1)
                ans[ind++] = i;
        }
        return ans;
    }
}