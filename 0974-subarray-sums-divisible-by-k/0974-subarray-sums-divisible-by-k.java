class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int prefixMod = 0, result = 0;
        int[] modGroups = new int[k];
        modGroups[0] = 1;
        for (int num: nums) {
            prefixMod = (prefixMod + num % k + k) % k;
            result += modGroups[prefixMod];
            modGroups[prefixMod]++;
        }

        return result;
    }
}