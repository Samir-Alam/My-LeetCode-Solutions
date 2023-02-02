class Solution {
    public boolean isAlienSorted(String[] words, String order) {
       int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i], index) > 0) {
                return false;
            }
        }

        return true;
    }

    private int compare(String s1, String s2, int[] index) {
        int n = s1.length();
        int m = s2.length();
        int min = Math.min(n, m);
        for (int i = 0; i < min; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return index[s1.charAt(i) - 'a'] - index[s2.charAt(i) - 'a'];
            }
        }
        return n - m; 
    }
}