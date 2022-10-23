class Solution {
    public int[] findErrorNums(int[] nums) {
        int a[] = new int[2], n = nums.length;
        int temp[] = new int[n + 1];
        for(int i : nums)
            temp[i]++;
        for(int i = 1; i < n + 1; i++){
            if(temp[i] == 2)
                a[0] = i;
            if(temp[i] == 0)
                a[1] = i;
            if(a[1] != 0 && a[0] != 0)
                break;
        }
        return a;
    }
}