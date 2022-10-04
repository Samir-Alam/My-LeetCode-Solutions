class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>(), neg = new ArrayList<>();
        for(int i : nums){
            if(i > 0)
                pos.add(i);
            else
                neg.add(i);
        }
        int p = 0, n = 0;
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0){
                nums[i] = pos.get(p);
                p++;
            }
            else{
                nums[i] = neg.get(n);
                n++;
            }
        }
        return nums;
    }
}