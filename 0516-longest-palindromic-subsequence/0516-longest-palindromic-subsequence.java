class Solution {
    public int countPalindrome(String s,int i,int j){
        if(i>j) return 0;
        if(i==j) return 1;
        if(s.charAt(i)==s.charAt(j)) return 2+ countPalindrome(s,i+1,j-1);
        return Math.max(countPalindrome(s,i+1,j),countPalindrome(s,i,j-1));
    }
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        int dp[][] = new int[n+1][n+1];
        for(int i=n;i>=0;i--){
            for(int j=0;j<n;j++){
                if(i>j) dp[i][j]=0;
                else if(i==j) dp[i][j]=1;
                else if(s.charAt(i)==s.charAt(j)) dp[i][j]=2+dp[i+1][j-1];
                else dp[i][j]= Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        // return countPalindrome(s,0,n-1);
        return dp[0][n-1];
    }
}