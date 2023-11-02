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
// class Solution {
//     int count = 0;
    
//     Pair<Integer, Integer> postOrder(TreeNode root) {
//         if (root == null)
//             return new Pair(0, 0);
//         Pair<Integer, Integer> left = postOrder(root.left);
//         Pair<Integer, Integer> right = postOrder(root.right);
//         int nodeSum = left.getKey() + right.getKey() + root.val;
//         int nodeCount = left.getValue() + right.getValue() + 1;
//         if (root.val == nodeSum / (nodeCount))
//             count++;
//         // Return the sum of nodes and the count in the subtree.
//         return new Pair(nodeSum, nodeCount);
//     }
    
//     public int averageOfSubtree(TreeNode root) {
//         postOrder(root);
//         return count;
//     }
// }

class Solution {
    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }
    
    private int[] dfs(TreeNode node) {
        if(node == null) {
            return new int[] {0,0};
        }
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        
        int currSum = left[0] + right[0] + node.val;
        int currCount = left[1] + right[1] + 1;
        
        if(currSum / currCount == node.val) {
            res++;
        }
            
        return new int[] {currSum, currCount};
    }
}