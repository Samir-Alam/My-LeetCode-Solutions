class Solution {
    public String reverseWords(String s) {
        String str[] = s.split(" ");
        String ans = "";
        for(String ss : str){
            ans += reverse(ss) + " ";
        }
        return ans.trim();
    }
    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        return sb.toString();
    }
}