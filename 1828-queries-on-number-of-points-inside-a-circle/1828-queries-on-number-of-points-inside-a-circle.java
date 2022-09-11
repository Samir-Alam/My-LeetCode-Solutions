class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int len = queries.length;
        int[] res = new int[len];
        
        for (int i = 0; i < len; i++) {
            int[] query = queries[i];
            int count = 0;
            
            for (int[] point : points) {
                int x = point[0] - query[0];
                int y = point[1] - query[1];
                
                if (x*x + y*y <= query[2]*query[2])
                    count++;
            }
            
            res[i] = count;
        }
        
        return res;
    }
}