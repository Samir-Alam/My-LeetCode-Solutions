class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int ans[] = new int[101];
        
        //--------1st Solution--------
        
        // for(int i = 0; i < n; i++){
        //     int count = 0;
        //     for(int j = 0; j < n; j++){
        //         if(nums[i] > nums[j])
        //             count++;
        //     }
        //     ans[i] = count;
        // }
        // return ans;
        
        
        //--------2nd Solution--------
        
        // int temp[] = Arrays.copyOf(nums, n);
        // Arrays.sort(temp);
        // for(int i = 0; i < n; i++){
        //     if(i == 0)
        //         ans[temp[i]] = 0;
        //     else if(temp[i] != temp[i - 1])
        //         ans[temp[i]] = i;
        //     else
        //         ans[temp[i]] = ans[temp[i - 1]]; 
        // }
        // for(int i = 0; i < n; i++)
        //     temp[i] = ans[nums[i]];
        // return temp;
        
        
        //--------3rd Solution--------
        
        int[] bucket = new int[102];
        for(int i = 0; i < nums.length; i++)
            bucket[nums[i] + 1]++;

        for(int i = 1; i < 102; i++) 
            bucket[i] += bucket[i - 1];
        
        for(int i = 0; i<nums.length; i++)
            nums[i] = bucket[nums[i]];
        
        return nums;
    }
}