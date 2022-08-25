class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // if(x.length() > y.length())
        //     return false;
        // int arr[] = new int[26];
        // Arrays.fill(arr, 0);
        // for(int i = 0; i < y.length(); i++)
        //     arr[y.charAt(i) - 'a']++;
        // for(int i = 0; i < x.length(); i++){
        //     arr[x.charAt(i) - 'a']--;
        //     if(arr[x.charAt(i) - 'a'] < 0)
        //         return false;
        // }
        // return true;
        
        int arr[] = new int[26];
        for(char c : magazine.toCharArray())
            arr[c-'a']++;
        for(char c : ransomNote.toCharArray()){
            if(arr[c - 'a'] == 0)
                return false;
            else
                arr[c - 'a']--;
        }
        return true;
    }
}