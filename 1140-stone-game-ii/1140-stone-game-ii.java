class Solution {
    Integer[][] cache;
    public int stoneGameII(int[] piles) {
        cache = new Integer[piles.length][piles.length * 2];
        int totalStones = 0;
        for(int stones : piles) totalStones += stones;
        return (totalStones + getAliceScore(piles, 0, 1)) / 2;
    }
    private int getAliceScore(int[] piles, int index, int M){
        if(index == piles.length) return 0;
        if(cache[index][M] != null) return cache[index][M];
        int maxScore = Integer.MIN_VALUE;
        int stone = 0;
        for(int x = 0; x < 2 * M; x++){
            int i = index + x;
            if(i >= piles.length) continue;
            stone += piles[i];
            int score = stone - getAliceScore(piles, i + 1, Math.max(x + 1, M));
            maxScore = Math.max(maxScore, score);
        }
        return cache[index][M] = maxScore;
    }
}