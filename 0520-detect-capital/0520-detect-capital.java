class Solution {
    public boolean detectCapitalUse(String word) {
        int capital = 0, small = 0;
        for(char c : word.toCharArray()){
            if(Character.isUpperCase(c))
                capital++;
            else
                small++;
        }
        if(capital == 0 || small == 0)
            return true;
        else if(capital == 1)
           return Character.isUpperCase(word.charAt(0));
        return false;
    }
}