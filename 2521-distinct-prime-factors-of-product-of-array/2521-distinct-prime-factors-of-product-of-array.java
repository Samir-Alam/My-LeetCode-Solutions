class Solution {
//     public int distinctPrimeFactors(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int count = 0;
//         for(int n : nums){
//             int i = 2;
//             while(n > 1){
//                 if(n % i == 0){
//                     map.put(i, map.getOrDefault(i, 0) + 1);
//                     n /= i;
//                 }
//                 else i++;
//             }
//         }
//         return map.size();
        
//     }
    
    public int distinctPrimeFactors(int[] nums) {
        int c=0;
        int[] a = new int[1001];
        for(int x:nums)
        {
            prime(x,a);
        }
        for(int x:a)
        {
            if(x==1)
                c++;
        }
        return c;
    }
    
    private void prime(int x,int[] a)
    {
        int root = (int)Math.sqrt(x);
        for (int i=2; i<=root; i++) {
            while (x%i == 0) {
                x/=i;
                a[i]=1;
            }
        }

        if(x>=2)
            a[x]=1;
    }
}