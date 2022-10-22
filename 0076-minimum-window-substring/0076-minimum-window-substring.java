class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        if(s.length() < t.length())
            return result;
        int minWindow = Integer.MAX_VALUE;
        int need = t.length();
        int have = 0;
        Map<Character, Integer> sMap = new HashMap();
        Map<Character, Integer> tMap = new HashMap();
        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            tMap.put(ch, tMap.getOrDefault(ch,0)+1);
        }
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd<s.length(); windowEnd++){
            char ch = s.charAt(windowEnd);
            sMap.put(ch, sMap.getOrDefault(ch,0)+1);
            if(tMap.containsKey(ch) && sMap.get(ch)<=(tMap.get(ch)))
                have++;
            while(have==need){
                if(minWindow > windowEnd-windowStart+1){
                    minWindow = windowEnd-windowStart+1;
                    result = s.substring(windowStart, windowEnd+1);
                }
                char charToRemove = s.charAt(windowStart);
                if(sMap.get(charToRemove) == 1)
                    sMap.remove(charToRemove);
                else
                    sMap.put(charToRemove, sMap.get(charToRemove)-1);
                windowStart++;
                if(tMap.containsKey(charToRemove) && sMap.getOrDefault(charToRemove,0)<(tMap.get(charToRemove)))
                    have--;
            }
        }
        return result;
    }
}