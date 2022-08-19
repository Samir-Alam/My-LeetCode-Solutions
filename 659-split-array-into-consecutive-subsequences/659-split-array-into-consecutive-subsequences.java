class Solution {
    public boolean isPossible(int[] nums) {
        // Map<Integer, Integer> count = new HashMap<>();
        // List<Integer> starts = new ArrayList<>(); // start index of subsequence
        // List<Integer> ends = new ArrayList<>();   // end index of subsequence
        // for (final int num : nums)
        //     count.put(num, count.getOrDefault(num, 0) + 1);
        // for (int i = 0; i < nums.length; ++i) {
        //     if (i > 0 && nums[i] == nums[i - 1])
        //         continue;
        //     final int num = nums[i];
        //     final int currCount = count.get(num);
        //     final int prevCount = count.containsKey(num - 1) ? count.get(num - 1) : 0;
        //     final int nextCount = count.containsKey(num + 1) ? count.get(num + 1) : 0;
        //     for (int j = 0; j < currCount - prevCount; ++j)
        //         starts.add(num);
        //     for (int j = 0; j < currCount - nextCount; ++j)
        //         ends.add(num);
        // }
        // for (int i = 0; i < starts.size(); ++i)
        //     if (ends.get(i) - starts.get(i) < 2)
        //         return false;
        // return true;
        
        int pre = Integer.MIN_VALUE;
        int p1 = 0, p2 = 0, p3 = 0, cur = 0, cnt = 0, c1 = 0, c2 = 0, c3 = 0;
        for (int i = 0; i < nums.length; pre = cur, p1 = c1, p2 = c2, p3 = c3) {
            for (cur = nums[i], cnt = 0; i < nums.length && cur == nums[i]; i++) 
                cnt++;
            if (cur != pre + 1) {
                if (p1 != 0 || p2 != 0)
                    return false;
                c1 = cnt;
                c2 = 0;
                c3 = 0;
            } else {
                if (cnt < p1 + p2) 
                    return false;
                c1 = Math.max(0, cnt - (p1 + p2 + p3));
                c2 = p1;
                c3 = p2 + Math.min(p3, cnt - (p1 + p2));
            }
        }
        return (p1 == 0 && p2 == 0);
    }
}