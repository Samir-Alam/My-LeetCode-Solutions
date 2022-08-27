class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
            a.add(index[i],nums[i]);
        int target[] = new int[nums.length];
        for(int i=0;i<nums.length;i++)
            target[i] = a.get(i);
        return target;
    }
}