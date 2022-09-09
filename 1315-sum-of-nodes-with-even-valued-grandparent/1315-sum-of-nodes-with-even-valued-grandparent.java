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
    int res = 0;
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null)
            return 0;
        gc(root);
        return res;
    }
    public void gc(TreeNode root){
        if(root == null)
            return;
        if(root.val % 2 == 0 && root.left != null){
            res += root.left.left != null ? root.left.left.val : 0;
            res += root.left.right != null ? root.left.right.val : 0;
        }
        gc(root.left);
        if(root.val % 2 == 0 && root.right != null){
            res += root.right.left != null ? root.right.left.val : 0;
            res += root.right.right != null ? root.right.right.val : 0;
        }
        gc(root.right);
    } 
}