class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        // bottom-up approach
        // int n = arr.length;
        // int dp[] = new int[n + 1];
        // for(int start = n-1; start >= 0; start--){
        //     int currMax = 0;
        //     int end = Math.min(n, start + k);
        //     for(int i = start; i < end; i++){
        //         currMax = Math.max(currMax, arr[i]);
        //         dp[start] = Math.max(dp[start], dp[i + 1] + currMax * (i - start + 1));
        //     }
        // }
        // return dp[0];
        
        //2nd solution
        int n = arr.length;
        int dp[] = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int ans = 0, currMax = 0;
            for(int j = 1; j <= k && (i - j) >= 0; j++){
                currMax = Math.max(currMax, arr[i - j]);
                ans = Math.max(ans, dp[i - j] + currMax * j);
            }
            dp[i] = ans;
        }
        return dp[n];
    }
}