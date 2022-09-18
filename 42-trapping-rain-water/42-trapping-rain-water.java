class Solution {
    public int trap(int[] height) {
//         int n = height.length, ans = 0;
//         int left[] = new int[n];
//         int right[] = new int[n];
        
//         left[0] = height[0];
//         for(int i = 1; i < n; i++)
//             left[i] = Math.max(left[i - 1], height[i]);
        
//         right[n - 1] = height[n - 1];
//         for(int i = n - 2; i >= 0; i--)
//             right[i] = Math.max(right[i + 1], height[i]);
        
//         for(int i = 0; i < n; i++)
//             ans += Math.min(left[i], right[i]) - height[i];
        
//         return ans;
        
        //2nd Solution - O(1) Space
        
        if (height.length <= 2) return 0;
        int n = height.length, maxLeft = height[0], maxRight = height[n-1];
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            if (maxLeft < maxRight) {
                if (height[left] > maxLeft)
                    maxLeft = height[left];
                else
                    ans += maxLeft - height[left];
                left += 1;
            } else {
                if (height[right] > maxRight)
                    maxRight = height[right];
                else
                    ans += maxRight - height[right];
                right -= 1;
            }
        }
        return ans;
    }
}