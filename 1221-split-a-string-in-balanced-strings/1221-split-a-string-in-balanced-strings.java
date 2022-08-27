class Solution {
    public int balancedStringSplit(String s) {
        int count = 0, BalanceCount = 0;
        for(int i = 0; i < s.length(); i++){
            if(BalanceCount == 0)
                count++;
            BalanceCount = s.charAt(i) == 'R' ? BalanceCount+1 : BalanceCount-1;
        }
        return count;
    }
}