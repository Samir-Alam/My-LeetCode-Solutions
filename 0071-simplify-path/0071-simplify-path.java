class Solution {
    public String simplifyPath(String path) {
        String[] str = path.split("/");
        Stack<String> stack = new Stack<String>();

        for(String s : str){
            if(s.equals("")  || s.equals(".")) continue;
            else if(s.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.push(s);
        }
        return "/" + String.join("/", stack);
    }
}