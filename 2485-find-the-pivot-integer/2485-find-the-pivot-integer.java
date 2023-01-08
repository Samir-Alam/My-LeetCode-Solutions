class Solution {
    public int pivotInteger(int n) {
        if(n == 1)
            return 1;
        int r = n, l = 1;
        int lsum = l, rsum = r;
        while(l < r){
            if(lsum < rsum){
                l++;
                lsum += l;
            }else if(rsum < lsum){
                r--;
                rsum += r;
            }else{
                l++;
                lsum += l;
                r--;
                rsum += r;
            }
        }
        return rsum == lsum ? l : -1;
    }
}