class Solution {
    public int[] divisibilityArray(String word, int m) {
        int l=word.length();
         long digi=0;
        int ans[]=new int[l];
        int j=0;
        for(int i=0;i<l;i++){
            int cur=word.charAt(i)-'0';
            digi=(digi*10+cur)%m;
            if(digi==0){
                ans[j++]=1;
            }else{
                ans[j++]=0;
            }
        }
        return ans;
    }
}