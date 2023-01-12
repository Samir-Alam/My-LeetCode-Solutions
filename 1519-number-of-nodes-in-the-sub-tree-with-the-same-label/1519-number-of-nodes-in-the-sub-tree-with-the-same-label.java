class Solution {
    int[] array;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        array = new int[n];
        ArrayList<Integer>[] a = new ArrayList[n];
        for(int i = 0; i < n; i++)
            a[i] = new ArrayList<Integer>();
        for(int[] x : edges){
            a[x[0]].add(x[1]);
            a[x[1]].add(x[0]);
        }
        dfs(-1,0,a,labels);
        return array;
    }
    private int[] dfs(int prev, int curr, ArrayList<Integer>[] a, String labels){
        int[] ans = new int[26];
        for(int x : a[curr]){
            if(prev != x){
                int[] res = dfs(curr, x, a, labels);
                for(int i = 0; i < res.length; i++)  
                    ans[i] += res[i];
            }
        }
        array[curr] = ++ans[labels.charAt(curr) - 'a']; 
        return ans;
    }
}