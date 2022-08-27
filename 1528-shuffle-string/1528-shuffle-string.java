class Solution {
    public String restoreString(String s, int[] indices) {
        char a[] = new char[s.length()];
        for(int i = 0; i < indices.length; i++)
            a[indices[i]] = s.charAt(i);
        String ans = "";
        for(char c : a)
            ans += Character.toString(c);
        return ans;
    }
}