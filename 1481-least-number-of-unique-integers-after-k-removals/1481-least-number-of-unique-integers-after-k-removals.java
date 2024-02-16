class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> frequencies = new ArrayList<>(map.values());
        Collections.sort(frequencies);
        int elementsRemoved = 0;
        for (int i = 0; i < frequencies.size(); i++) {
            elementsRemoved += frequencies.get(i);
            if (elementsRemoved > k) {
                return frequencies.size() - i;
            }
        }
        return 0;
    }
}