/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        // if(root == null) return 0;
        // int ans = 0;
        // Queue<pair> q = new LinkedList<>();
        // q.offer(new pair(root, 0));
        // while(!q.isEmpty()){
        //     int size = q.size();
        //     int min = q.peek().num;
        //     int start = 0, end = 0;
        //     for(int i = 0; i < size; i++){
        //         int curNodeNum = q.peek().num - min;
        //         TreeNode node = q.peek().node;
        //         q.poll();
        //         if(i == 0) start = curNodeNum;
        //         if(i == size - 1) end = curNodeNum;
        //         if(node.left != null) q.offer(new pair(node.left, curNodeNum * 2 + 1));
        //         if(node.right != null) q.offer(new pair(node.right, curNodeNum * 2 + 2));
        //     }
        //     ans = Math.max(ans, end-start+1);
        // }
        // return ans;
        if (root == null) return 0;
        
        Deque<TreeNode> bfsQueue = new LinkedList<>();
        
        root.val = 0;
        bfsQueue.addLast(root);
        
        int answer = 1;
        
        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            
            answer = Math.max(answer, bfsQueue.getLast().val - bfsQueue.getFirst().val + 1);
            while (size-- != 0) {
                TreeNode cur = bfsQueue.removeFirst();
                
                if (cur.left != null) {
                    cur.left.val = 2 * cur.val;
                    bfsQueue.addLast(cur.left);
                }
                
                if (cur.right != null) {
                    cur.right.val = 2 * cur.val + 1;
                    bfsQueue.addLast(cur.right);
                }
            }
        }
        
        return answer;
    }
}
class pair{
  TreeNode node;
  int num;
  pair(TreeNode _node, int _num){
    node = _node;
    num = _num;
  }
}