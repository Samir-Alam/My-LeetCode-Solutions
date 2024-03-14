class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // int ans = 0;
        // int n = nums.length;
        // for(int i = 0; i < n; i++){
        //     int sum = 0;
        //     for(int j = i; j < n; j++){
        //         sum += nums[j];
        //         if(sum == goal)
        //             ans++;
        //     }
        // }
        // return ans;
        
        // Sliding Window
        int start = 0;
        int prefixZeros = 0;
        int currentSum = 0;
        int totalCount = 0;
        for (int end = 0; end < nums.length; end++) {
            currentSum += nums[end];
            while (start < end && (nums[start] == 0 || currentSum > goal)) {
                if (nums[start] == 1)
                    prefixZeros = 0;
                else
                    prefixZeros++;
                currentSum -= nums[start];
                start++;
            }
            if (currentSum == goal)
                totalCount += 1 + prefixZeros;
        }
        return totalCount;
    }
}