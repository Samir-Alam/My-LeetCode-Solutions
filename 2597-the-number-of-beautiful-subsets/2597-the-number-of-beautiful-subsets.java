class Solution {
    int count = 0;
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        backtrack(new HashSet<>(), 0, nums, k);
        return count - 1;
    }
    public void backtrack(Set<Integer> current, int i, int[] nums, int k) {
        count++;
        for (int j = i; j < nums.length; j++) {
            if (!current.contains(nums[j] - k)) {
                current.add(nums[j]);
                backtrack(current, j + 1, nums, k);
                current.remove(Integer.valueOf(nums[j]));
            }
        }
    }
}