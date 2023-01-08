class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for(char c : word1.toCharArray()) arr1[c-'a']++;
        for(char c : word2.toCharArray()) arr2[c-'a']++;
        
        for(int i = 0; i < 26; i++) {
            if(arr1[i] == 0) continue;
            arr1[i]--;
            
            for(int j = 0; j < 26; j++) {
                if(arr2[j] == 0) continue;
                arr2[j]--;
                
                arr1[j]++;
                arr2[i]++;
                if(checkforsame(arr1, arr2)) return true;
                arr1[j]--; 
                arr2[i]--; 

                arr2[j]++;
            }
            arr1[i]++;
        }
        return false;
    }
    
    
    public boolean checkforsame(int[]a, int[] b) {
        int cnt1 = 0;
        int cnt2 = 0;
        for(int c : a) if(c != 0) cnt1++;
        for(int c : b) if(c != 0) cnt2++;
        return cnt1 == cnt2;
    }
}