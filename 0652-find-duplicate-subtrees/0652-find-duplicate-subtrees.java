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
    Map<String,TreeNode> result = new HashMap<>();
     Set<String> hashSet = new HashSet<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
       helper(root);
        return new ArrayList<TreeNode>(result.values());
    }
    
    
    public String helper(TreeNode root){
        
        if(root == null){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        
        String left  = helper(root.left);
        String right  = helper(root.right);
            sb.append("(");
            sb.append(left);
             sb.append(")");
        
             sb.append("(");
            sb.append(right);
             sb.append(")");
 
        
        String val = sb.toString();
        
        if(!hashSet.add(val) && !result.containsKey(val)){
            result.put(val,root);
        }
        
        return val;
    }
}