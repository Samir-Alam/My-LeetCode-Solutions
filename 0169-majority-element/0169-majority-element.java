class Solution {
    public int majorityElement(int[] nums) {
        int el = nums[0], count = 1;
        for(int i  = 1; i <  nums.length; i++){
            if(count == 0) el = nums[i];
            if(nums[i] == el)
                count++;
            else
                count--;
        }
        return el;
    }
}