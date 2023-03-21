class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0, count = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] == 0){
                int j = i;
                while(j < nums.length && nums[j] == 0)
                    j++;
                count = (j == nums.length - 1 && nums[j] == 0) ? j - i + 1 : j - i;
                i = j;
                ans += count * (count + 1) / 2;
            }
        return ans;
    }
}