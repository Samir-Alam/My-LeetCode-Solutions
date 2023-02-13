class Solution {
    public int countOdds(int low, int high) {
        int n = high - low;
        if(low % 2 == 1)
            n += 1;
        if(high % 2 == 1)
            n += 1;
        return n/2;
    }
}