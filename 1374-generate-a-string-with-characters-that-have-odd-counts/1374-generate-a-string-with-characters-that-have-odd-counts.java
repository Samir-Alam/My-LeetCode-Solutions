class Solution {
    public String generateTheString(int n) {
        // StringBuilder sb = new StringBuilder();
        // if(n % 2 == 1)
        //     for(int i = 0; i < n; i++)
        //         sb.append('a');
        // else{
        //     for(int i = 0; i < n - 1; i++)
        //         sb.append('a');
        //     sb.append('b');
        // }
        // return sb.toString();
        
        char c[] = new char[n];
        Arrays.fill(c, 'a');
        if(n%2 == 0)    c[c.length - 1] = 'b';
        return new String(c);
    }
}