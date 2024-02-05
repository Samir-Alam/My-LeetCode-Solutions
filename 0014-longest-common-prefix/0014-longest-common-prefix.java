class Solution {
    public String longestCommonPrefix(String[] strs) {
        for (int i = 0; i < strs[0].length(); i++) {
            char tmpChar = strs[0].charAt(i); 
            for (int j = 0; j < strs.length; j++) 
                if (strs[j].length() == i || strs[j].charAt(i) != tmpChar) 
                    return strs[0].substring(0, i);
        }
        return strs[0];
    }
}