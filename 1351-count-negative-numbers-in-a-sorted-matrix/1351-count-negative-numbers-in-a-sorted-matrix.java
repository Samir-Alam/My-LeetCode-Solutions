class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            for (int element : row) {
                if (element < 0) {
                    count++;
                }
            }
        }
        return count;
    }
}