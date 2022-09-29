class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0,curr = 0;
        for(int i = 1; i < bank.length; i++){
            if(ones(bank[i]) == 0)
                continue;
            ans += ones(bank[curr]) * ones(bank[i]);
            curr = i;
        }
        return ans;
    }
    public int ones(String s){
        int ans = 0;
        for(char c : s.toCharArray()){
            if(c == '1')
                ans++;
        }
        return ans;
    }
}