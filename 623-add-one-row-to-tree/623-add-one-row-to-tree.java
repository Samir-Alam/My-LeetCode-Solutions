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
    // public TreeNode addOneRow(TreeNode root, int val, int depth) {
    //     if(depth == 1){
    //         TreeNode newRoot = new TreeNode(val);
    //         newRoot.left = root;
    //         return newRoot;
    //     }
    //     dfs(root, val, depth);
    //     return root;
    // }
    // public void dfs(TreeNode root, int val, int depth){
    //     if(depth - 1 == 1){
    //         TreeNode left = new TreeNode(val), right = new TreeNode(val);
    //         left.left = root.left;
    //         right.right = root.right;
    //         root.left = left;
    //         root.right = right;
    //     }if(root.left != null)
    //         dfs(root.left, val, depth - 1);
    //     if(root.right != null)
    //         dfs(root.right, val,depth - 1);
    // }
    
    class Node{
        Node(TreeNode n,int d){
            node=n;
            depth=d;
        }
        TreeNode node;
        int depth;
    }
    public TreeNode addOneRow(TreeNode t, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = t;
            return n;
        } 
        Stack<Node> stack=new Stack<>();
        stack.push(new Node(t,1));
        while(!stack.isEmpty())
        {
            Node n=stack.pop();
            if(n.node==null)
                continue;
            if (n.depth == d - 1 ) {
                TreeNode temp = n.node.left;
                n.node.left = new TreeNode(v);
                n.node.left.left = temp;
                temp = n.node.right;
                n.node.right = new TreeNode(v);
                n.node.right.right = temp;
                
            } else{
                stack.push(new Node(n.node.left, n.depth + 1));
                stack.push(new Node(n.node.right, n.depth + 1));
            }
        }
        return t;
    }
}