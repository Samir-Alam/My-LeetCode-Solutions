class Solution {
    public long minCost(int[] nums, int[] cost) {
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
        
        int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
        for(int val : nums){
            lo = Math.min(lo, val);
            hi= Math.max(hi, val);
        }
        //System.out.println(lo + " " + hi);
        long res = (long)(1e18);
        while(lo <= hi){
            int mid = (lo + hi) >> 1;
            res = Math.min(res, change(nums, cost, mid));
            long left = change(nums, cost, mid-1); // this two steps are done to check which side should we go for further answer.
            long right = change(nums, cost, mid+1); // if left is smaller then the possible answer should lie in the left part or vise versa
            if(left < right){
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return res;
    }
    
    public long change(int[] nums, int[] costs, int tar){
        long ans = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != tar){
                int diff = Math.abs(nums[i] - tar); 
                ans+=(long) diff*costs[i]; // I just forget to typecast long here, which cost me extra 5min
            }
        }
        return ans;
    }
}