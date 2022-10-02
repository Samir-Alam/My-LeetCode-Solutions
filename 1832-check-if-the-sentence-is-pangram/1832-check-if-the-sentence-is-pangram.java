class Solution {
    public boolean checkIfPangram(String sentence) {
        int arr[] = new int[26];
        for(char c : sentence.toCharArray()){
            if(arr[c - 'a'] != 1)
                arr[c - 'a'] = 1;
        }
        return sum(arr) == 26;
    }
    public int sum(int arr[]){
        int sum = 0;
        for(int i : arr)
            sum += i;
        return sum;
    }
}