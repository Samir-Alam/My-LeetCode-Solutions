class Solution {
    public boolean checkValidString(String s) {
        int openCount = 0;
        int closeCount = 0;
        int length = s.length() - 1;
        
        for (int i = 0; i <= length; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                openCount++;
            } else
                openCount--;
            if (s.charAt(length - i) == ')' || s.charAt(length - i) == '*') {
                closeCount++;
            } else
                closeCount--;
            if (openCount < 0 || closeCount < 0)
                return false;
        }
        return true;
    }
}