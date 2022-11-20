class Solution {
    int idx;
    public int calculate(String s) {
        idx = 0;
        return calc(s);
    }
    private int calc(String s) {
        int res = 0, num = 0, sign = 1;
        while (idx < s.length()) {
            char c = s.charAt(idx++);
            if (c >= '0' && c <= '9') num = num * 10 + c - '0';
            else if (c == '(') num = calc(s);
            else if (c == ')') return res + sign * num;
            else if (c == '+' || c == '-') {
                res += sign * num;
                num = 0;
                sign = c == '-' ? -1 : 1;
            }
        }
        return res + sign * num; 
    }
}