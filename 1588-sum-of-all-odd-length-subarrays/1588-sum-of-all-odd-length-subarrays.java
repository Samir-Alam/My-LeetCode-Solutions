class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        
        //Brute Force
        // int n = arr.length, res = 0;
        // for(int i = 0; i < n; i += 2){  //size of subarray
        //     for(int j = 0; j < n - i; j++){ //start index
        //         for(int k = 0; k <= i; k++)
        //             res += arr[j + k];
        //     }
        // }
        // return res;
        
        //2nd Solution
        int res = 0, n = arr.length;
        for (int i = 0; i < n; ++i) {
            res += ((i + 1) * (n - i) + 1) / 2 * arr[i];
        }
        return res;
    }
}