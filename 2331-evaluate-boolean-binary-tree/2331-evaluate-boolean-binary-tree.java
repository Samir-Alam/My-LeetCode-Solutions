class Solution {
    public boolean evaluateTree(TreeNode root) {
        // Handles the case for leaf nodes.
        if (root.left == null && root.right == null) {
            return root.val != 0;
        }

        // Store the evaluations for the left subtree and right subtree.
        boolean evaluateLeftSubtree = evaluateTree(root.left);
        boolean evaluateRightSubtree = evaluateTree(root.right);
        boolean evaluateRoot;
        if (root.val == 2) {
            evaluateRoot = evaluateLeftSubtree | evaluateRightSubtree;
        } else {
            evaluateRoot = evaluateLeftSubtree & evaluateRightSubtree;
        }

        return evaluateRoot;
    }
}