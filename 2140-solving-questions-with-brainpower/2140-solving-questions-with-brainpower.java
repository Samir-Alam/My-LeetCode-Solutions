class Solution {
    long dp[];
    public long slove(int ind, int[][] arr, long dp[]){
        int n = arr.length;
        if(ind >= n)
            return 0;
        if(dp[ind] != 0)
            return dp[ind];
        long notTake = 0;
        notTake = slove(ind + 1, arr, dp);
        long take = 0;
        take = arr[ind][0] + slove(ind + arr[ind][1] + 1, arr, dp);
        return dp[ind] = Math.max(take,notTake);
    }
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        dp = new long[n + 1];   
        return slove(0, questions, dp); 
    }
}