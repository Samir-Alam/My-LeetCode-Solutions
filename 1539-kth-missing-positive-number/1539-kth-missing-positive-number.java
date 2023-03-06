class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr[arr.length-1];
        List<Integer> ans = new ArrayList<>();
        int j = 0;
        
        for(int i = 1; i <= n; i++){
            if(arr[j] == i)
                j++;
            else
                ans.add(i);
        }
        if(ans.size() >= k)
            return ans.get(k-1);
        else
            return arr[arr.length-1]+(k-ans.size());
    }
}