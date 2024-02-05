class Solution {
    public String longestCommonPrefix(String[] strs) {
        // for (int i = 0; i < strs[0].length(); i++) {
        //     char tmpChar = strs[0].charAt(i); 
        //     for (int j = 0; j < strs.length; j++) 
        //         if (strs[j].length() == i || strs[j].charAt(i) != tmpChar) 
        //             return strs[0].substring(0, i);
        // }
        // return strs[0];
        
        Arrays.sort(strs);
        String s1 = strs[0], s2 = strs[strs.length - 1];
        int idx = 0;
        while(idx < s1.length()){
            if(s1.charAt(idx) == s2.charAt(idx))
                idx++;
            else
                break;
        }
        return s1.substring(0, idx);
    }
}