class Solution {
    public List<Integer> partitionLabels(String s) {
        // int[] last = new int[26];
        // for (int i = 0; i < s.length(); ++i)
        //     last[s.charAt(i) - 'a'] = i;
        // int j = 0, anchor = 0;
        // List<Integer> ans = new ArrayList();
        // for (int i = 0; i < s.length(); ++i) {
        //     j = Math.max(j, last[s.charAt(i) - 'a']);
        //     if (i == j) {
        //         ans.add(i - anchor + 1);
        //         anchor = i + 1;
        //     }
        // }
        // return ans;
        
        int n = s.length();
        List<Integer> l = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(s.charAt(i), i);
        int outerLoop = 0;
        while (outerLoop < n) {
            int maxEnd = map.get(s.charAt(outerLoop)), innerLoop = outerLoop + 1;
            while (innerLoop < maxEnd) {
                int curr = map.get(s.charAt(innerLoop));
                if (curr > maxEnd) 
                    maxEnd = curr;
                innerLoop++;
            }
            l.add(maxEnd - outerLoop + 1);
            outerLoop = maxEnd + 1;
        }

        return l;
    }
}