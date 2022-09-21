class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        for(char c : s.toCharArray()){
            ans = Math.max(ans, st.size());
            if(c == '(')
                st.push(c);
            else if(c == ')')
                st.pop();
            else
                continue;
        }
        return ans;
    }
}