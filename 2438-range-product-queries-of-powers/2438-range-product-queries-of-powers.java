class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int mod = 1000000007;
        List<Integer> powers = new ArrayList<Integer>();
        for(int i = 0; i < 32; i++){
            int bit = (n & ( 1 << i )) >> i;
            if(bit == 1)
                powers.add((int)Math.pow(2, i));
        }
        int res[] = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int lo = queries[i][0];
            int high = queries[i][1];
            long val = 1;
            for(int j = lo; j <= high; j++){
                val = val * powers.get(j);
                val = val % mod;
            }
            res[i] = (int)val;
        }
        return res;
    }
}