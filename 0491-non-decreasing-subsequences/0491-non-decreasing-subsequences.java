class Solution {
    private void backtrack(int[] nums, int index, List<Integer> sequence,
            Set<List<Integer>> result) {
        if (index == nums.length) {
            if (sequence.size() >= 2)
                result.add(new ArrayList<>(sequence));
            return;
        }
        if (sequence.isEmpty() ||
                sequence.get(sequence.size() - 1) <= nums[index]) {
            sequence.add(nums[index]);
            backtrack(nums, index + 1, sequence, result);
            sequence.remove(sequence.size() - 1);
        }
        backtrack(nums, index + 1, sequence, result);
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        List<Integer> sequence = new ArrayList<Integer>();
        backtrack(nums, 0, sequence, result);
        return new ArrayList(result);
    }
}