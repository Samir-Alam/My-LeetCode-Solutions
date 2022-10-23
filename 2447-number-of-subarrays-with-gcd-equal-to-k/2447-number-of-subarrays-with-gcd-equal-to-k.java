class Solution {
    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    public int subarrayGCD(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int currGcd = nums[i];
            if(currGcd == k) // if element is equal to k, increment answer
                ans++;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] < k) // if nums[j] < k gcd can never be equal to k for this subarray
                    break;
                currGcd = gcd(nums[j], currGcd);
                if (currGcd == k)
                    ans++;
            }
        }
        return ans;
    }
}