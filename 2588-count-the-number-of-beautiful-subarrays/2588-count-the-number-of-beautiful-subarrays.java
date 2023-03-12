class Solution {
    public long beautifulSubarrays(int[] nums) {
        HashMap<Long, Integer> mp = new HashMap<>();
        long t = 0;
        long ans = 0;
        mp.put(0L, 1);//WHENEVER 0 COMES
        for(int i = 0; i < nums.length; i++){
            t ^= nums[i];
            if(mp.containsKey(t))//IF ALREADY VAL OF XOR THERE MEANS WE CAN ABLE TO SUBTRACT FULLY SO ADD IT ANS;
                ans += mp.get(t);
           mp.put(t, mp.getOrDefault(t, 0) + 1);
        }
        return ans;
    }
}