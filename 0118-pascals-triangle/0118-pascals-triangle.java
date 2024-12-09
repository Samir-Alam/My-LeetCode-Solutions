class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            List<Integer> temp = genrow(i);
            ans.add(temp);
        }
        return ans;
    }
    public List<Integer> genrow(int row){
        List<Integer> ans = new ArrayList<>();
        long a = 1;
        ans.add((int)a);
        for(int i = 1; i < row; i++){
            a *= row-i;
            a /= i;
            ans.add((int)a);
        }
        return ans;
    }
}