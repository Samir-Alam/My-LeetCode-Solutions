class Solution {
    public int[] productQueries(int n, int[][] queries) {
        // int mod = 1000000007;
        // List<Integer> powers = new ArrayList<Integer>();
        // for(int i = 0; i < 32; i++){
        //     int bit = (n & ( 1 << i )) >> i;
        //     if(bit == 1)
        //         powers.add((int)Math.pow(2, i));
        // }
        // int res[] = new int[queries.length];
        // for(int i = 0; i < queries.length; i++){
        //     int lo = queries[i][0];
        //     int high = queries[i][1];
        //     long val = 1;
        //     for(int j = lo; j <= high; j++){
        //         val = val * powers.get(j);
        //         val = val % mod;
        //     }
        //     res[i] = (int)val;
        // }
        // return res;
        
        //2nd Solution
        int mod=1000000007;
        //generating the array based on the given n value  n%2 and n/2 evry time genrating an array of 0 and 1 indcating whether to consdier the index or not and generate the powers array according to the array generated indexes
        List<Integer> arr=new ArrayList<Integer>();
        List<Integer> powers=new ArrayList<Integer>();
        while(n>0){  
            arr.add((int)n%2);
            n/=2;
        }
         //System.out.print(arr);
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)==1){  //considering only the arrays of value equals 1 indicating the maximum powers sum to n
                int t=(int)Math.pow(2,i);
                powers.add(t);
            }
        }
        int result[]=new int[queries.length];
        int j=0;
        for(int []a:queries){
            long res=1;
            for(int i=a[0];i<=a[1];i++){
                res=(res*powers.get(i)%mod);
            }
            result[j++]=(int)res%mod;
        }
        return result;
    }
}