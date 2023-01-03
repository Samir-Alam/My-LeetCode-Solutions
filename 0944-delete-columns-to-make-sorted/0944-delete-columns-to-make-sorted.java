class Solution {
    public int minDeletionSize(String[] strs) {
        int row = strs.length, col = strs[0].length(), count = 0;
        for(int c = 0; c < col; c++){
            for(int r = 0; r < row - 1; r++){
                if((int)strs[r].charAt(c) > (int)strs[r + 1].charAt(c)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}