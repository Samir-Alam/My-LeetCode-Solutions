class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        // int N = A.length;
        // List<Integer> LA = new ArrayList<>(),  LB = new ArrayList<>();
        // HashMap<Integer, Integer> count = new HashMap<>();
        // for (int i = 0; i < N * N; ++i)
        //     if (A[i / N][i % N] == 1)
        //         LA.add(i / N * 100 + i % N);
        // for (int i = 0; i < N * N; ++i)
        //     if (B[i / N][i % N] == 1)
        //         LB.add(i / N * 100 + i % N);
        // for (int i : LA)
        //     for (int j : LB)
        //         count.put(i - j, count.getOrDefault(i - j, 0) + 1);
        // int res = 0;
        // for (int i : count.values())
        //     res = Math.max(res, i);
        // return res;

        //2nd Solution
        
        int n = img1.length;
        int max = Integer.MIN_VALUE;	
		//Slide one image on other image.
        for(int r = 0; r < 2 * n - 1; r++){
            int i = n - 1 + Math.min(0, n - 1 - r);
            int x = r + Math.min(0, n - 1 - r);
            for(int c = 0; c < 2 * n - 1;  c++){
                int j = n - 1 + Math.min(0 ,  n - 1 - c);
                int y = c + Math.min(0, n - 1 - c);
                max = Math.max(max, overlap(img1, img2, i, j, x, y));
            }
        }
        return max;
    }
	//Compares two matrices from give coordinates to LEFT-TOP
    int overlap(int[][] img1, int[][] img2, int i1,int j1, int i2, int j2){
        int count = 0;
        for(int i = i1, x = i2; i >= 0 && x >= 0; i--, x--)
            for(int j = j1, y = j2; j >= 0 && y >= 0; j--, y--)
                if(img1[i][j] == img2[x][y] && img1[i][j] == 1)
                    count++;
        return count;
    }
}