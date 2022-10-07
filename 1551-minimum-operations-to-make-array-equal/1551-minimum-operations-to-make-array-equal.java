class Solution {
    public int minOperations(int n) {
        int count = 0;
        if(n <= 3)
            return n - 1;
        int diff = n - 1;
        if((diff & 1) == 1){
            count = (n / 2) * (n / 2);
        }else
            count = (n / 2) * ((n / 2) + 1);
        return count;
    }
}