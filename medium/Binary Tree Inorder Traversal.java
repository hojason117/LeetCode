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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode pointer = root;
        while(pointer != null) {
            stack.push(pointer);
            pointer = pointer.left;
        }
        
        while(!stack.isEmpty()) {
            pointer = stack.pop();
            result.add(pointer.val);
            pointer = pointer.right;
            while(pointer != null) {
                stack.push(pointer);
                pointer = pointer.left;
            }
        }
        
        return result;
    }
}
