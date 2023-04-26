class Solution {
    public int addDigits(int num) {
        // if(num < 10)
        //     return num;
        // while(num > 9){
        //     int sum = 0;
        //     while(num > 0){
        //         int rev = num % 10;
        //         sum += rev;
        //         num /= 10;
        //     }
        //     num = sum;
        // }
        // return num;
        return num == 0 ? 0 : 1 + (num - 1) % 9;
    }
}