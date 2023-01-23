class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0 && n == 1) 
            return 1;
        int[] count = new int[n + 1];
        for (int[] person : trust){
            count[person[0]]--;
            count[person[1]]++;
        }
        for (int person = 0; person < count.length; person++)
            if (count[person] == n - 1) return person;
        return -1;
    }
}