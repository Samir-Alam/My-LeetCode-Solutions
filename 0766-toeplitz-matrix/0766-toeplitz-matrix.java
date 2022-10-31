class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        for(int i = 0; i < row; i++){
            int r = i, c = 0;
            int ele = matrix[i][0];
            while(r < row && c < col){
                if(matrix[r][c] != ele)
                    return false;
                r++;
                c++;
            }
        }
        for(int j = 0; j < col; j++){
            int r = 0, c = j;
            int ele = matrix[0][j];
            while(r < row && c < col){
                if(matrix[r][c] != ele)
                    return false;
                r++;
                c++;
            }
        }
        return true;
    }
}