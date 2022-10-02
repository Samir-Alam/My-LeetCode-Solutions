class Solution {
    public String truncateSentence(String s, int k) {
        // String arr[] = s.split(" ");
        // String ans = "";
        // for(int i = 0; i < k - 1; i++)
        //     ans += arr[i] + " ";
        // ans += arr[k - 1];
        // return ans;
        
        //2nd Solution
        int i=0;
        for(;i<s.length();i++)
            if(s.charAt(i)==' '){
                k--;
                if(k==0) 
                    break;
            }
        return s.substring(0,i);
    }
}