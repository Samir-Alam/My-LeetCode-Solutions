class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1)
             return "";
        char[] chars = palindrome.toCharArray();
        for (int i = 0; i < chars.length/2; i++) {         
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }       
        chars[chars.length-1] = 'b';        
        return new String(chars);           
    }
}