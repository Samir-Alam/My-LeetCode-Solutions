class Solution {
    public int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = n - 1; i >= 2; i--){
            int a = nums[i];        //side 1
            int b = nums[i - 1];       //side 2
            int c = nums[i - 2];        //side 3
            if(a + b > c && a + c > b && b + c > a)
                return a + b + c;
            else
                continue;
        }
        return 0;
    }
}