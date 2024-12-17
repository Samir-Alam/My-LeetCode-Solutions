class Solution {
    public boolean searchMatrix(int[][] m, int target) {
        int row = m.length, col = m[0].length;
        for(int i = 0; i < row; i++){
            if(m[i][col-1] >= target){
                for(int j = 0; j < col; j++){
                    if(m[i][j] == target)
                        return true;
                }
                break;
            }
        }
        return false;
    }
}