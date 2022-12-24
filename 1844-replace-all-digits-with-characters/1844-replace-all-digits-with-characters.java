class Solution {
    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(i % 2 == 0)
                sb.append(s.charAt(i));
            else{
                int a = (int)s.charAt(i - 1) + Character.getNumericValue(s.charAt(i));
                char c = (char)(a);
                sb.append(c);
            }
        }
        return sb.toString();
    }
}