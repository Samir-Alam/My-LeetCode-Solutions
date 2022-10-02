class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int r = image.length, c = image[0].length;
        int ans[][] = new int[r][c];
        for(int i = 0; i < r; i++)
            ans[i] = reverse(image[i]);
        return ans;
    }
    public int[] reverse(int a[]){
        int ans[] = new int[a.length];
        int n = a.length;
        for(int i = 0; i < n; i++)
            ans[i] = a[n - 1 - i] == 0 ? 1 : 0;
        return ans;
    }
}