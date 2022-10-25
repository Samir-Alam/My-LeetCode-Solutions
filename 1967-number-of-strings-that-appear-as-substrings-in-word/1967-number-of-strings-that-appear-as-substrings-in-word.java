class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int ans = 0;
        for(String s : patterns){
            if(word.indexOf(s) != -1)
                ans++;
        }
        return ans;
    }
}