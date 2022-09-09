class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = groupSizes.length;
        for(int i = 0; i < n; i++){
            List<Integer> temp = map.getOrDefault(groupSizes[i], new ArrayList<Integer>());
            temp.add(i);
            map.put(groupSizes[i], temp);
        }
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i : groupSizes)
            set.add(i);
        for(int i : set){
            if(map.get(i).size() > i){
                int size = map.get(i).size();
                for(int j = 0; j < size; j += i)
                    ans.add(map.get(i).subList(j, j + i));
            }else{
                ans.add(map.get(i));
            }
        }
        return ans;
    }
}