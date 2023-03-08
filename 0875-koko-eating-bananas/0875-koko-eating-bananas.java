class Solution {
    public boolean ispos(int[] piles, int h,int k){
        int time=0;
        for(int i=0;i<piles.length;i++){
            time+=piles[i]/k;
            if(piles[i]%k>0)
                time+=1;
            if(time > h)
                return false;
        }
        if(h < time)return false;
        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxi = -1;
        for(int i:piles){
            maxi = Math.max(i,maxi);
        }
        int l=1,r = maxi,mid;
        int k = -1;
        while(l <= r){
            mid = l + (r-l)/2;
            if(ispos(piles,h,mid)){
                k=mid;
                r = mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return k;
    }
}