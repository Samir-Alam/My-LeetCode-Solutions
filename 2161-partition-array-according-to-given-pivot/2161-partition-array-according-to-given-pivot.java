class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> left = new ArrayList<>(), right = new ArrayList<>(), equal = new ArrayList<>(), ans = new ArrayList<>();
        for(int i : nums){
            if(i < pivot)
                left.add(i);
            if(i == pivot)
                equal.add(i);
            if(i > pivot)
                right.add(i);
        }
        for(int i : left)
            ans.add(i);
        for(int i : equal)
            ans.add(i);
        for(int i : right)
            ans.add(i);
        int res[] = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }
}