class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0, ans[] = new int[queries.length];;
        for (int a : A) 
            sum += (a % 2 == 0 ? a : 0); 
        for (int i = 0; i < ans.length; ++i) {
            int idx = queries[i][1];
            if (A[idx] % 2 == 0) 
                sum -= A[idx]; 
            A[idx] += queries[i][0];
            if (A[idx] % 2 == 0) 
                sum += A[idx]; 
            ans[i] = sum;
        }
        return ans;    
    }
}