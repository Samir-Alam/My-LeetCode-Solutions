class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> a = new ArrayList<>();
        for(int i = 0; i < nums.length / 2; i++){
            for(int j = 0; j < nums[i*2]; j++){
                a.add(nums[i*2 + 1]);
            }
        }int[] array = new int[a.size()];
        int ind = 0;
        for(int i : a)
            array[ind++] = i;
        return array;
    }
}