class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            map.putIfAbsent(sort(s), new ArrayList<>());
            map.get(sort(s)).add(s);
        }
        return new ArrayList<>(map.values());
    }
    public String sort(String s){
        char c[] = s.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }
}