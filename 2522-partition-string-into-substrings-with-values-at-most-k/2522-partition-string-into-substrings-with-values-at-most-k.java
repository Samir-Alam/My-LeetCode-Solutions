class Solution {
    public int minimumPartition(String s, int k) {
        // int i = 0, c = 0, j = 0;
        // while(j < s.length()){
        //     while(j < s.length() && Long.parseLong(s.substring(i, j + 1)) <= k)
        //         j++;
        //     c++;
        //     if(i == j)
        //         return -1;
        //     i = j;
        // }
        // return c;
        
        int left = 0, right = 1, len = s.length(), count = 0;
        for(right = 1; right <= len; right++)
            if(right - left > 9 || Integer.parseInt(s.substring(left, right)) > k){
                if(Integer.parseInt(s.substring(right - 1, right)) > k) 
                    return -1;
                else
                    left = right-1; count++;
            }
        if(left < right) count++;
        return count;
    }
}