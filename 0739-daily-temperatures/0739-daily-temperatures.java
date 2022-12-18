class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Stack<Integer> stack = new Stack<>();
        // int[] ret = new int[temperatures.length];
        // for(int i = 0; i < temperatures.length; i++) {
        //     while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
        //         int idx = stack.pop();
        //         ret[idx] = i - idx;
        //     }
        //     stack.push(i);
        // }
        // return ret;
        
        
        //2nd solution
        int[] stack = new int[temperatures.length];
        int top = -1;
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(top > -1 && temperatures[i] > temperatures[stack[top]]) {
                int idx = stack[top--];
                ret[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return ret;
    }
}