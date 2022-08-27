class Solution {
    public List<String> cellsInRange(String s) {
        int startIndex = Integer.parseInt(Character.toString(s.charAt(1)));
        int endIndex = Integer.parseInt(Character.toString(s.charAt(4)));
        int startChar = (int)s.charAt(0);
        int endChar = (int)s.charAt(3);
        List<String> ans = new ArrayList<>();
        for(int i = startChar; i <= endChar; i++){
            for(int j = startIndex; j <= endIndex; j++){
                String ss = Character.toString((char)i);
                ss += Integer.toString(j);
                ans.add(ss);
            }
        }
        return ans;
    }
}