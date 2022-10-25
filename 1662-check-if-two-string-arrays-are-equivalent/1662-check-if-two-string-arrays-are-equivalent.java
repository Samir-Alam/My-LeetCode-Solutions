class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // String w1 = "", w2 = "";
        // for(String s : word1)
        //     w1 += s;
        // for(String s : word2)
        //     w2 += s;
        // return w1.equals(w2);
        
        //2nd Solution
        int p1 = 0, p2 = 0; // inner pointer
        int w1 = 0, w2 = 0; // outer pointer
        while (w1 < word1.length && w2 < word2.length) {
            String curr1 = word1[w1], curr2 = word2[w2];
            if (curr1.charAt(p1) != curr2.charAt(p2)) return false;
            if (p1 < curr1.length() - 1)
                p1++;
            else {
                p1 = 0;
                w1++;
            }
            if (p2 < curr2.length() - 1)
                p2++;
            else {
                p2 = 0;
                w2++;
            }
        }
        return w1 == word1.length && w2 == word2.length;
    }
}