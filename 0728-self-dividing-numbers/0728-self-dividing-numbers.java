class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> l = new ArrayList<>();
        for(int i = left; i <= right; i++){
            if(check(i))
                l.add(i);
        }
        return l;
    }
    public boolean check(int n){
        int temp = n;
        while(temp > 0){
            int rem = temp % 10;
            temp /= 10;
            if(rem == 0 || n % rem != 0) return false;
        }
        return true;
    }
}