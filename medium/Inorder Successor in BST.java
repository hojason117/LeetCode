/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// naive
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode pointer = root;
        while(pointer.val != p.val) {
            stack.push(pointer);
            pointer = (pointer.val > p.val) ? pointer.left : pointer.right;
        }
        
        if(pointer.right != null) {
            pointer = pointer.right;
            
            while(pointer.left != null)
                pointer = pointer.left;
            
            return pointer;
        }
        
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            
            if(temp.left == pointer)
                return temp;
            
            pointer = temp;
        }
        
        return null;
    }
}

// O(log n) time, O(1) space
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null, pointer = root;
        
        while(pointer != null) {
            if(pointer.val > p.val) {
                succ = pointer;
                pointer = pointer.left;
            }
            else
                pointer = pointer.right;
        }
        
        return succ;
    }
}
