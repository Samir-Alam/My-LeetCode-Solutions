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
    int sum;
    public void inorder(TreeNode root,String str){
        if(root!=null && root.left == null && root.right == null){
            str += Integer.toString(root.val);
            sum += Integer.parseInt(str);
            return;
        }
        else if(root != null){
            inorder(root.left, str + Integer.toString(root.val));
            inorder(root.right, str + Integer.toString(root.val));
        }
        
    }
    public int sumNumbers(TreeNode root) {
        sum = 0;
        inorder(root, "");
        return sum;
    }
}