class Solution {
    public boolean searchMatrix(int[][] m, int target) {
        int row = m.length, col = m[0].length;
        // for(int i = 0; i < row; i++){
        //     if(m[i][col-1] >= target){
        //         for(int j = 0; j < col; j++){
        //             if(m[i][j] == target)
        //                 return true;
        //         }
        //         break;
        //     }
        // }
        // return false;
        return binarySearch(m, row, col, target);
    }
    public boolean binarySearch(int[][] arr, int m, int n, int target){
        int low = 0, high = (m * n) - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int row = mid / n, col = mid % n;
            if(arr[row][col] == target)
                return true;
            else if(arr[row][col] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}