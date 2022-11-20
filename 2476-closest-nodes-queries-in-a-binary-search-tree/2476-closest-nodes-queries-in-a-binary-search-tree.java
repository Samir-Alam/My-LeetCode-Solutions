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
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        TreeSet<Integer> set = new TreeSet<>();
        
        // perform any tree traversal 
        inOrder(root,set);
        
        // create a result array
        List<List<Integer>> result = new ArrayList<>(queries.size());
        
        // go through each query
        for(int i=0;i<queries.size();i++){
            
            result.add(new ArrayList<>());
            int largest = -1;
            
            if(set.floor(queries.get(i))!=null){
                largest = set.floor(queries.get(i));
            }
            
            int smallest = -1;
            if(set.ceiling(queries.get(i))!=null){
                smallest = set.ceiling(queries.get(i));
            }
            
            result.get(result.size()-1).add(largest);
            result.get(result.size()-1).add(smallest);
        }
        return result;

    }

    private void inOrder(TreeNode root, TreeSet set){
        if(root==null){
            return;
        }
        inOrder(root.left, set);
        set.add(root.val);
        inOrder(root.right, set);
        return;
    }
    //     List<List<Integer>> ans = new ArrayList<>();
    //     helper(root);
    //     for (int num : queries) {
    //         Integer low = map.containsKey(num) ? Integer.valueOf(num) : map.lowerKey(num);
    //         Integer high = map.containsKey(num) ? Integer.valueOf(num) : map.higherKey(num);
    //         ans.add(Arrays.asList(low == null ? -1 : low, high == null ? -1 : high));
    //     }
    //     return ans;
    // }
    // void helper(TreeNode root) {
    //     if (root == null) return;
    //     map.put(root.val, 0);
    //     helper(root.left);
    //     helper(root.right);
    // }
}