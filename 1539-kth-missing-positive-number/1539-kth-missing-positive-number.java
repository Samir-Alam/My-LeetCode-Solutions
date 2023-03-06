class Solution {
    public int findKthPositive(int[] arr, int k) {
//         int n = arr[arr.length-1];
//         List<Integer> ans = new ArrayList<>();
//         int j = 0;
        
//         for(int i = 1; i <= n; i++){
//             if(arr[j] == i)
//                 j++;
//             else
//                 ans.add(i);
//         }
//         if(ans.size() >= k)
//             return ans.get(k-1);
//         else
//             return arr[arr.length-1]+(k-ans.size());
        
        //2nd 
        int j = 0,count = 0,i = 0,num = 0;
        while(count < k){
            if(j < arr.length && arr[j] == i+1){
                j++;
            }else{
                count++;
                num = i+1;
            }
            i++;
        }
        return num;
    }
}