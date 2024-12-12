class Solution {
    public void rotate(int[][] matrix) {
        //transpose
        int row = matrix.length, col = matrix[0].length;
        for(int i = 0; i < row - 1; i++)
            for(int j = i+1; j < col; j++)
                swap(matrix, i, j, j, i);
        for(int i = 0; i < row; i++){
            reverse(matrix[i]);
        }
    }
    public void swap(int[][] arr, int i, int j, int a, int b){
        int temp = arr[i][j];
        arr[i][j] = arr[a][b];
        arr[a][b] = temp;
    }
    public void reverse(int[] arr){
        for(int i = 0; i < arr.length / 2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}