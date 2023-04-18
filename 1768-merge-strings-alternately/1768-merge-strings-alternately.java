class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = Math.max(word1.length(), word2.length());
        String ans = "";
        for(int i = 0; i < n; i++){
            if(word1.length() == i){
                ans += word2.substring(i, n);
                break;
            }else if(word2.length() == i){
                ans += word1.substring(i, n);
                break;
            }else{
                ans += word1.charAt(i) + "";
                ans += word2.charAt(i) + "";
            }
        }
        return ans;
    }
}