class Solution {
    public boolean wordPattern(String pattern, String s) {
        // String[] words = s.split(" ");
        // if (words.length != pattern.length())
        //     return false;
        // Map index = new HashMap();
        // for (Integer i = 0; i < words.length; ++i)
        //     if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
        //         return false;
        // return true;
        
        String[] arr= s.split(" ");
        HashMap<Character, String> map = new HashMap<Character, String>();
        if(arr.length!= pattern.length())
            return false;
        for(int i=0; i<arr.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i]))
                    return false;
            }else{
                if(map.containsValue(arr[i]))
                    return false;
                map.put(c, arr[i]);
            }    
        }
        return true;
    }
}