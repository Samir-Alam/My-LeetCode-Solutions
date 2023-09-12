class Solution {
    public int minDeletions(String s) {
        // int[] lettersCount = new int[26];
        // for (char letter : s.toCharArray())
        //     lettersCount[letter - 'a']++;
        // int numberOfDeletions = 0;
        // boolean[] usedFrequencies = new boolean[s.length() + 1];
        // for (int frequency : lettersCount) {
        //     while (usedFrequencies[frequency]) {
        //         frequency--;
        //         numberOfDeletions++;
        //     }
        //     if (frequency > 0)
        //         usedFrequencies[frequency] = true;
        // }
        // return numberOfDeletions;
        
        int freq[] = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        Arrays.sort(freq);
        int keep = freq[25], prev = keep;
        for (int i = 24; i >= 0 && freq[i] != 0 && prev != 0; i--) {
            prev = Math.min(freq[i], prev - 1);
            keep += prev;
        }
        return s.length() - keep;
    }
}