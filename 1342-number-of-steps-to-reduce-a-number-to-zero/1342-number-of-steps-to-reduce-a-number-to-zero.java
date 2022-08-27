class Solution {
    public int numberOfSteps(int num) {
        //1st Solution
        // int count = 0;
        // while(num != 0){
        //     num = (num & 1) == 1 ? num - 1 : num / 2;
        //     count++;
        // }
        // return count;
        
        //2nd Solution
        if(num == 0) return 0;
        int res = 0;
        while(num != 0) {
            res += (num & 1) == 1 ? 2 : 1;
            num >>= 1;
        }
        return res - 1;
    }
}