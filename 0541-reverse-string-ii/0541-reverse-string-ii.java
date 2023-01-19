class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int end = Math.min(i + k, s.length());
            int end2 = Math.min(i + 2 * k, s.length());
            sb.append(new StringBuilder(s.substring(i, end)).reverse());
            if(end2 > end)
                sb.append(s.substring(end, end2));
        }
        return sb.toString();
    }
}