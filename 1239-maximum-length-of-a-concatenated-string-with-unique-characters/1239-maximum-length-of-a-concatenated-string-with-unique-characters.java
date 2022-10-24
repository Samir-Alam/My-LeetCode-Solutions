class Solution {
    // public int maxLength(List<String> arr) {
    //     List<Integer> dp = new ArrayList<>();
    //     dp.add(0);
    //     int res = 0;
    //     for (String s : arr) {
    //         int a = 0, dup = 0;
    //         for (char c : s.toCharArray()) {
    //             dup |= a & (1 << (c - 'a'));
    //             a |= 1 << (c - 'a');
    //         }
    //         if (dup > 0) continue;
    //         for (int i = dp.size() - 1; i >= 0; --i) {
    //             if ((dp.get(i) & a) > 0) continue;
    //             dp.add(dp.get(i) | a);
    //             res = Math.max(res, Integer.bitCount(dp.get(i) | a));
    //         }
    //     }
    //     return res;
    
    int max =0;
    public int maxLength(List<String> arr) {
        backTrack(arr,"",0);
        return max;
    }
    
    private void backTrack(List<String> arr, String current, int start){
        if(max<current.length())
            max =current.length();
        for(int i=start; i<arr.size();i++){
            if(!isValid(current,arr.get(i))) continue;
            backTrack(arr,current+arr.get(i),i+1);
        }
    }
    
    private boolean isValid(String currentString, String newString){
        int[] array = new int[26];
        for(int i=0;i<newString.length();i++){
            if(++array[newString.charAt(i)-'a'] == 2) return false;  //to handle if the newString has duplicates then it's not valid
            if(currentString.contains(newString.charAt(i)+"")) // check if the currentString contains each char from newString
                return false;
        }
        return true;
    }
}