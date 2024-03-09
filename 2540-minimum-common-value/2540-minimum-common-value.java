class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        for(int i : nums1)
            for(int j : nums2){
                if(i == j)
                    return i;
                else if(i < j)
                    break;
            }
        return -1;
    }
}