class Solution {
    public int distinctPrimeFactors(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int n : nums){
            int i = 2;
            while(n > 1){
                if(n % i == 0){
                    map.put(i, map.getOrDefault(i, 0) + 1);
                    n /= i;
                }
                else i++;
            }
        }
        return map.size();
        
    }
}