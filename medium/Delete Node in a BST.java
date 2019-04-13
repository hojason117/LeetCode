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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode target = root, pre = new TreeNode(0);
        pre.left = root;
        while(target != null && target.val != key) {
            pre = target;
            target = (target.val > key) ? target.left : target.right;
        }
        
        if(target == null)
            return root;
        
        TreeNode pointer = null;
        if(target.left == null)
            pointer = target.right;
        else if(target.right == null)
            pointer = target.left;
        else {
            if(target.left.right == null) {
                target.left.right = target.right;
                pointer = target.left;
            }
            else {
                TreeNode prePointer = target.left;
                pointer = target.left.right;
                while(pointer.right != null) {
                    prePointer = pointer;
                    pointer = pointer.right;
                }
                
                prePointer.right = pointer.left;
                pointer.left = target.left;
                pointer.right = target.right;
            }
        }
        
        if(pre.left == target)
            pre.left = pointer;
        else
            pre.right = pointer;
        
        return (target == root) ? pre.left : root;
    }
}
