class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3)
            return false;
        int seq = 1, min_num = nums[0];
        int max_seq = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == min_num)
                continue;
            else if (nums[i] < min_num){
                min_num = nums[i];
                continue;
            }
            else if (nums[i] < max_seq) {
                max_seq = nums[i];           
            } 
            else if (nums[i] > max_seq){ 
                seq++;
                if (seq == 3)
                    return true;
                max_seq = nums[i];
            }
        }
        return false;
    }
}