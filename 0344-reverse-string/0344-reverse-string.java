class Solution {
    public void reverseString(char[] s) {
        int st = 0, e = s.length-1;
        while(st < e){
            char c = s[st];
            s[st] = s[e];
            s[e] = c;
            st++;
            e--;
        }
    }
}