class Solution {
    public List<String> generateParenthesis(int n) {
        // List<String> ans = new ArrayList();
        // if (n == 0) {
        //     ans.add("");
        // } else {
        //     for (int c = 0; c < n; ++c)
        //         for (String left: generateParenthesis(c))
        //             for (String right: generateParenthesis(n - 1 - c))
        //                 ans.add("(" + left + ")" + right);
        // }
        // return ans;
        
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
}