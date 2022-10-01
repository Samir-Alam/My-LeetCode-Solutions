class Solution {
    public int countAsterisks(String s) {
        int pair = 0, ans = 0;
        for(char c : s.toCharArray()){
            if(c == '|')
                pair++;
            if(c == '*' && pair % 2 != 1)
                ans++;
        }
        return ans;
    }
}