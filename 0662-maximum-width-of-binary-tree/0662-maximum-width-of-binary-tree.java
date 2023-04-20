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
        if(root == null) return 0;
        int ans = 0;
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(root, 0));
        while(!q.isEmpty()){
          int size = q.size();
          int min = q.peek().num;
          int start = 0, end = 0;
          for(int i = 0; i<size; i++){
            int curNodeNum = q.peek().num-min;
            TreeNode node = q.peek().node;
            q.poll();
            if(i==0) start = curNodeNum;
            if(i == size-1) end = curNodeNum;
            if(node.left != null) q.offer(new pair(node.left, curNodeNum*2+1));
            if(node.right != null) q.offer(new pair(node.right, curNodeNum*2+2));
          }
          ans = Math.max(ans, end-start+1);
        }
        return ans;
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