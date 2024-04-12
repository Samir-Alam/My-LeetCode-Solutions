class Solution {
    public int trap(int[] height) {
        int i=0,left_max=height[0],sum=0;
        int j=height.length-1,right_max=height[j];
        while (i<j)
        {
            if(left_max <= right_max)
            {
                sum+=(left_max-height[i]);
                i++;
                left_max=Math.max(left_max,height[i]);
            }
            else 
            {
                sum+=(right_max-height[j]);
                j--;
                right_max=Math.max(right_max,height[j]);
            }
        }
        return sum;
        
    }
}