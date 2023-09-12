class Solution {
    public int minDeletions(String s) {
        int[] lettersCount = new int[26];
        for (char letter : s.toCharArray())
            lettersCount[letter - 'a']++;
        int numberOfDeletions = 0;
        boolean[] usedFrequencies = new boolean[s.length() + 1];
        for (int frequency : lettersCount) {
            while (usedFrequencies[frequency]) {
                frequency--;
                numberOfDeletions++;
            }
            if (frequency > 0)
                usedFrequencies[frequency] = true;
        }
        return numberOfDeletions;
    }
}