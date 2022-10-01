class Solution {
    // public int countConsistentStrings(String allowed, String[] words) {
    //     int count = 0;
    //     for(String s : words){
    //         count++;
    //         for(char c : s.toCharArray()){
    //             if(!allowed.contains(c + "")){
    //                 count--;
    //                 break;
    //             }else
    //                 continue;
    //         }
    //     }
    //     return count;
    // }
    
    
    //2nd Solution
    int[] chars;
    public int countConsistentStrings(String allowed, String[] words) {
        chars = new int[26];
        for (int i = 0; i < allowed.length(); i++)
            chars[allowed.charAt(i) - 97]++;
        int count = 0;
        for (int i = 0; i < words.length; i++)
            if (isAllowed(words[i])) 
                count++;
        return count;
    }
    public boolean isAllowed(String str) {
        for (int i = 0; i < str.length(); i++)
            if (chars[str.charAt(i) - 97] == 0) 
                return false;
        return true;
    }
}