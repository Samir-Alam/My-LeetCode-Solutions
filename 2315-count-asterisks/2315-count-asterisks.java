class Solution {
    public int countAsterisks(String s) {
        int pair = 0, ans = 0;
        for(char c : s.toCharArray()){
            pair += c == '|' ? 1 : 0;
            ans += (c == '*' && pair % 2 != 1) ? 1 : 0;
        }
        return ans;
    }
}