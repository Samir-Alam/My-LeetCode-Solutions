class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int prefix_sum = 0;
        int ans = 0;
        int n = satisfaction.length;
        for(int i = n - 1; i >= 0; i--){
            // value of prefix_sum is getting updated every time until negative because positive value will always benefit answer.
            prefix_sum += satisfaction[i];
            if(prefix_sum < 0) break;
            ans += prefix_sum;
        }
        return ans;
    }
}