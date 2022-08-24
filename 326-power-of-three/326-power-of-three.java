class Solution {
    public boolean isPowerOfThree(int n) {
        // double a = Math.log(n) / Math.log(3);
        // return Math.abs(a - Math.round(a)) < 1e-10;
        while(n>=3){
            if(n%3!=0) return false;
            n/=3;
        }
        return n==1;
        
    }
}