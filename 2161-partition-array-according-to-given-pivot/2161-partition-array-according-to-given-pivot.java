class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        // int n = nums.length;
        // int[] ans = new int[n];
        // int left = 0, right = n - 1;
        // for (int i = 0, j = n - 1; i < n; ++i, --j) {
        //     if (nums[i] < pivot) {
        //         ans[left++] = nums[i];
        //     }
        //     if (nums[j] > pivot) {
        //         ans[right--] = nums[j];
        //     }
        // }
        // while (left <= right) {
        //     ans[left++] = pivot;
        // }
        // return ans;
        
        //2nd Solution
        int n = nums.length, pivotFreq = 0, i = 0;
        int[] ans = new int[n];
        for (int num : nums) {
            if (num < pivot)
                ans[i++] = num;
            else if (num == pivot)
                ++pivotFreq;
        }
        while (pivotFreq-- > 0)
            ans[i++] = pivot;
        for (int num : nums)
            if (num > pivot)
                ans[i++] = num;
        return ans;
    }
}