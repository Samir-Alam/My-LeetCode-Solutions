class Solution {
    public int minimizeArrayValue(int[] nums) {
     int start=0,end=Integer.MAX_VALUE,ans=0;
       while(start<=end){
           int mid=start+(end-start)/2;
           if(checkPossible(mid,nums)){
               ans=mid;
               end=mid-1;
           }else{
               start=mid+1;
           }
       }
        return ans;
    }

    private boolean checkPossible(int mid,int[] nums){
        long diff=0;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>mid){
                diff+=nums[i]-mid;
            }else{
               diff= Math.max(diff+nums[i]-mid,0);
            }
        }
        if(diff==0) return true;
        return false;   
    }
}