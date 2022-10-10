class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int ans[] = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            int countMoves = 0;
            int yIndex = startPos[0];
            int xIndex = startPos[1];
            for(int j = i; j < s.length(); j++){
                if(s.charAt(j) == 'R')
                    xIndex++;
                if(s.charAt(j) == 'L')
                       xIndex--;
                if(s.charAt(j) == 'U')
                        yIndex--;
                if(s.charAt(j) == 'D')
                    yIndex++;
                if(xIndex < 0 || xIndex >= n || yIndex < 0 || yIndex >= n)
                    break;
                else
                    countMoves++;
            }
            ans[i] = countMoves;
        }
        return ans;
    }
}