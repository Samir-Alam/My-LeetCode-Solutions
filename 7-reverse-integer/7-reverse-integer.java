class Solution {
    public int reverse(int x) {
        // long rev = 0;
        // while(n != 0){
        //     if((rev >= Math.pow(2, 31) - 1) && (rev <= Math.pow(-2, 31)))
        //         return 0;
        //     rev = rev*10 + (long)n%10;
        //     n = n/10;
        // }
        // if((rev <= Math.pow(2, 31) - 1) && (rev >= Math.pow(-2, 31)))
        //     return (int)rev;
        // return 0;

        int ans=0;
        while(x != 0){
            if(ans > Integer.MAX_VALUE/10 || ans < Integer.MIN_VALUE/10)
                return 0;
            else{
                ans = ans * 10 + x % 10;
                x = x / 10;
            }
        }
        return ans;
    }
}