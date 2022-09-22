class Solution {
    public String reverseWords(String s) {
        String st[] = s.split(" ");
        String ans = "";
        int n = st.length;
        for(int i = 0; i < n - 1; i++){
            ans += reverse(st[i]) + " ";
        }
        ans += reverse(st[n - 1]);
        return ans;
    }
    public String reverse(String s){
        String res = "";
        for(int i = s.length() - 1; i >= 0; i--)
            res += s.charAt(i) + "";
        return res;
    }
}