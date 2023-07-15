class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0, ans = 0;
        for(int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        for(Map.Entry<Integer, Integer> hm : map.entrySet())
            if(hm.getValue() > max){
                max = hm.getValue();
                ans = hm.getKey();
            }
        return ans;
    }
}