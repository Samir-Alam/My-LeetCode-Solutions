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
    public int longestZigZag(TreeNode root) {
        Stack<Node> stack = new Stack<>();
        stack.add(new Node(root));
        int max = 0;
        while(!stack.isEmpty()){
            Node node = stack.pop();

            if(node.node.left != null){
                Node leftNode = new Node(node.node.left);
                leftNode.rightLen = node.leftLen + 1;
                max = Math.max(max,leftNode.rightLen);
                stack.push(leftNode);
            }

            if(node.node.right != null){
                Node rightNode = new Node(node.node.right);
                rightNode.leftLen = node.rightLen + 1;
                max = Math.max(max,rightNode.leftLen);
                stack.push(rightNode);
            }
        }

        return max;

    }
}

class Node{
    int leftLen;
    int rightLen;
    TreeNode node;
    Node(TreeNode node){this.node = node;
    }
}