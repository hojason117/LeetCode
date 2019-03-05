/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        TreeNode pointer = root;
        while(pointer != null) {
            stack.push(pointer);
            pointer = pointer.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode result = stack.pop();
        
        TreeNode pointer = result.right;
        while(pointer != null) {
            stack.push(pointer);
            pointer = pointer.left;
        }
        
        return result.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
 