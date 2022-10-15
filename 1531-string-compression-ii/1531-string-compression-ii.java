class Solution {
    // public int getLengthOfOptimalCompression(String s, int k) {
    //     int n = s.length();
    //     int[][] dp = new int[110][110];
    //     for (int i = 0; i <= n; i++)
    //         for (int j = 0; j <= n; j++)
    //             dp[i][j] = 9999;
    //     dp[0][0] = 0;
    //     for(int i = 1; i <= n; i++){
    //         for(int j = 0; j <= k; j++){                
    //             int count = 0;
    //             int val = 0;
    //             for(int m = i; m >= 1; m--){
    //                 if(s.charAt(m - 1) == s.charAt(i - 1))
    //                     count++;
    //                 else
    //                     val++;
    //                 if(j - val >= 0){
    //                     if(count >= 100)
    //                         dp[i][j] = Math.min(dp[i][j], dp[m - 1][j - val] + 4);
    //                     else if(count >= 10)
    //                         dp[i][j] = Math.min(dp[i][j], dp[m - 1][j - val] + 3);
    //                     else if(count >= 2)
    //                         dp[i][j] = Math.min(dp[i][j], dp[m - 1][j - val] + 2);
    //                     else
    //                         dp[i][j] = Math.min(dp[i][j], dp[m - 1][j - val] + 1);
    //                 }
    //             }
    //             if(j > 0)
    //                 dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
    //         }
    //     }
    //     return dp[n][k];
    // }
    
    //2nd Solution
    private int[][] dp;
    private char[] chars;
    private int n;
    
    public int getLengthOfOptimalCompression(String s, int k) {
        this.chars = s.toCharArray();
        this.n = s.length();
        this.dp = new int[n][k+1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return dp(0, k);
    }
    
    private int dp(int i, int k) {
        if (k < 0) return n;
        if (n <= i + k) return 0;
        
        int ans = dp[i][k];
        if (ans != -1) return ans; 
        ans = dp(i + 1, k - 1);
        int length = 0, same = 0, diff = 0;
        
        for (int j=i; j < n && diff <= k; j++) {
            
            if (chars[j] == chars[i]) {
                same++;
                if (same <= 2 || same == 10 || same == 100) length++;
            } else {
                diff++; 
            }
            ans = Math.min(ans, length + dp(j + 1, k - diff)); 
        }
        dp[i][k] = ans;
        return ans;
    }
}