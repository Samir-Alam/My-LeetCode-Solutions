class Solution {
    public int[][] generateMatrix(int n) {
        int arr[][] = new int[n][n];
        int sr = 0;
        int sc = 0;
        int er = n - 1;
        int ec = n - 1;
        int a = 1;
        while(sr <= er && sc <= ec){
            for(int i = sc; i <= ec; i++)
                arr[sr][i] = a++;
            for(int i = sr + 1; i <= er; i++)
                arr[i][ec] = a++;
            for(int i = ec - 1; i >= sc; i--){
                if(sr == er)
                    break;
                arr[er][i] = a++;
            }
            for(int i = er - 1; i >= sr + 1; i--){
                if(sc == ec)
                    break;
                arr[i][sc] = a++;
            }
            sr++;
            sc++;
            er--;
            ec--;
        }
        return arr;
    }
}