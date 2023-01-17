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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);
        return buildTree(values, 0, values.size() - 1);
    }

    private void inorderTraversal(TreeNode root, ArrayList<Integer> values) {
        if (root == null) return;
        inorderTraversal(root.left, values);
        values.add(root.val);
        inorderTraversal(root.right, values);
    }

    private TreeNode buildTree(ArrayList<Integer> values, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(values.get(mid));
        root.left = buildTree(values, start, mid - 1);
        root.right = buildTree(values, mid + 1, end);
        return root;
    }
}