class Solution {
    public long minCost(int[] nums, int[] cost) {
        long ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE, max = 0;
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], cost[i]+map.getOrDefault(nums[i], 0));
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        long cmin = map.get(min);
        long cmax = map.get(max);
        while(min<max){
            if(cmin<=cmax){
                ans += cmin;
                min++;
                cmin += map.getOrDefault(min,0);
            }else{
                ans += cmax;
                max--;
                cmax += map.getOrDefault(max,0);
            }
        }
        return ans;
    }
}