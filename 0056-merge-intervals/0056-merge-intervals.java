class Solution {
    public int[][] merge(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> ans = new ArrayList<>();
        
        // 1st
        // for(int i = 0; i < n; i++){
        //     int start = arr[i][0];
        //     int end = arr[i][1];
        //     if(!ans.isEmpty() && ans.get(ans.size()-1).get(1) >= end)
        //         continue;
        //     for(int j = i+1; j < n; j++){
        //         if(arr[j][0] <= end)
        //             end = Math.max(end, arr[j][1]);
        //         else
        //             break;
        //     }
        //     ans.add(Arrays.asList(start, end));
        // }
        
        //2nd
        for(int i = 0; i < n; i++){
            if(ans.isEmpty() || arr[i][0] > ans.get(ans.size()-1).get(1))
                ans.add(Arrays.asList(arr[i][0] , arr[i][1]));
            else{
                int temp = Math.max(ans.get(ans.size()-1).get(1), arr[i][1]);   
                ans.get(ans.size()-1).set(1, temp);
            }
        }
        
        int[][] res = new int[ans.size()][2];
        for(int i = 0; i < ans.size(); i++){
            res[i][0] = ans.get(i).get(0);
            res[i][1] = ans.get(i).get(1);
        }
        // int[][] res = ans.stream().map(a -> a.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new);
        return res;
    }
}