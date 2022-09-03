class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        // List<Integer> cur = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // for (int i = 2; i <= n; ++i) {
        //     List<Integer> cur2 = new ArrayList<>();
        //     for (int x : cur) {
        //         int y = x % 10;
        //         if (y + k < 10)
        //             cur2.add(x * 10 + y + k);
        //         if (k > 0 && y - k >= 0)
        //             cur2.add(x * 10 + y - k);
        //     }
        //     cur = cur2;
        // }
        // return cur.stream().mapToInt(j->j).toArray();
        
        if (N == 1)
            return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> results = new ArrayList<Integer>();
        for (int num = 1; num < 10; ++num)
            this.DFS(N - 1, num, K, results);
        return results.stream().mapToInt(i->i).toArray();
    }

    protected void DFS(int N, int num, int K, List<Integer> results) {
        if (N == 0) {
            results.add(num);
            return;
        }
        List<Integer> nextDigits = new ArrayList<>();
        Integer tailDigit = num % 10;
        nextDigits.add(tailDigit + K);
        if (K != 0)
            nextDigits.add(tailDigit - K);
        for (Integer nextDigit : nextDigits) {
            if (0 <= nextDigit && nextDigit < 10) {
                Integer newNum = num * 10 + nextDigit;
                this.DFS(N - 1, newNum, K, results);
            }
        }
    }
}