class Solution {
    public boolean isPowerOfThree(int n) {
        //first solution
        // double a = Math.log(n) / Math.log(3);
        // return Math.abs(a - Math.round(a)) < 1e-10;
        
        //Second solution
        // while(n >= 3){
        //     if(n % 3 != 0) return false;
        //     n /= 3;
        // }
        // return n==1;
        
        //third solution
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
        
    }
}