class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
        for(int i = 0; i < nums.length - 2; i++) {
            int low = i + 1, high = nums.length - 1;           
            while(low < high) {
				int csum = nums[i] + nums[low] + nums[high];
                if(csum == target) return csum;
                if(Math.abs(target - csum) < Math.abs(target - min)) min = csum;
                if(csum < target) ++low;
                else --high;
            }
        }
        return min;
    }
}