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
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    
    private boolean validate(TreeNode root, Integer lower, Integer upper) {
        if (root == null)
            return true;
        
        if(root.left != null) {
            if(root.left.val >= root.val || (lower != null && root.left.val <= lower))
                return false;
        }
        if(root.right != null) {
            if(root.right.val <= root.val || (upper != null && root.right.val >= upper))
                return false;
        }
        
        if(root.left != null && !validate(root.left, lower, root.val))
            return false;
        if(root.right != null && !validate(root.right, root.val, upper))
            return false;
        
        return true;
    }
}