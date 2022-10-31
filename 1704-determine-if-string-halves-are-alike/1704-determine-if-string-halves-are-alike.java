class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length(), va = 0, vb = 0;
        String a = s.substring(0, n/2), b = s.substring(n/2, n);
        List<Character> vowel = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        for(int i = 0; i < n/2; i++){
            if(vowel.contains(a.charAt(i)))
                va++;
            if(vowel.contains(b.charAt(i)))
                vb++;
        }
        return va == vb;
    }
}