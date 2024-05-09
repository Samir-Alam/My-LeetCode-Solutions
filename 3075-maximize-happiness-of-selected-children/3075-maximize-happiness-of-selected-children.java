class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int happinessSize = happiness.length;
        
        // Convert the array to an Integer array for sorting in descending order
        Integer[] happinessArray = new Integer[happinessSize];
        for(int i = 0; i < happinessSize; i++) {
            happinessArray[i] = happiness[i];
        }
        
        Arrays.sort(happinessArray, Collections.reverseOrder());

        long totalHappinessSum = 0;
        int turns = 0;
        
        // Calculate the maximum happiness sum
        for(int i = 0; i < k; i++) {
            // Adjust happiness and ensure it's not negative
            totalHappinessSum += Math.max(happinessArray[i] - turns, 0);  

             // Increment turns for the next iteration
            turns++; 
        }
        
        return totalHappinessSum;
    }
}