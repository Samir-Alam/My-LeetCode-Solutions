class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for(int i : candyType)
            set.add(i);
        return Math.min(candyType.length/2, set.size());
    }
}