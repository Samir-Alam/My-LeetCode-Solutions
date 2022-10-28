class Solution {
    public String freqAlphabets(String s) {
        // int p1 = 0, p2 = 2;
        // int n = s.length();
        // char map[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        // String ans = "";
        // if(n < 3){
        //     for(char c : s.toCharArray()){
        //         ans += map[c - '1'];
        //     }
        // }
        // while(p1 < n){
        //     if(p2 < n && s.charAt(p2) == '#'){
        //         ans += map[Integer.parseInt(s.substring(p1, p2)) - 1];
        //         p1 += 3;
        //         p2 += 3;
        //     }else{
        //         ans += map[s.charAt(p1) - '1'];
        //         p1++;
        //         p2++;
        //     }
        // }
        // return ans;
        
        StringBuilder result = new StringBuilder();
        int n = s.length();
        for (int i=n-1;i>=0;i--){ // Traverse string reversely.
            char ch = s.charAt(i);
            if ( ch=='#'){
                int j = Integer.parseInt(s.substring(i-2,i));
                //Convert previous two chars into int 
                result.append((char)(j+'a'-1));//convert new int to char using ASCII
                i -= 2;
            }
            else{
                result.append( (char)(ch+'0') );
            }
        }
        result.reverse();
        return result.toString();
    }
}