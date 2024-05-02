class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int s = 0, e = nums.length-1;
        while(s <= e){
            if(Math.abs(nums[s]) == nums[e] && nums[s] < 0 && nums[e] > 0)
                return Math.abs(nums[s]);
            if(Math.abs(nums[s]) < nums[e])
                e--;
            else
                s++;
        }
        return -1;
    }
}