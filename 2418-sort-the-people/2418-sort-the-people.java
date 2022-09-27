class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for(int i = 0; i < names.length; i++){
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        String ans[] = new String[names.length];
        for(int i = 0; i < names.length; i++)
            ans[names.length - i - 1] = map.get(heights[i]);
        return ans;
    }
}