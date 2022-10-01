class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        for(String s : words){
            count++;
            for(char c : s.toCharArray()){
                if(!allowed.contains(c + "")){
                    count--;
                    break;
                }else
                    continue;
            }
        }
        return count;
    }
}