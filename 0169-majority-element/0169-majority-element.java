class Solution {
    public int majorityElement(int[] nums) {
        // HashMap<Integer, Integer> map = new HashMap<>();
        // int max = 0, ans = 0;
        // for(int i : nums)
        //     map.put(i, map.getOrDefault(i, 0) + 1);
        // for(Map.Entry<Integer, Integer> hm : map.entrySet())
        //     if(hm.getValue() > max){
        //         max = hm.getValue();
        //         ans = hm.getKey();
        //     }
        // return ans;
        
        Arrays.sort(nums);
        int n = nums.length/2 + 1;
        int max = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == max)
                count++;
            else{
                max = nums[i];
                count = 1;
            }
            if(count >= n)
                return max;
        }
        return max;
    }
}