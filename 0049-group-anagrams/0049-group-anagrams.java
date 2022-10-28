class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // List<List<String>> ans = new ArrayList<>();
        // Map<String, List<String>> map = new HashMap<>();
        // int n = strs.length;
        // for(String s : strs){
        //     List<String> temp = map.getOrDefault(sort(s), new ArrayList<>());
        //     temp.add(s);
        //     map.put(sort(s), temp);
        // }
        // for(String s : map.keySet())
        //     ans.add(map.get(s));
        // return ans;
        
        //2nd Solution
        // if (strs == null || strs.length == 0) return new ArrayList<>();
        // Map<String, List<String>> map = new HashMap<>();
        // for (String s : strs) {
        //     char[] ca = s.toCharArray();
        //     Arrays.sort(ca);
        //     String keyStr = String.valueOf(ca);
        //     if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
        //     map.get(keyStr).add(s);
        // }
        // return new ArrayList<>(map.values());
        
        //3rd Solution
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
    public String sort(String s){
        char c[] = s.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }
}