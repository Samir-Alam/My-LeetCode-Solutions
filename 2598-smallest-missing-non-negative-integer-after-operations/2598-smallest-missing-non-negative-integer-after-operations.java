class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int mod = num % value;
            mod = mod >= 0 ? mod : mod + value;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int check = i % value;
            if (!map.containsKey(check)) {
                return i;
            }
            int freq = map.get(check);
            if (freq <= 0) {
                return i;
            }
            map.put(check, freq - 1);
        }
        return n;
    }
}