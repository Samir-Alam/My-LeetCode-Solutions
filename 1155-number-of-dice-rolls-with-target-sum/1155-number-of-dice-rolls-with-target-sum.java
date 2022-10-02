class Solution {
    // public int numRollsToTarget(int n, int k, int t) {
    //     int mod = 1000000007;
    //     int[] prev = new int[t + 1];
    //     for(int dices = 0; dices <= n; dices++){
    //         int[] curr = new int[t + 1];
    //         for(int target = 0; target <= t; target++){
    //             if(dices == 0){
    //                 curr[target] = target == 0 ? 1 : 0;
    //             }else{
    //                 int ways = 0;
    //                 for(int j = 1; j <= Math.min(target,k); j++)
    //                     ways = (ways % mod + prev[target - j] % mod) % mod;
    //                 curr[target] = ways;
    //             }
    //         }
    //         prev = curr;
    //     }
    //     return prev[t];
    // }
    
    private int mod = (int) Math.pow(10, 9) + 7;
    public int numRollsToTarget(int n, int k, int target) {
        Integer dp[][] = new Integer[n+1][target+1];
        return recursiveCount(n, k, target, dp);
    }
    public int recursiveCount(int dice, int faces, int target, Integer[][] dp) {  
        if(dice == 0 && target == 0) return 1;
        if(target < 0) return 0;
        if(dice == 0 && target != 0) return 0;
        if(dp[dice][target] != null) return dp[dice][target]; //checking if answer already calculated return it
        int count = 0;
     //recursive calls with each face
        for(int face=1; face<=faces; face++) {
            count += recursiveCount(dice - 1, faces, target - face, dp); //recursive call with one less dice and target decresed by face on current dice
            count %= mod; //requirement in question
        }   
        return dp[dice][target] = count;
    }
}