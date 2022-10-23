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
        
     TreeMap<Integer, Long> numCosts = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            numCosts.put(nums[i], numCosts.getOrDefault(nums[i], (long) 0) + cost[i]);
        }
        long preSum = 0;  // exclusive
        long postSum = 0;  // inclusive
        for (int n : numCosts.keySet()) {
            postSum += numCosts.get(n);
        }
        int target = numCosts.firstKey();
        long currCost = 0;
        for (int n : numCosts.keySet()) {
            currCost += Math.abs(n - target) * numCosts.get(n);
        }
        long minCost = currCost;
        while (numCosts.higherKey(target) != null) {
            int nextTarget = numCosts.higherKey(target);
            preSum += numCosts.get(target);
            postSum -= numCosts.get(target);
            currCost += Math.abs(nextTarget - target) * (preSum - postSum);
            minCost = Math.min(minCost, currCost);
            target = nextTarget;
        }
        return minCost;
    }
}