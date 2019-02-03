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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(root, result);
        return result;
    }

    private int helper(TreeNode node, List<List<Integer>> result) {
        if(node == null)
            return 0;
        
        int level = Math.max(helper(node.left, result), helper(node.right, result));
        if(level >= result.size())
            result.add(new ArrayList<Integer>());
        result.get(level).add(node.val);

        return level + 1;
    }
}
