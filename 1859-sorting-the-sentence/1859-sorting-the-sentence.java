class Solution {
    public String sortSentence(String s) {
        String str[] = s.split(" "), temp[] = new String[str.length];
        int n = str.length;
        StringBuilder sb = new StringBuilder();
        for(String s1 : str)
            temp[s1.charAt(s1.length() - 1) - '1'] = s1.substring(0, s1.length() - 1);
        for(int i = 0; i < n - 1; i++)
            sb.append(temp[i]).append(" ");
        sb.append(temp[n - 1]);
        return sb.toString();
    }
}