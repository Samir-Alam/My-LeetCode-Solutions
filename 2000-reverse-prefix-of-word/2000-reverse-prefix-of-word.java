class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder().append(word);
        int index = sb.indexOf(ch + "");
        if(index == -1)
            return word;
        String ans = "";
        for(int i = index; i >= 0; i--)
            ans += word.charAt(i);
        ans += sb.substring(index + 1, word.length());
        // for(int i = index + 1; i < word.length(); i++){
        //     ans += word.charAt(i);
        // }
        return ans;
    }
}