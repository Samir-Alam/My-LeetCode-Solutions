class Solution {
    public List<Integer> findAnagrams(String s, String p) {
//         int[] charsInP = new int[26];
//         calculateFreq(p, charsInP);
//         int len1, len2;
//         len1 = s.length();
//         len2 = p.length();
//         List<Integer> res = new ArrayList<>();
//         for(int i = 0; i + len2 <= len1; i++){
//             String subs = s.substring(i, i + len2);
//             int[] charsInSubs = new int[26];
//             calculateFreq(subs, charsInSubs);
//             if(equalFreq(charsInP, charsInSubs)){
//                 res.add(i);
//             }
//         }
//         return res;
//     }
    
//     private void calculateFreq(String s, int[] chars){
//         for(char ch : s.toCharArray()){
//             chars[ch - 'a']++;
//         }
//     }
//     private boolean equalFreq(int[] chars1, int[] chars2){
//         for(int i = 0; i < 26; i++){
//             if(chars1[i] != chars2[i]){
//                 return false;
//             }
//         }
//         return true;
        
        List<Integer> ans = new ArrayList<>();
            int n = s.length();
            int m = p.length();
			if(m>n){
                return ans;
            }
			int []arrs = new int[26];
			int []arrp = new int[26];
			for(int i=0;i<m;i++){
				arrs[s.charAt(i)-'a']++;
				arrp[p.charAt(i)-'a']++;
			}
			for(int i=0;i<=n-m;i++){
				boolean flag = true;
				for(int j=0;j<26;j++){
					if(arrs[j]!=arrp[j]){
						flag = false;
						break;
					}
				}
				if(flag==true){
                    ans.add(i);
                }
				arrs[s.charAt(i)-'a']--;
				if(i+m < n){
                    arrs[s.charAt(i+m)-'a']++;
                }
			}
			return ans;
    }
}