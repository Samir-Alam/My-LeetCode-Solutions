class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // Base case
        if (root == null) {
            return null;
        }

        // 1. Visit the left children
        root.left = removeLeafNodes(root.left, target);

        // 2. Visit the right children
        root.right = removeLeafNodes(root.right, target);

        // 3. Check if the current node is a leaf node and its value equals target
        if (root.left == null && root.right == null && root.val == target) {
            // Delete the node by returning null to the parent, effectively disconnecting it
            return null;
        }

        // Keep it untouched otherwise
        return root;
    }
}