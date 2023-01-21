class Solution {
    public List<String> restoreIpAddresses(String s) {
        int idx = 0;
        int par = 0;
        String ans = "";
        ArrayList<String> res = new ArrayList<>();
        helper(s, idx, par, ans, res);

        return res;
    }
    public void helper(String s, int idx, int par, String ans, ArrayList<String> res){
        if(idx == s.length() || par == 4){
            if(idx==s.length() && par == 4)
                res.add(ans.substring(0, ans.length()-1));
            return;
        }
        helper(s, idx + 1, par + 1, ans + s.substring(idx, idx + 1) + ".", res);
        if(idx + 2 <= s.length() && isValid(s.substring(idx, idx + 2)))
            helper(s, idx + 2, par + 1, ans + s.substring(idx, idx + 2) + ".", res);
        if(idx + 3 <= s.length() && isValid(s.substring(idx, idx + 3)))
            helper(s, idx + 3, par + 1, ans + s.substring(idx, idx + 3) + ".", res);
    }
    public boolean isValid(String str){
        if(str.charAt(0) == '0') return false;
        return Integer.parseInt(str) <= 255;
    }
}