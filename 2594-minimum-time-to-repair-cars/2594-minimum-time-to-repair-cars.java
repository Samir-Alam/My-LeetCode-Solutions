class Solution {
    public long repairCars(int[] ranks, int cars) {
        long minTime = Integer.MAX_VALUE;
        long maxTime = 0;
        for(int i = 0; i < ranks.length; i++)
            minTime = Math.min(minTime, ranks[i]);
        maxTime = minTime * cars * cars;
        long low = minTime;
        long high = maxTime;
        long minTimeTaken = minTime;
        while(low <= high){
            long curTime = low + (high - low) / 2;
            long carsRepaired = 0;
            for(int i = 0; i < ranks.length; i++)
                carsRepaired += (int)Math.sqrt(curTime / ranks[i]);
            if(carsRepaired < cars)
            low = curTime + 1;
            else{
                minTimeTaken = curTime;
                high = curTime - 1;
            }
        }
        return minTimeTaken;
    }
}