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
    int count = 0;
    public int countNodes(TreeNode root) {
        // if(root == null)    return 0;
        // dfs(root);
        // return count;
        
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public void dfs(TreeNode root){
        if(root == null)    return;
        dfs(root.left);
        if(root != null)    count++;
        dfs(root.right);
    }
}