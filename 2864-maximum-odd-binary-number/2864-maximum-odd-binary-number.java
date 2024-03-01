class Solution {
    public String maximumOddBinaryNumber(String s) {
        int one = 0, zero = 0;
        for(char c : s.toCharArray()){
            if(c == '1')
                one++;
            else zero++;
        }
        String ans = "";
        for(int i = 1; i < one; i++)
            ans += "1";
        for(int i = 0; i < zero; i++)
            ans += "0";
        ans += "1";
        return ans;
    }
}