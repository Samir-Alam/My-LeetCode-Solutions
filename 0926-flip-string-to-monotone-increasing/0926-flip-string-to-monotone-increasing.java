class Solution {
    public int minFlipsMonoIncr(String s) {
        // int m = 0;
        // for (int i = 0; i < s.length(); ++i)
        //     if (s.charAt(i) == '0')
        //         m++;
        // int ans = m;
        // for (int i = 0; i < s.length(); ++i){
        //     if (s.charAt(i) == '0')
        //         ans = Math.min(ans, --m);
        //  else
        //         m++;
        // }
        // return ans;
        
        int f0 = 0, f1 = 0;
      for (int i = 0; i < s.length(); ++i) {
        f0 += s.charAt(i) - '0';
        f1 = Math.min(f0, f1 + 1 - (s.charAt(i) - '0'));
      }
      return f1;
    }
}