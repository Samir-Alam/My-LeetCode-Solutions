class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        // int ans[] = new int[k];
        // Map<Integer, HashSet<Integer>> map = new HashMap<>();
        // for(int i[] : logs){
        //     HashSet set = new HashSet<>();
        //     if(map.containsKey(i[0])){
        //         set = map.get(i[0]);
        //         set.add(i[1]);
        //         map.put(i[0], set);
        //     }
        //     else{
        //         set.add(i[1]);
        //         map.put(i[0], set);
        //     }
        // }
        // for (Integer i : map.keySet())
        //     ans[map.get(i).size() - 1]++;
        // return ans;
        
        //2nd Solution From Discussion
        int[] res = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] l : logs) {
            map.putIfAbsent(l[0], new HashSet<>());
            map.get(l[0]).add(l[1]);
        }
        for (int key : map.keySet())
            res[map.get(key).size() - 1]++;
        return res;
    }
}