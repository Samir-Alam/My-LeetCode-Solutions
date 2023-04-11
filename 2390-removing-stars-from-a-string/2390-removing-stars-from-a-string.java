class Solution {
    public String removeStars(String s) {
        StringBuilder res = new StringBuilder("");
        for(char ch: s.toCharArray()) {
            if(ch!='*'){
                res.append(ch);
            }

            else{
                res.deleteCharAt(res.length()-1);
            }
        }

        return res.toString();
    }
}