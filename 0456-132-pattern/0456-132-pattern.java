class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int sec = Integer.MIN_VALUE;
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] < sec)
                return true;
            while(!s.isEmpty() && nums[i] > s.peek())
                sec = s.pop();
            s.push(nums[i]);
        }
        return false;
    }
}