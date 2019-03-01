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
    int result = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return result;
    }
    
    private int longestPath(TreeNode node) {
        if(node == null)
            return 0;
        
        int leftPath = longestPath(node.left);
        int rightPath = longestPath(node.right);
        
        result = Integer.max(leftPath + rightPath, result);
        
        return Integer.max(leftPath, rightPath) + 1;
    }
}
