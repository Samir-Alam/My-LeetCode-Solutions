class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> nonPaired = new HashMap<>();
        int pairs = 0, sym = 0;
        for (String w : words) {
            String reverse = new StringBuilder(w).reverse().toString();
            if (nonPaired.getOrDefault(reverse, 0) > 0) {
                ++pairs;                                    
                nonPaired.merge(reverse, -1, Integer::sum); 
                sym -= w.charAt(0) == w.charAt(1) ? 1 : 0; 
            }else {
                nonPaired.merge(w, 1, Integer::sum);  
                sym += w.charAt(0) == w.charAt(1) ? 1 : 0;
            }
        }
        return 4 * pairs + (sym > 0 ? 2 : 0);        
    }
}