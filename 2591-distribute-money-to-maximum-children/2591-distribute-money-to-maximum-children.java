class Solution {
    public int distMoney(int money, int children) {
        if(money < children) {
            return -1;
        }
        
        money -= children;

        int result = 0;
        while (money - 7 >= 0 && result < children) {
            money -= 7;
            result++;
        }
        
        if((money == 3 && result == children - 1) || (money > 0 && result == children)) {
            result--;
        }

        return result;
    }
}