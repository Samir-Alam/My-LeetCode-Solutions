class Solution {
    public int minDeletionSize(String[] strs) {
        // int row = strs.length, col = strs[0].length(), count = 0;
        // for(int c = 0; c < col; c++)
        //     for(int r = 0; r < row - 1; r++)
        //         if((int)strs[r].charAt(c) > (int)strs[r + 1].charAt(c)){
        //             count++;
        //             break;
        //         }
        // return count;
        
        int row = strs.length;
        int col = strs[0].length();
        int ans = 0;
        for(int i = 0; i < col; i++){
            char prev = strs[0].charAt(i);
            for(int j = 1; j < row; j++){
                char ch = strs[j].charAt(i);
                 if(ch < prev){
                    ans++;
                    break;
                }
                prev = ch;
            }
        }
        return ans;       
    }
}