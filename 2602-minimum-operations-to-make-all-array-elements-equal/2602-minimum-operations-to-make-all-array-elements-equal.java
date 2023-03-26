class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        List<Long> list = new ArrayList<>();
        long[] prefix = new long[nums.length+2]; // taking prefix[0] an prefix[prefix.length-1] as 0 to avoid Index Out Of Bound
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            prefix[i+1]=sum;
        }
        for(int x:queries){
            int idx = Arrays.binarySearch(nums,x);
            if(idx<0){
                idx = -1*(idx+2);
            }
            list.add(((long)(idx+1)*x - prefix[idx+1]) + ((prefix[prefix.length-2] - prefix[idx+1]) - (long)(nums.length - idx - 1)*x));
        }
        return list;
    }
}