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
//     public int getMinimumDifference(TreeNode root) {
//         List<Integer> l = new ArrayList<>();
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             TreeNode temp = q.poll();
//             if(temp != null){
//                 l.add(temp.val);
//                 q.add(temp.left);
//                 q.add(temp.right);
//             }
//         }
//         Collections.sort(l);
//         int diff = l.get(l.size()-1);
//         for(int i = 1; i < l.size(); i++){
//             diff = Math.min(diff, l.get(i) - l.get(i-1));
//         }
//         return diff;
//     }
// }

class Solution {
    int minDifference = Integer.MAX_VALUE;
    // Initially, it will be null.
    TreeNode prevNode;

    void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        // Find the difference with the previous value if it is there.
        if (prevNode != null) {
            minDifference = Math.min(minDifference, node.val - prevNode.val);
        }
        prevNode = node;
        inorderTraversal(node.right);
    }

    int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return minDifference;
    }
}