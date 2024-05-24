class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int W = words.length;
        // Count how many times each letter occurs
        int[] freq = new int[26];
        for (char c: letters) {
            freq[c - 'a']++;
        }
        int maxScore = 0;
        // Iterate over every subset of words
        int[] subsetLetters = new int[26];
        for (int mask = 0; mask < 1 << W; mask++) {
            // Reset the subsetLetters array
            Arrays.fill(subsetLetters, 0);
            for (int i = 0; i < W; i++) {
                if ((mask & (1 << i)) > 0) {
                    // Count the letters in this word
                    int L = words[i].length();
                    for (int j = 0; j < L; j++) {
                        subsetLetters[words[i].charAt(j) - 'a']++;
                    }
                }
            }
            maxScore = Math.max(maxScore, subsetScore(subsetLetters, score, freq));
        }
        return maxScore;
    }

    private int subsetScore(int[] subsetLetters, int[] score, int[] freq) {
        int totalScore = 0;
        // Calculate score of subset
        for (int c = 0; c < 26; c++) {
            totalScore += subsetLetters[c] * score[c];
            // Check if we have enough of each letter to build this subset of words
            if (subsetLetters[c] > freq[c]) {
                return 0;
            }
        }
        return totalScore;
    }
}