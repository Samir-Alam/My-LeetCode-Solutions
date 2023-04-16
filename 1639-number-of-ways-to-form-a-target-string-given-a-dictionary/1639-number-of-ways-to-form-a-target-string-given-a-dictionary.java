class Solution {
    public int numWays(String[] words, String target) {
        int targetLength = target.length();
        int wordLength = words[0].length();
        long[][] numWays = new long[targetLength][wordLength];

        int[][] charCounts = new int[wordLength][26];

        for (String word : words) {
            for (int i = 0; i < wordLength; i++) {
                charCounts[i][word.charAt(i) - 'a']++;
            }
        }

        for (int i=0; i < targetLength; i++) {
            char c = target.charAt(i);
            int charsLeft = targetLength - i - 1;
            for (int j=i; j < wordLength - charsLeft; j++) {
                long numMatches = charCounts[j][c - 'a'];
                if (i > 0) {
                    numMatches = (numMatches * numWays[i - 1][j - 1]) % 1000000007;
                }
                if (j > i) {
                    numMatches = (numMatches + numWays[i][j - 1]) % 1000000007;
                }
                numWays[i][j] = numMatches % 1000000007;
            }
        }
        return (int) numWays[targetLength - 1][wordLength - 1];
    }
}