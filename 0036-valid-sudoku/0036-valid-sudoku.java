class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Set seen = new HashSet();
        // for (int i = 0; i < 9; ++i) {
        //     for (int j = 0; j < 9; ++j) {
        //         char number = board[i][j];
        //         if (number != '.')
        //             if (!seen.add(number + " in row " + i) ||
        //                 !seen.add(number + " in column " + j) ||
        //                 !seen.add(number + " in block " + i/3 + "-" + j/3))
        //                 return false;
        //     }
        // }
        // return true;
        
        //2nd Solution
        for(int i = 0; i < 9; i++){
        HashSet<Character> rows = new HashSet<Character>();
        HashSet<Character> columns = new HashSet<Character>();
        HashSet<Character> cube = new HashSet<Character>();
        for (int j = 0; j < 9;j++){
            if(board[i][j] != '.' && !rows.add(board[i][j]))
                return false;
            if(board[j][i] != '.' && !columns.add(board[j][i]))
                return false;
            int RowIndex = 3 * (i / 3);
            int ColIndex = 3 * (i % 3);
            if(board[RowIndex + j / 3][ColIndex + j % 3] != '.' && 
               !cube.add(board[RowIndex + j / 3][ColIndex + j % 3]))
                return false;
        }
    }
    return true;
    }
}