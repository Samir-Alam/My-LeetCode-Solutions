class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        // for(int i : nums1)
        //     for(int j : nums2){
        //         if(i == j)
        //             return i;
        //         else if(i < j)
        //             break;
        //     }
        // return -1;
        
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j])
                return nums1[i];
            else if(nums1[i] < nums2[j])
                i++;
            else
                j++;
        }
        return -1;
    }
}