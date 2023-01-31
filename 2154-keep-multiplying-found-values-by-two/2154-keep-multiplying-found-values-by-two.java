class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        while(set.contains(original)){
            original *= 2;
        }
        return original;
    }
}