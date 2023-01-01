class Solution {
    public int minimumPartition(String s, int k) {
        int i = 0, c = 0, j = 0;
        while(j < s.length()){
            while(j < s.length() && Long.parseLong(s.substring(i, j + 1)) <= k)
                j++;
            c++;
            if(i == j)
                return -1;
            i = j;
        }
        return c;
    }
}