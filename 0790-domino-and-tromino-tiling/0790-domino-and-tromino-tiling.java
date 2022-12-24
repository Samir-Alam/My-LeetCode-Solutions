class Solution {
    public int numTilings(int n) {
        long[] dp = new long[n + 3]; dp[0] = 1; dp[1] = 2; dp[2] = 5;
        for (int i = 3; i < n; i ++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 3]) % 1000000007;
        }
        return (int)dp[n - 1];
    }
}
// class Solution {
//     public int numTilings(int n) {
//         long[] dp = new long[n + 2]; dp[0] = 1; dp[1] = 2;
//         long[] dpa = new long[n + 2]; dpa[1] = 1;
//         for (int i = 2; i < n; i ++) {
//             dp[i] = (dp[i - 1] + dp[i - 2] + dpa[i - 1] * 2) % 1000000007;
//             dpa[i] = (dp[i - 2] + dpa[i - 1]) % 1000000007;
//         }
//         return (int)dp[n - 1];
//     }
// }