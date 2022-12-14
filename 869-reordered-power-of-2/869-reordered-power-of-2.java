class Solution {
    public boolean reorderedPowerOf2(int n) {
        //1st Solution
        // char[] res1 = String.valueOf(n).toCharArray();
        // Arrays.sort(res1);
        // for (int i = 0; i < 30; i++) {
        //     char[] res2 = String.valueOf(1 << i).toCharArray();
        //     Arrays.sort(res2);
        //     if (Arrays.equals(res1, res2)) return true;
        // }
        // return false;
        
        //2nd Solution
    //     long c = counter(n);
    //     for (int i = 0; i < 32; i++)
    //         if (counter(1 << i) == c) return true;
    //     return false;
    // }
    // public long counter(int N) {
    //     long res = 0;
    //     for (; N > 0; N /= 10) res += (int)Math.pow(10, N % 10);
    //     return res;
        
        int[] A = count(n);
        for (int i = 0; i < 31; ++i)
            if (Arrays.equals(A, count(1 << i)))
                return true;
        return false;
    }
    public int[] count(int N) {
        int[] ans = new int[10];
        while (N > 0) {
            ans[N % 10]++;
            N /= 10;
        }
        return ans;
    }
}