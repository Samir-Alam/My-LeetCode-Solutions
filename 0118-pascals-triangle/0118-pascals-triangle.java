class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            ans.add(new ArrayList<Integer>());
            if(i == 0)
                ans.get(i).add(1);
            else{
                for(int j = 0; j <= i; j++){
                    if(j == 0 || j == i)
                        ans.get(i).add(1);
                    else
                        ans.get(i).add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
        }
        return ans;
    }
}