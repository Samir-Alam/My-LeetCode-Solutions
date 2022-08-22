class Solution {
    public boolean isPowerOfFour(int n) {
        // if(n == 1)  return true;
        // if(((n%2 == 1) || (n == 0)) && n != 1)
        //     return false;
        // int ans = 4;
        // for(int i = 1; i < n; i++){
        //     ans = (int)Math.pow(4, i);
        //     if(ans == n)
        //         return true;
        //     else if(ans > n)
        //         break;
        // }
        // return ans == n;
        // return CountTrailingZeros(n);
        
        if(n<=0) return false;
        if((n&(n-1))!=0) return false;
        return (n-1)%3==0;
    }
    static boolean CountTrailingZeros(int n)
    {
         
        String bit = Integer.toBinaryString(n);
        StringBuilder bit1 = new StringBuilder();
        bit1.append(bit);
        int zero = 0;
      
        for (int i = 1; i < 64; i++) {
            if (i < bit1.length() && bit1.charAt(i) == '0')
                zero++;
            else if(i < bit1.length() && bit1.charAt(i) == '1')
                return false;
        }
      
        return zero%2 == 0;
    }
}