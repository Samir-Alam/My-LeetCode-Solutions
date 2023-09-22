class Solution {
    public boolean isSubsequence(String s, String t) {
        int ind = 0, n = s.length();
        for(int i = 0; i < t.length(); i++)
            if(ind < n && s.charAt(ind) == t.charAt(i))
                ind++;
        return ind == n;
    }
}