class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);
        int n = salary.length;
        double sum = 0;
        for(int i = 1; i < salary.length-1; i++){
            sum += (double)salary[i];
        }
        double avg = sum/(n-2);
        return avg;
    }
}