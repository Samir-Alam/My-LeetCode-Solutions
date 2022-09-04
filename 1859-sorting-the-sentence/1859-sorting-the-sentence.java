class Solution {
    public String sortSentence(String s) {
        // String str[] = s.split(" "), temp[] = new String[str.length];
        // int n = str.length;
        // StringBuilder sb = new StringBuilder();
        // for(String s1 : str)
        //     temp[s1.charAt(s1.length() - 1) - '1'] = s1.substring(0, s1.length() - 1);
        // for(int i = 0; i < n - 1; i++)
        //     sb.append(temp[i]).append(" ");
        // sb.append(temp[n - 1]);
        // return sb.toString();
        String[] str = s.split(" ");                // Since the String contains only whitespaces, it's safe to split the String at them
	String[] res = new String[str.length];      // This String array will hold the rearranged words
	StringBuilder sb = new StringBuilder();     // Instead of using '+' operator to concat repeatedly, I have created a StringBuilder object which is more efficient
	int i = 0;                          
	for (String elem : str) {
		i = (int) (elem.charAt(elem.length() - 1) - '0');  // This  will extract the digit present at the end of each String and store it in i (i = index of the word in res[])
		res[i - 1] = elem.substring(0, elem.length() - 1); // This gives the substring of each String except for the digit in the end and stores the word at an appropriate index (i - 1) in res[]
	}
	//append the words from res[] to StringBuilder object to form a sentence
	for (i = 0; i < res.length - 1; i++)
		sb.append(res[i]).append(" ");
	sb.append(res[i]);
	return sb.toString();
    }
}