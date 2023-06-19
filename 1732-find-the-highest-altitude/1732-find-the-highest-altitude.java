class Solution {
    public int largestAltitude(int[] gain) {
        int curr = 0, ans = 0;
        for(int i : gain){
            curr += i;
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}