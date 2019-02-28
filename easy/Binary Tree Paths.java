/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {        
        List<String> result = new ArrayList<String>();
        if(root == null)
            return result;
        helper(result, root, "");
        return result;
    }
    
    private void helper(List<String> result, TreeNode node, String path) {
        if(node.left == null && node.right == null)
            result.add(path + node.val);
        
        if(node.left != null)
            helper(result, node.left, path + node.val + "->");
        if(node.right != null)
            helper(result, node.right, path + node.val + "->");
    }
}
