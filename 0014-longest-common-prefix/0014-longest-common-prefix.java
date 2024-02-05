class Solution {
    public String longestCommonPrefix(String[] strs) {
        // for (int i = 0; i < strs[0].length(); i++) {
        //     char tmpChar = strs[0].charAt(i); 
        //     for (int j = 0; j < strs.length; j++) 
        //         if (strs[j].length() == i || strs[j].charAt(i) != tmpChar) 
        //             return strs[0].substring(0, i);
        // }
        // return strs[0];
        
        
        // using sort
        Arrays.sort(strs); // lexicographically sorts
        String s1 = strs[0], s2 = strs[strs.length - 1];    //store the 2 string from opposite extemes
        int idx = 0;    // index to traverse through the strings
        while(idx < s1.length()){
            if(s1.charAt(idx) == s2.charAt(idx))    // checking for the similar characters
                idx++;  // increament the index
            else
                break;  // if condition not matched exit the look
        }
        return s1.substring(0, idx);    // return the substring from start to where similarity ends.
    }
}