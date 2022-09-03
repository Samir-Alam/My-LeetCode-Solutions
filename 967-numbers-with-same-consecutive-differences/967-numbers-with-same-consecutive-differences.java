class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> cur = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 2; i <= n; ++i) {
            List<Integer> cur2 = new ArrayList<>();
            for (int x : cur) {
                int y = x % 10;
                if (y + k < 10)
                    cur2.add(x * 10 + y + k);
                if (k > 0 && y - k >= 0)
                    cur2.add(x * 10 + y - k);
            }
            cur = cur2;
        }
        return cur.stream().mapToInt(j->j).toArray();
    }
}