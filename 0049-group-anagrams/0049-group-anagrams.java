class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        int n = strs.length;
        if(n == 1){
            List<String> temp = new ArrayList<>();
            temp.add(strs[0]);
            ans.add(temp);
            return ans;
        }
        for(String s : strs){
            List<String> temp = map.getOrDefault(sort(s), new ArrayList<>());
            temp.add(s);
            map.put(sort(s), temp);
        }
        for(String s : map.keySet()){
            ans.add(map.get(s));
        }
        return ans;
    }
    public String sort(String s){
        char c[] = s.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }
}