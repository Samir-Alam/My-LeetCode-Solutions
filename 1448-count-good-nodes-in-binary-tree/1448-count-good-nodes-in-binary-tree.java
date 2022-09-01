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
class Node {
    TreeNode tn;
    int currentMax = Integer.MIN_VALUE;
    public Node(TreeNode n, int mx) {
        tn = n;
        currentMax = Math.max(mx, n.val);
    }
}
class Solution {
    public int goodNodes(TreeNode root) {
        // Deque<Node> stk = new ArrayDeque<>();
        // stk.push(new Node(root, root.val));
        // int cnt = 0;
        // while (!stk.isEmpty()) {
        //     Node cur = stk.pop();
        //     cnt += cur.tn.val >= cur.currentMax ? 1 : 0;
        //     for (TreeNode kid : new TreeNode[]{cur.tn.left, cur.tn.right}) {
        //         if (kid != null) {
        //             stk.push(new Node(kid, cur.currentMax));
        //         }
        //     }
        // }
        // return cnt;
        
        return preorder(root, root.val);
    }
    private int preorder(TreeNode n, int v) {
        if (n == null) // base cases.
            return 0;
        int max = Math.max(n.val, v); // maximum so far on the path.
        return (n.val >= v ? 1 : 0) + preorder(n.left, max) + preorder(n.right, max); // recurse to children.
    }
}