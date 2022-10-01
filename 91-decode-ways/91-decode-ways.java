class Solution {
    public int numDecodings(String s) {
        var dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;

        for (var i = 2; i <= s.length(); i++) {
            dp[i] = (s.charAt(i - 1) == '0') ? 0 : dp[i - 1];		
            var pair = Integer.parseInt(s.substring(i - 2, i));

            if (10 <= pair && pair <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
}