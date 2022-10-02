class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        while(start != 0 || goal != 0){
            int sbit = (start & 1);
            start = start >> 1;
            int gbit = (goal & 1);
            goal = goal >> 1;
            if(sbit != gbit)
                count++;
            else
                continue;
        }
        return count;
    }
}