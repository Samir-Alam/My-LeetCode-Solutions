class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n=s.length();
        int[][] dp=new int[110][110];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                dp[i][j] = 9999;
        dp[0][0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= k; j++){                
                int count = 0;
                int val = 0;
                for(int m = i; m >= 1; m--){
                    if(s.charAt(m - 1) == s.charAt(i - 1))
                        count++;
                    else
                        val++;
                    if(j - val >= 0){
                        if(count >= 100)
                            dp[i][j] = Math.min(dp[i][j], dp[m - 1][j - val] + 4);
                        else if(count >= 10)
                            dp[i][j] = Math.min(dp[i][j], dp[m - 1][j - val] + 3);
                        else if(count >= 2)
                            dp[i][j] = Math.min(dp[i][j], dp[m - 1][j - val] + 2);
                        else
                            dp[i][j] = Math.min(dp[i][j], dp[m - 1][j - val] + 1);
                    }
                }
                if(j > 0)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
            }
        }
        return dp[n][k];
    }
}