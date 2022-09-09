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
    // int res = 0;
    // public int sumEvenGrandparent(TreeNode root) {
    //     if(root == null)
    //         return 0;
    //     gc(root);
    //     return res;
    // }
    // public void gc(TreeNode root){
    //     if(root == null)
    //         return;
    //     if(root.val % 2 == 0 && root.left != null){
    //         res += root.left.left != null ? root.left.left.val : 0;
    //         res += root.left.right != null ? root.left.right.val : 0;
    //     }
    //     gc(root.left);
    //     if(root.val % 2 == 0 && root.right != null){
    //         res += root.right.left != null ? root.right.left.val : 0;
    //         res += root.right.right != null ? root.right.right.val : 0;
    //     }
    //     gc(root.right);
    // } 
    
    //2nd Solution
    public int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, null, null);
        return sum;
    }

    void dfs(TreeNode current, TreeNode parent, TreeNode grandParent) {
        if (current == null) return; // base case 
        if (grandParent != null && grandParent.val % 2 == 0) {
            sum += current.val;
        }
        dfs(current.left, current, parent);// ( newChild, parent, GrandParent)
        dfs(current.right, current, parent);
    }
}