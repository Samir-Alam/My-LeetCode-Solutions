class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int start = 0, maxElementsInWindow = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == maxElement)
                maxElementsInWindow++;
            while (k == maxElementsInWindow) {
                if (nums[start] == maxElement)
                    maxElementsInWindow--;
                start++;
            }
            ans += start;
        }
        return ans;
    }
}