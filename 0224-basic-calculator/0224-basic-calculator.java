class Solution {
    int idx;
    public int calculate(String s) {
        // idx = 0;
        // return calc(s);
        
        //2nd Solution
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = 10 * number + (int)(c - '0');
            }else if(c == '+'){
                result += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                result += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                stack.push(result);
                stack.push(sign);
                sign = 1;   
                result = 0;
            }else if(c == ')'){
                result += sign * number;  
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if(number != 0) result += sign * number;
        return result;
    }
    // private int calc(String s) {
    //     int res = 0, num = 0, sign = 1;
    //     while (idx < s.length()) {
    //         char c = s.charAt(idx++);
    //         if (c >= '0' && c <= '9') num = num * 10 + c - '0';
    //         else if (c == '(') num = calc(s);
    //         else if (c == ')') return res + sign * num;
    //         else if (c == '+' || c == '-') {
    //             res += sign * num;
    //             num = 0;
    //             sign = c == '-' ? -1 : 1;
    //         }
    //     }
    //     return res + sign * num; 
    // }
}