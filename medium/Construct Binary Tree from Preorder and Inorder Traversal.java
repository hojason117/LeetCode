/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// w/ array copy
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 && inorder.length == 0)
            return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        
        int inorderRootIndex = 0;
        while(inorder[inorderRootIndex] != root.val)
            inorderRootIndex++;
        
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, inorderRootIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, inorderRootIndex + 1, inorder.length);
        
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, leftInorder.length + 1), leftInorder);
        root.right = buildTree(Arrays.copyOfRange(preorder, leftInorder.length + 1, preorder.length), rightInorder);
        
        return root;
    }
}

// w/o array copy
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preEnd == preStart)
            return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int inorderRootIndex = inStart;
        while(inorder[inorderRootIndex] != root.val)
            inorderRootIndex++;
        
        root.left = helper(preorder, inorder, preStart + 1, preStart + 1 + inorderRootIndex - inStart, inStart, inorderRootIndex);
        root.right = helper(preorder, inorder, preStart + 1 + inorderRootIndex - inStart, preEnd, inorderRootIndex + 1, inEnd);
        
        return root;
    }
}
