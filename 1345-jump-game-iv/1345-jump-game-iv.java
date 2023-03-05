class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer,HashSet<Integer>> hsmap = new HashMap<>();
        boolean[] visited = new boolean[arr.length];
        for(int i = 0; i < arr.length; i++){
            hsmap.computeIfAbsent(arr[i], k -> new HashSet<Integer>());
            hsmap.get(arr[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int minSteps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int curIdx = q.poll();
                if(curIdx == arr.length - 1) return minSteps; 
                if(curIdx > 0 && !visited[curIdx-1]) {
                    q.offer(curIdx-1);
                    visited[curIdx-1] = true;
                }
                if(!visited[curIdx + 1]){
                    q.offer(curIdx + 1);
                    visited[curIdx + 1] = true;
                }
                if(hsmap.containsKey(arr[curIdx])){
                    HashSet<Integer> hset = hsmap.get(arr[curIdx]);
                    for(int idx : hset){
                        if(!visited[idx]){
                            visited[idx] = true;
                            q.offer(idx);
                        }
                    }
                    hsmap.remove(arr[curIdx]); //remove this value from map because we already added the indexes matching this value in the queue. So we dont need to visit them again
                }
            }
            minSteps++;
        }
        return 0;
    }
}