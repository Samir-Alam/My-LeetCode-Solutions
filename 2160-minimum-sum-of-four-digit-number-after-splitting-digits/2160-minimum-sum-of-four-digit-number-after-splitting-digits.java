class Solution {
    public int minimumSum(int num) {
        List<Integer> arr = new ArrayList<>();
        while(num != 0){
            int rem = num % 10;
            arr.add(rem);
            num /= 10;
        }
        Collections.sort(arr);
        arr.removeAll(Collections.singleton(0));
        int n = 0;
        
        if(arr.size() == 1)
            n = arr.get(0);
        else if(arr.size() == 2)
            n = arr.get(0) + arr.get(1);
        else if(arr.size() == 3)
            n = arr.get(0)*10 + arr.get(1) + arr.get(2);
        else if(arr.size() == 4)
            n = arr.get(0)*10 + arr.get(3) + arr.get(1)*10 + arr.get(2);
        return n;
    }
}