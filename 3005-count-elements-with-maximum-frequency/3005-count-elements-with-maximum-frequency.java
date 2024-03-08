class Solution {
    public int maxFrequencyElements(int[] nums) {
        int arr[] = new int[100];
        int max = 0;
        for(int i : nums){
            arr[i-1]++;
            max = Math.max(max, arr[i-1]);
        }
        int count = 0;
        for(int i : arr){
            if(i == max)
                count += i;
        }
        return count;
    }
}