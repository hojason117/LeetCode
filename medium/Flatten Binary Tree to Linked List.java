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
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode node) {
        if(node == null)
            return null;
        if(node.left == null && node.right == null)
            return node;
        
        TreeNode leftLeaf = helper(node.left);
        TreeNode rightLeaf = helper(node.right);
        
        if(leftLeaf != null) {
            leftLeaf.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        return (rightLeaf != null) ? rightLeaf : leftLeaf;
    }
}
