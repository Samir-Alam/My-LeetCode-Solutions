class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        for (String w: words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
            max = Math.max(max, map.get(w));
        }
        List<String>[] bucket = new ArrayList[max + 1];
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            int fre = entry.getValue();
            if (bucket[fre] == null) {
                bucket[fre] = new ArrayList<>();
            }
            bucket[fre].add(entry.getKey());
        }
        List<String> res = new ArrayList<>();
        for (int i = max; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                Collections.sort(bucket[i]);
                res.addAll(bucket[i]);
            }
        }
        return res.subList(0, k);
    }
}