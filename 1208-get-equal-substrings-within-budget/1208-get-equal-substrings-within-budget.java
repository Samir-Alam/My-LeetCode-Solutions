class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int N = s.length();
        
        int maxLen = 0;
        // Starting index of the current substring
        int start = 0;
        // Cost of converting the current substring in s to t
        int currCost = 0;
        
        for (int i = 0; i < N; i++) {
            // Add the current index to the substring
            currCost += Math.abs(s.charAt(i) - t.charAt(i));
            
            // Remove the indices from the left end till the cost becomes less than allowed
            while (currCost > maxCost) {
                currCost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            
            maxLen = Math.max(maxLen, i - start + 1);
        }
        
        return maxLen;
    }
}