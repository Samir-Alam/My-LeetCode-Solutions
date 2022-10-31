class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        // int row = matrix.length, col = matrix[0].length;
        // for(int i = 0; i < row; i++){
        //     int r = i, c = 0;
        //     int ele = matrix[i][0];
        //     while(r < row && c < col){
        //         if(matrix[r][c] != ele)
        //             return false;
        //         r++;
        //         c++;
        //     }
        // }
        // for(int j = 0; j < col; j++){
        //     int r = 0, c = j;
        //     int ele = matrix[0][j];
        //     while(r < row && c < col){
        //         if(matrix[r][c] != ele)
        //             return false;
        //         r++;
        //         c++;
        //     }
        // }
        // return true;
        
        //2nd Solution
        // Map<Integer, Integer> groups = new HashMap();
        // for (int r = 0; r < matrix.length; ++r) {
        //     for (int c = 0; c < matrix[0].length; ++c) {
        //         if (!groups.containsKey(r-c))
        //             groups.put(r-c, matrix[r][c]);
        //         else if (groups.get(r-c) != matrix[r][c])
        //             return false;
        //     }
        // }
        // return true;
        
        //3rd Solution
        for (int r = 0; r < matrix.length; ++r)
            for (int c = 0; c < matrix[0].length; ++c)
                if (r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c])
                    return false;
        return true;
    }
}