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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return false;
        return childrenAreSymmetric(root.left,root.right);
        
    }
    public boolean childrenAreSymmetric(TreeNode left,TreeNode right){
        if(left==null && right==null)
            return true;
        if(left==null || right==null || left.val!= right.val)
            return false;
        return childrenAreSymmetric(left.left,right.right) && childrenAreSymmetric(left.right,right.left);
    }
}