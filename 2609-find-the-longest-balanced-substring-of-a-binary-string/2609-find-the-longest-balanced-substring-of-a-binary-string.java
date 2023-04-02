class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int ans = 0, ones = 0, zeros = 0, min = 0;
        boolean flag = true;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch - '0' == 0){
                if(!flag){
                    zeros = 0;
                    ones = 0;
                    flag = true;
                }
                zeros++;
            }else{
                ones++;
                flag = false;
                min = Math.min(zeros, ones);
            }
            ans = Math.max(ans, min);     
        }
        return ans * 2;
    }
}