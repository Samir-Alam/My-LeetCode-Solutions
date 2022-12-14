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
    public List<Double> averageOfLevels(TreeNode root) {
        // List<Double> ans = new ArrayList<>();
        // List<List<Integer>> t = levelOrder(root);
        // for(List<Integer> i : t){
        //     double sum = 0;
        //     for(int j : i)
        //         sum += j;
        //     sum /= i.size();
        //     ans.add(sum);
        // }
        // return ans;
        
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return result;
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            double sum = 0.0;
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            result.add(sum / n);
        }
        return result;
    }
    
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     Queue<TreeNode> queue = new LinkedList<TreeNode>();
    //     List<List<Integer>> ans = new LinkedList<List<Integer>>();
    //     if(root == null) return ans;
    //     queue.offer(root);
    //     while(!queue.isEmpty()){
    //         int levelNum = queue.size();
    //         List<Integer> subList = new LinkedList<Integer>();
    //         for(int i = 0; i < levelNum; i++) {
    //             if(queue.peek().left != null) queue.offer(queue.peek().left);
    //             if(queue.peek().right != null) queue.offer(queue.peek().right);
    //             subList.add(queue.poll().val);
    //         }
    //         ans.add(subList);
    //     }
    //     return ans;
    // }
}