class Solution {
    public boolean checkInclusion(String s1, String s2) {
    //     s1 = sort(s1);
    //     for (int i = 0; i <= s2.length() - s1.length(); i++)
    //         if (s1.equals(sort(s2.substring(i, i + s1.length()))))
    //             return true;
    //     return false;
    // }
    // public String sort(String s) {
    //     char[] t = s.toCharArray();
    //     Arrays.sort(t);
    //     return new String(t);
        
        //Sliding Window
        // if (s1.length() > s2.length())
        //     return false;
        // int[] s1map = new int[26];
        // int[] s2map = new int[26];
        // for (int i = 0; i < s1.length(); i++) {
        //     s1map[s1.charAt(i) - 'a']++;
        //     s2map[s2.charAt(i) - 'a']++;
        // }
        // int count = 0;
        // for (int i = 0; i < 26; i++)
        //     if (s1map[i] == s2map[i])
        //         count++;
        // for (int i = 0; i < s2.length() - s1.length(); i++) {
        //     int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
        //     if (count == 26)
        //         return true;
        //     s2map[r]++;
        //     if (s2map[r] == s1map[r])
        //         count++;
        //     else if (s2map[r] == s1map[r] + 1)
        //         count--;
        //     s2map[l]--;
        //     if (s2map[l] == s1map[l])
        //         count++;
        //     else if (s2map[l] == s1map[l] - 1)
        //         count--;
        // }
        // return count == 26;
        
        int n = s1.length();
        int m = s2.length();
        if(n>m) return false;
        int[] arr = new int[26];
        for(int i=0;i<n;i++){
            arr[s1.charAt(i)-'a']++;
         }
         for(int i = 0;i<m;i++){
            arr[s2.charAt(i)-'a']--;
            if(i-n >= 0){
                arr[s2.charAt(i-n)-'a']++;
            }
            if(zero(arr)) {
                return true;
            }
        }
        return false;
    }
    public boolean zero(int[] arr){
       for(int i =0 ;i<26;i++){
           if(arr[i] != 0) {
               return false;
           }
       }
       return true;
    }
}