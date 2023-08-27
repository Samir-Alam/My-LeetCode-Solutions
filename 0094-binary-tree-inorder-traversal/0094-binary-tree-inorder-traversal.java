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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        // RECURSIVE SOLUTION
    //     List<Integer> l = new ArrayList<>();
    //     helper(root, l);
    //     return l;
    // }
    // public void helper(TreeNode root, List<Integer> l){
    //     if(root == null)
    //         return;
    //     helper(root.left, l);
    //     l.add(root.val);
    //     helper(root.right, l);
        
        // ITERATIVE SOLUTION USING STACK (DFS)
        
        List<Integer> l = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !s.isEmpty()){
            while(curr != null){
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            l.add(curr.val);
            curr = curr.right;
        }
        return l;
    }
}