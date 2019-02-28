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
    
    private boolean validate(TreeNode target, Integer min, Integer max) {
        if(target == null)
            return true;
        
        if((min != null && target.val <= min) || (max != null && target.val >= max))
            return false;
        
        return validate(target.left, min, target.val) && validate(target.right, target.val, max);
    }
}
