class Solution {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char a = 'a';
        for(char c : key.toCharArray()){
            if(!map.containsKey(c) && c != ' '){
                map.put(c, (char)a);
                a += 1;
            }
        }
        String ans = "";
        for(char c : message.toCharArray()){
            if(c != ' ')
                ans += Character.toString(map.get(c));
            else
                ans += " ";
        }
        return ans;
    }
}