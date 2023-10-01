// class Solution {
//     public String reverseWords(String s) {
//         String str[] = s.split(" ");
//         String ans = "";
//         for(String ss : str){
//             ans += reverse(ss) + " ";
//         }
//         return ans.trim();
//     }
//     public String reverse(String s){
//         StringBuilder sb = new StringBuilder();
//         sb.append(s);
//         sb.reverse();
//         return sb.toString();
//     }
// }
class Solution {

    public String reverseWords(String s) {
        int lastSpaceIndex = -1;
        char[] chArray = s.toCharArray();
        int len = s.length();
        for (int strIndex = 0; strIndex <= len; strIndex++) {
            if (strIndex == len || chArray[strIndex] == ' ') {
                int startIndex = lastSpaceIndex + 1;
                int endIndex = strIndex - 1;
                while (startIndex < endIndex) {
                    char temp = chArray[startIndex];
                    chArray[startIndex] = chArray[endIndex];
                    chArray[endIndex] = temp;
                    startIndex++;
                    endIndex--;
                }
                lastSpaceIndex = strIndex;
            }
        }
        return new String(chArray);
    }

}