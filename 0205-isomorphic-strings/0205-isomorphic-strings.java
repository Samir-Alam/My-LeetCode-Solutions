class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] freqS = new int[200]; // Stores frequency of characters in string s
        int[] freqT = new int[200]; // Stores frequency of characters in string t
        
        // Get the length of both strings
        int len = s.length();
        
        // If the lengths of the two strings are different, they can't be isomorphic
        if(len != t.length()) {
            return false;
        }
        
        // Iterate through each character of the strings
        for(int i = 0; i < len; i++) {
            // Check if the frequency of the current character in string s
            // is different from the frequency of the corresponding character in string t
            if(freqS[s.charAt(i)] != freqT[t.charAt(i)]) {
                return false; // If different, strings are not isomorphic
            }
            
            // Update the frequencies of characters in both strings
            freqS[s.charAt(i)] = i + 1; // Incrementing frequency of character in string s
            freqT[t.charAt(i)] = i + 1; // Incrementing frequency of character in string t
        }
        
        // If the loop completes without returning false, strings are isomorphic
        return true;
        
    }
}