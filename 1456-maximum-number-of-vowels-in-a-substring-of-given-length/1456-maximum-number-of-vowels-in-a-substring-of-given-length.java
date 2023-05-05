class Solution {
    public int maxVowels(String s, int k) {
        int vowel = 0;
        List<Character> v = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for(int i = 0; i < k; i++)
            if(v.contains(s.charAt(i)))
                vowel++;
        int i = k;
        int max = vowel;
        while(i < s.length()){
            if(v.contains(s.charAt(i-k)))
                vowel--;
            if(v.contains(s.charAt(i)))
                vowel++;
            i++;
            max = Math.max(max, vowel);
        }
        return max;
    }
}