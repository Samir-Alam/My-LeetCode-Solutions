class Solution {
    public int removeElement(int[] nums, int val) {
        // int count = 0, j = 0;
        // int[] num = new int[nums.length];
        // for(int i : nums){
        //     if(i != val){
        //         count++;
        //         num[j++] = i;
        //     }
        // }
        // for(int i = 0; i < count; i++)
        //     nums[i] = num[i];
        // return count;
        
        int n = nums.length, j = 0;
        for(int i : nums)
            if(i != val){
                nums[j++] = i;
            }
        return j;
    }
}