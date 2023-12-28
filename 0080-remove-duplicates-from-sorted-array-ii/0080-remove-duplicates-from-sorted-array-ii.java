class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if(i < nums.length - 2 && nums[i] == nums[i+2])
                continue;
            nums[count] = nums[i];
            count++;
        }
        return count;
    }
}