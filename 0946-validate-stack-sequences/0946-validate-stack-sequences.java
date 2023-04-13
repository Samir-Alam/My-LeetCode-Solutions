class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s=new Stack<>();
        int index=0;
        for(int i=0;i<pushed.length;i++){
            if(s.isEmpty()){
                s.push(pushed[i]);
            }else{
                while(!s.isEmpty() && index<popped.length){
                    if(s.peek()==popped[index]){
                        s.pop();
                        index++;
                    }else{
                        break;
                    }
                }
                s.push(pushed[i]);
            }
        }
        if(s.isEmpty() && index==popped.length-1) return true;
        while(!s.isEmpty() && index<popped.length){
            if(s.peek()==popped[index]){
                s.pop();
                index++;
            }else{
                return false;
            }
        }
        return true;
    }
}