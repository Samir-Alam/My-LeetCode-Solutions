class Solution {
    public int countPairs(int[] nums, int k) {
        // int ans = 0, n = nums.length;
        // for(int i = 0; i < n - 1; i++){
        //     for(int j = i + 1; j < n; j++){
        //         if(nums[i] == nums[j] && (i * j) % k == 0)
        //             ans++;
        //     }
        // }
        // return ans;
        
        //2nd Solution From Discussion
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < nums.length; ++i)
            indices.computeIfAbsent(nums[i], l -> new ArrayList<>()).add(i);
        int cnt = 0;
        for (List<Integer> ind : indices.values()) 
            for (int i = 0; i < ind.size(); ++i) 
                for (int j = 0; j < i; ++j) 
                    if (ind.get(i) * ind.get(j) % k == 0) 
                        ++cnt;
        return cnt;
    }
}