class Solution {
    public int numRollsToTarget(int n, int k, int t) {
        int mod = 1000000007;
        int[] prev = new int[t + 1];
        for(int dices = 0; dices <= n; dices++){
            int[] curr = new int[t + 1];
            for(int target = 0; target <= t; target++){
                if(dices == 0){
                    curr[target] = target == 0 ? 1 : 0;
                }else{
                    int ways = 0;
                    for(int j = 1; j <= Math.min(target,k); j++){
                        ways = (ways%mod + prev[target - j]%mod)%mod;
                    }
                    curr[target] = ways;
                }
            }
            prev = curr;
        }
        return prev[t];
    }
}