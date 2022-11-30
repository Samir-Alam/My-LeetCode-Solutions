class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);
        Set<Integer> set = new HashSet<>();
        for(int i : map.keySet())
            set.add(map.get(i));
        return set.size() == map.size();
    }
}