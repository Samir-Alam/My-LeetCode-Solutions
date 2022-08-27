class Solution {
    public int[] minOperations(String boxes) {
        
        //1st Solution
        // int ans[] = new int[boxes.length()];
        // for(int i = 0; i < boxes.length(); i++){
        //     for(int j = 0; j < boxes.length(); j++){
        //         if(boxes.charAt(j) == '1')
        //             ans[i] += Math.abs(j - i);
        //     }
        // }
        // return ans;
        
        //2nd Solution
        int len = boxes.length();
        int[] forward = new int[len];
        int prev = (boxes.charAt(0)=='0'?0:1);
        for(int i=1;i<len;i++){
            forward[i] += forward[i-1]+prev;
            prev += (boxes.charAt(i)=='0'?0:1);
        }
        prev = (boxes.charAt(len-1)=='0'?0:1);
        int[] back = new int[len];
        for(int i=len-2;i>=0;i--){
            back[i] += back[i+1]+prev;
            prev += (boxes.charAt(i)=='0'?0:1);
        }
        int[] op = new int[len];
        for(int i=0;i<len;i++) op[i] = forward[i]+back[i];
        return op;
    }
}