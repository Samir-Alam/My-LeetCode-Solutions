class Solution {
    public int maxSubarraySumCircular(int[] A) {
        // int nonCircularSum = kadaneMaxSum(A);
        // int totalSum = 0;
        // for(int i = 0; i < A.length; i++){
        //     totalSum += A[i];
        //     A[i] = -A[i];
        // }
        // int circularSum = totalSum + kadaneMaxSum(A);
        // if(circularSum == 0)
        //     return nonCircularSum;
        // return Math.max(circularSum, nonCircularSum);
        
        int curMax = 0, curMin = 0, sum = 0, maxSum = A[0], minSum = A[0];
        for (int num : A) {
            curMax = Math.max(curMax, 0) + num;
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin, 0) + num;
            minSum = Math.min(minSum, curMin);
            sum += num;  
        }
        return sum == minSum ? maxSum : Math.max(maxSum, sum - minSum);
    }
    int kadaneMaxSum(int[] A){
        int currentSum = A[0];
        int maxSum = A[0];
        for(int i = 1; i < A.length; i++){
            if(currentSum < 0)
                currentSum = 0;
            currentSum += A[i];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}