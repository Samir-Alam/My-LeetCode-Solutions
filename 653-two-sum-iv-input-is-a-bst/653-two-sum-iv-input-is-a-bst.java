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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> a = new ArrayList<>();
        bfs(root, a);
        Collections.sort(a);
        int i = 0, j = a.size() - 1;
        while(i < j){
            int n = a.get(i) + a.get(j);
            if(n < k)
                i++;
            else if(n > k)
                j--;
            else if(n == k)
                return true;
        }
        return false;
    }
    public void bfs(TreeNode root, List<Integer> a){
        if(root == null)
            return;
        bfs(root.left, a);
        a.add(root.val);
        bfs(root.right, a);
    }
}