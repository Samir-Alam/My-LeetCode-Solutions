class Solution {
    public String robotWithString(String s) {
        if (s == null || s.length() < 1) return "";
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            stack.add(c);
            freq[c - 'a']--;
            while (!stack.isEmpty()) {
                char temp = stack.peek();
                if (hasSmaller(temp, freq)) 
                    break;
                sb.append(stack.pop());
            }
        }
        return sb.toString();
    }
    private boolean hasSmaller(char c, int[] freq) {
        int ind = (int)(c - 'a');
        for (int i = 0; i < ind; i++) {
            if (freq[i] > 0) return true;
        }
        return false;
    }
}