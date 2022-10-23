class Solution {
    // public long minCost(int[] nums, int[] cost) {
        // long ans = 0;
        // Map<Integer,Integer> map = new HashMap<>();
        // int min = Integer.MAX_VALUE, max = 0;
        // for(int i=0; i<nums.length; i++){
        //     map.put(nums[i], cost[i]+map.getOrDefault(nums[i], 0));
        //     min = Math.min(min,nums[i]);
        //     max = Math.max(max,nums[i]);
        // }
        // long cmin = map.get(min);
        // long cmax = map.get(max);
        // while(min<max){
        //     if(cmin<=cmax){
        //         ans += cmin;
        //         min++;
        //         cmin += map.getOrDefault(min,0);
        //     }else{
        //         ans += cmax;
        //         max--;
        //         cmax += map.getOrDefault(max,0);
        //     }
        // }
        // return ans;
        
        // TreeMap<Integer, Long> numCosts = new TreeMap<>();
        // for (int i = 0; i < nums.length; i++) {
        //     numCosts.put(nums[i], numCosts.getOrDefault(nums[i], (long) 0) + cost[i]);
        // }
        // long preSum = 0;  // exclusive
        // long postSum = 0;  // inclusive
        // for (int n : numCosts.keySet()) {
        //     postSum += numCosts.get(n);
        // }
        // int target = numCosts.firstKey();
        // long currCost = 0;
        // for (int n : numCosts.keySet()) {
        //     currCost += Math.abs(n - target) * numCosts.get(n);
        // }
        // long minCost = currCost;
        // while (numCosts.higherKey(target) != null) {
        //     int nextTarget = numCosts.higherKey(target);
        //     preSum += numCosts.get(target);
        //     postSum -= numCosts.get(target);
        //     currCost += Math.abs(nextTarget - target) * (preSum - postSum);
        //     minCost = Math.min(minCost, currCost);
        //     target = nextTarget;
        // }
        // return minCost;
        
    //     int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
    //     for(int val : nums){
    //         lo = Math.min(lo, val);
    //         hi= Math.max(hi, val);
    //     }
    //     long res = (long)(1e18);
    //     while(lo <= hi){
    //         int mid = (lo + hi) >> 1;
    //         res = Math.min(res, change(nums, cost, mid));
    //         long left = change(nums, cost, mid-1);
    //         long right = change(nums, cost, mid+1);
    //         if(left < right){
    //             hi = mid - 1;
    //         }else
    //             lo = mid + 1;
    //     }
    //     return res;
    // }
    // public long change(int[] nums, int[] costs, int tar){
    //     long ans = 0;
    //     for(int i = 0; i<nums.length; i++)
    //         if(nums[i] != tar){
    //             int diff = Math.abs(nums[i] - tar); 
    //             ans+=(long) diff*costs[i];
    //         }
    //     return ans;
    // }
    
    public long check(int mid,int[] arr,int[] cost){
        long sum = 0;
         for(int i = 0; i < arr.length; i++)
             sum += 1l * Math.abs(mid - arr[i]) * cost[i];      
         return sum;
    }
    public long minCost(int[] nums, int[] cost) {
        int l = 0, r = 1000000;
        while(l <= r){
            int mid = (l + r) / 2;
            long p1 = check(mid-1,nums,cost);
            long p2 = check(mid,nums,cost);
            long p3 = check(mid+1,nums,cost);
            if(p1 >= p2 && p3 >= p2)
                return p2;
            else if(p1 < p2)
                r = (mid-1);
             else  
                l=(mid+1);
        }
        return 0;
    }
}