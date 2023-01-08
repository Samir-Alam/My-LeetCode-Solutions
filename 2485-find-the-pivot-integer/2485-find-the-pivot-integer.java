class Solution {
    public int pivotInteger(int n) {
        // if(n == 1)
        //     return 1;
        // int r = n, l = 1;
        // int lsum = l, rsum = r;
        // while(l < r){
        //     if(lsum < rsum){
        //         l++;
        //         lsum += l;
        //     }else if(rsum < lsum){
        //         r--;
        //         rsum += r;
        //     }else{
        //         l++;
        //         lsum += l;
        //         r--;
        //         rsum += r;
        //     }
        // }
        // return rsum == lsum ? l : -1;
        
        int sum = n * (n + 1) / 2;
        int lo = 1, hi = n + 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int leftSum = (mid - 1) * mid / 2;
            int rightSum = sum - (mid + 1) * mid / 2;
            if (leftSum < rightSum)
                lo = mid + 1;
            else
                hi = mid;
        }
        return (lo - 1) * lo / 2 == sum - lo * (lo + 1) / 2 ? lo : -1;
    }
}