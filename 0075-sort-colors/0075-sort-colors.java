class Solution {
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int r = 0, w = 0, b = nums.length - 1;
        while (w <= b){
            if (nums[w] == 0)
                swap(r++, w++, nums);
            else if (nums[w] == 1)
                w++;
            else
                swap(w, b--, nums);
        }
    }
}