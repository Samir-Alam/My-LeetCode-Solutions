class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        long min = time[0];
        for(int t : time)
            min = Math.min(min, t);
        long right = totalTrips * min;
        while(left < right){
            long mid = left + (right - left) / 2;
            long total = totalTripInGivenTime(time, mid);
            if(total < totalTrips)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    private long totalTripInGivenTime(int[] time, long givenTime){
        long totalTrips = 0l;
        for(int tripTime : time)
            totalTrips += ((long)givenTime) / tripTime;
        return totalTrips;
    }
}