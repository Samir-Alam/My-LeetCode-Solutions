class Solution {
    public String interpret(String command) {
        String ans = "";
        int n = command.length();
        for(int i = 0; i < n; i++){
            if(command.charAt(i) == 'G')
                ans += Character.toString('G');
            else if(command.charAt(i) == '('){
                if(i < n && command.charAt(i + 1) == ')'){
                    ans += Character.toString('o');
                    i++;
                }else if(i < n && command.charAt(i + 1) == 'a'){
                    i += 3;
                    ans += "al";
                }
            }
        }
        return ans;
    }
}
