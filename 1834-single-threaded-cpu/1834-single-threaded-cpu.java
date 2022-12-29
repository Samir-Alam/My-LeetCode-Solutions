// class Solution {
//     public int[] getOrder(int[][] tasks) {
        
//         // Sort based on min task processing time or min task index.
//         // Store enqueue time, processing time, task index.
//         PriorityQueue<int[]> nextTask = new PriorityQueue<int[]>((a, b) -> (a[1] != b[1] ? (a[1] - b[1]) : (a[2] - b[2])));
        
//         // Store task enqueue time, processing time, index.
//         int sortedTasks[][] = new int[tasks.length][3];
//         for (int i = 0; i < tasks.length; ++i) {
//             sortedTasks[i][0] = tasks[i][0];
//             sortedTasks[i][1] = tasks[i][1];
//             sortedTasks[i][2] = i;
//         }
        
//         Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a[0], b[0]));
//         int tasksProcessingOrder[] = new int[tasks.length];
        
//         long currTime = 0;
//         int taskIndex = 0;
//         int ansIndex = 0;
        
//         // Stop when no tasks are left in array and heap.
//         while (taskIndex < tasks.length || !nextTask.isEmpty()) {
//             if (nextTask.isEmpty() && currTime < sortedTasks[taskIndex][0]) {
//                 // When the heap is empty, try updating currTime to next task's enqueue time. 
//                 currTime = sortedTasks[taskIndex][0];
//             }
//             while (taskIndex < tasks.length && currTime >= sortedTasks[taskIndex][0]) { 
//                 nextTask.add(sortedTasks[taskIndex]);
//                 ++taskIndex;
//             }
            
//             int processTime = nextTask.peek()[1];
//             int index = nextTask.peek()[2];
//             nextTask.remove();
            
//             // Complete this task and increment currTime.
//             currTime += processTime; 
//             tasksProcessingOrder[ansIndex++] = index;
//         }
        
//         return tasksProcessingOrder;
//     }
// }

class Solution {
    private final static int ENQUEUE_TIME = 0;
    private final static int PROCESSING_TIME = 1;
    private final static int INDEX = 2;
    
    public int[] getOrder(int[][] tasks) {
        for(int i = 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            tasks[i] = new int[]{task[ENQUEUE_TIME], task[PROCESSING_TIME], i};
        }
        
        Arrays.sort(tasks, (task1, task2) -> {
           return Integer.compare(task1[ENQUEUE_TIME], task2[ENQUEUE_TIME]); 
        });
        
        Queue<int[]> pq = new PriorityQueue<>((task1, task2) -> {
           if(task1[PROCESSING_TIME] == task2[PROCESSING_TIME])
               return Integer.compare(task1[INDEX], task2[INDEX]);
            
           return Integer.compare(task1[PROCESSING_TIME], task2[PROCESSING_TIME]); 
        });
        
        int currentTime = 0;
        int enqueueIndex = 0;
        int[] processingOrder = new int[tasks.length];
        int processedIndex = 0;
        while(!pq.isEmpty() || enqueueIndex < tasks.length) {
            if(pq.isEmpty()) {
                currentTime = Math.max(currentTime, tasks[enqueueIndex][ENQUEUE_TIME]);
            }
            
            while(enqueueIndex < tasks.length && tasks[enqueueIndex][ENQUEUE_TIME] <= currentTime) {
                pq.offer(tasks[enqueueIndex]);
                enqueueIndex++;
            }
            
            int[] task = pq.poll();
            currentTime += task[PROCESSING_TIME];
            processingOrder[processedIndex++] = task[INDEX];
        }
        
        return processingOrder;
    }
}