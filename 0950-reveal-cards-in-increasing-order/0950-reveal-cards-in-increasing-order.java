class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        int[] result = new int[N];
        boolean skip = false;
        int indexInDeck = 0;
        int indexInResult = 0;

        Arrays.sort(deck);

        while (indexInDeck < N) {
            if (result[indexInResult] == 0) {
                if (!skip) {
                    result[indexInResult] = deck[indexInDeck];
                    indexInDeck++;
                }
                skip = !skip;
            }
            indexInResult = (indexInResult + 1) % N;
        }
        return result;
    }
}