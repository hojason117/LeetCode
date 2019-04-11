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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean reverse = false;
        
        if(root == null)
            return result;
        
        queue.offer(root);
        int levelSize = 1;
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            
            int nextLevelSize = 0;
            for(int i = 0; i < levelSize; i++) {
                TreeNode temp = queue.poll();
                
                if(temp.left != null)
                    queue.offer(temp.left);
                if(temp.right != null)
                    queue.offer(temp.right);
                
                if(reverse)
                    level.add(0, temp.val);
                else
                    level.add(temp.val);
            }
            
            result.add(level);
            reverse = !reverse;
            levelSize = queue.size();
        }
        
        return result;
    }
}
