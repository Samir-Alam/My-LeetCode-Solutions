class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        List<Character> ans = new ArrayList<>();
        for(char c : allowed.toCharArray())
            ans.add(c);
        for(String s : words){
            count++;
            for(char c : s.toCharArray()){
                if(!ans.contains(c)){
                    count--;
                    break;
                }else
                    continue;
            }
        }
        return count;
    }
}