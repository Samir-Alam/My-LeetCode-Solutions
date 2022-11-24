class Solution {
	// public boolean exist(char[][] board, String word) {
	// 	int rows = board.length, cols = board[0].length;                                
	// 	if(word.length() == 0)
	// return true;                                         
	// 	if(rows * cols < word.length())
	// return false;                               
	// 	for(int r = 0; r < rows; r++)
	// 		for(int c = 0; c < cols; c++)
	// 			if(board[r][c] == word.charAt(0)){                                                
	// 				boolean isFound = dfsBoard(board, new boolean[rows][cols], r, c, word, 0);    
	// 				if(isFound)
	// return true;
	// 			}
	// 	return false;                                                                             
	// }
	// public boolean dfsBoard(char[][] board, boolean[][] visitedBoard, int row, int col, String word, int wordInd) {        			
	// 	if((row<0 || row >= board.length) || (col < 0 || col >= board[0].length) || board[row][col] != word.charAt(wordInd))
	// 		return false;                                                                             
	// 	if(visitedBoard[row][col])
	// return false;
	// 	if(wordInd == word.length() - 1)
	// return true;
	// 	visitedBoard[row][col] = true;  
	// 	if( dfsBoard(board, visitedBoard, row, col - 1, word, wordInd + 1))
	// return true;
	// 	if( dfsBoard(board, visitedBoard, row, col+1, word, wordInd + 1))
	// return true; 
	// 	if( dfsBoard(board, visitedBoard, row-1, col, word, wordInd + 1))
	// return true;
	// 	if( dfsBoard(board, visitedBoard, row+1, col, word, wordInd + 1))
	// return true;
	// 	visitedBoard[row][col] = false;
	// 	return false;
	// }
    
    //2nd Solution
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        
        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) || 
           search(board, word, i+1, j, index+1) ||
           search(board, word, i, j-1, index+1) || 
           search(board, word, i, j+1, index+1)){
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}