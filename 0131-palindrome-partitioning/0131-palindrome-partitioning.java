class Solution {
    List<List<String>> ans=new ArrayList<>();  
     boolean ispalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<String> al=new ArrayList<String>();
        helper(0,s,al);
        return ans;
    }
    void helper(int index,String s,List<String> al){
        if(index==s.length()){
                ans.add(new ArrayList<>(al));
            }
        for(int i=index;i<s.length();i++){
            String temp=s.substring(index,i+1);
            if(ispalindrome(temp)){
            al.add(temp);
            helper(i+1,s,al);
            al.remove(al.size()-1);

            }
        }
    }
}